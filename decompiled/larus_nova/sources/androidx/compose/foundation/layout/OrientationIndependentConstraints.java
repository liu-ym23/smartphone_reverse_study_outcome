package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u000fJ\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001cJ5\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\b\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0012\u0010\t\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0012\u0010\n\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "value", "Landroidx/compose/ui/unit/Constraints;", "constructor-impl", "(J)J", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)J", "c", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "J", "getMainAxisMin-impl", "(J)I", "getMainAxisMax-impl", "getCrossAxisMin-impl", "getCrossAxisMax-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "maxWidth", "maxWidth-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxHeight", "maxHeight-impl", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class OrientationIndependentConstraints {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m697boximpl(long r100) {
        return new OrientationIndependentConstraints(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m699constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m703equalsimpl(long r100, Object r101) {
        if ((r101 instanceof OrientationIndependentConstraints) == true) goto L6;
        return false;
    L6:
        if (Constraints.m7480equalsimpl0(r100, ((OrientationIndependentConstraints) r101).m715unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m704equalsimpl0(long r100, long r101) {
        return Constraints.m7480equalsimpl0(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m709hashCodeimpl(long r100) {
        return Constraints.m7490hashCodeimpl(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m714toStringimpl(long r100) {
        return "OrientationIndependentConstraints(value=" + Constraints.m7492toStringimpl(r100) + ')';
    }

    public boolean equals(Object r100) {
        return m703equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m709hashCodeimpl(this.value);
    }

    public String toString() {
        return m714toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m715unboximpl() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m705getCrossAxisMaximpl(long r100) {
        return Constraints.m7486getMaxHeightimpl(r100);
    }

    /* JADX INFO: renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m706getCrossAxisMinimpl(long r100) {
        return Constraints.m7488getMinHeightimpl(r100);
    }

    /* JADX INFO: renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m707getMainAxisMaximpl(long r100) {
        return Constraints.m7487getMaxWidthimpl(r100);
    }

    /* JADX INFO: renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m708getMainAxisMinimpl(long r100) {
        return Constraints.m7489getMinWidthimpl(r100);
    }

    /* JADX INFO: renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m712stretchCrossAxisq4ezo7Y(long r100) {
        int r101 = Constraints.m7489getMinWidthimpl(r100);
        int r102 = Constraints.m7487getMaxWidthimpl(r100);
        if (Constraints.m7486getMaxHeightimpl(r100) == Integer.MAX_VALUE) goto L5;
        int r103 = Constraints.m7486getMaxHeightimpl(r100);
    L7:
        return m698constructorimpl(r101, r102, r103, Constraints.m7486getMaxHeightimpl(r100));
    L5:
        r103 = Constraints.m7488getMinHeightimpl(r100);
        goto L7
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m700constructorimpl(long r100, LayoutOrientation r101) {
        LayoutOrientation r102 = LayoutOrientation.Horizontal;
        if (r101 != r102) goto L5;
        int r103 = Constraints.m7489getMinWidthimpl(r100);
    L6:
        if (r101 != r102) goto L8;
        int r104 = Constraints.m7487getMaxWidthimpl(r100);
    L9:
        if (r101 != r102) goto L11;
        int r105 = Constraints.m7488getMinHeightimpl(r100);
    L12:
        if (r101 != r102) goto L14;
        int r106 = Constraints.m7486getMaxHeightimpl(r100);
    L16:
        return m698constructorimpl(r103, r104, r105, r106);
    L14:
        r106 = Constraints.m7487getMaxWidthimpl(r100);
        goto L16
    L11:
        r105 = Constraints.m7489getMinWidthimpl(r100);
        goto L12
    L8:
        r104 = Constraints.m7486getMaxHeightimpl(r100);
        goto L9
    L5:
        r103 = Constraints.m7488getMinHeightimpl(r100);
        goto L6
    }

    /* JADX INFO: renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m710maxHeightimpl(long r100, LayoutOrientation r101) {
        if (r101 != LayoutOrientation.Horizontal) goto L6;
        return Constraints.m7486getMaxHeightimpl(r100);
    L6:
        return Constraints.m7487getMaxWidthimpl(r100);
    }

    /* JADX INFO: renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m711maxWidthimpl(long r100, LayoutOrientation r101) {
        if (r101 != LayoutOrientation.Horizontal) goto L6;
        return Constraints.m7487getMaxWidthimpl(r100);
    L6:
        return Constraints.m7486getMaxHeightimpl(r100);
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m713toBoxConstraintsOenEA2s(long r100, LayoutOrientation r101) {
        if (r101 != LayoutOrientation.Horizontal) goto L6;
        return ConstraintsKt.Constraints(Constraints.m7489getMinWidthimpl(r100), Constraints.m7487getMaxWidthimpl(r100), Constraints.m7488getMinHeightimpl(r100), Constraints.m7486getMaxHeightimpl(r100));
    L6:
        return ConstraintsKt.Constraints(Constraints.m7488getMinHeightimpl(r100), Constraints.m7486getMaxHeightimpl(r100), Constraints.m7489getMinWidthimpl(r100), Constraints.m7487getMaxWidthimpl(r100));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m698constructorimpl(int r100, int r101, int r102, int r103) {
        return m699constructorimpl(ConstraintsKt.Constraints(r100, r101, r102, r103));
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m701copyyUG9Ft0(long r100, int r101, int r102, int r103, int r104) {
        return m698constructorimpl(r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m702copyyUG9Ft0$default(long r100, int r101, int r102, int r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = Constraints.m7489getMinWidthimpl(r100);
    L5:
        int r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = Constraints.m7487getMaxWidthimpl(r100);
    L8:
        int r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = Constraints.m7488getMinHeightimpl(r100);
    L11:
        int r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = Constraints.m7486getMaxHeightimpl(r100);
    L15:
        return m701copyyUG9Ft0(r100, r103, r104, r105, r111);
    }
}
