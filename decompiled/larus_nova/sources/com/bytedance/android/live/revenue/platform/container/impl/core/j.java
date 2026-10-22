package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "core.service.NativeHostService")
public interface j extends uh7.a {
    @BindsRpc(rpcName = "NotifyServiceCenterState")
    void notifyServiceCenterState(NotifyServiceCenterStateRequest r100, i57.a r101);
}
