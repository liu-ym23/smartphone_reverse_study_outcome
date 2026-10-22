package F0;

import X.g;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements ExecutorService, AutoCloseable {

    /* renamed from: b, reason: collision with root package name */
    private static final long f1618b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f1619c;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f1620a;

    /* renamed from: F0.a$a, reason: collision with other inner class name */
    private static final class ThreadFactoryC0021a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final String f1621a;

        /* renamed from: b, reason: collision with root package name */
        final b f1622b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f1623c;

        /* renamed from: d, reason: collision with root package name */
        private int f1624d;

        /* renamed from: F0.a$a$a, reason: collision with other inner class name */
        class C0022a extends Thread {
            C0022a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(9);
                if (ThreadFactoryC0021a.this.f1623c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    ThreadFactoryC0021a.this.f1622b.a(th);
                }
            }
        }

        ThreadFactoryC0021a(String str, b bVar, boolean z5) {
            this.f1621a = str;
            this.f1622b = bVar;
            this.f1623c = z5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            C0022a c0022a;
            c0022a = new C0022a(runnable, "glide-" + this.f1621a + "-thread-" + this.f1624d);
            this.f1624d = this.f1624d + 1;
            return c0022a;
        }
    }

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f1626a = new C0023a();

        /* renamed from: b, reason: collision with root package name */
        public static final b f1627b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f1628c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f1629d;

        /* renamed from: F0.a$b$a, reason: collision with other inner class name */
        class C0023a implements b {
            C0023a() {
            }

            @Override // F0.a.b
            public void a(Throwable th) {
            }
        }

        /* renamed from: F0.a$b$b, reason: collision with other inner class name */
        class C0024b implements b {
            C0024b() {
            }

            @Override // F0.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        class c implements b {
            c() {
            }

            @Override // F0.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0024b c0024b = new C0024b();
            f1627b = c0024b;
            f1628c = new c();
            f1629d = c0024b;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f1620a = executorService;
    }

    public static int a() {
        if (f1619c == 0) {
            f1619c = Math.min(4, F0.b.a());
        }
        return f1619c;
    }

    public static a c() {
        return m(a() >= 4 ? 2 : 1, b.f1629d);
    }

    public static a m(int i5, b bVar) {
        return new a(new ThreadPoolExecutor(0, i5, f1618b, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0021a("animation", bVar, true)));
    }

    public static a o() {
        return r(1, "disk-cache", b.f1629d);
    }

    public static a r(int i5, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i5, i5, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0021a(str, bVar, true)));
    }

    public static a u() {
        return v(a(), "source", b.f1629d);
    }

    public static a v(int i5, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i5, i5, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0021a(str, bVar, false)));
    }

    public static a w() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f1618b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0021a("source-unlimited", b.f1629d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j5, TimeUnit timeUnit) {
        return this.f1620a.awaitTermination(j5, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() throws InterruptedException {
        g.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1620a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f1620a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f1620a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f1620a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f1620a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f1620a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f1620a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f1620a.submit(runnable);
    }

    public String toString() {
        return this.f1620a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
        return this.f1620a.invokeAll(collection, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
        return (T) this.f1620a.invokeAny(collection, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t5) {
        return this.f1620a.submit(runnable, t5);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f1620a.submit(callable);
    }
}
