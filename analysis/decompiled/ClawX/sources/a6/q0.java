package a6;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class q0 extends h6.i {

    /* renamed from: c, reason: collision with root package name */
    public int f209c;

    public q0(int i8) {
        super(0L, false);
        this.f209c = i8;
    }

    public abstract f5.c d();

    public Throwable e(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            return vVar.f222a;
        }
        return null;
    }

    public final void g(Throwable th) {
        i0.n(d().getContext(), new h0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            f5.c cVarD = d();
            kotlin.jvm.internal.p.c(cVarD, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            f6.e eVar = (f6.e) cVarD;
            h5.c cVar = eVar.f2638e;
            Object obj = eVar.f2640g;
            f5.h context = cVar.getContext();
            Object objN = f6.a.n(context, obj);
            h1 h1Var = null;
            e2 e2VarZ = objN != f6.a.d ? i0.z(cVar, context, objN) : null;
            try {
                f5.h context2 = cVar.getContext();
                Object objI = i();
                Throwable thE = e(objI);
                if (thE == null) {
                    int i8 = this.f209c;
                    boolean z = true;
                    if (i8 != 1 && i8 != 2) {
                        z = false;
                    }
                    if (z) {
                        h1Var = (h1) context2.o(c0.f143b);
                    }
                }
                if (h1Var != null && !h1Var.a()) {
                    CancellationException cancellationExceptionV = h1Var.v();
                    c(cancellationExceptionV);
                    cVar.resumeWith(a.a.o(cancellationExceptionV));
                } else if (thE != null) {
                    cVar.resumeWith(a.a.o(thE));
                } else {
                    cVar.resumeWith(f(objI));
                }
                if (e2VarZ == null || e2VarZ.j0()) {
                    f6.a.g(context, objN);
                }
            } catch (Throwable th) {
                if (e2VarZ == null || e2VarZ.j0()) {
                    f6.a.g(context, objN);
                }
                throw th;
            }
        } catch (o0 e9) {
            i0.n(d().getContext(), e9.f201a);
        } catch (Throwable th2) {
            g(th2);
        }
    }

    public void c(CancellationException cancellationException) {
    }

    public Object f(Object obj) {
        return obj;
    }
}
