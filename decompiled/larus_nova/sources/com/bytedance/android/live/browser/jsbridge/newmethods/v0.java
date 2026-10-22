package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import javax.inject.Inject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastBroadcast")
public final class v0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public com.bytedance.android.live.browser.v f63688a;

    public v0() {
        BrowserServiceImpl.Companion.getClass();
        this.f63688a = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().f540207a.f540212e.get();
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        this.f63688a.sendEventToAllJsBridges("H5_webcastNotification", r102);
        com.bytedance.android.livesdk.event.o r103 = new com.bytedance.android.livesdk.event.o(r102);
        xs2.b.a().post(r103);
        return null;
    }
}
