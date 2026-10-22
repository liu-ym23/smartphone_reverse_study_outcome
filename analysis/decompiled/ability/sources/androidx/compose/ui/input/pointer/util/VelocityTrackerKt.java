package androidx.compose.ui.input.pointer.util;

import D7.q;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u001a3\u0010\t\u001a\u00020\b*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u000e\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0015\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013\u001a#\u0010\u0017\u001a\u00020\b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013\u001a9\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a/\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$\u001a\u0018\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0082\b¢\u0006\u0004\b&\u0010'\u001a\u001b\u0010)\u001a\u00020\u0006*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0002¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\u0006*\u00020\u0018H\u0082\b¢\u0006\u0004\b+\u0010,\u001a*\u00100\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`/0\u00002\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0082\b¢\u0006\u0004\b0\u00101\u001a.\u00105\u001a\u00020\u0006*\f\u0012\u0004\u0012\u00020\u00180\u0000j\u0002`22\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0002H\u0082\n¢\u0006\u0004\b5\u00106\u001a6\u0010\t\u001a\u00020\b*\f\u0012\u0004\u0012\u00020\u00180\u0000j\u0002`22\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0006H\u0082\n¢\u0006\u0004\b\t\u00108\"\u0014\u00109\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010:\"\u0014\u0010;\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010:\"\u0014\u0010<\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010:\"\u0014\u0010=\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010>\"(\u0010?\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b?\u0010@\u0012\u0004\bE\u0010F\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\"(\u0010G\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bG\u0010@\u0012\u0004\bJ\u0010F\u001a\u0004\bH\u0010B\"\u0004\bI\u0010D*\f\b\u0002\u0010K\"\u00020\u00182\u00020\u0018*\u0018\b\u0002\u00100\"\b\u0012\u0004\u0012\u00020\u00180\u00002\b\u0012\u0004\u0012\u00020\u00180\u0000¨\u0006L"}, d2 = {"", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "", "index", "", "time", "", "dataPoint", "LC7/r;", "set", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", NotificationCompat.CATEGORY_EVENT, "addPointerInputChange", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "addPointerInputChange-0AR0LA0", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/pointer/PointerInputChange;J)V", "addPointerInputChangeLegacy-0AR0LA0", "addPointerInputChangeLegacy", "addPointerInputChangeWithFix-0AR0LA0", "addPointerInputChangeWithFix", "", "x", "y", "sampleCount", "degree", "coefficients", "polyFitLeastSquares", "([F[FII[F)[F", "dataPoints", "", "isDataDifferential", "calculateImpulseVelocity", "([F[FIZ)F", "kineticEnergy", "kineticEnergyToVelocity", "(F)F", "a", "dot", "([F[F)F", "norm", "([F)F", "rows", "cols", "Landroidx/compose/ui/input/pointer/util/Vector;", "Matrix", "(II)[[F", "Landroidx/compose/ui/input/pointer/util/Matrix;", "row", "col", "get", "([[FII)F", "value", "([[FIIF)V", "AssumePointerMoveStoppedMilliseconds", "I", "HistorySize", "HorizonMilliseconds", "DefaultWeight", "F", "VelocityTrackerAddPointsFix", "Z", "getVelocityTrackerAddPointsFix", "()Z", "setVelocityTrackerAddPointsFix", "(Z)V", "getVelocityTrackerAddPointsFix$annotations", "()V", "VelocityTrackerStrategyUseImpulse", "getVelocityTrackerStrategyUseImpulse", "setVelocityTrackerStrategyUseImpulse", "getVelocityTrackerStrategyUseImpulse$annotations", "Vector", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static boolean VelocityTrackerAddPointsFix = true;
    private static boolean VelocityTrackerStrategyUseImpulse;

    private static final float[][] Matrix(int i, int i6) {
        float[][] fArr = new float[i][];
        for (int i10 = 0; i10 < i; i10++) {
            fArr[i10] = new float[i6];
        }
        return fArr;
    }

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        m5523addPointerInputChange0AR0LA0(velocityTracker, pointerInputChange, Offset.INSTANCE.m3911getZeroF1C5BW0());
    }

    /* renamed from: addPointerInputChange-0AR0LA0, reason: not valid java name */
    public static final void m5523addPointerInputChange0AR0LA0(VelocityTracker velocityTracker, PointerInputChange pointerInputChange, long j5) {
        if (VelocityTrackerAddPointsFix) {
            m5525addPointerInputChangeWithFix0AR0LA0(velocityTracker, pointerInputChange, j5);
        } else {
            m5524addPointerInputChangeLegacy0AR0LA0(velocityTracker, pointerInputChange, j5);
        }
    }

    /* renamed from: addPointerInputChangeLegacy-0AR0LA0, reason: not valid java name */
    private static final void m5524addPointerInputChangeLegacy0AR0LA0(VelocityTracker velocityTracker, PointerInputChange pointerInputChange, long j5) {
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.m5522setCurrentPointerPositionAccumulatork4lQ0M$ui_release(pointerInputChange.getPosition());
            velocityTracker.resetTracking();
        }
        long previousPosition = pointerInputChange.getPreviousPosition();
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int size = historical.size();
        int i = 0;
        while (i < size) {
            HistoricalChange historicalChange = historical.get(i);
            long jM3899minusMKHz9U = Offset.m3899minusMKHz9U(historicalChange.getPosition(), previousPosition);
            long position = historicalChange.getPosition();
            velocityTracker.m5522setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m3900plusMKHz9U(velocityTracker.getCurrentPointerPositionAccumulator(), jM3899minusMKHz9U));
            velocityTracker.m5518addPositionUv8p0NA(historicalChange.getUptimeMillis(), Offset.m3900plusMKHz9U(velocityTracker.getCurrentPointerPositionAccumulator(), j5));
            i++;
            previousPosition = position;
        }
        velocityTracker.m5522setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m3900plusMKHz9U(velocityTracker.getCurrentPointerPositionAccumulator(), Offset.m3899minusMKHz9U(pointerInputChange.getPosition(), previousPosition)));
        velocityTracker.m5518addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), Offset.m3900plusMKHz9U(velocityTracker.getCurrentPointerPositionAccumulator(), j5));
    }

    /* renamed from: addPointerInputChangeWithFix-0AR0LA0, reason: not valid java name */
    private static final void m5525addPointerInputChangeWithFix0AR0LA0(VelocityTracker velocityTracker, PointerInputChange pointerInputChange, long j5) {
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.resetTracking();
        }
        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                HistoricalChange historicalChange = historical.get(i);
                velocityTracker.m5518addPositionUv8p0NA(historicalChange.getUptimeMillis(), Offset.m3900plusMKHz9U(historicalChange.getOriginalEventPosition(), j5));
            }
            velocityTracker.m5518addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), Offset.m3900plusMKHz9U(pointerInputChange.getOriginalEventPosition(), j5));
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange) && pointerInputChange.getUptimeMillis() - velocityTracker.getLastMoveEventTimeStamp() > 40) {
            velocityTracker.resetTracking();
        }
        velocityTracker.setLastMoveEventTimeStamp$ui_release(pointerInputChange.getUptimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(float[] fArr, float[] fArr2, int i, boolean z10) {
        int i6 = i - 1;
        float f = fArr2[i6];
        float f7 = 0.0f;
        int i10 = i6;
        while (i10 > 0) {
            int i11 = i10 - 1;
            float f9 = fArr2[i11];
            if (f != f9) {
                float f10 = (z10 ? -fArr[i11] : fArr[i10] - fArr[i11]) / (f - f9);
                float fAbs = (Math.abs(f10) * (f10 - (Math.signum(f7) * ((float) Math.sqrt(Math.abs(f7) * 2))))) + f7;
                if (i10 == i6) {
                    fAbs *= 0.5f;
                }
                f7 = fAbs;
            }
            i10--;
            f = f9;
        }
        return Math.signum(f7) * ((float) Math.sqrt(Math.abs(f7) * 2));
    }

    private static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    private static final float get(float[][] fArr, int i, int i6) {
        return fArr[i][i6];
    }

    public static final boolean getVelocityTrackerAddPointsFix() {
        return VelocityTrackerAddPointsFix;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getVelocityTrackerAddPointsFix$annotations() {
    }

    public static final boolean getVelocityTrackerStrategyUseImpulse() {
        return VelocityTrackerStrategyUseImpulse;
    }

    @ExperimentalVelocityTrackerApi
    public static /* synthetic */ void getVelocityTrackerStrategyUseImpulse$annotations() {
    }

    private static final float kineticEnergyToVelocity(float f) {
        return Math.signum(f) * ((float) Math.sqrt(Math.abs(f) * 2));
    }

    private static final float norm(float[] fArr) {
        return (float) Math.sqrt(dot(fArr, fArr));
    }

    public static final float[] polyFitLeastSquares(float[] fArr, float[] fArr2, int i, int i6, float[] fArr3) {
        int i10 = i6;
        if (i10 < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("The degree must be at positive integer");
        }
        if (i == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
        }
        if (i10 >= i) {
            i10 = i - 1;
        }
        int i11 = i10 + 1;
        float[][] fArr4 = new float[i11][];
        for (int i12 = 0; i12 < i11; i12++) {
            fArr4[i12] = new float[i];
        }
        for (int i13 = 0; i13 < i; i13++) {
            fArr4[0][i13] = 1.0f;
            for (int i14 = 1; i14 < i11; i14++) {
                fArr4[i14][i13] = fArr4[i14 - 1][i13] * fArr[i13];
            }
        }
        float[][] fArr5 = new float[i11][];
        for (int i15 = 0; i15 < i11; i15++) {
            fArr5[i15] = new float[i];
        }
        float[][] fArr6 = new float[i11][];
        for (int i16 = 0; i16 < i11; i16++) {
            fArr6[i16] = new float[i11];
        }
        int i17 = 0;
        while (i17 < i11) {
            float[] fArr7 = fArr5[i17];
            q.V(fArr4[i17], 0, fArr7, 0, i);
            for (int i18 = 0; i18 < i17; i18++) {
                float[] fArr8 = fArr5[i18];
                float fDot = dot(fArr7, fArr8);
                for (int i19 = 0; i19 < i; i19++) {
                    fArr7[i19] = fArr7[i19] - (fArr8[i19] * fDot);
                }
            }
            float fSqrt = (float) Math.sqrt(dot(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f = 1.0f / fSqrt;
            for (int i20 = 0; i20 < i; i20++) {
                fArr7[i20] = fArr7[i20] * f;
            }
            float[] fArr9 = fArr6[i17];
            int i21 = 0;
            while (i21 < i11) {
                fArr9[i21] = i21 < i17 ? 0.0f : dot(fArr7, fArr4[i21]);
                i21++;
            }
            i17++;
        }
        for (int i22 = i10; -1 < i22; i22--) {
            float fDot2 = dot(fArr5[i22], fArr2);
            float[] fArr10 = fArr6[i22];
            int i23 = i22 + 1;
            if (i23 <= i10) {
                int i24 = i10;
                while (true) {
                    fDot2 -= fArr10[i24] * fArr3[i24];
                    if (i24 != i23) {
                        i24--;
                    }
                }
            }
            fArr3[i22] = fDot2 / fArr10[i22];
        }
        return fArr3;
    }

    public static float[] polyFitLeastSquares$default(float[] fArr, float[] fArr2, int i, int i6, float[] fArr3, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            int i11 = i6 + 1;
            if (i11 < 0) {
                i11 = 0;
            }
            fArr3 = new float[i11];
        }
        return polyFitLeastSquares(fArr, fArr2, i, i6, fArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] dataPointAtTimeArr, int i, long j5, float f) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i] = new DataPointAtTime(j5, f);
        } else {
            dataPointAtTime.setTime(j5);
            dataPointAtTime.setDataPoint(f);
        }
    }

    public static final void setVelocityTrackerAddPointsFix(boolean z10) {
        VelocityTrackerAddPointsFix = z10;
    }

    public static final void setVelocityTrackerStrategyUseImpulse(boolean z10) {
        VelocityTrackerStrategyUseImpulse = z10;
    }

    private static final void set(float[][] fArr, int i, int i6, float f) {
        fArr[i][i6] = f;
    }
}
