package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.ReportLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w20.i5;
import w20.id;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "reportLinkmicStatus")
public final class f extends i5<id, ReportLinkmicStatusResultModel> {
    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        id r102 = (id) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r103 = r102.b();
        boolean r104 = false;
        if (r103 == null) goto L5;
        int r105 = r103.intValue();
    L6:
        JsonObject r106 = r102.a();
        if (r106 == null) goto L48;
        JsonObject r107 = null;
        if (r105 != 2) goto L30;
        JsonElement r108 = r106.get("eventName");
        if (r108 == null) goto L14;
        String r109 = r108.getAsString();
        if (r109 == null) goto L14;
    L46:
        JsonElement r110 = r106.get("info");     // Catch: Exception -> L19
        if (r110 == null) goto L21;
        r107 = r110.getAsJsonObject();     // Catch: Exception -> L19
    L21:
        if (r107 != null) goto L24;
        r107 = new JsonObject();
    L24:
        if (TextUtils.isEmpty(r109) == true) goto L27;
        Gson r111 = GsonHelper.getDefault();
        Type r112 = new e().getType();
        Map<String, String> r113 = (Map) GsonProtectorUtils.fromJson(r111, r107.toString(), r112);
        com.bytedance.android.livesdk.log.j0.l().sendLog(r109, r113, new Object[0]);
        r104 = true;
    L27:
        if (r104 == true) goto L49;
        ALogger.e("reportEventDataFail", r102.toString());
        return;
    L49:
        return;
    L19:
        e = move-exception;
        ALogger.e("reportLinkmicStatus", e);
    L14:
        r109 = "";
        goto L46
    L30:
        if (r105 != 3) goto L51;
        JsonElement r114 = r106.get("tag");
        if (r114 == null) goto L44;
        r114.getAsString();
    L44:
        JsonElement r115 = r106.get("info");     // Catch: Exception -> L38
        if (r115 == null) goto L40;
        r107 = r115.getAsJsonObject();     // Catch: Exception -> L38
    L40:
        if (r107 != null) goto L42;
        r107 = new JsonObject();
    L42:
        r107.toString();
        return;
    L38:
        e = move-exception;
        ALogger.e("reportLinkmicStatus", e);
        goto L40
    L51:
        return;
    L48:
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
