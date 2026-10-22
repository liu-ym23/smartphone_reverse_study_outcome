package u0;

import i1.l0;
import i1.m0;
import i1.s1;

/* loaded from: classes.dex */
public final class j extends n0.l implements i1.v, s1 {

    /* renamed from: t, reason: collision with root package name */
    public p7.k f9911t;

    @Override // i1.v
    public final l0 G(m0 m0Var, g1.o oVar, long j2) {
        g1.s sVarB = oVar.b(j2);
        return m0Var.l0(sVarB.f3756f, sVarB.f3757g, d7.a0.f2944f, new g1.y(25, sVarB, this));
    }

    @Override // n0.l
    public final boolean a0() {
        return false;
    }

    @Override // i1.s1
    public final boolean g() {
        return false;
    }

    public final String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.f9911t + ')';
    }

    @Override // i1.s1
    public final void u(p1.i iVar) {
    }
}
