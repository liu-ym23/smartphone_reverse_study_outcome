package k0;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w0 implements a2, kc.r {

    /* renamed from: c, reason: collision with root package name */
    public final nb.g f7096c;

    /* renamed from: f, reason: collision with root package name */
    public final xb.p f7097f;

    /* renamed from: g, reason: collision with root package name */
    public final pc.c f7098g;

    /* renamed from: h, reason: collision with root package name */
    public kc.z f7099h;

    public w0(nb.g gVar, xb.p pVar) {
        this.f7096c = gVar;
        this.f7097f = pVar;
        this.f7098g = kc.w.a(gVar.plus(gVar.get(v0.b.f14317f) != null ? this : nb.h.f8811c));
    }

    @Override // k0.a2
    public final void a() {
        kc.z zVar = this.f7099h;
        if (zVar != null) {
            zVar.u(new n0(1));
        }
        this.f7099h = null;
    }

    @Override // k0.a2
    public final void b() {
        kc.z zVar = this.f7099h;
        if (zVar != null) {
            zVar.u(new n0(1));
        }
        this.f7099h = null;
    }

    @Override // k0.a2
    public final void c() {
        kc.z zVar = this.f7099h;
        if (zVar != null) {
            CancellationException cancellationException = new CancellationException("Old job was still running!");
            cancellationException.initCause(null);
            zVar.e(cancellationException);
        }
        this.f7099h = kc.w.u(this.f7098g, null, null, this.f7097f, 3);
    }

    @Override // nb.g
    public final Object fold(Object obj, xb.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // nb.g
    public final nb.e get(nb.f fVar) {
        return ac.a.t(this, fVar);
    }

    @Override // nb.e
    public final nb.f getKey() {
        return kc.q.f7473c;
    }

    @Override // kc.r
    public final void handleException(nb.g gVar, Throwable th) throws Throwable {
        v0.b bVar = (v0.b) gVar.get(v0.b.f14317f);
        if (bVar != null) {
            bVar.a(th, this);
        }
        kc.r rVar = (kc.r) this.f7096c.get(kc.q.f7473c);
        if (rVar == null) {
            throw th;
        }
        rVar.handleException(gVar, th);
    }

    @Override // nb.g
    public final nb.g minusKey(nb.f fVar) {
        return ac.a.H(this, fVar);
    }

    @Override // nb.g
    public final nb.g plus(nb.g gVar) {
        return ac.a.N(this, gVar);
    }
}
