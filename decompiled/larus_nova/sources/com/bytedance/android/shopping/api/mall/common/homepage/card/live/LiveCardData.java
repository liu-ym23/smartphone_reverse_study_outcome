package com.bytedance.android.shopping.api.mall.common.homepage.card.live;

import androidx.compose.ui.spatial.RectListKt;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b>\b\u0007\u0018\u00002\u00020\u0001:\u0005cdefgBÕ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010/J\b\u0010a\u001a\u0004\u0018\u00010\u0001J\b\u0010b\u001a\u0004\u0018\u00010\u0013R\u0018\u0010-\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010+\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u0010.\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010,\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u001a\u0010'\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b;\u00106R\u0018\u0010)\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b\u0018\u00106R\u0018\u0010&\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u00101R\u0018\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\"\u0010(\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bL\u00106\"\u0004\bM\u0010NR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bO\u00106R\u0018\u0010!\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00101R\u001a\u0010\"\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bT\u00106R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bW\u0010XR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0010\u0010^\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`¨\u0006h"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData;", "", "type", "", "live", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;", "impression", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "cardCommon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "schema", "", "marketIngData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "isAd", "", "favoriteLiveCardABValue", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "favoriteLiveCardABValues", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "needShowAdTagUI", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "playIcon", "showJustNowUI", "windVaneData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneParams", "isInstantRecCard", "disableVane", "needAnimation", "elementStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "btmCD", "descIcon", "accessibilityLabel", "cardMute", "(Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getBtmCD", "getCardCommon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "getCardMute", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getDescIcon", "getDisableVane", "getElementStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "getFavoriteLiveCardABValue", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "getFavoriteLiveCardABValues", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "getImpression", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "getLive", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "getMarketIngData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "getNeedAnimation", "setNeedAnimation", "(Ljava/lang/Boolean;)V", "getNeedShowAdTagUI", "getPlayIcon", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "getSchema", "getShowJustNowUI", "getStore", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "getWindVaneData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneHaveRcInfo", "getWindVaneParams", "()Ljava/lang/Object;", "carryRCInfoWindVaneParams", "rcPriorityFromProduct", "FavoriteItemStyle", "FavoriteLiveCardABValue", "FavoriteLiveCardABValues", "Live", "TTFavoriteLiveCardABParam", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCardData {

    @SerializedName("accessibility_label")
    private final String accessibilityLabel;

    @SerializedName("btm_cd")
    private final String btmCD;

    @SerializedName("card_common")
    private final CommonData.CardCommon cardCommon;

    @SerializedName("card_mute")
    private final Boolean cardMute;

    @SerializedName("gold_coin_info")
    private final CommonData.CoinData coinData;

    @SerializedName("desc_icon")
    private final String descIcon;

    @SerializedName("disable_vane")
    private final Boolean disableVane;

    @SerializedName("element_style")
    private final CommonData.ElementStyle elementStyle;

    @SerializedName("extra")
    private final CommonData.Extra extra;

    @SerializedName("ab_value")
    private final FavoriteLiveCardABValue favoriteLiveCardABValue;

    @SerializedName("ab_values")
    private final FavoriteLiveCardABValues favoriteLiveCardABValues;

    @SerializedName("impression")
    private final CommonData.Impression impression;

    @SerializedName("is_ad")
    private final Boolean isAd;

    @SerializedName("is_instant_rec_card")
    private final String isInstantRecCard;

    @SerializedName("item_style")
    private final FavoriteItemStyle itemStyle;

    @SerializedName("live")
    private final Live live;

    @SerializedName("marketing_data")
    private final CommonData.MarketingData marketIngData;

    @SerializedName("need_animation")
    private Boolean needAnimation;

    @SerializedName("need_show_ad_tag_ui")
    private final Boolean needShowAdTagUI;

    @SerializedName("play_icon")
    private final String playIcon;

    @SerializedName("product")
    private final CommonData.Product product;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("show_just_now_ui")
    private final Boolean showJustNowUI;

    @SerializedName(ComplianceConstants.ComplianceRequest.MARKET_STORE)
    private final CommonData.Store store;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final CommonData.User user;

    @SerializedName("wind_vane_data")
    private final CommonData.WindVaneEventData windVaneData;
    private String windVaneHaveRcInfo;

    @SerializedName("wind_vane_params")
    private final Object windVaneParams;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "", "itemCornerRadius", "", "itemThemeColor", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getItemCornerRadius", "()Ljava/lang/Double;", "setItemCornerRadius", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getItemThemeColor", "()Ljava/lang/String;", "setItemThemeColor", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteItemStyle {

        @SerializedName("item_corner_radius")
        private Double itemCornerRadius;

        @SerializedName("item_theme_color")
        private String itemThemeColor;

        /* JADX WARN: Multi-variable type inference failed */
        public FavoriteItemStyle() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FavoriteItemStyle copy$default(FavoriteItemStyle r100, Double r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.itemCornerRadius;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.itemThemeColor;
        L9:
            return r100.copy(r101, r102);
        }

        public final Double component1() {
            return this.itemCornerRadius;
        }

        public final String component2() {
            return this.itemThemeColor;
        }

        public final FavoriteItemStyle copy(Double r100, String r101) {
            return new FavoriteItemStyle(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FavoriteItemStyle) == false) goto L10;
            FavoriteItemStyle r101 = (FavoriteItemStyle) r100;
            if (Intrinsics.areEqual(this.itemCornerRadius, r101.itemCornerRadius) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.itemThemeColor, r101.itemThemeColor) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Double r100 = this.itemCornerRadius;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.itemThemeColor;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "FavoriteItemStyle(itemCornerRadius=" + this.itemCornerRadius + ", itemThemeColor=" + this.itemThemeColor + ")";
        }

        public final Double getItemCornerRadius() {
            return this.itemCornerRadius;
        }

        public final String getItemThemeColor() {
            return this.itemThemeColor;
        }

        public final void setItemCornerRadius(Double r100) {
            this.itemCornerRadius = r100;
        }

        public final void setItemThemeColor(String r100) {
            this.itemThemeColor = r100;
        }

        public FavoriteItemStyle(Double r100, String r101) {
            this.itemCornerRadius = r100;
            this.itemThemeColor = r101;
        }

        public /* synthetic */ FavoriteItemStyle(Double r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "", "feedUIStyle", "", "feedCardScale", "", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "getFeedCardScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeedUIStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteLiveCardABValue {

        @SerializedName("feed_card_scale")
        private final Float feedCardScale;

        @SerializedName("feed_ui_style")
        private final Integer feedUIStyle;

        /* JADX WARN: Multi-variable type inference failed */
        public FavoriteLiveCardABValue() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FavoriteLiveCardABValue copy$default(FavoriteLiveCardABValue r100, Integer r101, Float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.feedUIStyle;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.feedCardScale;
        L9:
            return r100.copy(r101, r102);
        }

        public final Integer component1() {
            return this.feedUIStyle;
        }

        public final Float component2() {
            return this.feedCardScale;
        }

        public final FavoriteLiveCardABValue copy(Integer r100, Float r101) {
            return new FavoriteLiveCardABValue(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FavoriteLiveCardABValue) == false) goto L10;
            FavoriteLiveCardABValue r101 = (FavoriteLiveCardABValue) r100;
            if (Intrinsics.areEqual(this.feedUIStyle, r101.feedUIStyle) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.feedCardScale, r101.feedCardScale) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.feedUIStyle;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Float r104 = this.feedCardScale;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "FavoriteLiveCardABValue(feedUIStyle=" + this.feedUIStyle + ", feedCardScale=" + this.feedCardScale + ")";
        }

        public final Float getFeedCardScale() {
            return this.feedCardScale;
        }

        public final Integer getFeedUIStyle() {
            return this.feedUIStyle;
        }

        public FavoriteLiveCardABValue(Integer r100, Float r101) {
            this.feedUIStyle = r100;
            this.feedCardScale = r101;
        }

        public /* synthetic */ FavoriteLiveCardABValue(Integer r100, Float r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b#\n\u0002\u0010$\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0086\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000bHÖ\u0001J\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000104J\t\u00105\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "", "newPadding", "", "highValue", "uiCompact", "useSameHeight", "", "liveCardChangeCover", "liveCardEnlargePlayArea", "coinLabelStyle", "", "ttABParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "showPeopleNewIcon", "appendHeight", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Boolean;Ljava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHighValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLiveCardChangeCover", "getLiveCardEnlargePlayArea", "getNewPadding", "getShowPeopleNewIcon", "getTtABParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "getUiCompact", "getUseSameHeight", "()Ljava/lang/String;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Boolean;Ljava/lang/Double;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "equals", "other", "hashCode", "toMap", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteLiveCardABValues {

        @SerializedName("live_video_height_v2_append")
        private final Double appendHeight;

        @SerializedName("coin_label_style")
        private final Integer coinLabelStyle;

        @SerializedName("high_value")
        private final Boolean highValue;

        @SerializedName("live_card_change_cover")
        private final Boolean liveCardChangeCover;

        @SerializedName("live_card_enlarge_play_area")
        private final Boolean liveCardEnlargePlayArea;

        @SerializedName("new_padding")
        private final Boolean newPadding;

        @SerializedName("live_card_show_people_new_icon")
        private final Boolean showPeopleNewIcon;

        @SerializedName("toutiao_ab_param")
        private final TTFavoriteLiveCardABParam ttABParam;

        @SerializedName("is_ui_compact")
        private final Boolean uiCompact;

        @SerializedName("use_same_height")
        private final String useSameHeight;

        public FavoriteLiveCardABValues() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public static /* synthetic */ FavoriteLiveCardABValues copy$default(FavoriteLiveCardABValues r110, Boolean r111, Boolean r112, Boolean r113, String r114, Boolean r115, Boolean r116, Integer r117, TTFavoriteLiveCardABParam r118, Boolean r210, Double r211, int r212, Object r213) {
            if ((r212 & 1) == 0) goto L5;
            Boolean r100 = r110.newPadding;
        L7:
            if ((r212 & 2) == 0) goto L9;
            Boolean r101 = r110.highValue;
        L11:
            if ((r212 & 4) == 0) goto L13;
            Boolean r102 = r110.uiCompact;
        L15:
            if ((r212 & 8) == 0) goto L17;
            String r103 = r110.useSameHeight;
        L19:
            if ((r212 & 16) == 0) goto L21;
            Boolean r104 = r110.liveCardChangeCover;
        L23:
            if ((r212 & 32) == 0) goto L25;
            Boolean r105 = r110.liveCardEnlargePlayArea;
        L27:
            if ((r212 & 64) == 0) goto L29;
            Integer r106 = r110.coinLabelStyle;
        L31:
            if ((r212 & 128) == 0) goto L33;
            TTFavoriteLiveCardABParam r107 = r110.ttABParam;
        L35:
            if ((r212 & 256) == 0) goto L37;
            Boolean r119 = r110.showPeopleNewIcon;
        L39:
            if ((r212 & 512) == 0) goto L41;
            Double r108 = r110.appendHeight;
        L43:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
        L41:
            r108 = r211;
            goto L43
        L37:
            r119 = r210;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final Boolean component1() {
            return this.newPadding;
        }

        public final Double component10() {
            return this.appendHeight;
        }

        public final Boolean component2() {
            return this.highValue;
        }

        public final Boolean component3() {
            return this.uiCompact;
        }

        public final String component4() {
            return this.useSameHeight;
        }

        public final Boolean component5() {
            return this.liveCardChangeCover;
        }

        public final Boolean component6() {
            return this.liveCardEnlargePlayArea;
        }

        public final Integer component7() {
            return this.coinLabelStyle;
        }

        public final TTFavoriteLiveCardABParam component8() {
            return this.ttABParam;
        }

        public final Boolean component9() {
            return this.showPeopleNewIcon;
        }

        public final FavoriteLiveCardABValues copy(Boolean r110, Boolean r111, Boolean r112, String r113, Boolean r114, Boolean r115, Integer r116, TTFavoriteLiveCardABParam r210, Boolean r211, Double r212) {
            return new FavoriteLiveCardABValues(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FavoriteLiveCardABValues) == false) goto L26;
            FavoriteLiveCardABValues r101 = (FavoriteLiveCardABValues) r100;
            if (Intrinsics.areEqual(this.newPadding, r101.newPadding) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.highValue, r101.highValue) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.uiCompact, r101.uiCompact) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.useSameHeight, r101.useSameHeight) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.liveCardChangeCover, r101.liveCardChangeCover) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.liveCardEnlargePlayArea, r101.liveCardEnlargePlayArea) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.coinLabelStyle, r101.coinLabelStyle) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.ttABParam, r101.ttABParam) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.showPeopleNewIcon, r101.showPeopleNewIcon) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.appendHeight, r101.appendHeight) == true) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        public int hashCode() {
            Boolean r100 = this.newPadding;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.highValue;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.uiCompact;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.useSameHeight;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Boolean r113 = this.liveCardChangeCover;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Boolean r116 = this.liveCardEnlargePlayArea;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            Integer r119 = this.coinLabelStyle;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            TTFavoriteLiveCardABParam r122 = this.ttABParam;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            Boolean r125 = this.showPeopleNewIcon;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            Double r128 = this.appendHeight;
            if (r128 == null) goto L42;
            r101 = r128.hashCode();
        L42:
            return r127 + r101;
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final Map<String, Object> toMap() {
            Map r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("new_padding", this.newPadding), TuplesKt.to("high_value", this.highValue), TuplesKt.to("is_ui_compact", this.uiCompact), TuplesKt.to("use_same_height", this.useSameHeight)});
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L11;
            Map.Entry r103 = (Map.Entry) r102.next();
            if (r103.getValue() == null) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L4;
            r101.put(r103.getKey(), r103.getValue());
            goto L4
        L8:
            r104 = false;
            goto L9
        L11:
            return r101;
        }

        public String toString() {
            return "FavoriteLiveCardABValues(newPadding=" + this.newPadding + ", highValue=" + this.highValue + ", uiCompact=" + this.uiCompact + ", useSameHeight=" + this.useSameHeight + ", liveCardChangeCover=" + this.liveCardChangeCover + ", liveCardEnlargePlayArea=" + this.liveCardEnlargePlayArea + ", coinLabelStyle=" + this.coinLabelStyle + ", ttABParam=" + this.ttABParam + ", showPeopleNewIcon=" + this.showPeopleNewIcon + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final Boolean getHighValue() {
            return this.highValue;
        }

        public final Boolean getLiveCardChangeCover() {
            return this.liveCardChangeCover;
        }

        public final Boolean getLiveCardEnlargePlayArea() {
            return this.liveCardEnlargePlayArea;
        }

        public final Boolean getNewPadding() {
            return this.newPadding;
        }

        public final Boolean getShowPeopleNewIcon() {
            return this.showPeopleNewIcon;
        }

        public final TTFavoriteLiveCardABParam getTtABParam() {
            return this.ttABParam;
        }

        public final Boolean getUiCompact() {
            return this.uiCompact;
        }

        public final String getUseSameHeight() {
            return this.useSameHeight;
        }

        public FavoriteLiveCardABValues(Boolean r100, Boolean r101, Boolean r102, String r103, Boolean r104, Boolean r105, Integer r106, TTFavoriteLiveCardABParam r107, Boolean r108, Double r110) {
            this.newPadding = r100;
            this.highValue = r101;
            this.uiCompact = r102;
            this.useSameHeight = r103;
            this.liveCardChangeCover = r104;
            this.liveCardEnlargePlayArea = r105;
            this.coinLabelStyle = r106;
            this.ttABParam = r107;
            this.showPeopleNewIcon = r108;
            this.appendHeight = r110;
        }

        public /* synthetic */ FavoriteLiveCardABValues(Boolean r110, Boolean r111, Boolean r112, String r113, Boolean r114, Boolean r115, Integer r116, TTFavoriteLiveCardABParam r117, Boolean r210, Double r211, int r212, DefaultConstructorMarker r213) {
            if ((r212 & 1) == 0) goto L5;
            Boolean r100 = Boolean.FALSE;
        L7:
            if ((r212 & 2) == 0) goto L9;
            Boolean r101 = Boolean.FALSE;
        L11:
            if ((r212 & 4) == 0) goto L13;
            Boolean r102 = Boolean.FALSE;
        L14:
            Double r103 = null;
            if ((r212 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r212 & 16) == 0) goto L21;
            Boolean r105 = Boolean.FALSE;
        L23:
            if ((r212 & 32) == 0) goto L25;
            Boolean r106 = Boolean.FALSE;
        L27:
            if ((r212 & 64) == 0) goto L29;
            Integer r107 = null;
        L31:
            if ((r212 & 128) == 0) goto L33;
            TTFavoriteLiveCardABParam r108 = null;
        L35:
            if ((r212 & 256) == 0) goto L37;
            Boolean r118 = Boolean.FALSE;
        L39:
            if ((r212 & 512) != 0) goto L42;
            r103 = r211;
        L42:
            this(r100, r101, r102, r104, r105, r106, r107, r108, r118, r103);
            return;
        L37:
            r118 = r210;
            goto L39
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r102 = r112;
            goto L14
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001:\u0007klmnopqBÍ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010P\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0013\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0015HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u000eHÆ\u0003JÖ\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\u0007HÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0018\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010'R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b:\u00104R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b>\u00104R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\bC\u00104R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\bD\u00104R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010'R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010@R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010'R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\bH\u00104R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010'¨\u0006r"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "", "uid", "", "secUid", "roomId", "status", "", "number", "numberStr", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "title", "avatar", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "nickName", "productCount", "totalNumber", "followStatus", "streamData", "relationTags", "", "liveDescription", "platformTextActivity", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;", PromotionProductPrivilegesStruct.TAGS, "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag;", "isGuessInstant", "arriveTimePoint", "showProductImage", "feedLiveRecReasonType", "feedLiveRecReasonContent", "descText", "hotAtmosphere", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;", "decorationParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;)V", "getArriveTimePoint", "()Ljava/lang/String;", "getAvatar", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "getDecorationParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;", "setDecorationParam", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;)V", "getDescText", "getFeedLiveRecReasonContent", "getFeedLiveRecReasonType", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHotAtmosphere", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;", "getLiveDescription", "getNickName", "getNumber", "getNumberStr", "getPlatformTextActivity", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;", "getProductCount", "getRelationTags", "()Ljava/util/List;", "getRoomId", "getSecUid", "getShowProductImage", "getStatus", "getStreamData", "getTags", "getTitle", "getTotalNumber", "getUid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "equals", "", "other", "hashCode", "toString", "Avatar", "Cover", "DecorationParam", "HotAtmosphere", ComposerHelper.CONFIG_LINK, "PlatformTextActivity", "Tag", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Live {

        @SerializedName("arrive_time_point")
        private final String arriveTimePoint;

        @SerializedName("avatar")
        private final Avatar avatar;

        @SerializedName("cover")
        private final Cover cover;

        @SerializedName("decoration_param")
        private DecorationParam decorationParam;

        @SerializedName("desc_text")
        private final String descText;

        @SerializedName("feed_live_rec_reason_content")
        private final String feedLiveRecReasonContent;

        @SerializedName("feed_live_rec_reason_type")
        private final String feedLiveRecReasonType;

        @SerializedName("follow_status")
        private final Integer followStatus;

        @SerializedName("hot_atmosphere")
        private final HotAtmosphere hotAtmosphere;

        @SerializedName("is_guess_instant")
        private final String isGuessInstant;

        @SerializedName("live_description")
        private final String liveDescription;

        @SerializedName("nick_name")
        private final String nickName;

        @SerializedName("number")
        private final Integer number;

        @SerializedName("number_str")
        private final String numberStr;

        @SerializedName("platform_text_activity")
        private final PlatformTextActivity platformTextActivity;

        @SerializedName("product_count")
        private final Integer productCount;

        @SerializedName("relation_tags")
        private final List<String> relationTags;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("sec_uid")
        private final String secUid;

        @SerializedName("feed_live_cover_show_product_image")
        private final Integer showProductImage;

        @SerializedName("status")
        private final Integer status;

        @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
        private final String streamData;

        @SerializedName(PromotionProductPrivilegesStruct.TAGS)
        private final List<Tag> tags;

        @SerializedName("title")
        private final String title;

        @SerializedName("total_number")
        private final Integer totalNumber;

        @SerializedName("uid")
        private final String uid;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Avatar {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName(ScoreTags.STAR_URL_LIST)
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Avatar() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Avatar copy$default(Avatar r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.uri;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.urlList;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.width;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.height;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final Avatar copy(String r100, List<String> r101, Integer r102, Integer r103) {
                return new Avatar(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Avatar) == false) goto L14;
                Avatar r101 = (Avatar) r100;
                if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r100 = this.uri;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<String> r104 = this.urlList;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.width;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.height;
                if (r110 == null) goto L18;
                r101 = r110.hashCode();
            L18:
                return r109 + r101;
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "Avatar(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Avatar(String r100, List<String> r101, Integer r102, Integer r103) {
                this.uri = r100;
                this.urlList = r101;
                this.width = r102;
                this.height = r103;
            }

            public /* synthetic */ Avatar(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r102 = null;
            L12:
                if ((r104 & 8) == 0) goto L14;
                r103 = null;
            L14:
                this(r100, r101, r102, r103);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Cover {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName(ScoreTags.STAR_URL_LIST)
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Cover() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Cover copy$default(Cover r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.uri;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.urlList;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.width;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.height;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final Cover copy(String r100, List<String> r101, Integer r102, Integer r103) {
                return new Cover(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Cover) == false) goto L14;
                Cover r101 = (Cover) r100;
                if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r100 = this.uri;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<String> r104 = this.urlList;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.width;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.height;
                if (r110 == null) goto L18;
                r101 = r110.hashCode();
            L18:
                return r109 + r101;
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "Cover(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Cover(String r100, List<String> r101, Integer r102, Integer r103) {
                this.uri = r100;
                this.urlList = r101;
                this.width = r102;
                this.height = r103;
            }

            public /* synthetic */ Cover(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r102 = null;
            L12:
                if ((r104 & 8) == 0) goto L14;
                r103 = null;
            L14:
                this(r100, r101, r102, r103);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;", "", "animationUrl", "", "(Ljava/lang/String;)V", "getAnimationUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class DecorationParam {

            @SerializedName("animation_url")
            private final String animationUrl;

            /* JADX WARN: Multi-variable type inference failed */
            public DecorationParam() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ DecorationParam copy$default(DecorationParam r100, String r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.animationUrl;
            L6:
                return r100.copy(r101);
            }

            public final String component1() {
                return this.animationUrl;
            }

            public final DecorationParam copy(String r100) {
                return new DecorationParam(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof DecorationParam) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.animationUrl, ((DecorationParam) r100).animationUrl) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                String r100 = this.animationUrl;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public String toString() {
                return "DecorationParam(animationUrl=" + this.animationUrl + ")";
            }

            public final String getAnimationUrl() {
                return this.animationUrl;
            }

            public DecorationParam(String r100) {
                this.animationUrl = r100;
            }

            public /* synthetic */ DecorationParam(String r100, int r101, DefaultConstructorMarker r102) {
                if ((r101 & 1) == 0) goto L5;
                r100 = null;
            L5:
                this(r100);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;", "", "icon", "", "saleDesc", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getSaleDesc", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class HotAtmosphere {

            @SerializedName("icon")
            private final String icon;

            @SerializedName("sale_num")
            private final String saleDesc;

            /* JADX WARN: Multi-variable type inference failed */
            public HotAtmosphere() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ HotAtmosphere copy$default(HotAtmosphere r100, String r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.icon;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.saleDesc;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.icon;
            }

            public final String component2() {
                return this.saleDesc;
            }

            public final HotAtmosphere copy(String r100, String r101) {
                return new HotAtmosphere(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof HotAtmosphere) == false) goto L10;
                HotAtmosphere r101 = (HotAtmosphere) r100;
                if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.saleDesc, r101.saleDesc) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r100 = this.icon;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.saleDesc;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "HotAtmosphere(icon=" + this.icon + ", saleDesc=" + this.saleDesc + ")";
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getSaleDesc() {
                return this.saleDesc;
            }

            public HotAtmosphere(String r100, String r101) {
                this.icon = r100;
                this.saleDesc = r101;
            }

            public /* synthetic */ HotAtmosphere(String r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Link;", "", "live", "", "liveWithProduct", "(Ljava/lang/String;Ljava/lang/String;)V", "getLive", "()Ljava/lang/String;", "getLiveWithProduct", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Link {

            @SerializedName("live")
            private final String live;

            @SerializedName("live_with_product")
            private final String liveWithProduct;

            /* JADX WARN: Multi-variable type inference failed */
            public Link() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Link copy$default(Link r100, String r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.live;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.liveWithProduct;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.live;
            }

            public final String component2() {
                return this.liveWithProduct;
            }

            public final Link copy(String r100, String r101) {
                return new Link(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Link) == false) goto L10;
                Link r101 = (Link) r100;
                if (Intrinsics.areEqual(this.live, r101.live) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.liveWithProduct, r101.liveWithProduct) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r100 = this.live;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.liveWithProduct;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "Link(live=" + this.live + ", liveWithProduct=" + this.liveWithProduct + ")";
            }

            public final String getLive() {
                return this.live;
            }

            public final String getLiveWithProduct() {
                return this.liveWithProduct;
            }

            public Link(String r100, String r101) {
                this.live = r100;
                this.liveWithProduct = r101;
            }

            public /* synthetic */ Link(String r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;", "", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class PlatformTextActivity {
            public PlatformTextActivity() {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001 BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag;", "", "type", "", "content", "", "icon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "endTime", "leftSeconds", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "getEndTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "getLeftSeconds", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag;", "equals", "", "other", "hashCode", "toString", "Icon", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Tag {

            @SerializedName("content")
            private final String content;

            @SerializedName("end_time")
            private final Integer endTime;

            @SerializedName("icon")
            private final Icon icon;

            @SerializedName("left_seconds")
            private final Integer leftSeconds;

            @SerializedName("type")
            private final Integer type;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class Icon {

                @SerializedName("height")
                private final Integer height;

                @SerializedName("uri")
                private final String uri;

                @SerializedName(ScoreTags.STAR_URL_LIST)
                private final List<String> urlList;

                @SerializedName("width")
                private final Integer width;

                public Icon() {
                    this(null, null, null, null, 15, null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Icon copy$default(Icon r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
                    if ((r105 & 1) == 0) goto L6;
                    r101 = r100.uri;
                L6:
                    if ((r105 & 2) == 0) goto L9;
                    r102 = r100.urlList;
                L9:
                    if ((r105 & 4) == 0) goto L12;
                    r103 = r100.width;
                L12:
                    if ((r105 & 8) == 0) goto L15;
                    r104 = r100.height;
                L15:
                    return r100.copy(r101, r102, r103, r104);
                }

                public final String component1() {
                    return this.uri;
                }

                public final List<String> component2() {
                    return this.urlList;
                }

                public final Integer component3() {
                    return this.width;
                }

                public final Integer component4() {
                    return this.height;
                }

                public final Icon copy(String r100, List<String> r101, Integer r102, Integer r103) {
                    return new Icon(r100, r101, r102, r103);
                }

                public boolean equals(Object r100) {
                    if (this != r100) goto L4;
                    return true;
                L4:
                    if ((r100 instanceof Icon) == false) goto L14;
                    Icon r101 = (Icon) r100;
                    if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                    return false;
                L10:
                    if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
                    return false;
                L22:
                    return true;
                L14:
                    return false;
                }

                public int hashCode() {
                    String r100 = this.uri;
                    int r101 = 0;
                    if (r100 == null) goto L5;
                    int r102 = r100.hashCode();
                L6:
                    int r103 = r102 * 31;
                    List<String> r104 = this.urlList;
                    if (r104 == null) goto L9;
                    int r105 = r104.hashCode();
                L10:
                    int r106 = (r103 + r105) * 31;
                    Integer r107 = this.width;
                    if (r107 == null) goto L13;
                    int r108 = r107.hashCode();
                L14:
                    int r109 = (r106 + r108) * 31;
                    Integer r110 = this.height;
                    if (r110 == null) goto L18;
                    r101 = r110.hashCode();
                L18:
                    return r109 + r101;
                L13:
                    r108 = 0;
                    goto L14
                L9:
                    r105 = 0;
                    goto L10
                L5:
                    r102 = 0;
                    goto L6
                }

                public String toString() {
                    return "Icon(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
                }

                public final Integer getHeight() {
                    return this.height;
                }

                public final String getUri() {
                    return this.uri;
                }

                public final List<String> getUrlList() {
                    return this.urlList;
                }

                public final Integer getWidth() {
                    return this.width;
                }

                public Icon(String r100, List<String> r101, Integer r102, Integer r103) {
                    this.uri = r100;
                    this.urlList = r101;
                    this.width = r102;
                    this.height = r103;
                }

                public /* synthetic */ Icon(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
                    if ((r104 & 1) == 0) goto L6;
                    r100 = null;
                L6:
                    if ((r104 & 2) == 0) goto L9;
                    r101 = null;
                L9:
                    if ((r104 & 4) == 0) goto L12;
                    r102 = null;
                L12:
                    if ((r104 & 8) == 0) goto L14;
                    r103 = null;
                L14:
                    this(r100, r101, r102, r103);
                }
            }

            public Tag() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ Tag copy$default(Tag r100, Integer r101, String r102, Icon r103, Integer r104, Integer r105, int r106, Object r110) {
                if ((r106 & 1) == 0) goto L6;
                r101 = r100.type;
            L6:
                if ((r106 & 2) == 0) goto L8;
                r102 = r100.content;
            L8:
                String r111 = r102;
                if ((r106 & 4) == 0) goto L11;
                r103 = r100.icon;
            L11:
                Icon r107 = r103;
                if ((r106 & 8) == 0) goto L14;
                r104 = r100.endTime;
            L14:
                Integer r108 = r104;
                if ((r106 & 16) == 0) goto L17;
                r105 = r100.leftSeconds;
            L17:
                Integer r109 = r101;
                return r100.copy(r109, r111, r107, r108, r105);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.content;
            }

            public final Icon component3() {
                return this.icon;
            }

            public final Integer component4() {
                return this.endTime;
            }

            public final Integer component5() {
                return this.leftSeconds;
            }

            public final Tag copy(Integer r100, String r101, Icon r110, Integer r111, Integer r112) {
                return new Tag(r100, r101, r110, r111, r112);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Tag) == false) goto L16;
                Tag r101 = (Tag) r100;
                if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.leftSeconds, r101.leftSeconds) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                Integer r100 = this.type;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.content;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Icon r107 = this.icon;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.endTime;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                Integer r113 = this.leftSeconds;
                if (r113 == null) goto L22;
                r101 = r113.hashCode();
            L22:
                return r112 + r101;
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "Tag(type=" + this.type + ", content=" + this.content + ", icon=" + this.icon + ", endTime=" + this.endTime + ", leftSeconds=" + this.leftSeconds + ")";
            }

            public final String getContent() {
                return this.content;
            }

            public final Integer getEndTime() {
                return this.endTime;
            }

            public final Icon getIcon() {
                return this.icon;
            }

            public final Integer getLeftSeconds() {
                return this.leftSeconds;
            }

            public final Integer getType() {
                return this.type;
            }

            public Tag(Integer r100, String r101, Icon r102, Integer r103, Integer r104) {
                this.type = r100;
                this.content = r101;
                this.icon = r102;
                this.endTime = r103;
                this.leftSeconds = r104;
            }

            public /* synthetic */ Tag(Integer r100, String r101, Icon r102, Integer r103, Integer r104, int r110, DefaultConstructorMarker r111) {
                if ((r110 & 1) == 0) goto L5;
                Integer r112 = null;
            L7:
                if ((r110 & 2) == 0) goto L9;
                String r105 = null;
            L11:
                if ((r110 & 4) == 0) goto L13;
                Icon r106 = null;
            L15:
                if ((r110 & 8) == 0) goto L17;
                Integer r107 = null;
            L19:
                if ((r110 & 16) == 0) goto L21;
                Integer r113 = null;
            L22:
                this(r112, r105, r106, r107, r113);
                return;
            L21:
                r113 = r104;
                goto L22
            L17:
                r107 = r103;
                goto L19
            L13:
                r106 = r102;
                goto L15
            L9:
                r105 = r101;
                goto L11
            L5:
                r112 = r100;
                goto L7
            }
        }

        public Live() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RectListKt.Lower26Bits, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Live copy$default(Live r110, String r111, String r112, String r210, Integer r211, Integer r212, String r213, Cover r214, String r215, Avatar r216, String r217, Integer r218, Integer r219, Integer r310, String r311, List r312, String r313, PlatformTextActivity r314, List r315, String r316, String r317, Integer r318, String r319, String r410, String r411, HotAtmosphere r412, DecorationParam r413, int r414, Object r415) {
            if ((r414 & 1) == 0) goto L5;
            String r100 = r110.uid;
        L7:
            if ((r414 & 2) == 0) goto L9;
            String r101 = r110.secUid;
        L11:
            if ((r414 & 4) == 0) goto L13;
            String r102 = r110.roomId;
        L15:
            if ((r414 & 8) == 0) goto L17;
            Integer r103 = r110.status;
        L19:
            if ((r414 & 16) == 0) goto L21;
            Integer r104 = r110.number;
        L23:
            if ((r414 & 32) == 0) goto L25;
            String r105 = r110.numberStr;
        L27:
            if ((r414 & 64) == 0) goto L29;
            Cover r106 = r110.cover;
        L31:
            if ((r414 & 128) == 0) goto L33;
            String r107 = r110.title;
        L35:
            if ((r414 & 256) == 0) goto L37;
            Avatar r113 = r110.avatar;
        L39:
            if ((r414 & 512) == 0) goto L41;
            String r114 = r110.nickName;
        L43:
            if ((r414 & 1024) == 0) goto L45;
            Integer r115 = r110.productCount;
        L47:
            if ((r414 & 2048) == 0) goto L49;
            Integer r116 = r110.totalNumber;
        L51:
            if ((r414 & 4096) == 0) goto L53;
            Integer r117 = r110.followStatus;
        L55:
            if ((r414 & 8192) == 0) goto L57;
            String r118 = r110.streamData;
        L58:
            String r320 = r118;
            if ((r414 & 16384) == 0) goto L61;
            List r119 = r110.relationTags;
        L62:
            List r321 = r119;
            if ((r414 & 32768) == 0) goto L65;
            String r120 = r110.liveDescription;
        L66:
            String r322 = r120;
            if ((r414 & 65536) == 0) goto L69;
            PlatformTextActivity r121 = r110.platformTextActivity;
        L70:
            PlatformTextActivity r323 = r121;
            if ((r414 & 131072) == 0) goto L73;
            List r122 = r110.tags;
        L74:
            List r324 = r122;
            if ((r414 & 262144) == 0) goto L77;
            String r123 = r110.isGuessInstant;
        L78:
            String r325 = r123;
            if ((r414 & 524288) == 0) goto L81;
            String r124 = r110.arriveTimePoint;
        L82:
            String r326 = r124;
            if ((r414 & 1048576) == 0) goto L85;
            Integer r125 = r110.showProductImage;
        L86:
            Integer r327 = r125;
            if ((r414 & 2097152) == 0) goto L89;
            String r126 = r110.feedLiveRecReasonType;
        L90:
            String r328 = r126;
            if ((r414 & 4194304) == 0) goto L93;
            String r127 = r110.feedLiveRecReasonContent;
        L94:
            String r416 = r127;
            if ((r414 & 8388608) == 0) goto L97;
            String r128 = r110.descText;
        L98:
            String r417 = r128;
            if ((r414 & 16777216) == 0) goto L101;
            HotAtmosphere r129 = r110.hotAtmosphere;
        L103:
            if ((r414 & 33554432) == 0) goto L105;
            DecorationParam r108 = r110.decorationParam;
        L107:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r416, r417, r129, r108);
        L105:
            r108 = r413;
            goto L107
        L101:
            r129 = r412;
            goto L103
        L97:
            r128 = r411;
            goto L98
        L93:
            r127 = r410;
            goto L94
        L89:
            r126 = r319;
            goto L90
        L85:
            r125 = r318;
            goto L86
        L81:
            r124 = r317;
            goto L82
        L77:
            r123 = r316;
            goto L78
        L73:
            r122 = r315;
            goto L74
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.uid;
        }

        public final String component10() {
            return this.nickName;
        }

        public final Integer component11() {
            return this.productCount;
        }

        public final Integer component12() {
            return this.totalNumber;
        }

        public final Integer component13() {
            return this.followStatus;
        }

        public final String component14() {
            return this.streamData;
        }

        public final List<String> component15() {
            return this.relationTags;
        }

        public final String component16() {
            return this.liveDescription;
        }

        public final PlatformTextActivity component17() {
            return this.platformTextActivity;
        }

        public final List<Tag> component18() {
            return this.tags;
        }

        public final String component19() {
            return this.isGuessInstant;
        }

        public final String component2() {
            return this.secUid;
        }

        public final String component20() {
            return this.arriveTimePoint;
        }

        public final Integer component21() {
            return this.showProductImage;
        }

        public final String component22() {
            return this.feedLiveRecReasonType;
        }

        public final String component23() {
            return this.feedLiveRecReasonContent;
        }

        public final String component24() {
            return this.descText;
        }

        public final HotAtmosphere component25() {
            return this.hotAtmosphere;
        }

        public final DecorationParam component26() {
            return this.decorationParam;
        }

        public final String component3() {
            return this.roomId;
        }

        public final Integer component4() {
            return this.status;
        }

        public final Integer component5() {
            return this.number;
        }

        public final String component6() {
            return this.numberStr;
        }

        public final Cover component7() {
            return this.cover;
        }

        public final String component8() {
            return this.title;
        }

        public final Avatar component9() {
            return this.avatar;
        }

        public final Live copy(String r210, String r310, String r311, Integer r312, Integer r313, String r314, Cover r315, String r316, Avatar r317, String r318, Integer r319, Integer r410, Integer r411, String r412, List<String> r413, String r414, PlatformTextActivity r415, List<Tag> r416, String r417, String r418, Integer r419, String r510, String r511, String r512, HotAtmosphere r513, DecorationParam r514) {
            return new Live(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Live) == false) goto L58;
            Live r101 = (Live) r100;
            if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.status, r101.status) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.number, r101.number) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.numberStr, r101.numberStr) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.productCount, r101.productCount) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.totalNumber, r101.totalNumber) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.streamData, r101.streamData) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.relationTags, r101.relationTags) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.liveDescription, r101.liveDescription) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.platformTextActivity, r101.platformTextActivity) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.isGuessInstant, r101.isGuessInstant) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.arriveTimePoint, r101.arriveTimePoint) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.showProductImage, r101.showProductImage) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.feedLiveRecReasonType, r101.feedLiveRecReasonType) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.feedLiveRecReasonContent, r101.feedLiveRecReasonContent) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.descText, r101.descText) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.hotAtmosphere, r101.hotAtmosphere) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.decorationParam, r101.decorationParam) == true) goto L88;
            return false;
        L88:
            return true;
        L58:
            return false;
        }

        public int hashCode() {
            String r100 = this.uid;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.secUid;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.roomId;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.status;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.number;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.numberStr;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            Cover r119 = this.cover;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.title;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            Avatar r125 = this.avatar;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.nickName;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            Integer r131 = this.productCount;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            Integer r134 = this.totalNumber;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            Integer r137 = this.followStatus;
            if (r137 == null) goto L53;
            int r138 = r137.hashCode();
        L54:
            int r139 = (r136 + r138) * 31;
            String r140 = this.streamData;
            if (r140 == null) goto L57;
            int r141 = r140.hashCode();
        L58:
            int r142 = (r139 + r141) * 31;
            List<String> r143 = this.relationTags;
            if (r143 == null) goto L61;
            int r144 = r143.hashCode();
        L62:
            int r145 = (r142 + r144) * 31;
            String r146 = this.liveDescription;
            if (r146 == null) goto L65;
            int r147 = r146.hashCode();
        L66:
            int r148 = (r145 + r147) * 31;
            PlatformTextActivity r149 = this.platformTextActivity;
            if (r149 == null) goto L69;
            int r150 = r149.hashCode();
        L70:
            int r151 = (r148 + r150) * 31;
            List<Tag> r152 = this.tags;
            if (r152 == null) goto L73;
            int r153 = r152.hashCode();
        L74:
            int r154 = (r151 + r153) * 31;
            String r155 = this.isGuessInstant;
            if (r155 == null) goto L77;
            int r156 = r155.hashCode();
        L78:
            int r157 = (r154 + r156) * 31;
            String r158 = this.arriveTimePoint;
            if (r158 == null) goto L81;
            int r159 = r158.hashCode();
        L82:
            int r160 = (r157 + r159) * 31;
            Integer r161 = this.showProductImage;
            if (r161 == null) goto L85;
            int r162 = r161.hashCode();
        L86:
            int r163 = (r160 + r162) * 31;
            String r164 = this.feedLiveRecReasonType;
            if (r164 == null) goto L89;
            int r165 = r164.hashCode();
        L90:
            int r166 = (r163 + r165) * 31;
            String r167 = this.feedLiveRecReasonContent;
            if (r167 == null) goto L93;
            int r168 = r167.hashCode();
        L94:
            int r169 = (r166 + r168) * 31;
            String r170 = this.descText;
            if (r170 == null) goto L97;
            int r171 = r170.hashCode();
        L98:
            int r172 = (r169 + r171) * 31;
            HotAtmosphere r173 = this.hotAtmosphere;
            if (r173 == null) goto L101;
            int r174 = r173.hashCode();
        L102:
            int r175 = (r172 + r174) * 31;
            DecorationParam r176 = this.decorationParam;
            if (r176 == null) goto L106;
            r101 = r176.hashCode();
        L106:
            return r175 + r101;
        L101:
            r174 = 0;
            goto L102
        L97:
            r171 = 0;
            goto L98
        L93:
            r168 = 0;
            goto L94
        L89:
            r165 = 0;
            goto L90
        L85:
            r162 = 0;
            goto L86
        L81:
            r159 = 0;
            goto L82
        L77:
            r156 = 0;
            goto L78
        L73:
            r153 = 0;
            goto L74
        L69:
            r150 = 0;
            goto L70
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Live(uid=" + this.uid + ", secUid=" + this.secUid + ", roomId=" + this.roomId + ", status=" + this.status + ", number=" + this.number + ", numberStr=" + this.numberStr + ", cover=" + this.cover + ", title=" + this.title + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ", productCount=" + this.productCount + ", totalNumber=" + this.totalNumber + ", followStatus=" + this.followStatus + ", streamData=" + this.streamData + ", relationTags=" + this.relationTags + ", liveDescription=" + this.liveDescription + ", platformTextActivity=" + this.platformTextActivity + ", tags=" + this.tags + ", isGuessInstant=" + this.isGuessInstant + ", arriveTimePoint=" + this.arriveTimePoint + ", showProductImage=" + this.showProductImage + ", feedLiveRecReasonType=" + this.feedLiveRecReasonType + ", feedLiveRecReasonContent=" + this.feedLiveRecReasonContent + ", descText=" + this.descText + ", hotAtmosphere=" + this.hotAtmosphere + ", decorationParam=" + this.decorationParam + ")";
        }

        public final String getArriveTimePoint() {
            return this.arriveTimePoint;
        }

        public final Avatar getAvatar() {
            return this.avatar;
        }

        public final Cover getCover() {
            return this.cover;
        }

        public final DecorationParam getDecorationParam() {
            return this.decorationParam;
        }

        public final String getDescText() {
            return this.descText;
        }

        public final String getFeedLiveRecReasonContent() {
            return this.feedLiveRecReasonContent;
        }

        public final String getFeedLiveRecReasonType() {
            return this.feedLiveRecReasonType;
        }

        public final Integer getFollowStatus() {
            return this.followStatus;
        }

        public final HotAtmosphere getHotAtmosphere() {
            return this.hotAtmosphere;
        }

        public final String getLiveDescription() {
            return this.liveDescription;
        }

        public final String getNickName() {
            return this.nickName;
        }

        public final Integer getNumber() {
            return this.number;
        }

        public final String getNumberStr() {
            return this.numberStr;
        }

        public final PlatformTextActivity getPlatformTextActivity() {
            return this.platformTextActivity;
        }

        public final Integer getProductCount() {
            return this.productCount;
        }

        public final List<String> getRelationTags() {
            return this.relationTags;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final String getSecUid() {
            return this.secUid;
        }

        public final Integer getShowProductImage() {
            return this.showProductImage;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final String getStreamData() {
            return this.streamData;
        }

        public final List<Tag> getTags() {
            return this.tags;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getTotalNumber() {
            return this.totalNumber;
        }

        public final String getUid() {
            return this.uid;
        }

        public final String isGuessInstant() {
            return this.isGuessInstant;
        }

        public final void setDecorationParam(DecorationParam r100) {
            this.decorationParam = r100;
        }

        public Live(String r100, String r101, String r102, Integer r103, Integer r104, String r105, Cover r106, String r110, Avatar r111, String r112, Integer r113, Integer r114, Integer r115, String r116, List<String> r117, String r118, PlatformTextActivity r119, List<Tag> r210, String r211, String r212, Integer r213, String r214, String r215, String r216, HotAtmosphere r217, DecorationParam r218) {
            this.uid = r100;
            this.secUid = r101;
            this.roomId = r102;
            this.status = r103;
            this.number = r104;
            this.numberStr = r105;
            this.cover = r106;
            this.title = r110;
            this.avatar = r111;
            this.nickName = r112;
            this.productCount = r113;
            this.totalNumber = r114;
            this.followStatus = r115;
            this.streamData = r116;
            this.relationTags = r117;
            this.liveDescription = r118;
            this.platformTextActivity = r119;
            this.tags = r210;
            this.isGuessInstant = r211;
            this.arriveTimePoint = r212;
            this.showProductImage = r213;
            this.feedLiveRecReasonType = r214;
            this.feedLiveRecReasonContent = r215;
            this.descText = r216;
            this.hotAtmosphere = r217;
            this.decorationParam = r218;
        }

        public /* synthetic */ Live(String r210, String r211, String r310, Integer r311, Integer r312, String r313, Cover r314, String r315, Avatar r316, String r317, Integer r318, Integer r319, Integer r410, String r411, List r412, String r413, PlatformTextActivity r414, List r415, String r416, String r417, Integer r418, String r419, String r510, String r511, HotAtmosphere r512, DecorationParam r513, int r514, DefaultConstructorMarker r515) {
            if ((r514 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r514 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r514 & 4) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r514 & 8) == 0) goto L17;
            Integer r103 = null;
        L19:
            if ((r514 & 16) == 0) goto L21;
            Integer r104 = null;
        L23:
            if ((r514 & 32) == 0) goto L25;
            String r105 = null;
        L27:
            if ((r514 & 64) == 0) goto L29;
            Cover r106 = null;
        L31:
            if ((r514 & 128) == 0) goto L33;
            String r107 = null;
        L35:
            if ((r514 & 256) == 0) goto L37;
            Avatar r110 = null;
        L39:
            if ((r514 & 512) == 0) goto L41;
            String r111 = null;
        L43:
            if ((r514 & 1024) == 0) goto L45;
            Integer r112 = null;
        L47:
            if ((r514 & 2048) == 0) goto L49;
            Integer r113 = null;
        L51:
            if ((r514 & 4096) == 0) goto L53;
            Integer r114 = null;
        L55:
            if ((r514 & 8192) == 0) goto L57;
            String r115 = null;
        L59:
            if ((r514 & 16384) == 0) goto L61;
            List r108 = null;
        L63:
            if ((r514 & 32768) == 0) goto L65;
            String r116 = null;
        L67:
            if ((r514 & 65536) == 0) goto L69;
            PlatformTextActivity r117 = null;
        L71:
            if ((r514 & 131072) == 0) goto L73;
            List r118 = null;
        L75:
            if ((r514 & 262144) == 0) goto L77;
            String r119 = null;
        L79:
            if ((r514 & 524288) == 0) goto L81;
            String r212 = null;
        L83:
            if ((r514 & 1048576) == 0) goto L85;
            Integer r213 = null;
        L87:
            if ((r514 & 2097152) == 0) goto L89;
            String r214 = null;
        L91:
            if ((r514 & 4194304) == 0) goto L93;
            String r215 = null;
        L95:
            if ((r514 & 8388608) == 0) goto L97;
            String r216 = null;
        L99:
            if ((r514 & 16777216) == 0) goto L101;
            HotAtmosphere r217 = null;
        L103:
            if ((r514 & 33554432) == 0) goto L105;
            DecorationParam r109 = null;
        L106:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r109);
            return;
        L105:
            r109 = r513;
            goto L106
        L101:
            r217 = r512;
            goto L103
        L97:
            r216 = r511;
            goto L99
        L93:
            r215 = r510;
            goto L95
        L89:
            r214 = r419;
            goto L91
        L85:
            r213 = r418;
            goto L87
        L81:
            r212 = r417;
            goto L83
        L77:
            r119 = r416;
            goto L79
        L73:
            r118 = r415;
            goto L75
        L69:
            r117 = r414;
            goto L71
        L65:
            r116 = r413;
            goto L67
        L61:
            r108 = r412;
            goto L63
        L57:
            r115 = r411;
            goto L59
        L53:
            r114 = r410;
            goto L55
        L49:
            r113 = r319;
            goto L51
        L45:
            r112 = r318;
            goto L47
        L41:
            r111 = r317;
            goto L43
        L37:
            r110 = r316;
            goto L39
        L33:
            r107 = r315;
            goto L35
        L29:
            r106 = r314;
            goto L31
        L25:
            r105 = r313;
            goto L27
        L21:
            r104 = r312;
            goto L23
        L17:
            r103 = r311;
            goto L19
        L13:
            r102 = r310;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "", "optGroup", "", "taskExpGroup", "(Ljava/lang/String;Ljava/lang/String;)V", "getOptGroup", "()Ljava/lang/String;", "getTaskExpGroup", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTFavoriteLiveCardABParam {

        @SerializedName("live_card_opt_group")
        private final String optGroup;

        @SerializedName("task_tab_show_exp_group")
        private final String taskExpGroup;

        /* JADX WARN: Multi-variable type inference failed */
        public TTFavoriteLiveCardABParam() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TTFavoriteLiveCardABParam copy$default(TTFavoriteLiveCardABParam r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.optGroup;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.taskExpGroup;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.optGroup;
        }

        public final String component2() {
            return this.taskExpGroup;
        }

        public final TTFavoriteLiveCardABParam copy(String r100, String r101) {
            return new TTFavoriteLiveCardABParam(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof TTFavoriteLiveCardABParam) == false) goto L10;
            TTFavoriteLiveCardABParam r101 = (TTFavoriteLiveCardABParam) r100;
            if (Intrinsics.areEqual(this.optGroup, r101.optGroup) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.taskExpGroup, r101.taskExpGroup) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.optGroup;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.taskExpGroup;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "TTFavoriteLiveCardABParam(optGroup=" + this.optGroup + ", taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getOptGroup() {
            return this.optGroup;
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public TTFavoriteLiveCardABParam(String r100, String r101) {
            this.optGroup = r100;
            this.taskExpGroup = r101;
        }

        public /* synthetic */ TTFavoriteLiveCardABParam(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public LiveCardData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435455, null);
    }

    public final Object carryRCInfoWindVaneParams() {
        String r100 = this.windVaneHaveRcInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CommonData.Extra r101 = this.extra;
        if (r101 == null) goto L12;
        String r102 = r101.getRecommendInfo();
        if (r102 == null) goto L12;
        String r103 = ToolsKt.H(String.valueOf(this.windVaneParams), r102);
        this.windVaneHaveRcInfo = r103;
        return r103;
    L12:
        return String.valueOf(this.windVaneParams);
    }

    public final String rcPriorityFromProduct() {
        CommonData.Product r100 = this.product;
        if (r100 == null) goto L12;
        String r101 = r100.getRecommendInfo();
        if (r101 == null) goto L12;
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return r101;
    L9:
        r102 = false;
    L12:
        CommonData.Extra r103 = this.extra;
        if (r103 == null) goto L17;
        String r104 = r103.getRecommendInfo();
        if (r104 == null) goto L19;
        return r104;
    L19:
        return null;
    L17:
        return null;
    }

    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final String getBtmCD() {
        return this.btmCD;
    }

    public final CommonData.CardCommon getCardCommon() {
        return this.cardCommon;
    }

    public final Boolean getCardMute() {
        return this.cardMute;
    }

    public final CommonData.CoinData getCoinData() {
        return this.coinData;
    }

    public final String getDescIcon() {
        return this.descIcon;
    }

    public final Boolean getDisableVane() {
        return this.disableVane;
    }

    public final CommonData.ElementStyle getElementStyle() {
        return this.elementStyle;
    }

    public final CommonData.Extra getExtra() {
        return this.extra;
    }

    public final FavoriteLiveCardABValue getFavoriteLiveCardABValue() {
        return this.favoriteLiveCardABValue;
    }

    public final FavoriteLiveCardABValues getFavoriteLiveCardABValues() {
        return this.favoriteLiveCardABValues;
    }

    public final CommonData.Impression getImpression() {
        return this.impression;
    }

    public final FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final Live getLive() {
        return this.live;
    }

    public final CommonData.MarketingData getMarketIngData() {
        return this.marketIngData;
    }

    public final Boolean getNeedAnimation() {
        return this.needAnimation;
    }

    public final Boolean getNeedShowAdTagUI() {
        return this.needShowAdTagUI;
    }

    public final String getPlayIcon() {
        return this.playIcon;
    }

    public final CommonData.Product getProduct() {
        return this.product;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Boolean getShowJustNowUI() {
        return this.showJustNowUI;
    }

    public final CommonData.Store getStore() {
        return this.store;
    }

    public final Integer getType() {
        return this.type;
    }

    public final CommonData.User getUser() {
        return this.user;
    }

    public final CommonData.WindVaneEventData getWindVaneData() {
        return this.windVaneData;
    }

    public final Object getWindVaneParams() {
        return this.windVaneParams;
    }

    public final Boolean isAd() {
        return this.isAd;
    }

    public final String isInstantRecCard() {
        return this.isInstantRecCard;
    }

    public final void setNeedAnimation(Boolean r100) {
        this.needAnimation = r100;
    }

    public LiveCardData(Integer r100, Live r101, CommonData.Product r102, CommonData.User r103, CommonData.Store r104, CommonData.Impression r105, CommonData.CardCommon r106, CommonData.Extra r110, String r111, CommonData.MarketingData r112, CommonData.CoinData r113, Boolean r114, FavoriteLiveCardABValue r115, FavoriteLiveCardABValues r116, Boolean r117, FavoriteItemStyle r118, String r119, Boolean r210, CommonData.WindVaneEventData r211, Object r212, String r213, Boolean r214, Boolean r215, CommonData.ElementStyle r216, String r217, String r218, String r219, Boolean r310) {
        this.type = r100;
        this.live = r101;
        this.product = r102;
        this.user = r103;
        this.store = r104;
        this.impression = r105;
        this.cardCommon = r106;
        this.extra = r110;
        this.schema = r111;
        this.marketIngData = r112;
        this.coinData = r113;
        this.isAd = r114;
        this.favoriteLiveCardABValue = r115;
        this.favoriteLiveCardABValues = r116;
        this.needShowAdTagUI = r117;
        this.itemStyle = r118;
        this.playIcon = r119;
        this.showJustNowUI = r210;
        this.windVaneData = r211;
        this.windVaneParams = r212;
        this.isInstantRecCard = r213;
        this.disableVane = r214;
        this.needAnimation = r215;
        this.elementStyle = r216;
        this.btmCD = r217;
        this.descIcon = r218;
        this.accessibilityLabel = r219;
        this.cardMute = r310;
    }

    public /* synthetic */ LiveCardData(Integer r310, Live r311, CommonData.Product r312, CommonData.User r313, CommonData.Store r314, CommonData.Impression r315, CommonData.CardCommon r316, CommonData.Extra r317, String r318, CommonData.MarketingData r319, CommonData.CoinData r410, Boolean r411, FavoriteLiveCardABValue r412, FavoriteLiveCardABValues r413, Boolean r414, FavoriteItemStyle r415, String r416, Boolean r417, CommonData.WindVaneEventData r418, Object r419, String r510, Boolean r511, Boolean r512, CommonData.ElementStyle r513, String r514, String r515, String r516, Boolean r517, int r518, DefaultConstructorMarker r519) {
        if ((r518 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r518 & 2) == 0) goto L9;
        Live r101 = null;
    L11:
        if ((r518 & 4) == 0) goto L13;
        CommonData.Product r102 = null;
    L15:
        if ((r518 & 8) == 0) goto L17;
        CommonData.User r103 = null;
    L19:
        if ((r518 & 16) == 0) goto L21;
        CommonData.Store r104 = null;
    L23:
        if ((r518 & 32) == 0) goto L25;
        CommonData.Impression r105 = null;
    L27:
        if ((r518 & 64) == 0) goto L29;
        CommonData.CardCommon r106 = null;
    L31:
        if ((r518 & 128) == 0) goto L33;
        CommonData.Extra r107 = null;
    L35:
        if ((r518 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r518 & 512) == 0) goto L41;
        CommonData.MarketingData r111 = null;
    L43:
        if ((r518 & 1024) == 0) goto L45;
        CommonData.CoinData r112 = null;
    L47:
        if ((r518 & 2048) == 0) goto L49;
        Boolean r113 = null;
    L51:
        if ((r518 & 4096) == 0) goto L53;
        FavoriteLiveCardABValue r114 = null;
    L55:
        if ((r518 & 8192) == 0) goto L57;
        FavoriteLiveCardABValues r115 = null;
    L59:
        if ((r518 & 16384) == 0) goto L61;
        Boolean r108 = null;
    L63:
        if ((r518 & 32768) == 0) goto L65;
        FavoriteItemStyle r116 = null;
    L67:
        if ((r518 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r518 & 131072) == 0) goto L73;
        Boolean r118 = null;
    L75:
        if ((r518 & 262144) == 0) goto L77;
        CommonData.WindVaneEventData r119 = null;
    L79:
        if ((r518 & 524288) == 0) goto L81;
        Object r210 = null;
    L83:
        if ((r518 & 1048576) == 0) goto L85;
        String r211 = null;
    L87:
        if ((r518 & 2097152) == 0) goto L89;
        Boolean r212 = null;
    L91:
        if ((r518 & 4194304) == 0) goto L93;
        Boolean r213 = null;
    L95:
        if ((r518 & 8388608) == 0) goto L97;
        CommonData.ElementStyle r214 = null;
    L99:
        if ((r518 & 16777216) == 0) goto L101;
        String r215 = null;
    L103:
        if ((r518 & 33554432) == 0) goto L105;
        String r216 = null;
    L107:
        if ((r518 & 67108864) == 0) goto L109;
        String r217 = null;
    L111:
        if ((r518 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Boolean r109 = null;
    L114:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r109);
        return;
    L113:
        r109 = r517;
        goto L114
    L109:
        r217 = r516;
        goto L111
    L105:
        r216 = r515;
        goto L107
    L101:
        r215 = r514;
        goto L103
    L97:
        r214 = r513;
        goto L99
    L93:
        r213 = r512;
        goto L95
    L89:
        r212 = r511;
        goto L91
    L85:
        r211 = r510;
        goto L87
    L81:
        r210 = r419;
        goto L83
    L77:
        r119 = r418;
        goto L79
    L73:
        r118 = r417;
        goto L75
    L69:
        r117 = r416;
        goto L71
    L65:
        r116 = r415;
        goto L67
    L61:
        r108 = r414;
        goto L63
    L57:
        r115 = r413;
        goto L59
    L53:
        r114 = r412;
        goto L55
    L49:
        r113 = r411;
        goto L51
    L45:
        r112 = r410;
        goto L47
    L41:
        r111 = r319;
        goto L43
    L37:
        r110 = r318;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
