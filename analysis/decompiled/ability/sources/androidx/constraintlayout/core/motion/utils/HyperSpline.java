package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d, double d6, double d10, double d11) {
            this.mA = d;
            this.mB = d6;
            this.mC = d10;
            this.mD = d11;
        }

        public double eval(double d) {
            return (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA;
        }

        public double vel(double d) {
            return (((this.mC * 2.0d) + (this.mD * 3.0d * d)) * d) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i, double[] dArr) {
        double[] dArr2 = new double[i];
        double[] dArr3 = new double[i];
        double[] dArr4 = new double[i];
        int i6 = i - 1;
        int i10 = 0;
        dArr2[0] = 0.5d;
        int i11 = 1;
        for (int i12 = 1; i12 < i6; i12++) {
            dArr2[i12] = 1.0d / (4.0d - dArr2[i12 - 1]);
        }
        int i13 = i - 2;
        dArr2[i6] = 1.0d / (2.0d - dArr2[i13]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i11 < i6) {
            int i14 = i11 + 1;
            int i15 = i11 - 1;
            dArr3[i11] = (((dArr[i14] - dArr[i15]) * 3.0d) - dArr3[i15]) * dArr2[i11];
            i11 = i14;
        }
        double d = (((dArr[i6] - dArr[i13]) * 3.0d) - dArr3[i13]) * dArr2[i6];
        dArr3[i6] = d;
        dArr4[i6] = d;
        while (i13 >= 0) {
            dArr4[i13] = dArr3[i13] - (dArr2[i13] * dArr4[i13 + 1]);
            i13--;
        }
        Cubic[] cubicArr = new Cubic[i6];
        while (i10 < i6) {
            double d6 = dArr[i10];
            double d10 = dArr4[i10];
            int i16 = i10 + 1;
            double d11 = dArr[i16];
            double d12 = dArr4[i16];
            cubicArr[i10] = new Cubic((float) d6, d10, (((d11 - d6) * 3.0d) - (d10 * 2.0d)) - d12, ((d6 - d11) * 2.0d) + d10 + d12);
            i10 = i16;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i;
        int length = cubicArr.length;
        double[] dArr = new double[length];
        double d = 0.0d;
        double d6 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i = 0;
            if (d6 >= 1.0d) {
                break;
            }
            double d10 = 0.0d;
            while (i < length) {
                double d11 = dArr[i];
                double dEval = cubicArr[i].eval(d6);
                dArr[i] = dEval;
                double d12 = d11 - dEval;
                d10 += d12 * d12;
                i++;
            }
            if (d6 > 0.0d) {
                dSqrt += Math.sqrt(d10);
            }
            d6 += 0.1d;
        }
        while (i < length) {
            double d13 = dArr[i];
            double dEval2 = cubicArr[i].eval(1.0d);
            dArr[i] = dEval2;
            double d14 = d13 - dEval2;
            d += d14 * d14;
            i++;
        }
        return Math.sqrt(d) + dSqrt;
    }

    public void getPos(double d, double[] dArr) {
        double d6 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d10 = dArr2[i];
            if (d10 >= d6) {
                break;
            }
            d6 -= d10;
            i++;
        }
        for (int i6 = 0; i6 < dArr.length; i6++) {
            dArr[i6] = this.mCurve[i6][i].eval(d6 / this.mCurveLength[i]);
        }
    }

    public void getVelocity(double d, double[] dArr) {
        double d6 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d10 = dArr2[i];
            if (d10 >= d6) {
                break;
            }
            d6 -= d10;
            i++;
        }
        for (int i6 = 0; i6 < dArr.length; i6++) {
            dArr[i6] = this.mCurve[i6][i].vel(d6 / this.mCurveLength[i]);
        }
    }

    public void setup(double[][] dArr) {
        int i;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i6 = 0; i6 < this.mDimensionality; i6++) {
            for (int i10 = 0; i10 < this.mPoints; i10++) {
                this.mCtl[i6][i10] = dArr[i10][i6];
            }
        }
        int i11 = 0;
        while (true) {
            i = this.mDimensionality;
            if (i11 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i11];
            cubicArr[i11] = calcNaturalCubic(dArr2.length, dArr2);
            i11++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i];
        for (int i12 = 0; i12 < this.mCurveLength.length; i12++) {
            for (int i13 = 0; i13 < this.mDimensionality; i13++) {
                cubicArr2[i13] = this.mCurve[i13][i12];
            }
            double d = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double dApproxLength = approxLength(cubicArr2);
            dArr3[i12] = dApproxLength;
            this.mTotalLength = d + dApproxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d, float[] fArr) {
        double d6 = d * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i >= dArr.length - 1) {
                break;
            }
            double d10 = dArr[i];
            if (d10 >= d6) {
                break;
            }
            d6 -= d10;
            i++;
        }
        for (int i6 = 0; i6 < fArr.length; i6++) {
            fArr[i6] = (float) this.mCurve[i6][i].eval(d6 / this.mCurveLength[i]);
        }
    }

    public double getPos(double d, int i) {
        double[] dArr;
        double d6 = d * this.mTotalLength;
        int i6 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i6 >= dArr.length - 1) {
                break;
            }
            double d10 = dArr[i6];
            if (d10 >= d6) {
                break;
            }
            d6 -= d10;
            i6++;
        }
        return this.mCurve[i][i6].eval(d6 / dArr[i6]);
    }
}
