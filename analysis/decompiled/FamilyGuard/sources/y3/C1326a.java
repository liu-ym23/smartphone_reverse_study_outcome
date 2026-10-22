package y3;

import B3.b;
import D3.h;
import java.util.concurrent.Callable;
import x3.p;

/* renamed from: y3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1326a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile h<Callable<p>, p> f23933a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile h<p, p> f23934b;

    static <T, R> R a(h<T, R> hVar, T t5) {
        try {
            return hVar.apply(t5);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static p b(h<Callable<p>, p> hVar, Callable<p> callable) {
        p pVar = (p) a(hVar, callable);
        if (pVar != null) {
            return pVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static p c(Callable<p> callable) {
        try {
            p pVarCall = callable.call();
            if (pVarCall != null) {
                return pVarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static p d(Callable<p> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<Callable<p>, p> hVar = f23933a;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    public static p e(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<p, p> hVar = f23934b;
        return hVar == null ? pVar : (p) a(hVar, pVar);
    }
}
