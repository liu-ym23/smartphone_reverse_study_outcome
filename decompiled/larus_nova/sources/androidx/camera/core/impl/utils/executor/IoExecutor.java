package androidx.camera.core.impl.utils.executor;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
final class IoExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mIoService;

    public static Executor getInstance() {
        if (sExecutor == null) goto L7;
        return sExecutor;
    L7:
        monitor-enter(IoExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sExecutor != null) goto L11;
        sExecutor = new IoExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(IoExecutor.class);     // Catch: Throwable -> L14
        return sExecutor;
    }

    public IoExecutor() {
        this.mIoService = PThreadExecutorsUtils.newFixedThreadPool(2, new AnonymousClass1(this));
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        this.mIoService.execute(r100);
    }
}
