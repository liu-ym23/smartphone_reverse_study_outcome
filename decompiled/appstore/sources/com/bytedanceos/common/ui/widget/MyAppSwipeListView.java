package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.common.R$id;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppSwipeListView extends ListView implements AbsListView.OnScrollListener {
    private static final int GESTURE_DOWN = 0;
    private static final int GESTURE_FLING_ON_ITEM = 5;
    private static final int GESTURE_FLING_ON_LIST = 6;
    private static final int GESTURE_LONGPRESS = 4;
    private static final int GESTURE_NONE = -1;
    private static final int GESTURE_SCROLL_ON_ITEM = 2;
    private static final int GESTURE_SCROLL_ON_LIST = 3;
    private static final int GESTURE_TAP = 1;
    private final int DEFAULT_PRE_POSITION;
    private final int MISS;
    private final int SELECT;
    private final int SPECIAL;
    private final float SPEED_CARDINAL;
    MyAppSwipeItemView canceledTarget;
    private int mCheckboxId;
    private View mChildUnderGesture;
    private Context mContext;
    private Point mCurrPoint;
    private Point mDownPoint;
    private float mDownScrollStartY;
    private int mEndX;
    private MyAppSwipeItemView mFocusChildView;
    private int mGesture;
    private GestureDetector mGestureDetector;
    private boolean mGestureIntercepted;
    private boolean mGestureOnOpenedChild;
    private boolean mGestureScrollingChild;
    private List<Integer> mIgnoreSecondaryPointers;
    private boolean mInterruptionGesture;
    private boolean mIsChecked;
    private boolean mIsFrozen;
    private boolean mIsSwipeAble;
    private Listener mListener;
    private PowerManager mPowerManager;
    private long mPrePokeTime;
    private int mPrePosition;
    private Rect mRect;
    private AbsListView.OnScrollListener mScrollListener;
    private SelectScroller mScroller;
    private float mSelectDownScrollStartFrac;
    private float mSelectUpScrollStartFrac;
    private int mStartX;
    private int mState;
    private int[] mTempLoc;
    private float mUpScrollStartY;

    public interface Listener {
        boolean isChecked(int r10);

        void setChecked(int r10, boolean r11);
    }

    public final class SelectScroller implements Runnable {
        public static final int DOWN = 2;
        public static final int UP = 1;
        private boolean mAbort;
        private long mCurrTime;
        private long mPrevTime;
        private int mScrollDir;
        private float mScrollSpeed;
        private boolean mScrolling;
        final /* synthetic */ MyAppSwipeListView this$0;

        private SelectScroller(MyAppSwipeListView r10) {
            this.this$0 = r10;
            this.mScrolling = false;
        }

        private void performSelectAction() {
            if (MyAppSwipeListView.access$200(this.this$0).y >= this.this$0.getPaddingTop()) goto L7;
            MyAppSwipeListView r10 = this.this$0;
            MyAppSwipeListView.access$500(r10, r10.getFirstVisiblePosition());
            return;
        L7:
            if (MyAppSwipeListView.access$200(this.this$0).y <= (this.this$0.getHeight() - this.this$0.getPaddingBottom())) goto L10;
            MyAppSwipeListView r11 = this.this$0;
            MyAppSwipeListView.access$500(r11, r11.getLastVisiblePosition());
            return;
        L10:
            MyAppSwipeListView r12 = this.this$0;
            int r13 = r12.pointToPosition(MyAppSwipeListView.access$200(r12).x, MyAppSwipeListView.access$200(this.this$0).y);
            MyAppSwipeListView r14 = this.this$0;
            View r15 = r14.getChildAt(r13 - r14.getFirstVisiblePosition());
            if (r15 != null) goto L13;
            return;
        L13:
            if (r15.findViewById(MyAppSwipeListView.access$600(this.this$0)) == null) goto L17;
            MyAppSwipeListView.access$500(this.this$0, r13);
            return;
        }

        public boolean isScrolling() {
            return this.mScrolling;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAbort == false) goto L5;
            return;
        L5:
            int r10 = this.this$0.getFirstVisiblePosition();
            int r11 = this.this$0.getLastVisiblePosition();
            int r12 = this.this$0.getCount();
            int r13 = this.this$0.getPaddingTop();
            int r14 = (this.this$0.getHeight() - r13) - this.this$0.getPaddingBottom();
            performSelectAction();
            if (this.mScrollDir != 1) goto L20;
            View r15 = this.this$0.getChildAt(0);
            if (r15 == null) goto L18;
            if (r10 != 0) goto L14;
            if (r15.getTop() == r13) goto L18;
        L14:
            if (MyAppSwipeListView.access$200(this.this$0).y < r13) goto L17;
            r13 = MyAppSwipeListView.access$200(this.this$0).y;
        L17:
            this.mScrollSpeed = (r13 - MyAppSwipeListView.access$300(this.this$0)) * 0.01f;
        L32:
            long r16 = SystemClock.uptimeMillis();
            this.mCurrTime = r16;
            float r17 = r16 - this.mPrevTime;
            this.this$0.smoothScrollBy(Math.round(this.mScrollSpeed * r17) / 2, (int) r17);
            this.this$0.invalidate();
            this.mPrevTime = this.mCurrTime;
            this.this$0.post(this);
            return;
        L18:
            this.mScrolling = false;
            return;
        L20:
            View r18 = this.this$0.getChildAt(r11 - r10);
            if (r18 != null) goto L23;
        L34:
            this.mScrolling = false;
            return;
        L23:
            if (r11 == (r12 - 1)) goto L25;
        L27:
            int r19 = this.this$0.getHeight() - this.this$0.getPaddingBottom();
            if (MyAppSwipeListView.access$200(this.this$0).y > r19) goto L31;
            r19 = MyAppSwipeListView.access$200(this.this$0).y;
        L31:
            this.mScrollSpeed = (r19 - MyAppSwipeListView.access$400(this.this$0)) * 0.01f;
            goto L32
        L25:
            if (r18.getBottom() > (r14 + r13)) goto L27;
            goto L27
        }

        public void startScroll(int r10) {
            if (this.mScrolling == true) goto L6;
            this.mScrolling = true;
            this.mAbort = false;
            this.mScrollDir = r10;
            this.mPrevTime = SystemClock.uptimeMillis();
            this.this$0.post(this);
            return;
        }

        public void stopScroll() {
            this.this$0.removeCallbacks(this);
            this.mScrolling = false;
        }

        public /* synthetic */ SelectScroller(MyAppSwipeListView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public MyAppSwipeListView(Context r10) {
        super(r10);
        this.mGesture = -1;
        this.mIsChecked = false;
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.mTempLoc = new int[2];
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        this.DEFAULT_PRE_POSITION = -2;
        this.SPEED_CARDINAL = 0.01f;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.mIgnoreSecondaryPointers = new ArrayList();
        init(r10);
    }

    public static /* synthetic */ int access$000(MyAppSwipeListView r10) {
        return r10.mGesture;
    }

    public static /* synthetic */ int access$002(MyAppSwipeListView r10, int r11) {
        r10.mGesture = r11;
        return r11;
    }

    public static /* synthetic */ Point access$200(MyAppSwipeListView r10) {
        return r10.mCurrPoint;
    }

    public static /* synthetic */ float access$300(MyAppSwipeListView r10) {
        return r10.mUpScrollStartY;
    }

    public static /* synthetic */ float access$400(MyAppSwipeListView r10) {
        return r10.mDownScrollStartY;
    }

    public static /* synthetic */ void access$500(MyAppSwipeListView r10, int r11) {
        r10.onMoving(r11);
    }

    public static /* synthetic */ int access$600(MyAppSwipeListView r10) {
        return r10.mCheckboxId;
    }

    private void continueSelect(int r10, int r11, int r12) {
        int r13 = r11 - this.mDownPoint.y;
        float r14 = r11;
        float r15 = this.mDownScrollStartY;
        if (r14 <= r15) goto L6;
        if (r13 <= 0) goto L6;
        this.mScroller.startScroll(2);
    L15:
        onMoving(r12);
        return;
    L6:
        float r16 = this.mUpScrollStartY;
        if (r14 >= r16) goto L11;
        if (r13 >= 0) goto L11;
        this.mScroller.startScroll(1);
    L11:
        if (r14 <= r16) goto L15;
        if (r14 >= r15) goto L15;
        this.mScroller.stopScroll();
        goto L15
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

    private MyAppSwipeItemView getOpenedChild() {
        int r10 = getChildCount();
        MyAppSwipeItemView r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        View r13 = getChildAt(r12);
        if ((r13 instanceof MyAppSwipeItemView) == false) goto L9;
        MyAppSwipeItemView r14 = (MyAppSwipeItemView) r13;
        if (r14.isLeftOpen() == false) goto L9;
        r11 = r14;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r11;
    }

    private void init(Context r10) {
        this.mContext = r10;
        this.mRect = new Rect();
        this.mIsSwipeAble = true;
        setChoiceMode(1);
        setLongClickable(true);
        super.setOnScrollListener(this);
        this.mCheckboxId = R$id.checkBoxFrame;
        GestureDetector r11 = new GestureDetector(r10, new AnonymousClass1(this));
        this.mGestureDetector = r11;
        r11.setIsLongpressEnabled(false);
        this.mScroller = new SelectScroller(this, null);
        this.mPowerManager = (PowerManager) r10.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    private void initScrollData() {
        int r10 = getPaddingTop();
        float r11 = (getHeight() - r10) - getPaddingBottom();
        float r12 = r10;
        this.mUpScrollStartY = (this.mSelectUpScrollStartFrac * r11) + r12;
        this.mDownScrollStartY = r12 + ((1.0f - this.mSelectDownScrollStartFrac) * r11);
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

    private void onDown(int r10) {
        Listener r11 = this.mListener;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 > (-1)) goto L7;
        return;
    L7:
        if (this.mPrePosition == r10) goto L13;
        this.mState = 1;
        this.mIsChecked = r11.isChecked(r10);
        onMoving(r10);
        return;
    }

    private boolean onInterceptTouchEventInner(MotionEvent r10) {
        this.mGestureDetector.onTouchEvent(r10);
        MyAppSwipeItemView r11 = getOpenedChild();
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

    private void onMoving(int r10) {
        Listener r11 = this.mListener;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 <= (-1)) goto L42;
        int r12 = this.mPrePosition;
        if (r12 != r10) goto L10;
        return;
    L10:
        if (this.mState == 1) goto L12;
    L31:
        pokeActivity();
        this.mPrePosition = r10;
        return;
    L12:
        if (r12 != (-2)) goto L14;
        r11.setChecked(r10, !this.mIsChecked);
        goto L31
    L14:
        if (r12 <= r10) goto L23;
        int r13 = r12 - 1;
    L16:
        if (r13 < r10) goto L31;
        if (r13 < getFirstVisiblePosition()) goto L22;
        if (r13 > getLastVisiblePosition()) goto L22;
        this.mListener.setChecked(r13, !this.mIsChecked);
    L22:
        r13 = r13 - 1;
        goto L16
    L23:
        int r14 = r12 + 1;
    L24:
        if (r14 > r10) goto L31;
        if (r14 < getFirstVisiblePosition()) goto L30;
        if (r14 > getLastVisiblePosition()) goto L30;
        this.mListener.setChecked(r14, !this.mIsChecked);
    L30:
        r14 = r14 + 1;
        goto L24
    }

    private void pokeActivity() {
        long r10 = SystemClock.uptimeMillis();
        if ((r10 - this.mPrePokeTime) <= 12000) goto L6;
        this.mPowerManager.userActivity(r10, true);
        this.mPrePokeTime = r10;
        return;
    }

    private void recovery() {
        if (this.mState != (-1)) goto L5;
        return;
    L5:
        SelectScroller r10 = this.mScroller;
        if (r10 != null) goto L8;
    L10:
        this.mIsChecked = false;
        this.mState = -1;
        this.mPrePosition = -2;
        this.mStartX = 0;
        this.mEndX = 0;
        return;
    L8:
        if (r10.isScrolling() == false) goto L10;
        this.mScroller.stopScroll();
        goto L10
    }

    private int startForgroundPosition(MotionEvent r10) {
        return viewIdHitPosition(r10, R$id.forground_layout);
    }

    private int viewIdHitPosition(MotionEvent r10, int r11) {
        int r12 = pointToPosition((int) r10.getX(), (int) r10.getY());
        int r13 = getHeaderViewsCount();
        int r14 = getFooterViewsCount();
        int r15 = getCount();
        if (r12 == (-1)) goto L41;
        if (r12 < r13) goto L41;
        if (r12 >= (r15 - r14)) goto L41;
        int r16 = (int) r10.getRawX();
        int r17 = (int) r10.getRawY();
        View r18 = getChildAt(r12 - getFirstVisiblePosition());
        if (r11 != 0) goto L10;
        View r19 = null;
    L12:
        if (r19 != null) goto L14;
    L32:
        if (r19 != null) goto L41;
        if (this.mState != 1) goto L41;
        if (r16 <= this.mStartX) goto L41;
        if (r16 >= this.mEndX) goto L41;
        return -2;
    L14:
        if (r19.getVisibility() != 0) goto L32;
        if (this.mState == 1) goto L18;
    L22:
        r19.getLocationOnScreen(this.mTempLoc);
        int[] r20 = this.mTempLoc;
        int r21 = r20[0];
        if (r16 <= r21) goto L41;
        if (r17 <= r20[1]) goto L41;
        if (r16 >= (r21 + r19.getWidth())) goto L41;
        if (r17 >= (this.mTempLoc[1] + r19.getHeight())) goto L41;
        int r22 = this.mTempLoc[0];
        this.mStartX = r22;
        this.mEndX = r22 + r19.getWidth();
        return r12;
    L18:
        if (r16 <= this.mStartX) goto L22;
        if (r16 >= this.mEndX) goto L22;
        return r12;
    L10:
        r19 = r18.findViewById(r11);
    L41:
        return -1;
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
        if ((r13 instanceof MyAppSwipeItemView) == false) goto L11;
        MyAppSwipeItemView r14 = (MyAppSwipeItemView) r13;
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
        MyAppSwipeItemView r11 = this.canceledTarget;
        if (r11 != null) goto L9;
    L12:
        this.canceledTarget = null;
        int r12 = r10.getActionMasked();
        int r13 = r10.getPointerId(r10.getActionIndex());
        if (r12 != 0) goto L15;
        this.mInterruptionGesture = false;
        MyAppSwipeItemView r14 = getOpenedChild();
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
        MyAppSwipeItemView r15 = this.mFocusChildView;
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
        if ((r12 instanceof MyAppSwipeItemView) == false) goto L10;
        if (((MyAppSwipeItemView) r12).isLeftOpen() == false) goto L10;
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

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        MyAppSwipeItemView r10 = getOpenedChild();
        if (r10 == null) goto L5;
        r10.setInListViewLayout(true);
    L5:
        super.layoutChildren();
        if (r10 == null) goto L9;
        r10.setInListViewLayout(false);
        return;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mIsSwipeAble == true) goto L15;
        int r11 = viewIdHitPosition(r10, this.mCheckboxId);
        int r12 = r10.getActionMasked();
        if (r11 <= (-1)) goto L8;
        if (r12 != 0) goto L8;
        this.mGestureIntercepted = true;
    L17:
        return this.mGestureIntercepted;
    L8:
        if (r12 == 1) goto L10;
    L14:
        this.mGestureIntercepted = super.onInterceptTouchEvent(r10);
        goto L17
    L10:
        if (this.mListener == null) goto L14;
        int r13 = startForgroundPosition(r10);
        if (r13 <= (-1)) goto L14;
        Listener r14 = this.mListener;
        r14.setChecked(r13, !r14.isChecked(r13));
        goto L14
    L15:
        this.mGestureIntercepted = onInterceptTouchEventInner(r10);
        goto L17
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (r10 != 22) goto L6;
        sendAccessibilityEvent(128);
    L17:
        return super.onKeyDown(r10, r11);
    L6:
        if (r10 != 4) goto L17;
        if (this.mIsFrozen == false) goto L10;
        return true;
    L10:
        MyAppSwipeItemView r12 = this.mFocusChildView;
        if (r12 == null) goto L17;
        if (r12.isClosed() == true) goto L17;
        this.mFocusChildView.closeAutonomously();
        this.mFocusChildView = null;
        return true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r10, int r11, int r12, int r13) {
        AbsListView.OnScrollListener r14 = this.mScrollListener;
        if (r14 == null) goto L6;
        r14.onScroll(r10, r11, r12, r13);
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r10, int r11) {
        if (r11 != 2) goto L5;
    L6:
        closeSwipedItems(false);
    L7:
        AbsListView.OnScrollListener r12 = this.mScrollListener;
        if (r12 == null) goto L11;
        r12.onScrollStateChanged(r10, r11);
        return;
    L11:
        return;
    L5:
        if (r11 != 1) goto L7;
        goto L6
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        initScrollData();
    }

    public void onSubItemViewEvent(int r10, MyAppSwipeItemView r11) {
        if (r10 == 0) goto L10;
        MyAppSwipeItemView r12 = this.mFocusChildView;
        if (r12 == r11) goto L6;
        return;
    L6:
        if (r12.isClosed() == true) goto L8;
        this.mFocusChildView.closeAutonomously();
    L8:
        this.mFocusChildView = null;
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mIsSwipeAble == true) goto L41;
        int r11 = viewIdHitPosition(r10, this.mCheckboxId);
        int r12 = (int) r10.getX();
        int r13 = (int) r10.getY();
        this.mCurrPoint.set(r12, r13);
        int r14 = r10.getActionMasked();
        if (r14 == 0) goto L32;
        if (r14 != 1) goto L8;
    L31:
        recovery();
        goto L41
    L8:
        if (r14 != 2) goto L10;
        if (r11 == (-2)) goto L18;
        if (r11 == (-1)) goto L15;
    L17:
        boolean r15 = false;
    L19:
        int r16 = this.mState;
        if (r16 == 1) goto L24;
        if (r15 == true) goto L24;
        onDown(r11);
        return true;
    L24:
        if (r16 != 1) goto L27;
        if (r11 != (-2)) goto L27;
        return true;
    L27:
        if (r15 == true) goto L41;
        continueSelect(r12, r13, r11);
        return true;
    L15:
        if (this.mState != (-1)) goto L17;
    L18:
        r15 = true;
        goto L19
    L10:
        if (r14 == 3) goto L31;
    L32:
        this.mPrePosition = -2;
        this.mDownPoint.set(r12, r13);
        if (r11 == (-2)) goto L41;
        if (r11 == (-1)) goto L36;
    L38:
        onDown(r11);
        return true;
    L36:
        if (this.mState != (-1)) goto L38;
    L41:
        return super.onTouchEvent(r10);
    }

    public void setFocusChild(MyAppSwipeItemView r10) {
        this.mFocusChildView = r10;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener r10) {
        super.setOnItemClickListener(r10);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r10) {
        this.mScrollListener = r10;
    }

    public void setSlideListener(Listener r10) {
        this.mListener = r10;
    }

    public void setSwipeAble(boolean r10) {
        this.mIsSwipeAble = r10;
    }

    public MyAppSwipeListView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mGesture = -1;
        this.mIsChecked = false;
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.mTempLoc = new int[2];
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        this.DEFAULT_PRE_POSITION = -2;
        this.SPEED_CARDINAL = 0.01f;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.mIgnoreSecondaryPointers = new ArrayList();
        init(r10);
    }

    public MyAppSwipeListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mGesture = -1;
        this.mIsChecked = false;
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.mTempLoc = new int[2];
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        this.DEFAULT_PRE_POSITION = -2;
        this.SPEED_CARDINAL = 0.01f;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.mIgnoreSecondaryPointers = new ArrayList();
        init(r10);
    }
}
