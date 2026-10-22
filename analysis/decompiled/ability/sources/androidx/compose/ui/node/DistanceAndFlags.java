package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u0088\u0001\u0002¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/DistanceAndFlags;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "isInExpandedBounds", "isInExpandedBounds-impl", "compareTo", "", "other", "compareTo-9YPOF3E", "(JJ)I", "equals", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DistanceAndFlags {
    private final long packedValue;

    private /* synthetic */ DistanceAndFlags(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndFlags m5717boximpl(long j5) {
        return new DistanceAndFlags(j5);
    }

    /* renamed from: compareTo-9YPOF3E, reason: not valid java name */
    public static final int m5718compareTo9YPOF3E(long j5, long j6) {
        boolean zM5725isInLayerimpl = m5725isInLayerimpl(j5);
        if (zM5725isInLayerimpl != m5725isInLayerimpl(j6)) {
            return zM5725isInLayerimpl ? -1 : 1;
        }
        return (Math.min(m5722getDistanceimpl(j5), m5722getDistanceimpl(j6)) >= 0.0f && m5724isInExpandedBoundsimpl(j5) != m5724isInExpandedBoundsimpl(j6)) ? m5724isInExpandedBoundsimpl(j5) ? -1 : 1 : (int) Math.signum(m5722getDistanceimpl(j5) - m5722getDistanceimpl(j6));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5719constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5720equalsimpl(long j5, Object obj) {
        return (obj instanceof DistanceAndFlags) && j5 == ((DistanceAndFlags) obj).m5727unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5721equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m5722getDistanceimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5723hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isInExpandedBounds-impl, reason: not valid java name */
    public static final boolean m5724isInExpandedBoundsimpl(long j5) {
        return (j5 & 2) != 0;
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m5725isInLayerimpl(long j5) {
        return (j5 & 1) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5726toStringimpl(long j5) {
        return "DistanceAndFlags(packedValue=" + j5 + ')';
    }

    public boolean equals(Object other) {
        return m5720equalsimpl(this.packedValue, other);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return m5723hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5726toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5727unboximpl() {
        return this.packedValue;
    }
}
