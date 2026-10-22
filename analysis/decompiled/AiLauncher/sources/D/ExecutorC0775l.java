package D;

import D.ExecutorC0775l;
import K.InterfaceC0897u;
import android.os.Process;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import s.C5424F;

/* renamed from: D.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ExecutorC0775l implements Executor, ScheduledExecutorService, AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadFactory f2134c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Object f2135a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f2136b = e();

    /* renamed from: D.l$a */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f2137a = new AtomicInteger(0);

        public static /* synthetic */ void a(Runnable runnable) throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-3);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Thread thread = new Thread(new Runnable() { // from class: D.k
                @Override // java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    ExecutorC0775l.a.a(runnable);
                }
            });
            thread.setPriority(7);
            thread.setName(String.format(Locale.US, "CameraX-core_camera_%d", Integer.valueOf(this.f2137a.getAndIncrement())));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor e() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, f2134c);
        scheduledThreadPoolExecutor.setKeepAliveTime(0L, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: D.j
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                C0761b0.o("CameraExecutor", "A rejected execution occurred in CameraExecutor!");
            }
        });
        return scheduledThreadPoolExecutor;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean zAwaitTermination;
        synchronized (this.f2135a) {
            zAwaitTermination = this.f2136b.awaitTermination(j10, timeUnit);
        }
        return zAwaitTermination;
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() throws InterruptedException {
        C5424F.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        B0.h.f(runnable);
        synchronized (this.f2135a) {
            this.f2136b.execute(runnable);
        }
    }

    public void g() {
        synchronized (this.f2135a) {
            try {
                if (!this.f2136b.isShutdown()) {
                    this.f2136b.shutdown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(InterfaceC0897u interfaceC0897u) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        B0.h.f(interfaceC0897u);
        synchronized (this.f2135a) {
            try {
                if (this.f2136b.isShutdown()) {
                    this.f2136b = e();
                }
                scheduledThreadPoolExecutor = this.f2136b;
            } catch (Throwable th) {
                throw th;
            }
        }
        scheduledThreadPoolExecutor.setCorePoolSize(Math.max(1, interfaceC0897u.c().size()));
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        List<Future<T>> listInvokeAll;
        synchronized (this.f2135a) {
            listInvokeAll = this.f2136b.invokeAll(collection);
        }
        return listInvokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        T t10;
        synchronized (this.f2135a) {
            t10 = (T) this.f2136b.invokeAny(collection);
        }
        return t10;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        boolean zIsShutdown;
        synchronized (this.f2135a) {
            zIsShutdown = this.f2136b.isShutdown();
        }
        return zIsShutdown;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        boolean zIsTerminated;
        synchronized (this.f2135a) {
            zIsTerminated = this.f2136b.isTerminated();
        }
        return zIsTerminated;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFutureSchedule;
        synchronized (this.f2135a) {
            scheduledFutureSchedule = this.f2136b.schedule(runnable, j10, timeUnit);
        }
        return scheduledFutureSchedule;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFutureScheduleAtFixedRate;
        synchronized (this.f2135a) {
            scheduledFutureScheduleAtFixedRate = this.f2136b.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }
        return scheduledFutureScheduleAtFixedRate;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        synchronized (this.f2135a) {
            scheduledFutureScheduleWithFixedDelay = this.f2136b.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }
        return scheduledFutureScheduleWithFixedDelay;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        synchronized (this.f2135a) {
            this.f2136b.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        List<Runnable> listShutdownNow;
        synchronized (this.f2135a) {
            listShutdownNow = this.f2136b.shutdownNow();
        }
        return listShutdownNow;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        Future<T> futureSubmit;
        synchronized (this.f2135a) {
            futureSubmit = this.f2136b.submit(callable);
        }
        return futureSubmit;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        List<Future<T>> listInvokeAll;
        synchronized (this.f2135a) {
            listInvokeAll = this.f2136b.invokeAll(collection, j10, timeUnit);
        }
        return listInvokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        T t10;
        synchronized (this.f2135a) {
            t10 = (T) this.f2136b.invokeAny(collection, j10, timeUnit);
        }
        return t10;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
        ScheduledFuture<V> scheduledFutureSchedule;
        synchronized (this.f2135a) {
            scheduledFutureSchedule = this.f2136b.schedule(callable, j10, timeUnit);
        }
        return scheduledFutureSchedule;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t10) {
        Future<T> futureSubmit;
        synchronized (this.f2135a) {
            futureSubmit = this.f2136b.submit(runnable, t10);
        }
        return futureSubmit;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        Future<?> futureSubmit;
        synchronized (this.f2135a) {
            futureSubmit = this.f2136b.submit(runnable);
        }
        return futureSubmit;
    }
}
