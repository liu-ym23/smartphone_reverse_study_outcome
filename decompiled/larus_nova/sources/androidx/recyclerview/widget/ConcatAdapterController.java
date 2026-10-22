package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
class ConcatAdapterController implements NestedAdapterWrapper.Callback {
    private List<WeakReference<RecyclerView>> mAttachedRecyclerViews;
    private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> mBinderLookup;
    private final ConcatAdapter mConcatAdapter;
    private WrapperAndLocalPosition mReusableHolder;
    private final ConcatAdapter.Config.StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List<NestedAdapterWrapper> mWrappers;

    public static class WrapperAndLocalPosition {
        boolean mInUse;
        int mLocalPosition;
        NestedAdapterWrapper mWrapper;

        public WrapperAndLocalPosition() {
        }
    }

    private RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy() {
        Iterator<NestedAdapterWrapper> r100 = this.mWrappers.iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        NestedAdapterWrapper r101 = r100.next();
        RecyclerView.Adapter.StateRestorationPolicy r102 = r101.adapter.getStateRestorationPolicy();
        RecyclerView.Adapter.StateRestorationPolicy r103 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
        if (r102 == r103) goto L7;
        if (r102 != RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) goto L4;
        if (r101.getCachedItemCount() != 0) goto L4;
        return r103;
    L7:
        return r103;
    L14:
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    public boolean canRestoreState() {
        Iterator<NestedAdapterWrapper> r100 = this.mWrappers.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().adapter.canRestoreState() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty() == true) goto L5;
        ArrayList r100 = new ArrayList(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> r101 = this.mWrappers.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r100.add(r101.next().adapter);
        goto L8
    L10:
        return r100;
    L5:
        return Collections.emptyList();
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> r100 = this.mWrappers.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + r100.next().getCachedItemCount();
        goto L4
    L6:
        return r101;
    }

    public boolean hasStableIds() {
        if (this.mStableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L5;
        return true;
    L5:
        return false;
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        RecyclerView.Adapter.StateRestorationPolicy r100 = computeStateRestorationPolicy();
        if (r100 == this.mConcatAdapter.getStateRestorationPolicy()) goto L6;
        this.mConcatAdapter.internalSetStateRestorationPolicy(r100);
        return;
    }

    private int countItemsBefore(NestedAdapterWrapper r100) {
        Iterator<NestedAdapterWrapper> r101 = this.mWrappers.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L8;
        NestedAdapterWrapper r103 = r101.next();
        if (r103 == r100) goto L8;
        r102 = r102 + r103.getCachedItemCount();
    L8:
        return r102;
    }

    private WrapperAndLocalPosition findWrapperAndLocalPosition(int r100) {
        WrapperAndLocalPosition r101 = this.mReusableHolder;
        if (r101.mInUse == false) goto L5;
        r101 = new WrapperAndLocalPosition();
    L6:
        Iterator<NestedAdapterWrapper> r102 = this.mWrappers.iterator();
        int r103 = r100;
    L8:
        if (r102.hasNext() == false) goto L14;
        NestedAdapterWrapper r104 = r102.next();
        if (r104.getCachedItemCount() > r103) goto L11;
        r103 = r103 - r104.getCachedItemCount();
        goto L8
    L11:
        r101.mWrapper = r104;
        r101.mLocalPosition = r103;
    L14:
        if (r101.mWrapper == null) goto L17;
        return r101;
    L17:
        throw new IllegalArgumentException("Cannot find wrapper for " + r100);
    L5:
        r101.mInUse = true;
        goto L6
    }

    private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        int r101 = indexOfWrapper(r100);
        if (r101 != (-1)) goto L7;
        return null;
    L7:
        return (NestedAdapterWrapper) ListProtector.get(this.mWrappers, r101);
    }

    private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder r100) {
        NestedAdapterWrapper r101 = this.mBinderLookup.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + this);
    }

    private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        int r101 = this.mWrappers.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (((NestedAdapterWrapper) ListProtector.get(this.mWrappers, r102)).adapter == r100) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }

    private boolean isAttachedTo(RecyclerView r100) {
        Iterator<WeakReference<RecyclerView>> r101 = this.mAttachedRecyclerViews.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().get() != r100) goto L4;
        return true;
    L9:
        return false;
    }

    private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition r100) {
        r100.mInUse = false;
        r100.mWrapper = null;
        r100.mLocalPosition = -1;
        this.mReusableHolder = r100;
    }

    public boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        return addAdapter(this.mWrappers.size(), r100);
    }

    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBoundAdapter(RecyclerView.ViewHolder r100) {
        NestedAdapterWrapper r101 = this.mBinderLookup.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.adapter;
    }

    public long getItemId(int r100) {
        WrapperAndLocalPosition r101 = findWrapperAndLocalPosition(r100);
        long r102 = r101.mWrapper.getItemId(r101.mLocalPosition);
        releaseWrapperAndLocalPosition(r101);
        return r102;
    }

    public int getItemViewType(int r100) {
        WrapperAndLocalPosition r101 = findWrapperAndLocalPosition(r100);
        int r102 = r101.mWrapper.getItemViewType(r101.mLocalPosition);
        releaseWrapperAndLocalPosition(r101);
        return r102;
    }

    public void onAttachedToRecyclerView(RecyclerView r100) {
        if (isAttachedTo(r100) == false) goto L5;
        return;
    L5:
        this.mAttachedRecyclerViews.add(new WeakReference(r100));
        Iterator<NestedAdapterWrapper> r101 = this.mWrappers.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().adapter.onAttachedToRecyclerView(r100);
        goto L7
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onChanged(NestedAdapterWrapper r100) {
        this.mConcatAdapter.notifyDataSetChanged();
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onDetachedFromRecyclerView(RecyclerView r100) {
        int r101 = this.mAttachedRecyclerViews.size() - 1;
    L3:
        if (r101 < 0) goto L11;
        WeakReference r102 = (WeakReference) ListProtector.get(this.mAttachedRecyclerViews, r101);
        if (r102.get() != null) goto L8;
        ListProtector.remove(this.mAttachedRecyclerViews, r101);
    L10:
        r101 = r101 - 1;
        goto L3
    L8:
        if (r102.get() != r100) goto L10;
        ListProtector.remove(this.mAttachedRecyclerViews, r101);
    L11:
        Iterator<NestedAdapterWrapper> r103 = this.mWrappers.iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        r103.next().adapter.onDetachedFromRecyclerView(r100);
        goto L13
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        NestedAdapterWrapper r101 = this.mBinderLookup.get(r100);
        if (r101 == null) goto L7;
        boolean r102 = r101.adapter.onFailedToRecycleView(r100);
        this.mBinderLookup.remove(r100);
        return r102;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onStateRestorationPolicyChanged(NestedAdapterWrapper r100) {
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        getWrapper(r100).adapter.onViewAttachedToWindow(r100);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        getWrapper(r100).adapter.onViewDetachedFromWindow(r100);
    }

    public void onViewRecycled(RecyclerView.ViewHolder r100) {
        NestedAdapterWrapper r101 = this.mBinderLookup.get(r100);
        if (r101 == null) goto L7;
        r101.adapter.onViewRecycled(r100);
        this.mBinderLookup.remove(r100);
        return;
    L7:
        throw new IllegalStateException("Cannot find wrapper for " + r100 + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r100) {
        int r101 = indexOfWrapper(r100);
        if (r101 != (-1)) goto L6;
        return false;
    L6:
        NestedAdapterWrapper r102 = (NestedAdapterWrapper) ListProtector.get(this.mWrappers, r101);
        int r103 = countItemsBefore(r102);
        ListProtector.remove(this.mWrappers, r101);
        this.mConcatAdapter.notifyItemRangeRemoved(r103, r102.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> r104 = this.mAttachedRecyclerViews.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        RecyclerView r105 = r104.next().get();
        if (r105 == null) goto L8;
        r100.onDetachedFromRecyclerView(r105);
        goto L8
    L12:
        r102.dispose();
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    public ConcatAdapterController(ConcatAdapter r100, ConcatAdapter.Config r101) {
        this.mAttachedRecyclerViews = new ArrayList();
        this.mBinderLookup = new IdentityHashMap();
        this.mWrappers = new ArrayList();
        this.mReusableHolder = new WrapperAndLocalPosition();
        this.mConcatAdapter = r100;
        if (r101.isolateViewTypes == false) goto L5;
        this.mViewTypeStorage = new ViewTypeStorage.IsolatedViewTypeStorage();
    L6:
        ConcatAdapter.Config.StableIdMode r102 = r101.stableIdMode;
        this.mStableIdMode = r102;
        if (r102 != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) goto L10;
        this.mStableIdStorage = new StableIdStorage.NoStableIdStorage();
        return;
    L10:
        if (r102 != ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) goto L13;
        this.mStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
        return;
    L13:
        if (r102 != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) goto L17;
        this.mStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
        return;
    L17:
        throw new IllegalArgumentException("unknown stable id mode");
    L5:
        this.mViewTypeStorage = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        goto L6
    }

    public boolean addAdapter(int r100, RecyclerView.Adapter<RecyclerView.ViewHolder> r101) {
        if (r100 < 0) goto L25;
        if (r100 > this.mWrappers.size()) goto L25;
        if (hasStableIds() == false) goto L8;
        Preconditions.checkArgument(r101.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
    L10:
        if (findWrapperFor(r101) == null) goto L13;
        return false;
    L13:
        NestedAdapterWrapper r102 = new NestedAdapterWrapper(r101, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
        ListProtector.add(this.mWrappers, r100, r102);
        Iterator<WeakReference<RecyclerView>> r103 = this.mAttachedRecyclerViews.iterator();
    L15:
        if (r103.hasNext() == false) goto L20;
        RecyclerView r104 = r103.next().get();
        if (r104 == null) goto L15;
        r101.onAttachedToRecyclerView(r104);
        goto L15
    L20:
        if (r102.getCachedItemCount() <= 0) goto L22;
        this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(r102), r102.getCachedItemCount());
    L22:
        calculateAndUpdateStateRestorationPolicy();
        return true;
    L8:
        r101.hasStableIds();
    L25:
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.mWrappers.size() + ". Given:" + r100);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        WrapperAndLocalPosition r102 = findWrapperAndLocalPosition(r101);
        this.mBinderLookup.put(r100, r102.mWrapper);
        r102.mWrapper.onBindViewHolder(r100, r102.mLocalPosition);
        releaseWrapperAndLocalPosition(r102);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return this.mViewTypeStorage.getWrapperForGlobalType(r101).onCreateViewHolder(r100, r101);
    }

    public int getLocalAdapterPosition(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, RecyclerView.ViewHolder r101, int r102) {
        NestedAdapterWrapper r103 = this.mBinderLookup.get(r101);
        if (r103 != null) goto L6;
        return -1;
    L6:
        int r104 = r102 - countItemsBefore(r103);
        int r105 = r103.adapter.getItemCount();
        if (r104 < 0) goto L12;
        if (r104 >= r105) goto L12;
        return r103.adapter.findRelativeAdapterPositionIn(r100, r101, r104);
    L12:
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + r104 + " which is out of bounds for the adapter with size " + r105 + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + r101 + "adapter:" + r100);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(NestedAdapterWrapper r100, int r101, int r102) {
        int r103 = countItemsBefore(r100);
        this.mConcatAdapter.notifyItemRangeChanged(r101 + r103, r102);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeInserted(NestedAdapterWrapper r100, int r101, int r102) {
        int r103 = countItemsBefore(r100);
        this.mConcatAdapter.notifyItemRangeInserted(r101 + r103, r102);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeMoved(NestedAdapterWrapper r100, int r101, int r102) {
        int r103 = countItemsBefore(r100);
        this.mConcatAdapter.notifyItemMoved(r101 + r103, r102 + r103);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeRemoved(NestedAdapterWrapper r100, int r101, int r102) {
        int r103 = countItemsBefore(r100);
        this.mConcatAdapter.notifyItemRangeRemoved(r101 + r103, r102);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(NestedAdapterWrapper r100, int r101, int r102, Object r103) {
        int r104 = countItemsBefore(r100);
        this.mConcatAdapter.notifyItemRangeChanged(r101 + r104, r102, r103);
    }
}
