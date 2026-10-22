package s4;

import i4.InterfaceC0772l;
import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class s0 {

    /* synthetic */ class a extends j4.j implements InterfaceC0772l<Throwable, V3.v> {
        a(Object obj) {
            super(1, obj, InterfaceC1081k0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        @Override // i4.InterfaceC0772l
        public /* bridge */ /* synthetic */ V3.v invoke(Throwable th) {
            j(th);
            return V3.v.f5542a;
        }

        public final void j(Throwable th) {
            ((InterfaceC1081k0) this.f17818b).a(th);
        }
    }

    public static final InterfaceC1094w a(n0 n0Var) {
        return new q0(n0Var);
    }

    public static /* synthetic */ InterfaceC1094w b(n0 n0Var, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            n0Var = null;
        }
        return r0.a(n0Var);
    }

    public static final void c(Z3.i iVar, CancellationException cancellationException) {
        n0 n0Var = (n0) iVar.a(n0.f20363P);
        if (n0Var != null) {
            n0Var.X(cancellationException);
        }
    }

    public static /* synthetic */ void d(Z3.i iVar, CancellationException cancellationException, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cancellationException = null;
        }
        r0.c(iVar, cancellationException);
    }

    public static final void e(Z3.i iVar) {
        n0 n0Var = (n0) iVar.a(n0.f20363P);
        if (n0Var != null) {
            r0.f(n0Var);
        }
    }

    public static final void f(n0 n0Var) {
        if (!n0Var.c()) {
            throw n0Var.w();
        }
    }

    public static final X g(n0 n0Var, boolean z5, boolean z6, InterfaceC1081k0 interfaceC1081k0) {
        return n0Var instanceof u0 ? ((u0) n0Var).h0(z5, z6, interfaceC1081k0) : n0Var.x(z5, z6, new a(interfaceC1081k0));
    }

    public static /* synthetic */ X h(n0 n0Var, boolean z5, boolean z6, InterfaceC1081k0 interfaceC1081k0, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = true;
        }
        return r0.g(n0Var, z5, z6, interfaceC1081k0);
    }
}
