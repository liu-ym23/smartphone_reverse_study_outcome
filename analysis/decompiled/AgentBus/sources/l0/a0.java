package l0;

/* loaded from: classes.dex */
public final class a0 extends f {

    /* renamed from: e, reason: collision with root package name */
    public final f f5727e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5728f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5729g;

    /* renamed from: h, reason: collision with root package name */
    public p7.k f5730h;

    /* renamed from: i, reason: collision with root package name */
    public final long f5731i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(f fVar, p7.k kVar, boolean z4, boolean z10) {
        p7.k kVarE;
        super(0L, k.f5764j);
        c6.d dVar = m.f5772a;
        this.f5727e = fVar;
        this.f5728f = z4;
        this.f5729g = z10;
        this.f5730h = m.l(kVar, (fVar == null || (kVarE = fVar.e()) == null) ? m.f5781j.f5733e : kVarE, z4);
        this.f5731i = j0.i.b();
    }

    @Override // l0.f
    public final void c() {
        f fVar;
        this.f5750c = true;
        if (!this.f5729g || (fVar = this.f5727e) == null) {
            return;
        }
        fVar.c();
    }

    @Override // l0.f
    public final k d() {
        return v().d();
    }

    @Override // l0.f
    public final p7.k e() {
        return this.f5730h;
    }

    @Override // l0.f
    public final boolean f() {
        return v().f();
    }

    @Override // l0.f
    public final long g() {
        return v().g();
    }

    @Override // l0.f
    public final p7.k i() {
        return null;
    }

    @Override // l0.f
    public final void k() {
        r.j();
        throw null;
    }

    @Override // l0.f
    public final void l() {
        r.j();
        throw null;
    }

    @Override // l0.f
    public final void m() {
        v().m();
    }

    @Override // l0.f
    public final void n(v vVar) {
        v().n(vVar);
    }

    @Override // l0.f
    public final f u(p7.k kVar) {
        p7.k kVarL = m.l(kVar, this.f5730h, true);
        return !this.f5728f ? m.h(v().u(null), kVarL, true) : v().u(kVarL);
    }

    public final f v() {
        f fVar = this.f5727e;
        return fVar == null ? m.f5781j : fVar;
    }
}
