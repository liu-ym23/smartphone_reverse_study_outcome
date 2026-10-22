package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTaskExecutor extends TaskExecutor {
    private final ExecutorService mDiskIO;
    private final Object mLock;
    private volatile Handler mMainHandler;

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r100) {
            return Handler.createAsync(r100);
        }
    }

    public DefaultTaskExecutor() {
        this.mLock = new Object();
        this.mDiskIO = PThreadExecutorsUtils.newFixedThreadPool(4, new AnonymousClass1(this));
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    private static Handler createAsync(Looper r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r100, null, Boolean.TRUE});
    L11:
        return new Handler(r100);
    L9:
        return new Handler(r100);
    L5:
        return Api28Impl.createAsync(r100);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable r100) {
        this.mDiskIO.execute(r100);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable r100) {
        if (this.mMainHandler != null) goto L14;
        Object r101 = this.mLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mMainHandler != null) goto L9;
        this.mMainHandler = createAsync(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L14:
        this.mMainHandler.post(r100);
    }
}
