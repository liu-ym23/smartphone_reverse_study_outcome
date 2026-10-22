package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.browser.jsbridge.base.LiveRunAiServiceResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.db;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "live.runAiService")
public final class j1 extends w20.j3<db, LiveRunAiServiceResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f142144a;

    public j1() {
        this.f142144a = "LAI-LiveRunAiServiceMethod";
    }

    public final JsonArray k(JSONArray r100) {
        JsonArray r101 = new JsonArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L28;
        Object r104 = r100.get(r103);     // Catch: Exception -> L25
        if ((r104 instanceof JSONObject) == false) goto L8;
        r101.add(l((JSONObject) r104));     // Catch: Exception -> L25
    L27:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONArray) == false) goto L11;
        r101.add(k((JSONArray) r104));     // Catch: Exception -> L25
        goto L27
    L11:
        if ((r104 instanceof Boolean) == false) goto L14;
        r101.add(new JsonPrimitive((Boolean) r104));     // Catch: Exception -> L25
        goto L27
    L14:
        if ((r104 instanceof Number) == false) goto L17;
        r101.add(new JsonPrimitive((Number) r104));     // Catch: Exception -> L25
        goto L27
    L17:
        if ((r104 instanceof String) == false) goto L19;
        r101.add(new JsonPrimitive((String) r104));     // Catch: Exception -> L25
        goto L27
    L19:
        String r105 = this.f142144a;     // Catch: Exception -> L25
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L25
        r106.append("Skipped array element at index ");     // Catch: Exception -> L25
        r106.append(r103);     // Catch: Exception -> L25
        r106.append(": Unsupported type ");     // Catch: Exception -> L25
        if (r104 == null) goto L22;
        String r107 = r104.getClass().getName();     // Catch: Exception -> L25
    L23:
        r106.append(r107);     // Catch: Exception -> L25
        Logger.e(r105, r106.toString());     // Catch: Exception -> L25
        goto L27
    L22:
        r107 = null;
    L25:
        e = move-exception;
        Logger.e(this.f142144a, "Failed to process array element at index " + r103 + ": " + e.getMessage());
        goto L27
    L28:
        return r101;
    }

    public final JsonObject l(JSONObject r100) {
        JsonObject r101 = new JsonObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L29;
        String r103 = r102.next();
        Object r104 = r100.get(r103);     // Catch: Exception -> L27
        if ((r104 instanceof JSONObject) == true) goto L8;
        if ((r104 instanceof JSONArray) == true) goto L11;
        if ((r104 instanceof Boolean) == true) goto L14;
        if ((r104 instanceof Number) == true) goto L17;
        if ((r104 instanceof String) == true) goto L20;
        String r105 = this.f142144a;     // Catch: Exception -> L27
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L27
        r106.append("Skipped key '");     // Catch: Exception -> L27
        r106.append(r103);     // Catch: Exception -> L27
        r106.append("': Unsupported type ");     // Catch: Exception -> L27
        if (r104 == null) goto L24;
        String r107 = r104.getClass().getName();     // Catch: Exception -> L27
    L25:
        r106.append(r107);     // Catch: Exception -> L27
        Logger.e(r105, r106.toString());     // Catch: Exception -> L27
        goto L4
    L24:
        r107 = null;
        goto L25
    L20:
        r101.addProperty(r103, (String) r104);     // Catch: Exception -> L27
        goto L4
    L17:
        r101.addProperty(r103, (Number) r104);     // Catch: Exception -> L27
        goto L4
    L14:
        r101.addProperty(r103, (Boolean) r104);     // Catch: Exception -> L27
        goto L4
    L11:
        r101.add(r103, k((JSONArray) r104));     // Catch: Exception -> L27
        goto L4
    L8:
        r101.add(r103, l((JSONObject) r104));     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Logger.e(this.f142144a, "Failed to process key '" + r103 + "': " + e.getMessage());
        goto L4
    L29:
        return r101;
    }

    public static void j(String r100, String r101) {
        IHostGameCP r102 = (IHostGameCP) jc1.k.f(IHostGameCP.class);
        if (r102 == null) goto L11;
        IGameCpLiveService r103 = r102.getGameCpLiveService();
        if (r103 == null) goto L12;
        HashMap<String, String> r104 = new HashMap();
        r104.put("status", r100);
        r104.put("from", PrefetchTiming.JSB);
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r101) == false) goto L9;
        Intrinsics.checkNotNull(r101);
        r104.put("reason", r101);
    L9:
        Unit r105 = Unit.INSTANCE;
        r103.reportCardDynamicEvent(r104);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        db r102 = (db) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        LiveRunAiServiceResultModel r103 = new LiveRunAiServiceResultModel();
        JSONObject r104 = null;
        j("ai invoke", null);
        Logger.d(this.f142144a, "LiveRunAiServiceMethod invoke : action=" + r102.a() + ", params=" + r102.b());
        Integer r105 = r102.a();
        if (r105 == null) goto L10;
        r105.intValue();
        IAiService r106 = (IAiService) jc1.k.f(IAiService.class);
        if (r106 == null) goto L12;
        Integer r107 = r102.a();
        Intrinsics.checkNotNull(r107);
        int r108 = r107.intValue();
        JsonObject r109 = r102.b();
        if (r109 == null) goto L9;
        int r110 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.f115581a;
        Intrinsics.checkNotNullParameter(r109, "$this$toJSONObject");
        r104 = tv5.a.b(r109);
    L9:
        r106.handleAction(r108, r104, new i1(this, r103));
        return;
    L12:
        return;
    L10:
        r103.c(LiveRunAiServiceResultModel.Code.Failed);
        finishWithResult(r103);
        Logger.w(this.f142144a, "finish with error: action is null");
    }
}
