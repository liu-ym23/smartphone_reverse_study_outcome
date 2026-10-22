package T8;

import io.objectbox.BoxStore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import s.C5424F;

/* loaded from: classes4.dex */
public class d extends ThreadPoolExecutor implements AutoCloseable {

    /* renamed from: b, reason: collision with root package name */
    public static String f5871b = "ObjectBox-";

    /* renamed from: a, reason: collision with root package name */
    public final BoxStore f5872a;

    public static class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f5873d = new AtomicInteger();

        /* renamed from: a, reason: collision with root package name */
        public final ThreadGroup f5874a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5875b = d.f5871b + f5873d.incrementAndGet() + "-Thread-";

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f5876c = new AtomicInteger();

        public a() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f5874a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f5874a, runnable, this.f5875b + this.f5876c.incrementAndGet());
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }

    public d(BoxStore boxStore) {
        super(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new a());
        this.f5872a = boxStore;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this.f5872a.n();
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() throws InterruptedException {
        C5424F.a(this);
    }
}
