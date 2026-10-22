package r;

/* loaded from: classes.dex */
public final class u extends n0.l implements i1.v {

    /* renamed from: t, reason: collision with root package name */
    public int f8940t;

    /* renamed from: u, reason: collision with root package name */
    public float f8941u;

    @Override // i1.v
    public final i1.l0 G(i1.m0 m0Var, g1.o oVar, long j2) {
        int iJ;
        int iH;
        int i2;
        int iG;
        if (!d2.a.d(j2) || this.f8940t == 1) {
            iJ = d2.a.j(j2);
            iH = d2.a.h(j2);
        } else {
            iJ = nb.i.k(Math.round(d2.a.h(j2) * this.f8941u), d2.a.j(j2), d2.a.h(j2));
            iH = iJ;
        }
        if (!d2.a.c(j2) || this.f8940t == 2) {
            i2 = d2.a.i(j2);
            iG = d2.a.g(j2);
        } else {
            i2 = nb.i.k(Math.round(d2.a.g(j2) * this.f8941u), d2.a.i(j2), d2.a.g(j2));
            iG = i2;
        }
        g1.s sVarB = oVar.b(d2.b.a(iJ, iH, i2, iG));
        return m0Var.l0(sVarB.f3756f, sVarB.f3757g, d7.a0.f2944f, new g1.v(sVarB, 5));
    }
}
