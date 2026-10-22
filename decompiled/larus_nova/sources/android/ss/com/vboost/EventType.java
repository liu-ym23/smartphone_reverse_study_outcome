package android.ss.com.vboost;

/* JADX INFO: loaded from: classes2.dex */
public final enum EventType extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES = null;
    public static final EventType EVENT_NET = null;
    public static final EventType EVENT_TEMP = null;
    private int index;
    private String name;

    static {
        EventType r100 = new EventType("EVENT_TEMP", 0, "event_temp", 0);
        EVENT_TEMP = r100;
        EventType r101 = new EventType("EVENT_NET", 1, "event_net", 1);
        EVENT_NET = r101;
        $VALUES = new EventType[]{r100, r101};
    }

    private EventType(String r100, int r101, EventType r102) {
        super(r100, r101);
        this.name = r102.name;
        this.index = r102.index;
    }

    private EventType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.name = r102;
        this.index = r103;
    }

    public static EventType valueOf(int r100) {
        EventType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        EventType r104 = r101[r103];
        if (r100 == r104.index) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new RuntimeException("Can't find enum type for index: " + r100);
    }

    public static EventType valueOf(String r100) {
        return (EventType) r27.a.a(EventType.class, r100);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
}
