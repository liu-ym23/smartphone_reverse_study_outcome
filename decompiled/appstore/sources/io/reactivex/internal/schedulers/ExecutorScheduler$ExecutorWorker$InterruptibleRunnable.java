package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ExecutorScheduler$ExecutorWorker$InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
    static final int FINISHED = 2;
    static final int INTERRUPTED = 4;
    static final int INTERRUPTING = 3;
    static final int READY = 0;
    static final int RUNNING = 1;
    private static final long serialVersionUID = -3603436687413320876L;
    final Runnable run;
    final DisposableContainer tasks;
    volatile Thread thread;

    public ExecutorScheduler$ExecutorWorker$InterruptibleRunnable(Runnable r10, DisposableContainer r11) {
        this.run = r10;
        this.tasks = r11;
    }

    public void cleanup() {
        DisposableContainer r10 = this.tasks;
        if (r10 == null) goto L6;
        r10.delete(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    L2:
        int r10 = get();
        if (r10 >= 2) goto L26;
        if (r10 == 0) goto L8;
        if (compareAndSet(1, 3) == false) goto L2;
        Thread r11 = this.thread;
        if (r11 == null) goto L15;
        r11.interrupt();
        this.thread = null;
    L15:
        set(4);
        cleanup();
        return;
    L8:
        if (compareAndSet(0, 4) == false) goto L2;
        cleanup();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() < 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != 0) goto L30;
        this.thread = Thread.currentThread();
        if (compareAndSet(0, 1) == true) goto L26;
        this.thread = null;
        return;
    L26:
        this.run.run();     // Catch: Throwable -> L15
        this.thread = null;
        if (compareAndSet(1, 2) == false) goto L12;
        cleanup();
        return;
    L12:
        if (get() != 3) goto L14;
        Thread.yield();
        goto L12
    L14:
        Thread.interrupted();
        return;
    L15:
        th = move-exception;
        this.thread = null;
        if (compareAndSet(1, 2) == false) goto L19;
        cleanup();
    L23:
        throw th;
    L19:
        if (get() != 3) goto L21;
        Thread.yield();
        goto L19
    L21:
        Thread.interrupted();
        goto L23
    }
}
