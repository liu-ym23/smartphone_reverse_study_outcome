package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u0011J'\u0010\u001c\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010!J\u001d\u0010\u0010\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\"J'\u0010\u0010\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010!R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010$¨\u0006,"}, d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "", "time", "", "y", "", "periodicBias", AppAgent.CONSTRUCT, "([F[[FF)V", "", "a", "b", "makeFloatArray", "(II)[[F", "j", "getSlope", "(FI)F", "h", "x", "y1", "y2", "t1", "t2", "interpolate", "(FFFFFF)F", "diff", "t", "getPos", "Landroidx/compose/animation/core/AnimationVector;", "v", "index", "LC7/r;", "(FLandroidx/compose/animation/core/AnimationVector;I)V", "(F[F)V", "timePoints", "[F", "values", "[[F", "tangents", "", "isExtrapolate", "Z", "slopeTemp", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalAnimationSpecApi
/* loaded from: classes.dex */
public final class MonoSpline {
    public static final int $stable = 8;
    private final boolean isExtrapolate = true;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    public MonoSpline(float[] fArr, float[][] fArr2, float f) {
        int i;
        int length = fArr.length;
        int i6 = 0;
        int length2 = fArr2[0].length;
        this.slopeTemp = new float[length2];
        int i10 = length - 1;
        float[][] fArrMakeFloatArray = makeFloatArray(i10, length2);
        float[][] fArrMakeFloatArray2 = makeFloatArray(length, length2);
        for (int i11 = 0; i11 < length2; i11++) {
            int i12 = 0;
            while (i12 < i10) {
                int i13 = i12 + 1;
                float f7 = fArr[i13] - fArr[i12];
                float[] fArr3 = fArrMakeFloatArray[i12];
                float f9 = (fArr2[i13][i11] - fArr2[i12][i11]) / f7;
                fArr3[i11] = f9;
                if (i12 == 0) {
                    fArrMakeFloatArray2[i12][i11] = f9;
                } else {
                    fArrMakeFloatArray2[i12][i11] = (fArrMakeFloatArray[i12 - 1][i11] + f9) * 0.5f;
                }
                i12 = i13;
            }
            fArrMakeFloatArray2[i10][i11] = fArrMakeFloatArray[length - 2][i11];
        }
        if (!Float.isNaN(f)) {
            for (int i14 = 0; i14 < length2; i14++) {
                float[] fArr4 = fArrMakeFloatArray[length - 2];
                float f10 = (1 - f) * fArr4[i14];
                float[] fArr5 = fArrMakeFloatArray[0];
                float f11 = (fArr5[i14] * f) + f10;
                fArr5[i14] = f11;
                fArr4[i14] = f11;
                fArrMakeFloatArray2[i10][i14] = f11;
                fArrMakeFloatArray2[0][i14] = f11;
            }
        }
        int i15 = 0;
        while (i15 < i10) {
            int i16 = i6;
            while (i16 < length2) {
                float f12 = fArrMakeFloatArray[i15][i16];
                if (f12 == 0.0f) {
                    fArrMakeFloatArray2[i15][i16] = 0.0f;
                    fArrMakeFloatArray2[i15 + 1][i16] = 0.0f;
                    i = length2;
                } else {
                    float f13 = fArrMakeFloatArray2[i15][i16] / f12;
                    int i17 = i15 + 1;
                    float f14 = fArrMakeFloatArray2[i17][i16] / f12;
                    i = length2;
                    float fHypot = (float) Math.hypot(f13, f14);
                    if (fHypot > 9.0d) {
                        float f15 = 3.0f / fHypot;
                        float[] fArr6 = fArrMakeFloatArray2[i15];
                        float[] fArr7 = fArrMakeFloatArray[i15];
                        fArr6[i16] = f13 * f15 * fArr7[i16];
                        fArrMakeFloatArray2[i17][i16] = f15 * f14 * fArr7[i16];
                    }
                }
                i16++;
                length2 = i;
            }
            i15++;
            i6 = 0;
        }
        this.timePoints = fArr;
        this.values = fArr2;
        this.tangents = fArrMakeFloatArray2;
    }

    private final float diff(float h, float x10, float y12, float y22, float t12, float t22) {
        float f = x10 * x10;
        float f7 = 6;
        float f9 = f7 * x10;
        float f10 = (((f7 * f) * y12) + ((y22 * f9) + (((-6) * f) * y22))) - (f9 * y12);
        float f11 = 3 * h;
        return (h * t12) + (((((f11 * t12) * f) + (((f11 * t22) * f) + f10)) - (((2 * h) * t22) * x10)) - (((4 * h) * t12) * x10));
    }

    public static /* synthetic */ void getPos$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        monoSpline.getPos(f, animationVector, i);
    }

    public static /* synthetic */ void getSlope$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 0;
        }
        monoSpline.getSlope(f, animationVector, i);
    }

    private final float interpolate(float h, float x10, float y12, float y22, float t12, float t22) {
        float f = x10 * x10;
        float f7 = f * x10;
        float f9 = 3 * f;
        float f10 = 2;
        float f11 = t22 * h;
        float f12 = (f11 * f7) + ((((f10 * f7) * y12) + ((y22 * f9) + (((-2) * f7) * y22))) - (f9 * y12)) + y12;
        float f13 = h * t12;
        return (f13 * x10) + ((((f7 * f13) + f12) - (f11 * f)) - (((f10 * h) * t12) * f));
    }

    private final float[][] makeFloatArray(int a3, int b) {
        float[][] fArr = new float[a3][];
        for (int i = 0; i < a3; i++) {
            fArr[i] = new float[b];
        }
        return fArr;
    }

    public final float getPos(float t9, int j5) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i = 0;
        if (this.isExtrapolate) {
            float f = fArr[0];
            if (t9 <= f) {
                return ((t9 - f) * getSlope(f, j5)) + this.values[0][j5];
            }
            int i6 = length - 1;
            float f7 = fArr[i6];
            if (t9 >= f7) {
                return ((t9 - f7) * getSlope(f7, j5)) + this.values[i6][j5];
            }
        } else {
            if (t9 <= fArr[0]) {
                return this.values[0][j5];
            }
            int i10 = length - 1;
            if (t9 >= fArr[i10]) {
                return this.values[i10][j5];
            }
        }
        int i11 = length - 1;
        while (i < i11) {
            float[] fArr2 = this.timePoints;
            float f9 = fArr2[i];
            if (t9 == f9) {
                return this.values[i][j5];
            }
            int i12 = i + 1;
            float f10 = fArr2[i12];
            if (t9 < f10) {
                float f11 = f10 - f9;
                float f12 = (t9 - f9) / f11;
                float[][] fArr3 = this.values;
                float f13 = fArr3[i][j5];
                float f14 = fArr3[i12][j5];
                float[][] fArr4 = this.tangents;
                return interpolate(f11, f12, f13, f14, fArr4[i][j5], fArr4[i12][j5]);
            }
            i = i12;
        }
        return 0.0f;
    }

    public final void getSlope(float time, float[] v10) {
        float f;
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int length2 = this.values[0].length;
        float f7 = fArr[0];
        if (time <= f7) {
            f = f7;
        } else {
            f = fArr[length - 1];
            if (time < f) {
                f = time;
            }
        }
        int i = length - 1;
        int i6 = 0;
        while (i6 < i) {
            float[] fArr2 = this.timePoints;
            int i10 = i6 + 1;
            float f9 = fArr2[i10];
            if (f <= f9) {
                float f10 = fArr2[i6];
                float f11 = f9 - f10;
                float f12 = (f - f10) / f11;
                int i11 = 0;
                while (i11 < length2) {
                    float[][] fArr3 = this.values;
                    float f13 = fArr3[i6][i11];
                    float f14 = fArr3[i10][i11];
                    float[][] fArr4 = this.tangents;
                    float f15 = fArr4[i6][i11];
                    float f16 = fArr4[i10][i11];
                    float f17 = f11;
                    v10[i11] = diff(f17, f12, f13, f14, f15, f16) / f17;
                    i11++;
                    f11 = f17;
                }
                return;
            }
            i6 = i10;
        }
    }

    public final void getSlope(float time, AnimationVector v10, int index) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int length2 = this.values[0].length;
        if (time <= fArr[0]) {
            for (int i = 0; i < length2; i++) {
                v10.set$animation_core_release(i, this.tangents[0][i]);
            }
            return;
        }
        int i6 = length - 1;
        if (time >= fArr[i6]) {
            for (int i10 = 0; i10 < length2; i10++) {
                v10.set$animation_core_release(i10, this.tangents[i6][i10]);
            }
            return;
        }
        int i11 = index;
        while (i11 < i6) {
            float[] fArr2 = this.timePoints;
            int i12 = i11 + 1;
            float f = fArr2[i12];
            if (time <= f) {
                float f7 = fArr2[i11];
                float f9 = f - f7;
                float f10 = (time - f7) / f9;
                int i13 = 0;
                while (i13 < length2) {
                    float[][] fArr3 = this.values;
                    float f11 = fArr3[i11][i13];
                    float f12 = fArr3[i12][i13];
                    float[][] fArr4 = this.tangents;
                    float f13 = f9;
                    v10.set$animation_core_release(i13, diff(f13, f10, f11, f12, fArr4[i11][i13], fArr4[i12][i13]) / f13);
                    i13++;
                    f9 = f13;
                }
                return;
            }
            i11 = i12;
        }
    }

    public final void getPos(float time, AnimationVector v10, int index) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i = 0;
        int length2 = this.values[0].length;
        if (this.isExtrapolate) {
            float f = fArr[0];
            if (time <= f) {
                getSlope(f, this.slopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    v10.set$animation_core_release(i6, ((time - this.timePoints[0]) * this.slopeTemp[i6]) + this.values[0][i6]);
                }
                return;
            }
            int i10 = length - 1;
            float f7 = fArr[i10];
            if (time >= f7) {
                getSlope(f7, this.slopeTemp);
                while (i < length2) {
                    v10.set$animation_core_release(i, ((time - this.timePoints[i10]) * this.slopeTemp[i]) + this.values[i10][i]);
                    i++;
                }
                return;
            }
        } else {
            if (time <= fArr[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    v10.set$animation_core_release(i11, this.values[0][i11]);
                }
                return;
            }
            int i12 = length - 1;
            if (time >= fArr[i12]) {
                while (i < length2) {
                    v10.set$animation_core_release(i, this.values[i12][i]);
                    i++;
                }
                return;
            }
        }
        int i13 = length - 1;
        int i14 = index;
        while (i14 < i13) {
            if (time == this.timePoints[i14]) {
                for (int i15 = 0; i15 < length2; i15++) {
                    v10.set$animation_core_release(i15, this.values[i14][i15]);
                }
            }
            float[] fArr2 = this.timePoints;
            int i16 = i14 + 1;
            float f9 = fArr2[i16];
            if (time < f9) {
                float f10 = fArr2[i14];
                float f11 = f9 - f10;
                float f12 = (time - f10) / f11;
                int i17 = 0;
                while (i17 < length2) {
                    float[][] fArr3 = this.values;
                    float f13 = fArr3[i14][i17];
                    float f14 = fArr3[i16][i17];
                    float[][] fArr4 = this.tangents;
                    float f15 = f11;
                    v10.set$animation_core_release(i17, interpolate(f15, f12, f13, f14, fArr4[i14][i17], fArr4[i16][i17]));
                    i17++;
                    f11 = f15;
                }
                return;
            }
            i14 = i16;
        }
    }

    private final float getSlope(float time, int j5) {
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i = 0;
        float f = fArr[0];
        if (time < f) {
            time = f;
        } else {
            float f7 = fArr[length - 1];
            if (time >= f7) {
                time = f7;
            }
        }
        int i6 = length - 1;
        while (i < i6) {
            float[] fArr2 = this.timePoints;
            int i10 = i + 1;
            float f9 = fArr2[i10];
            if (time <= f9) {
                float f10 = fArr2[i];
                float f11 = f9 - f10;
                float f12 = (time - f10) / f11;
                float[][] fArr3 = this.values;
                float f13 = fArr3[i][j5];
                float f14 = fArr3[i10][j5];
                float[][] fArr4 = this.tangents;
                return diff(f11, f12, f13, f14, fArr4[i][j5], fArr4[i10][j5]) / f11;
            }
            i = i10;
        }
        return 0.0f;
    }
}
