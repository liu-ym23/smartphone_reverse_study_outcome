package o;

/* loaded from: classes.dex */
public final class v extends n0.l implements i1.m {

    /* renamed from: t, reason: collision with root package name */
    public final q.i f7133t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7134u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7135v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7136w;

    public v(q.i iVar) {
        this.f7133t = iVar;
    }

    @Override // n0.l
    public final void d0() {
        ia.d0.s(Z(), null, null, new a6.r(this, null, 5), 3);
    }

    @Override // i1.m
    public final void e(i1.h0 h0Var) {
        h0Var.a();
        w0.b bVar = h0Var.f4489f;
        if (this.f7134u) {
            w0.d.K(h0Var, u0.m.b(0.3f, u0.m.f9912b), bVar.d(), 122);
        } else if (this.f7135v || this.f7136w) {
            w0.d.K(h0Var, u0.m.b(0.1f, u0.m.f9912b), bVar.d(), 122);
        }
    }
}
