package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a1\u0010\u0004\u001a\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a!\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0015\u001a#\u0010\u0018\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0015\u001a2\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\u001cH\u0000\u001a(\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0011\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0082\b\u001a\u0014\u0010)\u001a\u00020\f*\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0002\u001a\r\u0010+\u001a\u00020\f*\u00020\u001cH\u0082\b\u001a(\u0010,\u001a\f\u0012\b\u0012\u00060\u001cj\u0002`-0\u00062\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u00100\u001a,\u00101\u001a\u00020\f*\f\u0012\u0004\u0012\u00020\u001c0\u0006j\u0002`22\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0082\n¢\u0006\u0002\u00105\u001a4\u0010\u0004\u001a\u00020\u0005*\f\u0012\u0004\u0012\u00020\u001c0\u0006j\u0002`22\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u00106\u001a\u00020\fH\u0082\n¢\u0006\u0002\u00107\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"$\u00108\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\"$\u0010?\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>*\f\b\u0002\u0010(\"\u00020\u001c2\u00020\u001c*\u0018\b\u0002\u0010,\"\b\u0012\u0004\u0012\u00020\u001c0\u00062\b\u0012\u0004\u0012\u00020\u001c0\u0006¨\u0006C"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "HistorySize", "HorizonMilliseconds", "set", "", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "time", "", "dataPoint", "", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "addPointerInputChange", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange-0AR0LA0", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "addPointerInputChangeLegacy", "addPointerInputChangeLegacy-0AR0LA0", "addPointerInputChangeWithFix", "addPointerInputChangeWithFix-0AR0LA0", "DefaultWeight", "polyFitLeastSquares", "", "x", "y", "sampleCount", "degree", "coefficients", "calculateImpulseVelocity", "dataPoints", "isDataDifferential", "", "kineticEnergyToVelocity", "kineticEnergy", "Vector", "dot", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "norm", "Matrix", "Landroidx/compose/ui/input/pointer/util/Vector;", "rows", "cols", "(II)[[F", MonitorConstants.CONNECT_TYPE_GET, "Landroidx/compose/ui/input/pointer/util/Matrix;", SlcFlexDirection.FLEX_ROW, "col", "([[FII)F", "value", "([[FIIF)V", "VelocityTrackerAddPointsFix", "getVelocityTrackerAddPointsFix$annotations", "()V", "getVelocityTrackerAddPointsFix", "()Z", "setVelocityTrackerAddPointsFix", "(Z)V", "VelocityTrackerStrategyUseImpulse", "getVelocityTrackerStrategyUseImpulse$annotations", "getVelocityTrackerStrategyUseImpulse", "setVelocityTrackerStrategyUseImpulse", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static boolean VelocityTrackerAddPointsFix = true;
    private static boolean VelocityTrackerStrategyUseImpulse;

    public static /* synthetic */ void getVelocityTrackerAddPointsFix$annotations() {
    }

    public static /* synthetic */ void getVelocityTrackerStrategyUseImpulse$annotations() {
    }

    public static final boolean getVelocityTrackerAddPointsFix() {
        return VelocityTrackerAddPointsFix;
    }

    public static final boolean getVelocityTrackerStrategyUseImpulse() {
        return VelocityTrackerStrategyUseImpulse;
    }

    private static final float kineticEnergyToVelocity(float r100) {
        return Math.signum(r100) * ((float) Math.sqrt(2 * Math.abs(r100)));
    }

    private static final float norm(float[] r100) {
        return (float) Math.sqrt(dot(r100, r100));
    }

    public static final void setVelocityTrackerAddPointsFix(boolean r100) {
        VelocityTrackerAddPointsFix = r100;
    }

    public static final void setVelocityTrackerStrategyUseImpulse(boolean r100) {
        VelocityTrackerStrategyUseImpulse = r100;
    }

    private static final float[][] Matrix(int r100, int r101) {
        float[][] r102 = new float[r100][];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102[r103] = new float[r101];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final void addPointerInputChange(VelocityTracker r100, PointerInputChange r101) {
        m6229addPointerInputChange0AR0LA0(r100, r101, Offset.Companion.m4598getZeroF1C5BW0());
    }

    private static final float dot(float[] r100, float[] r101) {
        int r102 = r100.length;
        float r103 = 0.0f;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103 = r103 + (r100[r104] * r101[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    /* JADX INFO: renamed from: addPointerInputChange-0AR0LA0, reason: not valid java name */
    public static final void m6229addPointerInputChange0AR0LA0(VelocityTracker r100, PointerInputChange r101, long r102) {
        if (VelocityTrackerAddPointsFix == false) goto L5;
        m6231addPointerInputChangeWithFix0AR0LA0(r100, r101, r102);
        return;
    L5:
        m6230addPointerInputChangeLegacy0AR0LA0(r100, r101, r102);
    }

    /* JADX INFO: renamed from: addPointerInputChangeLegacy-0AR0LA0, reason: not valid java name */
    private static final void m6230addPointerInputChangeLegacy0AR0LA0(VelocityTracker r110, PointerInputChange r111, long r112) {
        if (PointerEventKt.changedToDownIgnoreConsumed(r111) == false) goto L5;
        r110.m6228setCurrentPointerPositionAccumulatork4lQ0M$ui_release(r111.m6126getPositionF1C5BW0());
        r110.resetTracking();
    L5:
        long r100 = r111.m6127getPreviousPositionF1C5BW0();
        List<HistoricalChange> r101 = r111.getHistorical();
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        HistoricalChange r104 = (HistoricalChange) ListProtector.get(r101, r103);
        long r105 = Offset.m4586minusMKHz9U(r104.m6050getPositionF1C5BW0(), r100);
        long r106 = r104.m6050getPositionF1C5BW0();
        r110.m6228setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m4587plusMKHz9U(r110.m6227getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), r105));
        r110.m6224addPositionUv8p0NA(r104.getUptimeMillis(), Offset.m4587plusMKHz9U(r110.m6227getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), r112));
        r103 = r103 + 1;
        r100 = r106;
        goto L6
    L8:
        long r107 = Offset.m4586minusMKHz9U(r111.m6126getPositionF1C5BW0(), r100);
        r110.m6228setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m4587plusMKHz9U(r110.m6227getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), r107));
        r110.m6224addPositionUv8p0NA(r111.getUptimeMillis(), Offset.m4587plusMKHz9U(r110.m6227getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), r112));
    }

    /* JADX INFO: renamed from: addPointerInputChangeWithFix-0AR0LA0, reason: not valid java name */
    private static final void m6231addPointerInputChangeWithFix0AR0LA0(VelocityTracker r100, PointerInputChange r101, long r110) {
        if (PointerEventKt.changedToDownIgnoreConsumed(r101) == false) goto L6;
        r100.resetTracking();
    L6:
        if (PointerEventKt.changedToUpIgnoreConsumed(r101) == true) goto L12;
        List<HistoricalChange> r102 = r101.getHistorical();
        int r103 = r102.size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        HistoricalChange r105 = (HistoricalChange) ListProtector.get(r102, r104);
        r100.m6224addPositionUv8p0NA(r105.getUptimeMillis(), Offset.m4587plusMKHz9U(r105.m6049getOriginalEventPositionF1C5BW0$ui_release(), r110));
        r104 = r104 + 1;
        goto L8
    L10:
        r100.m6224addPositionUv8p0NA(r101.getUptimeMillis(), Offset.m4587plusMKHz9U(r101.m6125getOriginalEventPositionF1C5BW0$ui_release(), r110));
    L12:
        if (PointerEventKt.changedToUpIgnoreConsumed(r101) == true) goto L14;
    L16:
        r100.setLastMoveEventTimeStamp$ui_release(r101.getUptimeMillis());
        return;
    L14:
        if ((r101.getUptimeMillis() - r100.getLastMoveEventTimeStamp$ui_release()) <= 40) goto L16;
        r100.resetTracking();
        goto L16
    }

    private static final float get(float[][] r100, int r101, int r102) {
        return r100[r101][r102];
    }

    public static final /* synthetic */ float access$calculateImpulseVelocity(float[] r100, float[] r101, int r102, boolean r103) {
        return calculateImpulseVelocity(r100, r101, r102, r103);
    }

    public static final /* synthetic */ void access$set(DataPointAtTime[] r100, int r101, long r102, float r103) {
        set(r100, r101, r102, r103);
    }

    private static final float calculateImpulseVelocity(float[] r100, float[] r110, int r111, boolean r112) {
        int r113 = r111 - 1;
        float r101 = r110[r113];
        float r102 = 0.0f;
        int r103 = r113;
    L4:
        if (r103 <= 0) goto L19;
        int r104 = r103 - 1;
        float r105 = r110[r104];
        if (r101 != r105) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L17;
        if (r112 == false) goto L13;
        float r107 = -r100[r104];
    L14:
        float r108 = r107 / (r101 - r105);
        r102 = r102 + ((r108 - (Math.signum(r102) * ((float) Math.sqrt(2 * Math.abs(r102))))) * Math.abs(r108));
        if (r103 != r113) goto L17;
        r102 = r102 * 0.5f;
        goto L17
    L13:
        r107 = r100[r103] - r100[r104];
    L17:
        r103 = r103 - 1;
        r101 = r105;
        goto L4
    L8:
        r106 = false;
        goto L9
    L19:
        return Math.signum(r102) * ((float) Math.sqrt(2 * Math.abs(r102)));
    }

    private static final void set(DataPointAtTime[] r100, int r101, long r102, float r103) {
        DataPointAtTime r104 = r100[r101];
        if (r104 != null) goto L5;
        r100[r101] = new DataPointAtTime(r102, r103);
        return;
    L5:
        r104.setTime(r102);
        r104.setDataPoint(r103);
    }

    private static final void set(float[][] r100, int r101, int r102, float r103) {
        r100[r101][r102] = r103;
    }

    public static final float[] polyFitLeastSquares(float[] r110, float[] r111, int r112, int r113, float[] r210) {
        int r100 = r113;
        if (r100 >= 1) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException("The degree must be at positive integer");
    L5:
        if (r112 != 0) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
    L7:
        if (r100 < r112) goto L9;
        r100 = r112 - 1;
    L9:
        int r101 = r100 + 1;
        float[][] r102 = new float[r101][];
        int r103 = 0;
    L10:
        if (r103 >= r101) goto L12;
        r102[r103] = new float[r112];
        r103 = r103 + 1;
        goto L10
    L12:
        int r104 = 0;
    L14:
        if (r104 >= r112) goto L19;
        r102[0][r104] = 1.0f;
        int r105 = 1;
    L16:
        if (r105 >= r101) goto L18;
        r102[r105][r104] = r102[r105 - 1][r104] * r110[r104];
        r105 = r105 + 1;
        goto L16
    L18:
        r104 = r104 + 1;
        goto L14
    L19:
        float[][] r106 = new float[r101][];
        int r107 = 0;
    L20:
        if (r107 >= r101) goto L22;
        r106[r107] = new float[r112];
        r107 = r107 + 1;
        goto L20
    L22:
        float[][] r108 = new float[r101][];
        int r109 = 0;
    L23:
        if (r109 >= r101) goto L25;
        r108[r109] = new float[r101];
        r109 = r109 + 1;
        goto L23
    L25:
        int r114 = 0;
    L26:
        if (r114 >= r101) goto L46;
        float[] r115 = r106[r114];
        ArraysKt.copyInto(r102[r114], r115, 0, 0, r112);
        int r116 = 0;
    L28:
        if (r116 >= r114) goto L33;
        float[] r117 = r106[r116];
        float r118 = dot(r115, r117);
        int r119 = 0;
    L30:
        if (r119 >= r112) goto L32;
        r115[r119] = r115[r119] - (r117[r119] * r118);
        r119 = r119 + 1;
        goto L30
    L32:
        r116 = r116 + 1;
        goto L28
    L33:
        float r120 = (float) Math.sqrt(dot(r115, r115));
        if (r120 >= 1.0E-6f) goto L36;
        r120 = 1.0E-6f;
    L36:
        float r121 = 1.0f / r120;
        int r122 = 0;
    L37:
        if (r122 >= r112) goto L39;
        r115[r122] = r115[r122] * r121;
        r122 = r122 + 1;
        goto L37
    L39:
        float[] r123 = r108[r114];
        int r124 = 0;
    L40:
        if (r124 >= r101) goto L45;
        if (r124 >= r114) goto L43;
        float r125 = 0.0f;
    L44:
        r123[r124] = r125;
        r124 = r124 + 1;
        goto L40
    L43:
        r125 = dot(r115, r102[r124]);
        goto L44
    L45:
        r114 = r114 + 1;
        goto L26
    L46:
        int r126 = r101 - 1;
        int r127 = r126;
    L48:
        if ((-1) >= r127) goto L56;
        float r128 = dot(r106[r127], r111);
        float[] r129 = r108[r127];
        int r130 = r127 + 1;
        if (r130 > r126) goto L55;
        int r131 = r126;
    L52:
        r128 = r128 - (r129[r131] * r210[r131]);
        if (r131 == r130) goto L55;
        r131 = r131 - 1;
    L55:
        r210[r127] = r128 / r129[r127];
        r127 = r127 - 1;
        goto L48
    L56:
        return r210;
    }

    public static /* synthetic */ float[] polyFitLeastSquares$default(float[] r100, float[] r101, int r102, int r103, float[] r104, int r105, Object r106) {
        if ((r105 & 16) == 0) goto L6;
        r104 = new float[RangesKt.coerceAtLeast(r103 + 1, 0)];
    L6:
        return polyFitLeastSquares(r100, r101, r102, r103, r104);
    }
}
