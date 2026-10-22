package kotlinx.coroutines.channels;

import ai.onnxruntime.a;
import b7.h;
import b7.i;
import ec.e;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.c;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import lb.n;
import qb.b;
import zb.l;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BufferedChannel<E> implements Channel<E> {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final l<E, n> onUndeliveredElement;
    private final q<SelectInstance<?>, Object, Object, q<Throwable, Object, d, n>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i10, long j10, b<? super Boolean> bVar) {
            Boolean bool;
            l<E, n> lVar;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(jd.b.w(bVar));
            try {
                this.continuation = orCreateCancellableContinuation;
                Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i10, j10, this);
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                    bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i10);
                } else {
                    q qVarBindCancellationFun = null;
                    if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                        if (j10 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                onClosedHasNextNoWaiterSuspend();
                                break;
                            }
                            long andIncrement = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                            int i11 = BufferedChannelKt.SEGMENT_SIZE;
                            long j11 = andIncrement / i11;
                            int i12 = (int) (andIncrement % i11);
                            if (channelSegment2.f10114id != j11) {
                                ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j11, channelSegment2);
                                if (channelSegmentFindSegmentReceive != null) {
                                    channelSegment2 = channelSegmentFindSegmentReceive;
                                }
                            }
                            objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment2, i12, andIncrement, this);
                            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                                bufferedChannel.prepareReceiverForSuspension(this, channelSegment2, i12);
                                break;
                            }
                            if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment2.cleanPrev();
                                }
                            } else {
                                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                    throw new IllegalStateException("unexpected");
                                }
                                channelSegment2.cleanPrev();
                                this.receiveResult = objUpdateCellReceive;
                                this.continuation = null;
                                bool = Boolean.TRUE;
                                lVar = bufferedChannel.onUndeliveredElement;
                                if (lVar != null) {
                                }
                            }
                        }
                        orCreateCancellableContinuation.resume((CancellableContinuationImpl) bool, (q<? super Throwable, ? super CancellableContinuationImpl, ? super d, n>) qVarBindCancellationFun);
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                        this.continuation = null;
                        bool = Boolean.TRUE;
                        lVar = bufferedChannel.onUndeliveredElement;
                        if (lVar != null) {
                            qVarBindCancellationFun = bufferedChannel.bindCancellationFun(lVar, objUpdateCellReceive);
                        }
                        orCreateCancellableContinuation.resume((CancellableContinuationImpl) bool, (q<? super Throwable, ? super CancellableContinuationImpl, ? super d, n>) qVarBindCancellationFun);
                    }
                }
                Object result = orCreateCancellableContinuation.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                return result;
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }

        private final boolean onClosedHasNext() throws Throwable {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            g.c(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                cancellableContinuationImpl.resumeWith(Boolean.FALSE);
            } else {
                cancellableContinuationImpl.resumeWith(c.a(closeCause));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(b<? super Boolean> bVar) throws Throwable {
            ChannelSegment<E> channelSegmentFindSegmentReceive;
            boolean zOnClosedHasNext = true;
            if (this.receiveResult == BufferedChannelKt.NO_RECEIVE_RESULT || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel<E> bufferedChannel = BufferedChannel.this;
                ChannelSegment<E> channelSegment = (ChannelSegment) BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.isClosedForReceive()) {
                        zOnClosedHasNext = onClosedHasNext();
                        break;
                    }
                    long andIncrement = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                    int i10 = BufferedChannelKt.SEGMENT_SIZE;
                    long j10 = andIncrement / i10;
                    int i11 = (int) (andIncrement % i10);
                    if (channelSegment.f10114id != j10) {
                        channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j10, channelSegment);
                        if (channelSegmentFindSegmentReceive == null) {
                            continue;
                        }
                    } else {
                        channelSegmentFindSegmentReceive = channelSegment;
                    }
                    Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i11, andIncrement, null);
                    if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                        throw new IllegalStateException("unreachable");
                    }
                    if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegmentFindSegmentReceive.cleanPrev();
                        }
                        channelSegment = channelSegmentFindSegmentReceive;
                    } else {
                        if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                            return hasNextOnNoWaiterSuspend(channelSegmentFindSegmentReceive, i11, andIncrement, bVar);
                        }
                        channelSegmentFindSegmentReceive.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                    }
                }
            }
            return Boolean.valueOf(zOnClosedHasNext);
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int i10) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i10);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() throws Throwable {
            E e10 = (E) this.receiveResult;
            if (e10 == BufferedChannelKt.NO_RECEIVE_RESULT) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e10 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                return e10;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
        }

        public final boolean tryResumeHasNext(E e10) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            g.c(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = e10;
            Boolean bool = Boolean.TRUE;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            l<E, n> lVar = bufferedChannel.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, bool, lVar != null ? bufferedChannel.bindCancellationFun(lVar, e10) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            g.c(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                cancellableContinuationImpl.resumeWith(Boolean.FALSE);
            } else {
                cancellableContinuationImpl.resumeWith(c.a(closeCause));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SendBroadcast implements Waiter {
        public final CancellableContinuation<Boolean> getCont() {
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: kotlinx.coroutines.channels.BufferedChannel$bindCancellationFun$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements q<Throwable, E, d, n> {
        public AnonymousClass2(Object obj) {
            super(3, obj, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // zb.q
        public /* bridge */ /* synthetic */ n invoke(Throwable th, Object obj, d dVar) {
            invoke2(th, (Throwable) obj, dVar);
            return n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th, E e10, d dVar) {
            ((BufferedChannel) this.receiver).onCancellationImplDoNotCall(th, e10, dVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: kotlinx.coroutines.channels.BufferedChannel$bindCancellationFunResult$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements q<Throwable, ChannelResult<? extends E>, d, n> {
        public AnonymousClass1(Object obj) {
            super(3, obj, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // zb.q
        public /* bridge */ /* synthetic */ n invoke(Throwable th, Object obj, d dVar) {
            m151invoke5_sEAP8(th, ((ChannelResult) obj).m162unboximpl(), dVar);
            return n.f10413a;
        }

        /* renamed from: invoke-5_sEAP8, reason: not valid java name */
        public final void m151invoke5_sEAP8(Throwable th, Object obj, d dVar) {
            ((BufferedChannel) this.receiver).m144onCancellationChannelResultImplDoNotCall5_sEAP8(th, obj, dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i10, l<? super E, n> lVar) {
        this.capacity = i10;
        this.onUndeliveredElement = lVar;
        if (i10 < 0) {
            throw new IllegalArgumentException(a.g(i10, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.initialBufferEnd(i10);
        this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
        ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment;
        this.receiveSegment$volatile = channelSegment;
        if (isRendezvousOrUnlimited()) {
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            g.d(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = channelSegment;
        this.onUndeliveredElementReceiveCancellationConstructor = lVar != 0 ? new h(this, 2) : null;
        this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q<Throwable, Object, d, n> bindCancellationFun(l<? super E, n> lVar, E e10) {
        return new i(2, lVar, e10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n bindCancellationFun$lambda$89(l lVar, Object obj, Throwable th, Object obj2, d dVar) {
        OnUndeliveredElementKt.callUndeliveredElement(lVar, obj, dVar);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e<n> bindCancellationFunResult(l<? super E, n> lVar) {
        return new AnonymousClass1(this);
    }

    private final boolean bufferOrRendezvousSend(long j10) {
        return j10 < getBufferEndCounter() || j10 < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> channelSegment, long j10) {
        Object objM171constructorimpl$default = InlineList.m171constructorimpl$default(null, 1, null);
        loop0: while (channelSegment != null) {
            for (int i10 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i10; i10--) {
                if ((channelSegment.f10114id * BufferedChannelKt.SEGMENT_SIZE) + i10 < j10) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
                    if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                                break;
                            }
                            if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                objM171constructorimpl$default = InlineList.m172plusFjFbRPM(objM171constructorimpl$default, state$kotlinx_coroutines_core);
                                channelSegment.onCancelledRequest(i10, true);
                                break;
                            }
                        } else {
                            if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                objM171constructorimpl$default = InlineList.m172plusFjFbRPM(objM171constructorimpl$default, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                channelSegment.onCancelledRequest(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            channelSegment.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.getPrev();
        }
        if (objM171constructorimpl$default != null) {
            if (!(objM171constructorimpl$default instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((Waiter) objM171constructorimpl$default);
                return;
            }
            ArrayList arrayList = (ArrayList) objM171constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object obj = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment.f10114id > ((ChannelSegment) obj).f10114id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment2.f10114id > ((ChannelSegment) obj).f10114id) {
            obj = channelSegment2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) obj);
    }

    private final void completeCancel(long j10) {
        removeUnprocessedElements(completeClose(j10));
    }

    private final ChannelSegment<E> completeClose(long j10) {
        ChannelSegment<E> channelSegmentCloseLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long jMarkAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(channelSegmentCloseLinkedList);
            if (jMarkAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(jMarkAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(channelSegmentCloseLinkedList, j10);
        return channelSegmentCloseLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        BufferedChannel<E> bufferedChannel;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = andIncrement / i10;
            if (this.getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.f10114id < j10 && channelSegment.getNext() != 0) {
                    this.moveSegmentBufferEndToSpecifiedOrLast(j10, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.f10114id != j10) {
                bufferedChannel = this;
                ChannelSegment<E> channelSegmentFindSegmentBufferEnd = bufferedChannel.findSegmentBufferEnd(j10, channelSegment, andIncrement);
                if (channelSegmentFindSegmentBufferEnd == null) {
                    continue;
                    this = bufferedChannel;
                } else {
                    channelSegment = channelSegmentFindSegmentBufferEnd;
                }
            } else {
                bufferedChannel = this;
            }
            if (bufferedChannel.updateCellExpandBuffer(channelSegment, (int) (andIncrement % i10), andIncrement)) {
                incCompletedExpandBufferAttempts$default(bufferedChannel, 0L, 1, null);
                return;
            } else {
                incCompletedExpandBufferAttempts$default(bufferedChannel, 0L, 1, null);
                this = bufferedChannel;
            }
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long j10, ChannelSegment<E> channelSegment, long j11) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
        p pVar = (p) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j10, pVar);
            if (!SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM174getSegmentimpl = SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f10114id >= segmentM174getSegmentimpl.f10114id) {
                        break loop0;
                    }
                    if (!segmentM174getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM174getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentM174getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM174getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(j10, channelSegment);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
        if (channelSegment2.f10114id <= j10) {
            return channelSegment2;
        }
        long j12 = channelSegment2.f10114id;
        int i10 = BufferedChannelKt.SEGMENT_SIZE;
        if (bufferEnd$volatile$FU.compareAndSet(this, j11 + 1, j12 * i10)) {
            incCompletedExpandBufferAttempts((channelSegment2.f10114id * i10) - j11);
        } else {
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long j10, ChannelSegment<E> channelSegment) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
        p pVar = (p) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j10, pVar);
            if (!SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM174getSegmentimpl = SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f10114id >= segmentM174getSegmentimpl.f10114id) {
                        break loop0;
                    }
                    if (!segmentM174getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM174getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentM174getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM174getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.f10114id * BufferedChannelKt.SEGMENT_SIZE < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
        if (!isRendezvousOrUnlimited() && j10 <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$volatile$FU;
            while (true) {
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.f10114id >= channelSegment2.f10114id || !channelSegment2.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != segment2) {
                        if (channelSegment2.decPointers$kotlinx_coroutines_core()) {
                            channelSegment2.remove();
                        }
                    }
                }
                if (segment2.decPointers$kotlinx_coroutines_core()) {
                    segment2.remove();
                }
            }
        }
        long j11 = channelSegment2.f10114id;
        if (j11 <= j10) {
            return channelSegment2;
        }
        int i10 = BufferedChannelKt.SEGMENT_SIZE;
        updateReceiversCounterIfLower(j11 * i10);
        if (channelSegment2.f10114id * i10 < getSendersCounter$kotlinx_coroutines_core()) {
            channelSegment2.cleanPrev();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long j10, ChannelSegment<E> channelSegment) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
        p pVar = (p) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j10, pVar);
            if (!SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM174getSegmentimpl = SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f10114id >= segmentM174getSegmentimpl.f10114id) {
                        break loop0;
                    }
                    if (!segmentM174getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM174getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentM174getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM174getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.f10114id * BufferedChannelKt.SEGMENT_SIZE < getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
        long j11 = channelSegment2.f10114id;
        if (j11 <= j10) {
            return channelSegment2;
        }
        int i10 = BufferedChannelKt.SEGMENT_SIZE;
        updateSendersCounterIfLower(j11 * i10);
        if (channelSegment2.f10114id * i10 < getReceiversCounter$kotlinx_coroutines_core()) {
            channelSegment2.cleanPrev();
        }
        return null;
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException("Channel was closed") : closeCause;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    private final void incCompletedExpandBufferAttempts(long j10) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j10);
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        loop0: while (true) {
            obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        if (obj == null) {
            return;
        }
        k.c(1, obj);
        ((l) obj).invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int i10, long j10) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                return state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV && j10 == getReceiversCounter$kotlinx_coroutines_core();
            }
        } while (!channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long j10, boolean z) {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            completeClose(j10 & 1152921504606846975L);
            return (z && hasElements$kotlinx_coroutines_core()) ? false : true;
        }
        if (i10 != 3) {
            throw new IllegalStateException(ai.onnxruntime.providers.a.a(i10, "unexpected close status: ").toString());
        }
        completeCancel(j10 & 1152921504606846975L);
        return true;
    }

    private final boolean isClosedForReceive0(long j10) {
        return isClosed(j10, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j10) {
        return isClosed(j10, false);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (kotlinx.coroutines.channels.ChannelSegment) r8.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long markAllEmptyCellsAsClosed(kotlinx.coroutines.channels.ChannelSegment<E> r8) {
        /*
            r7 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f10114id
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.getReceiversCounter$kotlinx_coroutines_core()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.getState$kotlinx_coroutines_core(r0)
            if (r1 == 0) goto L2c
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getIN_BUFFER$p()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r1 != r2) goto L39
            return r3
        L2c:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r1 = r8.casState$kotlinx_coroutines_core(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.onSlotCleaned()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r8 = r8.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.markAllEmptyCellsAsClosed(kotlinx.coroutines.channels.ChannelSegment):long");
    }

    private final void markCancellationStarted() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j10, 1))) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    private final void markCancelled() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            BufferedChannel<E> bufferedChannel = this;
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j10, 3))) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    private final void markClosed() {
        long jConstructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jConstructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j10, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jConstructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j10, 3);
            }
            BufferedChannel<E> bufferedChannel = this;
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j10, jConstructSendersAndCloseStatus)) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long r5, kotlinx.coroutines.channels.ChannelSegment<E> r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f10114id
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r7.getNext()
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.isRemoved()
            if (r5 == 0) goto L22
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r5 = r7.getNext()
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = getBufferEndSegment$volatile$FU()
        L26:
            java.lang.Object r6 = r5.get(r4)
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            long r0 = r6.f10114id
            long r2 = r7.f10114id
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L35
            return
        L35:
            boolean r0 = r7.tryIncPointers$kotlinx_coroutines_core()
            if (r0 != 0) goto L3c
            goto L11
        L3c:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4c
            boolean r4 = r6.decPointers$kotlinx_coroutines_core()
            if (r4 == 0) goto L4b
            r6.remove()
        L4b:
            return
        L4c:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3c
            boolean r6 = r7.decPointers$kotlinx_coroutines_core()
            if (r6 == 0) goto L26
            r7.remove()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.moveSegmentBufferEndToSpecifiedOrLast(long, kotlinx.coroutines.channels.ChannelSegment):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCancellationChannelResultImplDoNotCall-5_sEAP8, reason: not valid java name */
    public final void m144onCancellationChannelResultImplDoNotCall5_sEAP8(Throwable th, Object obj, d dVar) {
        l<E, n> lVar = this.onUndeliveredElement;
        g.c(lVar);
        Object objM156getOrNullimpl = ChannelResult.m156getOrNullimpl(obj);
        g.c(objM156getOrNullimpl);
        OnUndeliveredElementKt.callUndeliveredElement(lVar, objM156getOrNullimpl, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCancellationImplDoNotCall(Throwable th, E e10, d dVar) {
        l<E, n> lVar = this.onUndeliveredElement;
        g.c(lVar);
        OnUndeliveredElementKt.callUndeliveredElement(lVar, e10, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        cancellableContinuation.resumeWith(ChannelResult.m152boximpl(ChannelResult.Companion.m163closedJP2dKIU(getCloseCause())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cancellableContinuation) {
        cancellableContinuation.resumeWith(c.a(getReceiveException()));
    }

    private final Object onClosedSend(E e10, b<? super n> bVar) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(bVar), 1);
        cancellableContinuationImpl.initCancellability();
        l<E, n> lVar = this.onUndeliveredElement;
        if (lVar == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, e10, null, 2, null)) == null) {
            cancellableContinuationImpl.resumeWith(c.a(getSendException()));
        } else {
            jd.b.c(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, getSendException());
            cancellableContinuationImpl.resumeWith(c.a(undeliveredElementExceptionCallUndeliveredElementCatchingException$default));
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.f10059a ? result : n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E e10, CancellableContinuation<? super n> cancellableContinuation) {
        l<E, n> lVar = this.onUndeliveredElement;
        if (lVar != null) {
            OnUndeliveredElementKt.callUndeliveredElement(lVar, e10, cancellableContinuation.getContext());
        }
        cancellableContinuation.resumeWith(c.a(getSendException()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(final BufferedChannel bufferedChannel, final SelectInstance selectInstance, Object obj, final Object obj2) {
        return new q() { // from class: lc.a
            @Override // zb.q
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(obj2, bufferedChannel, selectInstance, (Throwable) obj3, obj4, (d) obj5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance, Throwable th, Object obj2, d dVar) {
        if (obj != BufferedChannelKt.getCHANNEL_CLOSED()) {
            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj, selectInstance.getContext());
        }
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i10) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i10) {
        waiter.invokeOnCancellation(channelSegment, i10 + BufferedChannelKt.SEGMENT_SIZE);
    }

    public static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, b<? super E> bVar) throws Throwable {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (channelSegment2.f10114id != j10) {
                ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j10, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i11, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return bufferedChannel2.receiveOnNoWaiterSuspend(channelSegment, i11, andIncrement, bVar);
                }
                channelSegment.cleanPrev();
                return objUpdateCellReceive;
            }
            if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            bufferedChannel = bufferedChannel2;
            channelSegment2 = channelSegment;
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r14v12, types: [kotlinx.coroutines.channels.ChannelResult$Companion] */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <E> java.lang.Object m145receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r13, qb.b<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            kotlin.c.b(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.m162unboximpl()
            return r13
        L2f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L37:
            kotlin.c.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = access$getReceiveSegment$volatile$FU()
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L44:
            boolean r1 = r13.isClosedForReceive()
            if (r1 == 0) goto L55
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r13 = r13.getCloseCause()
            java.lang.Object r13 = r14.m163closedJP2dKIU(r13)
            return r13
        L55:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = access$getReceivers$volatile$FU()
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f10114id
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L75
            kotlinx.coroutines.channels.ChannelSegment r1 = access$findSegmentReceive(r13, r7, r14)
            if (r1 != 0) goto L73
            goto L44
        L73:
            r8 = r1
            goto L76
        L75:
            r8 = r14
        L76:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = access$updateCellReceive(r7, r8, r9, r10, r12)
            r1 = r7
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.access$getSUSPEND$p()
            if (r13 == r14) goto Lb4
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.access$getFAILED$p()
            if (r13 != r14) goto L99
            long r13 = r1.getSendersCounter$kotlinx_coroutines_core()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L96
            r8.cleanPrev()
        L96:
            r13 = r1
            r14 = r8
            goto L44
        L99:
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()
            if (r13 != r14) goto Laa
            r6.label = r2
            r2 = r8
            java.lang.Object r13 = r1.m146receiveCatchingOnNoWaiterSuspendGKJJFZk(r2, r3, r4, r6)
            if (r13 != r0) goto La9
            return r0
        La9:
            return r13
        Laa:
            r8.cleanPrev()
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r13 = r14.m165successJP2dKIU(r13)
            return r13
        Lb4:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m145receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m146receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r11, int r12, long r13, qb.b<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m146receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, qb.b):java.lang.Object");
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i10, long j10, b<? super E> bVar) {
        ChannelSegment channelSegment2;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(jd.b.w(bVar));
        try {
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i10, j10, orCreateCancellableContinuation);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                prepareReceiverForSuspension(orCreateCancellableContinuation, channelSegment, i10);
            } else {
                e eVarBindCancellationFun = null;
                eVarBindCancellationFun = null;
                if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                    if (j10 < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    ChannelSegment channelSegment3 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            onClosedReceiveOnNoWaiterSuspend(orCreateCancellableContinuation);
                            break;
                        }
                        long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                        int i11 = BufferedChannelKt.SEGMENT_SIZE;
                        long j11 = andIncrement / i11;
                        int i12 = (int) (andIncrement % i11);
                        if (channelSegment3.f10114id != j11) {
                            ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j11, channelSegment3);
                            if (channelSegmentFindSegmentReceive != null) {
                                channelSegment2 = channelSegmentFindSegmentReceive;
                            }
                        } else {
                            channelSegment2 = channelSegment3;
                        }
                        objUpdateCellReceive = updateCellReceive(channelSegment2, i12, andIncrement, orCreateCancellableContinuation);
                        ChannelSegment channelSegment4 = channelSegment2;
                        if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                            CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                            if (cancellableContinuationImpl != null) {
                                prepareReceiverForSuspension(cancellableContinuationImpl, channelSegment4, i12);
                            }
                        } else if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment4.cleanPrev();
                            }
                            channelSegment3 = channelSegment4;
                        } else {
                            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment4.cleanPrev();
                            l<E, n> lVar = this.onUndeliveredElement;
                            if (lVar != null) {
                                eVarBindCancellationFun = bindCancellationFun(lVar);
                            }
                        }
                    }
                } else {
                    channelSegment.cleanPrev();
                    l<E, n> lVar2 = this.onUndeliveredElement;
                    if (lVar2 != null) {
                        eVarBindCancellationFun = bindCancellationFun(lVar2);
                    }
                }
                orCreateCancellableContinuation.resume((CancellableContinuationImpl) objUpdateCellReceive, (q<? super Throwable, ? super CancellableContinuationImpl, ? super d, n>) eVarBindCancellationFun);
            }
            Object result = orCreateCancellableContinuation.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> r12) {
        /*
            r11 = this;
            zb.l<E, lb.n> r0 = r11.onUndeliveredElement
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m171constructorimpl$default(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.f10114id
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getDONE_RCV$p()
            if (r8 == r9) goto Lbb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r8 != r9) goto L48
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L40:
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto Laf
        L48:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getIN_BUFFER$p()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof kotlinx.coroutines.Waiter
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r8 == r9) goto Lbb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_RCV$p()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L80
            r9 = r8
            kotlinx.coroutines.channels.WaiterEB r9 = (kotlinx.coroutines.channels.WaiterEB) r9
            kotlinx.coroutines.Waiter r9 = r9.waiter
            goto L83
        L80:
            r9 = r8
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L83:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L97:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m172plusFjFbRPM(r3, r9)
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto Laf
        La2:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.onSlotCleaned()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r12 = r12.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r12 = (kotlinx.coroutines.channels.ChannelSegment) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Ldc
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r11.resumeSenderOnCancelledChannel(r3)
            goto Ldc
        Lc7:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Lce:
            if (r5 >= r12) goto Ldc
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            r11.resumeSenderOnCancelledChannel(r0)
            int r12 = r12 + (-1)
            goto Lce
        Ldc:
            if (r1 != 0) goto Ldf
            return
        Ldf:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            ((SendBroadcast) waiter).getCont().resumeWith(Boolean.FALSE);
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            ((b) waiter).resumeWith(c.a(z ? getReceiveException() : getSendException()));
            return;
        }
        if (waiter instanceof ReceiveCatching) {
            ((ReceiveCatching) waiter).cont.resumeWith(ChannelResult.m152boximpl(ChannelResult.Companion.m163closedJP2dKIU(getCloseCause())));
            return;
        }
        if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public static <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e10, b<? super n> bVar) {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (channelSegment2.f10114id != j11) {
                ChannelSegment<E> channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j11, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    Object objOnClosedSend = bufferedChannel.onClosedSend(e10, bVar);
                    if (objOnClosedSend == CoroutineSingletons.f10059a) {
                        return objOnClosedSend;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            E e11 = e10;
            int iUpdateCellSend = bufferedChannel2.updateCellSend(channelSegment, i11, e11, j10, null, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    Object objSendOnNoWaiterSuspend = bufferedChannel2.sendOnNoWaiterSuspend(channelSegment, i11, e11, j10, bVar);
                    if (objSendOnNoWaiterSuspend == CoroutineSingletons.f10059a) {
                        return objSendOnNoWaiterSuspend;
                    }
                } else if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    bufferedChannel = bufferedChannel2;
                    channelSegment2 = channelSegment;
                    e10 = e11;
                } else {
                    if (j10 < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object objOnClosedSend2 = bufferedChannel2.onClosedSend(e11, bVar);
                    if (objOnClosedSend2 == CoroutineSingletons.f10059a) {
                        return objOnClosedSend2;
                    }
                }
            } else if (zIsClosedForSend0) {
                channelSegment.onSlotCleaned();
                Object objOnClosedSend3 = bufferedChannel2.onClosedSend(e11, bVar);
                if (objOnClosedSend3 == CoroutineSingletons.f10059a) {
                    return objOnClosedSend3;
                }
            }
        }
        return n.f10413a;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r16, int r17, E r18, long r19, qb.b<? super lb.n> r21) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, qb.b):java.lang.Object");
    }

    private final boolean shouldSendSuspend(long j10) {
        if (isClosedForSend0(j10)) {
            return false;
        }
        return !bufferOrRendezvousSend(j10 & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e10) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e10);
        }
        if (obj instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) obj).cont;
            ChannelResult channelResultM152boximpl = ChannelResult.m152boximpl(ChannelResult.Companion.m165successJP2dKIU(e10));
            l<E, n> lVar = this.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, channelResultM152boximpl, (q) (lVar != null ? bindCancellationFunResult(lVar) : null));
        }
        if (obj instanceof BufferedChannelIterator) {
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e10);
        }
        if (obj instanceof CancellableContinuation) {
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            l<E, n> lVar2 = this.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuation, e10, (q) (lVar2 != null ? bindCancellationFun(lVar2) : null));
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i10) {
        if (obj instanceof CancellableContinuation) {
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, n.f10413a, null, 2, null);
        }
        if (obj instanceof SelectInstance) {
            TrySelectDetailedResult trySelectDetailedResultTrySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, n.f10413a);
            if (trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i10);
            }
            return trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int i10, long j10) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
        if (!(state$kotlinx_coroutines_core instanceof Waiter) || j10 < receivers$volatile$FU.get(this) || !channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
            return updateCellExpandBufferSlow(channelSegment, i10, j10);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i10)) {
            channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.BUFFERED);
            return true;
        }
        channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.INTERRUPTED_SEND);
        channelSegment.onCancelledRequest(i10, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int i10, long j10) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                if (j10 < receivers$volatile$FU.get(this)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i10)) {
                        channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i10, false);
                    return false;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return true;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int i10, long j10, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
        if (state$kotlinx_coroutines_core == null) {
            if (j10 >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return channelSegment.retrieveElement$kotlinx_coroutines_core(i10);
        }
        return updateCellReceiveSlow(channelSegment, i10, j10, obj);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> channelSegment, int i10, long j10, Object obj) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (j10 < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.INTERRUPTED_SEND && state$kotlinx_coroutines_core != BufferedChannelKt.POISONED) {
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            expandBuffer();
                            return BufferedChannelKt.FAILED;
                        }
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV)) {
                            boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                            if (z) {
                                state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                            }
                            if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i10)) {
                                channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.DONE_RCV);
                                expandBuffer();
                                return channelSegment.retrieveElement$kotlinx_coroutines_core(i10);
                            }
                            channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.INTERRUPTED_SEND);
                            channelSegment.onCancelledRequest(i10, false);
                            if (z) {
                                expandBuffer();
                            }
                            return BufferedChannelKt.FAILED;
                        }
                    }
                    return BufferedChannelKt.FAILED;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return channelSegment.retrieveElement$kotlinx_coroutines_core(i10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> channelSegment, int i10, E e10, long j10, Object obj, boolean z) {
        channelSegment.storeElement$kotlinx_coroutines_core(i10, e10);
        if (z) {
            return updateCellSendSlow(channelSegment, i10, e10, j10, obj, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(j10)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i10, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i10, null, obj)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i10);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, e10)) {
                channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            }
            if (channelSegment.getAndSetState$kotlinx_coroutines_core(i10, BufferedChannelKt.INTERRUPTED_RCV) == BufferedChannelKt.INTERRUPTED_RCV) {
                return 5;
            }
            channelSegment.onCancelledRequest(i10, true);
            return 5;
        }
        return updateCellSendSlow(channelSegment, i10, e10, j10, obj, z);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int i10, E e10, long j10, Object obj, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i10);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j10) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i10, null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onCancelledRequest(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (channelSegment.casState$kotlinx_coroutines_core(i10, null, obj)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i10, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                        channelSegment.cleanElement$kotlinx_coroutines_core(i10);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                        channelSegment.cleanElement$kotlinx_coroutines_core(i10);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        channelSegment.cleanElement$kotlinx_coroutines_core(i10);
                        completeCloseOrCancel();
                        return 4;
                    }
                    channelSegment.cleanElement$kotlinx_coroutines_core(i10);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, e10)) {
                        channelSegment.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.DONE_RCV);
                        onReceiveDequeued();
                        return 0;
                    }
                    if (channelSegment.getAndSetState$kotlinx_coroutines_core(i10, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                        channelSegment.onCancelledRequest(i10, true);
                    }
                    return 5;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            }
        }
    }

    private final void updateReceiversCounterIfLower(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            long j12 = j10;
            if (receivers$volatile$FU.compareAndSet(bufferedChannel, j11, j12)) {
                return;
            }
            this = bufferedChannel;
            j10 = j12;
        }
    }

    private final void updateSendersCounterIfLower(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            long j12 = 1152921504606846975L & j11;
            if (j12 >= j10) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            if (sendersAndCloseStatus$volatile$FU.compareAndSet(bufferedChannel, j11, BufferedChannelKt.constructSendersAndCloseStatus(j12, (int) (j11 >> 60)))) {
                return;
            } else {
                this = bufferedChannel;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public boolean closeOrCancelImpl(Throwable th, boolean z) {
        boolean z3;
        if (z) {
            markCancellationStarted();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$volatile$FU;
        Symbol symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, th)) {
                z3 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != symbol) {
                z3 = false;
                break;
            }
        }
        if (z) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (z3) {
            invokeCloseHandler();
        }
        return z3;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j10) {
        ChannelSegment<E> channelSegment;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            long j11 = receivers$volatile$FU.get(this);
            if (j10 < Math.max(this.capacity + j11, this.getBufferEndCounter())) {
                return;
            }
            BufferedChannel<E> bufferedChannel = this;
            if (receivers$volatile$FU.compareAndSet(bufferedChannel, j11, 1 + j11)) {
                int i10 = BufferedChannelKt.SEGMENT_SIZE;
                long j12 = j11 / i10;
                int i11 = (int) (j11 % i10);
                if (channelSegment2.f10114id != j12) {
                    ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j12, channelSegment2);
                    if (channelSegmentFindSegmentReceive != null) {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i11, j11, null);
                if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                    channelSegment.cleanPrev();
                    l<E, n> lVar = bufferedChannel.onUndeliveredElement;
                    if (lVar != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, objUpdateCellReceive, null, 2, null)) != null) {
                        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
                    }
                } else if (j11 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                this = bufferedChannel;
                channelSegment2 = channelSegment;
            }
            this = bufferedChannel;
        }
    }

    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException("Channel was closed") : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> channelSegmentFindSegmentReceive = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j10 = receiversCounter$kotlinx_coroutines_core / i10;
            if (channelSegmentFindSegmentReceive.f10114id == j10 || (channelSegmentFindSegmentReceive = findSegmentReceive(j10, channelSegmentFindSegmentReceive)) != null) {
                channelSegmentFindSegmentReceive.cleanPrev();
                if (isCellNonEmpty(channelSegmentFindSegmentReceive, (int) (receiversCounter$kotlinx_coroutines_core % i10), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).f10114id < j10) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(l<? super Throwable, n> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$volatile$FU;
                while (true) {
                    Object obj = atomicReferenceFieldUpdater2.get(this);
                    if (obj != BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                        if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = closeHandler$volatile$FU;
                    Symbol symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
                    Symbol symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                    while (!atomicReferenceFieldUpdater3.compareAndSet(this, symbol, symbol2)) {
                        if (atomicReferenceFieldUpdater3.get(this) != symbol) {
                            break;
                        }
                    }
                    lVar.invoke(getCloseCause());
                    return;
                }
            }
        }
    }

    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(b<? super E> bVar) {
        return receive$suspendImpl(this, bVar);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo147receiveCatchingJP2dKIU(b<? super ChannelResult<? extends E>> bVar) {
        return m145receiveCatchingJP2dKIU$suspendImpl(this, bVar);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e10, b<? super n> bVar) {
        return send$suspendImpl(this, e10, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x01cb, code lost:
    
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d2, code lost:
    
        if (r3 != null) goto L97;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo148tryReceivePtdJZtk() {
        ChannelSegment channelSegmentFindSegmentReceive;
        long j10 = receivers$volatile$FU.get(this);
        long j11 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j11)) {
            return ChannelResult.Companion.m163closedJP2dKIU(getCloseCause());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return ChannelResult.Companion.m164failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!this.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i10 = BufferedChannelKt.SEGMENT_SIZE;
            long j12 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (channelSegment.f10114id != j12) {
                channelSegmentFindSegmentReceive = this.findSegmentReceive(j12, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                }
            } else {
                channelSegmentFindSegmentReceive = channelSegment;
            }
            BufferedChannel<E> bufferedChannel = this;
            Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i11, andIncrement, obj);
            channelSegment = channelSegmentFindSegmentReceive;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    bufferedChannel.prepareReceiverForSuspension(waiter, channelSegment, i11);
                }
                bufferedChannel.waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
                return ChannelResult.Companion.m164failurePtdJZtk();
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m165successJP2dKIU(objUpdateCellReceive);
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            this = bufferedChannel;
        }
        return ChannelResult.Companion.m163closedJP2dKIU(this.getCloseCause());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo149trySendJP2dKIU(E e10) {
        E e11;
        int i10;
        ChannelSegment channelSegment;
        BufferedChannel<E> bufferedChannel;
        if (shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            return ChannelResult.Companion.m164failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = this.isClosedForSend0(andIncrement);
            int i11 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i11;
            int i12 = (int) (j10 % i11);
            if (channelSegment2.f10114id != j11) {
                ChannelSegment channelSegmentFindSegmentSend = this.findSegmentSend(j11, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    i10 = i12;
                    channelSegment = channelSegmentFindSegmentSend;
                    bufferedChannel = this;
                    e11 = e10;
                } else if (zIsClosedForSend0) {
                    return ChannelResult.Companion.m163closedJP2dKIU(this.getSendException());
                }
            } else {
                e11 = e10;
                i10 = i12;
                channelSegment = channelSegment2;
                bufferedChannel = this;
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i10, e11, j10, obj, zIsClosedForSend0);
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            channelSegment2 = channelSegment;
            if (iUpdateCellSend == 0) {
                channelSegment2.cleanPrev();
                return ChannelResult.Companion.m165successJP2dKIU(n.f10413a);
            }
            if (iUpdateCellSend == 1) {
                return ChannelResult.Companion.m165successJP2dKIU(n.f10413a);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment2.onSlotCleaned();
                    return ChannelResult.Companion.m163closedJP2dKIU(bufferedChannel2.getSendException());
                }
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    bufferedChannel2.prepareSenderForSuspension(waiter, channelSegment2, i10);
                }
                channelSegment2.onSlotCleaned();
                return ChannelResult.Companion.m164failurePtdJZtk();
            }
            if (iUpdateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iUpdateCellSend == 4) {
                if (j10 < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                return ChannelResult.Companion.m163closedJP2dKIU(bufferedChannel2.getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment2.cleanPrev();
            }
            this = bufferedChannel2;
            e10 = e11;
        }
    }

    /* renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    public final Object m150trySendDropOldestJP2dKIU(E e10) {
        ChannelSegment channelSegmentFindSegmentSend;
        int i10;
        BufferedChannel<E> bufferedChannel;
        Object obj = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = this.isClosedForSend0(andIncrement);
            int i11 = BufferedChannelKt.SEGMENT_SIZE;
            long j11 = j10 / i11;
            int i12 = (int) (j10 % i11);
            if (channelSegment.f10114id != j11) {
                channelSegmentFindSegmentSend = this.findSegmentSend(j11, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    bufferedChannel = this;
                    i10 = i12;
                } else if (zIsClosedForSend0) {
                    return ChannelResult.Companion.m163closedJP2dKIU(this.getSendException());
                }
            } else {
                channelSegmentFindSegmentSend = channelSegment;
                i10 = i12;
                bufferedChannel = this;
            }
            E e11 = e10;
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegmentFindSegmentSend, i10, e11, j10, obj, zIsClosedForSend0);
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            channelSegment = channelSegmentFindSegmentSend;
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m165successJP2dKIU(n.f10413a);
            }
            if (iUpdateCellSend == 1) {
                return ChannelResult.Companion.m165successJP2dKIU(n.f10413a);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return ChannelResult.Companion.m163closedJP2dKIU(bufferedChannel2.getSendException());
                }
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    bufferedChannel2.prepareSenderForSuspension(waiter, channelSegment, i10);
                }
                bufferedChannel2.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.f10114id * i11) + i10);
                return ChannelResult.Companion.m165successJP2dKIU(n.f10413a);
            }
            if (iUpdateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iUpdateCellSend == 4) {
                if (j10 < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return ChannelResult.Companion.m163closedJP2dKIU(bufferedChannel2.getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            this = bufferedChannel2;
            e10 = e11;
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j10) {
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (bufferedChannel.getBufferEndCounter() <= j10) {
            bufferedChannel = this;
        }
        int i10 = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i11 = 0; i11 < i10; i11++) {
            long bufferEndCounter = bufferedChannel.getBufferEndCounter();
            if (bufferEndCounter == (4611686018427387903L & completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel)) && bufferEndCounter == bufferedChannel.getBufferEndCounter()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(bufferedChannel);
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j11, BufferedChannelKt.constructEBCompletedAndPauseFlag(j11 & 4611686018427387903L, true))) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        while (true) {
            long bufferEndCounter2 = bufferedChannel.getBufferEndCounter();
            long j12 = completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel);
            long j13 = j12 & 4611686018427387903L;
            boolean z = (4611686018427387904L & j12) != 0;
            if (bufferEndCounter2 == j13 && bufferEndCounter2 == bufferedChannel.getBufferEndCounter()) {
                break;
            }
            if (z) {
                bufferedChannel = this;
            } else {
                bufferedChannel = this;
                completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(bufferedChannel, j12, BufferedChannelKt.constructEBCompletedAndPauseFlag(j13, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$volatile$FU;
        while (true) {
            long j14 = atomicLongFieldUpdater2.get(bufferedChannel);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j14, BufferedChannelKt.constructEBCompletedAndPauseFlag(j14 & 4611686018427387903L, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            bufferedChannel = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e<n> bindCancellationFun(l<? super E, n> lVar) {
        return new AnonymousClass2(this);
    }

    public void onClosedIdempotent() {
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }
}
