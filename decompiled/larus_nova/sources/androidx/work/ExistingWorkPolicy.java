package androidx.work;

import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final enum ExistingWorkPolicy extends Enum<ExistingWorkPolicy> {
    private static final /* synthetic */ ExistingWorkPolicy[] $VALUES = null;
    public static final ExistingWorkPolicy APPEND = null;
    public static final ExistingWorkPolicy APPEND_OR_REPLACE = null;
    public static final ExistingWorkPolicy KEEP = null;
    public static final ExistingWorkPolicy REPLACE = null;

    static {
        ExistingWorkPolicy r100 = new ExistingWorkPolicy("REPLACE", 0);
        REPLACE = r100;
        ExistingWorkPolicy r101 = new ExistingWorkPolicy("KEEP", 1);
        KEEP = r101;
        ExistingWorkPolicy r102 = new ExistingWorkPolicy("APPEND", 2);
        APPEND = r102;
        ExistingWorkPolicy r103 = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
        APPEND_OR_REPLACE = r103;
        $VALUES = new ExistingWorkPolicy[]{r100, r101, r102, r103};
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[]) $VALUES.clone();
    }

    public static ExistingWorkPolicy valueOf(String r100) {
        return (ExistingWorkPolicy) a.a(ExistingWorkPolicy.class, r100);
    }

    private ExistingWorkPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
