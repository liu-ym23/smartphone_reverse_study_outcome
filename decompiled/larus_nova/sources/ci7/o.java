package ci7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f23878a = null;

    static {
        f23878a = new o();
    }

    public o() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap<Class<?>, di7.d> r100 = w.f23890a;     // Catch: Throwable -> L6
        ei7.a r101 = (ei7.a) w.b(ei7.a.class);     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.d();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
