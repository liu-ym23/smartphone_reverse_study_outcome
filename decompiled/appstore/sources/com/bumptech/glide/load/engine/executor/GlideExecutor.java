package com.bumptech.glide.load.engine.executor;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {
    private static final String ANIMATION_EXECUTOR_NAME = "animation";
    private static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    private static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    private static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final long KEEP_ALIVE_TIME_MS = 0;
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    public static final class DefaultThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;
        private final String name;
        final boolean preventNetworkOperations;
        private int threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public DefaultThreadFactory(String r10, UncaughtThrowableStrategy r11, boolean r12) {
            this.name = r10;
            this.uncaughtThrowableStrategy = r11;
            this.preventNetworkOperations = r12;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull final Runnable r10) {
            monitor-enter(this);
            final String r11 = "glide-" + this.name + "-thread-" + this.threadNum;     // Catch: Throwable -> L6
            Thread r12 = new AnonymousClass1(this, r10, r11);     // Catch: Throwable -> L6
            this.threadNum++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r12;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT = null;
        public static final UncaughtThrowableStrategy IGNORE = null;
        public static final UncaughtThrowableStrategy LOG = null;
        public static final UncaughtThrowableStrategy THROW = null;

        static {
            IGNORE = new AnonymousClass1();
            UncaughtThrowableStrategy r10 = new AnonymousClass2();
            LOG = r10;
            THROW = new AnonymousClass3();
            DEFAULT = r10;
        }

        void handle(Throwable r10);
    }

    static {
        KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    }

    @VisibleForTesting
    public GlideExecutor(ExecutorService r10) {
        this.delegate = r10;
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount != 0) goto L6;
        bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
    L6:
        return bestThreadCount;
    }

    public static GlideExecutor newAnimationExecutor() {
        if (calculateBestThreadCount() < 4) goto L5;
        int r10 = 2;
    L7:
        return newAnimationExecutor(r10, UncaughtThrowableStrategy.DEFAULT);
    L5:
        r10 = 1;
        goto L7
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceExecutor(calculateBestThreadCount(), "source", UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Channel.UNLIMITED, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r10, @NonNull TimeUnit r11) throws InterruptedException {
        return this.delegate.awaitTermination(r10, r11);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable r10) {
        this.delegate.execute(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> r10) throws InterruptedException {
        return this.delegate.invokeAll(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> r10) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable r10) {
        return this.delegate.submit(r10);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy r10) {
        return newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, r10);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> r10, long r11, @NonNull TimeUnit r12) throws InterruptedException {
        return this.delegate.invokeAll(r10, r11, r12);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> r10, long r11, @NonNull TimeUnit r12) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(r10, r11, r12);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable r10, T r11) {
        return this.delegate.submit(r10, r11);
    }

    public static GlideExecutor newAnimationExecutor(int r10, UncaughtThrowableStrategy r11) {
        return new GlideExecutor(new ThreadPoolExecutor(0, r10, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(ANIMATION_EXECUTOR_NAME, r11, true)));
    }

    public static GlideExecutor newDiskCacheExecutor(int r10, String r11, UncaughtThrowableStrategy r12) {
        return new GlideExecutor(new ThreadPoolExecutor(r10, r10, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(r11, r12, true)));
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy r10) {
        return newSourceExecutor(calculateBestThreadCount(), "source", r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> r10) {
        return this.delegate.submit(r10);
    }

    public static GlideExecutor newSourceExecutor(int r10, String r11, UncaughtThrowableStrategy r12) {
        return new GlideExecutor(new ThreadPoolExecutor(r10, r10, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(r11, r12, false)));
    }
}
