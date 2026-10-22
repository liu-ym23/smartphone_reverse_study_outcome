package com.bytedance.android.gamecp.common.monitor;

import bw.k;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.ttvideoengine.FeatureManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class LiveTracingMonitor {

    public static final enum EventModule extends Enum<EventModule> {
        public static final EventModule ACTIVITY = null;
        public static final EventModule AUDIENCE_INTERACT = null;
        public static final EventModule AUDIO = null;
        public static final EventModule BEAUTY = null;
        public static final EventModule BIG_PARTY = null;
        public static final EventModule CLOUD_GAME = null;
        public static final EventModule COMMENT = null;
        public static final EventModule DANMAKU = null;
        public static final EventModule DIGG = null;
        public static final EventModule DRESS = null;
        public static final EventModule EFFECT_GAME = null;
        public static final EventModule ENTER_ANIM = null;
        public static final EventModule ENTER_ROOM = null;
        public static final EventModule FACE_STICKER = null;
        public static final EventModule FANS_CLUB = null;
        public static final EventModule FM_INTERACT = null;
        public static final EventModule FRIEND_ROOM_BASE = null;
        public static final EventModule FRIEND_ROOM_COMMON = null;
        public static final EventModule GAME_LIVE = null;
        public static final EventModule GAME_ORDER = null;
        public static final EventModule GAME_PLAY_TOGETHER = null;
        public static final EventModule GAME_PROMOTE = null;
        public static final EventModule INNER_DRAW = null;
        public static final EventModule INTERACTION_OPT = null;
        public static final EventModule INTERACT_STREAM = null;
        public static final EventModule KTV = null;
        public static final EventModule LIVE_CORE = null;
        public static final EventModule LIVE_GIFT = null;
        public static final EventModule LIVE_MESSAGE = null;
        public static final EventModule LIVE_PROFIT = null;
        public static final EventModule LIVE_ROOM_OBSERVER = null;
        public static final EventModule MULTI_AUDIO = null;
        public static final EventModule MULTI_LINKER = null;
        public static final EventModule NETWORK = null;
        public static final EventModule OPEN_LIVE = null;
        public static final EventModule OPEN_PLATFORM = null;
        public static final EventModule PCDN = null;
        public static final EventModule PIN_COMMENT = null;
        public static final EventModule PK = null;
        public static final EventModule PLAYER = null;
        public static final EventModule PORTAL = null;
        public static final EventModule PREVIEW = null;
        public static final EventModule PRIVILEGE_DANMAKU = null;
        public static final EventModule PRIVILEGE_INFO = null;
        public static final EventModule PULL_STREAM = null;
        public static final EventModule PUSH_STREAM = null;
        public static final EventModule RANK = null;
        public static final EventModule REAL_NAME = null;
        public static final EventModule ROOM_APM = null;
        public static final EventModule SETTING = null;
        public static final EventModule SHORT_VIDEO = null;
        public static final EventModule STRATEGY = null;
        public static final EventModule SUBSCRIBE_VIP = null;
        public static final EventModule TEXT_MESSAGE = null;
        public static final EventModule TEXT_RENDER_ENGINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventModule[] f56536a = null;
        public static final EventModule common = null;
        public static final EventModule hybrid = null;

        /* JADX INFO: renamed from: vs, reason: collision with root package name */
        public static final EventModule f56537vs = null;
        private String mName;

        static {
            EventModule r100 = new EventModule("common", 0, "common");
            common = r100;
            EventModule r101 = new EventModule("vs", 1, "vs");
            f56537vs = r101;
            EventModule r102 = new EventModule("NETWORK", 2, "network");
            NETWORK = r102;
            EventModule r103 = new EventModule("ROOM_APM", 3, "room_apm");
            ROOM_APM = r103;
            EventModule r104 = new EventModule("ENTER_ROOM", 4, "enter_room");
            ENTER_ROOM = r104;
            EventModule r105 = new EventModule("OPEN_LIVE", 5, "anchor_live");
            OPEN_LIVE = r105;
            EventModule r110 = new EventModule("PUSH_STREAM", 6, "push_stream");
            PUSH_STREAM = r110;
            EventModule r111 = new EventModule("PULL_STREAM", 7, "pull_stream");
            PULL_STREAM = r111;
            EventModule r112 = new EventModule("INTERACT_STREAM", 8, "interact_stream");
            INTERACT_STREAM = r112;
            EventModule r113 = new EventModule(LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, 9, "beauty");
            BEAUTY = r113;
            EventModule r114 = new EventModule("FACE_STICKER", 10, IPerformanceManager.MODULE_FACE_STICKER);
            FACE_STICKER = r114;
            EventModule r106 = new EventModule("EFFECT_GAME", 11, IPerformanceManager.MODULE_EFFECT_GAME);
            EFFECT_GAME = r106;
            EventModule r107 = new EventModule("PK", 12, PbRequest.SwitchType.PK);
            PK = r107;
            EventModule r108 = new EventModule("AUDIENCE_INTERACT", 13, "audience_interact");
            AUDIENCE_INTERACT = r108;
            EventModule r109 = new EventModule("FM_INTERACT", 14, "fm_interact");
            FM_INTERACT = r109;
            EventModule r115 = new EventModule("MULTI_AUDIO", 15, "multi_audio");
            MULTI_AUDIO = r115;
            EventModule r116 = new EventModule("BIG_PARTY", 16, "big_party");
            BIG_PARTY = r116;
            EventModule r117 = new EventModule("MULTI_LINKER", 17, "muti_linker");
            MULTI_LINKER = r117;
            EventModule r118 = new EventModule("TEXT_MESSAGE", 18, "text_message");
            TEXT_MESSAGE = r118;
            EventModule r119 = new EventModule("INTERACTION_OPT", 19, "interaction_opt");
            INTERACTION_OPT = r119;
            EventModule r120 = new EventModule("REAL_NAME", 20, "real_name");
            REAL_NAME = r120;
            EventModule r121 = new EventModule(BannerBizName.ACTIVITY, 21, "activity");
            ACTIVITY = r121;
            EventModule r122 = new EventModule("KTV", 22, "ktv");
            KTV = r122;
            EventModule r123 = new EventModule("DIGG", 23, "digg");
            DIGG = r123;
            EventModule r124 = new EventModule("OPEN_PLATFORM", 24, "interactive_open_platform");
            OPEN_PLATFORM = r124;
            EventModule r125 = new EventModule("PLAYER", 25, "palyer");
            PLAYER = r125;
            EventModule r126 = new EventModule("PREVIEW", 26, "preview");
            PREVIEW = r126;
            EventModule r127 = new EventModule("GAME_LIVE", 27, "game_live");
            GAME_LIVE = r127;
            EventModule r128 = new EventModule("LIVE_MESSAGE", 28, "live_message");
            LIVE_MESSAGE = r128;
            EventModule r129 = new EventModule("SETTING", 29, "setting");
            SETTING = r129;
            EventModule r130 = new EventModule("FRIEND_ROOM_BASE", 30, "friend_room_base");
            FRIEND_ROOM_BASE = r130;
            EventModule r131 = new EventModule("FRIEND_ROOM_COMMON", 31, "friend_room_common");
            FRIEND_ROOM_COMMON = r131;
            EventModule r132 = new EventModule("SHORT_VIDEO", 32, UGCMonitor.TYPE_SHORT_VIDEO);
            SHORT_VIDEO = r132;
            EventModule r133 = new EventModule("GAME_PROMOTE", 33, "cooperation_partner");
            GAME_PROMOTE = r133;
            EventModule r134 = new EventModule("GAME_PLAY_TOGETHER", 34, "game_play_together");
            GAME_PLAY_TOGETHER = r134;
            EventModule r135 = new EventModule("LIVE_CORE", 35, "livecore");
            LIVE_CORE = r135;
            EventModule r136 = new EventModule("hybrid", 36, "hybrid");
            hybrid = r136;
            EventModule r137 = new EventModule("LIVE_GIFT", 37, "live_gift");
            LIVE_GIFT = r137;
            EventModule r138 = new EventModule("ENTER_ANIM", 38, "enter_anim");
            ENTER_ANIM = r138;
            EventModule r139 = new EventModule("LIVE_PROFIT", 39, "live_profit");
            LIVE_PROFIT = r139;
            EventModule r140 = new EventModule("INNER_DRAW", 40, "inner_draw");
            INNER_DRAW = r140;
            EventModule r141 = new EventModule("PCDN", 41, FeatureManager.PCDN);
            PCDN = r141;
            EventModule r142 = new EventModule("LIVE_ROOM_OBSERVER", 42, "live_room_observer");
            LIVE_ROOM_OBSERVER = r142;
            EventModule r143 = new EventModule("STRATEGY", 43, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            STRATEGY = r143;
            EventModule r144 = new EventModule("AUDIO", 44, "audio");
            AUDIO = r144;
            EventModule r145 = new EventModule("DRESS", 45, "dress");
            DRESS = r145;
            EventModule r146 = new EventModule("DANMAKU", 46, "danmaku");
            DANMAKU = r146;
            EventModule r147 = new EventModule("COMMENT", 47, "comment");
            COMMENT = r147;
            EventModule r148 = new EventModule("PIN_COMMENT", 48, "pin_comment");
            PIN_COMMENT = r148;
            EventModule r149 = new EventModule("TEXT_RENDER_ENGINE", 49, "text_render_engine");
            TEXT_RENDER_ENGINE = r149;
            EventModule r150 = new EventModule("FANS_CLUB", 50, PbRequest.SwitchType.FANS_CLUB);
            FANS_CLUB = r150;
            EventModule r151 = new EventModule("SUBSCRIBE_VIP", 51, "subscribe_vip");
            SUBSCRIBE_VIP = r151;
            EventModule r152 = new EventModule("PRIVILEGE_INFO", 52, "privilege_info");
            PRIVILEGE_INFO = r152;
            EventModule r153 = new EventModule("PRIVILEGE_DANMAKU", 53, "privilege_danmaku");
            PRIVILEGE_DANMAKU = r153;
            EventModule r154 = new EventModule("RANK", 54, "rank");
            RANK = r154;
            EventModule r155 = new EventModule("PORTAL", 55, "portal");
            PORTAL = r155;
            EventModule r156 = new EventModule("GAME_ORDER", 56, "game_order");
            GAME_ORDER = r156;
            EventModule r157 = new EventModule("CLOUD_GAME", 57, "cloud_game");
            CLOUD_GAME = r157;
            f56536a = new EventModule[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157};
        }

        public static EventModule[] values() {
            return (EventModule[]) f56536a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static EventModule valueOf(String r100) {
            return (EventModule) r27.a.a(EventModule.class, r100);
        }

        public EventModule(String r100, int r101, String r102) {
            super(r100, r101);
            this.mName = r102;
        }
    }

    public static final enum EventType extends Enum<EventType> {
        public static final EventType BUSSINESS_API_CALL = null;
        public static final EventType MESSAGE_RECEIVED = null;
        public static final EventType SDK_CALLBACK = null;
        public static final EventType SDK_INTERFACE_CALL = null;
        public static final EventType SERVER_API_CALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f56538a = null;
        private String mName;

        static {
            EventType r100 = new EventType("BUSSINESS_API_CALL", 0, "bussiness_api_call");
            BUSSINESS_API_CALL = r100;
            EventType r101 = new EventType("SERVER_API_CALL", 1, "server_api_call");
            SERVER_API_CALL = r101;
            EventType r102 = new EventType("MESSAGE_RECEIVED", 2, "message_received");
            MESSAGE_RECEIVED = r102;
            EventType r103 = new EventType("SDK_INTERFACE_CALL", 3, "sdk_interface_call");
            SDK_INTERFACE_CALL = r103;
            EventType r104 = new EventType("SDK_CALLBACK", 4, "sdk_callback");
            SDK_CALLBACK = r104;
            f56538a = new EventType[]{r100, r101, r102, r103, r104};
        }

        public static EventType[] values() {
            return (EventType[]) f56538a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public EventType(String r100, int r101, String r102) {
            super(r100, r101);
            this.mName = r102;
        }
    }

    public static void d(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
    }

    public static void c(String r100, JSONObject r101, JSONObject r102, JSONObject r110) {
        if (com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService() != null) goto L6;
        return;
    L6:
        if (r100.startsWith("ttlive_") == true) goto L8;
        r100 = "ttlive_".concat(r100);
    L8:
        d(r110, "event_source", "live_platform_client");
        JSONObject r103 = new JSONObject();
        JSONArray r104 = r110.names();     // Catch: Exception -> L23
        if (r104 == null) goto L21;
        int r105 = r104.length();     // Catch: Exception -> L23
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L21;
        String r107 = JSONArrayProtectorUtils.getString(r104, r106);     // Catch: Exception -> L23
        if (r107 != null) goto L16;
        String r108 = "";
    L17:
        Object r109 = r110.get(r108);     // Catch: Exception -> L23
        if ((r109 instanceof String) == true) goto L20;
        r110.put(r107, String.valueOf(r109));     // Catch: Exception -> L23
    L20:
        r106 = r106 + 1;     // Catch: Exception -> L23
        goto L12
    L16:
        r108 = r107;
    L21:
        r103.put("extra", r110);     // Catch: Exception -> L23
        d(r103, "tag", "ttlive_sdk");     // Catch: Exception -> L23
        d(r103, "ttlive_sdk_version", com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveSdkVersion());     // Catch: Exception -> L23
    L25:
        k r111 = com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService();
        if (r111 == null) goto L34;
        r111.monitorEvent(r100, r101, r102, r103);
        return;
    L34:
        return;
    L23:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L25
    }

    public static void b(String r100, EventModule r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        if (r104 != null) goto L4;
        r104 = new JSONObject();
    L4:
        d(r104, "event_module", r101.getName());
        d(r104, "event_type", EventType.BUSSINESS_API_CALL.getName());
        c(r100, r102, r103, r104);
    }

    public static void a(String r100, EventModule r101, EventType r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        if (r105 != null) goto L4;
        r105 = new JSONObject();
    L4:
        d(r105, "event_module", r101.getName());
        d(r105, "event_type", r102.getName());
        c(r100, r103, r104, r105);
    }
}
