package com.alibaba.android.vlayout;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.layout.LayoutChunkResult;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutHelper {
    public static final Range<Integer> RANGE_ALL = null;
    public static final Range<Integer> RANGE_EMPTY = null;

    @NonNull
    protected final List<View> mOffFlowViews;

    @NonNull
    Range<Integer> mRange;
    int mZIndex;

    static {
        RANGE_ALL = Range.create(Integer.MIN_VALUE, Integer.valueOf(Channel.UNLIMITED));
        RANGE_EMPTY = Range.create(-1, -1);
    }

    public LayoutHelper() {
        this.mRange = RANGE_EMPTY;
        this.mZIndex = 0;
        this.mOffFlowViews = new LinkedList();
    }

    public abstract void adjustLayout(int r10, int r11, LayoutManagerHelper r12);

    public abstract void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15);

    public abstract void beforeLayout(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutManagerHelper r12);

    public abstract void bindLayoutView(View r10);

    public void checkAnchorInfo(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
    }

    public abstract void clear(LayoutManagerHelper r10);

    public abstract int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13);

    public abstract int computeMarginEnd(int r10, boolean r11, boolean r12, LayoutManagerHelper r13);

    public abstract int computeMarginStart(int r10, boolean r11, boolean r12, LayoutManagerHelper r13);

    public abstract int computePaddingEnd(int r10, boolean r11, boolean r12, LayoutManagerHelper r13);

    public abstract int computePaddingStart(int r10, boolean r11, boolean r12, LayoutManagerHelper r13);

    public abstract void doLayout(RecyclerView.Recycler r10, RecyclerView.State r11, VirtualLayoutManager.LayoutStateWrapper r12, LayoutChunkResult r13, LayoutManagerHelper r14);

    @Nullable
    public View getFixedView() {
        return null;
    }

    public abstract int getItemCount();

    @NonNull
    public List<View> getOffFlowViews() {
        return this.mOffFlowViews;
    }

    @NonNull
    public final Range<Integer> getRange() {
        return this.mRange;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public abstract boolean isFixLayout();

    public boolean isOutOfRange(int r10) {
        return !this.mRange.contains(Integer.valueOf(r10));
    }

    public boolean isRecyclable(int r10, int r11, int r12, LayoutManagerHelper r13, boolean r14) {
        return true;
    }

    public void onItemsChanged(LayoutManagerHelper r10) {
    }

    public void onOffsetChildrenHorizontal(int r10, LayoutManagerHelper r11) {
    }

    public void onOffsetChildrenVertical(int r10, LayoutManagerHelper r11) {
    }

    public void onRangeChange(int r10, int r11) {
    }

    public void onRefreshLayout(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
    }

    public void onRestoreInstanceState(Bundle r10) {
    }

    public void onSaveState(Bundle r10) {
    }

    public void onScrollStateChanged(int r10, int r11, int r12, LayoutManagerHelper r13) {
    }

    public abstract boolean requireLayoutView();

    public abstract void setItemCount(int r10);

    public void setRange(int r10, int r11) {
        if (r11 < r10) goto L20;
        if (r10 != (-1)) goto L9;
        if (r11 != (-1)) goto L9;
        this.mRange = RANGE_EMPTY;
        onRangeChange(r10, r11);
        return;
    L9:
        if (((r11 - r10) + 1) != getItemCount()) goto L18;
        if (r10 == ((Integer) this.mRange.getUpper()).intValue()) goto L13;
    L15:
        this.mRange = Range.create(Integer.valueOf(r10), Integer.valueOf(r11));
        onRangeChange(r10, r11);
        return;
    L13:
        if (r11 != ((Integer) this.mRange.getLower()).intValue()) goto L15;
        return;
    L18:
        throw new MismatchChildCountException("ItemCount mismatch when range: " + this.mRange.toString() + " childCount: " + getItemCount());
    L20:
        throw new IllegalArgumentException("end should be larger or equeal then start position");
    }

    public void setZIndex(int r10) {
        this.mZIndex = r10;
    }
}
