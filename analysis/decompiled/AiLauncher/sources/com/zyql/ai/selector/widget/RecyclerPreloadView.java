package com.zyql.ai.selector.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zyql.ai.selector.listener.OnRecyclerViewPreloadMoreListener;

/* loaded from: classes4.dex */
public class RecyclerPreloadView extends RecyclerView {
    private static final int BOTTOM_DEFAULT = 1;
    public static final int BOTTOM_PRELOAD = 2;
    private static final String TAG = "RecyclerPreloadView";
    public boolean isEnabledLoadMore;
    public boolean isInTheBottom;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;
    private OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadListener;
    private int reachBottomRow;

    public RecyclerPreloadView(Context context) {
        super(context);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    public boolean isEnabledLoadMore() {
        return this.isEnabledLoadMore;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i10) {
        super.onScrollStateChanged(i10);
        if (i10 == 0 || i10 == 1) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                this.mFirstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
                this.mLastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i10, int i11) {
        super.onScrolled(i10, i11);
        if (this.onRecyclerViewPreloadListener == null || !this.isEnabledLoadMore) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            throw new RuntimeException("LayoutManager is null,Please check it!");
        }
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            throw new RuntimeException("Adapter is null,Please check it!");
        }
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager.findLastVisibleItemPosition() / gridLayoutManager.getSpanCount() >= (adapter.getItemCount() / gridLayoutManager.getSpanCount()) - this.reachBottomRow) {
                if (this.isInTheBottom) {
                    if (i11 == 0) {
                        this.isInTheBottom = false;
                        return;
                    }
                    return;
                } else {
                    this.onRecyclerViewPreloadListener.onRecyclerViewPreloadMore();
                    if (i11 > 0) {
                        this.isInTheBottom = true;
                        return;
                    }
                    return;
                }
            }
        }
        this.isInTheBottom = false;
    }

    public void setEnabledLoadMore(boolean z10) {
        this.isEnabledLoadMore = z10;
    }

    public void setOnRecyclerViewPreloadListener(OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.onRecyclerViewPreloadListener = onRecyclerViewPreloadMoreListener;
    }

    public void setReachBottomRow(int i10) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.reachBottomRow = i10;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }
}
