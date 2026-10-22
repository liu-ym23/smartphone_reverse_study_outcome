package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public ConcurrentLinkedListNode(N n10) {
        this._prev$volatile = n10;
    }

    private final N getAliveSegmentLeft() {
        N n10 = (N) getPrev();
        while (n10 != null && n10.isRemoved()) {
            n10 = (N) _prev$volatile$FU.get(n10);
        }
        return n10;
    }

    private final N getAliveSegmentRight() {
        ConcurrentLinkedListNode next;
        N n10 = (N) getNext();
        g.c(n10);
        while (n10.isRemoved() && (next = n10.getNext()) != null) {
            n10 = (N) next;
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getNextOrClosed() {
        return _next$volatile$FU.get(this);
    }

    public final void cleanPrev() {
        _prev$volatile$FU.set(this, null);
    }

    public final N getNext() {
        Object nextOrClosed = getNextOrClosed();
        if (nextOrClosed == ConcurrentLinkedListKt.CLOSED) {
            return null;
        }
        return (N) nextOrClosed;
    }

    public final N getPrev() {
        return (N) _prev$volatile$FU.get(this);
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        return getNext() == null;
    }

    public final boolean markAsClosed() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$volatile$FU;
        Symbol symbol = ConcurrentLinkedListKt.CLOSED;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                return false;
            }
        }
        return true;
    }

    public final void remove() {
        if (isTail()) {
            return;
        }
        while (true) {
            ConcurrentLinkedListNode aliveSegmentLeft = getAliveSegmentLeft();
            ConcurrentLinkedListNode aliveSegmentRight = getAliveSegmentRight();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$volatile$FU;
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(aliveSegmentRight);
                ConcurrentLinkedListNode concurrentLinkedListNode = ((ConcurrentLinkedListNode) obj) == null ? null : aliveSegmentLeft;
                while (!atomicReferenceFieldUpdater.compareAndSet(aliveSegmentRight, obj, concurrentLinkedListNode)) {
                    if (atomicReferenceFieldUpdater.get(aliveSegmentRight) != obj) {
                        break;
                    }
                }
            }
            if (aliveSegmentLeft != null) {
                _next$volatile$FU.set(aliveSegmentLeft, aliveSegmentRight);
            }
            if (!aliveSegmentRight.isRemoved() || aliveSegmentRight.isTail()) {
                if (aliveSegmentLeft == null || !aliveSegmentLeft.isRemoved()) {
                    return;
                }
            }
        }
    }

    public final boolean trySetNext(N n10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, n10)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                return false;
            }
        }
        return true;
    }
}
