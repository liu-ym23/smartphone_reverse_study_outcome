package com.baidu.naviapi.okhttp;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes39.dex */
public final class TaskExecutor {
    private static final int CPU_COUNT = 0;

    public static final class Pool {
        private static final ExecutorService CPU = null;
        private static final ExecutorService IO = null;
        private static final ScheduledExecutorService SCHEDULED = null;
        private static final ExecutorService SINGLE = null;

        public static class NamedThreadFactory implements ThreadFactory {
            private final AtomicInteger mCount;
            private final String name;

            public NamedThreadFactory(String r100) {
                this.mCount = new AtomicInteger(1);
                this.name = r100;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r100) {
                return new PthreadThreadV2(r100, this.name + "#" + this.mCount.getAndIncrement());
            }
        }

        static {
            int r100 = TaskExecutor.access$400();
            int r101 = (TaskExecutor.access$400() * 2) + 1;
            TimeUnit r110 = TimeUnit.SECONDS;
            IO = new PThreadPoolExecutor(r100, r101, 5, r110, new LinkedBlockingQueue(), new NamedThreadFactory("ex-io-pool"));
            CPU = new PThreadPoolExecutor(TaskExecutor.access$400(), TaskExecutor.access$400() + 1, 5, r110, new LinkedBlockingQueue(128), new NamedThreadFactory("ex-cpu-pool"));
            SINGLE = PThreadExecutorsUtils.newSingleThreadExecutor(new NamedThreadFactory("ex-single-pool"));
            SCHEDULED = new PThreadScheduledThreadPoolExecutor(TaskExecutor.access$400(), new NamedThreadFactory("ex-scheduled-pool"));
        }

        private Pool() {
        }

        public static /* synthetic */ ExecutorService access$000() {
            return IO;
        }

        public static /* synthetic */ ExecutorService access$100() {
            return CPU;
        }

        public static /* synthetic */ ExecutorService access$200() {
            return SINGLE;
        }

        public static /* synthetic */ ScheduledExecutorService access$300() {
            return SCHEDULED;
        }
    }

    static {
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
    }

    private TaskExecutor() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ int access$400() {
        return CPU_COUNT;
    }

    public static void cpu(Runnable r100) {
        Pool.access$100().execute(r100);
    }

    public static void ensureUI(Runnable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
        r100.run();
        return;
    L7:
        ui(r100);
    }

    public static <T> Future<T> io(Callable<T> r100) {
        return Pool.access$000().submit(r100);
    }

    public static void single(Runnable r100) {
        Pool.access$200().execute(r100);
    }

    public static void ui(Runnable r100) {
        new Handler(Looper.getMainLooper()).post(r100);
    }

    public static void io(Runnable r100) {
        Pool.access$000().execute(r100);
    }

    public static void schedule(Runnable r100, long r101) {
        Pool.access$300().schedule(r100, r101, TimeUnit.MILLISECONDS);
    }

    public static void ui(Runnable r100, long r101) {
        new Handler(Looper.getMainLooper()).postDelayed(r100, r101);
    }
}
