package com.bumptech.glide.load.engine.executor;

import android.text.TextUtils;
import com.bumptech.glide.monitor.GlideDispatcherMonitor;
import com.bumptech.glide.monitor.GlideMonitorSettings;
import com.bumptech.glide.monitor.GlideTask;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
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

/* JADX INFO: loaded from: classes39.dex */
public final class GlideExecutor implements ExecutorService {
    private static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    private static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    private static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    private static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = 0;
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private static final boolean sIsUseMonitor = false;
    private final ExecutorService delegate;

    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;
        private int corePoolSize;
        private int maximumPoolSize;
        private String name;
        private final boolean preventNetworkOperations;
        private long threadTimeoutMillis;
        private UncaughtThrowableStrategy uncaughtThrowableStrategy;
        private BlockingQueue<Runnable> workQueue;

        public GlideExecutor build() {
            if (TextUtils.isEmpty(this.name) == true) goto L13;
            PThreadPoolExecutor r100 = new PThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, this.workQueue, new DefaultThreadFactory(this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
            if (this.threadTimeoutMillis == 0) goto L8;
            r100.allowCoreThreadTimeOut(true);
        L8:
            if (GlideExecutor.access$000() == false) goto L11;
            GlideDispatcherMonitor.register(this.name, r100);
        L11:
            return new GlideExecutor(r100);
        L13:
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
        }

        public Builder(boolean r100) {
            this.uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;
            this.workQueue = new PriorityBlockingQueue();
            this.preventNetworkOperations = r100;
        }

        public Builder setName(String r100) {
            this.name = r100;
            return this;
        }

        public Builder setThreadCount(int r100) {
            this.corePoolSize = r100;
            this.maximumPoolSize = r100;
            return this;
        }

        public Builder setThreadTimeoutMillis(long r100) {
            this.threadTimeoutMillis = r100;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(UncaughtThrowableStrategy r100) {
            this.uncaughtThrowableStrategy = r100;
            return this;
        }

        public Builder setWorkQueue(BlockingQueue<Runnable> r100) {
            this.workQueue = r100;
            return this;
        }
    }

    public static final class DefaultThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;
        private final String name;
        final boolean preventNetworkOperations;
        private int threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(final Runnable r100) {
            monitor-enter(this);
            final String r101 = "glide-" + this.name + "-thread-" + this.threadNum;     // Catch: Throwable -> L7
            PthreadThreadV2 r102 = new AnonymousClass1(this, r100, r101);     // Catch: Throwable -> L7
            this.threadNum++;     // Catch: Throwable -> L7
            monitor-exit(this);
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public DefaultThreadFactory(String r100, UncaughtThrowableStrategy r101, boolean r102) {
            this.name = r100;
            this.uncaughtThrowableStrategy = r101;
            this.preventNetworkOperations = r102;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT = null;
        public static final UncaughtThrowableStrategy IGNORE = null;
        public static final UncaughtThrowableStrategy LOG = null;
        public static final UncaughtThrowableStrategy THROW = null;

        void handle(Throwable r100);

        static {
            IGNORE = new AnonymousClass1();
            UncaughtThrowableStrategy r100 = new AnonymousClass2();
            LOG = r100;
            THROW = new AnonymousClass3();
            DEFAULT = r100;
        }
    }

    static {
        KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
        boolean r100 = true;
        if (GlideMonitorSettings.getMonitor().getEnable() == 1) goto L6;
        r100 = false;
    L6:
        sIsUseMonitor = r100;
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount != 0) goto L6;
        bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
    L6:
        return bestThreadCount;
    }

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName("source");
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new PThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
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
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public static Builder newAnimationBuilder() {
        if (calculateBestThreadCount() < 4) goto L5;
        int r100 = 2;
    L7:
        return new Builder(true).setThreadCount(r100).setName("animation");
    L5:
        r100 = 1;
        goto L7
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    public static /* synthetic */ boolean access$000() {
        return sIsUseMonitor;
    }

    public GlideExecutor(ExecutorService r100) {
        this.delegate = r100;
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy r100) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(r100).build();
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy r100) {
        return newSourceBuilder().setUncaughtThrowableStrategy(r100).build();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (sIsUseMonitor == true) goto L5;
    L9:
        this.delegate.execute(r100);
        return;
    L5:
        if ((this.delegate instanceof ThreadPoolExecutor) == false) goto L9;
        if ((r100 instanceof IGlideExecutorTask) == false) goto L9;
        Object r101 = ((IGlideExecutorTask) r100).getLoadModel();
        ExecutorService r102 = this.delegate;
        r102.execute(new GlideTask((ThreadPoolExecutor) r102, r100, r101));
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100) throws InterruptedException {
        return this.delegate.invokeAll(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r100) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r100) {
        return this.delegate.submit(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r100) {
        return this.delegate.submit(r100);
    }

    public static GlideExecutor newAnimationExecutor(int r100, UncaughtThrowableStrategy r101) {
        return newAnimationBuilder().setThreadCount(r100).setUncaughtThrowableStrategy(r101).build();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        return this.delegate.awaitTermination(r100, r101);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r100, T r101) {
        return this.delegate.submit(r100, r101);
    }

    public static GlideExecutor newDiskCacheExecutor(int r100, String r101, UncaughtThrowableStrategy r102) {
        return newDiskCacheBuilder().setThreadCount(r100).setName(r101).setUncaughtThrowableStrategy(r102).build();
    }

    public static GlideExecutor newSourceExecutor(int r100, String r101, UncaughtThrowableStrategy r102) {
        return newSourceBuilder().setThreadCount(r100).setName(r101).setUncaughtThrowableStrategy(r102).build();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException {
        return this.delegate.invokeAll(r100, r101, r102);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(r100, r101, r102);
    }
}
