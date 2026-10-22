package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class e2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopSliceTopBarPresenter.b f184155a;

    public e2(ECShopSliceTopBarPresenter.b r100) {
        this.f184155a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        float r101 = ((Number) r100).floatValue();
        dm.a.a("ShopScrollTextViewManager").a("测试一下滑动_percent: " + r101);
        this.f184155a.f184015a.B.put("profile_scroll_percent", Float.valueOf(r101));
        ECShopSliceTopBarPresenter.q0(this.f184155a.f184015a);
    }
}
