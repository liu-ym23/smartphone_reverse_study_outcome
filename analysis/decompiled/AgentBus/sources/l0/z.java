package l0;

import k.b0;

/* loaded from: classes.dex */
public final class z extends b {

    /* renamed from: o, reason: collision with root package name */
    public final b f5819o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f5820p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f5821q;

    /* renamed from: r, reason: collision with root package name */
    public p7.k f5822r;

    /* renamed from: s, reason: collision with root package name */
    public p7.k f5823s;

    /* renamed from: t, reason: collision with root package name */
    public final long f5824t;

    /* JADX WARN: Illegal instructions before constructor call */
    public z(b bVar, p7.k kVar, p7.k kVar2, boolean z4, boolean z10) {
        p7.k kVarI;
        p7.k kVarE;
        c6.d dVar = m.f5772a;
        super(0L, k.f5764j, m.l(kVar, (bVar == null || (kVarE = bVar.e()) == null) ? m.f5781j.f5733e : kVarE, z4), m.b(kVar2, (bVar == null || (kVarI = bVar.i()) == null) ? m.f5781j.f5734f : kVarI));
        this.f5819o = bVar;
        this.f5820p = z4;
        this.f5821q = z10;
        this.f5822r = this.f5733e;
        this.f5823s = this.f5734f;
        this.f5824t = j0.i.b();
    }

    @Override // l0.b
    public final void B(b0 b0Var) {
        r.j();
        throw null;
    }

    @Override // l0.b
    public final b C(p7.k kVar, p7.k kVar2) {
        p7.k kVarL = m.l(kVar, this.f5822r, true);
        p7.k kVarB = m.b(kVar2, this.f5823s);
        return !this.f5820p ? new z(D().C(null, kVarB), kVarL, kVarB, false, true) : D().C(kVarL, kVarB);
    }

    public final b D() {
        b bVar = this.f5819o;
        return bVar == null ? m.f5781j : bVar;
    }

    @Override // l0.b, l0.f
    public final void c() {
        b bVar;
        this.f5750c = true;
        if (!this.f5821q || (bVar = this.f5819o) == null) {
            return;
        }
        bVar.c();
    }

    @Override // l0.f
    public final k d() {
        return D().d();
    }

    @Override // l0.b, l0.f
    public final p7.k e() {
        return this.f5822r;
    }

    @Override // l0.b, l0.f
    public final boolean f() {
        return D().f();
    }

    @Override // l0.f
    public final long g() {
        return D().g();
    }

    @Override // l0.b, l0.f
    public final int h() {
        return D().h();
    }

    @Override // l0.b, l0.f
    public final p7.k i() {
        return this.f5823s;
    }

    @Override // l0.b, l0.f
    public final void k() {
        r.j();
        throw null;
    }

    @Override // l0.b, l0.f
    public final void l() {
        r.j();
        throw null;
    }

    @Override // l0.b, l0.f
    public final void m() {
        D().m();
    }

    @Override // l0.b, l0.f
    public final void n(v vVar) {
        D().n(vVar);
    }

    @Override // l0.f
    public final void r(k kVar) {
        r.j();
        throw null;
    }

    @Override // l0.f
    public final void s(long j2) {
        r.j();
        throw null;
    }

    @Override // l0.b, l0.f
    public final void t(int i2) {
        D().t(i2);
    }

    @Override // l0.b, l0.f
    public final f u(p7.k kVar) {
        p7.k kVarL = m.l(kVar, this.f5822r, true);
        return !this.f5820p ? m.h(D().u(null), kVarL, true) : D().u(kVarL);
    }

    @Override // l0.b
    public final r w() {
        return D().w();
    }

    @Override // l0.b
    public final b0 x() {
        return D().x();
    }

    @Override // l0.b
    /* renamed from: y */
    public final p7.k e() {
        return this.f5822r;
    }
}
