package androidx.work;

import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final enum NetworkType extends Enum<NetworkType> {
    private static final /* synthetic */ NetworkType[] $VALUES = null;
    public static final NetworkType CONNECTED = null;
    public static final NetworkType METERED = null;
    public static final NetworkType NOT_REQUIRED = null;
    public static final NetworkType NOT_ROAMING = null;
    public static final NetworkType TEMPORARILY_UNMETERED = null;
    public static final NetworkType UNMETERED = null;

    static {
        NetworkType r100 = new NetworkType("NOT_REQUIRED", 0);
        NOT_REQUIRED = r100;
        NetworkType r101 = new NetworkType("CONNECTED", 1);
        CONNECTED = r101;
        NetworkType r102 = new NetworkType("UNMETERED", 2);
        UNMETERED = r102;
        NetworkType r103 = new NetworkType("NOT_ROAMING", 3);
        NOT_ROAMING = r103;
        NetworkType r104 = new NetworkType("METERED", 4);
        METERED = r104;
        NetworkType r105 = new NetworkType("TEMPORARILY_UNMETERED", 5);
        TEMPORARILY_UNMETERED = r105;
        $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105};
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }

    public static NetworkType valueOf(String r100) {
        return (NetworkType) a.a(NetworkType.class, r100);
    }

    private NetworkType(String r100, int r101) {
        super(r100, r101);
    }
}
