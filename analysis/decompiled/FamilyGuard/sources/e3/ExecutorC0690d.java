package e3;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: e3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ExecutorC0690d implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f16707a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, new a(), new RejectedExecutionHandler() { // from class: e3.c
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e("ScheduledExecutor", "Exceeded ThreadPoolExecutor pool size");
        }
    });

    /* renamed from: e3.d$a */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f16708a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (this.f16708a.get() == Integer.MAX_VALUE) {
                this.f16708a.set(0);
            }
            return new Thread(runnable, "ScheduleTask#" + this.f16708a.getAndIncrement());
        }
    }

    /* renamed from: e3.d$b */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final ExecutorC0690d f16710a = new ExecutorC0690d();
    }

    public static ExecutorC0690d b() {
        return b.f16710a;
    }

    public ScheduledFuture<?> c(long j5, TimeUnit timeUnit, Runnable runnable) {
        return this.f16707a.schedule(runnable, j5, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f16707a.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }
}
