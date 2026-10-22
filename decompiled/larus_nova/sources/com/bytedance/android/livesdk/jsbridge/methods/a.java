package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "reportALog")
public final class a extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, LiveTracingMonitor.EventModule> f142047a = null;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    static {
        HashMap r100 = new HashMap();
        f142047a = r100;
        r100.put("ttlive_real_name", LiveTracingMonitor.EventModule.REAL_NAME);
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = JSONObjectProtectorUtils.getString(r102, "level");
        String r104 = JSONObjectProtectorUtils.getString(r102, "tag");
        String r105 = JSONObjectProtectorUtils.getString(r102, "message");
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L31:
        finishWithFailure();
        return;
    L5:
        if (TextUtils.isEmpty(r104) == true) goto L31;
        if (TextUtils.isEmpty(r105) == true) goto L31;
        JSONObject r106 = r102.optJSONObject("codePosition");
        if (r106 == null) goto L13;
        String r107 = r106.optString("file");
        String r108 = r106.optString("line");
        String r109 = r106.optString("function");
        TextUtils.isEmpty(r107);
        TextUtils.isEmpty(r108);
        TextUtils.isEmpty(r109);
    L13:
        if (((HashMap) f142047a).containsKey(r104) == false) goto L16;
        finishWithFailure(new Throwable("tag 类型不允许调用JSB，需要注册，tag=" + r104));
        return;
    L16:
        if ("info".equals(r103) == false) goto L19;
        ALogger.i(r104, r105);
    L30:
        JSONObject r110 = new JSONObject();
        r110.put("code", 1);
        r110.put("msg", "SUCCESS");
        finishWithResult(r110);
        return;
    L19:
        if ("verbose".equals(r103) == false) goto L22;
        ALogger.v(r104, r105);
        goto L30
    L22:
        if ("warn".equals(r103) == false) goto L25;
        ALogger.w(r104, r105);
        goto L30
    L25:
        if ("error".equals(r103) == false) goto L28;
        ALogger.e(r104, r105);
        goto L30
    L28:
        if ("debug".equals(r103) == false) goto L30;
        ALogger.d(r104, r105);
        goto L30
    }
}
