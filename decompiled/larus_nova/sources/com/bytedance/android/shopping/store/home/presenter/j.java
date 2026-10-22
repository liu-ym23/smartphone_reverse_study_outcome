package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.home.view.ECStoreHeaderFrameLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements ECStoreHeaderFrameLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopAutoCollapsePresenter f184210a;

    @Override // com.bytedance.android.shopping.store.home.view.ECStoreHeaderFrameLayout.a
    public final void onClick() {
        this.f184210a.B = true;
    }

    public j(ECShopAutoCollapsePresenter r100) {
        this.f184210a = r100;
    }
}
