package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.View;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.google.common.base.Ascii;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.motion.utils.ViewSpline;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes3.dex */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] sNames;
    private float mAlpha;
    private int mAnimateRelativeTo;
    private boolean mApplyElevation;
    LinkedHashMap<String, ConstraintAttribute> mAttributes;
    private int mDrawPath;
    private float mElevation;
    private float mHeight;
    private Easing mKeyFrameEasing;
    int mMode;
    private float mPathRotate;
    private float mPivotX;
    private float mPivotY;
    private float mPosition;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mScaleX;
    private float mScaleY;
    double[] mTempDelta;
    double[] mTempValue;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    int mVisibility;
    int mVisibilityMode;
    private float mWidth;
    private float mX;
    private float mY;
    public float rotationY;

    MotionConstrainedPoint() {
        this.rotationY = 0.0f;
        this.mVisibilityMode = 0;
        this.mAttributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        this.mAlpha = 1.0f;
        this.mApplyElevation = false;
        this.mElevation = 0.0f;
        this.mRotation = 0.0f;
        this.mRotationX = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTranslationX = 0.0f;
        this.mTranslationY = 0.0f;
        this.mTranslationZ = 0.0f;
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mAnimateRelativeTo = -1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint r1) {
        return compareTo2(r1);
    }

    static {
        sNames = new String[]{"position", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "pathRotate"};
    }

    private boolean diff(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    void different(MotionConstrainedPoint r5, HashSet<String> r6) {
        if (diff(this.mAlpha, r5.mAlpha) == false) goto L6;
        r6.add("alpha");
    L6:
        if (diff(this.mElevation, r5.mElevation) == false) goto L8;
        r6.add("elevation");
    L8:
        int r0 = this.mVisibility;
        int r2 = r5.mVisibility;
        if (r0 == r2) goto L16;
        if (this.mVisibilityMode != 0) goto L16;
        if (r0 == 0) goto L14;
        if (r2 != 0) goto L16;
    L14:
        r6.add("alpha");
    L16:
        if (diff(this.mRotation, r5.mRotation) == false) goto L19;
        r6.add("rotation");
    L19:
        if (Float.isNaN(this.mPathRotate) == true) goto L21;
    L22:
        r6.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.mProgress) == true) goto L26;
    L27:
        r6.add("progress");
    L29:
        if (diff(this.mRotationX, r5.mRotationX) == false) goto L32;
        r6.add("rotationX");
    L32:
        if (diff(this.rotationY, r5.rotationY) == false) goto L35;
        r6.add("rotationY");
    L35:
        if (diff(this.mPivotX, r5.mPivotX) == false) goto L38;
        r6.add("transformPivotX");
    L38:
        if (diff(this.mPivotY, r5.mPivotY) == false) goto L41;
        r6.add("transformPivotY");
    L41:
        if (diff(this.mScaleX, r5.mScaleX) == false) goto L44;
        r6.add("scaleX");
    L44:
        if (diff(this.mScaleY, r5.mScaleY) == false) goto L47;
        r6.add("scaleY");
    L47:
        if (diff(this.mTranslationX, r5.mTranslationX) == false) goto L50;
        r6.add("translationX");
    L50:
        if (diff(this.mTranslationY, r5.mTranslationY) == false) goto L53;
        r6.add("translationY");
    L53:
        if (diff(this.mTranslationZ, r5.mTranslationZ) == false) goto L56;
        r6.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r5.mProgress) == true) goto L29;
    L21:
        if (Float.isNaN(r5.mPathRotate) == true) goto L24;
        goto L22
    }

    void different(MotionConstrainedPoint r4, boolean[] r5, String[] r6) {
        r5[0] = r5[0] | diff(this.mPosition, r4.mPosition);
        r5[1] = r5[1] | diff(this.mX, r4.mX);
        r5[2] = r5[2] | diff(this.mY, r4.mY);
        r5[3] = r5[3] | diff(this.mWidth, r4.mWidth);
        boolean r0 = r5[4];
        r5[4] = diff(this.mHeight, r4.mHeight) | r0;
    }

    void fillStandard(double[] r8, int[] r9) {
        int r3 = 0;
        float[] r1 = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mAlpha, this.mElevation, this.mRotation, this.mRotationX, this.rotationY, this.mScaleX, this.mScaleY, this.mPivotX, this.mPivotY, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mPathRotate};
        int r7 = 0;
    L4:
        if (r3 >= r9.length) goto L9;
        int r2 = r9[r3];
        if (r2 >= 18) goto L8;
        r8[r7] = r1[r2];
        r7 = r7 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    boolean hasCustomData(String r1) {
        return this.mAttributes.containsKey(r1);
    }

    int getCustomDataCount(String r1) {
        return this.mAttributes.get(r1).numberOfInterpolatedValues();
    }

    int getCustomData(String r5, double[] r6, int r7) {
        ConstraintAttribute r4 = this.mAttributes.get(r5);
        if (r4.numberOfInterpolatedValues() != 1) goto L6;
        r6[r7] = r4.getValueToInterpolate();
        return 1;
    L6:
        int r8 = r4.numberOfInterpolatedValues();
        float[] r0 = new float[r8];
        r4.getValuesToInterpolate(r0);
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L9;
        r6[r7] = r0[r9];
        r9 = r9 + 1;
        r7 = r7 + 1;
        goto L7
    L9:
        return r8;
    }

    void setBounds(float r1, float r2, float r3, float r4) {
        this.mX = r1;
        this.mY = r2;
        this.mWidth = r3;
        this.mHeight = r4;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r1) {
        return Float.compare(this.mPosition, r1.mPosition);
    }

    public void applyParameters(View r2) {
        this.mVisibility = r2.getVisibility();
        if (r2.getVisibility() == 0) goto L5;
        float r0 = 0.0f;
    L6:
        this.mAlpha = r0;
        this.mApplyElevation = false;
        this.mElevation = r2.getElevation();
        this.mRotation = r2.getRotation();
        this.mRotationX = r2.getRotationX();
        this.rotationY = r2.getRotationY();
        this.mScaleX = r2.getScaleX();
        this.mScaleY = r2.getScaleY();
        this.mPivotX = r2.getPivotX();
        this.mPivotY = r2.getPivotY();
        this.mTranslationX = r2.getTranslationX();
        this.mTranslationY = r2.getTranslationY();
        this.mTranslationZ = r2.getTranslationZ();
        return;
    L5:
        r0 = r2.getAlpha();
        goto L6
    }

    public void applyParameters(ConstraintSet.Constraint r5) {
        this.mVisibilityMode = r5.propertySet.mVisibilityMode;
        this.mVisibility = r5.propertySet.visibility;
        if (r5.propertySet.visibility != 0) goto L5;
    L7:
        float r0 = r5.propertySet.alpha;
    L8:
        this.mAlpha = r0;
        this.mApplyElevation = r5.transform.applyElevation;
        this.mElevation = r5.transform.elevation;
        this.mRotation = r5.transform.rotation;
        this.mRotationX = r5.transform.rotationX;
        this.rotationY = r5.transform.rotationY;
        this.mScaleX = r5.transform.scaleX;
        this.mScaleY = r5.transform.scaleY;
        this.mPivotX = r5.transform.transformPivotX;
        this.mPivotY = r5.transform.transformPivotY;
        this.mTranslationX = r5.transform.translationX;
        this.mTranslationY = r5.transform.translationY;
        this.mTranslationZ = r5.transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(r5.motion.mTransitionEasing);
        this.mPathRotate = r5.motion.mPathRotate;
        this.mDrawPath = r5.motion.mDrawPath;
        this.mAnimateRelativeTo = r5.motion.mAnimateRelativeTo;
        this.mProgress = r5.propertySet.mProgress;
        Iterator<String> r1 = r5.mCustomConstraints.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        ConstraintAttribute r3 = r5.mCustomConstraints.get(r2);
        if (r3.isContinuous() == false) goto L10;
        this.mAttributes.put(r2, r3);
        goto L10
    L14:
        return;
    L5:
        if (this.mVisibilityMode != 0) goto L7;
        r0 = 0.0f;
        goto L8
    }

    public void addValues(HashMap<String, ViewSpline> r8, int r9) {
        Iterator<String> r0 = r8.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L148;
        String r1 = r0.next();
        ViewSpline r2 = r8.get(r1);
        if (r2 == null) goto L4;
        r1.hashCode();
        byte r5 = -1;
        switch(r1.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -760884510: goto L32;
            case -760884509: goto L28;
            case -40300674: goto L24;
            case -4379043: goto L20;
            case 37232917: goto L16;
            case 92909918: goto L12;
            default: goto L67;
        };
    L67:
        float r3 = 1.0f;
        float r6 = 0.0f;
        switch(r5) {
            case 0: goto L144;
            case 1: goto L139;
            case 2: goto L134;
            case 3: goto L129;
            case 4: goto L124;
            case 5: goto L119;
            case 6: goto L114;
            case 7: goto L109;
            case 8: goto L104;
            case 9: goto L99;
            case 10: goto L94;
            case 11: goto L89;
            case 12: goto L84;
            case 13: goto L79;
            default: goto L70;
        };
    L79:
        if (Float.isNaN(this.mAlpha) == true) goto L82;
        r3 = this.mAlpha;
    L82:
        r2.setPoint(r9, r3);
        goto L4
    L84:
        if (Float.isNaN(this.mPathRotate) == true) goto L87;
        r6 = this.mPathRotate;
    L87:
        r2.setPoint(r9, r6);
        goto L4
    L89:
        if (Float.isNaN(this.mElevation) == true) goto L92;
        r6 = this.mElevation;
    L92:
        r2.setPoint(r9, r6);
        goto L4
    L94:
        if (Float.isNaN(this.mRotation) == true) goto L97;
        r6 = this.mRotation;
    L97:
        r2.setPoint(r9, r6);
        goto L4
    L99:
        if (Float.isNaN(this.mPivotY) == true) goto L102;
        r6 = this.mPivotY;
    L102:
        r2.setPoint(r9, r6);
        goto L4
    L104:
        if (Float.isNaN(this.mPivotX) == true) goto L107;
        r6 = this.mPivotX;
    L107:
        r2.setPoint(r9, r6);
        goto L4
    L109:
        if (Float.isNaN(this.mScaleY) == true) goto L112;
        r3 = this.mScaleY;
    L112:
        r2.setPoint(r9, r3);
        goto L4
    L114:
        if (Float.isNaN(this.mScaleX) == true) goto L117;
        r3 = this.mScaleX;
    L117:
        r2.setPoint(r9, r3);
        goto L4
    L119:
        if (Float.isNaN(this.mProgress) == true) goto L122;
        r6 = this.mProgress;
    L122:
        r2.setPoint(r9, r6);
        goto L4
    L124:
        if (Float.isNaN(this.mTranslationZ) == true) goto L127;
        r6 = this.mTranslationZ;
    L127:
        r2.setPoint(r9, r6);
        goto L4
    L129:
        if (Float.isNaN(this.mTranslationY) == true) goto L132;
        r6 = this.mTranslationY;
    L132:
        r2.setPoint(r9, r6);
        goto L4
    L134:
        if (Float.isNaN(this.mTranslationX) == true) goto L137;
        r6 = this.mTranslationX;
    L137:
        r2.setPoint(r9, r6);
        goto L4
    L139:
        if (Float.isNaN(this.rotationY) == true) goto L142;
        r6 = this.rotationY;
    L142:
        r2.setPoint(r9, r6);
        goto L4
    L144:
        if (Float.isNaN(this.mRotationX) == true) goto L147;
        r6 = this.mRotationX;
    L147:
        r2.setPoint(r9, r6);
        goto L4
    L70:
        if (r1.startsWith("CUSTOM") == true) goto L71;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionPaths", "UNKNOWN spline " + r1);
        goto L4
    L71:
        String r4 = r1.split(SimContactsConstants.EMAIL_SEP)[1];
        if (this.mAttributes.containsKey(r4) == false) goto L4;
        ConstraintAttribute r7 = this.mAttributes.get(r4);
        if ((r2 instanceof ViewSpline.CustomSet) == true) goto L75;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("MotionPaths", r1 + " ViewSpline not a CustomSet frame = " + r9 + ", value" + r7.getValueToInterpolate() + r2);
        goto L4
    L75:
        ((ViewSpline.CustomSet) r2).setPoint(r9, r7);
        goto L4
    L12:
        if (r1.equals("alpha") == false) goto L67;
        r5 = Ascii.CR;
        goto L67
    L16:
        if (r1.equals("transitionPathRotate") == false) goto L67;
        r5 = Ascii.FF;
        goto L67
    L20:
        if (r1.equals("elevation") == false) goto L67;
        r5 = Ascii.VT;
        goto L67
    L24:
        if (r1.equals("rotation") == false) goto L67;
        r5 = 10;
        goto L67
    L28:
        if (r1.equals("transformPivotY") == false) goto L67;
        r5 = 9;
        goto L67
    L32:
        if (r1.equals("transformPivotX") == false) goto L67;
        r5 = 8;
        goto L67
    L36:
        if (r1.equals("scaleY") == false) goto L67;
        r5 = 7;
        goto L67
    L40:
        if (r1.equals("scaleX") == false) goto L67;
        r5 = 6;
        goto L67
    L44:
        if (r1.equals("progress") == false) goto L67;
        r5 = 5;
        goto L67
    L48:
        if (r1.equals("translationZ") == false) goto L67;
        r5 = 4;
        goto L67
    L52:
        if (r1.equals("translationY") == false) goto L67;
        r5 = 3;
        goto L67
    L56:
        if (r1.equals("translationX") == false) goto L67;
        r5 = 2;
        goto L67
    L60:
        if (r1.equals("rotationY") == false) goto L67;
        r5 = 1;
        goto L67
    L64:
        if (r1.equals("rotationX") == false) goto L67;
        r5 = 0;
        goto L67
    }

    public void setState(View r5) {
        setBounds(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        applyParameters(r5);
    }

    public void setState(Rect r4, View r5, int r6, float r7) {
        setBounds(r4.left, r4.top, r4.width(), r4.height());
        applyParameters(r5);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (r6 != 1) goto L5;
        this.mRotation = r7 - 90.0f;
        return;
    L5:
        if (r6 != 2) goto L11;
        this.mRotation = r7 + 90.0f;
        return;
    }

    public void setState(Rect r4, ConstraintSet r5, int r6, int r7) {
        setBounds(r4.left, r4.top, r4.width(), r4.height());
        applyParameters(r5.getParameters(r7));
        if (r6 != 1) goto L5;
    L14:
        this.mRotation -= 90.0f;
        return;
    L5:
        if (r6 != 2) goto L7;
    L11:
        float r8 = this.mRotation + 90.0f;
        this.mRotation = r8;
        if (r8 <= 180.0f) goto L16;
        this.mRotation = r8 - 360.0f;
        return;
    L16:
        return;
    L7:
        if (r6 == 3) goto L14;
        if (r6 == 4) goto L11;
    }
}
