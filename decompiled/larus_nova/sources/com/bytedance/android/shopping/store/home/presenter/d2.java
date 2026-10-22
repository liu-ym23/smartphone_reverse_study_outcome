package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopSliceTopBarPresenter.b f184138a;

    public d2(ECShopSliceTopBarPresenter.b r100) {
        this.f184138a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.android.shopping.store.home.a0 r101 = (com.bytedance.android.shopping.store.home.a0) r100;
        Intrinsics.checkNotNullParameter(r101, "followConfig");
        com.bytedance.android.shopping.store.home.slice.h.a(this.f184138a.f184015a.B, r101, "ECShopSliceTopInfoPresenter");
        ECShopSliceTopBarPresenter.q0(this.f184138a.f184015a);
    }
}
