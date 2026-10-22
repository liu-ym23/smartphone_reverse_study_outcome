package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class h3 implements IMiddlewareHostBusiness.onLightLivePublishCallback {
    public h3() {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.onLightLivePublishCallback
    public final void response(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", r100);     // Catch: JSONException -> L5
        r103.put("type", r101);     // Catch: JSONException -> L5
        r103.put("status", r102);     // Catch: JSONException -> L5
    L7:
        ((IBrowserService) jc1.k.f(IBrowserService.class)).sendEventToAllJsBridges("H5_publishVideoStatusChange", r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
