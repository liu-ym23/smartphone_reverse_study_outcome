package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.common.lib.MobClickCombiner;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "reportADLog")
public final class xa extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public xa() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r110, CallContext r111) throws Exception {
        JSONObject r112 = r110;
        String r100 = r112.optString("tag");
        String r101 = r112.optString("label");
        String r102 = r112.optString("refer");
        String r103 = r112.optString("logExtra");
        String r104 = r112.optString("groupID");
        String r105 = r112.optString("creativeID");
        JSONObject r113 = r112.optJSONObject("extraParams");
        if (r113 != null) goto L5;
        r113 = new JSONObject();
    L5:
        JSONObject r106 = r113;
        r106.put("refer", r102);
        r106.put("log_extra", r103);
        r106.put("is_ad_event", "1");
        HashMap r114 = new HashMap();
        Iterator<String> r107 = r106.keys();
    L7:
        if (r107.hasNext() == false) goto L9;
        String r108 = r107.next();
        r114.put(r108, r106.optString(r108));
        goto L7
    L9:
        r114.put("category", "umeng");
        r114.put("tag", r100);
        r114.put("value", r105);
        r114.put("ext_value", r104);
        if (TextUtils.equals("click", r101) == false) goto L16;
        com.bytedance.android.livesdk.log.j0.l().sendLog("realtime_click", r114, new Object[0]);
        r106.put("has_v3", "1");
        MobClickCombiner.onEvent(r111.getContext(), r100, r101, CastLongProtector.parseLong(r105), CastLongProtector.parseLong(r104), r106);     // Catch: Exception -> L14
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        r114.put("ad_event_version", "3");
        com.bytedance.android.livesdk.log.j0.l().sendLog(r101, r114, new Object[0]);
        return null;
    }
}
