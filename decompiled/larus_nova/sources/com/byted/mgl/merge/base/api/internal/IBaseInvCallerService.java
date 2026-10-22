package com.byted.mgl.merge.base.api.internal;

import com.byted.mgl.merge.base.api.internal.delegate.IDelegateIpc;
import com.bytedance.bdp.serviceapi.defaults.platform.internal.AMglInvCallerService;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpHostMethodResult;
import kb4.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface IBaseInvCallerService extends AMglInvCallerService {
    /* synthetic */ BdpHostMethodResult callHostMethodInMainProc(String r100, JSONObject r101);

    /* synthetic */ void callHostMethodInMainProc(String r100, JSONObject r101, a r102);

    /* synthetic */ void dispatchHostEvent(String r100, JSONObject r101);

    /* synthetic */ String getDeviceId();

    /* synthetic */ String getInstallId();

    IDelegateIpc getIpcDelegate();

    @Override // com.bytedance.bdp.serviceapi.defaults.platform.internal.AMglInvCallerService
    /* synthetic */ JSONObject getSettings(String r100);
}
