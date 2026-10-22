package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
final class SequentialExecutor implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;
    final Deque<Runnable> mQueue;
    private final QueueWorker mWorker;
    long mWorkerRunCount;
    WorkerRunningState mWorkerRunningState;

    public final class QueueWorker implements Runnable {
        final /* synthetic */ SequentialExecutor this$0;

        private void workOnQueue() {
            boolean r100 = false;
            boolean r101 = false;
        L36:
            Deque<Runnable> r102 = this.this$0.mQueue;     // Catch: Throwable -> L31
            monitor-enter(r102);     // Catch: Throwable -> L31
            if (r100 == false) goto L35;
        L13:
            Runnable r103 = this.this$0.mQueue.poll();     // Catch: Throwable -> L28
            if (r103 == null) goto L15;
            monitor-exit(r102);     // Catch: Throwable -> L28
            r101 = r101 | Thread.interrupted();
            r103.run();     // Catch: RuntimeException -> L25 Throwable -> L31
        L25:
            e = move-exception;
            Logger.e(SequentialExecutor.TAG, "Exception while executing runnable " + r103, e);     // Catch: Throwable -> L31
            goto L36
        L15:
            this.this$0.mWorkerRunningState = WorkerRunningState.IDLE;     // Catch: Throwable -> L28
            monitor-exit(r102);     // Catch: Throwable -> L28
            if (r101 == false) goto L45;
            ThreadMethodProxy.currentThread().interrupt();
            return;
        L45:
            return;
        L35:
            SequentialExecutor r104 = this.this$0;     // Catch: Throwable -> L28
            WorkerRunningState r105 = r104.mWorkerRunningState;     // Catch: Throwable -> L28
            WorkerRunningState r106 = WorkerRunningState.RUNNING;     // Catch: Throwable -> L28
            if (r105 == r106) goto L8;
            r104.mWorkerRunCount++;     // Catch: Throwable -> L28
            r104.mWorkerRunningState = r106;     // Catch: Throwable -> L28
            r100 = true;
            goto L13
        L8:
            monitor-exit(r102);     // Catch: Throwable -> L28
            if (r101 == false) goto L44;
            ThreadMethodProxy.currentThread().interrupt();
            return;
        L44:
            return;
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            if (r101 == false) goto L34;
            ThreadMethodProxy.currentThread().interrupt();
        L34:
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker__run$___twin___() {
            workOnQueue();     // Catch: Error -> L4
            return;
        L4:
            e = move-exception;
            monitor-enter(this.this$0.mQueue);
            SequentialExecutor r100 = this.this$0;     // Catch: Throwable -> L10
            r100.mWorkerRunningState = WorkerRunningState.IDLE;     // Catch: Throwable -> L10
            throw e;
        L10:
            th = move-exception;
            throw th;
        }

        public QueueWorker(SequentialExecutor r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker_com_larus_apm_impl_protector_RunnableLancet_run(QueueWorker r100) {
            r100.androidx_camera_core_impl_utils_executor_SequentialExecutor$QueueWorker__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final enum WorkerRunningState extends Enum<WorkerRunningState> {
        private static final /* synthetic */ WorkerRunningState[] $VALUES = null;
        public static final WorkerRunningState IDLE = null;
        public static final WorkerRunningState QUEUED = null;
        public static final WorkerRunningState QUEUING = null;
        public static final WorkerRunningState RUNNING = null;

        private static /* synthetic */ WorkerRunningState[] $values() {
            return new WorkerRunningState[]{IDLE, QUEUING, QUEUED, RUNNING};
        }

        static {
            IDLE = new WorkerRunningState("IDLE", 0);
            QUEUING = new WorkerRunningState("QUEUING", 1);
            QUEUED = new WorkerRunningState("QUEUED", 2);
            RUNNING = new WorkerRunningState("RUNNING", 3);
            $VALUES = $values();
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) $VALUES.clone();
        }

        public static WorkerRunningState valueOf(String r100) {
            return (WorkerRunningState) r27.a.a(WorkerRunningState.class, r100);
        }

        private WorkerRunningState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SequentialExecutor(Executor r100) {
        this.mQueue = new ArrayDeque();
        this.mWorker = new QueueWorker(this);
        this.mWorkerRunningState = WorkerRunningState.IDLE;
        this.mWorkerRunCount = 0;
        this.mExecutor = (Executor) Preconditions.checkNotNull(r100);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r100) {
        Preconditions.checkNotNull(r100);
        Deque<Runnable> r101 = this.mQueue;
        monitor-enter(r101);
        WorkerRunningState r102 = this.mWorkerRunningState;     // Catch: Throwable -> L56
        if (r102 == WorkerRunningState.RUNNING) goto L53;
        WorkerRunningState r103 = WorkerRunningState.QUEUED;     // Catch: Throwable -> L56
        if (r102 == r103) goto L53;
        long r104 = this.mWorkerRunCount;     // Catch: Throwable -> L56
        Runnable r105 = new AnonymousClass1(this, r100);     // Catch: Throwable -> L56
        this.mQueue.add(r105);     // Catch: Throwable -> L56
        WorkerRunningState r106 = WorkerRunningState.QUEUING;     // Catch: Throwable -> L56
        this.mWorkerRunningState = r106;     // Catch: Throwable -> L56
        monitor-exit(r101);     // Catch: Throwable -> L56
        boolean r107 = true;
        this.mExecutor.execute(this.mWorker);     // Catch: Throwable -> L31 RuntimeException -> L33
        if (this.mWorkerRunningState != r106) goto L17;
        r107 = false;
    L17:
        if (r107 == false) goto L19;
        return;
    L19:
        Deque<Runnable> r108 = this.mQueue;
        monitor-enter(r108);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (this.mWorkerRunCount == r104) goto L24;
    L26:
        monitor-exit(r108);     // Catch: Throwable -> L28
        return;
    L24:
        if (this.mWorkerRunningState != r106) goto L26;
        this.mWorkerRunningState = r103;     // Catch: Throwable -> L28
    L31:
        e = move-exception;
        Deque<Runnable> r109 = this.mQueue;
        monitor-enter(r109);
        WorkerRunningState r110 = this.mWorkerRunningState;     // Catch: Throwable -> L50
        if (r110 == WorkerRunningState.IDLE) goto L41;
        if (r110 == WorkerRunningState.QUEUING) goto L41;
    L43:
        r107 = false;
    L45:
        if ((e instanceof RejectedExecutionException) == false) goto L49;
        if (r107 == true) goto L49;
        monitor-exit(r109);     // Catch: Throwable -> L50
        return;
    L49:
        throw e;     // Catch: Throwable -> L50
    L41:
        if (this.mQueue.removeLastOccurrence(r105) == false) goto L43;
    L50:
        th = move-exception;
        throw th;
    L53:
        this.mQueue.add(r100);     // Catch: Throwable -> L56
        monitor-exit(r101);     // Catch: Throwable -> L56
        return;
    L56:
        th = move-exception;
        throw th;
    }
}
