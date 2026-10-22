package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "open_webview_action")
public final class o9 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public o9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        r102.optString("type");
        r102.optString("url");
        r102.optInt("level");
        xs2.b.a().post(new zg1.f2());
        return null;
    }
}
