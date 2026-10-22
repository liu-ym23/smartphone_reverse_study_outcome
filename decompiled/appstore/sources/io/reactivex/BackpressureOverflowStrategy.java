package io.reactivex;

/* JADX INFO: loaded from: classes4.dex */
public final enum BackpressureOverflowStrategy extends Enum<BackpressureOverflowStrategy> {
    private static final /* synthetic */ BackpressureOverflowStrategy[] $VALUES = null;
    public static final BackpressureOverflowStrategy DROP_LATEST = null;
    public static final BackpressureOverflowStrategy DROP_OLDEST = null;
    public static final BackpressureOverflowStrategy ERROR = null;

    static {
        BackpressureOverflowStrategy r10 = new BackpressureOverflowStrategy("ERROR", 0);
        ERROR = r10;
        BackpressureOverflowStrategy r11 = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
        DROP_OLDEST = r11;
        BackpressureOverflowStrategy r12 = new BackpressureOverflowStrategy("DROP_LATEST", 2);
        DROP_LATEST = r12;
        $VALUES = new BackpressureOverflowStrategy[]{r10, r11, r12};
    }

    private BackpressureOverflowStrategy(String r10, int r11) {
        super(r10, r11);
    }

    public static BackpressureOverflowStrategy valueOf(String r10) {
        return (BackpressureOverflowStrategy) Enum.valueOf(BackpressureOverflowStrategy.class, r10);
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[]) $VALUES.clone();
    }
}
