package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[] mValues;

    public static class AlphaSet extends SplineSet {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setAlpha(get(r101));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int r110) {
            int r100 = this.mConstraintAttributeList.size();
            int r101 = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] r102 = new double[r100];
            this.mTempValues = new float[r101];
            double[][] r103 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, r101});
            int r104 = 0;
        L3:
            if (r104 >= r100) goto L9;
            int r105 = this.mConstraintAttributeList.keyAt(r104);
            ConstraintAttribute r106 = this.mConstraintAttributeList.valueAt(r104);
            r102[r104] = ((double) r105) * 0.01d;
            r106.getValuesToInterpolate(this.mTempValues);
            int r107 = 0;
        L5:
            float[] r108 = this.mTempValues;
            if (r107 >= r108.length) goto L8;
            r103[r104][r107] = r108[r107];
            r107 = r107 + 1;
            goto L5
        L8:
            r104 = r104 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r110, r102, r103);
        }

        public CustomSet(String r100, SparseArray<ConstraintAttribute> r101) {
            this.mAttributeName = r100.split(",")[1];
            this.mConstraintAttributeList = r101;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int r100, float r101) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            this.mCurveFit.getPos(r101, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r100, this.mTempValues);
        }

        public void setPoint(int r100, ConstraintAttribute r101) {
            this.mConstraintAttributeList.append(r100, r101);
        }
    }

    public static class ElevationSet extends SplineSet {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setElevation(get(r101));
        }
    }

    public static class PathRotate extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
        }

        public PathRotate() {
        }

        public void setPathRotate(View r100, float r101, double r102, double r103) {
            r100.setRotation(get(r101) + ((float) Math.toDegrees(Math.atan2(r103, r102))));
        }
    }

    public static class PivotXset extends SplineSet {
        public PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setPivotX(get(r101));
        }
    }

    public static class PivotYset extends SplineSet {
        public PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setPivotY(get(r101));
        }
    }

    public static class ProgressSet extends SplineSet {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            if ((r100 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r100).setProgress(get(r101));
            return;
        L6:
            if (this.mNoMethod == false) goto L18;
            return;
        L18:
            Method r102 = r100.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r102 == null) goto L21;
            r102.invoke(r100, new Object[]{Float.valueOf(get(r101))});     // Catch: Throwable -> L15
            return;
        L22:
            return;
        L21:
            return;
        L11:
            this.mNoMethod = true;
            r102 = null;
            goto L12
        }
    }

    public static class RotationSet extends SplineSet {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setRotation(get(r101));
        }
    }

    public static class RotationXset extends SplineSet {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setRotationX(get(r101));
        }
    }

    public static class RotationYset extends SplineSet {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setRotationY(get(r101));
        }
    }

    public static class ScaleXset extends SplineSet {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setScaleX(get(r101));
        }
    }

    public static class ScaleYset extends SplineSet {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setScaleY(get(r101));
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] r100, float[] r101, int r102, int r103) {
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

        private static int partition(int[] r100, float[] r101, int r102, int r103) {
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

        private static void swap(int[] r100, float[] r101, int r102, int r103) {
            int r104 = r100[r102];
            r100[r102] = r100[r103];
            r100[r103] = r104;
            float r105 = r101[r102];
            r101[r102] = r101[r103];
            r101[r103] = r105;
        }
    }

    public static class TranslationXset extends SplineSet {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setTranslationX(get(r101));
        }
    }

    public static class TranslationYset extends SplineSet {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setTranslationY(get(r101));
        }
    }

    public static class TranslationZset extends SplineSet {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View r100, float r101) {
            r100.setTranslationZ(get(r101));
        }
    }

    public abstract void setProperty(View r100, float r101);

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

    public SplineSet() {
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public static SplineSet makeSpline(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1249320806: goto L66;
            case -1249320805: goto L62;
            case -1225497657: goto L58;
            case -1225497656: goto L54;
            case -1225497655: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -797520672: goto L34;
            case -760884510: goto L30;
            case -760884509: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L69;
        };
    L69:
        switch(r101) {
            case 0: goto L103;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        return null;
    L73:
        return new AlphaSet();
    L75:
        return new AlphaSet();
    L77:
        return new PathRotate();
    L79:
        return new ElevationSet();
    L81:
        return new RotationSet();
    L83:
        return new PivotYset();
    L85:
        return new PivotXset();
    L87:
        return new AlphaSet();
    L89:
        return new ScaleYset();
    L91:
        return new ScaleXset();
    L93:
        return new ProgressSet();
    L95:
        return new TranslationZset();
    L97:
        return new TranslationYset();
    L99:
        return new TranslationXset();
    L101:
        return new RotationYset();
    L103:
        return new RotationXset();
    L6:
        if (r100.equals("waveOffset") == false) goto L69;
        r101 = 15;
        goto L69
    L10:
        if (r100.equals("alpha") == false) goto L69;
        r101 = 14;
        goto L69
    L14:
        if (r100.equals("transitionPathRotate") == false) goto L69;
        r101 = HTTP.CR;
        goto L69
    L18:
        if (r100.equals("elevation") == false) goto L69;
        r101 = 12;
        goto L69
    L22:
        if (r100.equals("rotation") == false) goto L69;
        r101 = 11;
        goto L69
    L26:
        if (r100.equals("transformPivotY") == false) goto L69;
        r101 = 10;
        goto L69
    L30:
        if (r100.equals("transformPivotX") == false) goto L69;
        r101 = 9;
        goto L69
    L34:
        if (r100.equals("waveVariesBy") == false) goto L69;
        r101 = 8;
        goto L69
    L38:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L69;
        r101 = 7;
        goto L69
    L42:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L69;
        r101 = 6;
        goto L69
    L46:
        if (r100.equals("progress") == false) goto L69;
        r101 = 5;
        goto L69
    L50:
        if (r100.equals("translationZ") == false) goto L69;
        r101 = 4;
        goto L69
    L54:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L69;
        r101 = 3;
        goto L69
    L58:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L69;
        r101 = 2;
        goto L69
    L62:
        if (r100.equals("rotationY") == false) goto L69;
        r101 = 1;
        goto L69
    L66:
        if (r100.equals("rotationX") == false) goto L69;
        r101 = 0;
        goto L69
    }

    public float get(float r100) {
        return (float) this.mCurveFit.getPos(r100, 0);
    }

    public float getSlope(float r100) {
        return (float) this.mCurveFit.getSlope(r100, 0);
    }

    public void setType(String r100) {
        this.mType = r100;
    }

    public void setup(int r110) {
        int r100 = this.count;
        if (r100 != 0) goto L5;
        return;
    L5:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r100 - 1);
        int r101 = 1;
        int r102 = 1;
    L7:
        if (r101 >= this.count) goto L12;
        int[] r103 = this.mTimePoints;
        if (r103[r101 - 1] == r103[r101]) goto L11;
        r102 = r102 + 1;
    L11:
        r101 = r101 + 1;
        goto L7
    L12:
        double[] r104 = new double[r102];
        double[][] r105 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r102, 1});
        int r106 = 0;
        int r107 = 0;
    L14:
        if (r106 >= this.count) goto L21;
        if (r106 <= 0) goto L19;
        int[] r108 = this.mTimePoints;
        if (r108[r106] != r108[r106 - 1]) goto L19;
    L20:
        r106 = r106 + 1;
    L19:
        r104[r107] = ((double) this.mTimePoints[r106]) * 0.01d;
        r105[r107][0] = this.mValues[r106];
        r107 = r107 + 1;
        goto L20
    L21:
        this.mCurveFit = CurveFit.get(r110, r104, r105);
    }

    public static SplineSet makeCustomSpline(String r100, SparseArray<ConstraintAttribute> r101) {
        return new CustomSet(r100, r101);
    }

    public void setPoint(int r100, float r101) {
        int[] r102 = this.mTimePoints;
        if (r102.length >= (this.count + 1)) goto L5;
        this.mTimePoints = Arrays.copyOf(r102, r102.length * 2);
        float[] r103 = this.mValues;
        this.mValues = Arrays.copyOf(r103, r103.length * 2);
    L5:
        int[] r104 = this.mTimePoints;
        int r105 = this.count;
        r104[r105] = r100;
        this.mValues[r105] = r101;
        this.count = r105 + 1;
    }
}
