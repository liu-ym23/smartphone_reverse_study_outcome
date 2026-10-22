package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double mPI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d, float f) {
        int length = this.mPeriod.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.mPosition[iBinarySearch] = d;
        this.mPeriod[iBinarySearch] = f;
        this.mNormalized = false;
    }

    public double getDP(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f = fArr[iBinarySearch];
        int i = iBinarySearch - 1;
        float f7 = fArr[i];
        double d6 = f - f7;
        double[] dArr = this.mPosition;
        double d10 = dArr[iBinarySearch];
        double d11 = dArr[i];
        double d12 = d6 / (d10 - d11);
        return (f7 - (d12 * d11)) + (d * d12);
    }

    public double getP(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.mPosition, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f = fArr[iBinarySearch];
        int i = iBinarySearch - 1;
        float f7 = fArr[i];
        double d6 = f - f7;
        double[] dArr = this.mPosition;
        double d10 = dArr[iBinarySearch];
        double d11 = dArr[i];
        double d12 = d6 / (d10 - d11);
        return ((((d * d) - (d11 * d11)) * d12) / 2.0d) + ((d - d11) * (f7 - (d12 * d11))) + this.mArea[i];
    }

    public double getSlope(double d, double d6, double d10) {
        double d11;
        double dSignum;
        double p = getP(d) + d6;
        double dp = getDP(d) + d10;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d11 = dp * 4.0d;
                dSignum = Math.signum((((p * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d12 = this.mPI2;
                return Math.sin(d12 * p) * (-d12) * dp;
            case 6:
                return ((((p * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p % 1.0d, 0);
            default:
                double d13 = this.mPI2;
                d11 = dp * d13;
                dSignum = Math.cos(d13 * p);
                break;
        }
        return dSignum * d11;
    }

    public double getValue(double d, double d6) {
        double p = getP(d) + d6;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p % 1.0d));
            case 2:
                return 1.0d - Math.abs((((p * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((p * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((p * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos((d6 + p) * this.mPI2);
            case 6:
                double dAbs = 1.0d - Math.abs(((p * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (dAbs * dAbs);
            case 7:
                return this.mCustomCurve.getPos(p % 1.0d, 0);
            default:
                return Math.sin(this.mPI2 * p);
        }
    }

    public void normalize() {
        double d = 0.0d;
        int i = 0;
        while (true) {
            if (i >= this.mPeriod.length) {
                break;
            }
            d += r6[i];
            i++;
        }
        double d6 = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i6 >= fArr.length) {
                break;
            }
            int i10 = i6 - 1;
            float f = (fArr[i10] + fArr[i6]) / 2.0f;
            double[] dArr = this.mPosition;
            d6 += (dArr[i6] - dArr[i10]) * f;
            i6++;
        }
        int i11 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i11 >= fArr2.length) {
                break;
            }
            fArr2[i11] = fArr2[i11] * ((float) (d / d6));
            i11++;
        }
        this.mArea[0] = 0.0d;
        int i12 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i12 >= fArr3.length) {
                this.mNormalized = true;
                return;
            }
            int i13 = i12 - 1;
            float f7 = (fArr3[i13] + fArr3[i12]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d10 = dArr2[i12] - dArr2[i13];
            double[] dArr3 = this.mArea;
            dArr3[i12] = (d10 * f7) + dArr3[i13];
            i12++;
        }
    }

    public void setType(int i, String str) {
        this.mType = i;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
