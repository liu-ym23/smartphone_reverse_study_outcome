package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> r1) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> r1) {
    }

    public MotionKeyPosition() {
        this.mCurveFit = UNSET;
        this.mTransitionEasing = null;
        this.mPathMotionArc = UNSET;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
        return clone();
    }

    private void calcScreenPosition(int r4, int r5) {
        float r1 = this.mPercentX;
        float r2 = 0;
        this.mCalculatedPositionX = ((r4 - 0) * r1) + r2;
        this.mCalculatedPositionY = ((r5 - 0) * r1) + r2;
    }

    private void calcPathPosition(float r4, float r5, float r6, float r7) {
        float r8 = r6 - r4;
        float r9 = r7 - r5;
        float r1 = this.mPercentX;
        float r10 = r4 + (r8 * r1);
        float r2 = this.mPercentY;
        this.mCalculatedPositionX = r10 + ((-r9) * r2);
        this.mCalculatedPositionY = (r5 + (r9 * r1)) + (r8 * r2);
    }

    private void calcCartesianPosition(float r6, float r7, float r8, float r9) {
        float r10 = r8 - r6;
        float r11 = r9 - r7;
        float r1 = 0.0f;
        if (Float.isNaN(this.mPercentX) == false) goto L5;
        float r0 = 0.0f;
    L7:
        if (Float.isNaN(this.mAltPercentY) == false) goto L9;
        float r2 = 0.0f;
    L11:
        if (Float.isNaN(this.mPercentY) == false) goto L13;
        float r3 = 0.0f;
    L15:
        if (Float.isNaN(this.mAltPercentX) == true) goto L18;
        r1 = this.mAltPercentX;
    L18:
        this.mCalculatedPositionX = (int) ((r6 + (r0 * r10)) + (r1 * r11));
        this.mCalculatedPositionY = (int) ((r7 + (r10 * r2)) + (r11 * r3));
        return;
    L13:
        r3 = this.mPercentY;
        goto L15
    L9:
        r2 = this.mAltPercentY;
        goto L11
    L5:
        r0 = this.mPercentX;
        goto L7
    }

    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public void positionAttributes(MotionWidget r8, FloatRect r9, FloatRect r10, float r11, float r12, String[] r13, float[] r14) {
        int r0 = this.mPositionType;
        if (r0 != 1) goto L5;
        positionPathAttributes(r9, r10, r11, r12, r13, r14);
        return;
    L5:
        if (r0 == 2) goto L8;
        positionCartAttributes(r9, r10, r11, r12, r13, r14);
        return;
    L8:
        positionScreenAttributes(r8, r9, r10, r11, r12, r13, r14);
    }

    void positionPathAttributes(FloatRect r7, FloatRect r8, float r9, float r10, String[] r11, float[] r12) {
        float r6 = r7.centerX();
        float r13 = r7.centerY();
        float r0 = r8.centerX() - r6;
        float r14 = r8.centerY() - r13;
        float r1 = (float) Math.hypot(r0, r14);
        if (r1 >= 1.0E-4d) goto L6;
        System.out.println("distance ~ 0");
        r12[0] = 0.0f;
        r12[1] = 0.0f;
        return;
    L6:
        float r2 = r0 / r1;
        float r15 = r14 / r1;
        float r16 = r10 - r13;
        float r17 = r9 - r6;
        float r18 = ((r2 * r16) - (r17 * r15)) / r1;
        float r3 = ((r2 * r17) + (r15 * r16)) / r1;
        String r19 = r11[0];
        if (r19 != null) goto L9;
        r11[0] = "percentX";
        r11[1] = "percentY";
        r12[0] = r3;
        r12[1] = r18;
        return;
    L9:
        if ("percentX".equals(r19) == false) goto L13;
        r12[0] = r3;
        r12[1] = r18;
        return;
    }

    void positionScreenAttributes(MotionWidget r3, FloatRect r4, FloatRect r5, float r6, float r7, String[] r8, float[] r9) {
        r4.centerX();
        r4.centerY();
        r5.centerX();
        r5.centerY();
        MotionWidget r2 = r3.getParent();
        int r10 = r2.getWidth();
        int r11 = r2.getHeight();
        String r12 = r8[0];
        if (r12 != null) goto L5;
        r8[0] = "percentX";
        r9[0] = r6 / r10;
        r8[1] = "percentY";
        r9[1] = r7 / r11;
        return;
    L5:
        if ("percentX".equals(r12) == false) goto L7;
        r9[0] = r6 / r10;
        r9[1] = r7 / r11;
        return;
    L7:
        r9[1] = r6 / r10;
        r9[0] = r7 / r11;
    }

    void positionCartAttributes(FloatRect r6, FloatRect r7, float r8, float r9, String[] r10, float[] r11) {
        float r5 = r6.centerX();
        float r12 = r6.centerY();
        float r0 = r7.centerX();
        float r1 = r0 - r5;
        float r13 = r7.centerY() - r12;
        String r2 = r10[0];
        if (r2 != null) goto L5;
        r10[0] = "percentX";
        r11[0] = (r8 - r5) / r1;
        r10[1] = "percentY";
        r11[1] = (r9 - r12) / r13;
        return;
    L5:
        if ("percentX".equals(r2) == false) goto L7;
        r11[0] = (r8 - r5) / r1;
        r11[1] = (r9 - r12) / r13;
        return;
    L7:
        r11[1] = (r8 - r5) / r1;
        r11[0] = (r9 - r12) / r13;
    }

    public boolean intersects(int r8, int r9, FloatRect r10, FloatRect r11, float r12, float r13) {
        calcPosition(r8, r9, r10.centerX(), r10.centerY(), r11.centerX(), r11.centerY());
        if (Math.abs(r12 - this.mCalculatedPositionX) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(r13 - this.mCalculatedPositionY) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey r2) {
        super.copy(r2);
        MotionKeyPosition r3 = (MotionKeyPosition) r2;
        this.mTransitionEasing = r3.mTransitionEasing;
        this.mPathMotionArc = r3.mPathMotionArc;
        this.mDrawPath = r3.mDrawPath;
        this.mPercentWidth = r3.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = r3.mPercentX;
        this.mPercentY = r3.mPercentY;
        this.mAltPercentX = r3.mAltPercentX;
        this.mAltPercentY = r3.mAltPercentY;
        this.mCalculatedPositionX = r3.mCalculatedPositionX;
        this.mCalculatedPositionY = r3.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyPosition().copy(this);
    }

    void calcPosition(int r3, int r4, float r5, float r6, float r7, float r8) {
        int r0 = this.mPositionType;
        if (r0 != 1) goto L5;
        calcPathPosition(r5, r6, r7, r8);
        return;
    L5:
        if (r0 == 2) goto L8;
        calcCartesianPosition(r5, r6, r7, r8);
        return;
    L8:
        calcScreenPosition(r3, r4);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, int r3) {
        if (r2 != 100) goto L5;
        this.mFramePosition = r3;
        return true;
    L5:
        if (r2 != 508) goto L7;
        this.mCurveFit = r3;
        return true;
    L7:
        if (r2 != 510) goto L9;
        this.mPositionType = r3;
        return true;
    L9:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, float r2) {
        switch(r1) {
            case 503: goto L9;
            case 504: goto L8;
            case 505: goto L7;
            case 506: goto L6;
            case 507: goto L5;
            default: goto L4;
        };
    L5:
        this.mPercentY = r2;
        return true;
    L6:
        this.mPercentX = r2;
        return true;
    L7:
        this.mPercentWidth = r2;
        this.mPercentHeight = r2;
        return true;
    L8:
        this.mPercentHeight = r2;
        return true;
    L9:
        this.mPercentWidth = r2;
        return true;
    L4:
        return super.setValue(r1, r2);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, String r3) {
        if (r2 != 501) goto L5;
        this.mTransitionEasing = r3.toString();
        return true;
    L5:
        return super.setValue(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return TypedValues.PositionType.getId(r1);
    }
}
