package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SendCommerceEventResultModel;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendCommerceEvent")
public final class rb extends w20.v5<w20.zd, SendCommerceEventResultModel> {
    public rb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.zd r100 = (w20.zd) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r112 = r100.a();
        JsonObject r101 = r100.b();
        if (r101 == null) goto L86;
        JsonElement r113 = r101.get("enter_from_dou_plus");     // Catch: Exception -> L80
        if (r113 == null) goto L8;
        String r114 = r113.getAsString();     // Catch: Exception -> L80
    L10:
        if ((!Intrinsics.areEqual(r114, "1")) == true) goto L85;
        JsonElement r115 = r101.get("creative_id");     // Catch: Exception -> L80
        if (r115 == null) goto L14;
        String r116 = r115.getAsString();     // Catch: Exception -> L80
    L15:
        if (r116 == null) goto L20;
        if (r116.length() == 0) goto L20;
        boolean r117 = false;
    L21:
        if (r117 == true) goto L87;
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L78
        JsonElement r119 = r101.get("enter_from_merge");     // Catch: Exception -> L78
        if (r119 == null) goto L26;
        String r120 = r119.getAsString();     // Catch: Exception -> L78
    L27:
        r118.put("enter_from_merge", r120);     // Catch: Exception -> L78
        JsonElement r121 = r101.get("enter_method");     // Catch: Exception -> L78
        if (r121 == null) goto L30;
        String r122 = r121.getAsString();     // Catch: Exception -> L78
    L31:
        r118.put("enter_from_method", r122);     // Catch: Exception -> L78
        JsonElement r123 = r101.get("room_id");     // Catch: Exception -> L78
        if (r123 == null) goto L34;
        String r124 = r123.getAsString();     // Catch: Exception -> L78
    L35:
        r118.put("room_id", r124);     // Catch: Exception -> L78
        JsonElement r102 = r101.get("author_id");     // Catch: Exception -> L78
        if (r102 == null) goto L38;
        String r103 = r102.getAsString();     // Catch: Exception -> L78
    L39:
        r118.put("author_id", r103);     // Catch: Exception -> L78
        JsonElement r104 = r101.get("vs_episode_id");     // Catch: Exception -> L78
        if (r104 == null) goto L42;
        String r105 = r104.getAsString();     // Catch: Exception -> L78
    L43:
        r118.put("vs_episode_id", r105);     // Catch: Exception -> L78
        JsonElement r106 = r101.get("vs_episode_stage");     // Catch: Exception -> L78
        if (r106 == null) goto L46;
        String r125 = r106.getAsString();     // Catch: Exception -> L78
    L47:
        r118.put("vs_episode_stage", r125);     // Catch: Exception -> L78
        JsonElement r107 = r101.get("vs_follow_position");     // Catch: Exception -> L78
        if (r107 == null) goto L50;
        r118.put("vs_follow_position", r107.getAsString());     // Catch: Exception -> L78
    L50:
        r118.put("is_ad_event", "1");     // Catch: Exception -> L78
        HashMap<String, String> r108 = new HashMap();     // Catch: Exception -> L78
        JsonElement r109 = r101.get("creative_id");     // Catch: Exception -> L78
        String r126 = "";
        if (r109 == null) goto L55;
        String r127 = r109.getAsString();     // Catch: Exception -> L78
        if (r127 == null) goto L55;
    L56:
        r108.put("value", r127);     // Catch: Exception -> L78
        JsonElement r128 = r101.get("ad_id");     // Catch: Exception -> L78
        if (r128 == null) goto L60;
        String r129 = r128.getAsString();     // Catch: Exception -> L78
        if (r129 == null) goto L60;
    L61:
        r108.put("ad_id", r129);     // Catch: Exception -> L78
        JsonElement r130 = r101.get("is_other_channel");     // Catch: Exception -> L78
        if (r130 == null) goto L65;
        String r131 = r130.getAsString();     // Catch: Exception -> L78
        if (r131 == null) goto L65;
    L66:
        r108.put("is_other_channel", r131);     // Catch: Exception -> L78
        JsonElement r132 = r101.get("log_extra");     // Catch: Exception -> L78
        if (r132 == null) goto L72;
        String r133 = r132.getAsString();     // Catch: Exception -> L78
        if (r133 == null) goto L72;
        r126 = r133;
    L72:
        r108.put("log_extra", URLDecoder.decode(r126));     // Catch: Exception -> L78
        r108.put("event_type", "vs_video_native_action");     // Catch: Exception -> L78
        ILiveDouPlusService r134 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);     // Catch: Exception -> L78
        HashMap r135 = new HashMap();     // Catch: Exception -> L78
        r135.put("ad_extra_data", r118.toString());     // Catch: Exception -> L78
        if (r108.isEmpty() == true) goto L76;
        r135.putAll(r108);     // Catch: Exception -> L78
    L76:
        r134.logEvent(true, "vs_ad", r112, r135);     // Catch: Exception -> L78
        com.bytedance.android.livesdk.utils.c1.f158903a = r118;     // Catch: Exception -> L78
        com.bytedance.android.livesdk.utils.c1.f158904b = r108;     // Catch: Exception -> L78
        SendCommerceEventResultModel r136 = new SendCommerceEventResultModel();     // Catch: Exception -> L78
        r136.a(SendCommerceEventResultModel.Code.Success);     // Catch: Exception -> L78
        Unit r137 = Unit.INSTANCE;     // Catch: Exception -> L78
        finishWithResult(r136);     // Catch: Exception -> L78
        return;
    L65:
        r131 = "";
    L60:
        r129 = "";
    L55:
        r127 = "";
        goto L56
    L46:
        r125 = null;
        goto L47
    L42:
        r105 = null;
        goto L43
    L38:
        r103 = null;
        goto L39
    L34:
        r124 = null;
        goto L35
    L30:
        r122 = null;
        goto L31
    L26:
        r120 = null;
    L78:
        SendCommerceEventResultModel r138 = new SendCommerceEventResultModel();
        r138.a(SendCommerceEventResultModel.Code.Failed);
        Unit r139 = Unit.INSTANCE;
        finishWithResult(r138);
        return;
    L87:
        return;
    L20:
        r117 = true;
        goto L21
    L14:
        r116 = null;
        goto L15
    L85:
        return;
    L8:
        r114 = null;
    L89:
        return;
    }
}
