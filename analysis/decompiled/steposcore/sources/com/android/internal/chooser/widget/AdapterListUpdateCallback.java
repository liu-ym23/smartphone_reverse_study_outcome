package com.android.internal.chooser.widget;

import com.android.internal.widget.RecyclerView;

/* loaded from: classes.dex */
public class AdapterListUpdateCallback implements ListUpdateCallback {
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // com.android.internal.chooser.widget.ListUpdateCallback
    public void onInserted(int position, int count) {
        this.mAdapter.notifyItemRangeInserted(position, count);
    }

    @Override // com.android.internal.chooser.widget.ListUpdateCallback
    public void onRemoved(int position, int count) {
        this.mAdapter.notifyItemRangeRemoved(position, count);
    }

    @Override // com.android.internal.chooser.widget.ListUpdateCallback
    public void onMoved(int fromPosition, int toPosition) {
        this.mAdapter.notifyItemMoved(fromPosition, toPosition);
    }

    @Override // com.android.internal.chooser.widget.ListUpdateCallback
    public void onChanged(int position, int count, Object payload) {
        this.mAdapter.notifyItemRangeChanged(position, count, payload);
    }
}
