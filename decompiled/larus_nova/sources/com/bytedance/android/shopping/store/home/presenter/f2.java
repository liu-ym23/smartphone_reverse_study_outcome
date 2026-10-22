package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class f2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopSliceTopBarPresenter.b f184166a;

    public f2(ECShopSliceTopBarPresenter.b r100) {
        this.f184166a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        ECShopSliceTopBarPresenter.r0(this.f184166a.f184015a);
    }
}
