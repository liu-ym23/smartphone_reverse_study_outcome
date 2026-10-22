package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes17.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    private double getLength2D(double r210) {
        if (Double.isNaN(this.mTotalLength) == false) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        double[] r100 = this.mT;
        int r101 = r100.length;
        if (r210 > r100[0]) goto L8;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L8:
        int r102 = r101 - 1;
        if (r210 >= r100[r102]) goto L11;
        double r103 = 0.0d;
        double r104 = 0.0d;
        double r110 = 0.0d;
        int r105 = 0;
    L13:
        if (r105 >= r102) goto L25;
        double[] r111 = this.mY[r105];
        double r112 = r111[0];
        double r113 = r111[1];
        if (r105 <= 0) goto L17;
        r103 = r103 + Math.hypot(r112 - r104, r113 - r110);
    L17:
        double[] r106 = this.mT;
        double r114 = r106[r105];
        if (r210 == r114) goto L19;
        int r115 = r105 + 1;
        double r116 = r106[r115];
        if (r210 < r116) goto L22;
        r105 = r115;
        r104 = r112;
        r110 = r113;
        goto L13
    L22:
        double r107 = (r210 - r114) / (r116 - r114);
        double[][] r108 = this.mY;
        double[] r109 = r108[r105];
        double r117 = r109[0];
        double[] r118 = r108[r115];
        double r119 = r118[0];
        double r211 = 1.0d - r107;
        return r103 + Math.hypot(r113 - ((r109[1] * r211) + (r118[1] * r107)), r112 - ((r117 * r211) + (r119 * r107)));
    L19:
        return r103;
    L25:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        return this.mTotalLength;
    }

    public LinearCurveFit(double[] r110, double[][] r111) {
        this.mTotalLength = Double.NaN;
        int r100 = r110.length;
        int r101 = r111[0].length;
        this.mT = r110;
        this.mY = r111;
        if (r101 <= 2) goto L16;
        double r102 = 0.0d;
        double r103 = 0.0d;
        int r104 = 0;
    L6:
        if (r104 >= r110.length) goto L11;
        double r105 = r111[r104][0];
        if (r104 <= 0) goto L10;
        Math.hypot(r105 - r102, r105 - r103);
    L10:
        r104 = r104 + 1;
        r102 = r105;
        r103 = r102;
        goto L6
    L11:
        this.mTotalLength = AudioStats.AUDIO_AMPLITUDE_NONE;
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r110, float[] r111) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.mY[0].length;
        if (r110 > r100[0]) goto L8;
        int r112 = 0;
    L5:
        if (r112 >= r103) goto L7;
        r111[r112] = (float) this.mY[0][r112];
        r112 = r112 + 1;
        goto L5
    L7:
        return;
    L8:
        int r104 = r101 - 1;
        if (r110 < r100[r104]) goto L13;
    L10:
        if (r102 >= r103) goto L12;
        r111[r102] = (float) this.mY[r104][r102];
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L13:
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L27;
        if (r110 != this.mT[r105]) goto L20;
        int r106 = 0;
    L18:
        if (r106 >= r103) goto L20;
        r111[r106] = (float) this.mY[r105][r106];
        r106 = r106 + 1;
    L20:
        double[] r107 = this.mT;
        int r108 = r105 + 1;
        double r109 = r107[r108];
        if (r110 < r109) goto L22;
        r105 = r108;
        goto L14
    L22:
        double r113 = r107[r105];
        double r114 = (r110 - r113) / (r109 - r113);
    L23:
        if (r102 >= r103) goto L25;
        double[][] r115 = this.mY;
        r111[r102] = (float) ((r115[r105][r102] * (1.0d - r114)) + (r115[r108][r102] * r114));
        r102 = r102 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double r110, double[] r111) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.mY[0].length;
        double r104 = r100[0];
        if (r110 > r104) goto L5;
    L4:
        r110 = r104;
    L8:
        int r105 = 0;
    L10:
        if (r105 >= (r101 - 1)) goto L17;
        double[] r106 = this.mT;
        int r107 = r105 + 1;
        double r108 = r106[r107];
        if (r110 <= r108) goto L13;
        r105 = r107;
        goto L10
    L13:
        double r109 = r108 - r106[r105];
    L14:
        if (r102 >= r103) goto L21;
        double[][] r112 = this.mY;
        r111[r102] = (r112[r107][r102] - r112[r105][r102]) / r109;
        r102 = r102 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        r104 = r100[r101 - 1];
        if (r110 < r104) goto L8;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r110, double[] r111) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.mY[0].length;
        if (r110 > r100[0]) goto L8;
        int r112 = 0;
    L5:
        if (r112 >= r103) goto L7;
        r111[r112] = this.mY[0][r112];
        r112 = r112 + 1;
        goto L5
    L7:
        return;
    L8:
        int r104 = r101 - 1;
        if (r110 < r100[r104]) goto L13;
    L10:
        if (r102 >= r103) goto L12;
        r111[r102] = this.mY[r104][r102];
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L13:
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L27;
        if (r110 != this.mT[r105]) goto L20;
        int r106 = 0;
    L18:
        if (r106 >= r103) goto L20;
        r111[r106] = this.mY[r105][r106];
        r106 = r106 + 1;
    L20:
        double[] r107 = this.mT;
        int r108 = r105 + 1;
        double r109 = r107[r108];
        if (r110 < r109) goto L22;
        r105 = r108;
        goto L14
    L22:
        double r113 = r107[r105];
        double r114 = (r110 - r113) / (r109 - r113);
    L23:
        if (r102 >= r103) goto L25;
        double[][] r115 = this.mY;
        r111[r102] = (r115[r105][r102] * (1.0d - r114)) + (r115[r108][r102] * r114);
        r102 = r102 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double r100, int r110) {
        double[] r101 = this.mT;
        int r102 = r101.length;
        int r103 = 0;
        double r104 = r101[0];
        if (r100 >= r104) goto L5;
    L4:
        r100 = r104;
    L9:
        if (r103 >= (r102 - 1)) goto L15;
        double[] r105 = this.mT;
        int r106 = r103 + 1;
        double r107 = r105[r106];
        if (r100 <= r107) goto L12;
        r103 = r106;
        goto L9
    L12:
        double r108 = r107 - r105[r103];
        double[][] r109 = this.mY;
        return (r109[r106][r110] - r109[r103][r110]) / r108;
    L15:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        r104 = r101[r102 - 1];
        if (r100 < r104) goto L9;
        goto L4
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double r100, int r110) {
        double[] r101 = this.mT;
        int r102 = r101.length;
        int r103 = 0;
        if (r100 <= r101[0]) goto L5;
        int r104 = r102 - 1;
        if (r100 >= r101[r104]) goto L9;
    L10:
        if (r103 >= r104) goto L20;
        double[] r105 = this.mT;
        double r106 = r105[r103];
        if (r100 == r106) goto L14;
        int r107 = r103 + 1;
        double r108 = r105[r107];
        if (r100 < r108) goto L17;
        r103 = r107;
        goto L10
    L17:
        double r109 = (r100 - r106) / (r108 - r106);
        double[][] r111 = this.mY;
        return (r111[r103][r110] * (1.0d - r109)) + (r111[r107][r110] * r109);
    L14:
        return this.mY[r103][r110];
    L20:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        return this.mY[r104][r110];
    L5:
        return this.mY[0][r110];
    }
}
