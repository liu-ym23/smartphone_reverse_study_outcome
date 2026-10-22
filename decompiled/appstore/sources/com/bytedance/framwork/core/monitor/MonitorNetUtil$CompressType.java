package com.bytedance.framwork.core.monitor;

/* JADX INFO: loaded from: classes.dex */
public final enum MonitorNetUtil$CompressType extends Enum<MonitorNetUtil$CompressType> {
    private static final /* synthetic */ MonitorNetUtil$CompressType[] $VALUES = null;
    public static final MonitorNetUtil$CompressType DEFLATER = null;
    public static final MonitorNetUtil$CompressType GZIP = null;
    public static final MonitorNetUtil$CompressType NONE = null;
    final int nativeInt;

    static {
        MonitorNetUtil$CompressType r10 = new MonitorNetUtil$CompressType("NONE", 0, 0);
        NONE = r10;
        MonitorNetUtil$CompressType r11 = new MonitorNetUtil$CompressType("GZIP", 1, 1);
        GZIP = r11;
        MonitorNetUtil$CompressType r12 = new MonitorNetUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r12;
        $VALUES = new MonitorNetUtil$CompressType[]{r10, r11, r12};
    }

    private MonitorNetUtil$CompressType(String r10, int r11, int r12) {
        super(r10, r11);
        this.nativeInt = r12;
    }

    public static MonitorNetUtil$CompressType valueOf(String r10) {
        return (MonitorNetUtil$CompressType) Enum.valueOf(MonitorNetUtil$CompressType.class, r10);
    }

    public static MonitorNetUtil$CompressType[] values() {
        return (MonitorNetUtil$CompressType[]) $VALUES.clone();
    }
}
