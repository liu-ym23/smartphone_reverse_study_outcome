package com.tmall.wireless.tangram.core.adapter;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.tmall.wireless.tangram.core.protocol.ControlBinder;
import com.tmall.wireless.tangram.core.protocol.ControlBinderResolver;
import com.tmall.wireless.tangram.core.protocol.LayoutBinder;
import com.tmall.wireless.tangram.core.protocol.LayoutBinderResolver;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GroupBasicAdapter<L, C> extends VirtualLayoutAdapter<BinderViewHolder<C, ? extends View>> {
    private LayoutBinderResolver<L, ? extends LayoutBinder<L>> mCardBinderResolver;

    @NonNull
    protected ArrayList<Pair<Range<Integer>, L>> mCards;
    private ControlBinderResolver<? extends ControlBinder<C, ? extends View>> mCompBinderResolver;

    @NonNull
    private final Context mContext;

    @NonNull
    protected List<C> mData;
    private final SparseArray<L> newMap;
    private final SparseArray<L> oldMap;
    private final SparseBooleanArray pendingDeleteMap;

    public GroupBasicAdapter(@NonNull Context r10, @NonNull VirtualLayoutManager r11, @NonNull ControlBinderResolver<? extends ControlBinder<C, ? extends View>> r12, @NonNull LayoutBinderResolver<L, ? extends LayoutBinder<L>> r13) {
        super(r11);
        this.mCards = new ArrayList();
        this.mData = new LinkedList();
        this.pendingDeleteMap = new SparseBooleanArray();
        this.oldMap = new SparseArray(64);
        this.newMap = new SparseArray(64);
        this.mContext = (Context) Preconditions.checkNotNull(r10, "context should not be null");
        this.mCompBinderResolver = (ControlBinderResolver) Preconditions.checkNotNull(r12, "componentBinderResolver should not be null");
        this.mCardBinderResolver = (LayoutBinderResolver) Preconditions.checkNotNull(r13, "layoutBinderResolver should not be null");
    }

    private void createSnapshot() {
        this.oldMap.clear();
        List<L> r10 = getGroups();
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        L r13 = r10.get(r12);
        this.oldMap.put(System.identityHashCode(r13), r13);
        r12 = r12 + 1;
        goto L3
    }

    private void diffWithSnapshot() {
        this.pendingDeleteMap.clear();
        this.newMap.clear();
        List<L> r10 = getGroups();
        int r11 = r10.size();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        L r14 = r10.get(r13);
        this.newMap.put(System.identityHashCode(r14), r14);
        r13 = r13 + 1;
        goto L3
    L5:
        int r15 = this.newMap.size();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L11;
        int r17 = this.newMap.keyAt(r16);
        if (this.oldMap.get(r17) == null) goto L10;
        this.oldMap.remove(r17);
        this.pendingDeleteMap.put(r17, true);
    L10:
        r16 = r16 + 1;
        goto L6
    L11:
        int r18 = this.pendingDeleteMap.size();
    L12:
        if (r12 >= r18) goto L14;
        this.newMap.remove(this.pendingDeleteMap.keyAt(r12));
        r12 = r12 + 1;
        goto L12
    L14:
        diffGroup(this.newMap, this.oldMap);
        this.oldMap.clear();
        this.newMap.clear();
    }

    public void appendGroup(@Nullable List<L> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.size() == 0) goto L9;
        createSnapshot();
        LinkedList r11 = new LinkedList(getLayoutHelpers());
        ArrayList<Pair<Range<Integer>, L>> r12 = this.mCards;
        r12.ensureCapacity(r12.size() + r10.size());
        r11.addAll(transformCards(r10, this.mData, this.mCards));
        setLayoutHelpers(r11);
        diffWithSnapshot();
        notifyDataSetChanged();
        return;
    }

    public abstract <V extends View> BinderViewHolder<C, V> createViewHolder(@NonNull ControlBinder<C, V> r10, @NonNull Context r11, ViewGroup r12);

    public void destroy() {
    }

    public void diffGroup(SparseArray<L> r10, SparseArray<L> r11) {
    }

    public int findCardIdxFor(int r10) {
        int r11 = this.mCards.size() - 1;
        int r12 = 0;
    L4:
        if (r12 > r11) goto L17;
        int r13 = (r12 + r11) >>> 1;
        Pair<Range<Integer>, L> r14 = this.mCards.get(r13);
        if (r14 == null) goto L7;
        if (((Integer) ((Range) r14.first).getLower()).intValue() > r10) goto L14;
        if (((Integer) ((Range) r14.first).getUpper()).intValue() <= r10) goto L14;
        return r13;
    L14:
        if (((Integer) ((Range) r14.first).getUpper()).intValue() <= r10) goto L15;
        r11 = r13 - 1;
        goto L4
    L15:
        r12 = r13 + 1;
        goto L4
    L7:
        return -1;
    L17:
        return -1;
    }

    public Pair<Range<Integer>, L> getCardRange(int r10) {
        if (r10 >= 0) goto L4;
        return null;
    L4:
        if (r10 <= (this.mCards.size() - 1)) goto L6;
        return null;
    L6:
        return this.mCards.get(r10);
    }

    public abstract int getCardType(L r10);

    public List<C> getComponents() {
        return new ArrayList(this.mData);
    }

    public List<L> getGroups() {
        ArrayList r10 = new ArrayList(this.mCards.size());
        int r11 = this.mCards.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(this.mCards.get(r12).second);
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    public C getItemByPosition(int r10) {
        return this.mData.get(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return super.getItemId(r10);
    }

    public abstract int getItemType(C r10);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        return getItemType(this.mData.get(r10));
    }

    public abstract List<C> getItems(@NonNull L r10);

    public int getPositionByItem(C r10) {
        return this.mData.indexOf(r10);
    }

    public void insertGroup(int r10, @Nullable List<L> r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= this.mCards.size()) goto L14;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.size() == 0) goto L17;
        List<L> r12 = getGroups();
        if (r12.addAll(r10, r11) == false) goto L16;
        setData(r12);
        return;
    L16:
        return;
    L17:
        return;
    }

    public void notifyUpdate() {
        notifyUpdate(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((BinderViewHolder) r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r10) {
        onViewRecycled((BinderViewHolder) r10);
    }

    public void refreshWithoutNotify() {
        setData(getGroups(), true);
    }

    public abstract void removeComponent(int r10);

    public abstract void removeComponent(C r10);

    public void removeGroup(@Nullable L r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List<L> r11 = getGroups();
        if (r11.remove(r10) == false) goto L8;
        setData(r11);
        return;
    }

    public void replaceGroup(int r10, @Nullable List<L> r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 >= this.mCards.size()) goto L14;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.size() == 0) goto L17;
        List<L> r12 = getGroups();
        if (r12.addAll(r10 + 1, r11) == false) goto L16;
        r12.remove(r10);
        setData(r12);
        return;
    L16:
        return;
    L17:
        return;
    }

    public void setData(@Nullable List<L> r10) {
        setData(r10, false);
    }

    @NonNull
    public List<LayoutHelper> transformCards(@Nullable List<L> r10, @NonNull List<C> r11, @NonNull List<Pair<Range<Integer>, L>> r12) {
        if (r10 == null) goto L21;
        if (r10.size() == 0) goto L21;
        int r13 = r11.size();
        ArrayList r14 = new ArrayList(r10.size());
        int r15 = r10.size();
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L19;
        L r17 = r10.get(r16);
        if (r17 == null) goto L18;
        int r18 = getCardType(r17);
        List<C> r19 = getItems(r17);
        if (r19 == null) goto L18;
        r11.addAll(r19);
        int r20 = r19.size() + r13;
        r12.add(Pair.create(Range.create(Integer.valueOf(r13), Integer.valueOf(r20)), r17));
        LayoutHelper r21 = this.mCardBinderResolver.create(r18).getHelper(r18, r17);
        if (r21 == null) goto L17;
        r21.setItemCount(r19.size());
        r14.add(r21);
    L17:
        r13 = r20;
    L18:
        r16 = r16 + 1;
        goto L7
    L19:
        return r14;
    L21:
        return new LinkedList();
    }

    public void notifyUpdate(boolean r10) {
        if (r10 == false) goto L4;
        setData(getGroups());
        return;
    L4:
        notifyDataSetChanged();
    }

    public void onBindViewHolder(BinderViewHolder<C, ? extends View> r10, int r11) {
        r10.bind(this.mData.get(r11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BinderViewHolder<C, ? extends View> onCreateViewHolder(ViewGroup r10, int r11) {
        return (BinderViewHolder<C, ? extends View>) createViewHolder(this.mCompBinderResolver.create(r11), this.mContext, r10);
    }

    public void onViewRecycled(BinderViewHolder<C, ? extends View> r10) {
        r10.unbind();
    }

    public void setData(@Nullable List<L> r10, boolean r11) {
        createSnapshot();
        this.mCards.clear();
        this.mData.clear();
        if (r10 != null) goto L5;
    L7:
        setLayoutHelpers(Collections.emptyList());
    L8:
        diffWithSnapshot();
        if (r11 == true) goto L12;
        notifyDataSetChanged();
        return;
    L12:
        return;
    L5:
        if (r10.isEmpty() == true) goto L7;
        this.mCards.ensureCapacity(r10.size());
        setLayoutHelpers(transformCards(r10, this.mData, this.mCards));
        goto L8
    }

    public Range<Integer> getCardRange(Card r10) {
        if (r10 == null) goto L5;
        int r11 = getGroups().indexOf(r10);
        if (r11 < 0) goto L11;
        return (Range) this.mCards.get(r11).first;
    L11:
        return Range.create(0, 1);
    L5:
        return Range.create(0, 1);
    }

    public void removeGroup(int r10) {
        List<L> r11 = getGroups();
        if (r10 >= 0) goto L5;
        return;
    L5:
        if (r10 < r11.size()) goto L7;
        return;
    L7:
        if (r11.remove(r10) == null) goto L12;
        setData(r11);
        return;
    }
}
