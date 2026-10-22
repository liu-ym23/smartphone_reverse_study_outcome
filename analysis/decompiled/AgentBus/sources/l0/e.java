package l0;

/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: e, reason: collision with root package name */
    public final p7.k f5746e;

    /* renamed from: f, reason: collision with root package name */
    public int f5747f;

    public e(long j2, k kVar, p7.k kVar2) {
        super(j2, kVar);
        this.f5746e = kVar2;
        this.f5747f = 1;
    }

    @Override // l0.f
    public final void c() {
        if (this.f5750c) {
            return;
        }
        l();
        this.f5750c = true;
        synchronized (m.f5774c) {
            o();
        }
    }

    @Override // l0.f
    public final p7.k e() {
        return this.f5746e;
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
        this.f5747f++;
    }

    @Override // l0.f
    public final void l() {
        int i2 = this.f5747f - 1;
        this.f5747f = i2;
        if (i2 == 0) {
            a();
        }
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
        m.d(this);
        return new d(this.f5749b, this.f5748a, m.l(kVar, this.f5746e, true), this);
    }
}
