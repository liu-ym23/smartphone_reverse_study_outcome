package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes17.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(RecyclerView.Adapter r100) {
        this.mAdapter = r100;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r100, int r101) {
        this.mAdapter.notifyItemRangeInserted(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r100, int r101) {
        this.mAdapter.notifyItemMoved(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r100, int r101) {
        this.mAdapter.notifyItemRangeRemoved(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r100, int r101, Object r102) {
        this.mAdapter.notifyItemRangeChanged(r100, r101, r102);
    }
}
