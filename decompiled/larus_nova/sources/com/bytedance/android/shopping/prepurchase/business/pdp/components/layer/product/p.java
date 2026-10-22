package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes13.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<WeakReference<RecyclerView>> f181787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f181788b;

    public p() {
    }

    static {
        f181787a = new ArrayList();
    }

    public static final void a(RecyclerView r100, int r101) {
        if (r101 < 1) goto L19;
        RecyclerView.Adapter r102 = r100.getAdapter();
        if ((r102 instanceof ProductDetailInfoAdapter) == true) goto L8;
        r102 = null;
    L8:
        ProductDetailInfoAdapter r103 = (ProductDetailInfoAdapter) r102;
        if (r103 == null) goto L22;
        IntRange r104 = CollectionsKt.getIndices(r103.getCurrentList());
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<Integer> r106 = r104.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        r105.add(Integer.valueOf(r103.getBasicItemViewType(((IntIterator) r106).nextInt())));
        goto L13
    L15:
        Iterator r107 = CollectionsKt.distinct(r105).iterator();
    L17:
        if (r107.hasNext() == false) goto L23;
        int r108 = ((Number) r107.next()).intValue();
        r100.getRecycledViewPool().setMaxRecycledViews(r108, r101);
        goto L17
    L23:
        return;
    L22:
        return;
    }
}
