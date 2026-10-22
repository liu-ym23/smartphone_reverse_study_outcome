package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class PinnedHeaderListView extends RefreshLoadListView {
    private static final int MAX_ALPHA = 255;
    private PinnedHeaderAdapter mAdapter;
    private View mHeaderView;
    private int mHeaderViewHeight;
    private boolean mHeaderViewVisible;
    private int mHeaderViewWidth;

    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_DOWN = 3;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        void configurePinnedHeader(View r10, int r11, int r12);

        int getPinnedHeaderState(AbsListView r10, int r11);
    }

    public PinnedHeaderListView(Context r10) {
        super(r10);
    }

    public void configureHeaderView(int r10) {
        if (this.mHeaderView != null) goto L5;
        return;
    L5:
        int r11 = this.mAdapter.getPinnedHeaderState(this, r10);
        if (r11 == 0) goto L39;
        int r12 = 255;
        if (r11 != 1) goto L10;
        this.mAdapter.configurePinnedHeader(this.mHeaderView, r10, 255);
        if (this.mHeaderView.getTop() == 0) goto L38;
        this.mHeaderView.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
    L38:
        this.mHeaderViewVisible = true;
        return;
    L10:
        if (r11 != 2) goto L12;
        View r13 = getChildAt(0);
        int r14 = r13.getBottom() + 8;
        int r15 = r13.getBottom();
        int r16 = this.mHeaderView.getHeight();
        if (r14 >= r16) goto L28;
        int r17 = 0;
    L29:
        if (r15 >= r16) goto L31;
        r12 = 0;
    L31:
        this.mAdapter.configurePinnedHeader(this.mHeaderView, r10, r12);
        if (this.mHeaderView.getTop() == r17) goto L34;
        this.mHeaderView.layout(0, r17, this.mHeaderViewWidth, this.mHeaderViewHeight + r17);
    L34:
        this.mHeaderViewVisible = true;
        return;
    L28:
        r17 = r14 - r16;
        goto L29
    L12:
        if (r11 != 3) goto L44;
        View r18 = getChildAt(0);
        int r19 = r18.getBottom() + 8;
        int r20 = r18.getBottom();
        int r21 = this.mHeaderView.getHeight();
        if (r19 >= r21) goto L17;
        int r22 = r19 - r21;
    L18:
        if (r20 < r21) goto L21;
        r12 = 0;
    L21:
        this.mAdapter.configurePinnedHeader(this.mHeaderView, getFirstVisiblePosition(), r12);
        if (this.mHeaderView.getTop() == r22) goto L24;
        this.mHeaderView.layout(0, r22, this.mHeaderViewWidth, this.mHeaderViewHeight + r22);
    L24:
        this.mHeaderViewVisible = true;
        return;
    L17:
        r22 = 0;
        goto L18
    L44:
        return;
    L39:
        this.mHeaderViewVisible = false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        super.dispatchDraw(r10);
        if (this.mHeaderViewVisible == false) goto L6;
        drawChild(r10, this.mHeaderView, getDrawingTime());
        return;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        View r15 = this.mHeaderView;
        if (r15 == null) goto L6;
        r15.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
        configureHeaderView(getFirstVisiblePosition());
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        View r12 = this.mHeaderView;
        if (r12 == null) goto L6;
        measureChild(r12, r10, 0);
        this.mHeaderViewWidth = this.mHeaderView.getMeasuredWidth();
        this.mHeaderViewHeight = this.mHeaderView.getMeasuredHeight();
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.RefreshLoadListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r10) {
        setAdapter((ListAdapter) r10);
    }

    public void setPinnedHeaderView(View r10) {
        this.mHeaderView = r10;
        if (r10 == null) goto L5;
        setFadingEdgeLength(0);
    L5:
        requestLayout();
    }

    public PinnedHeaderListView(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    @Override // com.bytedanceos.common.ui.widget.RefreshLoadListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r10) {
        super.setAdapter(r10);
        this.mAdapter = (PinnedHeaderAdapter) r10;
    }

    public PinnedHeaderListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
