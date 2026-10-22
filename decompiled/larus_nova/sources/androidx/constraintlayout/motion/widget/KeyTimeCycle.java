package androidx.constraintlayout.motion.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset;
    private float mWavePeriod;
    private int mWaveShape;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static final int WAVE_OFFSET = 21;
        private static final int WAVE_PERIOD = 20;
        private static final int WAVE_SHAPE = 19;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray r100 = new SparseIntArray();
            mAttrMap = r100;
            r100.append(0, 1);
            mAttrMap.append(9, 2);
            mAttrMap.append(5, 4);
            mAttrMap.append(6, 5);
            mAttrMap.append(7, 6);
            mAttrMap.append(3, 7);
            mAttrMap.append(15, 8);
            mAttrMap.append(14, 9);
            mAttrMap.append(13, 10);
            mAttrMap.append(11, 12);
            mAttrMap.append(10, 13);
            mAttrMap.append(4, 14);
            mAttrMap.append(1, 15);
            mAttrMap.append(2, 16);
            mAttrMap.append(8, 17);
            mAttrMap.append(12, 18);
            mAttrMap.append(18, 20);
            mAttrMap.append(17, 21);
            mAttrMap.append(20, 19);
        }

        public static void read(KeyTimeCycle r100, TypedArray r101) {
            int r102 = r101.getIndexCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L38;
            int r104 = r101.getIndex(r103);
            switch(mAttrMap.get(r104)) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L6;
                case 4: goto L34;
                case 5: goto L33;
                case 6: goto L32;
                case 7: goto L31;
                case 8: goto L30;
                case 9: goto L29;
                case 10: goto L21;
                case 11: goto L6;
                case 12: goto L19;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L13;
                case 19: goto L12;
                case 20: goto L11;
                case 21: goto L8;
                default: goto L6;
            };
        L6:
            Integer.toHexString(r104);
            mAttrMap.get(r104);
        L37:
            r103 = r103 + 1;
            goto L3
        L11:
            KeyTimeCycle.access$502(r100, r101.getFloat(r104, KeyTimeCycle.access$500(r100)));
            goto L37
        L12:
            KeyTimeCycle.access$402(r100, r101.getInt(r104, KeyTimeCycle.access$400(r100)));
            goto L37
        L13:
            KeyTimeCycle.access$1602(r100, r101.getFloat(r104, KeyTimeCycle.access$1600(r100)));
            goto L37
        L14:
            KeyTimeCycle.access$1502(r100, r101.getDimension(r104, KeyTimeCycle.access$1500(r100)));
            goto L37
        L15:
            KeyTimeCycle.access$1402(r100, r101.getDimension(r104, KeyTimeCycle.access$1400(r100)));
            goto L37
        L16:
            KeyTimeCycle.access$1302(r100, r101.getDimension(r104, KeyTimeCycle.access$1300(r100)));
            goto L37
        L17:
            KeyTimeCycle.access$1102(r100, r101.getFloat(r104, KeyTimeCycle.access$1100(r100)));
            goto L37
        L18:
            KeyTimeCycle.access$302(r100, r101.getInteger(r104, KeyTimeCycle.access$300(r100)));
            goto L37
        L19:
            r100.mFramePosition = r101.getInt(r104, r100.mFramePosition);
            goto L37
        L29:
            KeyTimeCycle.access$1002(r100, r101.getString(r104));
            goto L37
        L30:
            KeyTimeCycle.access$1202(r100, r101.getFloat(r104, KeyTimeCycle.access$1200(r100)));
            goto L37
        L31:
            KeyTimeCycle.access$702(r100, r101.getFloat(r104, KeyTimeCycle.access$700(r100)));
            goto L37
        L32:
            KeyTimeCycle.access$902(r100, r101.getFloat(r104, KeyTimeCycle.access$900(r100)));
            goto L37
        L33:
            KeyTimeCycle.access$802(r100, r101.getFloat(r104, KeyTimeCycle.access$800(r100)));
            goto L37
        L34:
            KeyTimeCycle.access$202(r100, r101.getFloat(r104, KeyTimeCycle.access$200(r100)));
            goto L37
        L35:
            KeyTimeCycle.access$102(r100, r101.getDimension(r104, KeyTimeCycle.access$100(r100)));
            goto L37
        L36:
            KeyTimeCycle.access$002(r100, r101.getFloat(r104, KeyTimeCycle.access$000(r100)));
            goto L37
        L8:
            if (r101.peekValue(r104).type != 5) goto L10;
            KeyTimeCycle.access$602(r100, r101.getDimension(r104, KeyTimeCycle.access$600(r100)));
            goto L37
        L10:
            KeyTimeCycle.access$602(r100, r101.getFloat(r104, KeyTimeCycle.access$600(r100)));
            goto L37
        L21:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L26;
            int r105 = r101.getResourceId(r104, r100.mTargetId);
            r100.mTargetId = r105;
            if (r105 != (-1)) goto L37;
            r100.mTargetString = r101.getString(r104);
            goto L37
        L26:
            if (r101.peekValue(r104).type != 3) goto L28;
            r100.mTargetString = r101.getString(r104);
            goto L37
        L28:
            r100.mTargetId = r101.getResourceId(r104, r100.mTargetId);
            goto L37
        }
    }

    public KeyTimeCycle() {
        this.mCurveFit = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mWaveShape = 0;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$000(KeyTimeCycle r100) {
        return r100.mAlpha;
    }

    public static /* synthetic */ float access$100(KeyTimeCycle r100) {
        return r100.mElevation;
    }

    public static /* synthetic */ float access$1100(KeyTimeCycle r100) {
        return r100.mScaleY;
    }

    public static /* synthetic */ float access$1200(KeyTimeCycle r100) {
        return r100.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1300(KeyTimeCycle r100) {
        return r100.mTranslationX;
    }

    public static /* synthetic */ float access$1400(KeyTimeCycle r100) {
        return r100.mTranslationY;
    }

    public static /* synthetic */ float access$1500(KeyTimeCycle r100) {
        return r100.mTranslationZ;
    }

    public static /* synthetic */ float access$1600(KeyTimeCycle r100) {
        return r100.mProgress;
    }

    public static /* synthetic */ float access$200(KeyTimeCycle r100) {
        return r100.mRotation;
    }

    public static /* synthetic */ int access$300(KeyTimeCycle r100) {
        return r100.mCurveFit;
    }

    public static /* synthetic */ int access$400(KeyTimeCycle r100) {
        return r100.mWaveShape;
    }

    public static /* synthetic */ float access$500(KeyTimeCycle r100) {
        return r100.mWavePeriod;
    }

    public static /* synthetic */ float access$600(KeyTimeCycle r100) {
        return r100.mWaveOffset;
    }

    public static /* synthetic */ float access$700(KeyTimeCycle r100) {
        return r100.mScaleX;
    }

    public static /* synthetic */ float access$800(KeyTimeCycle r100) {
        return r100.mRotationX;
    }

    public static /* synthetic */ float access$900(KeyTimeCycle r100) {
        return r100.mRotationY;
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> r110) {
        Iterator<String> r100 = r110.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L98;
        String r101 = r100.next();
        TimeCycleSplineSet r102 = r110.get(r101);
        byte r103 = 7;
        if (r101.startsWith("CUSTOM") == true) goto L7;
        switch(r101.hashCode()) {
            case -1249320806: goto L57;
            case -1249320805: goto L53;
            case -1225497657: goto L49;
            case -1225497656: goto L45;
            case -1225497655: goto L41;
            case -1001078227: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            default: goto L12;
        };
    L12:
        r103 = -1;
    L60:
        switch(r103) {
            case 0: goto L96;
            case 1: goto L93;
            case 2: goto L90;
            case 3: goto L87;
            case 4: goto L84;
            case 5: goto L81;
            case 6: goto L78;
            case 7: goto L75;
            case 8: goto L72;
            case 9: goto L69;
            case 10: goto L66;
            case 11: goto L63;
            default: goto L4;
        };
    L63:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L66:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L69:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L72:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L75:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L78:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L81:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L84:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L87:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L90:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L93:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L96:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r102.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L14:
        if (r101.equals("alpha") == false) goto L12;
        r103 = 11;
        goto L60
    L18:
        if (r101.equals("transitionPathRotate") == false) goto L12;
        r103 = 10;
        goto L60
    L22:
        if (r101.equals("elevation") == false) goto L12;
        r103 = 9;
        goto L60
    L26:
        if (r101.equals("rotation") == false) goto L12;
        r103 = 8;
        goto L60
    L30:
        if (r101.equals(LiveDegradeFpsAnimator.SCALE_Y) == true) goto L60;
    L33:
        if (r101.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L12;
        r103 = 6;
        goto L60
    L37:
        if (r101.equals("progress") == false) goto L12;
        r103 = 5;
        goto L60
    L41:
        if (r101.equals("translationZ") == false) goto L12;
        r103 = 4;
        goto L60
    L45:
        if (r101.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L12;
        r103 = 3;
        goto L60
    L49:
        if (r101.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L12;
        r103 = 2;
        goto L60
    L53:
        if (r101.equals("rotationY") == false) goto L12;
        r103 = 1;
        goto L60
    L57:
        if (r101.equals("rotationX") == false) goto L12;
        r103 = 0;
        goto L60
    L7:
        String r104 = r101.substring(7);
        ConstraintAttribute r105 = this.mCustomConstraints.get(r104);
        if (r105 == null) goto L4;
        ((TimeCycleSplineSet.CustomSet) r102).setPoint(this.mFramePosition, r105, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r100) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r100) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r100.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r100.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r100.add("rotation");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r100.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r100.add("rotationY");
    L18:
        if (Float.isNaN(this.mTranslationX) == true) goto L21;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L21:
        if (Float.isNaN(this.mTranslationY) == true) goto L24;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L24:
        if (Float.isNaN(this.mTranslationZ) == true) goto L27;
        r100.add("translationZ");
    L27:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L30;
        r100.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.mScaleX) == true) goto L33;
        r100.add(LiveDegradeFpsAnimator.SCALE_X);
    L33:
        if (Float.isNaN(this.mScaleY) == true) goto L36;
        r100.add(LiveDegradeFpsAnimator.SCALE_Y);
    L36:
        if (Float.isNaN(this.mProgress) == true) goto L39;
        r100.add("progress");
    L39:
        if (this.mCustomConstraints.size() <= 0) goto L44;
        Iterator<String> r101 = this.mCustomConstraints.keySet().iterator();
    L42:
        if (r101.hasNext() == false) goto L46;
        r100.add("CUSTOM," + r101.next());
        goto L42
    L46:
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> r100) {
        if (this.mCurveFit != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.mAlpha) == true) goto L9;
        r100.put("alpha", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mElevation) == true) goto L12;
        r100.put("elevation", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotation) == true) goto L15;
        r100.put("rotation", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationX) == true) goto L18;
        r100.put("rotationX", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mRotationY) == true) goto L21;
        r100.put("rotationY", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mTranslationX) == true) goto L24;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationY) == true) goto L27;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationZ) == true) goto L30;
        r100.put("translationZ", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L33;
        r100.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mScaleX) == true) goto L36;
        r100.put(LiveDegradeFpsAnimator.SCALE_X, Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r100.put(LiveDegradeFpsAnimator.SCALE_Y, Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mProgress) == true) goto L42;
        r100.put("progress", Integer.valueOf(this.mCurveFit));
    L42:
        if (this.mCustomConstraints.size() <= 0) goto L47;
        Iterator<String> r101 = this.mCustomConstraints.keySet().iterator();
    L45:
        if (r101.hasNext() == false) goto L49;
        r100.put("CUSTOM," + r101.next(), Integer.valueOf(this.mCurveFit));
        goto L45
    L49:
        return;
    }

    public static /* synthetic */ float access$002(KeyTimeCycle r100, float r101) {
        r100.mAlpha = r101;
        return r101;
    }

    public static /* synthetic */ String access$1002(KeyTimeCycle r100, String r101) {
        r100.mTransitionEasing = r101;
        return r101;
    }

    public static /* synthetic */ float access$102(KeyTimeCycle r100, float r101) {
        r100.mElevation = r101;
        return r101;
    }

    public static /* synthetic */ float access$1102(KeyTimeCycle r100, float r101) {
        r100.mScaleY = r101;
        return r101;
    }

    public static /* synthetic */ float access$1202(KeyTimeCycle r100, float r101) {
        r100.mTransitionPathRotate = r101;
        return r101;
    }

    public static /* synthetic */ float access$1302(KeyTimeCycle r100, float r101) {
        r100.mTranslationX = r101;
        return r101;
    }

    public static /* synthetic */ float access$1402(KeyTimeCycle r100, float r101) {
        r100.mTranslationY = r101;
        return r101;
    }

    public static /* synthetic */ float access$1502(KeyTimeCycle r100, float r101) {
        r100.mTranslationZ = r101;
        return r101;
    }

    public static /* synthetic */ float access$1602(KeyTimeCycle r100, float r101) {
        r100.mProgress = r101;
        return r101;
    }

    public static /* synthetic */ float access$202(KeyTimeCycle r100, float r101) {
        r100.mRotation = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(KeyTimeCycle r100, int r101) {
        r100.mCurveFit = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(KeyTimeCycle r100, int r101) {
        r100.mWaveShape = r101;
        return r101;
    }

    public static /* synthetic */ float access$502(KeyTimeCycle r100, float r101) {
        r100.mWavePeriod = r101;
        return r101;
    }

    public static /* synthetic */ float access$602(KeyTimeCycle r100, float r101) {
        r100.mWaveOffset = r101;
        return r101;
    }

    public static /* synthetic */ float access$702(KeyTimeCycle r100, float r101) {
        r100.mScaleX = r101;
        return r101;
    }

    public static /* synthetic */ float access$802(KeyTimeCycle r100, float r101) {
        r100.mRotationX = r101;
        return r101;
    }

    public static /* synthetic */ float access$902(KeyTimeCycle r100, float r101) {
        r100.mRotationY = r101;
        return r101;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r100, AttributeSet r101) {
        Loader.read(this, r100.obtainStyledAttributes(r101, new int[]{R.attr.alpha, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.curveFit, com.larus.nova.R.attr.framePosition, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.waveDecay, com.larus.nova.R.attr.waveOffset, com.larus.nova.R.attr.wavePeriod, com.larus.nova.R.attr.wavePhase, com.larus.nova.R.attr.waveShape}));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r100, Object r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1812823328: goto L58;
            case -1249320806: goto L54;
            case -1249320805: goto L50;
            case -1225497657: goto L46;
            case -1225497656: goto L42;
            case -1001078227: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 579057826: goto L10;
            case 1317633238: goto L6;
            default: goto L61;
        };
    L61:
        switch(r102) {
            case 0: goto L76;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            case 6: goto L70;
            case 7: goto L69;
            case 8: goto L68;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L65;
            case 12: goto L64;
            case 13: goto L63;
            default: goto L91;
        };
    L63:
        this.mTranslationZ = toFloat(r101);
        return;
    L64:
        this.mCurveFit = toInt(r101);
        return;
    L65:
        this.mAlpha = toFloat(r101);
        return;
    L66:
        this.mTransitionPathRotate = toFloat(r101);
        return;
    L67:
        this.mElevation = toFloat(r101);
        return;
    L68:
        this.mRotation = toFloat(r101);
        return;
    L69:
        this.mScaleY = toFloat(r101);
        return;
    L70:
        this.mScaleX = toFloat(r101);
        return;
    L71:
        this.mProgress = toFloat(r101);
        return;
    L72:
        this.mTranslationY = toFloat(r101);
        return;
    L73:
        this.mTranslationX = toFloat(r101);
        return;
    L74:
        this.mRotationY = toFloat(r101);
        return;
    L75:
        this.mRotationX = toFloat(r101);
        return;
    L76:
        this.mTransitionEasing = r101.toString();
        return;
    L91:
        return;
    L6:
        if (r100.equals("mTranslationZ") == false) goto L61;
        r102 = HTTP.CR;
        goto L61
    L10:
        if (r100.equals("curveFit") == false) goto L61;
        r102 = 12;
        goto L61
    L14:
        if (r100.equals("alpha") == false) goto L61;
        r102 = 11;
        goto L61
    L18:
        if (r100.equals("transitionPathRotate") == false) goto L61;
        r102 = 10;
        goto L61
    L22:
        if (r100.equals("elevation") == false) goto L61;
        r102 = 9;
        goto L61
    L26:
        if (r100.equals("rotation") == false) goto L61;
        r102 = 8;
        goto L61
    L30:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L61;
        r102 = 7;
        goto L61
    L34:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L61;
        r102 = 6;
        goto L61
    L38:
        if (r100.equals("progress") == false) goto L61;
        r102 = 5;
        goto L61
    L42:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L61;
        r102 = 4;
        goto L61
    L46:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L61;
        r102 = 3;
        goto L61
    L50:
        if (r100.equals("rotationY") == false) goto L61;
        r102 = 2;
        goto L61
    L54:
        if (r100.equals("rotationX") == false) goto L61;
        r102 = 1;
        goto L61
    L58:
        if (r100.equals("transitionEasing") == false) goto L61;
        r102 = 0;
        goto L61
    }
}
