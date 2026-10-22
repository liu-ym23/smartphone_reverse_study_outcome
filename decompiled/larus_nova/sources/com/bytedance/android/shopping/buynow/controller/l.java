package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CheckPayStatusController f170842a;

    public l(CheckPayStatusController r100) {
        this.f170842a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f170842a.c(BuyNowCloseMethod.PAY_FAIL);
    }
}
