package com.android.contacts.common.list;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.android.contacts.common.util.ViewUtil;

/* JADX INFO: loaded from: classes.dex */
public class PinnedHeaderListView extends AutoScrollListView implements AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener {
    private static final int BOTTOM = 1;
    private static final int DEFAULT_ANIMATION_DURATION = 20;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 100;
    private static final int FADING = 2;
    private static final int MAX_ALPHA = 255;
    private static final int TOP = 0;
    private PinnedHeaderAdapter mAdapter;
    private boolean mAnimating;
    private int mAnimationDuration;
    private long mAnimationTargetTime;
    private RectF mBounds;
    private int mHeaderPaddingStart;
    private boolean mHeaderTouched;
    private int mHeaderWidth;
    private PinnedHeader[] mHeaders;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mScrollState;
    private boolean mScrollToSectionOnHeaderTouch;
    private int mSize;

    /* JADX INFO: renamed from: com.android.contacts.common.list.PinnedHeaderListView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class PinnedHeader {
        int alpha;
        boolean animating;
        int height;
        int sourceY;
        int state;
        long targetTime;
        boolean targetVisible;
        int targetY;
        View view;
        boolean visible;
        int y;

        private PinnedHeader() {
        }

        /* synthetic */ PinnedHeader(AnonymousClass1 r1) {
            this();
        }
    }

    public interface PinnedHeaderAdapter {
        void configurePinnedHeaders(PinnedHeaderListView r1);

        int getPinnedHeaderCount();

        View getPinnedHeaderView(int r1, View r2, ViewGroup r3);

        int getScrollPositionForHeader(int r1);
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    public PinnedHeaderListView(Context r3) {
        this(r3, null, R.attr.listViewStyle);
    }

    public PinnedHeaderListView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.listViewStyle);
    }

    public PinnedHeaderListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mBounds = new RectF();
        this.mScrollToSectionOnHeaderTouch = false;
        this.mHeaderTouched = false;
        this.mAnimationDuration = 20;
        super.setOnScrollListener(this);
        super.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = getPaddingStart();
        this.mHeaderPaddingStart = r6;
        this.mHeaderWidth = ((r4 - r2) - r6) - getPaddingEnd();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r2) {
        this.mAdapter = (PinnedHeaderAdapter) r2;
        super.setAdapter(r2);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        this.mOnScrollListener = r1;
        super.setOnScrollListener(this);
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener r1) {
        this.mOnItemSelectedListener = r1;
        super.setOnItemSelectedListener(this);
    }

    public void setScrollToSectionOnHeaderTouch(boolean r1) {
        this.mScrollToSectionOnHeaderTouch = r1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r5, int r6, int r7, int r8) {
        PinnedHeaderAdapter r9 = this.mAdapter;
        if (r9 == null) goto L19;
        int r10 = r9.getPinnedHeaderCount();
        int r1 = 0;
        if (r10 == this.mSize) goto L13;
        this.mSize = r10;
        PinnedHeader[] r0 = this.mHeaders;
        if (r0 != null) goto L10;
        this.mHeaders = new PinnedHeader[r10];
        goto L13
    L10:
        if (r0.length >= r10) goto L13;
        PinnedHeader[] r11 = new PinnedHeader[r10];
        this.mHeaders = r11;
        System.arraycopy(r0, 0, r11, 0, r0.length);
    L13:
        if (r1 >= this.mSize) goto L18;
        PinnedHeader[] r12 = this.mHeaders;
        if (r12[r1] != null) goto L17;
        r12[r1] = new PinnedHeader(null);
    L17:
        PinnedHeader r13 = this.mHeaders[r1];
        r13.view = this.mAdapter.getPinnedHeaderView(r1, r13.view, this);
        r1 = r1 + 1;
        goto L13
    L18:
        this.mAnimationTargetTime = System.currentTimeMillis() + ((long) this.mAnimationDuration);
        this.mAdapter.configurePinnedHeaders(this);
        invalidateIfAnimating();
    L19:
        AbsListView.OnScrollListener r14 = this.mOnScrollListener;
        if (r14 == null) goto L27;
        r14.onScroll(this, r6, r7, r8);
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.mSize <= 0) goto L6;
        return 0.0f;
    L6:
        return super.getTopFadingEdgeStrength();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
        this.mScrollState = r2;
        AbsListView.OnScrollListener r3 = this.mOnScrollListener;
        if (r3 == null) goto L6;
        r3.onScrollStateChanged(this, r2);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r8, View r9, int r10, long r11) {
        int r0 = getHeight();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mSize) goto L14;
        PinnedHeader r3 = this.mHeaders[r1];
        if (r3.visible == false) goto L13;
        if (r3.state != 0) goto L11;
        r2 = r3.y + r3.height;
        goto L13
    L11:
        if (r3.state != 1) goto L13;
        r0 = r3.y;
    L13:
        r1 = r1 + 1;
    L14:
        View r4 = getSelectedView();
        if (r4 != null) goto L17;
    L22:
        AdapterView.OnItemSelectedListener r5 = this.mOnItemSelectedListener;
        if (r5 == null) goto L31;
        r5.onItemSelected(r8, r9, r10, r11);
        return;
    L31:
        return;
    L17:
        if (r4.getTop() >= r2) goto L20;
        setSelectionFromTop(r10, r2);
        goto L22
    L20:
        if (r4.getBottom() <= r0) goto L22;
        setSelectionFromTop(r10, r0 - r4.getHeight());
        goto L22
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
        AdapterView.OnItemSelectedListener r0 = this.mOnItemSelectedListener;
        if (r0 == null) goto L6;
        r0.onNothingSelected(r1);
        return;
    }

    public int getPinnedHeaderHeight(int r1) {
        ensurePinnedHeaderLayout(r1);
        return this.mHeaders[r1].view.getHeight();
    }

    public void setHeaderPinnedAtTop(int r1, int r2, boolean r3) {
        ensurePinnedHeaderLayout(r1);
        PinnedHeader r0 = this.mHeaders[r1];
        r0.visible = true;
        r0.y = r2;
        r0.state = 0;
        r0.animating = false;
    }

    public void setHeaderPinnedAtBottom(int r3, int r4, boolean r5) {
        ensurePinnedHeaderLayout(r3);
        PinnedHeader r6 = this.mHeaders[r3];
        r6.state = 1;
        if (r6.animating == false) goto L5;
        r6.targetTime = this.mAnimationTargetTime;
        r6.sourceY = r6.y;
        r6.targetY = r4;
        return;
    L5:
        if (r5 == true) goto L7;
    L15:
        r6.visible = true;
        r6.y = r4;
        return;
    L7:
        if (r6.y != r4) goto L11;
        if (r6.visible == true) goto L15;
    L11:
        if (r6.visible == false) goto L13;
        r6.sourceY = r6.y;
    L14:
        r6.animating = true;
        r6.targetVisible = true;
        r6.targetTime = this.mAnimationTargetTime;
        r6.targetY = r4;
        return;
    L13:
        r6.visible = true;
        r6.sourceY = r6.height + r4;
        goto L14
    }

    public void setFadingHeader(int r3, int r4, boolean r5) {
        ensurePinnedHeaderLayout(r3);
        View r6 = getChildAt(r4 - getFirstVisiblePosition());
        if (r6 != null) goto L5;
        return;
    L5:
        PinnedHeader r7 = this.mHeaders[r3];
        r7.visible = true;
        r7.state = 2;
        r7.alpha = 255;
        r7.animating = false;
        int r2 = getTotalTopPinnedHeaderHeight();
        r7.y = r2;
        if (r5 == false) goto L11;
        int r8 = r6.getBottom() - r2;
        int r9 = r7.height;
        if (r8 >= r9) goto L12;
        int r10 = r8 - r9;
        r7.alpha = ((r9 + r10) * 255) / r9;
        r7.y = r2 + r10;
        return;
    L12:
        return;
    }

    public void setHeaderInvisible(int r5, boolean r6) {
        PinnedHeader r7 = this.mHeaders[r5];
        if (r7.visible == false) goto L13;
        if (r6 == true) goto L8;
        if (r7.animating == false) goto L13;
    L8:
        if (r7.state != 1) goto L13;
        r7.sourceY = r7.y;
        if (r7.animating == true) goto L12;
        r7.visible = true;
        r7.targetY = getBottom() + r7.height;
    L12:
        r7.animating = true;
        r7.targetTime = this.mAnimationTargetTime;
        r7.targetVisible = false;
        return;
    L13:
        r7.visible = false;
    }

    private void ensurePinnedHeaderLayout(int r7) {
        View r0 = this.mHeaders[r7].view;
        if (r0.isLayoutRequested() == false) goto L18;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 != null) goto L7;
    L9:
        int r3 = View.MeasureSpec.makeMeasureSpec(this.mHeaderWidth, 1073741824);
    L11:
        if (r1 != null) goto L13;
    L15:
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L16:
        r0.measure(r3, r2);
        int r4 = r0.getMeasuredHeight();
        this.mHeaders[r7].height = r4;
        r0.layout(0, 0, r0.getMeasuredWidth(), r4);
        return;
    L13:
        if (r1.height <= 0) goto L15;
        r2 = View.MeasureSpec.makeMeasureSpec(r1.height, 1073741824);
        goto L16
    L7:
        if (r1.width <= 0) goto L9;
        r3 = View.MeasureSpec.makeMeasureSpec(r1.width, 1073741824);
        goto L11
    }

    public int getTotalTopPinnedHeaderHeight() {
        int r0 = this.mSize;
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L11;
        PinnedHeader r1 = this.mHeaders[r0];
        if (r1.visible == false) goto L3;
        if (r1.state != 0) goto L3;
        return r1.y + r1.height;
    L11:
        return 0;
    }

    public int getPositionAt(int r3) {
    L2:
        int r0 = pointToPosition(getPaddingLeft() + 1, r3);
        if (r0 != (-1)) goto L4;
        r3 = r3 - 1;
        if (r3 > 0) goto L2;
        return 0;
    L4:
        return r0;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        this.mHeaderTouched = false;
        if (super.onInterceptTouchEvent(r10) == false) goto L6;
        return true;
    L6:
        if (this.mScrollState != 0) goto L26;
        int r1 = (int) r10.getY();
        int r3 = (int) r10.getX();
        int r4 = this.mSize;
    L8:
        r4 = r4 - 1;
        if (r4 < 0) goto L26;
        PinnedHeader r5 = this.mHeaders[r4];
        int r6 = getPaddingLeft();
        if (r5.visible == false) goto L8;
        if (r5.y > r1) goto L8;
        if ((r5.y + r5.height) <= r1) goto L8;
        if (r3 < r6) goto L8;
        if ((r6 + r5.view.getWidth()) < r3) goto L8;
        this.mHeaderTouched = true;
        if (this.mScrollToSectionOnHeaderTouch == true) goto L22;
    L25:
        return true;
    L22:
        if (r10.getAction() != 0) goto L25;
        return smoothScrollToPartition(r4);
    L26:
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.mHeaderTouched == false) goto L9;
        if (r2.getAction() != 1) goto L7;
        this.mHeaderTouched = false;
    L7:
        return true;
    L9:
        return super.onTouchEvent(r2);
    }

    private boolean smoothScrollToPartition(int r6) {
        PinnedHeaderAdapter r0 = this.mAdapter;
        int r1 = 0;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.getScrollPositionForHeader(r6);
        if (r2 != (-1)) goto L8;
        return false;
    L8:
        int r3 = 0;
    L9:
        if (r1 >= r6) goto L14;
        PinnedHeader r4 = this.mHeaders[r1];
        if (r4.visible == false) goto L13;
        r3 = r3 + r4.height;
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        smoothScrollToPositionFromTop(r2 + getHeaderViewsCount(), r3, 100);
        return true;
    }

    private void invalidateIfAnimating() {
        int r0 = 0;
        this.mAnimating = false;
    L4:
        if (r0 >= this.mSize) goto L10;
        if (this.mHeaders[r0].animating == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        this.mAnimating = true;
        invalidate();
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r12) {
        if (this.mAnimating == false) goto L5;
        long r0 = System.currentTimeMillis();
    L6:
        int r2 = getBottom();
        int r3 = 0;
        int r4 = 0;
        boolean r5 = false;
        int r6 = 0;
    L8:
        if (r4 >= this.mSize) goto L25;
        PinnedHeader r7 = this.mHeaders[r4];
        if (r7.visible == false) goto L24;
        if (r7.state != 1) goto L17;
        if (r7.y >= r2) goto L17;
        r2 = r7.y;
    L23:
        r5 = true;
    L17:
        if (r7.state != 0) goto L19;
    L20:
        int r8 = r7.y + r7.height;
        if (r8 <= r6) goto L23;
        r6 = r8;
        goto L23
    L19:
        if (r7.state != 2) goto L23;
    L24:
        r4 = r4 + 1;
        goto L8
    L25:
        if (r5 == false) goto L27;
        r12.save();
    L27:
        super.dispatchDraw(r12);
        if (r5 == false) goto L57;
        r12.restore();
        if (this.mSize > 0) goto L32;
    L39:
        int r9 = this.mSize;
    L40:
        r9 = r9 - 1;
        if (r9 < 0) goto L50;
        PinnedHeader r10 = this.mHeaders[r9];
        if (r10.visible == false) goto L40;
        if (r10.state == 0) goto L48;
        if (r10.state != 2) goto L40;
    L48:
        drawHeader(r12, r10, r0);
    L50:
        if (r3 >= this.mSize) goto L57;
        PinnedHeader r11 = this.mHeaders[r3];
        if (r11.visible == false) goto L56;
        if (r11.state != 1) goto L56;
        drawHeader(r12, r11, r0);
    L56:
        r3 = r3 + 1;
        goto L50
    L32:
        if (getFirstVisiblePosition() != 0) goto L39;
        View r13 = getChildAt(0);
        PinnedHeader r14 = this.mHeaders[0];
        if (r14 == null) goto L39;
        if (r13 == null) goto L37;
        int r15 = r13.getTop();
    L38:
        r14.y = Math.max(r14.y, r15);
        goto L39
    L37:
        r15 = 0;
    L57:
        invalidateIfAnimating();
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void drawHeader(Canvas r5, PinnedHeader r6, long r7) {
        if (r6.animating == false) goto L9;
        int r8 = (int) (r6.targetTime - r7);
        if (r8 > 0) goto L7;
        r6.y = r6.targetY;
        r6.visible = r6.targetVisible;
        r6.animating = false;
        goto L9
    L7:
        r6.y = r6.targetY + (((r6.sourceY - r6.targetY) * r8) / this.mAnimationDuration);
    L9:
        if (r6.visible == false) goto L19;
        View r9 = r6.view;
        int r10 = r5.save();
        if (ViewUtil.isViewLayoutRtl(this) == false) goto L13;
        int r0 = (getWidth() - this.mHeaderPaddingStart) - r9.getWidth();
    L14:
        r5.translate(r0, r6.y);
        if (r6.state != 2) goto L17;
        this.mBounds.set(0.0f, 0.0f, r9.getWidth(), r9.getHeight());
        r5.saveLayerAlpha(this.mBounds, r6.alpha, 31);
    L17:
        r9.draw(r5);
        r5.restoreToCount(r10);
        return;
    L13:
        r0 = this.mHeaderPaddingStart;
        goto L14
    }
}
