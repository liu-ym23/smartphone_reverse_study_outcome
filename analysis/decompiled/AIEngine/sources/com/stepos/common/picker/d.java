package com.stepos.common.picker;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.picker.WheelPicker;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public final e f6534a;

    /* renamed from: b, reason: collision with root package name */
    public WheelPicker.c f6535b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6536c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {
        public a(int i10, int i11) {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int[] iArrCalculateDistanceToFinalSnap;
            WheelPicker.c cVar = d.this.f6535b;
            if (cVar != null) {
                WheelPicker wheelPicker = WheelPicker.this;
                wheelPicker.f6520s = true;
                LinearLayoutManager linearLayoutManager = wheelPicker.f6512j;
                if (linearLayoutManager == null || (iArrCalculateDistanceToFinalSnap = wheelPicker.f6513k.calculateDistanceToFinalSnap(linearLayoutManager, view)) == null) {
                    return;
                }
                wheelPicker.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
            }
        }
    }

    public d(e eVar, boolean z) {
        this.f6534a = eVar;
        this.f6536c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f6536c) {
            return Integer.MAX_VALUE;
        }
        return this.f6534a.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i10) {
        if (this.f6536c) {
            i10 %= this.f6534a.getItemCount();
        }
        return super.getItemId(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        boolean z = this.f6536c;
        e eVar = this.f6534a;
        if (z) {
            i10 %= eVar.getItemCount();
        }
        return eVar.getItemViewType(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f6534a.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i10) {
        boolean z = this.f6536c;
        e eVar = this.f6534a;
        int itemCount = z ? i10 % eVar.getItemCount() : i10;
        eVar.onBindViewHolder(viewHolder, itemCount);
        viewHolder.itemView.setOnClickListener(new a(i10, itemCount));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return this.f6534a.onCreateViewHolder(viewGroup, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f6534a.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.f6534a.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.f6534a.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.f6534a.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.f6534a.onViewRecycled(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f6534a.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        this.f6534a.setHasStableIds(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f6534a.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
