package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.android.contacts.common.SimContactsConstants;
import com.google.common.base.Ascii;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names;
    private float alpha;
    private boolean applyElevation;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    private float elevation;
    private float height;
    private int mAnimateRelativeTo;
    private int mDrawPath;
    private Easing mKeyFrameEasing;
    int mMode;
    private float mPathRotate;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    int mVisibilityMode;
    private float position;
    private float rotation;
    private float rotationX;
    public float rotationY;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;
    private float translationZ;
    int visibility;
    private float width;
    private float x;
    private float y;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint o) {
        return compareTo2(o);
    }

    static {
        names = new String[]{"position", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "pathRotate"};
    }

    public MotionConstrainedPoint() {
        this.alpha = 1.0f;
        this.mVisibilityMode = 0;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mAnimateRelativeTo = -1;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
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

    void different(MotionConstrainedPoint points, HashSet<String> keySet) {
        if (diff(this.alpha, points.alpha) == false) goto L6;
        keySet.add("alpha");
    L6:
        if (diff(this.elevation, points.elevation) == false) goto L8;
        keySet.add("elevation");
    L8:
        int r0 = this.visibility;
        int r2 = points.visibility;
        if (r0 == r2) goto L16;
        if (this.mVisibilityMode != 0) goto L16;
        if (r0 == 0) goto L14;
        if (r2 != 0) goto L16;
    L14:
        keySet.add("alpha");
    L16:
        if (diff(this.rotation, points.rotation) == false) goto L19;
        keySet.add("rotation");
    L19:
        if (Float.isNaN(this.mPathRotate) == true) goto L21;
    L22:
        keySet.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.mProgress) == true) goto L26;
    L27:
        keySet.add("progress");
    L29:
        if (diff(this.rotationX, points.rotationX) == false) goto L32;
        keySet.add("rotationX");
    L32:
        if (diff(this.rotationY, points.rotationY) == false) goto L35;
        keySet.add("rotationY");
    L35:
        if (diff(this.mPivotX, points.mPivotX) == false) goto L38;
        keySet.add("transformPivotX");
    L38:
        if (diff(this.mPivotY, points.mPivotY) == false) goto L41;
        keySet.add("transformPivotY");
    L41:
        if (diff(this.scaleX, points.scaleX) == false) goto L44;
        keySet.add("scaleX");
    L44:
        if (diff(this.scaleY, points.scaleY) == false) goto L47;
        keySet.add("scaleY");
    L47:
        if (diff(this.translationX, points.translationX) == false) goto L50;
        keySet.add("translationX");
    L50:
        if (diff(this.translationY, points.translationY) == false) goto L53;
        keySet.add("translationY");
    L53:
        if (diff(this.translationZ, points.translationZ) == false) goto L56;
        keySet.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(points.mProgress) == true) goto L29;
    L21:
        if (Float.isNaN(points.mPathRotate) == true) goto L24;
        goto L22
    }

    void different(MotionConstrainedPoint points, boolean[] mask, String[] custom) {
        mask[0] = mask[0] | diff(this.position, points.position);
        mask[1] = mask[1] | diff(this.x, points.x);
        mask[2] = mask[2] | diff(this.y, points.y);
        mask[3] = mask[3] | diff(this.width, points.width);
        boolean r0 = mask[4];
        mask[4] = diff(this.height, points.height) | r0;
    }

    void fillStandard(double[] data, int[] toUse) {
        int r3 = 0;
        float[] r1 = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int r7 = 0;
    L4:
        if (r3 >= toUse.length) goto L9;
        int r2 = toUse[r3];
        if (r2 >= 18) goto L8;
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
        return this.attributes.get(name).numberOfInterpolatedValues();
    }

    int getCustomData(String name, double[] value, int offset) {
        ConstraintAttribute r4 = this.attributes.get(name);
        if (r4.numberOfInterpolatedValues() != 1) goto L6;
        value[offset] = r4.getValueToInterpolate();
        return 1;
    L6:
        int r5 = r4.numberOfInterpolatedValues();
        float[] r0 = new float[r5];
        r4.getValuesToInterpolate(r0);
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L9;
        value[offset] = r0[r6];
        r6 = r6 + 1;
        offset = offset + 1;
        goto L7
    L9:
        return r5;
    }

    void setBounds(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint o) {
        return Float.compare(this.position, o.position);
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        if (view.getVisibility() == 0) goto L5;
        float r0 = 0.0f;
    L6:
        this.alpha = r0;
        this.applyElevation = false;
        this.elevation = view.getElevation();
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        this.translationZ = view.getTranslationZ();
        return;
    L5:
        r0 = view.getAlpha();
        goto L6
    }

    public void applyParameters(ConstraintSet.Constraint c) {
        this.mVisibilityMode = c.propertySet.mVisibilityMode;
        this.visibility = c.propertySet.visibility;
        if (c.propertySet.visibility != 0) goto L5;
    L7:
        float r0 = c.propertySet.alpha;
    L8:
        this.alpha = r0;
        this.applyElevation = c.transform.applyElevation;
        this.elevation = c.transform.elevation;
        this.rotation = c.transform.rotation;
        this.rotationX = c.transform.rotationX;
        this.rotationY = c.transform.rotationY;
        this.scaleX = c.transform.scaleX;
        this.scaleY = c.transform.scaleY;
        this.mPivotX = c.transform.transformPivotX;
        this.mPivotY = c.transform.transformPivotY;
        this.translationX = c.transform.translationX;
        this.translationY = c.transform.translationY;
        this.translationZ = c.transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(c.motion.mTransitionEasing);
        this.mPathRotate = c.motion.mPathRotate;
        this.mDrawPath = c.motion.mDrawPath;
        this.mAnimateRelativeTo = c.motion.mAnimateRelativeTo;
        this.mProgress = c.propertySet.mProgress;
        Iterator<String> r1 = c.mCustomConstraints.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        ConstraintAttribute r3 = c.mCustomConstraints.get(r2);
        if (r3.isContinuous() == false) goto L10;
        this.attributes.put(r2, r3);
        goto L10
    L14:
        return;
    L5:
        if (this.mVisibilityMode != 0) goto L7;
        r0 = 0.0f;
        goto L8
    }

    public void addValues(HashMap<String, ViewSpline> splines, int mFramePosition) {
        Iterator<String> r0 = splines.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L145;
        String r1 = r0.next();
        ViewSpline r2 = splines.get(r1);
        r1.hashCode();
        byte r5 = -1;
        switch(r1.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1225497657: goto L53;
            case -1225497656: goto L49;
            case -1225497655: goto L45;
            case -1001078227: goto L41;
            case -908189618: goto L37;
            case -908189617: goto L33;
            case -760884510: goto L29;
            case -760884509: goto L25;
            case -40300674: goto L21;
            case -4379043: goto L17;
            case 37232917: goto L13;
            case 92909918: goto L9;
            default: goto L64;
        };
    L64:
        float r3 = 1.0f;
        float r6 = 0.0f;
        switch(r5) {
            case 0: goto L141;
            case 1: goto L136;
            case 2: goto L131;
            case 3: goto L126;
            case 4: goto L121;
            case 5: goto L116;
            case 6: goto L111;
            case 7: goto L106;
            case 8: goto L101;
            case 9: goto L96;
            case 10: goto L91;
            case 11: goto L86;
            case 12: goto L81;
            case 13: goto L76;
            default: goto L67;
        };
    L76:
        if (Float.isNaN(this.alpha) == true) goto L79;
        r3 = this.alpha;
    L79:
        r2.setPoint(mFramePosition, r3);
        goto L4
    L81:
        if (Float.isNaN(this.mPathRotate) == true) goto L84;
        r6 = this.mPathRotate;
    L84:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L86:
        if (Float.isNaN(this.elevation) == true) goto L89;
        r6 = this.elevation;
    L89:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L91:
        if (Float.isNaN(this.rotation) == true) goto L94;
        r6 = this.rotation;
    L94:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L96:
        if (Float.isNaN(this.mPivotY) == true) goto L99;
        r6 = this.mPivotY;
    L99:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L101:
        if (Float.isNaN(this.mPivotX) == true) goto L104;
        r6 = this.mPivotX;
    L104:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L106:
        if (Float.isNaN(this.scaleY) == true) goto L109;
        r3 = this.scaleY;
    L109:
        r2.setPoint(mFramePosition, r3);
        goto L4
    L111:
        if (Float.isNaN(this.scaleX) == true) goto L114;
        r3 = this.scaleX;
    L114:
        r2.setPoint(mFramePosition, r3);
        goto L4
    L116:
        if (Float.isNaN(this.mProgress) == true) goto L119;
        r6 = this.mProgress;
    L119:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L121:
        if (Float.isNaN(this.translationZ) == true) goto L124;
        r6 = this.translationZ;
    L124:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L126:
        if (Float.isNaN(this.translationY) == true) goto L129;
        r6 = this.translationY;
    L129:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L131:
        if (Float.isNaN(this.translationX) == true) goto L134;
        r6 = this.translationX;
    L134:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L136:
        if (Float.isNaN(this.rotationY) == true) goto L139;
        r6 = this.rotationY;
    L139:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L141:
        if (Float.isNaN(this.rotationX) == true) goto L144;
        r6 = this.rotationX;
    L144:
        r2.setPoint(mFramePosition, r6);
        goto L4
    L67:
        if (r1.startsWith("CUSTOM") == true) goto L68;
        Log.e("MotionPaths", "UNKNOWN spline " + r1);
        goto L4
    L68:
        String r4 = r1.split(SimContactsConstants.EMAIL_SEP)[1];
        if (this.attributes.containsKey(r4) == false) goto L4;
        ConstraintAttribute r7 = this.attributes.get(r4);
        if ((r2 instanceof ViewSpline.CustomSet) == true) goto L72;
        Log.e("MotionPaths", r1 + " ViewSpline not a CustomSet frame = " + mFramePosition + ", value" + r7.getValueToInterpolate() + r2);
        goto L4
    L72:
        ((ViewSpline.CustomSet) r2).setPoint(mFramePosition, r7);
        goto L4
    L9:
        if (r1.equals("alpha") == false) goto L64;
        r5 = Ascii.CR;
        goto L64
    L13:
        if (r1.equals("transitionPathRotate") == false) goto L64;
        r5 = Ascii.FF;
        goto L64
    L17:
        if (r1.equals("elevation") == false) goto L64;
        r5 = Ascii.VT;
        goto L64
    L21:
        if (r1.equals("rotation") == false) goto L64;
        r5 = 10;
        goto L64
    L25:
        if (r1.equals("transformPivotY") == false) goto L64;
        r5 = 9;
        goto L64
    L29:
        if (r1.equals("transformPivotX") == false) goto L64;
        r5 = 8;
        goto L64
    L33:
        if (r1.equals("scaleY") == false) goto L64;
        r5 = 7;
        goto L64
    L37:
        if (r1.equals("scaleX") == false) goto L64;
        r5 = 6;
        goto L64
    L41:
        if (r1.equals("progress") == false) goto L64;
        r5 = 5;
        goto L64
    L45:
        if (r1.equals("translationZ") == false) goto L64;
        r5 = 4;
        goto L64
    L49:
        if (r1.equals("translationY") == false) goto L64;
        r5 = 3;
        goto L64
    L53:
        if (r1.equals("translationX") == false) goto L64;
        r5 = 2;
        goto L64
    L57:
        if (r1.equals("rotationY") == false) goto L64;
        r5 = 1;
        goto L64
    L61:
        if (r1.equals("rotationX") == false) goto L64;
        r5 = 0;
        goto L64
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    public void setState(Rect rect, View view, int rotation, float prevous) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(view);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (rotation != 1) goto L5;
        this.rotation = prevous - 90.0f;
        return;
    L5:
        if (rotation != 2) goto L11;
        this.rotation = prevous + 90.0f;
        return;
    }

    public void setState(Rect cw, ConstraintSet constraintSet, int rotation, int viewId) {
        setBounds(cw.left, cw.top, cw.width(), cw.height());
        applyParameters(constraintSet.getParameters(viewId));
        if (rotation != 1) goto L5;
    L14:
        this.rotation -= 90.0f;
        return;
    L5:
        if (rotation != 2) goto L7;
    L11:
        float r4 = this.rotation + 90.0f;
        this.rotation = r4;
        if (r4 <= 180.0f) goto L16;
        this.rotation = r4 - 360.0f;
        return;
    L16:
        return;
    L7:
        if (rotation == 3) goto L14;
        if (rotation == 4) goto L11;
    }
}
