package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j1 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k1 f13019c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f13020f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s1.o0 f13021g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, int i, s1.o0 o0Var) {
        super(1);
        this.f13019c = k1Var;
        this.f13020f = i;
        this.f13021g = o0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        s1.n0 n0Var = (s1.n0) obj;
        k1 k1Var = this.f13019c;
        int i = -p5.f.q(k1Var.f13027s.f12998a.g(), 0, this.f13020f);
        boolean z10 = k1Var.f13028t;
        int i3 = z10 ? 0 : i;
        if (!z10) {
            i = 0;
        }
        h0.s0 s0Var = new h0.s0(this.f13021g, i3, i, 1);
        n0Var.f11270c = true;
        s0Var.invoke(n0Var);
        n0Var.f11270c = false;
        return jb.v.f6774a;
    }
}
