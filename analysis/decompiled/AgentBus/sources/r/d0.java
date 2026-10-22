package r;

/* loaded from: classes.dex */
public final class d0 extends n0.l implements i1.v {

    /* renamed from: t, reason: collision with root package name */
    public c0 f8856t;

    @Override // i1.v
    public final i1.l0 G(i1.m0 m0Var, g1.o oVar, long j2) {
        c0 c0Var = this.f8856t;
        d2.l lVarC0 = m0Var.c0();
        c0Var.getClass();
        d2.l lVar = d2.l.f2793f;
        float f10 = lVarC0 == lVar ? c0Var.f8850a : c0Var.f8852c;
        float f11 = 0;
        if (Float.compare(f10, f11) >= 0 && Float.compare(this.f8856t.f8851b, f11) >= 0) {
            c0 c0Var2 = this.f8856t;
            d2.l lVarC02 = m0Var.c0();
            c0Var2.getClass();
            if (Float.compare(lVarC02 == lVar ? c0Var2.f8852c : c0Var2.f8850a, f11) >= 0 && Float.compare(this.f8856t.f8853d, f11) >= 0) {
                c0 c0Var3 = this.f8856t;
                d2.l lVarC03 = m0Var.c0();
                c0Var3.getClass();
                int iY = m0Var.y(lVarC03 == lVar ? c0Var3.f8850a : c0Var3.f8852c);
                c0 c0Var4 = this.f8856t;
                d2.l lVarC04 = m0Var.c0();
                c0Var4.getClass();
                int iY2 = m0Var.y(lVarC04 == lVar ? c0Var4.f8852c : c0Var4.f8850a) + iY;
                int iY3 = m0Var.y(this.f8856t.f8853d) + m0Var.y(this.f8856t.f8851b);
                g1.s sVarB = oVar.b(d2.b.h(j2, -iY2, -iY3));
                return m0Var.l0(d2.b.f(sVarB.f3756f + iY2, j2), d2.b.e(sVarB.f3757g + iY3, j2), d7.a0.f2944f, new m.q(sVarB, m0Var, this, 5));
            }
        }
        throw new IllegalArgumentException("Padding must be non-negative");
    }
}
