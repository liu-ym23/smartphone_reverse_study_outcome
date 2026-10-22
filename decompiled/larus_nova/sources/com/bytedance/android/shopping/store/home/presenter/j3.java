package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class j3<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 f184215a;

    public j3(ECShopTopBarSearchPresenterV2 r100) {
        this.f184215a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((ShopLiveState) r100).f185518a != ShopLiveState.PlayState.ERROR) goto L6;
        ECShopTopBarSearchPresenterV2.s0(this.f184215a, 1.0f);
        return;
    }
}
