package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryView;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements HistoryBanner.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopSearchHistoryPresenter f186074a;

    @Override // com.bytedance.android.ec.store.search.history.HistoryBanner.b
    public final void a() {
        HistoryView r100 = this.f186074a.f186012f;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.bytedance.android.ec.store.search.history.HistoryBanner.b
    public final void b() {
        HistoryView r100 = this.f186074a.f186012f;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.bytedance.android.ec.store.search.history.HistoryBanner.b
    public final void c() {
        HistoryView r100 = this.f186074a.f186012f;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public c(ShopSearchHistoryPresenter r100) {
        this.f186074a = r100;
    }
}
