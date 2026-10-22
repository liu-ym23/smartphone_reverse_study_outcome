package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BackoffPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final BackoffPolicy f2759a;

    /* renamed from: b, reason: collision with root package name */
    public static final BackoffPolicy f2760b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ BackoffPolicy[] f2761c;

    static {
        BackoffPolicy backoffPolicy = new BackoffPolicy("EXPONENTIAL", 0);
        f2759a = backoffPolicy;
        BackoffPolicy backoffPolicy2 = new BackoffPolicy("LINEAR", 1);
        f2760b = backoffPolicy2;
        f2761c = new BackoffPolicy[]{backoffPolicy, backoffPolicy2};
    }

    public BackoffPolicy() {
        throw null;
    }

    public static BackoffPolicy valueOf(String str) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, str);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) f2761c.clone();
    }
}
