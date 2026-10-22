package u0;

/* loaded from: classes.dex */
public final class u extends w {

    /* renamed from: a, reason: collision with root package name */
    public final t0.c f9925a;

    public u(t0.c cVar) {
        this.f9925a = cVar;
    }

    @Override // u0.w
    public final t0.c a() {
        return this.f9925a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return q7.k.a(this.f9925a, ((u) obj).f9925a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9925a.hashCode();
    }
}
