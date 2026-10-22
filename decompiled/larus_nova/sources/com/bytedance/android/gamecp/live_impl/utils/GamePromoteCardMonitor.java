package com.bytedance.android.gamecp.live_impl.utils;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.gamecp.common.monitor_v1.FMPMonitorTracker;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.live.datacontext.DataContext;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wu.g1;

/* JADX INFO: loaded from: classes44.dex */
public final class GamePromoteCardMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f58018a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/utils/GamePromoteCardMonitor$Status;", "", GXAnimation.STATE_START, "SUCCESS", "FAIL", "CANCEL", GXAnimation.STATE_END, "WILL_SHOW", "WILL_NOT_SHOW", "CANCEL_V2", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status CANCEL = null;
        public static final Status CANCEL_V2 = null;
        public static final Status END = null;
        public static final Status FAIL = null;
        public static final Status START = null;
        public static final Status SUCCESS = null;
        public static final Status WILL_NOT_SHOW = null;
        public static final Status WILL_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f58019a = null;

        static {
            Status r100 = new Status(GXAnimation.STATE_START, 0);
            START = r100;
            Status r101 = new Status("SUCCESS", 1);
            SUCCESS = r101;
            Status r102 = new Status("FAIL", 2);
            FAIL = r102;
            Status r103 = new Status("CANCEL", 3);
            CANCEL = r103;
            Status r104 = new Status(GXAnimation.STATE_END, 4);
            END = r104;
            Status r105 = new Status("WILL_SHOW", 5);
            WILL_SHOW = r105;
            Status r106 = new Status("WILL_NOT_SHOW", 6);
            WILL_NOT_SHOW = r106;
            Status r107 = new Status("CANCEL_V2", 7);
            CANCEL_V2 = r107;
            f58019a = new Status[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f58019a.clone();
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GamePromoteCardMonitor() {
    }

    static {
    }

    public static void c(String r410, int r510, String r511, String r512, ILiveRoomControllerProvider.ProviderSource r513) {
        Intrinsics.checkNotNullParameter(r410, "gameId");
        Intrinsics.checkNotNullParameter(r511, "roomId");
        Intrinsics.checkNotNullParameter(r512, "uniqueKey");
        Intrinsics.checkNotNullParameter(r513, "source");
        GamePromoteDataContext.Companion.getClass();
        DataContext r100 = com.bytedance.live.datacontext.d.d(GamePromoteDataContext.a.a(r511, r512));
        if ((r100 instanceof GamePromoteDataContext) == true) goto L5;
        r100 = null;
    L5:
        GamePromoteDataContext r101 = (GamePromoteDataContext) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.couldReportCardFullShow() == true) goto L10;
        return;
    L10:
        if (r513 == ILiveRoomControllerProvider.ProviderSource.PREVIEW) goto L109;
        long r102 = Math.max(r101.getEnterCardShowTime(), r101.getCardIconLoadFinisDurationV2());
        RoomContext.a r103 = RoomContext.Companion;
        String r104 = r513.name();
        r103.getClass();
        RoomContext r105 = RoomContext.a.b(r511, r512, r104);
        if (r105 != null) goto L15;
        return;
    L15:
        long r106 = r101.getEnterRoomTime();
        long r110 = -1;
        if (r101.getEnterCardPreloadEndTime() <= 0) goto L18;
        long r111 = r101.getEnterCardPreloadEndTime() - r101.getEnterCardPreloadStartTime();
    L20:
        if (r101.getEnterCardPreloadEndTime() <= 0) goto L22;
        long r112 = r101.getEnterCardReceiveResponseTime() - r101.getEnterCardPreloadEndTime();
    L24:
        if (r106 <= 0) goto L26;
        long r113 = r101.getEnterCardLoadTime() - r106;
    L27:
        long r210 = r101.getEnterCardFetchDataTime() - r101.getEnterCardLoadTime();
        long r211 = r101.getBindCardViewStart() - r101.getEnterCardReceiveResponseTime();
        if (r106 <= 0) goto L30;
        long r212 = r101.getEnterCardRequestStartTime() - r106;
    L31:
        if (r106 <= 0) goto L33;
        long r213 = r105.getEnterCardReceiveBackendDataTime() - r106;
    L34:
        if (r106 <= 0) goto L36;
        long r214 = r101.getEnterCardReceiveResponseTime() - r106;
    L37:
        if (r106 <= 0) goto L39;
        long r310 = r101.getEnterCardShowTime() - r106;
    L40:
        if (r106 <= 0) goto L42;
        long r107 = r102 - r106;
    L43:
        if (r106 <= 0) goto L45;
        long r311 = r101.getEnterRoomEnd() - r106;
    L46:
        if (r106 <= 0) goto L48;
        r110 = r101.getEnterRoomEnd() - r101.getBindCardViewStart();
    L48:
        long r108 = r101.getEventStartToAnimationStartDuration();
        long r312 = r101.getAnimationStartToEnd();
        String r109 = r101.getCardItemShowFrom();
        long r313 = r101.getEnterCardShowTime() - r101.getCardIconLoadFinisDurationV2();
        long r314 = r105.getEnterCardReceiveBackendParseTime() - r105.getEnterCardReceiveBackendDataTime();
        long r411 = r101.getEnterCardReceiveResponseTime() - r105.getEnterCardReceiveBackendParseTime();
        String r114 = String.valueOf(r105.getLoadFromLocal());
        String r115 = r105.getLoadFromLocalError();
        com.bytedance.android.gamecp.live_impl.card.p r116 = com.bytedance.android.gamecp.live_impl.preview.a.f57923b.a(r511, r512, r513).c();
        String r117 = "";
        if (r116 == null) goto L64;
        com.bytedance.android.gamecp.host_api.model.introducecard.q r118 = r116.m();
        if (r118 == null) goto L64;
        boolean r412 = r118.e();
        Pair<Boolean, String> r413 = r118.f();
        if (r413 != null) goto L55;
    L57:
        boolean r119 = false;
    L58:
        Pair<Boolean, String> r120 = r118.f();
        if (r120 == null) goto L65;
        String r121 = r120.getSecond();
        if (r121 == null) goto L65;
        r117 = r121;
    L65:
        long r414 = r101.getBindCardViewEnd() - r101.getBindCardViewStart();
        Pair[] r122 = new Pair[49];
        r122[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, String.valueOf(r510));
        r122[1] = TuplesKt.to("prefetch_duration", String.valueOf(r111));
        r122[2] = TuplesKt.to("prefetchend_response_duration", String.valueOf(r112));
        r122[3] = TuplesKt.to("enter_load_duration", String.valueOf(r113));
        r122[4] = TuplesKt.to("load_fetch_duration", String.valueOf(r210));
        r122[5] = TuplesKt.to("enter_request_duration", String.valueOf(r212));
        r122[6] = TuplesKt.to("request_response_duration", String.valueOf(r101.getEnterCardReceiveResponseTime() - r101.getEnterCardRequestStartTime()));
        r122[7] = TuplesKt.to("response_show_duration", String.valueOf(r101.getEnterCardShowTime() - r101.getEnterCardReceiveResponseTime()));
        r122[8] = TuplesKt.to("enter_full_show_duration", String.valueOf(r107));
        r122[9] = TuplesKt.to("add_detected_duration", String.valueOf(r101.getEnterFullShowDurationRender()));
        r122[10] = TuplesKt.to("response_add_duration", String.valueOf(r211));
        r122[11] = TuplesKt.to("enter_full_show_duration_ios", String.valueOf(r310));
        r122[12] = TuplesKt.to("add_view_duration", String.valueOf(r110));
        r122[13] = TuplesKt.to("event_start_to_animation_start_duration", String.valueOf(r108));
        r122[14] = TuplesKt.to("event_animation_start_to_end_duration", String.valueOf(r312));
        r122[15] = TuplesKt.to("event_animation_end_to_report", String.valueOf(r101.getAnimationEndToReport()));
        r122[16] = TuplesKt.to("enter_response_duration", String.valueOf(r214));
        r122[17] = TuplesKt.to("enter_to_receive_backend_data", String.valueOf(r213));
        r122[18] = TuplesKt.to("cardItemShowFrom", r109);
        r122[19] = TuplesKt.to("wait_toolbar_or_card_load_duration", String.valueOf(r101.getWaitToolbarOrCardLoad()));
        r122[20] = TuplesKt.to("icon_finish_to_event_report_duration", String.valueOf(r313));
        r122[21] = TuplesKt.to("backend_data_parse_duration", String.valueOf(r314));
        r122[22] = TuplesKt.to("backend_data_parse_to_response_duration", String.valueOf(r411));
        r122[23] = TuplesKt.to("icon_loading_duration", String.valueOf(r101.getCardIconLoadingDuration()));
        String r123 = "1";
        if (r412 == false) goto L68;
        Object r124 = "1";
    L69:
        r122[24] = TuplesKt.to("is_lynx_reuse", r124);
        if (r119 == false) goto L72;
        Object r125 = "1";
    L73:
        r122[25] = TuplesKt.to("is_hook_image_success", r125);
        r122[26] = TuplesKt.to("is_hook_image_error", r117);
        r122[27] = TuplesKt.to("is_hit_cache", r114);
        if (com.bytedance.android.gamecp.live_impl.preview.e.b(r513) == false) goto L76;
        Object r126 = "1";
    L77:
        r122[28] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r126);
        r122[29] = TuplesKt.to("is_hit_not_cache_reason", r115);
        r122[30] = TuplesKt.to("is_hit_cache_success_type", r105.getLoadFromLocalSuccess());
        if (r101.getCacheStart() == false) goto L80;
        Object r127 = "1";
    L81:
        r122[31] = TuplesKt.to("cache_start", r127);
        if (r101.getCacheValid() == false) goto L84;
        Object r128 = "1";
    L85:
        r122[32] = TuplesKt.to("cache_available", r128);
        if (r101.getCardIsOnScreen() == false) goto L88;
        Object r129 = "1";
    L89:
        r122[33] = TuplesKt.to("card_is_on_screen", r129);
        r122[34] = TuplesKt.to("show_invoke_to_enqueue", String.valueOf(r101.getShowToExecuteDuration()));
        r122[35] = TuplesKt.to("enter_full_show_duration_new", String.valueOf(r311));
        r122[36] = TuplesKt.to("cache_invalid_reason", r101.getCacheInvalidReason());
        r122[37] = TuplesKt.to("card_render_duration", String.valueOf(r414));
        r122[38] = TuplesKt.to("bind_view_to_icon_load_start", String.valueOf(r101.getBindViewToIconLoadStart()));
        r122[39] = TuplesKt.to("icon_load_finish_to_receive_callback", String.valueOf(r101.getIconLoadFinishToReceiveCallback()));
        r122[40] = TuplesKt.to("introduce_preload_from", r105.getPreloadFrom());
        if (r105.getScreenOrientationChange() == false) goto L92;
        Object r130 = "1";
    L93:
        r122[41] = TuplesKt.to("screen_orientation_change", r130);
        if (r105.getEnterCardBackendDataReady() == false) goto L96;
        Object r131 = "1";
    L97:
        r122[42] = TuplesKt.to("backend_data_ready", r131);
        if (r101.getCardIconLoadStatus() == false) goto L100;
        Object r132 = "1";
    L101:
        r122[43] = TuplesKt.to("icon_load_status", r132);
        if (r105.getPreloadResult() == true) goto L105;
        r123 = "0";
    L105:
        r122[44] = TuplesKt.to("icon_preload_result", r123);
        r122[45] = TuplesKt.to("icon_preload_option", r105.getMemoryCache());
        r122[46] = TuplesKt.to("icon_preload_cache_key", r105.getCacheKey());
        r122[47] = TuplesKt.to("icon_real_load_url", r105.getRealUrl());
        r122[48] = TuplesKt.to("icon_preload_error", r105.getPreloadErrorMsg());
        HashMap r133 = MapsKt.hashMapOf(r122);
        r105.setCardFirstReport(false);
        i.a("dygame_tech_explaincard_enter_full_show_duration", r410, r133);
        return;
    L100:
        r132 = "0";
        goto L101
    L96:
        r131 = "0";
        goto L97
    L92:
        r130 = "0";
        goto L93
    L88:
        r129 = "0";
        goto L89
    L84:
        r128 = "0";
        goto L85
    L80:
        r127 = "0";
        goto L81
    L76:
        r126 = "0";
        goto L77
    L72:
        r125 = "0";
        goto L73
    L68:
        r124 = "0";
        goto L69
    L55:
        if (r413.getFirst().booleanValue() != true) goto L57;
        r119 = true;
    L64:
        r119 = false;
        r412 = false;
        goto L65
    L45:
        r311 = -1;
        goto L46
    L42:
        r107 = -1;
        goto L43
    L39:
        r310 = -1;
        goto L40
    L36:
        r214 = -1;
        goto L37
    L33:
        r213 = -1;
        goto L34
    L30:
        r212 = -1;
        goto L31
    L26:
        r113 = -1;
        goto L27
    L22:
        r112 = -1;
        goto L24
    L18:
        r111 = -1;
        goto L20
    }

    public static /* synthetic */ void b(String r110, int r111, String r112, String r113, Status r114, String r210, ILiveRoomControllerProvider.ProviderSource r211, String r212, String r213, int r214) {
        if ((r214 & 2) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r214 & 32) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r214 & 64) == 0) goto L13;
        Integer r102 = -1;
    L15:
        if ((r214 & 128) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r214 & 256) == 0) goto L21;
        String r115 = "";
    L23:
        if ((r214 & 512) == 0) goto L25;
        String r116 = "";
    L27:
        if ((r214 & 2048) == 0) goto L29;
        String r117 = "";
    L31:
        if ((r214 & 4096) == 0) goto L33;
        String r118 = "";
    L34:
        a(r110, r100, r112, r113, r114, r101, r102, r103, r115, r116, r211, r117, r118);
        return;
    L33:
        r118 = r213;
        goto L34
    L29:
        r117 = r212;
        goto L31
    L25:
        r116 = null;
        goto L27
    L21:
        r115 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static void a(String r110, int r111, String r112, String r113, Status r114, String r210, Integer r211, String r212, String r213, String r214, ILiveRoomControllerProvider.ProviderSource r215, String r216, String r217) {
        Intrinsics.checkNotNullParameter(r110, "gameId");
        Intrinsics.checkNotNullParameter(r112, "showTime");
        Intrinsics.checkNotNullParameter(r113, "showType");
        Intrinsics.checkNotNullParameter(r114, "status");
        if (g1.f561313a.getValue().a() == true) goto L5;
    L41:
        Pair[] r100 = new Pair[8];
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, String.valueOf(r111));
        r100[1] = TuplesKt.to("show_time", r112);
        r100[2] = TuplesKt.to("show_type", r113);
        if (r215 != null) goto L44;
    L46:
        String r101 = "0";
    L47:
        r100[3] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r101);
        String r102 = r114.name();
        Locale r103 = Locale.ROOT;
        if (r102 == null) goto L66;
        r100[4] = TuplesKt.to("status", r102.toLowerCase(r103));
        r100[5] = TuplesKt.to("screen_rect", r212);
        r100[6] = TuplesKt.to("live_room_rect", r213);
        r100[7] = TuplesKt.to("card_rect", r214);
        HashMap r104 = MapsKt.hashMapOf(r100);
        if (r114 != Status.FAIL) goto L52;
    L57:
        r104.put("reason", r210);
        if (r210 == null) goto L61;
        FMPMonitorTracker.f56555g.p(FMPMonitorTracker.f56554f, r114 + '_' + r210);
    L61:
        if (r114 != Status.WILL_NOT_SHOW) goto L63;
        r104.put("fail_code", String.valueOf(r211));
    L63:
        i.a("dygame_tech_explaincard_show_status", r110, r104);
        return;
    L52:
        if (r114 == Status.CANCEL) goto L57;
        if (r114 == Status.WILL_NOT_SHOW) goto L57;
        if (r114 != Status.CANCEL_V2) goto L61;
    L66:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L44:
        if (com.bytedance.android.gamecp.live_impl.preview.e.b(r215) != true) goto L46;
        r101 = "1";
        goto L47
    L5:
        if (Intrinsics.areEqual(r112, "enter") == false) goto L41;
        String r115 = "";
        if (UtilsKt.c(r216) == false) goto L9;
        Intrinsics.checkNotNull(r216);
        String r105 = r216;
    L16:
        RoomContext.a r116 = RoomContext.Companion;
        if (r217 == null) goto L20;
        r115 = r217;
    L20:
        if (r215 == null) goto L23;
        String r117 = r215.name();
        if (r117 == null) goto L23;
    L24:
        r116.getClass();
        RoomContext r106 = RoomContext.a.b(r105, r115, r117);
        if (r106 == null) goto L41;
        if (r106.isCleared() == true) goto L41;
        int r118 = h.f58087a[r114.ordinal()];
        if (r118 == 1) goto L40;
        if (r118 == 2) goto L39;
        if (r118 == 3) goto L38;
        if (r118 == 4) goto L37;
        if (r118 != 5) goto L41;
        r106.setHasReportWillNotShow(true);
        goto L41
    L37:
        r106.setHasReportEnd(true);
        goto L41
    L38:
        r106.setHasReportCancel(true);
        goto L41
    L39:
        r106.setHasReportWillShow(true);
        goto L41
    L40:
        r106.setHasReportStart(true);
    L23:
        r117 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();
        goto L24
    L9:
        Room r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r107 == null) goto L15;
        Long r108 = r107.getRoomId();
        if (r108 == null) goto L15;
        r105 = String.valueOf(r108.longValue());
        if (r105 != null) goto L16;
    L15:
        r105 = "";
        goto L16
    }
}
