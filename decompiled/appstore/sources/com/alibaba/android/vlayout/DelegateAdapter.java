package com.alibaba.android.vlayout;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class DelegateAdapter extends VirtualLayoutAdapter<RecyclerView.ViewHolder> {
    private long[] cantorReverse;

    @NonNull
    private final List<Pair<AdapterDataObserver, Adapter>> mAdapters;
    private final boolean mHasConsistItemType;
    private int mIndex;
    private final SparseArray<Pair<AdapterDataObserver, Adapter>> mIndexAry;

    @Nullable
    private AtomicInteger mIndexGen;
    private SparseArray<Adapter> mItemTypeAry;
    private int mTotal;

    public static abstract class Adapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {
        public Adapter() {
        }

        public void onBindViewHolderWithOffset(VH r10, int r11, int r12) {
        }

        public abstract LayoutHelper onCreateLayoutHelper();

        public void onBindViewHolderWithOffset(VH r10, int r11, int r12, List<Object> r13) {
            onBindViewHolderWithOffset(r10, r11, r12);
        }
    }

    public class AdapterDataObserver extends RecyclerView.AdapterDataObserver {
        int mIndex;
        int mStartPosition;
        final /* synthetic */ DelegateAdapter this$0;

        public AdapterDataObserver(DelegateAdapter r10, int r11, int r12) {
            this.this$0 = r10;
            this.mStartPosition = r11;
            this.mIndex = r12;
        }

        private boolean updateLayoutHelper() {
            int r10 = this.mIndex;
            if (r10 >= 0) goto L5;
            return false;
        L5:
            int r11 = this.this$0.findAdapterPositionByIndex(r10);
            if (r11 >= 0) goto L8;
            return false;
        L8:
            Pair r12 = (Pair) DelegateAdapter.access$000(this.this$0).get(r11);
            LinkedList r13 = new LinkedList(this.this$0.getLayoutHelpers());
            LayoutHelper r14 = (LayoutHelper) r13.get(r11);
            if (r14.getItemCount() == ((Adapter) r12.second).getItemCount()) goto L15;
            r14.setItemCount(((Adapter) r12.second).getItemCount());
            DelegateAdapter.access$102(this.this$0, this.mStartPosition + ((Adapter) r12.second).getItemCount());
            int r15 = r11 + 1;
        L12:
            if (r15 >= DelegateAdapter.access$000(this.this$0).size()) goto L14;
            Pair r16 = (Pair) DelegateAdapter.access$000(this.this$0).get(r15);
            AdapterDataObserver r17 = (AdapterDataObserver) r16.first;
            r17.mStartPosition = DelegateAdapter.access$100(this.this$0);
            DelegateAdapter r18 = this.this$0;
            DelegateAdapter.access$102(r18, DelegateAdapter.access$100(r18) + ((Adapter) r16.second).getItemCount());
            r15 = r15 + 1;
            goto L12
        L14:
            DelegateAdapter.access$201(this.this$0, r13);
        L15:
            return true;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public int getStartPosition() {
            return this.mStartPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (updateLayoutHelper() == true) goto L5;
            return;
        L5:
            this.this$0.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r10, int r11) {
            if (updateLayoutHelper() == true) goto L5;
            return;
        L5:
            this.this$0.notifyItemRangeChanged(this.mStartPosition + r10, r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r10, int r11) {
            if (updateLayoutHelper() == true) goto L5;
            return;
        L5:
            this.this$0.notifyItemRangeInserted(this.mStartPosition + r10, r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r10, int r11, int r12) {
            if (updateLayoutHelper() == true) goto L5;
            return;
        L5:
            DelegateAdapter r13 = this.this$0;
            int r14 = this.mStartPosition;
            r13.notifyItemMoved(r10 + r14, r14 + r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r10, int r11) {
            if (updateLayoutHelper() == true) goto L5;
            return;
        L5:
            this.this$0.notifyItemRangeRemoved(this.mStartPosition + r10, r11);
        }

        public void updateStartPositionAndIndex(int r10, int r11) {
            this.mStartPosition = r10;
            this.mIndex = r11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r10, int r11, Object r12) {
            if (updateLayoutHelper() == true) goto L5;
            return;
        L5:
            this.this$0.notifyItemRangeChanged(this.mStartPosition + r10, r11, r12);
        }
    }

    public static class SimpleViewAdapter extends Adapter<RecyclerView.ViewHolder> {
        private LayoutHelper mLayoutHelper;
        private View mView;

        public SimpleViewAdapter(@NonNull View r10, @NonNull LayoutHelper r11) {
            this.mView = r10;
            this.mLayoutHelper = r11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        }

        @Override // com.alibaba.android.vlayout.DelegateAdapter.Adapter
        public LayoutHelper onCreateLayoutHelper() {
            return new SingleLayoutHelper();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            return new SimpleViewHolder(this.mView);
        }

        public SimpleViewAdapter(@NonNull View r10) {
            this(r10, new SingleLayoutHelper());
        }
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View r10) {
            super(r10);
        }
    }

    public DelegateAdapter(VirtualLayoutManager r10) {
        this(r10, false, false);
    }

    public static /* synthetic */ List access$000(DelegateAdapter r10) {
        return r10.mAdapters;
    }

    public static /* synthetic */ int access$100(DelegateAdapter r10) {
        return r10.mTotal;
    }

    public static /* synthetic */ int access$102(DelegateAdapter r10, int r11) {
        r10.mTotal = r11;
        return r11;
    }

    public static /* synthetic */ void access$201(DelegateAdapter r10, List r11) {
        super.setLayoutHelpers(r11);
    }

    public static Adapter<? extends RecyclerView.ViewHolder> simpleAdapter(@NonNull View r10) {
        return new SimpleViewAdapter(r10);
    }

    public void addAdapter(int r10, @Nullable Adapter r11) {
        addAdapters(r10, Collections.singletonList(r11));
    }

    public void addAdapters(int r10, @Nullable List<Adapter> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.size() == 0) goto L24;
        if (r10 >= 0) goto L9;
        r10 = 0;
    L9:
        if (r10 <= this.mAdapters.size()) goto L11;
        r10 = this.mAdapters.size();
    L11:
        ArrayList r12 = new ArrayList();
        Iterator<Pair<AdapterDataObserver, Adapter>> r13 = this.mAdapters.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        r12.add((Adapter) r13.next().second);
        goto L13
    L15:
        Iterator<Adapter> r14 = r11.iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        r12.add(r10, r14.next());
        r10 = r10 + 1;
        goto L17
    L19:
        setAdapters(r12);
        return;
    }

    public void clear() {
        this.mTotal = 0;
        this.mIndex = 0;
        AtomicInteger r10 = this.mIndexGen;
        if (r10 == null) goto L5;
        r10.set(0);
    L5:
        this.mLayoutManager.setLayoutHelpers(null);
        Iterator<Pair<AdapterDataObserver, Adapter>> r11 = this.mAdapters.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Pair<AdapterDataObserver, Adapter> r12 = r11.next();
        ((Adapter) r12.second).unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) r12.first);
        goto L7
    L9:
        this.mItemTypeAry.clear();
        this.mAdapters.clear();
        this.mIndexAry.clear();
    }

    public Adapter findAdapterByIndex(int r10) {
        return (Adapter) this.mIndexAry.get(r10).second;
    }

    @Nullable
    public Pair<AdapterDataObserver, Adapter> findAdapterByPosition(int r10) {
        int r11 = this.mAdapters.size();
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r12 = r11 - 1;
        int r13 = 0;
    L6:
        if (r13 > r12) goto L29;
        int r14 = (r13 + r12) / 2;
        Pair<AdapterDataObserver, Adapter> r15 = this.mAdapters.get(r14);
        int r16 = (((AdapterDataObserver) r15.first).mStartPosition + ((Adapter) r15.second).getItemCount()) - 1;
        Object r17 = r15.first;
        if (((AdapterDataObserver) r17).mStartPosition > r10) goto L9;
        if (r16 < r10) goto L11;
        if (((AdapterDataObserver) r17).mStartPosition > r10) goto L6;
        if (r16 < r10) goto L6;
        return r15;
    L11:
        r13 = r14 + 1;
        goto L6
    L9:
        r12 = r14 - 1;
        goto L6
    L29:
        return null;
    }

    public int findAdapterPositionByIndex(int r10) {
        Pair<AdapterDataObserver, Adapter> r11 = this.mIndexAry.get(r10);
        if (r11 != null) goto L6;
        return -1;
    L6:
        return this.mAdapters.indexOf(r11);
    }

    public int findOffsetPosition(int r10) {
        Pair<AdapterDataObserver, Adapter> r11 = findAdapterByPosition(r10);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r10 - ((AdapterDataObserver) r11.first).mStartPosition;
    }

    public int getAdaptersCount() {
        List<Pair<AdapterDataObserver, Adapter>> r10 = this.mAdapters;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTotal;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        Pair<AdapterDataObserver, Adapter> r11 = findAdapterByPosition(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        long r12 = ((Adapter) r11.second).getItemId(r10 - ((AdapterDataObserver) r11.first).mStartPosition);
        if (r12 >= 0) goto L9;
        return -1;
    L9:
        return Cantor.getCantor(((AdapterDataObserver) r11.first).mIndex, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        Pair<AdapterDataObserver, Adapter> r11 = findAdapterByPosition(r10);
        if (r11 != null) goto L6;
        return -1;
    L6:
        int r12 = ((Adapter) r11.second).getItemViewType(r10 - ((AdapterDataObserver) r11.first).mStartPosition);
        if (r12 >= 0) goto L10;
        return r12;
    L10:
        if (this.mHasConsistItemType == false) goto L14;
        this.mItemTypeAry.put(r12, (Adapter) r11.second);
        return r12;
    L14:
        return (int) Cantor.getCantor(r12, ((AdapterDataObserver) r11.first).mIndex);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        if (this.mHasConsistItemType == false) goto L9;
        Adapter r12 = this.mItemTypeAry.get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.onCreateViewHolder(r10, r11);
    L9:
        Cantor.reverseCantor(r11, this.cantorReverse);
        long[] r13 = this.cantorReverse;
        int r14 = (int) r13[1];
        int r15 = (int) r13[0];
        Adapter r16 = findAdapterByIndex(r14);
        if (r16 != null) goto L13;
        return null;
    L13:
        return r16.onCreateViewHolder(r10, r15);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        super.onViewAttachedToWindow(r10);
        int r11 = r10.getPosition();
        if (r11 <= 0) goto L8;
        Pair<AdapterDataObserver, Adapter> r12 = findAdapterByPosition(r11);
        if (r12 == null) goto L9;
        ((Adapter) r12.second).onViewAttachedToWindow(r10);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r10) {
        super.onViewDetachedFromWindow(r10);
        int r11 = r10.getPosition();
        if (r11 <= 0) goto L8;
        Pair<AdapterDataObserver, Adapter> r12 = findAdapterByPosition(r11);
        if (r12 == null) goto L9;
        ((Adapter) r12.second).onViewDetachedFromWindow(r10);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r10) {
        super.onViewRecycled(r10);
        int r11 = r10.getPosition();
        if (r11 <= 0) goto L8;
        Pair<AdapterDataObserver, Adapter> r12 = findAdapterByPosition(r11);
        if (r12 == null) goto L9;
        ((Adapter) r12.second).onViewRecycled(r10);
        return;
    L9:
        return;
    }

    public void removeAdapter(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= this.mAdapters.size()) goto L8;
        removeAdapter((Adapter) this.mAdapters.get(r10).second);
        return;
    }

    public void removeAdapters(@Nullable List<Adapter> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L33;
        LinkedList r11 = new LinkedList(super.getLayoutHelpers());
        int r12 = r10.size();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L20;
        Adapter r14 = r10.get(r13);
        Iterator<Pair<AdapterDataObserver, Adapter>> r15 = this.mAdapters.iterator();
    L10:
        if (r15.hasNext() == false) goto L19;
        Pair<AdapterDataObserver, Adapter> r16 = r15.next();
        Adapter r17 = (Adapter) r16.second;
        if (r17.equals(r14) == false) goto L10;
        r17.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) r16.first);
        int r18 = findAdapterPositionByIndex(((AdapterDataObserver) r16.first).mIndex);
        if (r18 >= 0) goto L16;
    L18:
        r15.remove();
        goto L19
    L16:
        if (r18 >= r11.size()) goto L18;
        r11.remove(r18);
    L19:
        r13 = r13 + 1;
        goto L7
    L20:
        ArrayList r19 = new ArrayList();
        Iterator<Pair<AdapterDataObserver, Adapter>> r20 = this.mAdapters.iterator();
    L22:
        if (r20.hasNext() == false) goto L24;
        r19.add(r20.next().second);
        goto L22
    L24:
        setAdapters(r19);
        return;
    }

    public void removeFirstAdapter() {
        List<Pair<AdapterDataObserver, Adapter>> r10 = this.mAdapters;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L9;
        removeAdapter((Adapter) this.mAdapters.get(0).second);
        return;
    }

    public void removeLastAdapter() {
        List<Pair<AdapterDataObserver, Adapter>> r10 = this.mAdapters;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L9;
        List<Pair<AdapterDataObserver, Adapter>> r11 = this.mAdapters;
        removeAdapter((Adapter) r11.get(r11.size() - 1).second);
        return;
    }

    public void setAdapters(@Nullable List<Adapter> r10) {
        clear();
        if (r10 != null) goto L5;
        r10 = Collections.emptyList();
    L5:
        LinkedList r11 = new LinkedList();
        this.mTotal = 0;
        Iterator<Adapter> r12 = r10.iterator();
        boolean r13 = true;
    L7:
        if (r12.hasNext() == false) goto L20;
        Adapter r14 = r12.next();
        int r15 = this.mTotal;
        AtomicInteger r16 = this.mIndexGen;
        if (r16 != null) goto L11;
        int r17 = this.mIndex;
        this.mIndex = r17 + 1;
    L12:
        AdapterDataObserver r18 = new AdapterDataObserver(this, r15, r17);
        r14.registerAdapterDataObserver(r18);
        if (r13 == true) goto L15;
    L17:
        r13 = false;
    L18:
        LayoutHelper r19 = r14.onCreateLayoutHelper();
        r19.setItemCount(r14.getItemCount());
        this.mTotal += r19.getItemCount();
        r11.add(r19);
        Pair<AdapterDataObserver, Adapter> r20 = Pair.create(r18, r14);
        this.mIndexAry.put(r18.mIndex, r20);
        this.mAdapters.add(r20);
        goto L7
    L15:
        if (r14.hasStableIds() == false) goto L17;
        r13 = true;
        goto L18
    L11:
        r17 = r16.incrementAndGet();
        goto L12
    L20:
        if (hasObservers() == true) goto L22;
        super.setHasStableIds(r13);
    L22:
        super.setLayoutHelpers(r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean r10) {
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutAdapter
    @Deprecated
    public void setLayoutHelpers(List<LayoutHelper> r10) {
        throw new UnsupportedOperationException("DelegateAdapter doesn't support setLayoutHelpers directly");
    }

    public DelegateAdapter(VirtualLayoutManager r10, boolean r11) {
        this(r10, r11, false);
    }

    public static Adapter<? extends RecyclerView.ViewHolder> simpleAdapter(@NonNull View r10, @NonNull LayoutHelper r11) {
        return new SimpleViewAdapter(r10, r11);
    }

    public void addAdapter(@Nullable Adapter r10) {
        addAdapters(Collections.singletonList(r10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11, List<Object> r12) {
        super.onBindViewHolder(r10, r11, r12);
        Pair<AdapterDataObserver, Adapter> r13 = findAdapterByPosition(r11);
        if (r13 != null) goto L5;
        return;
    L5:
        ((Adapter) r13.second).onBindViewHolder(r10, r11 - ((AdapterDataObserver) r13.first).mStartPosition, r12);
        ((Adapter) r13.second).onBindViewHolderWithOffset(r10, r11 - ((AdapterDataObserver) r13.first).mStartPosition, r11, r12);
    }

    public DelegateAdapter(VirtualLayoutManager r10, boolean r11, boolean r12) {
        super(r10);
        this.mIndex = 0;
        this.mItemTypeAry = new SparseArray();
        this.mAdapters = new ArrayList();
        this.mTotal = 0;
        this.mIndexAry = new SparseArray();
        this.cantorReverse = new long[2];
        if (r12 == false) goto L5;
        this.mIndexGen = new AtomicInteger(0);
    L5:
        this.mHasConsistItemType = r11;
    }

    public void removeAdapter(@Nullable Adapter r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        removeAdapters(Collections.singletonList(r10));
    }

    public void addAdapters(@Nullable List<Adapter> r10) {
        addAdapters(this.mAdapters.size(), r10);
    }
}
