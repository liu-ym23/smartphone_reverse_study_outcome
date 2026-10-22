package v9;

/* loaded from: classes.dex */
public final class o extends s0 {

    /* renamed from: b, reason: collision with root package name */
    public final s0 f10576b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f10577c;

    public o(s0 s0Var, s0 s0Var2) {
        this.f10576b = s0Var;
        this.f10577c = s0Var2;
    }

    @Override // v9.s0
    public final boolean a() {
        return this.f10576b.a() || this.f10577c.a();
    }

    @Override // v9.s0
    public final boolean b() {
        return this.f10576b.b() || this.f10577c.b();
    }

    @Override // v9.s0
    public final g8.j c(g8.j jVar) {
        q7.k.e(jVar, "annotations");
        return this.f10577c.c(this.f10576b.c(jVar));
    }

    @Override // v9.s0
    public final p0 d(v vVar) {
        p0 p0VarD = this.f10576b.d(vVar);
        return p0VarD == null ? this.f10577c.d(vVar) : p0VarD;
    }

    @Override // v9.s0
    public final v f(int i2, v vVar) {
        q7.k.e(vVar, "topLevelType");
        m.x.t(i2, "position");
        return this.f10577c.f(i2, this.f10576b.f(i2, vVar));
    }
}
