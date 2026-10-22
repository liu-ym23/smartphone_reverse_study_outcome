package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 implements r0, g, oc.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t0 f8841c;

    public f0(t0 t0Var) {
        this.f8841c = t0Var;
    }

    @Override // oc.r
    public final g a(nb.g gVar, int i, mc.a aVar) {
        return (((i < 0 || i >= 2) && i != -2) || aVar != mc.a.f8551f) ? k0.l(this, gVar, i, aVar) : this;
    }

    @Override // nc.g
    public final Object collect(h hVar, nb.c cVar) throws Throwable {
        this.f8841c.collect(hVar, cVar);
        return ob.a.f9351c;
    }

    @Override // nc.r0
    public final Object getValue() {
        return this.f8841c.getValue();
    }
}
