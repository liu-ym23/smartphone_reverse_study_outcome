package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.exchange.view.ExchangeConfirmDefaultView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements ExchangeConfirmDefaultView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f89907a;

    public c(Ref.BooleanRef r100) {
        this.f89907a = r100;
    }

    @Override // com.bytedance.android.live.recharge.exchange.view.ExchangeConfirmDefaultView.a
    public final void a(boolean r100) {
        lw0.a.f510984c.setValue(null, lw0.a.f510982a[1], Boolean.FALSE);
        this.f89907a.element = r100;
        xs2.b.a().post(new cx0.a(Boolean.valueOf(r100)));
    }
}
