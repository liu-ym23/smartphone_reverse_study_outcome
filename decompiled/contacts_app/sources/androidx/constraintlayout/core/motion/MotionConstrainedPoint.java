package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
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
    private float elevation;
    private float height;
    private int mAnimateRelativeTo;
    LinkedHashMap<String, CustomVariable> mCustomVariable;
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
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint r1) {
        return compareTo2(r1);
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
        this.mCustomVariable = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
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

    void different(MotionConstrainedPoint r6, HashSet<String> r7) {
        if (diff(this.alpha, r6.alpha) == false) goto L6;
        r7.add("alpha");
    L6:
        if (diff(this.elevation, r6.elevation) == false) goto L8;
        r7.add("translationZ");
    L8:
        int r0 = this.visibility;
        int r3 = r6.visibility;
        if (r0 == r3) goto L17;
        if (this.mVisibilityMode != 0) goto L17;
        if (r0 == 4) goto L15;
        if (r3 != 4) goto L17;
    L15:
        r7.add("alpha");
    L17:
        if (diff(this.rotation, r6.rotation) == false) goto L20;
        r7.add("rotationZ");
    L20:
        if (Float.isNaN(this.mPathRotate) == true) goto L22;
    L23:
        r7.add("pathRotate");
    L25:
        if (Float.isNaN(this.mProgress) == true) goto L27;
    L28:
        r7.add("progress");
    L30:
        if (diff(this.rotationX, r6.rotationX) == false) goto L33;
        r7.add("rotationX");
    L33:
        if (diff(this.rotationY, r6.rotationY) == false) goto L36;
        r7.add("rotationY");
    L36:
        if (diff(this.mPivotX, r6.mPivotX) == false) goto L39;
        r7.add("pivotX");
    L39:
        if (diff(this.mPivotY, r6.mPivotY) == false) goto L42;
        r7.add("pivotY");
    L42:
        if (diff(this.scaleX, r6.scaleX) == false) goto L45;
        r7.add("scaleX");
    L45:
        if (diff(this.scaleY, r6.scaleY) == false) goto L48;
        r7.add("scaleY");
    L48:
        if (diff(this.translationX, r6.translationX) == false) goto L51;
        r7.add("translationX");
    L51:
        if (diff(this.translationY, r6.translationY) == false) goto L54;
        r7.add("translationY");
    L54:
        if (diff(this.translationZ, r6.translationZ) == false) goto L57;
        r7.add("translationZ");
    L57:
        if (diff(this.elevation, r6.elevation) == false) goto L60;
        r7.add("elevation");
        return;
    L60:
        return;
    L27:
        if (Float.isNaN(r6.mProgress) == true) goto L30;
    L22:
        if (Float.isNaN(r6.mPathRotate) == true) goto L25;
        goto L23
    }

    void different(MotionConstrainedPoint r4, boolean[] r5, String[] r6) {
        r5[0] = r5[0] | diff(this.position, r4.position);
        r5[1] = r5[1] | diff(this.x, r4.x);
        r5[2] = r5[2] | diff(this.y, r4.y);
        r5[3] = r5[3] | diff(this.width, r4.width);
        boolean r0 = r5[4];
        r5[4] = diff(this.height, r4.height) | r0;
    }

    void fillStandard(double[] r8, int[] r9) {
        int r3 = 0;
        float[] r1 = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
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
        return this.mCustomVariable.containsKey(r1);
    }

    int getCustomDataCount(String r1) {
        return this.mCustomVariable.get(r1).numberOfInterpolatedValues();
    }

    int getCustomData(String r5, double[] r6, int r7) {
        CustomVariable r4 = this.mCustomVariable.get(r5);
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
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r1) {
        return Float.compare(this.position, r1.position);
    }

    public void applyParameters(MotionWidget r5) {
        this.visibility = r5.getVisibility();
        if (r5.getVisibility() == 4) goto L5;
        float r0 = 0.0f;
    L6:
        this.alpha = r0;
        this.applyElevation = false;
        this.rotation = r5.getRotationZ();
        this.rotationX = r5.getRotationX();
        this.rotationY = r5.getRotationY();
        this.scaleX = r5.getScaleX();
        this.scaleY = r5.getScaleY();
        this.mPivotX = r5.getPivotX();
        this.mPivotY = r5.getPivotY();
        this.translationX = r5.getTranslationX();
        this.translationY = r5.getTranslationY();
        this.translationZ = r5.getTranslationZ();
        Iterator<String> r1 = r5.getCustomAttributeNames().iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        CustomVariable r3 = r5.getCustomAttribute(r2);
        if (r3 == null) goto L8;
        if (r3.isContinuous() == false) goto L8;
        this.mCustomVariable.put(r2, r3);
        goto L8
    L14:
        return;
    L5:
        r0 = r5.getAlpha();
        goto L6
    }

    public void addValues(HashMap<String, SplineSet> r8, int r9) {
        Iterator<String> r0 = r8.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L136;
        String r1 = r0.next();
        SplineSet r2 = r8.get(r1);
        r1.hashCode();
        byte r5 = -1;
        switch(r1.hashCode()) {
            case -1249320806: goto L57;
            case -1249320805: goto L53;
            case -1249320804: goto L49;
            case -1225497657: goto L45;
            case -1225497656: goto L41;
            case -1225497655: goto L37;
            case -1001078227: goto L33;
            case -987906986: goto L29;
            case -987906985: goto L25;
            case -908189618: goto L21;
            case -908189617: goto L17;
            case 92909918: goto L13;
            case 803192288: goto L9;
            default: goto L60;
        };
    L60:
        float r3 = 1.0f;
        float r6 = 0.0f;
        switch(r5) {
            case 0: goto L132;
            case 1: goto L127;
            case 2: goto L122;
            case 3: goto L117;
            case 4: goto L112;
            case 5: goto L107;
            case 6: goto L102;
            case 7: goto L97;
            case 8: goto L92;
            case 9: goto L87;
            case 10: goto L82;
            case 11: goto L77;
            case 12: goto L72;
            default: goto L63;
        };
    L72:
        if (Float.isNaN(this.mPathRotate) == true) goto L75;
        r6 = this.mPathRotate;
    L75:
        r2.setPoint(r9, r6);
        goto L4
    L77:
        if (Float.isNaN(this.alpha) == true) goto L80;
        r3 = this.alpha;
    L80:
        r2.setPoint(r9, r3);
        goto L4
    L82:
        if (Float.isNaN(this.scaleY) == true) goto L85;
        r3 = this.scaleY;
    L85:
        r2.setPoint(r9, r3);
        goto L4
    L87:
        if (Float.isNaN(this.scaleX) == true) goto L90;
        r3 = this.scaleX;
    L90:
        r2.setPoint(r9, r3);
        goto L4
    L92:
        if (Float.isNaN(this.mPivotY) == true) goto L95;
        r6 = this.mPivotY;
    L95:
        r2.setPoint(r9, r6);
        goto L4
    L97:
        if (Float.isNaN(this.mPivotX) == true) goto L100;
        r6 = this.mPivotX;
    L100:
        r2.setPoint(r9, r6);
        goto L4
    L102:
        if (Float.isNaN(this.mProgress) == true) goto L105;
        r6 = this.mProgress;
    L105:
        r2.setPoint(r9, r6);
        goto L4
    L107:
        if (Float.isNaN(this.translationZ) == true) goto L110;
        r6 = this.translationZ;
    L110:
        r2.setPoint(r9, r6);
        goto L4
    L112:
        if (Float.isNaN(this.translationY) == true) goto L115;
        r6 = this.translationY;
    L115:
        r2.setPoint(r9, r6);
        goto L4
    L117:
        if (Float.isNaN(this.translationX) == true) goto L120;
        r6 = this.translationX;
    L120:
        r2.setPoint(r9, r6);
        goto L4
    L122:
        if (Float.isNaN(this.rotation) == true) goto L125;
        r6 = this.rotation;
    L125:
        r2.setPoint(r9, r6);
        goto L4
    L127:
        if (Float.isNaN(this.rotationY) == true) goto L130;
        r6 = this.rotationY;
    L130:
        r2.setPoint(r9, r6);
        goto L4
    L132:
        if (Float.isNaN(this.rotationX) == true) goto L135;
        r6 = this.rotationX;
    L135:
        r2.setPoint(r9, r6);
        goto L4
    L63:
        if (r1.startsWith("CUSTOM") == true) goto L64;
        Utils.loge("MotionPaths", "UNKNOWN spline " + r1);
        goto L4
    L64:
        String r4 = r1.split(SimContactsConstants.EMAIL_SEP)[1];
        if (this.mCustomVariable.containsKey(r4) == false) goto L4;
        CustomVariable r7 = this.mCustomVariable.get(r4);
        if ((r2 instanceof SplineSet.CustomSpline) == true) goto L68;
        Utils.loge("MotionPaths", r1 + " ViewSpline not a CustomSet frame = " + r9 + ", value" + r7.getValueToInterpolate() + r2);
        goto L4
    L68:
        ((SplineSet.CustomSpline) r2).setPoint(r9, r7);
        goto L4
    L9:
        if (r1.equals("pathRotate") == false) goto L60;
        r5 = Ascii.FF;
        goto L60
    L13:
        if (r1.equals("alpha") == false) goto L60;
        r5 = Ascii.VT;
        goto L60
    L17:
        if (r1.equals("scaleY") == false) goto L60;
        r5 = 10;
        goto L60
    L21:
        if (r1.equals("scaleX") == false) goto L60;
        r5 = 9;
        goto L60
    L25:
        if (r1.equals("pivotY") == false) goto L60;
        r5 = 8;
        goto L60
    L29:
        if (r1.equals("pivotX") == false) goto L60;
        r5 = 7;
        goto L60
    L33:
        if (r1.equals("progress") == false) goto L60;
        r5 = 6;
        goto L60
    L37:
        if (r1.equals("translationZ") == false) goto L60;
        r5 = 5;
        goto L60
    L41:
        if (r1.equals("translationY") == false) goto L60;
        r5 = 4;
        goto L60
    L45:
        if (r1.equals("translationX") == false) goto L60;
        r5 = 3;
        goto L60
    L49:
        if (r1.equals("rotationZ") == false) goto L60;
        r5 = 2;
        goto L60
    L53:
        if (r1.equals("rotationY") == false) goto L60;
        r5 = 1;
        goto L60
    L57:
        if (r1.equals("rotationX") == false) goto L60;
        r5 = 0;
        goto L60
    }

    public void setState(MotionWidget r5) {
        setBounds(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        applyParameters(r5);
    }

    public void setState(Rect r4, MotionWidget r5, int r6, float r7) {
        setBounds(r4.left, r4.top, r4.width(), r4.height());
        applyParameters(r5);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (r6 != 1) goto L5;
        this.rotation = r7 - 90.0f;
        return;
    L5:
        if (r6 != 2) goto L11;
        this.rotation = r7 + 90.0f;
        return;
    }
}
