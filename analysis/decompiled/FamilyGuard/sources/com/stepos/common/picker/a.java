package com.stepos.common.picker;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView.Adapter<RecyclerView.ViewHolder> f13664a;

    /* renamed from: b, reason: collision with root package name */
    private b f13665b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f13666c;

    /* renamed from: com.stepos.common.picker.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0173a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13667a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13668b;

        ViewOnClickListenerC0173a(int i5, int i6) {
            this.f13667a = i5;
            this.f13668b = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f13665b != null) {
                a.this.f13665b.a(view, this.f13667a, this.f13668b);
            }
        }
    }

    interface b {
        void a(View view, int i5, int i6);
    }

    public a(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, boolean z5) {
        this.f13664a = adapter;
        this.f13666c = z5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f13666c) {
            return Integer.MAX_VALUE;
        }
        return this.f13664a.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i5) {
        return super.getItemId(l(i5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        return this.f13664a.getItemViewType(l(i5));
    }

    public int k() {
        if (this.f13666c) {
            return (Integer.MAX_VALUE / (this.f13664a.getItemCount() * 2)) * this.f13664a.getItemCount();
        }
        return 0;
    }

    public int l(int i5) {
        return this.f13666c ? i5 % this.f13664a.getItemCount() : i5;
    }

    public void n(b bVar) {
        this.f13665b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f13664a.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        int iL = l(i5);
        this.f13664a.onBindViewHolder(viewHolder, iL);
        viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0173a(i5, iL));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return this.f13664a.onCreateViewHolder(viewGroup, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f13664a.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.f13664a.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.f13664a.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.f13664a.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.f13664a.onViewRecycled(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f13664a.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z5) {
        this.f13664a.setHasStableIds(z5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f13664a.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
