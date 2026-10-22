package com.obric.oui.constraintlayout.core.motion;

import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.constraintlayout.core.motion.key.MotionKey;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyAttributes;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyCycle;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyPosition;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import com.obric.oui.constraintlayout.core.motion.key.MotionKeyTrigger;
import com.obric.oui.constraintlayout.core.motion.utils.CurveFit;
import com.obric.oui.constraintlayout.core.motion.utils.DifferentialInterpolator;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.core.motion.utils.FloatRect;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCache;
import com.obric.oui.constraintlayout.core.motion.utils.KeyCycleOscillator;
import com.obric.oui.constraintlayout.core.motion.utils.KeyFrameArray;
import com.obric.oui.constraintlayout.core.motion.utils.Rect;
import com.obric.oui.constraintlayout.core.motion.utils.SplineSet;
import com.obric.oui.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import com.obric.oui.constraintlayout.core.motion.utils.TypedBundle;
import com.obric.oui.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.constraintlayout.core.motion.utils.Utils;
import com.obric.oui.constraintlayout.core.motion.utils.VelocityMatrix;
import com.obric.oui.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Motion implements TypedValues {
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
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    public String mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList;
    private MotionKeyTrigger[] mKeyTriggers;
    private int mMaxDimension;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private DifferentialInterpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    Motion mRelativeMotion;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    Rect mTempRect;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private MotionWidget mTransformPivotView;
    private float[] mValuesBuff;
    private float[] mVelocity;
    MotionWidget mView;

    void endTrigger(boolean r1) {
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public void setTransformPivotTarget(int r1) {
        this.mTransformPivotTarget = r1;
        this.mTransformPivotView = null;
    }

    public MotionPaths getKeyFrame(int r1) {
        return this.mMotionPaths.get(r1);
    }

    public Motion(MotionWidget r5) {
        this.mTempRect = new Rect();
        this.mCurveFitType = 0;
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
        this.mPathMotionArc = -1;
        this.mTransformPivotTarget = -1;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = -1;
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

    public String getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public void setupRelative(Motion r1) {
        this.mRelativeMotion = r1;
    }

    private void setupRelative() {
        Motion r0 = this.mRelativeMotion;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mStartMotionPath.setupRelative(r0, r0.mStartMotionPath);
        MotionPaths r1 = this.mEndMotionPath;
        Motion r3 = this.mRelativeMotion;
        r1.setupRelative(r3, r3.mEndMotionPath);
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

    public void buildPath(float[] r19, int r20) {
        float r9 = 1.0f;
        float r10 = 1.0f / (r20 - 1);
        HashMap<String, SplineSet> r1 = this.mAttributesMap;
        KeyCycleOscillator r3 = null;
        if (r1 != null) goto L5;
        SplineSet r11 = null;
    L6:
        HashMap<String, SplineSet> r2 = this.mAttributesMap;
        if (r2 != null) goto L9;
        SplineSet r12 = null;
    L10:
        HashMap<String, KeyCycleOscillator> r4 = this.mCycleMap;
        if (r4 != null) goto L13;
        KeyCycleOscillator r13 = null;
    L14:
        HashMap<String, KeyCycleOscillator> r5 = this.mCycleMap;
        if (r5 == null) goto L18;
        r3 = r5.get("translationY");
    L18:
        KeyCycleOscillator r14 = r3;
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
        HashMap<String, SplineSet> r4 = this.mAttributesMap;
        if (r4 == null) goto L6;
        SplineSet r5 = r4.get("translationX");
    L6:
        HashMap<String, SplineSet> r6 = this.mAttributesMap;
        if (r6 == null) goto L10;
        SplineSet r7 = r6.get("translationY");
    L10:
        HashMap<String, KeyCycleOscillator> r8 = this.mCycleMap;
        if (r8 == null) goto L14;
        KeyCycleOscillator r9 = r8.get("translationX");
    L14:
        HashMap<String, KeyCycleOscillator> r10 = this.mCycleMap;
        if (r10 == null) goto L18;
        KeyCycleOscillator r11 = r10.get("translationY");
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

    MotionKeyPosition getPositionKeyframe(int r11, int r12, float r13, float r14) {
        FloatRect r7 = new FloatRect();
        r7.left = this.mStartMotionPath.mX;
        r7.top = this.mStartMotionPath.mY;
        r7.right = r7.left + this.mStartMotionPath.mWidth;
        r7.bottom = r7.top + this.mStartMotionPath.mHeight;
        FloatRect r8 = new FloatRect();
        r8.left = this.mEndMotionPath.mX;
        r8.top = this.mEndMotionPath.mY;
        r8.right = r8.left + this.mEndMotionPath.mWidth;
        r8.bottom = r8.top + this.mEndMotionPath.mHeight;
        Iterator<MotionKey> r10 = this.mKeyList.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        MotionKey r0 = r10.next();
        if ((r0 instanceof MotionKeyPosition) == false) goto L4;
        MotionKeyPosition r9 = (MotionKeyPosition) r0;
        if (r9.intersects(r11, r12, r7, r8, r13, r14) == false) goto L4;
        return r9;
    L10:
        return null;
    }

    public int buildKeyFrames(float[] r10, int[] r11, int[] r12) {
        if (r10 == null) goto L21;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r11[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        if (r12 == null) goto L15;
        Iterator<MotionPaths> r13 = this.mMotionPaths.iterator();
        int r4 = 0;
    L13:
        if (r13.hasNext() == false) goto L15;
        r12[r4] = (int) (r13.next().mPosition * 100.0f);
        r4 = r4 + 1;
    L15:
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r14 >= r1.length) goto L20;
        this.mSpline[0].getPos(r1[r14], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r14], this.mInterpolateVariables, this.mInterpolateData, r10, r15);
        r15 = r15 + 2;
        r14 = r14 + 1;
        goto L17
    L20:
        return r15 / 2;
    L21:
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
        SplineSet r0 = this.mAttributesMap.get(r1);
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

    public void buildRect(float r4, float[] r5, int r6) {
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

    private void insertKey(MotionPaths r6) {
        Iterator<MotionPaths> r0 = this.mMotionPaths.iterator();
        MotionPaths r1 = null;
    L4:
        if (r0.hasNext() == false) goto L8;
        MotionPaths r2 = r0.next();
        if (r6.mPosition != r2.mPosition) goto L4;
        r1 = r2;
        goto L4
    L8:
        if (r1 == null) goto L10;
        this.mMotionPaths.remove(r1);
    L10:
        int r3 = Collections.binarySearch(this.mMotionPaths, r6);
        if (r3 != 0) goto L13;
        Utils.loge(TAG, " KeyPath position \"" + r6.mPosition + "\" outside of range");
    L13:
        this.mMotionPaths.add((-r3) - 1, r6);
    }

    void addKeys(ArrayList<MotionKey> r1) {
        this.mKeyList.addAll(r1);
    }

    public void addKey(MotionKey r1) {
        this.mKeyList.add(r1);
    }

    public void setPathMotionArc(int r1) {
        this.mPathMotionArc = r1;
    }

    public void setup(int r20, int r21, float r22, long r23) {
        new HashSet();
        HashSet<String> r3 = new HashSet();
        HashSet<String> r4 = new HashSet();
        HashSet<String> r5 = new HashSet();
        HashMap<String, Integer> r6 = new HashMap();
        setupRelative();
        if (this.mPathMotionArc != (-1)) goto L5;
    L7:
        this.mStartPoint.different(this.mEndPoint, r4);
        ArrayList<MotionKey> r7 = this.mKeyList;
        if (r7 == null) goto L29;
        Iterator<MotionKey> r8 = r7.iterator();
        ArrayList r10 = null;
    L11:
        if (r8.hasNext() == false) goto L31;
        MotionKey r11 = r8.next();
        if ((r11 instanceof MotionKeyPosition) == true) goto L14;
        if ((r11 instanceof MotionKeyCycle) == true) goto L19;
        if ((r11 instanceof MotionKeyTimeCycle) == true) goto L22;
        if ((r11 instanceof MotionKeyTrigger) == true) goto L25;
        r11.setInterpolation(r6);
        r11.getAttributeNames(r4);
        goto L11
    L25:
        if (r10 != null) goto L27;
        r10 = new ArrayList();
    L27:
        r10.add((MotionKeyTrigger) r11);
        goto L11
    L22:
        r11.getAttributeNames(r3);
        goto L11
    L19:
        r11.getAttributeNames(r5);
        goto L11
    L14:
        MotionKeyPosition r12 = (MotionKeyPosition) r11;
        insertKey(new MotionPaths(r20, r21, r12, this.mStartMotionPath, this.mEndMotionPath));
        if (r12.mCurveFit == (-1)) goto L11;
        this.mCurveFitType = r12.mCurveFit;
    L31:
        if (r10 == null) goto L33;
        this.mKeyTriggers = (MotionKeyTrigger[]) r10.toArray(new MotionKeyTrigger[0]);
    L33:
        char r13 = 1;
        if (r4.isEmpty() == true) goto L76;
        this.mAttributesMap = new HashMap();
        Iterator<String> r14 = r4.iterator();
    L37:
        if (r14.hasNext() == false) goto L55;
        String r15 = r14.next();
        if (r15.startsWith("CUSTOM,") == false) goto L50;
        KeyFrameArray.CustomVar r16 = new KeyFrameArray.CustomVar();
        String r9 = r15.split(SimContactsConstants.EMAIL_SEP)[r13];
        Iterator<MotionKey> r17 = this.mKeyList.iterator();
    L42:
        if (r17.hasNext() == false) goto L49;
        MotionKey r18 = r17.next();
        if (r18.mCustom == null) goto L42;
        CustomVariable r19 = r18.mCustom.get(r9);
        if (r19 == null) goto L42;
        r16.append(r18.mFramePosition, r19);
        goto L42
    L49:
        SplineSet r24 = SplineSet.makeCustomSplineSet(r15, r16);
    L51:
        if (r24 == null) goto L54;
        r24.setType(r15);
        this.mAttributesMap.put(r15, r24);
    L54:
        r13 = 1;
        goto L37
    L50:
        r24 = SplineSet.makeSpline(r15, r23);
        goto L51
    L55:
        ArrayList<MotionKey> r25 = this.mKeyList;
        if (r25 == null) goto L63;
        Iterator<MotionKey> r26 = r25.iterator();
    L59:
        if (r26.hasNext() == false) goto L63;
        MotionKey r27 = r26.next();
        if ((r27 instanceof MotionKeyAttributes) == false) goto L59;
        r27.addValues(this.mAttributesMap);
    L63:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r28 = this.mAttributesMap.keySet().iterator();
    L65:
        if (r28.hasNext() == false) goto L76;
        String r29 = r28.next();
        if (r6.containsKey(r29) == false) goto L71;
        Integer r30 = r6.get(r29);
        if (r30 == null) goto L71;
        int r31 = r30.intValue();
    L72:
        SplineSet r32 = this.mAttributesMap.get(r29);
        if (r32 == null) goto L65;
        r32.setup(r31);
    L71:
        r31 = 0;
    L76:
        if (r3.isEmpty() == false) goto L78;
    L118:
        int r1 = this.mMotionPaths.size() + 2;
        MotionPaths[] r33 = new MotionPaths[r1];
        r33[0] = this.mStartMotionPath;
        r33[r1 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L121;
    L123:
        Iterator<MotionPaths> r34 = this.mMotionPaths.iterator();
        int r35 = 1;
    L125:
        if (r34.hasNext() == false) goto L127;
        r33[r35] = r34.next();
        r35 = r35 + 1;
        goto L125
    L127:
        HashSet r36 = new HashSet();
        Iterator<String> r37 = this.mEndMotionPath.mCustomAttributes.keySet().iterator();
    L129:
        if (r37.hasNext() == false) goto L135;
        String r38 = r37.next();
        if (this.mStartMotionPath.mCustomAttributes.containsKey(r38) == false) goto L129;
        if (r4.contains("CUSTOM," + r38) == true) goto L129;
        r36.add(r38);
        goto L129
    L135:
        String[] r39 = (String[]) r36.toArray(new String[0]);
        this.mAttributeNames = r39;
        this.mAttributeInterpolatorCount = new int[r39.length];
        int r40 = 0;
    L136:
        String[] r41 = this.mAttributeNames;
        if (r40 >= r41.length) goto L148;
        String r42 = r41[r40];
        this.mAttributeInterpolatorCount[r40] = 0;
        int r43 = 0;
    L139:
        if (r43 >= r1) goto L146;
        if (r33[r43].mCustomAttributes.containsKey(r42) == false) goto L145;
        CustomVariable r44 = r33[r43].mCustomAttributes.get(r42);
        if (r44 == null) goto L145;
        int[] r45 = this.mAttributeInterpolatorCount;
        r45[r40] = r45[r40] + r44.numberOfInterpolatedValues();
    L145:
        r43 = r43 + 1;
    L146:
        r40 = r40 + 1;
        goto L136
    L148:
        if (r33[0].mPathMotionArc == (-1)) goto L150;
        boolean r46 = true;
    L151:
        int r47 = 18 + this.mAttributeNames.length;
        boolean[] r48 = new boolean[r47];
        int r49 = 1;
    L152:
        if (r49 >= r1) goto L154;
        r33[r49].different(r33[r49 - 1], r48, this.mAttributeNames, r46);
        r49 = r49 + 1;
        goto L152
    L154:
        int r50 = 1;
        int r51 = 0;
    L155:
        if (r50 >= r47) goto L160;
        if (r48[r50] == false) goto L159;
        r51 = r51 + 1;
    L159:
        r50 = r50 + 1;
        goto L155
    L160:
        this.mInterpolateVariables = new int[r51];
        int r52 = Math.max(2, r51);
        this.mInterpolateData = new double[r52];
        this.mInterpolateVelocity = new double[r52];
        int r53 = 1;
        int r54 = 0;
    L161:
        if (r53 >= r47) goto L166;
        if (r48[r53] == false) goto L165;
        this.mInterpolateVariables[r54] = r53;
        r54 = r54 + 1;
    L165:
        r53 = r53 + 1;
        goto L161
    L166:
        double[][] r55 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, this.mInterpolateVariables.length});
        double[] r56 = new double[r1];
        int r57 = 0;
    L167:
        if (r57 >= r1) goto L169;
        r33[r57].fillStandard(r55[r57], this.mInterpolateVariables);
        r56[r57] = r33[r57].mTime;
        r57 = r57 + 1;
        goto L167
    L169:
        int r58 = 0;
    L170:
        int[] r59 = this.mInterpolateVariables;
        if (r58 >= r59.length) goto L178;
        if (r59[r58] >= MotionPaths.sNames.length) goto L177;
        String r60 = MotionPaths.sNames[this.mInterpolateVariables[r58]] + " [";
        int r61 = 0;
    L175:
        if (r61 >= r1) goto L177;
        r60 = r60 + r55[r61][r58];
        r61 = r61 + 1;
    L177:
        r58 = r58 + 1;
        goto L170
    L178:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r62 = 0;
    L179:
        String[] r63 = this.mAttributeNames;
        if (r62 >= r63.length) goto L190;
        String r64 = r63[r62];
        int r65 = 0;
        int r110 = 0;
        double[] r111 = null;
        double[][] r112 = null;
    L182:
        if (r65 >= r1) goto L189;
        if (r33[r65].hasCustomData(r64) == false) goto L188;
        if (r112 != null) goto L187;
        r111 = new double[r1];
        r112 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r33[r65].getCustomDataCount(r64)});
    L187:
        r111[r110] = r33[r65].mTime;
        r33[r65].getCustomData(r64, r112[r110], 0);
        r110 = r110 + 1;
    L188:
        r65 = r65 + 1;
        goto L182
    L189:
        r62 = r62 + 1;
        this.mSpline[r62] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r111, r110), (double[][]) Arrays.copyOf(r112, r110));
        goto L179
    L190:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r56, r55);
        if (r33[0].mPathMotionArc == (-1)) goto L196;
        int[] r66 = new int[r1];
        double[] r67 = new double[r1];
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, 2});
        int r68 = 0;
    L193:
        if (r68 >= r1) goto L195;
        r66[r68] = r33[r68].mPathMotionArc;
        r67[r68] = r33[r68].mTime;
        r2[r68][0] = r33[r68].mX;
        r2[r68][1] = r33[r68].mY;
        r68 = r68 + 1;
        goto L193
    L195:
        this.mArcSpline = CurveFit.getArc(r66, r67, r2);
    L196:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L220;
        Iterator<String> r69 = r5.iterator();
        float r70 = Float.NaN;
    L200:
        if (r69.hasNext() == false) goto L210;
        String r71 = r69.next();
        KeyCycleOscillator r72 = KeyCycleOscillator.makeWidgetCycle(r71);
        if (r72 == null) goto L200;
        if (r72.variesByPath() == true) goto L207;
    L209:
        r72.setType(r71);
        this.mCycleMap.put(r71, r72);
        goto L200
    L207:
        if (Float.isNaN(r70) == false) goto L209;
        r70 = getPreCycleDistance();
        goto L209
    L210:
        Iterator<MotionKey> r73 = this.mKeyList.iterator();
    L212:
        if (r73.hasNext() == false) goto L216;
        MotionKey r74 = r73.next();
        if ((r74 instanceof MotionKeyCycle) == false) goto L212;
        ((MotionKeyCycle) r74).addCycleValues(this.mCycleMap);
        goto L212
    L216:
        Iterator<KeyCycleOscillator> r0 = this.mCycleMap.values().iterator();
    L218:
        if (r0.hasNext() == false) goto L318;
        r0.next().setup(r70);
        goto L218
    L318:
        return;
    L220:
        return;
    L150:
        r46 = false;
        goto L151
    L121:
        if (this.mCurveFitType != MotionKey.UNSET) goto L123;
        this.mCurveFitType = 0;
        goto L123
    L78:
        if (this.mTimeCycleAttributesMap != null) goto L80;
        this.mTimeCycleAttributesMap = new HashMap();
    L80:
        Iterator<String> r75 = r3.iterator();
    L82:
        if (r75.hasNext() == false) goto L102;
        String r76 = r75.next();
        if (this.mTimeCycleAttributesMap.containsKey(r76) == true) goto L82;
        if (r76.startsWith("CUSTOM,") == false) goto L98;
        KeyFrameArray.CustomVar r77 = new KeyFrameArray.CustomVar();
        String r78 = r76.split(SimContactsConstants.EMAIL_SEP)[1];
        Iterator<MotionKey> r113 = this.mKeyList.iterator();
    L90:
        if (r113.hasNext() == false) goto L97;
        MotionKey r114 = r113.next();
        if (r114.mCustom == null) goto L90;
        CustomVariable r115 = r114.mCustom.get(r78);
        if (r115 == null) goto L90;
        r77.append(r114.mFramePosition, r115);
        goto L90
    L97:
        SplineSet r79 = SplineSet.makeCustomSplineSet(r76, r77);
    L99:
        if (r79 == null) goto L82;
        r79.setType(r76);
        goto L82
    L98:
        r79 = SplineSet.makeSpline(r76, r23);
        goto L99
    L102:
        ArrayList<MotionKey> r80 = this.mKeyList;
        if (r80 == null) goto L110;
        Iterator<MotionKey> r81 = r80.iterator();
    L106:
        if (r81.hasNext() == false) goto L110;
        MotionKey r82 = r81.next();
        if ((r82 instanceof MotionKeyTimeCycle) == false) goto L106;
        ((MotionKeyTimeCycle) r82).addTimeValues(this.mTimeCycleAttributesMap);
    L110:
        Iterator<String> r83 = this.mTimeCycleAttributesMap.keySet().iterator();
    L112:
        if (r83.hasNext() == false) goto L118;
        String r84 = r83.next();
        if (r6.containsKey(r84) == false) goto L116;
        int r85 = r6.get(r84).intValue();
    L117:
        this.mTimeCycleAttributesMap.get(r84).setup(r85);
        goto L112
    L116:
        r85 = 0;
        goto L117
    L29:
        r10 = null;
        goto L31
    L5:
        if (this.mStartMotionPath.mPathMotionArc != (-1)) goto L7;
        this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
        goto L7
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    private void readView(MotionPaths r4) {
        r4.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void setView(MotionWidget r1) {
        this.mView = r1;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public void setStart(MotionWidget r6) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartMotionPath.applyParameters(r6);
        this.mStartPoint.setState(r6);
        TypedBundle r7 = r6.getWidgetFrame().getMotionProperties();
        if (r7 == null) goto L6;
        r7.applyDelta(this);
        return;
    }

    public void setEnd(MotionWidget r6) {
        this.mEndMotionPath.mTime = 1.0f;
        this.mEndMotionPath.mPosition = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(r6.getLeft(), r6.getTop(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.applyParameters(r6);
        this.mEndPoint.setState(r6);
    }

    public void setStartState(ViewState r5, MotionWidget r6, int r7, int r8, int r9) {
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

    private static DifferentialInterpolator getInterpolator(int r0, String r1, int r2) {
        if (r0 == (-1)) goto L6;
        return null;
    L6:
        final Easing r3 = Easing.getInterpolator(r1);
        return new AnonymousClass1(r3);
    }

    void setBothStates(MotionWidget r6) {
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

    public boolean interpolate(MotionWidget r18, float r19, long r20, KeyCache r22) {
        float r1 = getAdjustedPosition(r19, null);
        int r2 = this.mQuantizeMotionSteps;
        if (r2 == (-1)) goto L15;
        float r3 = 1.0f / r2;
        float r4 = ((float) Math.floor(r1 / r3)) * r3;
        float r5 = (r1 % r3) / r3;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r5 = (r5 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        DifferentialInterpolator r6 = this.mQuantizeMotionInterpolator;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r1 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r12 = r1;
        HashMap<String, SplineSet> r8 = this.mAttributesMap;
        if (r8 == null) goto L21;
        Iterator<SplineSet> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r9.next().setProperty(r18, r12);
    L21:
        CurveFit[] r10 = this.mSpline;
        if (r10 == null) goto L65;
        double r11 = r12;
        r10[0].getPos(r11, this.mInterpolateData);
        this.mSpline[0].getSlope(r11, this.mInterpolateVelocity);
        CurveFit r13 = this.mArcSpline;
        if (r13 == null) goto L29;
        double[] r14 = this.mInterpolateData;
        if (r14.length <= 0) goto L29;
        r13.getPos(r11, r14);
        this.mArcSpline.getSlope(r11, this.mInterpolateVelocity);
    L29:
        if (this.mNoMovement == true) goto L33;
        this.mStartMotionPath.setView(r12, r18, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
    L33:
        if (this.mTransformPivotTarget != (-1)) goto L35;
    L44:
        int r15 = 1;
    L45:
        CurveFit[] r16 = this.mSpline;
        if (r15 >= r16.length) goto L49;
        r16[r15].getPos(r11, this.mValuesBuff);
        this.mStartMotionPath.mCustomAttributes.get(this.mAttributeNames[r15 - 1]).setInterpolatedValue(r18, this.mValuesBuff);
        r15 = r15 + 1;
        goto L45
    L49:
        if (this.mStartPoint.mVisibilityMode != 0) goto L60;
        if (r12 > 0.0f) goto L54;
        r18.setVisibility(this.mStartPoint.mVisibility);
        goto L60
    L54:
        if (r12 < 1.0f) goto L57;
        r18.setVisibility(this.mEndPoint.mVisibility);
        goto L60
    L57:
        if (this.mEndPoint.mVisibility == this.mStartPoint.mVisibility) goto L60;
        r18.setVisibility(4);
    L60:
        if (this.mKeyTriggers == null) goto L66;
        int r17 = 0;
    L62:
        MotionKeyTrigger[] r21 = this.mKeyTriggers;
        if (r17 >= r21.length) goto L66;
        r21[r17].conditionallyFire(r12, r18);
        r17 = r17 + 1;
    L66:
        HashMap<String, KeyCycleOscillator> r23 = this.mCycleMap;
        if (r23 == null) goto L75;
        Iterator<KeyCycleOscillator> r24 = r23.values().iterator();
    L70:
        if (r24.hasNext() == false) goto L86;
        KeyCycleOscillator r25 = r24.next();
        if ((r25 instanceof KeyCycleOscillator.PathRotateSet) == true) goto L73;
        r25.setProperty(r18, r12);
        goto L70
    L73:
        double[] r26 = this.mInterpolateVelocity;
        ((KeyCycleOscillator.PathRotateSet) r25).setPathRotate(r18, r12, r26[0], r26[1]);
        goto L70
    L86:
        return false;
    L75:
        return false;
    L35:
        if (this.mTransformPivotView != null) goto L37;
        this.mTransformPivotView = r18.getParent().findViewById(this.mTransformPivotTarget);
    L37:
        MotionWidget r27 = this.mTransformPivotView;
        if (r27 == null) goto L44;
        float r28 = (r27.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r29 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r18.getRight() - r18.getLeft()) <= 0) goto L44;
        if ((r18.getBottom() - r18.getTop()) <= 0) goto L44;
        float r30 = r29 - r18.getLeft();
        float r31 = r28 - r18.getTop();
        r18.setPivotX(r30);
        r18.setPivotY(r31);
        goto L44
    L65:
        float r32 = this.mStartMotionPath.mX + ((this.mEndMotionPath.mX - this.mStartMotionPath.mX) * r12);
        float r33 = this.mStartMotionPath.mY + ((this.mEndMotionPath.mY - this.mStartMotionPath.mY) * r12);
        float r34 = r32 + 0.5f;
        float r35 = r33 + 0.5f;
        r18.layout((int) r34, (int) r35, (int) (r34 + (this.mStartMotionPath.mWidth + ((this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) * r12))), (int) (r35 + (this.mStartMotionPath.mHeight + ((this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) * r12))));
        goto L66
    }

    public void getDpDt(float r12, float r13, float r14, float[] r15) {
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
        HashMap<String, SplineSet> r2 = this.mAttributesMap;
        KeyCycleOscillator r4 = null;
        if (r2 != null) goto L5;
        SplineSet r3 = null;
    L6:
        HashMap<String, SplineSet> r5 = this.mAttributesMap;
        if (r5 != null) goto L9;
        SplineSet r6 = null;
    L10:
        HashMap<String, SplineSet> r7 = this.mAttributesMap;
        if (r7 != null) goto L13;
        SplineSet r8 = null;
    L14:
        HashMap<String, SplineSet> r9 = this.mAttributesMap;
        if (r9 != null) goto L17;
        SplineSet r10 = null;
    L18:
        HashMap<String, SplineSet> r11 = this.mAttributesMap;
        if (r11 != null) goto L21;
        SplineSet r12 = null;
    L22:
        HashMap<String, KeyCycleOscillator> r13 = this.mCycleMap;
        if (r13 != null) goto L25;
        KeyCycleOscillator r14 = null;
    L26:
        HashMap<String, KeyCycleOscillator> r15 = this.mCycleMap;
        if (r15 != null) goto L29;
        KeyCycleOscillator r16 = null;
    L30:
        HashMap<String, KeyCycleOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L33;
        KeyCycleOscillator r18 = null;
    L34:
        HashMap<String, KeyCycleOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L37;
        KeyCycleOscillator r111 = null;
    L38:
        HashMap<String, KeyCycleOscillator> r112 = this.mCycleMap;
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
        KeyCycleOscillator r118 = r4;
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
        r18 = r17.get("rotationZ");
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
        r8 = r7.get("rotationZ");
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
        return this.mView.getName();
    }

    void positionKeyframe(MotionWidget r9, MotionKeyPosition r10, float r11, float r12, String[] r13, float[] r14) {
        FloatRect r2 = new FloatRect();
        r2.left = this.mStartMotionPath.mX;
        r2.top = this.mStartMotionPath.mY;
        r2.right = r2.left + this.mStartMotionPath.mWidth;
        r2.bottom = r2.top + this.mStartMotionPath.mHeight;
        FloatRect r3 = new FloatRect();
        r3.left = this.mEndMotionPath.mX;
        r3.top = this.mEndMotionPath.mY;
        r3.right = r3.left + this.mEndMotionPath.mWidth;
        r3.bottom = r3.top + this.mEndMotionPath.mHeight;
        r10.positionAttributes(r9, r2, r3, r11, r12, r13, r14);
    }

    public int getKeyFramePositions(int[] r13, float[] r14) {
        Iterator<MotionKey> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        MotionKey r3 = r0.next();
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
        Iterator<MotionKey> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        MotionKey r14 = r10.next();
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
        if ((r14 instanceof MotionKeyPosition) == false) goto L13;
        MotionKeyPosition r15 = (MotionKeyPosition) r14;
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

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, int r4) {
        if (r3 != 509) goto L5;
        setPathMotionArc(r4);
        return true;
    L5:
        if (r3 != 610) goto L7;
        this.mQuantizeMotionSteps = r4;
        return true;
    L7:
        if (r3 == 704) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, float r4) {
        if (602 != r3) goto L7;
        this.mQuantizeMotionPhase = r4;
        return true;
    L7:
        if (600 != r3) goto L10;
        this.mMotionStagger = r4;
        return true;
    L10:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r4, String r5) {
        if (705 != r4) goto L5;
    L12:
        this.mQuantizeMotionInterpolator = getInterpolator(-1, r5, 0);
        return true;
    L5:
        if (611 == r4) goto L12;
        if (605 != r4) goto L11;
        this.mStartMotionPath.mAnimateRelativeTo = r5;
        return true;
    L11:
        return false;
    }

    public void setStaggerScale(float r1) {
        this.mStaggerScale = r1;
    }

    public void setStaggerOffset(float r1) {
        this.mStaggerOffset = r1;
    }

    public float getMotionStagger() {
        return this.mMotionStagger;
    }

    public void setIdString(String r1) {
        this.mId = r1;
        this.mStartMotionPath.mId = r1;
    }
}
