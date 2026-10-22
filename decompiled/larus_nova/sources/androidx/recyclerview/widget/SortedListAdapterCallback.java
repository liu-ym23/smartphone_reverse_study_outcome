package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes17.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter mAdapter;

    public SortedListAdapterCallback(RecyclerView.Adapter r100) {
        this.mAdapter = r100;
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback
    public void onChanged(int r100, int r101) {
        this.mAdapter.notifyItemRangeChanged(r100, r101);
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

    @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r100, int r101, Object r102) {
        this.mAdapter.notifyItemRangeChanged(r100, r101, r102);
    }
}
