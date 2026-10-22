package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0003\"\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0015\u0010\u001f\u001a\u00020\u000e*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b \u0010\u001e\"\u0015\u0010!\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b!\u0010#\"\u0015\u0010$\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b$\u0010#\"\u0015\u0010%\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0015\u0010&\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b&\u0010#\"\u0015\u0010'\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b'\u0010#\"\u0015\u0010(\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010+\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b,\u0010*\"\u0015\u0010-\u001a\u00020\u0019*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00100\u001a\u00020\"*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b0\u0010#¨\u00065"}, d2 = {"RoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "left", "", "top", "right", "bottom", "radiusX", "radiusY", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "rect", "Landroidx/compose/ui/geometry/Rect;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "translate", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "boundingRect", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "safeInnerRect", "getSafeInnerRect", "isEmpty", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isFinite", "isRect", "isEllipse", "isCircle", "minDimension", "getMinDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "maxDimension", "getMaxDimension", "center", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isSimple", "lerp", "start", "stop", "fraction", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(Rect rect, float f, float f7) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f7);
    }

    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m3947RoundRectZAM2FJo(Rect rect, long j5, long j6, long j10, long j11) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j5, j6, j10, j11, null);
    }

    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m3949RoundRectgG7oq9Y(float f, float f7, float f9, float f10, long j5) {
        return RoundRect(f, f7, f9, f10, Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m3950RoundRectsniSvfs(Rect rect, long j5) {
        return RoundRect(rect, Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j5 & 4294967295L)));
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(RoundRect roundRect) {
        float width = (roundRect.getWidth() / 2.0f) + roundRect.getLeft();
        float height = (roundRect.getHeight() / 2.0f) + roundRect.getTop();
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(width) << 32) | (Float.floatToRawIntBits(height) & 4294967295L));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        float fMax = Math.max(Float.intBitsToFloat((int) (roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() >> 32)));
        float fMax2 = Math.max(Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (roundRect.m3946getTopRightCornerRadiuskKHJgLs() & 4294967295L)));
        return new Rect((fMax * 0.29289323f) + roundRect.getLeft(), (fMax2 * 0.29289323f) + roundRect.getTop(), roundRect.getRight() - (Math.max(Float.intBitsToFloat((int) (roundRect.m3946getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (roundRect.m3944getBottomRightCornerRadiuskKHJgLs() >> 32))) * 0.29289323f), roundRect.getBottom() - (Math.max(Float.intBitsToFloat((int) (roundRect.m3944getBottomRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() & 4294967295L))) * 0.29289323f));
    }

    public static final boolean isCircle(RoundRect roundRect) {
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        return roundRect.m3945getTopLeftCornerRadiuskKHJgLs() == roundRect.m3946getTopRightCornerRadiuskKHJgLs() && roundRect.m3946getTopRightCornerRadiuskKHJgLs() == roundRect.m3944getBottomRightCornerRadiuskKHJgLs() && roundRect.m3944getBottomRightCornerRadiuskKHJgLs() == roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() && ((double) roundRect.getWidth()) <= ((double) Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() >> 32))) * 2.0d && ((double) roundRect.getHeight()) <= ((double) Float.intBitsToFloat((int) (roundRect.m3945getTopLeftCornerRadiuskKHJgLs() & 4294967295L))) * 2.0d;
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        return (Float.floatToRawIntBits(roundRect.getLeft()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getTop()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getRight()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getBottom()) & Integer.MAX_VALUE) < 2139095040;
    }

    public static final boolean isRect(RoundRect roundRect) {
        long jM3945getTopLeftCornerRadiuskKHJgLs = roundRect.m3945getTopLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~jM3945getTopLeftCornerRadiuskKHJgLs) & (jM3945getTopLeftCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long jM3946getTopRightCornerRadiuskKHJgLs = roundRect.m3946getTopRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~jM3946getTopRightCornerRadiuskKHJgLs) & (jM3946getTopRightCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long jM3943getBottomLeftCornerRadiuskKHJgLs = roundRect.m3943getBottomLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~jM3943getBottomLeftCornerRadiuskKHJgLs) & (jM3943getBottomLeftCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long jM3944getBottomRightCornerRadiuskKHJgLs = roundRect.m3944getBottomRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        return (((~jM3944getBottomRightCornerRadiuskKHJgLs) & (jM3944getBottomRightCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0;
    }

    public static final boolean isSimple(RoundRect roundRect) {
        long jM3945getTopLeftCornerRadiuskKHJgLs = roundRect.m3945getTopLeftCornerRadiuskKHJgLs();
        return (jM3945getTopLeftCornerRadiuskKHJgLs >>> 32) == (jM3945getTopLeftCornerRadiuskKHJgLs & 4294967295L) && roundRect.m3945getTopLeftCornerRadiuskKHJgLs() == roundRect.m3946getTopRightCornerRadiuskKHJgLs() && roundRect.m3945getTopLeftCornerRadiuskKHJgLs() == roundRect.m3944getBottomRightCornerRadiuskKHJgLs() && roundRect.m3945getTopLeftCornerRadiuskKHJgLs() == roundRect.m3943getBottomLeftCornerRadiuskKHJgLs();
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m3868lerp3Ry4LBc(roundRect.m3945getTopLeftCornerRadiuskKHJgLs(), roundRect2.m3945getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m3868lerp3Ry4LBc(roundRect.m3946getTopRightCornerRadiuskKHJgLs(), roundRect2.m3946getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m3868lerp3Ry4LBc(roundRect.m3944getBottomRightCornerRadiuskKHJgLs(), roundRect2.m3944getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m3868lerp3Ry4LBc(roundRect.m3943getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m3943getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    /* renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m3951translateUv8p0NA(RoundRect roundRect, long j5) {
        int i = (int) (j5 >> 32);
        int i6 = (int) (4294967295L & j5);
        return new RoundRect(roundRect.getLeft() + Float.intBitsToFloat(i), Float.intBitsToFloat(i6) + roundRect.getTop(), roundRect.getRight() + Float.intBitsToFloat(i), Float.intBitsToFloat(i6) + roundRect.getBottom(), roundRect.m3945getTopLeftCornerRadiuskKHJgLs(), roundRect.m3946getTopRightCornerRadiuskKHJgLs(), roundRect.m3944getBottomRightCornerRadiuskKHJgLs(), roundRect.m3943getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final RoundRect RoundRect(float f, float f7, float f9, float f10, float f11, float f12) {
        long jM3849constructorimpl = CornerRadius.m3849constructorimpl((Float.floatToRawIntBits(f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L));
        return new RoundRect(f, f7, f9, f10, jM3849constructorimpl, jM3849constructorimpl, jM3849constructorimpl, jM3849constructorimpl, null);
    }
}
