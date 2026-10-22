package androidx.work;

import r27.a;

/* JADX INFO: loaded from: classes17.dex */
public final enum OutOfQuotaPolicy extends Enum<OutOfQuotaPolicy> {
    private static final /* synthetic */ OutOfQuotaPolicy[] $VALUES = null;
    public static final OutOfQuotaPolicy DROP_WORK_REQUEST = null;
    public static final OutOfQuotaPolicy RUN_AS_NON_EXPEDITED_WORK_REQUEST = null;

    static {
        OutOfQuotaPolicy r100 = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        RUN_AS_NON_EXPEDITED_WORK_REQUEST = r100;
        OutOfQuotaPolicy r101 = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
        DROP_WORK_REQUEST = r101;
        $VALUES = new OutOfQuotaPolicy[]{r100, r101};
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[]) $VALUES.clone();
    }

    public static OutOfQuotaPolicy valueOf(String r100) {
        return (OutOfQuotaPolicy) a.a(OutOfQuotaPolicy.class, r100);
    }

    private OutOfQuotaPolicy(String r100, int r101) {
        super(r100, r101);
    }
}
