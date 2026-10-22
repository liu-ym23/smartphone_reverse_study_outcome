package com.bytedanceos.common.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.view.RecyclerviewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(3)
public class SwipeRecyclerView extends RecyclerviewCompat {
    private static final int GESTURE_DOWN = 0;
    private static final int GESTURE_FLING_ON_ITEM = 5;
    private static final int GESTURE_FLING_ON_LIST = 6;
    private static final int GESTURE_LONGPRESS = 4;
    private static final int GESTURE_NONE = -1;
    private static final int GESTURE_SCROLL_ON_ITEM = 2;
    private static final int GESTURE_SCROLL_ON_LIST = 3;
    private static final int GESTURE_TAP = 1;
    private final int MISS;
    private final int SELECT;
    private final int SPECIAL;
    SwipeItemView canceledTarget;
    private int mCheckboxId;
    private View mChildUnderGesture;
    private int mEndX;
    private SwipeItemView mFocusChildView;
    private int mGesture;
    private GestureDetector mGestureDetector;
    private boolean mGestureIntercepted;
    private boolean mGestureOnOpenedChild;
    private boolean mGestureScrollingChild;
    private List<Integer> mIgnoreSecondaryPointers;
    private boolean mInterruptionGesture;
    private boolean mIsFrozen;
    private boolean mIsSwipeAble;
    private Listener mListener;
    private Rect mRect;
    private int mStartX;
    private int mState;
    private int[] mTempLoc;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.widget.SwipeRecyclerView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface Listener {
        boolean isChecked(int r10);

        void setChecked(int r10, boolean r11);
    }

    public class SwipeGestureListener implements GestureDetector.OnGestureListener {
        final /* synthetic */ SwipeRecyclerView this$0;

        private SwipeGestureListener(SwipeRecyclerView r10) {
            this.this$0 = r10;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r10) {
            SwipeRecyclerView.access$102(this.this$0, 0);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            if (SwipeRecyclerView.isItemScroll(r12, r13) == false) goto L5;
            SwipeRecyclerView.access$102(this.this$0, 5);
            return false;
        L5:
            SwipeRecyclerView.access$102(this.this$0, 6);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r10) {
            SwipeRecyclerView.access$102(this.this$0, 4);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            if (SwipeRecyclerView.access$100(this.this$0) != 2) goto L5;
            return false;
        L5:
            if (SwipeRecyclerView.access$100(this.this$0) != 3) goto L7;
            return false;
        L7:
            if (SwipeRecyclerView.isItemScroll(-r12, -r13) == false) goto L9;
            SwipeRecyclerView.access$102(this.this$0, 2);
            return false;
        L9:
            SwipeRecyclerView.access$102(this.this$0, 3);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent r10) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r10) {
            SwipeRecyclerView.access$102(this.this$0, 1);
            return false;
        }

