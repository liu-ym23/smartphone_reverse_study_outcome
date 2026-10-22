package com.alibaba.android.vlayout;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutManagerHelper {
    void addBackgroundView(View r10, boolean r11);

    void addChildView(View r10, int r11);

    void addChildView(VirtualLayoutManager.LayoutStateWrapper r10, View r11);

    void addChildView(VirtualLayoutManager.LayoutStateWrapper r10, View r11, int r12);

    void addFixedView(View r10);

    void addOffFlowView(View r10, boolean r11);

    int findFirstVisibleItemPosition();

    int findLastVisibleItemPosition();

    LayoutHelper findLayoutHelperByPosition(int r10);

    @Nullable
    View findViewByPosition(int r10);

    View generateLayoutView();

    @Nullable
    View getChildAt(int r10);

    int getChildCount();

    int getChildMeasureSpec(int r10, int r11, boolean r12);

    RecyclerView.ViewHolder getChildViewHolder(View r10);

    int getContentHeight();

    int getContentWidth();

    int getDecoratedBottom(View r10);

    int getDecoratedLeft(View r10);

    int getDecoratedRight(View r10);

    int getDecoratedTop(View r10);

    OrientationHelperEx getMainOrientationHelper();

    int getOrientation();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    int getPosition(View r10);

    RecyclerView getRecyclerView();

    boolean getReverseLayout();

    OrientationHelperEx getSecondaryOrientationHelper();

    void hideView(View r10);

    boolean isDoLayoutRTL();

    boolean isEnableMarginOverLap();

    boolean isViewHolderUpdated(View r10);

    void layoutChild(View r10, int r11, int r12, int r13, int r14);

    void layoutChildWithMargins(View r10, int r11, int r12, int r13, int r14);

    void measureChild(View r10, int r11, int r12);

    void measureChildWithMargins(View r10, int r11, int r12);

    void recycleView(View r10);

    void removeChildView(View r10);

    void showView(View r10);
}
