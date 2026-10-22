package com.bytedance.android.live.core.paging.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes45.dex */
public class DelegatePagingAdapter<T> extends PagingAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Delegate f65024a;

    public interface Delegate<V> {
        boolean areContentsTheSame(V r100, V r101);

        boolean areItemsTheSame(V r100, V r101);

        int getEmptyResId();

        int getViewType(int r100, V r101);

        void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, V r102);

        RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101);

        void setPayload(Object... r100);
    }

    public static class a<T> extends DiffUtil.ItemCallback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Delegate<T> f65025a;

        public a(Delegate<T> r100) {
            this.f65025a = r100;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(T r100, T r101) {
            return this.f65025a.areContentsTheSame(r100, r101);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(T r100, T r101) {
            return this.f65025a.areItemsTheSame(r100, r101);
        }
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getEmptyResId() {
        if (this.f65024a.getEmptyResId() != 0) goto L7;
        return super.getEmptyResId();
    L7:
        return this.f65024a.getEmptyResId();
    }

    public DelegatePagingAdapter(Delegate<T> r100) {
        super(new a(r100));
        this.f65024a = r100;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final int getNormalViewType(int r100, T r101) {
        return this.f65024a.getViewType(r100, r101);
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final void onBindNormalViewHolder(RecyclerView.ViewHolder r100, int r101) {
        this.f65024a.onBindViewHolder(r100, r101, getItem(r101));
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r100, int r101) {
        return this.f65024a.onCreateViewHolder(r100, r101);
    }
}
