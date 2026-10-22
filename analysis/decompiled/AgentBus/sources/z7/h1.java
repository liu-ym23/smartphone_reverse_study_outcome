package z7;

/* loaded from: classes.dex */
public final class h1 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11878g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i1 f11879h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h1(i1 i1Var, int i2) {
        super(0);
        this.f11878g = i2;
        this.f11879h = i1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11878g) {
            case 0:
                return s1.a(this.f11879h, false);
            default:
                i1 i1Var = this.f11879h;
                i8.k0 k0VarG = i1Var.F().B().g();
                return k0VarG == null ? h9.m.g(i1Var.F().B(), g8.h.f3888a) : k0VarG;
        }
    }
}
