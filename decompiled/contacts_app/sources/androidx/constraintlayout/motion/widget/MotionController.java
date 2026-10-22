package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
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
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.android.contacts.common.SimContactsConstants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
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
    private int MAX_DIMENSION;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
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

    public void setTransformPivotTarget(int transformPivotTarget) {
        this.mTransformPivotTarget = transformPivotTarget;
        this.mTransformPivotView = null;
    }

    MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    MotionController(View view) {
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
        this.MAX_DIMENSION = 4;
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
        setView(view);
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

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getCenter(double p, float[] pos, float[] vel) {
        double[] r5 = new double[4];
        double[] r7 = new double[4];
        this.mSpline[0].getPos(p, r5);
        this.mSpline[0].getSlope(p, r7);
        Arrays.fill(vel, 0.0f);
        this.mStartMotionPath.getCenter(p, this.mInterpolateVariables, r5, pos, r7, vel);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    void buildPath(float[] points, int pointCount) {
        float r9 = 1.0f;
        float r10 = 1.0f / (pointCount - 1);
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
        if (r7 >= pointCount) goto L62;
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
        Easing r19 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r20 = this.mMotionPaths.iterator();
        float r110 = Float.NaN;
    L32:
        if (r20.hasNext() == false) goto L42;
        MotionPaths r21 = r20.next();
        if (r21.mKeyFrameEasing == null) goto L32;
        if (r21.time >= r17) goto L39;
        r19 = r21.mKeyFrameEasing;
        r15 = r21.time;
        goto L32
    L39:
        if (Float.isNaN(r110) == false) goto L32;
        r110 = r21.time;
        goto L32
    L42:
        if (r19 != null) goto L44;
    L47:
        double r22 = r18;
        this.mSpline[0].getPos(r22, this.mInterpolateData);
        CurveFit r23 = this.mArcSpline;
        if (r23 == null) goto L52;
        double[] r24 = this.mInterpolateData;
        if (r24.length <= 0) goto L52;
        r23.getPos(r22, r24);
    L52:
        int r111 = r7 * 2;
        int r112 = r7;
        this.mStartMotionPath.getCenter(r22, this.mInterpolateVariables, this.mInterpolateData, points, r111);
        if (r13 == null) goto L55;
        points[r111] = points[r111] + r13.get(r17);
    L57:
        if (r14 == null) goto L59;
        int r113 = r111 + 1;
        points[r113] = points[r113] + r14.get(r17);
    L61:
        r7 = r112 + 1;
        r9 = 1.0f;
        goto L19
    L59:
        if (r12 == null) goto L61;
        int r114 = r111 + 1;
        points[r114] = points[r114] + r12.get(r17);
        goto L61
    L55:
        if (r11 == null) goto L57;
        points[r111] = points[r111] + r11.get(r17);
        goto L57
    L44:
        if (Float.isNaN(r110) == false) goto L46;
        r110 = 1.0f;
    L46:
        float r115 = r110 - r15;
        r18 = (((float) r19.get((r17 - r15) / r115)) * r115) + r15;
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

    double[] getPos(double position) {
        this.mSpline[0].getPos(position, this.mInterpolateData);
        CurveFit r0 = this.mArcSpline;
        if (r0 == null) goto L8;
        double[] r1 = this.mInterpolateData;
        if (r1.length <= 0) goto L8;
        r0.getPos(position, r1);
    L8:
        return this.mInterpolateData;
    }

    void buildBounds(float[] bounds, int pointCount) {
        float r2 = 1.0f / (pointCount - 1);
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
        if (r12 >= pointCount) goto L52;
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
        double r17 = r13;
        Easing r18 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r19 = this.mMotionPaths.iterator();
        float r110 = Float.NaN;
    L32:
        if (r19.hasNext() == false) goto L41;
        MotionPaths r111 = r19.next();
        if (r111.mKeyFrameEasing == null) goto L32;
        if (r111.time < r13) goto L37;
        if (Float.isNaN(r110) == false) goto L32;
        r110 = r111.time;
        goto L32
    L37:
        r18 = r111.mKeyFrameEasing;
        r15 = r111.time;
        goto L32
    L41:
        if (r18 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r17, this.mInterpolateData);
        CurveFit r20 = this.mArcSpline;
        if (r20 == null) goto L51;
        double[] r21 = this.mInterpolateData;
        if (r21.length <= 0) goto L51;
        r20.getPos(r17, r21);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, bounds, r12 * 2);
        r12 = r12 + 1;
        goto L19
    L43:
        if (Float.isNaN(r110) == false) goto L45;
        r110 = 1.0f;
    L45:
        float r112 = r110 - r15;
        r17 = (((float) r18.get((r13 - r15) / r112)) * r112) + r15;
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

    KeyPositionBase getPositionKeyframe(int layoutWidth, int layoutHeight, float x, float y) {
        RectF r7 = new RectF();
        r7.left = this.mStartMotionPath.x;
        r7.top = this.mStartMotionPath.y;
        r7.right = r7.left + this.mStartMotionPath.width;
        r7.bottom = r7.top + this.mStartMotionPath.height;
        RectF r8 = new RectF();
        r8.left = this.mEndMotionPath.x;
        r8.top = this.mEndMotionPath.y;
        r8.right = r8.left + this.mEndMotionPath.width;
        r8.bottom = r8.top + this.mEndMotionPath.height;
        Iterator<Key> r10 = this.mKeyList.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Key r0 = r10.next();
        if ((r0 instanceof KeyPositionBase) == false) goto L4;
        KeyPositionBase r9 = (KeyPositionBase) r0;
        if (r9.intersects(layoutWidth, layoutHeight, r7, r8, x, y) == false) goto L4;
        return r9;
    L10:
        return null;
    }

    int buildKeyFrames(float[] keyFrames, int[] mode) {
        if (keyFrames == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (mode == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        mode[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        int r12 = 0;
        int r9 = 0;
    L12:
        if (r12 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r12], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r12], this.mInterpolateVariables, this.mInterpolateData, keyFrames, r9);
        r9 = r9 + 2;
        r12 = r12 + 1;
        goto L12
    L15:
        return r9 / 2;
    L16:
        return 0;
    }

    int buildKeyBounds(float[] keyBounds, int[] mode) {
        if (keyBounds == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (mode == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        mode[r3] = r2.next().mMode;
        r3 = r3 + 1;
    L10:
        int r9 = 0;
        int r4 = 0;
    L12:
        if (r9 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r9], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, keyBounds, r4);
        r4 = r4 + 2;
        r9 = r9 + 1;
        goto L12
    L15:
        return r4 / 2;
    L16:
        return 0;
    }

    int getAttributeValues(String attributeType, float[] points, int pointCount) {
        ViewSpline r0 = this.mAttributesMap.get(attributeType);
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = 0;
    L8:
        if (r1 >= points.length) goto L11;
        points[r1] = r0.get(r1 / (points.length - 1));
        r1 = r1 + 1;
        goto L8
    L11:
        return points.length;
    }

    void buildRect(float p, float[] path, int offset) {
        this.mSpline[0].getPos(getAdjustedPosition(p, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, path, offset);
    }

    void buildRectangles(float[] path, int pointCount) {
        float r1 = 1.0f / (pointCount - 1);
        int r2 = 0;
    L3:
        if (r2 >= pointCount) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r2 * r1, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, path, r2 * 8);
        r2 = r2 + 1;
        goto L3
    }

    float getKeyFrameParameter(int type, float x, float y) {
        float r0 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r1 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float r2 = this.mStartMotionPath.x + (this.mStartMotionPath.width / 2.0f);
        float r3 = this.mStartMotionPath.y + (this.mStartMotionPath.height / 2.0f);
        float r8 = (float) Math.hypot(r0, r1);
        if (r8 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r10 = x - r2;
        float r11 = y - r3;
        if (((float) Math.hypot(r10, r11)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r4 = (r10 * r0) + (r11 * r1);
        if (type == 0) goto L33;
        if (type == 1) goto L31;
        if (type == 2) goto L29;
        if (type == 3) goto L27;
        if (type == 4) goto L25;
        if (type == 5) goto L23;
        return 0.0f;
    L23:
        return r11 / r1;
    L25:
        return r10 / r1;
    L27:
        return r11 / r0;
    L29:
        return r10 / r0;
    L31:
        return (float) Math.sqrt((r8 * r8) - (r4 * r4));
    L33:
        return r4 / r8;
    }

    private void insertKey(MotionPaths point) {
        int r0 = Collections.binarySearch(this.mMotionPaths, point);
        if (r0 != 0) goto L5;
        Log.e(TAG, " KeyPath position \"" + point.position + "\" outside of range");
    L5:
        this.mMotionPaths.add((-r0) - 1, point);
    }

    void addKeys(ArrayList<Key> list) {
        this.mKeyList.addAll(list);
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void setPathMotionArc(int arc) {
        this.mPathMotionArc = arc;
    }

    public void setup(int parentWidth, int parentHeight, float transitionDuration, long currentTime) {
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
        insertKey(new MotionPaths(parentWidth, parentHeight, r9, this.mStartMotionPath, this.mEndMotionPath));
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
        ConstraintAttribute r17 = r16.mCustomConstraints.get(r14);
        if (r17 == null) goto L40;
        r13.append(r16.mFramePosition, r17);
        goto L40
    L47:
        ViewSpline r18 = ViewSpline.makeCustomSpline(r12, r13);
    L49:
        if (r18 == null) goto L35;
        r18.setType(r12);
        this.mAttributesMap.put(r12, r18);
        goto L35
    L48:
        r18 = ViewSpline.makeSpline(r12);
        goto L49
    L52:
        ArrayList<Key> r19 = this.mKeyList;
        if (r19 == null) goto L60;
        Iterator<Key> r20 = r19.iterator();
    L56:
        if (r20.hasNext() == false) goto L60;
        Key r21 = r20.next();
        if ((r21 instanceof KeyAttributes) == false) goto L56;
        r21.addValues(this.mAttributesMap);
    L60:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r22 = this.mAttributesMap.keySet().iterator();
    L62:
        if (r22.hasNext() == false) goto L73;
        String r23 = r22.next();
        if (r4.containsKey(r23) == false) goto L68;
        Integer r110 = r4.get(r23);
        if (r110 == null) goto L68;
        int r111 = r110.intValue();
    L69:
        ViewSpline r24 = this.mAttributesMap.get(r23);
        if (r24 == null) goto L62;
        r24.setup(r111);
    L68:
        r111 = 0;
    L73:
        if (r1.isEmpty() == false) goto L75;
    L115:
        int r25 = 2;
        int r26 = this.mMotionPaths.size() + 2;
        MotionPaths[] r27 = new MotionPaths[r26];
        r27[0] = this.mStartMotionPath;
        r27[r26 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L118;
    L120:
        Iterator<MotionPaths> r28 = this.mMotionPaths.iterator();
        int r29 = 1;
    L122:
        if (r28.hasNext() == false) goto L124;
        r27[r29] = r28.next();
        r29 = r29 + 1;
        goto L122
    L124:
        HashSet r30 = new HashSet();
        Iterator<String> r31 = this.mEndMotionPath.attributes.keySet().iterator();
    L126:
        if (r31.hasNext() == false) goto L132;
        String r112 = r31.next();
        if (this.mStartMotionPath.attributes.containsKey(r112) == false) goto L126;
        if (r2.contains("CUSTOM," + r112) == true) goto L126;
        r30.add(r112);
        goto L126
    L132:
        String[] r32 = (String[]) r30.toArray(new String[0]);
        this.mAttributeNames = r32;
        this.mAttributeInterpolatorCount = new int[r32.length];
        int r33 = 0;
    L133:
        String[] r34 = this.mAttributeNames;
        if (r33 >= r34.length) goto L145;
        String r35 = r34[r33];
        this.mAttributeInterpolatorCount[r33] = 0;
        int r36 = 0;
    L136:
        if (r36 >= r26) goto L143;
        if (r27[r36].attributes.containsKey(r35) == false) goto L142;
        ConstraintAttribute r37 = r27[r36].attributes.get(r35);
        if (r37 == null) goto L142;
        int[] r38 = this.mAttributeInterpolatorCount;
        r38[r33] = r38[r33] + r37.numberOfInterpolatedValues();
    L142:
        r36 = r36 + 1;
    L143:
        r33 = r33 + 1;
        goto L133
    L145:
        if (r27[0].mPathMotionArc == Key.UNSET) goto L147;
        boolean r39 = true;
    L148:
        int r40 = 18 + this.mAttributeNames.length;
        boolean[] r41 = new boolean[r40];
        int r42 = 1;
    L149:
        if (r42 >= r26) goto L151;
        r27[r42].different(r27[r42 - 1], r41, this.mAttributeNames, r39);
        r42 = r42 + 1;
        goto L149
    L151:
        int r43 = 0;
        int r44 = 1;
    L152:
        if (r44 >= r40) goto L157;
        if (r41[r44] == false) goto L156;
        r43 = r43 + 1;
    L156:
        r44 = r44 + 1;
        goto L152
    L157:
        this.mInterpolateVariables = new int[r43];
        int r45 = Math.max(2, r43);
        this.mInterpolateData = new double[r45];
        this.mInterpolateVelocity = new double[r45];
        int r46 = 0;
        int r47 = 1;
    L158:
        if (r47 >= r40) goto L163;
        if (r41[r47] == false) goto L162;
        this.mInterpolateVariables[r46] = r47;
        r46 = r46 + 1;
    L162:
        r47 = r47 + 1;
        goto L158
    L163:
        double[][] r48 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r26, this.mInterpolateVariables.length});
        double[] r49 = new double[r26];
        int r50 = 0;
    L164:
        if (r50 >= r26) goto L166;
        r27[r50].fillStandard(r48[r50], this.mInterpolateVariables);
        r49[r50] = r27[r50].time;
        r50 = r50 + 1;
        goto L164
    L166:
        int r51 = 0;
    L167:
        int[] r52 = this.mInterpolateVariables;
        if (r51 >= r52.length) goto L175;
        if (r52[r51] >= MotionPaths.names.length) goto L174;
        String r53 = MotionPaths.names[this.mInterpolateVariables[r51]] + " [";
        int r113 = 0;
    L172:
        if (r113 >= r26) goto L174;
        r53 = r53 + r48[r113][r51];
        r113 = r113 + 1;
    L174:
        r51 = r51 + 1;
        goto L167
    L175:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r54 = 0;
    L176:
        String[] r55 = this.mAttributeNames;
        if (r54 >= r55.length) goto L187;
        String r56 = r55[r54];
        int r114 = r10;
        int r115 = r114;
        double[] r116 = null;
        double[][] r117 = null;
    L179:
        if (r114 >= r26) goto L186;
        if (r27[r114].hasCustomData(r56) == false) goto L185;
        if (r117 != null) goto L184;
        r116 = new double[r26];
        int[] r118 = new int[r25];
        r118[1] = r27[r114].getCustomDataCount(r56);
        r118[r10] = r26;
        r117 = (double[][]) Array.newInstance(Double.TYPE, r118);
    L184:
        r116[r115] = r27[r114].time;
        r27[r114].getCustomData(r56, r117[r115], 0);
        r115 = r115 + 1;
    L185:
        r114 = r114 + 1;
        r25 = 2;
        r10 = 0;
        goto L179
    L186:
        r54 = r54 + 1;
        this.mSpline[r54] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r116, r115), (double[][]) Arrays.copyOf(r117, r115));
        r25 = 2;
        r10 = 0;
        goto L176
    L187:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r49, r48);
        if (r27[0].mPathMotionArc == Key.UNSET) goto L193;
        int[] r57 = new int[r26];
        double[] r58 = new double[r26];
        double[][] r59 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r26, 2});
        int r119 = 0;
    L190:
        if (r119 >= r26) goto L192;
        r57[r119] = r27[r119].mPathMotionArc;
        r58[r119] = r27[r119].time;
        r59[r119][0] = r27[r119].x;
        r59[r119][1] = r27[r119].y;
        r119 = r119 + 1;
        goto L190
    L192:
        this.mArcSpline = CurveFit.getArc(r57, r58, r59);
    L193:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L217;
        Iterator<String> r60 = r3.iterator();
        float r61 = Float.NaN;
    L197:
        if (r60.hasNext() == false) goto L207;
        String r62 = r60.next();
        ViewOscillator r63 = ViewOscillator.makeSpline(r62);
        if (r63 == null) goto L197;
        if (r63.variesByPath() == true) goto L204;
    L206:
        r63.setType(r62);
        this.mCycleMap.put(r62, r63);
        goto L197
    L204:
        if (Float.isNaN(r61) == false) goto L206;
        r61 = getPreCycleDistance();
        goto L206
    L207:
        Iterator<Key> r64 = this.mKeyList.iterator();
    L209:
        if (r64.hasNext() == false) goto L213;
        Key r65 = r64.next();
        if ((r65 instanceof KeyCycle) == false) goto L209;
        ((KeyCycle) r65).addCycleValues(this.mCycleMap);
        goto L209
    L213:
        Iterator<ViewOscillator> r0 = this.mCycleMap.values().iterator();
    L215:
        if (r0.hasNext() == false) goto L320;
        r0.next().setup(r61);
        goto L215
    L320:
        return;
    L217:
        return;
    L147:
        r39 = false;
        goto L148
    L118:
        if (this.mCurveFitType != (-1)) goto L120;
        this.mCurveFitType = 0;
        goto L120
    L75:
        if (this.mTimeCycleAttributesMap != null) goto L77;
        this.mTimeCycleAttributesMap = new HashMap();
    L77:
        Iterator<String> r66 = r1.iterator();
    L79:
        if (r66.hasNext() == false) goto L99;
        String r67 = r66.next();
        if (this.mTimeCycleAttributesMap.containsKey(r67) == true) goto L79;
        if (r67.startsWith("CUSTOM,") == false) goto L95;
        SparseArray r68 = new SparseArray();
        String r120 = r67.split(SimContactsConstants.EMAIL_SEP)[1];
        Iterator<Key> r121 = this.mKeyList.iterator();
    L87:
        if (r121.hasNext() == false) goto L94;
        Key r122 = r121.next();
        if (r122.mCustomConstraints == null) goto L87;
        ConstraintAttribute r123 = r122.mCustomConstraints.get(r120);
        if (r123 == null) goto L87;
        r68.append(r122.mFramePosition, r123);
        goto L87
    L94:
        ViewTimeCycle r69 = ViewTimeCycle.makeCustomSpline(r67, r68);
    L96:
        if (r69 == null) goto L79;
        r69.setType(r67);
        this.mTimeCycleAttributesMap.put(r67, r69);
        goto L79
    L95:
        r69 = ViewTimeCycle.makeSpline(r67, currentTime);
        goto L96
    L99:
        ArrayList<Key> r70 = this.mKeyList;
        if (r70 == null) goto L107;
        Iterator<Key> r71 = r70.iterator();
    L103:
        if (r71.hasNext() == false) goto L107;
        Key r72 = r71.next();
        if ((r72 instanceof KeyTimeCycle) == false) goto L103;
        ((KeyTimeCycle) r72).addTimeValues(this.mTimeCycleAttributesMap);
    L107:
        Iterator<String> r73 = this.mTimeCycleAttributesMap.keySet().iterator();
    L109:
        if (r73.hasNext() == false) goto L115;
        String r74 = r73.next();
        if (r4.containsKey(r74) == false) goto L113;
        int r75 = r4.get(r74).intValue();
    L114:
        this.mTimeCycleAttributesMap.get(r74).setup(r75);
        goto L109
    L113:
        r75 = 0;
        goto L114
    L27:
        r7 = null;
        goto L28
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams r2 = view.getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) r2).getConstraintTag();
        return;
    }

    public View getView() {
        return this.mView;
    }

    void setStartCurrentState(View v) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(v.getX(), v.getY(), v.getWidth(), v.getHeight());
        this.mStartPoint.setState(v);
    }

    public void setStartState(ViewState rect, View v, int rotation, int preWidth, int preHeight) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        Rect r0 = new Rect();
        if (rotation == 1) goto L7;
        if (rotation != 2) goto L8;
        int r8 = rect.left + rect.right;
        r0.left = preHeight - (((rect.top + rect.bottom) + rect.width()) / 2);
        r0.top = (r8 - rect.height()) / 2;
        r0.right = r0.left + rect.width();
        r0.bottom = r0.top + rect.height();
    L8:
        this.mStartMotionPath.setBounds(r0.left, r0.top, r0.width(), r0.height());
        this.mStartPoint.setState(r0, v, rotation, rect.rotation);
        return;
    L7:
        int r9 = rect.left + rect.right;
        r0.left = ((rect.top + rect.bottom) - rect.width()) / 2;
        r0.top = preWidth - ((r9 + rect.height()) / 2);
        r0.right = r0.left + rect.width();
        r0.bottom = r0.top + rect.height();
        goto L8
    }

    void rotate(Rect rect, Rect out, int rotation, int preHeight, int preWidth) {
        if (rotation == 1) goto L13;
        if (rotation != 2) goto L6;
        int r1 = rect.left + rect.right;
        out.left = preHeight - (((rect.top + rect.bottom) + rect.width()) / 2);
        out.top = (r1 - rect.height()) / 2;
        out.right = out.left + rect.width();
        out.bottom = out.top + rect.height();
        return;
    L6:
        if (rotation != 3) goto L8;
        int r2 = rect.left + rect.right;
        int r4 = rect.top;
        int r5 = rect.bottom;
        out.left = ((rect.height() / 2) + rect.top) - (r2 / 2);
        out.top = preWidth - ((r2 + rect.height()) / 2);
        out.right = out.left + rect.width();
        out.bottom = out.top + rect.height();
        return;
    L8:
        if (rotation != 4) goto L18;
        int r3 = rect.left + rect.right;
        out.left = preHeight - (((rect.bottom + rect.top) + rect.width()) / 2);
        out.top = (r3 - rect.height()) / 2;
        out.right = out.left + rect.width();
        out.bottom = out.top + rect.height();
        return;
    L18:
        return;
    L13:
        int r6 = rect.left + rect.right;
        out.left = ((rect.top + rect.bottom) - rect.width()) / 2;
        out.top = preWidth - ((r6 + rect.height()) / 2);
        out.right = out.left + rect.width();
        out.bottom = out.top + rect.height();
    }

    void setStartState(Rect cw, ConstraintSet constraintSet, int parentWidth, int parentHeight) {
        int r6 = constraintSet.mRotate;
        if (r6 == 0) goto L5;
        rotate(cw, this.mTempRect, r6, parentWidth, parentHeight);
    L5:
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(cw.left, cw.top, cw.width(), cw.height());
        ConstraintSet.Constraint r10 = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r10);
        this.mMotionStagger = r10.motion.mMotionStagger;
        this.mStartPoint.setState(cw, constraintSet, r6, this.mId);
        this.mTransformPivotTarget = r10.transform.transformPivotTarget;
        this.mQuantizeMotionSteps = r10.motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = r10.motion.mQuantizeMotionPhase;
        this.mQuantizeMotionInterpolator = getInterpolator(this.mView.getContext(), r10.motion.mQuantizeInterpolatorType, r10.motion.mQuantizeInterpolatorString, r10.motion.mQuantizeInterpolatorID);
    }

    private static Interpolator getInterpolator(Context context, int type, String interpolatorString, int id) {
        if (type == (-2)) goto L30;
        if (type == (-1)) goto L27;
        if (type == 0) goto L26;
        if (type == 1) goto L24;
        if (type == 2) goto L22;
        if (type == 4) goto L20;
        if (type == 5) goto L18;
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
        final Easing r1 = Easing.getInterpolator(interpolatorString);
        return new AnonymousClass1(r1);
    L30:
        return AnimationUtils.loadInterpolator(context, id);
    }

    void setEndState(Rect cw, ConstraintSet constraintSet, int parentWidth, int parentHeight) {
        int r6 = constraintSet.mRotate;
        if (r6 == 0) goto L5;
        rotate(cw, this.mTempRect, r6, parentWidth, parentHeight);
        cw = this.mTempRect;
    L5:
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(cw.left, cw.top, cw.width(), cw.height());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(cw, constraintSet, r6, this.mId);
    }

    void setBothStates(View v) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mNoMovement = true;
        this.mStartMotionPath.setBounds(v.getX(), v.getY(), v.getWidth(), v.getHeight());
        this.mEndMotionPath.setBounds(v.getX(), v.getY(), v.getWidth(), v.getHeight());
        this.mStartPoint.setState(v);
        this.mEndPoint.setState(v);
    }

    private float getAdjustedPosition(float position, float[] velocity) {
        float r0 = 0.0f;
        float r2 = 1.0f;
        if (velocity == null) goto L5;
        velocity[0] = 1.0f;
    L15:
        Easing r3 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r11 = this.mMotionPaths.iterator();
        float r4 = Float.NaN;
    L17:
        if (r11.hasNext() == false) goto L26;
        MotionPaths r5 = r11.next();
        if (r5.mKeyFrameEasing == null) goto L17;
        if (r5.time < position) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.time;
        goto L17
    L22:
        r3 = r5.mKeyFrameEasing;
        r0 = r5.time;
        goto L17
    L26:
        if (r3 != null) goto L28;
        return position;
    L28:
        if (Float.isNaN(r4) == true) goto L31;
        r2 = r4;
    L31:
        float r6 = r2 - r0;
        double r12 = (position - r0) / r6;
        float r1 = r0 + (((float) r3.get(r12)) * r6);
        if (velocity == null) goto L35;
        velocity[0] = (float) r3.getDiff(r12);
    L35:
        return r1;
    L5:
        float r7 = this.mStaggerScale;
        if (r7 == 1.0d) goto L15;
        float r8 = this.mStaggerOffset;
        if (position >= r8) goto L11;
        position = 0.0f;
    L11:
        if (position <= r8) goto L15;
        if (position >= 1.0d) goto L15;
        position = Math.min((position - r8) * r7, 1.0f);
        goto L15
    }

    void endTrigger(boolean start) {
        if ("button".equals(Debug.getName(this.mView)) == true) goto L5;
        return;
    L5:
        if (this.mKeyTriggers == null) goto L18;
        int r0 = 0;
    L7:
        KeyTrigger[] r1 = this.mKeyTriggers;
        if (r0 >= r1.length) goto L19;
        KeyTrigger r2 = r1[r0];
        if (start == false) goto L12;
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

    boolean interpolate(View child, float global_position, long time, KeyCache keyCache) {
        float r2 = getAdjustedPosition(global_position, null);
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
        r9.next().setProperty(child, r14);
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
        r13 = r13 | r1.setProperty(child, r14, time, keyCache);
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
        double[] r21 = this.mInterpolateData;
        if (r21.length <= 0) goto L40;
        r20.getPos(r19, r21);
        this.mArcSpline.getSlope(r19, this.mInterpolateVelocity);
    L40:
        if (this.mNoMovement == true) goto L44;
        this.mStartMotionPath.setView(r14, child, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
        this.mForceMeasure = false;
    L44:
        if (this.mTransformPivotTarget != Key.UNSET) goto L46;
    L55:
        HashMap<String, ViewSpline> r22 = this.mAttributesMap;
        if (r22 == null) goto L65;
        Iterator<ViewSpline> r23 = r22.values().iterator();
    L59:
        if (r23.hasNext() == false) goto L65;
        ViewSpline r24 = r23.next();
        if ((r24 instanceof ViewSpline.PathRotate) == false) goto L59;
        double[] r25 = this.mInterpolateVelocity;
        if (r25.length <= 1) goto L59;
        ((ViewSpline.PathRotate) r24).setPathRotate(child, r14, r25[0], r25[1]);
    L65:
        if (r15 == null) goto L68;
        double[] r26 = this.mInterpolateVelocity;
        r16 = r16 | r15.setPathRotate(child, keyCache, r14, time, r26[0], r26[1]);
    L68:
        int r110 = r18;
    L69:
        CurveFit[] r27 = this.mSpline;
        if (r110 >= r27.length) goto L73;
        r27[r110].getPos(r19, this.mValuesBuff);
        CustomSupport.setInterpolatedValue(this.mStartMotionPath.attributes.get(this.mAttributeNames[r110 - 1]), child, this.mValuesBuff);
        r110 = r110 + 1;
        goto L69
    L73:
        if (this.mStartPoint.mVisibilityMode != 0) goto L84;
        if (r14 > 0.0f) goto L78;
        child.setVisibility(this.mStartPoint.visibility);
        goto L84
    L78:
        if (r14 < 1.0f) goto L81;
        child.setVisibility(this.mEndPoint.visibility);
        goto L84
    L81:
        if (this.mEndPoint.visibility == this.mStartPoint.visibility) goto L84;
        child.setVisibility(0);
    L84:
        if (this.mKeyTriggers == null) goto L97;
        int r28 = 0;
    L86:
        KeyTrigger[] r29 = this.mKeyTriggers;
        if (r28 >= r29.length) goto L97;
        r29[r28].conditionallyFire(r14, child);
        r28 = r28 + 1;
    L97:
        HashMap<String, ViewOscillator> r30 = this.mCycleMap;
        if (r30 == null) goto L106;
        Iterator<ViewOscillator> r31 = r30.values().iterator();
    L101:
        if (r31.hasNext() == false) goto L106;
        ViewOscillator r32 = r31.next();
        if ((r32 instanceof ViewOscillator.PathRotateSet) == true) goto L104;
        r32.setProperty(child, r14);
        goto L101
    L104:
        double[] r33 = this.mInterpolateVelocity;
        ((ViewOscillator.PathRotateSet) r32).setPathRotate(child, r14, r33[0], r33[r18]);
    L106:
        return r16;
    L46:
        if (this.mTransformPivotView != null) goto L48;
        this.mTransformPivotView = ((View) child.getParent()).findViewById(this.mTransformPivotTarget);
    L48:
        View r34 = this.mTransformPivotView;
        if (r34 == null) goto L55;
        float r35 = (r34.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r36 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((child.getRight() - child.getLeft()) <= 0) goto L55;
        if ((child.getBottom() - child.getTop()) <= 0) goto L55;
        float r37 = r36 - child.getLeft();
        float r38 = r35 - child.getTop();
        child.setPivotX(r37);
        child.setPivotY(r38);
        goto L55
    L89:
        r18 = 1;
        float r39 = this.mStartMotionPath.x + ((this.mEndMotionPath.x - this.mStartMotionPath.x) * r14);
        float r40 = this.mStartMotionPath.y + ((this.mEndMotionPath.y - this.mStartMotionPath.y) * r14);
        float r41 = this.mStartMotionPath.width + ((this.mEndMotionPath.width - this.mStartMotionPath.width) * r14);
        float r42 = r39 + 0.5f;
        int r43 = (int) r42;
        float r44 = r40 + 0.5f;
        int r45 = (int) r44;
        int r46 = (int) (r42 + r41);
        int r47 = (int) (r44 + (this.mStartMotionPath.height + ((this.mEndMotionPath.height - this.mStartMotionPath.height) * r14)));
        int r48 = r46 - r43;
        int r49 = r47 - r45;
        if (this.mEndMotionPath.width == this.mStartMotionPath.width) goto L92;
    L95:
        child.measure(View.MeasureSpec.makeMeasureSpec(r48, 1073741824), View.MeasureSpec.makeMeasureSpec(r49, 1073741824));
        this.mForceMeasure = false;
    L96:
        child.layout(r43, r45, r46, r47);
        goto L97
    L92:
        if (this.mEndMotionPath.height != this.mStartMotionPath.height) goto L95;
        if (this.mForceMeasure == false) goto L96;
    L31:
        r15 = null;
        r16 = false;
        goto L32
    }

    void getDpDt(float position, float locationX, float locationY, float[] mAnchorDpDt) {
        float r12 = getAdjustedPosition(position, this.mVelocity);
        CurveFit[] r0 = this.mSpline;
        int r1 = 0;
        if (r0 == null) goto L16;
        double r2 = r12;
        r0[0].getSlope(r2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r2, this.mInterpolateData);
        float r13 = this.mVelocity[0];
    L5:
        double[] r9 = this.mInterpolateVelocity;
        if (r1 >= r9.length) goto L8;
        r9[r1] = r9[r1] * ((double) r13);
        r1 = r1 + 1;
        goto L5
    L8:
        CurveFit r14 = this.mArcSpline;
        if (r14 == null) goto L14;
        double[] r3 = this.mInterpolateData;
        if (r3.length <= 0) goto L19;
        r14.getPos(r2, r3);
        this.mArcSpline.getSlope(r2, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, r9, this.mInterpolateData);
        return;
    L16:
        float r15 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r4 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float r5 = (this.mEndMotionPath.width - this.mStartMotionPath.width) + r15;
        float r6 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + r4;
        mAnchorDpDt[0] = (r15 * (1.0f - locationX)) + (r5 * locationX);
        mAnchorDpDt[1] = (r4 * (1.0f - locationY)) + (r6 * locationY);
    }

    void getPostLayoutDvDp(float position, int width, int height, float locationX, float locationY, float[] mAnchorDpDt) {
        float r1 = getAdjustedPosition(position, this.mVelocity);
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
        HashMap<String, ViewOscillator> r19 = this.mCycleMap;
        if (r19 != null) goto L37;
        ViewOscillator r110 = null;
    L38:
        HashMap<String, ViewOscillator> r111 = this.mCycleMap;
        if (r111 == null) goto L42;
        r4 = r111.get("scaleY");
    L42:
        VelocityMatrix r112 = new VelocityMatrix();
        r112.clear();
        r112.setRotationVelocity(r8, r1);
        r112.setTranslationVelocity(r3, r6, r1);
        r112.setScaleVelocity(r10, r12, r1);
        r112.setRotationVelocity(r18, r1);
        r112.setTranslationVelocity(r14, r16, r1);
        r112.setScaleVelocity(r110, r4, r1);
        CurveFit r113 = this.mArcSpline;
        if (r113 == null) goto L49;
        double[] r20 = this.mInterpolateData;
        if (r20.length <= 0) goto L47;
        double r21 = r1;
        r113.getPos(r21, r20);
        this.mArcSpline.getSlope(r21, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r112.applyTransform(locationX, locationY, width, height, mAnchorDpDt);
        return;
    L49:
        int r114 = 0;
        if (this.mSpline == null) goto L57;
        double r22 = getAdjustedPosition(r1, this.mVelocity);
        this.mSpline[0].getSlope(r22, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r22, this.mInterpolateData);
        float r23 = this.mVelocity[0];
    L52:
        double[] r24 = this.mInterpolateVelocity;
        if (r114 >= r24.length) goto L55;
        r24[r114] = r24[r114] * ((double) r23);
        r114 = r114 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(locationX, locationY, mAnchorDpDt, this.mInterpolateVariables, r24, this.mInterpolateData);
        r112.applyTransform(locationX, locationY, width, height, mAnchorDpDt);
        return;
    L57:
        float r115 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r116 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        ViewOscillator r117 = r4;
        float r118 = (this.mEndMotionPath.width - this.mStartMotionPath.width) + r115;
        float r25 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + r116;
        mAnchorDpDt[0] = (r115 * (1.0f - locationX)) + (r118 * locationX);
        mAnchorDpDt[1] = (r116 * (1.0f - locationY)) + (r25 * locationY);
        r112.clear();
        r112.setRotationVelocity(r8, r1);
        r112.setTranslationVelocity(r3, r6, r1);
        r112.setScaleVelocity(r10, r12, r1);
        r112.setRotationVelocity(r18, r1);
        r112.setTranslationVelocity(r14, r16, r1);
        r112.setScaleVelocity(r110, r117, r1);
        r112.applyTransform(locationX, locationY, width, height, mAnchorDpDt);
        return;
    L37:
        r110 = r19.get("scaleX");
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

    public void setDrawPath(int debugMode) {
        this.mStartMotionPath.mDrawPath = debugMode;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View view, KeyPositionBase key, float x, float y, String[] attribute, float[] value) {
        RectF r2 = new RectF();
        r2.left = this.mStartMotionPath.x;
        r2.top = this.mStartMotionPath.y;
        r2.right = r2.left + this.mStartMotionPath.width;
        r2.bottom = r2.top + this.mStartMotionPath.height;
        RectF r3 = new RectF();
        r3.left = this.mEndMotionPath.x;
        r3.top = this.mEndMotionPath.y;
        r3.right = r3.left + this.mEndMotionPath.width;
        r3.bottom = r3.top + this.mEndMotionPath.height;
        key.positionAttributes(view, r2, r3, x, y, attribute, value);
    }

    public int getKeyFramePositions(int[] type, float[] pos) {
        Iterator<Key> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        Key r3 = r0.next();
        int r11 = r2 + 1;
        type[r2] = r3.mFramePosition + (r3.mType * 1000);
        double r4 = r3.mFramePosition / 100.0f;
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r4, this.mInterpolateVariables, this.mInterpolateData, pos, r10);
        r10 = r10 + 2;
        r2 = r11;
        goto L4
    L6:
        return r2;
    }

    public int getKeyFrameInfo(int type, int[] info) {
        float[] r2 = new float[2];
        Iterator<Key> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        Key r14 = r10.next();
        if (r14.mType == type) goto L10;
        if (type == (-1)) goto L4;
    L10:
        info[r13] = 0;
        int r3 = r13 + 1;
        info[r3] = r14.mType;
        int r16 = r3 + 1;
        info[r16] = r14.mFramePosition;
        double r5 = r14.mFramePosition / 100.0f;
        this.mSpline[0].getPos(r5, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r5, this.mInterpolateVariables, this.mInterpolateData, r2, 0);
        int r17 = r16 + 1;
        info[r17] = Float.floatToIntBits(r2[0]);
        int r18 = r17 + 1;
        info[r18] = Float.floatToIntBits(r2[1]);
        if ((r14 instanceof KeyPosition) == false) goto L13;
        KeyPosition r15 = (KeyPosition) r14;
        int r19 = r18 + 1;
        info[r19] = r15.mPositionType;
        int r110 = r19 + 1;
        info[r110] = Float.floatToIntBits(r15.mPercentX);
        r18 = r110 + 1;
        info[r18] = Float.floatToIntBits(r15.mPercentY);
    L13:
        int r111 = r18 + 1;
        info[r13] = r111 - r13;
        r12 = r12 + 1;
        r13 = r111;
        goto L4
    L14:
        return r12;
    }
}
