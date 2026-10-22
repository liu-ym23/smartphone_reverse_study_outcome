package androidx.camera.core;

import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class CameraExecutor implements Executor {
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final String TAG = "CameraExecutor";
    private static final ThreadFactory THREAD_FACTORY = null;
    private final Object mExecutorLock;
    private ThreadPoolExecutor mThreadPoolExecutor;

    public static /* synthetic */ void a(Runnable r100, ThreadPoolExecutor r101) {
        lambda$createExecutor$0(r100, r101);
    }

    static {
        THREAD_FACTORY = new AnonymousClass1();
    }

    private static ThreadPoolExecutor createExecutor() {
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        r100.setRejectedExecutionHandler(new c());
        return r100;
    }

    public void deinit() {
        Object r100 = this.mExecutorLock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadPoolExecutor.isShutdown() == true) goto L7;
        this.mThreadPoolExecutor.shutdown();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public CameraExecutor() {
        this.mExecutorLock = new Object();
        this.mThreadPoolExecutor = createExecutor();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        Preconditions.checkNotNull(r100);
        Object r101 = this.mExecutorLock;
        monitor-enter(r101);
        this.mThreadPoolExecutor.execute(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void init(CameraFactory r100) {
        Preconditions.checkNotNull(r100);
        Object r101 = this.mExecutorLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadPoolExecutor.isShutdown() == false) goto L7;
        this.mThreadPoolExecutor = createExecutor();     // Catch: Throwable -> L11
    L7:
        ThreadPoolExecutor r102 = this.mThreadPoolExecutor;     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        int r103 = Math.max(1, r100.getAvailableCameraIds().size());
        r102.setMaximumPoolSize(r103);
        r102.setCorePoolSize(r103);
    }

    private static /* synthetic */ void lambda$createExecutor$0(Runnable r100, ThreadPoolExecutor r101) {
        Logger.e(TAG, "A rejected execution occurred in CameraExecutor!");
    }
}
