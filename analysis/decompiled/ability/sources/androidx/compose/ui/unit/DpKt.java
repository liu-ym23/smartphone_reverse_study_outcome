package androidx.compose.ui.unit;

import S7.a;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\n\u001a\"\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\f\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\u000e\u001a \u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0011\u0010\t\u001a \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0013\u0010\t\u001a$\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001a\u0010\t\u001a\u001c\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001c\u0010\t\u001a'\u0010\"\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b!\u0010\u0018\u001a \u0010(\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b&\u0010'\u001a\"\u0010\u0005\u001a\u00020%*\u00020%2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020%0\u0001H\u0086\b¢\u0006\u0004\b)\u0010*\u001a'\u0010\"\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b+\u0010,\u001a\u001f\u00101\u001a\u00020/2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0000H\u0007¢\u0006\u0004\b0\u0010'\u001a\"\u0010\u0005\u001a\u00020/*\u00020/2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020/0\u0001H\u0086\b¢\u0006\u0004\b2\u0010*\u001a\u001c\u0010\n\u001a\u00020/*\u00020\r2\u0006\u00103\u001a\u00020/H\u0087\n¢\u0006\u0004\b4\u00105\u001a\u001c\u0010\n\u001a\u00020/*\u00020\u00062\u0006\u00103\u001a\u00020/H\u0087\n¢\u0006\u0004\b4\u00106\u001a'\u0010\"\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020/2\u0006\u0010\u001f\u001a\u00020/2\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b7\u0010,\"\u001f\u0010=\u001a\u000208*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010<\u001a\u0004\b9\u0010:\"\u001f\u0010@\u001a\u000208*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010<\u001a\u0004\b>\u0010:\"\u001f\u0010E\u001a\u00020\u0000*\u00020\r8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010D\u001a\u0004\bA\u0010B\"\u001f\u0010E\u001a\u00020\u0000*\u00020\u000b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010G\u001a\u0004\bA\u0010F\"\u001f\u0010E\u001a\u00020\u0000*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010<\u001a\u0004\bA\u0010H\"\u001f\u0010K\u001a\u000208*\u00020\u00008Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010<\u001a\u0004\bI\u0010:\"\u001f\u0010=\u001a\u000208*\u00020%8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010O\u001a\u0004\bL\u0010M\"\u001f\u0010@\u001a\u000208*\u00020%8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010O\u001a\u0004\bP\u0010M\"\u001f\u0010=\u001a\u000208*\u00020/8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bS\u0010O\u001a\u0004\bR\u0010M\"\u001f\u0010@\u001a\u000208*\u00020/8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010O\u001a\u0004\bT\u0010M\"\u001e\u0010Y\u001a\u00020%*\u00020/8FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010O\u001a\u0004\bV\u0010W\"\u001f\u0010-\u001a\u00020\u0000*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b]\u0010^\u001a\u0004\b[\u0010\\\"\u001f\u0010.\u001a\u00020\u0000*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b`\u0010^\u001a\u0004\b_\u0010\\\"\u001f\u00103\u001a\u00020/*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010^\u001a\u0004\ba\u0010b¨\u0006d"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "Lkotlin/Function0;", "block", "takeOrElse-D5KLDUw", "(FLS7/a;)F", "takeOrElse", "", "other", "times-3ABfNKs", "(FF)F", "times", "", "(DF)F", "", "(IF)F", "a", "b", "min-YgX7TsA", "min", "max-YgX7TsA", "max", "minimumValue", "maximumValue", "coerceIn-2z7ARbQ", "(FFF)F", "coerceIn", "coerceAtLeast-YgX7TsA", "coerceAtLeast", "coerceAtMost-YgX7TsA", "coerceAtMost", "start", "stop", "fraction", "lerp-Md-fbLM", "lerp", "x", "y", "Landroidx/compose/ui/unit/DpOffset;", "DpOffset-YgX7TsA", "(FF)J", "DpOffset", "takeOrElse-gVKV90s", "(JLS7/a;)J", "lerp-xhh869w", "(JJF)J", "width", "height", "Landroidx/compose/ui/unit/DpSize;", "DpSize-YgX7TsA", "DpSize", "takeOrElse-itqla9I", "size", "times-6HolHcs", "(IJ)J", "(FJ)J", "lerp-IDex15A", "", "isSpecified-0680j_4", "(F)Z", "isSpecified-0680j_4$annotations", "(F)V", "isSpecified", "isUnspecified-0680j_4", "isUnspecified-0680j_4$annotations", "isUnspecified", "getDp", "(I)F", "getDp$annotations", "(I)V", "dp", "(D)F", "(D)V", "(F)F", "isFinite-0680j_4", "isFinite-0680j_4$annotations", "isFinite", "isSpecified-jo-Fl9I", "(J)Z", "isSpecified-jo-Fl9I$annotations", "(J)V", "isUnspecified-jo-Fl9I", "isUnspecified-jo-Fl9I$annotations", "isSpecified-EaSLcWc", "isSpecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "isUnspecified-EaSLcWc$annotations", "getCenter-EaSLcWc", "(J)J", "getCenter-EaSLcWc$annotations", "center", "Landroidx/compose/ui/unit/DpRect;", "getWidth", "(Landroidx/compose/ui/unit/DpRect;)F", "getWidth$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "getHeight$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "getSize$annotations", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DpKt {
    @Stable
    /* renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m6865DpOffsetYgX7TsA(float f, float f7) {
        return DpOffset.m6900constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Stable
    /* renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m6866DpSizeYgX7TsA(float f, float f7) {
        return DpSize.m6933constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Stable
    /* renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m6867coerceAtLeastYgX7TsA(float f, float f7) {
        if (f < f7) {
            f = f7;
        }
        return Dp.m6844constructorimpl(f);
    }

    @Stable
    /* renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m6868coerceAtMostYgX7TsA(float f, float f7) {
        if (f > f7) {
            f = f7;
        }
        return Dp.m6844constructorimpl(f);
    }

    @Stable
    /* renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m6869coerceIn2z7ARbQ(float f, float f7, float f9) {
        return Dp.m6844constructorimpl(AbstractC1451a.t(f, f7, f9));
    }

    /* renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m6870getCenterEaSLcWc(long j5) {
        float fM6844constructorimpl = Dp.m6844constructorimpl(DpSize.m6942getWidthD9Ej5fM(j5) / 2.0f);
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(DpSize.m6940getHeightD9Ej5fM(j5) / 2.0f);
        return DpOffset.m6900constructorimpl((Float.floatToRawIntBits(fM6844constructorimpl2) & 4294967295L) | (Float.floatToRawIntBits(fM6844constructorimpl) << 32));
    }

    @Stable
    /* renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m6871getCenterEaSLcWc$annotations(long j5) {
    }

    public static final float getDp(int i) {
        return Dp.m6844constructorimpl(i);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static final float getHeight(DpRect dpRect) {
        return Dp.m6844constructorimpl(dpRect.m6926getBottomD9Ej5fM() - dpRect.m6929getTopD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static final long getSize(DpRect dpRect) {
        return m6866DpSizeYgX7TsA(Dp.m6844constructorimpl(dpRect.m6928getRightD9Ej5fM() - dpRect.m6927getLeftD9Ej5fM()), Dp.m6844constructorimpl(dpRect.m6926getBottomD9Ej5fM() - dpRect.m6929getTopD9Ej5fM()));
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static final float getWidth(DpRect dpRect) {
        return Dp.m6844constructorimpl(dpRect.m6928getRightD9Ej5fM() - dpRect.m6927getLeftD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m6872isFinite0680j_4(float f) {
        return (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040;
    }

    @Stable
    /* renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m6873isFinite0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m6874isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    @Stable
    /* renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m6875isSpecified0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m6876isSpecifiedEaSLcWc(long j5) {
        return j5 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m6877isSpecifiedEaSLcWc$annotations(long j5) {
    }

    /* renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m6878isSpecifiedjoFl9I(long j5) {
        return j5 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m6879isSpecifiedjoFl9I$annotations(long j5) {
    }

    /* renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m6880isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    @Stable
    /* renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m6881isUnspecified0680j_4$annotations(float f) {
    }

    /* renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m6882isUnspecifiedEaSLcWc(long j5) {
        return j5 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m6883isUnspecifiedEaSLcWc$annotations(long j5) {
    }

    /* renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m6884isUnspecifiedjoFl9I(long j5) {
        return j5 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m6885isUnspecifiedjoFl9I$annotations(long j5) {
    }

    @Stable
    /* renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m6886lerpIDex15A(long j5, long j6, float f) {
        float fM6887lerpMdfbLM = m6887lerpMdfbLM(DpSize.m6942getWidthD9Ej5fM(j5), DpSize.m6942getWidthD9Ej5fM(j6), f);
        float fM6887lerpMdfbLM2 = m6887lerpMdfbLM(DpSize.m6940getHeightD9Ej5fM(j5), DpSize.m6940getHeightD9Ej5fM(j6), f);
        return DpSize.m6933constructorimpl((Float.floatToRawIntBits(fM6887lerpMdfbLM) << 32) | (Float.floatToRawIntBits(fM6887lerpMdfbLM2) & 4294967295L));
    }

    @Stable
    /* renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m6887lerpMdfbLM(float f, float f7, float f9) {
        return Dp.m6844constructorimpl(MathHelpersKt.lerp(f, f7, f9));
    }

    @Stable
    /* renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m6888lerpxhh869w(long j5, long j6, float f) {
        float fLerp = MathHelpersKt.lerp(DpOffset.m6905getXD9Ej5fM(j5), DpOffset.m6905getXD9Ej5fM(j6), f);
        float fLerp2 = MathHelpersKt.lerp(DpOffset.m6907getYD9Ej5fM(j5), DpOffset.m6907getYD9Ej5fM(j6), f);
        return DpOffset.m6900constructorimpl((Float.floatToRawIntBits(fLerp) << 32) | (Float.floatToRawIntBits(fLerp2) & 4294967295L));
    }

    @Stable
    /* renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m6889maxYgX7TsA(float f, float f7) {
        return Dp.m6844constructorimpl(Math.max(f, f7));
    }

    @Stable
    /* renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m6890minYgX7TsA(float f, float f7) {
        return Dp.m6844constructorimpl(Math.min(f, f7));
    }

    /* renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m6891takeOrElseD5KLDUw(float f, a aVar) {
        return !Float.isNaN(f) ? f : ((Dp) aVar.invoke()).m6858unboximpl();
    }

    /* renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m6892takeOrElsegVKV90s(long j5, a aVar) {
        return j5 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j5 : ((DpOffset) aVar.invoke()).m6913unboximpl();
    }

    /* renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m6893takeOrElseitqla9I(long j5, a aVar) {
        return j5 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j5 : ((DpSize) aVar.invoke()).getPackedValue();
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m6895times3ABfNKs(float f, float f7) {
        return Dp.m6844constructorimpl(f * f7);
    }

    @Stable
    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m6898times6HolHcs(int i, long j5) {
        return DpSize.m6948timesGh9hcWk(j5, i);
    }

    public static final float getDp(double d) {
        return Dp.m6844constructorimpl((float) d);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(float f) {
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m6894times3ABfNKs(double d, float f) {
        return Dp.m6844constructorimpl(((float) d) * f);
    }

    @Stable
    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m6897times6HolHcs(float f, long j5) {
        return DpSize.m6947timesGh9hcWk(j5, f);
    }

    public static final float getDp(float f) {
        return Dp.m6844constructorimpl(f);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(int i) {
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m6896times3ABfNKs(int i, float f) {
        return Dp.m6844constructorimpl(i * f);
    }
}
