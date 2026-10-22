package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.GlobalProxyLancet;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.motion.utils.ViewSpline;
import com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyTimeCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_SHAPE = "waveShape";
    private float mAlpha;
    private int mCurveFit;
    private String mCustomWaveShape;
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

    private static class Loader {
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
        private static SparseIntArray sAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            sAttrMap = r0;
            r0.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            sAttrMap.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            sAttrMap.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            sAttrMap.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            sAttrMap.append(R.styleable.KeyTimeCycle_framePosition, 12);
            sAttrMap.append(R.styleable.KeyTimeCycle_curveFit, 13);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            sAttrMap.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            sAttrMap.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            sAttrMap.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            sAttrMap.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            sAttrMap.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void read(KeyTimeCycle r5, TypedArray r6) {
            int r0 = r6.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L41;
            int r2 = r6.getIndex(r1);
            switch(sAttrMap.get(r2)) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L6;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L24;
                case 11: goto L6;
                case 12: goto L22;
                case 13: goto L21;
                case 14: goto L20;
                case 15: goto L19;
                case 16: goto L18;
                case 17: goto L17;
                case 18: goto L16;
                case 19: goto L13;
                case 20: goto L11;
                case 21: goto L8;
                default: goto L6;
            };
        L6:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(r2) + "   " + sAttrMap.get(r2));
        L40:
            r1 = r1 + 1;
            goto L3
        L11:
            KeyTimeCycle.access$602(r5, r6.getFloat(r2, KeyTimeCycle.access$600(r5)));
            goto L40
        L16:
            KeyTimeCycle.access$1702(r5, r6.getFloat(r2, KeyTimeCycle.access$1700(r5)));
            goto L40
        L17:
            KeyTimeCycle.access$1602(r5, r6.getDimension(r2, KeyTimeCycle.access$1600(r5)));
            goto L40
        L18:
            KeyTimeCycle.access$1502(r5, r6.getDimension(r2, KeyTimeCycle.access$1500(r5)));
            goto L40
        L19:
            KeyTimeCycle.access$1402(r5, r6.getDimension(r2, KeyTimeCycle.access$1400(r5)));
            goto L40
        L20:
            KeyTimeCycle.access$1202(r5, r6.getFloat(r2, KeyTimeCycle.access$1200(r5)));
            goto L40
        L21:
            KeyTimeCycle.access$302(r5, r6.getInteger(r2, KeyTimeCycle.access$300(r5)));
            goto L40
        L22:
            r5.mFramePosition = r6.getInt(r2, r5.mFramePosition);
            goto L40
        L32:
            KeyTimeCycle.access$1102(r5, r6.getString(r2));
            goto L40
        L33:
            KeyTimeCycle.access$1302(r5, r6.getFloat(r2, KeyTimeCycle.access$1300(r5)));
            goto L40
        L34:
            KeyTimeCycle.access$802(r5, r6.getFloat(r2, KeyTimeCycle.access$800(r5)));
            goto L40
        L35:
            KeyTimeCycle.access$1002(r5, r6.getFloat(r2, KeyTimeCycle.access$1000(r5)));
            goto L40
        L36:
            KeyTimeCycle.access$902(r5, r6.getFloat(r2, KeyTimeCycle.access$900(r5)));
            goto L40
        L37:
            KeyTimeCycle.access$202(r5, r6.getFloat(r2, KeyTimeCycle.access$200(r5)));
            goto L40
        L38:
            KeyTimeCycle.access$102(r5, r6.getDimension(r2, KeyTimeCycle.access$100(r5)));
            goto L40
        L39:
            KeyTimeCycle.access$002(r5, r6.getFloat(r2, KeyTimeCycle.access$000(r5)));
            goto L40
        L8:
            if (r6.peekValue(r2).type != 5) goto L10;
            KeyTimeCycle.access$702(r5, r6.getDimension(r2, KeyTimeCycle.access$700(r5)));
            goto L40
        L10:
            KeyTimeCycle.access$702(r5, r6.getFloat(r2, KeyTimeCycle.access$700(r5)));
            goto L40
        L13:
            if (r6.peekValue(r2).type != 3) goto L15;
            KeyTimeCycle.access$402(r5, r6.getString(r2));
            KeyTimeCycle.access$502(r5, 7);
            goto L40
        L15:
            KeyTimeCycle.access$502(r5, r6.getInt(r2, KeyTimeCycle.access$500(r5)));
            goto L40
        L24:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L29;
            r5.mTargetId = r6.getResourceId(r2, r5.mTargetId);
            if (r5.mTargetId != (-1)) goto L40;
            r5.mTargetString = r6.getString(r2);
            goto L40
        L29:
            if (r6.peekValue(r2).type != 3) goto L31;
            r5.mTargetString = r6.getString(r2);
            goto L40
        L31:
            r5.mTargetId = r6.getResourceId(r2, r5.mTargetId);
            goto L40
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
        this.mCustomWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$000(KeyTimeCycle r0) {
        return r0.mAlpha;
    }

    static /* synthetic */ float access$002(KeyTimeCycle r0, float r1) {
        r0.mAlpha = r1;
        return r1;
    }

    static /* synthetic */ float access$100(KeyTimeCycle r0) {
        return r0.mElevation;
    }

    static /* synthetic */ float access$1000(KeyTimeCycle r0) {
        return r0.mRotationY;
    }

    static /* synthetic */ float access$1002(KeyTimeCycle r0, float r1) {
        r0.mRotationY = r1;
        return r1;
    }

    static /* synthetic */ float access$102(KeyTimeCycle r0, float r1) {
        r0.mElevation = r1;
        return r1;
    }

    static /* synthetic */ String access$1102(KeyTimeCycle r0, String r1) {
        r0.mTransitionEasing = r1;
        return r1;
    }

    static /* synthetic */ float access$1200(KeyTimeCycle r0) {
        return r0.mScaleY;
    }

    static /* synthetic */ float access$1202(KeyTimeCycle r0, float r1) {
        r0.mScaleY = r1;
        return r1;
    }

    static /* synthetic */ float access$1300(KeyTimeCycle r0) {
        return r0.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1302(KeyTimeCycle r0, float r1) {
        r0.mTransitionPathRotate = r1;
        return r1;
    }

    static /* synthetic */ float access$1400(KeyTimeCycle r0) {
        return r0.mTranslationX;
    }

    static /* synthetic */ float access$1402(KeyTimeCycle r0, float r1) {
        r0.mTranslationX = r1;
        return r1;
    }

    static /* synthetic */ float access$1500(KeyTimeCycle r0) {
        return r0.mTranslationY;
    }

    static /* synthetic */ float access$1502(KeyTimeCycle r0, float r1) {
        r0.mTranslationY = r1;
        return r1;
    }

    static /* synthetic */ float access$1600(KeyTimeCycle r0) {
        return r0.mTranslationZ;
    }

    static /* synthetic */ float access$1602(KeyTimeCycle r0, float r1) {
        r0.mTranslationZ = r1;
        return r1;
    }

    static /* synthetic */ float access$1700(KeyTimeCycle r0) {
        return r0.mProgress;
    }

    static /* synthetic */ float access$1702(KeyTimeCycle r0, float r1) {
        r0.mProgress = r1;
        return r1;
    }

    static /* synthetic */ float access$200(KeyTimeCycle r0) {
        return r0.mRotation;
    }

    static /* synthetic */ float access$202(KeyTimeCycle r0, float r1) {
        r0.mRotation = r1;
        return r1;
    }

    static /* synthetic */ int access$300(KeyTimeCycle r0) {
        return r0.mCurveFit;
    }

    static /* synthetic */ int access$302(KeyTimeCycle r0, int r1) {
        r0.mCurveFit = r1;
        return r1;
    }

    static /* synthetic */ String access$402(KeyTimeCycle r0, String r1) {
        r0.mCustomWaveShape = r1;
        return r1;
    }

    static /* synthetic */ int access$500(KeyTimeCycle r0) {
        return r0.mWaveShape;
    }

    static /* synthetic */ int access$502(KeyTimeCycle r0, int r1) {
        r0.mWaveShape = r1;
        return r1;
    }

    static /* synthetic */ float access$600(KeyTimeCycle r0) {
        return r0.mWavePeriod;
    }

    static /* synthetic */ float access$602(KeyTimeCycle r0, float r1) {
        r0.mWavePeriod = r1;
        return r1;
    }

    static /* synthetic */ float access$700(KeyTimeCycle r0) {
        return r0.mWaveOffset;
    }

    static /* synthetic */ float access$702(KeyTimeCycle r0, float r1) {
        r0.mWaveOffset = r1;
        return r1;
    }

    static /* synthetic */ float access$800(KeyTimeCycle r0) {
        return r0.mScaleX;
    }

    static /* synthetic */ float access$802(KeyTimeCycle r0, float r1) {
        r0.mScaleX = r1;
        return r1;
    }

    static /* synthetic */ float access$900(KeyTimeCycle r0) {
        return r0.mRotationX;
    }

    static /* synthetic */ float access$902(KeyTimeCycle r0, float r1) {
        r0.mRotationX = r1;
        return r1;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo444clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void load(Context r2, AttributeSet r3) {
        Loader.read(this, r2.obtainStyledAttributes(r3, R.styleable.KeyTimeCycle));
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> r4) {
        if (Float.isNaN(this.mAlpha) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.mElevation) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.mRotation) == true) goto L12;
        r4.add("rotation");
    L12:
        if (Float.isNaN(this.mRotationX) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.mRotationY) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.mTranslationX) == true) goto L21;
        r4.add("translationX");
    L21:
        if (Float.isNaN(this.mTranslationY) == true) goto L24;
        r4.add("translationY");
    L24:
        if (Float.isNaN(this.mTranslationZ) == true) goto L27;
        r4.add("translationZ");
    L27:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L30;
        r4.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.mScaleX) == true) goto L33;
        r4.add("scaleX");
    L33:
        if (Float.isNaN(this.mScaleY) == true) goto L36;
        r4.add("scaleY");
    L36:
        if (Float.isNaN(this.mProgress) == true) goto L39;
        r4.add("progress");
    L39:
        if (this.mCustomConstraints.size() <= 0) goto L44;
        Iterator<String> r3 = this.mCustomConstraints.keySet().iterator();
    L42:
        if (r3.hasNext() == false) goto L46;
        r4.add("CUSTOM," + r3.next());
        goto L42
    L46:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> r5) {
        if (this.mCurveFit != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.mAlpha) == true) goto L9;
        r5.put("alpha", Integer.valueOf(this.mCurveFit));
    L9:
        if (Float.isNaN(this.mElevation) == true) goto L12;
        r5.put("elevation", Integer.valueOf(this.mCurveFit));
    L12:
        if (Float.isNaN(this.mRotation) == true) goto L15;
        r5.put("rotation", Integer.valueOf(this.mCurveFit));
    L15:
        if (Float.isNaN(this.mRotationX) == true) goto L18;
        r5.put("rotationX", Integer.valueOf(this.mCurveFit));
    L18:
        if (Float.isNaN(this.mRotationY) == true) goto L21;
        r5.put("rotationY", Integer.valueOf(this.mCurveFit));
    L21:
        if (Float.isNaN(this.mTranslationX) == true) goto L24;
        r5.put("translationX", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mTranslationY) == true) goto L27;
        r5.put("translationY", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationZ) == true) goto L30;
        r5.put("translationZ", Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L33;
        r5.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mScaleX) == true) goto L36;
        r5.put("scaleX", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r5.put("scaleY", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mProgress) == true) goto L42;
        r5.put("progress", Integer.valueOf(this.mCurveFit));
    L42:
        if (this.mCustomConstraints.size() <= 0) goto L47;
        Iterator<String> r0 = this.mCustomConstraints.keySet().iterator();
    L45:
        if (r0.hasNext() == false) goto L49;
        r5.put("CUSTOM," + r0.next(), Integer.valueOf(this.mCurveFit));
        goto L45
    L49:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r1) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    public void addTimeValues(HashMap<String, ViewTimeCycle> r11) {
        Iterator<String> r0 = r11.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L101;
        String r1 = r0.next();
        ViewTimeCycle r3 = r11.get(r1);
        if (r3 == null) goto L4;
        byte r4 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L60;
            case -1249320805: goto L56;
            case -1225497657: goto L52;
            case -1225497656: goto L48;
            case -1225497655: goto L44;
            case -1001078227: goto L40;
            case -908189618: goto L36;
            case -908189617: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L15;
        };
    L15:
        r4 = -1;
    L63:
        switch(r4) {
            case 0: goto L99;
            case 1: goto L96;
            case 2: goto L93;
            case 3: goto L90;
            case 4: goto L87;
            case 5: goto L84;
            case 6: goto L81;
            case 7: goto L78;
            case 8: goto L75;
            case 9: goto L72;
            case 10: goto L69;
            case 11: goto L66;
            default: goto L64;
        };
    L66:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L69:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L72:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L75:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L78:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L81:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L84:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L87:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L90:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L93:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L96:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L99:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r3.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    L64:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("KeyTimeCycles", "UNKNOWN addValues \"" + r1 + "\"");
        goto L4
    L17:
        if (r1.equals("alpha") == false) goto L161;
        r4 = Ascii.VT;
        goto L63
    L161:
        r4 = -1;
        goto L63
    L21:
        if (r1.equals("transitionPathRotate") == false) goto L162;
        r4 = 10;
        goto L63
    L162:
        r4 = -1;
        goto L63
    L25:
        if (r1.equals("elevation") == false) goto L163;
        r4 = 9;
        goto L63
    L163:
        r4 = -1;
        goto L63
    L29:
        if (r1.equals("rotation") == false) goto L164;
        r4 = 8;
        goto L63
    L164:
        r4 = -1;
        goto L63
    L33:
        if (r1.equals("scaleY") == true) goto L63;
        r4 = -1;
        goto L63
    L36:
        if (r1.equals("scaleX") == false) goto L166;
        r4 = 6;
        goto L63
    L166:
        r4 = -1;
        goto L63
    L40:
        if (r1.equals("progress") == false) goto L167;
        r4 = 5;
        goto L63
    L167:
        r4 = -1;
        goto L63
    L44:
        if (r1.equals("translationZ") == false) goto L168;
        r4 = 4;
        goto L63
    L168:
        r4 = -1;
        goto L63
    L48:
        if (r1.equals("translationY") == false) goto L169;
        r4 = 3;
        goto L63
    L169:
        r4 = -1;
        goto L63
    L52:
        if (r1.equals("translationX") == false) goto L170;
        r4 = 2;
        goto L63
    L170:
        r4 = -1;
        goto L63
    L56:
        if (r1.equals("rotationY") == false) goto L171;
        r4 = 1;
        goto L63
    L171:
        r4 = -1;
        goto L63
    L60:
        if (r1.equals("rotationX") == false) goto L172;
        r4 = 0;
        goto L63
    L172:
        r4 = -1;
        goto L63
    L10:
        ConstraintAttribute r6 = this.mCustomConstraints.get(r1.substring(7));
        if (r6 == null) goto L4;
        ((ViewTimeCycle.CustomSet) r3).setPoint(this.mFramePosition, r6, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void setValue(String r4, Object r5) {
        r4.hashCode();
        byte r2 = -1;
        switch(r4.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -40300674: goto L34;
            case -4379043: goto L30;
            case 37232917: goto L26;
            case 92909918: goto L22;
            case 156108012: goto L18;
            case 184161818: goto L14;
            case 579057826: goto L10;
            case 1532805160: goto L6;
            default: goto L73;
        };
    L73:
        switch(r2) {
            case 0: goto L94;
            case 1: goto L93;
            case 2: goto L92;
            case 3: goto L91;
            case 4: goto L90;
            case 5: goto L89;
            case 6: goto L88;
            case 7: goto L87;
            case 8: goto L86;
            case 9: goto L85;
            case 10: goto L84;
            case 11: goto L83;
            case 12: goto L82;
            case 13: goto L81;
            case 14: goto L80;
            case 15: goto L79;
            case 16: goto L76;
            default: goto L113;
        };
    L79:
        this.mCurveFit = toInt(r5);
        return;
    L80:
        this.mWavePeriod = toFloat(r5);
        return;
    L81:
        this.mWaveOffset = toFloat(r5);
        return;
    L82:
        this.mAlpha = toFloat(r5);
        return;
    L83:
        this.mTransitionPathRotate = toFloat(r5);
        return;
    L84:
        this.mElevation = toFloat(r5);
        return;
    L85:
        this.mRotation = toFloat(r5);
        return;
    L86:
        this.mScaleY = toFloat(r5);
        return;
    L87:
        this.mScaleX = toFloat(r5);
        return;
    L88:
        this.mTranslationZ = toFloat(r5);
        return;
    L89:
        this.mTranslationY = toFloat(r5);
        return;
    L90:
        this.mTranslationX = toFloat(r5);
        return;
    L91:
        this.mRotationY = toFloat(r5);
        return;
    L92:
        this.mRotationX = toFloat(r5);
        return;
    L93:
        this.mTransitionEasing = r5.toString();
        return;
    L94:
        this.mProgress = toFloat(r5);
        return;
    L113:
        return;
    L76:
        if ((r5 instanceof Integer) == false) goto L78;
        this.mWaveShape = toInt(r5);
        return;
    L78:
        this.mWaveShape = 7;
        this.mCustomWaveShape = r5.toString();
        return;
    L6:
        if (r4.equals("waveShape") == false) goto L73;
        r2 = Ascii.DLE;
        goto L73
    L10:
        if (r4.equals("curveFit") == false) goto L73;
        r2 = Ascii.SI;
        goto L73
    L14:
        if (r4.equals("wavePeriod") == false) goto L73;
        r2 = Ascii.SO;
        goto L73
    L18:
        if (r4.equals("waveOffset") == false) goto L73;
        r2 = Ascii.CR;
        goto L73
    L22:
        if (r4.equals("alpha") == false) goto L73;
        r2 = Ascii.FF;
        goto L73
    L26:
        if (r4.equals("transitionPathRotate") == false) goto L73;
        r2 = Ascii.VT;
        goto L73
    L30:
        if (r4.equals("elevation") == false) goto L73;
        r2 = 10;
        goto L73
    L34:
        if (r4.equals("rotation") == false) goto L73;
        r2 = 9;
        goto L73
    L38:
        if (r4.equals("scaleY") == false) goto L73;
        r2 = 8;
        goto L73
    L42:
        if (r4.equals("scaleX") == false) goto L73;
        r2 = 7;
        goto L73
    L46:
        if (r4.equals("translationZ") == false) goto L73;
        r2 = 6;
        goto L73
    L50:
        if (r4.equals("translationY") == false) goto L73;
        r2 = 5;
        goto L73
    L54:
        if (r4.equals("translationX") == false) goto L73;
        r2 = 4;
        goto L73
    L58:
        if (r4.equals("rotationY") == false) goto L73;
        r2 = 3;
        goto L73
    L62:
        if (r4.equals("rotationX") == false) goto L73;
        r2 = 2;
        goto L73
    L66:
        if (r4.equals("transitionEasing") == false) goto L73;
        r2 = 1;
        goto L73
    L70:
        if (r4.equals("motionProgress") == false) goto L73;
        r2 = 0;
        goto L73
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public Key copy(Key r2) {
        super.copy(r2);
        KeyTimeCycle r3 = (KeyTimeCycle) r2;
        this.mTransitionEasing = r3.mTransitionEasing;
        this.mCurveFit = r3.mCurveFit;
        this.mWaveShape = r3.mWaveShape;
        this.mWavePeriod = r3.mWavePeriod;
        this.mWaveOffset = r3.mWaveOffset;
        this.mProgress = r3.mProgress;
        this.mAlpha = r3.mAlpha;
        this.mElevation = r3.mElevation;
        this.mRotation = r3.mRotation;
        this.mTransitionPathRotate = r3.mTransitionPathRotate;
        this.mRotationX = r3.mRotationX;
        this.mRotationY = r3.mRotationY;
        this.mScaleX = r3.mScaleX;
        this.mScaleY = r3.mScaleY;
        this.mTranslationX = r3.mTranslationX;
        this.mTranslationY = r3.mTranslationY;
        this.mTranslationZ = r3.mTranslationZ;
        this.mCustomWaveShape = r3.mCustomWaveShape;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyTimeCycle().copy(this);
    }
}
