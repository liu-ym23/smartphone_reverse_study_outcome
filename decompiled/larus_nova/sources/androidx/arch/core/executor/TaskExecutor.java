package androidx.arch.core.executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TaskExecutor {
    public TaskExecutor() {
    }

    public abstract void executeOnDiskIO(Runnable r100);

    public abstract boolean isMainThread();

    public abstract void postToMainThread(Runnable r100);

    public void executeOnMainThread(Runnable r100) {
        if (isMainThread() == false) goto L5;
        r100.run();
        return;
    L5:
        postToMainThread(r100);
    }
}
