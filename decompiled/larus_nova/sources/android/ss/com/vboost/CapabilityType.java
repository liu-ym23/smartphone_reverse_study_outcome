package android.ss.com.vboost;

/* JADX INFO: loaded from: classes2.dex */
public final enum CapabilityType extends Enum<CapabilityType> {
    private static final /* synthetic */ CapabilityType[] $VALUES = null;
    public static final CapabilityType BUS_FREQ_MAX = null;
    public static final CapabilityType BUS_FREQ_MIN = null;
    public static final CapabilityType CPU_AFFINITY = null;
    public static final CapabilityType CPU_CORE_MAX = null;
    public static final CapabilityType CPU_CORE_MIN = null;
    public static final CapabilityType CPU_FREQ_MAX = null;
    public static final CapabilityType CPU_FREQ_MIN = null;
    public static final CapabilityType GPU_FREQ_MAX = null;
    public static final CapabilityType GPU_FREQ_MIN = null;
    public static final CapabilityType IDLE_STATE = null;
    public static final CapabilityType IO_PRELOAD = null;
    public static final CapabilityType NETWORK_ENHANCE = null;
    public static final CapabilityType PRESET_SCENE = null;
    public static final CapabilityType TASK_PRIORITY = null;
    public static final CapabilityType THUMB_FETCH = null;
    public static final CapabilityType TYPE_MAX = null;
    public static final CapabilityType TYPE_MIN = null;
    public static final CapabilityType UFS_FREQ_MAX = null;
    public static final CapabilityType UFS_FREQ_MIN = null;
    public static final CapabilityType VIBRATE_ENHANCE = null;
    private int index;
    private String name;

    static {
        CapabilityType r100 = new CapabilityType("CPU_FREQ_MIN", 0, "cpu_freq_min", 1);
        CPU_FREQ_MIN = r100;
        CapabilityType r101 = new CapabilityType("CPU_FREQ_MAX", 1, "cpu_freq_max", 2);
        CPU_FREQ_MAX = r101;
        CapabilityType r102 = new CapabilityType("CPU_CORE_MIN", 2, "cpu_core_min", 3);
        CPU_CORE_MIN = r102;
        CapabilityType r103 = new CapabilityType("CPU_CORE_MAX", 3, "cpu_core_max", 4);
        CPU_CORE_MAX = r103;
        CapabilityType r104 = new CapabilityType("GPU_FREQ_MIN", 4, "gpu_freq_min", 5);
        GPU_FREQ_MIN = r104;
        CapabilityType r105 = new CapabilityType("GPU_FREQ_MAX", 5, "gpu_freq_max", 6);
        GPU_FREQ_MAX = r105;
        CapabilityType r110 = new CapabilityType("BUS_FREQ_MIN", 6, "bus_freq_min", 7);
        BUS_FREQ_MIN = r110;
        CapabilityType r111 = new CapabilityType("BUS_FREQ_MAX", 7, "bus_freq_max", 8);
        BUS_FREQ_MAX = r111;
        CapabilityType r112 = new CapabilityType("UFS_FREQ_MIN", 8, "ufs_freq_min", 9);
        UFS_FREQ_MIN = r112;
        CapabilityType r113 = new CapabilityType("UFS_FREQ_MAX", 9, "ufs_freq_max", 10);
        UFS_FREQ_MAX = r113;
        CapabilityType r114 = new CapabilityType("TASK_PRIORITY", 10, "task_priority", 11);
        TASK_PRIORITY = r114;
        CapabilityType r106 = new CapabilityType("CPU_AFFINITY", 11, "cpu_affinity", 12);
        CPU_AFFINITY = r106;
        CapabilityType r107 = new CapabilityType("IDLE_STATE", 12, "idle_state", 13);
        IDLE_STATE = r107;
        CapabilityType r108 = new CapabilityType("IO_PRELOAD", 13, "io_preload", 14);
        IO_PRELOAD = r108;
        CapabilityType r109 = new CapabilityType("NETWORK_ENHANCE", 14, "network_enhance", 15);
        NETWORK_ENHANCE = r109;
        CapabilityType r115 = new CapabilityType("PRESET_SCENE", 15, "preset_scene", 16);
        PRESET_SCENE = r115;
        CapabilityType r116 = new CapabilityType("THUMB_FETCH", 16, "thumb_fetch", 17);
        THUMB_FETCH = r116;
        CapabilityType r117 = new CapabilityType("VIBRATE_ENHANCE", 17, "vibrate_enhance", 18);
        VIBRATE_ENHANCE = r117;
        CapabilityType r118 = new CapabilityType("TYPE_MIN", 18, r100);
        TYPE_MIN = r118;
        CapabilityType r119 = new CapabilityType("TYPE_MAX", 19, r117);
        TYPE_MAX = r119;
        $VALUES = new CapabilityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119};
    }

    private CapabilityType(String r100, int r101, CapabilityType r102) {
        super(r100, r101);
        this.name = r102.name;
        this.index = r102.index;
    }

    private CapabilityType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.name = r102;
        this.index = r103;
    }

    public static CapabilityType valueOf(int r100) {
        CapabilityType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        CapabilityType r104 = r101[r103];
        if (r100 == r104.index) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        throw new RuntimeException("Can't find enum type for index: " + r100);
    }

    public static CapabilityType valueOf(String r100) {
        return (CapabilityType) r27.a.a(CapabilityType.class, r100);
    }

    public static CapabilityType[] values() {
        return (CapabilityType[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
}
