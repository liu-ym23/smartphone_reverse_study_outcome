package com.bytedance.android.shopping.store.hybridproduct;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f185418a = null;

    static {
        f185418a = new x();
    }

    public x() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        dm.a.b r101 = dm.a.a("product_list_presenter");
        r101.b("renderResultAsync error", (Throwable) r100);
    }
}
