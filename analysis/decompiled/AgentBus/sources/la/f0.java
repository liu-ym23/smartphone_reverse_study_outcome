package la;

/* loaded from: classes.dex */
public final class f0 implements s0, j, ma.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u0 f5918f;

    public f0(u0 u0Var) {
        this.f5918f = u0Var;
    }

    @Override // ma.o
    public final j E(g7.l lVar, int i2, ka.a aVar) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || aVar != ka.a.f5662g) ? k0.m(this, lVar, i2, aVar) : this;
    }

    @Override // la.s0
    public final Object getValue() {
        return this.f5918f.getValue();
    }

    @Override // la.j
    public final Object x(k kVar, g7.d dVar) throws Throwable {
        this.f5918f.x(kVar, dVar);
        return h7.a.f4212f;
    }
}
