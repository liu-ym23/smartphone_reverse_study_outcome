package com.android.contacts.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.ListViewCollapseRunner;
import com.android.contacts.MultiDeleteAnimation;
import com.android.contacts.R;
import com.android.contacts.util.CubicInterpolator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandListView extends HorizontalScrollExpandableListView implements AbsListView.OnScrollListener, MultiDeleteAnimation.MultiDeleteAnimationOperator {
    private final int DEFAULT_PRE_POSITION;
    private final int MISS;
    private final int SELECT;
    private final int SPECIAL;
    private final float SPEED_CARDINAL;
    private int mCheckboxId;
    private ListViewCollapseRunner mCollapseRunner;
    private Point mCurrPoint;
    private Point mDownPoint;
    private float mDownScrollStartY;
    private int mEndX;
    private ExpandableListAdapter mExpandAdapter;
    private TextView mGroupIconText;
    public int mGroupIndex;
    private LinearLayout mGroupLayout;
    private TextView mGroupNameText;
    private boolean mIsChecked;
    private SlideListener mListener;
    private int mPrePosition;
    private float mScale;
    private AbsListView.OnScrollListener mScrollListener;
    private SelectScroller mScroller;
    private float mSelectDownScrollStartFrac;
    private float mSelectUpScrollStartFrac;
    private TextView mSizeText;
    private boolean mSlideEnable;
    private int mStartX;
    private int mState;
    private int[] mTempLoc;
    private TouchMonitorListener mTouchMonitorListener;
    private float mUpScrollStartY;

    private final class SelectScroller implements Runnable {
        public static final int DOWN = 2;
        public static final int UP = 1;
        private boolean mAbort;
        private long mCurrTime;
        private long mPrevTime;
        private int mScrollDir;
        private float mScrollSpeed;
        private boolean mScrolling;
        final /* synthetic */ ExpandListView this$0;

        private SelectScroller(ExpandListView r1) {
            this.this$0 = r1;
            this.mScrolling = false;
        }

        /* synthetic */ SelectScroller(ExpandListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void startScroll(int r3) {
            if (this.mScrolling == true) goto L6;
            this.mScrolling = true;
            this.mAbort = false;
            this.mScrollDir = r3;
            this.mPrevTime = SystemClock.uptimeMillis();
            this.this$0.post(this);
            return;
        }

        public void stopScroll() {
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
            if (ExpandListView.access$200(this.this$0).y < r3) goto L17;
            r3 = ExpandListView.access$200(this.this$0).y;
        L17:
            this.mScrollSpeed = (r3 - ExpandListView.access$300(this.this$0)) * 0.01f;
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
            if (ExpandListView.access$200(this.this$0).y > r9) goto L31;
            r9 = ExpandListView.access$200(this.this$0).y;
        L31:
            this.mScrollSpeed = (r9 - ExpandListView.access$400(this.this$0)) * 0.01f;
            goto L32
        L25:
            if (r8.getBottom() > (r4 + r3)) goto L27;
            goto L27
        }

        private void performSelectAction() {
            if (ExpandListView.access$200(this.this$0).y >= this.this$0.getPaddingTop()) goto L7;
            ExpandListView r3 = this.this$0;
            ExpandListView.access$500(r3, r3.getFirstVisiblePosition());
            return;
        L7:
            if (ExpandListView.access$200(this.this$0).y <= (this.this$0.getHeight() - this.this$0.getPaddingBottom())) goto L10;
            ExpandListView r4 = this.this$0;
            ExpandListView.access$500(r4, r4.getLastVisiblePosition());
            return;
        L10:
            ExpandListView r0 = this.this$0;
            int r1 = r0.pointToPosition(ExpandListView.access$200(r0).x, ExpandListView.access$200(this.this$0).y);
            ExpandListView r2 = this.this$0;
            View r5 = r2.getChildAt(r1 - r2.getFirstVisiblePosition());
            if (r5 != null) goto L13;
            return;
        L13:
            if (r5.findViewById(ExpandListView.access$600(this.this$0)) == null) goto L17;
            ExpandListView.access$500(this.this$0, r1);
            return;
        }
    }

    public interface SlideListener {
        boolean isChecked(int r1);

        void setChecked(int r1, boolean r2);
    }

    public interface TouchMonitorListener {
        void onTouchActionUp();
    }

    static /* synthetic */ LinearLayout access$000(ExpandListView r0) {
        return r0.mGroupLayout;
    }

    static /* synthetic */ Point access$200(ExpandListView r0) {
        return r0.mCurrPoint;
    }

    static /* synthetic */ float access$300(ExpandListView r0) {
        return r0.mUpScrollStartY;
    }

    static /* synthetic */ float access$400(ExpandListView r0) {
        return r0.mDownScrollStartY;
    }

    static /* synthetic */ void access$500(ExpandListView r0, int r1) {
        r0.onMoving(r1);
    }

    static /* synthetic */ int access$600(ExpandListView r0) {
        return r0.mCheckboxId;
    }

    @Override // android.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter r1) {
        super.setAdapter(r1);
        this.mExpandAdapter = r1;
    }

    public ExpandListView(Context r2) {
        this(r2, null);
    }

    public ExpandListView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mGroupIndex = -1;
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
        super.setOnScrollListener(this);
        this.mScale = r3.getResources().getDimension(R.dimen.scale);
        init(r3, r4);
    }

    public ExpandListView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mGroupIndex = -1;
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
        super.setOnScrollListener(this);
        init(r2, r3);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        this.mScrollListener = r1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r9, int r10, int r11, int r12) {
        if (this.mExpandAdapter != null) goto L5;
        this.mExpandAdapter = getExpandableListAdapter();
    L5:
        AbsListView.OnScrollListener r0 = this.mScrollListener;
        if (r0 == null) goto L8;
        r0.onScroll(r9, r10, r11, r12);
    L8:
        int r13 = r9.pointToPosition(0, 0);
        if (this.mScale != 1.5d) goto L11;
        int r1 = r9.pointToPosition(0, 136);
    L13:
        if (r13 == (-1)) goto L64;
        ExpandListView r14 = (ExpandListView) r9;
        long r2 = r14.getExpandableListPosition(r13);
        long r4 = r14.getExpandableListPosition(r1);
        int r15 = getPackedPositionGroup(r2);
        int r16 = getPackedPositionChild(r2);
        Rect r3 = new Rect();
        getChildAt(0).getGlobalVisibleRect(r3);
        if (r15 == 0) goto L17;
    L21:
        boolean r5 = false;
    L23:
        if (r10 == 0) goto L25;
    L31:
        if (r16 >= 0) goto L39;
        if (isGroupExpanded(r15) == true) goto L39;
        this.mGroupIndex = -1;
        LinearLayout r17 = this.mGroupLayout;
        if (r17 == null) goto L37;
        r17.setVisibility(4);
    L37:
        r15 = -1;
    L39:
        if (r15 == this.mGroupIndex) goto L52;
        this.mGroupIndex = r15;
        final FrameLayout r18 = (FrameLayout) getParent();
        ExpandAdapter r19 = (ExpandAdapter) getExpandableListAdapter();
        List<SamContact> r6 = r19.getGroup(this.mGroupIndex);
        String r110 = r19.getHeaderData(this.mGroupIndex);
        if (r18.getChildCount() != 1) goto L47;
        LinearLayout r7 = (LinearLayout) inflate(getContext(), R.layout.contact_group_tag, null);
        this.mGroupLayout = r7;
        TextView r8 = (TextView) r7.findViewById(R.id.group_count);
        this.mSizeText = r8;
        if (r6 != null) goto L45;
        int r20 = 0;
    L46:
        r8.setText(String.valueOf(r20));
        TextView r21 = (TextView) this.mGroupLayout.findViewById(R.id.group_name);
        this.mGroupNameText = r21;
        r21.setText(r110);
        TextView r111 = (TextView) this.mGroupLayout.findViewById(R.id.icon);
        this.mGroupIconText = r111;
        r111.setBackgroundResource(R.drawable.location_unfold);
        this.mGroupLayout.setOnClickListener(new AnonymousClass1(this));
        new Handler().post(new AnonymousClass2(this, r18));
        goto L52
    L45:
        r20 = r6.size();
        goto L46
    L47:
        TextView r112 = this.mSizeText;
        if (r6 != null) goto L50;
        int r22 = 0;
    L51:
        r112.setText(String.valueOf(r22));
        this.mGroupNameText.setText(r110);
        this.mGroupLayout.setOnClickListener(new AnonymousClass3(this));
        this.mGroupLayout.setVisibility(0);
        goto L52
    L50:
        r22 = r6.size();
    L52:
        LinearLayout r113 = this.mGroupLayout;
        if (r113 != null) goto L55;
        return;
    L55:
        if (r113.getVisibility() != 0) goto L66;
        int r114 = getPackedPositionGroup(r4);
        if (r114 == (-1)) goto L62;
        if (r114 == r15) goto L62;
        Rect r23 = new Rect();
        if (getChildAt(0) == null) goto L67;
        getChildAt(0).getGlobalVisibleRect(r23);
        this.mGroupLayout.setY(r23.bottom - (this.mScale * 340.0f));
        this.mGroupLayout.findViewById(R.id.header_diver).setVisibility(4);
        return;
    L67:
        return;
    L62:
        this.mGroupLayout.setY(0.0f);
        this.mGroupLayout.findViewById(R.id.header_diver).setVisibility(0);
        return;
    L66:
        return;
    L25:
        if (r3.bottom < 338) goto L31;
        if (r5 == true) goto L31;
        this.mGroupIndex = -1;
        LinearLayout r24 = this.mGroupLayout;
        if (r24 == null) goto L30;
        r24.setVisibility(4);
    L30:
        r15 = -1;
        goto L31
    L17:
        if (isGroupExpanded(r15) == false) goto L21;
        if (r3.bottom >= 509) goto L21;
        r5 = true;
        goto L23
    L64:
        return;
    L11:
        r1 = r9.pointToPosition(0, 93);
        goto L13
    }

    @Override // android.widget.AbsListView, android.view.View
    protected void onOverScrolled(int r1, int r2, boolean r3, boolean r4) {
        super.onOverScrolled(r1, r2, r3, r4);
        if (r2 >= 0) goto L8;
        this.mGroupIndex = -1;
        LinearLayout r0 = this.mGroupLayout;
        if (r0 == null) goto L9;
        r0.setVisibility(4);
        return;
    L9:
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        AbsListView.OnScrollListener r0 = this.mScrollListener;
        if (r0 == null) goto L6;
        r0.onScrollStateChanged(r1, r2);
        return;
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
    }

    public void setTouchMonitorListener(TouchMonitorListener r1) {
        this.mTouchMonitorListener = r1;
    }

    public void setSlideListener(SlideListener r1) {
        this.mListener = r1;
    }

    public void setSlideEnable(boolean r1) {
        this.mSlideEnable = r1;
    }

    @Override // com.android.contacts.list.HorizontalScrollExpandableListView, android.widget.AbsListView, android.view.ViewGroup
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

    @Override // com.android.contacts.list.HorizontalScrollExpandableListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r9) {
        if (this.mSlideEnable == false) goto L5;
        int r0 = startCheckPosition(r9);
        int r1 = (int) r9.getX();
        int r2 = (int) r9.getY();
        this.mCurrPoint.set(r1, r2);
        int r3 = r9.getActionMasked();
        if (r3 == 0) goto L36;
        if (r3 != 1) goto L10;
    L33:
        recovery();
        TouchMonitorListener r4 = this.mTouchMonitorListener;
        if (r4 == null) goto L45;
        r4.onTouchActionUp();
    L45:
        return super.onTouchEvent(r9);
    L10:
        if (r3 != 2) goto L12;
        if (r0 == (-2)) goto L20;
        if (r0 == (-1)) goto L17;
    L19:
        boolean r5 = false;
    L21:
        int r6 = this.mState;
        if (r6 == 1) goto L26;
        if (r5 == true) goto L26;
        onDown(r0);
        return true;
    L26:
        if (r6 != 1) goto L29;
        if (r0 != (-2)) goto L29;
        return true;
    L29:
        if (r5 == true) goto L45;
        continueSelect(r1, r2, r0);
        return true;
    L17:
        if (this.mState != (-1)) goto L19;
    L20:
        r5 = true;
        goto L21
    L12:
        if (r3 == 3) goto L33;
    L36:
        this.mDownPoint.set(r1, r2);
        if (r0 == (-2)) goto L45;
        if (r0 == (-1)) goto L40;
    L42:
        onDown(r0);
        return true;
    L40:
        if (this.mState != (-1)) goto L42;
    L5:
        return super.onTouchEvent(r9);
    }

    private int startCheckPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mCheckboxId);
    }

    private void onDown(int r3) {
        SlideListener r0 = this.mListener;
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

    private void onMoving(int r3) {
        SlideListener r0 = this.mListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 > (-1)) goto L7;
        return;
    L7:
        if (this.mPrePosition == r3) goto L13;
        this.mPrePosition = r3;
        r0.setChecked(r3, !this.mIsChecked);
        return;
    }

    private void recovery() {
        if (this.mState != (-1)) goto L6;
        return;
    L6:
        if (this.mScroller.isScrolling() == false) goto L8;
        this.mScroller.stopScroll();
    L8:
        this.mIsChecked = false;
        this.mState = -1;
        this.mPrePosition = -2;
        this.mStartX = 0;
        this.mEndX = 0;
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
        if (r0 == (-1)) goto L41;
        if (r0 < r1) goto L41;
        if (r0 >= (r3 - r2)) goto L41;
        int r4 = (int) r8.getRawX();
        int r10 = (int) r8.getRawY();
        View r5 = getChildAt(r0 - getFirstVisiblePosition());
        if (r9 != 0) goto L10;
        View r11 = null;
    L12:
        if (r11 != null) goto L14;
    L32:
        if (r11 != null) goto L41;
        if (this.mState != 1) goto L41;
        if (r4 <= this.mStartX) goto L41;
        if (r4 >= this.mEndX) goto L41;
        return -2;
    L14:
        if (r11.getVisibility() != 0) goto L32;
        if (this.mState == 1) goto L18;
    L22:
        r11.getLocationOnScreen(this.mTempLoc);
        int[] r6 = this.mTempLoc;
        int r7 = r6[0];
        if (r4 <= r7) goto L41;
        if (r10 <= r6[1]) goto L41;
        if (r4 >= (r7 + r11.getWidth())) goto L41;
        if (r10 >= (this.mTempLoc[1] + r11.getHeight())) goto L41;
        int r12 = this.mTempLoc[0];
        this.mStartX = r12;
        this.mEndX = r12 + r11.getWidth();
        return r0;
    L18:
        if (r4 <= this.mStartX) goto L22;
        if (r4 >= this.mEndX) goto L22;
        return r0;
    L10:
        r11 = r5.findViewById(r9);
    L41:
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

    public void refreshPinnedView() {
        ExpandAdapter r0 = (ExpandAdapter) getExpandableListAdapter();
        List<SamContact> r1 = r0.getGroup(this.mGroupIndex);
        TextView r2 = this.mSizeText;
        if (r2 == null) goto L7;
        if (r1 == null) goto L7;
        r2.setText(String.valueOf(r1.size()));
    L7:
        if (this.mGroupLayout != null) goto L9;
        return;
    L9:
        if (r0.getGroupCount() != 0) goto L13;
        this.mGroupLayout.setVisibility(8);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas r3) {
        ListViewCollapseRunner r0 = this.mCollapseRunner;
        if (r0 == null) goto L7;
        boolean r1 = r0.compute();
        this.mCollapseRunner.draw(r3);
        invalidate();
        if (r1 == false) goto L9;
        this.mCollapseRunner = null;
        return;
    L9:
        return;
    L7:
        super.draw(r3);
    }

    @Override // com.android.contacts.MultiDeleteAnimation.MultiDeleteAnimationOperator
    public void startDeleteAnimations(List<Integer> r2, Animation.AnimationListener r3) {
        ListViewCollapseRunner r0 = new ListViewCollapseRunner(this, r2, r3);
        this.mCollapseRunner = r0;
        r0.setInterpolator(CubicInterpolator.OUT);
        this.mCollapseRunner.start();
        invalidate();
    }
}
