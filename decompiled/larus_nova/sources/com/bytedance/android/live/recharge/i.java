package com.bytedance.android.live.recharge;

import android.content.Context;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.RechargeService")
public interface i extends uh7.a, com.bytedance.android.scope.o {
    long getAvailableDiamonds();

    String getCoinCurrency();

    py.l getCoinImage();

    Observable<Long> observeAvailableDiamonds(boolean r100, String r101);

    void openRechargeDialog(Context r100, q0 r101);

    @BindsRpc(rpcName = "openRechargeDialog")
    void openRechargeDialog(i57.a r100, m r101);

    void refreshAvailableDiamonds(String r100);
}
