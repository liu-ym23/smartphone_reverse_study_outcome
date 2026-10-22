package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class SequentialExecutor implements Executor {
    private static final Logger log = null;
    private final Executor executor;

    @GuardedBy("queue")
    private final Deque<Runnable> queue;
    private final QueueWorker worker;

    @GuardedBy("queue")
    private long workerRunCount;

    @GuardedBy("queue")
    private WorkerRunningState workerRunningState;

    public final class QueueWorker implements Runnable {
        final /* synthetic */ SequentialExecutor this$0;

        private QueueWorker(SequentialExecutor r10) {
            this.this$0 = r10;
        }

        private void workOnQueue() {
            boolean r10 = false;
            boolean r11 = false;
        L38:
            Deque r12 = SequentialExecutor.access$100(this.this$0);     // Catch: Throwable -> L27
            monitor-enter(r12);     // Catch: Throwable -> L27
            if (r10 == false) goto L37;
        L15:
            Runnable r13 = (Runnable) SequentialExecutor.access$100(this.this$0).poll();     // Catch: Throwable -> L12
            if (r13 == null) goto L17;
            monitor-exit(r12);     // Catch: Throwable -> L12
            r11 = r11 | Thread.interrupted();
            r13.run();     // Catch: Throwable -> L27 RuntimeException -> L29
        L29:
            e = move-exception;
            SequentialExecutor.access$400().log(Level.SEVERE, "Exception while executing runnable " + r13, e);     // Catch: Throwable -> L27
            goto L38
        L17:
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.IDLE);     // Catch: Throwable -> L12
            monitor-exit(r12);     // Catch: Throwable -> L12
            if (r11 == false) goto L47;
            Thread.currentThread().interrupt();
            return;
        L47:
            return;
        L37:
            WorkerRunningState r14 = SequentialExecutor.access$200(this.this$0);     // Catch: Throwable -> L12
            WorkerRunningState r15 = WorkerRunningState.RUNNING;     // Catch: Throwable -> L12
            if (r14 == r15) goto L8;
            SequentialExecutor.access$308(this.this$0);     // Catch: Throwable -> L12
            SequentialExecutor.access$202(this.this$0, r15);     // Catch: Throwable -> L12
            r10 = true;
            goto L15
        L8:
            monitor-exit(r12);     // Catch: Throwable -> L12
            if (r11 == false) goto L46;
            Thread.currentThread().interrupt();
            return;
        L46:
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            if (r11 == false) goto L36;
            Thread.currentThread().interrupt();
        L36:
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            workOnQueue();     // Catch: Error -> L4
            return;
        L4:
            e = move-exception;
            monitor-enter(SequentialExecutor.access$100(this.this$0));
            SequentialExecutor.access$202(this.this$0, WorkerRunningState.IDLE);     // Catch: Throwable -> L10
            throw e;
        L10:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ QueueWorker(SequentialExecutor r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public static final enum WorkerRunningState extends Enum<WorkerRunningState> {
        private static final /* synthetic */ WorkerRunningState[] $VALUES = null;
        public static final WorkerRunningState IDLE = null;
        public static final WorkerRunningState QUEUED = null;
        public static final WorkerRunningState QUEUING = null;
        public static final WorkerRunningState RUNNING = null;

        static {
            WorkerRunningState r10 = new WorkerRunningState("IDLE", 0);
            IDLE = r10;
            WorkerRunningState r11 = new WorkerRunningState("QUEUING", 1);
            QUEUING = r11;
            WorkerRunningState r12 = new WorkerRunningState("QUEUED", 2);
            QUEUED = r12;
            WorkerRunningState r13 = new WorkerRunningState("RUNNING", 3);
            RUNNING = r13;
            $VALUES = new WorkerRunningState[]{r10, r11, r12, r13};
        }

        private WorkerRunningState(String r10, int r11) {
            super(r10, r11);
        }

        public static WorkerRunningState valueOf(String r10) {
            return (WorkerRunningState) Enum.valueOf(WorkerRunningState.class, r10);
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) $VALUES.clone();
        }
    }

    static {
        log = Logger.getLogger(SequentialExecutor.class.getName());
    }

    public SequentialExecutor(Executor r10) {
        this.queue = new ArrayDeque();
        this.workerRunningState = WorkerRunningState.IDLE;
        this.workerRunCount = 0;
        this.worker = new QueueWorker(this, null);
        this.executor = (Executor) Preconditions.checkNotNull(r10);
    }

    public static /* synthetic */ Deque access$100(SequentialExecutor r10) {
        return r10.queue;
    }

    public static /* synthetic */ WorkerRunningState access$200(SequentialExecutor r10) {
        return r10.workerRunningState;
    }

    public static /* synthetic */ WorkerRunningState access$202(SequentialExecutor r10, WorkerRunningState r11) {
        r10.workerRunningState = r11;
        return r11;
    }

    public static /* synthetic */ long access$308(SequentialExecutor r10) {
        long r11 = r10.workerRunCount;
        r10.workerRunCount = 1 + r11;
        return r11;
    }

    public static /* synthetic */ Logger access$400() {
        return log;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r10) {
        Preconditions.checkNotNull(r10);
        Deque<Runnable> r11 = this.queue;
        monitor-enter(r11);
        WorkerRunningState r12 = this.workerRunningState;     // Catch: Throwable -> L50
        if (r12 == WorkerRunningState.RUNNING) goto L52;
        WorkerRunningState r13 = WorkerRunningState.QUEUED;     // Catch: Throwable -> L50
        if (r12 == r13) goto L52;
        long r14 = this.workerRunCount;     // Catch: Throwable -> L50
        Runnable r15 = new AnonymousClass1(this, r10);     // Catch: Throwable -> L50
        this.queue.add(r15);     // Catch: Throwable -> L50
        WorkerRunningState r16 = WorkerRunningState.QUEUING;     // Catch: Throwable -> L50
        this.workerRunningState = r16;     // Catch: Throwable -> L50
        monitor-exit(r11);     // Catch: Throwable -> L50
        this.executor.execute(this.worker);     // Catch: Throwable -> L28
        if (this.workerRunningState == r16) goto L15;
        return;
    L15:
        Deque<Runnable> r17 = this.queue;
        monitor-enter(r17);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (this.workerRunCount == r14) goto L20;
    L24:
        monitor-exit(r17);     // Catch: Throwable -> L22
        return;
    L20:
        if (this.workerRunningState != r16) goto L24;
        this.workerRunningState = r13;     // Catch: Throwable -> L22
    L28:
        e = move-exception;
        monitor-enter(this.queue);
        WorkerRunningState r18 = this.workerRunningState;     // Catch: Throwable -> L36
        if (r18 == WorkerRunningState.IDLE) goto L39;
        if (r18 == WorkerRunningState.QUEUING) goto L39;
    L41:
        boolean r19 = false;
    L43:
        if ((e instanceof RejectedExecutionException) == false) goto L47;
        if (r19 == true) goto L47;
        return;
    L47:
        throw e;     // Catch: Throwable -> L36
    L39:
        if (this.queue.removeLastOccurrence(r15) == false) goto L41;
        r19 = true;
    L36:
        th = move-exception;
        throw th;
    L52:
        this.queue.add(r10);     // Catch: Throwable -> L50
        monitor-exit(r11);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }
}
