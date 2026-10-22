package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes17.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    private static double diff(double r110, double r111, double r112, double r113, double r114, double r210) {
        double r100 = r111 * r111;
        double r101 = r111 * 6.0d;
        double r102 = (((((-6.0d) * r100) * r113) + (r101 * r113)) + ((6.0d * r100) * r112)) - (r101 * r112);
        double r103 = 3.0d * r110;
        return ((((r102 + ((r103 * r210) * r100)) + ((r103 * r114) * r100)) - (((2.0d * r110) * r210) * r111)) - (((4.0d * r110) * r114) * r111)) + (r110 * r114);
    }

    private static double interpolate(double r110, double r111, double r112, double r113, double r210, double r211) {
        double r100 = r111 * r111;
        double r101 = r100 * r111;
        double r102 = 3.0d * r100;
        double r103 = ((((((-2.0d) * r101) * r113) + (r102 * r113)) + ((r101 * 2.0d) * r112)) - (r102 * r112)) + r112;
        double r104 = r110 * r211;
        double r105 = r103 + (r104 * r101);
        double r114 = r110 * r210;
        return (((r105 + (r101 * r114)) - (r104 * r100)) - (((r110 * 2.0d) * r210) * r100)) + (r114 * r111);
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    public MonotonicCurveFit(double[] r210, double[][] r211) {
        int r100 = r210.length;
        int r101 = r211[0].length;
        int r102 = r100 - 1;
        double[][] r103 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r102, r101});
        double[][] r104 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, r101});
        int r110 = 0;
    L3:
        if (r110 >= r101) goto L12;
        int r111 = 0;
    L5:
        if (r111 >= r102) goto L11;
        int r112 = r111 + 1;
        double r113 = r210[r112] - r210[r111];
        double[] r114 = r103[r111];
        double r115 = (r211[r112][r110] - r211[r111][r110]) / r113;
        r114[r110] = r115;
        if (r111 != 0) goto L9;
        r104[r111][r110] = r115;
    L10:
        r111 = r112;
        goto L5
    L9:
        r104[r111][r110] = (r103[r111 - 1][r110] + r115) * 0.5d;
        goto L10
    L11:
        r104[r102][r110] = r103[r100 - 2][r110];
        r110 = r110 + 1;
        goto L3
    L12:
        int r105 = 0;
    L13:
        if (r105 >= r102) goto L24;
        int r106 = 0;
    L15:
        if (r106 >= r101) goto L23;
        double r116 = r103[r105][r106];
        if (r116 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        r104[r105][r106] = 0.0d;
        r104[r105 + 1][r106] = 0.0d;
    L22:
        r106 = r106 + 1;
        goto L15
    L19:
        double r117 = r104[r105][r106] / r116;
        int r118 = r105 + 1;
        double r119 = r104[r118][r106] / r116;
        double r120 = Math.hypot(r117, r119);
        if (r120 <= 9.0d) goto L22;
        double r121 = 3.0d / r120;
        double[] r122 = r104[r105];
        double[] r123 = r103[r105];
        r122[r106] = (r117 * r121) * r123[r106];
        r104[r118][r106] = (r121 * r119) * r123[r106];
        goto L22
    L23:
        r105 = r105 + 1;
        goto L13
    L24:
        this.mT = r210;
        this.mY = r211;
        this.mTangent = r104;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r210, float[] r211) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.mY[0].length;
        if (r210 > r100[0]) goto L8;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r211[r104] = (float) this.mY[0][r104];
        r104 = r104 + 1;
        goto L5
    L7:
        return;
    L8:
        int r105 = r101 - 1;
        if (r210 < r100[r105]) goto L13;
    L10:
        if (r102 >= r103) goto L12;
        r211[r102] = (float) this.mY[r105][r102];
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L13:
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L27;
        if (r210 != this.mT[r106]) goto L20;
        int r107 = 0;
    L18:
        if (r107 >= r103) goto L20;
        r211[r107] = (float) this.mY[r106][r107];
        r107 = r107 + 1;
    L20:
        double[] r108 = this.mT;
        int r109 = r106 + 1;
        double r110 = r108[r109];
        if (r210 < r110) goto L22;
        r106 = r109;
        goto L14
    L22:
        double r111 = r108[r106];
        double r112 = r110 - r111;
        double r113 = (r210 - r111) / r112;
    L23:
        if (r102 >= r103) goto L25;
        double[][] r114 = this.mY;
        double r115 = r114[r106][r102];
        double r116 = r114[r109][r102];
        double[][] r117 = this.mTangent;
        r211[r102] = (float) interpolate(r112, r113, r115, r116, r117[r106][r102], r117[r109][r102]);
        r102 = r102 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double r210, double[] r211) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.mY[0].length;
        double r104 = r100[0];
        if (r210 <= r104) goto L9;
        r104 = r100[r101 - 1];
        if (r210 >= r104) goto L9;
        r104 = r210;
    L9:
        int r105 = 0;
    L11:
        if (r105 >= (r101 - 1)) goto L18;
        double[] r106 = this.mT;
        int r107 = r105 + 1;
        double r108 = r106[r107];
        if (r104 <= r108) goto L14;
        r105 = r107;
        goto L11
    L14:
        double r110 = r106[r105];
        double r109 = r108 - r110;
        double r111 = (r104 - r110) / r109;
    L15:
        if (r102 >= r103) goto L22;
        double[][] r112 = this.mY;
        double r113 = r112[r105][r102];
        double r114 = r112[r107][r102];
        double[][] r115 = this.mTangent;
        r211[r102] = diff(r109, r111, r113, r114, r115[r105][r102], r115[r107][r102]) / r109;
        r102 = r102 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r210, double[] r211) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = this.mY[0].length;
        if (r210 > r100[0]) goto L8;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r211[r104] = this.mY[0][r104];
        r104 = r104 + 1;
        goto L5
    L7:
        return;
    L8:
        int r105 = r101 - 1;
        if (r210 < r100[r105]) goto L13;
    L10:
        if (r102 >= r103) goto L12;
        r211[r102] = this.mY[r105][r102];
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L13:
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L27;
        if (r210 != this.mT[r106]) goto L20;
        int r107 = 0;
    L18:
        if (r107 >= r103) goto L20;
        r211[r107] = this.mY[r106][r107];
        r107 = r107 + 1;
    L20:
        double[] r108 = this.mT;
        int r109 = r106 + 1;
        double r110 = r108[r109];
        if (r210 < r110) goto L22;
        r106 = r109;
        goto L14
    L22:
        double r111 = r108[r106];
        double r112 = r110 - r111;
        double r113 = (r210 - r111) / r112;
    L23:
        if (r102 >= r103) goto L25;
        double[][] r114 = this.mY;
        double r115 = r114[r106][r102];
        double r116 = r114[r109][r102];
        double[][] r117 = this.mTangent;
        r211[r102] = interpolate(r112, r113, r115, r116, r117[r106][r102], r117[r109][r102]);
        r102 = r102 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double r210, int r211) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        double r103 = r100[0];
        if (r210 < r103) goto L10;
        r103 = r100[r101 - 1];
        if (r210 >= r103) goto L10;
        r103 = r210;
    L10:
        if (r102 >= (r101 - 1)) goto L16;
        double[] r104 = this.mT;
        int r105 = r102 + 1;
        double r106 = r104[r105];
        if (r103 <= r106) goto L13;
        r102 = r105;
        goto L10
    L13:
        double r107 = r104[r102];
        double r108 = r106 - r107;
        double[][] r109 = this.mY;
        double r110 = r109[r102][r211];
        double r111 = r109[r105][r211];
        double[][] r112 = this.mTangent;
        return diff(r108, (r103 - r107) / r108, r110, r111, r112[r102][r211], r112[r105][r211]) / r108;
    L16:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double r210, int r211) {
        double[] r100 = this.mT;
        int r101 = r100.length;
        int r102 = 0;
        if (r210 <= r100[0]) goto L5;
        int r103 = r101 - 1;
        if (r210 >= r100[r103]) goto L9;
    L10:
        if (r102 >= r103) goto L20;
        double[] r104 = this.mT;
        double r105 = r104[r102];
        if (r210 == r105) goto L14;
        int r106 = r102 + 1;
        double r107 = r104[r106];
        if (r210 < r107) goto L17;
        r102 = r106;
        goto L10
    L17:
        double r108 = r107 - r105;
        double r110 = (r210 - r105) / r108;
        double[][] r109 = this.mY;
        double r111 = r109[r102][r211];
        double r112 = r109[r106][r211];
        double[][] r113 = this.mTangent;
        return interpolate(r108, r110, r111, r112, r113[r102][r211], r113[r106][r211]);
    L14:
        return this.mY[r102][r211];
    L20:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        return this.mY[r103][r211];
    L5:
        return this.mY[0][r211];
    }
}
