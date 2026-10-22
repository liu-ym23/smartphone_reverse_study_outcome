package c6;

import a6.i0;
import a6.i1;
import a6.o0;
import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o extends a6.a implements p, g {
    public final c d;

    public o(f5.h hVar, c cVar) {
        super(hVar, true);
        this.d = cVar;
    }

    @Override // c6.q
    public final Object c(h5.i iVar) {
        return this.d.c(iVar);
    }

    @Override // c6.r
    public final Object d(f5.c cVar, Object obj) {
        return this.d.d(cVar, obj);
    }

    @Override // a6.p1, a6.h1
    public final void e(CancellationException cancellationException) throws o0 {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new i1(D(), null, this);
        }
        y(cancellationException);
    }

    @Override // c6.r
    public final boolean f(Throwable th) {
        return this.d.j(th, false);
    }

    @Override // a6.a
    public final void f0(Throwable th, boolean z) {
        if (this.d.j(th, false) || z) {
            return;
        }
        i0.n(this.f128c, th);
    }

    @Override // a6.a
    public final void g0(Object obj) throws o0 {
        this.d.f(null);
    }

    @Override // c6.q
    public final Object i() {
        return this.d.i();
    }

    @Override // c6.q
    public final b iterator() {
        c cVar = this.d;
        cVar.getClass();
        return new b(cVar);
    }

    @Override // c6.r
    public final Object k(Object obj) {
        return this.d.k(obj);
    }

    @Override // a6.p1
    public final void y(CancellationException cancellationException) throws o0 {
        this.d.j(cancellationException, true);
        x(cancellationException);
    }
}
