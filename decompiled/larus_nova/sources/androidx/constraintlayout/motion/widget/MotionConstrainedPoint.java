package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
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

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f15327x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f15328y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
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
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public void applyParameters(ConstraintSet.Constraint r100) {
        ConstraintSet.PropertySet r101 = r100.propertySet;
        int r102 = r101.mVisibilityMode;
        this.mVisibilityMode = r102;
        int r103 = r101.visibility;
        this.visibility = r103;
        if (r103 == 0) goto L6;
        if (r102 != 0) goto L6;
        float r104 = 0.0f;
    L7:
        this.alpha = r104;
        ConstraintSet.Transform r105 = r100.transform;
        this.applyElevation = r105.applyElevation;
        this.elevation = r105.elevation;
        this.rotation = r105.rotation;
        this.rotationX = r105.rotationX;
        this.rotationY = r105.rotationY;
        this.scaleX = r105.scaleX;
        this.scaleY = r105.scaleY;
        this.mPivotX = r105.transformPivotX;
        this.mPivotY = r105.transformPivotY;
        this.translationX = r105.translationX;
        this.translationY = r105.translationY;
        this.translationZ = r105.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(r100.motion.mTransitionEasing);
        ConstraintSet.Motion r106 = r100.motion;
        this.mPathRotate = r106.mPathRotate;
        this.mDrawPath = r106.mDrawPath;
        this.mProgress = r100.propertySet.mProgress;
        Iterator<String> r107 = r100.mCustomConstraints.keySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        String r108 = r107.next();
        ConstraintAttribute r109 = r100.mCustomConstraints.get(r108);
        if (r109.getType() == ConstraintAttribute.AttributeType.STRING_TYPE) goto L9;
        this.attributes.put(r108, r109);
        goto L9
    L13:
        return;
    L6:
        r104 = r101.alpha;
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionConstrainedPoint r100) {
        return Float.compare(this.position, r100.position);
    }

    public int getCustomDataCount(String r100) {
        return this.attributes.get(r100).noOfInterpValues();
    }

    public boolean hasCustomData(String r100) {
        return this.attributes.containsKey(r100);
    }

    public void setState(View r100) {
        setBounds(r100.getX(), r100.getY(), r100.getWidth(), r100.getHeight());
        applyParameters(r100);
    }

    public void applyParameters(View r100) {
        this.visibility = r100.getVisibility();
        if (r100.getVisibility() == 0) goto L5;
        float r101 = 0.0f;
    L6:
        this.alpha = r101;
        this.applyElevation = false;
        this.elevation = r100.getElevation();
        this.rotation = r100.getRotation();
        this.rotationX = r100.getRotationX();
        this.rotationY = r100.getRotationY();
        this.scaleX = r100.getScaleX();
        this.scaleY = r100.getScaleY();
        this.mPivotX = r100.getPivotX();
        this.mPivotY = r100.getPivotY();
        this.translationX = r100.getTranslationX();
        this.translationY = r100.getTranslationY();
        this.translationZ = r100.getTranslationZ();
        return;
    L5:
        r101 = r100.getAlpha();
        goto L6
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionConstrainedPoint r100) {
        return compareTo2(r100);
    }

    private boolean diff(float r100, float r101) {
        if (Float.isNaN(r100) == true) goto L13;
        if (Float.isNaN(r101) == true) goto L13;
        if (Math.abs(r100 - r101) > 1.0E-6f) goto L17;
        return false;
    L17:
        return true;
    L13:
        if (Float.isNaN(r100) != Float.isNaN(r101)) goto L18;
        return false;
    L18:
        return true;
    }

    public void addValues(HashMap<String, SplineSet> r100, int r101) {
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L146;
        String r103 = r102.next();
        SplineSet r104 = r100.get(r103);
        r103.getClass();
        byte r105 = -1;
        switch(r103.hashCode()) {
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
        float r106 = 1.0f;
        float r107 = 0.0f;
        switch(r105) {
            case 0: goto L142;
            case 1: goto L137;
            case 2: goto L132;
            case 3: goto L127;
            case 4: goto L122;
            case 5: goto L117;
            case 6: goto L112;
            case 7: goto L107;
            case 8: goto L102;
            case 9: goto L97;
            case 10: goto L92;
            case 11: goto L87;
            case 12: goto L82;
            case 13: goto L77;
            default: goto L67;
        };
    L77:
        if (Float.isNaN(this.alpha) == true) goto L80;
        r106 = this.alpha;
    L80:
        r104.setPoint(r101, r106);
        goto L4
    L82:
        if (Float.isNaN(this.mPathRotate) == true) goto L85;
        r107 = this.mPathRotate;
    L85:
        r104.setPoint(r101, r107);
        goto L4
    L87:
        if (Float.isNaN(this.elevation) == true) goto L90;
        r107 = this.elevation;
    L90:
        r104.setPoint(r101, r107);
        goto L4
    L92:
        if (Float.isNaN(this.rotation) == true) goto L95;
        r107 = this.rotation;
    L95:
        r104.setPoint(r101, r107);
        goto L4
    L97:
        if (Float.isNaN(this.mPivotY) == true) goto L100;
        r107 = this.mPivotY;
    L100:
        r104.setPoint(r101, r107);
        goto L4
    L102:
        if (Float.isNaN(this.mPivotX) == true) goto L105;
        r107 = this.mPivotX;
    L105:
        r104.setPoint(r101, r107);
        goto L4
    L107:
        if (Float.isNaN(this.scaleY) == true) goto L110;
        r106 = this.scaleY;
    L110:
        r104.setPoint(r101, r106);
        goto L4
    L112:
        if (Float.isNaN(this.scaleX) == true) goto L115;
        r106 = this.scaleX;
    L115:
        r104.setPoint(r101, r106);
        goto L4
    L117:
        if (Float.isNaN(this.mProgress) == true) goto L120;
        r107 = this.mProgress;
    L120:
        r104.setPoint(r101, r107);
        goto L4
    L122:
        if (Float.isNaN(this.translationZ) == true) goto L125;
        r107 = this.translationZ;
    L125:
        r104.setPoint(r101, r107);
        goto L4
    L127:
        if (Float.isNaN(this.translationY) == true) goto L130;
        r107 = this.translationY;
    L130:
        r104.setPoint(r101, r107);
        goto L4
    L132:
        if (Float.isNaN(this.translationX) == true) goto L135;
        r107 = this.translationX;
    L135:
        r104.setPoint(r101, r107);
        goto L4
    L137:
        if (Float.isNaN(this.rotationY) == true) goto L140;
        r107 = this.rotationY;
    L140:
        r104.setPoint(r101, r107);
        goto L4
    L142:
        if (Float.isNaN(this.rotationX) == true) goto L145;
        r107 = this.rotationX;
    L145:
        r104.setPoint(r101, r107);
        goto L4
    L67:
        if (r103.startsWith("CUSTOM") == false) goto L4;
        String r108 = r103.split(",")[1];
        if (this.attributes.containsKey(r108) == false) goto L4;
        ConstraintAttribute r109 = this.attributes.get(r108);
        if ((r104 instanceof SplineSet.CustomSet) == true) goto L72;
        r109.getValueToInterpolate();
        Objects.toString(r104);
        goto L4
    L72:
        ((SplineSet.CustomSet) r104).setPoint(r101, r109);
        goto L4
    L9:
        if (r103.equals("alpha") == false) goto L64;
        r105 = HTTP.CR;
        goto L64
    L13:
        if (r103.equals("transitionPathRotate") == false) goto L64;
        r105 = 12;
        goto L64
    L17:
        if (r103.equals("elevation") == false) goto L64;
        r105 = 11;
        goto L64
    L21:
        if (r103.equals("rotation") == false) goto L64;
        r105 = 10;
        goto L64
    L25:
        if (r103.equals("transformPivotY") == false) goto L64;
        r105 = 9;
        goto L64
    L29:
        if (r103.equals("transformPivotX") == false) goto L64;
        r105 = 8;
        goto L64
    L33:
        if (r103.equals(LiveDegradeFpsAnimator.SCALE_Y) == false) goto L64;
        r105 = 7;
        goto L64
    L37:
        if (r103.equals(LiveDegradeFpsAnimator.SCALE_X) == false) goto L64;
        r105 = 6;
        goto L64
    L41:
        if (r103.equals("progress") == false) goto L64;
        r105 = 5;
        goto L64
    L45:
        if (r103.equals("translationZ") == false) goto L64;
        r105 = 4;
        goto L64
    L49:
        if (r103.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L64;
        r105 = 3;
        goto L64
    L53:
        if (r103.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L64;
        r105 = 2;
        goto L64
    L57:
        if (r103.equals("rotationY") == false) goto L64;
        r105 = 1;
        goto L64
    L61:
        if (r103.equals("rotationX") == false) goto L64;
        r105 = 0;
        goto L64
    }

    public void different(MotionConstrainedPoint r100, HashSet<String> r101) {
        if (diff(this.alpha, r100.alpha) == false) goto L6;
        r101.add("alpha");
    L6:
        if (diff(this.elevation, r100.elevation) == false) goto L8;
        r101.add("elevation");
    L8:
        int r102 = this.visibility;
        int r103 = r100.visibility;
        if (r102 == r103) goto L16;
        if (this.mVisibilityMode != 0) goto L16;
        if (r102 == 0) goto L14;
        if (r103 != 0) goto L16;
    L14:
        r101.add("alpha");
    L16:
        if (diff(this.rotation, r100.rotation) == false) goto L19;
        r101.add("rotation");
    L19:
        if (Float.isNaN(this.mPathRotate) == true) goto L21;
    L22:
        r101.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.mProgress) == true) goto L26;
    L27:
        r101.add("progress");
    L29:
        if (diff(this.rotationX, r100.rotationX) == false) goto L32;
        r101.add("rotationX");
    L32:
        if (diff(this.rotationY, r100.rotationY) == false) goto L35;
        r101.add("rotationY");
    L35:
        if (diff(this.mPivotX, r100.mPivotX) == false) goto L38;
        r101.add("transformPivotX");
    L38:
        if (diff(this.mPivotY, r100.mPivotY) == false) goto L41;
        r101.add("transformPivotY");
    L41:
        if (diff(this.scaleX, r100.scaleX) == false) goto L44;
        r101.add(LiveDegradeFpsAnimator.SCALE_X);
    L44:
        if (diff(this.scaleY, r100.scaleY) == false) goto L47;
        r101.add(LiveDegradeFpsAnimator.SCALE_Y);
    L47:
        if (diff(this.translationX, r100.translationX) == false) goto L50;
        r101.add(LiveDegradeFpsAnimator.TRANSLATION_X);
    L50:
        if (diff(this.translationY, r100.translationY) == false) goto L53;
        r101.add(LiveDegradeFpsAnimator.TRANSLATION_Y);
    L53:
        if (diff(this.translationZ, r100.translationZ) == false) goto L56;
        r101.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r100.mProgress) == true) goto L29;
    L21:
        if (Float.isNaN(r100.mPathRotate) == true) goto L24;
        goto L22
    }

    public void fillStandard(double[] r100, int[] r110) {
        int r101 = 0;
        float[] r102 = {this.position, this.f15327x, this.f15328y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int r103 = 0;
    L4:
        if (r101 >= r110.length) goto L9;
        int r104 = r110[r101];
        if (r104 >= 18) goto L8;
        r100[r103] = r102[r104];
        r103 = r103 + 1;
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void different(MotionConstrainedPoint r100, boolean[] r101, String[] r102) {
        r101[0] = r101[0] | diff(this.position, r100.position);
        r101[1] = r101[1] | diff(this.f15327x, r100.f15327x);
        r101[2] = r101[2] | diff(this.f15328y, r100.f15328y);
        r101[3] = r101[3] | diff(this.width, r100.width);
        boolean r103 = r101[4];
        r101[4] = diff(this.height, r100.height) | r103;
    }

    public int getCustomData(String r100, double[] r101, int r102) {
        ConstraintAttribute r103 = this.attributes.get(r100);
        if (r103.noOfInterpValues() != 1) goto L6;
        r101[r102] = r103.getValueToInterpolate();
        return 1;
    L6:
        int r104 = r103.noOfInterpValues();
        float[] r105 = new float[r104];
        r103.getValuesToInterpolate(r105);
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L9;
        r101[r102] = r105[r106];
        r106 = r106 + 1;
        r102 = r102 + 1;
        goto L7
    L9:
        return r104;
    }

    public void setState(ConstraintWidget r100, ConstraintSet r101, int r102) {
        setBounds(r100.getX(), r100.getY(), r100.getWidth(), r100.getHeight());
        applyParameters(r101.getParameters(r102));
    }

    public void setBounds(float r100, float r101, float r102, float r103) {
        this.f15327x = r100;
        this.f15328y = r101;
        this.width = r102;
        this.height = r103;
    }
}
