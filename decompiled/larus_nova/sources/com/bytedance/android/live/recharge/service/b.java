package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.event.v;
import io.reactivex.functions.Consumer;
import zg1.x2;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f90351a;

    public b(a r100) {
        this.f90351a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        if ((r100 instanceof x2) == false) goto L6;
        a.a(this.f90351a, (x2) r100);
        return;
    L6:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        this.f90351a.getClass();
        int r102 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.e("ttlive_recharge", "recharge success, fetch wallet info.");
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync(PbRequest.SwitchType.RECHARGE);
        return;
    }
}
