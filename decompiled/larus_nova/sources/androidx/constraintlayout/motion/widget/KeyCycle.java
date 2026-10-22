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
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
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
    private int mWaveVariesBy;

    public static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray r100 = new SparseIntArray();
            mAttrMap = r100;
            r100.append(13, 1);
            mAttrMap.append(11, 2);
            mAttrMap.append(14, 3);
            mAttrMap.append(10, 4);
            mAttrMap.append(19, 5);
            mAttrMap.append(17, 6);
            mAttrMap.append(16, 7);
            mAttrMap.append(20, 8);
            mAttrMap.append(0, 9);
            mAttrMap.append(9, 10);
            mAttrMap.append(5, 11);
            mAttrMap.append(6, 12);
            mAttrMap.append(7, 13);
            mAttrMap.append(15, 14);
            mAttrMap.append(3, 15);
            mAttrMap.append(4, 16);
            mAttrMap.append(1, 17);
            mAttrMap.append(2, 18);
            mAttrMap.append(8, 19);
            mAttrMap.append(12, 20);
        }

        public static /* synthetic */ void access$000(KeyCycle r100, TypedArray r101) {
            read(r100, r101);
        }

        private static void read(KeyCycle r100, TypedArray r101) {
            int r102 = r101.getIndexCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L39;
            int r104 = r101.getIndex(r103);
            switch(mAttrMap.get(r104)) {
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L27;
                case 4: goto L26;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L6:
            Integer.toHexString(r104);
            mAttrMap.get(r104);
        L38:
            r103 = r103 + 1;
            goto L3
        L7:
            KeyCycle.access$1802(r100, r101.getFloat(r104, KeyCycle.access$1800(r100)));
            goto L38
        L8:
            KeyCycle.access$1702(r100, r101.getDimension(r104, KeyCycle.access$1700(r100)));
            goto L38
        L9:
            KeyCycle.access$1602(r100, r101.getDimension(r104, KeyCycle.access$1600(r100)));
            goto L38
        L10:
            KeyCycle.access$1502(r100, r101.getDimension(r104, KeyCycle.access$1500(r100)));
            goto L38
        L11:
            KeyCycle.access$1402(r100, r101.getFloat(r104, KeyCycle.access$1400(r100)));
            goto L38
        L12:
            KeyCycle.access$1302(r100, r101.getFloat(r104, KeyCycle.access$1300(r100)));
            goto L38
        L13:
            KeyCycle.access$1202(r100, r101.getFloat(r104, KeyCycle.access$1200(r100)));
            goto L38
        L14:
            KeyCycle.access$1102(r100, r101.getFloat(r104, KeyCycle.access$1100(r100)));
            goto L38
        L15:
            KeyCycle.access$1002(r100, r101.getFloat(r104, KeyCycle.access$1000(r100)));
            goto L38
        L16:
            KeyCycle.access$902(r100, r101.getFloat(r104, KeyCycle.access$900(r100)));
            goto L38
        L17:
            KeyCycle.access$802(r100, r101.getDimension(r104, KeyCycle.access$800(r100)));
            goto L38
        L18:
            KeyCycle.access$702(r100, r101.getFloat(r104, KeyCycle.access$700(r100)));
            goto L38
        L19:
            KeyCycle.access$602(r100, r101.getInt(r104, KeyCycle.access$600(r100)));
            goto L38
        L24:
            KeyCycle.access$402(r100, r101.getFloat(r104, KeyCycle.access$400(r100)));
            goto L38
        L25:
            KeyCycle.access$302(r100, r101.getInt(r104, KeyCycle.access$300(r100)));
            goto L38
        L26:
            KeyCycle.access$202(r100, r101.getInteger(r104, KeyCycle.access$200(r100)));
            goto L38
        L27:
            KeyCycle.access$102(r100, r101.getString(r104));
            goto L38
        L28:
            r100.mFramePosition = r101.getInt(r104, r100.mFramePosition);
            goto L38
        L21:
            if (r101.peekValue(r104).type != 5) goto L23;
            KeyCycle.access$502(r100, r101.getDimension(r104, KeyCycle.access$500(r100)));
            goto L38
        L23:
            KeyCycle.access$502(r100, r101.getFloat(r104, KeyCycle.access$500(r100)));
            goto L38
        L30:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L35;
            int r105 = r101.getResourceId(r104, r100.mTargetId);
            r100.mTargetId = r105;
            if (r105 != (-1)) goto L38;
            r100.mTargetString = r101.getString(r104);
            goto L38
        L35:
            if (r101.peekValue(r104).type != 3) goto L37;
            r100.mTargetString = r101.getString(r104);
            goto L38
        L37:
            r100.mTargetId = r101.getResourceId(r104, r100.mTargetId);
            goto L38
        }
    }

    public KeyCycle() {
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = 0.0f;
        this.mProgress = Float.NaN;
        this.mWaveVariesBy = -1;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mType = 4;
        this.mCustomConstraints = new HashMap();
    }

    public static /* synthetic */ float access$1000(KeyCycle r100) {
        return r100.mRotationX;
    }

    public static /* synthetic */ float access$1100(KeyCycle r100) {
        return r100.mRotationY;
    }

    public static /* synthetic */ float access$1200(KeyCycle r100) {
        return r100.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1300(KeyCycle r100) {
        return r100.mScaleX;
    }

    public static /* synthetic */ float access$1400(KeyCycle r100) {
        return r100.mScaleY;
    }

    public static /* synthetic */ float access$1500(KeyCycle r100) {
        return r100.mTranslationX;
    }

    public static /* synthetic */ float access$1600(KeyCycle r100) {
        return r100.mTranslationY;
    }

    public static /* synthetic */ float access$1700(KeyCycle r100) {
        return r100.mTranslationZ;
    }

    public static /* synthetic */ float access$1800(KeyCycle r100) {
        return r100.mProgress;
    }

    public static /* synthetic */ int access$200(KeyCycle r100) {
        return r100.mCurveFit;
    }

    public static /* synthetic */ int access$300(KeyCycle r100) {
        return r100.mWaveShape;
    }

    public static /* synthetic */ float access$400(KeyCycle r100) {
        return r100.mWavePeriod;
    }

    public static /* synthetic */ float access$500(KeyCycle r100) {
        return r100.mWaveOffset;
    }

    public static /* synthetic */ int access$600(KeyCycle r100) {
        return r100.mWaveVariesBy;
    }

    public static /* synthetic */ float access$700(KeyCycle r100) {
        return r100.mAlpha;
    }

    public static /* synthetic */ float access$800(KeyCycle r100) {
        return r100.mElevation;
    }

    public static /* synthetic */ float access$900(KeyCycle r100) {
        return r100.mRotation;
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> r210) {
        Iterator<String> r100 = r210.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        String r101 = r100.next();
        if (r101.startsWith("CUSTOM") == true) goto L7;
        float r110 = getValue(r101);
        if (Float.isNaN(r110) == true) goto L4;
        r210.get(r101).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, r110);
        goto L4
    L7:
        String r102 = r101.substring(7);
        ConstraintAttribute r111 = this.mCustomConstraints.get(r102);
        if (r111 == null) goto L4;
        if (r111.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        r210.get(r101).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, r111.getValueToInterpolate(), r111);
        goto L4
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r100) {
        Debug.logStack("KeyCycle", "add " + r100.size() + " values", 2);
        Iterator<String> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L75;
        String r102 = r101.next();
        SplineSet r103 = r100.get(r102);
        r102.getClass();
        byte r104 = -1;
        switch(r102.hashCode()) {
            case -1249320806: goto L57;
            case -1249320805: goto L53;
            case -1225497657: goto L49;
            case -1225497656: goto L45;
            case -1225497655: goto L41;
            case -1001078227: goto L37;
            case -908189618: goto L33;
            case -908189617: goto L29;
            case -40300674: goto L25;
            case -4379043: goto L21;
            case 37232917: goto L17;
            case 92909918: goto L13;
            case 156108012: goto L9;
            default: goto L60;
        };
    L60:
        switch(r104) {
            case 0: goto L74;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L70;
            case 5: goto L69;
            case 6: goto L68;
            case 7: goto L67;
            case 8: goto L66;
            case 9: goto L65;
            case 10: goto L64;
            case 11: goto L63;
            case 12: goto L62;
            default: goto L4;
        };
    L62:
        r103.setPoint(this.mFramePosition, this.mWaveOffset);
        goto L4
    L63:
        r103.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L64:
        r103.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L65:
        r103.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L66:
        r103.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L67:
        r103.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L68:
        r103.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L69:
        r103.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L70:
        r103.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L71:
        r103.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L72:
        r103.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L73:
        r103.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L74:
        r103.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L9:
        if (r102.equals("waveOffset") == false) goto L60;
        r104 = 12;
        goto L60
    L13:
        if (r102.equals("alpha") == false) goto L60;
        r104 = 11;
        goto L60
    L17:
        if (r102.equals("transitionPathRotate") == false) goto L60;
        r104 = 10;
        goto L60
    L21:
        if (r102.equals("elevation") == false) goto L60;
        r104 = 9;
        goto L60
    L25:
        if (r102.equals("rotation") == false) goto L60;
        r104 = 8;
        goto L60
    L29:
        if (r102.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L60;
        r104 = 7;
        goto L60
    L33:
        if (r102.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L60;
        r104 = 6;
        goto L60
    L37:
        if (r102.equals("progress") == false) goto L60;
        r104 = 5;
        goto L60
    L41:
        if (r102.equals("translationZ") == false) goto L60;
        r104 = 4;
        goto L60
    L45:
        if (r102.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L60;
        r104 = 3;
        goto L60
    L49:
        if (r102.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L60;
        r104 = 2;
        goto L60
    L53:
        if (r102.equals("rotationY") == false) goto L60;
        r104 = 1;
        goto L60
    L57:
        if (r102.equals("rotationX") == false) goto L60;
        r104 = 0;
        goto L60
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
        if (Float.isNaN(this.mScaleX) == true) goto L21;
        r100.add(LiveDegradeFpsAnimator.SCALE_X);
    L21:
        if (Float.isNaN(this.mScaleY) == true) goto L24;
        r100.add(LiveDegradeFpsAnimator.SCALE_Y);
    L24:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L27;
        r100.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r100.add("translationZ");
    L36:
        if (this.mCustomConstraints.size() <= 0) goto L41;
        Iterator<String> r101 = this.mCustomConstraints.keySet().iterator();
    L39:
        if (r101.hasNext() == false) goto L43;
        r100.add("CUSTOM," + r101.next());
        goto L39
    L43:
        return;
    }

    public float getValue(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1249320806: goto L54;
            case -1249320805: goto L50;
            case -1225497657: goto L46;
            case -1225497656: goto L42;
            case -1225497655: goto L38;
            case -1001078227: goto L34;
            case -908189618: goto L30;
            case -908189617: goto L26;
            case -40300674: goto L22;
            case -4379043: goto L18;
            case 37232917: goto L14;
            case 92909918: goto L10;
            case 156108012: goto L6;
            default: goto L57;
        };
    L57:
        switch(r101) {
            case 0: goto L85;
            case 1: goto L83;
            case 2: goto L81;
            case 3: goto L79;
            case 4: goto L77;
            case 5: goto L75;
            case 6: goto L73;
            case 7: goto L71;
            case 8: goto L69;
            case 9: goto L67;
            case 10: goto L65;
            case 11: goto L63;
            case 12: goto L61;
            default: goto L59;
        };
    L59:
        return Float.NaN;
    L61:
        return this.mWaveOffset;
    L63:
        return this.mAlpha;
    L65:
        return this.mTransitionPathRotate;
    L67:
        return this.mElevation;
    L69:
        return this.mRotation;
    L71:
        return this.mScaleY;
    L73:
        return this.mScaleX;
    L75:
        return this.mProgress;
    L77:
        return this.mTranslationZ;
    L79:
        return this.mTranslationY;
    L81:
        return this.mTranslationX;
    L83:
        return this.mRotationY;
    L85:
        return this.mRotationX;
    L6:
        if (r100.equals("waveOffset") == false) goto L57;
        r101 = 12;
        goto L57
    L10:
        if (r100.equals("alpha") == false) goto L57;
        r101 = 11;
        goto L57
    L14:
        if (r100.equals("transitionPathRotate") == false) goto L57;
        r101 = 10;
        goto L57
    L18:
        if (r100.equals("elevation") == false) goto L57;
        r101 = 9;
        goto L57
    L22:
        if (r100.equals("rotation") == false) goto L57;
        r101 = 8;
        goto L57
    L26:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L57;
        r101 = 7;
        goto L57
    L30:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L57;
        r101 = 6;
        goto L57
    L34:
        if (r100.equals("progress") == false) goto L57;
        r101 = 5;
        goto L57
    L38:
        if (r100.equals("translationZ") == false) goto L57;
        r101 = 4;
        goto L57
    L42:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L57;
        r101 = 3;
        goto L57
    L46:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L57;
        r101 = 2;
        goto L57
    L50:
        if (r100.equals("rotationY") == false) goto L57;
        r101 = 1;
        goto L57
    L54:
        if (r100.equals("rotationX") == false) goto L57;
        r101 = 0;
        goto L57
    }

    public static /* synthetic */ float access$1002(KeyCycle r100, float r101) {
        r100.mRotationX = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(KeyCycle r100, String r101) {
        r100.mTransitionEasing = r101;
        return r101;
    }

    public static /* synthetic */ float access$1102(KeyCycle r100, float r101) {
        r100.mRotationY = r101;
        return r101;
    }

    public static /* synthetic */ float access$1202(KeyCycle r100, float r101) {
        r100.mTransitionPathRotate = r101;
        return r101;
    }

    public static /* synthetic */ float access$1302(KeyCycle r100, float r101) {
        r100.mScaleX = r101;
        return r101;
    }

    public static /* synthetic */ float access$1402(KeyCycle r100, float r101) {
        r100.mScaleY = r101;
        return r101;
    }

    public static /* synthetic */ float access$1502(KeyCycle r100, float r101) {
        r100.mTranslationX = r101;
        return r101;
    }

    public static /* synthetic */ float access$1602(KeyCycle r100, float r101) {
        r100.mTranslationY = r101;
        return r101;
    }

    public static /* synthetic */ float access$1702(KeyCycle r100, float r101) {
        r100.mTranslationZ = r101;
        return r101;
    }

    public static /* synthetic */ float access$1802(KeyCycle r100, float r101) {
        r100.mProgress = r101;
        return r101;
    }

    public static /* synthetic */ int access$202(KeyCycle r100, int r101) {
        r100.mCurveFit = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(KeyCycle r100, int r101) {
        r100.mWaveShape = r101;
        return r101;
    }

    public static /* synthetic */ float access$402(KeyCycle r100, float r101) {
        r100.mWavePeriod = r101;
        return r101;
    }

    public static /* synthetic */ float access$502(KeyCycle r100, float r101) {
        r100.mWaveOffset = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(KeyCycle r100, int r101) {
        r100.mWaveVariesBy = r101;
        return r101;
    }

    public static /* synthetic */ float access$702(KeyCycle r100, float r101) {
        r100.mAlpha = r101;
        return r101;
    }

    public static /* synthetic */ float access$802(KeyCycle r100, float r101) {
        r100.mElevation = r101;
        return r101;
    }

    public static /* synthetic */ float access$902(KeyCycle r100, float r101) {
        r100.mRotation = r101;
        return r101;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r100, AttributeSet r101) {
        Loader.access$000(this, r100.obtainStyledAttributes(r101, new int[]{R.attr.alpha, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.curveFit, com.larus.nova.R.attr.framePosition, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate, com.larus.nova.R.attr.waveOffset, com.larus.nova.R.attr.wavePeriod, com.larus.nova.R.attr.wavePhase, com.larus.nova.R.attr.waveShape, com.larus.nova.R.attr.waveVariesBy}));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r100, Object r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1001078227: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -40300674: goto L34;
            case -4379043: goto L30;
            case 37232917: goto L26;
            case 92909918: goto L22;
            case 156108012: goto L18;
            case 184161818: goto L14;
            case 579057826: goto L10;
            case 1317633238: goto L6;
            default: goto L69;
        };
    L69:
        switch(r102) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L77;
            case 10: goto L76;
            case 11: goto L75;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            default: goto L103;
        };
    L71:
        this.mTranslationZ = toFloat(r101);
        return;
    L72:
        this.mCurveFit = toInt(r101);
        return;
    L73:
        this.mWavePeriod = toFloat(r101);
        return;
    L74:
        this.mWaveOffset = toFloat(r101);
        return;
    L75:
        this.mAlpha = toFloat(r101);
        return;
    L76:
        this.mTransitionPathRotate = toFloat(r101);
        return;
    L77:
        this.mElevation = toFloat(r101);
        return;
    L78:
        this.mRotation = toFloat(r101);
        return;
    L79:
        this.mScaleY = toFloat(r101);
        return;
    L80:
        this.mScaleX = toFloat(r101);
        return;
    L81:
        this.mProgress = toFloat(r101);
        return;
    L82:
        this.mTranslationY = toFloat(r101);
        return;
    L83:
        this.mTranslationX = toFloat(r101);
        return;
    L84:
        this.mRotationY = toFloat(r101);
        return;
    L85:
        this.mRotationX = toFloat(r101);
        return;
    L86:
        this.mTransitionEasing = r101.toString();
        return;
    L103:
        return;
    L6:
        if (r100.equals("mTranslationZ") == false) goto L69;
        r102 = 15;
        goto L69
    L10:
        if (r100.equals("curveFit") == false) goto L69;
        r102 = 14;
        goto L69
    L14:
        if (r100.equals("wavePeriod") == false) goto L69;
        r102 = HTTP.CR;
        goto L69
    L18:
        if (r100.equals("waveOffset") == false) goto L69;
        r102 = 12;
        goto L69
    L22:
        if (r100.equals("alpha") == false) goto L69;
        r102 = 11;
        goto L69
    L26:
        if (r100.equals("transitionPathRotate") == false) goto L69;
        r102 = 10;
        goto L69
    L30:
        if (r100.equals("elevation") == false) goto L69;
        r102 = 9;
        goto L69
    L34:
        if (r100.equals("rotation") == false) goto L69;
        r102 = 8;
        goto L69
    L38:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L69;
        r102 = 7;
        goto L69
    L42:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L69;
        r102 = 6;
        goto L69
    L46:
        if (r100.equals("progress") == false) goto L69;
        r102 = 5;
        goto L69
    L50:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L69;
        r102 = 4;
        goto L69
    L54:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L69;
        r102 = 3;
        goto L69
    L58:
        if (r100.equals("rotationY") == false) goto L69;
        r102 = 2;
        goto L69
    L62:
        if (r100.equals("rotationX") == false) goto L69;
        r102 = 1;
        goto L69
    L66:
        if (r100.equals("transitionEasing") == false) goto L69;
        r102 = 0;
        goto L69
    }
}
