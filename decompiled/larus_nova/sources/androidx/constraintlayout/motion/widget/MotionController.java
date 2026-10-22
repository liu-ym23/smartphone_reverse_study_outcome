package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private int mPathMotionArc;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    private float getPreCycleDistance() {
        float[] r100 = new float[2];
        float r101 = 1.0f / 99;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r103 = 0.0d;
        int r110 = 0;
        float r111 = 0.0f;
    L4:
        if (r110 >= 100) goto L27;
        float r112 = r110 * r101;
        double r113 = r112;
        Easing r114 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r104 = this.mMotionPaths.iterator();
        float r115 = Float.NaN;
        float r116 = 0.0f;
    L7:
        if (r104.hasNext() == false) goto L17;
        MotionPaths r105 = r104.next();
        Easing r106 = r105.mKeyFrameEasing;
        float r117 = r101;
        if (r106 == null) goto L16;
        float r107 = r105.time;
        if (r107 >= r112) goto L14;
        r116 = r107;
        r114 = r106;
        goto L16
    L14:
        if (Float.isNaN(r115) == false) goto L16;
        r115 = r105.time;
    L16:
        r101 = r117;
        goto L7
    L17:
        float r118 = r101;
        if (r114 != null) goto L20;
    L23:
        this.mSpline[0].getPos(r113, this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r100, 0);
        if (r110 <= 0) goto L26;
        r111 = (float) (((double) r111) + Math.hypot(r103 - ((double) r100[1]), r102 - ((double) r100[0])));
    L26:
        r102 = r100[0];
        r103 = r100[1];
        r110 = r110 + 1;
        r101 = r118;
        goto L4
    L20:
        if (Float.isNaN(r115) == false) goto L22;
        r115 = 1.0f;
    L22:
        float r119 = r115 - r116;
        r113 = (((float) r114.get((r112 - r116) / r119)) * r119) + r116;
        goto L23
    L27:
        return r111;
    }

    public int getDrawPath() {
        int r100 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> r101 = this.mMotionPaths.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100 = Math.max(r100, r101.next().mDrawPath);
        goto L4
    L7:
        return Math.max(r100, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalX() {
        return this.mEndMotionPath.f15330x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f15331y;
    }

    public float getStartX() {
        return this.mStartMotionPath.f15330x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f15331y;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f15330x + " y: " + this.mStartMotionPath.f15331y + " end: x: " + this.mEndMotionPath.f15330x + " y: " + this.mEndMotionPath.f15331y;
    }

    public MotionController(View r100) {
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
        setView(r100);
    }

    private void insertKey(MotionPaths r100) {
        int r101 = Collections.binarySearch(this.mMotionPaths, r100);
        if (r101 != 0) goto L5;
        float r102 = r100.position;
    L5:
        ListProtector.add(this.mMotionPaths, (-r101) - 1, r100);
    }

    private void readView(MotionPaths r100) {
        r100.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key r100) {
        this.mKeyList.add(r100);
    }

    public void addKeys(ArrayList<Key> r100) {
        this.mKeyList.addAll(r100);
    }

    public MotionPaths getKeyFrame(int r100) {
        return (MotionPaths) ListProtector.get(this.mMotionPaths, r100);
    }

    public void setDrawPath(int r100) {
        this.mStartMotionPath.mDrawPath = r100;
    }

    public void setPathMotionArc(int r100) {
        this.mPathMotionArc = r100;
    }

    public void setStartCurrentState(View r100) {
        MotionPaths r101 = this.mStartMotionPath;
        r101.time = 0.0f;
        r101.position = 0.0f;
        r101.setBounds(r100.getX(), r100.getY(), r100.getWidth(), r100.getHeight());
        this.mStartPoint.setState(r100);
    }

    public void setView(View r100) {
        this.mView = r100;
        this.mId = r100.getId();
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) r101).getConstraintTag();
        return;
    }

    private float getAdjustedPosition(float r110, float[] r111) {
        float r100 = 0.0f;
        float r101 = 1.0f;
        if (r111 == null) goto L5;
        r111[0] = 1.0f;
    L15:
        Easing r102 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r103 = this.mMotionPaths.iterator();
        float r104 = Float.NaN;
    L17:
        if (r103.hasNext() == false) goto L26;
        MotionPaths r105 = r103.next();
        Easing r106 = r105.mKeyFrameEasing;
        if (r106 == null) goto L17;
        float r107 = r105.time;
        if (r107 < r110) goto L22;
        if (Float.isNaN(r104) == false) goto L17;
        r104 = r105.time;
        goto L17
    L22:
        r102 = r106;
        r100 = r107;
        goto L17
    L26:
        if (r102 != null) goto L28;
    L34:
        return r110;
    L28:
        if (Float.isNaN(r104) == true) goto L31;
        r101 = r104;
    L31:
        float r108 = r101 - r100;
        double r109 = (r110 - r100) / r108;
        r110 = (((float) r102.get(r109)) * r108) + r100;
        if (r111 == null) goto L34;
        r111[0] = (float) r102.getDiff(r109);
        goto L34
    L5:
        float r112 = this.mStaggerScale;
        if (r112 == 1.0d) goto L15;
        float r113 = this.mStaggerOffset;
        if (r110 >= r113) goto L11;
        r110 = 0.0f;
    L11:
        if (r110 <= r113) goto L15;
        if (r110 >= 1.0d) goto L15;
        r110 = (r110 - r113) * r112;
        goto L15
    }

    public void buildBounds(float[] r110, int r111) {
        float r100 = 1.0f / (r111 - 1);
        HashMap<String, SplineSet> r101 = this.mAttributesMap;
        if (r101 == null) goto L6;
        SplineSet r102 = r101.get(LiveDegradeFpsAnimator.TRANSLATION_X);
    L6:
        HashMap<String, SplineSet> r103 = this.mAttributesMap;
        if (r103 == null) goto L10;
        SplineSet r104 = r103.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L10:
        HashMap<String, KeyCycleOscillator> r105 = this.mCycleMap;
        if (r105 == null) goto L14;
        KeyCycleOscillator r106 = r105.get(LiveDegradeFpsAnimator.TRANSLATION_X);
    L14:
        HashMap<String, KeyCycleOscillator> r107 = this.mCycleMap;
        if (r107 == null) goto L18;
        KeyCycleOscillator r108 = r107.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L18:
        int r109 = 0;
    L19:
        if (r109 >= r111) goto L52;
        float r112 = r109 * r100;
        float r113 = this.mStaggerScale;
        float r114 = 0.0f;
        if (r113 == 1.0f) goto L30;
        float r115 = this.mStaggerOffset;
        if (r112 >= r115) goto L26;
        r112 = 0.0f;
    L26:
        if (r112 <= r115) goto L30;
        if (r112 >= 1.0d) goto L30;
        r112 = (r112 - r115) * r113;
    L30:
        double r116 = r112;
        Easing r117 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r118 = this.mMotionPaths.iterator();
        float r119 = Float.NaN;
    L32:
        if (r118.hasNext() == false) goto L41;
        MotionPaths r120 = r118.next();
        Easing r121 = r120.mKeyFrameEasing;
        if (r121 == null) goto L32;
        float r122 = r120.time;
        if (r122 < r112) goto L37;
        if (Float.isNaN(r119) == false) goto L32;
        r119 = r120.time;
        goto L32
    L37:
        r117 = r121;
        r114 = r122;
        goto L32
    L41:
        if (r117 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r116, this.mInterpolateData);
        CurveFit r123 = this.mArcSpline;
        if (r123 == null) goto L51;
        double[] r124 = this.mInterpolateData;
        if (r124.length <= 0) goto L51;
        r123.getPos(r116, r124);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r110, r109 * 2);
        r109 = r109 + 1;
        goto L19
    L43:
        if (Float.isNaN(r119) == false) goto L45;
        r119 = 1.0f;
    L45:
        float r125 = r119 - r114;
        r116 = (((float) r117.get((r112 - r114) / r125)) * r125) + r114;
        goto L46
    }

    public int buildKeyBounds(float[] r100, int[] r101) {
        if (r100 == null) goto L16;
        double[] r102 = this.mSpline[0].getTimePoints();
        if (r101 == null) goto L10;
        Iterator<MotionPaths> r103 = this.mMotionPaths.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L10;
        r101[r104] = r103.next().mMode;
        r104 = r104 + 1;
    L10:
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r102.length) goto L15;
        this.mSpline[0].getPos(r102[r105], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r100, r106);
        r106 = r106 + 2;
        r105 = r105 + 1;
        goto L12
    L15:
        return r106 / 2;
    L16:
        return 0;
    }

    public int buildKeyFrames(float[] r100, int[] r101) {
        if (r100 == null) goto L16;
        double[] r102 = this.mSpline[0].getTimePoints();
        if (r101 == null) goto L10;
        Iterator<MotionPaths> r103 = this.mMotionPaths.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L10;
        r101[r104] = r103.next().mMode;
        r104 = r104 + 1;
    L10:
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r102.length) goto L15;
        this.mSpline[0].getPos(r102[r105], this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r100, r106);
        r106 = r106 + 2;
        r105 = r105 + 1;
        goto L12
    L15:
        return r106 / 2;
    L16:
        return 0;
    }

    public void buildPath(float[] r210, int r211) {
        int r100 = r211;
        float r101 = 1.0f;
        float r102 = 1.0f / (r100 - 1);
        HashMap<String, SplineSet> r103 = this.mAttributesMap;
        KeyCycleOscillator r104 = null;
        if (r103 != null) goto L5;
        SplineSet r105 = null;
    L6:
        HashMap<String, SplineSet> r106 = this.mAttributesMap;
        if (r106 != null) goto L9;
        SplineSet r107 = null;
    L10:
        HashMap<String, KeyCycleOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L13;
        KeyCycleOscillator r108 = null;
    L14:
        HashMap<String, KeyCycleOscillator> r111 = this.mCycleMap;
        if (r111 == null) goto L18;
        r104 = r111.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L18:
        int r112 = 0;
    L19:
        if (r112 >= r100) goto L64;
        float r113 = r112 * r102;
        float r114 = this.mStaggerScale;
        float r115 = 0.0f;
        if (r114 == r101) goto L30;
        float r116 = this.mStaggerOffset;
        if (r113 >= r116) goto L26;
        r113 = 0.0f;
    L26:
        if (r113 <= r116) goto L30;
        SplineSet r117 = r105;
        if (r113 >= 1.0d) goto L31;
        r113 = (r113 - r116) * r114;
    L31:
        double r109 = r113;
        Easing r118 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r119 = this.mMotionPaths.iterator();
        float r120 = Float.NaN;
    L33:
        if (r119.hasNext() == false) goto L43;
        MotionPaths r121 = r119.next();
        Easing r122 = r121.mKeyFrameEasing;
        if (r122 == null) goto L33;
        float r123 = r121.time;
        if (r123 >= r113) goto L40;
        r115 = r123;
        r118 = r122;
        goto L33
    L40:
        if (Float.isNaN(r120) == false) goto L33;
        r120 = r121.time;
        goto L33
    L43:
        if (r118 != null) goto L45;
    L48:
        this.mSpline[0].getPos(r109, this.mInterpolateData);
        CurveFit r124 = this.mArcSpline;
        if (r124 == null) goto L53;
        double[] r125 = this.mInterpolateData;
        if (r125.length <= 0) goto L53;
        r124.getPos(r109, r125);
    L53:
        int r126 = r112 * 2;
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r210, r126);
        if (r108 == null) goto L56;
        r210[r126] = r210[r126] + r108.get(r113);
    L58:
        r105 = r117;
    L59:
        if (r104 == null) goto L61;
        int r127 = r126 + 1;
        r210[r127] = r210[r127] + r104.get(r113);
    L63:
        r112 = r112 + 1;
        r100 = r211;
        r101 = 1.0f;
        goto L19
    L61:
        if (r107 == null) goto L63;
        int r128 = r126 + 1;
        r210[r128] = r210[r128] + r107.get(r113);
        goto L63
    L56:
        if (r117 == null) goto L58;
        r105 = r117;
        r210[r126] = r210[r126] + r105.get(r113);
        goto L59
    L45:
        if (Float.isNaN(r120) == false) goto L47;
        r120 = 1.0f;
    L47:
        float r129 = r120 - r115;
        r109 = (((float) r118.get((r113 - r115) / r129)) * r129) + r115;
    L30:
        r117 = r105;
        goto L31
    L64:
        return;
    L13:
        r108 = r110.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        goto L14
    L9:
        r107 = r106.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        goto L10
    L5:
        r105 = r103.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        goto L6
    }

    public void buildRectangles(float[] r100, int r101) {
        float r102 = 1.0f / (r101 - 1);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r103 * r102, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r100, r103 * 8);
        r103 = r103 + 1;
        goto L3
    }

    public int getKeyFrameInfo(int r110, int[] r111) {
        float[] r100 = new float[2];
        Iterator<Key> r101 = this.mKeyList.iterator();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L14;
        Key r104 = r101.next();
        int r105 = r104.mType;
        if (r105 == r110) goto L10;
        if (r110 == (-1)) goto L4;
    L10:
        r111[r103] = 0;
        int r106 = r103 + 1;
        r111[r106] = r105;
        int r107 = r106 + 1;
        int r108 = r104.mFramePosition;
        r111[r107] = r108;
        this.mSpline[0].getPos(r108 / 100.0f, this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r100, 0);
        int r109 = r107 + 1;
        r111[r109] = Float.floatToIntBits(r100[0]);
        int r112 = r109 + 1;
        r111[r112] = Float.floatToIntBits(r100[1]);
        if ((r104 instanceof KeyPosition) == false) goto L13;
        KeyPosition r113 = (KeyPosition) r104;
        int r114 = r112 + 1;
        r111[r114] = r113.mPositionType;
        int r115 = r114 + 1;
        r111[r115] = Float.floatToIntBits(r113.mPercentX);
        r112 = r115 + 1;
        r111[r112] = Float.floatToIntBits(r113.mPercentY);
    L13:
        int r116 = r112 + 1;
        r111[r103] = r116 - r103;
        r102 = r102 + 1;
        r103 = r116;
        goto L4
    L14:
        return r102;
    }

    public int getkeyFramePositions(int[] r100, float[] r110) {
        Iterator<Key> r101 = this.mKeyList.iterator();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        Key r104 = r101.next();
        int r105 = r104.mFramePosition;
        r100[r102] = (r104.mType * 1000) + r105;
        this.mSpline[0].getPos(r105 / 100.0f, this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r110, r103);
        r103 = r103 + 2;
        r102 = r102 + 1;
        goto L4
    L6:
        return r102;
    }

    public void setEndState(ConstraintWidget r100, ConstraintSet r101) {
        MotionPaths r102 = this.mEndMotionPath;
        r102.time = 1.0f;
        r102.position = 1.0f;
        readView(r102);
        this.mEndMotionPath.setBounds(r100.getX(), r100.getY(), r100.getWidth(), r100.getHeight());
        this.mEndMotionPath.applyParameters(r101.getParameters(this.mId));
        this.mEndPoint.setState(r100, r101, this.mId);
    }

    public void setStartState(ConstraintWidget r100, ConstraintSet r101) {
        MotionPaths r102 = this.mStartMotionPath;
        r102.time = 0.0f;
        r102.position = 0.0f;
        readView(r102);
        this.mStartMotionPath.setBounds(r100.getX(), r100.getY(), r100.getWidth(), r100.getHeight());
        ConstraintSet.Constraint r103 = r101.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r103);
        this.mMotionStagger = r103.motion.mMotionStagger;
        this.mStartPoint.setState(r100, r101, this.mId);
    }

    public void buildRect(float r100, float[] r101, int r102) {
        this.mSpline[0].getPos(getAdjustedPosition(r100, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r101, r102);
    }

    public int getAttributeValues(String r100, float[] r101, int r102) {
        SplineSet r103 = this.mAttributesMap.get(r100);
        if (r103 != null) goto L6;
        return -1;
    L6:
        int r104 = 0;
    L8:
        if (r104 >= r101.length) goto L11;
        r101[r104] = r103.get(r104 / (r101.length - 1));
        r104 = r104 + 1;
        goto L8
    L11:
        return r101.length;
    }

    public float getKeyFrameParameter(int r110, float r111, float r112) {
        MotionPaths r100 = this.mEndMotionPath;
        float r101 = r100.f15330x;
        MotionPaths r102 = this.mStartMotionPath;
        float r103 = r102.f15330x;
        float r104 = r101 - r103;
        float r105 = r100.f15331y;
        float r106 = r102.f15331y;
        float r107 = r105 - r106;
        float r108 = r103 + (r102.width / 2.0f);
        float r109 = r106 + (r102.height / 2.0f);
        float r113 = (float) Math.hypot(r104, r107);
        if (r113 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r114 = r111 - r108;
        float r115 = r112 - r109;
        if (((float) Math.hypot(r114, r115)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r116 = (r114 * r104) + (r115 * r107);
        if (r110 == 0) goto L33;
        if (r110 == 1) goto L31;
        if (r110 == 2) goto L29;
        if (r110 == 3) goto L27;
        if (r110 == 4) goto L25;
        if (r110 == 5) goto L23;
        return 0.0f;
    L23:
        return r115 / r107;
    L25:
        return r114 / r107;
    L27:
        return r115 / r104;
    L29:
        return r114 / r104;
    L31:
        return (float) Math.sqrt((r113 * r113) - (r116 * r116));
    L33:
        return r116 / r113;
    }

    public void getDpDt(float r110, float r111, float r112, float[] r113) {
        float r114 = getAdjustedPosition(r110, this.mVelocity);
        CurveFit[] r100 = this.mSpline;
        int r101 = 0;
        if (r100 == null) goto L16;
        double r102 = r114;
        r100[0].getSlope(r102, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r102, this.mInterpolateData);
        float r115 = this.mVelocity[0];
    L5:
        double[] r103 = this.mInterpolateVelocity;
        if (r101 >= r103.length) goto L8;
        r103[r101] = r103[r101] * ((double) r115);
        r101 = r101 + 1;
        goto L5
    L8:
        CurveFit r116 = this.mArcSpline;
        if (r116 == null) goto L14;
        double[] r104 = this.mInterpolateData;
        if (r104.length <= 0) goto L19;
        r116.getPos(r102, r104);
        this.mArcSpline.getSlope(r102, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r111, r112, r113, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(r111, r112, r113, this.mInterpolateVariables, r103, this.mInterpolateData);
        return;
    L16:
        MotionPaths r117 = this.mEndMotionPath;
        float r105 = r117.f15330x;
        MotionPaths r106 = this.mStartMotionPath;
        float r107 = r105 - r106.f15330x;
        float r108 = r117.f15331y - r106.f15331y;
        float r109 = (r117.width - r106.width) + r107;
        float r118 = (r117.height - r106.height) + r108;
        r113[0] = (r107 * (1.0f - r111)) + (r109 * r111);
        r113[1] = (r108 * (1.0f - r112)) + (r118 * r112);
    }

    public KeyPositionBase getPositionKeyframe(int r110, int r111, float r112, float r113) {
        RectF r100 = new RectF();
        MotionPaths r101 = this.mStartMotionPath;
        float r102 = r101.f15330x;
        r100.left = r102;
        float r103 = r101.f15331y;
        r100.top = r103;
        r100.right = r102 + r101.width;
        r100.bottom = r103 + r101.height;
        RectF r104 = new RectF();
        MotionPaths r105 = this.mEndMotionPath;
        float r106 = r105.f15330x;
        r104.left = r106;
        float r107 = r105.f15331y;
        r104.top = r107;
        r104.right = r106 + r105.width;
        r104.bottom = r107 + r105.height;
        Iterator<Key> r108 = this.mKeyList.iterator();
    L4:
        if (r108.hasNext() == false) goto L10;
        Key r109 = r108.next();
        if ((r109 instanceof KeyPositionBase) == false) goto L4;
        KeyPositionBase r114 = (KeyPositionBase) r109;
        if (r114.intersects(r110, r111, r100, r104, r112, r113) == false) goto L4;
        return r114;
    L10:
        return null;
    }

    public boolean interpolate(View r210, float r211, long r212, KeyCache r213) {
        float r110 = getAdjustedPosition(r211, null);
        HashMap<String, SplineSet> r100 = this.mAttributesMap;
        if (r100 == null) goto L8;
        Iterator<SplineSet> r101 = r100.values().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().setProperty(r210, r110);
    L8:
        HashMap<String, TimeCycleSplineSet> r102 = this.mTimeCycleAttributesMap;
        if (r102 == null) goto L18;
        Iterator<TimeCycleSplineSet> r103 = r102.values().iterator();
        TimeCycleSplineSet.PathRotate r104 = null;
        boolean r105 = false;
    L12:
        if (r103.hasNext() == false) goto L17;
        TimeCycleSplineSet r106 = r103.next();
        if ((r106 instanceof TimeCycleSplineSet.PathRotate) == true) goto L15;
        r105 = r105 | r106.setProperty(r210, r110, r212, r213);
        goto L12
    L15:
        r104 = (TimeCycleSplineSet.PathRotate) r106;
        goto L12
    L17:
        boolean r111 = r105;
    L19:
        CurveFit[] r107 = this.mSpline;
        if (r107 == null) goto L58;
        double r108 = r110;
        r107[0].getPos(r108, this.mInterpolateData);
        this.mSpline[0].getSlope(r108, this.mInterpolateVelocity);
        CurveFit r109 = this.mArcSpline;
        if (r109 == null) goto L26;
        double[] r112 = this.mInterpolateData;
        if (r112.length <= 0) goto L26;
        r109.getPos(r108, r112);
        this.mArcSpline.getSlope(r108, this.mInterpolateVelocity);
    L26:
        this.mStartMotionPath.setView(r210, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
        HashMap<String, SplineSet> r113 = this.mAttributesMap;
        if (r113 == null) goto L34;
        Iterator<SplineSet> r114 = r113.values().iterator();
    L30:
        if (r114.hasNext() == false) goto L34;
        SplineSet r115 = r114.next();
        if ((r115 instanceof SplineSet.PathRotate) == false) goto L30;
        double[] r116 = this.mInterpolateVelocity;
        ((SplineSet.PathRotate) r115).setPathRotate(r210, r110, r116[0], r116[1]);
    L34:
        if (r104 == null) goto L37;
        double[] r117 = this.mInterpolateVelocity;
        r111 = r104.setPathRotate(r210, r213, r110, r212, r117[0], r117[1]) | r111;
    L37:
        int r118 = 1;
    L38:
        CurveFit[] r119 = this.mSpline;
        if (r118 >= r119.length) goto L41;
        r119[r118].getPos(r108, this.mValuesBuff);
        this.mStartMotionPath.attributes.get(this.mAttributeNames[r118 - 1]).setInterpolatedValue(r210, this.mValuesBuff);
        r118 = r118 + 1;
        goto L38
    L41:
        MotionConstrainedPoint r120 = this.mStartPoint;
        if (r120.mVisibilityMode != 0) goto L53;
        if (r110 > 0.0f) goto L47;
        r210.setVisibility(r120.visibility);
        goto L53
    L47:
        if (r110 < 1.0f) goto L50;
        r210.setVisibility(this.mEndPoint.visibility);
        goto L53
    L50:
        if (this.mEndPoint.visibility == r120.visibility) goto L53;
        r210.setVisibility(0);
    L53:
        if (this.mKeyTriggers == null) goto L64;
        int r121 = 0;
    L55:
        KeyTrigger[] r122 = this.mKeyTriggers;
        if (r121 >= r122.length) goto L64;
        r122[r121].conditionallyFire(r110, r210);
        r121 = r121 + 1;
    L64:
        HashMap<String, KeyCycleOscillator> r123 = this.mCycleMap;
        if (r123 == null) goto L73;
        Iterator<KeyCycleOscillator> r124 = r123.values().iterator();
    L68:
        if (r124.hasNext() == false) goto L73;
        KeyCycleOscillator r125 = r124.next();
        if ((r125 instanceof KeyCycleOscillator.PathRotateSet) == true) goto L71;
        r125.setProperty(r210, r110);
        goto L68
    L71:
        double[] r126 = this.mInterpolateVelocity;
        ((KeyCycleOscillator.PathRotateSet) r125).setPathRotate(r210, r110, r126[0], r126[1]);
    L73:
        return r111;
    L58:
        MotionPaths r127 = this.mStartMotionPath;
        float r128 = r127.f15330x;
        MotionPaths r129 = this.mEndMotionPath;
        float r130 = r128 + ((r129.f15330x - r128) * r110);
        float r131 = r127.f15331y;
        float r132 = r131 + ((r129.f15331y - r131) * r110);
        float r133 = r127.width;
        float r134 = r129.width;
        float r135 = r127.height;
        float r136 = r129.height;
        float r137 = r130 + 0.5f;
        int r138 = (int) r137;
        float r139 = r132 + 0.5f;
        int r140 = (int) r139;
        int r141 = (int) (r137 + (((r134 - r133) * r110) + r133));
        int r142 = (int) (r139 + (((r136 - r135) * r110) + r135));
        int r143 = r141 - r138;
        int r144 = r142 - r140;
        if (r134 == r133) goto L61;
    L62:
        r210.measure(View.MeasureSpec.makeMeasureSpec(r143, 1073741824), View.MeasureSpec.makeMeasureSpec(r144, 1073741824));
    L63:
        r210.layout(r138, r140, r141, r142);
        goto L64
    L61:
        if (r136 == r135) goto L63;
    L18:
        r104 = null;
        r111 = false;
        goto L19
    }

    public void setup(int r110, int r111, float r112, long r210) {
        new HashSet();
        HashSet<String> r100 = new HashSet();
        HashSet<String> r101 = new HashSet();
        HashSet<String> r102 = new HashSet();
        HashMap<String, Integer> r103 = new HashMap();
        int r104 = this.mPathMotionArc;
        if (r104 == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = r104;
    L5:
        this.mStartPoint.different(this.mEndPoint, r101);
        ArrayList<Key> r105 = this.mKeyList;
        if (r105 == null) goto L27;
        Iterator<Key> r106 = r105.iterator();
        ArrayList r107 = null;
    L9:
        if (r106.hasNext() == false) goto L28;
        Key r108 = r106.next();
        if ((r108 instanceof KeyPosition) == true) goto L12;
        if ((r108 instanceof KeyCycle) == true) goto L17;
        if ((r108 instanceof KeyTimeCycle) == true) goto L20;
        if ((r108 instanceof KeyTrigger) == true) goto L23;
        r108.setInterpolation(r103);
        r108.getAttributeNames(r101);
        goto L9
    L23:
        if (r107 != null) goto L25;
        r107 = new ArrayList();
    L25:
        r107.add((KeyTrigger) r108);
        goto L9
    L20:
        r108.getAttributeNames(r100);
        goto L9
    L17:
        r108.getAttributeNames(r102);
        goto L9
    L12:
        KeyPosition r109 = (KeyPosition) r108;
        insertKey(new MotionPaths(r110, r111, r109, this.mStartMotionPath, this.mEndMotionPath));
        int r113 = r109.mCurveFit;
        if (r113 == Key.UNSET) goto L9;
        this.mCurveFitType = r113;
    L28:
        char r114 = 0;
        if (r107 == null) goto L31;
        this.mKeyTriggers = (KeyTrigger[]) r107.toArray(new KeyTrigger[0]);
    L31:
        char r115 = 1;
        if (r101.isEmpty() == true) goto L69;
        this.mAttributesMap = new HashMap();
        Iterator<String> r116 = r101.iterator();
    L35:
        if (r116.hasNext() == false) goto L52;
        String r117 = r116.next();
        if (r117.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r118 = new SparseArray();
        String r119 = r117.split(",")[1];
        Iterator<Key> r120 = this.mKeyList.iterator();
    L40:
        if (r120.hasNext() == false) goto L47;
        Key r121 = r120.next();
        HashMap<String, ConstraintAttribute> r122 = r121.mCustomConstraints;
        if (r122 == null) goto L40;
        ConstraintAttribute r123 = r122.get(r119);
        if (r123 == null) goto L40;
        r118.append(r121.mFramePosition, r123);
        goto L40
    L47:
        SplineSet r124 = SplineSet.makeCustomSpline(r117, r118);
    L49:
        if (r124 == null) goto L35;
        r124.setType(r117);
        this.mAttributesMap.put(r117, r124);
        goto L35
    L48:
        r124 = SplineSet.makeSpline(r117);
        goto L49
    L52:
        ArrayList<Key> r125 = this.mKeyList;
        if (r125 == null) goto L60;
        Iterator<Key> r126 = r125.iterator();
    L56:
        if (r126.hasNext() == false) goto L60;
        Key r127 = r126.next();
        if ((r127 instanceof KeyAttributes) == false) goto L56;
        r127.addValues(this.mAttributesMap);
    L60:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r128 = this.mAttributesMap.keySet().iterator();
    L62:
        if (r128.hasNext() == false) goto L69;
        String r129 = r128.next();
        if (r103.containsKey(r129) == false) goto L66;
        int r130 = r103.get(r129).intValue();
    L67:
        this.mAttributesMap.get(r129).setup(r130);
        goto L62
    L66:
        r130 = 0;
    L69:
        if (r100.isEmpty() == false) goto L71;
    L111:
        int r131 = 2;
        int r132 = this.mMotionPaths.size() + 2;
        MotionPaths[] r133 = new MotionPaths[r132];
        r133[0] = this.mStartMotionPath;
        r133[r132 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L114;
    L116:
        Iterator<MotionPaths> r134 = this.mMotionPaths.iterator();
        int r135 = 1;
    L118:
        if (r134.hasNext() == false) goto L120;
        r133[r135] = r134.next();
        r135 = r135 + 1;
        goto L118
    L120:
        HashSet r136 = new HashSet();
        Iterator<String> r137 = this.mEndMotionPath.attributes.keySet().iterator();
    L122:
        if (r137.hasNext() == false) goto L128;
        String r138 = r137.next();
        if (this.mStartMotionPath.attributes.containsKey(r138) == false) goto L122;
        if (r101.contains("CUSTOM," + r138) == true) goto L122;
        r136.add(r138);
        goto L122
    L128:
        String[] r139 = (String[]) r136.toArray(new String[0]);
        this.mAttributeNames = r139;
        this.mAttributeInterpCount = new int[r139.length];
        int r140 = 0;
    L129:
        String[] r141 = this.mAttributeNames;
        if (r140 >= r141.length) goto L139;
        String r142 = r141[r140];
        this.mAttributeInterpCount[r140] = 0;
        int r143 = 0;
    L132:
        if (r143 >= r132) goto L137;
        if (r133[r143].attributes.containsKey(r142) == true) goto L135;
        r143 = r143 + 1;
        goto L132
    L135:
        int[] r144 = this.mAttributeInterpCount;
        r144[r140] = r144[r140] + r133[r143].attributes.get(r142).noOfInterpValues();
    L137:
        r140 = r140 + 1;
        goto L129
    L139:
        if (r133[0].mPathMotionArc == Key.UNSET) goto L141;
        boolean r145 = true;
    L142:
        int r146 = 18 + r141.length;
        boolean[] r147 = new boolean[r146];
        int r148 = 1;
    L143:
        if (r148 >= r132) goto L145;
        r133[r148].different(r133[r148 - 1], r147, this.mAttributeNames, r145);
        r148 = r148 + 1;
        goto L143
    L145:
        int r149 = 1;
        int r150 = 0;
    L146:
        if (r149 >= r146) goto L151;
        if (r147[r149] == false) goto L150;
        r150 = r150 + 1;
    L150:
        r149 = r149 + 1;
        goto L146
    L151:
        int[] r151 = new int[r150];
        this.mInterpolateVariables = r151;
        this.mInterpolateData = new double[r151.length];
        this.mInterpolateVelocity = new double[r151.length];
        int r152 = 1;
        int r153 = 0;
    L152:
        if (r152 >= r146) goto L157;
        if (r147[r152] == false) goto L156;
        this.mInterpolateVariables[r153] = r152;
        r153 = r153 + 1;
    L156:
        r152 = r152 + 1;
        goto L152
    L157:
        double[][] r154 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r132, this.mInterpolateVariables.length});
        double[] r155 = new double[r132];
        int r156 = 0;
    L158:
        if (r156 >= r132) goto L160;
        r133[r156].fillStandard(r154[r156], this.mInterpolateVariables);
        r155[r156] = r133[r156].time;
        r156 = r156 + 1;
        goto L158
    L160:
        int r157 = 0;
    L161:
        int[] r158 = this.mInterpolateVariables;
        if (r157 >= r158.length) goto L169;
        if (r158[r157] >= MotionPaths.names.length) goto L168;
        String r159 = MotionPaths.names[this.mInterpolateVariables[r157]] + " [";
        int r160 = 0;
    L166:
        if (r160 >= r132) goto L168;
        r159 = r159 + r154[r160][r157];
        r160 = r160 + 1;
    L168:
        r157 = r157 + 1;
        goto L161
    L169:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r161 = 0;
    L170:
        String[] r162 = this.mAttributeNames;
        if (r161 >= r162.length) goto L181;
        String r163 = r162[r161];
        int r164 = 0;
        double[] r165 = null;
        int r166 = 0;
        double[][] r167 = null;
    L173:
        if (r164 >= r132) goto L180;
        if (r133[r164].hasCustomData(r163) == false) goto L179;
        if (r167 != null) goto L178;
        r165 = new double[r132];
        int[] r168 = new int[r131];
        r168[r115] = r133[r164].getCustomDataCount(r163);
        r168[r114] = r132;
        r167 = (double[][]) Array.newInstance(Double.TYPE, r168);
    L178:
        MotionPaths r169 = r133[r164];
        r165[r166] = r169.time;
        r169.getCustomData(r163, r167[r166], 0);
        r166 = r166 + 1;
    L179:
        r164 = r164 + 1;
        r131 = 2;
        r114 = 0;
        r115 = 1;
        goto L173
    L180:
        r161 = r161 + 1;
        this.mSpline[r161] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r165, r166), (double[][]) Arrays.copyOf(r167, r166));
        r131 = 2;
        r114 = 0;
        r115 = 1;
        goto L170
    L181:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r155, r154);
        if (r133[0].mPathMotionArc == Key.UNSET) goto L187;
        int[] r170 = new int[r132];
        double[] r171 = new double[r132];
        double[][] r172 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r132, 2});
        int r173 = 0;
    L184:
        if (r173 >= r132) goto L186;
        MotionPaths r174 = r133[r173];
        r170[r173] = r174.mPathMotionArc;
        r171[r173] = r174.time;
        double[] r175 = r172[r173];
        r175[0] = r174.f15330x;
        r175[1] = r174.f15331y;
        r173 = r173 + 1;
        goto L184
    L186:
        this.mArcSpline = CurveFit.getArc(r170, r171, r172);
    L187:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L211;
        Iterator<String> r176 = r102.iterator();
        float r177 = Float.NaN;
    L191:
        if (r176.hasNext() == false) goto L201;
        String r178 = r176.next();
        KeyCycleOscillator r179 = KeyCycleOscillator.makeSpline(r178);
        if (r179 == null) goto L191;
        if (r179.variesByPath() == true) goto L198;
    L200:
        r179.setType(r178);
        this.mCycleMap.put(r178, r179);
        goto L191
    L198:
        if (Float.isNaN(r177) == false) goto L200;
        r177 = getPreCycleDistance();
        goto L200
    L201:
        Iterator<Key> r180 = this.mKeyList.iterator();
    L203:
        if (r180.hasNext() == false) goto L207;
        Key r181 = r180.next();
        if ((r181 instanceof KeyCycle) == false) goto L203;
        ((KeyCycle) r181).addCycleValues(this.mCycleMap);
        goto L203
    L207:
        Iterator<KeyCycleOscillator> r182 = this.mCycleMap.values().iterator();
    L209:
        if (r182.hasNext() == false) goto L310;
        r182.next().setup(r177);
        goto L209
    L310:
        return;
    L211:
        return;
    L141:
        r145 = false;
        goto L142
    L114:
        if (this.mCurveFitType != (-1)) goto L116;
        this.mCurveFitType = 0;
        goto L116
    L71:
        if (this.mTimeCycleAttributesMap != null) goto L73;
        this.mTimeCycleAttributesMap = new HashMap();
    L73:
        Iterator<String> r183 = r100.iterator();
    L75:
        if (r183.hasNext() == false) goto L95;
        String r184 = r183.next();
        if (this.mTimeCycleAttributesMap.containsKey(r184) == true) goto L75;
        if (r184.startsWith("CUSTOM,") == false) goto L91;
        SparseArray r185 = new SparseArray();
        String r186 = r184.split(",")[1];
        Iterator<Key> r187 = this.mKeyList.iterator();
    L83:
        if (r187.hasNext() == false) goto L90;
        Key r188 = r187.next();
        HashMap<String, ConstraintAttribute> r189 = r188.mCustomConstraints;
        if (r189 == null) goto L83;
        ConstraintAttribute r190 = r189.get(r186);
        if (r190 == null) goto L83;
        r185.append(r188.mFramePosition, r190);
        goto L83
    L90:
        TimeCycleSplineSet r191 = TimeCycleSplineSet.makeCustomSpline(r184, r185);
    L92:
        if (r191 == null) goto L75;
        r191.setType(r184);
        this.mTimeCycleAttributesMap.put(r184, r191);
        goto L75
    L91:
        r191 = TimeCycleSplineSet.makeSpline(r184, r210);
        goto L92
    L95:
        ArrayList<Key> r192 = this.mKeyList;
        if (r192 == null) goto L103;
        Iterator<Key> r193 = r192.iterator();
    L99:
        if (r193.hasNext() == false) goto L103;
        Key r194 = r193.next();
        if ((r194 instanceof KeyTimeCycle) == false) goto L99;
        ((KeyTimeCycle) r194).addTimeValues(this.mTimeCycleAttributesMap);
    L103:
        Iterator<String> r195 = this.mTimeCycleAttributesMap.keySet().iterator();
    L105:
        if (r195.hasNext() == false) goto L111;
        String r196 = r195.next();
        if (r103.containsKey(r196) == false) goto L109;
        int r197 = r103.get(r196).intValue();
    L110:
        this.mTimeCycleAttributesMap.get(r196).setup(r197);
        goto L105
    L109:
        r197 = 0;
        goto L110
    L27:
        r107 = null;
        goto L28
    }

    public void getPostLayoutDvDp(float r110, int r210, int r211, float r212, float r213, float[] r214) {
        float r100 = getAdjustedPosition(r110, this.mVelocity);
        HashMap<String, SplineSet> r101 = this.mAttributesMap;
        KeyCycleOscillator r102 = null;
        if (r101 != null) goto L5;
        SplineSet r103 = null;
    L6:
        HashMap<String, SplineSet> r104 = this.mAttributesMap;
        if (r104 != null) goto L9;
        SplineSet r105 = null;
    L10:
        HashMap<String, SplineSet> r106 = this.mAttributesMap;
        if (r106 != null) goto L13;
        SplineSet r107 = null;
    L14:
        HashMap<String, SplineSet> r108 = this.mAttributesMap;
        if (r108 != null) goto L17;
        SplineSet r109 = null;
    L18:
        HashMap<String, SplineSet> r111 = this.mAttributesMap;
        if (r111 != null) goto L21;
        SplineSet r112 = null;
    L22:
        HashMap<String, KeyCycleOscillator> r113 = this.mCycleMap;
        if (r113 != null) goto L25;
        KeyCycleOscillator r114 = null;
    L26:
        HashMap<String, KeyCycleOscillator> r115 = this.mCycleMap;
        if (r115 != null) goto L29;
        KeyCycleOscillator r116 = null;
    L30:
        HashMap<String, KeyCycleOscillator> r117 = this.mCycleMap;
        if (r117 != null) goto L33;
        KeyCycleOscillator r118 = null;
    L34:
        HashMap<String, KeyCycleOscillator> r119 = this.mCycleMap;
        if (r119 != null) goto L37;
        KeyCycleOscillator r120 = null;
    L38:
        HashMap<String, KeyCycleOscillator> r121 = this.mCycleMap;
        if (r121 == null) goto L42;
        r102 = r121.get(LiveDegradeFpsAnimator.SCALE_Y);
    L42:
        VelocityMatrix r122 = new VelocityMatrix();
        r122.clear();
        r122.setRotationVelocity(r107, r100);
        r122.setTranslationVelocity(r103, r105, r100);
        r122.setScaleVelocity(r109, r112, r100);
        r122.setRotationVelocity(r118, r100);
        r122.setTranslationVelocity(r114, r116, r100);
        r122.setScaleVelocity(r120, r102, r100);
        CurveFit r123 = this.mArcSpline;
        if (r123 == null) goto L49;
        double[] r124 = this.mInterpolateData;
        if (r124.length <= 0) goto L47;
        double r125 = r100;
        r123.getPos(r125, r124);
        this.mArcSpline.getSlope(r125, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r212, r213, r214, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r122.applyTransform(r212, r213, r210, r211, r214);
        return;
    L49:
        int r126 = 0;
        if (this.mSpline == null) goto L57;
        double r127 = getAdjustedPosition(r100, this.mVelocity);
        this.mSpline[0].getSlope(r127, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r127, this.mInterpolateData);
        float r128 = this.mVelocity[0];
    L52:
        double[] r129 = this.mInterpolateVelocity;
        if (r126 >= r129.length) goto L55;
        r129[r126] = r129[r126] * ((double) r128);
        r126 = r126 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(r212, r213, r214, this.mInterpolateVariables, r129, this.mInterpolateData);
        r122.applyTransform(r212, r213, r210, r211, r214);
        return;
    L57:
        MotionPaths r130 = this.mEndMotionPath;
        float r131 = r130.f15330x;
        MotionPaths r132 = this.mStartMotionPath;
        float r133 = r131 - r132.f15330x;
        KeyCycleOscillator r134 = r102;
        float r135 = r130.f15331y - r132.f15331y;
        KeyCycleOscillator r136 = r120;
        float r137 = (r130.width - r132.width) + r133;
        float r138 = (r130.height - r132.height) + r135;
        r214[0] = (r133 * (1.0f - r212)) + (r137 * r212);
        r214[1] = (r135 * (1.0f - r213)) + (r138 * r213);
        r122.clear();
        r122.setRotationVelocity(r107, r100);
        r122.setTranslationVelocity(r103, r105, r100);
        r122.setScaleVelocity(r109, r112, r100);
        r122.setRotationVelocity(r118, r100);
        r122.setTranslationVelocity(r114, r116, r100);
        r122.setScaleVelocity(r136, r134, r100);
        r122.applyTransform(r212, r213, r210, r211, r214);
        return;
    L37:
        r120 = r119.get(LiveDegradeFpsAnimator.SCALE_X);
        goto L38
    L33:
        r118 = r117.get("rotation");
        goto L34
    L29:
        r116 = r115.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        goto L30
    L25:
        r114 = r113.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        goto L26
    L21:
        r112 = r111.get(LiveDegradeFpsAnimator.SCALE_Y);
        goto L22
    L17:
        r109 = r108.get(LiveDegradeFpsAnimator.SCALE_X);
        goto L18
    L13:
        r107 = r106.get("rotation");
        goto L14
    L9:
        r105 = r104.get(LiveDegradeFpsAnimator.TRANSLATION_Y);
        goto L10
    L5:
        r103 = r101.get(LiveDegradeFpsAnimator.TRANSLATION_X);
        goto L6
    }

    public void positionKeyframe(View r100, KeyPositionBase r110, float r111, float r112, String[] r113, float[] r114) {
        RectF r101 = new RectF();
        MotionPaths r102 = this.mStartMotionPath;
        float r103 = r102.f15330x;
        r101.left = r103;
        float r104 = r102.f15331y;
        r101.top = r104;
        r101.right = r103 + r102.width;
        r101.bottom = r104 + r102.height;
        RectF r105 = new RectF();
        MotionPaths r106 = this.mEndMotionPath;
        float r107 = r106.f15330x;
        r105.left = r107;
        float r108 = r106.f15331y;
        r105.top = r108;
        r105.right = r107 + r106.width;
        r105.bottom = r108 + r106.height;
        r110.positionAttributes(r100, r101, r105, r111, r112, r113, r114);
    }
}
