package r3;

import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: r3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5207a {

    /* renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f38758a = new ReferenceQueue();

    /* renamed from: b, reason: collision with root package name */
    public final Set f38759b = Collections.synchronizedSet(new HashSet());

    /* renamed from: r3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0515a {
        void clean();
    }

    public static C5207a a() {
        C5207a c5207a = new C5207a();
        c5207a.b(c5207a, new Runnable() { // from class: r3.n
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        final ReferenceQueue referenceQueue = c5207a.f38758a;
        final Set set = c5207a.f38759b;
        Thread thread = new Thread(new Runnable() { // from class: r3.o
            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = referenceQueue;
                while (!set.isEmpty()) {
                    try {
                        ((q) referenceQueue2.remove()).clean();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return c5207a;
    }

    public InterfaceC0515a b(Object obj, Runnable runnable) {
        q qVar = new q(obj, this.f38758a, this.f38759b, runnable, null);
        this.f38759b.add(qVar);
        return qVar;
    }
}
