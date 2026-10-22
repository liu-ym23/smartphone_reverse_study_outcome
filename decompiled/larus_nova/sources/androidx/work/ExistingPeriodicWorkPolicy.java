package androidx.work;

import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final enum ExistingPeriodicWorkPolicy extends Enum<ExistingPeriodicWorkPolicy> {
    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $VALUES = null;
    public static final ExistingPeriodicWorkPolicy KEEP = null;
    public static final ExistingPeriodicWorkPolicy REPLACE = null;

    static {
        ExistingPeriodicWorkPolicy r100 = new ExistingPeriodicWorkPolicy("REPLACE", 0);
        REPLACE = r100;
        ExistingPeriodicWorkPolicy r101 = new ExistingPeriodicWorkPolicy("KEEP", 1);
        KEEP = r101;
        $VALUES = new ExistingPeriodicWorkPolicy[]{r100, r101};
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) $VALUES.clone();
    }

    public static ExistingPeriodicWorkPolicy valueOf(String r100) {
        return (ExistingPeriodicWorkPolicy) a.a(ExistingPeriodicWorkPolicy.class, r100);
    }

    private ExistingPeriodicWorkPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
