package r;

/* loaded from: classes.dex */
public final class m0 extends n0.l implements i1.v {

    /* renamed from: t, reason: collision with root package name */
    public float f8895t;

    /* renamed from: u, reason: collision with root package name */
    public float f8896u;

    @Override // i1.v
    public final i1.l0 G(i1.m0 m0Var, g1.o oVar, long j2) {
        int iJ;
        int i2 = 0;
        if (d2.f.a(this.f8895t, Float.NaN) || d2.a.j(j2) != 0) {
            iJ = d2.a.j(j2);
        } else {
            iJ = m0Var.y(this.f8895t);
            int iH = d2.a.h(j2);
            if (iJ > iH) {
                iJ = iH;
            }
            if (iJ < 0) {
                iJ = 0;
            }
        }
        int iH2 = d2.a.h(j2);
        if (d2.f.a(this.f8896u, Float.NaN) || d2.a.i(j2) != 0) {
            i2 = d2.a.i(j2);
        } else {
            int iY = m0Var.y(this.f8896u);
            int iG = d2.a.g(j2);
            if (iY > iG) {
                iY = iG;
            }
            if (iY >= 0) {
                i2 = iY;
            }
        }
        g1.s sVarB = oVar.b(d2.b.a(iJ, iH2, i2, d2.a.g(j2)));
        return m0Var.l0(sVarB.f3756f, sVarB.f3757g, d7.a0.f2944f, new g1.v(sVarB, 7));
    }
}
