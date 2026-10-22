package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class x1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1.b f184457a;

    public x1(w1.b r100) {
        this.f184457a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ShopHeaderVideoVO r101 = (ShopHeaderVideoVO) r100;
        w1.q0(this.f184457a.f184448a);
    }
}
