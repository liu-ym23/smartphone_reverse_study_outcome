package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t0 f13914c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n1 f13915f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f13916g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(t0 t0Var, n1 n1Var, long j10) {
        super(0);
        this.f13914c = t0Var;
        this.f13915f = n1Var;
        this.f13916g = j10;
    }

    @Override // xb.a
    public final Object invoke() {
        p0 p0VarF0;
        k0 k0Var = this.f13914c.f13921j;
        s1.n0 placementScope = null;
        if (f.q(k0Var.f13843a) || k0Var.f13845c) {
            g1 g1Var = k0Var.a().f13812u;
            if (g1Var != null) {
                placementScope = g1Var.f13883p;
            }
        } else {
            g1 g1Var2 = k0Var.a().f13812u;
            if (g1Var2 != null && (p0VarF0 = g1Var2.F0()) != null) {
                placementScope = p0VarF0.f13883p;
            }
        }
        if (placementScope == null) {
            placementScope = ((v1.t) this.f13915f).getPlacementScope();
        }
        p0 p0VarF02 = k0Var.a().F0();
        p0VarF02.getClass();
        s1.n0.k(placementScope, p0VarF02, this.f13916g);
        return jb.v.f6774a;
    }
}
