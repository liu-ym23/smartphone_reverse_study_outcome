package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmediateFuture<V> implements ListenableFuture<V> {
    private static final String TAG = "ImmediateFuture";

    public static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable mCause;

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.mCause);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.mCause + "]]";
        }

        public ImmediateFailedFuture(Throwable r100) {
            this.mCause = r100;
        }
    }

    public static final class ImmediateFailedScheduledFuture<V> extends ImmediateFailedFuture<V> implements ScheduledFuture<V> {
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Delayed r100) {
            return -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit r100) {
            return 0;
        }

        public ImmediateFailedScheduledFuture(Throwable r100) {
            super(r100);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Delayed r100) {
            return compareTo2(r100);
        }
    }

    public static final class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateFuture<Object> NULL_FUTURE = null;
        private final V mValue;

        static {
            NULL_FUTURE = new ImmediateSuccessfulFuture(null);
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.mValue + "]]";
        }

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.mValue;
        }

        public ImmediateSuccessfulFuture(V r100) {
            this.mValue = r100;
        }
    }

    public ImmediateFuture() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public static <V> ListenableFuture<V> nullFuture() {
        return ImmediateSuccessfulFuture.NULL_FUTURE;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        r101.execute(r100);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "Experienced RuntimeException while attempting to notify " + r100 + " on Executor " + r101, e);
    }

    @Override // java.util.concurrent.Future
    public V get(long r100, TimeUnit r101) throws ExecutionException {
        Preconditions.checkNotNull(r101);
        return get();
    }
}
