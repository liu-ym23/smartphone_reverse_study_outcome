package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2;
    double[] mArea;
    private boolean mNormalized;
    float[] mPeriod;
    double[] mPosition;
    int mType;

    public void normalize() {
        double r100 = 0.0d;
        int r101 = 0;
    L3:
        float[] r102 = this.mPeriod;
        if (r101 >= r102.length) goto L6;
        r100 = r100 + ((double) r102[r101]);
        r101 = r101 + 1;
        goto L3
    L6:
        double r103 = 0.0d;
        int r104 = 1;
    L7:
        float[] r110 = this.mPeriod;
        if (r104 >= r110.length) goto L10;
        int r111 = r104 - 1;
        float r112 = (r110[r111] + r110[r104]) / 2.0f;
        double[] r113 = this.mPosition;
        r103 = r103 + ((r113[r104] - r113[r111]) * ((double) r112));
        r104 = r104 + 1;
        goto L7
    L10:
        int r105 = 0;
    L11:
        float[] r114 = this.mPeriod;
        if (r105 >= r114.length) goto L14;
        r114[r105] = (float) (((double) r114[r105]) * (r100 / r103));
        r105 = r105 + 1;
        goto L11
    L14:
        this.mArea[0] = 0.0d;
        int r106 = 1;
    L15:
        float[] r107 = this.mPeriod;
        if (r106 >= r107.length) goto L18;
        int r108 = r106 - 1;
        float r109 = (r107[r108] + r107[r106]) / 2.0f;
        double[] r115 = this.mPosition;
        double r116 = r115[r106] - r115[r108];
        double[] r117 = this.mArea;
        r117[r106] = r117[r108] + (r116 * ((double) r109));
        r106 = r106 + 1;
        goto L15
    L18:
        this.mNormalized = true;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }

    public Oscillator() {
        this.mPeriod = new float[0];
        this.mPosition = new double[0];
        this.PI2 = 6.283185307179586d;
        this.mNormalized = false;
    }

    public double getDP(double r110) {
        if (r110 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r110 = 1.0E-5d;
    L8:
        int r100 = Arrays.binarySearch(this.mPosition, r110);
        if (r100 <= 0) goto L11;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        if (r100 == 0) goto L14;
        int r101 = (-r100) - 1;
        float[] r102 = this.mPeriod;
        float r103 = r102[r101];
        int r104 = r101 - 1;
        float r105 = r102[r104];
        double r106 = r103 - r105;
        double[] r107 = this.mPosition;
        double r108 = r107[r101];
        double r109 = r107[r104];
        double r111 = r106 / (r108 - r109);
        return (((double) r105) - (r111 * r109)) + (r110 * r111);
    L14:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r110 < 1.0d) goto L8;
        r110 = 0.999999d;
        goto L8
    }

    public double getP(double r110) {
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r110 = 0.0d;
    L8:
        int r100 = Arrays.binarySearch(this.mPosition, r110);
        if (r100 > 0) goto L16;
        if (r100 == 0) goto L14;
        int r101 = (-r100) - 1;
        float[] r102 = this.mPeriod;
        float r103 = r102[r101];
        int r104 = r101 - 1;
        float r105 = r102[r104];
        double r106 = r103 - r105;
        double[] r107 = this.mPosition;
        double r108 = r107[r101];
        double r109 = r107[r104];
        double r111 = r106 / (r108 - r109);
        return (this.mArea[r104] + ((((double) r105) - (r111 * r109)) * (r110 - r109))) + ((r111 * ((r110 * r110) - (r109 * r109))) / 2.0d);
    L14:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L16:
        return 1.0d;
    L6:
        if (r110 <= 1.0d) goto L8;
        r110 = 1.0d;
        goto L8
    }

    public double getSlope(double r110) {
        switch(this.mType) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        double r100 = this.PI2 * getDP(r110);
        double r111 = Math.cos(this.PI2 * getP(r110));
    L6:
        return r100 * r111;
    L7:
        double r101 = getDP(r110) * 4.0d;
        double r112 = (((getP(r110) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
    L9:
        return r101 * r112;
    L10:
        r100 = (-this.PI2) * getDP(r110);
        r111 = Math.sin(this.PI2 * getP(r110));
        goto L6
    L11:
        double r113 = -getDP(r110);
    L13:
        return r113 * 2.0d;
    L14:
        r113 = getDP(r110);
        goto L13
    L15:
        r101 = getDP(r110) * 4.0d;
        r112 = Math.signum((((getP(r110) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L9
    L16:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public double getValue(double r100) {
        switch(this.mType) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        double r101 = 1.0d - Math.abs(((getP(r100) * 4.0d) % 4.0d) - 2.0d);
        double r102 = r101 * r101;
    L8:
        return 1.0d - r102;
    L11:
        r102 = ((getP(r100) * 2.0d) + 1.0d) % 2.0d;
        goto L8
    L14:
        r102 = Math.abs((((getP(r100) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
        goto L8
    L5:
        return Math.sin(this.PI2 * getP(r100));
    L10:
        return Math.cos(this.PI2 * getP(r100));
    L13:
        return (((getP(r100) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L16:
        return Math.signum(0.5d - (getP(r100) % 1.0d));
    }

    public void setType(int r100) {
        this.mType = r100;
    }

    public void addPoint(double r100, float r101) {
        int r102 = this.mPeriod.length + 1;
        int r103 = Arrays.binarySearch(this.mPosition, r100);
        if (r103 >= 0) goto L5;
        r103 = (-r103) - 1;
    L5:
        this.mPosition = Arrays.copyOf(this.mPosition, r102);
        this.mPeriod = Arrays.copyOf(this.mPeriod, r102);
        this.mArea = new double[r102];
        double[] r104 = this.mPosition;
        System.arraycopy(r104, r103, r104, r103 + 1, (r102 - r103) - 1);
        this.mPosition[r103] = r100;
        this.mPeriod[r103] = r101;
        this.mNormalized = false;
    }
}
