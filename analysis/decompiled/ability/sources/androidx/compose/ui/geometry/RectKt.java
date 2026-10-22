package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\rH\u0007¨\u0006\u0014"}, d2 = {"Rect", "Landroidx/compose/ui/geometry/Rect;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "size", "Landroidx/compose/ui/geometry/Size;", "Rect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/Rect;", "topLeft", "bottomRight", "Rect-0a9Yr6o", "center", "radius", "", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "lerp", "start", "stop", "fraction", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RectKt {
    @Stable
    /* renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m3933Rect0a9Yr6o(long j5, long j6) {
        return new Rect(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 >> 32)), Float.intBitsToFloat((int) (j6 & 4294967295L)));
    }

    @Stable
    /* renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m3934Rect3MmeM6k(long j5, float f) {
        int i = (int) (j5 >> 32);
        int i6 = (int) (j5 & 4294967295L);
        return new Rect(Float.intBitsToFloat(i) - f, Float.intBitsToFloat(i6) - f, Float.intBitsToFloat(i) + f, Float.intBitsToFloat(i6) + f);
    }

    @Stable
    /* renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m3935Recttz77jQw(long j5, long j6) {
        int i = (int) (j5 >> 32);
        int i6 = (int) (j5 & 4294967295L);
        return new Rect(Float.intBitsToFloat(i), Float.intBitsToFloat(i6), Float.intBitsToFloat((int) (j6 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j6 & 4294967295L)) + Float.intBitsToFloat(i6));
    }

    @Stable
    public static final Rect lerp(Rect rect, Rect rect2, float f) {
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
