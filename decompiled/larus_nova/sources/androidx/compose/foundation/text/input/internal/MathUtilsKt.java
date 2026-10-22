package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "findClosestRect", "Landroidx/compose/ui/geometry/Offset;", "rect1", "Landroidx/compose/ui/geometry/Rect;", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "distanceSquaredToClosestCornerFromOutside", "", SVGRenderEngine.RECT, "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MathUtilsKt {
    /* JADX INFO: renamed from: distanceSquaredToClosestCornerFromOutside-3MmeM6k, reason: not valid java name */
    private static final float m1265distanceSquaredToClosestCornerFromOutside3MmeM6k(long r100, Rect r101) {
        if (SelectionManagerKt.m1486containsInclusiveUv8p0NA(r101, r100) == false) goto L6;
        return 0.0f;
    L6:
        float r102 = Offset.m4581getDistanceSquaredimpl(Offset.m4586minusMKHz9U(r101.m4617getTopLeftF1C5BW0(), r100));
        if (r102 < Float.MAX_VALUE) goto L10;
        r102 = Float.MAX_VALUE;
    L10:
        float r103 = Offset.m4581getDistanceSquaredimpl(Offset.m4586minusMKHz9U(r101.m4618getTopRightF1C5BW0(), r100));
        if (r103 >= r102) goto L13;
        r102 = r103;
    L13:
        float r104 = Offset.m4581getDistanceSquaredimpl(Offset.m4586minusMKHz9U(r101.m4610getBottomLeftF1C5BW0(), r100));
        if (r104 >= r102) goto L16;
        r102 = r104;
    L16:
        float r105 = Offset.m4581getDistanceSquaredimpl(Offset.m4586minusMKHz9U(r101.m4611getBottomRightF1C5BW0(), r100));
        if (r105 < r102) goto L19;
        return r102;
    L19:
        return r105;
    }

    public static final int addExactOrElse(int r100, int r101, Function0<Integer> r102) {
        int r103 = r100 + r101;
        if (((r100 ^ r103) & (r101 ^ r103)) < 0) goto L5;
        return r103;
    L5:
        return r102.invoke().intValue();
    }

    /* JADX INFO: renamed from: findClosestRect-9KIMszo, reason: not valid java name */
    public static final int m1266findClosestRect9KIMszo(long r100, Rect r101, Rect r102) {
        float r103 = m1265distanceSquaredToClosestCornerFromOutside3MmeM6k(r100, r101);
        float r104 = m1265distanceSquaredToClosestCornerFromOutside3MmeM6k(r100, r102);
        if (r103 != r104) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        return 0;
    L8:
        if (r103 >= r104) goto L11;
        return -1;
    L11:
        return 1;
    L5:
        r105 = false;
        goto L6
    }

    public static final int subtractExactOrElse(int r100, int r101, Function0<Integer> r102) {
        int r103 = r100 - r101;
        int r104 = r101 ^ r100;
        if (((r100 ^ r103) & r104) < 0) goto L5;
        return r103;
    L5:
        return r102.invoke().intValue();
    }
}
