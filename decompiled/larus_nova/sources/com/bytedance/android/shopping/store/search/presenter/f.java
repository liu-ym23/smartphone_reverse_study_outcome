package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchHistoryPresenter f186080a;

    public f(ShopSearchHistoryPresenter r100) {
        this.f186080a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.FALSE) == false) goto L10;
        HistoryView r101 = this.f186080a.f186012f;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.f48548c != true) goto L12;
        r101.d();
        return;
    L12:
        return;
    }
}
