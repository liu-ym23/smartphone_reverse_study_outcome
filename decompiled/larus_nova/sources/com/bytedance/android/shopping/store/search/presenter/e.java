package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchHistoryPresenter f186078a;

    public e(ShopSearchHistoryPresenter r100) {
        this.f186078a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        sj3.h r103 = (sj3.h) r102.next();
        ShopSearchHistoryPresenter r104 = this.f186078a;
        HistoryView r105 = r104.f186012f;
        if (r105 == null) goto L10;
        r105.c(r103);
    L10:
        HistoryBanner r106 = r104.f186013g;
        if (r106 == null) goto L13;
        r106.setVisibility(0);
    L13:
        HistoryView r107 = r104.f186012f;
        if (r107 == null) goto L6;
        r107.setVisibility(0);
        goto L6
    L22:
        return;
    }
}
