package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes17.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        double mA;
        double mB;
        double mC;
        double mD;

        public double eval(double r100) {
            return (((((this.mD * r100) + this.mC) * r100) + this.mB) * r100) + this.mA;
        }

        public double vel(double r100) {
            return ((((this.mD * 0.3333333333333333d) * r100) + (this.mC * 0.5d)) * r100) + this.mB;
        }

        public Cubic(double r100, double r101, double r102, double r103) {
            this.mA = r100;
            this.mB = r101;
            this.mC = r102;
            this.mD = r103;
        }
    }

    public HyperSpline() {
    }

    public HyperSpline(double[][] r100) {
        setup(r100);
    }

    public double approxLength(Cubic[] r110) {
        int r100 = r110.length;
        double[] r101 = new double[r110.length];
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r103 = 0.0d;
        double r104 = 0.0d;
    L3:
        int r105 = 0;
        if (r103 >= 1.0d) goto L14;
        double r106 = 0.0d;
    L7:
        if (r105 >= r110.length) goto L10;
        double r111 = r101[r105];
        double r112 = r110[r105].eval(r103);
        r101[r105] = r112;
        double r113 = r111 - r112;
        r106 = r106 + (r113 * r113);
        r105 = r105 + 1;
        goto L7
    L10:
        if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        r104 = r104 + Math.sqrt(r106);
    L12:
        r103 = r103 + 0.1d;
    L14:
        if (r105 >= r110.length) goto L17;
        double r107 = r101[r105];
        double r114 = r110[r105].eval(1.0d);
        r101[r105] = r114;
        double r108 = r107 - r114;
        r102 = r102 + (r108 * r108);
        r105 = r105 + 1;
        goto L14
    L17:
        return r104 + Math.sqrt(r102);
    }

    public void setup(double[][] r100) {
        int r101 = r100[0].length;
        this.mDimensionality = r101;
        int r102 = r100.length;
        this.mPoints = r102;
        this.mCtl = (double[][]) Array.newInstance(Double.TYPE, new int[]{r101, r102});
        this.mCurve = new Cubic[this.mDimensionality][];
        int r103 = 0;
    L4:
        if (r103 >= this.mDimensionality) goto L10;
        int r104 = 0;
    L7:
        if (r104 >= this.mPoints) goto L9;
        this.mCtl[r103][r104] = r100[r104][r103];
        r104 = r104 + 1;
        goto L7
    L9:
        r103 = r103 + 1;
        goto L4
    L10:
        int r105 = 0;
    L11:
        int r106 = this.mDimensionality;
        if (r105 >= r106) goto L14;
        Cubic[][] r107 = this.mCurve;
        double[] r108 = this.mCtl[r105];
        r107[r105] = calcNaturalCubic(r108.length, r108);
        r105 = r105 + 1;
        goto L11
    L14:
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = AudioStats.AUDIO_AMPLITUDE_NONE;
        Cubic[] r109 = new Cubic[r106];
        int r110 = 0;
    L16:
        if (r110 >= this.mCurveLength.length) goto L22;
        int r111 = 0;
    L19:
        if (r111 >= this.mDimensionality) goto L21;
        r109[r111] = this.mCurve[r111][r110];
        r111 = r111 + 1;
        goto L19
    L21:
        double r112 = this.mTotalLength;
        double[] r113 = this.mCurveLength;
        double r114 = approxLength(r109);
        r113[r110] = r114;
        this.mTotalLength = r112 + r114;
        r110 = r110 + 1;
        goto L16
    }

    public static Cubic[] calcNaturalCubic(int r210, double[] r211) {
        double[] r100 = new double[r210];
        double[] r101 = new double[r210];
        double[] r102 = new double[r210];
        int r103 = r210 - 1;
        int r104 = 0;
        r100[0] = 0.5d;
        int r105 = 1;
        int r106 = 1;
    L4:
        if (r106 >= r103) goto L6;
        r100[r106] = 1.0d / (4.0d - r100[r106 - 1]);
        r106 = r106 + 1;
        goto L4
    L6:
        int r107 = r103 - 1;
        r100[r103] = 1.0d / (2.0d - r100[r107]);
        r101[0] = ((r211[1] - r211[0]) * 3.0d) * r100[0];
    L7:
        if (r105 >= r103) goto L9;
        int r108 = r105 + 1;
        int r109 = r105 - 1;
        r101[r105] = (((r211[r108] - r211[r109]) * 3.0d) - r101[r109]) * r100[r105];
        r105 = r108;
        goto L7
    L9:
        double r110 = (((r211[r103] - r211[r107]) * 3.0d) - r101[r107]) * r100[r103];
        r101[r103] = r110;
        r102[r103] = r110;
    L10:
        if (r107 < 0) goto L12;
        r102[r107] = r101[r107] - (r100[r107] * r102[r107 + 1]);
        r107 = r107 - 1;
        goto L10
    L12:
        Cubic[] r111 = new Cubic[r103];
    L13:
        if (r104 >= r103) goto L15;
        double r112 = r211[r104];
        double r113 = r102[r104];
        int r114 = r104 + 1;
        double r115 = r211[r114];
        double r212 = r102[r114];
        r111[r104] = new Cubic((float) r112, r113, (((r115 - r112) * 3.0d) - (r113 * 2.0d)) - r212, (((r112 - r115) * 2.0d) + r113) + r212);
        r104 = r114;
        goto L13
    L15:
        return r111;
    }

    public void getPos(double r100, float[] r101) {
        double r102 = r100 * this.mTotalLength;
        int r103 = 0;
        int r104 = 0;
    L3:
        double[] r105 = this.mCurveLength;
        if (r104 >= (r105.length - 1)) goto L9;
        double r106 = r105[r104];
        if (r106 >= r102) goto L9;
        r102 = r102 - r106;
        r104 = r104 + 1;
    L9:
        if (r103 >= r101.length) goto L11;
        r101[r103] = (float) this.mCurve[r103][r104].eval(r102 / this.mCurveLength[r104]);
        r103 = r103 + 1;
        goto L9
    }

    public void getVelocity(double r100, double[] r101) {
        double r102 = r100 * this.mTotalLength;
        int r103 = 0;
        int r104 = 0;
    L3:
        double[] r105 = this.mCurveLength;
        if (r104 >= (r105.length - 1)) goto L9;
        double r106 = r105[r104];
        if (r106 >= r102) goto L9;
        r102 = r102 - r106;
        r104 = r104 + 1;
    L9:
        if (r103 >= r101.length) goto L11;
        r101[r103] = this.mCurve[r103][r104].vel(r102 / this.mCurveLength[r104]);
        r103 = r103 + 1;
        goto L9
    }

    public void getPos(double r100, double[] r101) {
        double r102 = r100 * this.mTotalLength;
        int r103 = 0;
        int r104 = 0;
    L3:
        double[] r105 = this.mCurveLength;
        if (r104 >= (r105.length - 1)) goto L9;
        double r106 = r105[r104];
        if (r106 >= r102) goto L9;
        r102 = r102 - r106;
        r104 = r104 + 1;
    L9:
        if (r103 >= r101.length) goto L11;
        r101[r103] = this.mCurve[r103][r104].eval(r102 / this.mCurveLength[r104]);
        r103 = r103 + 1;
        goto L9
    }

    public double getPos(double r100, int r101) {
        double r102 = r100 * this.mTotalLength;
        int r103 = 0;
    L3:
        double[] r104 = this.mCurveLength;
        if (r103 >= (r104.length - 1)) goto L9;
        double r105 = r104[r103];
        if (r105 >= r102) goto L9;
        r102 = r102 - r105;
        r103 = r103 + 1;
    L9:
        return this.mCurve[r101][r103].eval(r102 / r104[r103]);
    }
}
