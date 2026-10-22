package androidx.constraintlayout.motion.utils;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes17.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    public static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double r100, int r101) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        public Constant(double r100, double[] r101) {
            this.mTime = r100;
            this.mValue = r101;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double r100, float[] r101) {
            int r102 = 0;
        L3:
            double[] r103 = this.mValue;
            if (r102 >= r103.length) goto L6;
            r101[r102] = (float) r103[r102];
            r102 = r102 + 1;
            goto L3
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double r100, double[] r101) {
            int r102 = 0;
        L4:
            if (r102 >= this.mValue.length) goto L6;
            r101[r102] = 0.0d;
            r102 = r102 + 1;
            goto L4
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double r100, double[] r101) {
            double[] r102 = this.mValue;
            System.arraycopy(r102, 0, r101, 0, r102.length);
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double r100, int r101) {
            return this.mValue[r101];
        }
    }

    public CurveFit() {
    }

    public abstract double getPos(double r100, int r101);

    public abstract void getPos(double r100, double[] r101);

    public abstract void getPos(double r100, float[] r101);

    public abstract double getSlope(double r100, int r101);

    public abstract void getSlope(double r100, double[] r101);

    public abstract double[] getTimePoints();

    public static CurveFit get(int r100, double[] r101, double[][] r102) {
        if (r101.length != 1) goto L5;
        r100 = 2;
    L5:
        if (r100 == 0) goto L12;
        if (r100 == 2) goto L10;
        return new LinearCurveFit(r101, r102);
    L10:
        return new Constant(r101[0], r102[0]);
    L12:
        return new MonotonicCurveFit(r101, r102);
    }

    public static CurveFit getArc(int[] r100, double[] r101, double[][] r102) {
        return new ArcCurveFit(r100, r101, r102);
    }
}
