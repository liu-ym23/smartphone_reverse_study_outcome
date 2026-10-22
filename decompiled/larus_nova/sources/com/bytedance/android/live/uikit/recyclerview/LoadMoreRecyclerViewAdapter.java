package com.bytedance.android.live.uikit.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {
    private ILoadMore mLoadMoreListener;
    private c mLoadMoreViewHolder;

    public interface ILoadMore {
        void loadMore(boolean r100);
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f102331a;

        public a(LoadMoreRecyclerViewAdapter r100) {
            this.f102331a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (LoadMoreRecyclerViewAdapter.access$000(this.f102331a) == null) goto L6;
            LoadMoreRecyclerViewAdapter.access$000(this.f102331a).loadMore(true);
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f102332a;

        public b(LoadMoreRecyclerViewAdapter r100) {
            this.f102332a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (LoadMoreRecyclerViewAdapter.access$000(this.f102332a) == null) goto L6;
            LoadMoreRecyclerViewAdapter.access$000(this.f102332a).loadMore(true);
            return;
        }
    }

    public class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f102333b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreRecyclerViewAdapter f102334a;

        public c(LoadMoreRecyclerViewAdapter r100, LoadingStatusView r101) {
            this.f102334a = r100;
            super(r101);
        }
    }

    public int getErrorLayoutForLoadMore() {
        return -1;
    }

    public int getLoadingLayoutForLoadMore() {
        return R.layout.liveuikit_layout_loading_more;
    }

    public void resetLoadMoreState() {
        c r100 = this.mLoadMoreViewHolder;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = c.f102333b;
        ((LoadingStatusView) r100.itemView).reset();
    }

    public void showLoadMoreError() {
        c r100 = this.mLoadMoreViewHolder;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = c.f102333b;
        ((LoadingStatusView) r100.itemView).showError();
    }

    public void showLoadMoreLoading() {
        c r100 = this.mLoadMoreViewHolder;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = c.f102333b;
        ((LoadingStatusView) r100.itemView).showLoading();
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getBasicItemCount() != 0) goto L7;
        return 0;
    L7:
        return super.getItemCount();
    }

    public LoadMoreRecyclerViewAdapter() {
    }

    public static /* synthetic */ ILoadMore access$000(LoadMoreRecyclerViewAdapter r100) {
        return r100.mLoadMoreListener;
    }

    public int getFooterHeight(View r100) {
        return r100.getResources().getDimensionPixelSize(R.dimen.default_list_loadmore_height);
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof c) == true) goto L5;
        return;
    L5:
        c r101 = (c) r100;
        if (((LoadingStatusView) r101.itemView).isReset() == true) goto L8;
    L10:
        RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) this.mLoadMoreViewHolder.itemView.getLayoutParams();
        if ((r102 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L13;
        ((StaggeredGridLayoutManager.LayoutParams) r102).setFullSpan(true);
    L13:
        this.mLoadMoreViewHolder.itemView.setLayoutParams(r102);
        return;
    L8:
        if (access$000(r101.f102334a) == null) goto L10;
        access$000(r101.f102334a).loadMore(false);
        goto L10
    }

    @Override // com.bytedance.android.live.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        LoadingStatusView r101 = new LoadingStatusView(r100.getContext());
        int r102 = getFooterHeight(r100);
        int r103 = r100.getResources().getDimensionPixelSize(R.dimen.default_list_loadmore_progressbar);
        r101.setLayoutParams(getFooterLayoutParams(-1, r102));
        LoadingStatusView.Builder r104 = new LoadingStatusView.Builder(r100.getContext());
        r104.setUseProgressBar(r103).setErrorText(R.string.load_status_click_retry, new a(this));
        if (getErrorLayoutForLoadMore() <= 0) goto L5;
        View r105 = LayoutInflater.from(r100.getContext()).inflate(getErrorLayoutForLoadMore(), r100, false);
        r105.setOnClickListener(new b(this));
        r104.setErrorView(r105);
    L5:
        r104.setLoadingView(LayoutInflater.from(r100.getContext()).inflate(getLoadingLayoutForLoadMore(), r100, false));
        r101.setBuilder(r104);
        c r106 = new c(this, r101);
        this.mLoadMoreViewHolder = r106;
        return r106;
    }

    public void setLoadMoreListener(ILoadMore r100) {
        this.mLoadMoreListener = r100;
    }

    public RecyclerView.LayoutParams getFooterLayoutParams(int r100, int r101) {
        return new RecyclerView.LayoutParams(r100, r101);
    }
}
