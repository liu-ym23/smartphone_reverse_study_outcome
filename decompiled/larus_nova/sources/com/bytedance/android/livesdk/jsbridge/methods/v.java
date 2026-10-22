package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.business.IHostAliYunVerifyProxy;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getAliCloudMetaInfo")
public final class v extends com.bytedance.ies.web.jsbridge2.f<Object, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        if (com.bytedance.android.live.core.verify.utils.a.j() == false) goto L6;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "aliyun service proxy is unavaliable"));
        return;
    L6:
        IHostAliYunVerifyProxy r102 = (IHostAliYunVerifyProxy) jc1.k.f(IHostAliYunVerifyProxy.class);
        r102.install(r101.getContext());
        String r103 = r102.getMetaInfos(r101.getContext());
        JSONObject r104 = r102.getSession(r101.getContext());
        JSONObject r105 = new JSONObject();
        r105.put("status_code", 0);
        r105.put("meta_info", r103);
        r105.put(RemoteMessageConst.DEVICE_TOKEN, r104);
        finishWithResult(r105);
    }
}
