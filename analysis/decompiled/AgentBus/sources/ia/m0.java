package ia;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class m0 extends pa.i {

    /* renamed from: h, reason: collision with root package name */
    public int f4976h;

    public m0(int i2) {
        super(0L, false);
        this.f4976h = i2;
    }

    public void c(CancellationException cancellationException) {
    }

    public abstract g7.d d();

    public Throwable e(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            return vVar.f5011a;
        }
        return null;
    }

    public Object g(Object obj) {
        return obj;
    }

    public final void i(Throwable th) {
        d0.n(d().getContext(), new c7.i("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            g7.d dVarD = d();
            q7.k.c(dVarD, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            na.g gVar = (na.g) dVarD;
            i7.c cVar = gVar.f6901j;
            Object obj = gVar.f6903l;
            g7.l context = cVar.getContext();
            Object objN = na.b.n(context, obj);
            g1 g1Var = null;
            e2 e2VarA = objN != na.b.f6890d ? d0.A(cVar, context, objN) : null;
            try {
                g7.l context2 = cVar.getContext();
                Object objJ = j();
                Throwable thE = e(objJ);
                if (thE == null) {
                    int i2 = this.f4976h;
                    boolean z4 = true;
                    if (i2 != 1 && i2 != 2) {
                        z4 = false;
                    }
                    if (z4) {
                        g1Var = (g1) context2.o(z.f5027g);
                    }
                }
                if (g1Var != null && !g1Var.b()) {
                    CancellationException cancellationExceptionE = g1Var.E();
                    c(cancellationExceptionE);
                    cVar.resumeWith(w7.e0.n(cancellationExceptionE));
                } else if (thE != null) {
                    cVar.resumeWith(w7.e0.n(thE));
                } else {
                    cVar.resumeWith(g(objJ));
                }
                if (e2VarA == null || e2VarA.p0()) {
                    na.b.g(context, objN);
                }
            } catch (Throwable th) {
                if (e2VarA == null || e2VarA.p0()) {
                    na.b.g(context, objN);
                }
                throw th;
            }
        } catch (k0 e10) {
            d0.n(d().getContext(), e10.f4965f);
        } catch (Throwable th2) {
            i(th2);
        }
    }
}
