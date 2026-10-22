package com.bytedance.android.ec.core.event;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventParam;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.h2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.ec.sdk.helper.r;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a implements com.bytedance.android.ec.core.event.d, tg.a {
    public static final C0793a Companion = null;
    public static final String EVENT_PDP_MODULE_CLICK = "pdp_module_click";
    public static final String EVENT_PDP_MODULE_SHOW = "pdp_module_show";
    public static final String FEEDBACK_TYPE = "type";
    public static final String KEY_ACTION_TYPE = "action_type";
    public static final String KEY_ACTIVITY_LABEL = "activity_label";
    public static final String KEY_ACTIVITY_TYPE = "activity_type";
    public static final String KEY_ACTIVITY_URL = "activity_url";
    public static final String KEY_ADD_CART_GUIDE_POPOP_UP_SHOW = "add_cart_guide_popup_show";
    public static final String KEY_AD_EXTRA_DATA = "ad_extra_data";
    public static final String KEY_AD_TYPE = "ad_type";
    public static final String KEY_AFTERSALE_INFORMATION = "aftersale_information";
    public static final String KEY_ALL_VIDEO_CNT = "all_video_cnt";
    public static final String KEY_ANCHOR_ID = "anchor_id";
    public static final String KEY_ANCHOR_LABEL_SHOW = "is_label_show";
    public static final String KEY_ANCHOR_PRODUCT_DETAIL_INFO = "anchor_detail_info";
    public static final String KEY_API_DURATION = "api_duration";
    public static final String KEY_APPLY_COUPON_IDS = "coupon_id";
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_APT_PATH_ID = "apt_path_id";
    public static final String KEY_ASK_AROUND_MODULE = "askaround_module";
    public static final String KEY_ATTR_ID = "attr_id";
    public static final String KEY_AUTHOR_ID = "author_id";
    public static final String KEY_AUTO_APPLY_COUPON = "auto_coupon";
    public static final String KEY_AVL_DISCOUNT = "avl_discount";
    public static final String KEY_BAR_TEXT = "bar_text";
    public static final String KEY_BASE_VERIFIED_CATEGORY = "base_verified_category";
    public static final String KEY_BELT_DETAIL = "belt_detail";
    public static final String KEY_BENEFIT_TYPE = "benefit_type";
    public static final String KEY_BIND_CARD_FLAG = "bind_card_flag";
    public static final String KEY_BIOMETRIC_PARAMS = "biometric_params";
    public static final String KEY_BIO_TYPE = "bio_type";
    public static final String KEY_BRAND_VERIFIED = "brand_verified";
    public static final String KEY_BST_GROUP_TYPE = "bst_group_type";
    public static final String KEY_BUSINESS_TYPE = "business_type";
    public static final String KEY_BUTTON_NAME = "button_name";
    public static final String KEY_BUTTON_STATUS = "button_status";
    public static final String KEY_BUTTON_TYPE = "button_type";
    public static final String KEY_BUYIN_TRACK = "buyin_track";
    public static final String KEY_CAMPAIGN_EXTRA_TYPE = "campaign_extra_type";
    public static final String KEY_CAMPAIGN_PRESELECT_CLICK = "product_detail_campaign_preselect_click";
    public static final String KEY_CARD_STATUS = "card_status";
    public static final String KEY_CARD_TYPE = "card_type";
    public static final String KEY_CARRIER_SOURCE = "carrier_source";
    public static final String KEY_CARRIER_TYPE = "carrier_type";
    public static final String KEY_CART_BUTTON_STATUS = "cart_button_status";
    public static final String KEY_CASH_REBATE = "cash_rebate";
    public static final String KEY_CASH_REBATE_ID = "cash_rebate_id";
    public static final String KEY_CHANGE_TAB_TO = "change_tab_to";
    public static final String KEY_CHANNEL_ID = "chnid";
    public static final String KEY_CID = "cid";
    public static final String KEY_CJ_INFO = "cj_info";
    public static final String KEY_CJ_SDK = "cj_sdk";
    public static final String KEY_CLASSIFICATION_BUTTON_ITEM = "classification_button_item";
    public static final String KEY_CLICK_AREA = "click_area";
    public static final String KEY_CLICK_ECOM_MODULE = "click_ecom_module";
    public static final String KEY_CLICK_ORDER = "click_order";
    public static final String KEY_CLICK_PRODUCT = "click_product";
    public static final String KEY_CLICK_PRODUCT_ACTIVITY = "click_product_activity";
    public static final String KEY_CLICK_PRODUCT_STATUS = "click_product_status";
    public static final String KEY_CLICK_STATUS = "click_status";
    public static final String KEY_CLICK_TO_AREACODE = "click_to_areacode";
    public static final String KEY_CLICK_TYPE = "click_type";
    public static final String KEY_CLIENT_PARAMS = "client_params";
    public static final String KEY_CLIENT_TYPE = "b_type";
    public static final String KEY_CLOSE_METHOD = "close_method";
    public static final String KEY_COMBINATION_ID = "combination_id";
    public static final String KEY_COMBO_ID = "combo_id";
    public static final String KEY_COMMENT_CARD_CLICK_ENTRANCE = "comment_card_click_entrance";
    public static final String KEY_COMMENT_DETAIL = "comment_detail";
    public static final String KEY_COMMENT_ENTRANCE = "comment_entrance";
    public static final String KEY_COMMENT_ID = "comment_id";
    public static final String KEY_COMMENT_IDS = "comment_ids";
    public static final String KEY_COMMENT_MODULE = "comment_module";
    public static final String KEY_COMMENT_NUM = "comment_num";
    public static final String KEY_COMMENT_NUMBER = "comment_number";
    public static final String KEY_COMMENT_RANK = "comment_rank";
    public static final String KEY_COMMENT_SHOW_LIST = "comment_show_list";
    public static final String KEY_COMMENT_SWITCH_TYPE = "comment_switch_type";
    public static final String KEY_COMMENT_TAG = "comment_tag";
    public static final String KEY_COMMENT_TYPE = "comment_type";
    public static final String KEY_COMMODITY_ID = "commodity_id";
    public static final String KEY_COMMODITY_NAME = "commodity_name";
    public static final String KEY_COMMODITY_TYPE = "commodity_type";
    public static final String KEY_CONFIRM_CONTENT = "confirm_content";
    public static final String KEY_CONFIRM_STATUS = "comfirm_status";
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_CONTENT_SOURCE = "content_source";
    public static final String KEY_CONTENT_TYPE = "content_type";
    public static final String KEY_COST_PRICE = "cost_price";
    public static final String KEY_COUPON_ID = "coupon_id";
    public static final String KEY_COUPON_INFO = "coupon_info";
    public static final String KEY_COUPON_NAME = "coupon_name";
    public static final String KEY_COUPON_TYPE = "coupon_type";
    public static final String KEY_CREATIVE_ID = "creative_id";
    public static final String KEY_CROSSBORDER_GOODS = "is_crossborder_goods";
    public static final String KEY_C_BIZ_COMBO = "c_biz_combo";
    public static final String KEY_DATA_TYPE = "data_type";
    public static final String KEY_DELIVERY_STATUS = "delivery_status";
    public static final String KEY_DESTINATION = "destination";
    public static final String KEY_DID = "did";
    public static final String KEY_DISCOUNT_ACTIVITY_ID = "discount_activity_id";
    public static final String KEY_DISCOUNT_ACTIVITY_TYPE = "discount_activity_type";
    public static final String KEY_DISCOUNT_MIN_PRICE = "discount_min_price";
    public static final String KEY_DISPLAY_RANK = "display_rank";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ECOM_ENTRANCE_FORM = "ecom_entrance_form";
    public static final String KEY_ECOM_GROUP_TYPE = "ecom_group_type";
    public static final String KEY_ECOM_ICON = "ecom_icon";
    public static final String KEY_ECOM_MESSAGE_SHOW_PV = "ecom_message_show_pv";
    public static final String KEY_ECOM_SCENE_ID = "ecom_scene_id";
    public static final String KEY_ECOM_TAG_ACTIVITY_ID = "ecom_tag_activity_id";
    public static final String KEY_ECOM_TAG_ACTIVITY_TYPE = "ecom_tag_activity_type";
    public static final String KEY_ECOM_TAG_TYPE = "ecom_tag_type";
    public static final String KEY_ECOM_TYPE = "ecom_type";
    public static final String KEY_EFFECTIVE_MIN_PRICE = "effective_min_price";
    public static final String KEY_ENTER_COUNT = "enter_count";
    public static final String KEY_ENTER_FROM = "enter_from";
    public static final String KEY_ENTER_FROM_MERGE = "enter_from_merge";
    public static final String KEY_ENTER_GROUP_ID = "enter_group_id";
    public static final String KEY_ENTER_METHOD = "enter_method";
    public static final String KEY_ENTER_METHOD_PIC = "enter_method_pic";
    public static final String KEY_ENTER_PRODUCT_DETAL = "enter_product_detail";
    public static final String KEY_ENTER_SOURCE = "enter_source";
    public static final String KEY_ENTER_TO = "enter_to";
    public static final String KEY_ENTRANCE_FORM = "entrance_form";
    public static final String KEY_ENTRANCE_INFO = "entrance_info";
    public static final String KEY_ENTRANCE_LOCATION = "entrance_location";
    public static final String KEY_ENTRANCE_METHOD = "entrance_method";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_ERROR_MSG = "error_msg";
    public static final String KEY_ERROR_TYPE = "error_type";
    public static final String KEY_EVENT_ORIGIN_FEATURE = "EVENT_ORIGIN_FEATURE";
    public static final String KEY_EXCEPTION = "exception";
    public static final String KEY_EXCHANGE_COUPON_ACTIVITY_NAME = "exchange_coupon_activity_name";
    public static final String KEY_EXIST_MATCH_REDUCE_TAB = "is_exist_match_reduce_tab";
    public static final String KEY_EXIST_MATCH_TAB = "is_exist_match_tab";
    public static final String KEY_EXIT_TYPE = "exit_type";
    public static final String KEY_EXTRA_CAMPAIGN_TYPE = "extra_campaign_type";
    public static final String KEY_FAST_DISPATCH = "fast_dispatch";
    public static final String KEY_FEED_COUNT = "feed_count";
    public static final String KEY_FE_FLAG = "fe_flag";
    public static final String KEY_FINAL_STATUS = "final_status";
    public static final String KEY_FIND_SIMILAR_TAB_CLICK = "find_similar_tab_click";
    public static final String KEY_FIND_SIMILAR_TAB_SHOW = "find_similar_tab_show";
    public static final String KEY_FLASH_TYPE = "flash_type";
    public static final String KEY_FOLLOW_STATUS = "follow_status";
    public static final String KEY_FRAME_IMAGE_IDENTIFIER = "frame_image_identifier";
    public static final String KEY_FRIENDS_ECOM_TAG = "friends_ecom_tag";
    public static final String KEY_FROM = "from";
    public static final String KEY_FROM_ACTION_TYPE = "from_action_type";
    public static final String KEY_FROM_AUTHOR_ID = "from_author_id";
    public static final String KEY_FROM_ENTRANCE = "from_entrance";
    public static final String KEY_FROM_GROUP_ID = "from_group_id";
    public static final String KEY_FROM_PRODUCT_MODULE_LABEL = "from_product_module_label";
    public static final String KEY_FXH_METHOD = "fxh_method";
    public static final String KEY_FXH_METHOD_LIST = "fxh_method_list";
    public static final String KEY_FXH_WHITE_LIST_FLAG = "fxh_white_list_flag";
    public static final String KEY_GOODS_AUTHOR_ID = "goods_author_id";
    public static final String KEY_GOODS_ID = "goods_id";
    public static final String KEY_GOODS_TYPE = "goods_type";
    public static final String KEY_GOOD_COMMENT_PERCENTAGE = "good_comment_percentage";
    public static final String KEY_GROUP_ID = "group_id";
    public static final String KEY_HAS_FRAME_IMAGE = "has_frame_image";
    public static final String KEY_HEAD_TAB_RANK = "tab_rank";
    public static final String KEY_HIT_CACHE = "hit_cache";
    public static final String KEY_ICON_STATUS = "icon_status";
    public static final String KEY_IF_POSITIVE = "if_positive";
    public static final String KEY_IMAGE_SHOW_NAME = "images_show_name";
    public static final String KEY_IMAGE_TAB_NAME = "images_tab_name";
    public static final String KEY_IMAGE_TAB_STATUS = "images_tab_status";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_IMPR_ID = "impr_id";
    public static final String KEY_INDICATOR_TYPE = "type";
    public static final String KEY_INFLOW_LANDING_PAGE_TYPE = "inflow_landing_page_type";
    public static final String KEY_INFLOW_MAIN_CARD_LOCATION = "inflow_main_card_location";
    public static final String KEY_INFLOW_ORDER = "inflow_order";
    public static final String KEY_INFO_NAME = "info_name";
    public static final String KEY_INFO_TYPE = "info_type";
    public static final String KEY_INSTALLMENT_INFO = "installment";
    public static final String KEY_INTERACTION_CONTENT = "interaction_content";
    public static final String KEY_INTERACTION_TYPE = "interaction_type";
    public static final String KEY_INTERACT_TIME = "interact_time";
    public static final String KEY_IS_ACTIVITY = "is_activity";
    public static final String KEY_IS_ACTIVITY_BANNER = "is_activity_banner";
    public static final String KEY_IS_AD = "is_ad";
    public static final String KEY_IS_AD_EVENT = "is_ad_event";
    public static final String KEY_IS_ALADDIN = "is_aladdin";
    public static final String KEY_IS_ANONYMOUS = "is_anonymous";
    public static final String KEY_IS_APPEND = "is_append";
    public static final String KEY_IS_AUTH = "is_auth";
    public static final String KEY_IS_AUTHENTIC_INSURE = "is_authentic_insure";
    public static final String KEY_IS_AUTHORISED = "is_authorised";
    public static final String KEY_IS_COMMENT_BIG_PIC_LIKE = "is_comment_big_pic_like";
    public static final String KEY_IS_CREAVAILABLE = "is_creavailable";
    public static final String KEY_IS_DIRECT_BUY = "is_direct_buy";
    public static final String KEY_IS_ENTER_PREVIEW = "is_enter_preview";
    public static final String KEY_IS_EXIST_SIZE_TAB = "is_exist_size_tab";
    public static final String KEY_IS_EXPLAIN = "is_explain";
    public static final String KEY_IS_EXPLAIN_APPLY = "is_explain_apply";
    public static final String KEY_IS_EXSIT_FOLLOW = "is_exist_follow";
    public static final String KEY_IS_FIRST = "is_first";
    public static final String KEY_IS_FIRST_MAIN_CARD = "is_first_main_card";
    public static final String KEY_IS_FIRST_SLIDE = "is_first_slide";
    public static final String KEY_IS_FLOAT = "is_float";
    public static final String KEY_IS_FROM_RESTORE = "is_from_restore";
    public static final String KEY_IS_GROUP_BUYING = "is_groupbuying";
    public static final String KEY_IS_JAILBREAK = "is_jailbreak";
    public static final String KEY_IS_LIVE = "is_live";
    public static final String KEY_IS_LIVE_FAN_GROUP = "is_live_fan_group";
    public static final String KEY_IS_LUBAN = "is_luban";
    public static final String KEY_IS_MEMBER = "is_membership";
    public static final String KEY_IS_MULTI_PIC_MODE = "is_multi_pic_mode";
    public static final String KEY_IS_N_GROUP_BUY = "is_multigroupbuying";
    public static final String KEY_IS_OTHER_CHANNE = "is_other_channel";
    public static final String KEY_IS_PACKAGE_SALE = "is_package_sale";
    public static final String KEY_IS_PLAY_OVER = "is_play_over";
    public static final String KEY_IS_REALLY_CLICK = "is_really_click";
    public static final String KEY_IS_RECEPTOR = "is_receptor";
    public static final String KEY_IS_REPEAT_CUSTOMER = "is_repeat_customer";
    public static final String KEY_IS_REPLAY = "is_replay";
    public static final String KEY_IS_SELF = "is_self";
    public static final String KEY_IS_SHOP_CART = "is_shopping_cart";
    public static final String KEY_IS_SHOW = "is_show";
    public static final String KEY_IS_SHOW_INFLOW_VIDEO = "is_show_inflow_video";
    public static final String KEY_IS_SHOW_SKU = "is_show_sku";
    public static final String KEY_IS_SKU_SELECTED = "is_sku_selected";
    public static final String KEY_IS_SUCCESS = "is_success";
    public static final String KEY_IS_UNDER_STOCK = "is_under_stock";
    public static final String KEY_IS_WHITE_BASE = "is_white_base";
    public static final String KEY_IS_WITH_VIDEO = "is_with_video";
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_ITEM_ORDER = "item_order";
    public static final String KEY_KEYS_CNT = "keys_cnt";
    public static final String KEY_KEY_ID = "key_id";
    public static final String KEY_KEY_RANK = "key_rank";
    public static final String KEY_KEY_WORD_NUM = "key_word_num";
    public static final String KEY_KOL_ALL_VIDEO_CNT = "kol_all_video_cnt";
    public static final String KEY_KOL_AUTHOR_ID = "kol_author_id";
    public static final String KEY_KOL_ID = "kol_id";
    public static final String KEY_KOL_USER_TAG = "kol_user_tag";
    public static final String KEY_KOL_VIDEO_CLICK = "kol_video_click";
    public static final String KEY_KOL_VIDEO_CNT = "kol_video_cnt";
    public static final String KEY_KOL_VIDEO_GROUP_CLICK = "kol_video_group_click";
    public static final String KEY_KOL_VIDEO_GROUP_SHOW = "kol_video_group_show";
    public static final String KEY_KOL_VIDEO_ID = "kol_video_id";
    public static final String KEY_KOL_VIDEO_RANK = "kol_video_rank";
    public static final String KEY_KOL_VIDEO_SHOW = "kol_video_show";
    public static final String KEY_KOL_VIDEO_TYPE = "kol_video_type";
    public static final String KEY_LABEL_CONTENT_TYPE = "label_content_type";
    public static final String KEY_LABEL_ID = "label_id";
    public static final String KEY_LABEL_INFO = "label_info";
    public static final String KEY_LABEL_NAME = "label_name";
    public static final String KEY_LABEL_NAME_LIVE = "label_name_live";
    public static final String KEY_LABEL_NAME_SECURE_BUY = "securebuy_prd";
    public static final String KEY_LAB_LUCKYPIG_OBJ = "lab_luckypig_obj";
    public static final String KEY_LIST = "list";
    public static final String KEY_LIVE_GROUP_ID = "live_group_id";
    public static final String KEY_LIVE_LIST_CHANNEL = "live_list_channel";
    public static final String KEY_LIVE_STATUS = "live_status";
    public static final String KEY_LOADING_DURATION = "loading_duration";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_LOG_DATA = "log_data";
    public static final String KEY_LOG_EXTRA = "log_extra";
    public static final String KEY_LOG_ID = "log_id";
    public static final String KEY_LOG_PB = "log_pb";
    public static final String KEY_LUBAN_CATEGORY = "category";
    public static final String KEY_LUBAN_TAG = "tag";
    public static final String KEY_LUBAN_VALUE = "value";
    public static final String KEY_MAIN_PIC_SIZE = "main_pic_size";
    public static final String KEY_MARKET_CHANNEL = "marketing_channel";
    public static final String KEY_MARKET_ENTER_PRODUCT_DETAIL = "market_enter_product_detail";
    public static final String KEY_MATCH_PRODUCT_ID = "matching_product_id";
    public static final String KEY_MAX_SKU_PRICE = "max_sku_price";
    public static final String KEY_MEDIA_TYPE = "media_type";
    public static final String KEY_MEMBERSHIP = "membership_prd";
    public static final String KEY_MESSAGE = "com.bytedance.android.ec.adapter.api.message";
    public static final String KEY_META_PARAM = "meta_param";
    public static final String KEY_MIN_SKU_PRICE = "min_sku_price";
    public static final String KEY_MODULE_LABEL = "module_label";
    public static final String KEY_MODULE_NAME = "module_name";
    public static final String KEY_MODULE_TYPE = "module_type";
    public static final String KEY_MORE_ACTION = "more_action";
    public static final String KEY_MSG = "message";
    public static final String KEY_MULTI_PIC_MODE = "multi_pic_mode";
    public static final String KEY_NEW_GIFT_TYPE = "new_gift_type";
    public static final String KEY_NEW_SOURCE_TYPE = "new_source_type";
    public static final String KEY_NEXT_PAGE = "next_page";
    public static final String KEY_NUM_LABEL_TYPE = "num_label_type";
    public static final String KEY_N_GROUP_BUY_STATE = "multigroupbuying_state";
    public static final String KEY_N_GROUP_BUY_TYPE = "ngroup_buy_type";
    public static final String KEY_ONEYUAN_BUTTON = "oneyuan_button";
    public static final String KEY_ORDER = "order";
    public static final String KEY_ORDER_ID = "order_id";
    public static final String KEY_ORDER_TYPE = "order_type";
    public static final String KEY_ORIGIN_ID = "origin_id";
    public static final String KEY_ORIGIN_PRODUCT_ID = "origin_product_id";
    public static final String KEY_ORIGIN_TYPE = "origin_type";
    public static final String KEY_OUTER_CARD_TYPE = "outer_card_type";
    public static final String KEY_OUTER_ENTRANCE_TYPE = "outer_entrance_type";
    public static final String KEY_OUTFLOW_ORDER = "outflow_order";
    public static final String KEY_OUTFLOW_RANK = "outflow_rank";
    public static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_PAGE_LOCATION = "page_location";
    public static final String KEY_PAGE_NAME = "page_name";
    public static final String KEY_PAGE_STATUS = "page_status";
    public static final String KEY_PAGE_TYPE = "page_type";
    public static final String KEY_PANEL_NAME = "panel_name";
    public static final String KEY_PARAMS_FOR_SPECIAL = "params_for_special";
    public static final String KEY_PARAM_LIVE_PLATFROM = "_param_live_platform";
    public static final String KEY_PASS_THROUGH = "pass_through";
    public static final String KEY_PASS_THROUGH_API = "pass_through_api";
    public static final String KEY_PDP_GALLERY_SHARE_BUTTON_SHOW = "ecom_share_button_show";
    public static final String KEY_PDP_SESSION_ID = "pdp_session_id";
    public static final String KEY_PD_BUTTON_STATUS = "pd_button_status";
    public static final String KEY_PIC = "pic";
    public static final String KEY_PIC_SHOW = "display_rank";
    public static final String KEY_PIC_TYPE = "pic_type";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_PRELOAD_COMMENTS_SIZE = "preload_comments_size";
    public static final String KEY_PRELOAD_DATA = "preload_data";
    public static final String KEY_PREVIOUS_PAGE = "previous_page";
    public static final String KEY_PRE_GROUP_ID = "pre_group_id";
    public static final String KEY_PRE_PRODUCT_ID = "pre_product_id";
    public static final String KEY_PRE_ROOM_ID = "pre_room_id";
    public static final String KEY_PRICE_INFO = "price_info";
    public static final String KEY_PRICE_TYPE = "price_type";
    public static final String KEY_PRODUCT_ACTIVITY_TYPE = "product_activity_type";
    public static final String KEY_PRODUCT_BUY_STATUS = "product_buy_status";
    public static final String KEY_PRODUCT_CNT = "product_cnt";
    public static final String KEY_PRODUCT_ENTRANCE_STYLE = "product_entrance_style";
    public static final String KEY_PRODUCT_FLOW_TYPE = "product_flow_type";
    public static final String KEY_PRODUCT_ID = "product_id";
    public static final String KEY_PRODUCT_ID_GROUP = "product_id_group";
    public static final String KEY_PRODUCT_LABEL = "product_label";
    public static final String KEY_PRODUCT_LOCATION = "product_location";
    public static final String KEY_PRODUCT_PRICE = "product_price";
    public static final String KEY_PRODUCT_RANK = "product_rank";
    public static final String KEY_PRODUCT_SOURCE_PAGE = "product_source_page";
    public static final String KEY_PRODUCT_SOURCE_TYPE = "product_source_type";
    public static final String KEY_PRODUCT_TYPE = "product_type";
    public static final String KEY_PROMOTION_ID = "promotion_id";
    public static final String KEY_PROMOTION_MESSAGE_BAR = "promotion_message_bar";
    public static final String KEY_QUESTION_ID = "question_id";
    public static final String KEY_QUESTION_NUM = "question_num";
    public static final String KEY_QUESTION_RANK = "question_rank";
    public static final String KEY_RANK = "rank";
    public static final String KEY_RANK_ID = "rank_id";
    public static final String KEY_RANK_INDEX = "rank_index";
    public static final String KEY_RAW_AD_DATA = "raw_ad_data";
    public static final String KEY_REAL_PRICE = "real_price";
    public static final String KEY_RECALL_TYPE = "recall_type";
    public static final String KEY_RECOMMEND_INFO = "recommend_info";
    public static final String KEY_RECOMMEND_TYPE = "recommend_type";
    public static final String KEY_REC_PASS_PARAMS = "rec_pass_params";
    public static final String KEY_REFER_COMMODITY_ID = "refer_commodity_id";
    public static final String KEY_REFER_SEED_ID = "refer_seed_id";
    public static final String KEY_REFER_SEED_NAME = "refer_seed_name";
    public static final String KEY_REGULAR_PRICE = "regular_price";
    public static final String KEY_RENDER_TIME = "render_time";
    public static final String KEY_REQUEST_ADDITIONS = "request_additions";
    public static final String KEY_REQUEST_ID = "request_id";
    public static final String KEY_RESULT = "result";
    public static final String KEY_RIFLE_MEGA_OBJECT = "rifle_mega_object";
    public static final String KEY_ROOM_ID = "room_id";
    public static final String KEY_SAME_PRODUCT_SCENE = "same_product_scene";
    public static final String KEY_SCENE_ID = "scene_id";
    public static final String KEY_SCHEMA = "schema";
    public static final String KEY_SCHEMA_URL = "schema_url";
    public static final String KEY_SCHEME = "scheme";
    public static final String KEY_SCORE = "score";
    public static final String KEY_SCROLL_DIRECTION = "scroll_direction";
    public static final String KEY_SEARCH_ID = "search_id";
    public static final String KEY_SEARCH_KEYWORD = "search_keyword";
    public static final String KEY_SEARCH_KEY_WORD = "search_keyword";
    public static final String KEY_SEARCH_METHOD = "search_method";
    public static final String KEY_SEARCH_PARAM = "search_params";
    public static final String KEY_SEARCH_RESULT_ID = "search_result_id";
    public static final String KEY_SEARCH_TYPE = "search_type";
    public static final String KEY_SEC_AUTHOR_ID = "sec_author_id";
    public static final String KEY_SEED_ID = "seed_id";
    public static final String KEY_SEED_NAME = "seed_name";
    public static final String KEY_SELLING_POINT_TYPE = "sellingpoint_type";
    public static final String KEY_SELLING_PT_INFO = "selling_pt_info";
    public static final String KEY_SELL_POINT_BP = "sellpoint_bp_video";
    public static final String KEY_SERVICE_TYPE = "service_type";
    public static final String KEY_SESSION_ID = "session_id";
    public static final String KEY_SHAI_DAN_GUIDE_BAR_CLICK = "shaidan_guide_bar_click";
    public static final String KEY_SHAI_DAN_GUIDE_BAR_SHOW = "shaidan_guide_bar_show";
    public static final String KEY_SHARE_CONTENT = "share_content";
    public static final String KEY_SHARE_HEAD_SHOW = "ecom_share_head_show";
    public static final String KEY_SHARE_OBJECT = "share_object";
    public static final String KEY_SHARE_THIRD_PARTY = "share_third_party";
    public static final String KEY_SHARE_TYPE = "share_action_type";
    public static final String KEY_SHARE_WITH_HEAD = "share_with_head";
    public static final String KEY_SHOOT_WAY = "shoot_way";
    public static final String KEY_SHOPPING_GUIDE_NAME = "name";
    public static final String KEY_SHOP_ID = "shop_id";
    public static final String KEY_SHOP_LABEL_NAME = "shop_label_name";
    public static final String KEY_SHOP_LEVEL_INFO_EXPLAIN_PAGE_CLICK = "shop_level_info_explain_page_click";
    public static final String KEY_SHOP_LEVEL_INFO_EXPLAIN_PAGE_SHOW = "shop_level_info_explain_page_show";
    public static final String KEY_SHOP_LIST_ENTRANCE_CLICK = "shop_list_entrance_click";
    public static final String KEY_SHOP_LIST_ENTRANCE_SHOW = "shop_list_entrance_show";
    public static final String KEY_SHOP_LIST_ID = "shop_list_id";
    public static final String KEY_SHOP_LIST_NAME = "shop_list_name";
    public static final String KEY_SHOP_LIST_TYPE = "shop_list_type";
    public static final String KEY_SHOP_OPEN_FLAG = "shop_open_fxh_flag";
    public static final String KEY_SHOW_ECOM_MODULE = "show_ecom_module";
    public static final String KEY_SHOW_PRODUCT = "show_product";
    public static final String KEY_SHOW_PRODUCT_ACTIVITY = "show_product_activity";
    public static final String KEY_SHOW_REASON = "show_reason";
    public static final String KEY_SHOW_REFERRER = "show_referrer";
    public static final String KEY_SHOW_TAB_NUM = "show_tab_num";
    public static final String KEY_SHOW_TYPE = "show_type";
    public static final String KEY_SIMILAR_CARD_TYPE = "similar_card_type";
    public static final String KEY_SIMILAR_ENTRANCE_FROM = "similar_entrance_form";
    public static final String KEY_SIMILAR_TYPE = "similar_type";
    public static final String KEY_SIM_PRODUCT_ID = "sim_product_id";
    public static final String KEY_SKU_ID = "sku_id";
    public static final String KEY_SKU_NAME = "sku_name";
    public static final String KEY_SLIDE_ORDER = "slide_order";
    public static final String KEY_SLIDE_TYPE = "slide_type";
    public static final String KEY_SORD_TYPE = "sort_type";
    public static final String KEY_SORT_BY = "sort_by";
    public static final String KEY_SOURCE_METHOD = "source_method";
    public static final String KEY_SOURCE_PAGE = "source_page";
    public static final String KEY_SOURCE_PRODUCT_ID = "source_product_id";
    public static final String KEY_SOURCE_TYPE = "source_type";
    public static final String KEY_STAGING_FLAG = "_staging_flag";
    public static final String KEY_STANDARD_CHAIN_PARAM = "standard_chain_param";
    public static final String KEY_STANDARD_PRODUCT_MARKETING_PARAM = "standard_product_marketing_param";
    public static final String KEY_STANDARD_TRACK_PARAM = "standard_track_param";
    public static final String KEY_STATUS = "status";
    public static final String KEY_STATUS_CODE = "statusCode";
    public static final String KEY_STATUS_MSG = "statusMsg";
    public static final String KEY_STOP_TYPE = "stop_type";
    public static final String KEY_STORE_GROUP_TYPE = "store_group_type";
    public static final String KEY_STORE_SOURCE_METHOD = "store_source_method";
    public static final String KEY_STORE_SOURCE_PAGE = "store_source_page";
    public static final String KEY_STORE_TYPE = "store_type";
    public static final String KEY_SUBJECT = "subject";
    public static final String KEY_SUBSEQUENT_PAGE_TYPE = "subsequent_page_type";
    public static final String KEY_SUBSIDIZED_ACTIVITY = "subsidized_activity";
    public static final String KEY_SUBSIDY_MARKET_PRICE = "subsidy_market_price";
    public static final String KEY_SUBSIDY_PRICE = "subsidy_price";
    public static final String KEY_TAB_ID = "tab_id";
    public static final String KEY_TAB_NAME = "tab_name";
    public static final String KEY_TAB_NUM = "tab_num";
    public static final String KEY_TAB_ORDER = "tab_order";
    public static final String KEY_TAB_TYPE = "tab_type";
    public static final String KEY_TAB_VIDEO_SIZE = "pd_headvideo_size";
    public static final String KEY_TAG_ID = "tag_id";
    public static final String KEY_TAG_NAME = "tag_name";
    public static final String KEY_TAG_TYPE = "tag_type";
    public static final String KEY_TARGET_ID = "target_product_id";
    public static final String KEY_TEMP_ID = "temp_id";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TEXT_TYPE = "text_type";
    public static final String KEY_THREE_D = "source_3d";
    public static final String KEY_TIME_SKU_NUM = "time_sku_num";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TOKEN_TYPE = "token_type";
    public static final String KEY_TOP_COMMENT_IDS = "top_comment_ids";
    public static final String KEY_TOTAL_COUNT = "total_count";
    public static final String KEY_TO_USER_ID = "to_user_id";
    public static final String KEY_TRACKER = "tracker";
    public static final String KEY_TREND_ID = "trend_id";
    public static final String KEY_TREND_NAME = "trend_name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UID = "uid";
    public static final String KEY_UPFRONT_PRESELL = "upfront_presell";
    public static final String KEY_URL = "url";
    public static final String KEY_USER_COMMENT_LEVEL = "user_comment_level";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_OPEN_FXH_FLAG = "user_open_fxh_flag";
    public static final String KEY_USER_TYPE = "user_type";
    public static final String KEY_USE_PRELOAD_DATA = "use_preload_data";
    public static final String KEY_VERTICAL_CATEGORY_NEW = "vertical_category_new";
    public static final String KEY_VIDEO_GROUP_TYPE = "video_group_type";
    public static final String KEY_VIDEO_ID = "video_id";
    public static final String KEY_VIDEO_INFO = "video_info";
    public static final String KEY_VIDEO_POSITION = "video_position";
    public static final String KEY_VIDEO_SOURCE = "video_source";
    public static final String KEY_VIDEO_SOURCE_TYPE = "video_source_type";
    public static final String KEY_VIDEO_TYPE = "video_type";
    public static final String KEY_VIEW_STYLE = "view_style";
    public static final String KEY_VIRTUAL_COMMODITY_FLAG = "virtual_commodity_flag";
    public static final String KEY_VS_GROUP_ID = "vs_group_id";
    public static final String KEY_VS_SESSION_ID = "vs_session_id";
    public static final String KEY_WHICH_ACCOUNT = "which_account";
    public static final String KEY_WITH_COUPON = "with_coupon";
    public static final String KEY_WITH_IMPRESSIVE_WORD = "with_impressive_word";
    public static final String KEY_WITH_LINK = "with_link";
    public static final String KEY_WITH_MORE = "with_more";
    public static final String KEY_WITH_SAME_COMMENT = "with_same_comment";
    public static final String KEY_WITH_SKU = "with_sku";
    public static final String KEY_WORD_ID = "word_id";
    public static final String KEY_WORD_NAME = "word_name";
    public static final String KEY_WORD_NUM = "word_num";
    public static final String KEY_WORD_ORDER = "word_order";
    public static final String VALUE_ACTION_TYPE_CLICK = "click";
    public static final String VALUE_ACTION_TYPE_DRAW = "draw";
    public static final String VALUE_ACTION_TYPE_SWIPE = "swipe";
    public static final String VALUE_ACTIVITY = "activity";
    public static final String VALUE_ADD_CART = "product_detail_add_cart";
    public static final String VALUE_ADD_FAVORITE = "product_detail_add_favoriate";
    public static final String VALUE_AFTERSALE_INFORMATION = "aftersale_information";
    public static final String VALUE_APPOINTMENT_PRODUCT = "5";
    public static final int VALUE_ARRIVE_TODAY = 4;
    public static final int VALUE_ARRIVE_TOMORROW = 5;
    public static final String VALUE_ASK_AROUND = "askaround";
    public static final String VALUE_AUCTION_PRODUCT = "8";
    public static final String VALUE_BASE_VERIFIED = "baseverified";
    public static final String VALUE_BEST_SELECTED = "best_selected";
    public static final String VALUE_BIG_PICTURE = "big_picture";
    public static final String VALUE_BIOMETRIC_PARAMS = "1";
    public static final String VALUE_BOI_TYPE = "1";
    public static final String VALUE_BRAND = "brand";
    public static final int VALUE_BST_CLICK_PRODUCT = 2;
    public static final int VALUE_BST_SHOW_PRODUCT = 1;
    public static final String VALUE_BUTTON_STATUS_BUY_AVAILABLE = "0";
    public static final String VALUE_CLICK = "click";
    public static final String VALUE_CLICK_AREA_BLANK = "blank";
    public static final String VALUE_CLICK_AREA_BUTTON = "button";
    public static final String VALUE_CLICK_BLANK = "blank";
    public static final String VALUE_CLICK_CHECK_ORDER = "check_order";
    public static final String VALUE_CLICK_COMMENT = "product_detail_click_comment";
    public static final String VALUE_CLICK_CONFIRM = "confirm";
    public static final String VALUE_CLICK_ENTER_SHOP = "product_detail_click_enter_shop";
    public static final String VALUE_CLICK_PIC = "pic";
    public static final String VALUE_CLICK_PRODUCT = "product";
    public static final String VALUE_CLICK_PURCHASE = "product_detail_click_purchase";
    public static final String VALUE_CLICK_TYPE = "ok";
    public static final String VALUE_CLOSE = "close";
    public static final String VALUE_COMMENT_CARD = "comment_card";
    public static final String VALUE_COMMENT_DETAIL_PAGE = "comment_detail_page";
    public static final String VALUE_COMMENT_LIST_SHAI_DAN_GUIDE_EDIT = "comment_list_shaidan_guide_edit";
    public static final String VALUE_COMMENT_REGION = "comment_region";
    public static final String VALUE_COMMENT_TAB = "comment";
    public static final String VALUE_COMMENT_TAB_NAME = "comment";
    public static final String VALUE_DAILY_REDUCTION = "daily_reduction";
    public static final String VALUE_DATA_TYPE = "commerce_data";
    public static final String VALUE_DEFAULT_RANK = "1";
    public static final String VALUE_DETAIL_TAB = "detail";
    public static final String VALUE_EFFECTIVE_AD = "effective_ad";
    public static final String VALUE_ENTER_ORDER = "1";
    public static final String VALUE_ENTER_SHOP = "product_detail_click_enter_shop";
    public static final String VALUE_ENTER_SKU = "2";
    public static final String VALUE_ENTER_THIRD_PART = "3";
    public static final String VALUE_EXIT_TYPE_CLICK_BLANK = "click_blank";
    public static final String VALUE_EXIT_TYPE_CLICK_CLOSE_BUTTON = "click_close_button";
    public static final String VALUE_EXIT_TYPE_SLIDE_DOWN = "slide_down";
    public static final String VALUE_EXPLOSIVE_SUBSIDY = "explosive_subsidy";
    public static final String VALUE_FEEDBACK = "feedback";
    public static final int VALUE_FOLLOW_STATUS_FOLLOWING = 1;
    public static final int VALUE_FOLLOW_STATUS_NOT_FOLLOWING = 0;
    public static final String VALUE_FORM_COMMENT_CARD = "product_card";
    public static final String VALUE_FORWARD = "forward";
    public static final String VALUE_FULL_SCREE = "full_screen";
    public static final String VALUE_FULL_SCREEN = "full_screen";
    public static final String VALUE_GLOBAL = "global";
    public static final String VALUE_GOOD_ARRIVE_TODAY_LABEL = "arrivetoday";
    public static final String VALUE_GOOD_ARRIVE_TOMORROW_LABEL = "arrivetmr";
    public static final String VALUE_GUESSULIKE_PRODUCT_CARD = "guess_you_like_product";
    public static final String VALUE_GUESSULIKE_PRODUCT_DETAIL = "guessyoulike_product_detail";
    public static final String VALUE_GUESS_YOU_LIKE_PRODUCT = "guess_you_like_product";
    public static final String VALUE_HALF_SCREE = "half_screen";
    public static final String VALUE_HAS_BUYER_SHOW = "1";
    public static final String VALUE_HAS_OR_CONFIRM = "1";
    public static final String VALUE_HAS_SKU = "1";
    public static final String VALUE_HEADER_AREA = "header_area";
    public static final String VALUE_IMMERSIVE_PRODUCT_FLOW_FIRST_PAGE = "immersive_product_flow_first_page";
    public static final String VALUE_IMMERSIVE_PRODUCT_FLOW_GUESS_PAGE = "immersive_product_flow_guess_page";
    public static final String VALUE_INFLOW = "inflow";
    public static final int VALUE_IS_AD_EVENT = 1;
    public static final String VALUE_IS_BRAND_TAG = "1";
    public static final String VALUE_IS_CREAVAILABLE = "1";
    public static final String VALUE_IS_CROSSBORDER = "1";
    public static final String VALUE_IS_JAILBREAK = "2";
    public static final String VALUE_IS_MEMBER = "1";
    public static final String VALUE_IS_NOT_CREAVAILABLE = "0";
    public static final String VALUE_IS_NOT_CROSSBORDER = "0";
    public static final String VALUE_IS_NOT_MEMBER = "0";
    public static final String VALUE_IS_SHOP_BRAND = "2";
    public static final String VALUE_JOIN_MEMBER = "7";
    public static final String VALUE_LIVE = "live";
    public static final String VALUE_LIVE_ECOM_TYPE = "live";
    public static final String VALUE_LOCATION_ANCHOR_V3 = "anchor_v3";
    public static final String VALUE_LOCATION_ANCHOR_V5 = "anchor_v5";
    public static final String VALUE_LONG_CLICK = "long_press";
    public static final String VALUE_LUBAN_CATEGORY = "umeng";
    public static final String VALUE_LUBAN_TAG = "views_product_item";
    public static final String VALUE_MAIN_PICTURE = "main_picture";
    public static final String VALUE_MAIN_PIC_SQUARE = "1_1";
    public static final String VALUE_MAIN_PIC_THREE_QUARTERS = "3_4";
    public static final String VALUE_MAIN_PRODUCT = "main_product";
    public static final String VALUE_MEMBER = "membership";
    public static final String VALUE_MEMBER_LEVEL = "membership_level";
    public static final String VALUE_MEMBER_LEVEL_REQUIRED = "membership_level_required";
    public static final String VALUE_MEMBER_REQUIRED = "membership_required";
    public static final String VALUE_MILLION_DISCOUNT = "million_discount";
    public static final String VALUE_MIX_COMMENT = "mix_comment";
    public static final String VALUE_MORE = "more";
    public static final String VALUE_NATIVE = "native";
    public static final String VALUE_NEGATIVE = "negative";
    public static final String VALUE_NEUTRAL = "neutral";
    public static final String VALUE_NEWBEE = "newright";
    public static final String VALUE_NEW_RETURN_COUPON_BAG = "new_return_coupon_bag";
    public static final String VALUE_NICE_STUFF = "nice_stuff";
    public static final String VALUE_NORMAL = "normal";
    public static final int VALUE_NOT_AD_EVENT = 0;
    public static final String VALUE_NOT_HAS = "0";
    public static final String VALUE_NO_BUYER_SHOW = "0";
    public static final String VALUE_OPEN = "open";
    public static final String VALUE_ORDER_DETAIL = "order_detail";
    public static final String VALUE_OTHERS = "others";
    public static final String VALUE_PARAMS_FOR_SPECIAL = "tppp";
    public static final String VALUE_PAUSE = "pause";
    public static final String VALUE_PDP_HEAD = "pdp_head";
    public static final String VALUE_PDP_MORE_VIDEO = "pdp_more_video";
    public static final String VALUE_PD_LIST_PRODUCT = "pd_live_list_product";
    public static final String VALUE_PERSONAL_HOMEPAGE = "personal_homepage";
    public static final String VALUE_PICTURE = "picture";
    public static final String VALUE_PIC_RECOMMEND = "pic_recommend";
    public static final String VALUE_PLAY = "play";
    public static final String VALUE_POSITIVE = "positive";
    public static final String VALUE_PRE_SECKILL = "pre_seckill";
    public static final String VALUE_PRODUCT = "product";
    public static final String VALUE_PRODUCT_CARD = "product_card";
    public static final String VALUE_PRODUCT_DETAIL = "product_detail";
    public static final String VALUE_PRODUCT_ECOM_TYPE = "product";
    public static final String VALUE_PRODUCT_FLOW_PAGE = "product_flow_page";
    public static final String VALUE_PRODUCT_FLOW_PAGE_GUESS_YOU_LIKE = "product_flow_page_102";
    public static final String VALUE_PRODUCT_FLOW_PAGE_NORMAL = "product_flow_page_101";
    public static final String VALUE_PRODUCT_FULLSCREEN_CARD = "product_fullscreen_card";
    public static final String VALUE_PRODUCT_INFLOW = "product_inflow";
    public static final String VALUE_PRODUCT_INFLOW_SIMILAR_TAB = "product_inflow_similar_tab";
    public static final String VALUE_PRODUCT_MODULE = "product_comment";
    public static final String VALUE_PRODUCT_TAB = "product";
    public static final String VALUE_QUESTION = "question";
    public static final String VALUE_RANKING_LIST = "ranking_list";
    public static final String VALUE_RECOMMEND_TAB = "recommend";
    public static final String VALUE_REPlAY_POPUP_CARD = "replay_popup_card";
    public static final String VALUE_SAME_PRODUCT_FLOW_PAGE = "same_product_flow_page";
    public static final String VALUE_SCARE_BUY = "6";
    public static final String VALUE_SEARCH_DETAIL = "search_product_detail";
    public static final String VALUE_SECKILL = "seckill";
    public static final String VALUE_SECURE_BUY = "securebuy_prd";
    public static final String VALUE_SELECTED_COMMENT = "selected_comment";
    public static final String VALUE_SELECTED_COMMENT_PAGE = "selected_comment_page";
    public static final String VALUE_SELECTED_PRODUCT = "selected_product";
    public static final String VALUE_SELLING_POINT = "selling_point";
    public static final String VALUE_SELL_TIME = "sell_time";
    public static final int VALUE_SHOP_LIST_TYPE_COLLECTION = 102;
    public static final int VALUE_SHOP_LIST_TYPE_RANK = 101;
    public static final String VALUE_SHOP_MODULE = "shop_comment";
    public static final String VALUE_SHOP_SAME_COMMENT = "same_comment";
    public static final String VALUE_SHOW_MODULE = "selected_comment";
    public static final String VALUE_SHOW_POPUP = "popup";
    public static final String VALUE_SHOW_TAB_NAME = "buyers_show";
    public static final String VALUE_SHOW_TOAST = "toast";
    public static final String VALUE_SKU_NAME = "product_detail_sku";
    public static final String VALUE_SLIDE = "slide";
    public static final String VALUE_SOURCE_COMMENT_CARD = "shop_comment_card";
    public static final String VALUE_STOP_BY_PAUSE = "pause";
    public static final String VALUE_STOP_BY_QUIT = "quit";
    public static final String VALUE_STORE_RECOMMEND = "store_recommend";
    public static final String VALUE_STORE_RECOMMEND_101 = "store_recommend_101";
    public static final String VALUE_SWITCH_PRODUCTS = "switch_products";
    public static final String VALUE_TEMAI = "TEMAI";
    public static final String VALUE_TITLE = "title";
    public static final long VALUE_TYPE_MEMBER = 2;
    public static final long VALUE_TYPE_MEMBER_LEVEL = 3;
    public static final long VALUE_TYPE_NORMAL = 0;
    public static final long VALUE_TYPE_NOT_ON_SALE = 1;
    public static final String VALUE_UNDER_PRICE_PANEL = "under_price_panel";
    public static final String VALUE_VIDEO = "video";
    public static final String VALUE_VIDEO_TYPE_LIVE_WINDOW = "live_window";
    public static final String VALUE_VIDEO_TYPE_MAIN_VIDEO = "main_video";
    public static final String VALUE_VIDEO_TYPE_MAIN_VIDEO_WINDOW = "main_video_window";
    public static final String VALUE_VIDEO_TYPE_REPLAY_VIDEO = "replay_video";
    public static final String VALUE_VIDEO_TYPE_TEST_TAB = "test_tab";
    public static final String VALUE_VIDEO_TYPE_TEST_TAB_WINDOW = "test_tab_window";
    public static final String VALUE_VIDEO_TYPE_VIDEO_WINDOW_AWEME = "video_window_aweme";
    public static final String VALUE_VIDEO_TYPE_VIDEO_WINDOW_REPLAY = "video_window_replay";
    public static final String VALUE_VIDEO_WINDOW = "video_window";
    public static final String VALUE_VIRTUAL_PRODUCT = "4";
    public static final String VALUE_VISIT_SECONDS = "product_detail_visit_seconds";
    public static final String VALUE_WITHOUT_CHECK_BUY = "0";
    private final String checkContextProvider;
    private final String checkScene;
    private final String checkScriptPath;
    private final String event;
    private final HashMap<String, String> extraParams;
    private final HashMap<String, String> params;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.event.a$a, reason: collision with other inner class name */
    public static final class C0793a {
        public C0793a() {
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0794a f44002a = null;

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.event.a$b$a, reason: collision with other inner class name */
        public static final class C0794a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0795a f44003a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C0796b f44004b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ C0794a f44005c = null;

            /* JADX INFO: renamed from: com.bytedance.android.ec.core.event.a$b$a$a, reason: collision with other inner class name */
            public static final class C0795a implements b {
                public C0795a() {
                }

                @Override // com.bytedance.android.ec.core.event.a.b
                public final String a(String r100) {
                    Intrinsics.checkNotNullParameter(r100, "param");
                    if (TextUtils.isEmpty(r100) == false) goto L5;
                L6:
                    return "";
                L5:
                    if (Intrinsics.areEqual("null", r100) == true) goto L6;
                    return r100;
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.ec.core.event.a$b$a$b, reason: collision with other inner class name */
            public static final class C0796b implements b {
                public C0796b() {
                }

                @Override // com.bytedance.android.ec.core.event.a.b
                public final String a(String r100) {
                    Intrinsics.checkNotNullParameter(r100, "param");
                    if (TextUtils.isEmpty(r100) == false) goto L5;
                L8:
                    return "";
                L5:
                    if (Intrinsics.areEqual("null", r100) == true) goto L8;
                    if (Intrinsics.areEqual("0", r100) == true) goto L8;
                    return r100;
                }
            }

            public C0794a() {
            }

            static {
                f44005c = new C0794a();
                f44003a = new C0795a();
                f44004b = new C0796b();
            }
        }

        static {
            f44002a = C0794a.f44005c;
        }

        String a(String r100);
    }

    public static final class c<T, U> implements BiConsumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f44006a;

        public c(HashMap r100) {
            this.f44006a = r100;
        }

        @Override // java.util.function.BiConsumer
        public final void accept(Object r100, Object r101) {
            String r102 = (String) r100;
            String r103 = (String) r101;
            Intrinsics.checkNotNullParameter(r102, "key");
            Intrinsics.checkNotNullParameter(r103, "value");
            boolean r104 = false;
            int r105 = 2;
            this.f44006a.put(new DumpedEventKey(r102, r104, r105, null), new DumpedEventParam(r103, r104, null, 6, null));
        }
    }

    public static final class d<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f44007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f44008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PageFinder f44009c;

        public d(a r100, String r101, PageFinder r102) {
            this.f44007a = r100;
            this.f44008b = r101;
            this.f44009c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            Map r100 = null;
            if (this.f44008b != null) goto L5;
        L13:
            g r101 = g.f48122a;     // Catch: Throwable -> L21
            String r102 = a.access$getEvent$p(this.f44007a);     // Catch: Throwable -> L21
            HashMap<String, String> r103 = this.f44007a.getParams();     // Catch: Throwable -> L21
            if ((r103 instanceof Map) == false) goto L17;
            r100 = r103;
        L17:
            if (r100 != null) goto L19;
            r100 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        L19:
            r101.logV3(r102, new JSONObject(r100));     // Catch: Throwable -> L21
            return Unit.INSTANCE;
        L5:
            if (this.f44009c == null) goto L13;
            g r104 = g.f48122a;     // Catch: Throwable -> L21
            String r105 = a.access$getEvent$p(this.f44007a);     // Catch: Throwable -> L21
            HashMap<String, String> r106 = this.f44007a.getParams();     // Catch: Throwable -> L21
            if ((r106 instanceof Map) == false) goto L10;
            r100 = r106;
        L10:
            if (r100 != null) goto L12;
            r100 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        L12:
            r104.g(r105, new JSONObject(r100), this.f44008b, this.f44009c);     // Catch: Throwable -> L21
            return Unit.INSTANCE;
        L21:
            th = move-exception;
            ECExceptionMonitor.e(th);
            return Integer.valueOf(Log.w("MetricsEvent", "post event failed: " + a.access$getEvent$p(this.f44007a), th));
        }
    }

    static {
        Companion = new C0793a();
    }

    public abstract void buildParams();

    public int getEventClassVersion() {
        return 1;
    }

    public final void buildLogParams() {
        b.f44002a.getClass();
        b.C0794a.C0795a r100 = b.C0794a.f44003a;
        appendParam("data_type", VALUE_DATA_TYPE, r100);
        appendParam(KEY_EVENT_ORIGIN_FEATURE, VALUE_TEMAI, r100);
        buildParams();
        this.params.putAll(this.extraParams);
    }

    public Map<DumpedEventKey, DumpedEventParam> getDumpedDumpedEventParams() {
        HashMap r100 = new HashMap();
        m8152getParams().forEach(new c(r100));
        return r100;
    }

    /* JADX INFO: renamed from: getParams, reason: collision with other method in class */
    public final Map<String, String> m8152getParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        b.f44002a.getClass();
        b.C0794a.C0795a r101 = b.C0794a.f44003a;
        appendParam("data_type", VALUE_DATA_TYPE, r101);
        appendParam(KEY_EVENT_ORIGIN_FEATURE, VALUE_TEMAI, r101);
        buildParams();
        this.params.putAll(this.extraParams);
        r100.putAll(this.params);
        return r100;
    }

    public final void newPost() {
        g r100 = g.f48122a;     // Catch: Throwable -> L9
        String r101 = this.event;     // Catch: Throwable -> L9
        Map r102 = this.params;     // Catch: Throwable -> L9
        if ((r102 instanceof Map) == true) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L7;
        r102 = MapsKt.emptyMap();     // Catch: Throwable -> L9
    L7:
        r100.logV3(r101, new JSONObject(r102));     // Catch: Throwable -> L9
    L12:
        if (ECAppInfoService.f48114e.isDebug() == false) goto L18;
        new StringBuilder("<<<=========" + this.event + " start =========>>>\n");
        Iterator<T> r103 = this.params.entrySet().iterator();
    L15:
        if (r103.hasNext() == false) goto L18;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = (String) r104.getValue();
    L18:
        ECEventDumper.f44016h.getClass();
        ECEventDumper.a.c(this);
        return;
    L9:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L12
    }

    public String getCheckContextProvider() {
        return this.checkContextProvider;
    }

    public String getCheckScene() {
        return this.checkScene;
    }

    public String getCheckScriptPath() {
        return this.checkScriptPath;
    }

    public String getEventName() {
        return this.event;
    }

    public final HashMap<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.event = r100;
        this.params = new HashMap();
        this.extraParams = new HashMap();
    }

    public static final /* synthetic */ String access$getEvent$p(a r100) {
        return r100.event;
    }

    public final a appendBaseParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "baseParams");
        this.params.putAll(r100);
        return this;
    }

    public final a appendExtraParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extraParams");
        this.extraParams.putAll(r100);
        return this;
    }

    public final void appendParam(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        appendParam(r102.getKey(), r102.getValue());
        goto L4
    }

    public final a appendStagingFlagParam(boolean r100) {
        if (r100 == false) goto L4;
        this.params.put(KEY_STAGING_FLAG, "1");
    L4:
        return this;
    }

    public final String productLabel(Integer r100) {
        if (r100 == null) goto L8;
        if (r100.intValue() != 3) goto L8;
        return "recommend";
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L20:
        return "normal";
    L16:
        if (r100.intValue() != 2) goto L20;
        return "new";
    L11:
        if (r100.intValue() != 1) goto L13;
        goto L13
    }

    public final void appendParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b.f44002a.getClass();
        appendParam(r100, r101, b.C0794a.f44003a);
    }

    public final String followStatus(Integer r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.intValue() == (-1)) goto L21;
        int r102 = h2.f45604a;
        if (r101 == null) goto L8;
        boolean r103 = Intrinsics.areEqual(r.f48132a.f(), r101);
    L9:
        if (r103 == false) goto L11;
        return null;
    L11:
        if (r100.intValue() != 1) goto L13;
    L16:
        return "1";
    L13:
        if (r100.intValue() == 2) goto L16;
        return "0";
    L8:
        r103 = false;
        goto L9
    L21:
        return null;
    }

    @Override // com.bytedance.android.ec.core.event.d
    public void post(PageFinder r100, String r101) {
        b.f44002a.getClass();
        b.C0794a.C0795a r102 = b.C0794a.f44003a;
        appendParam("data_type", VALUE_DATA_TYPE, r102);
        appendParam(KEY_EVENT_ORIGIN_FEATURE, VALUE_TEMAI, r102);
        buildParams();
        this.params.putAll(this.extraParams);
        Single.fromCallable(new d(this, r101, r100)).subscribeOn(Schedulers.io()).subscribe();
        if (ECAppInfoService.f48114e.isDebug() == false) goto L10;
        new StringBuilder("<<<=========" + this.event + " start =========>>>\n");     // Catch: Throwable -> L12
        Iterator<T> r103 = this.params.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L12
        String r105 = (String) r104.getKey();     // Catch: Throwable -> L12
        String r106 = (String) r104.getValue();     // Catch: Throwable -> L12
        goto L7
    L9:
    L10:
        ECEventDumper.f44016h.getClass();
        ECEventDumper.a.c(this);
    }

    public final void appendParam(String r100, String r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.f276366p);
        if (r101 == null) goto L6;
        String r103 = this.params.put(r100, r102.a(r101));
        return;
    }
}
