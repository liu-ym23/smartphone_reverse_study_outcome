package tc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n0<T> implements pc.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final pc.a<T> f13018a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f13019b;

    public n0(pc.a<T> aVar) {
        this.f13018a = aVar;
        this.f13019b = new x0(aVar.d());
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        if (obj != null) {
            kVar.q(this.f13018a, obj);
        } else {
            kVar.k();
        }
    }

    @Override // pc.a
    public final T b(sc.d dVar) {
        if (dVar.x()) {
            return (T) dVar.z(this.f13018a);
        }
        return null;
    }

    @Override // pc.c
    public final rc.e d() {
        return this.f13019b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && n0.class == obj.getClass() && kotlin.jvm.internal.g.b(this.f13018a, ((n0) obj).f13018a);
    }

    public final int hashCode() {
        return this.f13018a.hashCode();
    }
}
