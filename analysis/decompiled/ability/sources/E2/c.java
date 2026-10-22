package E2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class c implements ThreadFactory {
    public static final AtomicInteger d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public final ThreadGroup f456a;
    public final AtomicInteger b = new AtomicInteger(1);
    public final String c;

    public c() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f456a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.c = "TTBackgroundExecutors-" + d.getAndIncrement() + "-Thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        b bVar = new b(this.f456a, runnable, this.c + this.b.getAndIncrement(), 0L);
        if (bVar.isDaemon()) {
            bVar.setDaemon(false);
        }
        return bVar;
    }
}
