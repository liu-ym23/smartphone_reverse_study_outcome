package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.revenue.common.v;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExchangeStatusService f89964a;

    public o(ExchangeStatusService r100) {
        this.f89964a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Map<String, Object> r101 = ((wy0.g) r100).getData();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("enable");
    L7:
        if ((r103 instanceof Boolean) == false) goto L10;
        r102 = r103;
    L10:
        Boolean r104 = (Boolean) r102;
        int r105 = v.f91009a;
        v.e("ttlive_exchange", "receive auto exchange switch changed,enable: " + r104);
        if (r104 == null) goto L14;
        this.f89964a.a().updateExchangeStatus(r104.booleanValue());
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
