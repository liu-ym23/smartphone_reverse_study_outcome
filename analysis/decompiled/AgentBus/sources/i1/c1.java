package i1;

/* loaded from: classes.dex */
public final class c1 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4418g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d1 f4419h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(d1 d1Var, int i2) {
        super(0);
        this.f4418g = i2;
        this.f4419h = d1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f4418g) {
            case 0:
                d1 d1Var = this.f4419h;
                u0.l lVar = d1Var.J;
                q7.k.b(lVar);
                d1Var.t0(lVar, d1Var.I);
                return c7.r.f1986a;
            case 1:
                d1 d1Var2 = this.f4419h.f4439v;
                if (d1Var2 != null) {
                    d1Var2.G0();
                }
                return c7.r.f1986a;
            default:
                d1 d1Var3 = this.f4419h;
                if (!d1Var3.z0().f6810s) {
                    d1Var3 = null;
                }
                if (d1Var3 != null) {
                    return n7.m.a(0L, ib.k.W(d1Var3.f3758h));
                }
                return null;
        }
    }
}
