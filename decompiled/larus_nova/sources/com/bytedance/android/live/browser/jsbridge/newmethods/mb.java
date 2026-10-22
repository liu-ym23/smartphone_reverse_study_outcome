package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "saveLocalData")
public final class mb extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.tools.superkv.e f63559a;

    public mb() {
        this.f63559a = com.bytedance.android.live.core.utils.v1.a("webcast_jsb_local_data");
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("key");
        String r104 = r102.optString("data");
        com.bytedance.android.tools.superkv.e r105 = this.f63559a;
        if (r105 == null) goto L7;
        r105.putString(r103, r104);
        return null;
    L7:
        return null;
    }
}
