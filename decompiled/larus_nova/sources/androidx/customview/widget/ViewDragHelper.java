package androidx.customview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = null;
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public Callback() {
        }

        public int clampViewPositionHorizontal(View r100, int r101, int r102) {
            return 0;
        }

        public int clampViewPositionVertical(View r100, int r101, int r102) {
            return 0;
        }

        public int getOrderedChildIndex(int r100) {
            return r100;
        }

        public int getViewHorizontalDragRange(View r100) {
            return 0;
        }

        public int getViewVerticalDragRange(View r100) {
            return 0;
        }

        public void onEdgeDragStarted(int r100, int r101) {
        }

        public boolean onEdgeLock(int r100) {
            return false;
        }

        public void onEdgeTouched(int r100, int r101) {
        }

        public void onViewCaptured(View r100, int r101) {
        }

        public void onViewDragStateChanged(int r100) {
        }

        public void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
        }

        public void onViewReleased(View r100, float r101, float r102) {
        }

        public abstract boolean tryCaptureView(View r100, int r101);
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L6;
        r100.recycle();
        this.mVelocityTracker = null;
        return;
    }

    static {
        sInterpolator = new AnonymousClass1();
    }

    private void clearMotionHistory() {
        float[] r100 = this.mInitialMotionX;
        if (r100 != null) goto L5;
        return;
    L5:
        Arrays.fill(r100, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    public void abort() {
        cancel();
        if (this.mDragState != 2) goto L5;
        int r100 = this.mScroller.getCurrX();
        int r101 = this.mScroller.getCurrY();
        this.mScroller.abortAnimation();
        int r102 = this.mScroller.getCurrX();
        int r103 = this.mScroller.getCurrY();
        this.mCallback.onViewPositionChanged(this.mCapturedView, r102, r103, r102 - r100, r103 - r101);
    L5:
        setDragState(0);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_customview_widget_ViewDragHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void clearMotionHistory(int r100) {
        if (this.mInitialMotionX != null) goto L5;
        return;
    L5:
        if (isPointerDown(r100) == false) goto L10;
        this.mInitialMotionX[r100] = 0.0f;
        this.mInitialMotionY[r100] = 0.0f;
        this.mLastMotionX[r100] = 0.0f;
        this.mLastMotionY[r100] = 0.0f;
        this.mInitialEdgesTouched[r100] = 0;
        this.mEdgeDragsInProgress[r100] = 0;
        this.mEdgeDragsLocked[r100] = 0;
        int r101 = this.mPointersDown;
        this.mPointersDown = (~(1 << r100)) & r101;
        return;
    }

    private float distanceInfluenceForSnapDuration(float r100) {
        return (float) Math.sin((r100 - 0.5f) * 0.47123894f);
    }

    private void ensureMotionHistorySizeForId(int r110) {
        float[] r100 = this.mInitialMotionX;
        if (r100 != null) goto L5;
    L6:
        int r111 = r110 + 1;
        float[] r101 = new float[r111];
        float[] r102 = new float[r111];
        float[] r103 = new float[r111];
        float[] r104 = new float[r111];
        int[] r105 = new int[r111];
        int[] r106 = new int[r111];
        int[] r112 = new int[r111];
        if (r100 == null) goto L9;
        System.arraycopy(r100, 0, r101, 0, r100.length);
        float[] r107 = this.mInitialMotionY;
        System.arraycopy(r107, 0, r102, 0, r107.length);
        float[] r108 = this.mLastMotionX;
        System.arraycopy(r108, 0, r103, 0, r108.length);
        float[] r109 = this.mLastMotionY;
        System.arraycopy(r109, 0, r104, 0, r109.length);
        int[] r113 = this.mInitialEdgesTouched;
        System.arraycopy(r113, 0, r105, 0, r113.length);
        int[] r114 = this.mEdgeDragsInProgress;
        System.arraycopy(r114, 0, r106, 0, r114.length);
        int[] r115 = this.mEdgeDragsLocked;
        System.arraycopy(r115, 0, r112, 0, r115.length);
    L9:
        this.mInitialMotionX = r101;
        this.mInitialMotionY = r102;
        this.mLastMotionX = r103;
        this.mLastMotionY = r104;
        this.mInitialEdgesTouched = r105;
        this.mEdgeDragsInProgress = r106;
        this.mEdgeDragsLocked = r112;
        return;
    L5:
        if (r100.length <= r110) goto L6;
    }

    private boolean isValidPointerForActionMove(int r100) {
        if (isPointerDown(r100) == false) goto L5;
        return true;
    L5:
        return false;
    }

    private void saveLastMotion(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        int r103 = r100.getPointerId(r102);
        if (isValidPointerForActionMove(r103) == false) goto L8;
        float r104 = r100.getX(r102);
        float r105 = r100.getY(r102);
        this.mLastMotionX[r103] = r104;
        this.mLastMotionY[r103] = r105;
    L8:
        r102 = r102 + 1;
        goto L3
    }

    public boolean checkTouchSlop(int r100) {
        int r101 = this.mInitialMotionX.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (checkTouchSlop(r100, r102) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean continueSettling(boolean r110) {
        if (this.mDragState != 2) goto L23;
        boolean r100 = this.mScroller.computeScrollOffset();
        int r101 = this.mScroller.getCurrX();
        int r111 = this.mScroller.getCurrY();
        int r102 = r101 - this.mCapturedView.getLeft();
        int r103 = r111 - this.mCapturedView.getTop();
        if (r102 == 0) goto L7;
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r102);
    L7:
        if (r103 == 0) goto L9;
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r103);
    L9:
        if (r102 != 0) goto L11;
        if (r103 != 0) goto L11;
    L12:
        if (r100 == true) goto L14;
    L18:
        if (r100 == true) goto L23;
        if (r110 == false) goto L21;
        this.mParentView.post(this.mSetIdleRunnable);
        goto L23
    L21:
        setDragState(0);
        goto L23
    L14:
        if (r101 != this.mScroller.getFinalX()) goto L18;
        if (r111 != this.mScroller.getFinalY()) goto L18;
        this.mScroller.abortAnimation();
        r100 = false;
    L11:
        this.mCallback.onViewPositionChanged(this.mCapturedView, r101, r111, r102, r103);
    L23:
        if (this.mDragState != 2) goto L26;
        return true;
    L26:
        return false;
    }

    public boolean isEdgeTouched(int r100) {
        int r101 = this.mInitialEdgesTouched.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (isEdgeTouched(r100, r102) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isPointerDown(int r100) {
        int r101 = 1 << r100;
        if ((r101 & this.mPointersDown) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void processTouchEvent(MotionEvent r110) {
        int r100 = r110.getActionMasked();
        int r101 = r110.getActionIndex();
        if (r100 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r110);
        int r102 = 0;
        if (r100 != 0) goto L11;
        float r103 = r110.getX();
        float r104 = r110.getY();
        int r111 = r110.getPointerId(0);
        View r105 = findTopChildUnder((int) r103, (int) r104);
        saveInitialMotion(r103, r104, r111);
        tryCaptureViewForDrag(r105, r111);
        int r106 = this.mInitialEdgesTouched[r111];
        int r107 = this.mTrackingEdges;
        if ((r106 & r107) == 0) goto L102;
        this.mCallback.onEdgeTouched(r106 & r107, r111);
        return;
    L102:
        return;
    L11:
        if (r100 == 1) goto L75;
        if (r100 == 2) goto L54;
        if (r100 == 3) goto L50;
        if (r100 != 5) goto L19;
        int r108 = r110.getPointerId(r101);
        float r109 = r110.getX(r101);
        float r112 = r110.getY(r101);
        saveInitialMotion(r109, r112, r108);
        if (this.mDragState != 0) goto L47;
        tryCaptureViewForDrag(findTopChildUnder((int) r109, (int) r112), r108);
        int r113 = this.mInitialEdgesTouched[r108];
        int r114 = this.mTrackingEdges;
        if ((r113 & r114) == 0) goto L94;
        this.mCallback.onEdgeTouched(r113 & r114, r108);
        return;
    L94:
        return;
    L47:
        if (isCapturedViewUnder((int) r109, (int) r112) == false) goto L96;
        tryCaptureViewForDrag(this.mCapturedView, r108);
        return;
    L96:
        return;
    L19:
        if (r100 != 6) goto L103;
        int r115 = r110.getPointerId(r101);
        if (this.mDragState == 1) goto L24;
    L40:
        clearMotionHistory(r115);
        return;
    L24:
        if (r115 != this.mActivePointerId) goto L40;
        int r116 = r110.getPointerCount();
    L27:
        if (r102 >= r116) goto L37;
        int r117 = r110.getPointerId(r102);
        if (r117 == this.mActivePointerId) goto L36;
        float r118 = r110.getX(r102);
        View r119 = findTopChildUnder((int) r118, (int) r110.getY(r102));
        View r120 = this.mCapturedView;
        if (r119 != r120) goto L36;
        if (tryCaptureViewForDrag(r120, r117) == false) goto L36;
        int r121 = this.mActivePointerId;
    L38:
        if (r121 != (-1)) goto L40;
        releaseViewForPointerUp();
    L36:
        r102 = r102 + 1;
        goto L27
    L37:
        r121 = -1;
        goto L38
    L103:
        return;
    L50:
        if (this.mDragState != 1) goto L52;
        dispatchViewReleased(0.0f, 0.0f);
    L52:
        cancel();
        return;
    L54:
        if (this.mDragState == 1) goto L56;
        int r122 = r110.getPointerCount();
    L60:
        if (r102 >= r122) goto L73;
        int r123 = r110.getPointerId(r102);
        if (isValidPointerForActionMove(r123) == false) goto L72;
        float r124 = r110.getX(r102);
        float r125 = r110.getY(r102);
        float r126 = r124 - this.mInitialMotionX[r123];
        float r127 = r125 - this.mInitialMotionY[r123];
        reportNewEdgeDrags(r126, r127, r123);
        if (this.mDragState == 1) goto L73;
        View r128 = findTopChildUnder((int) r124, (int) r125);
        if (checkTouchSlop(r128, r126, r127) == false) goto L72;
        if (tryCaptureViewForDrag(r128, r123) == true) goto L73;
    L72:
        r102 = r102 + 1;
    L73:
        saveLastMotion(r110);
        return;
    L56:
        if (isValidPointerForActionMove(this.mActivePointerId) == false) goto L104;
        int r129 = r110.findPointerIndex(this.mActivePointerId);
        float r130 = r110.getX(r129);
        float r131 = r110.getY(r129);
        float[] r132 = this.mLastMotionX;
        int r133 = this.mActivePointerId;
        int r134 = (int) (r130 - r132[r133]);
        int r135 = (int) (r131 - this.mLastMotionY[r133]);
        dragTo(this.mCapturedView.getLeft() + r134, this.mCapturedView.getTop() + r135, r134, r135);
        saveLastMotion(r110);
        return;
    L104:
        return;
    L75:
        if (this.mDragState != 1) goto L77;
        releaseViewForPointerUp();
    L77:
        cancel();
    }

    public void setDragState(int r100) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState == r100) goto L8;
        this.mDragState = r100;
        this.mCallback.onViewDragStateChanged(r100);
        if (this.mDragState != 0) goto L9;
        this.mCapturedView = null;
        return;
    L9:
        return;
    }

    public void setEdgeSize(int r100) {
        this.mEdgeSize = r100;
    }

    public void setEdgeTrackingEnabled(int r100) {
        this.mTrackingEdges = r100;
    }

    public void setMinVelocity(float r100) {
        this.mMinVelocity = r100;
    }

    public boolean shouldInterceptTouchEvent(MotionEvent r110) {
        int r100 = r110.getActionMasked();
        int r101 = r110.getActionIndex();
        if (r100 != 0) goto L6;
        cancel();
    L6:
        if (this.mVelocityTracker != null) goto L8;
        this.mVelocityTracker = VelocityTracker.obtain();
    L8:
        this.mVelocityTracker.addMovement(r110);
        if (r100 == 0) goto L64;
        if (r100 == 1) goto L63;
        if (r100 == 2) goto L30;
        if (r100 == 3) goto L63;
        if (r100 != 5) goto L17;
        int r102 = r110.getPointerId(r101);
        float r103 = r110.getX(r101);
        float r104 = r110.getY(r101);
        saveInitialMotion(r103, r104, r102);
        int r105 = this.mDragState;
        if (r105 != 0) goto L25;
        int r106 = this.mInitialEdgesTouched[r102];
        int r107 = this.mTrackingEdges;
        if ((r106 & r107) != 0) goto L24;
    L18:
        boolean r108 = false;
    L73:
        if (this.mDragState != 1) goto L84;
        return true;
    L84:
        return r108;
    L24:
        this.mCallback.onEdgeTouched(r106 & r107, r102);
        goto L18
    L25:
        if (r105 != 2) goto L18;
        View r109 = findTopChildUnder((int) r103, (int) r104);
        if (r109 != this.mCapturedView) goto L18;
        tryCaptureViewForDrag(r109, r102);
        goto L18
    L17:
        if (r100 != 6) goto L18;
        clearMotionHistory(r110.getPointerId(r101));
        goto L18
    L30:
        if (this.mInitialMotionX == null) goto L18;
        if (this.mInitialMotionY == null) goto L18;
        int r111 = r110.getPointerCount();
        int r112 = 0;
    L35:
        if (r112 >= r111) goto L62;
        int r113 = r110.getPointerId(r112);
        if (isValidPointerForActionMove(r113) == false) goto L61;
        float r114 = r110.getX(r112);
        float r115 = r110.getY(r112);
        float r116 = r114 - this.mInitialMotionX[r113];
        float r117 = r115 - this.mInitialMotionY[r113];
        View r118 = findTopChildUnder((int) r114, (int) r115);
        if (r118 != null) goto L42;
    L44:
        boolean r119 = false;
    L45:
        if (r119 == false) goto L54;
        int r120 = r118.getLeft();
        int r121 = (int) r116;
        Callback r122 = this.mCallback;
        int r123 = r122.clampViewPositionHorizontal(r118, r120 + r121, r121);
        int r124 = r118.getTop();
        int r125 = (int) r117;
        Callback r126 = this.mCallback;
        int r127 = r126.clampViewPositionVertical(r118, r124 + r125, r125);
        int r128 = this.mCallback.getViewHorizontalDragRange(r118);
        int r129 = this.mCallback.getViewVerticalDragRange(r118);
        if (r128 == 0) goto L50;
        if (r128 <= 0) goto L54;
        if (r123 != r120) goto L54;
    L50:
        if (r129 == 0) goto L62;
        if (r129 <= 0) goto L54;
        if (r127 == r124) goto L62;
    L54:
        reportNewEdgeDrags(r116, r117, r113);
        if (this.mDragState == 1) goto L62;
        if (r119 == false) goto L61;
        if (tryCaptureViewForDrag(r118, r113) == false) goto L61;
    L42:
        if (checkTouchSlop(r118, r116, r117) == false) goto L44;
        r119 = true;
    L61:
        r112 = r112 + 1;
    L62:
        saveLastMotion(r110);
    L63:
        cancel();
        goto L18
    L64:
        float r130 = r110.getX();
        float r131 = r110.getY();
        r108 = false;
        int r132 = r110.getPointerId(0);
        saveInitialMotion(r130, r131, r132);
        View r133 = findTopChildUnder((int) r130, (int) r131);
        if (r133 == this.mCapturedView) goto L67;
    L69:
        int r134 = this.mInitialEdgesTouched[r132];
        int r135 = this.mTrackingEdges;
        if ((r134 & r135) == 0) goto L73;
        this.mCallback.onEdgeTouched(r134 & r135, r132);
        goto L73
    L67:
        if (this.mDragState != 2) goto L69;
        tryCaptureViewForDrag(r133, r132);
        goto L69
    }

    public static ViewDragHelper create(ViewGroup r100, Callback r101) {
        return new ViewDragHelper(r100.getContext(), r100, r101);
    }

    private void dispatchViewReleased(float r100, float r101) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, r100, r101);
        this.mReleaseInProgress = false;
        if (this.mDragState != 1) goto L6;
        setDragState(0);
        return;
    }

    private int getEdgesTouched(int r100, int r101) {
        if (r100 >= (this.mParentView.getLeft() + this.mEdgeSize)) goto L5;
        int r102 = 1;
    L7:
        if (r101 >= (this.mParentView.getTop() + this.mEdgeSize)) goto L10;
        r102 = r102 | 4;
    L10:
        if (r100 <= (this.mParentView.getRight() - this.mEdgeSize)) goto L13;
        r102 = r102 | 2;
    L13:
        if (r101 > (this.mParentView.getBottom() - this.mEdgeSize)) goto L15;
        return r102;
    L15:
        return r102 | 8;
    L5:
        r102 = 0;
        goto L7
    }

    public void captureChildView(View r100, int r101) {
        if (r100.getParent() != this.mParentView) goto L7;
        this.mCapturedView = r100;
        this.mActivePointerId = r101;
        this.mCallback.onViewCaptured(r100, r101);
        setDragState(1);
        return;
    L7:
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean checkTouchSlop(int r100, int r101) {
        if (isPointerDown(r101) == true) goto L6;
        return false;
    L6:
        if ((r100 & 1) != 1) goto L8;
        boolean r102 = true;
    L10:
        if ((r100 & 2) != 2) goto L12;
        boolean r103 = true;
    L13:
        float r104 = this.mLastMotionX[r101] - this.mInitialMotionX[r101];
        float r105 = this.mLastMotionY[r101] - this.mInitialMotionY[r101];
        if (r102 == false) goto L20;
        if (r103 == false) goto L20;
        float r106 = (r104 * r104) + (r105 * r105);
        int r107 = this.mTouchSlop;
        if (r106 <= (r107 * r107)) goto L30;
        return true;
    L30:
        return false;
    L20:
        if (r102 == true) goto L22;
        if (r103 == true) goto L27;
        return false;
    L27:
        if (Math.abs(r105) <= this.mTouchSlop) goto L33;
        return true;
    L33:
        return false;
    L22:
        if (Math.abs(r104) <= this.mTouchSlop) goto L31;
        return true;
    L31:
        return false;
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = false;
        goto L10
    }

    public View findTopChildUnder(int r100, int r101) {
        int r102 = this.mParentView.getChildCount() - 1;
    L3:
        if (r102 < 0) goto L14;
        View r103 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(r102));
        if (r100 < r103.getLeft()) goto L13;
        if (r100 >= r103.getRight()) goto L13;
        if (r101 < r103.getTop()) goto L13;
        if (r101 >= r103.getBottom()) goto L13;
        return r103;
    L13:
        r102 = r102 - 1;
        goto L3
    L14:
        return null;
    }

    public boolean isCapturedViewUnder(int r100, int r101) {
        return isViewUnder(this.mCapturedView, r100, r101);
    }

    public boolean isEdgeTouched(int r100, int r101) {
        if (isPointerDown(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 & this.mInitialEdgesTouched[r101]) == 0) goto L7;
        return true;
    }

    public boolean settleCapturedViewAt(int r100, int r101) {
        if (this.mReleaseInProgress == false) goto L7;
        return forceSettleCapturedViewAt(r100, r101, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
    L7:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean tryCaptureViewForDrag(View r100, int r101) {
        if (r100 == this.mCapturedView) goto L5;
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (this.mCallback.tryCaptureView(r100, r101) == false) goto L14;
        this.mActivePointerId = r101;
        captureChildView(r100, r101);
        return true;
    L14:
        return false;
    L5:
        if (this.mActivePointerId != r101) goto L7;
        return true;
    }

    private ViewDragHelper(Context r100, ViewGroup r101, Callback r102) {
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new AnonymousClass2(this);
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        this.mParentView = r101;
        this.mCallback = r102;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        int r104 = (int) ((INVOKEVIRTUAL_androidx_customview_widget_ViewDragHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = r104;
        this.mEdgeSize = r104;
        this.mTouchSlop = r103.getScaledTouchSlop();
        this.mMaxVelocity = r103.getScaledMaximumFlingVelocity();
        this.mMinVelocity = r103.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(r100, sInterpolator);
        return;
    L8:
        throw new IllegalArgumentException("Callback may not be null");
    L10:
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkTouchSlop(View r100, float r101, float r102) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.mCallback.getViewHorizontalDragRange(r100) <= 0) goto L8;
        boolean r103 = true;
    L10:
        if (this.mCallback.getViewVerticalDragRange(r100) <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r103 == false) goto L19;
        if (r104 == false) goto L19;
        float r105 = (r101 * r101) + (r102 * r102);
        int r106 = this.mTouchSlop;
        if (r105 <= (r106 * r106)) goto L29;
        return true;
    L29:
        return false;
    L19:
        if (r103 == true) goto L21;
        if (r104 == true) goto L26;
        return false;
    L26:
        if (Math.abs(r102) <= this.mTouchSlop) goto L32;
        return true;
    L32:
        return false;
    L21:
        if (Math.abs(r101) <= this.mTouchSlop) goto L30;
        return true;
    L30:
        return false;
    L12:
        r104 = false;
        goto L13
    L8:
        r103 = false;
        goto L10
    }

    private float clampMag(float r100, float r101, float r102) {
        float r103 = Math.abs(r100);
        if (r103 >= r101) goto L6;
        return 0.0f;
    L6:
        if (r103 > r102) goto L8;
        return r100;
    L8:
        if (r100 <= 0.0f) goto L11;
        return r102;
    L11:
        return -r102;
    }

    private int computeAxisDuration(int r100, int r101, int r102) {
        if (r100 != 0) goto L5;
        return 0;
    L5:
        int r103 = this.mParentView.getWidth();
        float r104 = r103 / 2;
        float r105 = r104 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(r100) / r103)) * r104);
        int r106 = Math.abs(r101);
        if (r106 <= 0) goto L8;
        int r107 = Math.round(Math.abs(r105 / r106) * 1000.0f) * 4;
    L10:
        return Math.min(r107, 600);
    L8:
        r107 = (int) (((Math.abs(r100) / r102) + 1.0f) * 256.0f);
        goto L10
    }

    public static ViewDragHelper create(ViewGroup r100, float r101, Callback r102) {
        ViewDragHelper r103 = create(r100, r102);
        r103.mTouchSlop = (int) (r103.mTouchSlop * (1.0f / r101));
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void reportNewEdgeDrags(float r100, float r101, int r102) {
        boolean r103 = checkNewEdgeDrag(r100, r101, r102, 1);
        ?? r104 = r103;
        if (checkNewEdgeDrag(r101, r100, r102, 4) == false) goto L5;
        r104 = (r103 ? 1 : 0) | 4;
    L5:
        ?? r105 = r104;
        if (checkNewEdgeDrag(r100, r101, r102, 2) == false) goto L8;
        r105 = (r104 == true ? 1 : 0) | 2;
    L8:
        ?? r106 = r105;
        if (checkNewEdgeDrag(r101, r100, r102, 8) == false) goto L11;
        r106 = (r105 == true ? 1 : 0) | 8;
    L11:
        if (r106 == 0) goto L14;
        int[] r107 = this.mEdgeDragsInProgress;
        r107[r102] = (r107[r102] | r106) == true ? 1 : 0;
        this.mCallback.onEdgeDragStarted(r106, r102);
        return;
    }

    private void saveInitialMotion(float r100, float r101, int r102) {
        ensureMotionHistorySizeForId(r102);
        float[] r103 = this.mInitialMotionX;
        this.mLastMotionX[r102] = r100;
        r103[r102] = r100;
        float[] r104 = this.mInitialMotionY;
        this.mLastMotionY[r102] = r101;
        r104[r102] = r101;
        this.mInitialEdgesTouched[r102] = getEdgesTouched((int) r100, (int) r101);
        this.mPointersDown |= 1 << r102;
    }

    public boolean isViewUnder(View r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r101 >= r100.getLeft()) goto L8;
        return false;
    L8:
        if (r101 < r100.getRight()) goto L10;
        return false;
    L10:
        if (r102 >= r100.getTop()) goto L12;
        return false;
    L12:
        if (r102 >= r100.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean smoothSlideViewTo(View r100, int r101, int r102) {
        this.mCapturedView = r100;
        this.mActivePointerId = -1;
        boolean r103 = forceSettleCapturedViewAt(r101, r102, 0, 0);
        if (r103 == false) goto L5;
    L9:
        return r103;
    L5:
        if (this.mDragState != 0) goto L9;
        if (this.mCapturedView == null) goto L9;
        this.mCapturedView = null;
        goto L9
    }

    private int clampMag(int r100, int r101, int r102) {
        int r103 = Math.abs(r100);
        if (r103 >= r101) goto L6;
        return 0;
    L6:
        if (r103 <= r102) goto L11;
        if (r100 <= 0) goto L10;
        return r102;
    L10:
        return -r102;
    L11:
        return r100;
    }

    private boolean checkNewEdgeDrag(float r100, float r101, int r102, int r103) {
        float r104 = Math.abs(r100);
        float r105 = Math.abs(r101);
        if ((this.mInitialEdgesTouched[r102] & r103) == r103) goto L5;
        return false;
    L5:
        if ((this.mTrackingEdges & r103) != 0) goto L7;
        return false;
    L7:
        if ((this.mEdgeDragsLocked[r102] & r103) != r103) goto L9;
        return false;
    L9:
        if ((this.mEdgeDragsInProgress[r102] & r103) == r103) goto L30;
        int r106 = this.mTouchSlop;
        if (r104 > r106) goto L16;
        if (r105 > r106) goto L16;
        return false;
    L16:
        if (r104 >= (r105 * 0.5f)) goto L22;
        if (this.mCallback.onEdgeLock(r103) == false) goto L22;
        int[] r107 = this.mEdgeDragsLocked;
        r107[r102] = r107[r102] | r103;
        return false;
    L22:
        if ((this.mEdgeDragsInProgress[r102] & r103) == 0) goto L24;
        return false;
    L24:
        if (r104 <= this.mTouchSlop) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    }

    private void dragTo(int r110, int r111, int r112, int r113) {
        int r100 = this.mCapturedView.getLeft();
        int r101 = this.mCapturedView.getTop();
        if (r112 == 0) goto L5;
        r110 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, r110, r112);
        ViewCompat.offsetLeftAndRight(this.mCapturedView, r110 - r100);
    L5:
        int r102 = r110;
        if (r113 == 0) goto L8;
        r111 = this.mCallback.clampViewPositionVertical(this.mCapturedView, r111, r113);
        ViewCompat.offsetTopAndBottom(this.mCapturedView, r111 - r101);
    L8:
        int r103 = r111;
        if (r112 != 0) goto L11;
        if (r113 != 0) goto L11;
        return;
    L11:
        Callback r104 = this.mCallback;
        View r105 = this.mCapturedView;
        r104.onViewPositionChanged(r105, r102, r103, r102 - r100, r103 - r101);
    }

    private boolean forceSettleCapturedViewAt(int r110, int r111, int r112, int r113) {
        int r100 = this.mCapturedView.getLeft();
        int r101 = this.mCapturedView.getTop();
        int r114 = r110 - r100;
        int r115 = r111 - r101;
        if (r114 != 0) goto L7;
        if (r115 != 0) goto L7;
        this.mScroller.abortAnimation();
        setDragState(0);
        return false;
    L7:
        int r102 = computeSettleDuration(this.mCapturedView, r114, r115, r112, r113);
        this.mScroller.startScroll(r100, r101, r114, r115, r102);
        setDragState(2);
        return true;
    }

    public void flingCapturedView(int r110, int r111, int r112, int r113) {
        if (this.mReleaseInProgress == false) goto L7;
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), r110, r112, r111, r113);
        setDragState(2);
        return;
    L7:
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    private int computeSettleDuration(View r100, int r101, int r102, int r110, int r111) {
        int r112 = clampMag(r110, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r113 = clampMag(r111, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int r103 = Math.abs(r101);
        int r104 = Math.abs(r102);
        int r105 = Math.abs(r112);
        int r106 = Math.abs(r113);
        int r107 = r105 + r106;
        int r108 = r103 + r104;
        if (r112 == 0) goto L5;
        float r109 = r105;
        float r114 = r107;
    L6:
        float r115 = r109 / r114;
        if (r113 == 0) goto L9;
        float r116 = r106;
        float r117 = r107;
    L10:
        float r118 = r116 / r117;
        return (int) ((computeAxisDuration(r101, r112, this.mCallback.getViewHorizontalDragRange(r100)) * r115) + (computeAxisDuration(r102, r113, this.mCallback.getViewVerticalDragRange(r100)) * r118));
    L9:
        r116 = r104;
        r117 = r108;
        goto L10
    L5:
        r109 = r103;
        r114 = r108;
        goto L6
    }

    public boolean canScroll(View r110, boolean r111, int r112, int r113, int r114, int r115) {
        if ((r110 instanceof ViewGroup) == false) goto L18;
        ViewGroup r100 = (ViewGroup) r110;
        int r101 = r110.getScrollX();
        int r102 = r110.getScrollY();
        int r103 = r100.getChildCount() - 1;
    L5:
        if (r103 < 0) goto L18;
        View r104 = r100.getChildAt(r103);
        int r105 = r114 + r101;
        if (r105 < r104.getLeft()) goto L17;
        if (r105 >= r104.getRight()) goto L17;
        int r106 = r115 + r102;
        if (r106 < r104.getTop()) goto L17;
        if (r106 >= r104.getBottom()) goto L17;
        if (canScroll(r104, true, r112, r113, r105 - r104.getLeft(), r106 - r104.getTop()) == false) goto L17;
        return true;
    L17:
        r103 = r103 - 1;
    L18:
        if (r111 == true) goto L20;
    L24:
        return false;
    L20:
        if (r110.canScrollHorizontally(-r112) == false) goto L22;
        return true;
    L22:
        if (r110.canScrollVertically(-r113) == false) goto L24;
        return true;
    }
}
