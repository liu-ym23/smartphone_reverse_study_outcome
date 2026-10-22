package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OutOfQuotaPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final OutOfQuotaPolicy f2789a;

    /* renamed from: b, reason: collision with root package name */
    public static final OutOfQuotaPolicy f2790b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ OutOfQuotaPolicy[] f2791c;

    static {
        OutOfQuotaPolicy outOfQuotaPolicy = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        f2789a = outOfQuotaPolicy;
        OutOfQuotaPolicy outOfQuotaPolicy2 = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
        f2790b = outOfQuotaPolicy2;
        f2791c = new OutOfQuotaPolicy[]{outOfQuotaPolicy, outOfQuotaPolicy2};
    }

    public OutOfQuotaPolicy() {
        throw null;
    }

    public static OutOfQuotaPolicy valueOf(String str) {
        return (OutOfQuotaPolicy) Enum.valueOf(OutOfQuotaPolicy.class, str);
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[]) f2791c.clone();
    }
}
