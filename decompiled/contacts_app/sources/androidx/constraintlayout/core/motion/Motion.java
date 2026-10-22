package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import com.android.contacts.common.SimContactsConstants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
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
    private int MAX_DIMENSION;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList;
    private MotionKeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private DifferentialInterpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, float r2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
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

    public Motion(MotionWidget r4) {
        this.mTempRect = new Rect();
        this.mCurveFitType = -1;
        this.mStartMotionPath = new MotionPaths();
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mStaggerOffset = 0.0f;
        this.mStaggerScale = 1.0f;
        this.MAX_DIMENSION = 4;
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
        setView(r4);
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public void setupRelative(Motion r3) {
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
        if (r23.time >= r17) goto L39;
        r21 = r23.mKeyFrameEasing;
        r15 = r23.time;
        goto L32
    L39:
        if (Float.isNaN(r110) == false) goto L32;
        r110 = r23.time;
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
        if (r113.time < r13) goto L37;
        if (Float.isNaN(r112) == false) goto L32;
        r112 = r113.time;
        goto L32
    L37:
        r110 = r113.mKeyFrameEasing;
        r15 = r113.time;
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
        float r7 = 0.0f;
    L4:
        if (r8 >= 100) goto L28;
        float r2 = r8 * r10;
        double r3 = r2;
        Easing r5 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r6 = this.mMotionPaths.iterator();
        float r17 = Float.NaN;
        float r18 = 0.0f;
    L7:
        if (r6.hasNext() == false) goto L17;
        MotionPaths r9 = r6.next();
        if (r9.mKeyFrameEasing == null) goto L7;
        if (r9.time >= r2) goto L14;
        r5 = r9.mKeyFrameEasing;
        r18 = r9.time;
        goto L7
    L14:
        if (Float.isNaN(r17) == false) goto L7;
        r17 = r9.time;
        goto L7
    L17:
        if (r5 != null) goto L19;
    L22:
        this.mSpline[0].getPos(r3, this.mInterpolateData);
        float r11 = r7;
        int r19 = r8;
        this.mStartMotionPath.getCenter(r3, this.mInterpolateVariables, this.mInterpolateData, r1, 0);
        if (r19 <= 0) goto L25;
        r7 = (float) (((double) r11) + Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])));
    L26:
        r13 = r1[0];
        r8 = r19 + 1;
        r15 = r1[1];
        goto L4
    L25:
        r7 = r11;
        goto L26
    L19:
        if (Float.isNaN(r17) == false) goto L21;
        r17 = 1.0f;
    L21:
        float r110 = r17 - r18;
        r3 = (((float) r5.get((r2 - r18) / r110)) * r110) + r18;
        goto L22
    L28:
        return r7;
    }

    MotionKeyPosition getPositionKeyframe(int r11, int r12, float r13, float r14) {
        FloatRect r7 = new FloatRect();
        r7.left = this.mStartMotionPath.x;
        r7.top = this.mStartMotionPath.y;
        r7.right = r7.left + this.mStartMotionPath.width;
        r7.bottom = r7.top + this.mStartMotionPath.height;
        FloatRect r8 = new FloatRect();
        r8.left = this.mEndMotionPath.x;
        r8.top = this.mEndMotionPath.y;
        r8.right = r8.left + this.mEndMotionPath.width;
        r8.bottom = r8.top + this.mEndMotionPath.height;
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
        r12[r4] = (int) (r13.next().position * 100.0f);
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
        float r0 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r1 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float r2 = this.mStartMotionPath.x + (this.mStartMotionPath.width / 2.0f);
        float r3 = this.mStartMotionPath.y + (this.mStartMotionPath.height / 2.0f);
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
        if (r6.position != r2.position) goto L4;
        r1 = r2;
        goto L4
    L8:
        if (r1 == null) goto L10;
        this.mMotionPaths.remove(r1);
    L10:
        int r3 = Collections.binarySearch(this.mMotionPaths, r6);
        if (r3 != 0) goto L13;
        Utils.loge(TAG, " KeyPath position \"" + r6.position + "\" outside of range");
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
        int r7 = this.mPathMotionArc;
        if (r7 == (-1)) goto L5;
        this.mStartMotionPath.mPathMotionArc = r7;
    L5:
        this.mStartPoint.different(this.mEndPoint, r4);
        ArrayList<MotionKey> r8 = this.mKeyList;
        if (r8 == null) goto L27;
        Iterator<MotionKey> r9 = r8.iterator();
        ArrayList r10 = null;
    L9:
        if (r9.hasNext() == false) goto L29;
        MotionKey r11 = r9.next();
        if ((r11 instanceof MotionKeyPosition) == true) goto L12;
        if ((r11 instanceof MotionKeyCycle) == true) goto L17;
        if ((r11 instanceof MotionKeyTimeCycle) == true) goto L20;
        if ((r11 instanceof MotionKeyTrigger) == true) goto L23;
        r11.setInterpolation(r6);
        r11.getAttributeNames(r4);
        goto L9
    L23:
        if (r10 != null) goto L25;
        r10 = new ArrayList();
    L25:
        r10.add((MotionKeyTrigger) r11);
        goto L9
    L20:
        r11.getAttributeNames(r3);
        goto L9
    L17:
        r11.getAttributeNames(r5);
        goto L9
    L12:
        MotionKeyPosition r12 = (MotionKeyPosition) r11;
        insertKey(new MotionPaths(r20, r21, r12, this.mStartMotionPath, this.mEndMotionPath));
        if (r12.mCurveFit == (-1)) goto L9;
        this.mCurveFitType = r12.mCurveFit;
    L29:
        if (r10 == null) goto L31;
        this.mKeyTriggers = (MotionKeyTrigger[]) r10.toArray(new MotionKeyTrigger[0]);
    L31:
        char r13 = 1;
        if (r4.isEmpty() == true) goto L74;
        this.mAttributesMap = new HashMap();
        Iterator<String> r14 = r4.iterator();
    L35:
        if (r14.hasNext() == false) goto L53;
        String r15 = r14.next();
        if (r15.startsWith("CUSTOM,") == false) goto L48;
        KeyFrameArray.CustomVar r16 = new KeyFrameArray.CustomVar();
        String r17 = r15.split(SimContactsConstants.EMAIL_SEP)[r13];
        Iterator<MotionKey> r18 = this.mKeyList.iterator();
    L40:
        if (r18.hasNext() == false) goto L47;
        MotionKey r19 = r18.next();
        if (r19.mCustom == null) goto L40;
        CustomVariable r24 = r19.mCustom.get(r17);
        if (r24 == null) goto L40;
        r16.append(r19.mFramePosition, r24);
        goto L40
    L47:
        SplineSet r25 = SplineSet.makeCustomSplineSet(r15, r16);
    L49:
        if (r25 == null) goto L52;
        r25.setType(r15);
        this.mAttributesMap.put(r15, r25);
    L52:
        r13 = 1;
        goto L35
    L48:
        r25 = SplineSet.makeSpline(r15, r23);
        goto L49
    L53:
        ArrayList<MotionKey> r26 = this.mKeyList;
        if (r26 == null) goto L61;
        Iterator<MotionKey> r27 = r26.iterator();
    L57:
        if (r27.hasNext() == false) goto L61;
        MotionKey r28 = r27.next();
        if ((r28 instanceof MotionKeyAttributes) == false) goto L57;
        r28.addValues(this.mAttributesMap);
    L61:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r29 = this.mAttributesMap.keySet().iterator();
    L63:
        if (r29.hasNext() == false) goto L74;
        String r30 = r29.next();
        if (r6.containsKey(r30) == false) goto L69;
        Integer r31 = r6.get(r30);
        if (r31 == null) goto L69;
        int r32 = r31.intValue();
    L70:
        SplineSet r33 = this.mAttributesMap.get(r30);
        if (r33 == null) goto L63;
        r33.setup(r32);
    L69:
        r32 = 0;
    L74:
        if (r3.isEmpty() == false) goto L76;
    L116:
        int r1 = this.mMotionPaths.size() + 2;
        MotionPaths[] r34 = new MotionPaths[r1];
        r34[0] = this.mStartMotionPath;
        r34[r1 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L119;
    L121:
        Iterator<MotionPaths> r35 = this.mMotionPaths.iterator();
        int r36 = 1;
    L123:
        if (r35.hasNext() == false) goto L125;
        r34[r36] = r35.next();
        r36 = r36 + 1;
        goto L123
    L125:
        HashSet r37 = new HashSet();
        Iterator<String> r38 = this.mEndMotionPath.customAttributes.keySet().iterator();
    L127:
        if (r38.hasNext() == false) goto L133;
        String r39 = r38.next();
        if (this.mStartMotionPath.customAttributes.containsKey(r39) == false) goto L127;
        if (r4.contains("CUSTOM," + r39) == true) goto L127;
        r37.add(r39);
        goto L127
    L133:
        String[] r40 = (String[]) r37.toArray(new String[0]);
        this.mAttributeNames = r40;
        this.mAttributeInterpolatorCount = new int[r40.length];
        int r41 = 0;
    L134:
        String[] r42 = this.mAttributeNames;
        if (r41 >= r42.length) goto L146;
        String r43 = r42[r41];
        this.mAttributeInterpolatorCount[r41] = 0;
        int r44 = 0;
    L137:
        if (r44 >= r1) goto L144;
        if (r34[r44].customAttributes.containsKey(r43) == false) goto L143;
        CustomVariable r45 = r34[r44].customAttributes.get(r43);
        if (r45 == null) goto L143;
        int[] r46 = this.mAttributeInterpolatorCount;
        r46[r41] = r46[r41] + r45.numberOfInterpolatedValues();
    L143:
        r44 = r44 + 1;
    L144:
        r41 = r41 + 1;
        goto L134
    L146:
        if (r34[0].mPathMotionArc == (-1)) goto L148;
        boolean r47 = true;
    L149:
        int r48 = 18 + this.mAttributeNames.length;
        boolean[] r49 = new boolean[r48];
        int r50 = 1;
    L150:
        if (r50 >= r1) goto L152;
        r34[r50].different(r34[r50 - 1], r49, this.mAttributeNames, r47);
        r50 = r50 + 1;
        goto L150
    L152:
        int r51 = 1;
        int r52 = 0;
    L153:
        if (r51 >= r48) goto L158;
        if (r49[r51] == false) goto L157;
        r52 = r52 + 1;
    L157:
        r51 = r51 + 1;
        goto L153
    L158:
        this.mInterpolateVariables = new int[r52];
        int r53 = Math.max(2, r52);
        this.mInterpolateData = new double[r53];
        this.mInterpolateVelocity = new double[r53];
        int r54 = 1;
        int r55 = 0;
    L159:
        if (r54 >= r48) goto L164;
        if (r49[r54] == false) goto L163;
        this.mInterpolateVariables[r55] = r54;
        r55 = r55 + 1;
    L163:
        r54 = r54 + 1;
        goto L159
    L164:
        double[][] r56 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, this.mInterpolateVariables.length});
        double[] r57 = new double[r1];
        int r58 = 0;
    L165:
        if (r58 >= r1) goto L167;
        r34[r58].fillStandard(r56[r58], this.mInterpolateVariables);
        r57[r58] = r34[r58].time;
        r58 = r58 + 1;
        goto L165
    L167:
        int r59 = 0;
    L168:
        int[] r60 = this.mInterpolateVariables;
        if (r59 >= r60.length) goto L176;
        if (r60[r59] >= MotionPaths.names.length) goto L175;
        String r61 = MotionPaths.names[this.mInterpolateVariables[r59]] + " [";
        int r62 = 0;
    L173:
        if (r62 >= r1) goto L175;
        r61 = r61 + r56[r62][r59];
        r62 = r62 + 1;
    L175:
        r59 = r59 + 1;
        goto L168
    L176:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r63 = 0;
    L177:
        String[] r64 = this.mAttributeNames;
        if (r63 >= r64.length) goto L188;
        double[][] r110 = (double[][]) null;
        String r65 = r64[r63];
        double[] r111 = null;
        double[][] r112 = null;
        int r113 = 0;
        int r114 = 0;
    L180:
        if (r113 >= r1) goto L187;
        if (r34[r113].hasCustomData(r65) == false) goto L186;
        if (r112 != null) goto L185;
        r111 = new double[r1];
        r112 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, r34[r113].getCustomDataCount(r65)});
    L185:
        r111[r114] = r34[r113].time;
        r34[r113].getCustomData(r65, r112[r114], 0);
        r114 = r114 + 1;
    L186:
        r113 = r113 + 1;
        goto L180
    L187:
        r63 = r63 + 1;
        this.mSpline[r63] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r111, r114), (double[][]) Arrays.copyOf(r112, r114));
        goto L177
    L188:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r57, r56);
        if (r34[0].mPathMotionArc == (-1)) goto L194;
        int[] r66 = new int[r1];
        double[] r67 = new double[r1];
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r1, 2});
        int r68 = 0;
    L191:
        if (r68 >= r1) goto L193;
        r66[r68] = r34[r68].mPathMotionArc;
        r67[r68] = r34[r68].time;
        r2[r68][0] = r34[r68].x;
        r2[r68][1] = r34[r68].y;
        r68 = r68 + 1;
        goto L191
    L193:
        this.mArcSpline = CurveFit.getArc(r66, r67, r2);
    L194:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L218;
        Iterator<String> r69 = r5.iterator();
        float r70 = Float.NaN;
    L198:
        if (r69.hasNext() == false) goto L208;
        String r71 = r69.next();
        KeyCycleOscillator r72 = KeyCycleOscillator.makeWidgetCycle(r71);
        if (r72 == null) goto L198;
        if (r72.variesByPath() == true) goto L205;
    L207:
        r72.setType(r71);
        this.mCycleMap.put(r71, r72);
        goto L198
    L205:
        if (Float.isNaN(r70) == false) goto L207;
        r70 = getPreCycleDistance();
        goto L207
    L208:
        Iterator<MotionKey> r73 = this.mKeyList.iterator();
    L210:
        if (r73.hasNext() == false) goto L214;
        MotionKey r74 = r73.next();
        if ((r74 instanceof MotionKeyCycle) == false) goto L210;
        ((MotionKeyCycle) r74).addCycleValues(this.mCycleMap);
        goto L210
    L214:
        Iterator<KeyCycleOscillator> r0 = this.mCycleMap.values().iterator();
    L216:
        if (r0.hasNext() == false) goto L316;
        r0.next().setup(r70);
        goto L216
    L316:
        return;
    L218:
        return;
    L148:
        r47 = false;
        goto L149
    L119:
        if (this.mCurveFitType != MotionKey.UNSET) goto L121;
        this.mCurveFitType = 0;
        goto L121
    L76:
        if (this.mTimeCycleAttributesMap != null) goto L78;
        this.mTimeCycleAttributesMap = new HashMap();
    L78:
        Iterator<String> r75 = r3.iterator();
    L80:
        if (r75.hasNext() == false) goto L100;
        String r76 = r75.next();
        if (this.mTimeCycleAttributesMap.containsKey(r76) == true) goto L80;
        if (r76.startsWith("CUSTOM,") == false) goto L96;
        KeyFrameArray.CustomVar r77 = new KeyFrameArray.CustomVar();
        String r78 = r76.split(SimContactsConstants.EMAIL_SEP)[1];
        Iterator<MotionKey> r115 = this.mKeyList.iterator();
    L88:
        if (r115.hasNext() == false) goto L95;
        MotionKey r116 = r115.next();
        if (r116.mCustom == null) goto L88;
        CustomVariable r117 = r116.mCustom.get(r78);
        if (r117 == null) goto L88;
        r77.append(r116.mFramePosition, r117);
        goto L88
    L95:
        SplineSet r79 = SplineSet.makeCustomSplineSet(r76, r77);
    L97:
        if (r79 == null) goto L80;
        r79.setType(r76);
        goto L80
    L96:
        r79 = SplineSet.makeSpline(r76, r23);
        goto L97
    L100:
        ArrayList<MotionKey> r80 = this.mKeyList;
        if (r80 == null) goto L108;
        Iterator<MotionKey> r81 = r80.iterator();
    L104:
        if (r81.hasNext() == false) goto L108;
        MotionKey r82 = r81.next();
        if ((r82 instanceof MotionKeyTimeCycle) == false) goto L104;
        ((MotionKeyTimeCycle) r82).addTimeValues(this.mTimeCycleAttributesMap);
    L108:
        Iterator<String> r83 = this.mTimeCycleAttributesMap.keySet().iterator();
    L110:
        if (r83.hasNext() == false) goto L116;
        String r84 = r83.next();
        if (r6.containsKey(r84) == false) goto L114;
        int r85 = r6.get(r84).intValue();
    L115:
        this.mTimeCycleAttributesMap.get(r84).setup(r85);
        goto L110
    L114:
        r85 = 0;
        goto L115
    L27:
        r10 = null;
        goto L29
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
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
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartMotionPath.applyParameters(r6);
        this.mStartPoint.setState(r6);
    }

    public void setEnd(MotionWidget r6) {
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(r6.getLeft(), r6.getTop(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.applyParameters(r6);
        this.mEndPoint.setState(r6);
    }

    public void setStartState(ViewState r5, MotionWidget r6, int r7, int r8, int r9) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
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
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
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
        if (r5.time < r12) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.time;
        goto L17
    L22:
        r3 = r5.mKeyFrameEasing;
        r0 = r5.time;
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
        this.mStartMotionPath.customAttributes.get(this.mAttributeNames[r15 - 1]).setInterpolatedValue(r18, this.mValuesBuff);
        r15 = r15 + 1;
        goto L45
    L49:
        if (this.mStartPoint.mVisibilityMode != 0) goto L60;
        if (r12 > 0.0f) goto L54;
        r18.setVisibility(this.mStartPoint.visibility);
        goto L60
    L54:
        if (r12 < 1.0f) goto L57;
        r18.setVisibility(this.mEndPoint.visibility);
        goto L60
    L57:
        if (this.mEndPoint.visibility == this.mStartPoint.visibility) goto L60;
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
        float r32 = this.mStartMotionPath.x + ((this.mEndMotionPath.x - this.mStartMotionPath.x) * r12);
        float r33 = this.mStartMotionPath.y + ((this.mEndMotionPath.y - this.mStartMotionPath.y) * r12);
        float r34 = r32 + 0.5f;
        float r35 = r33 + 0.5f;
        r18.layout((int) r34, (int) r35, (int) (r34 + (this.mStartMotionPath.width + ((this.mEndMotionPath.width - this.mStartMotionPath.width) * r12))), (int) (r35 + (this.mStartMotionPath.height + ((this.mEndMotionPath.height - this.mStartMotionPath.height) * r12))));
        goto L66
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
        float r19 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r4 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float r5 = (this.mEndMotionPath.width - this.mStartMotionPath.width) + r19;
        float r6 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + r4;
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
        float r116 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r117 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        KeyCycleOscillator r118 = r4;
        float r119 = (this.mEndMotionPath.width - this.mStartMotionPath.width) + r116;
        float r30 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + r117;
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
        r2.left = this.mStartMotionPath.x;
        r2.top = this.mStartMotionPath.y;
        r2.right = r2.left + this.mStartMotionPath.width;
        r2.bottom = r2.top + this.mStartMotionPath.height;
        FloatRect r3 = new FloatRect();
        r3.left = this.mEndMotionPath.x;
        r3.top = this.mEndMotionPath.y;
        r3.right = r3.left + this.mEndMotionPath.width;
        r3.bottom = r3.top + this.mEndMotionPath.height;
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

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, int r4) {
        if (r3 != 509) goto L5;
        setPathMotionArc(r4);
        return true;
    L5:
        if (r3 == 704) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r4, String r5) {
        if (705 != r4) goto L5;
        System.out.println("TYPE_INTERPOLATOR  " + r5);
        this.mQuantizeMotionInterpolator = getInterpolator(-1, r5, 0);
    L5:
        return false;
    }
}
