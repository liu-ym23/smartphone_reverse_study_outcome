package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    private static final float xRotate(float sin, float cos, float cx, float cy, float x, float y) {
        return (((x - cx) * cos) - ((y - cy) * sin)) + cx;
    }

    private static final float yRotate(float sin, float cos, float cx, float cy, float x, float y) {
        return (((x - cx) * sin) + ((y - cy) * cos)) + cy;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionPaths o) {
        return compareTo2(o);
    }

    static {
        names = new String[]{"position", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "pathRotate"};
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    void initCartesian(KeyPosition c, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float r4 = c.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = c.mDrawPath;
        if (Float.isNaN(c.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(c.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = endTimePoint.width;
        float r8 = startTimePoint.width;
        float r10 = endTimePoint.height;
        float r11 = startTimePoint.height;
        this.position = this.time;
        float r13 = startTimePoint.x;
        float r1 = startTimePoint.y;
        float r2 = endTimePoint.x + (r7 / 2.0f);
        float r3 = r2 - ((r8 / 2.0f) + r13);
        float r9 = (endTimePoint.y + (r10 / 2.0f)) - (r1 + (r11 / 2.0f));
        float r12 = (r7 - r8) * r5;
        float r14 = r12 / 2.0f;
        this.x = (int) ((r13 + (r3 * r4)) - r14);
        float r15 = (r10 - r11) * r6;
        float r16 = r15 / 2.0f;
        this.y = (int) ((r1 + (r9 * r4)) - r16);
        this.width = (int) (r8 + r12);
        this.height = (int) (r11 + r15);
        if (Float.isNaN(c.mPercentX) == false) goto L13;
        float r17 = r4;
    L14:
        float r18 = 0.0f;
        if (Float.isNaN(c.mAltPercentY) == false) goto L17;
        float r19 = 0.0f;
    L19:
        if (Float.isNaN(c.mPercentY) == true) goto L23;
        r4 = c.mPercentY;
    L23:
        if (Float.isNaN(c.mAltPercentX) == true) goto L26;
        r18 = c.mAltPercentX;
    L26:
        this.mMode = 0;
        this.x = (int) (((startTimePoint.x + (r17 * r3)) + (r18 * r9)) - r14);
        this.y = (int) (((startTimePoint.y + (r3 * r19)) + (r9 * r4)) - r16);
        this.mKeyFrameEasing = Easing.getInterpolator(c.mTransitionEasing);
        this.mPathMotionArc = c.mPathMotionArc;
        return;
    L17:
        r19 = c.mAltPercentY;
        goto L19
    L13:
        r17 = c.mPercentX;
        goto L14
    L9:
        r6 = c.mPercentHeight;
        goto L10
    L5:
        r5 = c.mPercentWidth;
        goto L7
    }

    public MotionPaths(int parentWidth, int parentHeight, KeyPosition c, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (startTimePoint.mAnimateRelativeTo == Key.UNSET) goto L6;
        initPolar(parentWidth, parentHeight, c, startTimePoint, endTimePoint);
        return;
    L6:
        int r0 = c.mPositionType;
        if (r0 != 1) goto L9;
        initPath(c, startTimePoint, endTimePoint);
        return;
    L9:
        if (r0 == 2) goto L12;
        initCartesian(c, startTimePoint, endTimePoint);
        return;
    L12:
        initScreen(parentWidth, parentHeight, c, startTimePoint, endTimePoint);
    }

    void initPolar(int parentWidth, int parentHeight, KeyPosition c, MotionPaths s, MotionPaths e) {
        float r7 = c.mFramePosition / 100.0f;
        this.time = r7;
        this.mDrawPath = c.mDrawPath;
        this.mMode = c.mPositionType;
        if (Float.isNaN(c.mPercentWidth) == false) goto L5;
        float r8 = r7;
    L7:
        if (Float.isNaN(c.mPercentHeight) == false) goto L9;
        float r0 = r7;
    L10:
        float r1 = e.width;
        float r2 = s.width;
        float r3 = e.height;
        float r4 = s.height;
        this.position = this.time;
        this.width = (int) (r2 + ((r1 - r2) * r8));
        this.height = (int) (r4 + ((r3 - r4) * r0));
        int r5 = c.mPositionType;
        if (r5 == 1) goto L33;
        if (r5 == 2) goto L24;
        if (Float.isNaN(c.mPercentX) == false) goto L17;
        float r9 = r7;
    L18:
        float r6 = e.x;
        float r10 = s.x;
        this.x = (r9 * (r6 - r10)) + r10;
        if (Float.isNaN(c.mPercentY) == true) goto L22;
        r7 = c.mPercentY;
    L22:
        float r11 = e.y;
        float r12 = s.y;
        this.y = (r7 * (r11 - r12)) + r12;
    L41:
        this.mAnimateRelativeTo = s.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c.mTransitionEasing);
        this.mPathMotionArc = c.mPathMotionArc;
        return;
    L17:
        r9 = c.mPercentX;
        goto L18
    L24:
        if (Float.isNaN(c.mPercentX) == false) goto L26;
        float r13 = e.x;
        float r14 = s.x;
        float r15 = ((r13 - r14) * r7) + r14;
    L27:
        this.x = r15;
        if (Float.isNaN(c.mPercentY) == false) goto L30;
        float r16 = e.y;
        float r17 = s.y;
        float r18 = (r7 * (r16 - r17)) + r17;
    L31:
        this.y = r18;
        goto L41
    L30:
        r18 = c.mPercentY;
        goto L31
    L26:
        r15 = Math.min(r0, r8) * c.mPercentX;
        goto L27
    L33:
        if (Float.isNaN(c.mPercentX) == false) goto L35;
        float r19 = r7;
    L36:
        float r20 = e.x;
        float r21 = s.x;
        this.x = (r19 * (r20 - r21)) + r21;
        if (Float.isNaN(c.mPercentY) == true) goto L40;
        r7 = c.mPercentY;
    L40:
        float r22 = e.y;
        float r110 = s.y;
        this.y = (r7 * (r22 - r110)) + r110;
        goto L41
    L35:
        r19 = c.mPercentX;
        goto L36
    L9:
        r0 = c.mPercentHeight;
        goto L10
    L5:
        r8 = c.mPercentWidth;
        goto L7
    }

    public void setupRelative(MotionController mc, MotionPaths relative) {
        double r0 = ((this.x + (this.width / 2.0f)) - relative.x) - (relative.width / 2.0f);
        double r2 = ((this.y + (this.height / 2.0f)) - relative.y) - (relative.height / 2.0f);
        this.mRelativeToController = mc;
        this.x = (float) Math.hypot(r2, r0);
        if (Float.isNaN(this.mRelativeAngle) == false) goto L5;
        this.y = (float) (Math.atan2(r2, r0) + 1.5707963267948966d);
        return;
    L5:
        this.y = (float) Math.toRadians(this.mRelativeAngle);
    }

    void initScreen(int parentWidth, int parentHeight, KeyPosition c, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float r4 = c.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = c.mDrawPath;
        if (Float.isNaN(c.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(c.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = endTimePoint.width;
        float r8 = startTimePoint.width;
        float r10 = endTimePoint.height;
        float r11 = startTimePoint.height;
        this.position = this.time;
        float r13 = startTimePoint.x;
        float r2 = startTimePoint.y;
        float r1 = endTimePoint.x + (r7 / 2.0f);
        float r3 = endTimePoint.y + (r10 / 2.0f);
        float r9 = (r7 - r8) * r5;
        this.x = (int) ((r13 + ((r1 - ((r8 / 2.0f) + r13)) * r4)) - (r9 / 2.0f));
        float r12 = (r10 - r11) * r6;
        this.y = (int) ((r2 + ((r3 - (r2 + (r11 / 2.0f))) * r4)) - (r12 / 2.0f));
        this.width = (int) (r8 + r9);
        this.height = (int) (r11 + r12);
        this.mMode = 2;
        if (Float.isNaN(c.mPercentX) == true) goto L14;
        this.x = (int) (c.mPercentX * ((int) (parentWidth - this.width)));
    L14:
        if (Float.isNaN(c.mPercentY) == true) goto L16;
        this.y = (int) (c.mPercentY * ((int) (parentHeight - this.height)));
    L16:
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c.mTransitionEasing);
        this.mPathMotionArc = c.mPathMotionArc;
        return;
    L9:
        r6 = c.mPercentHeight;
        goto L10
    L5:
        r5 = c.mPercentWidth;
        goto L7
    }

    void initPath(KeyPosition c, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float r4 = c.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = c.mDrawPath;
        if (Float.isNaN(c.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(c.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = endTimePoint.width - startTimePoint.width;
        float r8 = endTimePoint.height - startTimePoint.height;
        this.position = this.time;
        if (Float.isNaN(c.mPercentX) == true) goto L14;
        r4 = c.mPercentX;
    L14:
        float r9 = startTimePoint.x;
        float r10 = startTimePoint.width;
        float r13 = startTimePoint.y;
        float r14 = startTimePoint.height;
        float r2 = endTimePoint.x + (endTimePoint.width / 2.0f);
        float r3 = r2 - ((r10 / 2.0f) + r9);
        float r1 = (endTimePoint.y + (endTimePoint.height / 2.0f)) - ((r14 / 2.0f) + r13);
        float r11 = r3 * r4;
        float r12 = r7 * r5;
        float r15 = r12 / 2.0f;
        this.x = (int) ((r9 + r11) - r15);
        float r16 = r4 * r1;
        float r17 = r8 * r6;
        float r18 = r17 / 2.0f;
        this.y = (int) ((r13 + r16) - r18);
        this.width = (int) (r10 + r12);
        this.height = (int) (r14 + r17);
        if (Float.isNaN(c.mPercentY) == false) goto L17;
        float r19 = 0.0f;
    L18:
        this.mMode = 1;
        float r20 = (int) ((startTimePoint.x + r11) - r15);
        this.x = r20;
        float r21 = (int) ((startTimePoint.y + r16) - r18);
        this.x = r20 + ((-r1) * r19);
        this.y = r21 + (r3 * r19);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c.mTransitionEasing);
        this.mPathMotionArc = c.mPathMotionArc;
        return;
    L17:
        r19 = c.mPercentY;
        goto L18
    L9:
        r6 = c.mPercentHeight;
        goto L10
    L5:
        r5 = c.mPercentWidth;
        goto L7
    }

    private boolean diff(float a, float b) {
        if (Float.isNaN(a) == true) goto L13;
        if (Float.isNaN(b) == true) goto L13;
        if (Math.abs(a - b) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(a) == Float.isNaN(b)) goto L16;
        return true;
    L16:
        return false;
    }

    void different(MotionPaths points, boolean[] mask, String[] custom, boolean arcMode) {
        boolean r8 = diff(this.x, points.x);
        boolean r0 = diff(this.y, points.y);
        mask[0] = mask[0] | diff(this.position, points.position);
        boolean r9 = (r8 | r0) | arcMode;
        mask[1] = mask[1] | r9;
        mask[2] = r9 | mask[2];
        mask[3] = mask[3] | diff(this.width, points.width);
        boolean r10 = mask[4];
        mask[4] = diff(this.height, points.height) | r10;
    }

    void getCenter(double p, int[] toUse, double[] data, float[] point, int offset) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r7 = 0;
    L4:
        if (r7 >= toUse.length) goto L18;
        float r8 = (float) data[r7];
        int r11 = toUse[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.getCenter(p, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        point[offset] = (r2 + (r4 / 2.0f)) + 0.0f;
        point[offset + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    void getCenter(double p, int[] toUse, double[] data, float[] point, double[] vdata, float[] velocity) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r8 = 0;
        float r9 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
    L4:
        if (r8 >= toUse.length) goto L19;
        float r6 = (float) data[r8];
        float r13 = (float) vdata[r8];
        int r14 = toUse[r8];
        if (r14 != 1) goto L8;
        r2 = r6;
        r9 = r13;
    L18:
        r8 = r8 + 1;
        goto L4
    L8:
        if (r14 != 2) goto L10;
        r3 = r6;
        r11 = r13;
        goto L18
    L10:
        if (r14 != 3) goto L12;
        r4 = r6;
        r10 = r13;
        goto L18
    L12:
        if (r14 != 4) goto L18;
        r5 = r6;
        r12 = r13;
        goto L18
    L19:
        float r15 = (r10 / 2.0f) + r9;
        float r16 = (r12 / 2.0f) + r11;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L22;
        float[] r7 = new float[2];
        float[] r17 = new float[2];
        r0.getCenter(p, r7, r17);
        float r18 = r7[0];
        float r19 = r7[1];
        float r110 = r17[0];
        float r1 = r17[1];
        double r20 = r2;
        double r111 = r3;
        float r21 = (float) ((((double) r18) + (Math.sin(r111) * r20)) - ((double) (r4 / 2.0f)));
        float r22 = (float) ((((double) r19) - (r20 * Math.cos(r111))) - ((double) (r5 / 2.0f)));
        double r23 = r9;
        double r24 = r11;
        float r25 = (float) ((((double) r110) + (Math.sin(r111) * r23)) + (Math.cos(r111) * r24));
        r16 = (float) ((((double) r1) - (r23 * Math.cos(r111))) + (Math.sin(r111) * r24));
        r2 = r21;
        r3 = r22;
        r15 = r25;
        float r26 = 2.0f;
    L23:
        point[0] = (r2 + (r4 / r26)) + 0.0f;
        point[1] = (r3 + (r5 / r26)) + 0.0f;
        velocity[0] = r15;
        velocity[1] = r16;
        return;
    L22:
        r26 = 2.0f;
        goto L23
    }

    void getCenterVelocity(double p, int[] toUse, double[] data, float[] point, int offset) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r7 = 0;
    L4:
        if (r7 >= toUse.length) goto L18;
        float r8 = (float) data[r7];
        int r11 = toUse[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.getCenter(p, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        point[offset] = (r2 + (r4 / 2.0f)) + 0.0f;
        point[offset + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    void getBounds(int[] toUse, double[] data, float[] point, int offset) {
        float r0 = this.width;
        float r5 = this.height;
        int r1 = 0;
    L4:
        if (r1 >= toUse.length) goto L13;
        float r2 = (float) data[r1];
        int r3 = toUse[r1];
        if (r3 != 3) goto L8;
        r0 = r2;
    L12:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r3 != 4) goto L12;
        r5 = r2;
        goto L12
    L13:
        point[offset] = r0;
        point[offset + 1] = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void setView(float position, View view, int[] toUse, double[] data, double[] slope, double[] cycle, boolean mForceMeasure) {
        float r4 = this.x;
        float r5 = this.y;
        float r6 = this.width;
        float r7 = this.height;
        if (toUse.length != 0) goto L5;
    L7:
        Arrays.fill(this.mTempValue, Double.NaN);
        int r10 = 0;
    L9:
        if (r10 >= toUse.length) goto L11;
        double[] r11 = this.mTempValue;
        int r12 = toUse[r10];
        r11[r12] = data[r10];
        this.mTempDelta[r12] = slope[r10];
        r10 = r10 + 1;
        goto L9
    L11:
        float r13 = Float.NaN;
        int r14 = 0;
        float r15 = 0.0f;
        float r16 = 0.0f;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L12:
        double[] r2 = this.mTempValue;
        if (r14 >= r2.length) goto L43;
        double r19 = 0.0d;
        if (Double.isNaN(r2[r14]) == false) goto L20;
        if (cycle != null) goto L18;
    L19:
        float r24 = r13;
    L36:
        r13 = r24;
    L42:
        r14 = r14 + 1;
        goto L12
    L18:
        if (cycle[r14] == 0.0d) goto L19;
    L20:
        if (cycle == null) goto L23;
        r19 = cycle[r14];
    L23:
        if (Double.isNaN(this.mTempValue[r14]) == true) goto L26;
        r19 = this.mTempValue[r14] + r19;
    L26:
        r24 = r13;
        float r8 = (float) r19;
        float r9 = (float) this.mTempDelta[r14];
        if (r14 != 1) goto L29;
        r13 = r24;
        r4 = r8;
        r15 = r9;
        goto L42
    L29:
        if (r14 != 2) goto L31;
        r13 = r24;
        r5 = r8;
        r16 = r9;
        goto L42
    L31:
        if (r14 != 3) goto L33;
        r13 = r24;
        r6 = r8;
        r17 = r9;
        goto L42
    L33:
        if (r14 != 4) goto L35;
        r13 = r24;
        r7 = r8;
        r18 = r9;
        goto L42
    L35:
        if (r14 != 5) goto L36;
        r13 = r8;
        goto L42
    L43:
        float r25 = r13;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L53;
        float[] r20 = new float[2];
        float[] r110 = new float[2];
        r0.getCenter(position, r20, r110);
        float r111 = r20[0];
        float r21 = r20[1];
        float r112 = r110[0];
        float r1 = r110[1];
        double r3 = r4;
        double r22 = r5;
        float r23 = (float) ((((double) r111) + (Math.sin(r22) * r3)) - ((double) (r6 / 2.0f)));
        float r113 = r7;
        float r26 = (float) ((((double) r21) - (Math.cos(r22) * r3)) - ((double) (r7 / 2.0f)));
        double r114 = r15;
        double r115 = r16;
        float r27 = (float) ((((double) r112) + (Math.sin(r22) * r114)) + ((Math.cos(r22) * r3) * r115));
        float r28 = (float) ((((double) r1) - (r114 * Math.cos(r22))) + ((r3 * Math.sin(r22)) * r115));
        if (slope.length < 2) goto L48;
        boolean r29 = false;
        slope[0] = r27;
        boolean r116 = true;
        slope[1] = r28;
    L50:
        if (Float.isNaN(r25) == true) goto L52;
        view.setRotation((float) (((double) r25) + Math.toDegrees(Math.atan2(r28, r27))));
    L52:
        r4 = r23;
        r5 = r26;
    L57:
        if ((view instanceof FloatLayout) == false) goto L60;
        ((FloatLayout) view).layout(r4, r5, r6 + r4, r5 + r113);
        return;
    L60:
        float r30 = r4 + 0.5f;
        int r31 = (int) r30;
        float r32 = r5 + 0.5f;
        int r33 = (int) r32;
        int r34 = (int) (r30 + r6);
        int r35 = (int) (r32 + r113);
        int r36 = r34 - r31;
        int r37 = r35 - r33;
        if (r36 == view.getMeasuredWidth()) goto L63;
    L64:
        r29 = r116;
    L65:
        if (r29 == true) goto L67;
        if (mForceMeasure == true) goto L67;
    L68:
        view.layout(r31, r33, r34, r35);
        return;
    L67:
        view.measure(View.MeasureSpec.makeMeasureSpec(r36, 1073741824), View.MeasureSpec.makeMeasureSpec(r37, 1073741824));
        goto L68
    L63:
        if (r37 == view.getMeasuredHeight()) goto L65;
    L48:
        r29 = false;
        r116 = true;
        goto L50
    L53:
        r113 = r7;
        r29 = false;
        r116 = true;
        if (Float.isNaN(r25) == true) goto L57;
        view.setRotation((float) (((double) 0.0f) + (((double) r25) + Math.toDegrees(Math.atan2(r16 + (r18 / 2.0f), r15 + (r17 / 2.0f))))));
        goto L57
    L5:
        if (this.mTempValue.length > toUse[toUse.length - 1]) goto L7;
        int r38 = toUse[toUse.length - 1] + 1;
        this.mTempValue = new double[r38];
        this.mTempDelta = new double[r38];
        goto L7
    }

    void getRect(int[] toUse, double[] data, float[] path, int offset) {
        float r0 = this.x;
        float r1 = this.y;
        float r2 = this.width;
        float r3 = this.height;
        int r4 = 0;
    L4:
        if (r4 >= toUse.length) goto L19;
        float r5 = (float) data[r4];
        int r6 = toUse[r4];
        if (r6 != 1) goto L8;
        r0 = r5;
    L18:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6 != 2) goto L10;
        r1 = r5;
        goto L18
    L10:
        if (r6 != 3) goto L12;
        r2 = r5;
        goto L18
    L12:
        if (r6 != 4) goto L18;
        r3 = r5;
        goto L18
    L19:
        MotionController r10 = this.mRelativeToController;
        if (r10 == null) goto L22;
        float r11 = r10.getCenterX();
        float r9 = this.mRelativeToController.getCenterY();
        double r7 = r0;
        double r8 = r1;
        float r12 = (float) ((((double) r11) + (Math.sin(r8) * r7)) - ((double) (r2 / 2.0f)));
        r1 = (float) ((((double) r9) - (r7 * Math.cos(r8))) - ((double) (r3 / 2.0f)));
        r0 = r12;
    L22:
        float r13 = r2 + r0;
        float r14 = r3 + r1;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int r15 = offset + 1;
        path[offset] = r0 + 0.0f;
        int r16 = r15 + 1;
        path[r15] = r1 + 0.0f;
        int r17 = r16 + 1;
        path[r16] = r13 + 0.0f;
        int r18 = r17 + 1;
        path[r17] = r1 + 0.0f;
        int r19 = r18 + 1;
        path[r18] = r13 + 0.0f;
        int r110 = r19 + 1;
        path[r19] = r14 + 0.0f;
        path[r110] = r0 + 0.0f;
        path[r110 + 1] = r14 + 0.0f;
    }

    void setDpDt(float locationX, float locationY, float[] mAnchorDpDt, int[] toUse, double[] deltaData, double[] data) {
        float r4 = 0.0f;
        float r5 = 0.0f;
        float r6 = 0.0f;
        float r7 = 0.0f;
        int r3 = 0;
    L4:
        if (r3 >= toUse.length) goto L19;
        float r8 = (float) deltaData[r3];
        double r10 = data[r3];
        int r11 = toUse[r3];
        if (r11 != 1) goto L8;
        r4 = r8;
    L18:
        r3 = r3 + 1;
        goto L4
    L8:
        if (r11 != 2) goto L10;
        r6 = r8;
        goto L18
    L10:
        if (r11 != 3) goto L12;
        r5 = r8;
        goto L18
    L12:
        if (r11 != 4) goto L18;
        r7 = r8;
        goto L18
    L19:
        float r9 = r4 - ((0.0f * r5) / 2.0f);
        float r12 = r6 - ((0.0f * r7) / 2.0f);
        mAnchorDpDt[0] = ((r9 * (1.0f - locationX)) + (((r5 * 1.0f) + r9) * locationX)) + 0.0f;
        mAnchorDpDt[1] = ((r12 * (1.0f - locationY)) + (((r7 * 1.0f) + r12) * locationY)) + 0.0f;
    }

    void fillStandard(double[] data, int[] toUse) {
        int r3 = 0;
        float[] r1 = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int r7 = 0;
    L4:
        if (r3 >= toUse.length) goto L9;
        int r2 = toUse[r3];
        if (r2 >= 6) goto L8;
        data[r7] = r1[r2];
        r7 = r7 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    boolean hasCustomData(String name) {
        return this.attributes.containsKey(name);
    }

    int getCustomDataCount(String name) {
        ConstraintAttribute r0 = this.attributes.get(name);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.numberOfInterpolatedValues();
    }

    int getCustomData(String name, double[] value, int offset) {
        ConstraintAttribute r4 = this.attributes.get(name);
        int r5 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.numberOfInterpolatedValues() != 1) goto L9;
        value[offset] = r4.getValueToInterpolate();
        return 1;
    L9:
        int r0 = r4.numberOfInterpolatedValues();
        float[] r1 = new float[r0];
        r4.getValuesToInterpolate(r1);
    L10:
        if (r5 >= r0) goto L12;
        value[offset] = r1[r5];
        r5 = r5 + 1;
        offset = offset + 1;
        goto L10
    L12:
        return r0;
    }

    void setBounds(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionPaths o) {
        return Float.compare(this.position, o.position);
    }

    public void applyParameters(ConstraintSet.Constraint c) {
        this.mKeyFrameEasing = Easing.getInterpolator(c.motion.mTransitionEasing);
        this.mPathMotionArc = c.motion.mPathMotionArc;
        this.mAnimateRelativeTo = c.motion.mAnimateRelativeTo;
        this.mPathRotate = c.motion.mPathRotate;
        this.mDrawPath = c.motion.mDrawPath;
        this.mAnimateCircleAngleTo = c.motion.mAnimateCircleAngleTo;
        this.mProgress = c.propertySet.mProgress;
        this.mRelativeAngle = c.layout.circleAngle;
        Iterator<String> r0 = c.mCustomConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        ConstraintAttribute r2 = c.mCustomConstraints.get(r1);
        if (r2 == null) goto L4;
        if (r2.isContinuous() == false) goto L4;
        this.attributes.put(r1, r2);
        goto L4
    }

    public void configureRelativeTo(MotionController toOrbit) {
        toOrbit.getPos(this.mProgress);
    }
}
