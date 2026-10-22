package ka;

import ia.d0;
import ia.h1;
import ia.k0;
import ia.n1;
import ia.o1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class s extends ia.a implements t, k {

    /* renamed from: i, reason: collision with root package name */
    public final g f5719i;

    public s(g7.l lVar, g gVar) {
        super(lVar, true);
        this.f5719i = gVar;
    }

    @Override // ia.o1
    public final void C(CancellationException cancellationException) {
        CancellationException cancellationExceptionI0 = o1.i0(this, cancellationException);
        this.f5719i.h(cancellationExceptionI0, true);
        B(cancellationExceptionI0);
    }

    @Override // ia.o1, ia.g1
    public final /* synthetic */ boolean a(Throwable th) {
        C(new h1(F(), null, this));
        return true;
    }

    @Override // ka.x
    public final Object c(g7.d dVar) {
        return this.f5719i.c(dVar);
    }

    @Override // ia.o1, ia.g1
    public final void d(CancellationException cancellationException) {
        Object obj = o1.f4991f.get(this);
        if (obj instanceof ia.v) {
            return;
        }
        if ((obj instanceof n1) && ((n1) obj).e()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new h1(F(), null, this);
        }
        C(cancellationException);
    }

    @Override // ka.x
    public final b iterator() {
        g gVar = this.f5719i;
        gVar.getClass();
        return new b(gVar);
    }

    @Override // ka.z
    public final boolean j(Throwable th) {
        return this.f5719i.h(th, false);
    }

    @Override // ka.z
    public final Object l(g7.d dVar, Object obj) {
        return this.f5719i.l(dVar, obj);
    }

    @Override // ia.a
    public final void l0(Throwable th, boolean z4) {
        if (this.f5719i.h(th, false) || z4) {
            return;
        }
        d0.n(this.f4915h, th);
    }

    @Override // ia.a
    public final void m0(Object obj) {
        y.close$default(this.f5719i, null, 1, null);
    }

    public final void o0(c6.i iVar) {
        g gVar = this.f5719i;
        gVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f5685o;
        while (!atomicReferenceFieldUpdater.compareAndSet(gVar, null, iVar)) {
            if (atomicReferenceFieldUpdater.get(gVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(gVar);
                    f8.x xVar = i.f5704q;
                    if (obj != xVar) {
                        if (obj == i.f5705r) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    f8.x xVar2 = i.f5705r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, xVar, xVar2)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != xVar) {
                            break;
                        }
                    }
                    iVar.invoke(gVar.o());
                    return;
                }
            }
        }
    }

    @Override // ka.x
    public final Object p() {
        return this.f5719i.p();
    }

    @Override // ka.z
    public final Object u(Object obj) {
        return this.f5719i.u(obj);
    }

    @Override // ka.x
    public final Object v(w wVar) throws k0 {
        g gVar = this.f5719i;
        gVar.getClass();
        Object objD = g.D(gVar, wVar);
        h7.a aVar = h7.a.f4212f;
        return objD;
    }
}
