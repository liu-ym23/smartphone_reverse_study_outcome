package s4;

import V3.n;
import java.util.concurrent.CancellationException;
import x4.C1298J;
import x4.C1310j;

/* loaded from: classes.dex */
public abstract class U<T> extends z4.h {

    /* renamed from: c, reason: collision with root package name */
    public int f20322c;

    public U(int i5) {
        this.f20322c = i5;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract Z3.e<T> g();

    public Throwable i(Object obj) {
        C1096y c1096y = obj instanceof C1096y ? (C1096y) obj : null;
        if (c1096y != null) {
            return c1096y.f20398a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T j(Object obj) {
        return obj;
    }

    public final void k(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            V3.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        j4.k.d(th);
        C1058G.a(g().getContext(), new L("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object l();

    @Override // java.lang.Runnable
    public final void run() {
        Object objA;
        Object objA2;
        z4.i iVar = this.f24116b;
        try {
            Z3.e<T> eVarG = g();
            j4.k.e(eVarG, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C1310j c1310j = (C1310j) eVarG;
            Z3.e<T> eVar = c1310j.f23858e;
            Object obj = c1310j.f23860g;
            Z3.i context = eVar.getContext();
            Object objC = C1298J.c(context, obj);
            J0<?> j0G = objC != C1298J.f23835a ? C1055D.g(eVar, context, objC) : null;
            try {
                Z3.i context2 = eVar.getContext();
                Object objL = l();
                Throwable thI = i(objL);
                n0 n0Var = (thI == null && V.b(this.f20322c)) ? (n0) context2.a(n0.f20363P) : null;
                if (n0Var != null && !n0Var.c()) {
                    CancellationException cancellationExceptionW = n0Var.w();
                    a(objL, cancellationExceptionW);
                    n.a aVar = V3.n.f5531a;
                    eVar.resumeWith(V3.n.a(V3.o.a(cancellationExceptionW)));
                } else if (thI != null) {
                    n.a aVar2 = V3.n.f5531a;
                    eVar.resumeWith(V3.n.a(V3.o.a(thI)));
                } else {
                    n.a aVar3 = V3.n.f5531a;
                    eVar.resumeWith(V3.n.a(j(objL)));
                }
                V3.v vVar = V3.v.f5542a;
                if (j0G == null || j0G.N0()) {
                    C1298J.a(context, objC);
                }
                try {
                    iVar.a();
                    objA2 = V3.n.a(V3.v.f5542a);
                } catch (Throwable th) {
                    n.a aVar4 = V3.n.f5531a;
                    objA2 = V3.n.a(V3.o.a(th));
                }
                k(null, V3.n.b(objA2));
            } catch (Throwable th2) {
                if (j0G == null || j0G.N0()) {
                    C1298J.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                n.a aVar5 = V3.n.f5531a;
                iVar.a();
                objA = V3.n.a(V3.v.f5542a);
            } catch (Throwable th4) {
                n.a aVar6 = V3.n.f5531a;
                objA = V3.n.a(V3.o.a(th4));
            }
            k(th3, V3.n.b(objA));
        }
    }
}
