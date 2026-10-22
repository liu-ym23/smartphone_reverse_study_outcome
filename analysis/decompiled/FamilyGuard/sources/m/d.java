package m;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f18806a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f18807b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f18808c;

    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f18809a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f18809a.getAndIncrement());
            return thread;
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private static Handler e(Looper looper) {
        return b.a(looper);
    }

    @Override // m.e
    public void a(Runnable runnable) {
        this.f18807b.execute(runnable);
    }

    @Override // m.e
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // m.e
    public void d(Runnable runnable) {
        if (this.f18808c == null) {
            synchronized (this.f18806a) {
                try {
                    if (this.f18808c == null) {
                        this.f18808c = e(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f18808c.post(runnable);
    }
}
