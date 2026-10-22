package b0;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public final class y0 implements k2, CoroutineExceptionHandler {

    /* renamed from: f, reason: collision with root package name */
    public final g7.l f1427f;

    /* renamed from: g, reason: collision with root package name */
    public final p7.n f1428g;

    /* renamed from: h, reason: collision with root package name */
    public final na.d f1429h;

    /* renamed from: i, reason: collision with root package name */
    public ia.w1 f1430i;

    public y0(g7.l lVar, p7.n nVar) {
        this.f1427f = lVar;
        this.f1428g = nVar;
        this.f1429h = ia.d0.b(lVar.Q(lVar.o(m0.c.f6123g) != null ? this : g7.m.f3866f));
    }

    @Override // g7.l
    public final g7.l Q(g7.l lVar) {
        return ia.y.plus(this, lVar);
    }

    @Override // b0.k2
    public final void c() {
        ia.w1 w1Var = this.f1430i;
        if (w1Var != null) {
            CancellationException cancellationException = new CancellationException("Old job was still running!");
            cancellationException.initCause(null);
            w1Var.d(cancellationException);
        }
        this.f1430i = ia.d0.s(this.f1429h, null, null, this.f1428g, 3);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void e(g7.l lVar, Throwable th) throws Throwable {
        m0.c cVar = (m0.c) lVar.o(m0.c.f6123g);
        if (cVar != null) {
            s7.a.m0(th, new c2(2, cVar, this));
        }
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) this.f1427f.o(ia.z.f5026f);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.e(lVar, th);
    }

    @Override // b0.k2
    public final void f() {
        ia.w1 w1Var = this.f1430i;
        if (w1Var != null) {
            w1Var.C(new n0(1));
        }
        this.f1430i = null;
    }

    @Override // g7.j
    public final g7.k getKey() {
        return ia.z.f5026f;
    }

    @Override // b0.k2
    public final void h() {
        ia.w1 w1Var = this.f1430i;
        if (w1Var != null) {
            w1Var.C(new n0(1));
        }
        this.f1430i = null;
    }

    @Override // g7.l
    public final g7.j o(g7.k kVar) {
        return ia.y.get(this, kVar);
    }

    @Override // g7.l
    public final Object r(Object obj, p7.n nVar) {
        return ia.y.fold(this, obj, nVar);
    }

    @Override // g7.l
    public final g7.l z(g7.k kVar) {
        return ia.y.minusKey(this, kVar);
    }
}
