package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public final class g2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopSliceTopBarPresenter.b f184182a;

    public g2(ECShopSliceTopBarPresenter.b r100) {
        this.f184182a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        ECShopSliceTopBarPresenter.r0(this.f184182a.f184015a);
    }
}
