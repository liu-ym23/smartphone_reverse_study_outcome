package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingOption;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "请使用 ECLiveABUtils 替代")
public class EComABUtils {
    public static final String AB_EC_LIVE_DISABLE_CARD_ANIM_ON_ENTER = "ecom_disable_cart_to_card_webp_on_enter";
    public static final String AB_KEY_COUPON_LIST_URL = "live_coupon_list_url";
    public static final String AB_KEY_EC_LIVE_USE_MESSAGE_V2 = "ec_live_use_message_v2";
    public static final String AB_KEY_FLASH_BUY_URL = "live_flash_buy_url";
    public static final String AB_KEY_LIST_HEADER_OPT = "live_list_header_opt";
    public static final String AB_KEY_LIVE_OPT_SLOT = "live_new_common_slot";
    public static final String AB_KEY_LIVE_TOOLBAR_ICON_OPT = "live_toolbar_icon_opt";
    public static final String AB_KEY_NO_FILTER_NOTICE_SHOW_TIMES = "ec_live_no_filter_notice_show_times";
    public static final String AB_KEY_PICKING_PAGE_URL = "live_picking_promotion_url";
    public static final String AB_KEY_PRELOAD_LIST_IMAGES_OPT = "ecom_live_preload_list_images";
    private static final String AB_KEY_SHOW_STORE_ENTRY = "show_store_entry";
    public static final String AB_LIVE_LIST_CACHE_OPT_CLIENT_AI = "ec_live_list_cache_opt_client_ai";
    public static final String AB_LIVE_LIST_HOVER_MODE = "ecom_live_list_hover_mode";
    public static final String AB_LIVE_LIST_MEMORY_LEAK_SWITCH = "ec_live_list_memory_leak_switch";
    public static final String AB_LIVE_LIST_PRELOAD_TIME = "ec_live_list_preload_time";
    public static final String AB_LIVE_START_MEMORY_LEAK_SWITCH = "ec_live_start_memory_leak_switch";
    public static final int DEFAULT = 0;
    public static final int DEFAULT_LIVE_LIST_PANEL_HEIGHT = 73;
    public static final String ECOM_BOTTOM_ENTER_MALL_PARAMS = "ecom_bottom_enter_mall_params";
    public static final String ECOM_FAKE_CART_OPT_CINFIG = "ec_live_show_fake_cart";
    public static final String ECOM_LIVE_CARD_JUMP_SKU_CLEAR_SCREEN = "ecom_live_card_jump_sku_clear_screen";
    public static final String ECOM_LIVE_ENTER_ROOM_INIT_ADJUST = "ecom_live_enter_room_init_adjust";
    public static final String EC_LIVE_CONTROLLER_MONITOR_ENABLE = "ec_live_controller_monitor_enable";
    public static final String EC_LIVE_ENABLE_COMMON_NETWORK_REPORT = "ec_live_enable_common_network_report";
    public static final String EC_LIVE_ENABLE_NETWORK_REPORT = "ec_live_enable_network_report";
    public static final String EC_LIVE_ENABLE_NETWORK_REPORT_PATHS = "ec_live_enable_network_report_paths";
    public static final String EC_LIVE_EXTRA_REQUEST_PARAMS_PAGE_LIST = "ec_live_extra_request_params_page_list";
    public static final String EC_LIVE_EXTRA_REQUEST_PARAMS_PAGE_MAX_SIZE = "ec_live_extra_request_params_page_max_size";
    public static final String EC_LIVE_FIX_EXTRA_BUSINESS_PARAMS_SOURCE_LIST = "ec_live_fix_extra_business_params_source_list";
    public static final String EC_LIVE_REMOVE_SESITIVE_PARAMS_DISABLE_SOURCE_PAGE_LIST = "ec_live_remove_sesitive_params_disable_source_page_list";
    public static final String EC_LIVE_REMOVE_SESITIVE_PARAMS_LIST = "ec_live_remove_sesitive_params_list";
    public static String LIVE_HUAWEI_FOLDABLE_DEVICE = "live_huawei_foldable_device";
    public static final String SETTINGS_COUPON_LYNX_CONFIG = "live_commerce_lynx_url_config";
    public static final String SETTINGS_COUPON_PASSTHROUGH_PARAMS_KEY_CONFIG = "ec_live_ad_params_whitelist_config";
    public static final String SETTINGS_FLASH_CATEGORY_URL = "flash_purchase_categories_select_url";
    public static final String SETTINGS_HOUR_SHOP_DIALOG_CONFIG = "ec_live_address_alert_config";
    public static final String SETTINGS_LIVE_PARAMS_INFO = "ecom_live_params_info";
    public static final String SETTINGS_PASS_THROUGH_LOG_DATA_DENYLIST = "pass_through_log_data_denylist";
    public static final String SETTINGS_SAAS_ANCHOR_ENTRY_SHOULD_HIDE = "saas_anchor_ecom_entry_should_hide";
    public static final String SETTINGS_SHORT_TOUCH_COUPON_LYNX_CONFIG = "live_shortouch_coupon_lynx_url_config";
    public static final String SETTING_BROADCAST_LIVE_STORE_GUIDE_URL = "live_commerce_broadcast_live_store_guide_url";
    public static final String SETTING_ECOM_LIVE_PARAMS_DEPRECATE_SHOULD_NOT_SHOW = "ecom_live_params_deprecate_should_not_show";
    public static final String SETTING_ECOM_LIVE_PARAMS_DEPRECATE_SHOULD_NOT_SHOW_TIP = "ecom_live_params_deprecate_should_not_show_tip";
    public static final String SETTING_EC_LIVE_ALLOW_SCENE_ID_LIST = "ecom_live_scene_id_allow_list";
    public static final String SETTING_EC_LIVE_CART_CONFIG = "ec_live_room_cart_config";
    public static final String SETTING_EC_LIVE_CART_LOG_REPORT = "ec_live_cart_warning_report";
    public static final String SETTING_EC_LIVE_CART_LOG_RULE = "ec_live_cart_warning_rules";
    public static final String SETTING_EC_LIVE_CART_SCATTER_TIME = "ec_live_request_peak_reduce";
    public static final String SETTING_EC_LIVE_CHECK_CART_DELAY = "ec_live_check_cart_state_delay";
    public static final String SETTING_EC_LIVE_ENABLE_ENTER_REQUEST = "ec_live_enable_enter_request";
    public static final String SETTING_ENTER_ROOM_METHOD_OPT = "ec_live_enter_room_method_opt";
    public static final String SETTING_ENTER_ROOM_PARAMS_HOOK = "ec_live_enter_room_params_hook";
    public static final String SETTING_HOT_SALE_USE_NEW_MESSAGE = "iesec_hot_sale_use_new_message";
    public static final String SETTING_KEY_LIST_SKIN_CONFIG = "ecom_live_list_skin";
    public static final String SETTING_KEY_LIST_TAB_SKIN_CONFIG = "ecom_live_list_tab_skin";
    public static final String SETTING_LOTTERY_RESULT_URL = "live_commerce_lottery_url";
    public static final String SETTING_PROMOTION_LIST_USE_HISTORY_PADDING_TOP = "ec_promotion_list_use_history_padding_top";
    public static final String SETTING_SCARCE_LOTTERY_RESULT_URL = "live_commerce_scarce_lottery_url";
    public static final String SETTING_SHOULD_SHOW_FIND_SIMILAR = "live_show_find_similar";
    public static final String SETTING_SPLICING_PARAMS_CONFIG = "ecom_live_splicing_params_config";
    public static final int USE_NEW_PRICE = 1;

