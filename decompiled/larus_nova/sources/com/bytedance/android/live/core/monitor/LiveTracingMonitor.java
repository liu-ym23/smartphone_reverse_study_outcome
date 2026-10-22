package com.bytedance.android.live.core.monitor;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.ttvideoengine.FeatureManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;
import wm0.b;
import y50.h;
import y50.j;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveTracingMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f64909a = null;

    public static final enum EventModule extends Enum<EventModule> {
        public static final EventModule ACTIVITY = null;
        public static final EventModule ADVENTURE = null;
        public static final EventModule AI_CLONE = null;
        public static final EventModule ANCHOR_ASR = null;
        public static final EventModule AUDIENCE = null;
        public static final EventModule AUDIENCE_INTERACT = null;
        public static final EventModule AUDIO = null;
        public static final EventModule BACKEND = null;
        public static final EventModule BANNER = null;
        public static final EventModule BEAUTY = null;
        public static final EventModule BIG_PARTY = null;
        public static final EventModule CHAT_CHANNEL = null;
        public static final EventModule CLEAR_SCREEN = null;
        public static final EventModule CLOUD_GAME = null;
        public static final EventModule COMMENT = null;
        public static final EventModule COMMON_CARD = null;
        public static final EventModule DANMAKU = null;
        public static final EventModule DANMU_GAME = null;
        public static final EventModule DIGG = null;
        public static final EventModule DRESS = null;
        public static final EventModule DYNAMIC_STRATEGY = null;
        public static final EventModule EFFECT_GAME = null;
        public static final EventModule ENTER_ANIM = null;
        public static final EventModule ENTER_ROOM = null;
        public static final EventModule EXCHANGE = null;
        public static final EventModule FACE_STICKER = null;
        public static final EventModule FANS_CLUB = null;
        public static final EventModule FEED = null;
        public static final EventModule FEED_TAB = null;
        public static final EventModule FM_INTERACT = null;
        public static final EventModule FORMAT = null;
        public static final EventModule FORMAT_LIVE = null;
        public static final EventModule FRIEND_ROOM_BASE = null;
        public static final EventModule FRIEND_ROOM_COMMON = null;
        public static final EventModule GAME_LIVE = null;
        public static final EventModule GAME_ORDER = null;
        public static final EventModule GAME_PLAY_TOGETHER = null;
        public static final EventModule GAME_PROMOTE = null;
        public static final EventModule GIFT = null;
        public static final EventModule GIFT_PANEL_TOUCH = null;
        public static final EventModule GUEST_BATTLE = null;
        public static final EventModule HAMLET_AVATAR = null;
        public static final EventModule IMAGE_PICKER = null;
        public static final EventModule IMAGE_RECOGNITION = null;
        public static final EventModule INNER_DRAW = null;
        public static final EventModule INPUT_PANEL = null;
        public static final EventModule INTERACTION = null;
        public static final EventModule INTERACTION_OPT = null;
        public static final EventModule INTERACTIVITY = null;
        public static final EventModule INTERACTIVITY_DEGRADE = null;
        public static final EventModule INTERACT_STREAM = null;
        public static final EventModule INTERACT_XPLAY = null;
        public static final EventModule KTV = null;
        public static final EventModule KTV_CHORUS = null;
        public static final EventModule LIVE_CORE = null;
        public static final EventModule LIVE_GIFT = null;
        public static final EventModule LIVE_MESSAGE = null;
        public static final EventModule LIVE_PROFIT = null;
        public static final EventModule LIVE_ROOM_OBSERVER = null;
        public static final EventModule MATCH_TRAY = null;
        public static final EventModule MEDIA_MULTI_LINKER = null;
        public static final EventModule MSG_WINDOW_CARD = null;
        public static final EventModule MULTI_AUDIO = null;
        public static final EventModule MULTI_LINKER = null;
        public static final EventModule MULTI_LINK_DYNAMIC = null;
        public static final EventModule MULTI_LINK_GIFT = null;
        public static final EventModule MULTI_TAB = null;
        public static final EventModule NETWORK = null;
        public static final EventModule OPEN_ASSET = null;
        public static final EventModule OPEN_LIVE = null;
        public static final EventModule OPEN_PLATFORM = null;
        public static final EventModule PAID_LINK_MIC = null;
        public static final EventModule PAY_GRADE = null;
        public static final EventModule PCDN = null;
        public static final EventModule PERSONALIZED_CHANNEL = null;
        public static final EventModule PIN_COMMENT = null;
        public static final EventModule PK = null;
        public static final EventModule PLAYER = null;
        public static final EventModule PREDICTOR_PLAYING = null;
        public static final EventModule PREVIEW = null;
        public static final EventModule PRIVILEGE_DANMAKU = null;
        public static final EventModule PRIVILEGE_INFO = null;
        public static final EventModule PULL_STREAM = null;
        public static final EventModule PUSH_STREAM = null;
        public static final EventModule REAL_NAME = null;
        public static final EventModule RECHARGE = null;
        public static final EventModule ROOM_APM = null;
        public static final EventModule ROOM_BATTLE = null;
        public static final EventModule ROOM_STATE_AND_AV_RESOURCE = null;
        public static final EventModule SCREEN_LINKER = null;
        public static final EventModule SETTING = null;
        public static final EventModule SHORT_TOUCH = null;
        public static final EventModule SHORT_VIDEO = null;
        public static final EventModule SOLO_KTV = null;
        public static final EventModule STRATEGY = null;
        public static final EventModule SUBSCRIBE_VIP = null;
        public static final EventModule SWITCH_RESOLUTION = null;
        public static final EventModule TEAM_FIGHT = null;
        public static final EventModule TEXT_MESSAGE = null;
        public static final EventModule TEXT_RENDER_ENGINE = null;
        public static final EventModule USER_ENTER = null;
        public static final EventModule VOICE_CHAT = null;
        public static final EventModule WRDS = null;
        public static final EventModule XPLAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventModule[] f64910a = null;
        public static final EventModule common = null;
        public static final EventModule hybrid = null;

        /* JADX INFO: renamed from: vs, reason: collision with root package name */
        public static final EventModule f64911vs = null;
        private String mName;

        static {
            EventModule r100 = new EventModule("common", 0, "common");
            common = r100;
            EventModule r101 = new EventModule("vs", 1, "vs");
            f64911vs = r101;
            EventModule r102 = new EventModule("FORMAT", 2, "format_room");
            FORMAT = r102;
            EventModule r103 = new EventModule("FORMAT_LIVE", 3, "format_live");
            FORMAT_LIVE = r103;
            EventModule r104 = new EventModule("NETWORK", 4, "network");
            NETWORK = r104;
            EventModule r105 = new EventModule("ROOM_APM", 5, "room_apm");
            ROOM_APM = r105;
            EventModule r110 = new EventModule("ENTER_ROOM", 6, "enter_room");
            ENTER_ROOM = r110;
            EventModule r111 = new EventModule("OPEN_LIVE", 7, "anchor_live");
            OPEN_LIVE = r111;
            EventModule r112 = new EventModule("PUSH_STREAM", 8, "push_stream");
            PUSH_STREAM = r112;
            EventModule r113 = new EventModule("PULL_STREAM", 9, "pull_stream");
            PULL_STREAM = r113;
            EventModule r114 = new EventModule("INTERACT_STREAM", 10, "interact_stream");
            INTERACT_STREAM = r114;
            EventModule r106 = new EventModule(LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, 11, "beauty");
            BEAUTY = r106;
            EventModule r107 = new EventModule("FACE_STICKER", 12, IPerformanceManager.MODULE_FACE_STICKER);
            FACE_STICKER = r107;
            EventModule r108 = new EventModule("EFFECT_GAME", 13, IPerformanceManager.MODULE_EFFECT_GAME);
            EFFECT_GAME = r108;
            EventModule r109 = new EventModule("INTERACTIVITY", 14, "interactivty");
            INTERACTIVITY = r109;
            EventModule r115 = new EventModule("PK", 15, PbRequest.SwitchType.PK);
            PK = r115;
            EventModule r116 = new EventModule("GIFT", 16, PbRequest.SwitchType.GIFT);
            GIFT = r116;
            EventModule r117 = new EventModule("RECHARGE", 17, PbRequest.SwitchType.RECHARGE);
            RECHARGE = r117;
            EventModule r118 = new EventModule("VOICE_CHAT", 18, "voice_chat");
            VOICE_CHAT = r118;
            EventModule r119 = new EventModule("IMAGE_PICKER", 19, "image_picker");
            IMAGE_PICKER = r119;
            EventModule r120 = new EventModule("ROOM_STATE_AND_AV_RESOURCE", 20, "room_state_and_av_resource");
            ROOM_STATE_AND_AV_RESOURCE = r120;
            EventModule r121 = new EventModule("EXCHANGE", 21, "exchange");
            EXCHANGE = r121;
            EventModule r122 = new EventModule("AUDIENCE_INTERACT", 22, "audience_interact");
            AUDIENCE_INTERACT = r122;
            EventModule r123 = new EventModule("FM_INTERACT", 23, "fm_interact");
            FM_INTERACT = r123;
            EventModule r124 = new EventModule("MULTI_AUDIO", 24, "multi_audio");
            MULTI_AUDIO = r124;
            EventModule r125 = new EventModule("BIG_PARTY", 25, "big_party");
            BIG_PARTY = r125;
            EventModule r126 = new EventModule("MULTI_LINKER", 26, "muti_linker");
            MULTI_LINKER = r126;
            EventModule r127 = new EventModule("MEDIA_MULTI_LINKER", 27, "media_muti_linker");
            MEDIA_MULTI_LINKER = r127;
            EventModule r128 = new EventModule("SCREEN_LINKER", 28, "screen_linker");
            SCREEN_LINKER = r128;
            EventModule r129 = new EventModule("TEXT_MESSAGE", 29, "text_message");
            TEXT_MESSAGE = r129;
            EventModule r130 = new EventModule("DYNAMIC_STRATEGY", 30, PbRequest.SwitchType.DYNAMIC_STRATEGY);
            DYNAMIC_STRATEGY = r130;
            EventModule r131 = new EventModule("INTERACTION_OPT", 31, "interaction_opt");
            INTERACTION_OPT = r131;
            EventModule r132 = new EventModule("REAL_NAME", 32, "real_name");
            REAL_NAME = r132;
            EventModule r133 = new EventModule(BannerBizName.ACTIVITY, 33, "activity");
            ACTIVITY = r133;
            EventModule r134 = new EventModule("KTV", 34, "ktv");
            KTV = r134;
            EventModule r135 = new EventModule("KTV_CHORUS", 35, "ktv_chorus");
            KTV_CHORUS = r135;
            EventModule r136 = new EventModule("SOLO_KTV", 36, "solo_ktv");
            SOLO_KTV = r136;
            EventModule r137 = new EventModule("HAMLET_AVATAR", 37, "hamlet_avatar");
            HAMLET_AVATAR = r137;
            EventModule r138 = new EventModule("DIGG", 38, "digg");
            DIGG = r138;
            EventModule r139 = new EventModule("OPEN_PLATFORM", 39, "interactive_open_platform");
            OPEN_PLATFORM = r139;
            EventModule r140 = new EventModule("PLAYER", 40, "palyer");
            PLAYER = r140;
            EventModule r141 = new EventModule("PREVIEW", 41, "preview");
            PREVIEW = r141;
            EventModule r142 = new EventModule("GAME_LIVE", 42, "game_live");
            GAME_LIVE = r142;
            EventModule r143 = new EventModule("LIVE_MESSAGE", 43, "live_message");
            LIVE_MESSAGE = r143;
            EventModule r144 = new EventModule("SETTING", 44, "setting");
            SETTING = r144;
            EventModule r145 = new EventModule("FRIEND_ROOM_BASE", 45, "friend_room_base");
            FRIEND_ROOM_BASE = r145;
            EventModule r146 = new EventModule("FRIEND_ROOM_COMMON", 46, "friend_room_common");
            FRIEND_ROOM_COMMON = r146;
            EventModule r147 = new EventModule("SHORT_VIDEO", 47, UGCMonitor.TYPE_SHORT_VIDEO);
            SHORT_VIDEO = r147;
            EventModule r148 = new EventModule("GAME_PROMOTE", 48, "cooperation_partner");
            GAME_PROMOTE = r148;
            EventModule r149 = new EventModule("GAME_PLAY_TOGETHER", 49, "game_play_together");
            GAME_PLAY_TOGETHER = r149;
            EventModule r150 = new EventModule("LIVE_CORE", 50, "livecore");
            LIVE_CORE = r150;
            EventModule r151 = new EventModule("hybrid", 51, "hybrid");
            hybrid = r151;
            EventModule r152 = new EventModule("LIVE_GIFT", 52, "live_gift");
            LIVE_GIFT = r152;
            EventModule r153 = new EventModule("ENTER_ANIM", 53, "enter_anim");
            ENTER_ANIM = r153;
            EventModule r154 = new EventModule("LIVE_PROFIT", 54, "live_profit");
            LIVE_PROFIT = r154;
            EventModule r155 = new EventModule("INNER_DRAW", 55, "inner_draw");
            INNER_DRAW = r155;
            EventModule r156 = new EventModule("PCDN", 56, FeatureManager.PCDN);
            PCDN = r156;
            EventModule r157 = new EventModule("LIVE_ROOM_OBSERVER", 57, "live_room_observer");
            LIVE_ROOM_OBSERVER = r157;
            EventModule r158 = new EventModule("STRATEGY", 58, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
            STRATEGY = r158;
            EventModule r159 = new EventModule("AUDIO", 59, "audio");
            AUDIO = r159;
            EventModule r160 = new EventModule("DRESS", 60, "dress");
            DRESS = r160;
            EventModule r161 = new EventModule("DANMAKU", 61, "danmaku");
            DANMAKU = r161;
            EventModule r162 = new EventModule("COMMENT", 62, "comment");
            COMMENT = r162;
            EventModule r163 = new EventModule("PIN_COMMENT", 63, "pin_comment");
            PIN_COMMENT = r163;
            EventModule r164 = new EventModule("TEXT_RENDER_ENGINE", 64, "text_render_engine");
            TEXT_RENDER_ENGINE = r164;
            EventModule r165 = new EventModule("FANS_CLUB", 65, PbRequest.SwitchType.FANS_CLUB);
            FANS_CLUB = r165;
            EventModule r166 = new EventModule("SUBSCRIBE_VIP", 66, "subscribe_vip");
            SUBSCRIBE_VIP = r166;
            EventModule r167 = new EventModule("PRIVILEGE_INFO", 67, "privilege_info");
            PRIVILEGE_INFO = r167;
            EventModule r168 = new EventModule("PAY_GRADE", 68, "pay_grade");
            PAY_GRADE = r168;
            EventModule r169 = new EventModule("GIFT_PANEL_TOUCH", 69, "gift_panel_touch");
            GIFT_PANEL_TOUCH = r169;
            EventModule r170 = new EventModule("PRIVILEGE_DANMAKU", 70, "privilege_danmaku");
            PRIVILEGE_DANMAKU = r170;
            EventModule r171 = new EventModule("AUDIENCE", 71, SourceType.DEFAULT);
            AUDIENCE = r171;
            EventModule r172 = new EventModule("MSG_WINDOW_CARD", 72, "msg_window_card");
            MSG_WINDOW_CARD = r172;
            EventModule r173 = new EventModule("COMMON_CARD", 73, "common_card");
            COMMON_CARD = r173;
            EventModule r174 = new EventModule("GAME_ORDER", 74, "game_order");
            GAME_ORDER = r174;
            EventModule r175 = new EventModule("PREDICTOR_PLAYING", 75, "predictor_playing");
            PREDICTOR_PLAYING = r175;
            EventModule r176 = new EventModule("ROOM_BATTLE", 76, "room_battle");
            ROOM_BATTLE = r176;
            EventModule r177 = new EventModule("TEAM_FIGHT", 77, "team_fight");
            TEAM_FIGHT = r177;
            EventModule r178 = new EventModule("GUEST_BATTLE", 78, "guest_battle");
            GUEST_BATTLE = r178;
            EventModule r179 = new EventModule("ADVENTURE", 79, "adventure");
            ADVENTURE = r179;
            EventModule r180 = new EventModule("DANMU_GAME", 80, "danmu_game");
            DANMU_GAME = r180;
            EventModule r181 = new EventModule("INTERACT_XPLAY", 81, "interact_xplay");
            INTERACT_XPLAY = r181;
            EventModule r182 = new EventModule("MULTI_LINK_DYNAMIC", 82, "multi_link_dynamic");
            MULTI_LINK_DYNAMIC = r182;
            EventModule r183 = new EventModule("MULTI_LINK_GIFT", 83, "multi_link_gift");
            MULTI_LINK_GIFT = r183;
            EventModule r184 = new EventModule("FEED", 84, "feed");
            FEED = r184;
            EventModule r185 = new EventModule("FEED_TAB", 85, "feed_tab");
            FEED_TAB = r185;
            EventModule r186 = new EventModule("SWITCH_RESOLUTION", 86, "switch_resolution");
            SWITCH_RESOLUTION = r186;
            EventModule r187 = new EventModule("WRDS", 87, "wrds");
            WRDS = r187;
            EventModule r188 = new EventModule("CHAT_CHANNEL", 88, "chat_channel");
            CHAT_CHANNEL = r188;
            EventModule r189 = new EventModule("MULTI_TAB", 89, "multi_tab");
            MULTI_TAB = r189;
            EventModule r190 = new EventModule("ANCHOR_ASR", 90, "anchor_asr");
            ANCHOR_ASR = r190;
            EventModule r191 = new EventModule("AI_CLONE", 91, "ai_clone");
            AI_CLONE = r191;
            EventModule r192 = new EventModule("PERSONALIZED_CHANNEL", 92, "personalized_channel");
            PERSONALIZED_CHANNEL = r192;
            EventModule r193 = new EventModule("INPUT_PANEL", 93, "input_panel");
            INPUT_PANEL = r193;
            EventModule r194 = new EventModule("IMAGE_RECOGNITION", 94, "image_recognition");
            IMAGE_RECOGNITION = r194;
            EventModule r195 = new EventModule("CLOUD_GAME", 95, "cloud_game");
            CLOUD_GAME = r195;
            EventModule r196 = new EventModule("XPLAY", 96, "xplay");
            XPLAY = r196;
            EventModule r197 = new EventModule("MATCH_TRAY", 97, "match_tray");
            MATCH_TRAY = r197;
            EventModule r198 = new EventModule("PAID_LINK_MIC", 98, "paid_linkmic");
            PAID_LINK_MIC = r198;
            EventModule r199 = new EventModule("CLEAR_SCREEN", 99, "clear_screen");
            CLEAR_SCREEN = r199;
            EventModule r200 = new EventModule("OPEN_ASSET", 100, IPerformanceManager.MODULE_OPEN_ASSET);
            OPEN_ASSET = r200;
            EventModule r201 = new EventModule("INTERACTIVITY_DEGRADE", 101, "interactivity_degrade");
            INTERACTIVITY_DEGRADE = r201;
            EventModule r202 = new EventModule("USER_ENTER", 102, IPerformanceManager.MODULE_USER_ENTER);
            USER_ENTER = r202;
            EventModule r203 = new EventModule("SHORT_TOUCH", 103, "short_touch");
            SHORT_TOUCH = r203;
            EventModule r204 = new EventModule("INTERACTION", 104, "interaction");
            INTERACTION = r204;
            EventModule r205 = new EventModule("BANNER", 105, "banner");
            BANNER = r205;
            EventModule r206 = new EventModule("BACKEND", 106, "backend");
            BACKEND = r206;
            f64910a = new EventModule[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206};
        }

        public static EventModule[] values() {
            return (EventModule[]) f64910a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static EventModule valueOf(String r100) {
            return (EventModule) a.a(EventModule.class, r100);
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
        public static final /* synthetic */ EventType[] f64912a = null;
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
            f64912a = new EventType[]{r100, r101, r102, r103, r104};
        }

        public static EventType[] values() {
            return (EventType[]) f64912a.clone();
        }

        public String getName() {
            return this.mName;
        }

        public static EventType valueOf(String r100) {
            return (EventType) a.a(EventType.class, r100);
        }

        public EventType(String r100, int r101, String r102) {
            super(r100, r101);
            this.mName = r102;
        }
    }

    static {
        Boolean r100 = Boolean.FALSE;
        f64909a = new SettingKey("live_sdk_enable_dolphin_platform_test_key", "dolphin平台精准熔断演练", r100, r100);
    }

    public static EventModule b(int r100) {
        if (r100 != 1) goto L7;
        return EventModule.PK;
    L7:
        if (r100 != 17) goto L11;
        return EventModule.MEDIA_MULTI_LINKER;
    L11:
        if (r100 != 14) goto L15;
        return EventModule.SCREEN_LINKER;
    L15:
        return EventModule.MULTI_LINKER;
    }

    public static void a(String r100, Throwable r101, String r102) {
        d.f(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ALogger.e("ensureNotReachHere", "error occur!", th);
    }

    public static void l(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
    }

    public static void d(String r100, EventModule r101, EventType r102, JSONObject r103) {
        e(r100, r101, r102, null, null, r103);
    }

    public static void h(String r100, JSONObject r101, JSONObject r102, JSONObject r110) {
        if (((IHostMonitor) BaseServices.as(IHostMonitor.class)) != null) goto L6;
        return;
    L6:
        if (r100.startsWith("ttlive_") == true) goto L8;
        r100 = "ttlive_".concat(r100);
    L8:
        l(r110, "event_source", "live_platform_client");
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
        l(r103, "tag", "ttlive_sdk");     // Catch: Exception -> L23
        l(r103, "ttlive_sdk_version", String.valueOf(c.b()));     // Catch: Exception -> L23
    L25:
        int r111 = j.f566215a;
        b r112 = om0.c.j();
        if (r112 == null) goto L34;
        r112.monitorEvent(r100, r101, r102, r103);
        return;
    L34:
        return;
    L23:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L25
    }

    public static void i(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (((IHostMonitor) BaseServices.as(IHostMonitor.class)) != null) goto L6;
        return;
    L6:
        if (h.a(r100) == false) goto L8;
        return;
    L8:
        if (r103 != null) goto L11;
        r103 = new JSONObject();
    L11:
        if (r100.startsWith("ttlive_") == true) goto L13;
        r100 = "ttlive_".concat(r100);
    L13:
        l(r103, "tag", "ttlive_sdk");
        l(r103, "ttlive_sdk_version", String.valueOf(c.b()));
        int r104 = j.f566215a;
        b r105 = om0.c.j();
        if (r105 == null) goto L17;
        r105.monitorEvent(r100, r101, r102, r103);
        return;
    }

    public static void j(String r100, EventModule r101, int r102, JSONObject r110) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r103.put("status_code", r102);     // Catch: JSONException -> L8
    L10:
        e(r100, r101, EventType.BUSSINESS_API_CALL, r103, r104, r110);
        return;
    L8:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L10
    }

    public static void f(String r100, EventModule r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        if (r104 != null) goto L7;
        r104 = new JSONObject();
    L7:
        l(r104, "event_module", r101.getName());
        l(r104, "event_type", EventType.BUSSINESS_API_CALL.getName());
        h(r100, r102, r103, r104);
    }

    public static void e(String r100, EventModule r101, EventType r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        if (r105 != null) goto L7;
        r105 = new JSONObject();
    L7:
        l(r105, "event_module", r101.getName());
        l(r105, "event_type", r102.getName());
        h(r100, r103, r104, r105);
    }

    public static void g(String r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        if (r105 != null) goto L7;
        r105 = new JSONObject();
    L7:
        l(r105, "event_module", r101);
        l(r105, "event_type", r102);
        h(r100, r103, r104, r105);
    }

    public static void k(String r100, EventModule r101, long r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        if (h.a(r100) == false) goto L6;
        return;
    L6:
        if (r102 > 0) goto L14;
    L12:
        l(r105, "event_module", r101.getName());
        l(r105, "event_type", EventType.BUSSINESS_API_CALL.getName());
        h(r100, r103, r104, r105);
        return;
    L14:
        r104.put("latency", r102);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        Logger.e("LiveLinkSlardarMonitor", e.getMessage());
        goto L12
    }

    public static void c(String r100, EventModule r101, EventType r102, int r103, String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        if (h.a(r100) == false) goto L5;
        return;
    L5:
        if (r113 != null) goto L7;
        r113 = new JSONObject();
    L7:
        JSONObject r104 = r113;
        l(r104, "status_code", String.valueOf(r103));
        l(r104, "status_msg", String.valueOf(r110));
        e(r100, r101, r102, r111, r112, r104);
    }
}
