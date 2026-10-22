package com.obric.cae.libs.location.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoConfidence[] f31725b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31726a;

        static {
            GeoConfidence r0 = new GeoConfidence(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            GeoConfidence r2 = new GeoConfidence(1, 1, "LOW");
            LOW = r2;
            GeoConfidence r4 = new GeoConfidence(2, 2, "MEDIUM");
            MEDIUM = r4;
            GeoConfidence r6 = new GeoConfidence(3, 3, "HIGH");
            HIGH = r6;
            f31725b = new GeoConfidence[]{r0, r2, r4, r6};
        }

        public GeoConfidence(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31726a = r2;
        }

        public static GeoConfidence valueOf(String r2) {
            return (GeoConfidence) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoConfidence.class, r2), GeoConfidence.class, "com.obric.aiagent.plugin");
        }

        public static GeoConfidence[] values() {
            return (GeoConfidence[]) ZeusTransformUtils.preCheckCast(f31725b.clone(), GeoConfidence[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31726a;
        }
    }

    public static final enum GeoEvent extends Enum<GeoEvent> {
        public static final GeoEvent ENTER = null;
        public static final GeoEvent EXIT = null;
        public static final GeoEvent UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoEvent[] f31727b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31728a;

        static {
            GeoEvent r0 = new GeoEvent(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            GeoEvent r2 = new GeoEvent(1, 1, "ENTER");
            ENTER = r2;
            GeoEvent r4 = new GeoEvent(2, 2, "EXIT");
            EXIT = r4;
            f31727b = new GeoEvent[]{r0, r2, r4};
        }

        public GeoEvent(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31728a = r2;
        }

        public static GeoEvent valueOf(String r2) {
            return (GeoEvent) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoEvent.class, r2), GeoEvent.class, "com.obric.aiagent.plugin");
        }

        public static GeoEvent[] values() {
            return (GeoEvent[]) ZeusTransformUtils.preCheckCast(f31727b.clone(), GeoEvent[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31728a;
        }
    }

    public static final enum GeoState extends Enum<GeoState> {
        public static final GeoState INSIDE = null;
        public static final GeoState OUTSIDE = null;
        public static final GeoState UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoState[] f31729b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31730a;

        static {
            GeoState r0 = new GeoState(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            GeoState r2 = new GeoState(1, 1, "INSIDE");
            INSIDE = r2;
            GeoState r4 = new GeoState(2, 2, "OUTSIDE");
            OUTSIDE = r4;
            f31729b = new GeoState[]{r0, r2, r4};
        }

        public GeoState(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31730a = r2;
        }

        public static GeoState valueOf(String r2) {
            return (GeoState) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoState.class, r2), GeoState.class, "com.obric.aiagent.plugin");
        }

        public static GeoState[] values() {
            return (GeoState[]) ZeusTransformUtils.preCheckCast(f31729b.clone(), GeoState[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31730a;
        }
    }

    public static final enum GeoTransitionType extends Enum<GeoTransitionType> {
        public static final GeoTransitionType ENTERED_AND_EXITED = null;
        public static final GeoTransitionType ENTERED_ONLY = null;
        public static final GeoTransitionType EXITED_ONLY = null;
        public static final GeoTransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoTransitionType[] f31731b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31732a;

        static {
            GeoTransitionType r0 = new GeoTransitionType(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            GeoTransitionType r2 = new GeoTransitionType(1, 1, "ENTERED_ONLY");
            ENTERED_ONLY = r2;
            GeoTransitionType r4 = new GeoTransitionType(2, 2, "EXITED_ONLY");
            EXITED_ONLY = r4;
            GeoTransitionType r6 = new GeoTransitionType(3, 3, "ENTERED_AND_EXITED");
            ENTERED_AND_EXITED = r6;
            f31731b = new GeoTransitionType[]{r0, r2, r4, r6};
        }

        public GeoTransitionType(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31732a = r2;
        }

        public static GeoTransitionType valueOf(String r2) {
            return (GeoTransitionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoTransitionType.class, r2), GeoTransitionType.class, "com.obric.aiagent.plugin");
        }

        public static GeoTransitionType[] values() {
            return (GeoTransitionType[]) ZeusTransformUtils.preCheckCast(f31731b.clone(), GeoTransitionType[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31732a;
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

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GeoType[] f31733b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31734a;

        static {
            GeoType r0 = new GeoType(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            GeoType r2 = new GeoType(1, 1, "HOME");
            HOME = r2;
            GeoType r4 = new GeoType(2, 2, "COMPANY");
            COMPANY = r4;
            GeoType r6 = new GeoType(3, 3, "TRAFFIC");
            TRAFFIC = r6;
            GeoType r8 = new GeoType(4, 4, "MALL");
            MALL = r8;
            GeoType r10 = new GeoType(5, 5, "INDOOR");
            INDOOR = r10;
            GeoType r12 = new GeoType(6, 6, "OUTDOOR");
            OUTDOOR = r12;
            f31733b = new GeoType[]{r0, r2, r4, r6, r8, r10, r12};
        }

        public GeoType(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31734a = r2;
        }

        public static GeoType valueOf(String r2) {
            return (GeoType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoType.class, r2), GeoType.class, "com.obric.aiagent.plugin");
        }

        public static GeoType[] values() {
            return (GeoType[]) ZeusTransformUtils.preCheckCast(f31733b.clone(), GeoType[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31734a;
        }
    }

    public class a implements Parcelable.Creator<StarGeofence> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final StarGeofence createFromParcel(Parcel r1) {
            return new StarGeofence(r1);
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

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, StarGeofence.class) == false) goto L14;
        StarGeofence r7 = (StarGeofence) ZeusTransformUtils.preCheckCast(r6, StarGeofence.class, "com.obric.aiagent.plugin");
        if (this.latitude != r7.getLatitude()) goto L11;
        if (this.longitude != r7.getLongitude()) goto L11;
        if (this.radius != r7.getRadius()) goto L11;
    L12:
        return true;
    L11:
        if (this.geofenceId.equalsIgnoreCase(r7.getGeofenceId()) == true) goto L12;
        return false;
    L14:
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

    public boolean isBoundTo(AoiBoard r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (this.poiId.isEmpty() == true) goto L8;
        if (this.poiId.equals(r2.getPoiId()) == false) goto L8;
        return true;
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

    public boolean shouldEnableAoiBoard(AoiBoard r1) {
        if (isBoundTo(r1) == true) goto L5;
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
