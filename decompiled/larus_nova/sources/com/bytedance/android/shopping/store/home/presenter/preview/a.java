package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopExplainCardPresenter f184344a;

    public a(ECShopExplainCardPresenter r100) {
        this.f184344a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ShopLiveState r101 = (ShopLiveState) r100;
        if (r101.f185519b == ShopLiveState.LiveScene.LIVE_TAB) goto L5;
        return;
    L5:
        if (r101.f185518a != ShopLiveState.PlayState.ERROR) goto L12;
        cf.d r102 = this.f184344a.f184272l;
        if (r102 == null) goto L9;
        r102.onDestroy();
    L9:
        this.f184344a.f184272l = null;
        return;
    }
}
