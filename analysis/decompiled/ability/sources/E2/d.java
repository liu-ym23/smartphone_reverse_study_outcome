package E2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class d implements ThreadFactory {
    public static final AtomicInteger d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public final ThreadGroup f457a;
    public final AtomicInteger b = new AtomicInteger(1);
    public final String c;

    public d(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f457a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, "-");
        sbX.append(d.getAndIncrement());
        sbX.append("-Thread-");
        this.c = sbX.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f457a, runnable, this.c + this.b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
