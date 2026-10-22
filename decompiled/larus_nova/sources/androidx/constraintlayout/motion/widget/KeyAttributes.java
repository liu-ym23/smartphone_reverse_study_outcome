package androidx.constraintlayout.motion.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mPivotX;
    private float mPivotY;
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
    private boolean mVisibility;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
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
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray r100 = new SparseIntArray();
            mAttrMap = r100;
            r100.append(0, 1);
            mAttrMap.append(11, 2);
            mAttrMap.append(7, 4);
            mAttrMap.append(8, 5);
            mAttrMap.append(9, 6);
            mAttrMap.append(1, 19);
            mAttrMap.append(2, 20);
            mAttrMap.append(5, 7);
            mAttrMap.append(18, 8);
            mAttrMap.append(17, 9);
            mAttrMap.append(15, 10);
            mAttrMap.append(13, 12);
            mAttrMap.append(12, 13);
            mAttrMap.append(6, 14);
            mAttrMap.append(3, 15);
            mAttrMap.append(4, 16);
            mAttrMap.append(10, 17);
            mAttrMap.append(14, 18);
        }

        public static void read(KeyAttributes r100, TypedArray r101) {
            int r102 = r101.getIndexCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L34;
            int r104 = r101.getIndex(r103);
            switch(mAttrMap.get(r104)) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L6;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L17;
                case 11: goto L6;
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
        L33:
            r103 = r103 + 1;
            goto L3
        L7:
            KeyAttributes.access$802(r100, r101.getDimension(r104, KeyAttributes.access$800(r100)));
            goto L33
        L8:
            KeyAttributes.access$702(r100, r101.getDimension(r104, KeyAttributes.access$700(r100)));
            goto L33
        L9:
            KeyAttributes.access$1502(r100, r101.getFloat(r104, KeyAttributes.access$1500(r100)));
            goto L33
        L10:
            KeyAttributes.access$1402(r100, r101.getDimension(r104, KeyAttributes.access$1400(r100)));
            goto L33
        L11:
            KeyAttributes.access$1302(r100, r101.getDimension(r104, KeyAttributes.access$1300(r100)));
            goto L33
        L12:
            KeyAttributes.access$1202(r100, r101.getDimension(r104, KeyAttributes.access$1200(r100)));
            goto L33
        L13:
            KeyAttributes.access$1002(r100, r101.getFloat(r104, KeyAttributes.access$1000(r100)));
            goto L33
        L14:
            KeyAttributes.access$302(r100, r101.getInteger(r104, KeyAttributes.access$300(r100)));
            goto L33
        L15:
            r100.mFramePosition = r101.getInt(r104, r100.mFramePosition);
            goto L33
        L25:
            KeyAttributes.access$902(r100, r101.getString(r104));
            goto L33
        L26:
            KeyAttributes.access$1102(r100, r101.getFloat(r104, KeyAttributes.access$1100(r100)));
            goto L33
        L27:
            KeyAttributes.access$402(r100, r101.getFloat(r104, KeyAttributes.access$400(r100)));
            goto L33
        L28:
            KeyAttributes.access$602(r100, r101.getFloat(r104, KeyAttributes.access$600(r100)));
            goto L33
        L29:
            KeyAttributes.access$502(r100, r101.getFloat(r104, KeyAttributes.access$500(r100)));
            goto L33
        L30:
            KeyAttributes.access$202(r100, r101.getFloat(r104, KeyAttributes.access$200(r100)));
            goto L33
        L31:
            KeyAttributes.access$102(r100, r101.getDimension(r104, KeyAttributes.access$100(r100)));
            goto L33
        L32:
            KeyAttributes.access$002(r100, r101.getFloat(r104, KeyAttributes.access$000(r100)));
            goto L33
        L17:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L22;
            int r105 = r101.getResourceId(r104, r100.mTargetId);
            r100.mTargetId = r105;
            if (r105 != (-1)) goto L33;
            r100.mTargetString = r101.getString(r104);
            goto L33
        L22:
            if (r101.peekValue(r104).type != 3) goto L24;
            r100.mTargetString = r101.getString(r104);
            goto L33
        L24:
            r100.mTargetId = r101.getResourceId(r104, r100.mTargetId);
            goto L33
        }
    }

    public KeyAttributes() {
        this.mCurveFit = -1;
        this.mVisibility = false;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mType = 1;
        this.mCustomConstraints = new HashMap();
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    public static /* synthetic */ float access$000(KeyAttributes r100) {
        return r100.mAlpha;
    }

    public static /* synthetic */ float access$100(KeyAttributes r100) {
        return r100.mElevation;
    }

    public static /* synthetic */ float access$1000(KeyAttributes r100) {
        return r100.mScaleY;
    }

    public static /* synthetic */ float access$1100(KeyAttributes r100) {
        return r100.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1200(KeyAttributes r100) {
        return r100.mTranslationX;
    }

    public static /* synthetic */ float access$1300(KeyAttributes r100) {
        return r100.mTranslationY;
    }

    public static /* synthetic */ float access$1400(KeyAttributes r100) {
        return r100.mTranslationZ;
    }

    public static /* synthetic */ float access$1500(KeyAttributes r100) {
        return r100.mProgress;
    }

    public static /* synthetic */ float access$200(KeyAttributes r100) {
        return r100.mRotation;
    }

    public static /* synthetic */ int access$300(KeyAttributes r100) {
        return r100.mCurveFit;
    }

    public static /* synthetic */ float access$400(KeyAttributes r100) {
        return r100.mScaleX;
    }

    public static /* synthetic */ float access$500(KeyAttributes r100) {
        return r100.mRotationX;
    }

    public static /* synthetic */ float access$600(KeyAttributes r100) {
        return r100.mRotationY;
    }

    public static /* synthetic */ float access$700(KeyAttributes r100) {
        return r100.mPivotX;
    }

    public static /* synthetic */ float access$800(KeyAttributes r100) {
        return r100.mPivotY;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r100) {
        Iterator<String> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L112;
        String r102 = r101.next();
        SplineSet r103 = r100.get(r102);
        byte r104 = 7;
        if (r102.startsWith("CUSTOM") == true) goto L7;
        switch(r102.hashCode()) {
            case -1249320806: goto L65;
            case -1249320805: goto L61;
            case -1225497657: goto L57;
            case -1225497656: goto L53;
            case -1225497655: goto L49;
            case -1001078227: goto L45;
            case -908189618: goto L41;
            case -908189617: goto L38;
            case -760884510: goto L34;
            case -760884509: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            default: goto L12;
        };
    L12:
        r104 = -1;
    L68:
        switch(r104) {
            case 0: goto L110;
            case 1: goto L107;
            case 2: goto L104;
            case 3: goto L101;
            case 4: goto L98;
            case 5: goto L95;
            case 6: goto L92;
            case 7: goto L89;
            case 8: goto L86;
            case 9: goto L83;
            case 10: goto L80;
            case 11: goto L77;
            case 12: goto L74;
            case 13: goto L71;
            default: goto L4;
        };
    L71:
        if (Float.isNaN(this.mAlpha) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mAlpha);
        goto L4
    L74:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mTransitionPathRotate);
        goto L4
    L77:
        if (Float.isNaN(this.mElevation) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mElevation);
        goto L4
    L80:
        if (Float.isNaN(this.mRotation) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mRotation);
        goto L4
    L83:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mPivotY);
        goto L4
    L86:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mPivotX);
        goto L4
    L89:
        if (Float.isNaN(this.mScaleY) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mScaleY);
        goto L4
    L92:
        if (Float.isNaN(this.mScaleX) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mScaleX);
        goto L4
    L95:
        if (Float.isNaN(this.mProgress) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mProgress);
        goto L4
    L98:
        if (Float.isNaN(this.mTranslationZ) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mTranslationZ);
        goto L4
    L101:
        if (Float.isNaN(this.mTranslationY) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mTranslationY);
        goto L4
    L104:
        if (Float.isNaN(this.mTranslationX) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mTranslationX);
        goto L4
    L107:
        if (Float.isNaN(this.mRotationY) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mRotationY);
        goto L4
    L110:
        if (Float.isNaN(this.mRotationX) == true) goto L4;
        r103.setPoint(this.mFramePosition, this.mRotationX);
        goto L4
    L14:
        if (r102.equals("alpha") == false) goto L12;
        r104 = HTTP.CR;
        goto L68
    L18:
        if (r102.equals("transitionPathRotate") == false) goto L12;
        r104 = 12;
        goto L68
    L22:
        if (r102.equals("elevation") == false) goto L12;
        r104 = 11;
        goto L68
    L26:
        if (r102.equals("rotation") == false) goto L12;
        r104 = 10;
        goto L68
    L30:
        if (r102.equals("transformPivotY") == false) goto L12;
        r104 = 9;
        goto L68
    L34:
        if (r102.equals("transformPivotX") == false) goto L12;
        r104 = 8;
        goto L68
    L38:
        if (r102.equals(LiveDegradeFpsAnimator.SCALE_Y) == true) goto L68;
    L41:
        if (r102.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L12;
        r104 = 6;
        goto L68
    L45:
        if (r102.equals("progress") == false) goto L12;
        r104 = 5;
        goto L68
    L49:
        if (r102.equals("translationZ") == false) goto L12;
        r104 = 4;
        goto L68
    L53:
        if (r102.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L12;
        r104 = 3;
        goto L68
    L57:
        if (r102.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L12;
        r104 = 2;
        goto L68
    L61:
        if (r102.equals("rotationY") == false) goto L12;
        r104 = 1;
        goto L68
    L65:
        if (r102.equals("rotationX") == false) goto L12;
        r104 = 0;
        goto L68
    L7:
        String r105 = r102.substring(7);
        ConstraintAttribute r106 = this.mCustomConstraints.get(r105);
        if (r106 == null) goto L4;
        ((SplineSet.CustomSet) r103).setPoint(this.mFramePosition, r106);
        goto L4
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
        if (Float.isNaN(this.mPivotX) == true) goto L21;
        r100.add("transformPivotX");
    L21:
        if (Float.isNaN(this.mPivotY) == true) goto L24;
        r100.add("transformPivotY");
    L24:
        if (Float.isNaN(this.mTranslationX) == true) goto L27;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L27:
        if (Float.isNaN(this.mTranslationY) == true) goto L30;
        r100.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L30:
        if (Float.isNaN(this.mTranslationZ) == true) goto L33;
        r100.add("translationZ");
    L33:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L36;
        r100.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.mScaleX) == true) goto L39;
        r100.add(LiveDegradeFpsAnimator.SCALE_X);
    L39:
        if (Float.isNaN(this.mScaleY) == true) goto L42;
        r100.add(LiveDegradeFpsAnimator.SCALE_Y);
    L42:
        if (Float.isNaN(this.mProgress) == true) goto L45;
        r100.add("progress");
    L45:
        if (this.mCustomConstraints.size() <= 0) goto L50;
        Iterator<String> r101 = this.mCustomConstraints.keySet().iterator();
    L48:
        if (r101.hasNext() == false) goto L52;
        r100.add("CUSTOM," + r101.next());
        goto L48
    L52:
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
        if (Float.isNaN(this.mPivotX) == true) goto L24;
        r100.put("transformPivotX", Integer.valueOf(this.mCurveFit));
    L24:
        if (Float.isNaN(this.mPivotY) == true) goto L27;
        r100.put("transformPivotY", Integer.valueOf(this.mCurveFit));
    L27:
        if (Float.isNaN(this.mTranslationX) == true) goto L30;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
    L30:
        if (Float.isNaN(this.mTranslationY) == true) goto L33;
        r100.put(LiveDegradeFpsAnimator.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
    L33:
        if (Float.isNaN(this.mTranslationZ) == true) goto L36;
        r100.put("translationZ", Integer.valueOf(this.mCurveFit));
    L36:
        if (Float.isNaN(this.mTransitionPathRotate) == true) goto L39;
        r100.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
    L39:
        if (Float.isNaN(this.mScaleX) == true) goto L42;
        r100.put(LiveDegradeFpsAnimator.SCALE_X, Integer.valueOf(this.mCurveFit));
    L42:
        if (Float.isNaN(this.mScaleY) == true) goto L45;
        r100.put(LiveDegradeFpsAnimator.SCALE_Y, Integer.valueOf(this.mCurveFit));
    L45:
        if (Float.isNaN(this.mProgress) == true) goto L48;
        r100.put("progress", Integer.valueOf(this.mCurveFit));
    L48:
        if (this.mCustomConstraints.size() <= 0) goto L53;
        Iterator<String> r101 = this.mCustomConstraints.keySet().iterator();
    L51:
        if (r101.hasNext() == false) goto L55;
        r100.put("CUSTOM," + r101.next(), Integer.valueOf(this.mCurveFit));
        goto L51
    L55:
        return;
    }

    public static /* synthetic */ float access$002(KeyAttributes r100, float r101) {
        r100.mAlpha = r101;
        return r101;
    }

    public static /* synthetic */ float access$1002(KeyAttributes r100, float r101) {
        r100.mScaleY = r101;
        return r101;
    }

    public static /* synthetic */ float access$102(KeyAttributes r100, float r101) {
        r100.mElevation = r101;
        return r101;
    }

    public static /* synthetic */ float access$1102(KeyAttributes r100, float r101) {
        r100.mTransitionPathRotate = r101;
        return r101;
    }

    public static /* synthetic */ float access$1202(KeyAttributes r100, float r101) {
        r100.mTranslationX = r101;
        return r101;
    }

    public static /* synthetic */ float access$1302(KeyAttributes r100, float r101) {
        r100.mTranslationY = r101;
        return r101;
    }

    public static /* synthetic */ float access$1402(KeyAttributes r100, float r101) {
        r100.mTranslationZ = r101;
        return r101;
    }

    public static /* synthetic */ float access$1502(KeyAttributes r100, float r101) {
        r100.mProgress = r101;
        return r101;
    }

    public static /* synthetic */ float access$202(KeyAttributes r100, float r101) {
        r100.mRotation = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(KeyAttributes r100, int r101) {
        r100.mCurveFit = r101;
        return r101;
    }

    public static /* synthetic */ float access$402(KeyAttributes r100, float r101) {
        r100.mScaleX = r101;
        return r101;
    }

    public static /* synthetic */ float access$502(KeyAttributes r100, float r101) {
        r100.mRotationX = r101;
        return r101;
    }

    public static /* synthetic */ float access$602(KeyAttributes r100, float r101) {
        r100.mRotationY = r101;
        return r101;
    }

    public static /* synthetic */ float access$702(KeyAttributes r100, float r101) {
        r100.mPivotX = r101;
        return r101;
    }

    public static /* synthetic */ float access$802(KeyAttributes r100, float r101) {
        r100.mPivotY = r101;
        return r101;
    }

    public static /* synthetic */ String access$902(KeyAttributes r100, String r101) {
        r100.mTransitionEasing = r101;
        return r101;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r100, AttributeSet r101) {
        Loader.read(this, r100.obtainStyledAttributes(r101, new int[]{R.attr.alpha, R.attr.transformPivotX, R.attr.transformPivotY, R.attr.translationX, R.attr.translationY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.rotationX, R.attr.rotationY, R.attr.translationZ, R.attr.elevation, com.larus.nova.R.attr.curveFit, com.larus.nova.R.attr.framePosition, com.larus.nova.R.attr.motionProgress, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.transformPivotTarget, com.larus.nova.R.attr.transitionEasing, com.larus.nova.R.attr.transitionPathRotate}));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r100, Object r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -987906986: goto L46;
            case -987906985: goto L42;
            case -908189618: goto L38;
            case -908189617: goto L34;
            case -40300674: goto L30;
            case -4379043: goto L26;
            case 37232917: goto L22;
            case 92909918: goto L18;
            case 579057826: goto L14;
            case 1317633238: goto L10;
            case 1941332754: goto L6;
            default: goto L73;
        };
    L73:
        switch(r102) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L87;
            case 5: goto L86;
            case 6: goto L85;
            case 7: goto L84;
            case 8: goto L83;
            case 9: goto L82;
            case 10: goto L81;
            case 11: goto L80;
            case 12: goto L79;
            case 13: goto L78;
            case 14: goto L77;
            case 15: goto L76;
            case 16: goto L75;
            default: goto L109;
        };
    L75:
        this.mVisibility = toBoolean(r101);
        return;
    L76:
        this.mTranslationZ = toFloat(r101);
        return;
    L77:
        this.mCurveFit = toInt(r101);
        return;
    L78:
        this.mAlpha = toFloat(r101);
        return;
    L79:
        this.mTransitionPathRotate = toFloat(r101);
        return;
    L80:
        this.mElevation = toFloat(r101);
        return;
    L81:
        this.mRotation = toFloat(r101);
        return;
    L82:
        this.mScaleY = toFloat(r101);
        return;
    L83:
        this.mScaleX = toFloat(r101);
        return;
    L84:
        this.mPivotY = toFloat(r101);
        return;
    L85:
        this.mPivotX = toFloat(r101);
        return;
    L86:
        this.mTranslationY = toFloat(r101);
        return;
    L87:
        this.mTranslationX = toFloat(r101);
        return;
    L88:
        this.mRotationY = toFloat(r101);
        return;
    L89:
        this.mRotationX = toFloat(r101);
        return;
    L90:
        this.mTransitionEasing = r101.toString();
        return;
    L91:
        this.mProgress = toFloat(r101);
        return;
    L109:
        return;
    L6:
        if (r100.equals(RemoteMessageConst.Notification.VISIBILITY) == false) goto L73;
        r102 = 16;
        goto L73
    L10:
        if (r100.equals("mTranslationZ") == false) goto L73;
        r102 = 15;
        goto L73
    L14:
        if (r100.equals("curveFit") == false) goto L73;
        r102 = 14;
        goto L73
    L18:
        if (r100.equals("alpha") == false) goto L73;
        r102 = HTTP.CR;
        goto L73
    L22:
        if (r100.equals("transitionPathRotate") == false) goto L73;
        r102 = 12;
        goto L73
    L26:
        if (r100.equals("elevation") == false) goto L73;
        r102 = 11;
        goto L73
    L30:
        if (r100.equals("rotation") == false) goto L73;
        r102 = 10;
        goto L73
    L34:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L73;
        r102 = 9;
        goto L73
    L38:
        if (r100.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L73;
        r102 = 8;
        goto L73
    L42:
        if (r100.equals("pivotY") == false) goto L73;
        r102 = 7;
        goto L73
    L46:
        if (r100.equals("pivotX") == false) goto L73;
        r102 = 6;
        goto L73
    L50:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L73;
        r102 = 5;
        goto L73
    L54:
        if (r100.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L73;
        r102 = 4;
        goto L73
    L58:
        if (r100.equals("rotationY") == false) goto L73;
        r102 = 3;
        goto L73
    L62:
        if (r100.equals("rotationX") == false) goto L73;
        r102 = 2;
        goto L73
    L66:
        if (r100.equals("transitionEasing") == false) goto L73;
        r102 = 1;
        goto L73
    L70:
        if (r100.equals("motionProgress") == false) goto L73;
        r102 = 0;
        goto L73
    }
}
