package com.bytedance.android.window.shop.search.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowSearchResultOrderTypePresenter f189747a;

    public k(WindowSearchResultOrderTypePresenter r100) {
        this.f189747a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Iterator<T> r101 = ((List) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.bytedance.android.ec.window.base.repository.vo.k r102 = (com.bytedance.android.ec.window.base.repository.vo.k) r101.next();
        this.f189747a.e0().doEventAction("show_ecommerce_store_sort", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "search")});
        goto L4
    }
}
