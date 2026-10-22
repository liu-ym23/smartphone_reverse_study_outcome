package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class i3 implements IMiddlewareHostBusiness.onLivePublishCallback {
    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.onLivePublishCallback
    public final void onClose() {
    }

    public i3() {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.onLivePublishCallback
    public final void onPublish(JSONObject r100) {
        ((IBrowserService) jc1.k.f(IBrowserService.class)).sendEventToAllJsBridges("H5_publishVideoStatusChange", r100);
    }
}
