package com.stepos.common.picker;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class f extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f11371a;

    /* renamed from: b, reason: collision with root package name */
    public e f11372b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11373c;

    public f(h hVar, boolean z4) {
        this.f11371a = hVar;
        this.f11373c = z4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f11373c) {
            return Integer.MAX_VALUE;
        }
        return this.f11371a.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i4) {
        if (this.f11373c) {
            i4 %= this.f11371a.getItemCount();
        }
        return super.getItemId(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i4) {
        if (this.f11373c) {
            i4 %= this.f11371a.getItemCount();
        }
        return this.f11371a.getItemViewType(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f11371a.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        int itemCount = this.f11373c ? i4 % this.f11371a.getItemCount() : i4;
        this.f11371a.onBindViewHolder(viewHolder, itemCount);
        viewHolder.itemView.setOnClickListener(new d(this, i4, itemCount));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return this.f11371a.onCreateViewHolder(viewGroup, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f11371a.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.f11371a.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.f11371a.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.f11371a.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.f11371a.onViewRecycled(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f11371a.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z4) {
        this.f11371a.setHasStableIds(z4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f11371a.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
