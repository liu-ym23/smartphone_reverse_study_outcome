package l0;

/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: e, reason: collision with root package name */
    public final p7.k f5744e;

    /* renamed from: f, reason: collision with root package name */
    public final f f5745f;

    public d(long j2, k kVar, p7.k kVar2, f fVar) {
        super(j2, kVar);
        this.f5744e = kVar2;
        this.f5745f = fVar;
        fVar.k();
    }

    @Override // l0.f
    public final void c() {
        f fVar = this.f5745f;
        if (this.f5750c) {
            return;
        }
        if (this.f5749b != fVar.g()) {
            a();
        }
        fVar.l();
        this.f5750c = true;
        synchronized (m.f5774c) {
            o();
        }
    }

    @Override // l0.f
    public final p7.k e() {
        return this.f5744e;
    }

    @Override // l0.f
    public final boolean f() {
        return true;
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
    }

    @Override // l0.f
    public final void n(v vVar) {
        c6.d dVar = m.f5772a;
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    @Override // l0.f
    public final f u(p7.k kVar) {
        return new d(this.f5749b, this.f5748a, m.l(kVar, this.f5744e, true), this.f5745f);
    }
}
