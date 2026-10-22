package i1;

/* loaded from: classes.dex */
public final class q0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r0 f4564g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k1 f4565h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f4566i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(r0 r0Var, k1 k1Var, long j2) {
        super(0);
        this.f4564g = r0Var;
        this.f4565h = k1Var;
        this.f4566i = j2;
    }

    @Override // p7.a
    public final Object c() {
        n0 n0VarX0;
        i0 i0Var = this.f4564g.f4567k;
        g1.r placementScope = null;
        if (l.q(i0Var.f4493a) || i0Var.f4494b) {
            d1 d1Var = i0Var.a().f4439v;
            if (d1Var != null) {
                placementScope = d1Var.f4533q;
            }
        } else {
            d1 d1Var2 = i0Var.a().f4439v;
            if (d1Var2 != null && (n0VarX0 = d1Var2.x0()) != null) {
                placementScope = n0VarX0.f4533q;
            }
        }
        if (placementScope == null) {
            placementScope = ((j1.y) this.f4565h).getPlacementScope();
        }
        n0 n0VarX02 = i0Var.a().x0();
        q7.k.b(n0VarX02);
        g1.r.h(placementScope, n0VarX02, this.f4566i);
        return c7.r.f1986a;
    }
}
