package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f127317a;

    public o(u r100) {
        this.f127317a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final ExchangeInfo r101 = (ExchangeInfo) r100;
        this.f127317a.f127329j.onNext(v.a(r101));
        this.f127317a.g("observeExchange", new GiftRechargeDataStore$observeExchange$1$1(this, r101));
    }
}
