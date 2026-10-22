package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks;

    public synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r100 = this.mTasks.poll();     // Catch: Throwable -> L8
        this.mActive = r100;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        this.mExecutor.execute(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public TransactionExecutor(Executor r100) {
        this.mTasks = new ArrayDeque();
        this.mExecutor = r100;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r100) {
        monitor-enter(this);
        this.mTasks.offer(new AnonymousClass1(this, r100));     // Catch: Throwable -> L8
        if (this.mActive != null) goto L6;
        scheduleNext();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
