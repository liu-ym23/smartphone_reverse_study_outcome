package com.byted.cast.common.threadpool;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public class CastThreadExecutorsUtils {
    private static final int DEFAULT_QUENE_LENGTH = 128;
    private static final String TAG = null;

    public static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService mExecutorService;

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.mExecutorService.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.mExecutorService.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.mExecutorService.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.mExecutorService.shutdownNow();
        }

        public DelegatedExecutorService(ExecutorService r100) {
            this.mExecutorService = r100;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mExecutorService.execute(r100);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
            return this.mExecutorService.awaitTermination(r100, r101);
        }
    }

    public static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f33722e;

        public DelegatedScheduledExecutorService(ScheduledExecutorService r100) {
            super(r100);
            this.f33722e = r100;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102) {
            return this.f33722e.schedule(r100, r101, r102);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
            return this.f33722e.schedule(r100, r101, r102);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r110, TimeUnit r111) {
            return this.f33722e.scheduleAtFixedRate(r100, r101, r110, r111);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r110, TimeUnit r111) {
            return this.f33722e.scheduleWithFixedDelay(r100, r101, r110, r111);
        }
    }

    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        public void finalize() {
            super.shutdown();
        }

        public FinalizableDelegatedExecutorService(ExecutorService r100) {
            super(r100);
        }
    }

    static {
        TAG = "CastThreadExecutorsUtils";
    }

    public static ExecutorService newCachedThreadPool() {
        return new CastThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new CastThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128)));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService(new PThreadScheduledThreadPoolExecutor(1, new DefaultThreadFactory("CastThreadExecutorsUtils")));
    }

    private CastThreadExecutorsUtils() {
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory r100) {
        return new CastThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r100);
    }

    public static ExecutorService newFixedThreadPool(int r100) {
        return new CastThreadPoolExecutor(r100, r100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r100) {
        return new CastScheduledThreadPoolExecutor(r100);
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory r110) {
        return new FinalizableDelegatedExecutorService(new CastThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), r110));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory r100) {
        return new DelegatedScheduledExecutorService(new PThreadScheduledThreadPoolExecutor(1, r100));
    }

    public static ExecutorService newFixedThreadPool(int r100, ThreadFactory r110) {
        return new CastThreadPoolExecutor(r100, r100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), r110);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int r100, ThreadFactory r101) {
        return new CastScheduledThreadPoolExecutor(r100, r101);
    }
}
