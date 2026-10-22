package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\b\u0092\u0001\u00020\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "constructor-impl", "(II)J", "value", "", "(J)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StartOffset {
    private final long value;

    private /* synthetic */ StartOffset(long j5) {
        this.value = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m172boximpl(long j5) {
        return new StartOffset(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m174constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m175constructorimpl$default(int i, int i6, int i10, e eVar) {
        if ((i10 & 2) != 0) {
            i6 = StartOffsetType.INSTANCE.m190getDelayEo1U57Q();
        }
        return m173constructorimpl(i, i6);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m176equalsimpl(long j5, Object obj) {
        return (obj instanceof StartOffset) && j5 == ((StartOffset) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m177equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m178getOffsetMillisimpl(long j5) {
        return Math.abs((int) j5);
    }

    /* renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m179getOffsetTypeEo1U57Q(long j5) {
        boolean z10 = j5 > 0;
        if (z10) {
            return StartOffsetType.INSTANCE.m191getFastForwardEo1U57Q();
        }
        if (z10) {
            throw new NoWhenBranchMatchedException();
        }
        return StartOffsetType.INSTANCE.m190getDelayEo1U57Q();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m180hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m181toStringimpl(long j5) {
        return "StartOffset(value=" + j5 + ')';
    }

    public boolean equals(Object obj) {
        return m176equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m180hashCodeimpl(this.value);
    }

    public String toString() {
        return m181toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m173constructorimpl(int i, int i6) {
        return m174constructorimpl(i * i6);
    }
}
