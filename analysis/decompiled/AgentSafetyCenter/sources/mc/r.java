package mc;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kc.w;
import kc.y0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends kc.a implements i, t {

    /* renamed from: h, reason: collision with root package name */
    public e f8603h;

    @Override // mc.i
    public final Object a(pb.i iVar) {
        return this.f8603h.a(iVar);
    }

    @Override // kc.a
    public final void a0(Throwable th, boolean z10) {
        if (this.f8603h.l(th, false) || z10) {
            return;
        }
        w.p(this.f7414g, th);
    }

    @Override // mc.i
    public final Object b() {
        return this.f8603h.b();
    }

    @Override // kc.a
    public final void b0(Object obj) {
        this.f8603h.k(null);
    }

    @Override // mc.i
    public final Object c(oc.o oVar) {
        e eVar = this.f8603h;
        eVar.getClass();
        Object objC = e.C(eVar, oVar);
        ob.a aVar = ob.a.f9351c;
        return objC;
    }

    public final void d0(j9.f fVar) {
        pc.t tVar;
        e eVar = this.f8603h;
        eVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f8570n;
        if (atomicReferenceFieldUpdater.compareAndSet(eVar, null, fVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(eVar);
            tVar = g.f8588q;
            if (obj != tVar) {
                if (obj == g.f8589r) {
                    od.f.e("Another handler was already registered and successfully invoked");
                    return;
                } else {
                    g5.f.n(obj, "Another handler is already registered: ");
                    return;
                }
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(eVar, tVar, g.f8589r));
        fVar.invoke(eVar.q());
    }

    @Override // kc.e1, kc.x0
    public final void e(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new y0(w(), null, this);
        }
        u(cancellationException);
    }

    @Override // mc.t
    public final Object h(Object obj) {
        return this.f8603h.h(obj);
    }

    @Override // mc.i
    public final b iterator() {
        return this.f8603h.iterator();
    }

    @Override // mc.t
    public final Object j(Object obj, nb.c cVar) {
        return this.f8603h.j(obj, cVar);
    }

    @Override // kc.e1
    public final void u(CancellationException cancellationException) {
        this.f8603h.l(cancellationException, true);
        t(cancellationException);
    }
}
