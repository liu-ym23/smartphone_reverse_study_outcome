package g1;

import i1.l0;
import i1.m0;
import i1.x1;

/* loaded from: classes.dex */
public final class z extends n0.l implements i1.v, x1 {

    /* renamed from: t, reason: collision with root package name */
    public j f3774t;

    /* renamed from: u, reason: collision with root package name */
    public final y f3775u;

    public z(j jVar) {
        this.f3774t = jVar;
        this.f3775u = new y(0, this, jVar);
    }

    @Override // i1.v
    public final l0 G(m0 m0Var, o oVar, long j2) {
        s sVarB = oVar.b(j2);
        return m0Var.k0(sVarB.f3756f, sVarB.f3757g, d7.a0.f2944f, this.f3775u, new v(sVarB, 1));
    }

    @Override // i1.x1
    public final Object k() {
        return "androidx.compose.ui.layout.WindowInsetsRulers";
    }
}
