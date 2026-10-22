package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends f {

    /* renamed from: e, reason: collision with root package name */
    public final f f13633e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f13634f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13635g;

    /* renamed from: h, reason: collision with root package name */
    public xb.l f13636h;
    public final long i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(f fVar, xb.l lVar, boolean z10, boolean z11) {
        xb.l lVarE;
        super(0L, k.i);
        t0.d dVar = m.f13674a;
        this.f13633e = fVar;
        this.f13634f = z10;
        this.f13635g = z11;
        this.f13636h = m.l(lVar, (fVar == null || (lVarE = fVar.e()) == null) ? m.f13682j.f13638e : lVarE, z10);
        this.i = s0.h.b();
    }

    @Override // u0.f
    public final void c() {
        f fVar;
        this.f13654c = true;
        if (!this.f13635g || (fVar = this.f13633e) == null) {
            return;
        }
        fVar.c();
    }

    @Override // u0.f
    public final k d() {
        return v().d();
    }

    @Override // u0.f
    public final xb.l e() {
        return this.f13636h;
    }

    @Override // u0.f
    public final boolean f() {
        return v().f();
    }

    @Override // u0.f
    public final long g() {
        return v().g();
    }

    @Override // u0.f
    public final xb.l i() {
        return null;
    }

    @Override // u0.f
    public final void k() {
        r.k();
        throw null;
    }

    @Override // u0.f
    public final void l() {
        r.k();
        throw null;
    }

    @Override // u0.f
    public final void m() {
        v().m();
    }

    @Override // u0.f
    public final void n(v vVar) {
        v().n(vVar);
    }

    @Override // u0.f
    public final f u(xb.l lVar) {
        xb.l lVarL = m.l(lVar, this.f13636h, true);
        return !this.f13634f ? m.h(v().u(null), lVarL, true) : v().u(lVarL);
    }

    public final f v() {
        f fVar = this.f13633e;
        return fVar == null ? m.f13682j : fVar;
    }
}
