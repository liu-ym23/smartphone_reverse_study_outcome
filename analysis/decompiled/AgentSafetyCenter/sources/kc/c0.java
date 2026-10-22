package kc;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c0 extends rc.h {

    /* renamed from: g, reason: collision with root package name */
    public int f7419g;

    public c0(int i) {
        super(0L, false);
        this.f7419g = i;
    }

    public abstract nb.c c();

    public Throwable d(Object obj) {
        n nVar = obj instanceof n ? (n) obj : null;
        if (nVar != null) {
            return nVar.f7461a;
        }
        return null;
    }

    public final void g(Throwable th) {
        w.p(c().getContext(), new v("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            nb.c cVarC = c();
            cVarC.getClass();
            pc.f fVar = (pc.f) cVarC;
            pb.c cVar = fVar.i;
            Object obj = fVar.f9958k;
            nb.g context = cVar.getContext();
            Object objL = pc.a.l(context, obj);
            x0 x0Var = null;
            r1 r1VarD = objL != pc.a.f9946d ? w.D(cVar, context, objL) : null;
            try {
                nb.g context2 = cVar.getContext();
                Object objH = h();
                Throwable thD = d(objH);
                if (thD == null) {
                    int i = this.f7419g;
                    boolean z10 = true;
                    if (i != 1 && i != 2) {
                        z10 = false;
                    }
                    if (z10) {
                        x0Var = (x0) context2.get(w0.f7498c);
                    }
                }
                if (x0Var != null && !x0Var.d()) {
                    CancellationException cancellationExceptionO = x0Var.o();
                    b(cancellationExceptionO);
                    cVar.resumeWith(id.c.l(cancellationExceptionO));
                } else if (thD != null) {
                    cVar.resumeWith(id.c.l(thD));
                } else {
                    cVar.resumeWith(e(objH));
                }
                if (r1VarD != null && !r1VarD.d0()) {
                    return;
                }
                pc.a.g(context, objL);
            } catch (Throwable th) {
                if (r1VarD == null || r1VarD.d0()) {
                    pc.a.g(context, objL);
                }
                throw th;
            }
        } catch (Throwable th2) {
            g(th2);
        }
    }

    public void b(CancellationException cancellationException) {
    }

    public Object e(Object obj) {
        return obj;
    }
}
