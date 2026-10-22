package y;

/* loaded from: classes.dex */
public final class s extends n0.l implements i1.i, i1.v {
    @Override // i1.v
    public final i1.l0 G(i1.m0 m0Var, g1.o oVar, long j2) {
        float f10 = ((d2.f) i1.l.h(this, r.f11519a)).f2784f;
        float f11 = 0;
        if (f10 < f11) {
            f10 = f11;
        }
        g1.s sVarB = oVar.b(j2);
        boolean z4 = this.f6810s && !Float.isNaN(f10) && Float.compare(f10, f11) > 0;
        int iY = Float.isNaN(f10) ? 0 : m0Var.y(f10);
        int iMax = z4 ? Math.max(sVarB.f3756f, iY) : sVarB.f3756f;
        int iMax2 = z4 ? Math.max(sVarB.f3757g, iY) : sVarB.f3757g;
        return m0Var.l0(iMax, iMax2, d7.a0.f2944f, new r.x(iMax, sVarB, iMax2));
    }
}
