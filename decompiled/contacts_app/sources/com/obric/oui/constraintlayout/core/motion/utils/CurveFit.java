package com.obric.oui.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
        public double getSlope(double r1, int r3) {
            return 0.0d;
        }

        Constant(double r1, double[] r3) {
            this.mTime = r1;
            this.mValue = r3;
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double r1, double[] r3) {
            double[] r0 = this.mValue;
            System.arraycopy(r0, 0, r3, 0, r0.length);
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double r3, float[] r5) {
            int r4 = 0;
        L3:
            double[] r6 = this.mValue;
            if (r4 >= r6.length) goto L6;
            r5[r4] = (float) r6[r4];
            r4 = r4 + 1;
            goto L3
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
        public double getPos(double r1, int r3) {
            return this.mValue[r3];
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
        public void getSlope(double r3, double[] r5) {
            int r4 = 0;
        L4:
            if (r4 >= this.mValue.length) goto L6;
            r5[r4] = 0.0d;
            r4 = r4 + 1;
            goto L4
        }

        @Override // com.obric.oui.constraintlayout.core.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }
    }

    public abstract double getPos(double r1, int r3);

    public abstract void getPos(double r1, double[] r3);

    public abstract void getPos(double r1, float[] r3);

    public abstract double getSlope(double r1, int r3);

    public abstract void getSlope(double r1, double[] r3);

    public abstract double[] getTimePoints();

    public CurveFit() {
    }

    public static CurveFit get(int r3, double[] r4, double[][] r5) {
        if (r4.length != 1) goto L5;
        r3 = 2;
    L5:
        if (r3 == 0) goto L12;
        if (r3 == 2) goto L10;
        return new LinearCurveFit(r4, r5);
    L10:
        return new Constant(r4[0], r5[0]);
    L12:
        return new MonotonicCurveFit(r4, r5);
    }

    public static CurveFit getArc(int[] r1, double[] r2, double[][] r3) {
        return new ArcCurveFit(r1, r2, r3);
    }
}
