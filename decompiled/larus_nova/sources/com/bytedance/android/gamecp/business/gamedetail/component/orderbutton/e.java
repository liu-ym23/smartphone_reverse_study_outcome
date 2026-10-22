package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.business.GameCPService;
import com.bytedance.android.gamecp.business.gamedetail.GamePromoteDetailDialogManager;
import com.bytedance.android.gamecp.business.gamedetail.base.AudienceGamePromoteDetailApi;
import com.bytedance.android.gamecp.business.monitorlink.GamePromoteMonitorLinkHandler;
import com.bytedance.android.gamecp.business.track.GamePromoteOrderTrack;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.l1;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.gamecenter.base.v;
import com.bytedance.ies.sve_core.Store;
import com.bytedance.ies.sve_core.w;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import wu.p2;
import wu.x;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends w {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f54831i = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f54833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f54834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f54835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ yt.a f54836h;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.e$a$a, reason: collision with other inner class name */
        public static final class C0892a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f54837a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q f54838b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f54839c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f54840d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f54841e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f54842f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Context f54843g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f54844h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ String f54845i;

            public C0892a(m r100, q r101, JSONObject r102, boolean r103, boolean r104, boolean r105, Context r106, int r107, String r108) {
                this.f54837a = r100;
                this.f54838b = r101;
                this.f54839c = r102;
                this.f54840d = r103;
                this.f54841e = r104;
                this.f54842f = r105;
                this.f54843g = r106;
                this.f54844h = r107;
                this.f54845i = r108;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r110) {
                com.bytedance.android.gamecp.base.network.response.h r111 = (com.bytedance.android.gamecp.base.network.response.h) r110;
                yr.b.b(3, "GameOrder-AudienceOrder", "预约请求成功");
                String r100 = GsonProtectorUtils.toJson(new Gson(), (JsonElement) r111.data);     // Catch: JSONException -> L51
                String r101 = "";
                if (((JsonObject) r111.data).has("dialog_tips") == false) goto L7;
                String r102 = ((JsonObject) r111.data).get("dialog_tips").getAsString();     // Catch: JSONException -> L51
            L9:
                if (((JsonObject) r111.data).has("is_select_wifi_auto_download") == false) goto L11;
                boolean r112 = ((JsonObject) r111.data).get("is_select_wifi_auto_download").getAsBoolean();     // Catch: JSONException -> L51
            L13:
                if (((JsonObject) r111.data).has("order_id") == false) goto L15;
                String r103 = ((JsonObject) r111.data).get("order_id").getAsString();     // Catch: JSONException -> L51
            L17:
                if (((JsonObject) r111.data).has(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID) == false) goto L19;
                String r104 = ((JsonObject) r111.data).get(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID).getAsString();     // Catch: JSONException -> L51
            L21:
                if (((JsonObject) r111.data).has("dialog_schema") == false) goto L23;
                r101 = ((JsonObject) r111.data).get("dialog_schema").getAsString();     // Catch: JSONException -> L51
            L23:
                JSONObject r113 = new JSONObject();     // Catch: JSONException -> L51
                r113.putOpt("dialog_tips", r102);     // Catch: JSONException -> L51
                r113.putOpt("is_select_wifi_auto_download", Boolean.valueOf(r112));     // Catch: JSONException -> L51
                r113.putOpt("reserve_response", r100);     // Catch: JSONException -> L51
                r113.toString();     // Catch: JSONException -> L51
                m r105 = this.f54837a;     // Catch: JSONException -> L51
                if (r105 == null) goto L26;
                r105.onSuccess(r113);     // Catch: JSONException -> L51
            L26:
                q r114 = this.f54838b;     // Catch: JSONException -> L51
                r114.getClass();     // Catch: JSONException -> L51
                Intrinsics.checkNotNullParameter(r103, "<set-?>");     // Catch: JSONException -> L51
                r114.f54882a = r103;     // Catch: JSONException -> L51
                JSONObject r115 = this.f54839c;     // Catch: JSONException -> L51
                if (r115 == null) goto L29;
                r115.put("dialog_tips", r102);     // Catch: JSONException -> L51
            L29:
                JSONObject r116 = this.f54839c;     // Catch: JSONException -> L51
                if (r116 == null) goto L32;
                r116.put("is_select_wifi_auto_download", r112);     // Catch: JSONException -> L51
            L32:
                a r117 = e.f54831i;     // Catch: JSONException -> L51
                a.b(r117, this.f54838b.f54883b, this.f54839c, r104, this.f54840d);     // Catch: JSONException -> L51
                if (this.f54841e == false) goto L35;
            L38:
                Context r106 = this.f54843g;     // Catch: JSONException -> L51
                if ((r106 instanceof Activity) == true) goto L41;
                r106 = null;
            L41:
                Context r107 = (Activity) r106;     // Catch: JSONException -> L51
                if (r107 != null) goto L48;
                r107 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().A1();     // Catch: JSONException -> L51
                if (r107 != null) goto L48;
                r107 = this.f54843g;     // Catch: JSONException -> L51
            L48:
                q r108 = this.f54838b;     // Catch: JSONException -> L51
                int r109 = this.f54844h;     // Catch: JSONException -> L51
                LinkedHashMap r118 = new LinkedHashMap();     // Catch: JSONException -> L51
                r118.put("reserve_response", r100);     // Catch: JSONException -> L51
                r118.put(EventConstants.ExtraJson.GAME_NAME, r108.f54884c);     // Catch: JSONException -> L51
                r118.put("reserve_alert_type", String.valueOf(r109));     // Catch: JSONException -> L51
                com.bytedance.android.gamecp.business.hybrid.a.c(r107, r101, r118);     // Catch: JSONException -> L51
            L49:
                q r119 = this.f54838b;     // Catch: JSONException -> L51
                a.d(r117, r119.f54883b, this.f54845i, true, false, r119.f54890i, r119.f54891j);     // Catch: JSONException -> L51
                return;
            L35:
                if (this.f54840d == true) goto L49;
                if (this.f54842f == false) goto L49;
            L19:
                r104 = "";
                goto L21
            L15:
                r103 = "";
                goto L17
            L11:
                r112 = true;
                goto L13
            L7:
                r102 = "";
            L51:
                e = move-exception;
                yr.c.b("GameOrder-AudienceOrder", "e = " + e);
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f54846a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f54847b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ q f54848c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f54849d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ m f54850e;

            public b(boolean r100, boolean r101, q r102, String r103, m r104) {
                this.f54846a = r100;
                this.f54847b = r101;
                this.f54848c = r102;
                this.f54849d = r103;
                this.f54850e = r104;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                a r102 = e.f54831i;
                a.a(r102, r101);
                if (l1.a(r101) == 4014112) goto L13;
                if (this.f54846a == true) goto L13;
                if (this.f54847b == false) goto L13;
                String r103 = l1.c(r101);
                if (r103 != null) goto L11;
                r103 = y0.i(R.string.gamecp_reserve_failed);
            L11:
                ToastUtil.b(r103, 0);
            L13:
                if (l1.a(r101) != 4014137) goto L15;
                q r104 = this.f54848c;
                a.d(r102, r104.f54883b, this.f54849d, true, false, r104.f54890i, r104.f54891j);
            L15:
                m r105 = this.f54850e;
                if (r105 == null) goto L19;
                r105.onFail(r101);
                return;
            }
        }

        public a() {
        }

        public static int j(String r100) {
            if (r100 != null) goto L14;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L16;
            return CastIntegerProtector.parseInt(r100);
        L17:
            return 0;
        L16:
            return 0;
        L14:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r101 = false;
            goto L9
        }

        public static long k(String r100) {
            if (r100 != null) goto L15;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == true) goto L12;
            return CastLongProtector.parseLong(r100);
        L12:
            return 0;
        L15:
            if (StringsKt.isBlank(r100) == true) goto L7;
            r101 = false;
            goto L8
        }

        public static final void a(a r100, Throwable r101) {
            r100.getClass();
            yr.b.b(3, "GameOrder-AudienceOrder", "请求失败，" + l1.a(r101));
            if ((r101 instanceof CustomApiServerException) == false) goto L6;
            yr.b.b(3, "GameOrder-AudienceOrder", "logId: " + ((CustomApiServerException) r101).getXTtLogId());
            return;
        }

        public static Observable e(String r110, int r111, String r112) {
            HashMap<String, String> r100 = GamecpTracker.f56755a;
            String r101 = null;
            com.bytedance.android.gamecp.common.track.filter.d r102 = GamecpTracker.i(zu.e.class, null);
            if ((r102 instanceof com.bytedance.android.gamecp.common.track.filter.e) == true) goto L5;
            r102 = null;
        L5:
            com.bytedance.android.gamecp.common.track.filter.e r103 = (com.bytedance.android.gamecp.common.track.filter.e) r102;
            com.bytedance.android.gamecp.common.track.filter.d r104 = GamecpTracker.i(zu.a.class, null);
            if ((r104 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L8;
            r104 = null;
        L8:
            com.bytedance.android.gamecp.common.track.filter.b r105 = (com.bytedance.android.gamecp.common.track.filter.b) r104;
            String r106 = "";
            if (r103 == null) goto L16;
            Map<String, String> r107 = r103.f56801a;
            if (r107 == null) goto L14;
            String r108 = r107.get("traffic_source");
            if (r108 == null) goto L14;
        L15:
            String r109 = r108;
        L17:
            if (r105 == null) goto L19;
            String r113 = r105.d();
        L20:
            int r114 = j(r113);
            if (r105 == null) goto L23;
            String r115 = r105.b();
        L24:
            if (r105 == null) goto L26;
            String r116 = r105.c();
        L27:
            if (r103 == null) goto L29;
            r101 = r103.b();
        L29:
            String r117 = r101;
            String r118 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().P();
            JSONObject r119 = new JSONObject();
            if (r103 == null) goto L35;
            String r120 = r103.c();
            if (r120 == null) goto L35;
            r106 = r120;
        L35:
            r119.put("is_other_channel", r106);
            Observable<com.bytedance.android.gamecp.base.network.response.c> r121 = ((AudienceGamePromoteDetailApi) bs.e.a().b(AudienceGamePromoteDetailApi.class)).cancelOrderGame(r110, r109, Integer.valueOf(r114), r115, r116, r117, r118, r111, r112, r119.toString());
            hv.b r122 = hv.d.f487273a;
            return r121.compose(new hv.a());
        L26:
            r116 = null;
            goto L27
        L23:
            r115 = null;
            goto L24
        L19:
            r113 = null;
        L14:
            r108 = "";
            goto L15
        L16:
            r109 = null;
            goto L17
        }

        public static String l(JSONObject r100, String r101, String r102) {
            String r103 = r100.optString(r101);
            if (r103.length() <= 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L9;
            r103 = null;
        L9:
            if (r103 != null) goto L11;
            return r102;
        L11:
            return r103;
        L5:
            r104 = false;
            goto L6
        }

        public static final void b(a r210, String r211, JSONObject r212, String r213, boolean r214) {
            r210.getClass();
            Room r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r100 == null) goto L6;
            String r101 = r100.getOwnerUserId();
            if (r101 == null) goto L6;
        L7:
            HashMap<String, String> r102 = GamecpTracker.f56755a;
            String r103 = null;
            com.bytedance.android.gamecp.common.track.filter.d r104 = GamecpTracker.i(zu.a.class, null);
            if ((r104 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L10;
            r104 = null;
        L10:
            com.bytedance.android.gamecp.common.track.filter.b r105 = (com.bytedance.android.gamecp.common.track.filter.b) r104;
            if (r105 == null) goto L13;
            String r106 = r105.d();
        L14:
            int r107 = j(r106);
            if (r105 == null) goto L17;
            String r108 = r105.b();
        L18:
            if (r105 == null) goto L21;
            r103 = r105.c();
        L21:
            if (r212 == null) goto L26;
            long r110 = r212.optLong("scene");
            r101 = r212.optString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID);
            if (r212.optBoolean("is_ad") == false) goto L25;
            r107 = 1;
        L25:
            e.f54831i.getClass();
            r108 = l(r212, "ad_id", r108);
            r103 = l(r212, "creative_id", r103);
            String r109 = r212.optString(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID);
            int r111 = r212.optInt(" reserve_type", 1);
            String r112 = r212.optString("reserve_version_num", "");
        L27:
            Lazy r113 = GamePromoteMonitorLinkHandler.f56168a;
            int r114 = (int) r110;
            Pair[] r115 = new Pair[10];
            boolean r116 = false;
            r115[0] = TuplesKt.to("game_id", r211);
            r115[1] = TuplesKt.to("promote_id", r101);
            if (r212 == null) goto L31;
            String r117 = r212.optString(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP);
            if (r117 == null) goto L31;
        L32:
            r115[2] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, r117);
            if (r213 != null) goto L35;
            String r118 = "";
        L36:
            r115[3] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID, r118);
            r115[4] = TuplesKt.to("btn_type", "book");
            r115[5] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r109);
            if (r212 == null) goto L40;
            String r119 = r212.optString("enter_sub_method");
            if (r119 == null) goto L40;
        L41:
            r115[6] = TuplesKt.to("enter_sub_method", r119);
            if (r212 == null) goto L45;
            String r120 = r212.optString(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT);
            if (r120 == null) goto L45;
        L46:
            r115[7] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r120);
            r115[8] = TuplesKt.to("reserve_type", String.valueOf(r111));
            r115[9] = TuplesKt.to("reserve_version_num", String.valueOf(r112));
            HashMap r121 = MapsKt.hashMapOf(r115);
            if (r214 == false) goto L110;
            if (r212 == null) goto L51;
            String r122 = r212.optString("traffic_source");
            if (r122 == null) goto L51;
        L52:
            r121.put("enter_from_merge", r122);
            if (r212 == null) goto L56;
            String r123 = r212.optString("is_other_channel");
            if (r123 == null) goto L56;
        L57:
            r121.put("is_other_channel", r123);
            if (r212 == null) goto L61;
            String r124 = r212.optString(PdpOpenThirdParam.KEY_AD_LOG_EXTRA);
            if (r124 == null) goto L61;
        L62:
            r121.put("log_extra", r124);
            if (r103 != null) goto L65;
            r103 = "";
        L65:
            r121.put("value", r103);
            r121.put("is_ads", String.valueOf(r107));
            if (r108 != null) goto L68;
            String r125 = "";
        L69:
            r121.put("ad_plan_id", r125);
            if (r110 != 0) goto L77;
            if (r212 == null) goto L74;
            String r126 = r212.optString(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
            if (r126 == null) goto L74;
        L75:
            r121.put("room_id", r126);
        L84:
            if (r212 == null) goto L87;
            String r127 = r212.optString("request_id");
            if (r127 == null) goto L87;
        L88:
            r121.put("request_id", r127);
            r121.put("is_ad", String.valueOf(r107));
            if (r108 != null) goto L91;
            r108 = "";
        L91:
            r121.put("ad_id", r108);
            if (r212 == null) goto L94;
            int r128 = r212.optInt("ad_source_type");
        L95:
            r121.put("ad_source_type", String.valueOf(r128));
            if (r212 == null) goto L98;
            int r129 = r212.optInt("stock_type");
        L99:
            r121.put("stock_type", String.valueOf(r129));
            if (r212 == null) goto L102;
            int r130 = r212.optInt("original_system_origin");
        L103:
            r121.put("original_system_origin", String.valueOf(r130));
            if (r212 != null) goto L106;
        L108:
            String r131 = "0";
        L109:
            r121.put("if_dou", r131);
            goto L110
        L106:
            if (r212.optBoolean("if_dou") != true) goto L108;
            r131 = "1";
            goto L109
        L102:
            r130 = 0;
            goto L103
        L98:
            r129 = 0;
            goto L99
        L94:
            r128 = 0;
        L87:
            r127 = "";
        L74:
            r126 = "";
            goto L75
        L77:
            if (r110 != 1) goto L84;
            if (r212 == null) goto L81;
            String r132 = r212.optString(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
            if (r132 == null) goto L81;
        L82:
            r121.put("video_id", r132);
        L81:
            r132 = "";
            goto L82
        L68:
            r125 = r108;
        L61:
            r124 = "";
        L56:
            r123 = "";
        L51:
            r122 = "";
        L110:
            Unit r133 = Unit.INSTANCE;
            if (r110 == 0) goto L114;
            r116 = r214;
        L114:
            GamePromoteMonitorLinkHandler.a(r114, "livesdk_game_promote_user_btn_click", r121, r116);
            return;
        L45:
            r120 = "";
        L40:
            r119 = "";
            goto L41
        L35:
            r118 = r213;
        L31:
            r117 = "0";
            goto L32
        L26:
            r109 = "";
            r112 = r109;
            r111 = 1;
            r110 = 0;
            goto L27
        L17:
            r108 = null;
            goto L18
        L13:
            r106 = null;
        L6:
            r101 = "0";
            goto L7
        }

        public static final void c(a r100, Context r101, String r102, int r103, int r104) {
            r100.getClass();
            JSONObject r105 = new JSONObject();
            if (r102 == null) goto L5;
            r105.putOpt("game_id", r102);
        L5:
            r105.putOpt("reserve_type", Integer.valueOf(r103));
            r105.putOpt(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, Integer.valueOf(r104));
            com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().E();
            com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().X(r101, r105);
        }

        public static Observable i(String r310, JSONObject r311, Long r312, int r313, String r314) {
            Room r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r100 == null) goto L6;
            String r101 = r100.getOwnerUserId();
            if (r101 == null) goto L6;
        L7:
            Room r102 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r102 == null) goto L10;
            Long r103 = r102.getRoomId();
        L11:
            String r104 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().b().getNickName();
            HashMap<String, String> r105 = GamecpTracker.f56755a;
            com.bytedance.android.gamecp.common.track.filter.d r106 = GamecpTracker.i(zu.e.class, null);
            if ((r106 instanceof com.bytedance.android.gamecp.common.track.filter.e) == true) goto L14;
            r106 = null;
        L14:
            com.bytedance.android.gamecp.common.track.filter.e r107 = (com.bytedance.android.gamecp.common.track.filter.e) r106;
            com.bytedance.android.gamecp.common.track.filter.d r108 = GamecpTracker.i(zu.a.class, null);
            if ((r108 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L17;
            r108 = null;
        L17:
            com.bytedance.android.gamecp.common.track.filter.b r109 = (com.bytedance.android.gamecp.common.track.filter.b) r108;
            String r110 = "";
            if (r107 == null) goto L24;
            Map<String, String> r111 = r107.f56801a;
            if (r111 == null) goto L23;
            String r112 = r111.get("traffic_source");
            if (r112 == null) goto L23;
        L25:
            if (r109 == null) goto L27;
            String r113 = r109.d();
        L28:
            int r114 = Integer.valueOf(j(r113));
            if (r109 == null) goto L31;
            String r115 = r109.b();
        L32:
            if (r109 == null) goto L34;
            String r116 = r109.c();
        L35:
            if (r107 == null) goto L37;
            String r117 = r107.b();
        L38:
            String r210 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().P();
            if (r311 == null) goto L60;
            long r118 = r311.optLong("scene");
            if (r118 != 0) goto L44;
            r103 = Long.valueOf(r311.optLong(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID));
            Long r119 = 0L;
        L47:
            String r120 = r311.optString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID);
            String r121 = r311.optString("user_nick_name");
            if (r121.length() <= 0) goto L50;
            boolean r122 = true;
        L51:
            if (r122 == true) goto L54;
            r121 = null;
        L54:
            if (r121 == null) goto L56;
            r104 = r121;
        L56:
            String r123 = r311.optString(BdpAppEventConstant.PARAMS_SUB_SCENE);
            if (r311.optBoolean("is_ad") == false) goto L59;
            r114 = 1;
        L59:
            e.f54831i.getClass();
            String r124 = l(r311, "traffic_source", r112);
            String r125 = l(r311, "ad_id", r115);
            String r126 = l(r311, "creative_id", r116);
            String r127 = l(r311, "enter_method", r117);
            String r315 = r311.optString(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID);
            Long r211 = r119;
            String r212 = r126;
            String r213 = r124;
            Integer r214 = r114;
            String r215 = r125;
            String r216 = r127;
            String r217 = r123;
            long r218 = r118;
            String r128 = r120;
        L61:
            JSONObject r129 = new JSONObject();
            if (r107 == null) goto L67;
            String r130 = r107.c();
            if (r130 == null) goto L67;
            r110 = r130;
        L67:
            r129.put("is_other_channel", r110);
            AudienceGamePromoteDetailApi r131 = (AudienceGamePromoteDetailApi) bs.e.a().b(AudienceGamePromoteDetailApi.class);
            if (r103 == null) goto L70;
            long r132 = r103.longValue();
        L71:
            Observable<com.bytedance.android.gamecp.base.network.response.h<JsonObject>> r133 = r131.orderGame(r310, r128, r132, r104, r211, r218, r217, r213, r214, r215, r212, r216, r210, r315, r313, r314, r129.toString());
            hv.b r134 = hv.d.f487273a;
            return r133.compose(new hv.a());
        L70:
            r132 = 0;
            goto L71
        L50:
            r122 = false;
            goto L51
        L44:
            if (r118 != 1) goto L46;
            r119 = Long.valueOf(r311.optLong(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID));
            r103 = 0L;
            goto L47
        L46:
            r119 = r312;
            goto L47
        L60:
            r211 = r312;
            r128 = r101;
            r212 = r116;
            r217 = "";
            r315 = r217;
            r213 = r112;
            r214 = r114;
            r215 = r115;
            r216 = r117;
            r218 = 0;
            goto L61
        L37:
            r117 = null;
            goto L38
        L34:
            r116 = null;
            goto L35
        L31:
            r115 = null;
            goto L32
        L27:
            r113 = null;
        L23:
            r112 = "";
            goto L25
        L24:
            r112 = null;
            goto L25
        L10:
            r103 = null;
        L6:
            r101 = "0";
            goto L7
        }

        public final Disposable g(Context r110, String r111, q r112, r r210, JSONObject r211, m r212) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "anchorId");
            Intrinsics.checkNotNullParameter(r112, "orderInfo");
            int r100 = GamePromoteOrderTrack.f56417a;
            GamePromoteOrderTrack.b(r112.f54884c, r112.f54883b, r210.f54894a, r210.f54895b, Boolean.valueOf(r210.f54896c), r210.f54897d);
            r212.a();
            if (r211 == null) goto L5;
            boolean r113 = r211.optBoolean("called_from_jsb");
        L6:
            if (r211 == null) goto L8;
            boolean r114 = r211.optBoolean("need_show_success_notice");
        L10:
            if (r211 == null) goto L12;
            boolean r115 = r211.optBoolean("need_show_success_notice_native", true);
        L13:
            if (r211 == null) goto L15;
            int r116 = r211.optInt("reserve_alert_type", 0);
        L16:
            Observable r101 = h(this, r110, r112.f54883b, r211, null, r112.f54890i, r112.f54891j, 8);
            if (r101 == null) goto L21;
            hv.b r102 = hv.d.f487273a;
            Observable r103 = r101.compose(new hv.a());
            if (r103 == null) goto L21;
            return r103.subscribe(new C0892a(r212, r112, r211, r113, r114, r115, r110, r116, r111), new b(r113, r115, r112, r111, r212));
        L21:
            return null;
        L15:
            r116 = 0;
            goto L16
        L12:
            r115 = true;
            goto L13
        L8:
            r114 = false;
            goto L10
        L5:
            r113 = false;
            goto L6
        }

        public static final void d(a r100, String r101, String r102, boolean r103, boolean r110, int r111, String r112) {
            r100.getClass();
            p r104 = new p(r101, r102, r103, r110, 8);
            jv.a.a().b(r104);
            jw.c r105 = (jw.c) s.a(jw.c.class);
            if (r105 == null) goto L9;
            Pair[] r106 = new Pair[4];
            r106[0] = TuplesKt.to("gameID", r101);
            r106[1] = TuplesKt.to("reserveStatus", Integer.valueOf(r104.f54880d));
            r106[2] = TuplesKt.to("reserveType", Integer.valueOf(r111));
            if (r112 != null) goto L7;
            r112 = "";
        L7:
            r106[3] = TuplesKt.to("reserveVersionNum", r112);
            r105.sendJsEventToEventCenter("gamecpReserveStatusUpdate", MapsKt.mapOf(r106));
            return;
        }

        public static Observable h(a r100, Context r101, String r102, JSONObject r103, Long r110, int r111, String r112, int r113) {
            if ((r113 & 4) == 0) goto L5;
            r103 = null;
        L5:
            JSONObject r104 = r103;
            if ((r113 & 8) == 0) goto L8;
            r110 = 0L;
        L8:
            Long r105 = r110;
            if ((r113 & 16) == 0) goto L11;
            int r106 = 1;
        L13:
            if ((r113 & 32) == 0) goto L15;
            r112 = "";
        L15:
            String r107 = r112;
            r100.getClass();
            if (com.bytedance.android.gamecp.host_api.a.b().getUserService().user().isLogin() == true) goto L22;
            if (Intrinsics.areEqual(x.f561413a.getValue(), Boolean.TRUE) == false) goto L20;
            hw.b r108 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user();
            com.bytedance.android.gamecp.host_api.model.user.c.a r114 = new com.bytedance.android.gamecp.host_api.model.user.c.a();
            r114.f57409a = y0.i(R.string.ttlive_login_dialog_message);
            r114.f57411c = "game_promote";
            r114.f57410b = -1;
            return r108.c(r101, new com.bytedance.android.gamecp.host_api.model.user.c(r114)).concatMap(new f(r102, r104, r105, r106, r107));
        L20:
            hw.b r109 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user();
            com.bytedance.android.gamecp.host_api.model.user.c.a r115 = new com.bytedance.android.gamecp.host_api.model.user.c.a();
            r115.f57409a = y0.i(R.string.ttlive_login_dialog_message);
            r115.f57411c = "game_promote";
            r115.f57410b = -1;
            r109.c(r101, new com.bytedance.android.gamecp.host_api.model.user.c(r115));
            Observable r116 = Observable.error(new IllegalStateException("用户未登录"));
            hv.b r117 = hv.d.f487273a;
            return r116.compose(new hv.a());
        L22:
            return i(r102, r104, r105, r106, r107);
        L11:
            r106 = r111;
            goto L13
        }

        public static void f(final Context r110, final String r111, final String r112, String r113, final int r114, final String r115, String r116, final int r117, String r210, boolean r211, boolean r212, final GameCPService.b r213) {
            Intrinsics.checkNotNullParameter(r110, "ctx");
            Intrinsics.checkNotNullParameter(r111, "gameId");
            Intrinsics.checkNotNullParameter(r112, "anchorId");
            Intrinsics.checkNotNullParameter(r113, "enterFrom");
            Intrinsics.checkNotNullParameter(r116, "isRsvp");
            Intrinsics.checkNotNullParameter(r210, "promoteInstanceId");
            Lazy r100 = GamePromoteMonitorLinkHandler.f56168a;
            GamePromoteMonitorLinkHandler.a(r117, "livesdk_game_promote_user_btn_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("game_id", r111), TuplesKt.to("promote_id", r112), TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, r116), TuplesKt.to("btn_type", "cancel_book"), TuplesKt.to(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r210), TuplesKt.to("reserve_type", String.valueOf(r114)), TuplesKt.to("reserve_version_num", r115)}), r211);
            if (r212 == true) goto L5;
            Observable r101 = e(r111, r114, r115);
            hv.b r102 = hv.d.f487273a;
            r101.compose(new hv.a()).subscribe(new com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.c(r213, r111, r112, r114, r115, r110, r117), new d(r213));
            return;
        L5:
            final Function0<Unit> r118 = new AudienceOrderEffect$Companion$cancelOrderGame$3(r213, r111, r114, r115, r112, r110, r117);
            final Function0<Unit> r103 = new AudienceOrderEffect$Companion$cancelOrderGame$4(r213);
            Intrinsics.checkNotNullParameter(r110, "ctx");
            Intrinsics.checkNotNullParameter(r118, "confirm");
            com.bytedance.android.gamecp.business.gamedetail.view.n r104 = new com.bytedance.android.gamecp.business.gamedetail.view.n(r110);
            Function0<Unit> r105 = new AudienceOrderEffect$Companion$doubleCheckCancelOrder$1(r118);
            Intrinsics.checkNotNullParameter(r105, "block");
            r104.f55937a = r105;
            Function0<Unit> r106 = new AudienceOrderEffect$Companion$doubleCheckCancelOrder$2(r103);
            Intrinsics.checkNotNullParameter(r106, "block");
            r104.f55938b = r106;
            if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r104);
            return;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r104);
            r104.show();
            DialogLancet.afterDialogShow(r104);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f54851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ dt.b f54852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f54853c;

        public b(e r100, dt.b r101, JSONObject r102) {
            this.f54851a = r100;
            this.f54852b = r101;
            this.f54853c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            com.bytedance.android.gamecp.base.network.response.h r100 = (com.bytedance.android.gamecp.base.network.response.h) r210;
            yr.b.b(3, "GameOrder-AudienceOrder", "预约请求成功");
            Store r101 = this.f54851a.f248705c;
            int r102 = com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.f55589d;
            r101.dispatch(com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.C0896a.a(), new com.bytedance.android.gamecp.business.gamedetail.page.root.state.b.c(false));
            a r103 = e.f54831i;
            dt.b r104 = this.f54852b;
            String r110 = r104.F;
            if (r110 != null) goto L5;
            String r111 = "";
        L6:
            String r105 = r104.I;
            if (r105 != null) goto L9;
            String r112 = "";
        L10:
            a.d(r103, r111, r112, true, true, 1, null);
            String r106 = new Gson().toJson((JsonElement) r100.data);     // Catch: Exception -> L42
            if (((JsonObject) r100.data).has("dialog_tips") == false) goto L14;
            String r113 = ((JsonObject) r100.data).get("dialog_tips").getAsString();     // Catch: Exception -> L42
        L16:
            if (((JsonObject) r100.data).has("is_select_wifi_auto_download") == false) goto L18;
            boolean r114 = ((JsonObject) r100.data).get("is_select_wifi_auto_download").getAsBoolean();     // Catch: Exception -> L42
        L20:
            if (((JsonObject) r100.data).has("order_id") == false) goto L22;
            String r107 = ((JsonObject) r100.data).get("order_id").getAsString();     // Catch: Exception -> L42
        L24:
            if (((JsonObject) r100.data).has(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID) == false) goto L26;
            String r108 = ((JsonObject) r100.data).get(AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID).getAsString();     // Catch: Exception -> L42
        L28:
            if (((JsonObject) r100.data).has("dialog_schema") == false) goto L30;
            String r109 = ((JsonObject) r100.data).get("dialog_schema").getAsString();     // Catch: Exception -> L42
        L31:
            this.f54853c.put("dialog_tips", r113);     // Catch: Exception -> L42
            this.f54853c.put("is_select_wifi_auto_download", r114);     // Catch: Exception -> L42
            String r115 = this.f54852b.F;     // Catch: Exception -> L42
            if (r115 != null) goto L34;
            r115 = "";
        L34:
            a.b(r103, r115, this.f54853c, r108, false);     // Catch: Exception -> L42
            Context r116 = this.f54851a.getContext();     // Catch: Exception -> L42
            String r117 = this.f54852b.F;     // Catch: Exception -> L42
            if (r117 != null) goto L37;
            r117 = "";
        L37:
            String r118 = this.f54851a.f54832d;     // Catch: Exception -> L42
            JSONObject r119 = new JSONObject();     // Catch: Exception -> L42
            String r120 = String.valueOf(this.f54852b.P);     // Catch: Exception -> L42
            String r121 = this.f54852b.R;     // Catch: Exception -> L42
            if (r121 != null) goto L40;
            r121 = "";
        L40:
            Intrinsics.checkNotNullParameter(r107, "orderId");     // Catch: Exception -> L42
            Intrinsics.checkNotNullParameter(r117, "gameId");     // Catch: Exception -> L42
            Intrinsics.checkNotNullParameter(r118, "gameName");     // Catch: Exception -> L42
            Intrinsics.checkNotNullParameter(r119, "extra");     // Catch: Exception -> L42
            Intrinsics.checkNotNullParameter(r120, "scene");     // Catch: Exception -> L42
            Intrinsics.checkNotNullParameter(r121, "videoId");     // Catch: Exception -> L42
            Intrinsics.checkNotNullParameter("https://webcast.amemv.com/webcast/gamecp/user/auto_download/check/", "orderUrl");     // Catch: Exception -> L42
            LinkedHashMap r122 = new LinkedHashMap();     // Catch: Exception -> L42
            r122.put("reserve_response", r106);     // Catch: Exception -> L42
            r122.put(EventConstants.ExtraJson.GAME_NAME, r118);     // Catch: Exception -> L42
            r122.put("reserve_alert_type", String.valueOf(1));     // Catch: Exception -> L42
            com.bytedance.android.gamecp.business.hybrid.a.c(r116, r109, r122);     // Catch: Exception -> L42
            return;
        L30:
            r109 = "";
            goto L31
        L26:
            r108 = "";
            goto L28
        L22:
            r107 = "";
            goto L24
        L18:
            r114 = true;
            goto L20
        L14:
            r113 = "";
        L42:
            e = move-exception;
            yr.c.b("GameOrder-AudienceOrder", "e = " + e);
            return;
        L9:
            r112 = r105;
            goto L10
        L5:
            r111 = r110;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f54854a;

        public c(e r100) {
            this.f54854a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (l1.a(r101) != 4014112) goto L5;
            e r102 = this.f54854a;
            r102.getClass();
            ToastUtil.b("游戏已上线，刷新后可试玩", 0);
            GamePromoteDetailDialogManager r103 = GamePromoteDetailDialogManager.f53445d;
            GamePromoteDetailDialogManager.c(r103);
            dt.b r104 = (dt.b) r102.b(dt.e.f469988b);
            Context r105 = r102.f54833e;
            r104.getClass();
            Bundle r106 = new Bundle();
            r106.putString("game_id", r104.F);
            r106.putString("enter_from", r104.G);
            r106.putString("game_ad_type", r104.H);
            r106.putString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r104.Q);
            r106.putString("room_id", r104.f469939J);
            r106.putString(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, String.valueOf(r104.P));
            r106.putString(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r104.f469959j0);
            r103.getClass();
            GamePromoteDetailDialogManager.d(r105, r106, false);
        L9:
            a.a(e.f54831i, r101);
            return;
        L5:
            String r107 = l1.c(r101);
            if (r107 != null) goto L8;
            r107 = y0.i(R.string.gamecp_reserve_failed);
        L8:
            ToastUtil.b(r107, 0);
            Store r108 = this.f54854a.f248705c;
            int r109 = com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.f55589d;
            r108.dispatch(com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.C0896a.a(), new com.bytedance.android.gamecp.business.gamedetail.page.root.state.b.a());
            goto L9
        }
    }

    static {
        f54831i = new a();
    }

    @Override // com.bytedance.ies.sve_core.w
    public final void e() {
        this.f54836h.b();
    }

    public final Context getContext() {
        return this.f54833e;
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r310) {
        Intrinsics.checkNotNullParameter(r310, "action");
        boolean r100 = r310 instanceof n;
        if (r100 == false) goto L5;
    L7:
        dt.b r101 = (dt.b) b(dt.e.f469988b);
        int r102 = com.bytedance.android.gamecp.business.gamedetail.page.root.d.f55481b;
        com.bytedance.android.gamecp.business.gamedetail.page.root.d r103 = (com.bytedance.android.gamecp.business.gamedetail.page.root.d) ((com.bytedance.ies.sve_core.o) c(com.bytedance.android.gamecp.business.gamedetail.page.root.d.a.a()).getFirst()).b();
        if (r103 == null) goto L13;
        com.bytedance.android.gamecp.business.gamedetail.page.root.b r104 = r103.f55482a;
        if (r104 == null) goto L13;
        String r105 = r104.f55467a;
        if (r105 == null) goto L13;
    L14:
        String r106 = r105;
        mw.a r107 = (mw.a) s.a(mw.a.class);
        if (r107 != null) goto L17;
    L41:
        String r108 = "";
        String r110 = r108;
    L43:
        if (r100 == false) goto L92;
        int r109 = GamePromoteOrderTrack.f56417a;
        String r111 = this.f54832d;
        String r112 = r101.F;
        if (this.f54834f != 0) goto L47;
        boolean r113 = true;
    L48:
        String r114 = r110;
        GamePromoteOrderTrack.b(r111, r112, r106, "", Boolean.valueOf(r113), Integer.valueOf(this.f54834f));
        Store r115 = this.f248705c;
        int r116 = com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.f55589d;
        r115.dispatch(com.bytedance.android.gamecp.business.gamedetail.page.root.state.a.C0896a.a(), new com.bytedance.android.gamecp.business.gamedetail.page.root.state.b.C0897b());
        JSONObject r117 = new JSONObject();
        String r118 = r101.I;
        if (r118 != null) goto L51;
        r118 = "";
    L51:
        r117.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r118);
        int r119 = r101.P;
        long r120 = 0;
        if (r119 != 0) goto L54;
        a r121 = f54831i;
        String r122 = r101.f469939J;
        r121.getClass();
        Long r123 = Long.valueOf(a.k(r122));
        if (r123.longValue() == 0) goto L60;
        boolean r124 = true;
    L61:
        if (r124 == true) goto L64;
        r123 = null;
    L64:
        if (r123 != null) goto L69;
        Room r125 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r125 == null) goto L68;
        r123 = r125.getRoomId();
        goto L69
    L68:
        r123 = null;
    L69:
        if (r123 == null) goto L71;
        r120 = r123.longValue();
    L71:
        r117.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r120);
        r117.put("scene", r101.P);
        HashMap<String, String> r126 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r127 = GamecpTracker.h(zu.a.class);
        if ((r127 instanceof com.bytedance.android.gamecp.common.track.filter.b) == true) goto L74;
        com.bytedance.android.gamecp.common.track.filter.d r128 = null;
    L75:
        com.bytedance.android.gamecp.common.track.filter.b r129 = (com.bytedance.android.gamecp.common.track.filter.b) r128;
        if (r129 == null) goto L79;
        String r130 = r129.g();
        if (r130 == null) goto L79;
    L80:
        r117.put(BdpAppEventConstant.PARAMS_SUB_SCENE, r130);
        r117.put(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, r101.f469955h0);
        r117.put(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r101.f469959j0);
        r117.put(IPerformanceManager.MODULE_LIVE_GAME_PLATFORM, this.f54835g);
        r117.put("enter_sub_method", r108);
        r117.put(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r114);
        a r210 = f54831i;
        Context r131 = this.f54833e;
        String r132 = r101.F;
        if (r132 != null) goto L83;
        String r211 = "";
    L84:
        String r133 = r101.R;
        r210.getClass();
        Observable r134 = a.h(r210, r131, r211, r117, Long.valueOf(a.k(r133)), 0, null, 48);
        if (r134 == null) goto L117;
        hv.b r135 = hv.d.f487273a;
        Observable r136 = r134.compose(new hv.a());
        if (r136 == null) goto L118;
        Disposable r137 = r136.subscribe(new b(this, r101, r117), new c(this));
        if (r137 == null) goto L119;
        Intrinsics.checkNotNullParameter(r137, "$this$autoDispose");
        this.f54836h.a(r137);
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L83:
        r211 = r132;
    L79:
        r130 = "";
        goto L80
    L74:
        r128 = r127;
        goto L75
    L60:
        r124 = false;
        goto L61
    L54:
        if (r119 != 1) goto L71;
        a r138 = f54831i;
        String r139 = r101.R;
        r138.getClass();
        r120 = a.k(r139);
        goto L71
    L47:
        r113 = false;
        goto L48
    L92:
        if ((r310 instanceof g) == false) goto L121;
        a r140 = f54831i;
        Context r141 = this.f54833e;
        String r142 = r101.F;
        String r143 = r101.C;
        if (r143 != null) goto L96;
        r143 = "";
    L96:
        String r144 = r101.I;
        if (r144 != null) goto L99;
        r144 = "";
    L99:
        String r145 = r101.R;
        if (r145 != null) goto L102;
        r145 = "";
    L102:
        int r146 = r101.P;
        int r147 = ((g) r310).f54860a;
        JSONObject r148 = new JSONObject();
        TuplesKt.to("use_param_passing", Boolean.FALSE);
        String r149 = r101.I;
        if (r149 != null) goto L105;
        r149 = "";
    L105:
        TuplesKt.to("promote_id", r149);
        TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, r101.f469955h0);
        String r150 = r101.F;
        if (r150 != null) goto L108;
        r150 = "";
    L108:
        TuplesKt.to("game_id", r150);
        TuplesKt.to("btn_type", "cancel_book");
        String r151 = r101.f469959j0;
        if (r151 != null) goto L111;
        r151 = "";
    L111:
        TuplesKt.to(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, r151);
        TuplesKt.to("reserveType", "1");
        TuplesKt.to("reserve_version_num", "");
        Unit r152 = Unit.INSTANCE;
        String r153 = String.valueOf(v.a(r148));
        r140.getClass();
        LinkedHashMap r154 = new LinkedHashMap();
        r154.put("interactive_style", String.valueOf(r147));
        r154.put("game_id", String.valueOf(r142));
        r154.put(EventConstants.ExtraJson.GAME_NAME, r143);
        r154.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r144);
        r154.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r145);
        r154.put("scene", String.valueOf(r146));
        r154.put("reserve_alert_type", "1");
        r154.put("reserve_state", String.valueOf(0));
        r154.put("reserve_action", "1");
        r154.put("additional_link_params", r153);
        int r155 = com.bytedance.android.gamecp.business.hybrid.a.f55974a;
        com.bytedance.android.gamecp.business.hybrid.a.c(r141, p2.f561368a.getValue(), r154);
        return;
    L121:
        return;
    L17:
        if (r107.isPreviewMergeInteract() != true) goto L41;
        if (r101.f469965m0 == false) goto L41;
        xr.p r156 = (xr.p) s.a(xr.p.class);
        if (r156 == null) goto L23;
        Map<String, String> r157 = r156.v();
    L115:
        Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L38
        if (r157 == null) goto L27;
        String r159 = r157.get("traffic_extra");     // Catch: Throwable -> L38
    L28:
        if (r159 == null) goto L33;
        String r160 = new JSONObject(r159).optString("enter_sub_method");     // Catch: Throwable -> L38
        if (r160 == null) goto L33;
        String r161 = r160;
    L113:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
        r110 = "1";
        r108 = r161;
    L36:
        th = th;
        String r162 = "1";
    L40:
        Result.Companion r163 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r108 = r161;
        r110 = r162;
    L33:
        r161 = "";
        goto L113
    L27:
        r159 = null;
    L38:
        th = th;
        r161 = "";
        r162 = r161;
        goto L40
    L23:
        r157 = null;
    L13:
        r105 = "tab_game_detail";
        goto L14
    L5:
        if ((r310 instanceof g) == true) goto L7;
    }

    public e(String r100, Context r101, int r102, int r103, Store r104) {
        Intrinsics.checkNotNullParameter(r100, "gameName");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r104);
        this.f54836h = new yt.a();
        this.f54832d = r100;
        this.f54833e = r101;
        this.f54834f = r102;
        this.f54835g = r103;
    }
}