        public /* synthetic */ SwipeGestureListener(SwipeRecyclerView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public SwipeRecyclerView(Context r10) {
        super(r10);
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mIgnoreSecondaryPointers = new ArrayList();
        this.mTempLoc = new int[2];
        this.mRect = new Rect();
        this.mState = -1;
        this.mGesture = -1;
        this.mIsSwipeAble = true;
        init(r10);
    }

    public static /* synthetic */ int access$100(SwipeRecyclerView r10) {
        return r10.mGesture;
    }

    public static /* synthetic */ int access$102(SwipeRecyclerView r10, int r11) {
        r10.mGesture = r11;
        return r11;
    }

    private View getChildUnderMotion(MotionEvent r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = getChildAt(r12);
        if (isChildUnderMotion(r13, r10) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    private SwipeItemView getOpenedChild() {
        int r10 = getChildCount();
        SwipeItemView r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        View r13 = getChildAt(r12);
        if ((r13 instanceof SwipeItemView) == false) goto L9;
        SwipeItemView r14 = (SwipeItemView) r13;
        if (r14.isLeftOpen() == false) goto L9;
        r11 = r14;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r11;
    }

    private void init(Context r10) {
        this.mCheckboxId = R$id.checkBoxFrame;
        GestureDetector r11 = new GestureDetector(r10, new SwipeGestureListener(this, null));
        this.mGestureDetector = r11;
        r11.setIsLongpressEnabled(false);
    }

    private boolean isChildUnderMotion(View r10, MotionEvent r11) {
        int r12 = r11.getActionIndex();
        int r13 = Math.round(r11.getX(r12));
        int r14 = Math.round(r11.getY(r12));
        r10.getHitRect(this.mRect);
        return this.mRect.contains(r13, r14);
    }

    public static boolean isItemScroll(float r10, float r11) {
        float r12 = -r11;
        if (r10 >= 0.0f) goto L5;
        return false;
    L5:
        double r13 = r12 / r10;
        if (r13 < 0.8d) goto L8;
        return false;
    L8:
        if (r13 <= (-0.8d)) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean onInterceptTouchEventInner(MotionEvent r10) {
        this.mGestureDetector.onTouchEvent(r10);
        SwipeItemView r11 = getOpenedChild();
        if (this.mGesture != 0) goto L12;
        this.mGestureOnOpenedChild = false;
        this.mGestureScrollingChild = false;
        if (r11 == null) goto L12;
        if (r11.isClosed() == true) goto L12;
        r11.getHitRect(this.mRect);
        if (this.mRect.contains((int) r10.getX(), (int) r10.getY()) == false) goto L12;
        this.mGestureOnOpenedChild = true;
    L12:
        if (this.mGestureOnOpenedChild == false) goto L14;
    L28:
        return false;
    L14:
        if (this.mGestureScrollingChild == true) goto L28;
        int r12 = this.mGesture;
        if (r12 != 2) goto L19;
    L27:
        this.mGestureScrollingChild = true;
        goto L28
    L19:
        if (r12 == 5) goto L27;
        if (super.onInterceptTouchEvent(r10) == false) goto L26;
        if (r11 == null) goto L25;
        r11.closeAutonomously();
    L25:
        return true;
    L26:
        return false;
    }

    private int startForgroundPosition(MotionEvent r10) {
        return viewIdHitPosition(r10, R$id.forground_layout);
    }

    private int viewIdHitPosition(MotionEvent r10, int r11) {
        View r12 = findChildViewUnder((int) r10.getX(), (int) r10.getY());
        int r13 = getChildAdapterPosition(r12);
        getChildCount();
        int r14 = (int) r10.getRawX();
        int r15 = (int) r10.getRawY();
        if (r11 == 0) goto L6;
        if (r12 == null) goto L6;
        View r16 = r12.findViewById(r11);
    L8:
        if (r16 != null) goto L10;
    L28:
        if (r16 == null) goto L30;
        return -1;
    L30:
        if (this.mState == 1) goto L32;
        return -1;
    L32:
        if (r14 > this.mStartX) goto L34;
        return -1;
    L34:
        if (r14 >= this.mEndX) goto L45;
        return -2;
    L45:
        return -1;
    L10:
        if (r16.getVisibility() != 0) goto L28;
        if (this.mState == 1) goto L14;
    L18:
        r16.getLocationOnScreen(this.mTempLoc);
        int[] r17 = this.mTempLoc;
        int r18 = r17[0];
        if (r14 > r18) goto L21;
        return -1;
    L21:
        if (r15 > r17[1]) goto L23;
        return -1;
    L23:
        if (r14 < (r18 + r16.getWidth())) goto L25;
        return -1;
    L25:
        if (r15 >= (this.mTempLoc[1] + r16.getHeight())) goto L41;
        int r19 = this.mTempLoc[0];
        this.mStartX = r19;
        this.mEndX = r19 + r16.getWidth();
        return r13;
    L41:
        return -1;
    L14:
        if (r14 <= this.mStartX) goto L18;
        if (r14 >= this.mEndX) goto L18;
        return r13;
    L6:
        r16 = null;
        goto L8
    }

    public void active() {
        this.mIsFrozen = false;
    }

    public void closeSwipedItems(boolean r10) {
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        View r13 = getChildAt(r12);
        if ((r13 instanceof SwipeItemView) == false) goto L11;
        SwipeItemView r14 = (SwipeItemView) r13;
        if (r14.isLeftOpen() == false) goto L11;
        if (r10 == false) goto L10;
        r14.closeAutonomously();
        goto L11
    L10:
        r14.forceClose();
    L11:
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (this.mIsSwipeAble == false) goto L5;
        SwipeItemView r11 = this.canceledTarget;
        if (r11 != null) goto L9;
    L12:
        this.canceledTarget = null;
        int r12 = r10.getActionMasked();
        int r13 = r10.getPointerId(r10.getActionIndex());
        if (r12 != 0) goto L15;
        this.mInterruptionGesture = false;
        SwipeItemView r14 = getOpenedChild();
        if (r14 == null) goto L38;
        if (r14.isClosed() == true) goto L38;
        r14.getHitRect(this.mRect);
        if (isChildUnderMotion(r14, r10) == true) goto L34;
        r14.closeAutonomously();
        this.mInterruptionGesture = true;
        return true;
    L34:
        if (this.mIsFrozen == false) goto L45;
        this.mInterruptionGesture = true;
        return true;
    L45:
        if (r14 != null) goto L54;
        SwipeItemView r15 = this.mFocusChildView;
        if (r15 == null) goto L54;
        if (r15.isClosed() == true) goto L54;
        if (isChildUnderMotion(this.mFocusChildView, r10) == true) goto L54;
        this.mFocusChildView.closeAutonomously();
        this.mFocusChildView = null;
        this.mInterruptionGesture = true;
        return true;
    L54:
        this.mIgnoreSecondaryPointers.clear();
        this.mChildUnderGesture = getChildUnderMotion(r10);
    L56:
        if (this.mInterruptionGesture == false) goto L58;
    L62:
        return true;
    L58:
        if (this.mIgnoreSecondaryPointers.contains(Integer.valueOf(r13)) == true) goto L62;
        return super.dispatchTouchEvent(r10);
    L38:
        if (this.mIsFrozen == false) goto L42;
        this.mInterruptionGesture = true;
        return true;
    L42:
        if (isSomeItemSwiped() == false) goto L45;
        closeSwipedItems(true);
        this.mInterruptionGesture = true;
        return true;
    L15:
        if (r12 != 5) goto L56;
        if (this.mGestureIntercepted == true) goto L23;
        if (this.mChildUnderGesture == getChildUnderMotion(r10)) goto L23;
        this.mIgnoreSecondaryPointers.add(Integer.valueOf(r13));
    L23:
        if (this.mIgnoreSecondaryPointers.size() <= 0) goto L56;
        this.mIgnoreSecondaryPointers.clear();
        goto L56
    L9:
        if (r11 != getOpenedChild()) goto L12;
        return this.canceledTarget.dispatchTouchEvent(r10);
    L5:
        return super.dispatchTouchEvent(r10);
    }

    public void freeze() {
        this.mIsFrozen = true;
    }

    public boolean isSomeItemSwiped() {
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        View r12 = getChildAt(r11);
        if ((r12 instanceof SwipeItemView) == false) goto L10;
        if (((SwipeItemView) r12).isLeftOpen() == false) goto L10;
        return true;
    L10:
        r11 = r11 + 1;
        goto L3
    L11:
        return false;
    }

    public boolean isSwipeAble() {
        return this.mIsSwipeAble;
    }

    @Override // com.bytedanceos.common.view.RecyclerviewCompat, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mIsSwipeAble == true) goto L19;
        int r11 = viewIdHitPosition(r10, this.mCheckboxId);
        int r12 = r10.getActionMasked();
        if (r11 <= (-1)) goto L10;
        if (r12 != 0) goto L10;
        this.mGestureIntercepted = true;
        Listener r13 = this.mListener;
        if (r13 == null) goto L21;
        r13.setChecked(r11, !r13.isChecked(r11));
    L21:
        return this.mGestureIntercepted;
    L10:
        if (r12 == 1) goto L12;
    L18:
        this.mGestureIntercepted = super.onInterceptTouchEvent(r10);
        goto L21
    L12:
        if (this.mListener == null) goto L18;
        int r14 = startForgroundPosition(r10);
        if (r14 <= (-1)) goto L18;
        Listener r15 = this.mListener;
        if (r15 == null) goto L18;
        r15.setChecked(r14, !r15.isChecked(r14));
        goto L18
    L19:
        this.mGestureIntercepted = onInterceptTouchEventInner(r10);
        goto L21
    }

    public void onSubItemViewEvent(SwipeItemView r10) {
        SwipeItemView r11 = this.mFocusChildView;
        if (r11 == r10) goto L5;
        return;
    L5:
        if (r11.isClosed() == true) goto L7;
        this.mFocusChildView.closeAutonomously();
    L7:
        this.mFocusChildView = null;
    }

    @Override // com.bytedanceos.common.view.RecyclerviewCompat, androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        return super.onTouchEvent(r10);
    }

    public void setFocusChild(SwipeItemView r10) {
        this.mFocusChildView = r10;
    }

    public void setSlideListener(Listener r10) {
        this.mListener = r10;
    }

    public void setSwipeAble(boolean r10) {
        this.mIsSwipeAble = r10;
    }

    public SwipeRecyclerView(Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mIgnoreSecondaryPointers = new ArrayList();
        this.mTempLoc = new int[2];
        this.mRect = new Rect();
        this.mState = -1;
        this.mGesture = -1;
        this.mIsSwipeAble = true;
        init(r10);
    }

    public SwipeRecyclerView(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mIgnoreSecondaryPointers = new ArrayList();
        this.mTempLoc = new int[2];
        this.mRect = new Rect();
        this.mState = -1;
        this.mGesture = -1;
        this.mIsSwipeAble = true;
        init(r10);
    }
}
