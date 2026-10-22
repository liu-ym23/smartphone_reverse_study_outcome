package z7;

/* loaded from: classes.dex */
public final class f1 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11863g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g1 f11864h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f1(g1 g1Var, int i2) {
        super(0);
        this.f11863g = i2;
        this.f11864h = g1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11863g) {
            case 0:
                return s1.a(this.f11864h, true);
            default:
                g1 g1Var = this.f11864h;
                i8.j0 j0VarB = g1Var.F().B().b();
                return j0VarB == null ? h9.m.f(g1Var.F().B(), g8.h.f3888a) : j0VarB;
        }
    }
}
