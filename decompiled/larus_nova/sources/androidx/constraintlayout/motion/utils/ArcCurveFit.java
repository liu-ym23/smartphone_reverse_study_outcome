package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent;
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        static {
            ourPercent = new double[91];
        }

        public double getDX() {
            double r100 = this.mEllipseA * this.mTmpCosAngle;
            double r101 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r102 = this.mArcVelocity / Math.hypot(r100, r101);
            if (this.mVertical == false) goto L6;
            r100 = -r100;
        L6:
            return r100 * r102;
        }

        public double getDY() {
            double r100 = this.mEllipseA * this.mTmpCosAngle;
            double r101 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r102 = this.mArcVelocity / Math.hypot(r100, r101);
            if (this.mVertical == false) goto L6;
            return (-r101) * r102;
        L6:
            return r101 * r102;
        }

        public double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        public double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        public double getLinearDX(double r100) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double r100) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double r100) {
            double r101 = (r100 - this.mTime1) * this.mOneOverDeltaTime;
            double r102 = this.mX1;
            return r102 + (r101 * (this.mX2 - r102));
        }

        public double getLinearY(double r100) {
            double r101 = (r100 - this.mTime1) * this.mOneOverDeltaTime;
            double r102 = this.mY1;
            return r102 + (r101 * (this.mY2 - r102));
        }

        public double lookup(double r100) {
            if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L6:
            if (r100 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r101 = this.mLut;
            double r102 = r100 * ((double) (r101.length - 1));
            int r103 = (int) r102;
            double r104 = r102 - ((double) r103);
            double r105 = r101[r103];
            return r105 + (r104 * (r101[r103 + 1] - r105));
        }

        public void setPoint(double r100) {
            if (this.mVertical == false) goto L5;
            double r101 = this.mTime2 - r100;
        L6:
            double r102 = lookup(r101 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(r102);
            this.mTmpCosAngle = Math.cos(r102);
            return;
        L5:
            r101 = r100 - this.mTime1;
            goto L6
        }

        private void buildTable(double r210, double r211, double r212, double r213) {
            double r100 = r212 - r210;
            double r101 = r211 - r213;
            int r102 = 0;
            double r103 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L3:
            double[] r112 = ourPercent;
            if (r102 >= r112.length) goto L10;
            double r214 = r103;
            double r104 = Math.toRadians((((double) r102) * 90.0d) / ((double) (r112.length - 1)));
            double r105 = Math.sin(r104) * r100;
            double r106 = Math.cos(r104) * r101;
            if (r102 <= 0) goto L8;
            double r113 = Math.hypot(r105 - r110, r106 - r111) + r214;
            ourPercent[r102] = r113;
        L9:
            r102 = r102 + 1;
            r111 = r106;
            r103 = r113;
            r110 = r105;
            goto L3
        L8:
            r113 = r214;
            goto L9
        L10:
            double r114 = r103;
            this.mArcDistance = r114;
            int r107 = 0;
        L11:
            double[] r108 = ourPercent;
            if (r107 >= r108.length) goto L14;
            r108[r107] = r108[r107] / r114;
            r107 = r107 + 1;
            goto L11
        L14:
            int r109 = 0;
        L15:
            double[] r115 = this.mLut;
            if (r109 >= r115.length) goto L25;
            double r116 = ((double) r109) / ((double) (r115.length - 1));
            int r117 = Arrays.binarySearch(ourPercent, r116);
            if (r117 < 0) goto L21;
            this.mLut[r109] = r117 / (ourPercent.length - 1);
        L24:
            r109 = r109 + 1;
            goto L15
        L21:
            if (r117 != (-1)) goto L23;
            this.mLut[r109] = 0.0d;
            goto L24
        L23:
            int r118 = -r117;
            int r119 = r118 - 2;
            double[] r120 = ourPercent;
            double r121 = r120[r119];
            this.mLut[r109] = (((double) r119) + ((r116 - r121) / (r120[r118 - 1] - r121))) / ((double) (r120.length - 1));
            goto L24
        }

        public Arc(int r210, double r211, double r212, double r213, double r214, double r310, double r311) {
            boolean r110 = false;
            this.linear = false;
            int r111 = 1;
            if (r210 != 1) goto L5;
            r110 = true;
        L5:
            this.mVertical = r110;
            this.mTime1 = r211;
            this.mTime2 = r212;
            this.mOneOverDeltaTime = 1.0d / (r212 - r211);
            if (3 != r210) goto L8;
            this.linear = true;
        L8:
            double r100 = r310 - r213;
            double r101 = r311 - r214;
            if (this.linear == false) goto L11;
        L33:
            this.linear = true;
            this.mX1 = r213;
            this.mX2 = r310;
            this.mY1 = r214;
            this.mY2 = r311;
            double r102 = Math.hypot(r101, r100);
            this.mArcDistance = r102;
            this.mArcVelocity = r102 * this.mOneOverDeltaTime;
            double r103 = this.mTime2;
            double r104 = this.mTime1;
            this.mEllipseCenterX = r100 / (r103 - r104);
            this.mEllipseCenterY = r101 / (r103 - r104);
            return;
        L11:
            if (Math.abs(r100) < EPSILON) goto L33;
            if (Math.abs(r101) < EPSILON) goto L33;
            this.mLut = new double[101];
            boolean r105 = this.mVertical;
            if (r105 == false) goto L18;
            int r112 = -1;
        L19:
            this.mEllipseA = r100 * ((double) r112);
            if (r105 == true) goto L23;
            r111 = -1;
        L23:
            this.mEllipseB = r101 * ((double) r111);
            if (r105 == false) goto L26;
            double r106 = r310;
        L27:
            this.mEllipseCenterX = r106;
            if (r105 == false) goto L30;
            double r107 = r214;
        L31:
            this.mEllipseCenterY = r107;
            buildTable(r213, r214, r310, r311);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        L30:
            r107 = r311;
            goto L31
        L26:
            r106 = r213;
            goto L27
        L18:
            r112 = 1;
            goto L19
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r100, float[] r110) {
        Arc[] r101 = this.mArcs;
        double r102 = r101[0].mTime1;
        if (r100 >= r102) goto L6;
        r100 = r102;
    L8:
        int r103 = 0;
    L9:
        Arc[] r104 = this.mArcs;
        if (r103 >= r104.length) goto L20;
        Arc r105 = r104[r103];
        if (r100 <= r105.mTime2) goto L14;
        r103 = r103 + 1;
        goto L9
    L14:
        if (r105.linear == false) goto L17;
        r110[0] = (float) r105.getLinearX(r100);
        r110[1] = (float) this.mArcs[r103].getLinearY(r100);
        return;
    L17:
        r105.setPoint(r100);
        r110[0] = (float) this.mArcs[r103].getX();
        r110[1] = (float) this.mArcs[r103].getY();
        return;
    L20:
        return;
    L6:
        if (r100 <= r101[r101.length - 1].mTime2) goto L8;
        r100 = r101[r101.length - 1].mTime2;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double r100, double[] r110) {
        Arc[] r101 = this.mArcs;
        double r102 = r101[0].mTime1;
        if (r100 >= r102) goto L6;
        r100 = r102;
    L8:
        int r103 = 0;
    L9:
        Arc[] r104 = this.mArcs;
        if (r103 >= r104.length) goto L20;
        Arc r105 = r104[r103];
        if (r100 <= r105.mTime2) goto L14;
        r103 = r103 + 1;
        goto L9
    L14:
        if (r105.linear == false) goto L17;
        r110[0] = r105.getLinearDX(r100);
        r110[1] = this.mArcs[r103].getLinearDY(r100);
        return;
    L17:
        r105.setPoint(r100);
        r110[0] = this.mArcs[r103].getDX();
        r110[1] = this.mArcs[r103].getDY();
        return;
    L20:
        return;
    L6:
        if (r100 <= r101[r101.length - 1].mTime2) goto L8;
        r100 = r101[r101.length - 1].mTime2;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r100, double[] r110) {
        Arc[] r101 = this.mArcs;
        double r102 = r101[0].mTime1;
        if (r100 >= r102) goto L6;
        r100 = r102;
    L6:
        if (r100 <= r101[r101.length - 1].mTime2) goto L8;
        r100 = r101[r101.length - 1].mTime2;
    L8:
        int r103 = 0;
    L9:
        Arc[] r104 = this.mArcs;
        if (r103 >= r104.length) goto L20;
        Arc r105 = r104[r103];
        if (r100 <= r105.mTime2) goto L14;
        r103 = r103 + 1;
        goto L9
    L14:
        if (r105.linear == false) goto L17;
        r110[0] = r105.getLinearX(r100);
        r110[1] = this.mArcs[r103].getLinearY(r100);
        return;
    L17:
        r105.setPoint(r100);
        r110[0] = this.mArcs[r103].getX();
        r110[1] = this.mArcs[r103].getY();
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double r100, int r101) {
        Arc[] r102 = this.mArcs;
        int r103 = 0;
        double r104 = r102[0].mTime1;
        if (r100 >= r104) goto L6;
        r100 = r104;
    L6:
        if (r100 <= r102[r102.length - 1].mTime2) goto L8;
        r100 = r102[r102.length - 1].mTime2;
    L8:
        Arc[] r105 = this.mArcs;
        if (r103 >= r105.length) goto L26;
        Arc r106 = r105[r103];
        if (r100 <= r106.mTime2) goto L13;
        r103 = r103 + 1;
        goto L8
    L13:
        if (r106.linear == false) goto L19;
        if (r101 != 0) goto L18;
        return r106.getLinearDX(r100);
    L18:
        return r106.getLinearDY(r100);
    L19:
        r106.setPoint(r100);
        if (r101 != 0) goto L24;
        return this.mArcs[r103].getDX();
    L24:
        return this.mArcs[r103].getDY();
    L26:
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double r100, int r101) {
        Arc[] r102 = this.mArcs;
        int r103 = 0;
        double r104 = r102[0].mTime1;
        if (r100 >= r104) goto L6;
        r100 = r104;
    L8:
        Arc[] r105 = this.mArcs;
        if (r103 >= r105.length) goto L26;
        Arc r106 = r105[r103];
        if (r100 <= r106.mTime2) goto L13;
        r103 = r103 + 1;
        goto L8
    L13:
        if (r106.linear == false) goto L19;
        if (r101 != 0) goto L18;
        return r106.getLinearX(r100);
    L18:
        return r106.getLinearY(r100);
    L19:
        r106.setPoint(r100);
        if (r101 != 0) goto L24;
        return this.mArcs[r103].getX();
    L24:
        return this.mArcs[r103].getY();
    L26:
        return Double.NaN;
    L6:
        if (r100 <= r102[r102.length - 1].mTime2) goto L8;
        r100 = r102[r102.length - 1].mTime2;
        goto L8
    }

    public ArcCurveFit(int[] r210, double[] r211, double[][] r212) {
        this.mTime = r211;
        this.mArcs = new Arc[r211.length - 1];
        int r100 = 0;
        int r101 = 1;
        int r102 = 1;
    L3:
        Arc[] r103 = this.mArcs;
        if (r100 >= r103.length) goto L20;
        int r104 = r210[r100];
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L9;
        r101 = 1;
        r102 = 1;
    L19:
        double r110 = r211[r100];
        int r213 = r100 + 1;
        double r111 = r211[r213];
        double[] r105 = r212[r100];
        double r112 = r105[0];
        double r113 = r105[1];
        double[] r106 = r212[r213];
        int r107 = r102;
        r103[r100] = new Arc(r107, r110, r111, r112, r113, r106[0], r106[1]);
        r100 = r213;
        goto L3
    L9:
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L19;
        if (r101 != 1) goto L14;
        r101 = 2;
    L15:
        r102 = r101;
        goto L19
    L14:
        r101 = 1;
        goto L15
    L16:
        r101 = 2;
        r102 = 2;
        goto L19
    L18:
        r102 = 3;
        goto L19
    }
}
