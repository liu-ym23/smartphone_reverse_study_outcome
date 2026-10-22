package io.reactivex.annotations;

/* JADX INFO: loaded from: classes4.dex */
public final enum BackpressureKind extends Enum<BackpressureKind> {
    private static final /* synthetic */ BackpressureKind[] $VALUES = null;
    public static final BackpressureKind ERROR = null;
    public static final BackpressureKind FULL = null;
    public static final BackpressureKind NONE = null;
    public static final BackpressureKind PASS_THROUGH = null;
    public static final BackpressureKind SPECIAL = null;
    public static final BackpressureKind UNBOUNDED_IN = null;

    static {
        BackpressureKind r10 = new BackpressureKind("PASS_THROUGH", 0);
        PASS_THROUGH = r10;
        BackpressureKind r11 = new BackpressureKind("FULL", 1);
        FULL = r11;
        BackpressureKind r12 = new BackpressureKind("SPECIAL", 2);
        SPECIAL = r12;
        BackpressureKind r13 = new BackpressureKind("UNBOUNDED_IN", 3);
        UNBOUNDED_IN = r13;
        BackpressureKind r14 = new BackpressureKind("ERROR", 4);
        ERROR = r14;
        BackpressureKind r15 = new BackpressureKind("NONE", 5);
        NONE = r15;
        $VALUES = new BackpressureKind[]{r10, r11, r12, r13, r14, r15};
    }

    private BackpressureKind(String r10, int r11) {
        super(r10, r11);
    }

    public static BackpressureKind valueOf(String r10) {
        return (BackpressureKind) Enum.valueOf(BackpressureKind.class, r10);
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[]) $VALUES.clone();
    }
}
