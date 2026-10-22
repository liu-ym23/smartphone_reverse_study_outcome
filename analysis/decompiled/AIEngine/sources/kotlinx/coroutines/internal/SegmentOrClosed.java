package kotlinx.coroutines.internal;

import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.Segment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SegmentOrClosed<S extends Segment<S>> {
    /* renamed from: getSegment-impl, reason: not valid java name */
    public static final S m174getSegmentimpl(Object obj) {
        if (obj == ConcurrentLinkedListKt.CLOSED) {
            throw new IllegalStateException("Does not contain segment");
        }
        g.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m175isClosedimpl(Object obj) {
        return obj == ConcurrentLinkedListKt.CLOSED;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <S extends Segment<S>> Object m173constructorimpl(Object obj) {
        return obj;
    }
}
