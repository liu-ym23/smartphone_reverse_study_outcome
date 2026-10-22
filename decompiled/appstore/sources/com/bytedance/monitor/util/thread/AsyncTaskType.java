package com.bytedance.monitor.util.thread;

/* JADX INFO: loaded from: classes.dex */
public final enum AsyncTaskType extends Enum<AsyncTaskType> {
    private static final /* synthetic */ AsyncTaskType[] $VALUES = null;
    public static final AsyncTaskType IO = null;
    public static final AsyncTaskType LIGHT_WEIGHT = null;
    public static final AsyncTaskType TIME_SENSITIVE = null;

    static {
        AsyncTaskType r10 = new AsyncTaskType("IO", 0);
        IO = r10;
        AsyncTaskType r11 = new AsyncTaskType("TIME_SENSITIVE", 1);
        TIME_SENSITIVE = r11;
        AsyncTaskType r12 = new AsyncTaskType("LIGHT_WEIGHT", 2);
        LIGHT_WEIGHT = r12;
        $VALUES = new AsyncTaskType[]{r10, r11, r12};
    }

    private AsyncTaskType(String r10, int r11) {
        super(r10, r11);
    }

    public static AsyncTaskType valueOf(String r10) {
        return (AsyncTaskType) Enum.valueOf(AsyncTaskType.class, r10);
    }

    public static AsyncTaskType[] values() {
        return (AsyncTaskType[]) $VALUES.clone();
    }
}
