package ia;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class f1 {
    public static /* synthetic */ void cancel$default(g1 g1Var, CancellationException cancellationException, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        g1Var.d(cancellationException);
    }

    public static <R> R fold(g1 g1Var, R r10, p7.n nVar) {
        return (R) g7.i.fold(g1Var, r10, nVar);
    }

    public static <E extends g7.j> E get(g1 g1Var, g7.k kVar) {
        return (E) g7.i.get(g1Var, kVar);
    }

    public static /* synthetic */ void getParent$annotations() {
    }

    public static /* synthetic */ p0 invokeOnCompletion$default(g1 g1Var, boolean z4, boolean z10, p7.k kVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
        if ((i2 & 1) != 0) {
            z4 = false;
        }
        if ((i2 & 2) != 0) {
            z10 = true;
        }
        return g1Var.i(z4, z10, kVar);
    }

    public static g7.l minusKey(g1 g1Var, g7.k kVar) {
        return g7.i.minusKey(g1Var, kVar);
    }

    public static g7.l plus(g1 g1Var, g7.l lVar) {
        return g7.i.plus(g1Var, lVar);
    }

    public static /* synthetic */ boolean cancel$default(g1 g1Var, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i2 & 1) != 0) {
            th = null;
        }
        return g1Var.a(th);
    }

    @c7.a
    public static g1 plus(g1 g1Var, g1 g1Var2) {
        return g1Var2;
    }
}
