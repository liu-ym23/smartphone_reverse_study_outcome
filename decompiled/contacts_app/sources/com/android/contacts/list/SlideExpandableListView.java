package com.android.contacts.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class SlideExpandableListView extends ExpandableListView {
    private static String TAG = "SlideListView";
    private final int DEFAULT_PRE_POSITION;
    private final int MISS;
    private final int SELECT;
    private final int SPECIAL;
    private final float SPEED_CARDINAL;
    private int mCheckboxId;
    private Point mCurrPoint;
    private Point mDownPoint;
    private float mDownScrollStartY;
    private int mEndX;
    private boolean mIsChecked;
    private Listener mListener;
    private PowerManager mPowerManager;
    private long mPrePokeTime;
    private int mPrePosition;
    private SelectScroller mScroller;
    private float mSelectDownScrollStartFrac;
    private float mSelectUpScrollStartFrac;
    private boolean mSlideEnable;
    private int mStartX;
    private int mState;
    private int[] mTempLoc;
    private TouchMonitorListener mTouchMonitorListener;
    private float mUpScrollStartY;

    /* JADX INFO: renamed from: com.android.contacts.list.SlideExpandableListView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Listener {
        boolean isChecked(int r1);

        void setChecked(int r1, boolean r2);
    }

    private final class SelectScroller implements Runnable {
        public static final int DOWN = 2;
        public static final int UP = 1;
        private boolean mAbort;
        private long mCurrTime;
        private long mPrevTime;
        private int mScrollDir;
        private float mScrollSpeed;
        private boolean mScrolling;
        final /* synthetic */ SlideExpandableListView this$0;

        private SelectScroller(SlideExpandableListView r1) {
            this.this$0 = r1;
            this.mScrolling = false;
        }

        /* synthetic */ SelectScroller(SlideExpandableListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void startScroll(int r3) {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SlideExpandableListView.access$100(), "startScroll.........................");
        L6:
            if (this.mScrolling == true) goto L9;
            this.mScrolling = true;
            this.mAbort = false;
            this.mScrollDir = r3;
            this.mPrevTime = SystemClock.uptimeMillis();
            this.this$0.post(this);
            return;
        }

        public void stopScroll() {
            if (ContactsUtils.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SlideExpandableListView.access$100(), "stopScroll.........................");
        L5:
            this.this$0.removeCallbacks(this);
            this.mScrolling = false;
        }

        public boolean isScrolling() {
            return this.mScrolling;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAbort == false) goto L5;
            return;
        L5:
            int r0 = this.this$0.getFirstVisiblePosition();
            int r1 = this.this$0.getLastVisiblePosition();
            int r2 = this.this$0.getCount();
            int r3 = this.this$0.getPaddingTop();
            int r4 = (this.this$0.getHeight() - r3) - this.this$0.getPaddingBottom();
            performSelectAction();
            if (this.mScrollDir != 1) goto L20;
            View r5 = this.this$0.getChildAt(0);
            if (r5 == null) goto L18;
            if (r0 != 0) goto L14;
            if (r5.getTop() == r3) goto L18;
        L14:
            if (SlideExpandableListView.access$200(this.this$0).y < r3) goto L17;
            r3 = SlideExpandableListView.access$200(this.this$0).y;
        L17:
            this.mScrollSpeed = (r3 - SlideExpandableListView.access$300(this.this$0)) * 0.01f;
        L32:
            long r6 = SystemClock.uptimeMillis();
            this.mCurrTime = r6;
            float r7 = r6 - this.mPrevTime;
            this.this$0.smoothScrollBy(Math.round(this.mScrollSpeed * r7), (int) r7);
            this.this$0.invalidate();
            this.mPrevTime = this.mCurrTime;
            this.this$0.post(this);
            return;
        L18:
            this.mScrolling = false;
            return;
        L20:
            View r8 = this.this$0.getChildAt(r1 - r0);
            if (r8 != null) goto L23;
        L34:
            this.mScrolling = false;
            return;
        L23:
            if (r1 == (r2 - 1)) goto L25;
        L27:
            int r9 = this.this$0.getHeight() - this.this$0.getPaddingBottom();
            if (SlideExpandableListView.access$200(this.this$0).y > r9) goto L31;
            r9 = SlideExpandableListView.access$200(this.this$0).y;
        L31:
            this.mScrollSpeed = (r9 - SlideExpandableListView.access$400(this.this$0)) * 0.01f;
            goto L32
        L25:
            if (r8.getBottom() > (r4 + r3)) goto L27;
            goto L27
        }

        private void performSelectAction() {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SlideExpandableListView.access$100(), "performSelectAction().....................  ");
        L6:
            if (SlideExpandableListView.access$200(this.this$0).y >= this.this$0.getPaddingTop()) goto L13;
            if (ContactsUtils.DEBUG == false) goto L10;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SlideExpandableListView.access$100(), "mCurrPoint is above list view");
        L10:
            SlideExpandableListView r3 = this.this$0;
            SlideExpandableListView.access$500(r3, r3.getFirstVisiblePosition());
            return;
        L13:
            if (SlideExpandableListView.access$200(this.this$0).y > (this.this$0.getHeight() - this.this$0.getPaddingBottom())) goto L15;
            SlideExpandableListView r0 = this.this$0;
            int r1 = r0.pointToPosition(SlideExpandableListView.access$200(r0).x, SlideExpandableListView.access$200(this.this$0).y);
            SlideExpandableListView r2 = this.this$0;
            View r4 = r2.getChildAt(r1 - r2.getFirstVisiblePosition());
            if (r4 != null) goto L22;
            return;
        L22:
            if (r4.findViewById(SlideExpandableListView.access$600(this.this$0)) == null) goto L26;
            SlideExpandableListView.access$500(this.this$0, r1);
            return;
        L26:
            return;
        L15:
            if (ContactsUtils.DEBUG == false) goto L17;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SlideExpandableListView.access$100(), "mCurrPoint is below list view");
        L17:
            SlideExpandableListView r5 = this.this$0;
            SlideExpandableListView.access$500(r5, r5.getLastVisiblePosition());
        }
    }

    public interface TouchMonitorListener {
        void onTouchActionUp();
    }

    static {
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    static /* synthetic */ Point access$200(SlideExpandableListView r0) {
        return r0.mCurrPoint;
    }

    static /* synthetic */ float access$300(SlideExpandableListView r0) {
        return r0.mUpScrollStartY;
    }

    static /* synthetic */ float access$400(SlideExpandableListView r0) {
        return r0.mDownScrollStartY;
    }

    static /* synthetic */ void access$500(SlideExpandableListView r0, int r1) {
        r0.onMoving(r1);
    }

    static /* synthetic */ int access$600(SlideExpandableListView r0) {
        return r0.mCheckboxId;
    }

    public SlideExpandableListView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mIsChecked = false;
        this.mTempLoc = new int[2];
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.DEFAULT_PRE_POSITION = -2;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        init(r2, r3);
    }

    public SlideExpandableListView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mIsChecked = false;
        this.mTempLoc = new int[2];
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.DEFAULT_PRE_POSITION = -2;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        init(r3, r4);
    }

    public SlideExpandableListView(Context r2) {
        super(r2);
        this.mIsChecked = false;
        this.mTempLoc = new int[2];
        this.MISS = -1;
        this.SELECT = 1;
        this.SPECIAL = -2;
        this.mState = -1;
        this.DEFAULT_PRE_POSITION = -2;
        this.mPrePosition = -2;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
    }

    private void init(Context r3, AttributeSet r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SliderListView, 0, 0);
        if (r5 == null) goto L7;
        this.mCheckboxId = r5.getResourceId(0, 0);
        this.mSlideEnable = r5.getBoolean(1, false);
        r5.recycle();
    L7:
        this.mScroller = new SelectScroller(this, null);
        this.mPowerManager = (PowerManager) r3.getSystemService("power");
    }

    public void setTouchMonitorListener(TouchMonitorListener r1) {
        this.mTouchMonitorListener = r1;
    }

    public void setSlideListener(Listener r1) {
        this.mListener = r1;
    }

    public void setSlideEnable(boolean r1) {
        this.mSlideEnable = r1;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        if (this.mSlideEnable == false) goto L5;
        int r0 = startCheckPosition(r4);
        int r1 = r4.getActionMasked();
        if (r0 <= (-1)) goto L12;
        if (r1 != 0) goto L12;
        return true;
    L12:
        return super.onInterceptTouchEvent(r4);
    L5:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r9) {
        if (this.mSlideEnable == true) goto L7;
        return super.onTouchEvent(r9);
    L7:
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onTouchEvent   ev  " + r9.getX() + "   " + r9.getY());
    L9:
        int r0 = startCheckPosition(r9);
        if (ContactsUtils.DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onTouchEvent   position  " + r0);
    L12:
        int r1 = (int) r9.getX();
        int r2 = (int) r9.getY();
        this.mCurrPoint.set(r1, r2);
        int r3 = r9.getActionMasked();
        if (r3 == 0) goto L47;
        if (r3 == 1) goto L40;
        if (r3 != 2) goto L18;
        if (r0 == (-2)) goto L26;
        if (r0 == (-1)) goto L23;
    L25:
        boolean r4 = false;
    L27:
        int r5 = this.mState;
        if (r5 == 1) goto L32;
        if (r4 == true) goto L32;
        onDown(r0);
        return true;
    L32:
        if (r5 != 1) goto L35;
        if (r0 != (-2)) goto L35;
        return true;
    L35:
        if (r4 == true) goto L59;
        continueSelect(r1, r2, r0);
        return true;
    L59:
        return super.onTouchEvent(r9);
    L23:
        if (this.mState != (-1)) goto L25;
    L26:
        r4 = true;
        goto L27
    L18:
        if (r3 != 3) goto L59;
    L40:
        if (this.mTouchMonitorListener != null) goto L42;
    L46:
        recovery();
        goto L59
    L42:
        if (this.mState != 1) goto L44;
    L45:
        this.mTouchMonitorListener.onTouchActionUp();
        goto L46
    L44:
        if (pointToPosition(r1, r2) != pointToPosition(this.mDownPoint.x, this.mDownPoint.y)) goto L46;
    L47:
        this.mPrePosition = -2;
        if (ContactsUtils.DEBUG == false) goto L50;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "action down ............................................");
    L50:
        this.mDownPoint.set(r1, r2);
        if (r0 == (-2)) goto L59;
        if (r0 == (-1)) goto L54;
    L56:
        onDown(r0);
        return true;
    L54:
        if (this.mState != (-1)) goto L56;
        goto L56
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 == 0) goto L6;
        recovery();
        return;
    }

    private int startCheckPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mCheckboxId);
    }

    private void onDown(int r3) {
        Listener r0 = this.mListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 > (-1)) goto L7;
        return;
    L7:
        if (this.mPrePosition == r3) goto L13;
        this.mState = 1;
        this.mIsChecked = r0.isChecked(r3);
        onMoving(r3);
        return;
    }

    private void onMoving(int r8) {
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (r8 <= (-1)) goto L52;
        int r0 = this.mPrePosition;
        if (r0 != r8) goto L10;
        return;
    L10:
        if (this.mState == 1) goto L12;
    L41:
        pokeActivity();
        this.mPrePosition = r8;
        return;
    L12:
        if (r0 != (-2)) goto L18;
        if (ContactsUtils.DEBUG == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "mPrePosition == DEFAULT_PRE_POSITION  position  " + r8 + "  set to be " + (!this.mIsChecked));
    L16:
        this.mListener.setChecked(r8, !this.mIsChecked);
        goto L41
    L18:
        if (r0 <= r8) goto L30;
        int r1 = r0 - 1;
    L20:
        if (r1 < r8) goto L41;
        if (r1 < getFirstVisiblePosition()) goto L29;
        if (r1 > getLastVisiblePosition()) goto L29;
        if (ContactsUtils.DEBUG == false) goto L28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "mPrePosition > position position  " + r8 + "  set to be " + (!this.mIsChecked));
    L28:
        this.mListener.setChecked(r1, !this.mIsChecked);
    L29:
        r1 = r1 - 1;
        goto L20
    L30:
        int r2 = r0 + 1;
    L31:
        if (r2 > r8) goto L41;
        if (r2 < getFirstVisiblePosition()) goto L40;
        if (r2 > getLastVisiblePosition()) goto L40;
        if (ContactsUtils.DEBUG == false) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "mPrePosition > position position  " + r8 + "  set to be " + (!this.mIsChecked));
    L39:
        this.mListener.setChecked(r2, !this.mIsChecked);
    L40:
        r2 = r2 + 1;
        goto L31
    }

    private void pokeActivity() {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.mPrePokeTime) <= 12000) goto L6;
        this.mPowerManager.userActivity(r0, true);
        this.mPrePokeTime = r0;
        return;
    }

    private void recovery() {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "recovery()   mState  " + this.mState);
    L6:
        if (this.mState != (-1)) goto L8;
        return;
    L8:
        SelectScroller r0 = this.mScroller;
        if (r0 != null) goto L11;
    L13:
        this.mIsChecked = false;
        this.mState = -1;
        this.mPrePosition = -2;
        this.mStartX = 0;
        this.mEndX = 0;
        return;
    L11:
        if (r0.isScrolling() == false) goto L13;
        this.mScroller.stopScroll();
        goto L13
    }

    public boolean isSelecting() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private int viewIdHitPosition(MotionEvent r8, int r9) {
        int r0 = pointToPosition((int) r8.getX(), (int) r8.getY());
        int r1 = getHeaderViewsCount();
        int r2 = getFooterViewsCount();
        int r3 = getCount();
        if (r0 == (-1)) goto L42;
        if (r0 < r1) goto L42;
        if (r0 >= (r3 - r2)) goto L42;
        int r4 = (int) r8.getRawX();
        int r10 = (int) r8.getRawY();
        View r5 = getChildAt(r0 - getFirstVisiblePosition());
        View r6 = null;
        if (r5 == null) goto L13;
        if (r9 == 0) goto L13;
        r6 = r5.findViewById(r9);
    L13:
        if (r6 != null) goto L15;
    L33:
        if (r6 != null) goto L42;
        if (this.mState != 1) goto L42;
        if (r4 <= this.mStartX) goto L42;
        if (r4 >= this.mEndX) goto L42;
        return -2;
    L15:
        if (r6.getVisibility() != 0) goto L33;
        if (this.mState == 1) goto L19;
    L23:
        r6.getLocationOnScreen(this.mTempLoc);
        int[] r7 = this.mTempLoc;
        int r11 = r7[0];
        if (r4 <= r11) goto L42;
        if (r10 <= r7[1]) goto L42;
        if (r4 >= (r11 + r6.getWidth())) goto L42;
        if (r10 >= (this.mTempLoc[1] + r6.getHeight())) goto L42;
        int r12 = this.mTempLoc[0];
        this.mStartX = r12;
        this.mEndX = r12 + r6.getWidth();
        return r0;
    L19:
        if (r4 <= this.mStartX) goto L23;
        if (r4 >= this.mEndX) goto L23;
        return r0;
    L42:
        return -1;
    }

    private void initScrollData() {
        int r0 = getPaddingTop();
        float r1 = (getHeight() - r0) - getPaddingBottom();
        float r2 = r0;
        this.mUpScrollStartY = (this.mSelectUpScrollStartFrac * r1) + r2;
        this.mDownScrollStartY = r2 + ((1.0f - this.mSelectDownScrollStartFrac) * r1);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        initScrollData();
    }

    private void continueSelect(int r4, int r5, int r6) {
        int r7 = r5 - this.mDownPoint.y;
        float r8 = r5;
        float r0 = this.mDownScrollStartY;
        if (r8 <= r0) goto L7;
        if (r7 <= 0) goto L7;
        this.mScroller.startScroll(2);
        return;
    L7:
        float r1 = this.mUpScrollStartY;
        if (r8 >= r1) goto L13;
        if (r7 >= 0) goto L13;
        this.mScroller.startScroll(1);
        return;
    L13:
        if (r8 > r1) goto L15;
    L17:
        onMoving(r6);
        return;
    L15:
        if (r8 >= r0) goto L17;
        this.mScroller.stopScroll();
        goto L17
    }
}
