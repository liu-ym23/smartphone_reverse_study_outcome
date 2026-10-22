package D2;

import com.google.android.gms.common.internal.C1669j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class l {
    public static <TResult> TResult a(i<TResult> iVar) throws ExecutionException, InterruptedException {
        C1669j.i();
        C1669j.g();
        C1669j.l(iVar, "Task must not be null");
        if (iVar.k()) {
            return (TResult) e(iVar);
        }
        o oVar = new o(null);
        f(iVar, oVar);
        oVar.c();
        return (TResult) e(iVar);
    }

    public static <TResult> i<TResult> b() {
        G g10 = new G();
        g10.p();
        return g10;
    }

    public static <TResult> i<TResult> c(Exception exc) {
        G g10 = new G();
        g10.n(exc);
        return g10;
    }

    public static <TResult> i<TResult> d(TResult tresult) {
        G g10 = new G();
        g10.o(tresult);
        return g10;
    }

    public static Object e(i iVar) throws ExecutionException {
        if (iVar.l()) {
            return iVar.i();
        }
        if (iVar.j()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(iVar.h());
    }

    public static void f(i iVar, p pVar) {
        Executor executor = k.f2219b;
        iVar.g(executor, pVar);
        iVar.e(executor, pVar);
        iVar.a(executor, pVar);
    }
}
