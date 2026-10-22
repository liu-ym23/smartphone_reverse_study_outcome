package N;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import s.C5424F;

/* loaded from: classes.dex */
public final class c extends AbstractExecutorService implements ScheduledExecutorService, AutoCloseable {

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal<ScheduledExecutorService> f4764b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f4765a;

    public class a extends ThreadLocal<ScheduledExecutorService> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return N.a.d();
            }
            if (Looper.myLooper() != null) {
                return new c(new Handler(Looper.myLooper()));
            }
            return null;
        }
    }

    public class b implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f4766a;

        public b(Runnable runnable) {
            this.f4766a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            this.f4766a.run();
            return null;
        }
    }

    /* renamed from: N.c$c, reason: collision with other inner class name */
    public static class RunnableScheduledFutureC0084c<V> implements RunnableScheduledFuture<V> {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReference<CallbackToFutureAdapter.a<V>> f4768a = new AtomicReference<>(null);

        /* renamed from: b, reason: collision with root package name */
        public final long f4769b;

        /* renamed from: c, reason: collision with root package name */
        public final Callable<V> f4770c;

        /* renamed from: d, reason: collision with root package name */
        public final InterfaceFutureC4095a<V> f4771d;

        /* renamed from: N.c$c$a */
        public class a implements CallbackToFutureAdapter.b<V> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Handler f4772a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Callable f4773b;

            /* renamed from: N.c$c$a$a, reason: collision with other inner class name */
            public class RunnableC0085a implements Runnable {
                public RunnableC0085a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (RunnableScheduledFutureC0084c.this.f4768a.getAndSet(null) != null) {
                        a aVar = a.this;
                        aVar.f4772a.removeCallbacks(RunnableScheduledFutureC0084c.this);
                    }
                }
            }

            public a(Handler handler, Callable callable) {
                this.f4772a = handler;
                this.f4773b = callable;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public Object a(CallbackToFutureAdapter.a<V> aVar) throws RejectedExecutionException {
                aVar.a(new RunnableC0085a(), N.a.a());
                RunnableScheduledFutureC0084c.this.f4768a.set(aVar);
                return "HandlerScheduledFuture-" + this.f4773b.toString();
            }
        }

        public RunnableScheduledFutureC0084c(Handler handler, long j10, Callable<V> callable) {
            this.f4769b = j10;
            this.f4770c = callable;
            this.f4771d = CallbackToFutureAdapter.a(new a(handler, callable));
        }

        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return this.f4771d.cancel(z10);
        }

        @Override // java.util.concurrent.Future
        public V get() throws ExecutionException, InterruptedException {
            return this.f4771d.get();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.f4769b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f4771d.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f4771d.isDone();
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return false;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            CallbackToFutureAdapter.a andSet = this.f4768a.getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.c(this.f4770c.call());
                } catch (Exception e10) {
                    andSet.f(e10);
                }
            }
        }

        @Override // java.util.concurrent.Future
        public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f4771d.get(j10, timeUnit);
        }
    }

    public c(Handler handler) {
        this.f4765a = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    public final RejectedExecutionException b() {
        return new RejectedExecutionException(this.f4765a + " is shutting down");
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() throws InterruptedException {
        C5424F.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (!this.f4765a.post(runnable)) {
            throw b();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return schedule(new b(runnable), j10, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException(c.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
        long jUptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j10, timeUnit);
        RunnableScheduledFutureC0084c runnableScheduledFutureC0084c = new RunnableScheduledFutureC0084c(this.f4765a, jUptimeMillis, callable);
        return this.f4765a.postAtTime(runnableScheduledFutureC0084c, jUptimeMillis) ? runnableScheduledFutureC0084c : O.f.g(b());
    }
}
