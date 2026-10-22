package android.ss.com.vboost;

/* JADX INFO: loaded from: classes2.dex */
public final enum CpuCoreLevel extends Enum<CpuCoreLevel> {
    private static final /* synthetic */ CpuCoreLevel[] $VALUES = null;
    public static final CpuCoreLevel LEVEL_0 = null;
    public static final CpuCoreLevel LEVEL_1 = null;
    private int index;
    private String name;

    static {
        CpuCoreLevel r100 = new CpuCoreLevel("LEVEL_0", 0, "level_0", 0);
        LEVEL_0 = r100;
        CpuCoreLevel r101 = new CpuCoreLevel("LEVEL_1", 1, "level_1", 1);
        LEVEL_1 = r101;
        $VALUES = new CpuCoreLevel[]{r100, r101};
    }

    private CpuCoreLevel(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.name = r102;
        this.index = r103;
    }

    public static CpuCoreLevel valueOf(String r100) {
        return (CpuCoreLevel) r27.a.a(CpuCoreLevel.class, r100);
    }

    public static CpuCoreLevel[] values() {
        return (CpuCoreLevel[]) $VALUES.clone();
    }
}
