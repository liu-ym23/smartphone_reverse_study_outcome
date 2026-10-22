package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements IExchangeService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Order.a f90458a;

    public g(com.bytedance.android.live.recharge.order.f.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        this.f90458a = r100;
        r100.b(IExchangeService.ExchangeProgress.START);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService.a
    public final void a(IExchangeService.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f90458a.b(IExchangeService.ExchangeProgress.SUCCESS);
        this.f90458a.a(r100);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService.a
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.f90458a.b(IExchangeService.ExchangeProgress.FAIL);
        this.f90458a.d(r100);
    }
}
