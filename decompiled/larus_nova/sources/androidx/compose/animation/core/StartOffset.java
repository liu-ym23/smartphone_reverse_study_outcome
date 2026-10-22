package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "value", "", "constructor-impl", "(J)J", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "(II)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "hashCode", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class StartOffset {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m171boximpl(long r100) {
        return new StartOffset(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m173constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m175equalsimpl(long r100, Object r101) {
        if ((r101 instanceof StartOffset) == true) goto L6;
        return false;
    L6:
        if (r100 == ((StartOffset) r101).m181unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m176equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m179hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m180toStringimpl(long r100) {
        return "StartOffset(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m175equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m179hashCodeimpl(this.value);
    }

    public String toString() {
        return m180toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m181unboximpl() {
        return this.value;
    }

    private /* synthetic */ StartOffset(long r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m177getOffsetMillisimpl(long r100) {
        return Math.abs((int) r100);
    }

    /* JADX INFO: renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m178getOffsetTypeEo1U57Q(long r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L13;
        if (r101 == true) goto L12;
        return StartOffsetType.Companion.m189getDelayEo1U57Q();
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        return StartOffsetType.Companion.m190getFastForwardEo1U57Q();
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m172constructorimpl(int r100, int r101) {
        return m173constructorimpl(r100 * r101);
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m174constructorimpl$default(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = StartOffsetType.Companion.m189getDelayEo1U57Q();
    L6:
        return m172constructorimpl(r100, r101);
    }
}
