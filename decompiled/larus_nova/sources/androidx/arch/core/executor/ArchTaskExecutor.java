package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class ArchTaskExecutor extends TaskExecutor {
    private static final Executor sIOThreadExecutor = null;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor = null;
    private final TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;

    public static /* synthetic */ void a(Runnable r100) {
        lambda$static$1(r100);
    }

    public static /* synthetic */ void b(Runnable r100) {
        lambda$static$0(r100);
    }

    static {
        sMainThreadExecutor = new a();
        sIOThreadExecutor = new b();
    }

    public static ArchTaskExecutor getInstance() {
        if (sInstance == null) goto L7;
        return sInstance;
    L7:
        monitor-enter(ArchTaskExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L11;
        sInstance = new ArchTaskExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(ArchTaskExecutor.class);     // Catch: Throwable -> L14
        return sInstance;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor r100 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = r100;
        this.mDelegate = r100;
    }

    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    private static /* synthetic */ void lambda$static$0(Runnable r100) {
        getInstance().postToMainThread(r100);
    }

    private static /* synthetic */ void lambda$static$1(Runnable r100) {
        getInstance().executeOnDiskIO(r100);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable r100) {
        this.mDelegate.executeOnDiskIO(r100);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable r100) {
        this.mDelegate.postToMainThread(r100);
    }

    public void setDelegate(TaskExecutor r100) {
        if (r100 != null) goto L4;
        r100 = this.mDefaultTaskExecutor;
    L4:
        this.mDelegate = r100;
    }
}
