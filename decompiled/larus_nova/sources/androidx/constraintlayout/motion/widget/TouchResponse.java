package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.larus.nova.R;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
class TouchResponse {
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION = null;
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES = null;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;

    static {
        TOUCH_SIDES = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        TOUCH_DIRECTION = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    public void setupTouch() {
        int r100 = this.mTouchAnchorId;
        if (r100 == (-1)) goto L7;
        View r101 = this.mMotionLayout.findViewById(r100);
        if (r101 != null) goto L9;
        Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId);
    L9:
        if ((r101 instanceof NestedScrollView) == false) goto L12;
        NestedScrollView r102 = (NestedScrollView) r101;
        r102.setOnTouchListener(new AnonymousClass1(this));
        r102.setOnScrollChangeListener(new AnonymousClass2(this));
        return;
    L12:
        return;
    L7:
        r101 = null;
        goto L9
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    private void fill(TypedArray r100) {
        int r101 = r100.getIndexCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L40;
        int r103 = r100.getIndex(r102);
        if (r103 != 16) goto L8;
        this.mTouchAnchorId = r100.getResourceId(r103, this.mTouchAnchorId);
    L39:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r103 != 17) goto L10;
        int r104 = r100.getInt(r103, this.mTouchAnchorSide);
        this.mTouchAnchorSide = r104;
        float[] r105 = TOUCH_SIDES[r104];
        this.mTouchAnchorX = r105[0];
        this.mTouchAnchorY = r105[1];
        goto L39
    L10:
        if (r103 != 1) goto L13;
        int r106 = r100.getInt(r103, this.mTouchSide);
        this.mTouchSide = r106;
        float[] r107 = TOUCH_DIRECTION[r106];
        this.mTouchDirectionX = r107[0];
        this.mTouchDirectionY = r107[1];
        goto L39
    L13:
        if (r103 != 6) goto L16;
        this.mMaxVelocity = r100.getFloat(r103, this.mMaxVelocity);
        goto L39
    L16:
        if (r103 != 5) goto L19;
        this.mMaxAcceleration = r100.getFloat(r103, this.mMaxAcceleration);
        goto L39
    L19:
        if (r103 != 7) goto L22;
        this.mMoveWhenScrollAtTop = r100.getBoolean(r103, this.mMoveWhenScrollAtTop);
        goto L39
    L22:
        if (r103 != 2) goto L25;
        this.mDragScale = r100.getFloat(r103, this.mDragScale);
        goto L39
    L25:
        if (r103 != 3) goto L28;
        this.mDragThreshold = r100.getFloat(r103, this.mDragThreshold);
        goto L39
    L28:
        if (r103 != 18) goto L31;
        this.mTouchRegionId = r100.getResourceId(r103, this.mTouchRegionId);
        goto L39
    L31:
        if (r103 != 9) goto L34;
        this.mOnTouchUp = r100.getInt(r103, this.mOnTouchUp);
        goto L39
    L34:
        if (r103 != 8) goto L37;
        this.mFlags = r100.getInteger(r103, 0);
        goto L39
    L37:
        if (r103 != 4) goto L39;
        this.mLimitBoundsTo = r100.getResourceId(r103, 0);
        goto L39
    }

    public void setAnchorId(int r100) {
        this.mTouchAnchorId = r100;
    }

    public void setMaxAcceleration(float r100) {
        this.mMaxAcceleration = r100;
    }

    public void setMaxVelocity(float r100) {
        this.mMaxVelocity = r100;
    }

    public void setRTL(boolean r100) {
        if (r100 == false) goto L5;
        float[][] r101 = TOUCH_DIRECTION;
        r101[4] = r101[3];
        r101[5] = r101[2];
        float[][] r102 = TOUCH_SIDES;
        r102[5] = r102[2];
        r102[6] = r102[1];
    L6:
        float[] r103 = TOUCH_SIDES[this.mTouchAnchorSide];
        this.mTouchAnchorX = r103[0];
        this.mTouchAnchorY = r103[1];
        float[] r104 = TOUCH_DIRECTION[this.mTouchSide];
        this.mTouchDirectionX = r104[0];
        this.mTouchDirectionY = r104[1];
        return;
    L5:
        float[][] r105 = TOUCH_DIRECTION;
        r105[4] = r105[2];
        r105[5] = r105[3];
        float[][] r106 = TOUCH_SIDES;
        r106[5] = r106[1];
        r106[6] = r106[2];
        goto L6
    }

