package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f185389a = null;

    static {
        f185389a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        dm.a.a("ECShopMemberCardPresenter").a("applyCoupon：" + r101);
        EnsureManager.ensureNotReachHere(r101);
    }
}
