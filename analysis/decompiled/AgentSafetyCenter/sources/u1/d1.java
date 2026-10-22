package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13751c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g1 f13752f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(g1 g1Var, int i) {
        super(0);
        this.f13751c = i;
        this.f13752f = g1Var;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f13751c) {
            case 0:
                g1 g1Var = this.f13752f;
                d1.o oVar = g1Var.I;
                oVar.getClass();
                g1Var.B0(oVar, g1Var.H);
                return jb.v.f6774a;
            case 1:
                g1 g1Var2 = this.f13752f.f13812u;
                if (g1Var2 != null) {
                    g1Var2.O0();
                }
                return jb.v.f6774a;
            default:
                g1 g1Var3 = this.f13752f;
                if (!g1Var3.H0().f15126r) {
                    g1Var3 = null;
                }
                if (g1Var3 != null) {
                    return p5.f.d(0L, ac.a.i0(g1Var3.f11279g));
                }
                return null;
        }
    }
}
