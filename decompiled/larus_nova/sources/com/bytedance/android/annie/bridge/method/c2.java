package com.bytedance.android.annie.bridge.method;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "reportAppLog")
public final class c2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public c2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        b2 r102 = new b2();
        return r102.j(r100, r101);
    }
}
