package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
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
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static /* synthetic */ void access$000(KeyPosition r0, TypedArray r1) {
            read(r0, r1);
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            mAttrMap = r0;
            r0.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private static void read(KeyPosition c, TypedArray a) {
            int r0 = a.getIndexCount();
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L33;
            int r5 = a.getIndex(r2);
            switch(mAttrMap.get(r5)) {
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
            Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(r5) + "   " + mAttrMap.get(r5));
        L31:
            r2 = r2 + 1;
            goto L4
        L8:
            c.mPercentHeight = a.getFloat(r5, c.mPercentHeight);
            goto L31
        L9:
            c.mPercentWidth = a.getFloat(r5, c.mPercentWidth);
            goto L31
        L10:
            c.mPathMotionArc = a.getInt(r5, c.mPathMotionArc);
            goto L31
        L11:
            c.mPositionType = a.getInt(r5, c.mPositionType);
            goto L31
        L12:
            float r3 = a.getFloat(r5, c.mPercentHeight);
            c.mPercentWidth = r3;
            c.mPercentHeight = r3;
            goto L31
        L13:
            c.mPercentY = a.getFloat(r5, c.mPercentY);
            goto L31
        L14:
            c.mPercentX = a.getFloat(r5, c.mPercentX);
            goto L31
        L15:
            c.mDrawPath = a.getInt(r5, c.mDrawPath);
            goto L31
        L16:
            c.mCurveFit = a.getInteger(r5, c.mCurveFit);
            goto L31
        L21:
            c.mFramePosition = a.getInt(r5, c.mFramePosition);
            goto L31
        L18:
            if (a.peekValue(r5).type != 3) goto L20;
            c.mTransitionEasing = a.getString(r5);
            goto L31
        L20:
            c.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(r5, 0)];
            goto L31
        L23:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L28;
            c.mTargetId = a.getResourceId(r5, c.mTargetId);
            if (c.mTargetId != (-1)) goto L31;
            c.mTargetString = a.getString(r5);
            goto L31
        L28:
            if (a.peekValue(r5).type != 3) goto L30;
            c.mTargetString = a.getString(r5);
            goto L31
        L30:
            c.mTargetId = a.getResourceId(r5, c.mTargetId);
            goto L31
        L33:
            if (c.mFramePosition != (-1)) goto L54;
            Log.e("KeyPosition", "no frame position");
            return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
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

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo13clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.access$000(this, context.obtainStyledAttributes(attrs, R.styleable.KeyPosition));
    }

    public void setType(int type) {
        this.mPositionType = type;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    void calcPosition(int layoutWidth, int layoutHeight, float start_x, float start_y, float end_x, float end_y) {
        int r0 = this.mPositionType;
        if (r0 != 1) goto L5;
        calcPathPosition(start_x, start_y, end_x, end_y);
        return;
    L5:
        if (r0 == 2) goto L8;
        calcCartesianPosition(start_x, start_y, end_x, end_y);
        return;
    L8:
        calcScreenPosition(layoutWidth, layoutHeight);
    }

    private void calcScreenPosition(int layoutWidth, int layoutHeight) {
        float r1 = this.mPercentX;
        float r2 = 0;
        this.mCalculatedPositionX = ((layoutWidth - 0) * r1) + r2;
        this.mCalculatedPositionY = ((layoutHeight - 0) * r1) + r2;
    }

    private void calcPathPosition(float start_x, float start_y, float end_x, float end_y) {
        float r6 = end_x - start_x;
        float r7 = end_y - start_y;
        float r1 = this.mPercentX;
        float r4 = start_x + (r6 * r1);
        float r2 = this.mPercentY;
        this.mCalculatedPositionX = r4 + ((-r7) * r2);
        this.mCalculatedPositionY = (start_y + (r7 * r1)) + (r6 * r2);
    }

    private void calcCartesianPosition(float start_x, float start_y, float end_x, float end_y) {
        float r8 = end_x - start_x;
        float r9 = end_y - start_y;
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
        this.mCalculatedPositionX = (int) ((start_x + (r0 * r8)) + (r1 * r9));
        this.mCalculatedPositionY = (int) ((start_y + (r8 * r2)) + (r9 * r3));
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

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        int r0 = this.mPositionType;
        if (r0 != 1) goto L5;
        positionPathAttributes(start, end, x, y, attribute, value);
        return;
    L5:
        if (r0 == 2) goto L8;
        positionCartAttributes(start, end, x, y, attribute, value);
        return;
    L8:
        positionScreenAttributes(view, start, end, x, y, attribute, value);
    }

    void positionPathAttributes(RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        float r6 = start.centerX();
        float r7 = start.centerY();
        float r0 = end.centerX() - r6;
        float r8 = end.centerY() - r7;
        float r1 = (float) Math.hypot(r0, r8);
        if (r1 >= 1.0E-4d) goto L6;
        System.out.println("distance ~ 0");
        value[0] = 0.0f;
        value[1] = 0.0f;
        return;
    L6:
        float r2 = r0 / r1;
        float r9 = r8 / r1;
        float r10 = y - r7;
        float r11 = x - r6;
        float r12 = ((r2 * r10) - (r11 * r9)) / r1;
        float r3 = ((r2 * r11) + (r9 * r10)) / r1;
        String r13 = attribute[0];
        if (r13 != null) goto L9;
        attribute[0] = "percentX";
        attribute[1] = "percentY";
        value[0] = r3;
        value[1] = r12;
        return;
    L9:
        if ("percentX".equals(r13) == false) goto L13;
        value[0] = r3;
        value[1] = r12;
        return;
    }

    void positionScreenAttributes(View view, RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        start.centerX();
        start.centerY();
        end.centerX();
        end.centerY();
        ViewGroup r2 = (ViewGroup) view.getParent();
        int r3 = r2.getWidth();
        int r4 = r2.getHeight();
        String r5 = attribute[0];
        if (r5 != null) goto L5;
        attribute[0] = "percentX";
        value[0] = x / r3;
        attribute[1] = "percentY";
        value[1] = y / r4;
        return;
    L5:
        if ("percentX".equals(r5) == false) goto L7;
        value[0] = x / r3;
        value[1] = y / r4;
        return;
    L7:
        value[1] = x / r3;
        value[0] = y / r4;
    }

    void positionCartAttributes(RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        float r5 = start.centerX();
        float r6 = start.centerY();
        float r0 = end.centerX();
        float r1 = r0 - r5;
        float r7 = end.centerY() - r6;
        String r2 = attribute[0];
        if (r2 != null) goto L5;
        attribute[0] = "percentX";
        value[0] = (x - r5) / r1;
        attribute[1] = "percentY";
        value[1] = (y - r6) / r7;
        return;
    L5:
        if ("percentX".equals(r2) == false) goto L7;
        value[0] = (x - r5) / r1;
        value[1] = (y - r6) / r7;
        return;
    L7:
        value[1] = (x - r5) / r1;
        value[0] = (y - r6) / r7;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int layoutWidth, int layoutHeight, RectF start, RectF end, float x, float y) {
        calcPosition(layoutWidth, layoutHeight, start.centerX(), start.centerY(), end.centerX(), end.centerY());
        if (Math.abs(x - this.mCalculatedPositionX) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(y - this.mCalculatedPositionY) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        byte r1 = -1;
        switch(tag.hashCode()) {
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
        this.mPercentY = toFloat(value);
        return;
    L36:
        this.mPercentX = toFloat(value);
        return;
    L37:
        float r3 = toFloat(value);
        this.mPercentWidth = r3;
        this.mPercentHeight = r3;
        return;
    L38:
        this.mDrawPath = toInt(value);
        return;
    L39:
        this.mPercentHeight = toFloat(value);
        return;
    L40:
        this.mPercentWidth = toFloat(value);
        return;
    L41:
        this.mTransitionEasing = value.toString();
        return;
    L49:
        return;
    L6:
        if (tag.equals("percentY") == false) goto L33;
        r1 = 6;
        goto L33
    L10:
        if (tag.equals("percentX") == false) goto L33;
        r1 = 5;
        goto L33
    L14:
        if (tag.equals("sizePercent") == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (tag.equals("drawPath") == false) goto L33;
        r1 = 3;
        goto L33
    L22:
        if (tag.equals("percentHeight") == false) goto L33;
        r1 = 2;
        goto L33
    L26:
        if (tag.equals("percentWidth") == false) goto L33;
        r1 = 1;
        goto L33
    L30:
        if (tag.equals("transitionEasing") == false) goto L33;
        r1 = 0;
        goto L33
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyPosition r2 = (KeyPosition) src;
        this.mTransitionEasing = r2.mTransitionEasing;
        this.mPathMotionArc = r2.mPathMotionArc;
        this.mDrawPath = r2.mDrawPath;
        this.mPercentWidth = r2.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = r2.mPercentX;
        this.mPercentY = r2.mPercentY;
        this.mAltPercentX = r2.mAltPercentX;
        this.mAltPercentY = r2.mAltPercentY;
        this.mCalculatedPositionX = r2.mCalculatedPositionX;
        this.mCalculatedPositionY = r2.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyPosition().copy(this);
    }
}
