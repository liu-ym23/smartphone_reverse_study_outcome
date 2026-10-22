package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f89988a;

    public k0(a0 r100) {
        this.f89988a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExchangeInfo r101 = (ExchangeInfo) r100;
        int r102 = r101.getExchangeBalance();
        int r103 = r102 % 10;
        if (r103 <= 0) goto L5;
        r101.setExchangeBalance(r102 - r103);
    L5:
        this.f89988a.f89608l.a(r101);
        this.f89988a.G.onNext(r101);
    }
}
