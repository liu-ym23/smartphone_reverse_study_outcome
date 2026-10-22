package com.bytedance.platform.thread;

/* JADX INFO: loaded from: classes.dex */
public final enum ThreadPoolType extends Enum<ThreadPoolType> {
    private static final /* synthetic */ ThreadPoolType[] $VALUES = null;
    public static final ThreadPoolType BACKGROUND = null;
    public static final ThreadPoolType DEFAULT = null;
    public static final ThreadPoolType FIXED = null;
    public static final ThreadPoolType IO = null;
    public static final ThreadPoolType SCHEDULED = null;
    public static final ThreadPoolType SINGLE = null;

    static {
        ThreadPoolType r10 = new ThreadPoolType("IO", 0);
        IO = r10;
        ThreadPoolType r11 = new ThreadPoolType("DEFAULT", 1);
        DEFAULT = r11;
        ThreadPoolType r12 = new ThreadPoolType("BACKGROUND", 2);
        BACKGROUND = r12;
        ThreadPoolType r13 = new ThreadPoolType("FIXED", 3);
        FIXED = r13;
        ThreadPoolType r14 = new ThreadPoolType("SCHEDULED", 4);
        SCHEDULED = r14;
        ThreadPoolType r15 = new ThreadPoolType("SINGLE", 5);
        SINGLE = r15;
        $VALUES = new ThreadPoolType[]{r10, r11, r12, r13, r14, r15};
    }

    private ThreadPoolType(String r10, int r11) {
        super(r10, r11);
    }

    public static ThreadPoolType valueOf(String r10) {
        return (ThreadPoolType) Enum.valueOf(ThreadPoolType.class, r10);
    }

    public static ThreadPoolType[] values() {
        return (ThreadPoolType[]) $VALUES.clone();
    }
}
