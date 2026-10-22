package com.bytedance.android.gamecp.common.paging.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.gamecp.common.model.e;
import com.bytedance.android.gamecp.common.paging.BaseViewHolder;
import com.bytedance.android.gamecp.common.ui.DouyinLoadingLayout;
import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes44.dex */
public abstract class PagingAdapter<T> extends PagedListAdapter<T, RecyclerView.ViewHolder> {

    public static class EndViewHolder extends RecyclerView.ViewHolder {
        public EndViewHolder(View r100) {
            super(r100);
        }
    }

    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f56710a;

        @Override // com.bytedance.android.gamecp.common.paging.adapter.PagingAdapter.c
        public final void unbind() {
        }

        public a(View r100) {
            super(r100);
            ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.loading_container);
            this.f56710a = r101;
            r101.addView(new DouyinLoadingLayout(r100.getContext()));
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f56711a;

        public b(View r100) {
            super(r100);
            this.f56711a = r100.findViewById(R.id.error_icon);
            TextView r101 = (TextView) r100.findViewById(R.id.error_tips);
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public void unbind() {
        }

        public c(View r100) {
            super(r100);
        }
    }

    public abstract int getNormalViewType(int r100, T r101);

    public abstract RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r100, int r101);

    @Override // androidx.paging.PagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        super.getItemCount();
        super.getItemCount();
        return (((super.getItemCount() + 0) + 0) + 0) + 0;
    }

    @Override // androidx.paging.PagedListAdapter
    public final T getItem(int r100) {
        super.getItemCount();
        super.getItemCount();
        super.getItemCount();
        int r101 = r100 + 0;
        if (r101 >= 0) goto L5;
    L8:
        LocalTestManager.a(new Class[]{uv.a.class});
        return null;
    L5:
        if (r101 >= super.getItemCount()) goto L8;
        return (T) super.getItem(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        getItemCount();
        super.getItemCount();
        super.getItemCount();
        int r101 = r100 + 0;
        if (r101 < super.getItemCount()) goto L6;
        return -8888;
    L6:
        if (r101 >= 0) goto L8;
    L11:
        LocalTestManager.a(new Class[]{uv.a.class});
        Object r102 = null;
    L13:
        return getNormalViewType(r101, r102);
    L8:
        if (r101 >= super.getItemCount()) goto L11;
        r102 = super.getItem(r101);
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        super.onViewAttachedToWindow(r100);
        if ((r100 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r100).getClass();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        super.onViewDetachedFromWindow(r100);
        if ((r100 instanceof BaseViewHolder) == false) goto L6;
        ((BaseViewHolder) r100).getClass();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        if ((r100 instanceof BaseViewHolder) == false) goto L5;
        ((BaseViewHolder) r100).getClass();
        throw null;
    L5:
        if ((r100 instanceof c) == false) goto L8;
        ((c) r100).unbind();
        return;
    L8:
        if ((r100 instanceof b) == false) goto L14;
        ((b) r100).getClass();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        throw null;
    }

    public final void setFullSpan(RecyclerView.ViewHolder r100) {
        RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r100.itemView.getLayoutParams();
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L6;
        ((StaggeredGridLayoutManager.LayoutParams) r101).setFullSpan(true);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        int r102 = getItemViewType(r101);
        if (r102 != (-559038738)) goto L6;
        setFullSpan(r100);
        return;
    L6:
        if (r102 != (-559038737)) goto L9;
        setFullSpan(r100);
        return;
    L9:
        if (r102 != (-1091576148)) goto L11;
    L23:
        setFullSpan(r100);
        if ((r100 instanceof c) == false) goto L26;
        c r103 = (c) r100;
        throw null;
    L26:
        if ((r100 instanceof b) == false) goto L36;
        b r104 = (b) r100;
        super.getItemCount();
        throw null;
    L36:
        return;
    L11:
        if (r102 == (-1091576149)) goto L23;
        if (r102 != (-1091641683)) goto L17;
        setFullSpan(r100);
        return;
    L17:
        if ((r100 instanceof BaseViewHolder) == false) goto L34;
        T r105 = getItem(r101);
        if ((r105 instanceof e) == false) goto L21;
        ((e) r105).getClass();
        BaseViewHolder r106 = (BaseViewHolder) r100;
        r106.getClass();
        r106.bind(null, r101);
    L22:
        ((BaseViewHolder) r100).getClass();
        return;
    L21:
        ((BaseViewHolder) r100).bind(r105, r101);
        goto L22
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 == (-559038738)) goto L29;
        if (r101 != (-559038737)) goto L9;
        return new EndViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_core_rv_loading_end, r100, false));
    L9:
        if (r101 == (-1091576148)) goto L18;
        if (r101 == (-1091576149)) goto L18;
        if (r101 != (-1091641683)) goto L17;
        return new EndViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_core_rv_loading_empty, r100, false));
    L17:
        return onCreateNormalViewHolder(r100, r101);
    L18:
        if (r101 == (-1091576148)) goto L20;
        if (r101 != (-1091576149)) goto L27;
        return new b(LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_core_rv_loading_error, r100, false));
    L27:
        throw new RuntimeException("unknown footer type");
    L20:
        if (GameCpTargetUtils.c() == false) goto L31;
        return new a(LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_douyin_core_rv_loading_more, r100, false));
    L31:
        return new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.gamecp_core_rv_loading_more, r100, false));
    L29:
        throw new RuntimeException("create your header view holder");
    }
}
