package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\rB\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000fJ;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b$\u0010\"J\u0013\u0010%\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0088\u0001\u000e\u0092\u0001\u00020\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OrientationIndependentConstraints {
    private final long value;

    private /* synthetic */ OrientationIndependentConstraints(long j5) {
        this.value = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m666boximpl(long j5) {
        return new OrientationIndependentConstraints(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m668constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m670copyyUG9Ft0(long j5, int i, int i6, int i10, int i11) {
        return m667constructorimpl(i, i6, i10, i11);
    }

    /* renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m671copyyUG9Ft0$default(long j5, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = Constraints.m6799getMinWidthimpl(j5);
        }
        int i13 = i;
        if ((i12 & 2) != 0) {
            i6 = Constraints.m6797getMaxWidthimpl(j5);
        }
        int i14 = i6;
        if ((i12 & 4) != 0) {
            i10 = Constraints.m6798getMinHeightimpl(j5);
        }
        int i15 = i10;
        if ((i12 & 8) != 0) {
            i11 = Constraints.m6796getMaxHeightimpl(j5);
        }
        return m670copyyUG9Ft0(j5, i13, i14, i15, i11);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m672equalsimpl(long j5, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m6790equalsimpl0(j5, ((OrientationIndependentConstraints) obj).getValue());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m673equalsimpl0(long j5, long j6) {
        return Constraints.m6790equalsimpl0(j5, j6);
    }

    /* renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m674getCrossAxisMaximpl(long j5) {
        return Constraints.m6796getMaxHeightimpl(j5);
    }

    /* renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m675getCrossAxisMinimpl(long j5) {
        return Constraints.m6798getMinHeightimpl(j5);
    }

    /* renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m676getMainAxisMaximpl(long j5) {
        return Constraints.m6797getMaxWidthimpl(j5);
    }

    /* renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m677getMainAxisMinimpl(long j5) {
        return Constraints.m6799getMinWidthimpl(j5);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m678hashCodeimpl(long j5) {
        return Constraints.m6800hashCodeimpl(j5);
    }

    /* renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m679maxHeightimpl(long j5, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m6796getMaxHeightimpl(j5) : Constraints.m6797getMaxWidthimpl(j5);
    }

    /* renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m680maxWidthimpl(long j5, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m6797getMaxWidthimpl(j5) : Constraints.m6796getMaxHeightimpl(j5);
    }

    /* renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m681stretchCrossAxisq4ezo7Y(long j5) {
        return m667constructorimpl(Constraints.m6799getMinWidthimpl(j5), Constraints.m6797getMaxWidthimpl(j5), Constraints.m6796getMaxHeightimpl(j5) != Integer.MAX_VALUE ? Constraints.m6796getMaxHeightimpl(j5) : Constraints.m6798getMinHeightimpl(j5), Constraints.m6796getMaxHeightimpl(j5));
    }

    /* renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m682toBoxConstraintsOenEA2s(long j5, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? ConstraintsKt.Constraints(Constraints.m6799getMinWidthimpl(j5), Constraints.m6797getMaxWidthimpl(j5), Constraints.m6798getMinHeightimpl(j5), Constraints.m6796getMaxHeightimpl(j5)) : ConstraintsKt.Constraints(Constraints.m6798getMinHeightimpl(j5), Constraints.m6796getMaxHeightimpl(j5), Constraints.m6799getMinWidthimpl(j5), Constraints.m6797getMaxWidthimpl(j5));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m683toStringimpl(long j5) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.m6802toStringimpl(j5)) + ')';
    }

    public boolean equals(Object obj) {
        return m672equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m678hashCodeimpl(this.value);
    }

    public String toString() {
        return m683toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m667constructorimpl(int i, int i6, int i10, int i11) {
        return m668constructorimpl(ConstraintsKt.Constraints(i, i6, i10, i11));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m669constructorimpl(long j5, LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        return m667constructorimpl(layoutOrientation == layoutOrientation2 ? Constraints.m6799getMinWidthimpl(j5) : Constraints.m6798getMinHeightimpl(j5), layoutOrientation == layoutOrientation2 ? Constraints.m6797getMaxWidthimpl(j5) : Constraints.m6796getMaxHeightimpl(j5), layoutOrientation == layoutOrientation2 ? Constraints.m6798getMinHeightimpl(j5) : Constraints.m6799getMinWidthimpl(j5), layoutOrientation == layoutOrientation2 ? Constraints.m6796getMaxHeightimpl(j5) : Constraints.m6797getMaxWidthimpl(j5));
    }
}
