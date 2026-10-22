package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u0088\u0001\u0002¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/DistanceAndFlags;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "isInExpandedBounds", "isInExpandedBounds-impl", "compareTo", "", "other", "compareTo-9YPOF3E", "(JJ)I", "equals", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class DistanceAndFlags {
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndFlags m6424boximpl(long r100) {
        return new DistanceAndFlags(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m6426constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6427equalsimpl(long r100, Object r101) {
        if ((r101 instanceof DistanceAndFlags) == true) goto L6;
        return false;
    L6:
        if (r100 == ((DistanceAndFlags) r101).m6434unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6428equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6430hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: isInExpandedBounds-impl, reason: not valid java name */
    public static final boolean m6431isInExpandedBoundsimpl(long r100) {
        if ((r100 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m6432isInLayerimpl(long r100) {
        if ((r100 & 1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6433toStringimpl(long r100) {
        return "DistanceAndFlags(packedValue=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m6427equalsimpl(this.packedValue, r100);
    }

    public int hashCode() {
        return m6430hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m6433toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m6434unboximpl() {
        return this.packedValue;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ DistanceAndFlags(long r100) {
        this.packedValue = r100;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m6429getDistanceimpl(long r100) {
        return Float.intBitsToFloat((int) (r100 >> 32));
    }

    /* JADX INFO: renamed from: compareTo-9YPOF3E, reason: not valid java name */
    public static final int m6425compareTo9YPOF3E(long r100, long r101) {
        boolean r102 = m6432isInLayerimpl(r100);
        if (r102 == m6432isInLayerimpl(r101)) goto L8;
        if (r102 == true) goto L19;
        return 1;
    L19:
        return -1;
    L8:
        int r103 = (int) Math.signum(m6429getDistanceimpl(r100) - m6429getDistanceimpl(r101));
        if (Math.min(m6429getDistanceimpl(r100), m6429getDistanceimpl(r101)) >= 0.0f) goto L12;
        return r103;
    L12:
        if (m6431isInExpandedBoundsimpl(r100) != m6431isInExpandedBoundsimpl(r101)) goto L14;
        return r103;
    L14:
        if (m6431isInExpandedBoundsimpl(r100) == true) goto L20;
        return 1;
    L20:
        return -1;
    }
}
