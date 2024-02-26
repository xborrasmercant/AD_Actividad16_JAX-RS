import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Booking {
    private String bookingID, clientID, agencyID, roomID, hotelID, clientName, agencyName, hotelName;
    private Double price;
    private int roomNights;
    private Date checkIn;
    public enum Type {
        NEW,
        UPDATE
    }

    public Booking(String bookingID, String clientID, String agencyID, Double price, String roomID, String hotelID, String clientName, String agencyName, String hotelName, Date checkIn, int roomNights) {
        this.bookingID = bookingID;
        this.clientID = clientID;
        this.agencyID = agencyID;
        this.price = price;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.clientName = clientName;
        this.agencyName = agencyName;
        this.hotelName = hotelName;
        this.checkIn = checkIn;
        this.roomNights = roomNights;
    }

    public Booking()  {
        // Null constructor
    }

    public void printBooking() {
        System.out.println();
        System.out.println("============= Booking " + bookingID + " ==============");
        System.out.println("Client (" + clientID + "): " + clientName);
        System.out.println("Agency (" + agencyID + "): " + agencyName);
        System.out.println("Price: " + price);
        System.out.println("Room: " + getRoomType(roomID));
        System.out.println("Hotel (" + hotelID + "): " + hotelName);
        System.out.println("Check-in: " + checkIn);
        System.out.println("Nights: " + roomNights);
        System.out.println();
    }


    public String getRoomType(String roomID) {
        return switch (roomID) {
            case "1" -> "Double";
            case "2" -> "Apartment";
            case "3" -> "Individual";
            case "4" -> "Suite";
            default -> "";
        };
    }

    public static Booking createNewBooking(Type btype) {
        Scanner in = new Scanner(System.in);
        String bookingID = "0";
        Date checkIn = null;

        if (btype == Type.NEW) {
            System.out.print("Booking ID: ");
             bookingID = in.nextLine();
        }

        System.out.print("Client ID: ");
        String clientID = in.nextLine();

        System.out.print("Agency ID: ");
        String agencyID = in.nextLine();

        double price = 0.0;
        while (price == 0.0) {
            System.out.print("Price: ");
            try {
                price = in.nextDouble();
                in.nextLine(); // Clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid price.");
                in.nextLine(); // Clear the invalid input
            }
        }

        System.out.print("Room ID: ");
        String roomID = in.nextLine();

        System.out.print("Hotel ID: ");
        String hotelID = in.nextLine();

        System.out.print("Client Name: ");
        String clientName = in.nextLine();

        System.out.print("Agency Name: ");
        String agencyName = in.nextLine();

        System.out.print("Hotel Name: ");
        String hotelName = in.nextLine();

        System.out.print("Check-In Date (DD/MM/YYYY): ");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String checkInString = in.nextLine();
        try {
            checkIn = (Date) dateFormat.parse(checkInString);
        } catch (Exception e) {
            System.out.println("[ERROR] Check in failed: " + e.getMessage());
        }

        int roomNights = 0;
        while (roomNights == 0) {
            System.out.print("Room Nights: ");
            try {
                roomNights = in.nextInt();
                in.nextLine(); // Clear buffer
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number of room nights.");
                in.nextLine(); // Clear the invalid input
            }
        }

        return new Booking(bookingID, clientID, agencyID, price, roomID, hotelID, clientName, agencyName, hotelName, checkIn, roomNights);    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRoomNights() {
        return roomNights;
    }

    public void setRoomNights(int roomNights) {
        this.roomNights = roomNights;
    }
}
