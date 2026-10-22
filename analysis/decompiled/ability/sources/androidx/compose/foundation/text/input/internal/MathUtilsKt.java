package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a*\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a&\u0010\r\u001a\u00020\u0000*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"", "right", "Lkotlin/Function0;", "defaultValue", "addExactOrElse", "(IILS7/a;)I", "subtractExactOrElse", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "findClosestRect", "rect", "", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "distanceSquaredToClosestCornerFromOutside", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i6, S7.a aVar) {
        int i10 = i + i6;
        return ((i ^ i10) & (i6 ^ i10)) < 0 ? ((Number) aVar.invoke()).intValue() : i10;
    }

    /* renamed from: distanceSquaredToClosestCornerFromOutside-3MmeM6k, reason: not valid java name */
    private static final float m1205distanceSquaredToClosestCornerFromOutside3MmeM6k(long j5, Rect rect) {
        if (SelectionManagerKt.m1432containsInclusiveUv8p0NA(rect, j5)) {
            return 0.0f;
        }
        float fM3894getDistanceSquaredimpl = Offset.m3894getDistanceSquaredimpl(Offset.m3899minusMKHz9U(rect.m3930getTopLeftF1C5BW0(), j5));
        if (fM3894getDistanceSquaredimpl >= Float.MAX_VALUE) {
            fM3894getDistanceSquaredimpl = Float.MAX_VALUE;
        }
        float fM3894getDistanceSquaredimpl2 = Offset.m3894getDistanceSquaredimpl(Offset.m3899minusMKHz9U(rect.m3931getTopRightF1C5BW0(), j5));
        if (fM3894getDistanceSquaredimpl2 < fM3894getDistanceSquaredimpl) {
            fM3894getDistanceSquaredimpl = fM3894getDistanceSquaredimpl2;
        }
        float fM3894getDistanceSquaredimpl3 = Offset.m3894getDistanceSquaredimpl(Offset.m3899minusMKHz9U(rect.m3923getBottomLeftF1C5BW0(), j5));
        if (fM3894getDistanceSquaredimpl3 < fM3894getDistanceSquaredimpl) {
            fM3894getDistanceSquaredimpl = fM3894getDistanceSquaredimpl3;
        }
        float fM3894getDistanceSquaredimpl4 = Offset.m3894getDistanceSquaredimpl(Offset.m3899minusMKHz9U(rect.m3924getBottomRightF1C5BW0(), j5));
        return fM3894getDistanceSquaredimpl4 < fM3894getDistanceSquaredimpl ? fM3894getDistanceSquaredimpl4 : fM3894getDistanceSquaredimpl;
    }

    /* renamed from: findClosestRect-9KIMszo, reason: not valid java name */
    public static final int m1206findClosestRect9KIMszo(long j5, Rect rect, Rect rect2) {
        float fM1205distanceSquaredToClosestCornerFromOutside3MmeM6k = m1205distanceSquaredToClosestCornerFromOutside3MmeM6k(j5, rect);
        float fM1205distanceSquaredToClosestCornerFromOutside3MmeM6k2 = m1205distanceSquaredToClosestCornerFromOutside3MmeM6k(j5, rect2);
        if (fM1205distanceSquaredToClosestCornerFromOutside3MmeM6k == fM1205distanceSquaredToClosestCornerFromOutside3MmeM6k2) {
            return 0;
        }
        return fM1205distanceSquaredToClosestCornerFromOutside3MmeM6k < fM1205distanceSquaredToClosestCornerFromOutside3MmeM6k2 ? -1 : 1;
    }

    public static final int subtractExactOrElse(int i, int i6, S7.a aVar) {
        int i10 = i - i6;
        return ((i ^ i10) & (i6 ^ i)) < 0 ? ((Number) aVar.invoke()).intValue() : i10;
    }
}
