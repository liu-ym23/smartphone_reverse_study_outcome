package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes4.dex */
public final enum ThreadMode extends Enum<ThreadMode> {
    private static final /* synthetic */ ThreadMode[] $VALUES = null;
    public static final ThreadMode ASYNC = null;
    public static final ThreadMode BACKGROUND = null;
    public static final ThreadMode MAIN = null;
    public static final ThreadMode MAIN_ORDERED = null;
    public static final ThreadMode POSTING = null;

    static {
        ThreadMode r10 = new ThreadMode("POSTING", 0);
        POSTING = r10;
        ThreadMode r11 = new ThreadMode("MAIN", 1);
        MAIN = r11;
        ThreadMode r12 = new ThreadMode("MAIN_ORDERED", 2);
        MAIN_ORDERED = r12;
        ThreadMode r13 = new ThreadMode("BACKGROUND", 3);
        BACKGROUND = r13;
        ThreadMode r14 = new ThreadMode("ASYNC", 4);
        ASYNC = r14;
        $VALUES = new ThreadMode[]{r10, r11, r12, r13, r14};
    }

    private ThreadMode(String r10, int r11) {
        super(r10, r11);
    }

    public static ThreadMode valueOf(String r10) {
        return (ThreadMode) Enum.valueOf(ThreadMode.class, r10);
    }

    public static ThreadMode[] values() {
        return (ThreadMode[]) $VALUES.clone();
    }
}
