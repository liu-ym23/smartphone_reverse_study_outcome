package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "sendLogV3")
public final class b2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public b2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final /* bridge */ /* synthetic */ Object invoke(JSONObject r100, CallContext r101) throws Exception {
        return j(r100, r101);
    }

    public final Object j(JSONObject r100, CallContext r101) throws Exception {
        String r102 = r100.optString("eventName");
        Integer r103 = Integer.valueOf(r100.optInt("no_prefix"));
        JSONObject r104 = r100.optJSONObject("params");
        HashMap r105 = new HashMap();
        if (r104 == null) goto L9;
        Iterator<String> r106 = r104.keys();
    L6:
        if (r106.hasNext() == false) goto L9;
        String r107 = r106.next();
        String r108 = r104.optString(r107);
        r106.remove();
        r105.put(r107, r108);
    L9:
        if (r101.f249271f == false) goto L11;
        r105.put("is_open_anniex", "1");
    L13:
        if (r103.intValue() != 1) goto L15;
        ((x9.b) Annie.getService(x9.b.class, r101.a())).t(r102, r105);
    L16:
        JSONObject r109 = new JSONObject();
        r109.put("code", 1);
        r109.put("msg", "SUCCESS");
        return r109;
    L15:
        ((x9.b) Annie.getService(x9.b.class, r101.a())).logV3(r102, r105);
        goto L16
    L11:
        r105.put("is_open_anniex", "0");
        goto L13
    }
}
