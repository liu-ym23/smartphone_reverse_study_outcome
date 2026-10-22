package com.android.contacts.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class PinnedHeaderListView extends ListView implements AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener {
    private static final int BOTTOM = 1;
    private static final int DEFAULT_ANIMATION_DURATION = 100;
    private static final int FADING = 2;
    private static final int MAX_ALPHA = 255;
    private static final int TOP = 0;
    private PinnedHeaderAdapter mAdapter;
    private boolean mAnimating;
    private int mAnimationDuration;
    private long mAnimationTargetTime;
    private RectF mBounds;
    private Rect mClipRect;
    private int mHeaderPaddingLeft;
    private int mHeaderWidth;
    private PinnedHeader[] mHeaders;
    private SectionIndexer mIndexer;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mScrollState;
    private int mSize;

    /* JADX INFO: renamed from: com.android.contacts.widget.PinnedHeaderListView$1, reason: invalid class name */
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

        SectionIndexer getIndexer();

        int getPinnedHeaderCount();

        View getPinnedHeaderView(int r1, View r2, ViewGroup r3);

        int getScrollPositionForHeader(int r1);

        void setIndexer1(SectionIndexer r1);
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
        this.mClipRect = new Rect();
        this.mAnimationDuration = 100;
        super.setOnScrollListener(this);
        super.setOnItemSelectedListener(this);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = getPaddingLeft();
        this.mHeaderPaddingLeft = r6;
        this.mHeaderWidth = ((r4 - r2) - r6) - getPaddingRight();
    }

    public void setPinnedHeaderAnimationDuration(int r1) {
        this.mAnimationDuration = r1;
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

    public void setIndexer1(SectionIndexer r1) {
        this.mIndexer = r1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r5, int r6, int r7, int r8) {
        PinnedHeaderAdapter r9 = this.mAdapter;
        if (r9 == null) goto L23;
        int r10 = r9.getPinnedHeaderCount();
        int r1 = 0;
        if (r10 == this.mSize) goto L17;
        this.mSize = r10;
        int r11 = 0;
    L7:
        int r0 = this.mSize;
        if (r11 >= r0) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        PinnedHeader[] r12 = this.mHeaders;
        if (r12 != null) goto L14;
        this.mHeaders = new PinnedHeader[r0];
        goto L17
    L14:
        if (r12.length >= r0) goto L17;
        PinnedHeader[] r2 = new PinnedHeader[r0];
        this.mHeaders = r2;
        System.arraycopy(r12, 0, r2, 0, r12.length);
    L17:
        if (r1 >= this.mSize) goto L22;
        PinnedHeader[] r13 = this.mHeaders;
        if (r13[r1] != null) goto L21;
        r13[r1] = new PinnedHeader(null);
    L21:
        PinnedHeader r14 = this.mHeaders[r1];
        r14.view = this.mAdapter.getPinnedHeaderView(r1, r14.view, this);
        r1 = r1 + 1;
        goto L17
    L22:
        this.mAnimationTargetTime = System.currentTimeMillis() + ((long) this.mAnimationDuration);
        this.mAdapter.configurePinnedHeaders(this);
        invalidateIfAnimating();
    L23:
        AbsListView.OnScrollListener r15 = this.mOnScrollListener;
        if (r15 == null) goto L32;
        r15.onScroll(this, r6, r7, r8);
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
        if (r0.isLayoutRequested() == false) goto L12;
        int r1 = View.MeasureSpec.makeMeasureSpec(this.mHeaderWidth, 1073741824);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        if (r3 != null) goto L7;
    L9:
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L10:
        r0.measure(r1, r2);
        int r4 = r0.getMeasuredHeight();
        this.mHeaders[r7].height = r4;
        r0.layout(0, 0, this.mHeaderWidth, r4);
        return;
    L7:
        if (r3.height <= 0) goto L9;
        r2 = View.MeasureSpec.makeMeasureSpec(r3.height, 1073741824);
        goto L10
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
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.mScrollState != 0) goto L20;
        int r0 = (int) r5.getY();
        int r1 = this.mSize;
    L5:
        r1 = r1 - 1;
        if (r1 < 0) goto L20;
        PinnedHeader r2 = this.mHeaders[r1];
        if (r2.visible == false) goto L5;
        if (r2.y > r0) goto L5;
        if ((r2.y + r2.height) <= r0) goto L5;
        if (r5.getAction() == 0) goto L16;
        return true;
    L16:
        return smoothScrollToPartition(r1);
    L20:
        return super.onInterceptTouchEvent(r5);
    }

    private boolean smoothScrollToPartition(int r6) {
        int r0 = this.mAdapter.getScrollPositionForHeader(r6);
        int r2 = 0;
        if (r0 != (-1)) goto L5;
        return false;
    L5:
        this.mAdapter.getIndexer();
        int r1 = 0;
    L6:
        if (r2 >= r6) goto L11;
        PinnedHeader r3 = this.mHeaders[r2];
        if (r3.visible == false) goto L10;
        r1 = r1 + r3.height;
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        smoothScrollToPositionFromTop(r0 + getHeaderViewsCount(), r1);
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
        this.mClipRect.set(0, r6, getWidth(), r2);
        r12.clipRect(this.mClipRect);
    L27:
        super.dispatchDraw(r12);
        if (r5 == false) goto L47;
        r12.restore();
        int r9 = this.mSize;
    L30:
        r9 = r9 - 1;
        if (r9 < 0) goto L40;
        PinnedHeader r10 = this.mHeaders[r9];
        if (r10.visible == false) goto L30;
        if (r10.state == 0) goto L38;
        if (r10.state != 2) goto L30;
    L38:
        drawHeader(r12, r10, r0);
    L40:
        if (r3 >= this.mSize) goto L47;
        PinnedHeader r11 = this.mHeaders[r3];
        if (r11.visible == false) goto L46;
        if (r11.state != 1) goto L46;
        drawHeader(r12, r11, r0);
    L46:
        r3 = r3 + 1;
    L47:
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
        if (r6.visible == false) goto L17;
        View r9 = r6.view;
        int r10 = r5.save();
        r5.translate(this.mHeaderPaddingLeft, r6.y);
        if (r6.state == 2) goto L13;
    L15:
        r9.draw(r5);
        r5.restoreToCount(r10);
        return;
    L13:
        if (r6.alpha == 255) goto L15;
        this.mBounds.set(0.0f, 0.0f, this.mHeaderWidth, r9.getHeight());
        r5.saveLayerAlpha(this.mBounds, r6.alpha, 31);
        goto L15
    }
}
