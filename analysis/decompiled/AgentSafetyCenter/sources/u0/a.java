package u0;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends b {
    @Override // u0.b
    public final b C(xb.l lVar, xb.l lVar2) {
        e9.w wVar = new e9.w(3);
        wVar.f3732f = lVar;
        wVar.f3733g = lVar2;
        VarHandle.storeStoreFence();
        l9.l lVar3 = new l9.l(2);
        lVar3.f7807f = wVar;
        VarHandle.storeStoreFence();
        return (b) ((f) m.f(lVar3));
    }

    @Override // u0.b, u0.f
    public final void c() {
        synchronized (m.f13676c) {
            o();
        }
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
        m.a();
    }

    @Override // u0.b, u0.f
    public final f u(xb.l lVar) {
        j9.f fVar = new j9.f(3);
        fVar.f6662f = lVar;
        VarHandle.storeStoreFence();
        l9.l lVar2 = new l9.l(2);
        lVar2.f7807f = fVar;
        VarHandle.storeStoreFence();
        return (e) ((f) m.f(lVar2));
    }

    @Override // u0.b
    public final r w() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }
}