    public EComABUtils() {
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-数据绑定", key = "ecom_live_opt_card_load_3_bind")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2Bind() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_bind", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-doFrame", key = "ecom_live_opt_card_load_3_doframe")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2CardDoFrame() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_doframe", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-优惠券延迟", key = "ecom_live_opt_card_load_3_coupon")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2Coupon() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_coupon", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-图片doFrame", key = "ecom_live_opt_card_load_3_pic_doframe")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2PicDoFrame() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_pic_doframe", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-图片预加载", key = "ecom_live_opt_card_load_3_pic_preload")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2PicPreLoad() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_pic_preload", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-请求", key = "ecom_live_opt_card_load_3_request")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2Request() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_request", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡优化2-requestShow", key = "ecom_live_opt_card_load_3_show")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV2Show() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_3_show", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡接口进房请求", key = "ecom_live_opt_card_load_4_api")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV3Api() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_4_api", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡埋点异步加载", key = "ecom_live_opt_card_load_4_event")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV3Event() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_4_event", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡状态、按钮图片预加载", key = "ecom_live_opt_card_load_4_image")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV3Image() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_4_image", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡进房预加载布局", key = "ecom_live_opt_card_load_4_layout")
    @ECLiveSettingOption({"关闭", "开启"})
    public static int cardLoadOptV3Layout() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_card_load_4_layout", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "是否不允许商详接入降帧优化", key = "disable_anchor_v4_reduce_frame")
    @ECLiveSettingOption({"0", "1"})
    public static int disableAnchorV4ReduceFrame() {
        return ((Integer) getLiveSettingValue("disable_anchor_v4_reduce_frame", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡动态决策降级动画仅在消息生效", key = "ec_live_explain_anim_from_msg")
    @ECLiveSettingOption({"关闭", "开启"})
    public static boolean ecLiveExplainAnimFromMsg() {
        if (((Integer) getLiveSettingValue("ec_live_explain_anim_from_msg", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "商列动态资源位预加载gecko", key = "ec_live_list_access_enable")
    public static boolean ecLiveListAccessEnable() {
        if (((Integer) getLiveSettingValue("ec_live_list_access_enable", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "讲解回放背景色修正", key = "ec_live_replay_promotion_bg_fix")
    public static boolean ecLiveReplayPromotionBgFix() {
        if (((Integer) getLiveSettingValue("ec_live_replay_promotion_bg_fix", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean enableCommonNetworkReport() {
        if (((Integer) getLiveSettingValue(EC_LIVE_ENABLE_COMMON_NETWORK_REPORT, 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "直播小窗定制能力开关", key = "is_ecom_live_small_window_customized")
    public static int enableEcomLiveSmallWindowCustomized() {
        return ((Integer) getLiveSettingValue("is_ecom_live_small_window_customized", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "进房初始化方法调整", key = ECOM_LIVE_ENTER_ROOM_INIT_ADJUST)
    @ECLiveSettingOption({"关闭", "开启"})
    public static boolean enableEnterRoomInitAdjust() {
        if (((Integer) getLiveSettingValue(ECOM_LIVE_ENTER_ROOM_INIT_ADJUST, 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "即时零售直播间进房是否始终请求承接卡", key = "ec_live_enable_instant_related_card_query")
    public static boolean enableInstantRoomRelatedCardQuery() {
        if (((Integer) getLiveSettingValue("ec_live_enable_instant_related_card_query", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "是否开启大字模式", key = "ec_live_enable_big_font")
    public static boolean enableLargeModeAdapt() {
        if (((Integer) getLiveSettingValue("ec_live_enable_big_font", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "服务端接口ab加载优化", key = "enable_list_ab_opt")
    public static boolean enableListAbOpt() {
        if (((Integer) getLiveSettingValue("enable_list_ab_opt", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "讲解卡打开面板, 直播流自适应", key = "ec_live_card_notify_stream_adaptation")
    public static int enableLiveCardAdaption() {
        return ((Integer) getLiveSettingValue("ec_live_card_notify_stream_adaptation", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡收到库存开价等消息是否增补弹出", key = "ec_live_card_update_when_recv_refresh")
    public static int enableLiveCardPopRecvRefreshMsg() {
        return ((Integer) getLiveSettingValue("ec_live_card_update_when_recv_refresh", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播间是否开启动态降级能力", key = "ec_live_enable_dynamic_degrade")
    public static boolean enableLiveDynamicDegrade() {
        if (((Integer) getLiveSettingValue("ec_live_enable_dynamic_degrade", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "使用商列window新主题", key = "ec_live_list_new_window_style")
    public static boolean enableLiveListNewWindowStyle() {
        return true;
    }

    @ECLiveSettingPanel(desc = "讲解卡点击静默唤起商列", key = "ec_live_pop_card_open_list_v2")
    public static int enableLivePopCardOpenList() {
        return ((Integer) getLiveSettingValue("ec_live_pop_card_open_list_v2", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡点击静默唤起商列频控", key = "ec_live_pop_card_open_list_v2_frequency")
    public static int enableLivePopCardOpenListFrequency() {
        return ((Integer) getLiveSettingValue("ec_live_pop_card_open_list_v2_frequency", -1)).intValue();
    }

    public static boolean enableMonitorNetworkReport() {
        if (((Integer) getLiveSettingValue(EC_LIVE_ENABLE_NETWORK_REPORT, 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "讲解卡分层重构", key = "ecom_live_pop_opt_routine")
    public static boolean enablePopCardRequestTimeOpt() {
        if (((Integer) getLiveSettingValue("ecom_live_pop_opt_routine", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "商列使用schema的roomId", key = "ec_live_enable_promotion_list_use_schema_room_id")
    public static boolean enablePromotionListUseSchemaRoomId() {
        if (((Integer) getLiveSettingValue("ec_live_enable_promotion_list_use_schema_room_id", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "商列顶部信息区使用单独接口", key = "ecom_enable_request_interaction")
    @ECLiveSettingOption({"0", "1"})
    public static boolean enableRequestInteraction() {
        if (((Integer) getLiveSettingValue("ecom_enable_request_interaction", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "服务端接口依赖优化开关", key = "ecom_live_opt_routine")
    public static int enableServerRoutineOpt() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_routine", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播间主播端列表不注册打开优惠券的jsb", key = "enable_unregister_open_coupon_panel_in_anchor_framgent")
    public static boolean enableUnRegisterOpenCouponPanelInAnchorFramgent() {
        if (((Integer) getLiveSettingValue("enable_unregister_open_coupon_panel_in_anchor_framgent", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "列表信息区优化", key = AB_KEY_LIST_HEADER_OPT)
    public static int getABListHeaderOpt() {
        return ((Integer) getLiveSettingValue(AB_KEY_LIST_HEADER_OPT, 1)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播框架Controller优化", key = "ec_live_controller_cache_count")
    public static int getControllerCacheCount() {
        return ((Integer) getLiveSettingValue("ec_live_controller_cache_count", 3)).intValue();
    }

    @ECLiveSettingPanel(desc = "Hook进房的ecom_live_params和参数校验", key = SETTING_ENTER_ROOM_PARAMS_HOOK)
    @ECLiveSettingOption({"关闭", "开启"})
    private static int getECEnterRoomParamsHook() {
        return ((Integer) getLiveSettingValue(SETTING_ENTER_ROOM_PARAMS_HOOK, 1)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡展示逻辑优化", key = "ec_live_card_control_type")
    public static int getExplainCardShowOptType() {
        return ((Integer) getLiveSettingValue("ec_live_card_control_type", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "商品内容与卡片上下边缘间距", key = "ec_live_list_card_content_margin")
    public static int getLiveListCardContentMargin() {
        return ((Integer) getLiveSettingValue("ec_live_list_card_content_margin", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播商列商品卡主图高度", key = "ec_live_list_card_image_height")
    public static int getLiveListCardImageHeight() {
        return ((Integer) getLiveSettingValue("ec_live_list_card_image_height", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播商列商品卡标题样式", key = "ec_live_list_card_title_style")
    public static int getLiveListCardTitleStyle() {
        return ((Integer) getLiveSettingValue("ec_live_list_card_title_style", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播电商进房参数should_not_show_panel下线开关", key = SETTING_ECOM_LIVE_PARAMS_DEPRECATE_SHOULD_NOT_SHOW)
    public static int getLiveParamsDeprecateShouldNotShow() {
        return ((Integer) getLiveSettingValue(SETTING_ECOM_LIVE_PARAMS_DEPRECATE_SHOULD_NOT_SHOW, 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "relatedInfo最大长度", key = "ec_live_related_info_max_length")
    public static int getLiveRelatedInfoMaxLength() {
        return ((Integer) getLiveSettingValue("ec_live_related_info_max_length", -1)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播间换肤LRUCache大小", key = "ec_live_skin_lru_cache_size")
    public static int getLiveSkinLruCacheSize() {
        return ((Integer) getLiveSettingValue("ec_live_skin_lru_cache_size", 3)).intValue();
    }

    public static int getPreloadListHeadImage() {
        return ((Integer) getLiveSettingValue(AB_KEY_PRELOAD_LIST_IMAGES_OPT, 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "直播交易schema化", key = "enable_schema_opt")
    public static int getPromotionSchemaOpt() {
        return ((Integer) getLiveSettingValue("enable_schema_opt", 0)).intValue();
    }

    public static int getRoomNoFilterNoticeShowCount() {
        return ((Integer) getLiveSettingValue(AB_KEY_NO_FILTER_NOTICE_SHOW_TIMES, 0)).intValue();
    }

    public static boolean getShowStoreEntry() {
        if (((Integer) getLiveSettingValue(AB_KEY_SHOW_STORE_ENTRY, 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isDisableCardLinkedAnimOnEnter() {
        if (((Integer) getLiveSettingValue(AB_EC_LIVE_DISABLE_CARD_ANIM_ON_ENTER, 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isEnableCartAnimControl() {
        return true;
    }

    public static boolean isEnableEnterRequest() {
        if (((Integer) getLiveSettingValue(SETTING_EC_LIVE_ENABLE_ENTER_REQUEST, 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isLiveListMemoryLeakSwitch() {
        int r100 = ((Integer) getLiveSettingValue(AB_LIVE_LIST_MEMORY_LEAK_SWITCH, 1)).intValue();
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isLiveListMemoryLeakSwitchForDisposable() {
        int r100 = ((Integer) getLiveSettingValue(AB_LIVE_LIST_MEMORY_LEAK_SWITCH, 1)).intValue();
        if (r100 != 2) goto L5;
        return true;
    L5:
        if (r100 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isLiveStartMemoryLeakSwitch() {
        if (((Integer) getLiveSettingValue(AB_LIVE_START_MEMORY_LEAK_SWITCH, 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "商列请求时机优化", key = "ec_live_list_request_time_opt")
    public static boolean listRequestTimeOpt() {
        if (((Integer) getLiveSettingValue("ec_live_list_request_time_opt", 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "商列布局是否适应沉浸式布局", key = "live_list_page_adapt_translucent")
    @ECLiveSettingOption({"0", "1"})
    public static int liveListPageAdaptTranslucent() {
        return ((Integer) getLiveSettingValue("live_list_page_adapt_translucent", 1)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解回放视频预加载", key = "ec_replay_preload_enable")
    @ECLiveSettingOption({"0", "1"})
    public static boolean replayPreloadEnable() {
        if (((Integer) getLiveSettingValue("ec_replay_preload_enable", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "讲解回放视频预加载视频封面", key = "ec_replay_preload_video_cover")
    @ECLiveSettingOption({"0", "1"})
    public static boolean replayPreloadVideoCover() {
        if (((Integer) getLiveSettingValue("ec_replay_preload_video_cover", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "SaaS领券弹窗每天最多弹Toast的次数", key = "ec_saas_coupon_toast_max_show_count_daily")
    public static int saasCouponToastMaxShowCountDaily() {
        return ((Integer) getLiveSettingValue("ec_saas_coupon_toast_max_show_count_daily", 3)).intValue();
    }

    @ECLiveSettingPanel(desc = "服务端接口主动劣化", key = "ecom_live_opt_routine_reverse_step")
    public static int serverRoutineReverseStep() {
        return ((Integer) getLiveSettingValue("ecom_live_opt_routine_reverse_step", 0)).intValue();
    }

    public static boolean shouldHideSaasAnchorEntrance() {
        if (((Integer) getLiveSettingValue(SETTINGS_SAAS_ANCHOR_ENTRY_SHOULD_HIDE, 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean shouldShowFindSimilar() {
        if (((Integer) getLiveSettingValue(SETTING_SHOULD_SHOW_FIND_SIMILAR, 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "服务端只会在首刷page接口下发skinType，修复skinType被重置问题", key = "ec_live_skin_type_fix")
    public static boolean skinTypeFix() {
        if (((Integer) getLiveSettingValue("ec_live_skin_type_fix", 1)).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @ECLiveSettingPanel(desc = "讲解卡跳转SKU面板调用直播清屏能力", key = ECOM_LIVE_CARD_JUMP_SKU_CLEAR_SCREEN)
    @ECLiveSettingOption({"0", "1"})
    public static int useClearScreenAbilityFromCard() {
        return ((Integer) getLiveSettingValue(ECOM_LIVE_CARD_JUMP_SKU_CLEAR_SCREEN, 0)).intValue();
    }

    public static boolean useLiveListHoverMode() {
        if (((Integer) getLiveSettingValue(AB_LIVE_LIST_HOVER_MODE, 0)).intValue() != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @ECLiveSettingPanel(desc = "商列自动领券逻辑优化是否开启", key = "ec_live_list_new_auto_apply_coupon_opt")
    @ECLiveSettingOption({"0", "1"})
    public static int useNewLiveListAutoApplyCouponOpt() {
        return ((Integer) getLiveSettingValue("ec_live_list_new_auto_apply_coupon_opt", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "使用新商品信息刷新消息", key = "ec_use_new_product_refresh_message")
    public static int useNewProductRefreshMessage() {
        return ((Integer) getLiveSettingValue("ec_use_new_product_refresh_message", 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡热卖数字变化时补充时长", key = "ec_live_card_hot_atmosphere_extend_time")
    public static long cardHotAtmosphereExtendTime() {
        return ((Long) getLiveSettingValue("ec_live_card_hot_atmosphere_extend_time", 0L)).longValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡遮挡恢复延长时长", key = "ec_live_card_obscured_extend_time")
    public static long cardObscuredExtendTime() {
        return ((Long) getLiveSettingValue("ec_live_card_obscured_extend_time", 0L)).longValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡弹出策略配置", key = "ec_live_card_pop_up_strategy")
    public static String cardPopupStrategyConfig() {
        return (String) getLiveSettingValue("ec_live_card_pop_up_strategy", "");
    }

    @ECLiveSettingPanel(desc = "直播间短触区优惠券旧渲染链路下线开关", key = "ecom_live_disable_legacy_load_coupon_render_logic")
    public static boolean disableLegacyLoadCouponRenderLogic() {
        return ((Boolean) getLiveSettingValue("ecom_live_disable_legacy_load_coupon_render_logic", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "更多直播入口根据用户行为修改文案", key = "drawer_entrance_show_ecom")
    public static boolean drawerEntranceShowEcom() {
        return ((Boolean) getLiveSettingValue("drawer_entrance_show_ecom", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "商列动态资源位预加载gecko channel", key = "ec_live_list_access_channels")
    public static List<String> ecLiveListAccessChannels() {
        return (List) getLiveSettingValue("ec_live_list_access_channels", new ArrayList());
    }

    @ECLiveSettingPanel(desc = "底部进房参数实验", key = ECOM_BOTTOM_ENTER_MALL_PARAMS)
    public static si2.w ecomBottomEnterMallParams() {
        return (si2.w) getLiveSettingValue(ECOM_BOTTOM_ENTER_MALL_PARAMS, new si2.w());
    }

    @ECLiveSettingPanel(desc = "check/v2返回数据拼接到promotion", key = "ecom_live_check_resp_append_promotion")
    public static boolean enableCheckRespAppendPromotion() {
        return ((Boolean) getLiveSettingValue("ecom_live_check_resp_append_promotion", Boolean.TRUE)).booleanValue();
    }

    public static String enableCommonNetworkReportPaths() {
        return (String) getLiveSettingValue(EC_LIVE_ENABLE_NETWORK_REPORT_PATHS, "");
    }

    @ECLiveSettingPanel(desc = "直播框架Controller优化", key = "ec_live_controller_opt")
    public static boolean enableControllerOpt() {
        return ((Boolean) getLiveSettingValue("ec_live_controller_opt", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "直播框架Converter优化", key = "ec_live_controller_opt")
    public static boolean enableConverterOpt() {
        return ((Boolean) getLiveSettingValue("ec_live_converter_opt", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "是否打开直播间EcLiveControllerMonitor监控", key = EC_LIVE_CONTROLLER_MONITOR_ENABLE)
    public static boolean enableEcLiveControllerMonitor() {
        return ((Boolean) getLiveSettingValue(EC_LIVE_CONTROLLER_MONITOR_ENABLE, Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "是否开启讲解卡监控埋点开关", key = "ec_live_card_report_monitor_switch")
    public static boolean enableExplainCardMonitor() {
        return ((Boolean) getLiveSettingValue("ec_live_card_report_monitor_switch", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "修复开播前商品滤镜无法关闭问题", key = "ec_live_fix_commodity_no_filter")
    public static Boolean enableFixCommodityNoFilter() {
        return (Boolean) getLiveSettingValue("ec_live_fix_commodity_no_filter", Boolean.TRUE);
    }

    @ECLiveSettingPanel(desc = "修复商列打开滚动到底部的问题", key = "ecom_live_fix_list_scroll_bottom")
    public static boolean enableFixLiveListScrollBottom() {
        return ((Boolean) getLiveSettingValue("ecom_live_fix_list_scroll_bottom", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "新框架讲解卡, 进房的时候是否讲解卡有弹出的动效", key = "ec_live_enable_intro_card_enter_room_anim")
    public static boolean enableIntroCardEnterRoomAnim() {
        return ((Boolean) getLiveSettingValue("ec_live_enable_intro_card_enter_room_anim", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "修复商品卡非常驻左上角标签一闪而过", key = "ec_live_list_fix_flicker_icon")
    public static boolean enableListFlickerIconFix() {
        return ((Boolean) getLiveSettingValue("ec_live_list_fix_flicker_icon", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡动画切换线程", key = "ec_live_anim_controller_not_change_thread")
    public static boolean enableLiveAnimControllerNotChangeThread() {
        return ((Boolean) getLiveSettingValue("ec_live_anim_controller_not_change_thread", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "是否打开电商膨胀券优化开关", key = "ec_live_expansion_coupon")
    public static boolean enableLiveExpansionCoupon() {
        return ((Boolean) getLiveSettingValue("ec_live_expansion_coupon", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "修复商列锚定底部问题", key = "ec_live_fix_bottom_select")
    public static boolean enableLiveFixBottomSelect() {
        return ((Boolean) getLiveSettingValue("ec_live_fix_bottom_select", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "修复直播间回调生命周期导致电商初始化crash问题", key = "ec_live_fix_function_handler_attached")
    public static boolean enableLiveFixFunctionHandlerAttached() {
        return ((Boolean) getLiveSettingValue("ec_live_fix_function_handler_attached", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "直播商列数据流监控开关", key = "ec_live_list_stream_monitor_enable")
    public static boolean enableLiveListStreamMonitor() {
        return ((Boolean) getLiveSettingValue("ec_live_list_stream_monitor_enable", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "讲解卡点击静默唤起商列延迟时间", key = "ec_live_pop_card_open_list_delay_time")
    public static int enableLivePopCardOpenListDelayTime() {
        return ((Integer) getLiveSettingValue("ec_live_pop_card_open_list_delay_time", 1000)).intValue();
    }

    @ECLiveSettingPanel(desc = "是否开启直播间接口重定向", key = "ec_live_enable_live_url_redirect")
    public static Boolean enableLiveUrlRedirect() {
        return (Boolean) getLiveSettingValue("ec_live_enable_live_url_redirect", Boolean.TRUE);
    }

    @ECLiveSettingPanel(desc = "C侧M3流量标识开关", key = "ec_live_m3_traffic_distinguish_mark_switch")
    public static boolean enableM3TrafficDistinguishMark() {
        return ((Boolean) getLiveSettingValue("ec_live_m3_traffic_distinguish_mark_switch", Boolean.TRUE)).booleanValue();
    }

    public static boolean enableOptCouponLoad() {
        return ((Boolean) getLiveSettingValue("ecom_live_opt_coupon_load", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "讲解回放支持评价互动", key = "ecom_enable_replay_interaction")
    public static boolean enableReplayInteraction() {
        return ((Boolean) getLiveSettingValue("ecom_enable_replay_interaction", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "SaaS动效降级总开关", key = "saas_device_degrade_main_switch")
    public static boolean enableSaasDeviceDegrade() {
        return ((Boolean) getLiveSettingValue("saas_device_degrade_main_switch", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "SaaS讲解卡优化总开关", key = "saas_promotion_card_opt_main_switch")
    public static boolean enableSaasPromotionCardOpt() {
        return ((Boolean) getLiveSettingValue("saas_promotion_card_opt_main_switch", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "进房接口匹配 enter_room", key = "ec_live_enter_room_related_match")
    public static boolean enalbeLiveEnterRoomRelatedMatch() {
        return ((Boolean) getLiveSettingValue("ec_live_enter_room_related_match", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "强制进房预加载商列数据", key = "force_preload_live_list_data")
    public static boolean forcePreloadLiveListData() {
        return ((Boolean) getLiveSettingValue("force_preload_live_list_data", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "直播间商列兼容商品屏蔽逻辑", key = "ec_live_list_adapt_product_block")
    public static boolean getAdaptProductBlockSwitch() {
        return ((Boolean) getLiveSettingValue("ec_live_list_adapt_product_block", Boolean.TRUE)).booleanValue();
    }

    public static ECResultDialogContentVO getAlertAddressDialogConfig() {
        return (ECResultDialogContentVO) getLiveSettingValue(SETTINGS_HOUR_SHOP_DIALOG_CONFIG, new ECResultDialogContentVO());
    }

    @ECLiveSettingPanel(desc = "直播间网络请求Catch异常", key = "ec_live_get_api_data_catch_exception")
    public static boolean getApiDataCatchException() {
        return ((Boolean) getLiveSettingValue("ec_live_get_api_data_catch_exception", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "控制是否要分发给事件消费者，可以针对某一 consumer 独立控制", key = "ars_consumer_white_list")
    public static List<String> getArsConsumerWhitList() {
        return (List) getLiveSettingValue("ars_consumer_white_list", new ArrayList(Arrays.asList(new String[]{com.bytedance.android.ec.core.event.a.KEY_TRACKER, "slardar", "logger"})));
    }

    @ECLiveSettingPanel(desc = "用来扩展通用 event 的参数，会根据 module + action + event 匹配新的 event，配置才生效", key = "ars_event_map_list")
    public static List<String> getArsEventMapList() {
        return (List) getLiveSettingValue("ars_event_map_list", new ArrayList());
    }

    @ECLiveSettingPanel(desc = "控制埋点上报采样率，可以针对某一 event 独立控制", key = "ars_tracker_sampling")
    public static Map<String, String> getArsTrackerSampling() {
        return (Map) getLiveSettingValue("ars_tracker_sampling", new HashMap());
    }

    @ECLiveSettingPanel(desc = "检测小黄车是否展示延时，默认4s", key = SETTING_EC_LIVE_CHECK_CART_DELAY)
    public static long getCheckCartStateDelay() {
        return ((Integer) getLiveSettingValue(SETTING_EC_LIVE_CHECK_CART_DELAY, 4000)).intValue();
    }

    public static String getCouponListUrl() {
        return (String) getLiveSettingValue(AB_KEY_COUPON_LIST_URL, "https://lf3-static.bytednsdoc.com/obj/eden-cn/lrnuhduloj/iesec/webcast_coupon/coupon/online_resource/template.js");
    }

    @ECLiveSettingPanel(desc = "直播电商进房券透传参数白名单配置", key = SETTINGS_COUPON_PASSTHROUGH_PARAMS_KEY_CONFIG)
    public static List<String> getCouponPassthroughParamsKeyConfig() {
        return (List) getLiveSettingValue(SETTINGS_COUPON_PASSTHROUGH_PARAMS_KEY_CONFIG, new ArrayList());
    }

    @ECLiveSettingPanel(desc = "直播电商接口登录校验名单", key = "ec_live_network_api_check_list")
    public static List<String> getECNetworkAPICheckList() {
        List<String> r100 = vi2.t0.f555262a;
        return (List) getLiveSettingValue("ec_live_network_api_check_list", vi2.t0.f555262a);
    }

    @ECLiveSettingPanel(desc = "即时零售直播电商接口登录校验名单", key = "ec_live_network_api_check_list_instant")
    public static List<String> getECNetworkInstantAPICheckList() {
        List<String> r100 = vi2.t0.f555262a;
        return (List) getLiveSettingValue("ec_live_network_api_check_list_instant", vi2.t0.f555262a);
    }

    public static String getECOMLiveParamsInfo() {
        return (String) getLiveSettingValue(SETTINGS_LIVE_PARAMS_INFO, "");
    }

    @ECLiveSettingPanel(desc = "精选频道预加载实验", key = "ecom_live_channel_prefetch_opt")
    public static li2.b getEcLiveChannelPrefetchOpt() {
        return (li2.b) getLiveSettingValue("ecom_live_channel_prefetch_opt", new li2.b());
    }

    @ECLiveSettingPanel(desc = "精选频道预加载实验测试", key = "ecom_live_channel_prefetch_opt_debug")
    public static boolean getEcLiveChannelPrefetchOptDebug() {
        return ((Boolean) getLiveSettingValue("ecom_live_channel_prefetch_opt_debug", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "商列提示条吸顶/跟滑", key = "ecom_live_promotion_list_hint_bar_opt_config")
    public static mj2.a getEcomLivePromotionListHintBarOptConfig() {
        return (mj2.a) getLiveSettingValue("ecom_live_promotion_list_hint_bar_opt_config", new mj2.a());
    }

    public static boolean getEnterRoomMethodOpt() {
        return ((Boolean) getLiveSettingValue(SETTING_ENTER_ROOM_METHOD_OPT, Boolean.TRUE)).booleanValue();
    }

    public static String getFlashCategoryUrl() {
        return (String) getLiveSettingValue(SETTINGS_FLASH_CATEGORY_URL, "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_webcast_legacy_aweme%2Fhtml%2Fpages%2Fflash_purchase_categories_select%2Findex.html%3Fis_half_screen%3D1%26is_commerce_url%3D1%26height%3D480%26type%3Dpopup%26gravity%3Dbottom%26web_bg_color%3D%2523ffffff%26show_from%3Dright%26categories%3Dcategories_placeholder%26categoriesName%3Dcategories_name_placeholder%26anchor_id%3Danchor_id_placeholder&type=popup&gravity=bottom&height_percent=73&add_safe_area_height=0&web_bg_color=%2523ffffff&engine_type=new&host=aweme&use_real_screen_height=1");
    }

    public static String getFlashUrl() {
        return (String) getLiveSettingValue(AB_KEY_FLASH_BUY_URL, "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_webcast_legacy_aweme%2Fhtml%2Fpages%2Fflash_purchase_setting%2Fcontainers%2Fsetting_index%2Findex.html%3Fis_half_screen%3D1%26is_commerce_url%3D1%26type%3Dpopup%26gravity%3Dbottom%26web_bg_color%3D%2523ffffff%26show_from%3Dright%26room_id%3Droom_id_placeholder &web_bg_color=%2523ffffff&height_percent=73&type=popup&gravity=bottom&add_safe_area_height=0&host=aweme&engine_type=new&use_real_screen_height=1");
    }

    public static int getHuaweiFoldableDevice() {
        return ((Integer) getLiveSettingValue(LIVE_HUAWEI_FOLDABLE_DEVICE, 0)).intValue();
    }

    @ECLiveSettingPanel(desc = "即时零售能力Map", key = "ec_live_instant_room_func_map")
    public static String getInstantRoomFuncMap() {
        return (String) getLiveSettingValue("ec_live_instant_room_func_map", "");
    }

    @ECLiveSettingPanel(desc = "即时零售直播间进房预加载配置", key = "ec_live_instant_room_preload_config")
    public static String getInstantRoomPreloadConfig() {
        return (String) getLiveSettingValue("ec_live_instant_room_preload_config", "");
    }

    @ECLiveSettingPanel(desc = "直播商列讲解置顶商品讲解状态优化", key = "ec_list_explain_msg_opt_config")
    public static String getListExplainMsgOptConfig() {
        return (String) getLiveSettingValue("ec_list_explain_msg_opt_config", "");
    }

    @ECLiveSettingPanel(desc = "即时零售融合场景商列区域左边距", key = "ec_live_list_instant_fusion_margin_left")
    public static int getListLeftMarginInInstantFusion() {
        return ((Integer) getLiveSettingValue("ec_live_list_instant_fusion_margin_left", 76)).intValue();
    }

    @ECLiveSettingPanel(desc = "商列tab强化样式配置", key = "ec_live_list_tab_enhance_style")
    public static String getListTabEnhanceConfig() {
        return (String) getLiveSettingValue("ec_live_list_tab_enhance_style", "");
    }

    @ECLiveSettingPanel(desc = "商列卡顿优化", key = "ec_live_list_fps_opt")
    public static ECLiveFpsOptConfig getLiveListFpsOptConfig() {
        return (ECLiveFpsOptConfig) getLiveSettingValue("ec_live_list_fps_opt", new ECLiveFpsOptConfig());
    }

    @ECLiveSettingPanel(desc = "商列推荐实验字段", key = "live_list_recommended_ab_tag")
    public static String getLiveListRecommendedABTag() {
        return (String) getLiveSettingValue("live_list_recommended_ab_tag", "");
    }

    public static String getLiveListSkinConfig() {
        return (String) getLiveSettingValue(SETTING_KEY_LIST_SKIN_CONFIG, "");
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return "";
    }

    public static String getLiveListTabSkinConfig() {
        return (String) getLiveSettingValue(SETTING_KEY_LIST_TAB_SKIN_CONFIG, "");
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return "";
    }

    @ECLiveSettingPanel(desc = "直播长按找相似", key = "ec_live_long_press_find_similarity_v3")
    public static boolean getLiveLongPressFindSimilarity() {
        return ((Boolean) getLiveSettingValue("ec_live_long_press_find_similarity_v3", Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "直播长按找相似引导动画", key = "ec_live_long_press_find_similarity_guide_v2")
    public static String getLiveLongPressFindSimilarityGuide() {
        return (String) getLiveSettingValue("ec_live_long_press_find_similarity_guide_v2", "");
    }

    @ECLiveSettingPanel(desc = "进房参数提示文案", key = SETTING_ECOM_LIVE_PARAMS_DEPRECATE_SHOULD_NOT_SHOW_TIP)
    public static String getLiveParamsDeprecateShouldNotShowTip() {
        return (String) getLiveSettingValue(SETTING_ECOM_LIVE_PARAMS_DEPRECATE_SHOULD_NOT_SHOW_TIP, "新版本进房唤起列表能力should_not_show_panel字段已废弃，请使用should_show_panel（0:不唤起，1:唤起列表），具体请咨询chenpan.julian.0224");
    }

    @ECLiveSettingPanel(desc = "直播电商接口拼接地址参数时，支持的bizcode列表", key = "ec_live_request_addr_bizcodes")
    public static List<String> getLiveRequestAddressBizCodes() {
        return (List) getLiveSettingValue("ec_live_request_addr_bizcodes", new ArrayList());
    }

    public static si2.u getLynxUrlConfig() {
        return (si2.u) getLiveSettingValue(SETTINGS_COUPON_LYNX_CONFIG, new si2.u());
    }

    @ECLiveSettingPanel(desc = "直播电商接口可重定向的白名单", key = "ec_live_network_api_enable_redirect_list")
    public static List<String> getNetworkAPIEnableRedirectList() {
        return (List) getLiveSettingValue("ec_live_network_api_enable_redirect_list", new ArrayList());
    }

    @ECLiveSettingPanel(desc = "直播电商接口需要拼接地址参数的白名单", key = "ec_live_network_api_need_append_addr")
    public static List<String> getNetworkAPINeedAppendAddressInfo() {
        return (List) getLiveSettingValue("ec_live_network_api_need_append_addr", new ArrayList());
    }

    public static List<String> getPassThroughLogDataDenyList() {
        return (List) getLiveSettingValue(SETTINGS_PASS_THROUGH_LOG_DATA_DENYLIST, new ArrayList());
    }

    @ECLiveSettingPanel(desc = "relatedInfo中需要透传给Server的配置相关key", key = "ec_live_related_info_common_key")
    public static List<String> getRelatedInfoCommonKey() {
        return (List) getLiveSettingValue("ec_live_related_info_common_key", new ArrayList(Collections.singleton("related_config")));
    }

    public static ECPromotionList.u getRoomCartSetting() {
        return (ECPromotionList.u) getLiveSettingValue(SETTING_EC_LIVE_CART_CONFIG, ECPromotionList.u.f149502a);
    }

    @ECLiveSettingPanel(desc = "SaaS Lynx优惠券卡片展示延迟", key = "ec_live_saas_lynx_coupon_delay_time")
    public static long getSaaSLynxCardDelay() {
        return ((Long) getLiveSettingValue("ec_live_saas_lynx_coupon_delay_time", 2000L)).longValue();
    }

    public static si2.n getScatterTimeSetting() {
        return (si2.n) getLiveSettingValue(SETTING_EC_LIVE_CART_SCATTER_TIME, si2.n.f542188a);
    }

    public static String getSettingBroadcastLiveStoreGuideUrl() {
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        if (r100.isDebug() == true) goto L10;
        if (r100.isLocalTest() == true) goto L10;
        return (String) getLiveSettingValue(SETTING_BROADCAST_LIVE_STORE_GUIDE_URL, "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_ecommerce_live_pages%2Flive_store_notice_dialog%2Ftemplate.js\n&type=popup&gravity=center&open_animate=0&width_percent=100&height_percent=100&show_dim=1&mask_alpha=0.15&horizontal_width_percent=100&horizontal_height_percent=100&enable_full_screen=1&load_taro=0");
    L10:
        return (String) getLiveSettingValue(SETTING_BROADCAST_LIVE_STORE_GUIDE_URL, "sslocal://webcast_lynxview?url=https%3A%2F%2Ftosv.byted.org%2Fobj%2Fgecko-internal%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_ecommerce_live_pages%2Flive_store_notice_dialog%2Ftemplate.js\n&type=popup&gravity=center&open_animate=0&width_percent=100&height_percent=100&show_dim=1&mask_alpha=0.15&horizontal_width_percent=100&horizontal_height_percent=100&enable_full_screen=1&load_taro=0");
    }

    public static String getSettingLotteryResultUrl() {
        return (String) getLiveSettingValue(SETTING_LOTTERY_RESULT_URL, "sslocal://webcast_lynxview?type=popup&gravity=center&open_animate=0&width_percent=100&height_percent=100&show_dim=1&mask_alpha=0.5&horizontal_width_percent=100&horizontal_height_percent=100&enable_full_screen=1&load_taro=0&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_ecommerce_lottery%2Fresult_panel%2Ftemplate.js");
    }

    public static String getSettingScarceLotteryResultUrl() {
        return (String) getLiveSettingValue(SETTING_SCARCE_LOTTERY_RESULT_URL, "sslocal://webcast_lynxview?type=popup&gravity=center&open_animate=0&width_percent=100&height_percent=100&show_dim=1&mask_alpha=0.5&horizontal_width_percent=100&horizontal_height_percent=100&enable_full_screen=1&load_taro=0&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_ecommerce_lottery%2Fscarce_goods_result_panel%2Ftemplate.js");
    }

    public static com.bytedance.android.livesdk.livecommerce.room.coupon.f getShortTouchCouponLynxConfig() {
        return (com.bytedance.android.livesdk.livecommerce.room.coupon.f) getLiveSettingValue(SETTINGS_SHORT_TOUCH_COUPON_LYNX_CONFIG, com.bytedance.android.livesdk.livecommerce.room.coupon.f.f151834a);
    }

    public static ECFindSimilarConfig getSimilarConfig() {
        return (ECFindSimilarConfig) getLiveSettingValue("ec_find_similar_config", new ECFindSimilarConfig());
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return new ECFindSimilarConfig();
    }

    public static si2.o getSplicingParamsConfig() {
        return (si2.o) getLiveSettingValue(SETTING_SPLICING_PARAMS_CONFIG, new si2.o());
    }

    @ECLiveSettingPanel(desc = "ARS 整体开关", key = "ars_enable")
    public static boolean isArsEnable() {
        return ((Boolean) getLiveSettingValue("ars_enable", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "切换商铺时关闭搜索页面", key = "ec_live_close_search_fragment_enable")
    public static boolean isCloseSearchFragmentEnable() {
        return ((Boolean) getLiveSettingValue("ec_live_close_search_fragment_enable", Boolean.TRUE)).booleanValue();
    }

    public static boolean isEnableLiveOptSlot() {
        return ((Boolean) getLiveSettingValue(AB_KEY_LIVE_OPT_SLOT, Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "商详讲解回放视频优化展示策略优化", key = "ec_live_outer_entrance_info_report")
    public static boolean isOuterEntranceInfoReport() {
        return ((Boolean) getLiveSettingValue("ec_live_outer_entrance_info_report", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "SaaS Lynx优惠券卡片showDuration埋点是否端上上报", key = "ec_live_saas_lynx_coupon_duration_event")
    public static boolean isSaaSLynxCouponDurationEventNAReport() {
        return ((Boolean) getLiveSettingValue("ec_live_saas_lynx_coupon_duration_event", Boolean.TRUE)).booleanValue();
    }

    public static boolean isToolbarIconOpt() {
        return ((Boolean) getLiveSettingValue(AB_KEY_LIVE_TOOLBAR_ICON_OPT, Boolean.FALSE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "商详讲解回放ecom_scene_id优化", key = "ec_replay_use_origin_ecom_scene_id")
    public static boolean isUseOriginEcomSceneId() {
        return ((Boolean) getLiveSettingValue("ec_replay_use_origin_ecom_scene_id", Boolean.TRUE)).booleanValue();
    }

    @ECLiveSettingPanel(desc = "跳转首页商城还原直播间schema ecomLiveParams白名单兜底", key = "ec_live_jump_xtab_mall_live_entrance_ecom_params")
    public static Map<String, String> jumpXtabMallLiveEntranceEcomParams() {
        return (Map) getLiveSettingValue("ec_live_jump_xtab_mall_live_entrance_ecom_params", new HashMap());
    }

    @ECLiveSettingPanel(desc = "跳转首页商城还原直播间schema query白名单兜底", key = "ec_live_jump_xtab_mall_live_entrance_params")
    public static Map<String, String> jumpXtabMallLiveEntranceParams() {
        return (Map) getLiveSettingValue("ec_live_jump_xtab_mall_live_entrance_params", new HashMap());
    }

    @ECLiveSettingPanel(desc = "讲解卡直播流自适应白名单", key = "ec_live_card_stream_adaptation_white_list")
    public static List<String> liveCardAdaptionWhiteList() {
        return (List) getLiveSettingValue("ec_live_card_stream_adaptation_white_list", new ArrayList());
    }

    @ECLiveSettingPanel(desc = "针对enter_from_merge和enter_method，配置下发不同的path，只给这些path增加额外请求参数", key = EC_LIVE_EXTRA_REQUEST_PARAMS_PAGE_LIST)
    public static Map<String, List<String>> liveExtraRequestParmasPageList() {
        return (Map) getLiveSettingValue(EC_LIVE_EXTRA_REQUEST_PARAMS_PAGE_LIST, new HashMap());
    }

    @ECLiveSettingPanel(desc = "针对enter_from_merge和enter_method，配置下发不同的path，只给这些path增加额外请求参数的最大长度", key = EC_LIVE_EXTRA_REQUEST_PARAMS_PAGE_MAX_SIZE)
    public static int liveExtraRequestParmasPageMaxSize() {
        return ((Integer) getLiveSettingValue(EC_LIVE_EXTRA_REQUEST_PARAMS_PAGE_MAX_SIZE, 1024)).intValue();
    }

    @ECLiveSettingPanel(desc = "统一进房pass_through_log_data参数修复白名单", key = EC_LIVE_FIX_EXTRA_BUSINESS_PARAMS_SOURCE_LIST)
    public static List<String> liveFixExtraBusinessParamsSourceList() {
        return (List) getLiveSettingValue(EC_LIVE_FIX_EXTRA_BUSINESS_PARAMS_SOURCE_LIST, new ArrayList());
    }

    public static int liveListCacheTabDataCount() {
        return ((Integer) getLiveSettingValue("ec_live_list_cache_tab_data_count", 10)).intValue();
    }

    @ECLiveSettingPanel(desc = "商列头部布局配置", key = "ec_live_list_header_layout_config")
    public static String liveListHeaderLayoutConfig() {
        return (String) getLiveSettingValue("ec_live_list_header_layout_config", "");
    }

    @ECLiveSettingPanel(desc = "商品列表分页加载提前加载距离", key = "ec_live_list_preload_page_count")
    public static int liveListLoadPagePrefetchDistance() {
        return ((Integer) getLiveSettingValue("ec_live_list_preload_page_count", 10)).intValue();
    }

    @ECLiveSettingPanel(desc = "商品列表分页加载页面大小", key = "ec_live_list_page_count")
    public static int liveListLoadPageSize() {
        return ((Integer) getLiveSettingValue("ec_live_list_page_count", 20)).intValue();
    }

    @ECLiveSettingPanel(desc = "商品列表面板高度", key = "ec_live_panel_height_percent")
    public static int liveListPanelHeight() {
        return ((Integer) getLiveSettingValue("ec_live_panel_height_percent", 73)).intValue();
    }

    @ECLiveSettingPanel(desc = "到家直播间商品列表面板高度", key = "ec_live_panel_height_percent_instant")
    public static int liveListPanelHeightInstant() {
        return ((Integer) getLiveSettingValue("ec_live_panel_height_percent_instant", 73)).intValue();
    }

    @ECLiveSettingPanel(desc = "关闭无条件移除pass_through_log_data中存在的直播电商敏感参数", key = EC_LIVE_REMOVE_SESITIVE_PARAMS_DISABLE_SOURCE_PAGE_LIST)
    public static List<String> liveRemoveSesitiveParamsDisableSourcePageList() {
        return (List) getLiveSettingValue(EC_LIVE_REMOVE_SESITIVE_PARAMS_DISABLE_SOURCE_PAGE_LIST, new ArrayList());
    }

    @ECLiveSettingPanel(desc = "无条件移除pass_through_log_data中存在的直播电商敏感参数", key = EC_LIVE_REMOVE_SESITIVE_PARAMS_LIST)
    public static List<String> liveRemoveSesitiveParamsList() {
        return (List) getLiveSettingValue(EC_LIVE_REMOVE_SESITIVE_PARAMS_LIST, new ArrayList());
    }

    @ECLiveSettingPanel(desc = "讲解回放视频预加载超时", key = "ec_replay_preload_timeout")
    public static long replayPreloadTimeout() {
        return ((Long) getLiveSettingValue("ec_replay_preload_timeout", 10L)).longValue() * 1000;
    }

    @ECLiveSettingPanel(desc = "使用新商品信息刷新热卖氛围", key = "ec_use_product_refresh_message_atmosphere")
    public static boolean useNewProductRefreshMessageAtmosphere() {
        return ((Boolean) getLiveSettingValue("ec_use_product_refresh_message_atmosphere", Boolean.FALSE)).booleanValue();
    }

    public static boolean usePromotionListHistoryPaddingTop() {
        return ((Boolean) getLiveSettingValue(SETTING_PROMOTION_LIST_USE_HISTORY_PADDING_TOP, Boolean.FALSE)).booleanValue();
    }

    public static boolean getEnterRoomParamsHook() {
        if (getECEnterRoomParamsHook() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int liveListCacheExpireTime() {
        return ((Integer) getLiveSettingValue("ec_live_list_cache_expire_time", 300000)).intValue();
    }

    @ECLiveSettingPanel(desc = "商列自动领券是否使用新消息", key = "ec_live_list_new_auto_apply_coupon")
    @ECLiveSettingOption({"0", "1"})
    public static int useNewLiveListAutoApplyCoupon(int r100) {
        return ((Integer) getLiveSettingValue("ec_live_list_new_auto_apply_coupon", Integer.valueOf(r100))).intValue();
    }

    private static <T> T getAbLibraValue(String r100, T r101) {
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L9;
        T r104 = (T) r103.getLiveSettingsValue(r100, r101);
        if (r104 != null) goto L8;
        return r101;
    L8:
        return r104;
    L9:
        return r101;
    }

    public static <T> T getLiveSettingValue(String r100, T r101) {
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L9;
        T r104 = (T) r103.getLiveSettingsValue(r100, r101);
        if (r104 != null) goto L8;
        return r101;
    L8:
        return r104;
    L9:
        return r101;
    }
}
