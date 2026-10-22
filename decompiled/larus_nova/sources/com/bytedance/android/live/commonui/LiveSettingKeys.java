package com.bytedance.android.live.commonui;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.feature.config.LiveFeatureEventFilterConfig;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.a3;
import com.bytedance.android.livesdk.config.b81;
import com.bytedance.android.livesdk.config.bk1;
import com.bytedance.android.livesdk.config.gb1;
import com.bytedance.android.livesdk.config.i0;
import com.bytedance.android.livesdk.config.j31;
import com.bytedance.android.livesdk.config.q71;
import com.bytedance.android.livesdk.config.setting.w;
import com.bytedance.android.livesdk.config.ti1;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.LivePlayerSmoothEnterRoomConfig;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.bytedance.android.livesdkapi.util.FrescoHostConfigUtil;
import ls1.c;
import ls1.r;
import rs1.d;
import xs1.i;

/* JADX INFO: loaded from: classes45.dex */
public interface LiveSettingKeys {
    public static final SettingKey<Boolean> ENABLE_IMAGE_DEFAULT_565 = null;
    public static final SettingKey<Boolean> LIVE_ADD_BASE_RESOLUTION_FPS_FEATURE = null;
    public static final SettingKey<c> LIVE_AI_ASR_CONFIG = null;
    public static final SettingKey<r> LIVE_AI_HAR = null;
    public static final SettingKey<LivePreviewWormholePredictConfig> LIVE_AI_PREVIEW_WORMHOLE_CONFIG = null;
    public static final SettingKey<i0> LIVE_AUDIENCE_RESOLUTION_UI = null;
    public static final SettingKey<Boolean> LIVE_BLOCK_CODE_OPT = null;
    public static final SettingKey<CommunityFoldFixConfig> LIVE_COMMUNITY_FOLD_FIX_CONFIG = null;
    public static final SettingKey<Long> LIVE_COOPERATION_PARTNER_CARD_ANIMATION_DELAYED_REPORT_TIME = null;
    public static final SettingKey<Boolean> LIVE_DOUYIN_STATUS_BAR_CONFIG = null;
    public static final SettingKey<a3> LIVE_DRAW_SCROLL_CONFIG = null;
    public static final SettingKey<Boolean> LIVE_ENABLE_LOADING_NEW_ANIMATION = null;
    public static final SettingKey<LiveFeatureConfig> LIVE_FEATURE_CONFIG = null;
    public static final SettingKey<LiveFeatureEventFilterConfig> LIVE_FEATURE_EVENT_FILTER_CONFIG = null;
    public static final SettingKey<Boolean> LIVE_FOLLOW_COVER_PRE_PULLSTREAM = null;
    public static final SettingKey<j31> LIVE_FRESCO_CONFIG_KEY = null;
    public static final SettingKey<Integer> LIVE_GIFT_MULTIPLE_SEND_OPTIMIZE = null;
    public static final SettingKey<Boolean> LIVE_GIFT_MULTIPLE_SEND_OPTIMIZE_BLOCK_INTERACT = null;
    public static final SettingKey<Integer> LIVE_LANDSCAPE_ENTRANCE_STYLE = null;
    public static final SettingKey<Boolean> LIVE_LANDSCAPE_NEW_STYLE = null;
    public static final SettingKey<Double> LIVE_LANDSCAPE_SCROLL_ANGLE = null;
    public static final SettingKey<Boolean> LIVE_MULTI_CAMERA_SERVICES = null;
    public static final SettingKey<Boolean> LIVE_MULTI_FAN_TICKET_OPTIMIZE = null;
    public static final SettingKey<Boolean> LIVE_NEW_PANEL_SWITCH = null;
    public static final SettingKey<LivePlayerSmoothEnterRoomConfig> LIVE_PLAYER_SMOOTH_ENTER_ROOM = null;
    public static final SettingKey<LivePostClientSequenceConfig> LIVE_POST_CLIENT_SEQUENCE_CONFIG = null;
    public static final SettingKey<q71> LIVE_REN_QI_BAO = null;
    public static final SettingKey<Boolean> LIVE_RESOLUTION_STACK_ONLINE = null;
    public static final SettingKey<d> LIVE_ROOM_MICSEAT_UNIFIED_ICON = null;
    public static final SettingKey<Double> LIVE_SCOLLABLE_ANGLE = null;
    public static final SettingKey<b81> LIVE_SCROLL_SWITCH_CONFIG = null;
    public static final SettingKey<Integer> LIVE_SHUFFLE_SEQUENCE_REPORT_CONFIG = null;
    public static final SettingKey<Boolean> LIVE_SLIDE_BLOCK_SWITCH = null;
    public static final SettingKey<Integer> LIVE_STRATEGY_FAST_SCROLL_RECG_ROOM_COUNT = null;
    public static final SettingKey<Boolean> LIVE_STRATEGY_PLATFROM_SETTING_ENABLE = null;
    public static final SettingKey<Integer> LIVE_STREAM_DATA_MOCK = null;
    public static final SettingKey<bk1> LIVE_TALK_ROOM_LOTTIE_ANIM_OPTIMIZE = null;
    public static final SettingKey<Boolean> LIVE_TOOL_BAR_LOAD_OPT = null;
    public static final SettingKey<LiveUnifyBoxConfig> LIVE_UNIFY_BOX_CONFIG = null;
    public static final SettingKey<ti1> LIVE_VBOOST_OPT = null;
    public static final SettingKey<VSFoldFixConfig> LIVE_VS_FOLD_FIX_CONFIG = null;
    public static final SettingKey<gb1> MOVE_SAMPLING_CONFIG = null;
    public static final SettingKey<Integer> RED_DOT_SHOW_COUNT_MANAGE = null;
    public static final SettingKey<String> STRATEGY_INFO_DATA = null;
    public static final SettingKey<Boolean> UNABLE_NAME_EQUALS = null;
    public static final SettingKey<i> VS_PRIVILEGE = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.commonui.LiveSettingKeys$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            SettingKey<LivePlayerSmoothEnterRoomConfig> r100 = LiveSettingKeys.LIVE_PLAYER_SMOOTH_ENTER_ROOM;
        }

        public static boolean checkBinaryPos(Integer r100, Integer r101) {
            int r102 = 1 << (r101.intValue() - 1);
            if ((r100.intValue() & r102) == r102) goto L7;
            return false;
        L7:
            return true;
        }
    }

    static {
        LIVE_PLAYER_SMOOTH_ENTER_ROOM = new SettingKey("live_player_smooth_enter_room", "多人场景预览流播放器平滑进房优化", new LivePlayerSmoothEnterRoomConfig(), new LivePlayerSmoothEnterRoomConfig());
        Boolean r100 = Boolean.TRUE;
        ENABLE_IMAGE_DEFAULT_565 = new SettingKey("enable_image_default_565", r100, "是否默认开启565");
        LIVE_FRESCO_CONFIG_KEY = new SettingKey(FrescoHostConfigUtil.LIVE_FRESCO_CONFIG_KEY, "fresco图片库缓存key优化", new j31(), new j31());
        RED_DOT_SHOW_COUNT_MANAGE = new SettingKey("live_red_dot_show_count", 3, "黄点规范，展示n次数后消失，0代表仅展示不会消失");
        Double r101 = Double.valueOf(-1.0d);
        LIVE_SCOLLABLE_ANGLE = new SettingKey("live_scrollable_angle", "直播内流滑动角度调整", r101, r101);
        MOVE_SAMPLING_CONFIG = new SettingKey("move_sampling_config", "滑动事件采样的配置", new gb1(), new gb1());
        Boolean r102 = Boolean.FALSE;
        LIVE_SLIDE_BLOCK_SWITCH = new SettingKey("live_slide_block_switch", "修复直播间卡顿的问题", r102, r102);
        LIVE_DRAW_SCROLL_CONFIG = new SettingKey("live_draw_scroll_config", new a3(), "内流滑动参数调优");
        LIVE_LANDSCAPE_NEW_STYLE = new SettingKey("landscape_standard_switch", "横屏新版布局样式", r100, r100, true);
        LIVE_LANDSCAPE_ENTRANCE_STYLE = new SettingKey("live_landscape_entrance_style", "直播间切换横屏入口样式", 0, 0);
        LIVE_BLOCK_CODE_OPT = new SettingKey("live_block_code_opt", "比较零散的耗时逻辑优化", r102, r102);
        LIVE_FOLLOW_COVER_PRE_PULLSTREAM = new SettingKey("live_follow_cover_pre_pullstream", "关注天窗首次滑动预拉流优化", r102, r102, new String[]{"true:使用预拉流", "false:不使用预拉流"});
        LIVE_VBOOST_OPT = new SettingKey("live_vboost_opt", "vboost性能加速优化", new ti1(), new ti1());
        LIVE_TOOL_BAR_LOAD_OPT = new SettingKey("live_tool_bar_load_opt", "LiveToolbarWidget加载耗时优化", r102, r102);
        LIVE_COOPERATION_PARTNER_CARD_ANIMATION_DELAYED_REPORT_TIME = new SettingKey("live_cooperation_partner_card_animation_delayed_report_time", "讲解卡动画执行延时上报端监控时间", 200L, 200L);
        LIVE_NEW_PANEL_SWITCH = new SettingKey("live_new_panel_switch", "是否使用新面板", r102, r102);
        LIVE_ENABLE_LOADING_NEW_ANIMATION = new SettingKey("live_enable_loading_new_animation", "直播是否使用新的双色球动画", r102, r102);
        LIVE_DOUYIN_STATUS_BAR_CONFIG = new SettingKey("live_douyin_status_bar_config", "抖音直播间状态栏与主端保持一致", r100, r100);
        LIVE_TALK_ROOM_LOTTIE_ANIM_OPTIMIZE = new SettingKey("live_talk_room_toolbar_icon_optimize", "是否替换聊天室lottie动画", new bk1(), new bk1());
        LIVE_ROOM_MICSEAT_UNIFIED_ICON = new SettingKey("live_micseat_value_icon_unified", "多人麦位计值Icon统一配置", new d(), new d());
        LIVE_GIFT_MULTIPLE_SEND_OPTIMIZE = new SettingKey("live_gift_multiple_send_optimize", "多人互动场景送礼优化开关", 7, 7);
        LIVE_MULTI_FAN_TICKET_OPTIMIZE = new SettingKey("live_multi_fan_ticket_optimize", "多人麦位计值Icon统一实验", r100, r100);
        LIVE_GIFT_MULTIPLE_SEND_OPTIMIZE_BLOCK_INTERACT = new SettingKey("lift_gift_multiple_send_optimize_block_interact", "屏蔽双人聊礼物分值特效", r102, r102);
        UNABLE_NAME_EQUALS = new SettingKey("unable_name_equals", "button比较时去除name比较", r100, r100);
        VS_PRIVILEGE = new SettingKey("vs_privilege", "付费权益包配置", new i(), new i());
        LIVE_SCROLL_SWITCH_CONFIG = new SettingKey("live_scroll_switch_item", "直播内流滑动期间切换画面调优", new b81(), new b81());
        LIVE_REN_QI_BAO = new SettingKey("live_renqibao_entrance_config", "人气宝入口和样式控制", new q71(), new q71());
        LIVE_AUDIENCE_RESOLUTION_UI = new SettingKey("live_audience_resolution_ui_configs", "看播端清晰度选档UI相关的配置", new i0(), new i0());
        LIVE_FEATURE_CONFIG = new SettingKey(LiveInitSettingKeys.LIVE_FEATURE_CONFIG, "直播特征包配置", new LiveFeatureConfig(), new LiveFeatureConfig());
        LIVE_UNIFY_BOX_CONFIG = new SettingKey("live_unify_box_setting", "集装箱配置", new LiveUnifyBoxConfig(), new LiveUnifyBoxConfig());
        LIVE_RESOLUTION_STACK_ONLINE = new SettingKey("live_resolution_stack_online", "线上resolution stack 开关", r102, r102);
        LIVE_COMMUNITY_FOLD_FIX_CONFIG = new SettingKey("live_community_fold_fix_config", "折叠屏修复适配社区配置", new CommunityFoldFixConfig(), new CommunityFoldFixConfig());
        LIVE_ADD_BASE_RESOLUTION_FPS_FEATURE = new SettingKey("live_add_base_resolution_fps_feature", "添加当前播放器档位转码基准FPS", r102, r102);
        LIVE_VS_FOLD_FIX_CONFIG = new SettingKey("live_vs_fold_fix_config", "折叠屏修复适配节目配置", new VSFoldFixConfig(), new VSFoldFixConfig());
        LIVE_FEATURE_EVENT_FILTER_CONFIG = new SettingKey("live_feature_event_filter_config", "直播特征包埋点过滤配置", new LiveFeatureEventFilterConfig(), new LiveFeatureEventFilterConfig());
        LIVE_POST_CLIENT_SEQUENCE_CONFIG = new SettingKey("live_post_client_sequence_config", "客户端实时特征序列上报配置", new LivePostClientSequenceConfig(), new LivePostClientSequenceConfig());
        LIVE_STRATEGY_FAST_SCROLL_RECG_ROOM_COUNT = new SettingKey("live_strategy_fast_scroll_recg_room_count", "内流快滑场景识别参数:房间数量", 0, 0);
        LIVE_AI_ASR_CONFIG = new SettingKey("live_ai_asr_config", "直播端智能ASR配置", new c(), new c());
        LIVE_AI_HAR = new SettingKey("live_ai_har", r.class, "直播HAR配置", new r(), new r());
        LIVE_SHUFFLE_SEQUENCE_REPORT_CONFIG = new SettingKey("live_shuffle_sequence_report_config", "混排实时特征序列上报配置", 1, 1);
        LIVE_AI_PREVIEW_WORMHOLE_CONFIG = new SettingKey("live_ai_preview_wormhole_config", "直播端智能外流预拉流配置", new LivePreviewWormholePredictConfig(), new LivePreviewWormholePredictConfig()).setPreloadCache(w.a());
        LIVE_STRATEGY_PLATFROM_SETTING_ENABLE = new SettingKey("live_strategy_platform_setting_enable", "配置从策略平台下发", r100, r100);
        STRATEGY_INFO_DATA = new SettingKey("strategy_info_data", "策略平台配置数据", "", "");
        LIVE_STREAM_DATA_MOCK = new SettingKey("live_stream_data_mock", "直播播放器流mock", 0, 0);
        LIVE_LANDSCAPE_SCROLL_ANGLE = new SettingKey("live_landscape_scroll_angle", "直播横屏内流滑动角度调整", r101, r101);
        LIVE_MULTI_CAMERA_SERVICES = new SettingKey("live_multi_camera_services", "多机位通用服务", r100, r100);
    }
}
