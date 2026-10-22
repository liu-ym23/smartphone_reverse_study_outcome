package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendLogV1")
public final class ub extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public ub() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("eventName");
        String r104 = r102.optString("labelName");
        JSONObject r105 = r102.optJSONObject("params");
        HashMap r106 = new HashMap();
        Iterator<String> r107 = r105.keys();
    L4:
        if (r107.hasNext() == false) goto L6;
        String r108 = r107.next();
        String r109 = r105.optString(r108);
        r107.remove();
        r106.put(r108, r109);
        goto L4
    L6:
        ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).logEvent(true, r103, r104, r106);
        return null;
    }
}
