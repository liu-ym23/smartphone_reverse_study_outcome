package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "handleSharedKv")
public final class rc extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63631a;

    public rc() {
        this.f63631a = "live_share_js_kv_methods";
    }

    public static JSONObject j(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("code", r100);
        return r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("key");
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L22;
        int r105 = r102.optInt("action");
        if (r105 != 1) goto L14;
        String r106 = r102.optString("value");
        r101.getContext().getSharedPreferences(this.f63631a, 0).edit().putString(r103, r106).commit();
        return j(1);
    L14:
        if (r105 != 2) goto L16;
        JSONObject r107 = j(1);
        r107.put("value", r101.getContext().getSharedPreferences(this.f63631a, 0).getString(r103, ""));
        return r107;
    L16:
        if (r105 != 3) goto L23;
        r101.getContext().getSharedPreferences(this.f63631a, 0).edit().remove(r103).commit();
        return j(1);
    L23:
        return j(0);
    L22:
        return j(0);
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
