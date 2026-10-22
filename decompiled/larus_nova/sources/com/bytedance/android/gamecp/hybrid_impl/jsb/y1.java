package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.gamecp.common.utils.GameCPSafeConvertUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpAttribution")
public final class y1 extends s<k3, GamecpAttributionResultModel> {

    public static final class a {
    }

    static {
    }

    public y1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        k3 r101 = (k3) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamecpAttribution", GsonProtectorUtils.toJson(new Gson(), r101));
        Integer r111 = r101.a();     // Catch: Exception -> L165
        if (r111 != null) goto L7;
    L9:
        String r112 = "livesdk_game_promote_user_btn_click";
    L10:
        int r102 = GameCPSafeConvertUtils.f57158a;     // Catch: Exception -> L165
        Integer r103 = GameCPSafeConvertUtils.d(r101.i());     // Catch: Exception -> L165
        int r104 = 0;
        if (r103 == null) goto L13;
        int r105 = r103.intValue();     // Catch: Exception -> L165
    L14:
        HashMap r106 = new HashMap();     // Catch: Exception -> L165
        String r107 = r101.c();     // Catch: Exception -> L165
        String r108 = "";
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        r106.put("game_id", r107);     // Catch: Exception -> L165
        String r109 = r101.d();     // Catch: Exception -> L165
        if (r109 != null) goto L21;
        r109 = "";
    L21:
        r106.put(EventConstants.ExtraJson.GAME_NAME, r109);     // Catch: Exception -> L165
        String r113 = r101.h();     // Catch: Exception -> L165
        if (r113 != null) goto L24;
        r113 = "";
    L24:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r113);     // Catch: Exception -> L165
        String r114 = r101.f();     // Catch: Exception -> L165
        if (r114 != null) goto L27;
        r114 = "";
    L27:
        r106.put("promote_id", r114);     // Catch: Exception -> L165
        String r115 = r101.h();     // Catch: Exception -> L165
        if (r115 != null) goto L30;
        r115 = "";
    L30:
        r106.put("room_id", r115);     // Catch: Exception -> L165
        String r116 = r101.j();     // Catch: Exception -> L165
        if (r116 != null) goto L33;
        r116 = "";
    L33:
        r106.put("video_id", r116);     // Catch: Exception -> L165
        String r117 = r101.e();     // Catch: Exception -> L165
        if (r117 != null) goto L36;
        r117 = "";
    L36:
        r106.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r117);     // Catch: Exception -> L165
        String r118 = r101.b();     // Catch: Exception -> L165
        if (r118 != null) goto L39;
        r118 = "";
    L39:
        r106.put("btn_type", r118);     // Catch: Exception -> L165
        String r119 = r101.g();     // Catch: Exception -> L165
        JSONObject r120 = null;
        Object r121 = null;
        if (r119 == null) goto L52;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L44
        Object r123 = Result.m9449constructorimpl(new JSONObject(r119));     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r123) == true) goto L50;
        r121 = r123;
    L50:
        r120 = (JSONObject) r121;     // Catch: Exception -> L165
    L44:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Exception -> L165
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L165
    L52:
        if (r120 == null) goto L55;
        String r125 = r120.optString("enter_from");     // Catch: Exception -> L165
        if (r125 == null) goto L55;
    L56:
        r106.put("enter_from", r125);     // Catch: Exception -> L165
        if (r120 == null) goto L61;
        String r126 = r120.optString("enter_method");     // Catch: Exception -> L165
        if (r126 == null) goto L61;
    L62:
        r106.put("enter_method", r126);     // Catch: Exception -> L165
        if (r120 == null) goto L67;
        String r127 = r120.optString("enter_sub_method");     // Catch: Exception -> L165
        if (r127 == null) goto L67;
    L68:
        r106.put("enter_sub_method", r127);     // Catch: Exception -> L165
        if (r120 == null) goto L73;
        String r128 = r120.optString(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT);     // Catch: Exception -> L165
        if (r128 == null) goto L73;
    L74:
        r106.put(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r128);     // Catch: Exception -> L165
        if (r120 == null) goto L79;
        String r129 = r120.optString("enter_from_merge");     // Catch: Exception -> L165
        if (r129 == null) goto L79;
    L80:
        r106.put("enter_from_merge", r129);     // Catch: Exception -> L165
        CharSequence r130 = (CharSequence) r106.get("enter_from_merge");     // Catch: Exception -> L165
        if (r130 != null) goto L83;
    L86:
        boolean r131 = true;
    L87:
        if (r131 == false) goto L94;
        if (r120 == null) goto L91;
        String r132 = r120.optString("enter_from");     // Catch: Exception -> L165
        if (r132 == null) goto L91;
    L92:
        r106.put("enter_from_merge", r132);     // Catch: Exception -> L165
    L91:
        r132 = "";
    L94:
        if (r120 == null) goto L97;
        String r133 = r120.optString("ad_plan_id");     // Catch: Exception -> L165
        if (r133 == null) goto L97;
    L98:
        r106.put("ad_plan_id", r133);     // Catch: Exception -> L165
        if (r120 == null) goto L102;
        String r134 = r120.optString("creative_id");     // Catch: Exception -> L165
        if (r134 == null) goto L102;
    L103:
        r106.put("value", r134);     // Catch: Exception -> L165
        if (r120 == null) goto L108;
        String r135 = r120.optString("is_other_channel");     // Catch: Exception -> L165
        if (r135 == null) goto L108;
    L109:
        r106.put("is_other_channel", r135);     // Catch: Exception -> L165
        if (r120 == null) goto L113;
        int r136 = r120.optInt("biz_type");     // Catch: Exception -> L165
    L114:
        r106.put("biz_type", String.valueOf(r136));     // Catch: Exception -> L165
        if (r120 == null) goto L119;
        String r137 = r120.optString("official_enter_from");     // Catch: Exception -> L165
        if (r137 == null) goto L119;
    L120:
        r106.put("official_enter_from", r137);     // Catch: Exception -> L165
        if (r120 == null) goto L124;
        int r138 = r120.optInt("ad_source_type");     // Catch: Exception -> L165
    L125:
        r106.put("ad_source_type", String.valueOf(r138));     // Catch: Exception -> L165
        if (r120 == null) goto L129;
        int r139 = r120.optInt("stock_type");     // Catch: Exception -> L165
    L130:
        r106.put("stock_type", String.valueOf(r139));     // Catch: Exception -> L165
        if (r120 == null) goto L134;
        r104 = r120.optInt("original_system_origin");     // Catch: Exception -> L165
    L134:
        r106.put("original_system_origin", String.valueOf(r104));     // Catch: Exception -> L165
        String r140 = "0";
        if (r120 == null) goto L139;
        String r141 = r120.optString("if_dou");     // Catch: Exception -> L165
        if (r141 == null) goto L139;
    L140:
        r106.put("if_dou", r141);     // Catch: Exception -> L165
        if (r120 == null) goto L147;
        String r142 = r120.optString("is_ads");     // Catch: Exception -> L165
        if (r142 == null) goto L147;
        r140 = r142;
    L147:
        r106.put("is_ads", r140);     // Catch: Exception -> L165
        if (r120 == null) goto L152;
        String r143 = r120.optString("request_id");     // Catch: Exception -> L165
        if (r143 == null) goto L152;
    L153:
        r106.put("request_id", r143);     // Catch: Exception -> L165
        if (r120 == null) goto L160;
        String r144 = r120.optString("log_extra");     // Catch: Exception -> L165
        if (r144 == null) goto L160;
        r108 = r144;
    L160:
        r106.put("log_extra", r108);     // Catch: Exception -> L165
        xr.f r145 = (xr.f) xr.s.a(xr.f.class);     // Catch: Exception -> L165
        if (r145 == null) goto L163;
        r145.logMonitorLinkEvent(r105, r112, r106, true);     // Catch: Exception -> L165
    L163:
        GamecpAttributionResultModel r146 = new GamecpAttributionResultModel();     // Catch: Exception -> L165
        r146.a(GamecpAttributionResultModel.Code.Success);     // Catch: Exception -> L165
        Unit r147 = Unit.INSTANCE;     // Catch: Exception -> L165
        finishWithResult(r146);     // Catch: Exception -> L165
        return;
    L152:
        r143 = "";
    L139:
        r141 = "0";
        goto L140
    L129:
        r139 = 0;
        goto L130
    L124:
        r138 = 0;
    L119:
        r137 = "";
        goto L120
    L113:
        r136 = 0;
    L108:
        r135 = "";
    L102:
        r134 = "";
    L97:
        r133 = "";
        goto L98
    L83:
        if (r130.length() == 0) goto L86;
        r131 = false;
    L79:
        r129 = "";
    L73:
        r128 = "";
    L67:
        r127 = "";
    L61:
        r126 = "";
    L55:
        r125 = "";
        goto L56
    L13:
        r105 = 0;
        goto L14
    L7:
        if (r111.intValue() != 1) goto L9;
        r112 = "livesdk_game_promote_user_btn_show";
    L165:
        e = move-exception;
        yr.b.b(4, "GameCpAttributionMethod", e.getMessage());
        GamecpAttributionResultModel r148 = new GamecpAttributionResultModel();
        r148.a(GamecpAttributionResultModel.Code.Failed);
        r148.b(e.getMessage());
        Unit r149 = Unit.INSTANCE;
        finishWithResult(r148);
    }
}