    private void fillFromAttributeList(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.autoCompleteMode, R.attr.dragDirection, R.attr.dragScale, R.attr.dragThreshold, R.attr.limitBoundsTo, R.attr.maxAcceleration, R.attr.maxVelocity, R.attr.moveWhenScrollAtTop, R.attr.nestedScrollFlags, R.attr.onTouchUp, R.attr.rotationCenterId, R.attr.springBoundary, R.attr.springDamping, R.attr.springMass, R.attr.springStiffness, R.attr.springStopThreshold, R.attr.touchAnchorId, R.attr.touchAnchorSide, R.attr.touchRegionId});
        fill(r102);
        r102.recycle();
    }

    public float dot(float r100, float r101) {
        return (r100 * this.mTouchDirectionX) + (r101 * this.mTouchDirectionY);
    }

    public RectF getLimitBoundsTo(ViewGroup r100, RectF r101) {
        int r102 = this.mLimitBoundsTo;
        if (r102 != (-1)) goto L5;
        return null;
    L5:
        View r103 = r100.findViewById(r102);
        if (r103 != null) goto L8;
        return null;
    L8:
        r101.set(r103.getLeft(), r103.getTop(), r103.getRight(), r103.getBottom());
        return r101;
    }

    public float getProgressDirection(float r100, float r101) {
        float r102 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r102, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r103 = this.mTouchDirectionX;
        if (r103 == 0.0f) goto L8;
        float[] r104 = this.mAnchorDpDt;
        if (r104[0] != 0.0f) goto L13;
        r104[0] = 1.0E-7f;
    L13:
        return (r100 * r103) / r104[0];
    L8:
        float[] r105 = this.mAnchorDpDt;
        if (r105[1] != 0.0f) goto L12;
        r105[1] = 1.0E-7f;
    L12:
        return (r101 * this.mTouchDirectionY) / r105[1];
    }

    public RectF getTouchRegion(ViewGroup r100, RectF r101) {
        int r102 = this.mTouchRegionId;
        if (r102 != (-1)) goto L5;
        return null;
    L5:
        View r103 = r100.findViewById(r102);
        if (r103 != null) goto L8;
        return null;
    L8:
        r101.set(r103.getLeft(), r103.getTop(), r103.getRight(), r103.getBottom());
        return r101;
    }

    public void scrollMove(float r100, float r110) {
        float r101 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L5;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r101);
    L5:
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r101, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r102 = this.mTouchDirectionX;
        float[] r103 = this.mAnchorDpDt;
        if (Math.abs((r102 * r103[0]) + (this.mTouchDirectionY * r103[1])) >= 0.01d) goto L8;
        float[] r104 = this.mAnchorDpDt;
        r104[0] = 0.01f;
        r104[1] = 0.01f;
    L8:
        float r105 = this.mTouchDirectionX;
        if (r105 == 0.0f) goto L11;
        float r106 = (r100 * r105) / this.mAnchorDpDt[0];
    L12:
        float r107 = Math.max(Math.min(r101 + r106, 1.0f), 0.0f);
        if (r107 == this.mMotionLayout.getProgress()) goto L16;
        this.mMotionLayout.setProgress(r107);
        return;
    L16:
        return;
    L11:
        r106 = (r110 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        goto L12
    }

    public void scrollUp(float r110, float r111) {
        boolean r100 = false;
        this.mDragStarted = false;
        float r101 = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, r101, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float r102 = this.mTouchDirectionX;
        float[] r103 = this.mAnchorDpDt;
        float r104 = r103[0];
        float r105 = this.mTouchDirectionY;
        float r106 = r103[1];
        float r107 = 0.0f;
        if (r102 == 0.0f) goto L5;
        float r112 = (r110 * r102) / r104;
    L7:
        if (Float.isNaN(r112) == true) goto L10;
        r101 = r101 + (r112 / 3.0f);
    L10:
        if (r101 != 0.0f) goto L12;
        return;
    L12:
        if (r101 == 1.0f) goto L14;
        boolean r108 = true;
    L15:
        int r109 = this.mOnTouchUp;
        if (r109 == 3) goto L19;
        r100 = true;
    L19:
        if ((r100 & r108) == false) goto L27;
        MotionLayout r113 = this.mMotionLayout;
        if (r101 < 0.5d) goto L24;
        r107 = 1.0f;
    L24:
        r113.touchAnimateTo(r109, r107, r112);
        return;
    L27:
        return;
    L14:
        r108 = false;
        goto L15
    L5:
        r112 = (r111 * r105) / r106;
        goto L7
    }

    public void setDown(float r100, float r101) {
        this.mLastTouchX = r100;
        this.mLastTouchY = r101;
    }

    public void setTouchAnchorLocation(float r100, float r101) {
        this.mTouchAnchorX = r100;
        this.mTouchAnchorY = r101;
    }

    public void setUpTouchEvent(float r100, float r101) {
        this.mLastTouchX = r100;
        this.mLastTouchY = r101;
        this.mDragStarted = false;
    }

    public TouchResponse(Context r100, MotionLayout r101, XmlPullParser r102) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mMotionLayout = r101;
        fillFromAttributeList(r100, Xml.asAttributeSet(r102));
    }

    public void processTouchEvent(MotionEvent r110, MotionLayout.MotionTracker r210, int r211, MotionScene r212) {
        r210.addMovement(r110);
        int r100 = r110.getAction();
        if (r100 != 0) goto L5;
        this.mLastTouchX = r110.getRawX();
        this.mLastTouchY = r110.getRawY();
        this.mDragStarted = false;
        return;
    L5:
        if (r100 != 1) goto L7;
        this.mDragStarted = false;
        r210.computeCurrentVelocity(1000);
        float r101 = r210.getXVelocity();
        float r102 = r210.getYVelocity();
        float r103 = this.mMotionLayout.getProgress();
        int r111 = this.mTouchAnchorId;
        if (r111 == (-1)) goto L39;
        this.mMotionLayout.getAnchorDpDt(r111, r103, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L40:
        float r104 = this.mTouchDirectionX;
        float[] r105 = this.mAnchorDpDt;
        float r106 = r105[0];
        float r107 = r105[1];
        if (r104 == 0.0f) goto L43;
        float r108 = r101 / r106;
    L45:
        if (Float.isNaN(r108) == true) goto L47;
        float r109 = (r108 / 3.0f) + r103;
    L49:
        if (r109 == 0.0f) goto L64;
        if (r109 == 1.0f) goto L64;
        int r112 = this.mOnTouchUp;
        if (r112 == 3) goto L64;
        MotionLayout r113 = this.mMotionLayout;
        if (r109 >= 0.5d) goto L57;
        float r114 = 0.0f;
    L58:
        r113.touchAnimateTo(r112, r114, r108);
        if (0.0f < r103) goto L61;
    L62:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L61:
        if (1.0f <= r103) goto L62;
        return;
    L57:
        r114 = 1.0f;
    L64:
        if (0.0f < r109) goto L66;
    L67:
        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L66:
        if (1.0f <= r109) goto L67;
        return;
    L47:
        r109 = r103;
        goto L49
    L43:
        r108 = r102 / r107;
        goto L45
    L39:
        float r115 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r116 = this.mAnchorDpDt;
        r116[1] = this.mTouchDirectionY * r115;
        r116[0] = r115 * this.mTouchDirectionX;
        goto L40
    L7:
        if (r100 != 2) goto L76;
        float r117 = r110.getRawY() - this.mLastTouchY;
        float r118 = r110.getRawX() - this.mLastTouchX;
        if (Math.abs((this.mTouchDirectionX * r118) + (this.mTouchDirectionY * r117)) <= this.mDragThreshold) goto L12;
    L13:
        float r119 = this.mMotionLayout.getProgress();
        if (this.mDragStarted == true) goto L16;
        this.mDragStarted = true;
        this.mMotionLayout.setProgress(r119);
    L16:
        int r120 = this.mTouchAnchorId;
        if (r120 == (-1)) goto L19;
        this.mMotionLayout.getAnchorDpDt(r120, r119, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    L20:
        float r121 = this.mTouchDirectionX;
        float[] r122 = this.mAnchorDpDt;
        if (Math.abs(((r121 * r122[0]) + (this.mTouchDirectionY * r122[1])) * this.mDragScale) >= 0.01d) goto L24;
        float[] r123 = this.mAnchorDpDt;
        r123[0] = 0.01f;
        r123[1] = 0.01f;
    L24:
        if (this.mTouchDirectionX == 0.0f) goto L26;
        float r124 = r118 / this.mAnchorDpDt[0];
    L27:
        float r125 = Math.max(Math.min(r119 + r124, 1.0f), 0.0f);
        if (r125 == this.mMotionLayout.getProgress()) goto L34;
        this.mMotionLayout.setProgress(r125);
        r210.computeCurrentVelocity(1000);
        float r126 = r210.getXVelocity();
        float r127 = r210.getYVelocity();
        if (this.mTouchDirectionX == 0.0f) goto L32;
        float r128 = r126 / this.mAnchorDpDt[0];
    L33:
        this.mMotionLayout.mLastVelocity = r128;
    L35:
        this.mLastTouchX = r110.getRawX();
        this.mLastTouchY = r110.getRawY();
        return;
    L32:
        r128 = r127 / this.mAnchorDpDt[1];
        goto L33
    L34:
        this.mMotionLayout.mLastVelocity = 0.0f;
        goto L35
    L26:
        r124 = r117 / this.mAnchorDpDt[1];
        goto L27
    L19:
        float r129 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
        float[] r130 = this.mAnchorDpDt;
        r130[1] = this.mTouchDirectionY * r129;
        r130[0] = r129 * this.mTouchDirectionX;
        goto L20
    L12:
        if (this.mDragStarted == true) goto L13;
        return;
    }
}
