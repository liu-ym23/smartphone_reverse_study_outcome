package i1;

/* loaded from: classes.dex */
public final class u0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4604g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ v0 f4605h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(v0 v0Var, int i2) {
        super(0);
        this.f4604g = i2;
        this.f4605h = v0Var;
    }

    @Override // p7.a
    public final Object c() {
        g1.r placementScope;
        switch (this.f4604g) {
            case 0:
                v0 v0Var = this.f4605h;
                i0 i0Var = v0Var.f4607k;
                i0Var.f4500h = 0;
                d0.e eVarS = i0Var.f4493a.s();
                Object[] objArr = eVarS.f2749f;
                int i2 = eVarS.f2751h;
                for (int i10 = 0; i10 < i2; i10++) {
                    v0 v0Var2 = ((f0) objArr[i10]).I.f4507o;
                    v0Var2.f4609m = v0Var2.f4610n;
                    v0Var2.f4610n = Integer.MAX_VALUE;
                    v0Var2.f4619w = false;
                    if (v0Var2.f4613q == d0.f4434g) {
                        v0Var2.f4613q = d0.f4435h;
                    }
                }
                f0 f0Var = i0Var.f4493a;
                f0 f0Var2 = i0Var.f4493a;
                d0.e eVarS2 = f0Var.s();
                Object[] objArr2 = eVarS2.f2749f;
                int i11 = eVarS2.f2751h;
                for (int i12 = 0; i12 < i11; i12++) {
                    ((f0) objArr2[i12]).I.f4507o.A.getClass();
                }
                v0Var.l().e0().e();
                d0.e eVarS3 = f0Var2.s();
                Object[] objArr3 = eVarS3.f2749f;
                int i13 = eVarS3.f2751h;
                for (int i14 = 0; i14 < i13; i14++) {
                    f0 f0Var3 = (f0) objArr3[i14];
                    i0 i0Var2 = f0Var3.I;
                    if (i0Var2.f4507o.f4609m != f0Var3.o()) {
                        f0Var2.H();
                        f0Var2.v();
                        if (f0Var3.o() == Integer.MAX_VALUE) {
                            if (i0Var2.f4494b) {
                                r0 r0Var = i0Var2.f4508p;
                                q7.k.b(r0Var);
                                r0Var.Q(false);
                            }
                            i0Var2.f4507o.S();
                        }
                    }
                }
                d0.e eVarS4 = f0Var2.s();
                Object[] objArr4 = eVarS4.f2749f;
                int i15 = eVarS4.f2751h;
                for (int i16 = 0; i16 < i15; i16++) {
                    g0 g0Var = ((f0) objArr4[i16]).I.f4507o.A;
                    g0Var.getClass();
                    g0Var.f4481c = false;
                }
                break;
            case 1:
                v0 v0Var3 = this.f4605h;
                v0Var3.f4607k.a().b(v0Var3.E);
                break;
            default:
                v0 v0Var4 = this.f4605h;
                i0 i0Var3 = v0Var4.f4607k;
                d1 d1Var = i0Var3.a().f4439v;
                if (d1Var == null || (placementScope = d1Var.f4533q) == null) {
                    placementScope = ((j1.y) l.w(i0Var3.f4493a)).getPlacementScope();
                }
                p7.k kVar = v0Var4.J;
                if (kVar == null) {
                    d1 d1VarA = i0Var3.a();
                    long j2 = v0Var4.K;
                    placementScope.getClass();
                    g1.r.a(placementScope, d1VarA);
                    d1VarA.M(d2.i.c(j2, d1VarA.f3760j), 0.0f, null);
                } else {
                    d1 d1VarA2 = i0Var3.a();
                    long j4 = v0Var4.K;
                    placementScope.getClass();
                    g1.r.a(placementScope, d1VarA2);
                    d1VarA2.M(d2.i.c(j4, d1VarA2.f3760j), 0.0f, kVar);
                }
                break;
        }
        return c7.r.f1986a;
    }
}
