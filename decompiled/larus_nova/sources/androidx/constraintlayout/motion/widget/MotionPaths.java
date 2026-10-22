package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes17.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f15330x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f15331y;

    private static final float xRotate(float r100, float r101, float r102, float r103, float r104, float r105) {
        return (((r104 - r102) * r101) - ((r105 - r103) * r100)) + r102;
    }

    private static final float yRotate(float r100, float r101, float r102, float r103, float r104, float r105) {
        return (((r104 - r102) * r100) + ((r105 - r103) * r101)) + r103;
    }

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public void applyParameters(ConstraintSet.Constraint r100) {
        this.mKeyFrameEasing = Easing.getInterpolator(r100.motion.mTransitionEasing);
        ConstraintSet.Motion r101 = r100.motion;
        this.mPathMotionArc = r101.mPathMotionArc;
        this.mPathRotate = r101.mPathRotate;
        this.mDrawPath = r101.mDrawPath;
        this.mProgress = r100.propertySet.mProgress;
        Iterator<String> r102 = r100.mCustomConstraints.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        ConstraintAttribute r104 = r100.mCustomConstraints.get(r103);
        if (r104.getType() == ConstraintAttribute.AttributeType.STRING_TYPE) goto L4;
        this.attributes.put(r103, r104);
        goto L4
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionPaths r100) {
        return Float.compare(this.position, r100.position);
    }

    public int getCustomDataCount(String r100) {
        return this.attributes.get(r100).noOfInterpValues();
    }

    public boolean hasCustomData(String r100) {
        return this.attributes.containsKey(r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionPaths r100) {
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

    public void fillStandard(double[] r100, int[] r110) {
        int r101 = 0;
        float[] r102 = {this.position, this.f15330x, this.f15331y, this.width, this.height, this.mPathRotate};
        int r103 = 0;
    L4:
        if (r101 >= r110.length) goto L9;
        int r104 = r110[r101];
        if (r104 >= 6) goto L8;
        r100[r103] = r102[r104];
        r103 = r103 + 1;
    L8:
        r101 = r101 + 1;
        goto L4
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

    public void initCartesian(KeyPosition r110, MotionPaths r111, MotionPaths r210) {
        float r100 = r110.mFramePosition / 100.0f;
        this.time = r100;
        this.mDrawPath = r110.mDrawPath;
        if (Float.isNaN(r110.mPercentWidth) == false) goto L5;
        float r101 = r100;
    L7:
        if (Float.isNaN(r110.mPercentHeight) == false) goto L9;
        float r102 = r100;
    L10:
        float r103 = r210.width;
        float r104 = r111.width;
        float r112 = r210.height;
        float r113 = r111.height;
        this.position = this.time;
        float r114 = r111.f15330x;
        float r105 = r111.f15331y;
        float r106 = r210.f15330x + (r103 / 2.0f);
        float r107 = r106 - ((r104 / 2.0f) + r114);
        float r108 = (r210.f15331y + (r112 / 2.0f)) - (r105 + (r113 / 2.0f));
        float r109 = (r103 - r104) * r101;
        float r115 = r109 / 2.0f;
        this.f15330x = (int) ((r114 + (r107 * r100)) - r115);
        float r116 = (r112 - r113) * r102;
        float r117 = r116 / 2.0f;
        this.f15331y = (int) ((r105 + (r108 * r100)) - r117);
        this.width = (int) (r104 + r109);
        this.height = (int) (r113 + r116);
        if (Float.isNaN(r110.mPercentX) == false) goto L13;
        float r118 = r100;
    L14:
        float r119 = 0.0f;
        if (Float.isNaN(r110.mAltPercentY) == false) goto L17;
        float r120 = 0.0f;
    L19:
        if (Float.isNaN(r110.mPercentY) == true) goto L23;
        r100 = r110.mPercentY;
    L23:
        if (Float.isNaN(r110.mAltPercentX) == true) goto L26;
        r119 = r110.mAltPercentX;
    L26:
        this.mMode = 2;
        this.f15330x = (int) (((r111.f15330x + (r118 * r107)) + (r119 * r108)) - r115);
        this.f15331y = (int) (((r111.f15331y + (r107 * r120)) + (r108 * r100)) - r117);
        this.mKeyFrameEasing = Easing.getInterpolator(r110.mTransitionEasing);
        this.mPathMotionArc = r110.mPathMotionArc;
        return;
    L17:
        r120 = r110.mAltPercentY;
        goto L19
    L13:
        r118 = r110.mPercentX;
        goto L14
    L9:
        r102 = r110.mPercentHeight;
        goto L10
    L5:
        r101 = r110.mPercentWidth;
        goto L7
    }

    public void initPath(KeyPosition r110, MotionPaths r111, MotionPaths r112) {
        float r100 = r110.mFramePosition / 100.0f;
        this.time = r100;
        this.mDrawPath = r110.mDrawPath;
        if (Float.isNaN(r110.mPercentWidth) == false) goto L5;
        float r101 = r100;
    L7:
        if (Float.isNaN(r110.mPercentHeight) == false) goto L9;
        float r102 = r100;
    L10:
        float r103 = r112.width - r111.width;
        float r104 = r112.height - r111.height;
        this.position = this.time;
        if (Float.isNaN(r110.mPercentX) == true) goto L14;
        r100 = r110.mPercentX;
    L14:
        float r105 = r111.f15330x;
        float r113 = r111.width;
        float r114 = r111.f15331y;
        float r115 = r111.height;
        float r106 = r112.f15330x + (r112.width / 2.0f);
        float r107 = r106 - ((r113 / 2.0f) + r105);
        float r108 = (r112.f15331y + (r112.height / 2.0f)) - ((r115 / 2.0f) + r114);
        float r109 = r107 * r100;
        float r116 = r103 * r101;
        float r117 = r116 / 2.0f;
        this.f15330x = (int) ((r105 + r109) - r117);
        float r118 = r100 * r108;
        float r119 = r104 * r102;
        float r120 = r119 / 2.0f;
        this.f15331y = (int) ((r114 + r118) - r120);
        this.width = (int) (r113 + r116);
        this.height = (int) (r115 + r119);
        if (Float.isNaN(r110.mPercentY) == false) goto L17;
        float r121 = 0.0f;
    L18:
        this.mMode = 1;
        float r122 = (int) ((r111.f15330x + r109) - r117);
        float r123 = (int) ((r111.f15331y + r118) - r120);
        this.f15330x = r122 + ((-r108) * r121);
        this.f15331y = r123 + (r107 * r121);
        this.mKeyFrameEasing = Easing.getInterpolator(r110.mTransitionEasing);
        this.mPathMotionArc = r110.mPathMotionArc;
        return;
    L17:
        r121 = r110.mPercentY;
        goto L18
    L9:
        r102 = r110.mPercentHeight;
        goto L10
    L5:
        r101 = r110.mPercentWidth;
        goto L7
    }

    public void different(MotionPaths r100, boolean[] r101, String[] r102, boolean r103) {
        r101[0] = r101[0] | diff(this.position, r100.position);
        r101[1] = r101[1] | (diff(this.f15330x, r100.f15330x) | r103);
        boolean r104 = r101[2];
        r101[2] = (r103 | diff(this.f15331y, r100.f15331y)) | r104;
        r101[3] = r101[3] | diff(this.width, r100.width);
        boolean r105 = r101[4];
        r101[4] = diff(this.height, r100.height) | r105;
    }

    public void getBounds(int[] r100, double[] r101, float[] r102, int r110) {
        float r103 = this.width;
        float r104 = this.height;
        int r105 = 0;
    L4:
        if (r105 >= r100.length) goto L13;
        float r106 = (float) r101[r105];
        int r107 = r100[r105];
        if (r107 != 3) goto L8;
        r103 = r106;
    L12:
        r105 = r105 + 1;
        goto L4
    L8:
        if (r107 != 4) goto L12;
        r104 = r106;
        goto L12
    L13:
        r102[r110] = r103;
        r102[r110 + 1] = r104;
    }

    public void getCenter(int[] r110, double[] r111, float[] r112, int r113) {
        float r100 = this.f15330x;
        float r101 = this.f15331y;
        float r102 = this.width;
        float r103 = this.height;
        int r104 = 0;
    L4:
        if (r104 >= r110.length) goto L19;
        float r105 = (float) r111[r104];
        int r106 = r110[r104];
        if (r106 != 1) goto L8;
        r100 = r105;
    L18:
        r104 = r104 + 1;
        goto L4
    L8:
        if (r106 != 2) goto L10;
        r101 = r105;
        goto L18
    L10:
        if (r106 != 3) goto L12;
        r102 = r105;
        goto L18
    L12:
        if (r106 != 4) goto L18;
        r103 = r105;
        goto L18
    L19:
        r112[r113] = (r100 + (r102 / 2.0f)) + 0.0f;
        r112[r113 + 1] = (r101 + (r103 / 2.0f)) + 0.0f;
    }

    public void getRect(int[] r100, double[] r110, float[] r111, int r112) {
        float r101 = this.f15330x;
        float r102 = this.f15331y;
        float r103 = this.width;
        float r104 = this.height;
        int r105 = 0;
    L4:
        if (r105 >= r100.length) goto L19;
        float r106 = (float) r110[r105];
        int r107 = r100[r105];
        if (r107 != 1) goto L8;
        r101 = r106;
    L18:
        r105 = r105 + 1;
        goto L4
    L8:
        if (r107 != 2) goto L10;
        r102 = r106;
        goto L18
    L10:
        if (r107 != 3) goto L12;
        r103 = r106;
        goto L18
    L12:
        if (r107 != 4) goto L18;
        r104 = r106;
        goto L18
    L19:
        float r108 = r103 + r101;
        float r109 = r104 + r102;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float r113 = r101 + 0.0f;
        float r114 = r102 + 0.0f;
        float r115 = r108 + 0.0f;
        float r116 = r109 + 0.0f;
        int r117 = r112 + 1;
        r111[r112] = r113;
        int r118 = r117 + 1;
        r111[r117] = r114;
        int r119 = r118 + 1;
        r111[r118] = r115;
        int r120 = r119 + 1;
        r111[r119] = r102 + 0.0f;
        int r121 = r120 + 1;
        r111[r120] = r108 + 0.0f;
        int r122 = r121 + 1;
        r111[r121] = r116;
        int r123 = r122 + 1;
        r111[r122] = r101 + 0.0f;
        r111[r123] = r109 + 0.0f;
    }

    public void setBounds(float r100, float r101, float r102, float r103) {
        this.f15330x = r100;
        this.f15331y = r101;
        this.width = r102;
        this.height = r103;
    }

    public MotionPaths(int r100, int r101, KeyPosition r102, MotionPaths r103, MotionPaths r104) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int r105 = r102.mPositionType;
        if (r105 != 1) goto L5;
        initPath(r102, r103, r104);
        return;
    L5:
        if (r105 == 2) goto L8;
        initCartesian(r102, r103, r104);
        return;
    L8:
        initScreen(r100, r101, r102, r103, r104);
    }

    public void initScreen(int r110, int r111, KeyPosition r210, MotionPaths r211, MotionPaths r212) {
        float r100 = r210.mFramePosition / 100.0f;
        this.time = r100;
        this.mDrawPath = r210.mDrawPath;
        if (Float.isNaN(r210.mPercentWidth) == false) goto L5;
        float r101 = r100;
    L7:
        if (Float.isNaN(r210.mPercentHeight) == false) goto L9;
        float r102 = r100;
    L10:
        float r103 = r212.width;
        float r104 = r211.width;
        float r112 = r212.height;
        float r113 = r211.height;
        this.position = this.time;
        float r114 = r211.f15330x;
        float r105 = r211.f15331y;
        float r106 = r212.f15330x + (r103 / 2.0f);
        float r107 = r212.f15331y + (r112 / 2.0f);
        float r108 = (r103 - r104) * r101;
        this.f15330x = (int) ((r114 + ((r106 - ((r104 / 2.0f) + r114)) * r100)) - (r108 / 2.0f));
        float r115 = (r112 - r113) * r102;
        this.f15331y = (int) ((r105 + ((r107 - (r105 + (r113 / 2.0f))) * r100)) - (r115 / 2.0f));
        this.width = (int) (r104 + r108);
        this.height = (int) (r113 + r115);
        this.mMode = 3;
        if (Float.isNaN(r210.mPercentX) == true) goto L14;
        this.f15330x = (int) (r210.mPercentX * ((int) (r110 - this.width)));
    L14:
        if (Float.isNaN(r210.mPercentY) == true) goto L16;
        this.f15331y = (int) (r210.mPercentY * ((int) (r111 - this.height)));
    L16:
        this.mKeyFrameEasing = Easing.getInterpolator(r210.mTransitionEasing);
        this.mPathMotionArc = r210.mPathMotionArc;
        return;
    L9:
        r102 = r210.mPercentHeight;
        goto L10
    L5:
        r101 = r210.mPercentWidth;
        goto L7
    }

    public void setView(View r210, int[] r211, double[] r212, double[] r213, double[] r214) {
        float r100 = this.f15330x;
        float r101 = this.f15331y;
        float r102 = this.width;
        float r103 = this.height;
        if (r211.length != 0) goto L5;
    L7:
        Arrays.fill(this.mTempValue, Double.NaN);
        int r104 = 0;
    L9:
        if (r104 >= r211.length) goto L11;
        double[] r110 = this.mTempValue;
        int r111 = r211[r104];
        r110[r111] = r212[r104];
        this.mTempDelta[r111] = r213[r104];
        r104 = r104 + 1;
        goto L9
    L11:
        int r112 = 0;
        float r113 = Float.NaN;
        float r114 = 0.0f;
        float r115 = 0.0f;
        float r116 = 0.0f;
        float r117 = 0.0f;
    L12:
        double[] r105 = this.mTempValue;
        if (r112 >= r105.length) goto L43;
        boolean r106 = Double.isNaN(r105[r112]);
        double r118 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r106 == false) goto L20;
        if (r214 != null) goto L18;
    L19:
        float r215 = r100;
    L36:
        float r107 = r215;
    L42:
        r112 = r112 + 1;
        r100 = r107;
        goto L12
    L18:
        if (r214[r112] == AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
    L20:
        if (r214 == null) goto L23;
        r118 = r214[r112];
    L23:
        if (Double.isNaN(this.mTempValue[r112]) == true) goto L26;
        r118 = this.mTempValue[r112] + r118;
    L26:
        r107 = (float) r118;
        r215 = r100;
        float r108 = (float) this.mTempDelta[r112];
        if (r112 != 1) goto L29;
        r114 = r108;
        goto L42
    L29:
        if (r112 != 2) goto L31;
        r116 = r108;
        r101 = r107;
        goto L36
    L31:
        if (r112 != 3) goto L33;
        r115 = r108;
        r102 = r107;
        goto L36
    L33:
        if (r112 != 4) goto L35;
        r117 = r108;
        r103 = r107;
        goto L36
    L35:
        if (r112 != 5) goto L36;
        r113 = r107;
        goto L36
    L43:
        float r216 = r100;
        if (Float.isNaN(r113) == true) goto L46;
        float r109 = Float.NaN;
        if (Float.isNaN(Float.NaN) == false) goto L51;
        r109 = 0.0f;
    L51:
        r210.setRotation((float) (((double) r109) + (((double) r113) + Math.toDegrees(Math.atan2(r116 + (r117 / 2.0f), r114 + (r115 / 2.0f))))));
    L52:
        float r119 = r216 + 0.5f;
        int r120 = (int) r119;
        float r121 = r101 + 0.5f;
        int r122 = (int) r121;
        int r123 = (int) (r119 + r102);
        int r124 = (int) (r121 + r103);
        int r125 = r123 - r120;
        int r126 = r124 - r122;
        if (r125 == r210.getMeasuredWidth()) goto L55;
    L58:
        boolean r127 = true;
    L59:
        if (r127 == false) goto L61;
        r210.measure(View.MeasureSpec.makeMeasureSpec(r125, 1073741824), View.MeasureSpec.makeMeasureSpec(r126, 1073741824));
    L61:
        r210.layout(r120, r122, r123, r124);
        return;
    L55:
        if (r126 != r210.getMeasuredHeight()) goto L58;
        r127 = false;
        goto L59
    L46:
        if (Float.isNaN(Float.NaN) == true) goto L52;
        r210.setRotation(Float.NaN);
        goto L52
    L5:
        if (this.mTempValue.length > r211[r211.length - 1]) goto L7;
        int r128 = r211[r211.length - 1] + 1;
        this.mTempValue = new double[r128];
        this.mTempDelta = new double[r128];
        goto L7
    }

    public void setDpDt(float r110, float r111, float[] r112, int[] r113, double[] r114, double[] r115) {
        int r100 = 0;
        float r101 = 0.0f;
        float r102 = 0.0f;
        float r103 = 0.0f;
        float r104 = 0.0f;
    L4:
        if (r100 >= r113.length) goto L19;
        float r105 = (float) r114[r100];
        double r116 = r115[r100];
        int r117 = r113[r100];
        if (r117 != 1) goto L8;
        r101 = r105;
    L18:
        r100 = r100 + 1;
        goto L4
    L8:
        if (r117 != 2) goto L10;
        r103 = r105;
        goto L18
    L10:
        if (r117 != 3) goto L12;
        r102 = r105;
        goto L18
    L12:
        if (r117 != 4) goto L18;
        r104 = r105;
        goto L18
    L19:
        float r106 = r101 - ((0.0f * r102) / 2.0f);
        float r107 = r103 - ((0.0f * r104) / 2.0f);
        float r108 = (r102 * 1.0f) + r106;
        float r109 = (r104 * 1.0f) + r107;
        r112[0] = ((r106 * (1.0f - r110)) + (r108 * r110)) + 0.0f;
        r112[1] = ((r107 * (1.0f - r111)) + (r109 * r111)) + 0.0f;
    }
}
