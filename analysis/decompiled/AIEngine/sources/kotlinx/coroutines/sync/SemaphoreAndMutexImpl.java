package kotlinx.coroutines.sync;

import b6.h;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import lb.n;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SemaphoreAndMutexImpl {
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private final q<Throwable, n, d, n> onCancellationRelease;
    private final int permits;
    private volatile /* synthetic */ Object tail$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");

    public SemaphoreAndMutexImpl(int i10, int i11) {
        this.permits = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i11 < 0 || i11 > i10) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "The number of acquired permits should be in 0..").toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = i10 - i11;
        this.onCancellationRelease = new h(this, 2);
    }

    private final Object acquireSlowPath(qb.b<? super n> bVar) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(jd.b.w(bVar));
        try {
            if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                acquire((CancellableContinuation<? super n>) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            return result == CoroutineSingletons.f10059a ? result : n.f10413a;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addAcquireToQueue(Waiter waiter) {
        Object objFindSegmentInternal;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) tail$volatile$FU.get(this);
        long andIncrement = enqIdx$volatile$FU.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$volatile$FU;
        long j10 = andIncrement / SemaphoreKt.SEGMENT_SIZE;
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j10, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
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
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
        int i10 = (int) (andIncrement % SemaphoreKt.SEGMENT_SIZE);
        AtomicReferenceArray acquirers = semaphoreSegment2.getAcquirers();
        while (!acquirers.compareAndSet(i10, null, waiter)) {
            if (acquirers.get(i10) != null) {
                Symbol symbol = SemaphoreKt.PERMIT;
                Symbol symbol2 = SemaphoreKt.TAKEN;
                AtomicReferenceArray acquirers2 = semaphoreSegment2.getAcquirers();
                while (!acquirers2.compareAndSet(i10, symbol, symbol2)) {
                    if (acquirers2.get(i10) != symbol) {
                        return false;
                    }
                }
                if (waiter instanceof CancellableContinuation) {
                    g.d(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((CancellableContinuation) waiter).resume(n.f10413a, this.onCancellationRelease);
                } else {
                    if (!(waiter instanceof SelectInstance)) {
                        throw new IllegalStateException(("unexpected: " + waiter).toString());
                    }
                    ((SelectInstance) waiter).selectInRegistrationPhase(n.f10413a);
                }
                return true;
            }
        }
        waiter.invokeOnCancellation(semaphoreSegment2, i10);
        return true;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        int i10;
        do {
            i10 = _availablePermits$volatile$FU.get(this);
            if (i10 <= this.permits) {
                return;
            }
        } while (!_availablePermits$volatile$FU.compareAndSet(this, i10, this.permits));
    }

    private final int decPermits() {
        int andDecrement;
        do {
            andDecrement = _availablePermits$volatile$FU.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCancellationRelease$lambda$2(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Throwable th, n nVar, d dVar) {
        semaphoreAndMutexImpl.release();
        return n.f10413a;
    }

    private final boolean tryResumeAcquire(Object obj) {
        if (!(obj instanceof CancellableContinuation)) {
            if (obj instanceof SelectInstance) {
                return ((SelectInstance) obj).trySelect(this, n.f10413a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
        Object objTryResume = cancellableContinuation.tryResume(n.f10413a, null, this.onCancellationRelease);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }

    private final boolean tryResumeNextFromQueue() {
        Object objFindSegmentInternal;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) head$volatile$FU.get(this);
        long andIncrement = deqIdx$volatile$FU.getAndIncrement(this);
        long j10 = andIncrement / SemaphoreKt.SEGMENT_SIZE;
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$volatile$FU;
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j10, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.m175isClosedimpl(objFindSegmentInternal)) {
                break;
            }
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
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m174getSegmentimpl(objFindSegmentInternal);
        semaphoreSegment2.cleanPrev();
        boolean z = false;
        if (semaphoreSegment2.f10114id > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % SemaphoreKt.SEGMENT_SIZE);
        Object andSet = semaphoreSegment2.getAcquirers().getAndSet(i10, SemaphoreKt.PERMIT);
        if (andSet != null) {
            if (andSet == SemaphoreKt.CANCELLED) {
                return false;
            }
            return tryResumeAcquire(andSet);
        }
        int i11 = SemaphoreKt.MAX_SPIN_CYCLES;
        for (int i12 = 0; i12 < i11; i12++) {
            if (semaphoreSegment2.getAcquirers().get(i10) == SemaphoreKt.TAKEN) {
                return true;
            }
        }
        Symbol symbol = SemaphoreKt.PERMIT;
        Symbol symbol2 = SemaphoreKt.BROKEN;
        AtomicReferenceArray acquirers = semaphoreSegment2.getAcquirers();
        while (true) {
            if (acquirers.compareAndSet(i10, symbol, symbol2)) {
                z = true;
                break;
            }
            if (acquirers.get(i10) != symbol) {
                break;
            }
        }
        return !z;
    }

    public final Object acquire(qb.b<? super n> bVar) {
        if (decPermits() > 0) {
            return n.f10413a;
        }
        Object objAcquireSlowPath = acquireSlowPath(bVar);
        return objAcquireSlowPath == CoroutineSingletons.f10059a ? objAcquireSlowPath : n.f10413a;
    }

    public final int getAvailablePermits() {
        return Math.max(_availablePermits$volatile$FU.get(this), 0);
    }

    public final void release() {
        do {
            int andIncrement = _availablePermits$volatile$FU.getAndIncrement(this);
            if (andIncrement >= this.permits) {
                coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!tryResumeNextFromQueue());
    }

    public final boolean tryAcquire() {
        while (true) {
            int i10 = _availablePermits$volatile$FU.get(this);
            if (i10 > this.permits) {
                coerceAvailablePermitsAtMaximum();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (_availablePermits$volatile$FU.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final void acquire(CancellableContinuation<? super n> cancellableContinuation) {
        while (decPermits() <= 0) {
            g.d(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.resume(n.f10413a, this.onCancellationRelease);
    }
}
