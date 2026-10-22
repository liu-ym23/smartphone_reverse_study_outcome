package com.android.ttcjpaysdk.base.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
final class HeaderAndFooterRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_FOOTER_VIEW = -2000;
    private static final int TYPE_HEADER_VIEW = -1000;
    private RecyclerView.AdapterDataObserver mDataObserver;
    private List<ExtendRecyclerView.FixedViewInfo> mFooterViewInfos;
    private List<ExtendRecyclerView.FixedViewInfo> mHeaderViewInfos;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mInnerAdapter;
    protected RecyclerView mOwnerRecyclerView;

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View r100) {
            super(r100);
        }
    }

    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int r100 = getHeaderViewsCount() + getFooterViewsCount();
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L5;
        int r102 = r101.getItemCount();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.mInnerAdapter;
    }

    public HeaderAndFooterRecyclerViewAdapter(RecyclerView.Adapter r100) {
        this(null, null, r100);
    }

    private View wrapHeaderOrFooter(View r100) {
        ViewGroup.LayoutParams r101 = new ViewGroup.LayoutParams(-1, -2);
        RecyclerView r102 = this.mOwnerRecyclerView;
        if (r102 != null) goto L5;
    L7:
        CJPayBasicUtils.detachFromParent(r100);
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.addView(r100);
        r103.setLayoutParams(r101);
        return r103;
    L5:
        if (r102.getLayoutManager() == null) goto L7;
        r101 = this.mOwnerRecyclerView.getLayoutManager().generateLayoutParams(r101);
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L5;
        int r102 = r101.getItemCount();
    L6:
        int r103 = getHeaderViewsCount();
        if (r100 < r103) goto L9;
        if (r103 > r100) goto L19;
        if (r100 >= (r103 + r102)) goto L19;
        int r104 = this.mInnerAdapter.getItemViewType(r100 - r103);
        if (r104 < 0) goto L17;
        return r104;
    L17:
        throw new IllegalArgumentException("Your adapter's itemViewType must >= 0");
    L19:
        return ((r100 - 2000) - r103) - r102;
    L9:
        return r100 - 1000;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        this.mOwnerRecyclerView = r100;
        super.onAttachedToRecyclerView(r100);
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L6;
        r101.onAttachedToRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r100) {
        this.mOwnerRecyclerView = null;
        super.onDetachedFromRecyclerView(r100);
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L6;
        r101.onDetachedFromRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        if (HeaderViewHolder.class.isInstance(r100) == true) goto L12;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (r101.onFailedToRecycleView(r100) == false) goto L9;
        return true;
    L12:
        return super.onFailedToRecycleView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        if (HeaderViewHolder.class.isInstance(r100) == true) goto L7;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L9;
        r101.onViewAttachedToWindow(r100);
        return;
    L9:
        return;
    L7:
        super.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        if (HeaderViewHolder.class.isInstance(r100) == true) goto L7;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L9;
        r101.onViewDetachedFromWindow(r100);
        return;
    L9:
        return;
    L7:
        super.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r100) {
        if (HeaderViewHolder.class.isInstance(r100) == true) goto L7;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L9;
        r101.onViewRecycled(r100);
        return;
    L9:
        return;
    L7:
        super.onViewRecycled(r100);
    }

    public boolean removeHeader(View r100) {
        if (this.mHeaderViewInfos.size() <= 0) goto L7;
        boolean r101 = removeFixedViewInfo(r100, this.mHeaderViewInfos);
        if (r101 == false) goto L9;
        CJPayBasicUtils.detachFromParent(r100);
        notifyDataSetChanged();
        return r101;
    L9:
        return r101;
    L7:
        return false;
    }

    public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        RecyclerView.Adapter<RecyclerView.ViewHolder> r101 = this.mInnerAdapter;
        if (r101 == null) goto L5;
        r101.unregisterAdapterDataObserver(this.mDataObserver);
    L5:
        this.mInnerAdapter = r100;
        if (r100 == null) goto L8;
        r100.registerAdapterDataObserver(this.mDataObserver);
    L8:
        notifyDataSetChanged();
    }

    private boolean removeFixedViewInfo(View r100, List<ExtendRecyclerView.FixedViewInfo> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (((ExtendRecyclerView.FixedViewInfo) ListProtector.get(r101, r103)).view == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        ListProtector.remove(r101, r103);
        return true;
    L9:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (this.mInnerAdapter != null) goto L5;
        return;
    L5:
        int r102 = getHeaderViewsCount();
        if (r101 >= r102) goto L8;
    L10:
        ViewGroup.LayoutParams r103 = r100.itemView.getLayoutParams();
        if ((r103 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L15;
        ((StaggeredGridLayoutManager.LayoutParams) r103).setFullSpan(true);
        return;
    L15:
        return;
    L8:
        if (r101 >= (this.mInnerAdapter.getItemCount() + r102)) goto L10;
        this.mInnerAdapter.onBindViewHolder(r100, r101 - r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 >= (getFooterViewsCount() - 2000)) goto L7;
        return new HeaderViewHolder(wrapHeaderOrFooter(((ExtendRecyclerView.FixedViewInfo) ListProtector.get(this.mFooterViewInfos, r101 + 2000)).view));
    L7:
        if (r101 < (getHeaderViewsCount() - 1000)) goto L9;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r102 = this.mInnerAdapter;
        if (r102 != null) goto L15;
        return null;
    L15:
        return r102.onCreateViewHolder(r100, r101);
    L9:
        return new HeaderViewHolder(wrapHeaderOrFooter(((ExtendRecyclerView.FixedViewInfo) ListProtector.get(this.mHeaderViewInfos, r101 + 1000)).view));
    }

    public HeaderAndFooterRecyclerViewAdapter(List<ExtendRecyclerView.FixedViewInfo> r100, List<ExtendRecyclerView.FixedViewInfo> r101, RecyclerView.Adapter r102) {
        this.mDataObserver = new AnonymousClass1(this);
        if (r100 != null) goto L5;
        this.mHeaderViewInfos = new ArrayList();
    L6:
        if (r101 != null) goto L8;
        this.mFooterViewInfos = new ArrayList();
    L9:
        setAdapter(r102);
        return;
    L8:
        this.mFooterViewInfos = r101;
        goto L9
    L5:
        this.mHeaderViewInfos = r100;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        if (this.mInnerAdapter != null) goto L6;
        super.onBindViewHolder(r100, r101, r102);
        return;
    L6:
        int r103 = getHeaderViewsCount();
        if (r101 >= r103) goto L9;
    L11:
        ViewGroup.LayoutParams r104 = r100.itemView.getLayoutParams();
        if ((r104 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L16;
        ((StaggeredGridLayoutManager.LayoutParams) r104).setFullSpan(true);
        return;
    L16:
        return;
    L9:
        if (r101 >= (this.mInnerAdapter.getItemCount() + r103)) goto L11;
        this.mInnerAdapter.onBindViewHolder(r100, r101 - r103, r102);
    }
}
