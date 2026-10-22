package org.apache.http.annotation;

/* JADX INFO: loaded from: classes4.dex */
public final enum ThreadingBehavior extends Enum<ThreadingBehavior> {
    private static final /* synthetic */ ThreadingBehavior[] $VALUES = null;
    public static final ThreadingBehavior IMMUTABLE = null;
    public static final ThreadingBehavior IMMUTABLE_CONDITIONAL = null;
    public static final ThreadingBehavior SAFE = null;
    public static final ThreadingBehavior SAFE_CONDITIONAL = null;
    public static final ThreadingBehavior UNSAFE = null;

    static {
        ThreadingBehavior r10 = new ThreadingBehavior("IMMUTABLE", 0);
        IMMUTABLE = r10;
        ThreadingBehavior r11 = new ThreadingBehavior("IMMUTABLE_CONDITIONAL", 1);
        IMMUTABLE_CONDITIONAL = r11;
        ThreadingBehavior r12 = new ThreadingBehavior("SAFE", 2);
        SAFE = r12;
        ThreadingBehavior r13 = new ThreadingBehavior("SAFE_CONDITIONAL", 3);
        SAFE_CONDITIONAL = r13;
        ThreadingBehavior r14 = new ThreadingBehavior("UNSAFE", 4);
        UNSAFE = r14;
        $VALUES = new ThreadingBehavior[]{r10, r11, r12, r13, r14};
    }

    private ThreadingBehavior(String r10, int r11) {
        super(r10, r11);
    }

    public static ThreadingBehavior valueOf(String r10) {
        return (ThreadingBehavior) Enum.valueOf(ThreadingBehavior.class, r10);
    }

    public static ThreadingBehavior[] values() {
        return (ThreadingBehavior[]) $VALUES.clone();
    }
}
