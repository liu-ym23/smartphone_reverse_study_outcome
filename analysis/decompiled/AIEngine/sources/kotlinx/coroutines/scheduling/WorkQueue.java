package kotlinx.coroutines.scheduling;

import com.stepos.core.common.util.TraceIdKeys;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkQueue {
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(TraceIdKeys.MAX_LENGTH);
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater lastScheduledTask$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater producerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater blockingTasksInBuffer$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer$volatile");

    private final Task addLast(Task task) {
        if (getBufferSize() == 127) {
            return task;
        }
        if (task.taskContext) {
            blockingTasksInBuffer$volatile$FU.incrementAndGet(this);
        }
        int i10 = producerIndex$volatile$FU.get(this) & 127;
        while (this.buffer.get(i10) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i10, task);
        producerIndex$volatile$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task == null || !task.taskContext) {
            return;
        }
        blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
    }

    private final int getBufferSize() {
        return producerIndex$volatile$FU.get(this) - consumerIndex$volatile$FU.get(this);
    }

    private final Task pollBuffer() {
        Task andSet;
        while (true) {
            int i10 = consumerIndex$volatile$FU.get(this);
            if (i10 - producerIndex$volatile$FU.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (consumerIndex$volatile$FU.compareAndSet(this, i10, i10 + 1) && (andSet = this.buffer.getAndSet(i11, null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    private final boolean pollTo(GlobalQueue globalQueue) {
        Task taskPollBuffer = pollBuffer();
        if (taskPollBuffer == null) {
            return false;
        }
        globalQueue.addLast(taskPollBuffer);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r0 = kotlinx.coroutines.scheduling.WorkQueue.consumerIndex$volatile$FU.get(r4);
        r2 = kotlinx.coroutines.scheduling.WorkQueue.producerIndex$volatile$FU.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r0 == r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r5 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (kotlinx.coroutines.scheduling.WorkQueue.blockingTasksInBuffer$volatile$FU.get(r4) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r2 = r2 - 1;
        r3 = tryExtractFromTheMiddle(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.scheduling.Task pollWithExclusiveMode(boolean r5) {
        /*
            r4 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = getLastScheduledTask$volatile$FU()
            java.lang.Object r0 = r0.get(r4)
            kotlinx.coroutines.scheduling.Task r0 = (kotlinx.coroutines.scheduling.Task) r0
            r1 = 0
            if (r0 != 0) goto Le
            goto L24
        Le:
            boolean r2 = r0.taskContext
            if (r2 != r5) goto L24
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = getLastScheduledTask$volatile$FU()
        L16:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L1d
            return r0
        L1d:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L16
            goto L0
        L24:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = getConsumerIndex$volatile$FU()
            int r0 = r0.get(r4)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = getProducerIndex$volatile$FU()
            int r2 = r2.get(r4)
        L34:
            if (r0 == r2) goto L4c
            if (r5 == 0) goto L43
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = getBlockingTasksInBuffer$volatile$FU()
            int r3 = r3.get(r4)
            if (r3 != 0) goto L43
            return r1
        L43:
            int r2 = r2 + (-1)
            kotlinx.coroutines.scheduling.Task r3 = r4.tryExtractFromTheMiddle(r2, r5)
            if (r3 == 0) goto L34
            return r3
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.WorkQueue.pollWithExclusiveMode(boolean):kotlinx.coroutines.scheduling.Task");
    }

    private final Task stealWithExclusiveMode(int i10) {
        int i11 = consumerIndex$volatile$FU.get(this);
        int i12 = producerIndex$volatile$FU.get(this);
        boolean z = i10 == 1;
        while (i11 != i12) {
            if (z && blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            Task taskTryExtractFromTheMiddle = tryExtractFromTheMiddle(i11, z);
            if (taskTryExtractFromTheMiddle != null) {
                return taskTryExtractFromTheMiddle;
            }
            i11 = i13;
        }
        return null;
    }

    private final Task tryExtractFromTheMiddle(int i10, boolean z) {
        int i11 = i10 & 127;
        Task task = this.buffer.get(i11);
        if (task != null && task.taskContext == z) {
            AtomicReferenceArray<Task> atomicReferenceArray = this.buffer;
            while (!atomicReferenceArray.compareAndSet(i11, task, null)) {
                if (atomicReferenceArray.get(i11) != task) {
                }
            }
            if (z) {
                blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
            }
            return task;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.Task] */
    private final long tryStealLastScheduled(int i10, Ref$ObjectRef<Task> ref$ObjectRef) {
        while (true) {
            ?? r02 = (Task) lastScheduledTask$volatile$FU.get(this);
            if (r02 == 0) {
                return -2L;
            }
            if (((r02.taskContext ? 1 : 2) & i10) == 0) {
                return -2L;
            }
            long jNanoTime = TasksKt.schedulerTimeSource.nanoTime() - r02.submissionTime;
            long j10 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (jNanoTime < j10) {
                return j10 - jNanoTime;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = lastScheduledTask$volatile$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, r02, null)) {
                if (atomicReferenceFieldUpdater.get(this) != r02) {
                    break;
                }
            }
            ref$ObjectRef.f10076a = r02;
            return -1L;
        }
    }

    public final Task add(Task task, boolean z) {
        if (z) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$volatile$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return addLast(task2);
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object obj = lastScheduledTask$volatile$FU.get(this);
        int bufferSize = getBufferSize();
        return obj != null ? bufferSize + 1 : bufferSize;
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue) {
        Task task = (Task) lastScheduledTask$volatile$FU.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        while (pollTo(globalQueue)) {
        }
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$volatile$FU.getAndSet(this, null);
        return task == null ? pollBuffer() : task;
    }

    public final Task pollBlocking() {
        return pollWithExclusiveMode(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long trySteal(int i10, Ref$ObjectRef<Task> ref$ObjectRef) {
        T tPollBuffer = i10 == 3 ? pollBuffer() : stealWithExclusiveMode(i10);
        if (tPollBuffer == 0) {
            return tryStealLastScheduled(i10, ref$ObjectRef);
        }
        ref$ObjectRef.f10076a = tPollBuffer;
        return -1L;
    }
}
