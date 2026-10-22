package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendMonitor")
public final class a8 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public a8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("type");
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r102, "args");
        r103.getClass();
        switch(r103.hashCode()) {
            case -1853762817: goto L18;
            case -858688242: goto L14;
            case 1708461408: goto L10;
            case 1821543916: goto L6;
            default: goto L21;
        };
    L21:
        byte r105 = -1;
    L23:
        if (r105 == 0) goto L31;
        if (r105 == 1) goto L30;
        if (r105 == 2) goto L29;
        if (r105 != 3) goto L37;
        LiveSlardarMonitor.monitorStatus(r104.optString("service"), r104.optInt("status"), r104.optJSONObject("ext_json"));
        return null;
    L37:
        return null;
    L29:
        LiveSlardarMonitor.monitorEvent(r104.optString("service"), r104.optJSONObject("category"), r104.optJSONObject("metric"), r104.optJSONObject("extra"));
        return null;
    L30:
        LiveSlardarMonitor.monitorDuration(r104.optString("service"), r104.optLong("duration"), r104.optJSONObject("ext_json"));
        return null;
    L31:
        LiveSlardarMonitor.monitorStatusAndDuration(r104.optString("service"), r104.optInt("status"), r104.optLong("duration"), r104.optJSONObject("ext_json"));
        return null;
    L6:
        if (r103.equals("monitorStatus") == false) goto L21;
        r105 = 3;
        goto L23
    L10:
        if (r103.equals("monitorEvent") == false) goto L21;
        r105 = 2;
        goto L23
    L14:
        if (r103.equals("monitorDuration") == false) goto L21;
        r105 = 1;
        goto L23
    L18:
        if (r103.equals("monitorStatusAndDuration") == false) goto L21;
        r105 = 0;
        goto L23
    }
}
