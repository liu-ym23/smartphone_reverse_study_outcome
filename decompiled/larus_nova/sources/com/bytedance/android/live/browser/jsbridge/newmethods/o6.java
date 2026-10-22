package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "reportStarEvent")
public final class o6 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    public static final class a {
    }

    static {
    }

    public o6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("event", "");     // Catch: Throwable -> L5
        JSONObject r104 = r102.optJSONObject("args");     // Catch: Throwable -> L5
        Map<String, String> r105 = (Map) GsonHelper.getDefault().fromJson(r104.toString(), new p6().getType());     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.log.u.l().sendLog(r103, r105, new Object[0]);     // Catch: Throwable -> L5
    L8:
        return new JSONObject();
    L5:
        th = move-exception;
        ALogger.d("LiveLoggerMethod", String.valueOf(th.getMessage()));
        goto L8
    }
}
