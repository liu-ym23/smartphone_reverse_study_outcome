package r;

/* loaded from: classes.dex */
public final class b0 extends n0.l implements i1.v {

    /* renamed from: t, reason: collision with root package name */
    public float f8845t;

    /* renamed from: u, reason: collision with root package name */
    public float f8846u;

    /* renamed from: v, reason: collision with root package name */
    public float f8847v;

    /* renamed from: w, reason: collision with root package name */
    public float f8848w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8849x;

    @Override // i1.v
    public final i1.l0 G(i1.m0 m0Var, g1.o oVar, long j2) {
        int iY = m0Var.y(this.f8847v) + m0Var.y(this.f8845t);
        int iY2 = m0Var.y(this.f8848w) + m0Var.y(this.f8846u);
        g1.s sVarB = oVar.b(d2.b.h(j2, -iY, -iY2));
        return m0Var.l0(d2.b.f(sVarB.f3756f + iY, j2), d2.b.e(sVarB.f3757g + iY2, j2), d7.a0.f2944f, new m.q(this, sVarB, m0Var, 4));
    }
}
