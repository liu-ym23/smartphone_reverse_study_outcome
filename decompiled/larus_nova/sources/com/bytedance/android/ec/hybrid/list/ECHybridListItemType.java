package com.bytedance.android.ec.hybrid.list;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.hihealthlite.LoginFreeSDKStatusCodes;
import com.mammon.audiosdk.SAMICoreCode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\bI\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bK¨\u0006L"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/ECHybridListItemType;", "", "Ljava/io/Serializable;", "", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "INVALID", "SHOP_MOMENTS_SHORT_VIDEO_CARD", "SHOP_MOMENTS_SHORT_VIDEO_CARD_V2", "SHOP_PRODUCT_LIST_PRODUCT_CARD", "SHOP_PRODUCT_LIST_SORT_FILTER", "SHOP_PRODUCT_LIST_WINDOW_ENTRANCE", "SHOP_PRODUCT_LIST_MALL_CARD", "SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER", "SHOP_PRODUCT_LIST_PRODUCTS_FOOTER", "SHOP_PRODUCT_LIST_RECOMMEND_SHOP_CARD", "SHOP_PRODUCT_LIST_RECOMMEND_MULTI_SHOP_CARD", "SHOP_PRODUCT_LIST_EMPTY", "SHOP_PRODUCT_LIST_END", "SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE", "SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE", "SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE", "SHOP_PRODUCT_LIST_EMPTY_NEW", "SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND", "SHOP_MEMBER_CARD", "SHOP_MEMBER_CARD_SINGLE", "SHOP_SLICE_PRODUCT_CARD_SINGLE", "SHOP_SLICE_PRODUCT_CARD", "SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW", "SHOP_SLICE_PRODUCT_CARD_NEW", "SHOP_SLICE_CLOTHES_PREVIEW", "SHOP_SLICE_PRODUCTS_FILTER_CARD", "SHOP_MIDDLE_COUPON_FILTER", "SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE", "SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE", "SHOP_SEARCH_RESULT_GENERAL_CARD", "SHOP_LYNX_CARD_DIVIDER", "SHOP_MOMENTS_PRODUCT_UPDATE_CARD", "SHOP_MOMENTS_PRODUCT_SELL_TOP_CARD", "SHOP_MOMENTS_PRODUCT_GOOD_TOP_CARD", "SHOP_MOMENTS_WEBCAST_APPOINTMENT_CAR", "SHOP_MOMENTS_WEBCAST_SELL_TOP_CARD", "SHOP_MOMENTS_WEBCAST_GOOD_TOP_CARD", "SHOP_PRODUCTS_TREND", "SHOP_LYNX_CARD_LIST_NEWCOMER_BANNER_ITEM", "SHOP_LYNX_CARD_HEADER_CARD_V2", "UNKNOWN_1_CARD", "UNKNOWN_2_CARD", "UNKNOWN_3_CARD", "UNKNOWN_4_CARD", "SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD", "SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD", "MALL_LYNX_VIDEO_CARD", "HYBRID_TYPE_FAV_LOADING_CARD", "MITA_CARD_VIEW_HOLDER_MIN", "MITA_CARD_VIEW_HOLDER_MAX", "NATIVE_VIEW_HOLDER_MAX", "NATIVE_FLEXIBLE_PRODUCT_CARD", "SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD", "LYNX_CHIP_AREA_CARD", "LYNX_VIEW_HOLDER_MAX", "NATIVE_LIVE_BIG_CARD", "NATIVE_VIDEO_BIG_CARD", "NATIVE_HEADER_CHIP_AREA_CARD", "MALL_CHANNEL_CARD_VIEW_HOLDER_MIN", "MALL_CHANNEL_CARD_VIEW_HOLDER_MAX", "MALL_CHANNEL_CARD", "LOGIN_GUIDE_CARD", "HYBRID_LIST_SINGLE_PLACEHOLDER_CARD", "HYBRID_LIST_DOUBLE_PLACEHOLDER_CARD", "HYBRID_LIST_TITLE", "HYBRID_LIST_LOAD_MORE_VIEW_HOLDER", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECHybridListItemType extends Enum<ECHybridListItemType> implements Serializable {
    public static final a Companion = null;
    public static final ECHybridListItemType HYBRID_LIST_DOUBLE_PLACEHOLDER_CARD = null;
    public static final ECHybridListItemType HYBRID_LIST_LOAD_MORE_VIEW_HOLDER = null;
    public static final ECHybridListItemType HYBRID_LIST_SINGLE_PLACEHOLDER_CARD = null;
    public static final ECHybridListItemType HYBRID_LIST_TITLE = null;

    @SerializedName("1007")
    public static final ECHybridListItemType HYBRID_TYPE_FAV_LOADING_CARD = null;
    public static final ECHybridListItemType INVALID = null;
    public static final ECHybridListItemType LOGIN_GUIDE_CARD = null;

    @SerializedName("51013")
    public static final ECHybridListItemType LYNX_CHIP_AREA_CARD = null;
    public static final ECHybridListItemType LYNX_VIEW_HOLDER_MAX = null;
    public static final ECHybridListItemType MALL_CHANNEL_CARD = null;
    public static final ECHybridListItemType MALL_CHANNEL_CARD_VIEW_HOLDER_MAX = null;
    public static final ECHybridListItemType MALL_CHANNEL_CARD_VIEW_HOLDER_MIN = null;

    @SerializedName("51044")
    public static final ECHybridListItemType MALL_LYNX_VIDEO_CARD = null;
    public static final ECHybridListItemType MITA_CARD_VIEW_HOLDER_MAX = null;
    public static final ECHybridListItemType MITA_CARD_VIEW_HOLDER_MIN = null;

    @SerializedName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF)
    public static final ECHybridListItemType NATIVE_FLEXIBLE_PRODUCT_CARD = null;

    @SerializedName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON)
    public static final ECHybridListItemType NATIVE_HEADER_CHIP_AREA_CARD = null;

    @SerializedName("1008")
    public static final ECHybridListItemType NATIVE_LIVE_BIG_CARD = null;

    @SerializedName("1009")
    public static final ECHybridListItemType NATIVE_VIDEO_BIG_CARD = null;
    public static final ECHybridListItemType NATIVE_VIEW_HOLDER_MAX = null;

    @SerializedName("50000")
    public static final ECHybridListItemType SHOP_LYNX_CARD_DIVIDER = null;

    @SerializedName("52001")
    public static final ECHybridListItemType SHOP_LYNX_CARD_HEADER_CARD_V2 = null;

    @SerializedName("51012")
    public static final ECHybridListItemType SHOP_LYNX_CARD_LIST_NEWCOMER_BANNER_ITEM = null;

    @SerializedName("18")
    public static final ECHybridListItemType SHOP_MEMBER_CARD = null;

    @SerializedName(Constants.VIA_ACT_TYPE_NINETEEN)
    public static final ECHybridListItemType SHOP_MEMBER_CARD_SINGLE = null;

    @SerializedName("105")
    public static final ECHybridListItemType SHOP_MIDDLE_COUPON_FILTER = null;

    @SerializedName("50003")
    public static final ECHybridListItemType SHOP_MOMENTS_PRODUCT_GOOD_TOP_CARD = null;

    @SerializedName("50002")
    public static final ECHybridListItemType SHOP_MOMENTS_PRODUCT_SELL_TOP_CARD = null;

    @SerializedName("50001")
    public static final ECHybridListItemType SHOP_MOMENTS_PRODUCT_UPDATE_CARD = null;

    @SerializedName("1")
    public static final ECHybridListItemType SHOP_MOMENTS_SHORT_VIDEO_CARD = null;

    @SerializedName("2")
    public static final ECHybridListItemType SHOP_MOMENTS_SHORT_VIDEO_CARD_V2 = null;

    @SerializedName("50004")
    public static final ECHybridListItemType SHOP_MOMENTS_WEBCAST_APPOINTMENT_CAR = null;

    @SerializedName("50006")
    public static final ECHybridListItemType SHOP_MOMENTS_WEBCAST_GOOD_TOP_CARD = null;

    @SerializedName("50005")
    public static final ECHybridListItemType SHOP_MOMENTS_WEBCAST_SELL_TOP_CARD = null;

    @SerializedName("50210")
    public static final ECHybridListItemType SHOP_PRODUCTS_TREND = null;

    @SerializedName("11")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_EMPTY = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_START_WAP)
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_EMPTY_NEW = null;

    @SerializedName("12")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_END = null;

    @SerializedName("6")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_MALL_CARD = null;

    @SerializedName("8")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCTS_FOOTER = null;

    @SerializedName("3")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_MAKE_FRIEND)
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE = null;

    @SerializedName("20")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_WPA_STATE)
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE = null;

    @SerializedName("21")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE = null;

    @SerializedName("13")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_START_GROUP)
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND = null;

    @SerializedName("7")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_RECOMMEND_MULTI_SHOP_CARD = null;

    @SerializedName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_RECOMMEND_SHOP_CARD = null;

    @SerializedName("4")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_SORT_FILTER = null;

    @SerializedName("5")
    public static final ECHybridListItemType SHOP_PRODUCT_LIST_WINDOW_ENTRANCE = null;

    @SerializedName("100")
    public static final ECHybridListItemType SHOP_SEARCH_RESULT_GENERAL_CARD = null;

    @SerializedName(IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX)
    public static final ECHybridListItemType SHOP_SLICE_CLOTHES_PREVIEW = null;

    @SerializedName("104")
    public static final ECHybridListItemType SHOP_SLICE_PRODUCTS_FILTER_CARD = null;

    @SerializedName("99")
    public static final ECHybridListItemType SHOP_SLICE_PRODUCT_CARD = null;

    @SerializedName(BDLocationException.ERROR_UID_IS_EMPTY)
    public static final ECHybridListItemType SHOP_SLICE_PRODUCT_CARD_NEW = null;

    @SerializedName(BDLocationException.ERROR_BEACON_INFO_NULL)
    public static final ECHybridListItemType SHOP_SLICE_PRODUCT_CARD_SINGLE = null;

    @SerializedName("101")
    public static final ECHybridListItemType SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW = null;

    @SerializedName(com.byted.cast.common.Constants.DEMO_HOST_AID)
    public static final ECHybridListItemType SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD = null;

    @SerializedName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M)
    public static final ECHybridListItemType SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD = null;

    @SerializedName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF)
    public static final ECHybridListItemType SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD = null;

    @SerializedName("51001")
    public static final ECHybridListItemType UNKNOWN_1_CARD = null;

    @SerializedName("51008")
    public static final ECHybridListItemType UNKNOWN_2_CARD = null;

    @SerializedName("51009")
    public static final ECHybridListItemType UNKNOWN_3_CARD = null;

    @SerializedName("51199")
    public static final ECHybridListItemType UNKNOWN_4_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECHybridListItemType[] f46914a = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static boolean a(int r100) {
            int r101 = ECHybridListItemType.NATIVE_VIEW_HOLDER_MAX.getType() + 1;
            int r102 = ECHybridListItemType.LYNX_VIEW_HOLDER_MAX.getType();
            if (r101 > r100) goto L7;
            if (r102 < r100) goto L7;
            return true;
        L7:
            return false;
        }

        public static boolean b(Integer r100) {
            IntRange r101 = new IntRange(ECHybridListItemType.MALL_CHANNEL_CARD_VIEW_HOLDER_MIN.getType(), ECHybridListItemType.MALL_CHANNEL_CARD_VIEW_HOLDER_MAX.getType());
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.contains(r100.intValue()) == false) goto L7;
            return true;
        }

        public static boolean c(int r100) {
            int r101 = ECHybridListItemType.MITA_CARD_VIEW_HOLDER_MIN.getType();
            int r102 = ECHybridListItemType.MITA_CARD_VIEW_HOLDER_MAX.getType();
            if (r101 > r100) goto L7;
            if (r102 < r100) goto L7;
            return true;
        L7:
            return false;
        }
    }

    public static ECHybridListItemType valueOf(String r100) {
        return (ECHybridListItemType) r27.a.a(ECHybridListItemType.class, r100);
    }

    public static ECHybridListItemType[] values() {
        return (ECHybridListItemType[]) f46914a.clone();
    }

    static {
        ECHybridListItemType r100 = new ECHybridListItemType("INVALID", 0, -1);
        INVALID = r100;
        ECHybridListItemType r101 = new ECHybridListItemType("SHOP_MOMENTS_SHORT_VIDEO_CARD", 1, 1);
        SHOP_MOMENTS_SHORT_VIDEO_CARD = r101;
        ECHybridListItemType r102 = new ECHybridListItemType("SHOP_MOMENTS_SHORT_VIDEO_CARD_V2", 2, 2);
        SHOP_MOMENTS_SHORT_VIDEO_CARD_V2 = r102;
        ECHybridListItemType r103 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD", 3, 3);
        SHOP_PRODUCT_LIST_PRODUCT_CARD = r103;
        ECHybridListItemType r104 = new ECHybridListItemType("SHOP_PRODUCT_LIST_SORT_FILTER", 4, 4);
        SHOP_PRODUCT_LIST_SORT_FILTER = r104;
        ECHybridListItemType r105 = new ECHybridListItemType("SHOP_PRODUCT_LIST_WINDOW_ENTRANCE", 5, 5);
        SHOP_PRODUCT_LIST_WINDOW_ENTRANCE = r105;
        ECHybridListItemType r106 = new ECHybridListItemType("SHOP_PRODUCT_LIST_MALL_CARD", 6, 6);
        SHOP_PRODUCT_LIST_MALL_CARD = r106;
        ECHybridListItemType r107 = new ECHybridListItemType("SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER", 7, 7);
        SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER = r107;
        ECHybridListItemType r108 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCTS_FOOTER", 8, 8);
        SHOP_PRODUCT_LIST_PRODUCTS_FOOTER = r108;
        ECHybridListItemType r109 = new ECHybridListItemType("SHOP_PRODUCT_LIST_RECOMMEND_SHOP_CARD", 9, 9);
        SHOP_PRODUCT_LIST_RECOMMEND_SHOP_CARD = r109;
        ECHybridListItemType r110 = new ECHybridListItemType("SHOP_PRODUCT_LIST_RECOMMEND_MULTI_SHOP_CARD", 10, 10);
        SHOP_PRODUCT_LIST_RECOMMEND_MULTI_SHOP_CARD = r110;
        ECHybridListItemType r111 = new ECHybridListItemType("SHOP_PRODUCT_LIST_EMPTY", 11, 11);
        SHOP_PRODUCT_LIST_EMPTY = r111;
        ECHybridListItemType r112 = new ECHybridListItemType("SHOP_PRODUCT_LIST_END", 12, 12);
        SHOP_PRODUCT_LIST_END = r112;
        ECHybridListItemType r113 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE", 13, 13);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE = r113;
        ECHybridListItemType r114 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE", 14, 14);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE = r114;
        ECHybridListItemType r115 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE", 15, 15);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE = r115;
        ECHybridListItemType r116 = new ECHybridListItemType("SHOP_PRODUCT_LIST_EMPTY_NEW", 16, 16);
        SHOP_PRODUCT_LIST_EMPTY_NEW = r116;
        ECHybridListItemType r117 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND", 17, 17);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND = r117;
        ECHybridListItemType r118 = new ECHybridListItemType("SHOP_MEMBER_CARD", 18, 18);
        SHOP_MEMBER_CARD = r118;
        ECHybridListItemType r119 = new ECHybridListItemType("SHOP_MEMBER_CARD_SINGLE", 19, 19);
        SHOP_MEMBER_CARD_SINGLE = r119;
        ECHybridListItemType r120 = new ECHybridListItemType("SHOP_SLICE_PRODUCT_CARD_SINGLE", 20, 98);
        SHOP_SLICE_PRODUCT_CARD_SINGLE = r120;
        ECHybridListItemType r121 = new ECHybridListItemType("SHOP_SLICE_PRODUCT_CARD", 21, 99);
        SHOP_SLICE_PRODUCT_CARD = r121;
        ECHybridListItemType r122 = new ECHybridListItemType("SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW", 22, 101);
        SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW = r122;
        ECHybridListItemType r123 = new ECHybridListItemType("SHOP_SLICE_PRODUCT_CARD_NEW", 23, 102);
        SHOP_SLICE_PRODUCT_CARD_NEW = r123;
        ECHybridListItemType r124 = new ECHybridListItemType("SHOP_SLICE_CLOTHES_PREVIEW", 24, 103);
        SHOP_SLICE_CLOTHES_PREVIEW = r124;
        ECHybridListItemType r125 = new ECHybridListItemType("SHOP_SLICE_PRODUCTS_FILTER_CARD", 25, 104);
        SHOP_SLICE_PRODUCTS_FILTER_CARD = r125;
        ECHybridListItemType r126 = new ECHybridListItemType("SHOP_MIDDLE_COUPON_FILTER", 26, 105);
        SHOP_MIDDLE_COUPON_FILTER = r126;
        ECHybridListItemType r127 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE", 27, 20);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE = r127;
        ECHybridListItemType r128 = new ECHybridListItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE", 28, 21);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE = r128;
        ECHybridListItemType r129 = new ECHybridListItemType("SHOP_SEARCH_RESULT_GENERAL_CARD", 29, 100);
        SHOP_SEARCH_RESULT_GENERAL_CARD = r129;
        ECHybridListItemType r130 = new ECHybridListItemType("SHOP_LYNX_CARD_DIVIDER", 30, 50000);
        SHOP_LYNX_CARD_DIVIDER = r130;
        ECHybridListItemType r131 = new ECHybridListItemType("SHOP_MOMENTS_PRODUCT_UPDATE_CARD", 31, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND);
        SHOP_MOMENTS_PRODUCT_UPDATE_CARD = r131;
        ECHybridListItemType r132 = new ECHybridListItemType("SHOP_MOMENTS_PRODUCT_SELL_TOP_CARD", 32, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY);
        SHOP_MOMENTS_PRODUCT_SELL_TOP_CARD = r132;
        ECHybridListItemType r133 = new ECHybridListItemType("SHOP_MOMENTS_PRODUCT_GOOD_TOP_CARD", 33, TTVideoEngineInterface.ALGO_OPTION_INT_CACHE_TIMESTAMP);
        SHOP_MOMENTS_PRODUCT_GOOD_TOP_CARD = r133;
        ECHybridListItemType r134 = new ECHybridListItemType("SHOP_MOMENTS_WEBCAST_APPOINTMENT_CAR", 34, TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_EXITED_LC);
        SHOP_MOMENTS_WEBCAST_APPOINTMENT_CAR = r134;
        ECHybridListItemType r135 = new ECHybridListItemType("SHOP_MOMENTS_WEBCAST_SELL_TOP_CARD", 35, TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_ORIGIN_LC);
        SHOP_MOMENTS_WEBCAST_SELL_TOP_CARD = r135;
        ECHybridListItemType r136 = new ECHybridListItemType("SHOP_MOMENTS_WEBCAST_GOOD_TOP_CARD", 36, TTVideoEngineInterface.ALGO_OPTION_INT_SELECT_BITRATE_MODE);
        SHOP_MOMENTS_WEBCAST_GOOD_TOP_CARD = r136;
        ECHybridListItemType r137 = new ECHybridListItemType("SHOP_PRODUCTS_TREND", 37, 50210);
        SHOP_PRODUCTS_TREND = r137;
        ECHybridListItemType r138 = new ECHybridListItemType("SHOP_LYNX_CARD_LIST_NEWCOMER_BANNER_ITEM", 38, LoginFreeSDKStatusCodes.HEALTHKIT_SDK_TO_APP_FAIL);
        SHOP_LYNX_CARD_LIST_NEWCOMER_BANNER_ITEM = r138;
        ECHybridListItemType r139 = new ECHybridListItemType("SHOP_LYNX_CARD_HEADER_CARD_V2", 39, LoginFreeSDKStatusCodes.HEALTHKIT_SDK_TO_APP_FAIL);
        SHOP_LYNX_CARD_HEADER_CARD_V2 = r139;
        ECHybridListItemType r140 = new ECHybridListItemType("UNKNOWN_1_CARD", 40, 51001);
        UNKNOWN_1_CARD = r140;
        ECHybridListItemType r141 = new ECHybridListItemType("UNKNOWN_2_CARD", 41, 51008);
        UNKNOWN_2_CARD = r141;
        ECHybridListItemType r142 = new ECHybridListItemType("UNKNOWN_3_CARD", 42, 51009);
        UNKNOWN_3_CARD = r142;
        ECHybridListItemType r143 = new ECHybridListItemType("UNKNOWN_4_CARD", 43, 51199);
        UNKNOWN_4_CARD = r143;
        ECHybridListItemType r144 = new ECHybridListItemType("SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD", 44, 1001);
        SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD = r144;
        ECHybridListItemType r145 = new ECHybridListItemType("SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD", 45, 1002);
        SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD = r145;
        ECHybridListItemType r146 = new ECHybridListItemType("MALL_LYNX_VIDEO_CARD", 46, 51044);
        MALL_LYNX_VIDEO_CARD = r146;
        ECHybridListItemType r147 = new ECHybridListItemType("HYBRID_TYPE_FAV_LOADING_CARD", 47, 1007);
        HYBRID_TYPE_FAV_LOADING_CARD = r147;
        ECHybridListItemType r148 = new ECHybridListItemType("MITA_CARD_VIEW_HOLDER_MIN", 48, 20000);
        MITA_CARD_VIEW_HOLDER_MIN = r148;
        ECHybridListItemType r149 = new ECHybridListItemType("MITA_CARD_VIEW_HOLDER_MAX", 49, 29999);
        MITA_CARD_VIEW_HOLDER_MAX = r149;
        ECHybridListItemType r150 = new ECHybridListItemType("NATIVE_VIEW_HOLDER_MAX", 50, 50000);
        NATIVE_VIEW_HOLDER_MAX = r150;
        ECHybridListItemType r151 = new ECHybridListItemType("NATIVE_FLEXIBLE_PRODUCT_CARD", 51, 1011);
        NATIVE_FLEXIBLE_PRODUCT_CARD = r151;
        ECHybridListItemType r152 = new ECHybridListItemType("SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD", 52, 1013);
        SHOP_VIEW_HOLDER_NATIVE_DELIVERY_CARD = r152;
        ECHybridListItemType r153 = new ECHybridListItemType("LYNX_CHIP_AREA_CARD", 53, LoginFreeSDKStatusCodes.HEALTHKIT_SDK_TO_H5_FAIL);
        LYNX_CHIP_AREA_CARD = r153;
        ECHybridListItemType r154 = new ECHybridListItemType("LYNX_VIEW_HOLDER_MAX", 54, 100000);
        LYNX_VIEW_HOLDER_MAX = r154;
        ECHybridListItemType r155 = new ECHybridListItemType("NATIVE_LIVE_BIG_CARD", 55, 1008);
        NATIVE_LIVE_BIG_CARD = r155;
        ECHybridListItemType r156 = new ECHybridListItemType("NATIVE_VIDEO_BIG_CARD", 56, 1009);
        NATIVE_VIDEO_BIG_CARD = r156;
        ECHybridListItemType r157 = new ECHybridListItemType("NATIVE_HEADER_CHIP_AREA_CARD", 57, 1010);
        NATIVE_HEADER_CHIP_AREA_CARD = r157;
        ECHybridListItemType r158 = new ECHybridListItemType("MALL_CHANNEL_CARD_VIEW_HOLDER_MIN", 58, SAMICoreCode.SAMI_PROCESSOR_BASE);
        MALL_CHANNEL_CARD_VIEW_HOLDER_MIN = r158;
        ECHybridListItemType r159 = new ECHybridListItemType("MALL_CHANNEL_CARD_VIEW_HOLDER_MAX", 59, 115000);
        MALL_CHANNEL_CARD_VIEW_HOLDER_MAX = r159;
        ECHybridListItemType r160 = new ECHybridListItemType("MALL_CHANNEL_CARD", 60, SAMICoreCode.SAMI_PROCESSOR_BASE);
        MALL_CHANNEL_CARD = r160;
        ECHybridListItemType r161 = new ECHybridListItemType("LOGIN_GUIDE_CARD", 61, -2001);
        LOGIN_GUIDE_CARD = r161;
        ECHybridListItemType r162 = new ECHybridListItemType("HYBRID_LIST_SINGLE_PLACEHOLDER_CARD", 62, -2002);
        HYBRID_LIST_SINGLE_PLACEHOLDER_CARD = r162;
        ECHybridListItemType r163 = new ECHybridListItemType("HYBRID_LIST_DOUBLE_PLACEHOLDER_CARD", 63, -2003);
        HYBRID_LIST_DOUBLE_PLACEHOLDER_CARD = r163;
        ECHybridListItemType r164 = new ECHybridListItemType("HYBRID_LIST_TITLE", 64, -1001);
        HYBRID_LIST_TITLE = r164;
        ECHybridListItemType r165 = new ECHybridListItemType("HYBRID_LIST_LOAD_MORE_VIEW_HOLDER", 65, -1000);
        HYBRID_LIST_LOAD_MORE_VIEW_HOLDER = r165;
        f46914a = new ECHybridListItemType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165};
        Companion = new a();
    }

    public final int getType() {
        return this.type;
    }

    public ECHybridListItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
