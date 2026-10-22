package kotlin.jvm.internal;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f10085a;

    public h(Class jClass) {
        g.f(jClass, "jClass");
        this.f10085a = jClass;
    }

    @Override // kotlin.jvm.internal.b
    public final Class<?> a() {
        return this.f10085a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return g.b(this.f10085a, ((h) obj).f10085a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10085a.hashCode();
    }

    public final String toString() {
        return this.f10085a + " (Kotlin reflection is not available)";
    }
}
