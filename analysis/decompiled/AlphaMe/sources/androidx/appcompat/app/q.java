package androidx.appcompat.app;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import q.C0818b;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2673a;

    /* renamed from: b, reason: collision with root package name */
    public static final q.g f2674b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f2675c;

    static {
        new ArrayDeque();
        f2673a = -100;
        f2674b = new q.g(0);
        f2675c = new Object();
    }

    public static void a(F f4) {
        synchronized (f2675c) {
            try {
                q.g gVar = f2674b;
                gVar.getClass();
                C0818b c0818b = new C0818b(gVar);
                while (c0818b.hasNext()) {
                    q qVar = (q) ((WeakReference) c0818b.next()).get();
                    if (qVar == f4 || qVar == null) {
                        c0818b.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
