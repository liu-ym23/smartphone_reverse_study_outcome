package com.bytedance.android.live.recharge.panel.dynamic;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.data.RechargePanelDataUseCase")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ObserveDealSet")
    com.bytedance.revenue.platform.api.core.rx.a<com.bytedance.android.live.recharge.deal.aio.c> observeDealSet();

    @BindsRpc(rpcName = "RequestDealSet")
    void requestDealSet();
}
