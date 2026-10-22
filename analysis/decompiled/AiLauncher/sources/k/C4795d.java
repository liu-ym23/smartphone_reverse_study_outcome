package k;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: k.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4795d extends AbstractC4796e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f34569a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f34570b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    public volatile Handler f34571c;

    /* renamed from: k.d$a */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f34572a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f34572a.getAndIncrement());
            return thread;
        }
    }

    /* renamed from: k.d$b */
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler d(Looper looper) {
        return b.a(looper);
    }

    @Override // k.AbstractC4796e
    public void a(Runnable runnable) {
        this.f34570b.execute(runnable);
    }

    @Override // k.AbstractC4796e
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // k.AbstractC4796e
    public void c(Runnable runnable) {
        if (this.f34571c == null) {
            synchronized (this.f34569a) {
                try {
                    if (this.f34571c == null) {
                        this.f34571c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f34571c.post(runnable);
    }
}
