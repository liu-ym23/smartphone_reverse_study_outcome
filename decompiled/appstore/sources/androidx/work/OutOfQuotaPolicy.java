package androidx.work;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/work/OutOfQuotaPolicy;", "", "(Ljava/lang/String;I)V", "RUN_AS_NON_EXPEDITED_WORK_REQUEST", "DROP_WORK_REQUEST", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum OutOfQuotaPolicy extends Enum<OutOfQuotaPolicy> {
    private static final /* synthetic */ OutOfQuotaPolicy[] $VALUES = null;
    public static final OutOfQuotaPolicy DROP_WORK_REQUEST = null;
    public static final OutOfQuotaPolicy RUN_AS_NON_EXPEDITED_WORK_REQUEST = null;

    private static final /* synthetic */ OutOfQuotaPolicy[] $values() {
        return new OutOfQuotaPolicy[]{RUN_AS_NON_EXPEDITED_WORK_REQUEST, DROP_WORK_REQUEST};
    }

    static {
        RUN_AS_NON_EXPEDITED_WORK_REQUEST = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        DROP_WORK_REQUEST = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
        $VALUES = $values();
    }

    private OutOfQuotaPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static OutOfQuotaPolicy valueOf(String r10) {
        return (OutOfQuotaPolicy) Enum.valueOf(OutOfQuotaPolicy.class, r10);
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[]) $VALUES.clone();
    }
}
