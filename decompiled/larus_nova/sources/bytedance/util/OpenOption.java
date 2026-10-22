package bytedance.util;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;

/* JADX INFO: loaded from: classes28.dex */
final enum OpenOption extends Enum<OpenOption> {
    public static final OpenOption APPEND = null;
    public static final OpenOption CREATE = null;
    public static final OpenOption CREATE_NEW = null;
    public static final OpenOption DELETE_ON_CLOSE = null;
    public static final OpenOption DSYNC = null;
    public static final OpenOption READ = null;
    public static final OpenOption SPARSE = null;
    public static final OpenOption SYNC = null;
    public static final OpenOption TRUNCATE_EXISTING = null;
    public static final OpenOption WRITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenOption[] f21734a = null;

    static {
        OpenOption r100 = new OpenOption("READ", 0);
        READ = r100;
        OpenOption r101 = new OpenOption("WRITE", 1);
        WRITE = r101;
        OpenOption r102 = new OpenOption("APPEND", 2);
        APPEND = r102;
        OpenOption r103 = new OpenOption("TRUNCATE_EXISTING", 3);
        TRUNCATE_EXISTING = r103;
        OpenOption r104 = new OpenOption("CREATE", 4);
        CREATE = r104;
        OpenOption r105 = new OpenOption("CREATE_NEW", 5);
        CREATE_NEW = r105;
        OpenOption r110 = new OpenOption("DELETE_ON_CLOSE", 6);
        DELETE_ON_CLOSE = r110;
        OpenOption r111 = new OpenOption("SPARSE", 7);
        SPARSE = r111;
        OpenOption r112 = new OpenOption(BridgeSyncType.SYNC, 8);
        SYNC = r112;
        OpenOption r113 = new OpenOption("DSYNC", 9);
        DSYNC = r113;
        f21734a = new OpenOption[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static OpenOption[] values() {
        return (OpenOption[]) f21734a.clone();
    }

    public static OpenOption valueOf(String r100) {
        return (OpenOption) r27.a.a(OpenOption.class, r100);
    }

    public OpenOption(String r100, int r101) {
        super(r100, r101);
    }
}
