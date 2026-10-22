package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy;
    ArrayList<WavePoint> mWavePoints;
    private int mWaveShape;
    private String mWaveString;

    private static class CoreSpline extends KeyCycleOscillator {
        String type;
        int typeId;

        public CoreSpline(String r1) {
            this.type = r1;
            this.typeId = TypedValues.CycleType.getId(r1);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget r2, float r3) {
            r2.setValue(this.typeId, get(r3));
        }
    }

    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        private final int OFFST;
        private final int PHASE;
        private final int VALUE;
        CurveFit mCurveFit;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        float[] mPhase;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        CycleOscillator(int r3, String r4, int r5, int r6) {
            Oscillator r0 = new Oscillator();
            this.mOscillator = r0;
            this.OFFST = 0;
            this.PHASE = 1;
            this.VALUE = 2;
            this.mWaveShape = r3;
            this.mVariesBy = r5;
            r0.setType(r3, r4);
            this.mValues = new float[r6];
            this.mPosition = new double[r6];
            this.mPeriod = new float[r6];
            this.mOffset = new float[r6];
            this.mPhase = new float[r6];
            this.mScale = new float[r6];
        }

        public double getValues(float r10) {
            CurveFit r0 = this.mCurveFit;
            if (r0 == null) goto L5;
            r0.getPos(r10, this.mSplineValueCache);
        L6:
            double[] r1 = this.mSplineValueCache;
            return r1[0] + (this.mOscillator.getValue(r10, r1[1]) * this.mSplineValueCache[2]);
        L5:
            double[] r2 = this.mSplineValueCache;
            r2[0] = this.mOffset[0];
            r2[1] = this.mPhase[0];
            r2[2] = this.mValues[0];
            goto L6
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float r14) {
            CurveFit r0 = this.mCurveFit;
            if (r0 == null) goto L5;
            double r4 = r14;
            r0.getSlope(r4, this.mSplineSlopeCache);
            this.mCurveFit.getPos(r4, this.mSplineValueCache);
        L6:
            double r5 = r14;
            double r11 = this.mOscillator.getValue(r5, this.mSplineValueCache[1]);
            double r3 = this.mOscillator.getSlope(r5, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] r15 = this.mSplineSlopeCache;
            return (r15[0] + (r11 * r15[2])) + (r3 * this.mSplineValueCache[2]);
        L5:
            double[] r1 = this.mSplineSlopeCache;
            r1[0] = 0.0d;
            r1[1] = 0.0d;
            r1[2] = 0.0d;
            goto L6
        }

        public void setPoint(int r6, int r7, float r8, float r9, float r10, float r11) {
            this.mPosition[r6] = ((double) r7) / 100.0d;
            this.mPeriod[r6] = r8;
            this.mOffset[r6] = r9;
            this.mPhase[r6] = r10;
            this.mValues[r6] = r11;
        }

        public void setup(float r10) {
            this.mPathLength = r10;
            double[][] r11 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.mPosition.length, 3});
            float[] r1 = this.mValues;
            this.mSplineValueCache = new double[r1.length + 2];
            this.mSplineSlopeCache = new double[r1.length + 2];
            if (this.mPosition[0] <= 0.0d) goto L5;
            this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
        L5:
            double[] r2 = this.mPosition;
            int r4 = r2.length - 1;
            if (r2[r4] >= 1.0d) goto L8;
            this.mOscillator.addPoint(1.0d, this.mPeriod[r4]);
        L8:
            int r3 = 0;
        L10:
            if (r3 >= r11.length) goto L12;
            double[] r5 = r11[r3];
            r5[0] = this.mOffset[r3];
            r5[1] = this.mPhase[r3];
            r5[2] = this.mValues[r3];
            this.mOscillator.addPoint(this.mPosition[r3], this.mPeriod[r3]);
            r3 = r3 + 1;
            goto L10
        L12:
            this.mOscillator.normalize();
            double[] r0 = this.mPosition;
            if (r0.length <= 1) goto L15;
            this.mCurveFit = CurveFit.get(0, r0, r11);
            return;
        L15:
            this.mCurveFit = null;
        }
    }

    private static class IntDoubleSort {
        private IntDoubleSort() {
        }

        static void sort(int[] r6, float[] r7, int r8, int r9) {
            int[] r0 = new int[r6.length + 10];
            r0[0] = r9;
            r0[1] = r8;
            int r10 = 2;
        L3:
            if (r10 <= 0) goto L7;
            int r11 = r10 - 1;
            int r1 = r0[r11];
            r10 = r11 - 1;
            int r2 = r0[r10];
            if (r1 >= r2) goto L3;
            int r3 = partition(r6, r7, r1, r2);
            int r4 = r10 + 1;
            r0[r10] = r3 - 1;
            int r12 = r4 + 1;
            r0[r4] = r1;
            int r5 = r12 + 1;
            r0[r12] = r2;
            r10 = r5 + 1;
            r0[r5] = r3 + 1;
            goto L3
        }

        private static int partition(int[] r3, float[] r4, int r5, int r6) {
            int r0 = r3[r6];
            int r1 = r5;
        L3:
            if (r5 >= r6) goto L8;
            if (r3[r5] > r0) goto L7;
            swap(r3, r4, r1, r5);
            r1 = r1 + 1;
        L7:
            r5 = r5 + 1;
            goto L3
        L8:
            swap(r3, r4, r1, r6);
            return r1;
        }

        private static void swap(int[] r2, float[] r3, int r4, int r5) {
            int r0 = r2[r4];
            r2[r4] = r2[r5];
            r2[r5] = r0;
            float r6 = r3[r4];
            r3[r4] = r3[r5];
            r3[r5] = r6;
        }
    }

    private static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        static void sort(int[] r6, float[] r7, float[] r8, int r9, int r10) {
            int[] r0 = new int[r6.length + 10];
            r0[0] = r10;
            r0[1] = r9;
            int r11 = 2;
        L3:
            if (r11 <= 0) goto L7;
            int r12 = r11 - 1;
            int r1 = r0[r12];
            r11 = r12 - 1;
            int r2 = r0[r11];
            if (r1 >= r2) goto L3;
            int r3 = partition(r6, r7, r8, r1, r2);
            int r4 = r11 + 1;
            r0[r11] = r3 - 1;
            int r13 = r4 + 1;
            r0[r4] = r1;
            int r5 = r13 + 1;
            r0[r13] = r2;
            r11 = r5 + 1;
            r0[r5] = r3 + 1;
            goto L3
        }

        private static int partition(int[] r3, float[] r4, float[] r5, int r6, int r7) {
            int r0 = r3[r7];
            int r1 = r6;
        L3:
            if (r6 >= r7) goto L8;
            if (r3[r6] > r0) goto L7;
            swap(r3, r4, r5, r1, r6);
            r1 = r1 + 1;
        L7:
            r6 = r6 + 1;
            goto L3
        L8:
            swap(r3, r4, r5, r1, r7);
            return r1;
        }

        private static void swap(int[] r2, float[] r3, float[] r4, int r5, int r6) {
            int r0 = r2[r5];
            r2[r5] = r2[r6];
            r2[r6] = r0;
            float r7 = r3[r5];
            r3[r5] = r3[r6];
            r3[r6] = r7;
            float r8 = r4[r5];
            r4[r5] = r4[r6];
            r4[r6] = r8;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String type;
        int typeId;

        public PathRotateSet(String r1) {
            this.type = r1;
            this.typeId = TypedValues.CycleType.getId(r1);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget r2, float r3) {
            r2.setValue(this.typeId, get(r3));
        }

        public void setPathRotate(MotionWidget r1, float r2, double r3, double r5) {
            r1.setRotationZ(get(r2) + ((float) Math.toDegrees(Math.atan2(r5, r3))));
        }
    }

    static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int r1, float r2, float r3, float r4, float r5) {
            this.mPosition = r1;
            this.mValue = r5;
            this.mOffset = r3;
            this.mPeriod = r2;
            this.mPhase = r4;
        }
    }

    protected void setCustom(Object r1) {
    }

    public void setProperty(MotionWidget r1, float r2) {
    }

    public KeyCycleOscillator() {
        this.mWaveShape = 0;
        this.mWaveString = null;
        this.mVariesBy = 0;
        this.mWavePoints = new ArrayList();
    }

    public static KeyCycleOscillator makeWidgetCycle(String r1) {
        if (r1.equals("pathRotate") == false) goto L7;
        return new PathRotateSet(r1);
    L7:
        return new CoreSpline(r1);
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        String r0 = this.mType;
        DecimalFormat r1 = new DecimalFormat("##.##");
        Iterator<WavePoint> r4 = this.mWavePoints.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        WavePoint r2 = r4.next();
        r0 = r0 + "[" + r2.mPosition + " , " + r1.format(r2.mValue) + "] ";
        goto L4
    L6:
        return r0;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public float get(float r1) {
        return (float) this.mCycleOscillator.getValues(r1);
    }

    public float getSlope(float r1) {
        return (float) this.mCycleOscillator.getSlope(r1);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18, Object r19) {
        this.mWavePoints.add(new WavePoint(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.mVariesBy = r14;
    L5:
        this.mWaveShape = r12;
        setCustom(r19);
        this.mWaveString = r13;
    }

    public void setPoint(int r11, int r12, String r13, int r14, float r15, float r16, float r17, float r18) {
        this.mWavePoints.add(new WavePoint(r11, r15, r16, r17, r18));
        if (r14 == (-1)) goto L5;
        this.mVariesBy = r14;
    L5:
        this.mWaveShape = r12;
        this.mWaveString = r13;
    }

    public void setup(float r15) {
        int r0 = this.mWavePoints.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.mWavePoints, new AnonymousClass1(this));
        double[] r1 = new double[r0];
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, 3});
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, r0);
        Iterator<WavePoint> r2 = this.mWavePoints.iterator();
        int r13 = 0;
    L7:
        if (r2.hasNext() == false) goto L9;
        WavePoint r6 = r2.next();
        r1[r13] = ((double) r6.mPeriod) * 0.01d;
        r3[r13][0] = r6.mValue;
        r3[r13][1] = r6.mOffset;
        r3[r13][2] = r6.mPhase;
        this.mCycleOscillator.setPoint(r13, r6.mPosition, r6.mPeriod, r6.mOffset, r6.mPhase, r6.mValue);
        r13 = r13 + 1;
        goto L7
    L9:
        this.mCycleOscillator.setup(r15);
        this.mCurveFit = CurveFit.get(0, r1, r3);
    }
}
