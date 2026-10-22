package com.obric.cae.libs.location.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.server.utils.PriorityDump;
import com.obric.cae.libs.location.poi.AoiBoard;

/* JADX INFO: loaded from: classes3.dex */
public class StarGeofence implements Parcelable {
    public static final Parcelable.Creator<StarGeofence> CREATOR = null;
    public static final String KEY_CURRENT_LOCATION = "current-location";
    public static final String KEY_GEOFENCE_EVENT = "geofence-event";
    public static final String KEY_GEOFENCE_ID = "geofence-id";
    private String address;
    private GeoConfidence confidence;
    private long eventTimestamp;
    private boolean firstBreach;
    private GeoState geoState;
    private GeoType geoType;
    private String geofenceId;
    private double latitude;
    private double longitude;
    private String packageName;
    private String poiId;
    private int radius;
    private GeoTransitionType transitionType;

    public static final enum GeoConfidence extends Enum<GeoConfidence> {
        public static final GeoConfidence HIGH = null;
        public static final GeoConfidence LOW = null;
        public static final GeoConfidence MEDIUM = null;
        public static final GeoConfidence UNKNOWN = null;
        public static final /* synthetic */ GeoConfidence[] b = null;
        public final int a;

        static {
            GeoConfidence r0 = new GeoConfidence("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoConfidence r1 = new GeoConfidence("LOW", 1, 1);
            LOW = r1;
            GeoConfidence r2 = new GeoConfidence("MEDIUM", 2, 2);
            MEDIUM = r2;
            GeoConfidence r3 = new GeoConfidence(PriorityDump.PRIORITY_ARG_HIGH, 3, 3);
            HIGH = r3;
            b = new GeoConfidence[]{r0, r1, r2, r3};
        }

        public GeoConfidence(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static GeoConfidence valueOf(String r1) {
            return (GeoConfidence) Enum.valueOf(GeoConfidence.class, r1);
        }

        public static GeoConfidence[] values() {
            return (GeoConfidence[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum GeoEvent extends Enum<GeoEvent> {
        public static final GeoEvent ENTER = null;
        public static final GeoEvent EXIT = null;
        public static final GeoEvent UNKNOWN = null;
        public static final /* synthetic */ GeoEvent[] b = null;
        public final int a;

        static {
            GeoEvent r0 = new GeoEvent("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoEvent r1 = new GeoEvent("ENTER", 1, 1);
            ENTER = r1;
            GeoEvent r2 = new GeoEvent("EXIT", 2, 2);
            EXIT = r2;
            b = new GeoEvent[]{r0, r1, r2};
        }

        public GeoEvent(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static GeoEvent valueOf(String r1) {
            return (GeoEvent) Enum.valueOf(GeoEvent.class, r1);
        }

        public static GeoEvent[] values() {
            return (GeoEvent[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum GeoState extends Enum<GeoState> {
        public static final GeoState INSIDE = null;
        public static final GeoState OUTSIDE = null;
        public static final GeoState UNKNOWN = null;
        public static final /* synthetic */ GeoState[] b = null;
        public final int a;

        static {
            GeoState r0 = new GeoState("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoState r1 = new GeoState("INSIDE", 1, 1);
            INSIDE = r1;
            GeoState r2 = new GeoState("OUTSIDE", 2, 2);
            OUTSIDE = r2;
            b = new GeoState[]{r0, r1, r2};
        }

        public GeoState(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static GeoState valueOf(String r1) {
            return (GeoState) Enum.valueOf(GeoState.class, r1);
        }

        public static GeoState[] values() {
            return (GeoState[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum GeoTransitionType extends Enum<GeoTransitionType> {
        public static final GeoTransitionType ENTERED_AND_EXITED = null;
        public static final GeoTransitionType ENTERED_ONLY = null;
        public static final GeoTransitionType EXITED_ONLY = null;
        public static final GeoTransitionType UNKNOWN = null;
        public static final /* synthetic */ GeoTransitionType[] b = null;
        public final int a;

        static {
            GeoTransitionType r0 = new GeoTransitionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoTransitionType r1 = new GeoTransitionType("ENTERED_ONLY", 1, 1);
            ENTERED_ONLY = r1;
            GeoTransitionType r2 = new GeoTransitionType("EXITED_ONLY", 2, 2);
            EXITED_ONLY = r2;
            GeoTransitionType r3 = new GeoTransitionType("ENTERED_AND_EXITED", 3, 3);
            ENTERED_AND_EXITED = r3;
            b = new GeoTransitionType[]{r0, r1, r2, r3};
        }

        public GeoTransitionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static GeoTransitionType valueOf(String r1) {
            return (GeoTransitionType) Enum.valueOf(GeoTransitionType.class, r1);
        }

        public static GeoTransitionType[] values() {
            return (GeoTransitionType[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public static final enum GeoType extends Enum<GeoType> {
        public static final GeoType COMPANY = null;
        public static final GeoType HOME = null;
        public static final GeoType INDOOR = null;
        public static final GeoType MALL = null;
        public static final GeoType OUTDOOR = null;
        public static final GeoType TRAFFIC = null;
        public static final GeoType UNKNOWN = null;
        public static final /* synthetic */ GeoType[] b = null;
        public final int a;

        static {
            GeoType r0 = new GeoType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GeoType r1 = new GeoType("HOME", 1, 1);
            HOME = r1;
            GeoType r2 = new GeoType("COMPANY", 2, 2);
            COMPANY = r2;
            GeoType r3 = new GeoType("TRAFFIC", 3, 3);
            TRAFFIC = r3;
            GeoType r4 = new GeoType("MALL", 4, 4);
            MALL = r4;
            GeoType r5 = new GeoType("INDOOR", 5, 5);
            INDOOR = r5;
            GeoType r6 = new GeoType("OUTDOOR", 6, 6);
            OUTDOOR = r6;
            b = new GeoType[]{r0, r1, r2, r3, r4, r5, r6};
        }

        public GeoType(String r1, int r2, int r3) {
            super(r1, r2);
            this.a = r3;
        }

        public static GeoType valueOf(String r1) {
            return (GeoType) Enum.valueOf(GeoType.class, r1);
        }

        public static GeoType[] values() {
            return (GeoType[]) b.clone();
        }

        public int getValue() {
            return this.a;
        }
    }

    public class a implements Parcelable.Creator<StarGeofence> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence createFromParcel(Parcel r2) {
            return new StarGeofence(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence[] newArray(int r1) {
            return new StarGeofence[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public StarGeofence(Parcel r3) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        readFromParcel(r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof StarGeofence) == false) goto L18;
        StarGeofence r8 = (StarGeofence) r7;
        if (Double.compare(this.latitude, r8.getLatitude()) == 0) goto L7;
        return false;
    L7:
        if (Double.compare(this.longitude, r8.getLongitude()) == 0) goto L9;
        return false;
    L9:
        if (this.radius == r8.getRadius()) goto L11;
        return false;
    L11:
        if (this.geofenceId.equals(r8.getGeofenceId()) == true) goto L13;
        return false;
    L13:
        if (this.transitionType == r8.getTransitionType()) goto L15;
        return false;
    L15:
        if (this.confidence != r8.getConfidence()) goto L25;
        return true;
    L25:
        return false;
    L18:
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public GeoConfidence getConfidence() {
        return this.confidence;
    }

    public long getEventTimestamp() {
        return this.eventTimestamp;
    }

    public GeoState getGeoState() {
        return this.geoState;
    }

    public GeoType getGeoType() {
        return this.geoType;
    }

    public String getGeofenceId() {
        return this.geofenceId;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public int getRadius() {
        return this.radius;
    }

    public GeoTransitionType getTransitionType() {
        return this.transitionType;
    }

    public boolean isBoundTo(AoiBoard r7) {
        if (r7 == null) goto L30;
        String r1 = this.poiId;
        String r8 = r7.getPoiId();
        if (r1 != null) goto L7;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L25;
        return false;
    L25:
        return true;
    L7:
        if (r1.isEmpty() == true) goto L21;
        if (r8 == null) goto L21;
        if (r8.isEmpty() == true) goto L21;
        String[] r2 = r1.split(";");
        int r3 = r2.length;
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L21;
        String r5 = r2[r4];
        if (r5 == null) goto L20;
        if (r8.equals(r5.trim()) == false) goto L20;
        r9 = true;
    L20:
        r4 = r4 + 1;
        goto L14
    L30:
        return false;
    }

    public boolean isFirstBreach() {
        return this.firstBreach;
    }

    public void readFromParcel(Parcel r3) {
        this.packageName = r3.readString();
        this.geofenceId = r3.readString();
        this.latitude = r3.readDouble();
        this.longitude = r3.readDouble();
        this.radius = r3.readInt();
        this.address = r3.readString();
        this.eventTimestamp = r3.readLong();
        this.transitionType = GeoTransitionType.values()[r3.readInt()];
        this.confidence = GeoConfidence.values()[r3.readInt()];
        this.geoState = GeoState.values()[r3.readInt()];
        this.geoType = GeoType.values()[r3.readInt()];
        this.firstBreach = r3.readBoolean();
        this.poiId = r3.readString();
    }

    public void setAddress(String r1) {
        this.address = r1;
    }

    public void setConfidence(GeoConfidence r1) {
        this.confidence = r1;
    }

    public void setEventTimestamp(long r1) {
        this.eventTimestamp = r1;
    }

    public void setFirstBreach(boolean r1) {
        this.firstBreach = r1;
    }

    public void setGeoState(GeoState r1) {
        this.geoState = r1;
    }

    public void setGeoType(GeoType r1) {
        this.geoType = r1;
    }

    public void setGeofenceId(String r1) {
        this.geofenceId = r1;
    }

    public void setLatitude(double r1) {
        this.latitude = r1;
    }

    public void setLongitude(double r1) {
        this.longitude = r1;
    }

    public void setPackageName(String r1) {
        this.packageName = r1;
    }

    public void setPoiId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.poiId = r1;
    }

    public void setRadius(int r1) {
        this.radius = r1;
    }

    public void setTransitionType(GeoTransitionType r1) {
        this.transitionType = r1;
    }

    public boolean shouldEnableAoiBoard(AoiBoard r2) {
        if (isBoundTo(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.geoState != GeoState.INSIDE) goto L7;
        return true;
    }

    public String toString() {
        return "[StarGeofence: " + this.geofenceId + ", from: " + this.packageName + ", (" + this.latitude + ", " + this.longitude + ", " + this.radius + "), address: " + this.address + ", eventTime: " + this.eventTimestamp + ", transitionType: " + this.transitionType + ", curState: " + this.geoState + ", geoType: " + this.geoType + ", firstBreach: " + this.firstBreach + ", poiId: " + this.poiId + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.packageName);
        r3.writeString(this.geofenceId);
        r3.writeDouble(this.latitude);
        r3.writeDouble(this.longitude);
        r3.writeInt(this.radius);
        r3.writeString(this.address);
        r3.writeLong(this.eventTimestamp);
        r3.writeInt(this.transitionType.ordinal());
        r3.writeInt(this.confidence.ordinal());
        r3.writeInt(this.geoState.ordinal());
        r3.writeInt(this.geoType.ordinal());
        r3.writeBoolean(this.firstBreach);
        r3.writeString(this.poiId);
    }

    public StarGeofence() {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
    }

    public StarGeofence(String r3, String r4, double r5, double r7, int r9, GeoTransitionType r10) {
        this.packageName = "";
        this.geofenceId = "";
        this.address = "";
        this.transitionType = GeoTransitionType.UNKNOWN;
        this.confidence = GeoConfidence.HIGH;
        this.geoState = GeoState.UNKNOWN;
        this.geoType = GeoType.UNKNOWN;
        this.firstBreach = true;
        this.poiId = "";
        this.packageName = r3;
        this.geofenceId = r4;
        this.latitude = r5;
        this.longitude = r7;
        this.radius = r9;
        this.transitionType = r10;
    }
}
