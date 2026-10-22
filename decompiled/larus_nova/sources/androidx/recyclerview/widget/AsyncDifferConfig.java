package androidx.recyclerview.widget;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public final class AsyncDifferConfig<T> {
    private final Executor mBackgroundThreadExecutor;
    private final DiffUtil.ItemCallback<T> mDiffCallback;
    private final Executor mMainThreadExecutor;

    public static final class Builder<T> {
        private static Executor sDiffExecutor;
        private static final Object sExecutorLock = null;
        private Executor mBackgroundThreadExecutor;
        private final DiffUtil.ItemCallback<T> mDiffCallback;
        private Executor mMainThreadExecutor;

        static {
            sExecutorLock = new Object();
            sDiffExecutor = null;
        }

        public AsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor != null) goto L15;
            Object r100 = sExecutorLock;
            monitor-enter(r100);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sDiffExecutor != null) goto L9;
            sDiffExecutor = PThreadExecutorsUtils.newFixedThreadPool(2, new DefaultThreadFactory("AsyncDifferConfig$Builder"));     // Catch: Throwable -> L11
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
            this.mBackgroundThreadExecutor = sDiffExecutor;
        L15:
            return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        }

        public Builder(DiffUtil.ItemCallback<T> r100) {
            this.mDiffCallback = r100;
        }

        public Builder<T> setBackgroundThreadExecutor(Executor r100) {
            this.mBackgroundThreadExecutor = r100;
            return this;
        }

        public Builder<T> setMainThreadExecutor(Executor r100) {
            this.mMainThreadExecutor = r100;
            return this;
        }
    }

    public Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.mDiffCallback;
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public AsyncDifferConfig(Executor r100, Executor r101, DiffUtil.ItemCallback<T> r102) {
        this.mMainThreadExecutor = r100;
        this.mBackgroundThreadExecutor = r101;
        this.mDiffCallback = r102;
    }
}
