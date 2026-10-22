package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i6 = 0; i6 < length2; i6++) {
            int i10 = 0;
            while (i10 < i) {
                int i11 = i10 + 1;
                double d = dArr[i11] - dArr[i10];
                double[] dArr5 = dArr3[i10];
                double d6 = (dArr2[i11][i6] - dArr2[i10][i6]) / d;
                dArr5[i6] = d6;
                if (i10 == 0) {
                    dArr4[i10][i6] = d6;
                } else {
                    dArr4[i10][i6] = (dArr3[i10 - 1][i6] + d6) * 0.5d;
                }
                i10 = i11;
            }
            dArr4[i][i6] = dArr3[length - 2][i6];
        }
        for (int i12 = 0; i12 < i; i12++) {
            for (int i13 = 0; i13 < length2; i13++) {
                double d10 = dArr3[i12][i13];
                if (d10 == 0.0d) {
                    dArr4[i12][i13] = 0.0d;
                    dArr4[i12 + 1][i13] = 0.0d;
                } else {
                    double d11 = dArr4[i12][i13] / d10;
                    int i14 = i12 + 1;
                    double d12 = dArr4[i14][i13] / d10;
                    double dHypot = Math.hypot(d11, d12);
                    if (dHypot > 9.0d) {
                        double d13 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i12];
                        double[] dArr7 = dArr3[i12];
                        dArr6[i13] = d11 * d13 * dArr7[i13];
                        dArr4[i14][i13] = d13 * d12 * dArr7[i13];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i = 0;
        while (iIndexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i + 1));
    }

    private static double diff(double d, double d6, double d10, double d11, double d12, double d13) {
        double d14 = d6 * d6;
        double d15 = d6 * 6.0d;
        double d16 = 6.0d * d14 * d10;
        double d17 = (d16 + ((d15 * d11) + (((-6.0d) * d14) * d11))) - (d15 * d10);
        double d18 = 3.0d * d;
        return (d * d12) + (((((d18 * d12) * d14) + (((d18 * d13) * d14) + d17)) - (((2.0d * d) * d13) * d6)) - (((4.0d * d) * d12) * d6));
    }

    private static double interpolate(double d, double d6, double d10, double d11, double d12, double d13) {
        double d14 = d6 * d6;
        double d15 = d14 * d6;
        double d16 = 3.0d * d14;
        double d17 = d15 * 2.0d * d10;
        double d18 = ((d17 + ((d16 * d11) + (((-2.0d) * d15) * d11))) - (d16 * d10)) + d10;
        double d19 = d * d13;
        double d20 = (d19 * d15) + d18;
        double d21 = d * d12;
        return (d21 * d6) + ((((d15 * d21) + d20) - (d19 * d14)) - (((d * 2.0d) * d12) * d14));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr2[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = ((d - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6];
                }
                return;
            }
            int i10 = length - 1;
            double d10 = dArr2[i10];
            if (d >= d10) {
                getSlope(d10, this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d - this.mT[i10]) * this.mSlopeTemp[i]) + this.mY[i10][i];
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d >= dArr2[i12]) {
                while (i < length2) {
                    dArr[i] = this.mY[i12][i];
                    i++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.mY[i13][i14];
                }
            }
            double[] dArr3 = this.mT;
            int i15 = i13 + 1;
            double d11 = dArr3[i15];
            if (d < d11) {
                double d12 = dArr3[i13];
                double d13 = d11 - d12;
                double d14 = (d - d12) / d13;
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    double d15 = dArr4[i13][i];
                    double d16 = dArr4[i15][i];
                    double[][] dArr5 = this.mTangent;
                    dArr[i] = interpolate(d13, d14, d15, d16, dArr5[i13][i], dArr5[i15][i]);
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d6 = dArr2[0];
        if (d > d6) {
            d6 = dArr2[length - 1];
            if (d < d6) {
                d6 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.mT;
            int i6 = i + 1;
            double d10 = dArr3[i6];
            if (d6 <= d10) {
                double d11 = dArr3[i];
                double d12 = d10 - d11;
                double d13 = (d6 - d11) / d12;
                for (int i10 = 0; i10 < length2; i10++) {
                    double[][] dArr4 = this.mY;
                    double d14 = dArr4[i][i10];
                    double d15 = dArr4[i6][i10];
                    double[][] dArr5 = this.mTangent;
                    dArr[i10] = diff(d12, d13, d14, d15, dArr5[i][i10], dArr5[i6][i10]) / d12;
                }
                return;
            }
            i = i6;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d6 = dArr[i];
            int i6 = i + length2;
            dArr2[i6][0] = d6;
            double d10 = i * d;
            dArr3[i6] = d10;
            if (i > 0) {
                int i10 = (length2 * 2) + i;
                dArr2[i10][0] = d6 + 1.0d;
                dArr3[i10] = d10 + 1.0d;
                int i11 = i - 1;
                dArr2[i11][0] = (d6 - 1.0d) - d;
                dArr3[i11] = (d10 - 1.0d) - d;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        double d6 = dArr[0];
        if (d >= d6) {
            d6 = dArr[length - 1];
            if (d < d6) {
                d6 = d;
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            int i10 = i6 + 1;
            double d10 = dArr2[i10];
            if (d6 <= d10) {
                double d11 = dArr2[i6];
                double d12 = d10 - d11;
                double d13 = (d6 - d11) / d12;
                double[][] dArr3 = this.mY;
                double d14 = dArr3[i6][i];
                double d15 = dArr3[i10][i];
                double[][] dArr4 = this.mTangent;
                return diff(d12, d13, d14, d15, dArr4[i6][i], dArr4[i10][i]) / d12;
            }
            i6 = i10;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) (((d - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6]);
                }
                return;
            }
            int i10 = length - 1;
            double d10 = dArr[i10];
            if (d >= d10) {
                getSlope(d10, this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d - this.mT[i10]) * this.mSlopeTemp[i]) + this.mY[i10][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d >= dArr[i12]) {
                while (i < length2) {
                    fArr[i] = (float) this.mY[i12][i];
                    i++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.mY[i13][i14];
                }
            }
            double[] dArr2 = this.mT;
            int i15 = i13 + 1;
            double d11 = dArr2[i15];
            if (d < d11) {
                double d12 = dArr2[i13];
                double d13 = d11 - d12;
                double d14 = (d - d12) / d13;
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    double d15 = dArr3[i13][i];
                    double d16 = dArr3[i15][i];
                    double[][] dArr4 = this.mTangent;
                    fArr[i] = (float) interpolate(d13, d14, d15, d16, dArr4[i13][i], dArr4[i15][i]);
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d <= d6) {
                return (getSlope(d6, i) * (d - d6)) + this.mY[0][i];
            }
            int i10 = length - 1;
            double d10 = dArr[i10];
            if (d >= d10) {
                return (getSlope(d10, i) * (d - d10)) + this.mY[i10][i];
            }
        } else {
            if (d <= dArr[0]) {
                return this.mY[0][i];
            }
            int i11 = length - 1;
            if (d >= dArr[i11]) {
                return this.mY[i11][i];
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d11 = dArr2[i6];
            if (d == d11) {
                return this.mY[i6][i];
            }
            int i12 = i6 + 1;
            double d12 = dArr2[i12];
            if (d < d12) {
                double d13 = d12 - d11;
                double d14 = (d - d11) / d13;
                double[][] dArr3 = this.mY;
                double d15 = dArr3[i6][i];
                double d16 = dArr3[i12][i];
                double[][] dArr4 = this.mTangent;
                return interpolate(d13, d14, d15, d16, dArr4[i6][i], dArr4[i12][i]);
            }
            i6 = i12;
        }
        return 0.0d;
    }
}
