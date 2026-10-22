package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.util.SparseArray;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final enum ToolbarButton extends Enum<ToolbarButton> implements a2 {
    private static final /* synthetic */ ToolbarButton[] $VALUES = null;
    public static final ToolbarButton ACTIVITY_ZONE = null;
    public static final ToolbarButton ADD_PICTURE = null;
    public static final ToolbarButton ADVANCE_ANNOUNCEMENT = null;
    public static final ToolbarButton AIRDROP_GIFT = null;
    public static final ToolbarButton ANCHOR_BACKTRACK = null;
    public static final ToolbarButton ANCHOR_CHAT_CHANNEL = null;
    public static final ToolbarButton ANCHOR_SHOW = null;
    public static final ToolbarButton ASSEMBLED_SETTING = null;
    public static final ToolbarButton ATTACK_AND_DEFENSE = null;
    public static final ToolbarButton AUDIENCE_LANDSCAPE = null;
    public static final ToolbarButton AUDIENCE_PUBLIC_SCREEN_CONFIG = null;
    public static final ToolbarButton AUDIENCE_RECORD = null;
    public static final ToolbarButton AUDIENCE_RESOLUTION = null;
    public static final ToolbarButton AUDIO = null;
    public static final ToolbarButton AUDIO_COMMENT = null;
    public static final ToolbarButton AUDIO_SUBTITLE_SETTING = null;
    public static final ToolbarButton AUDIO_TOGGLE = null;
    public static final ToolbarButton AUTO_CAR = null;
    public static final ToolbarButton AUTO_REPLY = null;
    public static final ToolbarButton AV_ADJUST = null;
    public static final ToolbarButton BARRAGE = null;
    public static final ToolbarButton BARRAGE_SETTING = null;
    public static final ToolbarButton BEAUTY = null;
    public static final ToolbarButton BGM = null;
    public static final ToolbarButton BLOCK = null;
    public static final ToolbarButton BLOCK_MEDIA = null;
    public static final ToolbarButton BROADCAST_ADMIN = null;
    public static final ToolbarButton BROADCAST_BARRAGE = null;
    public static final ToolbarButton BROADCAST_EFFECT = null;
    public static final ToolbarButton BROADCAST_GIFT = null;
    public static final ToolbarButton BROADCAST_INFO = null;
    public static final ToolbarButton BROADCAST_PAUSE = null;
    public static final ToolbarButton BROADCAST_RESTART = null;
    public static final ToolbarButton BROADCAST_SHARE = null;
    public static final ToolbarButton BROADCAST_TASK = null;
    public static final ToolbarButton CAMERA_MOVEMENT = null;
    public static final ToolbarButton CASH_EXCHANGE = null;
    public static final ToolbarButton CAST_FEED_BACK = null;
    public static final ToolbarButton CAST_REFRESH = null;
    public static final ToolbarButton CAST_SCREEN = null;
    public static final ToolbarButton CAST_SCREEN_FEED_BACK = null;
    public static final ToolbarButton CAST_SCREEN_MORE_PANEL = null;
    public static final ToolbarButton CAST_SCREEN_REFRESH = null;
    public static final ToolbarButton CHANNEL_COMMENT = null;
    public static final ToolbarButton CHAT_CHANNEL_LANDSCAPE = null;
    public static final ToolbarButton CLEAR_SCREEN = null;
    public static final ToolbarButton CLEAR_SCREEN_OPTIMIZE_OFF = null;
    public static final ToolbarButton CLEAR_SCREEN_OPTIMIZE_ON = null;
    public static final ToolbarButton CLOSE_ROOM = null;
    public static final ToolbarButton COLLECT = null;
    public static final ToolbarButton COMMENT = null;
    public static final ToolbarButton COMMERCE = null;
    public static final ToolbarButton COMMERCE_IM = null;
    public static final ToolbarButton COMMERCE_LIVE_AD = null;
    public static final ToolbarButton COMMERCE_MORE = null;
    public static final ToolbarButton COPY_LINK = null;
    public static final ToolbarButton COUPON_EXCHANGE = null;
    public static final ToolbarButton DECORATION = null;
    public static final ToolbarButton DESKTOP_WIDGET_PIN_ANCHOR = null;
    public static final ToolbarButton DESKTOP_WIDGET_UNPIN_ANCHOR = null;
    public static final ToolbarButton DISLIKE = null;
    public static final ToolbarButton DIVIDER = null;
    public static final ToolbarButton DOUYIN_CLOSE = null;
    public static final ToolbarButton DOUYIN_GAME = null;
    public static final ToolbarButton DOUYIN_OFFICIAL_EFFECT = null;
    public static final ToolbarButton DOUYIN_OFFICIAL_IMMERSE = null;
    public static final ToolbarButton DOUYIN_OFFICIAL_QUALITY = null;
    public static final ToolbarButton DOU_PLUS_PROMOTE = null;
    public static final ToolbarButton DOU_PLUS_PROMOTE_AUDIENCE = null;
    public static final ToolbarButton DRIVE = null;
    public static final ToolbarButton DUTY_GIFT = null;
    public static final ToolbarButton EASTER_EGG = null;
    public static final ToolbarButton FAN_GROUP_MANAGE = null;
    public static final ToolbarButton FAST_GIFT = null;
    public static final ToolbarButton FILTER = null;
    public static final ToolbarButton FLOW_FEEDBACK = null;
    public static final ToolbarButton FNA_GROUP = null;
    public static final ToolbarButton FollowerShare = null;
    public static final ToolbarButton GAME_CAST_SCREEN = null;
    public static final ToolbarButton GAME_EXIT = null;
    public static final ToolbarButton GAME_GUESS = null;
    public static final ToolbarButton GAME_PROMOTE = null;
    public static final ToolbarButton GAME_PROMOTE_AUDIENCE = null;
    public static final ToolbarButton GAME_PROMOTE_AUDIENCE_MORE = null;
    public static final ToolbarButton GAME_PROMOTE_MORE = null;
    public static final ToolbarButton GAME_QUIZ = null;
    public static final ToolbarButton GESTURE_MAGIC = null;
    public static final ToolbarButton GIFT = null;
    public static final ToolbarButton GIFT_ANIMATION = null;
    public static final ToolbarButton GIFT_CONSUMER_TOAST = null;
    public static final ToolbarButton GIFT_EFFECT = null;
    public static final ToolbarButton GROUP_PURCHASE = null;
    public static final ToolbarButton GROUP_PURCHASE_AUDIENCE = null;
    public static final ToolbarButton GROUP_PURCHASE_MORE = null;
    public static final ToolbarButton GUARD_BOX = null;
    public static final ToolbarButton GUEST_BATTLE_ADMIN = null;
    public static final ToolbarButton HASH_TAG = null;
    public static final ToolbarButton HOTSOON_PROMOTION = null;
    public static final ToolbarButton HOUR_RANK = null;
    public static final ToolbarButton IM_LIST_VIRTUAL = null;
    public static final ToolbarButton INCOME_MORE = null;
    public static final ToolbarButton INNER_SMALL_WINDOW_ACTION_BUTTON = null;
    public static final ToolbarButton INTERACTION = null;
    public static final ToolbarButton INTERACTION_AUDIENCE = null;
    public static final ToolbarButton INTERACTION_MORE = null;
    public static final ToolbarButton INTERACTION_ROOM = null;
    public static final ToolbarButton INTERACTION_ROOM_BATTLE = null;
    public static final ToolbarButton INTERACTION_SCENE = null;
    public static final ToolbarButton INTERACT_GAME = null;
    public static final ToolbarButton INTERACT_GAME_EXIT = null;
    public static final ToolbarButton INTERACT_GIFT = null;
    public static final ToolbarButton INTERACT_PLAY = null;
    public static final ToolbarButton INTERACT_PLAY_FOR_GROUP_LIVE_GAME = null;
    public static final ToolbarButton IN_ROOM_RESOLUTION = null;
    public static final ToolbarButton KEY_ROOM_INFO = null;
    public static final ToolbarButton KTV = null;
    public static final ToolbarButton KTV_GROUP = null;
    public static final ToolbarButton LANDSCAPE_MULTI_TAB = null;
    public static final ToolbarButton LICENSE_INFO = null;
    public static final ToolbarButton LIKE_FEEDBACK = null;
    public static final ToolbarButton LINKMIC_ANNOUNCE = null;
    public static final ToolbarButton LINKMIC_GAME = null;
    public static final ToolbarButton LINKMIC_SETTING = null;
    public static final ToolbarButton LITTLE_GAME = null;
    public static final ToolbarButton LITTLE_PLUGIN = null;
    public static final ToolbarButton LIVE_CONTENT = null;
    public static final ToolbarButton LIVE_FLOAT_WINDOW_PLAY = null;
    public static final ToolbarButton LIVE_IM_ENTRANCE = null;
    public static final ToolbarButton LIVE_IM_ENTRANCE_MORE = null;
    public static final ToolbarButton LIVE_LISTEN = null;
    public static final ToolbarButton LIVE_MATRIX = null;
    public static final ToolbarButton LIVE_MULTI_CAMERA = null;
    public static final ToolbarButton LIVE_PICTURE_PRESENTATION = null;
    public static final ToolbarButton LIVE_PICTURE_TYPE = null;
    public static final ToolbarButton LIVE_WIDGET = null;
    public static final ToolbarButton LIVING_DRAINAGE = null;
    public static final ToolbarButton LOTTERY = null;
    public static final ToolbarButton MANAGE = null;
    public static final ToolbarButton MANAGE_UNFOLD = null;
    public static final ToolbarButton MARKETING_WIDGET_PIN_BUTTON = null;
    public static final ToolbarButton MATCH_ROOM_MOMENT = null;
    public static final ToolbarButton MATCH_ROOM_MULTI_CAMERA = null;
    public static final ToolbarButton MERCHANT_QUALIFICATIONS = null;
    public static final ToolbarButton MESSAGE_BOX = null;
    public static final ToolbarButton MESSAGE_PUSH = null;
    public static final ToolbarButton MINI_APP = null;
    public static final ToolbarButton MINI_APP_MORE = null;
    public static final ToolbarButton MINOR_REFUND = null;
    public static final ToolbarButton MORE = null;
    public static final ToolbarButton MULTI_CAMERA = null;
    public static final ToolbarButton MULTI_CAMERA_LINKED_ROOM = null;
    public static final ToolbarButton MULTI_SCENE_GAME_PLAY = null;
    public static final ToolbarButton OPEN_PLATFORM_GAME = null;
    public static final ToolbarButton OPEN_PLATFORM_LYNX_GAME = null;
    public static final ToolbarButton OPEN_PLATFORM_MINI_APP = null;
    public static final ToolbarButton OPEN_PLATFORM_MINI_APP_MORE = null;
    public static final ToolbarButton OPEN_PLATFORM_MINI_GAME = null;
    public static final ToolbarButton PAD_AND_PC_PLAY = null;
    public static final ToolbarButton PAD_AND_PC_PLAY_LANDSCAPE = null;
    public static final ToolbarButton PERMANENT_CHAT_GUEST = null;
    public static final ToolbarButton PERMANENT_CHAT_ROOM = null;
    public static final ToolbarButton PK = null;
    public static final ToolbarButton PLAY_QUALITY_OPT = null;
    public static final ToolbarButton PLAY_SETTING = null;
    public static final ToolbarButton POI = null;
    public static final ToolbarButton PREDICTOR_GUESS = null;
    public static final ToolbarButton PROMOTION_CARD = null;
    public static final ToolbarButton PROMOTION_VIDEO = null;
    public static final ToolbarButton PROMPT = null;
    public static final ToolbarButton PUBLIC_SCREEN_AI_HELPER = null;
    public static final ToolbarButton PUBLIC_SCREEN_CONFIG = null;
    public static final ToolbarButton PUBLIC_SCREEN_SELECTED_MESSAGE = null;
    public static final ToolbarButton PUSH_URL = null;
    public static final ToolbarButton QR_CODE = null;
    public static final ToolbarButton QUESTION_AND_ANSWER = null;
    public static final ToolbarButton QUICK_SCREEN_SHOT = null;
    public static final ToolbarButton RADIO_COVER = null;
    public static final ToolbarButton RADIO_INTERACTION_AUDIENCE = null;
    public static final ToolbarButton RECHARGE_RECORD = null;
    public static final ToolbarButton RECORD = null;
    public static final ToolbarButton RECORD_COMBINE = null;
    public static final ToolbarButton RECORD_LANDSCAPE = null;
    public static final ToolbarButton RED_ENVELOPE = null;
    public static final ToolbarButton REN_QI_BAO = null;
    public static final ToolbarButton REPLAY_CAST_SCREEN = null;
    public static final ToolbarButton REPLAY_CAST_SCREEN_FEED_BACK = null;
    public static final ToolbarButton REPLAY_CHOOSE = null;
    public static final ToolbarButton REPLAY_TICKET_SALE = null;
    public static final ToolbarButton REPORT = null;
    public static final ToolbarButton REVERSE_CAMERA = null;
    public static final ToolbarButton REVERSE_MIRROR = null;
    public static final ToolbarButton REVOKE_AUTH = null;
    public static final ToolbarButton ROOM_CHANNEL = null;
    public static final ToolbarButton ROOM_CHANNEL_LANDSCAPE = null;
    public static final ToolbarButton ROOM_FIGHT_ADMIN = null;
    public static final ToolbarButton ROOM_INTRO = null;
    public static final ToolbarButton ROOM_NOTICE = null;
    public static final ToolbarButton SCHEDULE_CLOSE = null;
    public static final ToolbarButton SHAKE_MATCH_SETTING = null;
    public static final ToolbarButton SHARE = null;
    public static final ToolbarButton SHARE_TO_DAILY = null;
    public static final ToolbarButton SMALL_WINDOW_ACTION_BUTTON = null;
    public static final ToolbarButton SOUND_EFFECT = null;
    public static final ToolbarButton SQUARE_COMMENT = null;
    public static final ToolbarButton STABLE_MODE = null;
    public static final ToolbarButton STAR_GRAPH = null;
    public static final ToolbarButton STICKER = null;
    public static final ToolbarButton STICKER_NEW = null;
    public static final ToolbarButton SWITCH_ACCOUNT = null;
    public static final ToolbarButton SWITCH_SCREEN_ORIENTATION = null;
    public static final ToolbarButton SWITCH_VIDEO_QUALITY = null;
    public static final ToolbarButton SWITCH_VIDEO_QUALITY_MATCH = null;
    public static final ToolbarButton TASK_CENTER = null;
    public static final ToolbarButton TEAM_FIGHT = null;
    public static final ToolbarButton TEAM_FIGHT_ADMIN = null;
    public static final ToolbarButton TICKET_SALE = null;
    public static final ToolbarButton TICKET_SALE_ANCHOR = null;
    public static final ToolbarButton TICKET_SALE_ANCHOR_MORE = null;
    public static final ToolbarButton TOUTIAO_FLOAT_WINDOW = null;
    public static final ToolbarButton TRANSFORM_WIDGET = null;
    public static final ToolbarButton TRANSFORM_WIDGET_AUDIENCE_MORE = null;
    public static final ToolbarButton TRANSFORM_WIDGET_MORE = null;
    public static final ToolbarButton TREASURE_BOX = null;
    public static final ToolbarButton TURNTABLE_V2 = null;
    public static final ToolbarButton UNION_LIVE = null;
    public static final ToolbarButton VIDEO_PLAY = null;
    public static final ToolbarButton VIP_IM = null;
    public static final ToolbarButton VIRTUAL_LIVE = null;
    public static final ToolbarButton VOICE_LIVE_THEME = null;
    public static final ToolbarButton VOTE = null;
    public static final ToolbarButton VR_MODE = null;
    public static final ToolbarButton VS_ACTIVITY_ONE = null;
    public static final ToolbarButton VS_ACTIVITY_THREE = null;
    public static final ToolbarButton VS_ACTIVITY_TWO = null;
    public static final ToolbarButton VS_BARRAGE_KEY_FILTER = null;
    public static final ToolbarButton VS_BARRAGE_SETTING = null;
    public static final ToolbarButton VS_CACHE = null;
    public static final ToolbarButton VS_CART = null;
    public static final ToolbarButton VS_CAST_SCREEN = null;
    public static final ToolbarButton VS_COLLECT = null;
    public static final ToolbarButton VS_DELETE = null;
    public static final ToolbarButton VS_FAST_PLAY = null;
    public static final ToolbarButton VS_FLOAT_WINDOW = null;
    public static final ToolbarButton VS_GIFT_CONSUMER_TOAST = null;
    public static final ToolbarButton VS_HIGHLIGHT = null;
    public static final ToolbarButton VS_INTERACTIVE = null;
    public static final ToolbarButton VS_LANDSCAPE_MORE = null;
    public static final ToolbarButton VS_LANDSCAPE_OPERATION = null;
    public static final ToolbarButton VS_MESSAGE_BOARD = null;
    public static final ToolbarButton VS_MORE_LIVE_ENTRY = null;
    public static final ToolbarButton VS_ONLY_TA = null;
    public static final ToolbarButton VS_ONLY_TA_LANDSCAPE = null;
    public static final ToolbarButton VS_PORTRAIT_LOCK = null;
    public static final ToolbarButton VS_PORTRAIT_MORE = null;
    public static final ToolbarButton VS_PORTRAIT_OPERATION = null;
    public static final ToolbarButton VS_PORTRAIT_TOP_MORE = null;
    public static final ToolbarButton VS_RECORD_PORTAIT_DAMAKU_ENABLE = null;
    public static final ToolbarButton VS_REPORT = null;
    public static final ToolbarButton VS_SCHEDULE_CLOSE = null;
    public static final ToolbarButton VS_SELECT_EPISODE = null;
    public static final ToolbarButton VS_SHARE = null;
    public static final ToolbarButton VS_SHARE_UNFOLD = null;
    public static final ToolbarButton VS_TEDIOUS = null;
    public static final ToolbarButton VS_TOPIC_OPERATION = null;
    public static final ToolbarButton VS_VERTICAL_RESOLUTION = null;
    public static final ToolbarButton VS_VIDEO_QUALITY = null;
    public static final ToolbarButton VS_VISIBILITY_SETTING = null;
    public static final ToolbarButton WATCH_LATER = null;
    public static final ToolbarButton WELFARE = null;
    public static final ToolbarButton WELFARE_FOLD = null;
    public static final ToolbarButton WISH_LIST = null;
    public static final ToolbarButton XT_GAMELIVE_INTERACTION = null;
    public static final ToolbarButton XT_LANDSCAPE_SHARE = null;
    private static Map<String, ToolbarButton> nameEnumMap;
    private int broadcastDrawableFolded;
    private int broadcastDrawableUnfolded;
    private int broadcastLayoutId;
    private int broadcastTitleId;
    private int drawableFolded;
    private int drawableUnfolded;
    private int layoutId;
    private boolean pureText;
    private long serverId;
    private int titleId;
    private String titleStr;
    private boolean useStandardLayout;
    private k4 vsToolbarExtendProperty;

    private static int getInteractSceneDrawable() {
        if (j40.u.f497304a.getValue().booleanValue() == false) goto L6;
        return R.drawable.ttlive_ic_interact_link_mode;
    L6:
        return R.drawable.ttlive_ic_interact_scene;
    }

    private static int getTicketSaleIcon() {
        if (j40.h4.f497235a.getValue().booleanValue() == false) goto L6;
        return R.drawable.live_toolbar_ic_v2_ticketsale_static;
    L6:
        return R.drawable.ttlive_ic_ticket_sale_new;
    }

    public static ToolbarButton[] values() {
        return (ToolbarButton[]) $VALUES.clone();
    }

    public ExtendedToolbarButton extended() {
        ExtendedToolbarButton.f115618h.getClass();
        return ExtendedToolbarButton.a.a(this);
    }

    public int getBroadcastDrawableFolded() {
        int r100 = this.broadcastDrawableFolded;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.drawableFolded;
    }

    public int getBroadcastDrawableUnfolded() {
        int r100 = this.broadcastDrawableUnfolded;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.drawableUnfolded;
    }

    public int getBroadcastLayoutId() {
        int r100 = this.broadcastLayoutId;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.layoutId;
    }

    public int getBroadcastTitleId() {
        int r100 = this.broadcastTitleId;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.titleId;
    }

    public String getTag() {
        return ToolbarButton.class.getName();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public String debugName() {
        return name();
    }

    static {
        int r100 = 0;
        VS_LANDSCAPE_MORE = new ToolbarButton("VS_LANDSCAPE_MORE", 0, R.layout.ttlive_vs_view_toolbar_more, R.layout.ttlive_vs_view_toolbar_more);
        VS_PORTRAIT_TOP_MORE = new ToolbarButton("VS_PORTRAIT_TOP_MORE", 1, R.layout.ttlive_vs_view_toolbar_more, R.layout.ttlive_vs_view_toolbar_more);
        VS_PORTRAIT_MORE = new ToolbarButton("VS_PORTRAIT_MORE", 2, R.drawable.ttlive_vs_portrait_more, R.drawable.ttlive_vs_portrait_more, R.string.ttlive_a11y_toolbar_more);
        VS_SELECT_EPISODE = new ToolbarButton("VS_SELECT_EPISODE", 3, 0, 0, R.string.ttlive_vs_select_episode);
        VS_VIDEO_QUALITY = new ToolbarButton("VS_VIDEO_QUALITY", 4, 0, 0, R.string.ttlive_vs_origin_texture);
        REPLAY_CHOOSE = new ToolbarButton("REPLAY_CHOOSE", 5, 0, 0, R.string.ttlive_replay_tab);
        VS_FAST_PLAY = new ToolbarButton("VS_FAST_PLAY", 6, R.drawable.ttlive_vs_fast_play, R.drawable.ttlive_vs_fast_play, R.string.ttlive_vs_fast_play);
        VS_ONLY_TA = new ToolbarButton("VS_ONLY_TA", 7, R.drawable.ttlive_vs_only_ta, R.drawable.ttlive_vs_only_ta, R.string.ttlive_vs_only_watch_ta);
        VS_ONLY_TA_LANDSCAPE = new ToolbarButton("VS_ONLY_TA_LANDSCAPE", 8, R.layout.ttlive_vs_toolbar_only_ta_landscape, R.layout.ttlive_vs_toolbar_only_ta_landscape);
        VS_PORTRAIT_LOCK = new ToolbarButton("VS_PORTRAIT_LOCK", 9, R.drawable.ttlive_vs_portrait_lock, R.drawable.ttlive_vs_portrait_lock, R.string.ttlive_vs_lock);
        VS_HIGHLIGHT = new ToolbarButton("VS_HIGHLIGHT", 10, 0, 0, R.string.ttlive_vs_highlight);
        VS_TEDIOUS = new ToolbarButton("VS_TEDIOUS", 11, R.drawable.ttlive_vs_tedious, R.drawable.ttlive_vs_tedious, R.string.ttlive_dislike, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_tedious_toolbar_portrait), null));
        VS_SCHEDULE_CLOSE = new ToolbarButton("VS_SCHEDULE_CLOSE", 12, R.drawable.ttlive_vs_schedule_close_portrait, R.drawable.ttlive_vs_schedule_close_portrait, R.string.ttlive_vs_schedule_close, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_schedule_close_portrait), null));
        VS_FLOAT_WINDOW = new ToolbarButton("VS_FLOAT_WINDOW", 13, R.drawable.ttlive_vs_ic_float_window_switch_landscape, R.drawable.ttlive_vs_ic_float_window_switch_landscape, R.string.ttlive_vs_float_window, new k4(Integer.valueOf(R.drawable.ttlive_vs_ic_float_window_switch), Integer.valueOf(R.string.ttlive_vs_float_window), Integer.valueOf(R.drawable.ttlive_vs_ic_float_window_switch_2), null));
        Integer r101 = Integer.valueOf(R.drawable.ttlive_vs_collect_toolbar_portrait);
        VS_COLLECT = new ToolbarButton("VS_COLLECT", 14, R.drawable.ttlive_vs_collection, R.drawable.ttlive_vs_collection, R.string.ttlive_vs_collection, new k4(null, null, r101, null));
        VS_CACHE = new ToolbarButton("VS_CACHE", 15, R.drawable.ttlive_vs_cache_video, R.drawable.ttlive_vs_cache_video, R.string.ttlive_vs_cache_video, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_cache_portrait), null));
        VS_VISIBILITY_SETTING = new ToolbarButton("VS_VISIBILITY_SETTING", 16, 0, 0, R.string.ttlive_vs_setting, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_setting_toolbar_portrait), null));
        VS_DELETE = new ToolbarButton("VS_DELETE", 17, 0, 0, R.string.ttlive_vs_delete, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_delete_toolbar_portrait), null));
        VS_CAST_SCREEN = new ToolbarButton("VS_CAST_SCREEN", 18, 0, 0, R.string.ttlive_vs_projection_screen, new k4(Integer.valueOf(R.drawable.ttlive_icon_vs_landscape_castscreen), null, Integer.valueOf(R.drawable.ttlive_icon_vs_portrait_castscreen), null));
        CAST_FEED_BACK = new ToolbarButton("CAST_FEED_BACK", 19, R.drawable.cast_feedback_landscape_ic, R.drawable.cast_feedback_landscape_ic, R.string.ttlive_cast_feed_back);
        CAST_REFRESH = new ToolbarButton("CAST_REFRESH", 20, R.drawable.cast_refresh_landscape_ic, R.drawable.cast_refresh_landscape_ic, R.string.ttlive_cast_refresh);
        VS_TOPIC_OPERATION = new ToolbarButton("VS_TOPIC_OPERATION", 21, R.layout.ttlive_view_toolbar_stable_topic);
        VS_PORTRAIT_OPERATION = new ToolbarButton("VS_PORTRAIT_OPERATION", 22, R.layout.ttlive_view_toolbar_operation, R.string.ttlive_vs_activity_operation, new k4());
        VS_LANDSCAPE_OPERATION = new ToolbarButton("VS_LANDSCAPE_OPERATION", 23, 0, 0, R.string.ttlive_vs_activity_operation, new k4());
        VS_ACTIVITY_ONE = new ToolbarButton("VS_ACTIVITY_ONE", 24, 0, 0, R.string.ttlive_vs_activity_one, new k4());
        VS_ACTIVITY_TWO = new ToolbarButton("VS_ACTIVITY_TWO", 25, 0, 0, R.string.ttlive_vs_activity_two, new k4());
        VS_ACTIVITY_THREE = new ToolbarButton("VS_ACTIVITY_THREE", 26, 0, 0, R.string.ttlive_vs_activity_three, new k4());
        VS_SHARE = new ToolbarButton("VS_SHARE", 27, R.drawable.ttlive_vs_share, R.drawable.ttlive_vs_share, R.string.ttlive_share, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_icon_share_portrait), null));
        VS_SHARE_UNFOLD = new ToolbarButton("VS_SHARE_UNFOLD", 28, R.drawable.ttlive_vs_share_unfold_icon, R.drawable.ttlive_vs_share_unfold_icon, R.string.ttlive_share, new k4());
        VS_BARRAGE_SETTING = new ToolbarButton("VS_BARRAGE_SETTING", 29, R.drawable.ttlive_vs_danmuku_setting, R.drawable.ttlive_vs_danmuku_setting, R.string.ttlive_barrage_setting, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_danmuku_setting_portrait), null));
        VS_RECORD_PORTAIT_DAMAKU_ENABLE = new ToolbarButton("VS_RECORD_PORTAIT_DAMAKU_ENABLE", 30, R.drawable.ttlive_ic_vs_danmaku_block_selector, R.drawable.ttlive_ic_vs_danmaku_block_selector, R.string.ttlive_vs_damaku_open);
        VS_REPORT = new ToolbarButton("VS_REPORT", 31, R.drawable.ttlive_vs_ic_report_anchor, R.drawable.ttlive_vs_ic_report_anchor, R.string.ttlive_report_anchor, new k4(null, null, Integer.valueOf(R.drawable.ttlive_vs_report_toolbar_portrait), null));
        VS_INTERACTIVE = new ToolbarButton("VS_INTERACTIVE", 32, R.drawable.ttlive_ic_vs_interactive_switch_landscape, R.drawable.ttlive_ic_vs_interactive_switch_landscape, R.string.ttlive_interactive_switch, new k4(null, null, Integer.valueOf(R.drawable.ttlive_ic_vs_interactive_switch), null));
        VS_MESSAGE_BOARD = new ToolbarButton("VS_MESSAGE_BOARD", 33, R.drawable.ttlive_ic_vs_message_board, R.drawable.ttlive_ic_vs_message_board_fold, R.string.ttlive_vs_message_board);
        MULTI_CAMERA_LINKED_ROOM = new ToolbarButton("MULTI_CAMERA_LINKED_ROOM", 34, R.layout.ttlive_matchroom_camera_behavior);
        MATCH_ROOM_MOMENT = new ToolbarButton("MATCH_ROOM_MOMENT", 35, R.layout.ttlive_matchroom_match_moment_behavior);
        EASTER_EGG = new ToolbarButton("EASTER_EGG", 36, R.layout.ttlive_layout_toolbar_easter_egg_new);
        KTV = new ToolbarButton("KTV", 37, R.drawable.ttlive_ic_anchor_ktv_access, R.drawable.ttlive_ic_anchor_ktv_access, R.string.ttlive_broadcast_toolbar_anchor_ktv_access, R.drawable.ttlive_ic_anchor_ktv_access_broadcast, R.drawable.ttlive_ic_anchor_ktv_access_broadcast, R.string.ttlive_broadcast_toolbar_anchor_ktv_access);
        KTV_GROUP = new ToolbarButton("KTV_GROUP", 38, R.drawable.ttlive_toolbar_ktv_group_icon, R.drawable.ttlive_toolbar_ktv_group_icon, R.string.ttlive_broadcast_toolbar_anchor_ktv_group, R.drawable.ttlive_toolbar_ktv_group_icon, R.drawable.ttlive_toolbar_ktv_group_icon, R.string.ttlive_broadcast_toolbar_anchor_ktv_group);
        INTERACTION_AUDIENCE = new ToolbarButton("INTERACTION_AUDIENCE", 39, R.layout.ttlive_layout_toolbar_audience_interact_new);
        INTERACTION_ROOM = new ToolbarButton("INTERACTION_ROOM", 40, R.layout.ttlive_view_toolbar_interact_room_opend, R.layout.ttlive_view_toolbar_interact_room_opend);
        INTERACTION = new ToolbarButton("INTERACTION", 41, R.layout.ttlive_view_toolbar_interact_new, R.layout.ttlive_view_toolbar_interact);
        j40.h4 r102 = j40.h4.f497235a;
        if (r102.getValue().booleanValue() == false) goto L5;
        int r210 = R.drawable.live_toolbarmore_ic_v2_audience_guest;
    L6:
        INTERACTION_MORE = new ToolbarButton("INTERACTION_MORE", 42, R.drawable.ttlive_ic_audience_guest_no_bg, r210, R.string.ttlive_interaction_more);
        INTERACTION_SCENE = new ToolbarButton("INTERACTION_SCENE", 43, getInteractSceneDrawable(), getInteractSceneDrawable(), R.string.ttlive_interaction_more);
        INTERACTION_ROOM_BATTLE = new ToolbarButton("INTERACTION_ROOM_BATTLE", 44, R.layout.ttlive_view_toolbar_room_battle, R.layout.ttlive_view_toolbar_room_battle);
        TEAM_FIGHT = new ToolbarButton("TEAM_FIGHT", 45, R.drawable.ttlive_ic_interact_team_fight, R.drawable.ttlive_ic_interact_team_fight, R.string.ttlive_team_fight);
        MULTI_SCENE_GAME_PLAY = new ToolbarButton("MULTI_SCENE_GAME_PLAY", 46, R.layout.ttlive_view_toolbar_multi_scene_game_play, R.layout.ttlive_view_toolbar_multi_scene_game_play);
        PK = new ToolbarButton("PK", 47, R.layout.ttlive_view_toolbar_pk, R.layout.ttlive_view_toolbar_pk);
        CLOSE_ROOM = new ToolbarButton("CLOSE_ROOM", 48, R.drawable.ttlive_ic_toolbar_close_live, 0, 0, R.drawable.ttlive_ic_toolbar_close_broadcast, 0, 0);
        RED_ENVELOPE = new ToolbarButton("RED_ENVELOPE", 49, R.drawable.ttlive_selector_action_btn_red_envelope, R.drawable.ttlive_selector_action_btn_red_envelope, 0);
        MORE = new ToolbarButton("MORE", 50, R.layout.ttlive_view_toolbar_more_new, R.layout.ttlive_view_toolbar_more_broadcast);
        LIVING_DRAINAGE = new ToolbarButton("LIVING_DRAINAGE", 51, R.drawable.ttlive_living_drainage, R.drawable.ttlive_living_drainage, R.string.ttlive_living_drainage);
        BARRAGE_SETTING = new ToolbarButton("BARRAGE_SETTING", 52, R.drawable.ttlive_ic_barrage_setting_new, R.drawable.ttlive_ic_barrage_setting_new, R.string.ttlive_barrage_setting);
        SHARE = new ToolbarButton("SHARE", 53, R.drawable.ttlive_selector_share_toolbar_36, R.drawable.ttlive_ic_share_fold_new, R.string.ttlive_share, R.drawable.ttlive_ic_share_broadcast, R.drawable.ttlive_ic_share_broadcast_folded, 0);
        BROADCAST_SHARE = new ToolbarButton("BROADCAST_SHARE", 54, R.drawable.ttlive_selector_action_btn_broadcast_share, R.drawable.ttlive_selector_action_btn_share, R.string.ttlive_share, R.drawable.ttlive_ic_share_broadcast, R.drawable.ttlive_ic_share_broadcast_folded, 0);
        SHARE_TO_DAILY = new ToolbarButton("SHARE_TO_DAILY", 55, R.drawable.ttlive_share_to_daily_arrow, R.drawable.ttlive_share_to_daily_arrow, R.string.ttlive_ui_share_to_daily);
        FollowerShare = new ToolbarButton("FollowerShare", 56, R.drawable.ttlive_selector_btn_follower_share, R.drawable.ttlive_selector_btn_follower_share, R.string.ttlive_button_follower_share);
        WELFARE = new ToolbarButton("WELFARE", 57, R.layout.ttlive_toolbar_welfare, R.layout.ttlive_toolbar_welfare);
        WELFARE_FOLD = new ToolbarButton("WELFARE_FOLD", 58, R.drawable.ttlive_ic_welfare_toolbar_fold, R.drawable.ttlive_ic_welfare_toolbar_fold, R.string.ttlive_welfare_name, 0, R.drawable.ttlive_ic_welfare_toolbar_folded, R.string.ttlive_welfare_name);
        GROUP_PURCHASE = new ToolbarButton("GROUP_PURCHASE", 59, R.layout.ttlive_view_toolbar_group_purchase_widget, R.layout.ttlive_view_toolbar_group_purchase_widget);
        GROUP_PURCHASE_MORE = new ToolbarButton("GROUP_PURCHASE_MORE", 60, R.drawable.ttlive_ic_group_purchase_toolbar_fold, R.drawable.ttlive_ic_group_purchase_toolbar_fold, R.string.ttlive_group_purchase, R.drawable.ttlive_ic_group_purchase_toolbar_folded, R.drawable.ttlive_ic_group_purchase_toolbar_folded, R.string.ttlive_group_purchase);
        GROUP_PURCHASE_AUDIENCE = new ToolbarButton("GROUP_PURCHASE_AUDIENCE", 61, R.layout.ttlive_view_toolbar_group_purchase_audience);
        MANAGE = new ToolbarButton("MANAGE", 62, R.drawable.ttlive_ic_room_manage_broadcast, R.drawable.ttlive_ic_room_manage_broadcast, R.string.ttlive_broadcast_toolbar_room_manager, R.drawable.ttlive_ic_room_manage_broadcast, R.drawable.ttlive_ic_room_manage_broadcast, R.string.ttlive_broadcast_toolbar_room_manager);
        PROMPT = new ToolbarButton("PROMPT", 63, R.drawable.ttlive_icon_prompter, R.drawable.ttlive_icon_prompter, R.string.ttlive_text_prompter);
        VIDEO_PLAY = new ToolbarButton("VIDEO_PLAY", 64, R.drawable.ttlive_ic_video_cast, R.drawable.ttlive_ic_video_cast, R.string.ttlive_text_video_cast);
        ACTIVITY_ZONE = new ToolbarButton("ACTIVITY_ZONE", 65, R.drawable.ttlive_ic_activity_zone_more, R.drawable.ttlive_ic_activity_zone_more, R.string.ttlive_broadcast_activity_zone, 0, R.drawable.ttlive_ic_activity_zone_more_folded, R.string.ttlive_broadcast_activity_zone);
        BROADCAST_ADMIN = new ToolbarButton("BROADCAST_ADMIN", 66, R.drawable.ttlive_icon_broadcast_admin, R.drawable.ttlive_icon_broadcast_admin, R.string.ttlive_text_live_management);
        FLOW_FEEDBACK = new ToolbarButton("FLOW_FEEDBACK", 67, R.drawable.ttlive_ic_flow_feedback_folded, R.drawable.ttlive_ic_flow_feedback_folded, R.string.ttlive_text_flow_feedback);
        MANAGE_UNFOLD = new ToolbarButton("MANAGE_UNFOLD", 68, R.layout.ttlive_view_toolbar_manage_unfold);
        UNION_LIVE = new ToolbarButton("UNION_LIVE", 69, 1036, R.drawable.ttlive_ic_union_live, R.drawable.ttlive_ic_union_live, R.string.ttlive_broadcast_union_live_invite, R.drawable.ttlive_ic_union_live_folded, R.drawable.ttlive_ic_union_live_folded, R.string.ttlive_broadcast_union_live_invite);
        ANCHOR_CHAT_CHANNEL = new ToolbarButton("ANCHOR_CHAT_CHANNEL", 70, R.drawable.ttlive_ic_anchor_chat_channel, R.drawable.ttlive_ic_anchor_chat_channel, R.string.ttlive_more_panel_chat_channel);
        STABLE_MODE = new ToolbarButton("STABLE_MODE", 71, R.drawable.ttlive_ic_stable_mode, R.drawable.ttlive_ic_stable_mode, R.string.ttlive_broadcast_stable_mode_text);
        MINI_APP = new ToolbarButton("MINI_APP", 72, R.drawable.ttlive_ic_mini_app, R.drawable.ttlive_ic_mini_app, R.string.ttlive_mini_app, R.drawable.ttlive_ic_broadcast_mini_app, R.drawable.ttlive_ic_broadcast_mini_app_more, R.string.ttlive_mini_app);
        MINI_APP_MORE = new ToolbarButton("MINI_APP_MORE", 73, R.drawable.ttlive_ic_broadcast_mini_app, R.drawable.ttlive_ic_broadcast_mini_app_more, R.string.ttlive_mini_app);
        LITTLE_GAME = new ToolbarButton("LITTLE_GAME", 74, R.layout.ttlive_toolbar_mini_game, R.layout.ttlive_toolbar_mini_game, R.string.ttlive_game_candy, R.string.ttlive_game_candy);
        TICKET_SALE = new ToolbarButton("TICKET_SALE", 75, getTicketSaleIcon(), getTicketSaleIcon(), R.string.ttlive_ticket_sale, R.drawable.ttlive_ic_ticket_sale_new, R.drawable.ttlive_ic_ticket_sale_new, R.string.ttlive_ticket_sale);
        REPLAY_TICKET_SALE = new ToolbarButton("REPLAY_TICKET_SALE", 76, R.drawable.ttlive_paid_live_ticket_replay_behavior_unfold, R.drawable.ttlive_paid_live_ticket_replay_behavior_unfold, R.string.ttlive_ticket_sale);
        TICKET_SALE_ANCHOR = new ToolbarButton("TICKET_SALE_ANCHOR", 77, R.drawable.ttlive_paid_live_ticket_anchor_behavior_unfold, R.drawable.ttlive_paid_live_ticket_anchor_behavior_unfold, R.string.ttlive_ticket_sale_anchor, R.drawable.ttlive_paid_live_ticket_anchor_behavior_unfold, R.drawable.ttlive_paid_live_ticket_anchor_behavior_unfold, R.string.ttlive_ticket_sale_anchor);
        TICKET_SALE_ANCHOR_MORE = new ToolbarButton("TICKET_SALE_ANCHOR_MORE", 78, R.drawable.ttlive_paid_live_ticket_anchor_behavior_fold, R.drawable.ttlive_paid_live_ticket_anchor_behavior_fold, R.string.ttlive_ticket_sale_anchor, R.drawable.ttlive_paid_live_ticket_anchor_behavior_fold, R.drawable.ttlive_paid_live_ticket_anchor_behavior_fold, R.string.ttlive_ticket_sale_anchor);
        LICENSE_INFO = new ToolbarButton("LICENSE_INFO", 79, R.drawable.ttlive_license_info_anchor_behavior_fold_white, R.drawable.ttlive_license_info_anchor_behavior_fold_white, R.string.ttlive_license_info, R.drawable.ttlive_license_info_anchor_behavior_fold_white, R.drawable.ttlive_license_info_anchor_behavior_fold_white, R.string.ttlive_license_info);
        CLEAR_SCREEN = new ToolbarButton("CLEAR_SCREEN", 80, R.drawable.ttlive_ic_clear_screen_type_1, R.drawable.ttlive_ic_clear_screen_type_1, R.string.ttlive_clear_screen);
        ROOM_CHANNEL_LANDSCAPE = new ToolbarButton("ROOM_CHANNEL_LANDSCAPE", 81, R.layout.ttlive_toolbar_room_channel_landscape);
        if (r102.getValue().booleanValue() == false) goto L9;
        int r310 = R.drawable.live_toolbar_ic_v2_roomchannel_static;
    L10:
        ROOM_CHANNEL = new ToolbarButton("ROOM_CHANNEL", 82, r310, R.drawable.ttlive_ic_room_channel, R.string.ttlive_room_channel);
        SCHEDULE_CLOSE = new ToolbarButton("SCHEDULE_CLOSE", 83, R.drawable.ttlive_vs_schedule_close_portrait, R.drawable.ttlive_vs_schedule_close_portrait, R.string.ttlive_vs_schedule_close);
        COLLECT = new ToolbarButton("COLLECT", 84, R.drawable.ttlive_vs_collection, R.drawable.ttlive_vs_collection, R.string.ttlive_vs_collection, new k4(null, null, r101, null));
        CLEAR_SCREEN_OPTIMIZE_OFF = new ToolbarButton("CLEAR_SCREEN_OPTIMIZE_OFF", 85, R.drawable.ttlive_ic_clear_screen_optimize_white_off, R.drawable.ttlive_ic_clear_screen_optimize_white_off, R.string.ttlive_clear_screen);
        CLEAR_SCREEN_OPTIMIZE_ON = new ToolbarButton("CLEAR_SCREEN_OPTIMIZE_ON", 86, R.drawable.ttlive_ic_clear_screen_optimize_white_on, R.drawable.ttlive_ic_clear_screen_optimize_white_on, R.string.ttlive_clear_screen);
        REPORT = new ToolbarButton(OpenNetMethod.REPORT, 87, R.drawable.ttlive_ic_report_anchor, R.drawable.ttlive_ic_report_anchor, R.string.ttlive_report_anchor);
        MINOR_REFUND = new ToolbarButton("MINOR_REFUND", 88, R.drawable.ttlive_minor_refund, R.drawable.ttlive_minor_refund, R.string.ttlilve_minor_refund);
        SWITCH_ACCOUNT = new ToolbarButton("SWITCH_ACCOUNT", 89, R.drawable.ttlive_ic_toolbar_switch_account, R.drawable.ttlive_ic_toolbar_switch_account, R.string.ttlive_a11y_switch_account);
        VIP_IM = new ToolbarButton("VIP_IM", 90, R.drawable.ttlive_ic_vip_im, R.drawable.ttlive_ic_vip_im, R.string.ttlive_vip_im);
        int r103 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        PREDICTOR_GUESS = new ToolbarButton("PREDICTOR_GUESS", 91, R.drawable.ttlive_ic_game_point_new, R.drawable.ttlive_ic_game_point_new, R.string.ttlive_game_point);
        RECORD = new ToolbarButton("RECORD", 92, R.drawable.ttlive_ic_record_unfolded_bg, R.drawable.ttlive_selector_action_btn_record, R.string.ttlive_broadcast_toolbar_record, R.drawable.ttlive_ic_record_unfolded, R.drawable.ttlive_ic_broadcast_live_record_folded, 0);
        RECORD_LANDSCAPE = new ToolbarButton("RECORD_LANDSCAPE", 93, R.drawable.ttlive_ic_record_landscape_new, R.drawable.ttlive_ic_record_landscape, R.string.ttlive_broadcast_toolbar_record);
        GAME_CAST_SCREEN = new ToolbarButton("GAME_CAST_SCREEN", 94, R.drawable.ttlive_ic_landscape_cast_screen_new, R.drawable.ttlive_ic_landscape_cast_screen_new, R.string.ttlive_broadcast_toolbar_record);
        CAST_SCREEN = new ToolbarButton("CAST_SCREEN", 95, R.drawable.ttlive_cast_screen_unfolded_icon, R.drawable.ttlive_cast_screen_unfolded_icon, R.string.ttlive_vs_projection_screen);
        PAD_AND_PC_PLAY = new ToolbarButton("PAD_AND_PC_PLAY", 96, R.drawable.ttlive_ic_pad_and_pc_play_button_land, R.drawable.ttlive_ic_pad_and_pc_play_button_land, R.string.ttlive_more_dialog_pad_and_pc_play);
        PAD_AND_PC_PLAY_LANDSCAPE = new ToolbarButton("PAD_AND_PC_PLAY_LANDSCAPE", 97, R.drawable.ttlive_ic_pad_and_pc_play_button_land, R.drawable.ttlive_ic_pad_and_pc_play_button_land, R.string.ttlive_more_dialog_pad_and_pc_play);
        WATCH_LATER = new ToolbarButton("WATCH_LATER", 98, R.drawable.ttlive_ic_watch_later_button, R.drawable.ttlive_ic_watch_later_button, R.string.ttlive_watch_later);
        LIVE_WIDGET = new ToolbarButton("LIVE_WIDGET", 99, R.drawable.ttlive_add_widget_moredialog_icon, R.drawable.ttlive_add_widget_moredialog_icon, R.string.ttlive_add_widget);
        ANCHOR_BACKTRACK = new ToolbarButton("ANCHOR_BACKTRACK", 100, R.drawable.ttlive_ic_anchorbacktrack_loading, R.drawable.ttlive_ic_anchorbacktrack_loading, R.string.ttlive_anchor_backtrack_toolbar_name, R.drawable.ttlive_ic_anchorbacktrack_loading, R.drawable.ttlive_ic_anchorbacktrack_loading, 0);
        PUBLIC_SCREEN_SELECTED_MESSAGE = new ToolbarButton("PUBLIC_SCREEN_SELECTED_MESSAGE", 101, R.drawable.ttlive_ic_toolbar_selected_message, R.drawable.ttlive_ic_toolbar_selected_message, R.string.ttlive_selected_message_toolbar_name, R.drawable.ttlive_ic_toolbar_selected_message, R.drawable.ttlive_ic_toolbar_selected_message_folded, R.string.ttlive_selected_message_toolbar_name);
        PUBLIC_SCREEN_AI_HELPER = new ToolbarButton("PUBLIC_SCREEN_AI_HELPER", 102, R.drawable.ttlive_ic_toolbar_selected_message, R.drawable.ttlive_ic_toolbar_selected_message, R.string.ttlive_public_screen_ai_helper_toolbar_name, R.drawable.ttlive_ic_toolbar_selected_message, R.drawable.ttlive_ic_toolbar_selected_message_folded, R.string.ttlive_public_screen_ai_helper_toolbar_name);
        PUBLIC_SCREEN_CONFIG = new ToolbarButton("PUBLIC_SCREEN_CONFIG", 103, R.drawable.ttlive_ic_toolbar_public_screen_config, R.drawable.ttlive_ic_toolbar_public_screen_config, R.string.ttlive_ps_config, R.drawable.ttlive_ic_toolbar_public_screen_config, R.drawable.ttlive_ic_toolbar_public_screen_config_folded, R.string.ttlive_ps_config);
        AUDIENCE_PUBLIC_SCREEN_CONFIG = new ToolbarButton("AUDIENCE_PUBLIC_SCREEN_CONFIG", 104, R.drawable.ttlive_ic_toolbar_public_screen_config, R.drawable.ttlive_ic_toolbar_public_screen_config, R.string.ttlive_ps_config);
        BARRAGE = new ToolbarButton("BARRAGE", 105, R.drawable.ttlive_ic_live_barrage, R.drawable.ttlive_ic_live_barrage, 0);
        LIVE_PICTURE_TYPE = new ToolbarButton("LIVE_PICTURE_TYPE", 106, R.drawable.ttlive_ic_pic_type, R.drawable.ttlive_ic_pic_type, R.string.ttlive_picture_type_config);
        BLOCK = new ToolbarButton("BLOCK", 107, R.drawable.ttlive_ic_live_block, R.drawable.ttlive_ic_live_block, 0);
        BLOCK_MEDIA = new ToolbarButton("BLOCK_MEDIA", 108, R.drawable.ttlive_ic_live_media_block, R.drawable.ttlive_ic_live_media_block, 0);
        HASH_TAG = new ToolbarButton("HASH_TAG", 109, R.drawable.ttlive_icon_hashtag_view, R.drawable.ttlive_icon_hashtag_view, R.string.ttlive_hash_tag, R.drawable.ttlive_icon_hashtag_view_new, R.drawable.ttlive_icon_hashtag_view_new, 0);
        int r104 = j40.g4.f497229a;
        if (j40.g4.a.a() == false) goto L13;
        int r311 = R.drawable.ttlive_ic_vote_saas_broadcast;
    L15:
        if (j40.g4.a.a() == false) goto L17;
        int r312 = R.drawable.ttlive_ic_vote_saas_broadcast;
    L18:
        VOTE = new ToolbarButton("VOTE", 110, R.drawable.ttlive_ic_vote, R.drawable.ttlive_ic_vote, R.string.ttlive_live_behavior_vote, r311, r312, 0);
        if (j40.g4.a.a() == false) goto L21;
        int r410 = R.drawable.ttlive_ic_wish_list_saas_broadcast;
    L23:
        if (j40.g4.a.a() == false) goto L25;
        int r411 = R.drawable.ttlive_ic_wish_list_saas_broadcast;
    L26:
        WISH_LIST = new ToolbarButton("WISH_LIST", 111, R.drawable.ttlive_ic_wish_list, R.drawable.ttlive_ic_wish_list, R.string.ttlive_live_behavior_wish_list, r410, r411, 0);
        boolean r105 = tb1.c.f545229a;
        if (r105 == true) goto L29;
    L31:
        int r106 = R.layout.ttlive_view_toolbar_interact_game;
    L32:
        if (r105 == true) goto L34;
    L36:
        int r107 = R.layout.ttlive_view_toolbar_interact_game_broadcast;
    L37:
        INTERACT_GAME = new ToolbarButton("INTERACT_GAME", 112, r106, r107);
        INTERACT_PLAY = new ToolbarButton("INTERACT_PLAY", 113, R.layout.ttlive_view_toolbar_interact_play_broadcast, R.layout.ttlive_view_toolbar_interact_play_broadcast);
        INTERACT_PLAY_FOR_GROUP_LIVE_GAME = new ToolbarButton("INTERACT_PLAY_FOR_GROUP_LIVE_GAME", 114, R.layout.ttlive_view_toolbar_interact_play_broadcast, R.layout.ttlive_view_toolbar_interact_play_broadcast);
        COMMERCE = new ToolbarButton("COMMERCE", 115, R.layout.ttlive_view_toolbar_commerce, R.layout.ttlive_view_toolbar_commerce_broadcast);
        COMMERCE_IM = new ToolbarButton("COMMERCE_IM", 116, R.layout.ttlive_view_toolbar_commerce_im);
        COMMERCE_MORE = new ToolbarButton("COMMERCE_MORE", 117, R.layout.ttlive_view_toolbar_common, R.layout.ttlive_view_toolbar_common, R.string.ttlive_toolbar_commerce_more, R.string.ttlive_toolbar_commerce_more);
        if (j40.g4.a.a() == false) goto L40;
        int r412 = R.drawable.ttlive_ic_toolbar_lottery_saas_broadcast;
    L42:
        if (j40.g4.a.a() == false) goto L44;
        int r413 = R.drawable.ttlive_ic_toolbar_lottery_saas_broadcast;
    L45:
        LOTTERY = new ToolbarButton("LOTTERY", 118, R.drawable.ttlive_ic_toolbar_lottery, R.drawable.ttlive_ic_toolbar_lottery, R.string.ttlive_lottery_default_feature_name, r412, r413, R.string.ttlive_lottery_default_feature_name);
        BROADCAST_EFFECT = new ToolbarButton("BROADCAST_EFFECT", 119, R.drawable.ttlive_ic_effect_more, R.drawable.ttlive_ic_effect_more, 0, R.drawable.ttlive_ic_effect_more_broadcast, R.drawable.ttlive_ic_effect_more_broadcast, 0);
        DECORATION = new ToolbarButton("DECORATION", 120, R.drawable.ttlive_selector_action_btn_decoration, R.drawable.ttlive_selector_action_btn_decoration, R.string.ttlive_live_decoration, R.drawable.ttlive_ic_decoration_broadcast, R.drawable.ttlive_ic_decoration_broadcast, R.string.ttlive_broadcast_toolbar_decoration);
        AUDIO = new ToolbarButton("AUDIO", 121, R.drawable.live_toolbar_audio, R.drawable.live_toolbar_audio, R.string.ttlive_live_audio, R.drawable.live_toolbar_audio, R.drawable.live_toolbar_audio, R.string.ttlive_live_audio);
        REVERSE_CAMERA = new ToolbarButton("REVERSE_CAMERA", 122, 0, R.drawable.ttlive_selector_action_btn_reverse_camera, R.string.ttlive_reverse_camera, R.drawable.ttlive_ic_reverse_camera_broadcast, R.drawable.ttlive_ic_reverse_camera_broadcast_folded, 0);
        STICKER = new ToolbarButton("STICKER", 123, 0, R.drawable.ttlive_selector_action_btn_sticker, R.string.ttlive_live_sticker, R.drawable.ttlive_ic_sticker_broadcast, R.drawable.ttlive_ic_sticker_broadcast, 0);
        STICKER_NEW = new ToolbarButton("STICKER_NEW", 124, 0, R.drawable.ttlive_selector_action_btn_sticker, R.string.ttlive_live_sticker_new, R.drawable.ttlive_ic_sticker_broadcast, R.drawable.ttlive_ic_sticker_broadcast, 0);
        BEAUTY = new ToolbarButton(LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, 125, 0, R.drawable.ttlive_selector_action_btn_tool_beauty, R.string.ttlive_live_start_live_set_beauty, R.drawable.ttlive_ic_beauty_broadcast, R.drawable.ttlive_ic_beauty_broadcast, R.string.ttlive_broadcast_toolbar_beauty);
        AV_ADJUST = new ToolbarButton("AV_ADJUST", 126, 0, R.drawable.ttlive_ic_beauty_broadcast_av_adjust, R.string.ttlive_broadcast_toolbar_av_adjust);
        LIVE_MULTI_CAMERA = new ToolbarButton("LIVE_MULTI_CAMERA", 127, 0, R.drawable.ttlive_ic_broadcast_multi_camera, R.string.ttlive_broadcast_toolbar_multi_camera);
        LIVE_PICTURE_PRESENTATION = new ToolbarButton("LIVE_PICTURE_PRESENTATION", 128, 0, R.drawable.ttlive_ic_broadcast_picture_presentation, R.string.ttlive_broadcast_toolbar_picture_presentation);
        CAMERA_MOVEMENT = new ToolbarButton("CAMERA_MOVEMENT", 129, 0, R.drawable.ttlive_ic_decoration_camera_movement, R.string.ttlive_broadcast_toolbar_camera_movement);
        SOUND_EFFECT = new ToolbarButton("SOUND_EFFECT", 130, 0, R.drawable.ttlive_ic_sound_effect_folded, R.string.ttlive_sound_effect);
        FILTER = new ToolbarButton(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 131, 0, R.drawable.ttlive_selector_action_btn_tool_filter, R.string.ttlive_filter);
        GESTURE_MAGIC = new ToolbarButton("GESTURE_MAGIC", 132, 0, R.drawable.ttlive_selector_action_btn_tool_gesture_magic, R.string.ttlive_live_gesture_magic, R.drawable.ttlive_ic_gesture_broadcast, R.drawable.ttlive_ic_gesture_broadcast, 0);
        REVERSE_MIRROR = new ToolbarButton("REVERSE_MIRROR", 133, 0, R.drawable.ttlive_selector_action_btn_reverse_mirror_enabled, R.string.ttlive_reverse_mirror, R.drawable.ttlive_ic_reverse_mirror_enable_broadcast, R.drawable.ttlive_ic_reverse_mirror_enable_broadcast, 0);
        POI = new ToolbarButton("POI", 134, 0, R.drawable.ttlive_selector_action_btn_tool_poi, R.string.ttlive_poi, R.drawable.ttlive_ic_poi_enable_broadcast, R.drawable.ttlive_ic_poi_enable_broadcast_folded, 0);
        SWITCH_SCREEN_ORIENTATION = new ToolbarButton("SWITCH_SCREEN_ORIENTATION", 135, R.drawable.ttlive_selector_action_btn_switch_to_portrait, R.drawable.ttlive_selector_action_btn_switch_orientation, R.string.ttlive_live_switch_to_landscape);
        SWITCH_VIDEO_QUALITY = new ToolbarButton("SWITCH_VIDEO_QUALITY", 136, R.layout.ttlive_view_toolbar_video_quality);
        LANDSCAPE_MULTI_TAB = new ToolbarButton("LANDSCAPE_MULTI_TAB", 137, R.layout.ttlive_view_toolbar_landscape_multi_tab);
        KEY_ROOM_INFO = new ToolbarButton("KEY_ROOM_INFO", 138, 0, R.drawable.ic_key_info_setting, R.string.ttlive_key_room_info);
        PUSH_URL = new ToolbarButton("PUSH_URL", 139, 0, R.drawable.ttlive_selector_action_btn_push_url, R.string.ttlive_push_url);
        BROADCAST_PAUSE = new ToolbarButton("BROADCAST_PAUSE", 140, R.drawable.ttlive_bg_broadcast_pause_live, R.drawable.ttlive_bg_broadcast_pause_live, R.string.ttlive_broadcast_pause_live);
        ADD_PICTURE = new ToolbarButton("ADD_PICTURE", 141, R.drawable.ttlive_ic_add_picture, R.drawable.ttlive_ic_add_picture, R.string.ttlive_broadcast_add_picture);
        LIVE_MATRIX = new ToolbarButton("LIVE_MATRIX", 142, R.drawable.ttlive_ic_live_matrix_anchor_entrance, R.drawable.ttlive_ic_live_matrix_anchor_entrance, R.string.ttlive_live_matrix);
        QUESTION_AND_ANSWER = new ToolbarButton("QUESTION_AND_ANSWER", 143, R.drawable.ttlive_ic_question_mark, R.drawable.ttlive_ic_question_mark, R.string.ttlive_question_and_answer);
        INNER_SMALL_WINDOW_ACTION_BUTTON = new ToolbarButton("INNER_SMALL_WINDOW_ACTION_BUTTON", 144, 0, R.drawable.ttlive_small_window_action_button, R.string.ttlive_small_window_action);
        BROADCAST_INFO = new ToolbarButton("BROADCAST_INFO", 145, R.drawable.ttlive_icon_broadcast_info, R.drawable.ttlive_icon_broadcast_info, R.string.ttlive_broadcast_content_manage_opt);
        BROADCAST_RESTART = new ToolbarButton("BROADCAST_RESTART", 146, R.drawable.ttlive_ic_broadcast_restart, R.drawable.ttlive_ic_broadcast_restart, R.string.ttlive_broadcast_restart);
        FAST_GIFT = new ToolbarButton("FAST_GIFT", 147, R.layout.ttlive_view_toolbar_fast_gift);
        CASH_EXCHANGE = new ToolbarButton("CASH_EXCHANGE", 148, R.layout.ttlive_view_toolbar_cash_exchange);
        TREASURE_BOX = new ToolbarButton("TREASURE_BOX", 149, R.layout.ttlive_view_toolbar_treasure_box);
        COUPON_EXCHANGE = new ToolbarButton("COUPON_EXCHANGE", 150, R.layout.ttlive_view_toolbar_coupon_exchange);
        GIFT = new ToolbarButton("GIFT", 151, R.layout.ttlive_layout_toolbar_gift);
        QUICK_SCREEN_SHOT = new ToolbarButton("QUICK_SCREEN_SHOT", 152, R.layout.ttlive_layout_toolbar_quick_screenshot);
        BROADCAST_GIFT = new ToolbarButton("BROADCAST_GIFT", 153, 0, 0, R.string.ttlive_broadcast_toolbar_gift, R.drawable.ttlive_ic_gift_broadcast_new, R.drawable.ttlive_ic_gift_broadcast_new, R.string.ttlive_broadcast_toolbar_gift);
        INTERACT_GIFT = new ToolbarButton("INTERACT_GIFT", 154, 0, 0, R.string.ttlive_interact_toolbar_gift, R.drawable.ttlive_ic_gift_broadcast_folded, R.drawable.ttlive_ic_gift_broadcast_folded, R.string.ttlive_interact_toolbar_gift);
        LINKMIC_ANNOUNCE = new ToolbarButton("LINKMIC_ANNOUNCE", 155, 0, 0, R.string.ttlive_likmic_announce, R.drawable.ttlive_ic_linkmic_announce_more, R.drawable.ttlive_ic_linkmic_announce_more, R.string.ttlive_likmic_announce);
        BGM = new ToolbarButton("BGM", 156, 0, 0, 0, 0, R.drawable.ttlive_toolbar_icon_bgm, R.string.ttlive_toolbar_title_bgm);
        GIFT_ANIMATION = new ToolbarButton("GIFT_ANIMATION", 157, R.drawable.ttlive_selector_action_btn_gift_animation_enabled, R.drawable.ttlive_selector_action_btn_gift_animation_enabled, 0);
        PERMANENT_CHAT_ROOM = new ToolbarButton("PERMANENT_CHAT_ROOM", 158, 0, 0, 0, 0, R.drawable.ttlive_multi_link_permanent_room_ic, R.string.ttlive_permanent_chat_room);
        PERMANENT_CHAT_GUEST = new ToolbarButton("PERMANENT_CHAT_GUEST", 159, 0, 0, 0, 0, R.drawable.ttlive_multi_link_permanent_room_ic, R.string.ttlive_permanent_guest);
        GIFT_EFFECT = new ToolbarButton("GIFT_EFFECT", 160, R.drawable.ttlive_ic_gift_effect_open, R.drawable.ttlive_ic_gift_effect_open, R.string.ttlive_toolbar_gift_effect);
        AUDIO_TOGGLE = new ToolbarButton("AUDIO_TOGGLE", 161, R.drawable.ttlive_ic_live_audio_on, R.drawable.ttlive_ic_live_audio_on, R.string.ttlive_microphone);
        MESSAGE_PUSH = new ToolbarButton("MESSAGE_PUSH", 162, R.drawable.ttlive_ic_message_push, R.drawable.ttlive_ic_message_push, R.string.ttlive_message_push);
        GAME_QUIZ = new ToolbarButton("GAME_QUIZ", 163, R.drawable.ttlive_selector_game_quiz, 0, 0);
        AUTO_REPLY = new ToolbarButton("AUTO_REPLY", 164, R.drawable.ttlive_selector_action_btn_auto_reply, R.drawable.ttlive_selector_action_btn_auto_reply, R.string.ttlive_auto_reply);
        DIVIDER = new ToolbarButton("DIVIDER", 165, R.layout.ttlive_toolbar_divider);
        XT_LANDSCAPE_SHARE = new ToolbarButton("XT_LANDSCAPE_SHARE", 166, R.drawable.ttlive_xt_landscape_share, R.drawable.ttlive_selector_action_btn_share, R.string.ttlive_share);
        HOUR_RANK = new ToolbarButton("HOUR_RANK", 167, R.drawable.ttlive_ic_hour_rank_tool_bar, 0, 0);
        AUTO_CAR = new ToolbarButton("AUTO_CAR", 168, R.layout.ttlive_auto_car_toolbar);
        DOUYIN_CLOSE = new ToolbarButton("DOUYIN_CLOSE", 169, R.layout.ttlive_view_toolbar_douyin_close);
        PROMOTION_VIDEO = new ToolbarButton("PROMOTION_VIDEO", 170, R.drawable.ttlive_ic_extra_promotion, R.drawable.ttlive_ic_extra_promotion, R.string.ttlive_live_help_promotion_video, R.drawable.ttlive_ic_extra_promotion_broadcast, R.drawable.ttlive_ic_extra_promotion_broadcast, R.string.ttlive_live_help_promotion_video);
        DOU_PLUS_PROMOTE = new ToolbarButton("DOU_PLUS_PROMOTE", 171, R.drawable.ttlive_dou_plus_before, R.drawable.ttlive_dou_plus_before, R.string.ttlive_dou_plus_promote_live, R.drawable.ttlive_ic_dou_plus_broadcast, R.drawable.ttlive_ic_dou_plus_broadcast, 0);
        DOU_PLUS_PROMOTE_AUDIENCE = new ToolbarButton("DOU_PLUS_PROMOTE_AUDIENCE", 172, R.drawable.ttlive_ic_dou_plus_broadcast, R.drawable.ttlive_ic_dou_plus_broadcast, R.string.ttlive_dou_plus_promote_live_audience, R.drawable.ttlive_ic_dou_plus_broadcast, R.drawable.ttlive_ic_dou_plus_broadcast, 0);
        if (n5.d() == false) goto L48;
        int r313 = R.drawable.ttlive_ic_ren_qi_bao_people;
    L50:
        if (n5.d() == false) goto L52;
        int r414 = R.drawable.ttlive_ic_ren_qi_bao_people;
    L54:
        if (n5.d() == false) goto L56;
        int r415 = R.drawable.ttlive_ic_ren_qi_bao_people;
    L58:
        if (n5.d() == false) goto L60;
        int r416 = R.drawable.ttlive_ic_ren_qi_bao_people;
    L61:
        REN_QI_BAO = new ToolbarButton("REN_QI_BAO", 173, r313, r414, R.string.ttlive_renqibao, r415, r416, R.string.ttlive_renqibao);
        VR_MODE = new ToolbarButton("VR_MODE", 174, R.layout.ttlive_layout_toolbar_vr);
        MULTI_CAMERA = new ToolbarButton("MULTI_CAMERA", 175, R.layout.ttlive_layout_toolbar_multi_camera);
        HOTSOON_PROMOTION = new ToolbarButton("HOTSOON_PROMOTION", 176, R.drawable.ttlive_ic_help_promotion, R.drawable.ttlive_ic_help_promotion, R.string.ttlive_promotion);
        PROMOTION_CARD = new ToolbarButton("PROMOTION_CARD", 177, R.drawable.ttlive_selector_action_btn_promotion_card, R.drawable.ttlive_selector_action_btn_promotion_card, 0);
        DOUYIN_OFFICIAL_IMMERSE = new ToolbarButton("DOUYIN_OFFICIAL_IMMERSE", 178, R.layout.ttlive_toolbar_douyin_official_immerse);
        DOUYIN_OFFICIAL_QUALITY = new ToolbarButton("DOUYIN_OFFICIAL_QUALITY", 179, R.layout.ttlive_toolbar_douyin_official_quality);
        DOUYIN_OFFICIAL_EFFECT = new ToolbarButton("DOUYIN_OFFICIAL_EFFECT", 180, R.drawable.ttlive_douyin_official_effect_open, R.drawable.ttlive_douyin_official_effect_open, 0);
        DOUYIN_GAME = new ToolbarButton("DOUYIN_GAME", 181, R.drawable.ttlive_ic_broadcast_game, R.drawable.ttlive_icon_game_more, R.string.ttlive_live_eye_blink_game_hint, R.drawable.ttlive_ic_game_broadcast, R.drawable.ttlive_ic_game_broadcast, 0);
        XT_GAMELIVE_INTERACTION = new ToolbarButton("XT_GAMELIVE_INTERACTION", 182, R.drawable.ttlive_ic_interaction, R.drawable.ttlive_ic_interaction, R.string.ttlive_interaction);
        BROADCAST_TASK = new ToolbarButton("BROADCAST_TASK", 183, R.drawable.ttlive_anchor_task_entry, R.drawable.ttlive_anchor_task_entry, R.string.ttlive_broadcast_task_entry, R.drawable.ttlive_ic_task_broadcast, R.drawable.ttlive_ic_task_broadcast_folded, 0);
        COMMENT = new ToolbarButton("COMMENT", 184, R.drawable.ttlive_ic_comment_broadcast, R.drawable.ttlive_ic_comment_broadcast, R.string.ttlive_broadcast_toolbar_comment, 0, R.drawable.ttlive_ic_comment_broadcast_folded, R.string.ttlive_broadcast_toolbar_comment);
        CHANNEL_COMMENT = new ToolbarButton("CHANNEL_COMMENT", 185, R.drawable.ttlive_ic_anchor_comment_broadcast, R.drawable.ttlive_ic_anchor_comment_broadcast, R.string.ttlive_broadcast_toolbar_comment, R.drawable.ttlive_ic_anchor_comment_broadcast, R.drawable.ttlive_ic_anchor_comment_broadcast, R.string.ttlive_broadcast_toolbar_comment);
        SQUARE_COMMENT = new ToolbarButton("SQUARE_COMMENT", 186, R.drawable.ttlive_ic_anchor_comment_broadcast, R.drawable.ttlive_ic_anchor_comment_broadcast, R.string.ttlive_broadcast_toolbar_comment, R.drawable.ttlive_ic_anchor_comment_broadcast, R.drawable.ttlive_ic_anchor_comment_broadcast, R.string.ttlive_broadcast_toolbar_square_comment);
        AUDIO_COMMENT = new ToolbarButton("AUDIO_COMMENT", 187, R.drawable.ttlive_ic_audio_comment_broadcast, R.drawable.ttlive_ic_audio_comment_broadcast, R.string.ttlive_broadcast_toolbar_audio_comment);
        COMMERCE_LIVE_AD = new ToolbarButton("COMMERCE_LIVE_AD", 188, R.layout.ttlive_view_toolbar_commerce_ad);
        TRANSFORM_WIDGET = new ToolbarButton("TRANSFORM_WIDGET", 189, R.layout.ttlive_view_toolbar_transform_widget, R.layout.ttlive_view_toolbar_transform_widget);
        TRANSFORM_WIDGET_AUDIENCE_MORE = new ToolbarButton("TRANSFORM_WIDGET_AUDIENCE_MORE", 190, R.drawable.ttlive_ic_transform_widget, R.drawable.ttlive_ic_transform_widget, R.string.ttlive_transform_widget_name);
        TRANSFORM_WIDGET_MORE = new ToolbarButton("TRANSFORM_WIDGET_MORE", 191, R.drawable.ttlive_ic_transform_widget, R.drawable.ttlive_ic_transform_widget, R.string.ttlive_transform_widget_name, R.drawable.ttlive_ic_transform_widget, R.drawable.ttlive_ic_transform_widget_pure, R.string.ttlive_transform_widget_name);
        GAME_EXIT = new ToolbarButton("GAME_EXIT", 192, R.layout.ttlive_toolbar_game_exit, R.layout.ttlive_toolbar_game_exit);
        PLAY_SETTING = new ToolbarButton("PLAY_SETTING", 193, R.drawable.ttlive_ic_toolbar_button_play_setting, R.drawable.ttlive_ic_toolbar_button_play_setting, R.string.ttlive_play_setting);
        INTERACT_GAME_EXIT = new ToolbarButton("INTERACT_GAME_EXIT", MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, R.layout.ttlive_toolbar_game_exit, R.layout.ttlive_toolbar_game_exit);
        GAME_GUESS = new ToolbarButton("GAME_GUESS", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, R.layout.ttlive_toolbar_game_guess, R.layout.ttlive_toolbar_game_guess);
        OPEN_PLATFORM_LYNX_GAME = new ToolbarButton("OPEN_PLATFORM_LYNX_GAME", MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, R.layout.ttlive_toolbar_game_guess, R.layout.ttlive_toolbar_game_guess);
        OPEN_PLATFORM_MINI_APP = new ToolbarButton("OPEN_PLATFORM_MINI_APP", MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, R.layout.ttlive_toolbar_open_platform, R.layout.ttlive_toolbar_open_platform);
        OPEN_PLATFORM_MINI_APP_MORE = new ToolbarButton("OPEN_PLATFORM_MINI_APP_MORE", 198, R.drawable.ttlive_ic_mini_app_anchor_default, R.drawable.ttlive_ic_mini_app_anchor_default, R.string.ttlive_mini_app, R.drawable.ttlive_ic_mini_app_anchor_default, R.drawable.ttlive_ic_mini_app_anchor_new, R.string.ttlive_mini_app);
        OPEN_PLATFORM_MINI_GAME = new ToolbarButton("OPEN_PLATFORM_MINI_GAME", 199, R.layout.ttlive_toolbar_open_platform, R.layout.ttlive_toolbar_open_platform);
        OPEN_PLATFORM_GAME = new ToolbarButton("OPEN_PLATFORM_GAME", 200, R.layout.ttlive_toolbar_open_game, R.layout.ttlive_toolbar_open_game);
        AUDIENCE_RECORD = new ToolbarButton("AUDIENCE_RECORD", 201, 0, 0, R.string.ttlive_audience_toolbar_record, 0, 0, 0);
        AIRDROP_GIFT = new ToolbarButton("AIRDROP_GIFT", 202, R.layout.ttlive_view_toolbar_airdrop_gift);
        VS_VERTICAL_RESOLUTION = new ToolbarButton("VS_VERTICAL_RESOLUTION", 203, R.drawable.ttlive_icon_vs_resolution, R.drawable.ttlive_icon_vs_resolution, R.string.ttlive_audience_resolution);
        AUDIENCE_RESOLUTION = new ToolbarButton("AUDIENCE_RESOLUTION", 204, R.drawable.ttlive_icon_toolbar_resolution_hd, R.drawable.ttlive_icon_toolbar_resolution_hd, R.string.ttlive_audience_resolution);
        IN_ROOM_RESOLUTION = new ToolbarButton("IN_ROOM_RESOLUTION", 205, R.drawable.ttlive_icon_toolbar_resolution_hd, R.drawable.ttlive_icon_toolbar_resolution_hd, R.string.ttlive_audience_resolution, R.drawable.ttlive_icon_toolbar_resolution_hd, R.drawable.ttlive_icon_toolbar_resolution_hd, R.string.ttlive_audience_resolution);
        VOICE_LIVE_THEME = new ToolbarButton("VOICE_LIVE_THEME", 206, R.drawable.ttlive_theme_icon, R.drawable.ttlive_theme_icon, R.string.ttlive_broadcast_toolbar_theme, R.drawable.ttlive_theme_icon, R.drawable.ttlive_theme_icon_folded, R.string.ttlive_broadcast_toolbar_theme);
        RECORD_COMBINE = new ToolbarButton("RECORD_COMBINE", 207, 0, 0, R.string.ttlive_toolbar_record_combine, 0, 0, 0);
        LIVE_CONTENT = new ToolbarButton("LIVE_CONTENT", 208, R.drawable.ttlive_ic_live_content, R.drawable.ttlive_ic_live_content, R.string.ttlive_screen_record_live_content, R.drawable.ttlive_ic_live_content, R.drawable.ttlive_ic_live_content, R.string.ttlive_screen_record_live_content);
        FNA_GROUP = new ToolbarButton("FNA_GROUP", 209, R.drawable.ttlive_ic_toolbar_anchor_fansgroup_unfolded, R.drawable.ttlive_ic_toolbar_anchor_fansgroup_unfolded, R.string.ttlive_anchor_toolbar_title_fans_group, 0, R.drawable.ttlive_ic_toolbar_anchor_fansgroup_folded, R.string.ttlive_anchor_toolbar_title_fans_group);
        FAN_GROUP_MANAGE = new ToolbarButton("FAN_GROUP_MANAGE", 210, R.drawable.ttlive_ic_toolbar_anchor_fansgroup_manage_fold, R.drawable.ttlive_ic_toolbar_anchor_fansgroup_manage_fold, R.string.ttlive_anchor_toolbar_title_fans_group_manage);
        ANCHOR_SHOW = new ToolbarButton("ANCHOR_SHOW", 211, R.drawable.ttlive_ic_anchor_show, R.drawable.ttlive_ic_anchor_show, R.string.ttlive_room_anchor_show, 0, R.drawable.ttlive_ic_anchor_show_folded, R.string.ttlive_room_anchor_show);
        ROOM_INTRO = new ToolbarButton("ROOM_INTRO", 212, 0, R.drawable.ttlive_toolbar_room_intro, R.string.ttlive_room_intro);
        ROOM_NOTICE = new ToolbarButton("ROOM_NOTICE", 213, 0, R.drawable.ttlive_toolbar_room_intro, R.string.ttlive_room_notice);
        ADVANCE_ANNOUNCEMENT = new ToolbarButton("ADVANCE_ANNOUNCEMENT", 214, 0, R.drawable.ttlive_toolbar_advance_announcement, R.string.ttlive_advance_announcement);
        LINKMIC_SETTING = new ToolbarButton("LINKMIC_SETTING", 215, R.drawable.ttlive_toolbar_linkmic_setting, R.drawable.ttlive_toolbar_linkmic_setting, R.string.ttlive_linkmic_setting, 0, R.drawable.ttlive_toolbar_linkmic_setting_folded, R.string.ttlive_linkmic_setting);
        LINKMIC_GAME = new ToolbarButton("LINKMIC_GAME", 216, R.drawable.ttlive_toolbar_linkmic_game, R.drawable.ttlive_toolbar_linkmic_game, R.string.ttlive_linkmic_game);
        VIRTUAL_LIVE = new ToolbarButton("VIRTUAL_LIVE", 217, R.drawable.ttlive_toolbar_virtual_live, R.drawable.ttlive_toolbar_virtual_live, R.string.ttlive_virtual_live_control);
        DISLIKE = new ToolbarButton("DISLIKE", 218, 0, R.drawable.ttlive_toolbar_dislike, R.string.ttlive_dislike);
        LITTLE_PLUGIN = new ToolbarButton("LITTLE_PLUGIN", 219, 0, 0, R.string.ttlive_little_plugin);
        LIVE_IM_ENTRANCE = new ToolbarButton("LIVE_IM_ENTRANCE", 220, R.layout.ttlive_view_toolbar_im_industry, R.layout.ttlive_view_toolbar_im_industry);
        LIVE_IM_ENTRANCE_MORE = new ToolbarButton("LIVE_IM_ENTRANCE_MORE", 221, R.layout.ttlive_view_toolbar_im_industry, R.layout.ttlive_view_toolbar_im_industry, R.string.ttlive_im_entrance_toolbar_more_title, R.string.ttlive_im_entrance_toolbar_more_title);
        LIKE_FEEDBACK = new ToolbarButton("LIKE_FEEDBACK", 222, 0, R.drawable.ttlive_toolbar_like_feedback, R.string.ttlive_dislike_feedback, j40.k1.f497250a.getValue().getFeedbackText());
        STAR_GRAPH = new ToolbarButton("STAR_GRAPH", 223, 0, R.drawable.ttlive_toolbar_star_graph_icon, R.string.ttlive_toolbar_star_graph);
        GAME_PROMOTE = new ToolbarButton("GAME_PROMOTE", 224, R.layout.ttlive_game_promote_gamepad_anchor, R.layout.ttlive_game_promote_gamepad_anchor);
        GAME_PROMOTE_MORE = new ToolbarButton("GAME_PROMOTE_MORE", 225, R.drawable.ttlive_ic_game_promote_grey, R.drawable.ttlive_ic_game_promote_grey, R.string.ttlive_game_promote_name, R.drawable.ttlive_ic_game_promote_grey_folded, R.drawable.ttlive_ic_game_promote_grey_folded, R.string.ttlive_game_promote_name);
        GAME_PROMOTE_AUDIENCE = new ToolbarButton("GAME_PROMOTE_AUDIENCE", 226, R.layout.ttlive_game_promote_gamepad_audience_new, R.layout.ttlive_game_promote_gamepad_audience);
        GAME_PROMOTE_AUDIENCE_MORE = new ToolbarButton("GAME_PROMOTE_AUDIENCE_MORE", VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, R.drawable.ttlive_ic_game_promote_grey, R.drawable.ttlive_ic_game_promote_grey_more_panel, R.string.ttlive_game_promote_name);
        TASK_CENTER = new ToolbarButton("TASK_CENTER", VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2, 0, R.drawable.ttlive_toolbar_task_center_new, R.string.ttlive_toolbar_task_center);
        TOUTIAO_FLOAT_WINDOW = new ToolbarButton("TOUTIAO_FLOAT_WINDOW", 229, 0, R.drawable.ttlive_ic_toutiao_float_window, R.string.ttlive_toutiao_float_window_play);
        GIFT_CONSUMER_TOAST = new ToolbarButton("GIFT_CONSUMER_TOAST", 230, 0, R.drawable.ttlive_ic_toutiao_gift_consumer, R.string.ttlive_gift_consumer_toast);
        VS_GIFT_CONSUMER_TOAST = new ToolbarButton("VS_GIFT_CONSUMER_TOAST", 231, 0, R.drawable.ttlive_ic_toutiao_gift_consumer, R.string.ttlive_gift_consumer_toast);
        ASSEMBLED_SETTING = new ToolbarButton("ASSEMBLED_SETTING", VideoRef.VALUE_VIDEO_REF_CATEGORY, 0, R.drawable.ttlive_ic_toolbar_button_play_setting, R.string.ttlive_toolbar_assembled_setting);
        PLAY_QUALITY_OPT = new ToolbarButton("PLAY_QUALITY_OPT", 233, 0, R.drawable.ttlive_ic_toolbar_play_quality_opt, R.string.ttlive_toolbar_play_quality_opt);
        LIVE_FLOAT_WINDOW_PLAY = new ToolbarButton("LIVE_FLOAT_WINDOW_PLAY", 234, 0, R.drawable.ttlive_more_panel_btn_live_float_window_play, R.string.ttlive_more_panel_live_float_window_play);
        GUARD_BOX = new ToolbarButton("GUARD_BOX", VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, R.drawable.ttlive_anchor_guard_box, R.drawable.ttlive_anchor_guard_box, R.string.ttlive_anchor_guard_box, R.drawable.ttlive_anchor_guard_box, R.drawable.ttlive_anchor_guard_box_folded, R.string.ttlive_anchor_guard_box);
        SHAKE_MATCH_SETTING = new ToolbarButton("SHAKE_MATCH_SETTING", VideoRef.VALUE_VIDEO_REF_CONST_DEPTH, R.drawable.ttlive_ic_shake_match_on, R.drawable.ttlive_ic_shake_match_on, R.string.ttlive_shake_match_setting);
        AUDIO_SUBTITLE_SETTING = new ToolbarButton("AUDIO_SUBTITLE_SETTING", VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, R.drawable.ttlive_ic_audio_subtitle_on, R.drawable.ttlive_ic_audio_subtitle_on, R.string.ttlive_audio_subtitle);
        CHAT_CHANNEL_LANDSCAPE = new ToolbarButton("CHAT_CHANNEL_LANDSCAPE", 238, R.layout.ttlive_toolbar_chat_channel_landscape);
        SMALL_WINDOW_ACTION_BUTTON = new ToolbarButton("SMALL_WINDOW_ACTION_BUTTON", VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 0, R.drawable.ttlive_small_window_action_button, R.string.ttlive_small_window_action);
        MARKETING_WIDGET_PIN_BUTTON = new ToolbarButton("MARKETING_WIDGET_PIN_BUTTON", 240, 0, R.drawable.ttlive_icon_marketing_widget_pin, R.string.ttlive_marketing_widget_pin);
        CAST_SCREEN_MORE_PANEL = new ToolbarButton("CAST_SCREEN_MORE_PANEL", 241, R.drawable.ttlive_cast_screen_unfolded_icon, R.drawable.ttlive_cast_screen_unfolded_icon, R.string.ttlive_vs_projection_screen);
        CAST_SCREEN_REFRESH = new ToolbarButton("CAST_SCREEN_REFRESH", 242, R.drawable.ttlive_cast_screen_refresh, R.drawable.ttlive_cast_screen_refresh, R.string.ttlive_cast_screen_refresh);
        CAST_SCREEN_FEED_BACK = new ToolbarButton("CAST_SCREEN_FEED_BACK", 243, R.drawable.ttlive_cast_screen_feedback, R.drawable.ttlive_cast_screen_feedback, R.string.ttlive_cast_screen_feed_back);
        SWITCH_VIDEO_QUALITY_MATCH = new ToolbarButton("SWITCH_VIDEO_QUALITY_MATCH", 244, R.layout.ttlive_view_toolbar_video_quality_match);
        TEAM_FIGHT_ADMIN = new ToolbarButton("TEAM_FIGHT_ADMIN", 245, R.drawable.ttlive_toolbar_icon_team_fight, R.drawable.ttlive_toolbar_icon_team_fight, R.string.ttlive_team_fight_multi_linker, R.drawable.ttlive_toolbar_icon_team_fight, R.drawable.ttlive_toolbar_icon_team_fight, R.string.ttlive_team_fight_multi_linker);
        GUEST_BATTLE_ADMIN = new ToolbarButton("GUEST_BATTLE_ADMIN", 246, R.drawable.ttlive_toolbar_icon_guest_battle, R.drawable.ttlive_toolbar_icon_guest_battle, R.string.ttlive_guest_battle, R.drawable.ttlive_toolbar_icon_guest_battle, R.drawable.ttlive_toolbar_icon_guest_battle, R.string.ttlive_guest_battle);
        ROOM_FIGHT_ADMIN = new ToolbarButton("ROOM_FIGHT_ADMIN", 247, R.drawable.ttlive_room_fight_icon, R.drawable.ttlive_room_fight_icon, R.string.ttlive_link_room_fight, R.drawable.ttlive_room_fight_icon, R.drawable.ttlive_room_fight_icon, R.string.ttlive_link_room_fight);
        RADIO_COVER = new ToolbarButton("RADIO_COVER", 248, R.drawable.ttlive_ic_live_radio_cover, R.drawable.ttlive_ic_live_radio_cover, 0);
        DUTY_GIFT = new ToolbarButton("DUTY_GIFT", 249, R.layout.ttlive_view_toolbar_duty_gift);
        AUDIENCE_LANDSCAPE = new ToolbarButton("AUDIENCE_LANDSCAPE", 250, R.layout.ttlive_view_toolbar_audience_record_landscape);
        DRIVE = new ToolbarButton("DRIVE", 251, 0, 0, R.string.ttlive_drive);
        TURNTABLE_V2 = new ToolbarButton("TURNTABLE_V2", 252, 0, 0, R.string.ttlive_turntable);
        BROADCAST_BARRAGE = new ToolbarButton("BROADCAST_BARRAGE", 253, R.drawable.ttlive_ic_game_broadcast_barrage, R.drawable.ttlive_ic_game_broadcast_barrage, 0);
        REPLAY_CAST_SCREEN_FEED_BACK = new ToolbarButton("REPLAY_CAST_SCREEN_FEED_BACK", 254, R.drawable.cast_feedback_landscape_ic, R.drawable.cast_feedback_landscape_ic, R.string.ttlive_cast_feed_back);
        MATCH_ROOM_MULTI_CAMERA = new ToolbarButton("MATCH_ROOM_MULTI_CAMERA", 255, R.layout.ttlive_matchroom_camera_behavior);
        RADIO_INTERACTION_AUDIENCE = new ToolbarButton("RADIO_INTERACTION_AUDIENCE", 256, R.layout.ttlive_layout_toolbar_audience_interact_new);
        VS_MORE_LIVE_ENTRY = new ToolbarButton("VS_MORE_LIVE_ENTRY", 257, R.layout.ttlive_vs_toolbar_more_live);
        INCOME_MORE = new ToolbarButton("INCOME_MORE", 258, R.layout.ttlive_view_toolbar_income_more, R.layout.ttlive_view_toolbar_income_more_broadcast);
        REVOKE_AUTH = new ToolbarButton("REVOKE_AUTH", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, R.drawable.ttlive_icon_toolbar_revoke_auth, R.drawable.ttlive_icon_toolbar_revoke_auth, R.string.ttlive_revoke_auth);
        VS_BARRAGE_KEY_FILTER = new ToolbarButton("VS_BARRAGE_KEY_FILTER", 260, R.drawable.ttlive_ic_vs_barrage_key_filter, R.drawable.ttlive_ic_vs_barrage_key_filter, R.string.ttlive_vs_damaku_key_filter);
        VS_CART = new ToolbarButton("VS_CART", 261, R.layout.ttlive_view_toolbar_vs_cart);
        LIVE_LISTEN = new ToolbarButton("LIVE_LISTEN", 262, 1043, R.drawable.ttlive_ic_live_listen_only, R.drawable.ttlive_ic_live_listen_only, R.string.ttlive_live_listen_only, null);
        REPLAY_CAST_SCREEN = new ToolbarButton("REPLAY_CAST_SCREEN", MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, R.drawable.ttlive_cast_screen_entry_match, R.drawable.ttlive_cast_screen_entry_match, R.string.ttlive_vs_projection_screen);
        com.bytedance.android.livesdk.l1 r108 = com.bytedance.android.livesdk.l1.f146985a;
        if (r108.getValue().booleanValue() == false) goto L64;
        int r314 = R.drawable.ttlive_more_panel_copy_link_sub_panel_icon;
    L66:
        if (r108.getValue().booleanValue() == false) goto L68;
        int r315 = R.drawable.ttlive_more_panel_copy_link_sub_panel_icon;
    L70:
        if (r108.getValue().booleanValue() == false) goto L72;
        int r316 = R.string.ttlive_more_panel_copy_link_sub_panel_text;
    L73:
        COPY_LINK = new ToolbarButton("COPY_LINK", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, r314, r315, r316);
        QR_CODE = new ToolbarButton(CommonConstant.RETKEY.QR_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, R.drawable.ttlive_more_panel_qr_code_icon_67, R.drawable.ttlive_more_panel_qr_code_icon_67, R.string.ttlive_more_panel_qr_code_text);
        IM_LIST_VIRTUAL = new ToolbarButton("IM_LIST_VIRTUAL", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 0, 0, 0);
        DESKTOP_WIDGET_PIN_ANCHOR = new ToolbarButton("DESKTOP_WIDGET_PIN_ANCHOR", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, R.drawable.ttlive_ic_live_pin_anchor, R.drawable.ttlive_ic_live_pin_anchor, R.string.ttlive_live_pin_anchor);
        DESKTOP_WIDGET_UNPIN_ANCHOR = new ToolbarButton("DESKTOP_WIDGET_UNPIN_ANCHOR", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, R.drawable.ttlive_ic_live_unpin_anchor, R.drawable.ttlive_ic_live_unpin_anchor, R.string.ttlive_live_unpin_anchor);
        ATTACK_AND_DEFENSE = new ToolbarButton("ATTACK_AND_DEFENSE", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, R.drawable.ttlive_ic_toolbar_attack_and_defense, R.drawable.ttlive_ic_toolbar_attack_and_defense, R.string.ttlive_live_attack_and_defense);
        RECHARGE_RECORD = new ToolbarButton("RECHARGE_RECORD", 270, 1060, 0, R.drawable.ttlive_icon_toolbar_recharge_record, R.string.ttlive_toolbar_recharge_record, null);
        MESSAGE_BOX = new ToolbarButton("MESSAGE_BOX", MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 1059, 0, R.drawable.ttlive_icon_toolbar_notification, R.string.ttlive_notification, null);
        MERCHANT_QUALIFICATIONS = new ToolbarButton("MERCHANT_QUALIFICATIONS", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 1061, 0, 0, 0, 0);
        $VALUES = new ToolbarButton[]{VS_LANDSCAPE_MORE, VS_PORTRAIT_TOP_MORE, VS_PORTRAIT_MORE, VS_SELECT_EPISODE, VS_VIDEO_QUALITY, REPLAY_CHOOSE, VS_FAST_PLAY, VS_ONLY_TA, VS_ONLY_TA_LANDSCAPE, VS_PORTRAIT_LOCK, VS_HIGHLIGHT, VS_TEDIOUS, VS_SCHEDULE_CLOSE, VS_FLOAT_WINDOW, VS_COLLECT, VS_CACHE, VS_VISIBILITY_SETTING, VS_DELETE, VS_CAST_SCREEN, CAST_FEED_BACK, CAST_REFRESH, VS_TOPIC_OPERATION, VS_PORTRAIT_OPERATION, VS_LANDSCAPE_OPERATION, VS_ACTIVITY_ONE, VS_ACTIVITY_TWO, VS_ACTIVITY_THREE, VS_SHARE, VS_SHARE_UNFOLD, VS_BARRAGE_SETTING, VS_RECORD_PORTAIT_DAMAKU_ENABLE, VS_REPORT, VS_INTERACTIVE, VS_MESSAGE_BOARD, MULTI_CAMERA_LINKED_ROOM, MATCH_ROOM_MOMENT, EASTER_EGG, KTV, KTV_GROUP, INTERACTION_AUDIENCE, INTERACTION_ROOM, INTERACTION, INTERACTION_MORE, INTERACTION_SCENE, INTERACTION_ROOM_BATTLE, TEAM_FIGHT, MULTI_SCENE_GAME_PLAY, PK, CLOSE_ROOM, RED_ENVELOPE, MORE, LIVING_DRAINAGE, BARRAGE_SETTING, SHARE, BROADCAST_SHARE, SHARE_TO_DAILY, FollowerShare, WELFARE, WELFARE_FOLD, GROUP_PURCHASE, GROUP_PURCHASE_MORE, GROUP_PURCHASE_AUDIENCE, MANAGE, PROMPT, VIDEO_PLAY, ACTIVITY_ZONE, BROADCAST_ADMIN, FLOW_FEEDBACK, MANAGE_UNFOLD, UNION_LIVE, ANCHOR_CHAT_CHANNEL, STABLE_MODE, MINI_APP, MINI_APP_MORE, LITTLE_GAME, TICKET_SALE, REPLAY_TICKET_SALE, TICKET_SALE_ANCHOR, TICKET_SALE_ANCHOR_MORE, LICENSE_INFO, CLEAR_SCREEN, ROOM_CHANNEL_LANDSCAPE, ROOM_CHANNEL, SCHEDULE_CLOSE, COLLECT, CLEAR_SCREEN_OPTIMIZE_OFF, CLEAR_SCREEN_OPTIMIZE_ON, REPORT, MINOR_REFUND, SWITCH_ACCOUNT, VIP_IM, PREDICTOR_GUESS, RECORD, RECORD_LANDSCAPE, GAME_CAST_SCREEN, CAST_SCREEN, PAD_AND_PC_PLAY, PAD_AND_PC_PLAY_LANDSCAPE, WATCH_LATER, LIVE_WIDGET, ANCHOR_BACKTRACK, PUBLIC_SCREEN_SELECTED_MESSAGE, PUBLIC_SCREEN_AI_HELPER, PUBLIC_SCREEN_CONFIG, AUDIENCE_PUBLIC_SCREEN_CONFIG, BARRAGE, LIVE_PICTURE_TYPE, BLOCK, BLOCK_MEDIA, HASH_TAG, VOTE, WISH_LIST, INTERACT_GAME, INTERACT_PLAY, INTERACT_PLAY_FOR_GROUP_LIVE_GAME, COMMERCE, COMMERCE_IM, COMMERCE_MORE, LOTTERY, BROADCAST_EFFECT, DECORATION, AUDIO, REVERSE_CAMERA, STICKER, STICKER_NEW, BEAUTY, AV_ADJUST, LIVE_MULTI_CAMERA, LIVE_PICTURE_PRESENTATION, CAMERA_MOVEMENT, SOUND_EFFECT, FILTER, GESTURE_MAGIC, REVERSE_MIRROR, POI, SWITCH_SCREEN_ORIENTATION, SWITCH_VIDEO_QUALITY, LANDSCAPE_MULTI_TAB, KEY_ROOM_INFO, PUSH_URL, BROADCAST_PAUSE, ADD_PICTURE, LIVE_MATRIX, QUESTION_AND_ANSWER, INNER_SMALL_WINDOW_ACTION_BUTTON, BROADCAST_INFO, BROADCAST_RESTART, FAST_GIFT, CASH_EXCHANGE, TREASURE_BOX, COUPON_EXCHANGE, GIFT, QUICK_SCREEN_SHOT, BROADCAST_GIFT, INTERACT_GIFT, LINKMIC_ANNOUNCE, BGM, GIFT_ANIMATION, PERMANENT_CHAT_ROOM, PERMANENT_CHAT_GUEST, GIFT_EFFECT, AUDIO_TOGGLE, MESSAGE_PUSH, GAME_QUIZ, AUTO_REPLY, DIVIDER, XT_LANDSCAPE_SHARE, HOUR_RANK, AUTO_CAR, DOUYIN_CLOSE, PROMOTION_VIDEO, DOU_PLUS_PROMOTE, DOU_PLUS_PROMOTE_AUDIENCE, REN_QI_BAO, VR_MODE, MULTI_CAMERA, HOTSOON_PROMOTION, PROMOTION_CARD, DOUYIN_OFFICIAL_IMMERSE, DOUYIN_OFFICIAL_QUALITY, DOUYIN_OFFICIAL_EFFECT, DOUYIN_GAME, XT_GAMELIVE_INTERACTION, BROADCAST_TASK, COMMENT, CHANNEL_COMMENT, SQUARE_COMMENT, AUDIO_COMMENT, COMMERCE_LIVE_AD, TRANSFORM_WIDGET, TRANSFORM_WIDGET_AUDIENCE_MORE, TRANSFORM_WIDGET_MORE, GAME_EXIT, PLAY_SETTING, INTERACT_GAME_EXIT, GAME_GUESS, OPEN_PLATFORM_LYNX_GAME, OPEN_PLATFORM_MINI_APP, OPEN_PLATFORM_MINI_APP_MORE, OPEN_PLATFORM_MINI_GAME, OPEN_PLATFORM_GAME, AUDIENCE_RECORD, AIRDROP_GIFT, VS_VERTICAL_RESOLUTION, AUDIENCE_RESOLUTION, IN_ROOM_RESOLUTION, VOICE_LIVE_THEME, RECORD_COMBINE, LIVE_CONTENT, FNA_GROUP, FAN_GROUP_MANAGE, ANCHOR_SHOW, ROOM_INTRO, ROOM_NOTICE, ADVANCE_ANNOUNCEMENT, LINKMIC_SETTING, LINKMIC_GAME, VIRTUAL_LIVE, DISLIKE, LITTLE_PLUGIN, LIVE_IM_ENTRANCE, LIVE_IM_ENTRANCE_MORE, LIKE_FEEDBACK, STAR_GRAPH, GAME_PROMOTE, GAME_PROMOTE_MORE, GAME_PROMOTE_AUDIENCE, GAME_PROMOTE_AUDIENCE_MORE, TASK_CENTER, TOUTIAO_FLOAT_WINDOW, GIFT_CONSUMER_TOAST, VS_GIFT_CONSUMER_TOAST, ASSEMBLED_SETTING, PLAY_QUALITY_OPT, LIVE_FLOAT_WINDOW_PLAY, GUARD_BOX, SHAKE_MATCH_SETTING, AUDIO_SUBTITLE_SETTING, CHAT_CHANNEL_LANDSCAPE, SMALL_WINDOW_ACTION_BUTTON, MARKETING_WIDGET_PIN_BUTTON, CAST_SCREEN_MORE_PANEL, CAST_SCREEN_REFRESH, CAST_SCREEN_FEED_BACK, SWITCH_VIDEO_QUALITY_MATCH, TEAM_FIGHT_ADMIN, GUEST_BATTLE_ADMIN, ROOM_FIGHT_ADMIN, RADIO_COVER, DUTY_GIFT, AUDIENCE_LANDSCAPE, DRIVE, TURNTABLE_V2, BROADCAST_BARRAGE, REPLAY_CAST_SCREEN_FEED_BACK, MATCH_ROOM_MULTI_CAMERA, RADIO_INTERACTION_AUDIENCE, VS_MORE_LIVE_ENTRY, INCOME_MORE, REVOKE_AUTH, VS_BARRAGE_KEY_FILTER, VS_CART, LIVE_LISTEN, REPLAY_CAST_SCREEN, COPY_LINK, QR_CODE, IM_LIST_VIRTUAL, DESKTOP_WIDGET_PIN_ANCHOR, DESKTOP_WIDGET_UNPIN_ANCHOR, ATTACK_AND_DEFENSE, RECHARGE_RECORD, MESSAGE_BOX, MERCHANT_QUALIFICATIONS};
        ToolbarButton[] r109 = values();
        nameEnumMap = new HashMap(r109.length);
        int r110 = r109.length;
    L74:
        if (r100 >= r110) goto L76;
        ToolbarButton r111 = r109[r100];
        nameEnumMap.put(r111.name(), r111);
        r100 = r100 + 1;
        goto L74
    L76:
        return;
    L72:
        r316 = R.string.ttlive_more_panel_copy_link_text;
        goto L73
    L68:
        r315 = R.drawable.ttlive_more_panel_copy_link_icon_67;
        goto L70
    L64:
        r314 = R.drawable.ttlive_more_panel_copy_link_icon_67;
        goto L66
    L60:
        r416 = R.drawable.ttlive_ic_ren_qi_bao_heart;
        goto L61
    L56:
        r415 = R.drawable.ttlive_ic_ren_qi_bao_heart;
        goto L58
    L52:
        r414 = R.drawable.ttlive_ic_ren_qi_bao_heart;
        goto L54
    L48:
        r313 = R.drawable.ttlive_ic_ren_qi_bao_heart;
        goto L50
    L44:
        r413 = R.drawable.ttlive_ic_toolbar_lottery_broadcast;
        goto L45
    L40:
        r412 = R.drawable.ttlive_ic_toolbar_lottery_broadcast;
        goto L42
    L34:
        if (tb1.c.f545231c == true) goto L36;
        r107 = R.layout.ttlive_view_toolbar_open_platform_broadcast;
        goto L37
    L29:
        if (tb1.c.f545231c == true) goto L31;
        r106 = R.layout.ttlive_view_toolbar_open_platform;
        goto L32
    L25:
        r411 = R.drawable.ttlive_ic_wish_list;
        goto L26
    L21:
        r410 = R.drawable.ttlive_ic_wish_list;
        goto L23
    L17:
        r312 = R.drawable.ttlive_ic_vote_broadcast;
        goto L18
    L13:
        r311 = R.drawable.ttlive_ic_vote_broadcast;
        goto L15
    L9:
        r310 = R.drawable.ttlive_ic_room_channel_unfold;
        goto L10
    L5:
        r210 = R.drawable.ttlive_ic_audience_guest_no_bg;
        goto L6
    }

    public int getDrawableFolded() {
        return this.drawableFolded;
    }

    public int getDrawableUnfolded() {
        return this.drawableUnfolded;
    }

    public long getId() {
        return this.serverId;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public String getTitleStr() {
        return this.titleStr;
    }

    public int getTrueBroadcastLayoutId() {
        return this.broadcastLayoutId;
    }

    public k4 getVsToolbarExtendProperty() {
        return this.vsToolbarExtendProperty;
    }

    public boolean isPureText() {
        return this.pureText;
    }

    public boolean useStandardLayout() {
        return this.useStandardLayout;
    }

    public static ToolbarButton fromName(String r100) {
        return nameEnumMap.get(r100);
    }

    public static ExtendedToolbarButton mappingFold(ExtendedToolbarButton r100) {
        ToolbarButton r101 = fromName(r100.f());
        if (r101 == INTERACTION) goto L38;
        if (r101 == INTERACTION_AUDIENCE) goto L38;
        if (r101 != COMMERCE) goto L12;
        return COMMERCE_MORE.extended();
    L12:
        if (r101 != TRANSFORM_WIDGET) goto L16;
        return TRANSFORM_WIDGET_MORE.extended();
    L16:
        if (r101 == GAME_PROMOTE_AUDIENCE) goto L18;
        ToolbarButton r102 = LIVE_IM_ENTRANCE;
        if (r101 == r102) goto L22;
        ToolbarButton r103 = VS_ACTIVITY_ONE;
        if (r101 == r103) goto L26;
        ToolbarButton r104 = ROOM_CHANNEL;
        if (r101 == r104) goto L30;
        ToolbarButton r105 = VS_MESSAGE_BOARD;
        if (r101 == r105) goto L34;
        return null;
    L34:
        return r105.extended();
    L30:
        return r104.extended();
    L26:
        return r103.extended();
    L22:
        return r102.extended();
    L18:
        return GAME_PROMOTE_AUDIENCE_MORE.extended();
    L38:
        return INTERACTION_MORE.extended();
    }

    public static ToolbarButton valueOf(String r100) {
        return (ToolbarButton) r27.a.a(ToolbarButton.class, r100);
    }

    public ToolbarButton originalToolbarButton(ToolbarButton r100) {
        if (r100.name().equals(DOU_PLUS_PROMOTE.name()) == false) goto L6;
        r100.titleId = R.string.ttlive_dou_plus_promote_live;
        r100.drawableFolded = R.drawable.ttlive_dou_plus_before;
        r100.drawableUnfolded = R.drawable.ttlive_dou_plus_before;
        r100.broadcastDrawableUnfolded = R.drawable.ttlive_ic_dou_plus_broadcast;
        r100.broadcastDrawableFolded = R.drawable.ttlive_ic_dou_plus_broadcast;
    L8:
        return r100;
    L6:
        if (r100.name().equals(DOU_PLUS_PROMOTE_AUDIENCE.name()) == false) goto L8;
        r100.titleId = R.string.ttlive_dou_plus_promote_live_audience;
        r100.drawableFolded = R.drawable.ttlive_ic_dou_plus_broadcast;
        r100.drawableUnfolded = R.drawable.ttlive_ic_dou_plus_broadcast;
        r100.broadcastDrawableUnfolded = R.drawable.ttlive_ic_dou_plus_broadcast;
        r100.broadcastDrawableFolded = R.drawable.ttlive_ic_dou_plus_broadcast;
        goto L8
    }

    public void setBroadcastDrawableUnfolded(int r100) {
        this.broadcastDrawableUnfolded = r100;
    }

    public void setBroadcastLayoutId(int r100) {
        this.broadcastLayoutId = r100;
    }

    public void setDrawableFolded(int r100) {
        this.drawableFolded = r100;
    }

    public ToolbarButton setPureText(boolean r100) {
        this.pureText = r100;
        return this;
    }

    public void setServerId(long r100) {
        this.serverId = r100;
        int r101 = (int) r100;
        SparseArray<ToolbarButton> r102 = x2.f116825a;
        Intrinsics.checkNotNullParameter(this, "toolbarButton");
        x2.f116825a.put(r101, this);
    }

    public void setTitleId(int r100) {
        this.titleId = r100;
    }

    private ToolbarButton(String r100, int r101, int r102) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.broadcastLayoutId = R.layout.ttlive_view_toolbar_common;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r102;
    }

    private ToolbarButton(String r100, int r101, long r102, int r103) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.broadcastLayoutId = R.layout.ttlive_view_toolbar_common;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r103;
        setServerId(r102);
    }

    public ToolbarButton dynamicWrapToolbarButton(ToolbarButton r100, int r101, int r102, int r103) {
        r100.titleId = r101;
        if (r100.name().equals(DOU_PLUS_PROMOTE.name()) == false) goto L6;
        r100.drawableFolded = R.drawable.ttlive_dou_plus_before;
        r100.drawableUnfolded = R.drawable.ttlive_dou_plus_before;
    L8:
        r100.broadcastDrawableUnfolded = r102;
        r100.broadcastDrawableFolded = r103;
        return r100;
    L6:
        if (r100.name().equals(DOU_PLUS_PROMOTE_AUDIENCE.name()) == false) goto L8;
        r100.drawableFolded = r102;
        r100.drawableUnfolded = r102;
        goto L8
    }

    private ToolbarButton(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r102;
        this.broadcastLayoutId = r103;
    }

    private ToolbarButton(String r100, int r101, int r102, int r103, k4 r104) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.broadcastLayoutId = R.layout.ttlive_view_toolbar_common;
        this.pureText = false;
        this.layoutId = r102;
        this.titleId = r103;
        this.vsToolbarExtendProperty = r104;
    }

    private ToolbarButton(String r110, int r111, int r112, int r113, int r114) {
        this(r110, r111, r112, r113, r114, 0, 0, 0);
    }

    private ToolbarButton(String r100, int r101, int r102, int r103, int r104, String r105) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.layoutId = R.layout.ttlive_view_toolbar_common;
        this.broadcastLayoutId = R.layout.ttlive_view_toolbar_common;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.drawableUnfolded = r102;
        this.drawableFolded = r103;
        this.titleId = r104;
        this.titleStr = r105;
    }

    private ToolbarButton(String r110, int r111, int r112, int r113, int r114, k4 r115) {
        this(r110, r111, -1, r112, r113, r114, 0, 0, 0);
        this.vsToolbarExtendProperty = r115;
    }

    private ToolbarButton(String r110, int r111, int r112, int r113, int r114, int r115) {
        this(r110, r111, -1, r112, r113, r114, r115);
    }

    private ToolbarButton(String r100, int r101, long r102, int r103, int r104, int r105, int r106) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        this.layoutId = r103;
        this.broadcastLayoutId = r104;
        this.titleId = r105;
        this.broadcastTitleId = r106;
        setServerId(r102);
    }

    private ToolbarButton(String r110, int r111, long r112, int r113, int r114, int r115, k4 r116) {
        this(r110, r111, r112, r113, r114, r115, 0, 0, 0);
        this.vsToolbarExtendProperty = r116;
    }

    private ToolbarButton(String r110, int r111, boolean r112, long r113, int r114, int r115, int r116) {
        this(r110, r111, r114, r115, r116, 0, 0, 0);
        this.useStandardLayout = r112;
    }

    private ToolbarButton(String r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117) {
        this(r110, r111, -1, r112, r113, r114, r115, r116, r117);
    }

    private ToolbarButton(String r100, int r101, long r102, int r103, int r104, int r105, int r106, int r107, int r110) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.layoutId = R.layout.ttlive_view_toolbar_common;
        this.broadcastLayoutId = R.layout.ttlive_view_toolbar_common;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        setServerId(r102);
        this.drawableUnfolded = r103;
        this.drawableFolded = r104;
        this.titleId = r105;
        this.broadcastDrawableUnfolded = r106;
        this.broadcastDrawableFolded = r107;
        this.broadcastTitleId = r110;
    }

    private ToolbarButton(String r100, int r101, boolean r102, long r103, int r104, int r105, int r106, int r107, int r110, int r111) {
        super(r100, r101);
        this.serverId = -1;
        this.useStandardLayout = false;
        this.layoutId = R.layout.ttlive_view_toolbar_common;
        this.broadcastLayoutId = R.layout.ttlive_view_toolbar_common;
        this.pureText = false;
        this.vsToolbarExtendProperty = null;
        setServerId(r103);
        this.useStandardLayout = r102;
        this.drawableUnfolded = r104;
        this.drawableFolded = r105;
        this.titleId = r106;
        this.broadcastDrawableUnfolded = r107;
        this.broadcastDrawableFolded = r110;
        this.broadcastTitleId = r111;
    }
}
