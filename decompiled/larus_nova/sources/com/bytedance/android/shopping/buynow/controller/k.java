package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CheckPayStatusController f170841a;

    public k(CheckPayStatusController r100) {
        this.f170841a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SsResponse r101 = (SsResponse) r100;
        if (((ma3.p) r101.body()).e() == false) goto L9;
        ma3.p r102 = (ma3.p) r101.body();
        BuyNowLog.d("selfPayAndCheck", "check pay status response received");
        CheckPayStatusController r103 = this.f170841a;
        if (r102 == null) goto L7;
        ma3.o r104 = r102.a();
    L8:
        r103.f(4, r104, true);
        this.f170841a.d();
        goto L9
    L7:
        r104 = null;
    L9:
        this.f170841a.c(BuyNowCloseMethod.PAY_FAIL);
    }
}
