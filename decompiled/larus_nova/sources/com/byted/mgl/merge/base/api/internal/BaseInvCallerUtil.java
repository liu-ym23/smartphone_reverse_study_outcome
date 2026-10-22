package com.byted.mgl.merge.base.api.internal;

import com.byted.mgl.merge.base.api.internal.delegate.IDelegateIpc;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.platform.internal.AMglInvCallerService;

/* JADX INFO: loaded from: classes43.dex */
public final class BaseInvCallerUtil {
    public BaseInvCallerUtil() {
    }

    public static IDelegateIpc getIpcDelegate() {
        return getService().getIpcDelegate();
    }

    private static IBaseInvCallerService getService() {
        return (IBaseInvCallerService) BdpManager.getInst().getService(AMglInvCallerService.class);
    }
}
