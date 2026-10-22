package com.bytedance.android.ec.hybrid.list.util;

import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/util/SortedListWithPosition;", "Ljava/util/ArrayList;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "Lkotlin/collections/ArrayList;", "()V", "add", "", "element", "addAll", "c", "", "remove", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortedListWithPosition extends ArrayList<BaseViewHolder> {

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((BaseViewHolder) r100).getAdapterPosition()), Integer.valueOf(((BaseViewHolder) r101).getAdapterPosition()));
        }
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((BaseViewHolder) r100).getAdapterPosition()), Integer.valueOf(((BaseViewHolder) r101).getAdapterPosition()));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((BaseViewHolder) r100).getAdapterPosition()), Integer.valueOf(((BaseViewHolder) r101).getAdapterPosition()));
        }
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public SortedListWithPosition() {
    }

    public boolean add(BaseViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (super.contains(r100) == false) goto L6;
        return false;
    L6:
        boolean r101 = super.add(r100);
        if (size() <= 1) goto L9;
        CollectionsKt.sortWith(this, new a());
    L9:
        return r101;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends BaseViewHolder> r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        boolean r101 = super.addAll(r100);
        if (size() <= 1) goto L5;
        CollectionsKt.sortWith(this, new b());
    L5:
        return r101;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof BaseViewHolder) == true) goto L7;
        return false;
    L7:
        return contains((BaseViewHolder) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof BaseViewHolder) == true) goto L7;
        return -1;
    L7:
        return indexOf((BaseViewHolder) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof BaseViewHolder) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((BaseViewHolder) r100);
    }

    public boolean remove(BaseViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        boolean r101 = super.remove(r100);
        if (size() <= 1) goto L5;
        CollectionsKt.sortWith(this, new c());
    L5:
        return r101;
    }

    public /* bridge */ BaseViewHolder removeAt(int r100) {
        return remove(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        return add((BaseViewHolder) r100);
    }

    public /* bridge */ boolean contains(BaseViewHolder r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(BaseViewHolder r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(BaseViewHolder r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof BaseViewHolder) == true) goto L7;
        return false;
    L7:
        return remove((BaseViewHolder) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ BaseViewHolder remove(int r100) {
        return removeAt(r100);
    }
}
