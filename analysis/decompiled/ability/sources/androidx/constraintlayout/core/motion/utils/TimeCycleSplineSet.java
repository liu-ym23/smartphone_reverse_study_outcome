package androidx.constraintlayout.core.motion.utils;

import androidx.appfunctions.metadata.a;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected long mLastTime;
    protected String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    protected float[] mCache = new float[3];
    protected boolean mContinue = false;
    protected float mLastCycle = Float.NaN;

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f7, int i6, float f9) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j5, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f7 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            long j6 = j5 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f10 = (float) ((((j6 * 1.0E-9d) * f7) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f10;
            this.mLastTime = j5;
            float fCalcWave = calcWave(f10);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z10 = this.mContinue;
                float f11 = this.mTempValues[i];
                this.mContinue = z10 | (((double) f11) != 0.0d);
                fArr2[i] = (f11 * fCalcWave) + f9;
                i++;
            }
            motionWidget.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f7 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i6);
            for (int i10 = 0; i10 < size; i10++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i10);
                CustomAttribute customAttributeValueAt = this.mConstraintAttributeList.valueAt(i10);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i10);
                dArr[i10] = iKeyAt * 0.01d;
                customAttributeValueAt.getValuesToInterpolate(this.mTempValues);
                int i11 = 0;
                while (true) {
                    if (i11 < this.mTempValues.length) {
                        dArr2[i10][i11] = r8[i11];
                        i11++;
                    }
                }
                double[] dArr3 = dArr2[i10];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomAttribute customAttribute, float f, int i6, float f7) {
            this.mConstraintAttributeList.append(i, customAttribute);
            this.mWaveProperties.append(i, new float[]{f, f7});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f7, int i6, float f9) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j5, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f7 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            long j6 = j5 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f10 = (float) ((((j6 * 1.0E-9d) * f7) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f10;
            this.mLastTime = j5;
            float fCalcWave = calcWave(f10);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z10 = this.mContinue;
                float f11 = this.mTempValues[i];
                this.mContinue = z10 | (((double) f11) != 0.0d);
                fArr2[i] = (f11 * fCalcWave) + f9;
                i++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCustomCache);
            if (f7 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i6);
            for (int i10 = 0; i10 < size; i10++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i10);
                CustomVariable customVariableValueAt = this.mConstraintAttributeList.valueAt(i10);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i10);
                dArr[i10] = iKeyAt * 0.01d;
                customVariableValueAt.getValuesToInterpolate(this.mTempValues);
                int i11 = 0;
                while (true) {
                    if (i11 < this.mTempValues.length) {
                        dArr2[i10][i11] = r8[i11];
                        i11++;
                    }
                }
                double[] dArr3 = dArr2[i10];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomVariable customVariable, float f, int i6, float f7) {
            this.mConstraintAttributeList.append(i, customVariable);
            this.mWaveProperties.append(i, new float[]{f, f7});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i, int i6) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i6;
            iArr2[1] = i;
            int i10 = 2;
            while (i10 > 0) {
                int i11 = iArr2[i10 - 1];
                int i12 = i10 - 2;
                int i13 = iArr2[i12];
                if (i11 < i13) {
                    int iPartition = partition(iArr, fArr, i11, i13);
                    iArr2[i12] = iPartition - 1;
                    iArr2[i10 - 1] = i11;
                    int i14 = i10 + 1;
                    iArr2[i10] = i13;
                    i10 += 2;
                    iArr2[i14] = iPartition + 1;
                } else {
                    i10 = i12;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i, int i6) {
            int i10 = iArr[i6];
            int i11 = i;
            while (i < i6) {
                if (iArr[i] <= i10) {
                    swap(iArr, fArr, i11, i);
                    i11++;
                }
                i++;
            }
            swap(iArr, fArr, i11, i6);
            return i11;
        }

        private static void swap(int[] iArr, float[][] fArr, int i, int i6) {
            int i10 = iArr[i];
            iArr[i] = iArr[i6];
            iArr[i6] = i10;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i6];
            fArr[i6] = fArr2;
        }
    }

    public float calcWave(float f) {
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f * sVal2PI);
            case 2:
                return 1.0f - Math.abs(f);
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(f * sVal2PI);
            case 6:
                float fAbs = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (fAbs * fAbs);
            default:
                return (float) Math.sin(f * sVal2PI);
        }
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, float f, float f7, int i6, float f9) {
        int[] iArr = this.mTimePoints;
        int i10 = this.mCount;
        iArr[i10] = i;
        float[] fArr = this.mValues[i10];
        fArr[0] = f;
        fArr[1] = f7;
        fArr[2] = f9;
        this.mWaveShape = Math.max(this.mWaveShape, i6);
        this.mCount++;
    }

    public void setStartTime(long j5) {
        this.mLastTime = j5;
    }

    public void setType(String str) {
        this.mType = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setup(int r12) {
        /*
            r11 = this;
            int r0 = r11.mCount
            if (r0 != 0) goto L1a
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error no points added to "
            r0.<init>(r1)
            java.lang.String r11 = r11.mType
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.println(r11)
            return
        L1a:
            int[] r1 = r11.mTimePoints
            float[][] r2 = r11.mValues
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.Sort.doubleQuickSort(r1, r2, r4, r0)
            r0 = r3
            r1 = r4
        L26:
            int[] r2 = r11.mTimePoints
            int r5 = r2.length
            if (r0 >= r5) goto L38
            r5 = r2[r0]
            int r6 = r0 + (-1)
            r2 = r2[r6]
            if (r5 == r2) goto L35
            int r1 = r1 + 1
        L35:
            int r0 = r0 + 1
            goto L26
        L38:
            if (r1 != 0) goto L3b
            r1 = r3
        L3b:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r5 = new int[r2]
            r6 = 3
            r5[r3] = r6
            r5[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r5)
            double[][] r1 = (double[][]) r1
            r5 = r4
            r6 = r5
        L4f:
            int r7 = r11.mCount
            if (r5 >= r7) goto L87
            if (r5 <= 0) goto L60
            int[] r7 = r11.mTimePoints
            r8 = r7[r5]
            int r9 = r5 + (-1)
            r7 = r7[r9]
            if (r8 != r7) goto L60
            goto L84
        L60:
            int[] r7 = r11.mTimePoints
            r7 = r7[r5]
            double r7 = (double) r7
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r7 = r7 * r9
            r0[r6] = r7
            r7 = r1[r6]
            float[][] r8 = r11.mValues
            r8 = r8[r5]
            r9 = r8[r4]
            double r9 = (double) r9
            r7[r4] = r9
            r9 = r8[r3]
            double r9 = (double) r9
            r7[r3] = r9
            r8 = r8[r2]
            double r8 = (double) r8
            r7[r2] = r8
            int r6 = r6 + 1
        L84:
            int r5 = r5 + 1
            goto L4f
        L87:
            androidx.constraintlayout.core.motion.utils.CurveFit r12 = androidx.constraintlayout.core.motion.utils.CurveFit.get(r12, r0, r1)
            r11.mCurveFit = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.setup(int):void");
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.mCount; i++) {
            StringBuilder sbX = a.x(string, "[");
            sbX.append(this.mTimePoints[i]);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(this.mValues[i]));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }
}
