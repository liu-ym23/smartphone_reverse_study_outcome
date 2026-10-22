package p6;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f11440b = new h(2);

    /* renamed from: a, reason: collision with root package name */
    public final int f11441a;

    public h(int i10) {
        this.f11441a = i10;
        if (i10 < 1) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "maxConcurrent must be >= 1, got ").toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f11441a == ((h) obj).f11441a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11441a);
    }

    public final String toString() {
        return ai.onnxruntime.a.g(this.f11441a, "QuotaConfig(maxConcurrent=", ")");
    }
}
