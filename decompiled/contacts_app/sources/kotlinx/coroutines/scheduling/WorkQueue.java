package kotlinx.coroutines.scheduling;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0016\u0010#\u001a\u0004\u0018\u00010\u00072\n\u0010$\u001a\u00060\tj\u0002`%H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\"\u0010(\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+J$\u0010,\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+H\u0002J\u000e\u0010-\u001a\u00020\u0018*\u0004\u0018\u00010\u0007H\u0002R\t\u0010\u0003\u001a\u00020\u0004X\u0082\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\t\u0010\f\u001a\u00020\u0004X\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eX\u0082\u0004R\t\u0010\u000f\u001a\u00020\u0004X\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006."}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "blockingTasksInBuffer", "Lkotlinx/atomicfu/AtomicInt;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize", "()I", "consumerIndex", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", PerfConsts.PERF_DISK_FILE_SIZE, "getSize$kotlinx_coroutines_core", "add", "task", "fair", "", "addLast", "offloadAllWorkTo", "", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "poll", "pollBlocking", "pollBuffer", "pollCpu", "pollTo", DBHelper.TABLE_QUEUE, "pollWithExclusiveMode", "onlyBlocking", "stealWithExclusiveMode", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryExtractFromTheMiddle", "index", "trySteal", "", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "tryStealLastScheduled", "decrementIfBlocking", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkQueue {
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = null;
    private static final AtomicIntegerFieldUpdater consumerIndex$FU = null;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU = null;
    private static final AtomicIntegerFieldUpdater producerIndex$FU = null;

    @Volatile
    private volatile int blockingTasksInBuffer;
    private final AtomicReferenceArray<Task> buffer;

    @Volatile
    private volatile int consumerIndex;

    @Volatile
    private volatile Object lastScheduledTask;

    @Volatile
    private volatile int producerIndex;

    static {
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
        blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    }

    public WorkQueue() {
        this.buffer = new AtomicReferenceArray(128);
    }

    private final int getBufferSize() {
        return producerIndex$FU.get(this) - consumerIndex$FU.get(this);
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object r0 = lastScheduledTask$FU.get(this);
        int r1 = getBufferSize();
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    public final Task poll() {
        Task r0 = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return pollBuffer();
    }

    public static /* synthetic */ Task add$default(WorkQueue r0, Task r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.add(r1, r2);
    }

    public final Task add(Task r1, boolean r2) {
        if (r2 == true) goto L4;
        Task r3 = (Task) lastScheduledTask$FU.getAndSet(this, r1);
        if (r3 != null) goto L10;
        return null;
    L10:
        return addLast(r3);
    L4:
        return addLast(r1);
    }

    private final Task addLast(Task r4) {
        if (getBufferSize() != 127) goto L5;
        return r4;
    L5:
        boolean r2 = true;
        if (r4.taskContext.getTaskMode() == 1) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L11;
        blockingTasksInBuffer$FU.incrementAndGet(this);
    L11:
        int r0 = producerIndex$FU.get(this) & WorkQueueKt.MASK;
    L13:
        if (this.buffer.get(r0) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.buffer.lazySet(r0, r4);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long trySteal(int r2, Ref.ObjectRef<Task> r3) {
        if (r2 != 3) goto L5;
        T r0 = pollBuffer();
    L6:
        if (r0 == 0) goto L10;
        r3.element = r0;
        return -1;
    L10:
        return tryStealLastScheduled(r2, r3);
    L5:
        r0 = stealWithExclusiveMode(r2);
        goto L6
    }

    private final Task stealWithExclusiveMode(int r5) {
        int r0 = consumerIndex$FU.get(this);
        int r1 = producerIndex$FU.get(this);
        boolean r2 = true;
        if (r5 == 1) goto L7;
        r2 = false;
    L7:
        if (r0 == r1) goto L16;
        if (r2 == true) goto L10;
    L12:
        int r6 = r0 + 1;
        Task r3 = tryExtractFromTheMiddle(r0, r2);
        if (r3 != null) goto L15;
        r0 = r6;
        goto L7
    L15:
        return r3;
    L10:
        if (blockingTasksInBuffer$FU.get(this) != 0) goto L12;
        return null;
    L16:
        return null;
    }

    public final Task pollBlocking() {
        return pollWithExclusiveMode(true);
    }

    public final Task pollCpu() {
        return pollWithExclusiveMode(false);
    }

    private final Task pollWithExclusiveMode(boolean r6) {
    L2:
        AtomicReferenceFieldUpdater r0 = lastScheduledTask$FU;
        Task r1 = (Task) r0.get(this);
        if (r1 == null) goto L13;
        boolean r4 = true;
        if (r1.taskContext.getTaskMode() == 1) goto L9;
        r4 = false;
    L9:
        if (r4 != r6) goto L13;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r1, null) == false) goto L2;
        return r1;
    L13:
        int r2 = consumerIndex$FU.get(this);
        int r3 = producerIndex$FU.get(this);
    L14:
        if (r2 == r3) goto L22;
        if (r6 == true) goto L17;
    L19:
        r3 = r3 - 1;
        Task r5 = tryExtractFromTheMiddle(r3, r6);
        if (r5 == null) goto L14;
        return r5;
    L17:
        if (blockingTasksInBuffer$FU.get(this) != 0) goto L19;
        return null;
    L22:
        return null;
    }

    private final Task tryExtractFromTheMiddle(int r5, boolean r6) {
        int r7 = r5 & WorkQueueKt.MASK;
        Task r0 = this.buffer.get(r7);
        if (r0 == null) goto L14;
        boolean r3 = true;
        if (r0.taskContext.getTaskMode() == 1) goto L8;
        r3 = false;
    L8:
        if (r3 != r6) goto L14;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.buffer, r7, r0, null) == false) goto L14;
        if (r6 == false) goto L13;
        blockingTasksInBuffer$FU.decrementAndGet(this);
    L13:
        return r0;
    L14:
        return null;
    }

    public final void offloadAllWorkTo(GlobalQueue r3) {
        Task r0 = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (r0 == null) goto L6;
        r3.addLast(r0);
    L6:
        if (pollTo(r3) == true) goto L6;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.Task] */
    private final long tryStealLastScheduled(int r7, Ref.ObjectRef<Task> r8) {
    L2:
        AtomicReferenceFieldUpdater r0 = lastScheduledTask$FU;
        ?? r1 = (Task) r0.get(this);
        if (r1 == 0) goto L4;
        int r5 = 1;
        if (r1.taskContext.getTaskMode() != 1) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L13;
        r5 = 2;
    L13:
        if ((r5 & r7) == 0) goto L14;
        long r2 = TasksKt.schedulerTimeSource.nanoTime() - r1.submissionTime;
        if (r2 < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) goto L18;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, this, r1, null) == false) goto L2;
        r8.element = r1;
        return -1;
    L18:
        return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - r2;
    L14:
        return -2;
    L8:
        r4 = false;
        goto L9
    L4:
        return -2;
    }

    private final boolean pollTo(GlobalQueue r1) {
        Task r0 = pollBuffer();
        if (r0 != null) goto L6;
        return false;
    L6:
        r1.addLast(r0);
        return true;
    }

    private final Task pollBuffer() {
    L2:
        AtomicIntegerFieldUpdater r0 = consumerIndex$FU;
        int r1 = r0.get(this);
        if ((r1 - producerIndex$FU.get(this)) == 0) goto L4;
        int r2 = r1 & WorkQueueKt.MASK;
        if (r0.compareAndSet(this, r1, r1 + 1) == false) goto L2;
        Task r3 = this.buffer.getAndSet(r2, null);
        if (r3 == null) goto L2;
        decrementIfBlocking(r3);
        return r3;
    L4:
        return null;
    }

    private final void decrementIfBlocking(Task r3) {
        if (r3 == null) goto L16;
        boolean r0 = false;
        if (r3.taskContext.getTaskMode() != 1) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L17;
        int r2 = blockingTasksInBuffer$FU.decrementAndGet(this);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L18;
        if (r2 < 0) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        throw new AssertionError();
    L18:
        return;
    L17:
        return;
    L6:
        r4 = false;
        goto L7
    }
}
