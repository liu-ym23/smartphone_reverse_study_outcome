package io.reactivex;

/* JADX INFO: loaded from: classes4.dex */
public final enum BackpressureStrategy extends Enum<BackpressureStrategy> {
    private static final /* synthetic */ BackpressureStrategy[] $VALUES = null;
    public static final BackpressureStrategy BUFFER = null;
    public static final BackpressureStrategy DROP = null;
    public static final BackpressureStrategy ERROR = null;
    public static final BackpressureStrategy LATEST = null;
    public static final BackpressureStrategy MISSING = null;

    private BackpressureStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static BackpressureStrategy valueOf(String r1) {
        return (BackpressureStrategy) Enum.valueOf(BackpressureStrategy.class, r1);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) $VALUES.clone();
    }

    static {
        BackpressureStrategy r0 = new BackpressureStrategy("MISSING", 0);
        MISSING = r0;
        BackpressureStrategy r1 = new BackpressureStrategy("ERROR", 1);
        ERROR = r1;
        BackpressureStrategy r3 = new BackpressureStrategy("BUFFER", 2);
        BUFFER = r3;
        BackpressureStrategy r5 = new BackpressureStrategy("DROP", 3);
        DROP = r5;
        BackpressureStrategy r7 = new BackpressureStrategy("LATEST", 4);
        LATEST = r7;
        $VALUES = new BackpressureStrategy[]{r0, r1, r3, r5, r7};
    }
}
