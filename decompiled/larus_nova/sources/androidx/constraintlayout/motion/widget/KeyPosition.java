package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import com.larus.nova.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes17.dex */
public class KeyPosition extends KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
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

    public static class Loader {
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

        static {
            SparseIntArray r100 = new SparseIntArray();
            mAttrMap = r100;
            r100.append(4, 1);
            mAttrMap.append(2, 2);
            mAttrMap.append(11, 3);
            mAttrMap.append(0, 4);
            mAttrMap.append(1, 5);
            mAttrMap.append(8, 6);
            mAttrMap.append(9, 7);
            mAttrMap.append(3, 9);
            mAttrMap.append(10, 8);
            mAttrMap.append(7, 11);
            mAttrMap.append(6, 12);
            mAttrMap.append(5, 10);
        }

        public static /* synthetic */ void access$000(KeyPosition r100, TypedArray r101) {
            read(r100, r101);
        }

        private static void read(KeyPosition r100, TypedArray r101) {
            int r102 = r101.getIndexCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L31;
            int r104 = r101.getIndex(r103);
            switch(mAttrMap.get(r104)) {
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L6:
            Integer.toHexString(r104);
            mAttrMap.get(r104);
        L30:
            r103 = r103 + 1;
            goto L3
        L7:
            r100.mPercentHeight = r101.getFloat(r104, r100.mPercentHeight);
            goto L30
        L8:
            r100.mPercentWidth = r101.getFloat(r104, r100.mPercentWidth);
            goto L30
        L9:
            r100.mPathMotionArc = r101.getInt(r104, r100.mPathMotionArc);
            goto L30
        L10:
            r100.mPositionType = r101.getInt(r104, r100.mPositionType);
            goto L30
        L11:
            float r105 = r101.getFloat(r104, r100.mPercentHeight);
            r100.mPercentWidth = r105;
            r100.mPercentHeight = r105;
            goto L30
        L12:
            r100.mPercentY = r101.getFloat(r104, r100.mPercentY);
            goto L30
        L13:
            r100.mPercentX = r101.getFloat(r104, r100.mPercentX);
            goto L30
        L14:
            r100.mDrawPath = r101.getInt(r104, r100.mDrawPath);
            goto L30
        L15:
            r100.mCurveFit = r101.getInteger(r104, r100.mCurveFit);
            goto L30
        L20:
            r100.mFramePosition = r101.getInt(r104, r100.mFramePosition);
            goto L30
        L17:
            if (r101.peekValue(r104).type != 3) goto L19;
            r100.mTransitionEasing = r101.getString(r104);
            goto L30
        L19:
            r100.mTransitionEasing = Easing.NAMED_EASING[r101.getInteger(r104, 0)];
            goto L30
        L22:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L27;
            int r106 = r101.getResourceId(r104, r100.mTargetId);
            r100.mTargetId = r106;
            if (r106 != (-1)) goto L30;
            r100.mTargetString = r101.getString(r104);
            goto L30
        L27:
            if (r101.peekValue(r104).type != 3) goto L29;
            r100.mTargetString = r101.getString(r104);
            goto L30
        L29:
            r100.mTargetId = r101.getResourceId(r104, r100.mTargetId);
            goto L30
        L31:
            int r107 = r100.mFramePosition;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> r100) {
    }

    public KeyPosition() {
        this.mTransitionEasing = null;
        this.mPathMotionArc = Key.UNSET;
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

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    private void calcScreenPosition(int r100, int r101) {
        float r102 = this.mPercentX;
        float r103 = 0;
        this.mCalculatedPositionX = ((r100 - 0) * r102) + r103;
        this.mCalculatedPositionY = ((r101 - 0) * r102) + r103;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context r100, AttributeSet r101) {
        Loader.access$000(this, r100.obtainStyledAttributes(r101, new int[]{R.attr.curveFit, R.attr.drawPath, R.attr.framePosition, R.attr.keyPositionType, R.attr.motionTarget, R.attr.pathMotionArc, R.attr.percentHeight, R.attr.percentWidth, R.attr.percentX, R.attr.percentY, R.attr.sizePercent, R.attr.transitionEasing}));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String r100, Object r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
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
        switch(r102) {
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
        this.mPercentY = toFloat(r101);
        return;
    L36:
        this.mPercentX = toFloat(r101);
        return;
    L37:
        float r103 = toFloat(r101);
        this.mPercentWidth = r103;
        this.mPercentHeight = r103;
        return;
    L38:
        this.mDrawPath = toInt(r101);
        return;
    L39:
        this.mPercentHeight = toFloat(r101);
        return;
    L40:
        this.mPercentWidth = toFloat(r101);
        return;
    L41:
        this.mTransitionEasing = r101.toString();
        return;
    L49:
        return;
    L6:
        if (r100.equals(PERCENT_Y) == false) goto L33;
        r102 = 6;
        goto L33
    L10:
        if (r100.equals(PERCENT_X) == false) goto L33;
        r102 = 5;
        goto L33
    L14:
        if (r100.equals("sizePercent") == false) goto L33;
        r102 = 4;
        goto L33
    L18:
        if (r100.equals("drawPath") == false) goto L33;
        r102 = 3;
        goto L33
    L22:
        if (r100.equals("percentHeight") == false) goto L33;
        r102 = 2;
        goto L33
    L26:
        if (r100.equals("percentWidth") == false) goto L33;
        r102 = 1;
        goto L33
    L30:
        if (r100.equals("transitionEasing") == false) goto L33;
        r102 = 0;
        goto L33
    }

    private void calcCartesianPosition(float r100, float r101, float r102, float r103) {
        float r104 = r102 - r100;
        float r105 = r103 - r101;
        float r106 = 0.0f;
        if (Float.isNaN(this.mPercentX) == false) goto L5;
        float r107 = 0.0f;
    L7:
        if (Float.isNaN(this.mAltPercentY) == false) goto L9;
        float r108 = 0.0f;
    L11:
        if (Float.isNaN(this.mPercentY) == false) goto L13;
        float r109 = 0.0f;
    L15:
        if (Float.isNaN(this.mAltPercentX) == true) goto L18;
        r106 = this.mAltPercentX;
    L18:
        this.mCalculatedPositionX = (int) ((r100 + (r107 * r104)) + (r106 * r105));
        this.mCalculatedPositionY = (int) ((r101 + (r104 * r108)) + (r105 * r109));
        return;
    L13:
        r109 = this.mPercentY;
        goto L15
    L9:
        r108 = this.mAltPercentY;
        goto L11
    L5:
        r107 = this.mPercentX;
        goto L7
    }

    private void calcPathPosition(float r100, float r101, float r102, float r103) {
        float r104 = r102 - r100;
        float r105 = r103 - r101;
        float r106 = this.mPercentX;
        float r107 = r100 + (r104 * r106);
        float r108 = this.mPercentY;
        this.mCalculatedPositionX = r107 + ((-r105) * r108);
        this.mCalculatedPositionY = (r101 + (r105 * r106)) + (r104 * r108);
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int r100, int r101, float r102, float r103, float r104, float r105) {
        int r106 = this.mPositionType;
        if (r106 != 1) goto L5;
        calcPathPosition(r102, r103, r104, r105);
        return;
    L5:
        if (r106 == 2) goto L8;
        calcCartesianPosition(r102, r103, r104, r105);
        return;
    L8:
        calcScreenPosition(r100, r101);
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int r100, int r101, RectF r110, RectF r111, float r112, float r113) {
        calcPosition(r100, r101, r110.centerX(), r110.centerY(), r111.centerX(), r111.centerY());
        if (Math.abs(r112 - this.mCalculatedPositionX) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(r113 - this.mCalculatedPositionY) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    public void positionCartAttributes(RectF r100, RectF r101, float r102, float r110, String[] r111, float[] r112) {
        float r103 = r100.centerX();
        float r104 = r100.centerY();
        float r105 = r101.centerX();
        float r106 = r105 - r103;
        float r107 = r101.centerY() - r104;
        String r108 = r111[0];
        if (r108 != null) goto L5;
        r111[0] = PERCENT_X;
        r112[0] = (r102 - r103) / r106;
        r111[1] = PERCENT_Y;
        r112[1] = (r110 - r104) / r107;
        return;
    L5:
        if (PERCENT_X.equals(r108) == false) goto L7;
        r112[0] = (r102 - r103) / r106;
        r112[1] = (r110 - r104) / r107;
        return;
    L7:
        r112[1] = (r102 - r103) / r106;
        r112[0] = (r110 - r104) / r107;
    }

    public void positionPathAttributes(RectF r110, RectF r111, float r112, float r113, String[] r114, float[] r115) {
        float r100 = r110.centerX();
        float r101 = r110.centerY();
        float r102 = r111.centerX() - r100;
        float r103 = r111.centerY() - r101;
        float r104 = (float) Math.hypot(r102, r103);
        if (r104 >= 1.0E-4d) goto L6;
        System.out.println("distance ~ 0");
        r115[0] = 0.0f;
        r115[1] = 0.0f;
        return;
    L6:
        float r105 = r102 / r104;
        float r106 = r103 / r104;
        float r107 = r113 - r101;
        float r108 = r112 - r100;
        float r109 = ((r105 * r107) - (r108 * r106)) / r104;
        float r116 = ((r105 * r108) + (r106 * r107)) / r104;
        String r117 = r114[0];
        if (r117 != null) goto L9;
        r114[0] = PERCENT_X;
        r114[1] = PERCENT_Y;
        r115[0] = r116;
        r115[1] = r109;
        return;
    L9:
        if (PERCENT_X.equals(r117) == false) goto L13;
        r115[0] = r116;
        r115[1] = r109;
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View r100, RectF r101, RectF r110, float r111, float r112, String[] r113, float[] r114) {
        int r102 = this.mPositionType;
        if (r102 != 1) goto L5;
        positionPathAttributes(r101, r110, r111, r112, r113, r114);
        return;
    L5:
        if (r102 == 2) goto L8;
        positionCartAttributes(r101, r110, r111, r112, r113, r114);
        return;
    L8:
        positionScreenAttributes(r100, r101, r110, r111, r112, r113, r114);
    }

    public void positionScreenAttributes(View r100, RectF r101, RectF r102, float r103, float r104, String[] r105, float[] r110) {
        r101.centerX();
        r101.centerY();
        r102.centerX();
        r102.centerY();
        ViewGroup r106 = (ViewGroup) r100.getParent();
        int r107 = r106.getWidth();
        int r108 = r106.getHeight();
        String r109 = r105[0];
        if (r109 != null) goto L5;
        r105[0] = PERCENT_X;
        r110[0] = r103 / r107;
        r105[1] = PERCENT_Y;
        r110[1] = r104 / r108;
        return;
    L5:
        if (PERCENT_X.equals(r109) == false) goto L7;
        r110[0] = r103 / r107;
        r110[1] = r104 / r108;
        return;
    L7:
        r110[1] = r103 / r107;
        r110[0] = r104 / r108;
    }
}
