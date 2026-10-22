package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class TransactionExecutor implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque<Runnable> mTasks;

    TransactionExecutor(Executor executor) {
        this.mTasks = new ArrayDeque();
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable command) {
        monitor-enter(this);
        this.mTasks.offer(new AnonymousClass1(this, command));     // Catch: Throwable -> L8
        if (this.mActive != null) goto L6;
        scheduleNext();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void scheduleNext() {
        monitor-enter(this);
        Runnable r0 = this.mTasks.poll();     // Catch: Throwable -> L8
        this.mActive = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        this.mExecutor.execute(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
