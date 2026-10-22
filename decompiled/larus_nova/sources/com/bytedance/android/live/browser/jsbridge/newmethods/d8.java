package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "statusNotification")
public final class d8 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public d8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("type");
        JSONObject r104 = r102.optJSONObject("args");
        r103.getClass();
        if (r103.equals(PbRequest.SwitchType.RECHARGE) == true) goto L6;
        return null;
    L6:
        if (TextUtils.equals(r104.optString("status"), "1") == false) goto L10;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.v(1, 0));
        return null;
    L10:
        return null;
    }
}
