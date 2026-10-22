package com.obric.cae.libs.location.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AoiBoard implements Parcelable {
    public static final Parcelable.Creator<AoiBoard> CREATOR = null;
    private String aoiBoard;
    private Confidence confidence;
    private ConfidenceSource confidenceSource;
    private State curState;
    private Event event;
    private long eventTime;
    private String geofenceId;
    private String poiId;
    private String poiName;
    private TransitionType transitionType;
    private Type type;

    public static final enum Confidence extends Enum<Confidence> {
        public static final Confidence HIGH = null;
        public static final Confidence LOW = null;
        public static final Confidence MAX = null;
        public static final Confidence MEDIUM = null;
        public static final Confidence MIN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Confidence[] f31735b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31736a;

        static {
            Confidence r0 = new Confidence(0, 0, "MIN");
            MIN = r0;
            Confidence r2 = new Confidence(1, 1, "LOW");
            LOW = r2;
            Confidence r4 = new Confidence(2, 2, "MEDIUM");
            MEDIUM = r4;
            Confidence r6 = new Confidence(3, 3, "HIGH");
            HIGH = r6;
            Confidence r8 = new Confidence(4, 4, "MAX");
            MAX = r8;
            f31735b = new Confidence[]{r0, r2, r4, r6, r8};
        }

        public Confidence(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31736a = r2;
        }

        public static Confidence valueOf(String r2) {
            return (Confidence) ZeusTransformUtils.preCheckCast(Enum.valueOf(Confidence.class, r2), Confidence.class, "com.obric.aiagent.plugin");
        }

        public static Confidence[] values() {
            return (Confidence[]) ZeusTransformUtils.preCheckCast(f31735b.clone(), Confidence[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31736a;
        }
    }

    public static final enum ConfidenceSource extends Enum<ConfidenceSource> {
        public static final ConfidenceSource DEFAULT = null;
        public static final ConfidenceSource DISTANCE = null;
        public static final ConfidenceSource RETRY = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ConfidenceSource[] f31737b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31738a;

        static {
            ConfidenceSource r0 = new ConfidenceSource(0, 0, "DEFAULT");
            DEFAULT = r0;
            ConfidenceSource r2 = new ConfidenceSource(1, 1, "DISTANCE");
            DISTANCE = r2;
            ConfidenceSource r4 = new ConfidenceSource(2, 2, "RETRY");
            RETRY = r4;
            f31737b = new ConfidenceSource[]{r0, r2, r4};
        }

        public ConfidenceSource(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31738a = r2;
        }

        public static ConfidenceSource valueOf(String r2) {
            return (ConfidenceSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConfidenceSource.class, r2), ConfidenceSource.class, "com.obric.aiagent.plugin");
        }

        public static ConfidenceSource[] values() {
            return (ConfidenceSource[]) ZeusTransformUtils.preCheckCast(f31737b.clone(), ConfidenceSource[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31738a;
        }
    }

    public static final enum Event extends Enum<Event> {
        public static final Event ENTER = null;
        public static final Event EXIT = null;
        public static final Event UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Event[] f31739b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31740a;

        static {
            Event r0 = new Event(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            Event r2 = new Event(1, 1, "ENTER");
            ENTER = r2;
            Event r4 = new Event(2, 2, "EXIT");
            EXIT = r4;
            f31739b = new Event[]{r0, r2, r4};
        }

        public Event(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31740a = r2;
        }

        public static Event valueOf(String r2) {
            return (Event) ZeusTransformUtils.preCheckCast(Enum.valueOf(Event.class, r2), Event.class, "com.obric.aiagent.plugin");
        }

        public static Event[] values() {
            return (Event[]) ZeusTransformUtils.preCheckCast(f31739b.clone(), Event[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31740a;
        }
    }

    public static final enum State extends Enum<State> {
        public static final State INSIDE = null;
        public static final State OUTSIDE = null;
        public static final State UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ State[] f31741b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31742a;

        static {
            State r0 = new State(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            State r2 = new State(1, 1, "INSIDE");
            INSIDE = r2;
            State r4 = new State(2, 2, "OUTSIDE");
            OUTSIDE = r4;
            f31741b = new State[]{r0, r2, r4};
        }

        public State(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31742a = r2;
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.aiagent.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast(f31741b.clone(), State[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31742a;
        }
    }

    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType ENTERED_AND_EXITED = null;
        public static final TransitionType ENTERED_ONLY = null;
        public static final TransitionType EXITED_ONLY = null;
        public static final TransitionType UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ TransitionType[] f31743b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31744a;

        static {
            TransitionType r0 = new TransitionType(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            TransitionType r2 = new TransitionType(1, 1, "ENTERED_ONLY");
            ENTERED_ONLY = r2;
            TransitionType r4 = new TransitionType(2, 2, "EXITED_ONLY");
            EXITED_ONLY = r4;
            TransitionType r6 = new TransitionType(3, 3, "ENTERED_AND_EXITED");
            ENTERED_AND_EXITED = r6;
            f31743b = new TransitionType[]{r0, r2, r4, r6};
        }

        public TransitionType(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31744a = r2;
        }

        public static TransitionType valueOf(String r2) {
            return (TransitionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TransitionType.class, r2), TransitionType.class, "com.obric.aiagent.plugin");
        }

        public static TransitionType[] values() {
            return (TransitionType[]) ZeusTransformUtils.preCheckCast(f31743b.clone(), TransitionType[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31744a;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AIRPORT = null;
        public static final Type MALL = null;
        public static final Type SUBWAY_STATION = null;
        public static final Type TRAIN_STATION = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Type[] f31745b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31746a;

        static {
            Type r0 = new Type(0, 0, "UNKNOWN");
            UNKNOWN = r0;
            Type r2 = new Type(1, 1, "AIRPORT");
            AIRPORT = r2;
            Type r4 = new Type(2, 2, "TRAIN_STATION");
            TRAIN_STATION = r4;
            Type r6 = new Type(3, 3, "SUBWAY_STATION");
            SUBWAY_STATION = r6;
            Type r8 = new Type(4, 4, "MALL");
            MALL = r8;
            f31745b = new Type[]{r0, r2, r4, r6, r8};
        }

        public Type(int r1, int r2, String r3) {
            super(r3, r1);
            this.f31746a = r2;
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.aiagent.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast(f31745b.clone(), Type[].class, "com.obric.aiagent.plugin");
        }

        public int getValue() {
            return this.f31746a;
        }
    }

    public class a implements Parcelable.Creator<AoiBoard> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard createFromParcel(Parcel r1) {
            return new AoiBoard(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final AoiBoard[] newArray(int r1) {
            return new AoiBoard[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AoiBoard(Parcel r3) {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
        readFromParcel(r3);
    }

    public void applyEvent(Event r2) {
        if (r2 != Event.ENTER) goto L6;
        this.curState = State.INSIDE;
    L9:
        setEvent(r2);
        return;
    L6:
        if (r2 != Event.EXIT) goto L8;
        this.curState = State.OUTSIDE;
        goto L9
    L8:
        this.curState = State.UNKNOWN;
        goto L9
    }

    public void applyState(State r5) {
        if (r5 != null) goto L5;
        r5 = State.UNKNOWN;
    L5:
        if (this.curState == r5) goto L7;
        boolean r0 = true;
    L8:
        this.curState = r5;
        if (r0 == false) goto L11;
    L14:
        this.eventTime = System.currentTimeMillis();
        return;
    L11:
        if (r5 != State.UNKNOWN) goto L13;
        return;
    L13:
        if (this.eventTime <= 0) goto L14;
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAoiBoard() {
        return this.aoiBoard;
    }

    public Confidence getConfidence() {
        return this.confidence;
    }

    public ConfidenceSource getConfidenceSource() {
        return this.confidenceSource;
    }

    public State getCurState() {
        return this.curState;
    }

    public Event getEvent() {
        return this.event;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getGeofenceId() {
        return this.geofenceId;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public TransitionType getTransitionType() {
        return this.transitionType;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isBoundTo(StarGeofence r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.geofenceId.isEmpty() == true) goto L10;
        return this.geofenceId.equals(r3.getGeofenceId());
    L10:
        if (this.poiId.isEmpty() == false) goto L12;
        return false;
    L12:
        if (this.poiId.equals(r3.getPoiId()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean isSecondLayerEnabledBy(StarGeofence r1) {
        if (isBoundTo(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getGeoState() != StarGeofence.GeoState.INSIDE) goto L7;
        return true;
    }

    public void readFromParcel(Parcel r3) {
        this.poiId = r3.readString();
        this.poiName = r3.readString();
        this.aoiBoard = r3.readString();
        this.curState = State.values()[r3.readInt()];
        this.transitionType = TransitionType.values()[r3.readInt()];
        this.confidence = Confidence.values()[r3.readInt()];
        this.confidenceSource = ConfidenceSource.values()[r3.readInt()];
        this.event = Event.values()[r3.readInt()];
        this.type = Type.values()[r3.readInt()];
        this.geofenceId = r3.readString();
        this.eventTime = r3.readLong();
    }

    public void setAoiBoard(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.aoiBoard = r1;
    }

    public void setConfidence(Confidence r1) {
        if (r1 != null) goto L4;
        r1 = Confidence.MIN;
    L4:
        this.confidence = r1;
    }

    public void setConfidenceSource(ConfidenceSource r1) {
        if (r1 != null) goto L4;
        r1 = ConfidenceSource.DEFAULT;
    L4:
        this.confidenceSource = r1;
    }

    public void setCurState(State r1) {
        if (r1 != null) goto L4;
        r1 = State.UNKNOWN;
    L4:
        this.curState = r1;
    }

    public void setEvent(Event r3) {
        if (r3 != null) goto L4;
        r3 = Event.UNKNOWN;
    L4:
        this.event = r3;
        if (r3 == Event.UNKNOWN) goto L8;
        this.eventTime = System.currentTimeMillis();
        return;
    }

    public void setEventTime(long r3) {
        this.eventTime = Math.max(0, r3);
    }

    public void setGeofenceId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.geofenceId = r1;
    }

    public void setPoiId(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.poiId = r1;
    }

    public void setPoiName(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.poiName = r1;
    }

    public void setTransitionType(TransitionType r1) {
        if (r1 != null) goto L4;
        r1 = TransitionType.UNKNOWN;
    L4:
        this.transitionType = r1;
    }

    public void setType(Type r1) {
        if (r1 != null) goto L4;
        r1 = Type.UNKNOWN;
    L4:
        this.type = r1;
    }

    public String toString() {
        return "[AoiBoard: poiId=" + this.poiId + ", name=" + this.poiName + ", curState=" + this.curState + ", transitionType=" + this.transitionType + ", confidence=" + this.confidence + ", confidenceSource=" + this.confidenceSource + ", type=" + this.type + ", geofenceId=" + this.geofenceId + ", eventTime=" + this.eventTime + ", aoiBoard=(" + this.aoiBoard + ")]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.poiId);
        r3.writeString(this.poiName);
        r3.writeString(this.aoiBoard);
        r3.writeInt(this.curState.ordinal());
        r3.writeInt(this.transitionType.ordinal());
        r3.writeInt(this.confidence.ordinal());
        r3.writeInt(this.confidenceSource.ordinal());
        r3.writeInt(this.event.ordinal());
        r3.writeInt(this.type.ordinal());
        r3.writeString(this.geofenceId);
        r3.writeLong(this.eventTime);
    }

    public AoiBoard() {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
    }

    public AoiBoard(String r3, String r4, String r5) {
        this.poiId = "";
        this.poiName = "";
        this.aoiBoard = "";
        this.curState = State.UNKNOWN;
        this.transitionType = TransitionType.ENTERED_AND_EXITED;
        this.confidence = Confidence.MIN;
        this.confidenceSource = ConfidenceSource.DEFAULT;
        this.event = Event.UNKNOWN;
        this.type = Type.UNKNOWN;
        this.geofenceId = "";
        this.eventTime = 0;
        setPoiId(r3);
        setPoiName(r4);
        setAoiBoard(r5);
    }
}
