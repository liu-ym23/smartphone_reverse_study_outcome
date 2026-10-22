package androidx.work;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExistingWorkPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final ExistingWorkPolicy f2774a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExistingWorkPolicy f2775b;

    /* renamed from: c, reason: collision with root package name */
    public static final ExistingWorkPolicy f2776c;

    /* renamed from: d, reason: collision with root package name */
    public static final ExistingWorkPolicy f2777d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ ExistingWorkPolicy[] f2778e;

    static {
        ExistingWorkPolicy existingWorkPolicy = new ExistingWorkPolicy("REPLACE", 0);
        f2774a = existingWorkPolicy;
        ExistingWorkPolicy existingWorkPolicy2 = new ExistingWorkPolicy("KEEP", 1);
        f2775b = existingWorkPolicy2;
        ExistingWorkPolicy existingWorkPolicy3 = new ExistingWorkPolicy("APPEND", 2);
        f2776c = existingWorkPolicy3;
        ExistingWorkPolicy existingWorkPolicy4 = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
        f2777d = existingWorkPolicy4;
        f2778e = new ExistingWorkPolicy[]{existingWorkPolicy, existingWorkPolicy2, existingWorkPolicy3, existingWorkPolicy4};
    }

    public ExistingWorkPolicy() {
        throw null;
    }

    public static ExistingWorkPolicy valueOf(String str) {
        return (ExistingWorkPolicy) Enum.valueOf(ExistingWorkPolicy.class, str);
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[]) f2778e.clone();
    }
}
