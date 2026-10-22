package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.constraintlayout.core.motion.utils.CurveFit;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCache;
import com.obric.oui.constraintlayout.core.motion.utils.VelocityMatrix;
import com.obric.oui.constraintlayout.motion.utils.CustomSupport;
import com.obric.oui.constraintlayout.motion.utils.ViewOscillator;
import com.obric.oui.constraintlayout.motion.utils.ViewSpline;
import com.obric.oui.constraintlayout.motion.utils.ViewState;
import com.obric.oui.constraintlayout.motion.utils.ViewTimeCycle;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MotionController {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, ViewOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    boolean mForceMeasure;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private int mMaxDimension;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    Rect mTempRect;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public void setTransformPivotTarget(int r1) {
        this.mTransformPivotTarget = r1;
        this.mTransformPivotView = null;
    }

    MotionPaths getKeyFrame(int r1) {
        return this.mMotionPaths.get(r1);
    }

    MotionController(View r5) {
        this.mTempRect = new Rect();
        this.mForceMeasure = false;
        this.mCurveFitType = -1;
        this.mStartMotionPath = new MotionPaths();
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mStaggerOffset = 0.0f;
        this.mStaggerScale = 1.0f;
        this.mMaxDimension = 4;
        this.mValuesBuff = new float[4];
        this.mMotionPaths = new ArrayList();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList();
        this.mPathMotionArc = Key.UNSET;
        this.mTransformPivotTarget = Key.UNSET;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = Key.UNSET;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(r5);
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public void setupRelative(MotionController r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getCenter(double r10, float[] r12, float[] r13) {
        double[] r5 = new double[4];
        double[] r7 = new double[4];
        this.mSpline[0].getPos(r10, r5);
        this.mSpline[0].getSlope(r10, r7);
        Arrays.fill(r13, 0.0f);
        this.mStartMotionPath.getCenter(r10, this.mInterpolateVariables, r5, r12, r7, r13);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    void buildPath(float[] r19, int r20) {
        float r9 = 1.0f;
        float r10 = 1.0f / (r20 - 1);
        HashMap<String, ViewSpline> r1 = this.mAttributesMap;
        ViewOscillator r3 = null;
        if (r1 != null) goto L5;
        ViewSpline r11 = null;
    L6:
        HashMap<String, ViewSpline> r2 = this.mAttributesMap;
        if (r2 != null) goto L9;
        ViewSpline r12 = null;
    L10:
        HashMap<String, ViewOscillator> r4 = this.mCycleMap;
        if (r4 != null) goto L13;
        ViewOscillator r13 = null;
    L14:
        HashMap<String, ViewOscillator> r5 = this.mCycleMap;
        if (r5 == null) goto L18;
        r3 = r5.get("translationY");
    L18:
        ViewOscillator r14 = r3;
        int r7 = 0;
    L19:
        if (r7 >= r20) goto L62;
        float r6 = r7 * r10;
        float r8 = this.mStaggerScale;
        float r15 = 0.0f;
        if (r8 == r9) goto L30;
        float r16 = this.mStaggerOffset;
        if (r6 >= r16) goto L26;
        r6 = 0.0f;
    L26:
        if (r6 <= r16) goto L30;
        if (r6 >= 1.0d) goto L30;
        r6 = Math.min((r6 - r16) * r8, r9);
    L30:
        float r17 = r6;
        double r18 = r17;
        Easing r21 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r22 = this.mMotionPaths.iterator();
        float r110 = Float.NaN;
    L32:
        if (r22.hasNext() == false) goto L42;
        MotionPaths r23 = r22.next();
        if (r23.mKeyFrameEasing == null) goto L32;
        if (r23.mTime >= r17) goto L39;
        r21 = r23.mKeyFrameEasing;
        r15 = r23.mTime;
        goto L32
    L39:
        if (Float.isNaN(r110) == false) goto L32;
        r110 = r23.mTime;
        goto L32
    L42:
        if (r21 != null) goto L44;
    L47:
        double r24 = r18;
        this.mSpline[0].getPos(r24, this.mInterpolateData);
        CurveFit r25 = this.mArcSpline;
        if (r25 == null) goto L52;
        double[] r26 = this.mInterpolateData;
        if (r26.length <= 0) goto L52;
        r25.getPos(r24, r26);
    L52:
        int r111 = r7 * 2;
        int r112 = r7;
        this.mStartMotionPath.getCenter(r24, this.mInterpolateVariables, this.mInterpolateData, r19, r111);
        if (r13 == null) goto L55;
        r19[r111] = r19[r111] + r13.get(r17);
    L57:
        if (r14 == null) goto L59;
        int r113 = r111 + 1;
        r19[r113] = r19[r113] + r14.get(r17);
    L61:
        r7 = r112 + 1;
        r9 = 1.0f;
        goto L19
    L59:
        if (r12 == null) goto L61;
        int r114 = r111 + 1;
        r19[r114] = r19[r114] + r12.get(r17);
        goto L61
    L55:
        if (r11 == null) goto L57;
        r19[r111] = r19[r111] + r11.get(r17);
        goto L57
    L44:
        if (Float.isNaN(r110) == false) goto L46;
        r110 = 1.0f;
    L46:
        float r115 = r110 - r15;
        r18 = (((float) r21.get((r17 - r15) / r115)) * r115) + r15;
        goto L47
    L62:
        return;
    L13:
        r13 = r4.get("translationX");
        goto L14
    L9:
        r12 = r2.get("translationY");
        goto L10
    L5:
        r11 = r1.get("translationX");
        goto L6
    }

    double[] getPos(double r4) {
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        CurveFit r0 = this.mArcSpline;
        if (r0 == null) goto L8;
        double[] r1 = this.mInterpolateData;
        if (r1.length <= 0) goto L8;
        r0.getPos(r4, r1);
    L8:
        return this.mInterpolateData;
    }

    void buildBounds(float[] r17, int r18) {
        float r2 = 1.0f / (r18 - 1);
        HashMap<String, ViewSpline> r4 = this.mAttributesMap;
        if (r4 == null) goto L6;
        ViewSpline r5 = r4.get("translationX");
    L6:
        HashMap<String, ViewSpline> r6 = this.mAttributesMap;
        if (r6 == null) goto L10;
        ViewSpline r7 = r6.get("translationY");
    L10:
        HashMap<String, ViewOscillator> r8 = this.mCycleMap;
        if (r8 == null) goto L14;
        ViewOscillator r9 = r8.get("translationX");
    L14:
        HashMap<String, ViewOscillator> r10 = this.mCycleMap;
        if (r10 == null) goto L18;
        ViewOscillator r11 = r10.get("translationY");
    L18:
        int r12 = 0;
    L19:
        if (r12 >= r18) goto L52;
        float r13 = r12 * r2;
        float r14 = this.mStaggerScale;
        float r15 = 0.0f;
        if (r14 == 1.0f) goto L30;
        float r16 = this.mStaggerOffset;
        if (r13 >= r16) goto L26;
        r13 = 0.0f;
    L26:
        if (r13 <= r16) goto L30;
        if (r13 >= 1.0d) goto L30;
        r13 = Math.min((r13 - r16) * r14, 1.0f);
    L30:
        double r19 = r13;
        Easing r110 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r111 = this.mMotionPaths.iterator();
        float r112 = Float.NaN;
    L32:
        if (r111.hasNext() == false) goto L41;
        MotionPaths r113 = r111.next();
        if (r113.mKeyFrameEasing == null) goto L32;
        if (r113.mTime < r13) goto L37;
        if (Float.isNaN(r112) == false) goto L32;
        r112 = r113.mTime;
        goto L32
    L37:
        r110 = r113.mKeyFrameEasing;
        r15 = r113.mTime;
        goto L32
    L41:
        if (r110 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r19, this.mInterpolateData);
        CurveFit r20 = this.mArcSpline;
        if (r20 == null) goto L51;
        double[] r21 = this.mInterpolateData;
        if (r21.length <= 0) goto L51;
        r20.getPos(r19, r21);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r17, r12 * 2);
        r12 = r12 + 1;
        goto L19
    L43:
        if (Float.isNaN(r112) == false) goto L45;
        r112 = 1.0f;
    L45:
        float r114 = r112 - r15;
        r19 = (((float) r110.get((r13 - r15) / r114)) * r114) + r15;
        goto L46
    }

    private float getPreCycleDistance() {
        float[] r1 = new float[2];
        float r10 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        int r8 = 0;
        float r17 = 0.0f;
    L4:
        if (r8 >= 100) goto L26;
        float r2 = r8 * r10;
        double r3 = r2;
        Easing r5 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r6 = this.mMotionPaths.iterator();
        float r7 = Float.NaN;
        float r18 = 0.0f;
    L7:
        if (r6.hasNext() == false) goto L17;
        MotionPaths r9 = r6.next();
        if (r9.mKeyFrameEasing == null) goto L7;
        if (r9.mTime >= r2) goto L14;
        r5 = r9.mKeyFrameEasing;
        r18 = r9.mTime;
        goto L7
    L14:
        if (Float.isNaN(r7) == false) goto L7;
        r7 = r9.mTime;
        goto L7
    L17:
        if (r5 != null) goto L19;
    L22:
        this.mSpline[0].getPos(r3, this.mInterpolateData);
        int r11 = r8;
        this.mStartMotionPath.getCenter(r3, this.mInterpolateVariables, this.mInterpolateData, r1, 0);
        if (r11 <= 0) goto L25;
        r17 = r17 + ((float) Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])));
    L25:
        r13 = r1[0];
        r8 = r11 + 1;
        r15 = r1[1];
        goto L4
    L19:
        if (Float.isNaN(r7) == false) goto L21;
        r7 = 1.0f;
    L21:
        float r12 = r7 - r18;
        r3 = (((float) r5.get((r2 - r18) / r12)) * r12) + r18;
        goto L22
    L26:
        return r17;
    }

    KeyPositionBase getPositionKeyframe(int r11, int r12, float r13, float r14) {
        RectF r7 = new RectF();
        r7.left = this.mStartMotionPath.mX;
        r7.top = this.mStartMotionPath.mY;
        r7.right = r7.left + this.mStartMotionPath.mWidth;
        r7.bottom = r7.top + this.mStartMotionPath.mHeight;
        RectF r8 = new RectF();
        r8.left = this.mEndMotionPath.mX;
        r8.top = this.mEndMotionPath.mY;
        r8.right = r8.left + this.mEndMotionPath.mWidth;
        r8.bottom = r8.top + this.mEndMotionPath.mHeight;
        Iterator<Key> r10 = this.mKeyList.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Key r0 = r10.next();
        if ((r0 instanceof KeyPositionBase) == false) goto L4;
        KeyPositionBase r9 = (KeyPositionBase) r0;
        if (r9.intersects(r11, r12, r7, r8, r13, r14) == false) goto L4;
        return r9;
    L10:
        return null;
    }

    int buildKeyFrames(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r12 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r12[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        int r13 = 0;
        int r9 = 0;
    L12:
        if (r13 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r13], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r13], this.mInterpolateVariables, this.mInterpolateData, r11, r9);
        r9 = r9 + 2;
        r13 = r13 + 1;
        goto L12
    L15:
        return r9 / 2;
    L16:
        return 0;
    }

    int buildKeyBounds(float[] r8, int[] r9) {
        if (r8 == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r9 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r9[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        int r10 = 0;
        int r4 = 0;
    L12:
        if (r10 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r10], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r8, r4);
        r4 = r4 + 2;
        r10 = r10 + 1;
        goto L12
    L15:
        return r4 / 2;
    L16:
        return 0;
    }

    int getAttributeValues(String r1, float[] r2, int r3) {
        ViewSpline r0 = this.mAttributesMap.get(r1);
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r4 = 0;
    L8:
        if (r4 >= r2.length) goto L11;
        r2[r4] = r0.get(r4 / (r2.length - 1));
        r4 = r4 + 1;
        goto L8
    L11:
        return r2.length;
    }

    void buildRect(float r4, float[] r5, int r6) {
        this.mSpline[0].getPos(getAdjustedPosition(r4, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r5, r6);
    }

    void buildRectangles(float[] r8, int r9) {
        float r1 = 1.0f / (r9 - 1);
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r2 * r1, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r8, r2 * 8);
        r2 = r2 + 1;
        goto L3
    }

    float getKeyFrameParameter(int r9, float r10, float r11) {
        float r0 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float r1 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        float r2 = this.mStartMotionPath.mX + (this.mStartMotionPath.mWidth / 2.0f);
        float r3 = this.mStartMotionPath.mY + (this.mStartMotionPath.mHeight / 2.0f);
        float r8 = (float) Math.hypot(r0, r1);
        if (r8 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r12 = r10 - r2;
        float r13 = r11 - r3;
        if (((float) Math.hypot(r12, r13)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r4 = (r12 * r0) + (r13 * r1);
        if (r9 == 0) goto L33;
        if (r9 == 1) goto L31;
        if (r9 == 2) goto L29;
        if (r9 == 3) goto L27;
        if (r9 == 4) goto L25;
        if (r9 == 5) goto L23;
        return 0.0f;
    L23:
        return r13 / r1;
    L25:
        return r12 / r1;
    L27:
        return r13 / r0;
    L29:
        return r12 / r0;
    L31:
        return (float) Math.sqrt((r8 * r8) - (r4 * r4));
    L33:
        return r4 / r8;
    }

    private void insertKey(MotionPaths r4) {
        int r0 = Collections.binarySearch(this.mMotionPaths, r4);
        if (r0 != 0) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, " KeyPath position \"" + r4.mPosition + "\" outside of range");
    L5:
        this.mMotionPaths.add((-r0) - 1, r4);
    }

    void addKeys(ArrayList<Key> r1) {
        this.mKeyList.addAll(r1);
    }

    public void addKey(Key r1) {
        this.mKeyList.add(r1);
    }

    public void setPathMotionArc(int r1) {
        this.mPathMotionArc = r1;
    }

    public void setup(int r17, int r18, float r19, long r20) {
        new HashSet();
        HashSet<String> r1 = new HashSet();
        HashSet<String> r2 = new HashSet();
        HashSet<String> r3 = new HashSet();
        HashMap<String, Integer> r4 = new HashMap();
        if (this.mPathMotionArc == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
    L5:
        this.mStartPoint.different(this.mEndPoint, r2);
        ArrayList<Key> r5 = this.mKeyList;
        if (r5 == null) goto L27;
        Iterator<Key> r6 = r5.iterator();
        ArrayList r7 = null;
    L9:
        if (r6.hasNext() == false) goto L28;
        Key r8 = r6.next();
        if ((r8 instanceof KeyPosition) == true) goto L12;
        if ((r8 instanceof KeyCycle) == true) goto L17;
        if ((r8 instanceof KeyTimeCycle) == true) goto L20;
        if ((r8 instanceof KeyTrigger) == true) goto L23;
        r8.setInterpolation(r4);
        r8.getAttributeNames(r2);
        goto L9
    L23:
        if (r7 != null) goto L25;
        r7 = new ArrayList();
    L25:
        r7.add((KeyTrigger) r8);
        goto L9
    L20:
        r8.getAttributeNames(r1);
        goto L9
    L17:
        r8.getAttributeNames(r3);
        goto L9
    L12:
        KeyPosition r9 = (KeyPosition) r8;
        insertKey(new MotionPaths(r17, r18, r9, this.mStartMotionPath, this.mEndMotionPath));
        if (r9.mCurveFit == Key.UNSET) goto L9;
        this.mCurveFitType = r9.mCurveFit;
    L28:
        int r10 = 0;
        if (r7 == null) goto L32;
        this.mKeyTriggers = (KeyTrigger[]) r7.toArray(new KeyTrigger[0]);
    L32:
        if (r2.isEmpty() == true) goto L73;
        this.mAttributesMap = new HashMap();
        Iterator<String> r11 = r2.iterator();
    L35:
        if (r11.hasNext() == false) goto L52;
        String r12 = r11.next();
        if (r12.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r13 = new SparseArray();
        String r14 = r12.split(SimContactsConstants.EMAIL_SEP)[1];
        Iterator<Key> r15 = this.mKeyList.iterator();
    L40:
        if (r15.hasNext() == false) goto L47;
        Key r16 = r15.next();
        if (r16.mCustomConstraints == null) goto L40;
        ConstraintAttribute r21 = r16.mCustomConstraints.get(r14);
        if (r21 == null) goto L40;
        r13.append(r16.mFramePosition, r21);
        goto L40
    L47:
        ViewSpline r22 = ViewSpline.makeCustomSpline(r12, r13);
    L49:
        if (r22 == null) goto L35;
        r22.setType(r12);
        this.mAttributesMap.put(r12, r22);
        goto L35
    L48:
        r22 = ViewSpline.makeSpline(r12);
        goto L49
    L52:
        ArrayList<Key> r23 = this.mKeyList;
        if (r23 == null) goto L60;
        Iterator<Key> r24 = r23.iterator();
    L56:
        if (r24.hasNext() == false) goto L60;
        Key r25 = r24.next();
        if ((r25 instanceof KeyAttributes) == false) goto L56;
        r25.addValues(this.mAttributesMap);
    L60:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r26 = this.mAttributesMap.keySet().iterator();
    L62:
        if (r26.hasNext() == false) goto L73;
        String r27 = r26.next();
        if (r4.containsKey(r27) == false) goto L68;
        Integer r110 = r4.get(r27);
        if (r110 == null) goto L68;
        int r111 = r110.intValue();
    L69:
        ViewSpline r28 = this.mAttributesMap.get(r27);
        if (r28 == null) goto L62;
        r28.setup(r111);
    L68:
        r111 = 0;
    L73:
        if (r1.isEmpty() == false) goto L75;
    L115:
        int r29 = 2;
        int r30 = this.mMotionPaths.size() + 2;
        MotionPaths[] r31 = new MotionPaths[r30];
        r31[0] = this.mStartMotionPath;
        r31[r30 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L118;
    L120:
        Iterator<MotionPaths> r32 = this.mMotionPaths.iterator();
        int r33 = 1;
    L122:
        if (r32.hasNext() == false) goto L124;
        r31[r33] = r32.next();
        r33 = r33 + 1;
        goto L122
    L124:
        HashSet r34 = new HashSet();
        Iterator<String> r35 = this.mEndMotionPath.mAttributes.keySet().iterator();
    L126:
        if (r35.hasNext() == false) goto L132;
        String r112 = r35.next();
        if (this.mStartMotionPath.mAttributes.containsKey(r112) == false) goto L126;
        if (r2.contains("CUSTOM," + r112) == true) goto L126;
        r34.add(r112);
        goto L126
    L132:
        String[] r36 = (String[]) r34.toArray(new String[0]);
        this.mAttributeNames = r36;
        this.mAttributeInterpolatorCount = new int[r36.length];
        int r37 = 0;
    L133:
        String[] r38 = this.mAttributeNames;
        if (r37 >= r38.length) goto L145;
        String r39 = r38[r37];
        this.mAttributeInterpolatorCount[r37] = 0;
        int r40 = 0;
    L136:
        if (r40 >= r30) goto L143;
        if (r31[r40].mAttributes.containsKey(r39) == false) goto L142;
        ConstraintAttribute r41 = r31[r40].mAttributes.get(r39);
        if (r41 == null) goto L142;
        int[] r42 = this.mAttributeInterpolatorCount;
        r42[r37] = r42[r37] + r41.numberOfInterpolatedValues();
    L142:
        r40 = r40 + 1;
    L143:
        r37 = r37 + 1;
        goto L133
    L145:
        if (r31[0].mPathMotionArc == Key.UNSET) goto L147;
        boolean r43 = true;
    L148:
        int r44 = 18 + this.mAttributeNames.length;
        boolean[] r45 = new boolean[r44];
        int r46 = 1;
    L149:
        if (r46 >= r30) goto L151;
        r31[r46].different(r31[r46 - 1], r45, this.mAttributeNames, r43);
        r46 = r46 + 1;
        goto L149
    L151:
        int r47 = 0;
        int r48 = 1;
    L152:
        if (r48 >= r44) goto L157;
        if (r45[r48] == false) goto L156;
        r47 = r47 + 1;
    L156:
        r48 = r48 + 1;
        goto L152
    L157:
        this.mInterpolateVariables = new int[r47];
        int r49 = Math.max(2, r47);
        this.mInterpolateData = new double[r49];
        this.mInterpolateVelocity = new double[r49];
        int r50 = 0;
        int r51 = 1;
    L158:
        if (r51 >= r44) goto L163;
        if (r45[r51] == false) goto L162;
        this.mInterpolateVariables[r50] = r51;
        r50 = r50 + 1;
    L162:
        r51 = r51 + 1;
        goto L158
    L163:
        double[][] r52 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r30, this.mInterpolateVariables.length});
        double[] r53 = new double[r30];
        int r54 = 0;
    L164:
        if (r54 >= r30) goto L166;
        r31[r54].fillStandard(r52[r54], this.mInterpolateVariables);
        r53[r54] = r31[r54].mTime;
        r54 = r54 + 1;
        goto L164
    L166:
        int r55 = 0;
    L167:
        int[] r56 = this.mInterpolateVariables;
        if (r55 >= r56.length) goto L175;
        if (r56[r55] >= MotionPaths.sNames.length) goto L174;
        String r57 = MotionPaths.sNames[this.mInterpolateVariables[r55]] + " [";
        int r113 = 0;
    L172:
        if (r113 >= r30) goto L174;
        r57 = r57 + r52[r113][r55];
        r113 = r113 + 1;
    L174:
        r55 = r55 + 1;
        goto L167
    L175:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r58 = 0;
    L176:
        String[] r59 = this.mAttributeNames;
        if (r58 >= r59.length) goto L187;
        String r60 = r59[r58];
        int r114 = r10;
        int r115 = r114;
        double[] r116 = null;
        double[][] r117 = null;
    L179:
        if (r114 >= r30) goto L186;
        if (r31[r114].hasCustomData(r60) == false) goto L185;
        if (r117 != null) goto L184;
        r116 = new double[r30];
        int[] r118 = new int[r29];
        r118[1] = r31[r114].getCustomDataCount(r60);
        r118[r10] = r30;
        r117 = (double[][]) Array.newInstance(Double.TYPE, r118);
    L184:
        r116[r115] = r31[r114].mTime;
        r31[r114].getCustomData(r60, r117[r115], 0);
        r115 = r115 + 1;
    L185:
        r114 = r114 + 1;
        r29 = 2;
        r10 = 0;
        goto L179
    L186:
        r58 = r58 + 1;
        this.mSpline[r58] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r116, r115), (double[][]) Arrays.copyOf(r117, r115));
        r29 = 2;
        r10 = 0;
        goto L176
    L187:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r53, r52);
        if (r31[0].mPathMotionArc == Key.UNSET) goto L193;
        int[] r61 = new int[r30];
        double[] r62 = new double[r30];
        double[][] r63 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r30, 2});
        int r119 = 0;
    L190:
        if (r119 >= r30) goto L192;
        r61[r119] = r31[r119].mPathMotionArc;
        r62[r119] = r31[r119].mTime;
        r63[r119][0] = r31[r119].mX;
        r63[r119][1] = r31[r119].mY;
        r119 = r119 + 1;
        goto L190
    L192:
        this.mArcSpline = CurveFit.getArc(r61, r62, r63);
    L193:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L217;
        Iterator<String> r64 = r3.iterator();
        float r65 = Float.NaN;
    L197:
        if (r64.hasNext() == false) goto L207;
        String r66 = r64.next();
        ViewOscillator r67 = ViewOscillator.makeSpline(r66);
        if (r67 == null) goto L197;
        if (r67.variesByPath() == true) goto L204;
    L206:
        r67.setType(r66);
        this.mCycleMap.put(r66, r67);
        goto L197
    L204:
        if (Float.isNaN(r65) == false) goto L206;
        r65 = getPreCycleDistance();
        goto L206
    L207:
        Iterator<Key> r68 = this.mKeyList.iterator();
    L209:
        if (r68.hasNext() == false) goto L213;
        Key r69 = r68.next();
        if ((r69 instanceof KeyCycle) == false) goto L209;
        ((KeyCycle) r69).addCycleValues(this.mCycleMap);
        goto L209
    L213:
        Iterator<ViewOscillator> r0 = this.mCycleMap.values().iterator();
    L215:
        if (r0.hasNext() == false) goto L320;
        r0.next().setup(r65);
        goto L215
    L320:
        return;
    L217:
        return;
    L147:
        r43 = false;
        goto L148
    L118:
        if (this.mCurveFitType != (-1)) goto L120;
        this.mCurveFitType = 0;
        goto L120
    L75:
        if (this.mTimeCycleAttributesMap != null) goto L77;
        this.mTimeCycleAttributesMap = new HashMap();
    L77:
        Iterator<String> r70 = r1.iterator();
    L79:
        if (r70.hasNext() == false) goto L99;
        String r71 = r70.next();
        if (this.mTimeCycleAttributesMap.containsKey(r71) == true) goto L79;
        if (r71.startsWith("CUSTOM,") == false) goto L95;
        SparseArray r72 = new SparseArray();
        String r120 = r71.split(SimContactsConstants.EMAIL_SEP)[1];
        Iterator<Key> r121 = this.mKeyList.iterator();
    L87:
        if (r121.hasNext() == false) goto L94;
        Key r122 = r121.next();
        if (r122.mCustomConstraints == null) goto L87;
        ConstraintAttribute r123 = r122.mCustomConstraints.get(r120);
        if (r123 == null) goto L87;
        r72.append(r122.mFramePosition, r123);
        goto L87
    L94:
        ViewTimeCycle r73 = ViewTimeCycle.makeCustomSpline(r71, r72);
    L96:
        if (r73 == null) goto L79;
        r73.setType(r71);
        this.mTimeCycleAttributesMap.put(r71, r73);
        goto L79
    L95:
        r73 = ViewTimeCycle.makeSpline(r71, r20);
        goto L96
    L99:
        ArrayList<Key> r74 = this.mKeyList;
        if (r74 == null) goto L107;
        Iterator<Key> r75 = r74.iterator();
    L103:
        if (r75.hasNext() == false) goto L107;
        Key r76 = r75.next();
        if ((r76 instanceof KeyTimeCycle) == false) goto L103;
        ((KeyTimeCycle) r76).addTimeValues(this.mTimeCycleAttributesMap);
    L107:
        Iterator<String> r77 = this.mTimeCycleAttributesMap.keySet().iterator();
    L109:
        if (r77.hasNext() == false) goto L115;
        String r78 = r77.next();
        if (r4.containsKey(r78) == false) goto L113;
        int r79 = r4.get(r78).intValue();
    L114:
        this.mTimeCycleAttributesMap.get(r78).setup(r79);
        goto L109
    L113:
        r79 = 0;
        goto L114
    L27:
        r7 = null;
        goto L28
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    private void readView(MotionPaths r4) {
        r4.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void setView(View r2) {
        this.mView = r2;
        this.mId = r2.getId();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) r3).getConstraintTag();
        return;
    }

    public View getView() {
        return this.mView;
    }

    void setStartCurrentState(View r6) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
    }

    public void setStartState(ViewState r5, View r6, int r7, int r8, int r9) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        Rect r0 = new Rect();
        if (r7 == 1) goto L7;
        if (r7 != 2) goto L8;
        int r10 = r5.left + r5.right;
        r0.left = r9 - (((r5.top + r5.bottom) + r5.width()) / 2);
        r0.top = (r10 - r5.height()) / 2;
        r0.right = r0.left + r5.width();
        r0.bottom = r0.top + r5.height();
    L8:
        this.mStartMotionPath.setBounds(r0.left, r0.top, r0.width(), r0.height());
        this.mStartPoint.setState(r0, r6, r7, r5.rotation);
        return;
    L7:
        int r11 = r5.left + r5.right;
        r0.left = ((r5.top + r5.bottom) - r5.width()) / 2;
        r0.top = r8 - ((r11 + r5.height()) / 2);
        r0.right = r0.left + r5.width();
        r0.bottom = r0.top + r5.height();
        goto L8
    }

    void rotate(Rect r2, Rect r3, int r4, int r5, int r6) {
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L6;
        int r1 = r2.left + r2.right;
        r3.left = r5 - (((r2.top + r2.bottom) + r2.width()) / 2);
        r3.top = (r1 - r2.height()) / 2;
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L6:
        if (r4 != 3) goto L8;
        int r7 = r2.left + r2.right;
        int r8 = r2.top;
        int r9 = r2.bottom;
        r3.left = ((r2.height() / 2) + r2.top) - (r7 / 2);
        r3.top = r6 - ((r7 + r2.height()) / 2);
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L8:
        if (r4 != 4) goto L18;
        int r10 = r2.left + r2.right;
        r3.left = r5 - (((r2.bottom + r2.top) + r2.width()) / 2);
        r3.top = (r10 - r2.height()) / 2;
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L18:
        return;
    L13:
        int r11 = r2.left + r2.right;
        r3.left = ((r2.top + r2.bottom) - r2.width()) / 2;
        r3.top = r6 - ((r11 + r2.height()) / 2);
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
    }

    void setStartState(Rect r8, ConstraintSet r9, int r10, int r11) {
        int r6 = r9.mRotate;
        if (r6 == 0) goto L5;
        rotate(r8, this.mTempRect, r6, r10, r11);
    L5:
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(r8.left, r8.top, r8.width(), r8.height());
        ConstraintSet.Constraint r12 = r9.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r12);
        this.mMotionStagger = r12.motion.mMotionStagger;
        this.mStartPoint.setState(r8, r9, r6, this.mId);
        this.mTransformPivotTarget = r12.transform.transformPivotTarget;
        this.mQuantizeMotionSteps = r12.motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = r12.motion.mQuantizeMotionPhase;
        this.mQuantizeMotionInterpolator = getInterpolator(this.mView.getContext(), r12.motion.mQuantizeInterpolatorType, r12.motion.mQuantizeInterpolatorString, r12.motion.mQuantizeInterpolatorID);
    }

    private static Interpolator getInterpolator(Context r1, int r2, String r3, int r4) {
        if (r2 == (-2)) goto L30;
        if (r2 == (-1)) goto L27;
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L24;
        if (r2 == 2) goto L22;
        if (r2 == 4) goto L20;
        if (r2 == 5) goto L18;
        return null;
    L18:
        return new OvershootInterpolator();
    L20:
        return new BounceInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final Easing r5 = Easing.getInterpolator(r3);
        return new AnonymousClass1(r5);
    L30:
        return AnimationUtils.loadInterpolator(r1, r4);
    }

    void setEndState(Rect r8, ConstraintSet r9, int r10, int r11) {
        int r6 = r9.mRotate;
        if (r6 == 0) goto L5;
        rotate(r8, this.mTempRect, r6, r10, r11);
        r8 = this.mTempRect;
    L5:
        this.mEndMotionPath.mTime = 1.0f;
        this.mEndMotionPath.mPosition = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(r8.left, r8.top, r8.width(), r8.height());
        this.mEndMotionPath.applyParameters(r9.getParameters(this.mId));
        this.mEndPoint.setState(r8, r9, r6, this.mId);
    }

    void setBothStates(View r6) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mNoMovement = true;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
        this.mEndPoint.setState(r6);
    }

    private float getAdjustedPosition(float r12, float[] r13) {
        float r0 = 0.0f;
        float r2 = 1.0f;
        if (r13 == null) goto L5;
        r13[0] = 1.0f;
    L15:
        Easing r3 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r11 = this.mMotionPaths.iterator();
        float r4 = Float.NaN;
    L17:
        if (r11.hasNext() == false) goto L26;
        MotionPaths r5 = r11.next();
        if (r5.mKeyFrameEasing == null) goto L17;
        if (r5.mTime < r12) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.mTime;
        goto L17
    L22:
        r3 = r5.mKeyFrameEasing;
        r0 = r5.mTime;
        goto L17
    L26:
        if (r3 != null) goto L28;
        return r12;
    L28:
        if (Float.isNaN(r4) == true) goto L31;
        r2 = r4;
    L31:
        float r6 = r2 - r0;
        double r14 = (r12 - r0) / r6;
        float r1 = r0 + (((float) r3.get(r14)) * r6);
        if (r13 == null) goto L35;
        r13[0] = (float) r3.getDiff(r14);
    L35:
        return r1;
    L5:
        float r7 = this.mStaggerScale;
        if (r7 == 1.0d) goto L15;
        float r8 = this.mStaggerOffset;
        if (r12 >= r8) goto L11;
        r12 = 0.0f;
    L11:
        if (r12 <= r8) goto L15;
        if (r12 >= 1.0d) goto L15;
        r12 = Math.min((r12 - r8) * r7, 1.0f);
        goto L15
    }

    void endTrigger(boolean r5) {
        if ("button".equals(Debug.getName(this.mView)) == true) goto L5;
        return;
    L5:
        if (this.mKeyTriggers == null) goto L18;
        int r0 = 0;
    L7:
        KeyTrigger[] r1 = this.mKeyTriggers;
        if (r0 >= r1.length) goto L19;
        KeyTrigger r2 = r1[r0];
        if (r5 == false) goto L12;
        float r3 = -100.0f;
    L13:
        r2.conditionallyFire(r3, this.mView);
        r0 = r0 + 1;
        goto L7
    L12:
        r3 = 100.0f;
        goto L13
    L19:
        return;
    }

    boolean interpolate(View r21, float r22, long r23, KeyCache r25) {
        float r2 = getAdjustedPosition(r22, null);
        if (this.mQuantizeMotionSteps == Key.UNSET) goto L15;
        float r3 = 1.0f / this.mQuantizeMotionSteps;
        float r4 = ((float) Math.floor(r2 / r3)) * r3;
        float r5 = (r2 % r3) / r3;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r5 = (r5 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        Interpolator r6 = this.mQuantizeMotionInterpolator;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r2 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r14 = r2;
        HashMap<String, ViewSpline> r8 = this.mAttributesMap;
        if (r8 == null) goto L21;
        Iterator<ViewSpline> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r9.next().setProperty(r21, r14);
    L21:
        HashMap<String, ViewTimeCycle> r10 = this.mTimeCycleAttributesMap;
        if (r10 == null) goto L31;
        Iterator<ViewTimeCycle> r11 = r10.values().iterator();
        ViewTimeCycle.PathRotate r12 = null;
        boolean r13 = false;
    L25:
        if (r11.hasNext() == false) goto L30;
        ViewTimeCycle r1 = r11.next();
        if ((r1 instanceof ViewTimeCycle.PathRotate) == true) goto L28;
        r13 = r13 | r1.setProperty(r21, r14, r23, r25);
        goto L25
    L28:
        r12 = (ViewTimeCycle.PathRotate) r1;
        goto L25
    L30:
        boolean r16 = r13;
        ViewTimeCycle.PathRotate r15 = r12;
    L32:
        CurveFit[] r17 = this.mSpline;
        int r18 = 1;
        if (r17 == null) goto L89;
        double r19 = r14;
        r17[0].getPos(r19, this.mInterpolateData);
        this.mSpline[0].getSlope(r19, this.mInterpolateVelocity);
        CurveFit r20 = this.mArcSpline;
        if (r20 == null) goto L40;
        double[] r24 = this.mInterpolateData;
        if (r24.length <= 0) goto L40;
        r20.getPos(r19, r24);
        this.mArcSpline.getSlope(r19, this.mInterpolateVelocity);
    L40:
        if (this.mNoMovement == true) goto L44;
        this.mStartMotionPath.setView(r14, r21, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
        this.mForceMeasure = false;
    L44:
        if (this.mTransformPivotTarget != Key.UNSET) goto L46;
    L55:
        HashMap<String, ViewSpline> r26 = this.mAttributesMap;
        if (r26 == null) goto L65;
        Iterator<ViewSpline> r27 = r26.values().iterator();
    L59:
        if (r27.hasNext() == false) goto L65;
        ViewSpline r28 = r27.next();
        if ((r28 instanceof ViewSpline.PathRotate) == false) goto L59;
        double[] r29 = this.mInterpolateVelocity;
        if (r29.length <= 1) goto L59;
        ((ViewSpline.PathRotate) r28).setPathRotate(r21, r14, r29[0], r29[1]);
    L65:
        if (r15 == null) goto L68;
        double[] r30 = this.mInterpolateVelocity;
        r16 = r16 | r15.setPathRotate(r21, r25, r14, r23, r30[0], r30[1]);
    L68:
        int r110 = r18;
    L69:
        CurveFit[] r31 = this.mSpline;
        if (r110 >= r31.length) goto L73;
        r31[r110].getPos(r19, this.mValuesBuff);
        CustomSupport.setInterpolatedValue(this.mStartMotionPath.mAttributes.get(this.mAttributeNames[r110 - 1]), r21, this.mValuesBuff);
        r110 = r110 + 1;
        goto L69
    L73:
        if (this.mStartPoint.mVisibilityMode != 0) goto L84;
        if (r14 > 0.0f) goto L78;
        r21.setVisibility(this.mStartPoint.mVisibility);
        goto L84
    L78:
        if (r14 < 1.0f) goto L81;
        r21.setVisibility(this.mEndPoint.mVisibility);
        goto L84
    L81:
        if (this.mEndPoint.mVisibility == this.mStartPoint.mVisibility) goto L84;
        r21.setVisibility(0);
    L84:
        if (this.mKeyTriggers == null) goto L97;
        int r32 = 0;
    L86:
        KeyTrigger[] r33 = this.mKeyTriggers;
        if (r32 >= r33.length) goto L97;
        r33[r32].conditionallyFire(r14, r21);
        r32 = r32 + 1;
    L97:
        HashMap<String, ViewOscillator> r34 = this.mCycleMap;
        if (r34 == null) goto L106;
        Iterator<ViewOscillator> r35 = r34.values().iterator();
    L101:
        if (r35.hasNext() == false) goto L106;
        ViewOscillator r36 = r35.next();
        if ((r36 instanceof ViewOscillator.PathRotateSet) == true) goto L104;
        r36.setProperty(r21, r14);
        goto L101
    L104:
        double[] r37 = this.mInterpolateVelocity;
        ((ViewOscillator.PathRotateSet) r36).setPathRotate(r21, r14, r37[0], r37[r18]);
    L106:
        return r16;
    L46:
        if (this.mTransformPivotView != null) goto L48;
        this.mTransformPivotView = ((View) r21.getParent()).findViewById(this.mTransformPivotTarget);
    L48:
        View r38 = this.mTransformPivotView;
        if (r38 == null) goto L55;
        float r39 = (r38.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r40 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r41 = r40 - r21.getLeft();
        float r42 = r39 - r21.getTop();
        r21.setPivotX(r41);
        r21.setPivotY(r42);
        goto L55
    L89:
        r18 = 1;
        float r43 = this.mStartMotionPath.mX + ((this.mEndMotionPath.mX - this.mStartMotionPath.mX) * r14);
        float r44 = this.mStartMotionPath.mY + ((this.mEndMotionPath.mY - this.mStartMotionPath.mY) * r14);
        float r45 = this.mStartMotionPath.mWidth + ((this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) * r14);
        float r46 = r43 + 0.5f;
        int r47 = (int) r46;
        float r48 = r44 + 0.5f;
        int r49 = (int) r48;
        int r50 = (int) (r46 + r45);
        int r51 = (int) (r48 + (this.mStartMotionPath.mHeight + ((this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) * r14)));
        int r52 = r50 - r47;
        int r53 = r51 - r49;
        if (this.mEndMotionPath.mWidth == this.mStartMotionPath.mWidth) goto L92;
    L95:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r52, 1073741824), View.MeasureSpec.makeMeasureSpec(r53, 1073741824));
        this.mForceMeasure = false;
    L96:
        r21.layout(r47, r49, r50, r51);
        goto L97
    L92:
        if (this.mEndMotionPath.mHeight != this.mStartMotionPath.mHeight) goto L95;
        if (this.mForceMeasure == false) goto L96;
    L31:
        r15 = null;
        r16 = false;
        goto L32
    }

    void getDpDt(float r12, float r13, float r14, float[] r15) {
        float r16 = getAdjustedPosition(r12, this.mVelocity);
        CurveFit[] r0 = this.mSpline;
        int r1 = 0;
        if (r0 == null) goto L16;
        double r2 = r16;
        r0[0].getSlope(r2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r2, this.mInterpolateData);
        float r17 = this.mVelocity[0];
    L5:
        double[] r9 = this.mInterpolateVelocity;
        if (r1 >= r9.length) goto L8;
        r9[r1] = r9[r1] * ((double) r17);
        r1 = r1 + 1;
        goto L5
    L8:
        CurveFit r18 = this.mArcSpline;
        if (r18 == null) goto L14;
        double[] r3 = this.mInterpolateData;
        if (r3.length <= 0) goto L19;
        r18.getPos(r2, r3);
        this.mArcSpline.getSlope(r2, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, r9, this.mInterpolateData);
        return;
    L16:
        float r19 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float r4 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        float r5 = (this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) + r19;
        float r6 = (this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) + r4;
        r15[0] = (r19 * (1.0f - r13)) + (r5 * r13);
        r15[1] = (r4 * (1.0f - r14)) + (r6 * r14);
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, ViewSpline> r2 = this.mAttributesMap;
        ViewOscillator r4 = null;
        if (r2 != null) goto L5;
        ViewSpline r3 = null;
    L6:
        HashMap<String, ViewSpline> r5 = this.mAttributesMap;
        if (r5 != null) goto L9;
        ViewSpline r6 = null;
    L10:
        HashMap<String, ViewSpline> r7 = this.mAttributesMap;
        if (r7 != null) goto L13;
        ViewSpline r8 = null;
    L14:
        HashMap<String, ViewSpline> r9 = this.mAttributesMap;
        if (r9 != null) goto L17;
        ViewSpline r10 = null;
    L18:
        HashMap<String, ViewSpline> r11 = this.mAttributesMap;
        if (r11 != null) goto L21;
        ViewSpline r12 = null;
    L22:
        HashMap<String, ViewOscillator> r13 = this.mCycleMap;
        if (r13 != null) goto L25;
        ViewOscillator r14 = null;
    L26:
        HashMap<String, ViewOscillator> r15 = this.mCycleMap;
        if (r15 != null) goto L29;
        ViewOscillator r16 = null;
    L30:
        HashMap<String, ViewOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L33;
        ViewOscillator r18 = null;
    L34:
        HashMap<String, ViewOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L37;
        ViewOscillator r111 = null;
    L38:
        HashMap<String, ViewOscillator> r112 = this.mCycleMap;
        if (r112 == null) goto L42;
        r4 = r112.get("scaleY");
    L42:
        VelocityMatrix r113 = new VelocityMatrix();
        r113.clear();
        r113.setRotationVelocity(r8, r1);
        r113.setTranslationVelocity(r3, r6, r1);
        r113.setScaleVelocity(r10, r12, r1);
        r113.setRotationVelocity(r18, r1);
        r113.setTranslationVelocity(r14, r16, r1);
        r113.setScaleVelocity(r111, r4, r1);
        CurveFit r114 = this.mArcSpline;
        if (r114 == null) goto L49;
        double[] r25 = this.mInterpolateData;
        if (r25.length <= 0) goto L47;
        double r26 = r1;
        r114.getPos(r26, r25);
        this.mArcSpline.getSlope(r26, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L49:
        int r115 = 0;
        if (this.mSpline == null) goto L57;
        double r27 = getAdjustedPosition(r1, this.mVelocity);
        this.mSpline[0].getSlope(r27, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r27, this.mInterpolateData);
        float r28 = this.mVelocity[0];
    L52:
        double[] r29 = this.mInterpolateVelocity;
        if (r115 >= r29.length) goto L55;
        r29[r115] = r29[r115] * ((double) r28);
        r115 = r115 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, r29, this.mInterpolateData);
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L57:
        float r116 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float r117 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        ViewOscillator r118 = r4;
        float r119 = (this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) + r116;
        float r30 = (this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) + r117;
        r24[0] = (r116 * (1.0f - r22)) + (r119 * r22);
        r24[1] = (r117 * (1.0f - r23)) + (r30 * r23);
        r113.clear();
        r113.setRotationVelocity(r8, r1);
        r113.setTranslationVelocity(r3, r6, r1);
        r113.setScaleVelocity(r10, r12, r1);
        r113.setRotationVelocity(r18, r1);
        r113.setTranslationVelocity(r14, r16, r1);
        r113.setScaleVelocity(r111, r118, r1);
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L37:
        r111 = r110.get("scaleX");
        goto L38
    L33:
        r18 = r17.get("rotation");
        goto L34
    L29:
        r16 = r15.get("translationY");
        goto L30
    L25:
        r14 = r13.get("translationX");
        goto L26
    L21:
        r12 = r11.get("scaleY");
        goto L22
    L17:
        r10 = r9.get("scaleX");
        goto L18
    L13:
        r8 = r7.get("rotation");
        goto L14
    L9:
        r6 = r5.get("translationY");
        goto L10
    L5:
        r3 = r2.get("translationX");
        goto L6
    }

    public int getDrawPath() {
        int r0 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> r1 = this.mMotionPaths.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = Math.max(r0, r1.next().mDrawPath);
        goto L4
    L7:
        return Math.max(r0, this.mEndMotionPath.mDrawPath);
    }

    public void setDrawPath(int r1) {
        this.mStartMotionPath.mDrawPath = r1;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View r9, KeyPositionBase r10, float r11, float r12, String[] r13, float[] r14) {
        RectF r2 = new RectF();
        r2.left = this.mStartMotionPath.mX;
        r2.top = this.mStartMotionPath.mY;
        r2.right = r2.left + this.mStartMotionPath.mWidth;
        r2.bottom = r2.top + this.mStartMotionPath.mHeight;
        RectF r3 = new RectF();
        r3.left = this.mEndMotionPath.mX;
        r3.top = this.mEndMotionPath.mY;
        r3.right = r3.left + this.mEndMotionPath.mWidth;
        r3.bottom = r3.top + this.mEndMotionPath.mHeight;
        r10.positionAttributes(r9, r2, r3, r11, r12, r13, r14);
    }

    public int getKeyFramePositions(int[] r13, float[] r14) {
        Iterator<Key> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        Key r3 = r0.next();
        int r11 = r2 + 1;
        r13[r2] = r3.mFramePosition + (r3.mType * 1000);
        double r4 = r3.mFramePosition / 100.0f;
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r4, this.mInterpolateVariables, this.mInterpolateData, r14, r10);
        r10 = r10 + 2;
        r2 = r11;
        goto L4
    L6:
        return r2;
    }

    public int getKeyFrameInfo(int r18, int[] r19) {
        float[] r2 = new float[2];
        Iterator<Key> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        Key r14 = r10.next();
        if (r14.mType == r18) goto L10;
        if (r18 == (-1)) goto L4;
    L10:
        r19[r13] = 0;
        int r3 = r13 + 1;
        r19[r3] = r14.mType;
        int r16 = r3 + 1;
        r19[r16] = r14.mFramePosition;
        double r5 = r14.mFramePosition / 100.0f;
        this.mSpline[0].getPos(r5, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r5, this.mInterpolateVariables, this.mInterpolateData, r2, 0);
        int r17 = r16 + 1;
        r19[r17] = Float.floatToIntBits(r2[0]);
        int r110 = r17 + 1;
        r19[r110] = Float.floatToIntBits(r2[1]);
        if ((r14 instanceof KeyPosition) == false) goto L13;
        KeyPosition r15 = (KeyPosition) r14;
        int r111 = r110 + 1;
        r19[r111] = r15.mPositionType;
        int r112 = r111 + 1;
        r19[r112] = Float.floatToIntBits(r15.mPercentX);
        r110 = r112 + 1;
        r19[r110] = Float.floatToIntBits(r15.mPercentY);
    L13:
        int r113 = r110 + 1;
        r19[r13] = r113 - r13;
        r12 = r12 + 1;
        r13 = r113;
        goto L4
    L14:
        return r12;
    }
}
