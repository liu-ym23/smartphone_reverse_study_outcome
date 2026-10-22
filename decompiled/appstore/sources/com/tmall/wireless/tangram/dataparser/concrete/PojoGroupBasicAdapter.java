package com.tmall.wireless.tangram.dataparser.concrete;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.core.adapter.BinderViewHolder;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.protocol.ControlBinder;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class PojoGroupBasicAdapter extends GroupBasicAdapter<Card, BaseCell> {
    private final SparseIntArray mId2Types;
    private final Map<String, Card> mIdCardCache;
    private final SparseIntArray mIntKeys;
    private int mLastBindPosition;
    private MVHelper mMVHelper;
    private final Map<String, Integer> mStrKeys;
    private AtomicInteger mTypeId;

    public PojoGroupBasicAdapter(@NonNull Context r10, @NonNull VirtualLayoutManager r11, @NonNull BaseCellBinderResolver r12, @NonNull BaseCardBinderResolver r13, @NonNull MVHelper r14) {
        super(r10, r11, r12, r13);
        this.mLastBindPosition = -1;
        this.mTypeId = new AtomicInteger(0);
        this.mStrKeys = new ArrayMap(64);
        this.mIntKeys = new SparseIntArray(64);
        this.mId2Types = new SparseIntArray(64);
        this.mIdCardCache = new ArrayMap(64);
        this.mMVHelper = r14;
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public void appendGroup(@Nullable List<Card> r10) {
        super.appendGroup(r10);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public <V extends View> BinderViewHolder<BaseCell, V> createViewHolder(@NonNull ControlBinder<BaseCell, V> r10, @NonNull Context r11, ViewGroup r12) {
        return new BinderViewHolder(r10.createView(r11, r12), r10);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public void destroy() {
        super.destroy();
        int r10 = this.mCards.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((Card) ((Pair) this.mCards.get(r11)).second).removed();
        r11 = r11 + 1;
        goto L3
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public void diffGroup(SparseArray<Card> r10, SparseArray<Card> r11) {
        int r12 = r11.size();
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L8;
        Card r15 = r11.get(r11.keyAt(r14));
        if (r15 == null) goto L7;
        r15.removed();
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        int r16 = r10.size();
    L9:
        if (r13 >= r16) goto L14;
        Card r17 = r10.get(r10.keyAt(r13));
        if (r17 == null) goto L13;
        r17.added();
    L13:
        r13 = r13 + 1;
        goto L9
    }

    public int findFirstPositionOfCell(int r10) {
        List<BaseCell> r11 = getComponents();
        if (r11 != null) goto L5;
        return -1;
    L5:
        if (r11.isEmpty() == true) goto L17;
        int r12 = r11.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L18;
        if (r10 == r11.get(r13).type) goto L16;
        r13 = r13 + 1;
        goto L8
    L16:
        return r13;
    L18:
        return -1;
    L17:
        return -1;
    }

    public int findLastPositionOfCell(int r10) {
        List<BaseCell> r11 = getComponents();
        if (r11 != null) goto L5;
        return -1;
    L5:
        if (r11.isEmpty() == true) goto L17;
        int r12 = r11.size() - 1;
    L8:
        if (r12 < 0) goto L18;
        if (r10 == r11.get(r12).type) goto L16;
        r12 = r12 - 1;
        goto L8
    L16:
        return r12;
    L18:
        return -1;
    L17:
        return -1;
    }

    public Range<Integer> getCardRange(String r10) {
        int r11 = 0;
        if (TextUtils.isEmpty(r10) == true) goto L5;
        List<Card> r12 = getGroups();
        int r13 = r12.size();
    L7:
        if (r11 >= r13) goto L14;
        Card r14 = r12.get(r11);
        if (r10.equals(r14.f18212id) == true) goto L11;
        r11 = r11 + 1;
        goto L7
    L11:
        return getCardRange(r14);
    L14:
        return Range.create(0, 0);
    L5:
        return Range.create(0, 0);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public /* bridge */ /* synthetic */ int getCardType(Card r10) {
        return getCardType2(r10);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return getItemByPosition(r10).objectId;
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public /* bridge */ /* synthetic */ int getItemType(BaseCell r10) {
        return getItemType2(r10);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public /* bridge */ /* synthetic */ List<BaseCell> getItems(@NonNull Card r10) {
        return getItems2(r10);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((BinderViewHolder) r10, r11);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public /* bridge */ /* synthetic */ void removeComponent(BaseCell r10) {
        removeComponent2(r10);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    @NonNull
    public List<LayoutHelper> transformCards(@Nullable List<Card> r10, @NonNull List<BaseCell> r11, @NonNull List<Pair<Range<Integer>, Card>> r12) {
        if (r10 == null) goto L4;
        Iterator<Card> r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        Card r14 = r13.next();
        if (TextUtils.isEmpty(r14.f18212id) == true) goto L7;
        this.mIdCardCache.put(r14.f18212id, r14);
        goto L7
    L11:
        List<LayoutHelper> r15 = super.transformCards(r10, r11, r12);
        this.mIdCardCache.clear();
        return r15;
    L4:
        return super.transformCards(r10, r11, r12);
    }

    /* JADX INFO: renamed from: getCardType, reason: avoid collision after fix types in other method */
    public int getCardType2(Card r10) {
        return r10.type;
    }

    /* JADX INFO: renamed from: getItemType, reason: avoid collision after fix types in other method */
    public int getItemType2(BaseCell r10) {
        if (TextUtils.isEmpty(r10.typeKey) == true) goto L10;
        String r11 = r10.typeKey;
        if (this.mStrKeys.containsKey(r11) == true) goto L8;
        int r12 = this.mTypeId.getAndIncrement();
        this.mStrKeys.put(r11, Integer.valueOf(r12));
        this.mId2Types.put(r12, r10.type);
    L8:
        return this.mStrKeys.get(r11).intValue();
    L10:
        if (this.mIntKeys.indexOfKey(r10.type) >= 0) goto L13;
        int r13 = this.mTypeId.getAndIncrement();
        this.mIntKeys.put(r10.type, r13);
        this.mId2Types.put(r13, r10.type);
    L13:
        return this.mIntKeys.get(r10.type);
    }

    /* JADX INFO: renamed from: getItems, reason: avoid collision after fix types in other method */
    public List<BaseCell> getItems2(@NonNull Card r10) {
        Style r11 = r10.style;
        if (r11 == null) goto L16;
        if (TextUtils.isEmpty(r11.forLabel) == true) goto L16;
        String r12 = r10.style.forLabel;
        if (this.mIdCardCache.containsKey(r12) == false) goto L16;
        Card r13 = this.mIdCardCache.get(r12);
        if (r13.mCells.size() != 0) goto L16;
        if (TextUtils.isEmpty(r13.load) == false) goto L14;
        return null;
    L14:
        return Collections.emptyList();
    L16:
        if (TextUtils.isEmpty(r10.load) == false) goto L21;
        if (r10.mCells.isEmpty() == false) goto L21;
        return null;
    L21:
        return new LinkedList(r10.mCells);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public void onBindViewHolder(BinderViewHolder<BaseCell, ? extends View> r10, int r11) {
        super.onBindViewHolder(r10, r11);
        int r12 = findCardIdxFor(r11);
        if (r12 < 0) goto L11;
        Pair r13 = (Pair) this.mCards.get(r12);
        Card r14 = (Card) r13.second;
        int r15 = r11 - ((Integer) ((Range) r13.first).getLower()).intValue();
        int r16 = this.mLastBindPosition;
        if (r16 < 0) goto L9;
        if (r16 < r11) goto L9;
        boolean r17 = false;
    L10:
        r14.onBindCell(r15, r11, r17);
    L9:
        r17 = true;
    L11:
        this.mLastBindPosition = r11;
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BinderViewHolder<BaseCell, ? extends View> onCreateViewHolder(ViewGroup r10, int r11) {
        if (this.mId2Types.indexOfKey(r11) < 0) goto L7;
        return super.onCreateViewHolder(r10, this.mId2Types.get(r11));
    L7:
        throw new IllegalStateException("Can not found item.type for viewType: " + r11);
    }

    @Override // com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter
    public void removeComponent(int r10) {
        List<C> r11 = this.mData;
        if (r11 == 0) goto L17;
        if (r10 < 0) goto L18;
        boolean r12 = true;
        if (r10 > (r11.size() - 1)) goto L19;
        BaseCell r13 = (BaseCell) this.mData.remove(r10);
        if (r13 != null) goto L11;
        r12 = false;
    L11:
        int r14 = findCardIdxFor(r10);
        if (r14 < 0) goto L14;
        ((Card) ((Pair) this.mCards.get(r14)).second).removeCellSilently(r13);
    L14:
        if (r12 == false) goto L20;
        notifyItemRemoved(r10);
        notifyItemRangeChanged(r10, this.mLayoutManager.findLastVisibleItemPosition() - r10);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    /* JADX INFO: renamed from: removeComponent, reason: avoid collision after fix types in other method */
    public void removeComponent2(BaseCell r10) {
        List<C> r11 = this.mData;
        if (r11 == 0) goto L12;
        if (r10 == null) goto L13;
        int r12 = r11.indexOf(r10);
        if (r12 < 0) goto L14;
        this.mData.remove(r10);
        int r13 = findCardIdxFor(r12);
        if (r13 < 0) goto L10;
        ((Card) ((Pair) this.mCards.get(r13)).second).removeCellSilently(r10);
    L10:
        notifyItemRemoved(r12);
        notifyItemRangeChanged(r12, this.mLayoutManager.findLastVisibleItemPosition() - r12);
        return;
    L14:
        return;
    L13:
        return;
    }
}
