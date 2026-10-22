package com.bytedance.android.shopping.store.home.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopAutoCollapsePresenter f184161a;

    public f(ECShopAutoCollapsePresenter r100) {
        this.f184161a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ECShopAutoCollapsePresenter r102 = this.f184161a;
        if (r102.B == false) goto L5;
        return;
    L5:
        if ((!r102.f183879x.isEmpty()) == true) goto L9;
        this.f184161a.r0();
        return;
    }
}
