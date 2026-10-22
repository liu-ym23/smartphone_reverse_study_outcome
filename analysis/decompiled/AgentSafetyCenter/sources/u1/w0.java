package u1;

import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13953c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x0 f13954f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(x0 x0Var, int i) {
        super(0);
        this.f13953c = i;
        this.f13954f = x0Var;
    }

    @Override // xb.a
    public final Object invoke() {
        s1.n0 placementScope;
        switch (this.f13953c) {
            case 0:
                x0 x0Var = this.f13954f;
                k0 k0Var = x0Var.f13956j;
                k0Var.i = 0;
                m0.e eVarX = k0Var.f13843a.x();
                Object[] objArr = eVarX.f8158c;
                int i = eVarX.f8160g;
                for (int i3 = 0; i3 < i; i3++) {
                    x0 x0Var2 = ((g0) objArr[i3]).I.f13857p;
                    x0Var2.f13958l = x0Var2.f13959m;
                    x0Var2.f13959m = Reader.READ_DONE;
                    x0Var2.f13970x = false;
                    if (x0Var2.f13962p == e0.f13766f) {
                        x0Var2.f13962p = e0.f13767g;
                    }
                }
                g0 g0Var = k0Var.f13843a;
                g0 g0Var2 = k0Var.f13843a;
                m0.e eVarX2 = g0Var.x();
                Object[] objArr2 = eVarX2.f8158c;
                int i10 = eVarX2.f8160g;
                for (int i11 = 0; i11 < i10; i11++) {
                    ((g0) objArr2[i11]).I.f13857p.B.f13825d = false;
                }
                x0Var.f().p0().c();
                m0.e eVarX3 = g0Var2.x();
                Object[] objArr3 = eVarX3.f8158c;
                int i12 = eVarX3.f8160g;
                for (int i13 = 0; i13 < i12; i13++) {
                    g0 g0Var3 = (g0) objArr3[i13];
                    k0 k0Var2 = g0Var3.I;
                    if (k0Var2.f13857p.f13958l != g0Var3.u()) {
                        g0Var2.M();
                        g0Var2.A();
                        if (g0Var3.u() == Integer.MAX_VALUE) {
                            if (k0Var2.f13845c) {
                                t0 t0Var = k0Var2.f13858q;
                                t0Var.getClass();
                                t0Var.Z(false);
                            }
                            k0Var2.f13857p.c0();
                        }
                    }
                }
                m0.e eVarX4 = g0Var2.x();
                Object[] objArr4 = eVarX4.f8158c;
                int i14 = eVarX4.f8160g;
                for (int i15 = 0; i15 < i14; i15++) {
                    h0 h0Var = ((g0) objArr4[i15]).I.f13857p.B;
                    h0Var.f13826e = h0Var.f13825d;
                }
                break;
            case 1:
                x0 x0Var3 = this.f13954f;
                x0Var3.f13956j.a().q(x0Var3.F);
                break;
            default:
                x0 x0Var4 = this.f13954f;
                k0 k0Var3 = x0Var4.f13956j;
                g1 g1Var = k0Var3.a().f13812u;
                if (g1Var == null || (placementScope = g1Var.f13883p) == null) {
                    placementScope = ((v1.t) j0.a(k0Var3.f13843a)).getPlacementScope();
                }
                xb.l lVar = x0Var4.K;
                if (lVar == null) {
                    g1 g1VarA = k0Var3.a();
                    long j10 = x0Var4.L;
                    float f5 = x0Var4.M;
                    placementScope.getClass();
                    s1.n0.b(placementScope, g1VarA);
                    g1VarA.R(o2.i.d(j10, g1VarA.i), f5, null);
                } else {
                    g1 g1VarA2 = k0Var3.a();
                    long j11 = x0Var4.L;
                    float f10 = x0Var4.M;
                    placementScope.getClass();
                    s1.n0.b(placementScope, g1VarA2);
                    g1VarA2.R(o2.i.d(j11, g1VarA2.i), f10, lVar);
                }
                break;
        }
        return jb.v.f6774a;
    }
}
