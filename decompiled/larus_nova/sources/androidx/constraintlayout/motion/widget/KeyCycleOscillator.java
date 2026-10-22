package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy;
    ArrayList<WavePoint> mWavePoints;
    private int mWaveShape;

    public static class AlphaSet extends KeyCycleOscillator {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setAlpha(get(r101));
        }
    }

    public static class CustomSet extends KeyCycleOscillator {
        float[] value;

        public CustomSet() {
            this.value = new float[1];
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            this.value[0] = get(r101);
            this.mCustom.setInterpolatedValue(r100, this.value);
        }
    }

    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public double getSlope(float r110) {
            CurveFit r100 = this.mCurveFit;
            if (r100 == null) goto L5;
            double r101 = r110;
            r100.getSlope(r101, this.mSplineSlopeCache);
            this.mCurveFit.getPos(r101, this.mSplineValueCache);
        L6:
            double r102 = r110;
            double r103 = this.mOscillator.getValue(r102);
            double r104 = this.mOscillator.getSlope(r102);
            double[] r111 = this.mSplineSlopeCache;
            return (r111[0] + (r103 * r111[1])) + (r104 * this.mSplineValueCache[1]);
        L5:
            double[] r105 = this.mSplineSlopeCache;
            r105[0] = 0.0d;
            r105[1] = 0.0d;
            goto L6
        }

        public double getValues(float r100) {
            CurveFit r101 = this.mCurveFit;
            if (r101 == null) goto L5;
            r101.getPos(r100, this.mSplineValueCache);
        L7:
            return this.mSplineValueCache[0] + (this.mOscillator.getValue(r100) * this.mSplineValueCache[1]);
        L5:
            double[] r102 = this.mSplineValueCache;
            r102[0] = this.mOffset[0];
            r102[1] = this.mValues[0];
            goto L7
        }

        public void setup(float r100) {
            this.mPathLength = r100;
            double[][] r101 = (double[][]) Array.newInstance(Double.TYPE, new int[]{this.mPosition.length, 2});
            float[] r102 = this.mValues;
            this.mSplineValueCache = new double[r102.length + 1];
            this.mSplineSlopeCache = new double[r102.length + 1];
            if (this.mPosition[0] <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
            this.mOscillator.addPoint(AudioStats.AUDIO_AMPLITUDE_NONE, this.mPeriod[0]);
        L5:
            double[] r103 = this.mPosition;
            int r104 = r103.length - 1;
            if (r103[r104] >= 1.0d) goto L8;
            this.mOscillator.addPoint(1.0d, this.mPeriod[r104]);
        L8:
            int r105 = 0;
        L10:
            if (r105 >= r101.length) goto L16;
            r101[r105][0] = this.mOffset[r105];
            int r106 = 0;
        L12:
            float[] r107 = this.mValues;
            if (r106 >= r107.length) goto L15;
            r101[r106][1] = r107[r106];
            r106 = r106 + 1;
            goto L12
        L15:
            this.mOscillator.addPoint(this.mPosition[r105], this.mPeriod[r105]);
            r105 = r105 + 1;
            goto L10
        L16:
            this.mOscillator.normalize();
            double[] r108 = this.mPosition;
            if (r108.length <= 1) goto L19;
            this.mCurveFit = CurveFit.get(0, r108, r101);
            return;
        L19:
            this.mCurveFit = null;
        }

        private ConstraintAttribute get(String r100, ConstraintAttribute.AttributeType r101) {
            if (this.mCustomConstraints.containsKey(r100) == false) goto L9;
            ConstraintAttribute r102 = this.mCustomConstraints.get(r100);
            if (r102.getType() != r101) goto L8;
            return r102;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r102.getType().name());
        L9:
            ConstraintAttribute r103 = new ConstraintAttribute(r100, r101);
            this.mCustomConstraints.put(r100, r103);
            return r103;
        }

        public CycleOscillator(int r100, int r101, int r102) {
            this.mOscillator = new Oscillator();
            this.mCustomConstraints = new HashMap();
            this.mWaveShape = r100;
            this.mVariesBy = r101;
            this.mOscillator.setType(r100);
            this.mValues = new float[r102];
            this.mPosition = new double[r102];
            this.mPeriod = new float[r102];
            this.mOffset = new float[r102];
            this.mScale = new float[r102];
        }

        public void setPoint(int r100, int r101, float r102, float r103, float r110) {
            this.mPosition[r100] = ((double) r101) / 100.0d;
            this.mPeriod[r100] = r102;
            this.mOffset[r100] = r103;
            this.mValues[r100] = r110;
        }
    }

    public static class ElevationSet extends KeyCycleOscillator {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setElevation(get(r101));
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
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

        public static void sort(int[] r100, float[] r101, int r102, int r103) {
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

        private static void swap(int[] r100, float[] r101, int r102, int r103) {
            int r104 = r100[r102];
            r100[r102] = r100[r103];
            r100[r103] = r104;
            float r105 = r101[r102];
            r101[r102] = r101[r103];
            r101[r103] = r105;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] r100, float[] r101, float[] r102, int r103, int r104) {
            int r105 = r100[r104];
            int r106 = r103;
        L3:
            if (r103 >= r104) goto L8;
            if (r100[r103] > r105) goto L7;
            swap(r100, r101, r102, r106, r103);
            r106 = r106 + 1;
        L7:
            r103 = r103 + 1;
            goto L3
        L8:
            swap(r100, r101, r102, r106, r104);
            return r106;
        }

        public static void sort(int[] r100, float[] r101, float[] r102, int r103, int r110) {
            int[] r104 = new int[r100.length + 10];
            r104[0] = r110;
            r104[1] = r103;
            int r105 = 2;
        L3:
            if (r105 <= 0) goto L7;
            int r106 = r105 - 1;
            int r107 = r104[r106];
            r105 = r106 - 1;
            int r108 = r104[r105];
            if (r107 >= r108) goto L3;
            int r109 = partition(r100, r101, r102, r107, r108);
            int r111 = r105 + 1;
            r104[r105] = r109 - 1;
            int r112 = r111 + 1;
            r104[r111] = r107;
            int r113 = r112 + 1;
            r104[r112] = r108;
            r105 = r113 + 1;
            r104[r113] = r109 + 1;
            goto L3
        }

        private static void swap(int[] r100, float[] r101, float[] r102, int r103, int r104) {
            int r105 = r100[r103];
            r100[r103] = r100[r104];
            r100[r104] = r105;
            float r106 = r101[r103];
            r101[r103] = r101[r104];
            r101[r104] = r106;
            float r107 = r102[r103];
            r102[r103] = r102[r104];
            r102[r104] = r107;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
        }

        public PathRotateSet() {
        }

        public void setPathRotate(View r100, float r101, double r102, double r103) {
            r100.setRotation(get(r101) + ((float) Math.toDegrees(Math.atan2(r103, r102))));
        }
    }

    public static class ProgressSet extends KeyCycleOscillator {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
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

    public static class RotationSet extends KeyCycleOscillator {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setRotation(get(r101));
        }
    }

    public static class RotationXset extends KeyCycleOscillator {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setRotationX(get(r101));
        }
    }

    public static class RotationYset extends KeyCycleOscillator {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setRotationY(get(r101));
        }
    }

    public static class ScaleXset extends KeyCycleOscillator {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setScaleX(get(r101));
        }
    }

    public static class ScaleYset extends KeyCycleOscillator {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setScaleY(get(r101));
        }
    }

    public static class TranslationXset extends KeyCycleOscillator {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setTranslationX(get(r101));
        }
    }

    public static class TranslationYset extends KeyCycleOscillator {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setTranslationY(get(r101));
        }
    }

    public static class TranslationZset extends KeyCycleOscillator {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View r100, float r101) {
            r100.setTranslationZ(get(r101));
        }
    }

    public static class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int r100, float r101, float r102, float r103) {
            this.mPosition = r100;
            this.mValue = r103;
            this.mOffset = r102;
            this.mPeriod = r101;
        }
    }

    public abstract void setProperty(View r100, float r101);

    public String toString() {
        String r100 = this.mType;
        DecimalFormat r101 = new DecimalFormat("##.##");
        Iterator<WavePoint> r102 = this.mWavePoints.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        WavePoint r103 = r102.next();
        r100 = r100 + "[" + r103.mPosition + " , " + r101.format(r103.mValue) + "] ";
        goto L4
    L6:
        return r100;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public KeyCycleOscillator() {
        this.mWaveShape = 0;
        this.mVariesBy = 0;
        this.mWavePoints = new ArrayList();
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public static KeyCycleOscillator makeSpline(String r100) {
        if (r100.startsWith("CUSTOM") == true) goto L5;
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -1001078227: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -797520672: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            default: goto L65;
        };
    L65:
        switch(r101) {
            case 0: goto L95;
            case 1: goto L93;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L85;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L69;
            default: goto L66;
        };
    L66:
        return null;
    L69:
        return new AlphaSet();
    L71:
        return new AlphaSet();
    L73:
        return new PathRotateSet();
    L75:
        return new ElevationSet();
    L77:
        return new RotationSet();
    L79:
        return new AlphaSet();
    L81:
        return new ScaleYset();
    L83:
        return new ScaleXset();
    L85:
        return new ProgressSet();
    L87:
        return new TranslationZset();
    L89:
        return new TranslationYset();
    L91:
        return new TranslationXset();
    L93:
        return new RotationYset();
    L95:
        return new RotationXset();
    L10:
        if (r100.equals("waveOffset") == false) goto L65;
        r101 = HTTP.CR;
        goto L65
    L14:
        if (r100.equals("alpha") == false) goto L65;
        r101 = 12;
        goto L65
    L18:
        if (r100.equals("transitionPathRotate") == false) goto L65;
        r101 = 11;
        goto L65
    L22:
        if (r100.equals("elevation") == false) goto L65;
        r101 = 10;
        goto L65
    L26:
        if (r100.equals("rotation") == false) goto L65;
        r101 = 9;
        goto L65
    L30:
        if (r100.equals("waveVariesBy") == false) goto L65;
        r101 = 8;
        goto L65
    L34:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L65;
        r101 = 7;
        goto L65
    L38:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L65;
        r101 = 6;
        goto L65
    L42:
        if (r100.equals("progress") == false) goto L65;
        r101 = 5;
        goto L65
    L46:
        if (r100.equals("translationZ") == false) goto L65;
        r101 = 4;
        goto L65
    L50:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L65;
        r101 = 3;
        goto L65
    L54:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L65;
        r101 = 2;
        goto L65
    L58:
        if (r100.equals("rotationY") == false) goto L65;
        r101 = 1;
        goto L65
    L62:
        if (r100.equals("rotationX") == false) goto L65;
        r101 = 0;
        goto L65
    L5:
        return new CustomSet();
    }

    public float get(float r100) {
        return (float) this.mCycleOscillator.getValues(r100);
    }

    public float getSlope(float r100) {
        return (float) this.mCycleOscillator.getSlope(r100);
    }

    public void setType(String r100) {
        this.mType = r100;
    }

    public void setup(float r110) {
        int r100 = this.mWavePoints.size();
        if (r100 != 0) goto L5;
        return;
    L5:
        Collections.sort(this.mWavePoints, new AnonymousClass1(this));
        double[] r101 = new double[r100];
        double[][] r102 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, 2});
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, r100);
        Iterator<WavePoint> r103 = this.mWavePoints.iterator();
        int r111 = 0;
    L7:
        if (r103.hasNext() == false) goto L9;
        WavePoint r104 = r103.next();
        float r105 = r104.mPeriod;
        r101[r111] = ((double) r105) * 0.01d;
        double[] r106 = r102[r111];
        float r112 = r104.mValue;
        r106[0] = r112;
        float r107 = r104.mOffset;
        r106[1] = r107;
        this.mCycleOscillator.setPoint(r111, r104.mPosition, r105, r107, r112);
        r111 = r111 + 1;
        goto L7
    L9:
        this.mCycleOscillator.setup(r110);
        this.mCurveFit = CurveFit.get(0, r101, r102);
    }

    public void setPoint(int r100, int r101, int r102, float r103, float r104, float r105) {
        this.mWavePoints.add(new WavePoint(r100, r103, r104, r105));
        if (r102 == (-1)) goto L5;
        this.mVariesBy = r102;
    L5:
        this.mWaveShape = r101;
    }

    public void setPoint(int r100, int r101, int r102, float r103, float r104, float r105, ConstraintAttribute r106) {
        this.mWavePoints.add(new WavePoint(r100, r103, r104, r105));
        if (r102 == (-1)) goto L5;
        this.mVariesBy = r102;
    L5:
        this.mWaveShape = r101;
        this.mCustom = r106;
    }
}
