package com.bytedance.android.livesdk.jsbridge.methods;

import com.baidu.platform.comapi.UIMsg;
import com.bytedance.android.live.browser.jsbridge.base.ReportLiveTraceResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.livetrace.ILiveCloudGameTraceMonitor;
import com.bytedance.android.livesdkapi.livetrace.ILiveGameTraceMonitor;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.jd;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "reportLiveTrace")
public final class q1 extends w20.j5<jd, ReportLiveTraceResultModel> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public q1() {
    }

    public final JSONObject j(JsonObject r100) {
        Object r101 = null;
        if (r100 != null) goto L15;
        return null;
    L15:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(tv5.a.c(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r101 = r103;
    L14:
        return (JSONObject) r101;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        jd r100 = (jd) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = r100.d();
        String r102 = r100.b();
        boolean r103 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L81;
        if (r102 != null) goto L13;
    L16:
        if (r103 == true) goto L81;
        String r105 = r100.i();
        String r106 = r100.a();
        String r107 = r100.h();
        String r108 = r100.k();
        String r112 = r100.j();
        JSONObject r113 = j(r100.c());
        JSONObject r114 = j(r100.e());
        JSONObject r115 = j(r100.g());
        JSONObject r109 = j(r100.f());
        HashMap r116 = new HashMap();
        if (r109 == null) goto L30;
        JSONArray r117 = r109.names();
        int r118 = r117.length();
        int r119 = 0;
    L21:
        if (r119 >= r118) goto L30;
        Object r120 = r117.get(r119);
        if (r120 == null) goto L27;
        int r121 = r118;
        String r122 = r120.toString();
        JSONArray r123 = r117;
        if (r122 == null) goto L28;
        r116.put(r122, r109.opt(r122));
    L28:
        r119 = r119 + 1;
        r118 = r121;
        r117 = r123;
        goto L21
    L27:
        r121 = r118;
        r123 = r117;
    L30:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L43;
        StringBuilder r124 = new StringBuilder("roomId=");
        r124.append(r105);
        r124.append(", anchorId=");
        r124.append(r106);
        r124.append(", productId=");
        r124.append(r107);
        r124.append(", eventType=");
        r124.append(r101);
        r124.append(", businessType=");
        r124.append(r102);
        r124.append(", category=");
        String r125 = null;
        if (r113 == null) goto L34;
        String r126 = r113.toString();
    L35:
        r124.append(r126);
        r124.append(", extra=");
        if (r114 == null) goto L38;
        String r127 = r114.toString();
    L39:
        r124.append(r127);
        r124.append(", index=");
        if (r109 == null) goto L42;
        r125 = r109.toString();
    L42:
        r124.append(r125);
        ALogger.i("LiveTraceMethod", r124.toString());
        goto L43
    L38:
        r127 = null;
        goto L39
    L34:
        r126 = null;
    L43:
        String r128 = "";
        if (r107 == null) goto L71;
        int r129 = r107.hashCode();
        if (r129 == (-1428074950)) goto L62;
        if (r129 != 626387643) goto L71;
        if (r107.equals("webcast_client_game_promote") == false) goto L71;
        IMiddlewareLiveService r130 = TTLiveServiceMiddleware.getLiveService();
        if (r130 == null) goto L80;
        ILiveGameTraceMonitor r131 = r130.getGameTraceMonitor();
        if (r131 == null) goto L80;
        if (r112 != null) goto L59;
        String r132 = "";
    L60:
        r131.reportTraceEvent(r102, r101, r132, r108, r105, null, r113, r115, r114);
        goto L80
    L59:
        r132 = r112;
    L80:
        finishWithSuccess();
        return;
    L62:
        if (r107.equals("webcast_client_game") == false) goto L71;
        IMiddlewareLiveService r133 = TTLiveServiceMiddleware.getLiveService();
        if (r133 == null) goto L80;
        ILiveCloudGameTraceMonitor r134 = r133.getCloudGameTraceMonitor();
        if (r134 == null) goto L80;
        if (r112 != null) goto L69;
        String r135 = "";
    L70:
        r134.reportTraceEvent(r102, r101, r135, r108, r105, r116, r113, r115, r114);
        goto L80
    L69:
        r135 = r112;
    L71:
        int r136 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r137 = com.bytedance.android.live.core.monitor.trace.e.b.a(r101, r102);
        r137.f65012c = r107;
        r137.f65015f = r106;
        r137.f65014e = r105;
        IMiddlewareUserService r138 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r138 == null) goto L79;
        com.bytedance.android.livesdk.user.e r139 = r138.user();
        if (r139 == null) goto L79;
        String r140 = r139.n();
        if (r140 == null) goto L79;
        r128 = r140;
    L79:
        r137.f65016g = r128;
        Intrinsics.checkNotNullParameter(r116, "index");
        r137.f65019j = r116;
        r137.f65013d = r112;
        r137.f65010a = r108;
        TraceMonitor.i(r137.a(), r113, r115, r114);
        goto L80
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
    L81:
        pm0.b r141 = om0.c.f();
        if (r141 == null) goto L84;
        r141.i("LiveTraceMethod", "invoke failed; params=" + r100);
    L84:
        finishWithFailure(new Throwable(UIMsg.UI_TIP_REQUEST_PARAMS_ERROR));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L10
    }
}
