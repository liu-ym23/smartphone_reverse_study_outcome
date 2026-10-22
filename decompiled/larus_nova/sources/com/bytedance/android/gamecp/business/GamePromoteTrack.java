package com.bytedance.android.gamecp.business;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.business.download.DownloadInfoFactory;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.DataContext;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GamePromoteTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51759a = 0;

    public GamePromoteTrack() {
    }

    public static String g(int r100) {
        if (r100 != 0) goto L4;
        return "download";
    L4:
        if (r100 != 1) goto L6;
        return "pause_download";
    L6:
        if (r100 != 2) goto L8;
        return "continue_download";
    L8:
        if (r100 != 3) goto L10;
        return "install";
    L10:
        if (r100 != 5) goto L12;
        return EventConstant.Value.RETRY;
    L12:
        if (r100 != 6) goto L14;
        return EventVerify.TYPE_LAUNCH;
    L14:
        if (r100 == 7) goto L16;
        return "";
    L16:
        return "update";
    }

    public static int h() {
        DataContext r100 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r100 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r100 = null;
    L5:
        AudienceGamePromoteDetailViewModel r101 = (AudienceGamePromoteDetailViewModel) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.getPromoteScene();
    }

    public static String j() {
        bw.p r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r100 == null) goto L9;
        hw.b r101 = r100.user();
        if (r101 == null) goto L9;
        String r102 = r101.getCurrentUserId();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return null;
    }

    static {
    }

    public static void b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        com.bytedance.android.gamecp.host_api.model.c r101 = i0.c();
        String r102 = "2";
        String r103 = "1";
        if (r101.d() == false) goto L5;
        Object r104 = "1";
    L6:
        r100.put(EventConstants.ExtraJson.KEY_PURE_MODE, r104);
        if (r101.c() == false) goto L9;
        r102 = "1";
    L9:
        r100.put(EventConstants.ExtraJson.KEY_ENHANCED_PURE_MODE, r102);
        r100.put("os", r101.b());
        String r105 = r101.a();
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r100.put("harmony_display_version", r105);
        Context r106 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
        int r107 = yt.j.f569017a;
        if (Build.VERSION.SDK_INT < 26) goto L18;
        if (r106 == null) goto L18;
        boolean r108 = r106.getPackageManager().canRequestPackageInstalls();     // Catch: Exception -> L17
    L19:
        if (r108 == true) goto L22;
        r103 = "0";
    L22:
        r100.put("is_grant_permission", r103);
        return;
    L17:
        r108 = false;
    L18:
        r108 = true;
        goto L19
    L5:
        r104 = "2";
        goto L6
    }

    public static void c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        LinkedHashMap r101 = new LinkedHashMap();
        b(r101);
        Iterator r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.put(r103.getKey(), r103.getValue());
        goto L4
    }

    public static String e(com.bytedance.android.gamecp.business.download.p r100) {
        int r101 = i0.f56003a;
        String r102 = null;
        if (r100 == null) goto L5;
        Long r103 = r100.Q;
    L7:
        if (i0.i(r103) == true) goto L16;
        if (r100 == null) goto L11;
        r102 = r100.f52845f;
    L11:
        if (Intrinsics.areEqual(r102, "game_ad") == false) goto L14;
        return "view";
    L14:
        return "grayed";
    L16:
        if (r100 == null) goto L18;
        int r104 = r100.f52880w0;
    L20:
        return g(r104);
    L18:
        r104 = 0;
        goto L20
    L5:
        r103 = null;
        goto L7
    }

    public static String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "couponType");
        switch(r100.hashCode()) {
            case 49: goto L12;
            case 50: goto L9;
            case 51: goto L6;
            default: goto L14;
        };
    L14:
        return "";
    L6:
        if (r100.equals("3") == false) goto L14;
        return SoloKtvContext.SOLO_PAGE_FIRST;
    L9:
        if (r100.equals("2") == false) goto L14;
        return "direct";
    L12:
        if (r100.equals("1") == false) goto L14;
        return "general";
    }

    public static void k(com.bytedance.android.gamecp.business.download.p r210) {
        String r100 = "";
        String r101 = null;
        if (r210 == null) goto L5;
        HashMap<String, String> r102 = r210.f52837b;
    L6:
        if (r102 == null) goto L8;
        String r103 = r102.get(SlcElement.KEY_ATTR);
    L80:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        String r105 = new JSONObject(r103).optString("status");     // Catch: Throwable -> L15
    L13:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r106) == false) goto L20;
        r106 = null;
    L20:
        String r107 = (String) r106;
        if (r103 != null) goto L23;
    L26:
        boolean r108 = true;
    L27:
        if (r107 != null) goto L29;
    L32:
        boolean r109 = true;
    L33:
        if (r102 == null) goto L35;
        String r110 = r102.get("location");
    L36:
        if (r110 != null) goto L38;
    L41:
        boolean r111 = true;
    L42:
        if (r102 == null) goto L44;
        String r112 = r102.get(CloudControlInf.ROUTE);
    L45:
        if (r112 != null) goto L47;
    L50:
        boolean r113 = true;
    L51:
        if (r108 == true) goto L55;
        if (r109 == true) goto L55;
        if (r111 == true) goto L55;
        if (r113 == true) goto L55;
        return;
    L55:
        LinkedHashMap r114 = new LinkedHashMap();
        String r115 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Boolean[]{Boolean.valueOf(r109), Boolean.valueOf(r108), Boolean.valueOf(r111), Boolean.valueOf(r113)}), "", null, null, 0, null, GamePromoteTrack$monitorViewTrackInfo$missingType$1.INSTANCE, 30, null);
        if (r102 != null) goto L78;
    L61:
        r114.put("view_track_info", r100);     // Catch: Throwable -> L74
        if (r210 == null) goto L64;
        String r116 = r210.f52855k;     // Catch: Throwable -> L74
    L65:
        r114.put("download_game_id", r116);     // Catch: Throwable -> L74
        if (r210 == null) goto L68;
        String r117 = r210.f52836a0;     // Catch: Throwable -> L74
    L69:
        r114.put("download_game_name", r117);     // Catch: Throwable -> L74
        if (r210 == null) goto L72;
        r101 = r210.F0;     // Catch: Throwable -> L74
    L72:
        r114.put("download_position", r101);     // Catch: Throwable -> L74
        r114.put("download_status", e(r210));     // Catch: Throwable -> L74
        Result.m9449constructorimpl((String) r114.put("missing_type", r115));     // Catch: Throwable -> L74
    L76:
        HashMap<String, String> r118 = GamecpTracker.f56755a;
        GamecpTracker.B("dygame_tech_download_missing_view_track", r114);
        return;
    L74:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L76
    L68:
        r117 = null;
        goto L69
    L64:
        r116 = null;
        goto L65
    L78:
        String r120 = e1.a(r102);     // Catch: Throwable -> L74
        if (r120 == null) goto L61;
        r100 = r120;
        goto L61
    L47:
        if (r112.length() == 0) goto L50;
        r113 = false;
        goto L51
    L44:
        r112 = null;
        goto L45
    L38:
        if (r110.length() == 0) goto L41;
        r111 = false;
        goto L42
    L35:
        r110 = null;
        goto L36
    L29:
        if (r107.length() == 0) goto L32;
        r109 = false;
        goto L33
    L23:
        if (r103.length() == 0) goto L26;
        r108 = false;
        goto L27
    L12:
        r105 = "";
    L15:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L8:
        r103 = null;
        goto L80
    L5:
        r102 = null;
        goto L6
    }

    public static Map i(wt.g r110, Map r111) {
        String r100 = (String) r111.get("all_props_from");
        Pair[] r101 = new Pair[9];
        boolean r102 = false;
        r101[0] = TuplesKt.to("user_id", j());
        Long r103 = null;
        if (r110 == null) goto L5;
        String r104 = r110.gameId;
    L6:
        r101[1] = TuplesKt.to("game_id", r104);
        if (r110 == null) goto L9;
        String r105 = r110.gameName;
    L10:
        r101[2] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r105);
        if (r110 == null) goto L15;
        wt.e r106 = r110.gamePropInfo;
        if (r106 == null) goto L15;
        String r107 = r106.propId;
    L16:
        r101[3] = TuplesKt.to("prop_id", r107);
        if (r110 == null) goto L21;
        wt.e r108 = r110.gamePropInfo;
        if (r108 == null) goto L21;
        String r109 = r108.propName;
    L22:
        r101[4] = TuplesKt.to("prop_name", r109);
        if (r110 == null) goto L27;
        wt.e r112 = r110.gamePropInfo;
        if (r112 == null) goto L27;
        Long r113 = r112.propType;
    L28:
        if (r113 != null) goto L31;
    L33:
        String r114 = "direct";
    L34:
        r101[5] = TuplesKt.to("prop_type", r114);
        r101[6] = TuplesKt.to("enter_from", (String) r111.get("prop_enter_from"));
        int r115 = com.bytedance.android.gamecp.business.props.y.f56404a;
        if (r110 == null) goto L39;
        wt.e r116 = r110.gamePropInfo;
        if (r116 == null) goto L39;
        Long r117 = r116.sellingPrice;
    L40:
        if (r110 == null) goto L44;
        wt.e r118 = r110.gamePropInfo;
        if (r118 == null) goto L44;
        r103 = r118.marketPrice;
    L44:
        boolean r119 = com.bytedance.android.gamecp.business.props.y.b(r117, r103);
        String r120 = "1";
        if (r119 == false) goto L47;
        Object r121 = "1";
    L48:
        r101[7] = TuplesKt.to("is_discount", r121);
        if (r110 == null) goto L55;
        wt.e r122 = r110.gamePropInfo;
        if (r122 == null) goto L55;
        if (r122.isIntroducing != true) goto L55;
    L56:
        r101[8] = TuplesKt.to("is_introduce", r120);
        Map r123 = MapsKt.mutableMapOf(r101);
        if (r100 != null) goto L59;
    L63:
        return r123;
    L59:
        if (r100.length() <= 0) goto L61;
        r102 = true;
    L61:
        if (r102 != true) goto L63;
        r123.put("all_props_from", r100);
    L55:
        r120 = "0";
        goto L56
    L47:
        r121 = "0";
    L39:
        r117 = null;
        goto L40
    L31:
        if (r113.longValue() != 2) goto L33;
        r114 = "cdkey";
    L27:
        r113 = null;
    L21:
        r109 = null;
    L15:
        r107 = null;
        goto L16
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static void p(String r100, com.bytedance.android.gamecp.business.download.p r101) {
        Intrinsics.checkNotNullParameter(r100, "clickPosition");
        AtomicInteger r102 = DownloadInfoFactory.f52322a;
        JSONObject r103 = DownloadInfoFactory.c(r101);
        r103.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r100);
        Map r104 = com.bytedance.android.gamecp.common.track.b.e(r103);
        c(r104);
        com.bytedance.android.gamecp.common.track.b.h("download_block_pop_click", false, r104, new String[0]);
    }

    public static void q(String r100, com.bytedance.android.gamecp.business.download.p r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        AtomicInteger r102 = DownloadInfoFactory.f52322a;
        JSONObject r103 = DownloadInfoFactory.c(r101);
        r103.put("result", r100);
        Map r104 = com.bytedance.android.gamecp.common.track.b.e(r103);
        c(r104);
        com.bytedance.android.gamecp.common.track.b.h("download_block_login_result", false, r104, new String[0]);
    }

    public static void r(String r100, com.bytedance.android.gamecp.business.download.p r101) {
        Intrinsics.checkNotNullParameter(r100, "blockReason");
        AtomicInteger r102 = DownloadInfoFactory.f52322a;
        JSONObject r103 = DownloadInfoFactory.c(r101);
        r103.put("block_reason", r100);
        Map r104 = com.bytedance.android.gamecp.common.track.b.e(r103);
        c(r104);
        com.bytedance.android.gamecp.common.track.b.h("download_block", false, r104, new String[0]);
    }

    public static void l(wt.g r100, Map r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "status");
        Map r103 = i(r100, r101);
        r103.put("status", r102);
        h0.c("livesdk_gcom_user_id_verifiy_result_show", r103, h(), false, 16);
    }

    public static void m(wt.g r100, Map r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Map r103 = i(r100, r101);
        boolean r104 = true;
        if (r100 == null) goto L18;
        wt.c r105 = r100.accountInfo;
        if (r105 == null) goto L18;
        String r106 = r105.guid;
        if (r106 == null) goto L18;
        if (r106.length() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L15;
        r106 = null;
    L15:
        if (r106 == null) goto L18;
        r103.put("user_game_id", r106);
        goto L18
    L11:
        r107 = false;
    L18:
        if (r102.length() > 0) goto L21;
        r104 = false;
    L21:
        if (r104 == true) goto L24;
        r102 = null;
    L24:
        if (r102 == null) goto L26;
        r103.put("add_from", r102);
    L26:
        h0.c("livesdk_gcom_user_order_enter_id_show", r103, h(), false, 16);
    }

    public static void n(wt.g r100, String r101, Integer r102, String r103) {
        Pair[] r104 = new Pair[5];
        r104[0] = TuplesKt.to("user_id", j());
        String r105 = null;
        if (r100 == null) goto L5;
        String r106 = r100.gameId;
    L6:
        r104[1] = TuplesKt.to("game_id", r106);
        if (r100 == null) goto L9;
        r105 = r100.gameName;
    L9:
        r104[2] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r105);
        r104[3] = TuplesKt.to("enter_from", r101);
        r104[4] = TuplesKt.to("coupon_id", r103);
        t("livesdk_gcom_coupon_card_select_confirm", r101, r102, MapsKt.mutableMapOf(r104));
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static void t(String r100, String r101, Integer r102, Map r103) {
        if (r102 != null) goto L6;
    L22:
        int r104 = h0.f55949a;
        h0.c(r100, r103, h(), false, 16);
        return;
    L6:
        if (r102.intValue() != 2) goto L22;
        if (r101 != null) goto L10;
    L21:
        h0.c(r100, r103, 2, false, 24);
        return;
    L10:
        if (r101.hashCode() != (-1655966961)) goto L21;
        if (r101.equals("activity") == false) goto L21;
        DataContext r105 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        if ((r105 instanceof GamePromoteTrackViewModel) == true) goto L17;
        r105 = null;
    L17:
        GamePromoteTrackViewModel r106 = (GamePromoteTrackViewModel) r105;
        if (r106 != null) goto L20;
        r106 = (GamePromoteTrackViewModel) com.bytedance.live.datacontext.d.a(GamePromoteTrack$sendPropsAndCouponLog$1.INSTANCE).getFirst();
        r106.share();
    L20:
        r106.setOfficialEnterFrom((String) r103.get("enter_from"));
        goto L21
    }

    public static void s(com.bytedance.android.gamecp.base.Result r100, String r101, String r102, int r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Map r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", String.valueOf(r100.getValue())), TuplesKt.to("logId", r101), TuplesKt.to("extra", r102), TuplesKt.to("code", String.valueOf(r103))});
        if (r104 == null) goto L5;
        r105.putAll(r104);
    L5:
        int r106 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("gamecp_get_download_result", r105, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, int r105) {
        Map r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, String.valueOf(r100)), TuplesKt.to("game_id", String.valueOf(r101)), TuplesKt.to("prorate_min", String.valueOf(r102)), TuplesKt.to("prorate_max", String.valueOf(r103)), TuplesKt.to("status", g(r105)), TuplesKt.to("enter_from", "promote_detail"), TuplesKt.to("anchor_id", com.bytedance.android.gamecp.business.gamedetail.base.track.a.b()), TuplesKt.to("live_type", com.bytedance.android.gamecp.business.gamedetail.base.track.a.a()), TuplesKt.to("game_rating", r104)});
        int r107 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("livesdk_game_promote_anchor_download", r106, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
    }

    public static void o(String r100, String r101, String r102, String r103, String r104, Boolean r105, Boolean r106, String r107, Long r110) {
        Pair[] r108 = new Pair[8];
        boolean r109 = false;
        r108[0] = TuplesKt.to("game_id", r100);
        r108[1] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r101);
        r108[2] = TuplesKt.to("prop_id", r102);
        r108[3] = TuplesKt.to("prop_name", r103);
        r108[4] = TuplesKt.to("enter_from", r104);
        Boolean r111 = Boolean.TRUE;
        String r112 = "1";
        if (Intrinsics.areEqual(r105, r111) == false) goto L5;
        Object r113 = "1";
    L6:
        r108[5] = TuplesKt.to("is_discount", r113);
        if (Intrinsics.areEqual(r106, r111) == true) goto L10;
        r112 = "0";
    L10:
        r108[6] = TuplesKt.to("is_introduce", r112);
        if (r110 != null) goto L14;
    L16:
        String r114 = "direct";
    L17:
        r108[7] = TuplesKt.to("prop_type", r114);
        Map r115 = MapsKt.mutableMapOf(r108);
        if (r107 != null) goto L20;
    L24:
        int r116 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("livesdk_gcom_user_purchase_click", r115, new String[]{LogFilterName.ROOM, LogFilterName.PAGE_SOURCE_LOG});
        return;
    L20:
        if (r107.length() <= 0) goto L22;
        r109 = true;
    L22:
        if (r109 != true) goto L24;
        r115.put("all_props_from", r107);
        goto L24
    L14:
        if (r110.longValue() != 2) goto L16;
        r114 = "cdkey";
        goto L17
    L5:
        r113 = "0";
        goto L6
    }

    public static void d(String r110, String r111, boolean r112, String r210, String r211, String r212, int r213, boolean r214, String r215, String r216, Long r217, String r218, String r219, String r310, String r311, Boolean r312, Integer r313, String r314, String r315, String r316, String r317, long r318, String r410, int r411) {
        if ((r411 & 2048) == 0) goto L5;
        Long r100 = 0L;
    L7:
        if ((r411 & 4096) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r411 & 8192) == 0) goto L13;
        String r102 = "";
    L15:
        if ((32768 & r411) == 0) goto L17;
        String r103 = "";
    L19:
        if ((65536 & r411) == 0) goto L21;
        Boolean r104 = Boolean.FALSE;
    L23:
        if ((262144 & r411) == 0) goto L25;
        Integer r113 = 0;
    L27:
        if ((524288 & r411) == 0) goto L29;
        String r114 = null;
    L31:
        if ((1048576 & r411) == 0) goto L33;
        String r115 = "";
    L35:
        if ((4194304 & r411) == 0) goto L37;
        String r116 = "";
    L39:
        if ((r411 & 16777216) == 0) goto L41;
        String r105 = "false";
    L42:
        Intrinsics.checkNotNullParameter(r310, "couponType");
        Intrinsics.checkNotNullParameter(r316, "traceId");
        if (Intrinsics.areEqual("game_ad", r211) == true) goto L97;
        Pair[] r117 = new Pair[19];
        Integer r220 = r113;
        r117[0] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r110);
        r117[1] = TuplesKt.to("enter_from", r211);
        r117[2] = TuplesKt.to("start_page", r212);
        String r106 = "1";
        String r118 = "0";
        String r221 = r116;
        if (r112 == false) goto L48;
        r118 = "1";
    L48:
        r117[3] = TuplesKt.to("is_introduce", r118);
        r117[4] = TuplesKt.to("show_type", r210);
        if (r214 == false) goto L51;
        Object r119 = "0";
    L52:
        r117[5] = TuplesKt.to("user_type", r119);
        r117[6] = TuplesKt.to("status", g(r213));
        r117[7] = TuplesKt.to("game_id", r111);
        r117[8] = TuplesKt.to("game_ad_type", "1");
        r117[9] = TuplesKt.to("user_id", j());
        r117[10] = TuplesKt.to("package_anchor_id", r215);
        r117[11] = TuplesKt.to("game_rating", r101);
        r117[12] = TuplesKt.to("game_rating_from_comment", r102);
        r117[13] = TuplesKt.to("if_clear_mode", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getIfClearModeValueWithClick());
        r117[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, r310);
        r117[15] = TuplesKt.to(EventConstants.ExtraJson.PACKAGE_SIZE, r115);
        r117[16] = TuplesKt.to(BindCardPayConfirmConstants.Key.TRACE_ID, r316);
        r117[17] = TuplesKt.to("duration", String.valueOf(r318));
        r117[18] = TuplesKt.to("is_auto_download", r105);
        Map r107 = MapsKt.mutableMapOf(r117);
        r107.put("promote_detail_tab", r103);
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L55;
        Object r108 = "1";
    L56:
        r107.put("is_fullscreen", r108);
        if (TextUtils.isEmpty(r216) == true) goto L63;
        if (Intrinsics.areEqual(r216, "pass") == false) goto L61;
        r106 = "0";
    L61:
        r107.put("is_risk", r106);
    L63:
        if (TextUtils.equals(r211, "game_ad") == false) goto L66;
        r107.put("total_download_cnt", String.valueOf(r100));
    L66:
        if (TextUtils.isEmpty(r114) == true) goto L68;
        r107.put("is_task", r114);
    L68:
        int r109 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getCurrentScene();
        if (r109 != 4) goto L71;
        r107.put("function_type", SourceType.DEFAULT);
    L84:
        if (TextUtils.isEmpty(r221) == false) goto L95;
    L89:
        int r120 = h0.f55949a;
        if (r220 == null) goto L92;
        int r121 = r220.intValue();
    L93:
        h0.c("livesdk_game_promote_user_download", r107, r121, false, 16);
        return;
    L92:
        r121 = 0;
        goto L93
    L95:
        JSONObject r122 = new JSONObject(r221);     // Catch: Exception -> L87
        r107.put("benefit_detail_scene", r122.optString("benefit_detail_scene"));     // Catch: Exception -> L87
        r107.put("benefit_detail_type", r122.optString("benefit_detail_type"));     // Catch: Exception -> L87
        r107.put("benefit_content", r122.optString("benefit_content"));     // Catch: Exception -> L87
        r107.put("benefit_id", r122.optString("benefit_id"));     // Catch: Exception -> L87
        r107.put("benefit_extra", r122.optString("benefit_extra"));     // Catch: Exception -> L87
    L87:
        e = move-exception;
        yr.c.b("", String.valueOf(e.getMessage()));
        goto L89
    L71:
        if (r109 == 5) goto L79;
        if (r109 == 12) goto L78;
        switch(r109) {
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            default: goto L84;
        };
    L75:
        r107.put("function_type", "watch");
        goto L84
    L76:
        r107.put("function_type", "ktv");
        goto L84
    L77:
        r107.put("function_type", "radio");
        goto L84
    L78:
        r107.put("function_type", "party");
        goto L84
    L79:
        r107.put("function_type", "radio");
        if (com.bytedance.android.gamecp.host_api.a.b().getLiveService().isEqualOnVoice() == false) goto L84;
        r107.put("function_type", "party");
        goto L84
    L55:
        r108 = "0";
        goto L56
    L51:
        r119 = "1";
        goto L52
    L97:
        return;
    L41:
        r105 = r410;
        goto L42
    L37:
        r116 = r317;
        goto L39
    L33:
        r115 = r315;
        goto L35
    L29:
        r114 = r314;
        goto L31
    L25:
        r113 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r219;
        goto L15
    L9:
        r101 = r218;
        goto L11
    L5:
        r100 = r217;
        goto L7
    }
}
