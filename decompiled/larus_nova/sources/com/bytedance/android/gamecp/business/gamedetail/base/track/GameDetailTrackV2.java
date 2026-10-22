package com.bytedance.android.gamecp.business.gamedetail.base.track;

import bw.j;
import bw.p;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.gamecp.business.GamePlatformType;
import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.android.gamecp.business.h0;
import com.bytedance.android.gamecp.common.model.GameStageType;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GameDetailTrackV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudienceGamePromoteDetailViewModel f53492a;

    static {
        DataContext r100 = d.d(AudienceGamePromoteDetailViewModel.class);
        if ((r100 instanceof AudienceGamePromoteDetailViewModel) == true) goto L5;
        r100 = null;
    L5:
        f53492a = (AudienceGamePromoteDetailViewModel) r100;
    }

    public static String a() {
        p r100 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r100 == null) goto L7;
        hw.b r101 = r100.user();
        if (r101 == null) goto L7;
        String r102 = r101.getCurrentUserId();
    L9:
        return r102.toString();
    L7:
        r102 = null;
        goto L9
    }

    public static void c(boolean r100) {
        Pair[] r101 = new Pair[2];
        r101[0] = TuplesKt.to(DownloadHelper.IDENTITY, "user");
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101[1] = TuplesKt.to("if_cancel_confirmed", r102);
        h("livesdk_game_promote_user_cancel_comment_click", MapsKt.mutableMapOf(r101), null);
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public static void b(long r100, String r101) {
        Intrinsics.checkNotNullParameter("tab_game_detail", "tabId");
        Intrinsics.checkNotNullParameter("comment", "clickLocation");
        Intrinsics.checkNotNullParameter(r101, "commentLocation");
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("promote_detail_tab", "tab_game_detail"), TuplesKt.to("click_location", "comment"), TuplesKt.to("total_cnt", String.valueOf(r100))});
        if (Intrinsics.areEqual("comment", "comment") == false) goto L5;
        r102.put("comment_location", r101);
    L5:
        h("livesdk_game_promote_user_promote_detail_outlook_more_click", r102, null);
    }

    public static void d(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        h("livesdk_game_promote_user_comment_page_explore_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(DownloadHelper.IDENTITY, "user"), TuplesKt.to(PortraitEngine.LABEL_WATCH_DURATION, String.valueOf(r100 / ((long) 1000))), TuplesKt.to("enter_from", r101)}), null);
    }

    public static void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "adType");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        h("livesdk_game_promote_user_promote_detail_game_rating_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_ad_type", r100), TuplesKt.to("game_rating", r101), TuplesKt.to("enter_from", r102)}), null);
    }

    public static void g(Map r100, String r101, String r102) {
        HashMap r103 = (HashMap) r100;
        CharSequence r104 = (CharSequence) r103.get(r101);
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r103.put(r101, r102);
        return;
    L12:
        return;
    L5:
        if (StringsKt.isBlank(r104) == true) goto L8;
        r105 = false;
        goto L9
    }

    public static void h(String r100, Map r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        HashMap r103 = new HashMap();
        AudienceGamePromoteDetailViewModel r104 = f53492a;
        String r105 = null;
        if (r104 == null) goto L7;
        m<String> r106 = r104.getCurrentTab();
        if (r106 == null) goto L7;
        String r107 = r106.getValue();
    L8:
        r103.put("promote_detail_tab", r107);
        AudienceGamePromoteDetailViewModel r108 = f53492a;
        boolean r109 = true;
        if (r108 != null) goto L11;
    L13:
        String r110 = "0";
    L14:
        r103.put("is_fullscreen", r110);
        if ((!r101.isEmpty()) == false) goto L17;
        r103.putAll(r101);
    L17:
        AudienceGamePromoteDetailViewModel r111 = f53492a;
        if (r111 == null) goto L21;
        String r112 = r111.getAnchorId();
        if (r112 == null) goto L21;
    L27:
        String r113 = "";
        if (r112 != null) goto L30;
        r112 = "";
    L30:
        g(r103, "anchor_id", r112);
        AudienceGamePromoteDetailViewModel r114 = f53492a;
        if (r114 == null) goto L34;
        String r115 = r114.getRoomId();
        if (r115 == null) goto L34;
    L38:
        if (r115 != null) goto L40;
        r115 = "";
    L40:
        g(r103, "room_id", r115);
        String r116 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getEventLiveType();
        if (r116.length() == 0) goto L44;
        r109 = false;
    L44:
        if (r109 == false) goto L46;
        r116 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getPreviewEventLiveType();
    L46:
        r103.put("live_type", r116);
        AudienceGamePromoteDetailViewModel r117 = f53492a;
        if (r117 == null) goto L50;
        String r118 = r117.getGameName();
        if (r118 == null) goto L50;
    L51:
        g(r103, EventConstants.ExtraJson.GAME_NAME, r118);
        AudienceGamePromoteDetailViewModel r119 = f53492a;
        if (r119 == null) goto L55;
        String r120 = r119.getGameId();
        if (r120 == null) goto L55;
    L56:
        g(r103, "game_id", r120);
        r103.put("user_id", a());
        int r121 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getCurrentScene();
        if (r121 != 4) goto L59;
        r113 = SourceType.DEFAULT;
    L69:
        r103.put("function_type", r113);
        AudienceGamePromoteDetailViewModel r122 = f53492a;
        if (r122 == null) goto L74;
        GameStageType r123 = r122.getGameStage();
        if (r123 == null) goto L74;
        r105 = r123.toTrackString();
    L74:
        r103.put("page_type", r105);
        int r124 = h0.f55949a;
        AudienceGamePromoteDetailViewModel r125 = f53492a;
        if (r125 == null) goto L77;
        int r126 = r125.getPromoteScene();
    L78:
        h0.b(r100, r103, r126, false, r102);
        return;
    L77:
        r126 = 0;
        goto L78
    L59:
        if (r121 != 5) goto L61;
    L67:
        r113 = "radio";
        goto L69
    L61:
        if (r121 == 12) goto L66;
        switch(r121) {
            case 8: goto L67;
            case 9: goto L65;
            case 10: goto L64;
            default: goto L69;
        };
    L64:
        r113 = "watch";
        goto L69
    L65:
        r113 = "ktv";
        goto L69
    L66:
        r113 = "party";
    L55:
        r120 = "";
    L50:
        r118 = "";
    L34:
        Room r127 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r127 == null) goto L37;
        r115 = String.valueOf(r127.getId());
        goto L38
    L37:
        r115 = null;
    L21:
        Room r128 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r128 == null) goto L26;
        r112 = r128.getOwnerUserId();
        if (r112 != null) goto L27;
    L26:
        r112 = null;
        goto L27
    L11:
        if (r108.isFullScreen() != true) goto L13;
        r110 = "1";
    L7:
        r107 = null;
        goto L8
    }

    public static void i(String r100, b r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter("anchor_page", "refer");
        Intrinsics.checkNotNullParameter(r110, "adParams");
        Map r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("app_id", String.valueOf(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppId())), TuplesKt.to("group_id", String.valueOf(r110.f53500b)), TuplesKt.to("owner_id", String.valueOf(r110.f53501c)), TuplesKt.to("author_id", String.valueOf(r110.f53501c)), TuplesKt.to("anchor_id", String.valueOf(r110.f53502d)), TuplesKt.to("anchor_type", String.valueOf(r110.f53503e)), TuplesKt.to("user_id", com.bytedance.android.gamecp.host_api.a.b().getUserService().getCurUserId()), TuplesKt.to("enter_from", String.valueOf(r111)), TuplesKt.to("download_status", String.valueOf(r110.f53505g))});
        j r102 = com.bytedance.android.gamecp.host_api.a.b().getLogService();
        String r103 = r110.f53500b;
        String r104 = r110.f53504f;
        String r112 = r110.f53499a;
        if (r112 != null) goto L5;
        r112 = "";
    L5:
        r102.H1(r100, r103, r104, r104, r112, r101);
    }

    public static void f(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, GamePlatformType r315, dt.b r316) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "gameAdType");
        Intrinsics.checkNotNullParameter(r112, "gameAdShowType");
        Intrinsics.checkNotNullParameter(r210, "videoSwitch");
        Intrinsics.checkNotNullParameter(r211, "playerDirection");
        Intrinsics.checkNotNullParameter(r212, "couponType");
        Intrinsics.checkNotNullParameter(r213, "isActive");
        Intrinsics.checkNotNullParameter(r214, "tabList");
        Intrinsics.checkNotNullParameter(r215, "downloadNum");
        Intrinsics.checkNotNullParameter(r217, "isOnLine");
        Intrinsics.checkNotNullParameter(r218, "isBook");
        Intrinsics.checkNotNullParameter(r219, "pageType");
        Intrinsics.checkNotNullParameter(r310, "traceId");
        Intrinsics.checkNotNullParameter(r315, "gamePlatformType");
        Map r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from", r110), TuplesKt.to("game_ad_type", r111), TuplesKt.to("show_type", r112), TuplesKt.to("video_switch", r210), TuplesKt.to("player_direction", r211), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, r212), TuplesKt.to("is_active", r213), TuplesKt.to("tab_list", r214), TuplesKt.to("download_num", r215), TuplesKt.to("online_or_not", r217), TuplesKt.to("is_book", r218), TuplesKt.to("page_type", r219), TuplesKt.to(BindCardPayConfirmConstants.Key.TRACE_ID, r310)});
        if (r216.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 != true) goto L8;
        r100.put("is_task", r216);
    L8:
        String r102 = null;
        final String r103 = "livesdk_game_promote_user_promote_detail_show";
        if (r315 != GamePlatformType.MOBILE_GAME) goto L15;
        int r104 = com.bytedance.android.gamecp.common.track.b.f56775a;
        String r105 = r314;
        if (r105 != null) goto L13;
        String r106 = "";
    L14:
        com.bytedance.android.gamecp.common.track.b.a(r106, r100, new GameDetailTrackV2$logGameDetailPageShow$1(r103));
    L17:
        if (r316 == null) goto L28;
        if (r316.P != 0) goto L28;
        JSONObject r107 = new JSONObject();
        r107.putOpt("anchor_id", r311);
        r107.putOpt("room_id", r312);
        r107.putOpt(EventConstants.ExtraJson.GAME_NAME, r313);
        r107.putOpt("game_id", r105);
        int r108 = com.bytedance.android.gamecp.common.track.b.f56775a;
        if (r312 == null) goto L25;
        Long r109 = StringsKt.toLongOrNull(r312);
        if (r109 == null) goto L25;
        long r113 = r109.longValue();
    L26:
        com.bytedance.android.gamecp.common.track.b.f("othershow", "landing_page_new", Long.valueOf(r113), r107, true);
    L25:
        r113 = 0;
    L28:
        if (r4 == 0) goto L31;
        r102 = r316.f469980u;
    L31:
        if (Intrinsics.areEqual(r102, "1") == true) goto L33;
        return;
    L33:
        if (r4.P != 1) goto L37;
        i("othershow", new b(r4.f469964m, r4.f469966n, r4.f469968o, r4.f469970p, r4.f469972q, r4.f469974r, ""), r110);
        return;
    L37:
        return;
    L13:
        r106 = r105;
        goto L14
    L15:
        r105 = r314;
        h("livesdk_game_promote_user_promote_detail_show", r100, null);
        goto L17
    L5:
        r101 = false;
        goto L6
    }
}
