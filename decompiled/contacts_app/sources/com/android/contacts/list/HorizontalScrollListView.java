package com.android.contacts.list;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.Scroller;
import com.GlobalProxyLancet;
import com.android.contacts.PinnedHeaderList.WrapperView;
import com.android.contacts.R;
import com.obric.oui.bouncelayout.OListView;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalScrollListView extends OListView implements GestureDetector.OnGestureListener {
    private static int COMPLETE_SCROLL_DURATION = 200;
    private static boolean DEBUG_SCROLL = false;
    private static int DEL_ANIMATION_DURATION = 200;
    public static final int IDLE = 0;
    private static final int MISS = -1;
    private static int RESTORE_SCROLL_DURATION = 150;
    public static final int SCROLLED_LEFT = 4;
    public static final int SCROLLED_RIGHT = 3;
    public static final int SCROLLING_LEFT = 2;
    public static final int SCROLLING_RIGHT = 1;
    public static final int SCROLL_MODE_BOTH = 2;
    public static final int SCROLL_MODE_LEFT = 1;
    public static final int SCROLL_MODE_RIGHT = 0;
    private static String TAG = "HorizontalScrollListView";
    private boolean mAutoClose;
    private MotionEvent mCancelEvent;
    private int mClickScrollHitPos;
    private GestureDetector mDetector;
    private int mDownX;
    private int mDownY;
    private View mHintView;
    private boolean mIntercept;
    private boolean mIsAnimating;
    private boolean mIsScrollRunning;
    private ItemLongClickedListener mItemLongClickedListener;
    private int mJustClickedPos;
    private View.OnClickListener mLeftBtnsClickListener;
    private int mLeftBtnsId;
    private int mLeftBtnsWidth;
    private int mMaxLeftBtnsWidth;
    private int mMaxRightBtnsWidth;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private ScrollStateListener mOnScrollStateListener;
    private float mOverflowVelocityFactor;
    private BroadcastReceiver mReceiver;
    private boolean mRestoreEatBackKey;
    private View.OnClickListener mRightBtnsClickListener;
    private int mRightBtnsId;
    private int mRightBtnsWidth;
    private boolean mScrollEnabled;
    private float mScrollFactor;
    private int mScrollHandleId;
    private int mScrollMode;
    private ScrollRunner mScrollRunner;
    private int mScrollState;
    private Scroller mScroller;
    private int mTouchSlop;
    private float mVelocityFactor;

    public interface ItemLongClickedListener {
        boolean itemLongClicked(AdapterView<?> r1, View r2, int r3, long r4, int r6, int r7);
    }

    private class ScrollRunner implements Runnable {
        final /* synthetic */ HorizontalScrollListView this$0;

        private ScrollRunner(HorizontalScrollListView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ScrollRunner(HorizontalScrollListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r0 = HorizontalScrollListView.access$000(this.this$0).computeScrollOffset();
            if (this.this$0.getScrollHandleView() == null) goto L6;
            this.this$0.getScrollHandleView().scrollTo(HorizontalScrollListView.access$000(this.this$0).getCurrX(), 0);
        L6:
            if (r0 == false) goto L8;
            HorizontalScrollListView.access$100(this.this$0, false);
            HorizontalScrollListView.access$202(this.this$0, true);
            this.this$0.post(this);
            return;
        L8:
            HorizontalScrollListView.access$202(this.this$0, false);
            int r3 = 4;
            if (this.this$0.getHorizontalScrollX() != 0) goto L15;
            this.this$0.setScrollState(0);
            HorizontalScrollListView.access$100(this.this$0, false);
            if (HorizontalScrollListView.access$300(this.this$0) == null) goto L13;
            HorizontalScrollListView.access$300(this.this$0).onScrollRestored(HorizontalScrollListView.access$400(this.this$0));
        L13:
            HorizontalScrollListView.access$500(this.this$0, 4);
            HorizontalScrollListView.access$402(this.this$0, null);
            return;
        L15:
            if (this.this$0.getBtnsView() == null) goto L22;
            HorizontalScrollListView r1 = this.this$0;
            if (r1.getHorizontalScrollX() > 0) goto L20;
            r3 = 3;
        L20:
            r1.setScrollState(r3);
            HorizontalScrollListView.access$100(this.this$0, true);
        L22:
            if (HorizontalScrollListView.access$300(this.this$0) == null) goto L27;
            HorizontalScrollListView.access$300(this.this$0).onScrollCompleted(HorizontalScrollListView.access$400(this.this$0));
            return;
        }
    }

    public interface ScrollStateListener {
        void onScrollCompleted(View r1);

        void onScrollRestored(View r1);

        void onScrollStateChanged(View r1, int r2, int r3);

        void onScrolling(int r1, View r2);
    }

    static {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r1) {
        return false;
    }

    static /* synthetic */ Scroller access$000(HorizontalScrollListView r0) {
        return r0.mScroller;
    }

    static /* synthetic */ void access$100(HorizontalScrollListView r0, boolean r1) {
        r0.setBtnsListenerEnabled(r1);
    }

    static /* synthetic */ int access$1000(HorizontalScrollListView r0) {
        return r0.mDownY;
    }

    static /* synthetic */ int access$1102(HorizontalScrollListView r0, int r1) {
        r0.mJustClickedPos = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1202(HorizontalScrollListView r0, boolean r1) {
        r0.mIsAnimating = r1;
        return r1;
    }

    static /* synthetic */ int access$1300() {
        return DEL_ANIMATION_DURATION;
    }

    static /* synthetic */ boolean access$202(HorizontalScrollListView r0, boolean r1) {
        r0.mIsScrollRunning = r1;
        return r1;
    }

    static /* synthetic */ ScrollStateListener access$300(HorizontalScrollListView r0) {
        return r0.mOnScrollStateListener;
    }

    static /* synthetic */ View access$400(HorizontalScrollListView r0) {
        return r0.mHintView;
    }

    static /* synthetic */ View access$402(HorizontalScrollListView r0, View r1) {
        r0.mHintView = r1;
        return r1;
    }

    static /* synthetic */ void access$500(HorizontalScrollListView r0, int r1) {
        r0.setBackgroundViewVisibility(r1);
    }

    static /* synthetic */ boolean access$700(HorizontalScrollListView r0) {
        return r0.mScrollEnabled;
    }

    static /* synthetic */ ItemLongClickedListener access$800(HorizontalScrollListView r0) {
        return r0.mItemLongClickedListener;
    }

    static /* synthetic */ int access$900(HorizontalScrollListView r0) {
        return r0.mDownX;
    }

    public void setItemLongClickedListener(ItemLongClickedListener r1) {
        this.mItemLongClickedListener = r1;
    }

    public HorizontalScrollListView(Context r2) {
        this(r2, null);
    }

    public HorizontalScrollListView(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mScrollState = 0;
        this.mClickScrollHitPos = -1;
        this.mAutoClose = true;
        this.mScrollEnabled = false;
        this.mRestoreEatBackKey = true;
        this.mIsAnimating = false;
        this.mLeftBtnsWidth = -1;
        this.mRightBtnsWidth = -1;
        this.mMaxLeftBtnsWidth = -1;
        this.mMaxRightBtnsWidth = -1;
        this.mVelocityFactor = 1.0f;
        this.mOverflowVelocityFactor = 0.2f;
        this.mScrollFactor = 0.5f;
        this.mIntercept = false;
        this.mIsScrollRunning = false;
        this.mJustClickedPos = -1;
        this.mOnItemLongClickListener = new AnonymousClass1(this);
        this.mReceiver = new AnonymousClass2(this);
        init(r4, r5);
    }

    public HorizontalScrollListView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mScrollState = 0;
        this.mClickScrollHitPos = -1;
        this.mAutoClose = true;
        this.mScrollEnabled = false;
        this.mRestoreEatBackKey = true;
        this.mIsAnimating = false;
        this.mLeftBtnsWidth = -1;
        this.mRightBtnsWidth = -1;
        this.mMaxLeftBtnsWidth = -1;
        this.mMaxRightBtnsWidth = -1;
        this.mVelocityFactor = 1.0f;
        this.mOverflowVelocityFactor = 0.2f;
        this.mScrollFactor = 0.5f;
        this.mIntercept = false;
        this.mIsScrollRunning = false;
        this.mJustClickedPos = -1;
        this.mOnItemLongClickListener = new AnonymousClass1(this);
        this.mReceiver = new AnonymousClass2(this);
        init(r3, r4);
    }

    private void init(Context r17, AttributeSet r18) {
        if (r18 == null) goto L5;
        TypedArray r3 = getContext().obtainStyledAttributes(r18, R.styleable.HorizontalScrollListView, 0, 0);
        this.mScrollEnabled = r3.getBoolean(8, this.mScrollEnabled);
        this.mRestoreEatBackKey = r3.getBoolean(5, this.mRestoreEatBackKey);
        this.mLeftBtnsWidth = r3.getDimensionPixelSize(1, this.mLeftBtnsWidth);
        this.mRightBtnsWidth = r3.getDimensionPixelSize(7, this.mRightBtnsWidth);
        this.mMaxLeftBtnsWidth = r3.getDimensionPixelSize(2, this.mMaxLeftBtnsWidth);
        this.mMaxRightBtnsWidth = r3.getDimensionPixelSize(3, this.mMaxRightBtnsWidth);
        this.mVelocityFactor = r3.getFloat(12, this.mVelocityFactor);
        this.mOverflowVelocityFactor = r3.getFloat(4, this.mOverflowVelocityFactor);
        this.mScrollFactor = r3.getFloat(9, this.mScrollFactor);
        this.mLeftBtnsId = r3.getResourceId(0, 0);
        this.mRightBtnsId = r3.getResourceId(6, 0);
        this.mScrollHandleId = r3.getResourceId(10, 0);
        this.mScrollMode = r3.getInt(11, 0);
        r3.recycle();
        getContext().obtainStyledAttributes(r18, R.styleable.DragSortListView, 0, 0).recycle();
    L5:
        this.mScrollRunner = new ScrollRunner(this, null);
        this.mScroller = new Scroller(r17);
        this.mDetector = new GestureDetector(r17, this);
        this.mTouchSlop = ViewConfiguration.get(r17).getScaledTouchSlop();
        this.mCancelEvent = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        setSelector(android.R.color.transparent);
        setOnItemLongClickListener(this.mOnItemLongClickListener);
    }

    public void setAutoClose(boolean r1) {
        this.mAutoClose = r1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r3, KeyEvent r4) {
        if (r3 != 4) goto L13;
        if (this.mScrollEnabled == false) goto L13;
        if (restoreScrollState(true) == false) goto L13;
        if (this.mRestoreEatBackKey == false) goto L13;
        return true;
    L13:
        return super.onKeyUp(r3, r4);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getContext(), this.mReceiver, new IntentFilter(IntentSmt.get_ACTION_STATUS_BAR_CLICKED()));
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(this.mReceiver);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r2) {
        if (this.mScrollEnabled == true) goto L5;
        return false;
    L5:
        if (isStateScrolled() == true) goto L7;
    L9:
        this.mClickScrollHitPos = viewIdHitPosition(r2, this.mScrollHandleId);
        return false;
    L7:
        if (isMotionHintView(getBtnsView(), r2) == false) goto L9;
        this.mClickScrollHitPos = -1;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
        if (this.mScrollEnabled == true) goto L6;
        return false;
    L6:
        if (this.mClickScrollHitPos != (-1)) goto L8;
        return false;
    L8:
        int r0 = (int) (r6.getX() - r5.getX());
        int r9 = (int) (r6.getY() - r5.getY());
        if (isStateScrolling() == true) goto L30;
        int r10 = this.mScrollMode;
        if (r10 != 1) goto L14;
        if (r0 <= 0) goto L14;
        return false;
    L14:
        if (r10 != 0) goto L18;
        if (r0 >= 0) goto L18;
        return false;
    L18:
        if (Math.abs(r0) >= Math.abs(r9)) goto L21;
        return false;
    L21:
        if (Math.abs(r0) >= this.mTouchSlop) goto L24;
        return false;
    L24:
        if (Math.abs(r7) >= Math.abs(r8)) goto L27;
        return false;
    L27:
        if (Math.abs(r7) >= this.mTouchSlop) goto L30;
        return false;
    L30:
        if (DEBUG_SCROLL == false) goto L32;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onScroll mode: " + this.mScrollMode + ", deltaX: " + r0 + ", deltaY: " + r9 + ", distanceX: " + r7 + ", distanceY: " + r8);
    L32:
        scrolling(this.mClickScrollHitPos - getHeaderViewsCount(), r7);
        return false;
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        View r1 = getChildAt(viewIdHitPosition(r5, 0) - getFirstVisiblePosition());
        if (r1 != null) goto L5;
    L16:
        boolean r2 = false;
    L18:
        if (super.onInterceptTouchEvent(r5) == true) goto L21;
        if (r2 == true) goto L21;
        return false;
    L21:
        return true;
    L5:
        if (isStateScrolled() == false) goto L12;
        if (r1 != this.mHintView) goto L12;
        if (isMotionHintView(getBtnsView(), r5) == false) goto L15;
        return false;
    L15:
        r2 = true;
    L12:
        if (isMotionHintView(r1.findViewById(this.mLeftBtnsId), r5) == true) goto L15;
        if (isMotionHintView(r1.findViewById(this.mRightBtnsId), r5) == false) goto L16;
        goto L15
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (DEBUG_SCROLL == false) goto L5;
        log("dispatchTouchEvent");
    L5:
        boolean r0 = super.dispatchTouchEvent(r3);
        if (this.mAutoClose == true) goto L8;
    L10:
        return r0;
    L8:
        if (isStateScrolled() == false) goto L10;
        onScrolledStateTouchEvent_V2(r3);
        onCancelPendingInputEvents();
        goto L10
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (DEBUG_SCROLL == false) goto L5;
        log("onTouchEvent");
    L5:
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L8;
    L9:
        int r1 = r5.getActionIndex();
        this.mDownX = (int) r5.getX(r1);
        this.mDownY = (int) r5.getY(r1);
        this.mJustClickedPos = -1;
    L11:
        if (this.mScrollEnabled == true) goto L15;
        return super.onTouchEvent(r5);
    L15:
        if (this.mIsAnimating == false) goto L17;
    L18:
        this.mIntercept = true;
    L19:
        this.mDetector.onTouchEvent(r5);
        if (isStateScrolled() == false) goto L22;
        onScrolledStateTouchEvent(r5);
        this.mIntercept = true;
    L22:
        boolean r2 = this.mIntercept;
        if (r0 != 1) goto L25;
    L28:
        ensureScrollState(true);
        doActionUpOrCancel();
    L29:
        if (r2 == false) goto L33;
        onCancelPendingInputEvents();
        doActionUpOrCancel();
        return true;
    L33:
        return super.onTouchEvent(r5);
    L25:
        if (r0 == 3) goto L28;
        if (r2 == false) goto L29;
        super.onTouchEvent(this.mCancelEvent);
        goto L29
    L17:
        if (this.mIsScrollRunning == false) goto L19;
    L8:
        if (r0 != 5) goto L11;
        goto L9
    }

    private void doActionUpOrCancel() {
        this.mIntercept = false;
        this.mClickScrollHitPos = -1;
    }

    private void onScrolledStateTouchEvent(MotionEvent r2) {
        if (isMotionHintView(getBtnsView(), r2) == false) goto L5;
        return;
    L5:
        restoreScrollState(true);
    }

    private void onScrolledStateTouchEvent_V2(MotionEvent r4) {
        if (isMotionHintView(getBtnsView(), r4) == true) goto L5;
        return;
    L5:
        int r5 = r4.getAction() & 255;
        boolean r0 = false;
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L12;
        if (r5 != 3) goto L14;
    L12:
        if (isStateScrolling() == true) goto L14;
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        restoreScrollState(true);
        return;
    }

    private void setBtnsListenerEnabled(boolean r5) {
        View r0 = getBtnsView();
        if (isStateLeft() == false) goto L5;
        View.OnClickListener r4 = this.mRightBtnsClickListener;
    L6:
        if (r0 == null) goto L25;
        if (r4 != null) goto L10;
        return;
    L10:
        if ((r0 instanceof ViewGroup) == false) goto L18;
        ViewGroup r1 = (ViewGroup) r0;
        int r2 = 0;
    L13:
        if (r2 >= r1.getChildCount()) goto L28;
        if (r5 == false) goto L16;
        r1.getChildAt(r2).setOnClickListener(r4);
    L17:
        r2 = r2 + 1;
        goto L13
    L16:
        r1.getChildAt(r2).setClickable(false);
        goto L17
    L28:
        return;
    L18:
        if (r5 == false) goto L20;
        r0.setOnClickListener(r4);
        return;
    L20:
        r0.setClickable(false);
        return;
    L25:
        return;
    L5:
        r4 = this.mLeftBtnsClickListener;
        goto L6
    }

    private int viewIdHitPosition(MotionEvent r6, int r7) {
        int r0 = pointToPosition((int) r6.getX(), (int) r6.getY());
        int r1 = getHeaderViewsCount();
        int r2 = getFooterViewsCount();
        int r3 = getCount();
        if (r0 == (-1)) goto L14;
        if (r0 < r1) goto L14;
        if (r0 >= (r3 - r2)) goto L14;
        View r4 = getChildAt(r0 - getFirstVisiblePosition());
        if (r7 == 0) goto L12;
        r4 = r4.findViewById(r7);
    L12:
        if (isMotionHintView(r4, r6) == false) goto L14;
        return r0;
    L14:
        return -1;
    }

    private boolean isMotionHintView(View r6, MotionEvent r7) {
        if (r6 != null) goto L5;
    L16:
        return false;
    L5:
        if (r6.getVisibility() != 0) goto L16;
        int[] r0 = new int[2];
        int r1 = (int) r7.getRawX();
        int r8 = (int) r7.getRawY();
        r6.getLocationOnScreen(r0);
        int r2 = r0[0];
        if (r1 <= r2) goto L16;
        if (r8 <= r0[1]) goto L16;
        if (r1 >= (r2 + r6.getWidth())) goto L16;
        if (r8 >= (r0[1] + r6.getHeight())) goto L16;
        return true;
    }

    private void scrolling(int r6, float r7) {
        int r8 = (r6 - getHeaderViewsCount()) - getFirstVisiblePosition();
        View r0 = getChildAt(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.mHintView;
        if (r1 == null) goto L10;
        if (r1 == r0) goto L10;
        return;
    L10:
        if (this.mIntercept == false) goto L13;
        if (r1 != null) goto L13;
        return;
    L13:
        super.onTouchEvent(this.mCancelEvent);
        this.mHintView = r0;
        int r2 = getHorizontalScrollX();
        int r3 = 2;
        if (r2 == 0) goto L16;
        if (r2 >= 0) goto L21;
        r3 = 1;
    L21:
        setScrollState(r3);
    L22:
        int r4 = getBtnsWidth();
        if (r4 > 0) goto L25;
    L28:
        float r5 = this.mVelocityFactor;
    L29:
        int r9 = (int) ((r7 * r5) + r2);
        if (r9 > 0) goto L32;
    L34:
        if (r9 < 0) goto L36;
    L38:
        int r10 = getMaxBtnsWidth();
        if (r10 <= 0) goto L46;
        if (Math.abs(r9) <= r10) goto L46;
        if (r9 <= 0) goto L44;
        r9 = r10;
        goto L46
    L44:
        r9 = -r10;
    L46:
        if (DEBUG_SCROLL == false) goto L49;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "oldScrollX: " + r2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "newScrollX: " + r9);
    L49:
        if (getScrollHandleView() == null) goto L52;
        getScrollHandleView().scrollTo(r9, 0);
    L52:
        if (getBtnsView() == null) goto L54;
        setBackgroundViewVisibility(0);
    L54:
        ScrollStateListener r11 = this.mOnScrollStateListener;
        if (r11 == null) goto L58;
        r11.onScrolling(r8, this.mHintView);
        return;
    L58:
        return;
    L36:
        if (this.mScrollMode != 1) goto L38;
        r9 = 0;
        goto L38
    L32:
        if (this.mScrollMode != 0) goto L34;
        r9 = 0;
        goto L34
    L25:
        if (Math.abs(r2) < r4) goto L28;
        r5 = this.mOverflowVelocityFactor;
        goto L29
    L16:
        if (r7 >= 0.0f) goto L18;
        r3 = 1;
    L18:
        setScrollState(r3);
        goto L22
    }

    private void horizontalScrolling(int r8, int r9, int r10) {
        removeCallbacks(this.mScrollRunner);
        this.mScroller.startScroll(r8, 0, r9, 0, r10);
        post(this.mScrollRunner);
    }

    private int getBtnsWidth() {
        if (isStateLeft() == false) goto L5;
        int r0 = this.mRightBtnsWidth;
    L6:
        if (r0 > 0) goto L10;
        View r1 = getBtnsView();
        if (r1 == null) goto L10;
        r0 = r1.getMeasuredWidth();
    L10:
        if (r0 > 0) goto L14;
        return -1;
    L14:
        return r0;
    L5:
        r0 = this.mLeftBtnsWidth;
        goto L6
    }

    private int getMaxBtnsWidth() {
        if (isStateLeft() == false) goto L5;
        int r1 = this.mMaxRightBtnsWidth;
    L6:
        if (r1 > 0) goto L10;
        return -1;
    L10:
        return r1;
    L5:
        r1 = this.mMaxLeftBtnsWidth;
        goto L6
    }

    private boolean completeScrollState() {
        if (this.mHintView != null) goto L5;
        return false;
    L5:
        int r0 = getBtnsWidth();
        if (r0 > 0) goto L8;
        return false;
    L8:
        int r2 = getHorizontalScrollX();
        if (r2 == 0) goto L11;
    L13:
        int r1 = r0 - Math.abs(r2);
        if (r2 >= 0) goto L16;
        r1 = -r1;
    L16:
        horizontalScrolling(r2, r1, COMPLETE_SCROLL_DURATION);
        return true;
    L11:
        if (this.mScrollMode != 2) goto L13;
        return false;
    }

    private void setBackgroundViewVisibility(int r4) {
        View r0 = this.mHintView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mScrollMode != 1) goto L7;
        int r3 = this.mRightBtnsId;
    L8:
        View r5 = r0.findViewById(r3);
        if (r5 == null) goto L13;
        r5.setVisibility(r4);
        return;
    L13:
        return;
    L7:
        r3 = this.mLeftBtnsId;
        goto L8
    }

    public boolean restoreScrollState(boolean r4) {
        int r1 = 0;
        if (getHorizontalScrollX() != 0) goto L11;
        setBackgroundViewVisibility(4);
        if (this.mScrollState == 0) goto L9;
        ScrollStateListener r5 = this.mOnScrollStateListener;
        if (r5 == null) goto L9;
        r5.onScrollRestored(this.mHintView);
    L9:
        setScrollState(0);
        this.mHintView = null;
        return false;
    L11:
        int r0 = getScrollHandleView().getScrollX();
        int r2 = -r0;
        if (r4 == false) goto L14;
        r1 = RESTORE_SCROLL_DURATION;
    L14:
        horizontalScrolling(r0, r2, r1);
        return true;
    }

    public boolean ensureScrollState(boolean r5) {
        if (isStateScrolled() == false) goto L6;
        return true;
    L6:
        if (this.mHintView != null) goto L8;
        return false;
    L8:
        if (getBtnsView() != null) goto L10;
    L15:
        restoreScrollState(r5);
    L16:
        return true;
    L10:
        if (Math.abs(getHorizontalScrollX()) < (getBtnsWidth() * this.mScrollFactor)) goto L15;
        if (completeScrollState() == true) goto L16;
        restoreScrollState(r5);
        goto L16
    }

    public void changeHintView(View r3) {
        this.mHintView = r3;
        int r4 = getBtnsWidth();
        if (r4 > 0) goto L5;
        return;
    L5:
        removeCallbacks(this.mScrollRunner);
        if (isStateLeft() == true) goto L10;
        r4 = -r4;
    L10:
        if (getScrollHandleView() == null) goto L12;
        setBtnsListenerEnabled(false);
        getScrollHandleView().scrollTo(0, 0);
    L12:
        setBtnsListenerEnabled(true);
        getScrollHandleView().scrollTo(r4, 0);
    }

    public void changeHintView(int r2) {
        changeHintView(getChildAt((r2 - getHeaderViewsCount()) - getFirstVisiblePosition()));
    }

    public View getHintView() {
        return this.mHintView;
    }

    public View getScrollHandleView() {
        View r0 = this.mHintView;
        if (r0 == null) goto L9;
        int r1 = this.mScrollHandleId;
        if (r1 != 0) goto L8;
        return r0;
    L8:
        return r0.findViewById(r1);
    L9:
        return null;
    }

    public View getBtnsView() {
        View r0 = this.mHintView;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (isStateLeft() == false) goto L9;
        int r2 = this.mRightBtnsId;
    L11:
        return r0.findViewById(r2);
    L9:
        r2 = this.mLeftBtnsId;
        goto L11
    }

    public int getHorizontalScrollX() {
        View r0 = getScrollHandleView();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getScrollX();
    }

    public void setScrollEnabled(boolean r1) {
        this.mScrollEnabled = r1;
    }

    public boolean isScrollEnabled() {
        return this.mScrollEnabled;
    }

    public void setScrollMode(int r1) {
        this.mScrollMode = r1;
    }

    public int getScrollMode() {
        return this.mScrollMode;
    }

    public void setScrollState(int r4) {
        int r0 = this.mScrollState;
        if (r0 != r4) goto L5;
        return;
    L5:
        ScrollStateListener r1 = this.mOnScrollStateListener;
        if (r1 == null) goto L8;
        r1.onScrollStateChanged(this.mHintView, r0, r4);
    L8:
        this.mScrollState = r4;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isStateLeft() {
        int r1 = this.mScrollState;
        if (r1 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 2) goto L8;
        return false;
    }

    public boolean isStateRight() {
        int r2 = this.mScrollState;
        if (r2 == 3) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isStateScrolled() {
        int r1 = this.mScrollState;
        if (r1 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    public boolean isStateScrolling() {
        int r2 = this.mScrollState;
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public boolean isStateIdle() {
        if (this.mScrollState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setOnScrollStateChangeListener(ScrollStateListener r1) {
        this.mOnScrollStateListener = r1;
    }

    public void setBtnsOnClickListener(View.OnClickListener r1, View.OnClickListener r2) {
        this.mLeftBtnsClickListener = r1;
        this.mRightBtnsClickListener = r2;
    }

    public void playDeleteItemAnimation(final Animator.AnimatorListener r16) {
        View r0 = this.mHintView;
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L11;
        int r3 = this.mJustClickedPos;
        if (r3 < 0) goto L11;
        changeHintView(getChildAt(r3 - getFirstVisiblePosition()));
        r0 = this.mHintView;
    L11:
        final View r4 = r0;
        if (r4 != null) goto L16;
        if (r16 == null) goto L49;
        r16.onAnimationStart(null);
        r16.onAnimationEnd(null);
        return;
    L49:
        return;
    L16:
        final View r8 = getBtnsView();
        if (isStateLeft() == false) goto L19;
        int r1 = this.mLeftBtnsId;
    L20:
        final View r9 = r4.findViewById(r1);
        if (r9 == null) goto L23;
        int r2 = r9.getVisibility();
    L24:
        final int r6 = r2;
        final int r7 = r4.getScrollX();
        if (isStateLeft() == false) goto L27;
        int r5 = r4.getWidth();
    L28:
        int r10 = 0;
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r7, r5});
        r12.setInterpolator(new DecelerateInterpolator(1.5f));
        r12.setDuration(DEL_ANIMATION_DURATION);
        r12.addUpdateListener(new AnonymousClass3(this, r4));
        r12.addListener(new AnonymousClass4(this, r16, r4, r8, r9, r6, r7));
        if (r9 == null) goto L31;
        r9.setVisibility(4);
    L31:
        if (r8 == null) goto L43;
        AlphaAnimation r11 = new AlphaAnimation(1.0f, 0.0f);
        r11.setDuration(DEL_ANIMATION_DURATION);
        r11.setFillAfter(true);
        r11.setInterpolator(new DecelerateInterpolator(1.5f));
        if ((r8 instanceof ViewGroup) == false) goto L42;
        ViewGroup r13 = (ViewGroup) r8;
        int r14 = r13.getChildCount();
    L35:
        if (r10 >= r14) goto L43;
        View r15 = r13.getChildAt(r10);
        if (r15 == null) goto L41;
        if (r15.getVisibility() != 0) goto L41;
        r15.startAnimation(r11);
    L41:
        r10 = r10 + 1;
        goto L35
    L42:
        r8.startAnimation(r11);
    L43:
        r12.start();
        return;
    L27:
        r5 = -r4.getWidth();
        goto L28
    L23:
        r2 = 8;
        goto L24
    L19:
        r1 = this.mRightBtnsId;
        goto L20
    L5:
        if ((r0 instanceof WrapperView) == false) goto L7;
        r0 = ((WrapperView) r0).getItem();
        goto L11
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == false) goto L5;
        return;
    L5:
        if (isStateScrolled() == false) goto L9;
        restoreScrollState(true);
        onCancelPendingInputEvents();
        return;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 == 0) goto L6;
        restoreScrollState(true);
        onCancelPendingInputEvents();
        return;
    }

    @Override // android.view.View
    public void onScreenStateChanged(int r1) {
        if (r1 != 0) goto L5;
        restoreScrollState(false);
        return;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 == 0) goto L6;
        restoreScrollState(true);
        onCancelPendingInputEvents();
        return;
    }

    private static void log(String r1) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("HorizontalScrollListView", r1);
    }
}
