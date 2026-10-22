package com.stepos.statsapp.v3.lib.plugin.utils.thread;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class ScheduledExecutor implements Executor {
    private static final String TAG = "ScheduledExecutor";
    private final ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, new ThreadFactory() { // from class: com.stepos.statsapp.v3.lib.plugin.utils.thread.ScheduledExecutor.1
        private final AtomicInteger threadCount = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (this.threadCount.get() == Integer.MAX_VALUE) {
                this.threadCount.set(0);
            }
            return new Thread(runnable, "ScheduleTask#" + this.threadCount.getAndIncrement());
        }
    }, new RejectedExecutionHandler() { // from class: com.stepos.statsapp.v3.lib.plugin.utils.thread.b
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.e(ScheduledExecutor.TAG, "Exceeded ThreadPoolExecutor pool size");
        }
    });

    public static class InnerSingleton {
        private static final ScheduledExecutor sInstance = new ScheduledExecutor();

        private InnerSingleton() {
        }
    }

    public static ScheduledExecutor getInstance() {
        return InnerSingleton.sInstance;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.threadPool.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public ScheduledFuture<?> schedule(long j10, TimeUnit timeUnit, Runnable runnable) {
        return this.threadPool.schedule(runnable, j10, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(long j10, long j11, TimeUnit timeUnit, Runnable runnable) {
        return this.threadPool.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
    }
}
