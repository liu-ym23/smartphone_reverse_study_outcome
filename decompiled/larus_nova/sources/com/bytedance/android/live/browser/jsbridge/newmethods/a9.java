package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPKPanel")
public final class a9 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public a9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        b30.o r102 = new b30.o(r100.optString("source", "activity"));
        xs2.b.a().post(r102);
        return null;
    }
}
