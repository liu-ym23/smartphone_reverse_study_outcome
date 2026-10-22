package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamePromoteReserve")
public final class b3 extends o<e3, GamePromoteReserveResultModel> {

    public static final class a {
    }

    static {
    }

    public b3() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v52, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.ies.web.jsbridge2.f] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r310, CallContext r410) {
        e3 r100 = (e3) r310;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r410, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamePromoteReserve", GsonProtectorUtils.toJson(new Gson(), r100));
        String r101 = r100.h();     // Catch: Exception -> L177
        String r102 = "";
        if (r101 != null) goto L7;
        String r103 = "";
    L9:
        if (r103.length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        GamePromoteReserveResultModel r105 = new GamePromoteReserveResultModel();     // Catch: Exception -> L177
        r105.a(GamePromoteReserveResultModel.Code.Failed);     // Catch: Exception -> L177
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L177
        r106.put("error_reason", "game id is null");     // Catch: Exception -> L177
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L177
        r105.b(r106.toString());     // Catch: Exception -> L177
        finishWithResult(r105);     // Catch: Exception -> L177
        return;
    L14:
        String r108 = r100.i();     // Catch: Exception -> L177
        if (r108 != null) goto L17;
        String r109 = "";
    L18:
        String r110 = r100.y();     // Catch: Exception -> L177
        if (r110 != null) goto L21;
        String r111 = "";
    L22:
        Integer r112 = r100.v();     // Catch: Exception -> L177
        if (r112 == null) goto L25;
        int r113 = r112.intValue();     // Catch: Exception -> L177
    L26:
        long r114 = r113;
        String r115 = r100.o();     // Catch: Exception -> L177
        if (r115 != null) goto L29;
        String r116 = "";
    L30:
        String r117 = r100.d();     // Catch: Exception -> L177
        if (r117 == null) goto L35;
        Long r118 = StringsKt.toLongOrNull(r117);     // Catch: Exception -> L177
        if (r118 == null) goto L35;
        long r119 = r118.longValue();     // Catch: Exception -> L177
    L36:
        String r120 = r100.x();     // Catch: Exception -> L177
        if (r120 != null) goto L39;
        String r121 = "";
    L40:
        String r122 = r100.A();     // Catch: Exception -> L177
        if (r122 != null) goto L43;
        String r123 = "";
    L44:
        String r124 = r100.y();     // Catch: Exception -> L177
        if (r124 != null) goto L47;
        String r125 = "";
    L48:
        String r126 = r100.g();     // Catch: Exception -> L177
        if (r126 == null) goto L52;
        r102 = r126;
    L52:
        String r127 = r100.e();     // Catch: Exception -> L177
        String r128 = "error_reason";
        if (r127 != null) goto L56;
        String r129 = "";
    L184:
        Boolean r130 = r100.B();     // Catch: Exception -> L175
        String r131 = r111;
        if (r130 != null) goto L60;
        Object r132 = "";
    L61:
        String r133 = r100.a();     // Catch: Exception -> L175
        if (r133 != null) goto L64;
        String r134 = "";
    L188:
        String r135 = r100.b();     // Catch: Exception -> L173
        if (r135 != null) goto L68;
        String r136 = "";
    L69:
        String r137 = r100.q();     // Catch: Exception -> L173
        if (r137 != null) goto L72;
        String r210 = "";
    L73:
        String r138 = r100.C();     // Catch: Exception -> L173
        if (r138 != null) goto L76;
        String r211 = "";
    L77:
        Integer r139 = r100.c();     // Catch: Exception -> L173
        if (r139 != null) goto L80;
        Object r212 = "";
    L81:
        Integer r140 = r100.w();     // Catch: Exception -> L173
        if (r140 != null) goto L84;
        Object r213 = "";
    L85:
        Integer r141 = r100.m();     // Catch: Exception -> L173
        if (r141 != null) goto L88;
        Object r214 = "";
    L89:
        Boolean r142 = r100.j();     // Catch: Exception -> L173
        if (r142 != null) goto L92;
        Object r215 = "";
    L93:
        String r143 = r100.n();     // Catch: Exception -> L173
        if (r143 != null) goto L96;
        String r216 = "";
    L97:
        Boolean r144 = r100.l();     // Catch: Exception -> L173
        if (r144 == null) goto L100;
        boolean r217 = r144.booleanValue();     // Catch: Exception -> L173
    L101:
        Integer r145 = r100.s();     // Catch: Exception -> L173
        if (r145 == null) goto L104;
        int r218 = r145.intValue();     // Catch: Exception -> L173
    L105:
        Boolean r146 = r100.f();     // Catch: Exception -> L173
        if (r146 == null) goto L108;
        boolean r219 = r146.booleanValue();     // Catch: Exception -> L173
    L109:
        Boolean r147 = r100.k();     // Catch: Exception -> L173
        if (r147 == null) goto L112;
        boolean r311 = r147.booleanValue();     // Catch: Exception -> L173
    L113:
        Integer r148 = r100.r();     // Catch: Exception -> L173
        if (r148 == null) goto L116;
        int r312 = r148.intValue();     // Catch: Exception -> L173
    L117:
        String r149 = r100.p();     // Catch: Exception -> L173
        Object r313 = null;
        if (r149 != null) goto L186;
        String r314 = r134;
    L136:
        ?? r150 = r313;
        if (r150 == 0) goto L142;
        String r315 = r150.optString(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT);     // Catch: Exception -> L173
        if (r315 == null) goto L142;
        String r316 = r315;
    L144:
        if (r150 == 0) goto L147;
        String r151 = r150.optString("enter_sub_method");     // Catch: Exception -> L173
        if (r151 == null) goto L147;
    L148:
        String r317 = r100.D();     // Catch: Exception -> L173
        if (r317 != null) goto L151;
        String r318 = "";
    L152:
        Boolean r152 = r100.z();     // Catch: Exception -> L173
        if (r152 == null) goto L155;
        boolean r319 = r152.booleanValue();     // Catch: Exception -> L173
    L156:
        Integer r153 = r100.t();     // Catch: Exception -> L173
        String r154 = r100.u();     // Catch: Exception -> L173
        JSONObject r155 = new JSONObject();     // Catch: Exception -> L173
        r155.put("game_id", r103);     // Catch: Exception -> L173
        r155.put(EventConstants.ExtraJson.GAME_NAME, r109);     // Catch: Exception -> L173
        r155.put("scene", r114);     // Catch: Exception -> L173
        r155.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r116);     // Catch: Exception -> L173
        r155.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r119);     // Catch: Exception -> L173
        r155.put(BdpAppEventConstant.PARAMS_SUB_SCENE, r121);     // Catch: Exception -> L173
        r155.put("user_nick_name", r123);     // Catch: Exception -> L173
        r155.put("traffic_source", r125);     // Catch: Exception -> L173
        r155.put("enter_method", r102);     // Catch: Exception -> L173
        r155.put("creative_id", r129);     // Catch: Exception -> L173
        r155.put("is_ad", r132);     // Catch: Exception -> L173
        r155.put("ad_id", r314);     // Catch: Exception -> L173
        r155.put(PdpOpenThirdParam.KEY_AD_LOG_EXTRA, r136);     // Catch: Exception -> L173
        r155.put("request_id", r210);     // Catch: Exception -> L173
        r155.put("is_other_channel", r211);     // Catch: Exception -> L173
        r155.put(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r316);     // Catch: Exception -> L173
        r155.put("enter_sub_method", r151);     // Catch: Exception -> L173
        r155.put("ad_source_type", r212);     // Catch: Exception -> L173
        r155.put("stock_type", r213);     // Catch: Exception -> L173
        r155.put("original_system_origin", r214);     // Catch: Exception -> L173
        r155.put("if_dou", r215);     // Catch: Exception -> L173
        r155.put("called_from_jsb", true);     // Catch: Exception -> L173
        r155.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r216);     // Catch: Exception -> L173
        r155.put("need_show_success_notice", r217);     // Catch: Exception -> L173
        r155.put("need_show_cancel_alert", r311);     // Catch: Exception -> L173
        r155.put("reserve_alert_type", r312);     // Catch: Exception -> L173
        r155.put("reserve_type", r153);     // Catch: Exception -> L173
        r155.put("reserve_version_num", r154);     // Catch: Exception -> L173
        r155.put(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, r318);     // Catch: Exception -> L173
        r155.put("use_param_passing", r319);     // Catch: Exception -> L173
        int r156 = r218;
        ?? r157 = 1;
        if (r156 != 1) goto L164;
        xr.f r158 = (xr.f) xr.s.a(xr.f.class);     // Catch: Exception -> L173
        if (r158 == null) goto L195;
        b3 r159 = this;
        r158.O1(r410.getContext(), r103, r109, r131, r155, new c3(r159));     // Catch: Exception -> L171
        r157 = r159;
    L190:
        return;
    L195:
        return;
    L164:
        b3 r160 = this;
        if (r156 != 0) goto L196;
        if (r219 == false) goto L197;
        xr.f r161 = (xr.f) xr.s.a(xr.f.class);     // Catch: Exception -> L171
        r157 = r160;
        if (r161 == null) goto L190;
        r161.r0(r410.getContext(), r103, r131, r155, new d3(r160));     // Catch: Exception -> L171
        r157 = r160;
        goto L190
    L197:
        return;
    L196:
        return;
    L171:
        e = e;
    L179:
        GamePromoteReserveResultModel r162 = new GamePromoteReserveResultModel();
        r162.a(GamePromoteReserveResultModel.Code.Failed);
        JSONObject r163 = new JSONObject();
        r163.put(r128, "2-client crash:" + e.getMessage());
        Unit r164 = Unit.INSTANCE;
        r162.b(r163.toString());
        r157.finishWithResult(r162);
        return;
    L155:
        r319 = false;
        goto L156
    L151:
        r318 = r317;
    L147:
        r151 = "";
    L142:
        r316 = "";
        goto L144
    L186:
        Result.Companion r320 = Result.Companion;     // Catch: Throwable -> L126
        r314 = r134;
        Object r165 = Result.m9449constructorimpl(new JSONObject(r149));     // Catch: Throwable -> L124
    L130:
        if (Result.m9455isFailureimpl(r165) == true) goto L133;
        r313 = r165;
    L133:
        r313 = (JSONObject) r313;     // Catch: Exception -> L173
    L124:
        th = th;
    L128:
        Result.Companion r166 = Result.Companion;     // Catch: Exception -> L173
        r165 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L173
    L126:
        th = th;
        r314 = r134;
        goto L128
    L116:
        r312 = 0;
        goto L117
    L112:
        r311 = false;
        goto L113
    L108:
        r219 = false;
        goto L109
    L104:
        r218 = 1;
        goto L105
    L100:
        r217 = false;
        goto L101
    L96:
        r216 = r143;
        goto L97
    L92:
        r215 = r142;
        goto L93
    L88:
        r214 = r141;
        goto L89
    L84:
        r213 = r140;
        goto L85
    L80:
        r212 = r139;
        goto L81
    L76:
        r211 = r138;
        goto L77
    L72:
        r210 = r137;
        goto L73
    L68:
        r136 = r135;
    L173:
        e = e;
        r157 = this;
        goto L179
    L64:
        r134 = r133;
        goto L188
    L60:
        r132 = r130;
    L175:
        e = e;
    L176:
        r157 = this;
        goto L179
    L56:
        r129 = r127;
        goto L184
    L47:
        r125 = r124;
        goto L48
    L43:
        r123 = r122;
        goto L44
    L39:
        r121 = r120;
    L35:
        r119 = 0;
        goto L36
    L29:
        r116 = r115;
        goto L30
    L25:
        r113 = 0;
        goto L26
    L21:
        r111 = r110;
        goto L22
    L17:
        r109 = r108;
        goto L18
    L11:
        r104 = false;
        goto L12
    L7:
        r103 = r101;
    L177:
        e = e;
        r128 = "error_reason";
        goto L176
    }
}
