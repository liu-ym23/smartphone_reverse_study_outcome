package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutor mBackgroundExecutor;
    private final Executor mMainThreadExecutor;
    private final Handler mMainThreadHandler;

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public SerialExecutor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public WorkManagerTaskExecutor(Executor r100) {
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mMainThreadExecutor = new AnonymousClass1(this);
        this.mBackgroundExecutor = new SerialExecutor(r100);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public void executeOnBackgroundThread(Runnable r100) {
        this.mBackgroundExecutor.execute(r100);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public void postToMainThread(Runnable r100) {
        this.mMainThreadHandler.post(r100);
    }
}
