package y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15743c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i0 f15744f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(i0 i0Var, int i) {
        super(0);
        this.f15743c = i;
        this.f15744f = i0Var;
    }

    @Override // xb.a
    public final Object invoke() {
        long jB;
        switch (this.f15743c) {
            case 0:
                i0 i0Var = this.f15744f;
                x.r rVar = i0Var.f15753t.f15403a;
                if (rVar.i().f15451n == u.f0.f13453c) {
                    s1.g0 g0Var = rVar.i().f15454q;
                    jB = ac.a.b(g0Var.e(), g0Var.d()) & 4294967295L;
                } else {
                    s1.g0 g0Var2 = rVar.i().f15454q;
                    jB = ac.a.b(g0Var2.e(), g0Var2.d()) >> 32;
                }
                int i = (int) jB;
                x.r rVar2 = i0Var.f15753t.f15403a;
                return Float.valueOf(i - ((-rVar2.i().f15448k) + rVar2.i().f15452o));
            case 1:
                x.r rVar3 = this.f15744f.f15753t.f15403a;
                return Float.valueOf((rVar3.g() * 500) + rVar3.h());
            default:
                x.r rVar4 = this.f15744f.f15753t.f15403a;
                int iG = rVar4.g();
                int iH = rVar4.h();
                return Float.valueOf(rVar4.d() ? (iG * 500) + iH + 100 : (iG * 500) + iH);
        }
    }
}
