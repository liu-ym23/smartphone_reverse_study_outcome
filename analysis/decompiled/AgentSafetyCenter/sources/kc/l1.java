package kc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f7450a = new ThreadLocal();

    public static j0 a() {
        ThreadLocal threadLocal = f7450a;
        j0 j0Var = (j0) threadLocal.get();
        if (j0Var != null) {
            return j0Var;
        }
        Thread threadCurrentThread = Thread.currentThread();
        d dVar = new d();
        dVar.f7423m = threadCurrentThread;
        VarHandle.storeStoreFence();
        threadLocal.set(dVar);
        return dVar;
    }
}
