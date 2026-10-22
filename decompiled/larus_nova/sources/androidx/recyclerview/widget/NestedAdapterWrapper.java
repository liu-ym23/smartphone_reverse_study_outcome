package androidx.recyclerview.widget;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private RecyclerView.AdapterDataObserver mAdapterObserver;
    int mCachedItemCount;
    final Callback mCallback;
    private final StableIdStorage.StableIdLookup mStableIdLookup;
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    public interface Callback {
        void onChanged(NestedAdapterWrapper r100);

        void onItemRangeChanged(NestedAdapterWrapper r100, int r101, int r102);

        void onItemRangeChanged(NestedAdapterWrapper r100, int r101, int r102, Object r103);

        void onItemRangeInserted(NestedAdapterWrapper r100, int r101, int r102);

        void onItemRangeMoved(NestedAdapterWrapper r100, int r101, int r102);

        void onItemRangeRemoved(NestedAdapterWrapper r100, int r101, int r102);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper r100);
    }

    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int r100) {
        long r101 = this.adapter.getItemId(r100);
        return this.mStableIdLookup.localToGlobal(r101);
    }

    public int getItemViewType(int r100) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(r100));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        this.adapter.bindViewHolder(r100, r101);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        int r102 = this.mViewTypeLookup.globalToLocal(r101);
        return this.adapter.onCreateViewHolder(r100, r102);
    }

    public NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r100, Callback r101, ViewTypeStorage r102, StableIdStorage.StableIdLookup r103) {
        this.mAdapterObserver = new AnonymousClass1(this);
        this.adapter = r100;
        this.mCallback = r101;
        this.mViewTypeLookup = r102.createViewTypeWrapper(this);
        this.mStableIdLookup = r103;
        this.mCachedItemCount = r100.getItemCount();
        r100.registerAdapterDataObserver(this.mAdapterObserver);
    }
}
