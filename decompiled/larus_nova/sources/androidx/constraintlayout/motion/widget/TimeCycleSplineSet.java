package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes17.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    float last_cycle;
    long last_time;
    private float[] mCache;
    protected boolean mContinue;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[][] mValues;
    protected int mWaveShape;

    public static class AlphaSet extends TimeCycleSplineSet {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setAlpha(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties;

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int r110) {
            int r100 = this.mConstraintAttributeList.size();
            int r101 = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] r102 = new double[r100];
            int r103 = r101 + 2;
            this.mTempValues = new float[r103];
            this.mCache = new float[r101];
            double[][] r104 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, r103});
            int r105 = 0;
        L3:
            if (r105 >= r100) goto L9;
            int r106 = this.mConstraintAttributeList.keyAt(r105);
            ConstraintAttribute r107 = this.mConstraintAttributeList.valueAt(r105);
            float[] r108 = this.mWaveProperties.valueAt(r105);
            r102[r105] = ((double) r106) * 0.01d;
            r107.getValuesToInterpolate(this.mTempValues);
            int r109 = 0;
        L5:
            float[] r111 = this.mTempValues;
            if (r109 >= r111.length) goto L8;
            r104[r105][r109] = r111[r109];
            r109 = r109 + 1;
            goto L5
        L8:
            double[] r112 = r104[r105];
            r112[r101] = r108[0];
            r112[r101 + 1] = r108[1];
            r105 = r105 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r110, r102, r104);
        }

        public CustomSet(String r100, SparseArray<ConstraintAttribute> r101) {
            this.mWaveProperties = new SparseArray();
            this.mAttributeName = r100.split(",")[1];
            this.mConstraintAttributeList = r101;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r110, float r111, long r210, KeyCache r211) {
            this.mCurveFit.getPos(r111, this.mTempValues);
            float[] r100 = this.mTempValues;
            float r101 = r100[r100.length - 2];
            float r102 = r100[r100.length - 1];
            long r103 = r210 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r104 = r211.getFloatValue(r110, this.mAttributeName, 0);
            this.last_cycle = r104;
            if (Float.isNaN(r104) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r105 = (float) ((((double) this.last_cycle) + ((r103 * 1.0E-9d) * ((double) r101))) % 1.0d);
            this.last_cycle = r105;
            this.last_time = r210;
            float r106 = calcWave(r105);
            this.mContinue = false;
            int r107 = 0;
        L8:
            float[] r108 = this.mCache;
            if (r107 >= r108.length) goto L15;
            boolean r109 = this.mContinue;
            float r112 = this.mTempValues[r107];
            if (r112 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            boolean r113 = true;
        L14:
            this.mContinue = r109 | r113;
            r108[r107] = (r112 * r106) + r102;
            r107 = r107 + 1;
            goto L8
        L13:
            r113 = false;
            goto L14
        L15:
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r110, this.mCache);
            if (r101 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        public void setPoint(int r100, ConstraintAttribute r101, float r102, int r103, float r104) {
            this.mConstraintAttributeList.append(r100, r101);
            this.mWaveProperties.append(r100, new float[]{r102, r104});
            this.mWaveShape = Math.max(this.mWaveShape, r103);
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int r100, float r101, float r102, int r103, float r104) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }
    }

    public static class ElevationSet extends TimeCycleSplineSet {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setElevation(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class PathRotate extends TimeCycleSplineSet {
        public PathRotate() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r103) {
            return this.mContinue;
        }

        public boolean setPathRotate(View r100, KeyCache r101, float r102, long r110, double r111, double r112) {
            r100.setRotation(get(r102, r110, r100, r101) + ((float) Math.toDegrees(Math.atan2(r112, r111))));
            return this.mContinue;
        }
    }

    public static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r110, float r111, long r112, KeyCache r113) {
            if ((r110 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r110).setProgress(get(r111, r112, r110, r113));
        L15:
            return this.mContinue;
        L6:
            if (this.mNoMethod == false) goto L19;
            return false;
        L19:
            Method r100 = r110.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r100 == null) goto L15;
            r100.invoke(r110, new Object[]{Float.valueOf(get(r111, r112, r110, r113))});     // Catch: Throwable -> L16
        L11:
            this.mNoMethod = true;
            r100 = null;
            goto L12
        }
    }

    public static class RotationSet extends TimeCycleSplineSet {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setRotation(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class RotationXset extends TimeCycleSplineSet {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setRotationX(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class RotationYset extends TimeCycleSplineSet {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setRotationY(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class ScaleXset extends TimeCycleSplineSet {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setScaleX(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class ScaleYset extends TimeCycleSplineSet {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setScaleY(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] r100, float[][] r101, int r102, int r103) {
            int[] r104 = new int[r100.length + 10];
            r104[0] = r103;
            r104[1] = r102;
            int r105 = 2;
        L3:
            if (r105 <= 0) goto L7;
            int r106 = r105 - 1;
            int r107 = r104[r106];
            r105 = r106 - 1;
            int r108 = r104[r105];
            if (r107 >= r108) goto L3;
            int r109 = partition(r100, r101, r107, r108);
            int r110 = r105 + 1;
            r104[r105] = r109 - 1;
            int r111 = r110 + 1;
            r104[r110] = r107;
            int r112 = r111 + 1;
            r104[r111] = r108;
            r105 = r112 + 1;
            r104[r112] = r109 + 1;
            goto L3
        }

        private static int partition(int[] r100, float[][] r101, int r102, int r103) {
            int r104 = r100[r103];
            int r105 = r102;
        L3:
            if (r102 >= r103) goto L8;
            if (r100[r102] > r104) goto L7;
            swap(r100, r101, r105, r102);
            r105 = r105 + 1;
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            swap(r100, r101, r105, r103);
            return r105;
        }

        private static void swap(int[] r100, float[][] r101, int r102, int r103) {
            int r104 = r100[r102];
            r100[r102] = r100[r103];
            r100[r103] = r104;
            float[] r105 = r101[r102];
            r101[r102] = r101[r103];
            r101[r103] = r105;
        }
    }

    public static class TranslationXset extends TimeCycleSplineSet {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setTranslationX(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class TranslationYset extends TimeCycleSplineSet {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setTranslationY(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public static class TranslationZset extends TimeCycleSplineSet {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r100, float r101, long r102, KeyCache r110) {
            r100.setTranslationZ(get(r101, r102, r100, r110));
            return this.mContinue;
        }
    }

    public abstract boolean setProperty(View r100, float r101, long r102, KeyCache r103);

    public String toString() {
        String r100 = this.mType;
        DecimalFormat r101 = new DecimalFormat("##.##");
        int r102 = 0;
    L4:
        if (r102 >= this.count) goto L6;
        r100 = r100 + "[" + this.mTimePoints[r102] + " , " + r101.format(this.mValues[r102]) + "] ";
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    public TimeCycleSplineSet() {
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        Class r100 = Float.TYPE;
        this.mValues = (float[][]) Array.newInstance(r100, new int[]{10, 3});
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float calcWave(float r100) {
        switch(this.mWaveShape) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r101 = 1.0f - Math.abs(((r100 * 4.0f) % 4.0f) - 2.0f);
        float r102 = r101 * r101;
    L8:
        return 1.0f - r102;
    L11:
        r102 = ((r100 * 2.0f) + 1.0f) % 2.0f;
        goto L8
    L14:
        r102 = Math.abs(r100);
        goto L8
    L5:
        return (float) Math.sin(r100 * VAL_2PI);
    L10:
        return (float) Math.cos(r100 * VAL_2PI);
    L13:
        return (((r100 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L16:
        return Math.signum(r100 * VAL_2PI);
    }

    public void setStartTime(long r100) {
        this.last_time = r100;
    }

    public void setType(String r100) {
        this.mType = r100;
    }

    public void setup(int r110) {
        int r100 = this.count;
        if (r100 == 0) goto L5;
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r100 - 1);
        int r101 = 1;
        int r102 = 0;
    L7:
        int[] r103 = this.mTimePoints;
        if (r101 >= r103.length) goto L13;
        if (r103[r101] == r103[r101 - 1]) goto L12;
        r102 = r102 + 1;
    L12:
        r101 = r101 + 1;
        goto L7
    L13:
        if (r102 != 0) goto L15;
        r102 = 1;
    L15:
        double[] r104 = new double[r102];
        double[][] r105 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r102, 3});
        int r106 = 0;
        int r107 = 0;
    L17:
        if (r106 >= this.count) goto L24;
        if (r106 <= 0) goto L22;
        int[] r108 = this.mTimePoints;
        if (r108[r106] != r108[r106 - 1]) goto L22;
    L23:
        r106 = r106 + 1;
    L22:
        r104[r107] = ((double) this.mTimePoints[r106]) * 0.01d;
        double[] r109 = r105[r107];
        float[] r111 = this.mValues[r106];
        r109[0] = r111[0];
        r109[1] = r111[1];
        r109[2] = r111[2];
        r107 = r107 + 1;
        goto L23
    L24:
        this.mCurveFit = CurveFit.get(r110, r104, r105);
        return;
    }

    public static TimeCycleSplineSet makeCustomSpline(String r100, SparseArray<ConstraintAttribute> r101) {
        return new CustomSet(r100, r101);
    }

    public static TimeCycleSplineSet makeSpline(String r100, long r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1249320806: goto L50;
            case -1249320805: goto L46;
            case -1225497657: goto L42;
            case -1225497656: goto L38;
            case -1225497655: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -40300674: goto L18;
            case -4379043: goto L14;
            case 37232917: goto L10;
            case 92909918: goto L6;
            default: goto L53;
        };
    L53:
        switch(r102) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        return null;
    L56:
        TimeCycleSplineSet r103 = new AlphaSet();
    L68:
        r103.setStartTime(r101);
        return r103;
    L57:
        r103 = new PathRotate();
        goto L68
    L58:
        r103 = new ElevationSet();
        goto L68
    L59:
        r103 = new RotationSet();
        goto L68
    L60:
        r103 = new ScaleYset();
        goto L68
    L61:
        r103 = new ScaleXset();
        goto L68
    L62:
        r103 = new ProgressSet();
        goto L68
    L63:
        r103 = new TranslationZset();
        goto L68
    L64:
        r103 = new TranslationYset();
        goto L68
    L65:
        r103 = new TranslationXset();
        goto L68
    L66:
        r103 = new RotationYset();
        goto L68
    L67:
        r103 = new RotationXset();
        goto L68
    L6:
        if (r100.equals("alpha") == false) goto L53;
        r102 = 11;
        goto L53
    L10:
        if (r100.equals("transitionPathRotate") == false) goto L53;
        r102 = 10;
        goto L53
    L14:
        if (r100.equals("elevation") == false) goto L53;
        r102 = 9;
        goto L53
    L18:
        if (r100.equals("rotation") == false) goto L53;
        r102 = 8;
        goto L53
    L22:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L53;
        r102 = 7;
        goto L53
    L26:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L53;
        r102 = 6;
        goto L53
    L30:
        if (r100.equals("progress") == false) goto L53;
        r102 = 5;
        goto L53
    L34:
        if (r100.equals("translationZ") == false) goto L53;
        r102 = 4;
        goto L53
    L38:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L53;
        r102 = 3;
        goto L53
    L42:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L53;
        r102 = 2;
        goto L53
    L46:
        if (r100.equals("rotationY") == false) goto L53;
        r102 = 1;
        goto L53
    L50:
        if (r100.equals("rotationX") == false) goto L53;
        r102 = 0;
        goto L53
    }

    public float get(float r110, long r210, View r211, KeyCache r212) {
        this.mCurveFit.getPos(r110, this.mCache);
        float[] r100 = this.mCache;
        float r101 = r100[1];
        if (r101 != 0.0f) goto L7;
        this.mContinue = false;
        return r100[2];
    L7:
        if (Float.isNaN(this.last_cycle) == false) goto L11;
        float r102 = r212.getFloatValue(r211, this.mType, 0);
        this.last_cycle = r102;
        if (Float.isNaN(r102) == false) goto L11;
        this.last_cycle = 0.0f;
    L11:
        float r103 = (float) ((((double) this.last_cycle) + (((r210 - this.last_time) * 1.0E-9d) * ((double) r101))) % 1.0d);
        this.last_cycle = r103;
        r212.setFloatValue(r211, this.mType, 0, r103);
        this.last_time = r210;
        float r104 = this.mCache[0];
        float r105 = (calcWave(this.last_cycle) * r104) + this.mCache[2];
        if (r104 != 0.0f) goto L16;
        if (r101 != 0.0f) goto L16;
        boolean r106 = false;
    L17:
        this.mContinue = r106;
        return r105;
    L16:
        r106 = true;
        goto L17
    }

    public void setPoint(int r100, float r101, float r102, int r103, float r104) {
        int[] r105 = this.mTimePoints;
        int r106 = this.count;
        r105[r106] = r100;
        float[] r107 = this.mValues[r106];
        r107[0] = r101;
        r107[1] = r102;
        r107[2] = r104;
        this.mWaveShape = Math.max(this.mWaveShape, r103);
        this.count++;
    }
}
