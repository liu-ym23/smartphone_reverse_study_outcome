package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.obric.oui.constraintlayout.core.motion.utils.Easing;
import com.obric.oui.constraintlayout.motion.utils.ViewSpline;
import com.obric.oui.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    private static final String TAG = "KeyPosition";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_AXIS = 3;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    float mAltPercentX;
    float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    int mDrawPath;
    int mPathMotionArc;
    float mPercentHeight;
    float mPercentWidth;
    float mPercentX;
    float mPercentY;
    int mPositionType;
    String mTransitionEasing;

    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray sAttrMap;

        private Loader() {
        }

        static /* synthetic */ void access$000(KeyPosition r0, TypedArray r1) {
            read(r0, r1);
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            sAttrMap = r0;
            r0.append(R.styleable.KeyPosition_motionTarget, 1);
            sAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            sAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            sAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            sAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            sAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            sAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            sAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            sAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            sAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            sAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            sAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private static void read(KeyPosition r8, TypedArray r9) {
            int r0 = r9.getIndexCount();
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L33;
            int r5 = r9.getIndex(r2);
            switch(sAttrMap.get(r5)) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                default: goto L7;
            };
        L7:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("KeyPosition", "unused attribute 0x" + Integer.toHexString(r5) + "   " + sAttrMap.get(r5));
        L31:
            r2 = r2 + 1;
            goto L4
        L8:
            r8.mPercentHeight = r9.getFloat(r5, r8.mPercentHeight);
            goto L31
        L9:
            r8.mPercentWidth = r9.getFloat(r5, r8.mPercentWidth);
            goto L31
        L10:
            r8.mPathMotionArc = r9.getInt(r5, r8.mPathMotionArc);
            goto L31
        L11:
            r8.mPositionType = r9.getInt(r5, r8.mPositionType);
            goto L31
        L12:
            float r3 = r9.getFloat(r5, r8.mPercentHeight);
            r8.mPercentWidth = r3;
            r8.mPercentHeight = r3;
            goto L31
        L13:
            r8.mPercentY = r9.getFloat(r5, r8.mPercentY);
            goto L31
        L14:
            r8.mPercentX = r9.getFloat(r5, r8.mPercentX);
            goto L31
        L15:
            r8.mDrawPath = r9.getInt(r5, r8.mDrawPath);
            goto L31
        L16:
            r8.mCurveFit = r9.getInteger(r5, r8.mCurveFit);
            goto L31
        L21:
            r8.mFramePosition = r9.getInt(r5, r8.mFramePosition);
            goto L31
        L18:
            if (r9.peekValue(r5).type != 3) goto L20;
            r8.mTransitionEasing = r9.getString(r5);
            goto L31
        L20:
            r8.mTransitionEasing = Easing.NAMED_EASING[r9.getInteger(r5, 0)];
            goto L31
        L23:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L28;
            r8.mTargetId = r9.getResourceId(r5, r8.mTargetId);
            if (r8.mTargetId != (-1)) goto L31;
            r8.mTargetString = r9.getString(r5);
            goto L31
        L28:
            if (r9.peekValue(r5).type != 3) goto L30;
            r8.mTargetString = r9.getString(r5);
            goto L31
        L30:
            r8.mTargetId = r9.getResourceId(r5, r8.mTargetId);
            goto L31
        L33:
            if (r8.mFramePosition != (-1)) goto L54;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("KeyPosition", "no frame position");
            return;
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> r1) {
    }

    public KeyPosition() {
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

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo444clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void load(Context r2, AttributeSet r3) {
        Loader.access$000(this, r2.obtainStyledAttributes(r3, R.styleable.KeyPosition));
    }

    public void setType(int r1) {
        this.mPositionType = r1;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.KeyPositionBase
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

    @Override // com.obric.oui.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View r8, RectF r9, RectF r10, float r11, float r12, String[] r13, float[] r14) {
        int r0 = this.mPositionType;
        if (r0 != 1) goto L5;
        positionPathAttributes(r9, r10, r11, r12, r13, r14);
        return;
    L5:
        if (r0 != 2) goto L7;
        positionScreenAttributes(r8, r9, r10, r11, r12, r13, r14);
        return;
    L7:
        if (r0 == 3) goto L10;
        positionCartAttributes(r9, r10, r11, r12, r13, r14);
        return;
    L10:
        positionAxisAttributes(r9, r10, r11, r12, r13, r14);
    }

    void positionPathAttributes(RectF r7, RectF r8, float r9, float r10, String[] r11, float[] r12) {
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

    void positionScreenAttributes(View r3, RectF r4, RectF r5, float r6, float r7, String[] r8, float[] r9) {
        r4.centerX();
        r4.centerY();
        r5.centerX();
        r5.centerY();
        ViewGroup r2 = (ViewGroup) r3.getParent();
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

    void positionCartAttributes(RectF r6, RectF r7, float r8, float r9, String[] r10, float[] r11) {
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

    void positionAxisAttributes(RectF r7, RectF r8, float r9, float r10, String[] r11, float[] r12) {
        float r6 = r7.centerX();
        float r13 = r7.centerY();
        float r0 = r8.centerX();
        float r14 = r8.centerY();
        if (r6 <= r0) goto L6;
        r0 = r6;
        r6 = r0;
    L6:
        if (r13 > r14) goto L9;
        r14 = r13;
        r13 = r14;
    L9:
        float r1 = r0 - r6;
        float r15 = r13 - r14;
        String r2 = r11[0];
        if (r2 != null) goto L12;
        r11[0] = "percentX";
        r12[0] = (r9 - r6) / r1;
        r11[1] = "percentY";
        r12[1] = (r10 - r14) / r15;
        return;
    L12:
        if ("percentX".equals(r2) == false) goto L14;
        r12[0] = (r9 - r6) / r1;
        r12[1] = (r10 - r14) / r15;
        return;
    L14:
        r12[1] = (r9 - r6) / r1;
        r12[0] = (r10 - r14) / r15;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int r8, int r9, RectF r10, RectF r11, float r12, float r13) {
        calcPosition(r8, r9, r10.centerX(), r10.centerY(), r11.centerX(), r11.centerY());
        if (Math.abs(r12 - this.mCalculatedPositionX) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(r13 - this.mCalculatedPositionY) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public void setValue(String r3, Object r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1812823328: goto L30;
            case -1127236479: goto L26;
            case -1017587252: goto L22;
            case -827014263: goto L18;
            case -200259324: goto L14;
            case 428090547: goto L10;
            case 428090548: goto L6;
            default: goto L33;
        };
    L33:
        switch(r1) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L49;
        };
    L35:
        this.mPercentY = toFloat(r4);
        return;
    L36:
        this.mPercentX = toFloat(r4);
        return;
    L37:
        float r5 = toFloat(r4);
        this.mPercentWidth = r5;
        this.mPercentHeight = r5;
        return;
    L38:
        this.mDrawPath = toInt(r4);
        return;
    L39:
        this.mPercentHeight = toFloat(r4);
        return;
    L40:
        this.mPercentWidth = toFloat(r4);
        return;
    L41:
        this.mTransitionEasing = r4.toString();
        return;
    L49:
        return;
    L6:
        if (r3.equals("percentY") == false) goto L33;
        r1 = 6;
        goto L33
    L10:
        if (r3.equals("percentX") == false) goto L33;
        r1 = 5;
        goto L33
    L14:
        if (r3.equals("sizePercent") == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (r3.equals("drawPath") == false) goto L33;
        r1 = 3;
        goto L33
    L22:
        if (r3.equals("percentHeight") == false) goto L33;
        r1 = 2;
        goto L33
    L26:
        if (r3.equals("percentWidth") == false) goto L33;
        r1 = 1;
        goto L33
    L30:
        if (r3.equals("transitionEasing") == false) goto L33;
        r1 = 0;
        goto L33
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public Key copy(Key r2) {
        super.copy(r2);
        KeyPosition r3 = (KeyPosition) r2;
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

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyPosition().copy(this);
    }
}
