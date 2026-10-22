package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
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

/* JADX INFO: loaded from: classes2.dex */
final class HandlerScheduledExecutorService extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal<ScheduledExecutorService> sThreadLocalInstance;
    private final Handler mHandler;

    public static class HandlerScheduledFuture<V> implements RunnableScheduledFuture<V> {
        final AtomicReference<CallbackToFutureAdapter.Completer<V>> mCompleter;
        private final ListenableFuture<V> mDelegate;
        private final long mRunAtMillis;
        private final Callable<V> mTask;

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public V get() throws ExecutionException, InterruptedException {
            return this.mDelegate.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.mDelegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.mDelegate.isDone();
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            CallbackToFutureAdapter.Completer r100 = this.mCompleter.getAndSet(null);
            if (r100 == null) goto L11;
            r100.set(this.mTask.call());     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            r100.setException(e);
            return;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean r100) {
            return this.mDelegate.cancel(r100);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Delayed r100) {
            TimeUnit r101 = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(r101), r100.getDelay(r101));
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit r100) {
            return r100.convert(this.mRunAtMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Delayed r100) {
            return compareTo2(r100);
        }

        @Override // java.util.concurrent.Future
        public V get(long r100, TimeUnit r101) throws ExecutionException, InterruptedException, TimeoutException {
            return this.mDelegate.get(r100, r101);
        }

        public HandlerScheduledFuture(final Handler r100, long r101, final Callable<V> r102) {
            this.mCompleter = new AtomicReference(null);
            this.mRunAtMillis = r101;
            this.mTask = r102;
            this.mDelegate = CallbackToFutureAdapter.getFuture(new AnonymousClass1(this, r100, r102));
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

    static {
        sThreadLocalInstance = new AnonymousClass1();
    }

    private RejectedExecutionException createPostFailedException() {
        return new RejectedExecutionException(this.mHandler + " is shutting down");
    }

    public static ScheduledExecutorService currentThreadExecutor() {
        ScheduledExecutorService r100 = sThreadLocalInstance.get();
        if (r100 != null) goto L9;
        Looper r101 = Looper.myLooper();
        if (r101 == null) goto L8;
        HandlerScheduledExecutorService r102 = new HandlerScheduledExecutorService(new Handler(r101));
        sThreadLocalInstance.set(r102);
        return r102;
    L8:
        throw new IllegalStateException("Current thread has no looper!");
    L9:
        return r100;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService cannot be shut down. Use Looper.quitSafely().");
    }

    public HandlerScheduledExecutorService(Handler r100) {
        this.mHandler = r100;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (this.mHandler.post(r100) == false) goto L6;
        return;
    L6:
        throw createPostFailedException();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r100, TimeUnit r101) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
        long r103 = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(r101, r102);
        HandlerScheduledFuture r104 = new HandlerScheduledFuture(this.mHandler, r103, r100);
        if (this.mHandler.postAtTime(r104, r103) == false) goto L6;
        return r104;
    L6:
        return Futures.immediateFailedScheduledFuture(createPostFailedException());
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(final Runnable r100, long r101, TimeUnit r102) {
        return schedule(new AnonymousClass2(this, r100), r101, r102);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r102, TimeUnit r103) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService does not yet support fixed-rate scheduling.");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r102, TimeUnit r103) {
        throw new UnsupportedOperationException("HandlerScheduledExecutorService does not yet support fixed-delay scheduling.");
    }
}
