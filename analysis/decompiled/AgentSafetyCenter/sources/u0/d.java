package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: e, reason: collision with root package name */
    public final xb.l f13648e;

    /* renamed from: f, reason: collision with root package name */
    public final f f13649f;

    public d(long j10, k kVar, xb.l lVar, f fVar) {
        super(j10, kVar);
        this.f13648e = lVar;
        this.f13649f = fVar;
        fVar.k();
    }

    @Override // u0.f
    public final void c() {
        f fVar = this.f13649f;
        if (this.f13654c) {
            return;
        }
        if (this.f13653b != fVar.g()) {
            a();
        }
        fVar.l();
        this.f13654c = true;
        synchronized (m.f13676c) {
            o();
        }
    }

    @Override // u0.f
    public final xb.l e() {
        return this.f13648e;
    }

    @Override // u0.f
    public final boolean f() {
        return true;
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
    public final void n(v vVar) {
        t0.d dVar = m.f13674a;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override // u0.f
    public final f u(xb.l lVar) {
        return new d(this.f13653b, this.f13652a, m.l(lVar, this.f13648e, true), this.f13649f);
    }

    @Override // u0.f
    public final void m() {
    }
}
