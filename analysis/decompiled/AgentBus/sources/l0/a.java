package l0;

import b0.w0;

/* loaded from: classes.dex */
public final class a extends b {
    @Override // l0.b
    public final b C(p7.k kVar, p7.k kVar2) {
        return (b) ((f) m.f(new a5.a(11, new w0(2, kVar, kVar2))));
    }

    @Override // l0.b, l0.f
    public final void c() {
        synchronized (m.f5774c) {
            o();
        }
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
        m.a();
    }

    @Override // l0.b, l0.f
    public final f u(p7.k kVar) {
        return (e) ((f) m.f(new a5.a(11, new c6.i(4, kVar))));
    }

    @Override // l0.b
    public final r w() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }
}
