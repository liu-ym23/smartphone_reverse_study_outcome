package u0;

import p.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends b {

    /* renamed from: o, reason: collision with root package name */
    public final b f13719o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f13720p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f13721q;

    /* renamed from: r, reason: collision with root package name */
    public xb.l f13722r;

    /* renamed from: s, reason: collision with root package name */
    public xb.l f13723s;

    /* renamed from: t, reason: collision with root package name */
    public final long f13724t;

    /* JADX WARN: Illegal instructions before constructor call */
    public z(b bVar, xb.l lVar, xb.l lVar2, boolean z10, boolean z11) {
        xb.l lVarI;
        xb.l lVarE;
        t0.d dVar = m.f13674a;
        super(0L, k.i, m.l(lVar, (bVar == null || (lVarE = bVar.e()) == null) ? m.f13682j.f13638e : lVarE, z10), m.b(lVar2, (bVar == null || (lVarI = bVar.i()) == null) ? m.f13682j.f13639f : lVarI));
        this.f13719o = bVar;
        this.f13720p = z10;
        this.f13721q = z11;
        this.f13722r = this.f13638e;
        this.f13723s = this.f13639f;
        this.f13724t = s0.h.b();
    }

    @Override // u0.b
    public final void B(g0 g0Var) {
        r.k();
        throw null;
    }

    @Override // u0.b
    public final b C(xb.l lVar, xb.l lVar2) {
        xb.l lVarL = m.l(lVar, this.f13722r, true);
        xb.l lVarB = m.b(lVar2, this.f13723s);
        return !this.f13720p ? new z(D().C(null, lVarB), lVarL, lVarB, false, true) : D().C(lVarL, lVarB);
    }

    public final b D() {
        b bVar = this.f13719o;
        return bVar == null ? m.f13682j : bVar;
    }

    @Override // u0.b, u0.f
    public final void c() {
        b bVar;
        this.f13654c = true;
        if (!this.f13721q || (bVar = this.f13719o) == null) {
            return;
        }
        bVar.c();
    }

    @Override // u0.f
    public final k d() {
        return D().d();
    }

    @Override // u0.b, u0.f
    public final xb.l e() {
        return this.f13722r;
    }

    @Override // u0.b, u0.f
    public final boolean f() {
        return D().f();
    }

    @Override // u0.f
    public final long g() {
        return D().g();
    }

    @Override // u0.b, u0.f
    public final int h() {
        return D().h();
    }

    @Override // u0.b, u0.f
    public final xb.l i() {
        return this.f13723s;
    }

    @Override // u0.b, u0.f
    public final void k() {
        r.k();
        throw null;
    }

    @Override // u0.b, u0.f
    public final void l() {
        r.k();
        throw null;
    }

    @Override // u0.b, u0.f
    public final void m() {
        D().m();
    }

    @Override // u0.b, u0.f
    public final void n(v vVar) {
        D().n(vVar);
    }

    @Override // u0.f
    public final void r(k kVar) {
        r.k();
        throw null;
    }

    @Override // u0.f
    public final void s(long j10) {
        r.k();
        throw null;
    }

    @Override // u0.b, u0.f
    public final void t(int i) {
        D().t(i);
    }

    @Override // u0.b, u0.f
    public final f u(xb.l lVar) {
        xb.l lVarL = m.l(lVar, this.f13722r, true);
        return !this.f13720p ? m.h(D().u(null), lVarL, true) : D().u(lVarL);
    }

    @Override // u0.b
    public final r w() {
        return D().w();
    }

    @Override // u0.b
    public final g0 x() {
        return D().x();
    }

    @Override // u0.b
    /* renamed from: y */
    public final xb.l e() {
        return this.f13722r;
    }
}
