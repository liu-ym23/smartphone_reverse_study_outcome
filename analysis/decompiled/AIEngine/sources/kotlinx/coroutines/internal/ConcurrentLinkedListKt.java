package kotlinx.coroutines.internal;

import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n10) {
        while (true) {
            Object nextOrClosed = n10.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n10;
            }
            ?? r02 = (ConcurrentLinkedListNode) nextOrClosed;
            if (r02 != 0) {
                n10 = r02;
            } else if (n10.markAsClosed()) {
                return n10;
            }
        }
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S s8, long j10, p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s8.f10114id >= j10 && !s8.isRemoved()) {
                return SegmentOrClosed.m173constructorimpl(s8);
            }
            Object nextOrClosed = s8.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return SegmentOrClosed.m173constructorimpl(CLOSED);
            }
            S sInvoke = (S) ((ConcurrentLinkedListNode) nextOrClosed);
            if (sInvoke == null) {
                sInvoke = pVar.invoke(Long.valueOf(s8.f10114id + 1), s8);
                if (s8.trySetNext(sInvoke)) {
                    if (s8.isRemoved()) {
                        s8.remove();
                    }
                }
            }
            s8 = sInvoke;
        }
    }
}
