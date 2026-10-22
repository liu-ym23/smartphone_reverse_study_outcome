package com.blankj.utilcode.util;

import android.util.Log;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class g extends ThreadPoolExecutor implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2206a;
    public final ThreadUtils$LinkedBlockingQueue4Util b;

    public g(int i, int i6, long j5, TimeUnit timeUnit, ThreadUtils$LinkedBlockingQueue4Util threadUtils$LinkedBlockingQueue4Util, ThreadFactory threadFactory) {
        super(i, i6, j5, timeUnit, threadUtils$LinkedBlockingQueue4Util, threadFactory);
        this.f2206a = new AtomicInteger();
        threadUtils$LinkedBlockingQueue4Util.f2198a = this;
        this.b = threadUtils$LinkedBlockingQueue4Util;
    }

    public static g b() {
        return new g(0, 128, 60L, TimeUnit.SECONDS, new ThreadUtils$LinkedBlockingQueue4Util(0), new ThreadUtils$UtilsThreadFactory("cached"));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        this.f2206a.decrementAndGet();
        super.afterExecute(runnable, th);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() throws InterruptedException {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z10 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z10) {
                    shutdownNow();
                    z10 = true;
                }
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (isShutdown()) {
            return;
        }
        AtomicInteger atomicInteger = this.f2206a;
        atomicInteger.incrementAndGet();
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException unused) {
            Log.e("ThreadUtils", "This will not happen!");
            this.b.offer(runnable);
        } catch (Throwable unused2) {
            atomicInteger.decrementAndGet();
        }
    }
}
