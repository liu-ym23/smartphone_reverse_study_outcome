package m9;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutinesInternalError;
import s9.AbstractC1921a;
import s9.C1925e;

/* renamed from: m9.G, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1689G extends u9.h {
    public int c;

    public AbstractC1689G(int i) {
        super(0L, false);
        this.c = i;
    }

    public void i(CancellationException cancellationException) {
    }

    public abstract H7.c k();

    public Throwable m(Object obj) {
        C1727t c1727t = obj instanceof C1727t ? (C1727t) obj : null;
        if (c1727t != null) {
            return c1727t.f5333a;
        }
        return null;
    }

    public Object n(Object obj) {
        return obj;
    }

    public final void o(Throwable th) {
        AbstractC1683A.k(k().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object p();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            H7.c cVarK = k();
            kotlin.jvm.internal.k.d(cVarK, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C1925e c1925e = (C1925e) cVarK;
            H7.c cVar = c1925e.e;
            Object obj = c1925e.g;
            H7.h context = cVar.getContext();
            Object objL = AbstractC1921a.l(context, obj);
            c0 c0Var = null;
            w0 w0VarV = objL != AbstractC1921a.d ? AbstractC1683A.v(cVar, context, objL) : null;
            try {
                H7.h context2 = cVar.getContext();
                Object objP = p();
                Throwable thM = m(objP);
                if (thM == null) {
                    int i = this.c;
                    boolean z10 = true;
                    if (i != 1 && i != 2) {
                        z10 = false;
                    }
                    if (z10) {
                        c0Var = (c0) context2.get(b0.f5325a);
                    }
                }
                if (c0Var != null && !c0Var.isActive()) {
                    CancellationException cancellationExceptionI = c0Var.i();
                    i(cancellationExceptionI);
                    cVar.resumeWith(kotlin.b.a(cancellationExceptionI));
                } else if (thM != null) {
                    cVar.resumeWith(kotlin.b.a(thM));
                } else {
                    cVar.resumeWith(n(objP));
                }
                if (w0VarV != null && !w0VarV.j0()) {
                    return;
                }
                AbstractC1921a.g(context, objL);
            } catch (Throwable th) {
                if (w0VarV == null || w0VarV.j0()) {
                    AbstractC1921a.g(context, objL);
                }
                throw th;
            }
        } catch (Throwable th2) {
            o(th2);
        }
    }
}
