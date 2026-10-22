package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import lb.n;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, Flow, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Emitter implements DisposableHandle {
        public final qb.b<n> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j10, Object obj, qb.b<? super n> bVar) {
            this.flow = sharedFlowImpl;
            this.index = j10;
            this.value = obj;
            this.cont = bVar;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {387, 394, 397}, m = "collect$suspendImpl")
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SharedFlowImpl<T> sharedFlowImpl, qb.b<? super AnonymousClass1> bVar) {
            super(bVar);
            this.this$0 = sharedFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
        }
    }

    public SharedFlowImpl(int i10, int i11, BufferOverflow bufferOverflow) {
        this.replay = i10;
        this.bufferCapacity = i11;
        this.onBufferOverflow = bufferOverflow;
    }

    private final Object awaitValue(SharedFlowSlot sharedFlowSlot, qb.b<? super n> bVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    cancellableContinuationImpl.resumeWith(n.f10413a);
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.f10059a ? result : n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            g.c(objArr);
            if (SharedFlowKt.getBufferAt(objArr, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            n nVar = n.f10413a;
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            g.c(objArr);
            while (this.queueSize > 0 && SharedFlowKt.getBufferAt(objArr, (getHead() + getTotalSize()) - 1) == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + getTotalSize(), null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        if (((kotlinx.coroutines.flow.SubscribedFlowCollector) r9).onSubscription(r0) == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> java.lang.Object collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.FlowCollector<? super T> r9, qb.b<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, qb.b):java.lang.Object");
    }

    private final void correctCollectorIndexesOnDropOldest(long j10) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j11 = sharedFlowSlot.index;
                    if (j11 >= 0 && j11 < j10) {
                        sharedFlowSlot.index = j10;
                    }
                }
            }
        }
        this.minCollectorIndex = j10;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        g.c(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
    }

    public static <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t8, qb.b<? super n> bVar) throws Throwable {
        if (sharedFlowImpl.tryEmit(t8)) {
            return n.f10413a;
        }
        Object objEmitSuspend = sharedFlowImpl.emitSuspend(t8, bVar);
        return objEmitSuspend == CoroutineSingletons.f10059a ? objEmitSuspend : n.f10413a;
    }

    private final Object emitSuspend(T t8, qb.b<? super n> bVar) throws Throwable {
        SharedFlowImpl<T> sharedFlowImpl;
        Throwable th;
        qb.b<n>[] bVarArrFindSlotsToResumeLocked;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        qb.b<n>[] bVarArrFindSlotsToResumeLocked2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(t8)) {
                    try {
                        cancellableContinuationImpl.resumeWith(n.f10413a);
                        bVarArrFindSlotsToResumeLocked = findSlotsToResumeLocked(bVarArrFindSlotsToResumeLocked2);
                        emitter = null;
                        sharedFlowImpl = this;
                    } catch (Throwable th2) {
                        th = th2;
                        sharedFlowImpl = this;
                        throw th;
                    }
                } else {
                    sharedFlowImpl = this;
                    try {
                        Emitter emitter2 = new Emitter(sharedFlowImpl, getHead() + getTotalSize(), t8, cancellableContinuationImpl);
                        sharedFlowImpl.enqueueLocked(emitter2);
                        sharedFlowImpl.queueSize++;
                        if (sharedFlowImpl.bufferCapacity == 0) {
                            bVarArrFindSlotsToResumeLocked2 = sharedFlowImpl.findSlotsToResumeLocked(bVarArrFindSlotsToResumeLocked2);
                        }
                        bVarArrFindSlotsToResumeLocked = bVarArrFindSlotsToResumeLocked2;
                        emitter = emitter2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (emitter != null) {
                    CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
                }
                for (qb.b<n> bVar2 : bVarArrFindSlotsToResumeLocked) {
                    if (bVar2 != null) {
                        bVar2.resumeWith(n.f10413a);
                    }
                }
                Object result = cancellableContinuationImpl.getResult();
                return result == CoroutineSingletons.f10059a ? result : n.f10413a;
            } catch (Throwable th4) {
                th = th4;
                sharedFlowImpl = this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object obj) {
        int totalSize = getTotalSize();
        Object[] objArrGrowBuffer = this.buffer;
        if (objArrGrowBuffer == null) {
            objArrGrowBuffer = growBuffer(null, 0, 2);
        } else if (totalSize >= objArrGrowBuffer.length) {
            objArrGrowBuffer = growBuffer(objArrGrowBuffer, totalSize, objArrGrowBuffer.length * 2);
        }
        SharedFlowKt.setBufferAt(objArrGrowBuffer, getHead() + totalSize, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final qb.b<n>[] findSlotsToResumeLocked(qb.b<n>[] bVarArr) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        qb.b<? super n> bVar;
        int length = bVarArr.length;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i10 = 0;
            bVarArr = bVarArr;
            while (i10 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i10];
                if (abstractSharedFlowSlot != null && (bVar = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = bVarArr.length;
                    bVarArr = bVarArr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(bVarArr, Math.max(2, bVarArr.length * 2));
                        g.e(CopyOf, "copyOf(...)");
                        bVarArr = CopyOf;
                    }
                    bVarArr[length] = bVar;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i10++;
                bVarArr = bVarArr;
            }
        }
        return bVarArr;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object getPeekedValueLockedAt(long j10) {
        Object[] objArr = this.buffer;
        g.c(objArr);
        Object bufferAt = SharedFlowKt.getBufferAt(objArr, j10);
        return bufferAt instanceof Emitter ? ((Emitter) bufferAt).value : bufferAt;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] objArr, int i10, int i11) {
        if (i11 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i11];
        this.buffer = objArr2;
        if (objArr != null) {
            long head = getHead();
            for (int i12 = 0; i12 < i10; i12++) {
                long j10 = i12 + head;
                SharedFlowKt.setBufferAt(objArr2, j10, SharedFlowKt.getBufferAt(objArr, j10));
            }
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T t8) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(t8);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        enqueueLocked(t8);
        int i11 = this.bufferSize + 1;
        this.bufferSize = i11;
        if (i11 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T t8) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(t8);
        int i10 = this.bufferSize + 1;
        this.bufferSize = i10;
        if (i10 > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j10 = sharedFlowSlot.index;
        if (j10 >= getBufferEndIndex() && (this.bufferCapacity > 0 || j10 > getHead() || this.queueSize == 0)) {
            return -1L;
        }
        return j10;
    }

    private final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        qb.b<n>[] bVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long jTryPeekLocked = tryPeekLocked(sharedFlowSlot);
                if (jTryPeekLocked < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j10 = sharedFlowSlot.index;
                    Object peekedValueLockedAt = getPeekedValueLockedAt(jTryPeekLocked);
                    sharedFlowSlot.index = jTryPeekLocked + 1;
                    bVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j10);
                    obj = peekedValueLockedAt;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (qb.b<n> bVar : bVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (bVar != null) {
                bVar.resumeWith(n.f10413a);
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long head = getHead(); head < jMin; head++) {
            Object[] objArr = this.buffer;
            g.c(objArr);
            SharedFlowKt.setBufferAt(objArr, head, null);
        }
        this.replayIndex = j10;
        this.minCollectorIndex = j11;
        this.bufferSize = (int) (j12 - jMin);
        this.queueSize = (int) (j13 - j12);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, qb.b<?> bVar) {
        return collect$suspendImpl(this, flowCollector, bVar);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t8, qb.b<? super n> bVar) {
        return emit$suspendImpl(this, t8, bVar);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(d dVar, int i10, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, dVar, i10, bufferOverflow);
    }

    public final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        g.c(objArr);
        return (T) SharedFlowKt.getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t8) {
        int i10;
        boolean z;
        qb.b<n>[] bVarArrFindSlotsToResumeLocked = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t8)) {
                bVarArrFindSlotsToResumeLocked = findSlotsToResumeLocked(bVarArrFindSlotsToResumeLocked);
                z = true;
            } else {
                z = false;
            }
        }
        for (qb.b<n> bVar : bVarArrFindSlotsToResumeLocked) {
            if (bVar != null) {
                bVar.resumeWith(n.f10413a);
            }
        }
        return z;
    }

    public final qb.b<n>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j10) {
        long j11;
        long j12;
        long j13;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (j10 > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j14 = this.bufferSize + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j14++;
        }
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j15 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j15 >= 0 && j15 < j14) {
                        j14 = j15;
                    }
                }
            }
        }
        if (j14 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        int iMin = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j14))) : this.queueSize;
        qb.b<n>[] bVarArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j16 = this.queueSize + bufferEndIndex;
        if (iMin > 0) {
            bVarArr = new qb.b[iMin];
            Object[] objArr = this.buffer;
            g.c(objArr);
            j13 = 1;
            long j17 = bufferEndIndex;
            int i10 = 0;
            while (true) {
                if (bufferEndIndex >= j16) {
                    j11 = head;
                    j12 = j14;
                    bufferEndIndex = j17;
                    break;
                }
                Object bufferAt = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j11 = head;
                Symbol symbol = SharedFlowKt.NO_VALUE;
                if (bufferAt != symbol) {
                    g.d(bufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) bufferAt;
                    int i11 = i10 + 1;
                    j12 = j14;
                    bVarArr[i10] = emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, symbol);
                    SharedFlowKt.setBufferAt(objArr, j17, emitter.value);
                    long j18 = j17 + 1;
                    if (i11 >= iMin) {
                        bufferEndIndex = j18;
                        break;
                    }
                    i10 = i11;
                    j17 = j18;
                } else {
                    j12 = j14;
                }
                bufferEndIndex++;
                head = j11;
                j14 = j12;
            }
        } else {
            j11 = head;
            j12 = j14;
            j13 = 1;
        }
        qb.b<n>[] bVarArr2 = bVarArr;
        int i12 = (int) (bufferEndIndex - j11);
        long j19 = getNCollectors() == 0 ? bufferEndIndex : j12;
        long jMax = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i12));
        if (this.bufferCapacity == 0 && jMax < j16) {
            Object[] objArr2 = this.buffer;
            g.c(objArr2);
            if (g.b(SharedFlowKt.getBufferAt(objArr2, jMax), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex += j13;
                jMax += j13;
            }
        }
        updateBufferLocked(jMax, j19, bufferEndIndex, j16);
        cleanupTailLocked();
        return !(bVarArr2.length == 0) ? findSlotsToResumeLocked(bVarArr2) : bVarArr2;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j10 = this.replayIndex;
        if (j10 < this.minCollectorIndex) {
            this.minCollectorIndex = j10;
        }
        return j10;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int i10) {
        return new SharedFlowSlot[i10];
    }
}
