package reactor.core.scheduler;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Exceptions;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class ExecutorScheduler implements Scheduler, Scannable {
    final Executor executor;
    volatile boolean terminated;
    final boolean trampoline;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ExecutorPlainRunnable extends AtomicBoolean implements Runnable, Disposable {
        private static final long serialVersionUID = 5116223460201378097L;
        final Runnable task;

        public ExecutorPlainRunnable(Runnable runnable) {
            this.task = runnable;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            set(true);
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get()) {
                return;
            }
            try {
                this.task.run();
            } catch (Throwable th) {
                try {
                    Schedulers.handleError(th);
                } finally {
                    lazySet(true);
                }
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ExecutorSchedulerTrampolineWorker implements Scheduler.Worker, WorkerDelete, Runnable, Scannable {
        static final AtomicIntegerFieldUpdater<ExecutorSchedulerTrampolineWorker> WIP = AtomicIntegerFieldUpdater.newUpdater(ExecutorSchedulerTrampolineWorker.class, "wip");
        final Executor executor;
        final Queue<ExecutorTrackedRunnable> queue = new ConcurrentLinkedQueue();
        volatile boolean terminated;
        volatile int wip;
        private final boolean wrapSchedule;

        public ExecutorSchedulerTrampolineWorker(Executor executor) {
            this.executor = executor;
            this.wrapSchedule = !(executor instanceof Scheduler);
        }

        @Override // reactor.core.scheduler.ExecutorScheduler.WorkerDelete
        public void delete(ExecutorTrackedRunnable executorTrackedRunnable) {
            synchronized (this) {
                try {
                    if (!this.terminated) {
                        this.queue.remove(executorTrackedRunnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            Queue<ExecutorTrackedRunnable> queue = this.queue;
            while (true) {
                ExecutorTrackedRunnable executorTrackedRunnablePoll = queue.poll();
                if (executorTrackedRunnablePoll == null || queue.isEmpty()) {
                    return;
                } else {
                    executorTrackedRunnablePoll.dispose();
                }
            }
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.terminated;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Queue<ExecutorTrackedRunnable> queue = this.queue;
            do {
                int i3 = this.wip;
                i = 0;
                while (i != i3) {
                    if (this.terminated) {
                        return;
                    }
                    ExecutorTrackedRunnable executorTrackedRunnablePoll = queue.poll();
                    if (executorTrackedRunnablePoll == null) {
                        break;
                    }
                    executorTrackedRunnablePoll.run();
                    i++;
                }
                if (i == i3 && this.terminated) {
                    return;
                }
            } while (WIP.addAndGet(this, -i) != 0);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.PARENT) {
                Executor executor = this.executor;
                if (executor instanceof Scannable) {
                    return executor;
                }
                return null;
            }
            if (attr != Scannable.Attr.NAME) {
                return (attr == Scannable.Attr.BUFFERED || attr == Scannable.Attr.LARGE_BUFFERED) ? Integer.valueOf(this.queue.size()) : Schedulers.scanExecutor(this.executor, attr);
            }
            return "fromExecutor(" + this.executor + ",trampolining).worker";
        }

        @Override // reactor.core.scheduler.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            Objects.requireNonNull(runnable, "task");
            if (this.terminated) {
                throw Exceptions.failWithRejected();
            }
            if (this.wrapSchedule) {
                runnable = Schedulers.onSchedule(runnable);
            }
            ExecutorTrackedRunnable executorTrackedRunnable = new ExecutorTrackedRunnable(runnable, this, false);
            synchronized (this) {
                if (this.terminated) {
                    throw Exceptions.failWithRejected();
                }
                this.queue.offer(executorTrackedRunnable);
            }
            if (WIP.getAndIncrement(this) != 0) {
                return executorTrackedRunnable;
            }
            try {
                this.executor.execute(this);
                return executorTrackedRunnable;
            } catch (Throwable th) {
                executorTrackedRunnable.dispose();
                Schedulers.handleError(th);
                throw Exceptions.failWithRejected(th);
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ExecutorSchedulerWorker implements Scheduler.Worker, WorkerDelete, Scannable {
        final Executor executor;
        final Disposable.Composite tasks = Disposables.composite();
        private final boolean wrapSchedule;

        public ExecutorSchedulerWorker(Executor executor) {
            this.executor = executor;
            this.wrapSchedule = !(executor instanceof Scheduler);
        }

        @Override // reactor.core.scheduler.ExecutorScheduler.WorkerDelete
        public void delete(ExecutorTrackedRunnable executorTrackedRunnable) {
            this.tasks.remove(executorTrackedRunnable);
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            this.tasks.dispose();
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return this.tasks.isDisposed();
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(isDisposed());
            }
            if (attr == Scannable.Attr.BUFFERED) {
                return Integer.valueOf(this.tasks.size());
            }
            if (attr == Scannable.Attr.PARENT) {
                Executor executor = this.executor;
                if (executor instanceof Scannable) {
                    return executor;
                }
                return null;
            }
            Scannable.Attr<String> attr2 = Scannable.Attr.NAME;
            Executor executor2 = this.executor;
            if (attr != attr2) {
                return Schedulers.scanExecutor(executor2, attr);
            }
            boolean z10 = executor2 instanceof SingleWorkerScheduler;
            Executor executor3 = this.executor;
            if (z10) {
                return executor3 + ".worker";
            }
            return "fromExecutor(" + executor3 + ").worker";
        }

        @Override // reactor.core.scheduler.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            Objects.requireNonNull(runnable, "task");
            if (this.wrapSchedule) {
                runnable = Schedulers.onSchedule(runnable);
            }
            ExecutorTrackedRunnable executorTrackedRunnable = new ExecutorTrackedRunnable(runnable, this, true);
            if (!this.tasks.add(executorTrackedRunnable)) {
                throw Exceptions.failWithRejected();
            }
            try {
                this.executor.execute(executorTrackedRunnable);
                return executorTrackedRunnable;
            } catch (Throwable th) {
                this.tasks.remove(executorTrackedRunnable);
                Schedulers.handleError(th);
                throw Exceptions.failWithRejected(th);
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class ExecutorTrackedRunnable extends AtomicBoolean implements Runnable, Disposable {
        private static final long serialVersionUID = 3503344795919906192L;
        final boolean callRemoveOnFinish;
        final WorkerDelete parent;
        final Runnable task;

        public ExecutorTrackedRunnable(Runnable runnable, WorkerDelete workerDelete, boolean z10) {
            this.task = runnable;
            this.parent = workerDelete;
            this.callRemoveOnFinish = z10;
        }

        @Override // reactor.core.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.delete(this);
            }
        }

        @Override // reactor.core.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get()) {
                return;
            }
            try {
                this.task.run();
            } catch (Throwable th) {
                try {
                    Schedulers.handleError(th);
                    if (this.callRemoveOnFinish) {
                        dispose();
                    } else {
                        lazySet(true);
                    }
                } finally {
                    if (this.callRemoveOnFinish) {
                        dispose();
                    } else {
                        lazySet(true);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface WorkerDelete {
        void delete(ExecutorTrackedRunnable executorTrackedRunnable);
    }

    public ExecutorScheduler(Executor executor, boolean z10) {
        this.executor = executor;
        this.trampoline = z10;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Scheduler.Worker createWorker() {
        return this.trampoline ? new ExecutorSchedulerTrampolineWorker(this.executor) : new ExecutorSchedulerWorker(this.executor);
    }

    @Override // reactor.core.scheduler.Scheduler, reactor.core.Disposable
    public void dispose() {
        this.terminated = true;
    }

    @Override // reactor.core.Disposable
    public boolean isDisposed() {
        return this.terminated;
    }

    @Override // reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.TERMINATED || attr == Scannable.Attr.CANCELLED) {
            return Boolean.valueOf(isDisposed());
        }
        if (attr == Scannable.Attr.NAME) {
            return toString();
        }
        return null;
    }

    @Override // reactor.core.scheduler.Scheduler
    public Disposable schedule(Runnable runnable) {
        if (this.terminated) {
            throw Exceptions.failWithRejected();
        }
        Objects.requireNonNull(runnable, "task");
        ExecutorPlainRunnable executorPlainRunnable = new ExecutorPlainRunnable(Schedulers.onSchedule(runnable));
        try {
            this.executor.execute(executorPlainRunnable);
            return executorPlainRunnable;
        } catch (Throwable th) {
            Executor executor = this.executor;
            if ((executor instanceof ExecutorService) && ((ExecutorService) executor).isShutdown()) {
                this.terminated = true;
            }
            Schedulers.handleError(th);
            throw Exceptions.failWithRejected(th);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("fromExecutor(");
        sb2.append(this.executor);
        if (this.trampoline) {
            sb2.append(",trampolining");
        }
        sb2.append(')');
        return sb2.toString();
    }
}
