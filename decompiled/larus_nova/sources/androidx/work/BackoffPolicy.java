package androidx.work;

import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final enum BackoffPolicy extends Enum<BackoffPolicy> {
    private static final /* synthetic */ BackoffPolicy[] $VALUES = null;
    public static final BackoffPolicy EXPONENTIAL = null;
    public static final BackoffPolicy LINEAR = null;

    static {
        BackoffPolicy r100 = new BackoffPolicy("EXPONENTIAL", 0);
        EXPONENTIAL = r100;
        BackoffPolicy r101 = new BackoffPolicy("LINEAR", 1);
        LINEAR = r101;
        $VALUES = new BackoffPolicy[]{r100, r101};
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) $VALUES.clone();
    }

    public static BackoffPolicy valueOf(String r100) {
        return (BackoffPolicy) a.a(BackoffPolicy.class, r100);
    }

    private BackoffPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
