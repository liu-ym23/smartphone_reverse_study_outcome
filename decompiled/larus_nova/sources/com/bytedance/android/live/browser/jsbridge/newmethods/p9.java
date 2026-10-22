package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.browser.jsbridge.base.LiveOperateInteractPluginResultModel;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.operateInteractPlugin")
public final class p9 extends w20.e3<w20.ya, LiveOperateInteractPluginResultModel> {

    public static final class a {
    }

    static {
    }

    public p9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        w20.ya r101 = (w20.ya) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r111 = r101.b();
        if (r111 == null) goto L43;
        int r102 = r111.hashCode();
        if (r102 == 3417674) goto L25;
        if (r102 != 94756344) goto L43;
        if (r111.equals("close") == false) goto L43;
        JsonObject r103 = r101.c();
        if (r103 == null) goto L47;
        JsonElement r104 = r103.get("interact_app_id");
        if (r104 == null) goto L48;
        IBroadcastService r112 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r112 == null) goto L19;
        boolean r113 = r112.closeInteractPluginCard(r104.getAsString(), true);
    L20:
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(r104.getAsString(), ReloadPanelType.FROM_CAHCE, false, false, 4));
        if (r113 == false) goto L23;
        finishWithSuccess();
        return;
    L23:
        finishWithFailure();
        return;
    L19:
        r113 = false;
        goto L20
    L48:
        return;
    L47:
        return;
    L25:
        if (r111.equals("open") == false) goto L43;
        JsonObject r114 = r101.c();
        if (r114 == null) goto L51;
        JsonElement r115 = r114.get(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL);
        if (r115 == null) goto L52;
        String r105 = null;
        if (RoomContext.a.c(RoomContext.Companion, null, 0, 3) != null) goto L45;
        j(r115, r101, null);
        return;
    L45:
        JsonObject r106 = r101.c();     // Catch: Exception -> L39
        if (r106 == null) goto L40;
        JsonElement r107 = r106.get("interact_app_id");     // Catch: Exception -> L39
        if (r107 == null) goto L40;
        r105 = r107.getAsString();     // Catch: Exception -> L39
    L40:
        if (r105 != null) goto L42;
        finishWithFailure();
        Unit r108 = Unit.INSTANCE;
    L42:
        j(r115, r101, r105);
        return;
    L52:
        return;
    L51:
        return;
    L43:
        finishWithFailure(new Throwable("Unsupported operation type"));
    }

    public final void j(JsonElement r100, w20.ya r110, String r111) {
        IBroadcastService r101 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        LinkedHashMap r102 = new LinkedHashMap();
        if (r110 == null) goto L11;
        JsonObject r103 = r110.c();
        if (r103 == null) goto L11;
        JsonElement r104 = r103.get("relate_effect_id");
        if (r104 == null) goto L11;
        String r105 = r104.getAsString();
        if (r105 == null) goto L11;
        String r106 = r102.put("relate_effect_id", r105);
    L11:
        String r107 = "";
        if (r110 == null) goto L27;
        String r112 = r110.a();
        if (r112 == null) goto L27;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L26
        JSONObject r113 = LiveSeiUtil.c(r112);     // Catch: Exception -> L26
        String r108 = r113.optString("upload_score_id");     // Catch: Exception -> L26
        String r109 = r113.optString(MonitorConstants.EXTRA_DOWNLOAD_PAGE);     // Catch: Exception -> L24
        String r114 = r113.optString("interact_tool_name");     // Catch: Exception -> L22
        r107 = r113.optString("interact_tool_info");     // Catch: Exception -> L20
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L20
    L21:
        String r116 = r107;
    L23:
        r107 = r109;
    L25:
        String r117 = r116;
        String r118 = r107;
        r107 = r108;
    L28:
        if (r101 == null) goto L30;
        boolean r119 = r101.openPluginMiniApp(r100.getAsString(), r111, r107, r102);
    L31:
        if (r119 == false) goto L40;
        if (r111 == null) goto L39;
        if (r101 == null) goto L39;
        int r120 = InteractID.InteractMiniApp.getValue();
        if (com.bytedance.android.livesdk.utils.r2.a(r118) == true) goto L38;
        r118 = "interactive_extension_detailpage";
    L38:
        r101.putInteractToolsMobInfo(r111, new a00.a(r114, r120, r118, r117));
    L39:
        finishWithSuccess();
        return;
    L40:
        finishWithFailure();
        return;
    L30:
        r119 = false;
    L22:
        r116 = "";
        r114 = r116;
    L24:
        r116 = "";
        r114 = r116;
    L27:
        r118 = "";
        r117 = r118;
        r114 = r117;
        goto L28
    }
}
