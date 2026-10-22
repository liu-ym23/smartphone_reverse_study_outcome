package com.bytedance.framwork.core.monitor;

/* JADX INFO: loaded from: classes.dex */
public final enum MonitorNetUtil$NetworkType extends Enum<MonitorNetUtil$NetworkType> {
    private static final /* synthetic */ MonitorNetUtil$NetworkType[] $VALUES = null;
    public static final MonitorNetUtil$NetworkType MOBILE = null;
    public static final MonitorNetUtil$NetworkType MOBILE_2G = null;
    public static final MonitorNetUtil$NetworkType MOBILE_3G = null;
    public static final MonitorNetUtil$NetworkType MOBILE_4G = null;
    public static final MonitorNetUtil$NetworkType NONE = null;
    public static final MonitorNetUtil$NetworkType WIFI = null;
    final int nativeInt;

    static {
        MonitorNetUtil$NetworkType r10 = new MonitorNetUtil$NetworkType("NONE", 0, 0);
        NONE = r10;
        MonitorNetUtil$NetworkType r11 = new MonitorNetUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r11;
        MonitorNetUtil$NetworkType r12 = new MonitorNetUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r12;
        MonitorNetUtil$NetworkType r13 = new MonitorNetUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r13;
        MonitorNetUtil$NetworkType r14 = new MonitorNetUtil$NetworkType("WIFI", 4, 4);
        WIFI = r14;
        MonitorNetUtil$NetworkType r15 = new MonitorNetUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r15;
        $VALUES = new MonitorNetUtil$NetworkType[]{r10, r11, r12, r13, r14, r15};
    }

    private MonitorNetUtil$NetworkType(String r10, int r11, int r12) {
        super(r10, r11);
        this.nativeInt = r12;
    }

    public static MonitorNetUtil$NetworkType valueOf(String r10) {
        return (MonitorNetUtil$NetworkType) Enum.valueOf(MonitorNetUtil$NetworkType.class, r10);
    }

    public static MonitorNetUtil$NetworkType[] values() {
        return (MonitorNetUtil$NetworkType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }
}
