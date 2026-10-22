package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class ECPromotion extends com.bytedance.android.ec.model.g implements Serializable {
    public static final int APP_TYPE_TAOBAO = 1;
    public static final transient String BACKGROUND_BUTTON_ICON = "background";
    public static final String DETAIL = "detail";
    public static final String NORMAL_BOTTON_ICON = "normal";
    public static final int PLATFORM_ALLIANCE = 1;
    public static final int PLATFORM_JD = 7;
    public static final int PLATFORM_JINGDONG_URL = 10;
    public static final int PLATFORM_SUNING = 8;
    public static final int PLATFORM_SUNING_URL = 11;
    public static final int PLATFORM_TAOBAO_FEED = 3;
    public static final int PLATFORM_TAOBAO_PC = 2;
    public static final int PLATFORM_TAOBAO_URL = 9;
    public static final int PLATFORM_TAOBO_OP = 6;
    public static final int PLATFORM_TAOBO_PWD = 5;
    public static final int PLATFORM_XIAODIAN = 4;
    public static final String SHORT_HALF = "split_short_half";
    public static final String SKU = "sku";
    public static final String SPLIT = "split";
    public static final transient String TRANSPARENT_BOTTON_ICON = "transparent";

    @SerializedName("activity")
    public ECActivityResponse activity;

    @SerializedName("add_cart_param")
    public n addCartParams;

    @SerializedName("apply_coupon")
    public int applyCoupon;

    @SerializedName("ask_explain_info")
    public ECPromotionAskExplainInfo askExplainInfo;

    @SerializedName("atmosphere")
    public ECAtmosphere atmosphere;

    @SerializedName("auction_atmosphere")
    public ECAuctionAtmosphere auctionAtmosphere;

    @SerializedName("auction_v2")
    public ECAuctionInfo auctionV2;

    @SerializedName("author_stat")
    public AuthorStat authorStat;

    @SerializedName("background")
    public ECCurrentPromotion.PopBackground background;

    @SerializedName("benefit_labels")
    public List<PromotionBenefitLabel> benefitLabels;

    @SerializedName("biz_identity")
    public String bizIdentity;

    @SerializedName("bottom_banner")
    public ECPromotionBottomBanner bottomBanner;
    public Map<String, String> bottomIcon;
    public long buttomIconWide;

    @SerializedName("button_label")
    public String buttonLabel;

    @SerializedName(alternate = {"is_campaign"}, value = "campaign")
    public boolean campaign;

    @SerializedName("campaign_info")
    public ECPromotionCampaign campaignInfo;

    @SerializedName("can_add_cart")
    public boolean canAddShopCart;

    @SerializedName("can_explain")
    public boolean canExplain;

    @SerializedName("can_sold")
    public boolean canSold;
    public long carouselTime;

    @SerializedName("category")
    public ECCategoryData categoryData;

    @SerializedName("channel_id")
    public String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    public int channelType;

    @SerializedName("check_callback")
    public String checkCallback;

    @SerializedName("combination")
    public ECCombination combination;

    @SerializedName("commentary_video_data")
    public String commentaryVideoData;

    @SerializedName("cover")
    public String cover;

    @SerializedName("detail_cover")
    public ECUrlModel detailCover;

    @SerializedName("detail_url")
    public String detailUrl;

    @SerializedName("directly_jump_url")
    public String directlyJumpUrl;

    @SerializedName("dynamic_recommend_index")
    public int dynamicRecommendIndex;

    @SerializedName("event_param")
    public Map<String, String> eventParams;

    @SerializedName("explain_type")
    public int explainType;
    public ECPopExtendInfo extendInfo;

    @SerializedName("extra")
    public Extra extra;

    @SerializedName("find_goods_info")
    public String findGoodsInfo;

    @SerializedName("flash_icon")
    public String flashIcon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_FLASH_TYPE)
    public int flashType;

    @SerializedName("flicker_icon_v2")
    public FlickerIcon flickerIconV2;
    public ECFloatWindowInfo floatWindowInfo;

    @SerializedName("force_price_module")
    public boolean forcePriceModule;

    @SerializedName("fragment_id")
    public String fragmentId;

    @SerializedName("given_info")
    public ECGivenProductStruck givenProduct;

    @SerializedName("has_commentary_video")
    public boolean hasCommentaryVideo;

    @SerializedName("has_price_module")
    public boolean hasPriceModule;

    @SerializedName("hide_cart")
    public boolean hideCart;

    @SerializedName("hot_atmosphere")
    public ECHotAtmosphere hotAtmosphere;

    @SerializedName("in_stock")
    public boolean inStock;

    @SerializedName("index")
    public int index;

    @SerializedName("auction")
    public boolean isAuction;
    public transient boolean isRetry;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    public int itemType;

    @SerializedName("jump_destination")
    public ECJumpDestination jumpDestination;

    @SerializedName("label_icon")
    public String labelIcon;

    @SerializedName("leaf_category")
    public String leafCategory;
    public long liveRoomType;
    public long logicalClock;

    @SerializedName(CronetDataStorageAccess.LOGID)
    public String logid;

    @SerializedName("lottery")
    public boolean lottery;

    @SerializedName("lottery_info")
    public ECPromotionLotteryInfo lotteryInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    public long marketPrice;

    @SerializedName("max_price")
    public long maxPrice;

    @SerializedName("min_price")
    public long minPrice;

    @SerializedName("min_price_str")
    public String minPriceStr;
    public String opType;

    @SerializedName("order_url")
    public String orderUrl;

    @SerializedName("overlay_type")
    public int overlayType;

    @SerializedName("platform")
    public int platform;

    @SerializedName("platform_atmosphere")
    public ECUrlModel platformAtmosphere;

    @SerializedName("platform_label")
    public String platformLabel;

    @SerializedName("pop_header")
    public ECPromotionPopHeader pop3DHeader;

    @SerializedName("prefetch_order")
    public PrefetchOrder prefetchOrder;

    @SerializedName("price_description")
    public ECPriceDescription priceDescription;

    @SerializedName("price_header")
    public String priceHeader;

    @SerializedName("product_id")
    public String productId;

    @SerializedName("biz_kind")
    public int productKind;
    public long productType;

    @SerializedName("promotion_bottom")
    public ll.a promotionBottom;

    @SerializedName("promotion_header")
    public ll.a promotionHeader;

    @SerializedName("promotion_id")
    public String promotionId;
    public transient ECCurrentPromotion.a publicArea;
    public ECPromotionCampaign rawCampaign;

    @SerializedName("real_index")
    public int realIndex;

    @SerializedName("recommend_sell_point_data")
    public ECSalePointCarouselData recommendPointData;
    public String replaceRelatedInfo;

    @SerializedName("reservation_info")
    public ReservationInfo reservationInfo;

    @SerializedName("rit_tags")
    public Map<String, List<ECRitTag>> ritTags;
    public int roomType;

    @SerializedName("sell_point_data")
    public ECSalePointCarouselData salePointData;
    public long serverTime;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    public String shopId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    public List<String> shopSource;

    @SerializedName("short_title")
    public String shortTitle;
    public long showDuration;
    public long showPriority;

    @SerializedName("is_sole_sku")
    public boolean singleSku;

    @SerializedName("skin")
    public ECSkinData skinData;

    @SerializedName("small_pop_card")
    public SmallPopCard smallPopCard;

    @SerializedName("sold_hint")
    public String soldHint;

    @SerializedName("sale_num")
    public long soldNum;

    @SerializedName("source")
    public String source;

    @SerializedName("standard_event_track")
    public StandardEventTrack standardEventTrack;

    @SerializedName("status")
    public int status;

    @SerializedName("status_img_map")
    public Map<String, String> statusImgMap;

    @SerializedName("status_img_url")
    public ECUrlModel statusImgUrl;

    @SerializedName("purchase_stepper")
    public v stepperInfo;

    @SerializedName("stock_num")
    public long stockNum;

    @SerializedName("title")
    public String title;
    public ECUrlModel topIcon;
    public String upDesc;
    public String upIcon;

    @SerializedName("up_icon_tag_track")
    public RitTagTrack upIconTagTrack;

    public static class AuthorStat implements Serializable {

        @SerializedName("gmv")
        public String gmv;

        @SerializedName("order_num")
        public String orderNum;

        @SerializedName("user_num")
        public String userNum;

        public AuthorStat() {
        }
    }

    public static class CommentWordsItem implements Serializable {

        @SerializedName("name")
        public String name;

        public CommentWordsItem() {
            this.name = null;
        }
    }

    public static class ECActivityResponse implements Serializable {

        @SerializedName("activity_banner")
        public String activityBanner;

        @SerializedName("activity_banner_landscape")
        public String activityBannerLandscape;

        @SerializedName("activity_banner_small")
        public String activityBannerSmall;

        @SerializedName("activity_icon")
        public String activityIcon;

        @SerializedName("activity_id")
        public long activityId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE)
        public long activityType;

        public ECActivityResponse() {
        }
    }

    public static class Extra implements Serializable {

        @SerializedName("coupon_min_price")
        public String couponMinPrice;

        @SerializedName("has_discount_price")
        public String hasDiscountPrice;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)
        public String originId;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE)
        public String originType;

        @SerializedName("show_notice")
        public String showNotice;

        @SerializedName("track_extra")
        public String trackExtra;

        public Extra() {
            this.trackExtra = "";
        }
    }

    public static class FlickerIcon implements Serializable {

        @SerializedName("duration")
        public long duration;

        @SerializedName("tag")
        public String eventTag;

        @SerializedName("url")
        public ECUrlModel icon;

        @SerializedName("show_index")
        public boolean showIndex;

        public FlickerIcon() {
            this.showIndex = false;
        }
    }

    public static class Presale implements Serializable {

        @SerializedName("delivery_time")
        public long deliveryTime;

        @SerializedName("end_time")
        public long endTime;

        @SerializedName("server_time")
        public long serverTime;

        public Presale() {
        }
    }

    public static class ReservationInfo implements Serializable {

        @SerializedName("button_label")
        public Map<String, String> buttonLabel;

        @SerializedName("reservation_end_time")
        public long endTime;

        @SerializedName("has_reservation")
        public int hasReserved;

        @SerializedName("server_time")
        public long serverTime;

        @SerializedName("reservation_start_time")
        public long startTime;

        public ReservationInfo() {
        }
    }

    public static class SmallPopCard implements Serializable {

        @SerializedName("background_img")
        public String backgroundImg;

        @SerializedName("background_img_new")
        public String backgroundImgNew;

        @SerializedName("button_label")
        public String buttonLabel;

        @SerializedName("header_img")
        public String headerImg;

        @SerializedName("header_label")
        public String headerLabel;

        public SmallPopCard() {
        }
    }

    public ECPromotion() {
        this.canSold = true;
        this.isRetry = false;
        this.productType = 0;
        this.showDuration = 10000;
        this.carouselTime = 0;
    }
}
