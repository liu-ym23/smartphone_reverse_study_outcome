package reactor.core.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.Disposable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class WorkerTask implements Runnable, Disposable, Callable<Void> {
    volatile Future<?> future;
    volatile Disposable.Composite parent;
    final Runnable task;
    volatile Thread thread;
    static final Disposable.Composite DISPOSED = new EmptyCompositeDisposable();
    static final Disposable.Composite DONE = new EmptyCompositeDisposable();
    static final Future<Void> FINISHED = new FutureTask(new e(5));
    static final Future<Void> SYNC_CANCELLED = new FutureTask(new e(6));
    static final Future<Void> ASYNC_CANCELLED = new FutureTask(new e(7));
    static final AtomicReferenceFieldUpdater<WorkerTask, Future> FUTURE = AtomicReferenceFieldUpdater.newUpdater(WorkerTask.class, Future.class, "future");
    static final AtomicReferenceFieldUpdater<WorkerTask, Disposable.Composite> PARENT = AtomicReferenceFieldUpdater.newUpdater(WorkerTask.class, Disposable.Composite.class, "parent");
    static final AtomicReferenceFieldUpdater<WorkerTask, Thread> THREAD = AtomicReferenceFieldUpdater.newUpdater(WorkerTask.class, Thread.class, "thread");

    public WorkerTask(Runnable runnable, Disposable.Composite composite) {
        this.task = runnable;
        PARENT.lazySet(this, composite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$static$2() {
        return null;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public Void call() {
        Future<?> future;
        Future<Void> future2;
        Future<Void> future3;
        boolean zCompareAndSet;
        Disposable.Composite composite;
        Future<?> future4;
        THREAD.lazySet(this, Thread.currentThread());
        try {
            this.task.run();
        } finally {
            try {
                THREAD.lazySet(this, null);
                composite = this.parent;
                if (composite != DISPOSED) {
                    composite.remove(this);
                }
                do {
                    future4 = this.future;
                    if (future4 == SYNC_CANCELLED) {
                        break;
                    }
                    break;
                } while (!FUTURE.compareAndSet(this, future4, FINISHED));
                return null;
            } catch (Throwable th) {
                do {
                    if (future == future2) {
                        break;
                    }
                    if (future == future3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        THREAD.lazySet(this, null);
        composite = this.parent;
        if (composite != DISPOSED && PARENT.compareAndSet(this, composite, DONE) && composite != null) {
            composite.remove(this);
        }
        do {
            future4 = this.future;
            if (future4 == SYNC_CANCELLED || future4 == ASYNC_CANCELLED) {
                break;
                break;
            }
        } while (!FUTURE.compareAndSet(this, future4, FINISHED));
        return null;
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        Disposable.Composite composite;
        Disposable.Composite composite2;
        Future<Void> future;
        Future<Void> future2;
        while (true) {
            Future<?> future3 = this.future;
            if (future3 == FINISHED || future3 == (future = SYNC_CANCELLED) || future3 == (future2 = ASYNC_CANCELLED)) {
                break;
            }
            boolean z10 = this.thread != Thread.currentThread();
            AtomicReferenceFieldUpdater<WorkerTask, Future> atomicReferenceFieldUpdater = FUTURE;
            if (z10) {
                future = future2;
            }
            if (atomicReferenceFieldUpdater.compareAndSet(this, future3, future)) {
                if (future3 != null) {
                    future3.cancel(z10);
                }
            }
        }
        do {
            composite = this.parent;
            if (composite == DONE || composite == (composite2 = DISPOSED) || composite == null) {
                return;
            }
        } while (!PARENT.compareAndSet(this, composite, composite2));
        composite.remove(this);
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        Disposable.Composite composite = PARENT.get(this);
        return composite == DISPOSED || composite == DONE;
    }

    @Override // java.lang.Runnable
    public void run() {
        call();
    }

    public void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.future;
            if (future2 == FINISHED) {
                return;
            }
            if (future2 == SYNC_CANCELLED) {
                future.cancel(false);
                return;
            } else if (future2 == ASYNC_CANCELLED) {
                future.cancel(true);
                return;
            }
        } while (!FUTURE.compareAndSet(this, future2, future));
    }
}
