package com.stepos.common.picker;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int DIVIDER = 2;
    private static final int INFINITY_COUNT = Integer.MAX_VALUE;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private final boolean mLoop;
    private b mOnItemClickListener;

    /* renamed from: com.stepos.common.picker.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0348a implements View.OnClickListener {
        final /* synthetic */ int val$position;
        final /* synthetic */ int val$virtualPosition;

        public ViewOnClickListenerC0348a(int i10, int i11) {
            this.val$position = i10;
            this.val$virtualPosition = i11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mOnItemClickListener != null) {
                a.this.mOnItemClickListener.a(view, this.val$position, this.val$virtualPosition);
            }
        }
    }

    public interface b {
        void a(View view, int i10, int i11);
    }

    public a(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, boolean z10) {
        this.mAdapter = adapter;
        this.mLoop = z10;
    }

    public int d() {
        if (this.mLoop) {
            return (Integer.MAX_VALUE / (this.mAdapter.getItemCount() * 2)) * this.mAdapter.getItemCount();
        }
        return 0;
    }

    public int e(int i10) {
        return this.mLoop ? i10 % this.mAdapter.getItemCount() : i10;
    }

    public void f(b bVar) {
        this.mOnItemClickListener = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mLoop) {
            return Integer.MAX_VALUE;
        }
        return this.mAdapter.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return super.getItemId(e(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.mAdapter.getItemViewType(e(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i10) {
        int iE = e(i10);
        this.mAdapter.onBindViewHolder(viewHolder, iE);
        viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0348a(i10, iE));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return this.mAdapter.onCreateViewHolder(viewGroup, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mAdapter.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.mAdapter.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        this.mAdapter.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        this.mAdapter.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.mAdapter.onViewRecycled(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z10) {
        this.mAdapter.setHasStableIds(z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
