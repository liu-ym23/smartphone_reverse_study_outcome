package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u001a\"\u0010\n\u001a\u00020\u0002*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001f\u001a \u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b#\u0010\u001d\u001a \u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b%\u0010\u001d\u001a$\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b,\u0010\u001d\u001a\u001c\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b.\u0010\u001d\u001a'\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\b6\u0010*\u001a \u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b;\u0010<\u001a\"\u0010\n\u001a\u000208*\u0002082\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002080\fH\u0086\b¢\u0006\u0004\bC\u0010D\u001a'\u00102\u001a\u0002082\u0006\u00103\u001a\u0002082\u0006\u00104\u001a\u0002082\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\bE\u0010F\u001a\u001f\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u0002H\u0007¢\u0006\u0004\bK\u0010<\u001a\"\u0010\n\u001a\u00020H*\u00020H2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020H0\fH\u0086\b¢\u0006\u0004\bP\u0010D\u001a\u001c\u0010\u001a\u001a\u00020H*\u00020\u00102\u0006\u0010U\u001a\u00020HH\u0087\n¢\u0006\u0004\bV\u0010W\u001a\u001c\u0010\u001a\u001a\u00020H*\u00020\u00182\u0006\u0010U\u001a\u00020HH\u0087\n¢\u0006\u0004\bV\u0010X\u001a'\u00102\u001a\u00020H2\u0006\u00103\u001a\u00020H2\u0006\u00104\u001a\u00020H2\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\bY\u0010F\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00108Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00188Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0013\u0010\u0019\"\u001f\u0010/\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001f\u0010\u0000\u001a\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u001f\u0010\u0007\u001a\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010>\u001a\u0004\bB\u0010@\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010>\u001a\u0004\bO\u0010@\"\u001e\u0010Q\u001a\u000208*\u00020H8FX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010>\u001a\u0004\bS\u0010T\"\u001f\u0010I\u001a\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u001f\u0010J\u001a\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\\\u001a\u0004\b`\u0010^\"\u001f\u0010U\u001a\u00020H*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010\\\u001a\u0004\bb\u0010c¨\u0006d"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/unit/Dp;", "isSpecified-0680j_4$annotations", "(F)V", "isSpecified-0680j_4", "(F)Z", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "dp", "", "getDp$annotations", "(I)V", "getDp", "(I)F", "", "(D)V", "(D)F", "", "(F)F", "times", "other", "times-3ABfNKs", "(FF)F", "(DF)F", "(IF)F", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "min-YgX7TsA", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "max-YgX7TsA", "coerceIn", "minimumValue", "maximumValue", "coerceIn-2z7ARbQ", "(FFF)F", "coerceAtLeast", "coerceAtLeast-YgX7TsA", "coerceAtMost", "coerceAtMost-YgX7TsA", "isFinite", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "DpOffset", "Landroidx/compose/ui/unit/DpOffset;", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "isSpecified-jo-Fl9I$annotations", "(J)V", "isSpecified-jo-Fl9I", "(J)Z", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "lerp-xhh869w", "(JJF)J", "DpSize", "Landroidx/compose/ui/unit/DpSize;", "width", "height", "DpSize-YgX7TsA", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "takeOrElse-itqla9I", "center", "getCenter-EaSLcWc$annotations", "getCenter-EaSLcWc", "(J)J", "size", "times-6HolHcs", "(IJ)J", "(FJ)J", "lerp-IDex15A", "Landroidx/compose/ui/unit/DpRect;", "getWidth$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getWidth", "(Landroidx/compose/ui/unit/DpRect;)F", "getHeight$annotations", "getHeight", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DpKt {
    /* JADX INFO: renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m7571getCenterEaSLcWc$annotations(long r100) {
    }

    public static /* synthetic */ void getDp$annotations(double r100) {
    }

    public static /* synthetic */ void getDp$annotations(float r100) {
    }

    public static /* synthetic */ void getDp$annotations(int r100) {
    }

    public static /* synthetic */ void getHeight$annotations(DpRect r100) {
    }

    public static /* synthetic */ void getSize$annotations(DpRect r100) {
    }

    public static /* synthetic */ void getWidth$annotations(DpRect r100) {
    }

    /* JADX INFO: renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m7573isFinite0680j_4$annotations(float r100) {
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m7575isSpecified0680j_4$annotations(float r100) {
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m7576isSpecifiedEaSLcWc(long r100) {
        if (r100 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m7577isSpecifiedEaSLcWc$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m7578isSpecifiedjoFl9I(long r100) {
        if (r100 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m7579isSpecifiedjoFl9I$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m7581isUnspecified0680j_4$annotations(float r100) {
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m7582isUnspecifiedEaSLcWc(long r100) {
        if (r100 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m7583isUnspecifiedEaSLcWc$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m7584isUnspecifiedjoFl9I(long r100) {
        if (r100 != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m7585isUnspecifiedjoFl9I$annotations(long r100) {
    }

    /* JADX INFO: renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m7570getCenterEaSLcWc(long r100) {
        float r101 = Dp.m7544constructorimpl(DpSize.m7642getWidthD9Ej5fM(r100) / 2.0f);
        float r102 = Dp.m7544constructorimpl(DpSize.m7640getHeightD9Ej5fM(r100) / 2.0f);
        long r103 = Float.floatToRawIntBits(r101);
        return DpOffset.m7600constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32));
    }

    public static final float getDp(double r100) {
        return Dp.m7544constructorimpl((float) r100);
    }

    public static final float getHeight(DpRect r100) {
        return Dp.m7544constructorimpl(r100.m7626getBottomD9Ej5fM() - r100.m7629getTopD9Ej5fM());
    }

    public static final long getSize(DpRect r100) {
        return m7566DpSizeYgX7TsA(Dp.m7544constructorimpl(r100.m7628getRightD9Ej5fM() - r100.m7627getLeftD9Ej5fM()), Dp.m7544constructorimpl(r100.m7626getBottomD9Ej5fM() - r100.m7629getTopD9Ej5fM()));
    }

    public static final float getWidth(DpRect r100) {
        return Dp.m7544constructorimpl(r100.m7628getRightD9Ej5fM() - r100.m7627getLeftD9Ej5fM());
    }

    /* JADX INFO: renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m7572isFinite0680j_4(float r100) {
        if ((Float.floatToRawIntBits(r100) & Integer.MAX_VALUE) >= 2139095040) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m7574isSpecified0680j_4(float r100) {
        return !Float.isNaN(r100);
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m7580isUnspecified0680j_4(float r100) {
        return Float.isNaN(r100);
    }

    public static final float getDp(int r100) {
        return Dp.m7544constructorimpl(r100);
    }

    public static final float getDp(float r100) {
        return Dp.m7544constructorimpl(r100);
    }

    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m7565DpOffsetYgX7TsA(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        return DpOffset.m7600constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m7566DpSizeYgX7TsA(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        return DpSize.m7633constructorimpl((((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32));
    }

    /* JADX INFO: renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m7567coerceAtLeastYgX7TsA(float r100, float r101) {
        return Dp.m7544constructorimpl(RangesKt.coerceAtLeast(r100, r101));
    }

    /* JADX INFO: renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m7568coerceAtMostYgX7TsA(float r100, float r101) {
        return Dp.m7544constructorimpl(RangesKt.coerceAtMost(r100, r101));
    }

    /* JADX INFO: renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m7589maxYgX7TsA(float r100, float r101) {
        return Dp.m7544constructorimpl(Math.max(r100, r101));
    }

    /* JADX INFO: renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m7590minYgX7TsA(float r100, float r101) {
        return Dp.m7544constructorimpl(Math.min(r100, r101));
    }

    /* JADX INFO: renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m7591takeOrElseD5KLDUw(float r100, Function0<Dp> r101) {
        if ((!Float.isNaN(r100)) == false) goto L6;
        return r100;
    L6:
        return r101.invoke().m7558unboximpl();
    }

    /* JADX INFO: renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m7592takeOrElsegVKV90s(long r100, Function0<DpOffset> r101) {
        if (r100 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r100;
    L9:
        return r101.invoke().m7613unboximpl();
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m7593takeOrElseitqla9I(long r100, Function0<DpSize> r101) {
        if (r100 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r100;
    L9:
        return r101.invoke().m7650unboximpl();
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m7594times3ABfNKs(double r100, float r101) {
        return Dp.m7544constructorimpl(((float) r100) * r101);
    }

    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m7597times6HolHcs(float r100, long r101) {
        return DpSize.m7647timesGh9hcWk(r101, r100);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m7596times3ABfNKs(int r100, float r101) {
        return Dp.m7544constructorimpl(r100 * r101);
    }

    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m7598times6HolHcs(int r100, long r101) {
        return DpSize.m7648timesGh9hcWk(r101, r100);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m7595times3ABfNKs(float r100, float r101) {
        return Dp.m7544constructorimpl(r100 * r101);
    }

    /* JADX INFO: renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m7569coerceIn2z7ARbQ(float r100, float r101, float r102) {
        return Dp.m7544constructorimpl(RangesKt.coerceIn(r100, r101, r102));
    }

    /* JADX INFO: renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m7586lerpIDex15A(long r100, long r101, float r102) {
        float r103 = m7587lerpMdfbLM(DpSize.m7642getWidthD9Ej5fM(r100), DpSize.m7642getWidthD9Ej5fM(r101), r102);
        float r104 = m7587lerpMdfbLM(DpSize.m7640getHeightD9Ej5fM(r100), DpSize.m7640getHeightD9Ej5fM(r101), r102);
        return DpSize.m7633constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m7587lerpMdfbLM(float r100, float r101, float r102) {
        return Dp.m7544constructorimpl(MathHelpersKt.lerp(r100, r101, r102));
    }

    /* JADX INFO: renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m7588lerpxhh869w(long r100, long r101, float r102) {
        float r103 = MathHelpersKt.lerp(DpOffset.m7605getXD9Ej5fM(r100), DpOffset.m7605getXD9Ej5fM(r101), r102);
        float r104 = MathHelpersKt.lerp(DpOffset.m7607getYD9Ej5fM(r100), DpOffset.m7607getYD9Ej5fM(r101), r102);
        return DpOffset.m7600constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
    }
}
