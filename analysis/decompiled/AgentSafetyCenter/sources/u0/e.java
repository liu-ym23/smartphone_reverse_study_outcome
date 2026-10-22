package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: e, reason: collision with root package name */
    public xb.l f13650e;

    /* renamed from: f, reason: collision with root package name */
    public int f13651f;

    @Override // u0.f
    public final void c() {
        if (this.f13654c) {
            return;
        }
        l();
        this.f13654c = true;
        synchronized (m.f13676c) {
            o();
        }
    }

    @Override // u0.f
    public final xb.l e() {
        return this.f13650e;
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
        this.f13651f++;
    }

    @Override // u0.f
    public final void l() {
        int i = this.f13651f - 1;
        this.f13651f = i;
        if (i == 0) {
            a();
        }
    }

    @Override // u0.f
    public final void n(v vVar) {
        t0.d dVar = m.f13674a;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override // u0.f
    public final f u(xb.l lVar) {
        m.d(this);
        return new d(this.f13653b, this.f13652a, m.l(lVar, this.f13650e, true), this);
    }

    @Override // u0.f
    public final void m() {
    }
}
