package com.bytedance.apm6.util.timetask;

/* JADX INFO: loaded from: classes.dex */
public final enum AsyncTaskManagerType extends Enum<AsyncTaskManagerType> {
    private static final /* synthetic */ AsyncTaskManagerType[] $VALUES = null;
    public static final AsyncTaskManagerType CPU = null;
    public static final AsyncTaskManagerType IO = null;
    public static final AsyncTaskManagerType LIGHT_WEIGHT = null;
    public static final AsyncTaskManagerType TIME_SENSITIVE = null;

    static {
        AsyncTaskManagerType r10 = new AsyncTaskManagerType("IO", 0);
        IO = r10;
        AsyncTaskManagerType r11 = new AsyncTaskManagerType("LIGHT_WEIGHT", 1);
        LIGHT_WEIGHT = r11;
        AsyncTaskManagerType r12 = new AsyncTaskManagerType("TIME_SENSITIVE", 2);
        TIME_SENSITIVE = r12;
        AsyncTaskManagerType r13 = new AsyncTaskManagerType("CPU", 3);
        CPU = r13;
        $VALUES = new AsyncTaskManagerType[]{r10, r11, r12, r13};
    }

    private AsyncTaskManagerType(String r10, int r11) {
        super(r10, r11);
    }

    public static AsyncTaskManagerType valueOf(String r10) {
        return (AsyncTaskManagerType) Enum.valueOf(AsyncTaskManagerType.class, r10);
    }

    public static AsyncTaskManagerType[] values() {
        return (AsyncTaskManagerType[]) $VALUES.clone();
    }
}
