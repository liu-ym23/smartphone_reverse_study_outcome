package com.android.contacts.widget.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class DragSortController extends SimpleFloatViewManager implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static final int CLICK_REMOVE = 0;
    public static final int FLING_REMOVE = 1;
    public static final int MISS = -1;
    public static final int ON_DOWN = 0;
    public static final int ON_DRAG = 1;
    public static final int ON_LONG_PRESS = 2;
    private boolean mCanDrag;
    private int mCheckHandleId;
    private int mCheckHitPos;
    private int mClickRemoveHitPos;
    private int mClickRemoveId;
    private int mCurrX;
    private int mCurrY;
    private GestureDetector mDetector;
    private int mDragHandleId;
    private int mDragInitMode;
    private boolean mDragging;
    private DragSortListView mDslv;
    private int mFlingHandleId;
    private int mFlingHitPos;
    private GestureDetector mFlingRemoveDetector;
    private GestureDetector.OnGestureListener mFlingRemoveListener;
    private float mFlingSpeed;
    private int mHitPos;
    private boolean mIsRemoving;
    private int mItemX;
    private int mItemY;
    private int mPositionX;
    private boolean mRemoveEnabled;
    private int mRemoveMode;
    private boolean mSortEnabled;
    private int[] mTempLoc;
    private int mTouchSlop;
    private boolean moveing;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent r1) {
    }

    static /* synthetic */ boolean access$000(DragSortController r0) {
        return r0.mRemoveEnabled;
    }

    static /* synthetic */ boolean access$100(DragSortController r0) {
        return r0.mIsRemoving;
    }

    static /* synthetic */ boolean access$102(DragSortController r0, boolean r1) {
        r0.mIsRemoving = r1;
        return r1;
    }

    static /* synthetic */ DragSortListView access$200(DragSortController r0) {
        return r0.mDslv;
    }

    static /* synthetic */ float access$300(DragSortController r0) {
        return r0.mFlingSpeed;
    }

    static /* synthetic */ int access$400(DragSortController r0) {
        return r0.mPositionX;
    }

    public DragSortController(DragSortListView r3) {
        this(r3, 0, 0, 1);
    }

    public DragSortController(DragSortListView r7, int r8, int r9, int r10) {
        this(r7, r8, r9, r10, 0);
    }

    public DragSortController(DragSortListView r9, int r10, int r11, int r12, int r13) {
        this(r9, r10, r11, r12, r13, 0, 0);
    }

    public DragSortController(DragSortListView r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        super(r5);
        this.mDragInitMode = 0;
        this.mSortEnabled = true;
        this.mRemoveEnabled = false;
        this.mIsRemoving = false;
        this.mHitPos = -1;
        this.mCheckHitPos = -1;
        this.mFlingHitPos = -1;
        this.mClickRemoveHitPos = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.mFlingSpeed = 500.0f;
        this.mFlingRemoveListener = new AnonymousClass1(this);
        this.mDslv = r5;
        this.mDetector = new GestureDetector(r5.getContext(), this);
        GestureDetector r1 = new GestureDetector(r5.getContext(), this.mFlingRemoveListener);
        this.mFlingRemoveDetector = r1;
        r1.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(r5.getContext()).getScaledTouchSlop();
        this.mDragHandleId = r6;
        this.mClickRemoveId = r9;
        this.mFlingHandleId = r10;
        this.mCheckHandleId = r11;
        setRemoveMode(r8);
        setDragInitMode(r7);
    }

    public int getDragInitMode() {
        return this.mDragInitMode;
    }

    public void setDragInitMode(int r1) {
        this.mDragInitMode = r1;
    }

    public void setSortEnabled(boolean r1) {
        this.mSortEnabled = r1;
    }

    public boolean isSortEnabled() {
        return this.mSortEnabled;
    }

    public void setRemoveMode(int r1) {
        this.mRemoveMode = r1;
    }

    public int getRemoveMode() {
        return this.mRemoveMode;
    }

    public void setRemoveEnabled(boolean r1) {
        this.mRemoveEnabled = r1;
    }

    public boolean isRemoveEnabled() {
        return this.mRemoveEnabled;
    }

    public void setDragHandleId(int r1) {
        this.mDragHandleId = r1;
    }

    public void setFlingHandleId(int r1) {
        this.mFlingHandleId = r1;
    }

    public void setClickRemoveId(int r1) {
        this.mClickRemoveId = r1;
    }

    public boolean startDrag(int r4, int r5, int r6) {
        if (this.mSortEnabled == true) goto L5;
    L7:
        int r0 = 0;
    L9:
        if (this.mRemoveEnabled == true) goto L11;
    L13:
        DragSortListView r1 = this.mDslv;
        boolean r7 = r1.startDrag(r4 - r1.getHeaderViewsCount(), r0, r5, r6);
        this.mDragging = r7;
        return r7;
    L11:
        if (this.mIsRemoving == false) goto L13;
        r0 = (r0 | 1) | 2;
        goto L13
    L5:
        if (this.mIsRemoving == true) goto L7;
        r0 = 12;
        goto L9
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r3, MotionEvent r4) {
        if (this.mDslv.isDragEnabled() == true) goto L5;
    L33:
        return false;
    L5:
        if (this.mDslv.listViewIntercepted() == true) goto L33;
        this.mDetector.onTouchEvent(r4);
        if (this.mRemoveEnabled == true) goto L10;
    L14:
        int r5 = r4.getAction() & 255;
        if (r5 == 0) goto L32;
        if (r5 == 1) goto L22;
        if (r5 != 3) goto L33;
        this.mIsRemoving = false;
        this.mDragging = false;
        goto L33
    L22:
        if (this.mRemoveEnabled == false) goto L33;
        if (this.mIsRemoving == false) goto L33;
        int r6 = this.mPositionX;
        if (r6 >= 0) goto L30;
        r6 = -r6;
    L30:
        if (r6 <= (this.mDslv.getWidth() / 2)) goto L33;
        this.mDslv.stopDragWithVelocity(true, 0.0f);
        goto L33
    L32:
        this.mCurrX = (int) r4.getX();
        this.mCurrY = (int) r4.getY();
        goto L33
    L10:
        if (this.mDragging == false) goto L14;
        if (this.mRemoveMode != 1) goto L14;
        this.mFlingRemoveDetector.onTouchEvent(r4);
        goto L14
    }

    @Override // com.android.contacts.widget.dslv.SimpleFloatViewManager, com.android.contacts.widget.dslv.DragSortListView.FloatViewManager
    public void onDragFloatView(View r1, Point r2, Point r3) {
        if (this.mRemoveEnabled == true) goto L5;
        return;
    L5:
        if (this.mIsRemoving == false) goto L9;
        this.mPositionX = r2.x;
        return;
    }

    public int startDragPosition(MotionEvent r1) {
        return dragHandleHitPosition(r1);
    }

    public int startCheckPosition(MotionEvent r1) {
        return checkHandleHitPosition(r1);
    }

    public int startFlingPosition(MotionEvent r3) {
        if (this.mRemoveMode == 1) goto L7;
        return -1;
    L7:
        return flingHandleHitPosition(r3);
    }

    public int dragHandleHitPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mDragHandleId);
    }

    public int checkHandleHitPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mCheckHandleId);
    }

    public int flingHandleHitPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mFlingHandleId);
    }

    public int viewIdHitPosition(MotionEvent r9, int r10) {
        int r0 = (int) r9.getX();
        int r1 = (int) r9.getY();
        int r2 = this.mDslv.pointToPosition(r0, r1);
        int r3 = this.mDslv.getHeaderViewsCount();
        int r4 = this.mDslv.getFooterViewsCount();
        int r5 = this.mDslv.getCount();
        if (r2 == (-1)) goto L30;
        if (r2 < r3) goto L30;
        if (r2 >= (r5 - r4)) goto L30;
        DragSortListView r6 = this.mDslv;
        View r7 = r6.getChildAt(r2 - r6.getFirstVisiblePosition());
        int r8 = (int) r9.getRawX();
        int r11 = (int) r9.getRawY();
        if (r10 != 0) goto L10;
        View r12 = r7;
    L11:
        if (r12 == null) goto L30;
        if (this.mDslv.getSelectState() != 1) goto L20;
        int r13 = this.mTempLoc[0];
        if (r8 <= r13) goto L20;
        if (r8 >= (r13 + r12.getWidth())) goto L20;
        this.mItemX = r7.getLeft();
        this.mItemY = r7.getTop();
        return r2;
    L20:
        r12.getLocationOnScreen(this.mTempLoc);
        int[] r14 = this.mTempLoc;
        int r15 = r14[0];
        if (r8 <= r15) goto L30;
        if (r11 <= r14[1]) goto L30;
        if (r8 >= (r15 + r12.getWidth())) goto L30;
        if (r11 >= (this.mTempLoc[1] + r12.getHeight())) goto L30;
        this.mItemX = r7.getLeft();
        this.mItemY = r7.getTop();
        return r2;
    L10:
        r12 = r7.findViewById(r10);
    L30:
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r5) {
        if (this.mRemoveEnabled == true) goto L5;
    L7:
        this.mHitPos = startDragPosition(r5);
        int r0 = startCheckPosition(r5);
        this.mCheckHitPos = r0;
        int r1 = this.mHitPos;
        if (r1 != (-1)) goto L10;
    L15:
        if (r0 == (-1)) goto L17;
        startMove(r0, (int) r5.getX(), (int) r5.getY());
    L17:
        this.mIsRemoving = false;
        this.mCanDrag = true;
        this.mPositionX = 0;
        this.mFlingHitPos = startFlingPosition(r5);
        return true;
    L10:
        if (this.mDragInitMode != 0) goto L15;
        if (r1 == (-1)) goto L14;
        r0 = r1;
    L14:
        startDrag(r0, ((int) r5.getX()) - this.mItemX, ((int) r5.getY()) - this.mItemY);
        goto L17
    L5:
        if (this.mRemoveMode != 0) goto L7;
        this.mClickRemoveHitPos = viewIdHitPosition(r5, this.mClickRemoveId);
        goto L7
    }

    private boolean startMove(int r3, int r4, int r5) {
        DragSortListView r0 = this.mDslv;
        boolean r6 = r0.startMove(r3 - r0.getHeaderViewsCount(), 12, r4, r5);
        this.moveing = r6;
        return r6;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r8, MotionEvent r9, float r10, float r11) {
        if (r8 != null) goto L5;
        return true;
    L5:
        int r12 = (int) r8.getX();
        int r13 = (int) r8.getY();
        int r0 = (int) r9.getX();
        int r14 = (int) r9.getY();
        int r1 = r0 - this.mItemX;
        int r2 = r14 - this.mItemY;
        if (this.mCanDrag == true) goto L8;
    L47:
        return false;
    L8:
        if (this.mDragging == true) goto L47;
        int r3 = this.mHitPos;
        if (r3 == (-1)) goto L12;
    L15:
        if (r3 == (-1)) goto L31;
        if (this.mDragInitMode != 1) goto L24;
        if (Math.abs(r14 - r13) <= this.mTouchSlop) goto L24;
        if (this.mSortEnabled == false) goto L24;
        startDrag(this.mHitPos, r1, r2);
    L24:
        if (this.mDragInitMode == 0) goto L47;
        if (Math.abs(r0 - r12) <= this.mTouchSlop) goto L47;
        if (this.mRemoveEnabled == false) goto L47;
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, r1, r2);
        goto L47
    L31:
        if (this.mFlingHitPos == (-1)) goto L41;
        if (Math.abs(r0 - r12) <= this.mTouchSlop) goto L38;
        if (this.mRemoveEnabled == false) goto L38;
        this.mIsRemoving = true;
        startDrag(this.mFlingHitPos, r1, r2);
    L38:
        if (Math.abs(r14 - r13) <= this.mTouchSlop) goto L47;
        this.mCanDrag = false;
        goto L47
    L41:
        if (this.mCheckHitPos == (-1)) goto L47;
        if (this.mDragInitMode != 0) goto L47;
        if (Math.abs(r14 - r13) <= this.mTouchSlop) goto L47;
        startMove(this.mCheckHitPos, r0, r14);
        goto L47
    L12:
        if (this.mFlingHitPos != (-1)) goto L15;
        if (this.mCheckHitPos == (-1)) goto L47;
        goto L15
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r4) {
        if (this.mHitPos != (-1)) goto L5;
        return;
    L5:
        if (this.mDragInitMode != 2) goto L9;
        this.mDslv.performHapticFeedback(0);
        startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
        return;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r2) {
        if (this.mRemoveEnabled == true) goto L5;
        return true;
    L5:
        if (this.mRemoveMode != 0) goto L12;
        int r3 = this.mClickRemoveHitPos;
        if (r3 == (-1)) goto L13;
        DragSortListView r1 = this.mDslv;
        r1.removeItem(r3 - r1.getHeaderViewsCount());
        return true;
    L13:
        return true;
    L12:
        return true;
    }
}
