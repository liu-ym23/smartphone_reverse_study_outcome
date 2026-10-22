package com.bytedance.android.shopping.api.mall.common.homepage.card.video;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECParamsFromClientDTO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import com.tencent.open.SocialConstants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\b\u0007\u0018\u0000 S2\u00020\u0001:\u0006STUVWXBõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010'J\b\u0010Q\u001a\u0004\u0018\u00010\u0001J\b\u0010R\u001a\u0004\u0018\u00010\u0013R\u0018\u0010%\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010&\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006Y"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData;", "", "type", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "video", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "liveHeader", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "impression", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "cardCommon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "schema", "", "marketingData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "favoriteVideoCardABValue", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "favoriteVideoCardABValues", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "showJustNowUI", "", "windVaneData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneParams", "elementStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "accessibilityLabel", "btmCD", "(Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Ljava/lang/Object;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;Ljava/lang/String;Ljava/lang/String;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getBtmCD", "getCardCommon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getElementStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "getFavoriteVideoCardABValue", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "getFavoriteVideoCardABValues", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "getImpression", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "getLiveHeader", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "getMarketingData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "getSchema", "getShowJustNowUI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "getVideo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "getWindVaneData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneHaveRcInfo", "getWindVaneParams", "()Ljava/lang/Object;", "carryRCInfoWindVaneParams", "rcPriorityFromProduct", "Companion", "FavoriteItemStyle", "FavoriteVideoCardABValue", "FavoriteVideoCardABValues", "TTFavoriteVideoCardABParam", "Video", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCardData {
    public static final Companion Companion = null;
    private static final String RECOMMEND_INFO = "recommend_info";

    @SerializedName("accessibility_label")
    private final String accessibilityLabel;

    @SerializedName("btm_cd")
    private final String btmCD;

    @SerializedName("card_common")
    private final CommonData.CardCommon cardCommon;

    @SerializedName("gold_coin_info")
    private final CommonData.CoinData coinData;

    @SerializedName("element_style")
    private final CommonData.ElementStyle elementStyle;

    @SerializedName("extra")
    private final CommonData.Extra extra;

    @SerializedName("ab_value")
    private final FavoriteVideoCardABValue favoriteVideoCardABValue;

    @SerializedName("ab_values")
    private final FavoriteVideoCardABValues favoriteVideoCardABValues;

    @SerializedName("impression")
    private final CommonData.Impression impression;

    @SerializedName("item_style")
    private final FavoriteItemStyle itemStyle;

    @SerializedName("live_header")
    private final Companion.LiveHeader liveHeader;

    @SerializedName("marketing_data")
    private final CommonData.MarketingData marketingData;

    @SerializedName("product")
    private final CommonData.Product product;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("show_just_now_ui")
    private final Boolean showJustNowUI;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final CommonData.User user;

    @SerializedName("video")
    private final Video video;

    @SerializedName("wind_vane_data")
    private final CommonData.WindVaneEventData windVaneData;
    private String windVaneHaveRcInfo;

    @SerializedName("wind_vane_params")
    private final Object windVaneParams;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0099\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "", "roomID", "", "secUid", "avatar", "nickName", "liveDesc", "liveIcon", "enterLiveIcon", "schema", "event", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;", "btmCD", "bcmData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;Ljava/lang/String;Ljava/util/Map;)V", "getAvatar", "()Ljava/lang/String;", "getBcmData", "()Ljava/util/Map;", "getBtmCD", "getEnterLiveIcon", "getEvent", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;", "getLiveDesc", "getLiveIcon", "getNickName", "getRoomID", "getSchema", "getSecUid", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeader {

            @SerializedName("avatar")
            private final String avatar;

            @SerializedName("bcm_data")
            private final Map<String, String> bcmData;

            @SerializedName("btm_cd")
            private final String btmCD;

            @SerializedName("enter_live_icon")
            private final String enterLiveIcon;

            @SerializedName("event")
            private final LiveHeaderEvent event;

            @SerializedName("live_description")
            private final String liveDesc;

            @SerializedName("live_icon")
            private final String liveIcon;

            @SerializedName("nick_name")
            private final String nickName;

            @SerializedName("room_id")
            private final String roomID;

            @SerializedName("schema")
            private final String schema;

            @SerializedName("sec_uid")
            private final String secUid;

            public LiveHeader() {
                this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LiveHeader copy$default(LiveHeader r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, LiveHeaderEvent r211, String r212, Map r213, int r214, Object r215) {
                if ((r214 & 1) == 0) goto L5;
                String r100 = r110.roomID;
            L7:
                if ((r214 & 2) == 0) goto L9;
                String r101 = r110.secUid;
            L11:
                if ((r214 & 4) == 0) goto L13;
                String r102 = r110.avatar;
            L15:
                if ((r214 & 8) == 0) goto L17;
                String r103 = r110.nickName;
            L19:
                if ((r214 & 16) == 0) goto L21;
                String r104 = r110.liveDesc;
            L23:
                if ((r214 & 32) == 0) goto L25;
                String r105 = r110.liveIcon;
            L27:
                if ((r214 & 64) == 0) goto L29;
                String r106 = r110.enterLiveIcon;
            L31:
                if ((r214 & 128) == 0) goto L33;
                String r107 = r110.schema;
            L35:
                if ((r214 & 256) == 0) goto L37;
                LiveHeaderEvent r118 = r110.event;
            L39:
                if ((r214 & 512) == 0) goto L41;
                String r119 = r110.btmCD;
            L43:
                if ((r214 & 1024) == 0) goto L45;
                Map r108 = r110.bcmData;
            L47:
                return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
            L45:
                r108 = r213;
                goto L47
            L41:
                r119 = r212;
                goto L43
            L37:
                r118 = r211;
                goto L39
            L33:
                r107 = r210;
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

            public final String component1() {
                return this.roomID;
            }

            public final String component10() {
                return this.btmCD;
            }

            public final Map<String, String> component11() {
                return this.bcmData;
            }

            public final String component2() {
                return this.secUid;
            }

            public final String component3() {
                return this.avatar;
            }

            public final String component4() {
                return this.nickName;
            }

            public final String component5() {
                return this.liveDesc;
            }

            public final String component6() {
                return this.liveIcon;
            }

            public final String component7() {
                return this.enterLiveIcon;
            }

            public final String component8() {
                return this.schema;
            }

            public final LiveHeaderEvent component9() {
                return this.event;
            }

            public final LiveHeader copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, LiveHeaderEvent r212, String r213, Map<String, String> r214) {
                return new LiveHeader(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof LiveHeader) == false) goto L28;
                LiveHeader r101 = (LiveHeader) r100;
                if (Intrinsics.areEqual(this.roomID, r101.roomID) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.liveDesc, r101.liveDesc) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.liveIcon, r101.liveIcon) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.enterLiveIcon, r101.enterLiveIcon) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.event, r101.event) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.btmCD, r101.btmCD) == true) goto L26;
                return false;
            L26:
                if (Intrinsics.areEqual(this.bcmData, r101.bcmData) == true) goto L43;
                return false;
            L43:
                return true;
            L28:
                return false;
            }

            public int hashCode() {
                String r100 = this.roomID;
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
                String r107 = this.avatar;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.nickName;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.liveDesc;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                String r116 = this.liveIcon;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                String r119 = this.enterLiveIcon;
                if (r119 == null) goto L29;
                int r120 = r119.hashCode();
            L30:
                int r121 = (r118 + r120) * 31;
                String r122 = this.schema;
                if (r122 == null) goto L33;
                int r123 = r122.hashCode();
            L34:
                int r124 = (r121 + r123) * 31;
                LiveHeaderEvent r125 = this.event;
                if (r125 == null) goto L37;
                int r126 = r125.hashCode();
            L38:
                int r127 = (r124 + r126) * 31;
                String r128 = this.btmCD;
                if (r128 == null) goto L41;
                int r129 = r128.hashCode();
            L42:
                int r130 = (r127 + r129) * 31;
                Map<String, String> r131 = this.bcmData;
                if (r131 == null) goto L46;
                r101 = r131.hashCode();
            L46:
                return r130 + r101;
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
                return "LiveHeader(roomID=" + this.roomID + ", secUid=" + this.secUid + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ", liveDesc=" + this.liveDesc + ", liveIcon=" + this.liveIcon + ", enterLiveIcon=" + this.enterLiveIcon + ", schema=" + this.schema + ", event=" + this.event + ", btmCD=" + this.btmCD + ", bcmData=" + this.bcmData + ")";
            }

            public final String getAvatar() {
                return this.avatar;
            }

            public final Map<String, String> getBcmData() {
                return this.bcmData;
            }

            public final String getBtmCD() {
                return this.btmCD;
            }

            public final String getEnterLiveIcon() {
                return this.enterLiveIcon;
            }

            public final LiveHeaderEvent getEvent() {
                return this.event;
            }

            public final String getLiveDesc() {
                return this.liveDesc;
            }

            public final String getLiveIcon() {
                return this.liveIcon;
            }

            public final String getNickName() {
                return this.nickName;
            }

            public final String getRoomID() {
                return this.roomID;
            }

            public final String getSchema() {
                return this.schema;
            }

            public final String getSecUid() {
                return this.secUid;
            }

            public LiveHeader(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, LiveHeaderEvent r108, String r110, Map<String, String> r111) {
                this.roomID = r100;
                this.secUid = r101;
                this.avatar = r102;
                this.nickName = r103;
                this.liveDesc = r104;
                this.liveIcon = r105;
                this.enterLiveIcon = r106;
                this.schema = r107;
                this.event = r108;
                this.btmCD = r110;
                this.bcmData = r111;
            }

            public /* synthetic */ LiveHeader(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, LiveHeaderEvent r211, String r212, Map r213, int r214, DefaultConstructorMarker r215) {
                Map r100 = null;
                if ((r214 & 1) == 0) goto L5;
                String r101 = null;
            L7:
                if ((r214 & 2) == 0) goto L9;
                String r102 = null;
            L11:
                if ((r214 & 4) == 0) goto L13;
                String r103 = null;
            L15:
                if ((r214 & 8) == 0) goto L17;
                String r104 = null;
            L19:
                if ((r214 & 16) == 0) goto L21;
                String r105 = null;
            L23:
                if ((r214 & 32) == 0) goto L25;
                String r106 = null;
            L27:
                if ((r214 & 64) == 0) goto L29;
                String r107 = null;
            L31:
                if ((r214 & 128) == 0) goto L33;
                String r108 = null;
            L35:
                if ((r214 & 256) == 0) goto L37;
                LiveHeaderEvent r117 = null;
            L39:
                if ((r214 & 512) == 0) goto L41;
                String r118 = null;
            L43:
                if ((r214 & 1024) != 0) goto L46;
                r100 = r213;
            L46:
                this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
                return;
            L41:
                r118 = r212;
                goto L43
            L37:
                r117 = r211;
                goto L39
            L33:
                r108 = r210;
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
                r103 = r112;
                goto L15
            L9:
                r102 = r111;
                goto L11
            L5:
                r101 = r110;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;", "", "showEvent", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;", "clickEvent", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;)V", "getClickEvent", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;", "getShowEvent", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeaderEvent {

            @SerializedName("video_live_header_click")
            private final LiveHeaderEventInner clickEvent;

            @SerializedName("video_live_header_show")
            private final LiveHeaderEventInner showEvent;

            /* JADX WARN: Multi-variable type inference failed */
            public LiveHeaderEvent() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ LiveHeaderEvent copy$default(LiveHeaderEvent r100, LiveHeaderEventInner r101, LiveHeaderEventInner r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.showEvent;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.clickEvent;
            L9:
                return r100.copy(r101, r102);
            }

            public final LiveHeaderEventInner component1() {
                return this.showEvent;
            }

            public final LiveHeaderEventInner component2() {
                return this.clickEvent;
            }

            public final LiveHeaderEvent copy(LiveHeaderEventInner r100, LiveHeaderEventInner r101) {
                return new LiveHeaderEvent(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof LiveHeaderEvent) == false) goto L10;
                LiveHeaderEvent r101 = (LiveHeaderEvent) r100;
                if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.clickEvent, r101.clickEvent) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                LiveHeaderEventInner r100 = this.showEvent;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                LiveHeaderEventInner r104 = this.clickEvent;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "LiveHeaderEvent(showEvent=" + this.showEvent + ", clickEvent=" + this.clickEvent + ")";
            }

            public final LiveHeaderEventInner getClickEvent() {
                return this.clickEvent;
            }

            public final LiveHeaderEventInner getShowEvent() {
                return this.showEvent;
            }

            public LiveHeaderEvent(LiveHeaderEventInner r100, LiveHeaderEventInner r101) {
                this.showEvent = r100;
                this.clickEvent = r101;
            }

            public /* synthetic */ LiveHeaderEvent(LiveHeaderEventInner r100, LiveHeaderEventInner r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;", "", "params", "", "", "paramsFromClient", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECParamsFromClientDTO;", "(Ljava/util/Map;Ljava/util/List;)V", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getParamsFromClient", "()Ljava/util/List;", "setParamsFromClient", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeaderEventInner {

            @SerializedName("params")
            private Map<String, Object> params;

            @SerializedName("params_from_client")
            private List<ECParamsFromClientDTO> paramsFromClient;

            /* JADX WARN: Multi-variable type inference failed */
            public LiveHeaderEventInner() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LiveHeaderEventInner copy$default(LiveHeaderEventInner r100, Map r101, List r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.params;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.paramsFromClient;
            L9:
                return r100.copy(r101, r102);
            }

            public final Map<String, Object> component1() {
                return this.params;
            }

            public final List<ECParamsFromClientDTO> component2() {
                return this.paramsFromClient;
            }

            public final LiveHeaderEventInner copy(Map<String, Object> r100, List<ECParamsFromClientDTO> r101) {
                return new LiveHeaderEventInner(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof LiveHeaderEventInner) == false) goto L10;
                LiveHeaderEventInner r101 = (LiveHeaderEventInner) r100;
                if (Intrinsics.areEqual(this.params, r101.params) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.paramsFromClient, r101.paramsFromClient) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Map<String, Object> r100 = this.params;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<ECParamsFromClientDTO> r104 = this.paramsFromClient;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "LiveHeaderEventInner(params=" + this.params + ", paramsFromClient=" + this.paramsFromClient + ")";
            }

            public final Map<String, Object> getParams() {
                return this.params;
            }

            public final List<ECParamsFromClientDTO> getParamsFromClient() {
                return this.paramsFromClient;
            }

            public final void setParams(Map<String, Object> r100) {
                this.params = r100;
            }

            public final void setParamsFromClient(List<ECParamsFromClientDTO> r100) {
                this.paramsFromClient = r100;
            }

            public LiveHeaderEventInner(Map<String, Object> r100, List<ECParamsFromClientDTO> r101) {
                this.params = r100;
                this.paramsFromClient = r101;
            }

            public /* synthetic */ LiveHeaderEventInner(Map r100, List r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        public Companion() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "", "itemCornerRadius", "", "itemThemeColor", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getItemCornerRadius", "()Ljava/lang/Double;", "setItemCornerRadius", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getItemThemeColor", "()Ljava/lang/String;", "setItemThemeColor", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "", "feedUIStyle", "", "feedCardScale", "", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "getFeedCardScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeedUIStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteVideoCardABValue {

        @SerializedName("feed_card_scale")
        private final Float feedCardScale;

        @SerializedName("feed_ui_style")
        private final Integer feedUIStyle;

        /* JADX WARN: Multi-variable type inference failed */
        public FavoriteVideoCardABValue() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FavoriteVideoCardABValue copy$default(FavoriteVideoCardABValue r100, Integer r101, Float r102, int r103, Object r104) {
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

        public final FavoriteVideoCardABValue copy(Integer r100, Float r101) {
            return new FavoriteVideoCardABValue(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FavoriteVideoCardABValue) == false) goto L10;
            FavoriteVideoCardABValue r101 = (FavoriteVideoCardABValue) r100;
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
            return "FavoriteVideoCardABValue(feedUIStyle=" + this.feedUIStyle + ", feedCardScale=" + this.feedCardScale + ")";
        }

        public final Float getFeedCardScale() {
            return this.feedCardScale;
        }

        public final Integer getFeedUIStyle() {
            return this.feedUIStyle;
        }

        public FavoriteVideoCardABValue(Integer r100, Float r101) {
            this.feedUIStyle = r100;
            this.feedCardScale = r101;
        }

        public /* synthetic */ FavoriteVideoCardABValue(Integer r100, Float r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010$\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0012Jz\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000100J\t\u00101\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u000b\u0010\u0018R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "", "newPadding", "", "hideVideoTime", "hideVideoDesc", "useSameHeight", "", "uiCompact", "coinLabelStyle", "", "isEnlarge", "ttABParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "appendHeight", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHideVideoDesc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideVideoTime", "getNewPadding", "getTtABParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "getUiCompact", "getUseSameHeight", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Double;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "equals", "other", "hashCode", "toMap", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteVideoCardABValues {

        @SerializedName("live_video_height_v2_append")
        private final Double appendHeight;

        @SerializedName("coin_label_style")
        private final Integer coinLabelStyle;

        @SerializedName("hide_video_desc")
        private final Boolean hideVideoDesc;

        @SerializedName("hide_video_time")
        private final Boolean hideVideoTime;

        @SerializedName("video_card_enlarge_play_area")
        private final Boolean isEnlarge;

        @SerializedName("new_padding")
        private final Boolean newPadding;

        @SerializedName("toutiao_ab_param")
        private final LiveCardData.TTFavoriteLiveCardABParam ttABParam;

        @SerializedName("is_ui_compact")
        private final Boolean uiCompact;

        @SerializedName("use_same_height")
        private final String useSameHeight;

        public FavoriteVideoCardABValues() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ FavoriteVideoCardABValues copy$default(FavoriteVideoCardABValues r110, Boolean r111, Boolean r112, Boolean r113, String r114, Boolean r115, Integer r116, Boolean r117, LiveCardData.TTFavoriteLiveCardABParam r118, Double r119, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            Boolean r100 = r110.newPadding;
        L7:
            if ((r210 & 2) == 0) goto L9;
            Boolean r101 = r110.hideVideoTime;
        L11:
            if ((r210 & 4) == 0) goto L13;
            Boolean r102 = r110.hideVideoDesc;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r103 = r110.useSameHeight;
        L19:
            if ((r210 & 16) == 0) goto L21;
            Boolean r104 = r110.uiCompact;
        L23:
            if ((r210 & 32) == 0) goto L25;
            Integer r105 = r110.coinLabelStyle;
        L27:
            if ((r210 & 64) == 0) goto L29;
            Boolean r106 = r110.isEnlarge;
        L31:
            if ((r210 & 128) == 0) goto L33;
            LiveCardData.TTFavoriteLiveCardABParam r107 = r110.ttABParam;
        L35:
            if ((r210 & 256) == 0) goto L37;
            Double r108 = r110.appendHeight;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
        L37:
            r108 = r119;
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

        public final Boolean component2() {
            return this.hideVideoTime;
        }

        public final Boolean component3() {
            return this.hideVideoDesc;
        }

        public final String component4() {
            return this.useSameHeight;
        }

        public final Boolean component5() {
            return this.uiCompact;
        }

        public final Integer component6() {
            return this.coinLabelStyle;
        }

        public final Boolean component7() {
            return this.isEnlarge;
        }

        public final LiveCardData.TTFavoriteLiveCardABParam component8() {
            return this.ttABParam;
        }

        public final Double component9() {
            return this.appendHeight;
        }

        public final FavoriteVideoCardABValues copy(Boolean r110, Boolean r111, Boolean r112, String r113, Boolean r114, Integer r115, Boolean r116, LiveCardData.TTFavoriteLiveCardABParam r117, Double r210) {
            return new FavoriteVideoCardABValues(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FavoriteVideoCardABValues) == false) goto L24;
            FavoriteVideoCardABValues r101 = (FavoriteVideoCardABValues) r100;
            if (Intrinsics.areEqual(this.newPadding, r101.newPadding) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.hideVideoTime, r101.hideVideoTime) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.hideVideoDesc, r101.hideVideoDesc) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.useSameHeight, r101.useSameHeight) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.uiCompact, r101.uiCompact) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.coinLabelStyle, r101.coinLabelStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.isEnlarge, r101.isEnlarge) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.ttABParam, r101.ttABParam) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.appendHeight, r101.appendHeight) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            Boolean r100 = this.newPadding;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.hideVideoTime;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.hideVideoDesc;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.useSameHeight;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Boolean r113 = this.uiCompact;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Integer r116 = this.coinLabelStyle;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            Boolean r119 = this.isEnlarge;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            LiveCardData.TTFavoriteLiveCardABParam r122 = this.ttABParam;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            Double r125 = this.appendHeight;
            if (r125 == null) goto L38;
            r101 = r125.hashCode();
        L38:
            return r124 + r101;
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
            Map r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("new_padding", this.newPadding), TuplesKt.to("is_ui_compact", this.uiCompact), TuplesKt.to("use_same_height", this.useSameHeight)});
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
            return "FavoriteVideoCardABValues(newPadding=" + this.newPadding + ", hideVideoTime=" + this.hideVideoTime + ", hideVideoDesc=" + this.hideVideoDesc + ", useSameHeight=" + this.useSameHeight + ", uiCompact=" + this.uiCompact + ", coinLabelStyle=" + this.coinLabelStyle + ", isEnlarge=" + this.isEnlarge + ", ttABParam=" + this.ttABParam + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final Boolean getHideVideoDesc() {
            return this.hideVideoDesc;
        }

        public final Boolean getHideVideoTime() {
            return this.hideVideoTime;
        }

        public final Boolean getNewPadding() {
            return this.newPadding;
        }

        public final LiveCardData.TTFavoriteLiveCardABParam getTtABParam() {
            return this.ttABParam;
        }

        public final Boolean getUiCompact() {
            return this.uiCompact;
        }

        public final String getUseSameHeight() {
            return this.useSameHeight;
        }

        public final Boolean isEnlarge() {
            return this.isEnlarge;
        }

        public FavoriteVideoCardABValues(Boolean r100, Boolean r101, Boolean r102, String r103, Boolean r104, Integer r105, Boolean r106, LiveCardData.TTFavoriteLiveCardABParam r107, Double r108) {
            this.newPadding = r100;
            this.hideVideoTime = r101;
            this.hideVideoDesc = r102;
            this.useSameHeight = r103;
            this.uiCompact = r104;
            this.coinLabelStyle = r105;
            this.isEnlarge = r106;
            this.ttABParam = r107;
            this.appendHeight = r108;
        }

        public /* synthetic */ FavoriteVideoCardABValues(Boolean r110, Boolean r111, Boolean r112, String r113, Boolean r114, Integer r115, Boolean r116, LiveCardData.TTFavoriteLiveCardABParam r117, Double r118, int r210, DefaultConstructorMarker r211) {
            if ((r210 & 1) == 0) goto L5;
            Boolean r100 = Boolean.FALSE;
        L7:
            if ((r210 & 2) == 0) goto L9;
            Boolean r101 = Boolean.FALSE;
        L11:
            if ((r210 & 4) == 0) goto L13;
            Boolean r102 = Boolean.FALSE;
        L14:
            Double r103 = null;
            if ((r210 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r210 & 16) == 0) goto L21;
            Boolean r105 = Boolean.FALSE;
        L23:
            if ((r210 & 32) == 0) goto L25;
            Integer r106 = null;
        L27:
            if ((r210 & 64) == 0) goto L29;
            Boolean r107 = Boolean.FALSE;
        L31:
            if ((r210 & 128) == 0) goto L33;
            LiveCardData.TTFavoriteLiveCardABParam r108 = null;
        L35:
            if ((r210 & 256) != 0) goto L38;
            r103 = r118;
        L38:
            this(r100, r101, r102, r104, r105, r106, r107, r108, r103);
            return;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$TTFavoriteVideoCardABParam;", "", "taskExpGroup", "", "(Ljava/lang/String;)V", "getTaskExpGroup", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTFavoriteVideoCardABParam {

        @SerializedName("task_tab_show_exp_group")
        private final String taskExpGroup;

        /* JADX WARN: Multi-variable type inference failed */
        public TTFavoriteVideoCardABParam() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TTFavoriteVideoCardABParam copy$default(TTFavoriteVideoCardABParam r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.taskExpGroup;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.taskExpGroup;
        }

        public final TTFavoriteVideoCardABParam copy(String r100) {
            return new TTFavoriteVideoCardABParam(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof TTFavoriteVideoCardABParam) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.taskExpGroup, ((TTFavoriteVideoCardABParam) r100).taskExpGroup) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.taskExpGroup;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "TTFavoriteVideoCardABParam(taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public TTFavoriteVideoCardABParam(String r100) {
            this.taskExpGroup = r100;
        }

        public /* synthetic */ TTFavoriteVideoCardABParam(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001:\u0003*+,BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "", "id", "", "itemId", "seconds", "", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "addr", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "addrH265", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;Ljava/lang/String;)V", "getAddr", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "getAddrH265", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "getDesc", "()Ljava/lang/String;", "getId", "getItemId", "getSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "equals", "", "other", "hashCode", "toString", "Addr", "AddrH265", "Cover", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Video {

        @SerializedName("addr")
        private final Addr addr;

        @SerializedName("addr_h265")
        private final AddrH265 addrH265;

        @SerializedName("cover")
        private final Cover cover;

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        private final String desc;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f170334id;

        @SerializedName("item_id")
        private final String itemId;

        @SerializedName("seconds")
        private final Integer seconds;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jv\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "", "uri", "", "urlList", "", "width", "", "height", "urlKey", "dataSize", "fileHash", "fileCs", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDataSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileCs", "()Ljava/lang/String;", "getFileHash", "getHeight", "getUri", "getUrlKey", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Addr {

            @SerializedName("data_size")
            private final Integer dataSize;

            @SerializedName("file_cs")
            private final String fileCs;

            @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
            private final String fileHash;

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_key")
            private final String urlKey;

            @SerializedName(ScoreTags.STAR_URL_LIST)
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Addr() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Addr copy$default(Addr r100, String r110, List r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117, int r118, Object r119) {
                if ((r118 & 1) == 0) goto L5;
                String r101 = r100.uri;
            L7:
                if ((r118 & 2) == 0) goto L9;
                List r102 = r100.urlList;
            L11:
                if ((r118 & 4) == 0) goto L13;
                Integer r103 = r100.width;
            L15:
                if ((r118 & 8) == 0) goto L17;
                Integer r104 = r100.height;
            L19:
                if ((r118 & 16) == 0) goto L21;
                String r105 = r100.urlKey;
            L23:
                if ((r118 & 32) == 0) goto L25;
                Integer r106 = r100.dataSize;
            L27:
                if ((r118 & 64) == 0) goto L29;
                String r107 = r100.fileHash;
            L31:
                if ((r118 & 128) == 0) goto L33;
                String r108 = r100.fileCs;
            L35:
                return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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
                r103 = r112;
                goto L15
            L9:
                r102 = r111;
                goto L11
            L5:
                r101 = r110;
                goto L7
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

            public final String component5() {
                return this.urlKey;
            }

            public final Integer component6() {
                return this.dataSize;
            }

            public final String component7() {
                return this.fileHash;
            }

            public final String component8() {
                return this.fileCs;
            }

            public final Addr copy(String r110, List<String> r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117) {
                return new Addr(r110, r111, r112, r113, r114, r115, r116, r117);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Addr) == false) goto L22;
                Addr r101 = (Addr) r100;
                if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.urlKey, r101.urlKey) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.dataSize, r101.dataSize) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.fileHash, r101.fileHash) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.fileCs, r101.fileCs) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
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
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.urlKey;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                Integer r116 = this.dataSize;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                String r119 = this.fileHash;
                if (r119 == null) goto L29;
                int r120 = r119.hashCode();
            L30:
                int r121 = (r118 + r120) * 31;
                String r122 = this.fileCs;
                if (r122 == null) goto L34;
                r101 = r122.hashCode();
            L34:
                return r121 + r101;
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
                return "Addr(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ", urlKey=" + this.urlKey + ", dataSize=" + this.dataSize + ", fileHash=" + this.fileHash + ", fileCs=" + this.fileCs + ")";
            }

            public final Integer getDataSize() {
                return this.dataSize;
            }

            public final String getFileCs() {
                return this.fileCs;
            }

            public final String getFileHash() {
                return this.fileHash;
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final String getUrlKey() {
                return this.urlKey;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Addr(String r100, List<String> r101, Integer r102, Integer r103, String r104, Integer r105, String r106, String r107) {
                this.uri = r100;
                this.urlList = r101;
                this.width = r102;
                this.height = r103;
                this.urlKey = r104;
                this.dataSize = r105;
                this.fileHash = r106;
                this.fileCs = r107;
            }

            public /* synthetic */ Addr(String r110, List r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
                String r100 = null;
                if ((r118 & 1) == 0) goto L5;
                String r101 = null;
            L7:
                if ((r118 & 2) == 0) goto L9;
                List r102 = null;
            L11:
                if ((r118 & 4) == 0) goto L13;
                Integer r103 = null;
            L15:
                if ((r118 & 8) == 0) goto L17;
                Integer r104 = null;
            L19:
                if ((r118 & 16) == 0) goto L21;
                String r105 = null;
            L23:
                if ((r118 & 32) == 0) goto L25;
                Integer r106 = null;
            L27:
                if ((r118 & 64) == 0) goto L29;
                String r107 = null;
            L31:
                if ((r118 & 128) != 0) goto L34;
                r100 = r117;
            L34:
                this(r101, r102, r103, r104, r105, r106, r107, r100);
                return;
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
                r103 = r112;
                goto L15
            L9:
                r102 = r111;
                goto L11
            L5:
                r101 = r110;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jv\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "", "uri", "", "urlList", "", "width", "", "height", "urlKey", "dataSize", "fileHash", "fileCs", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDataSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileCs", "()Ljava/lang/String;", "getFileHash", "getHeight", "getUri", "getUrlKey", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class AddrH265 {

            @SerializedName("data_size")
            private final Integer dataSize;

            @SerializedName("file_cs")
            private final String fileCs;

            @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
            private final String fileHash;

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_key")
            private final String urlKey;

            @SerializedName(ScoreTags.STAR_URL_LIST)
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public AddrH265() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AddrH265 copy$default(AddrH265 r100, String r110, List r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117, int r118, Object r119) {
                if ((r118 & 1) == 0) goto L5;
                String r101 = r100.uri;
            L7:
                if ((r118 & 2) == 0) goto L9;
                List r102 = r100.urlList;
            L11:
                if ((r118 & 4) == 0) goto L13;
                Integer r103 = r100.width;
            L15:
                if ((r118 & 8) == 0) goto L17;
                Integer r104 = r100.height;
            L19:
                if ((r118 & 16) == 0) goto L21;
                String r105 = r100.urlKey;
            L23:
                if ((r118 & 32) == 0) goto L25;
                Integer r106 = r100.dataSize;
            L27:
                if ((r118 & 64) == 0) goto L29;
                String r107 = r100.fileHash;
            L31:
                if ((r118 & 128) == 0) goto L33;
                String r108 = r100.fileCs;
            L35:
                return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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
                r103 = r112;
                goto L15
            L9:
                r102 = r111;
                goto L11
            L5:
                r101 = r110;
                goto L7
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

            public final String component5() {
                return this.urlKey;
            }

            public final Integer component6() {
                return this.dataSize;
            }

            public final String component7() {
                return this.fileHash;
            }

            public final String component8() {
                return this.fileCs;
            }

            public final AddrH265 copy(String r110, List<String> r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117) {
                return new AddrH265(r110, r111, r112, r113, r114, r115, r116, r117);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof AddrH265) == false) goto L22;
                AddrH265 r101 = (AddrH265) r100;
                if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.urlKey, r101.urlKey) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.dataSize, r101.dataSize) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.fileHash, r101.fileHash) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.fileCs, r101.fileCs) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
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
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.urlKey;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                Integer r116 = this.dataSize;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                String r119 = this.fileHash;
                if (r119 == null) goto L29;
                int r120 = r119.hashCode();
            L30:
                int r121 = (r118 + r120) * 31;
                String r122 = this.fileCs;
                if (r122 == null) goto L34;
                r101 = r122.hashCode();
            L34:
                return r121 + r101;
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
                return "AddrH265(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ", urlKey=" + this.urlKey + ", dataSize=" + this.dataSize + ", fileHash=" + this.fileHash + ", fileCs=" + this.fileCs + ")";
            }

            public final Integer getDataSize() {
                return this.dataSize;
            }

            public final String getFileCs() {
                return this.fileCs;
            }

            public final String getFileHash() {
                return this.fileHash;
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final String getUrlKey() {
                return this.urlKey;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public AddrH265(String r100, List<String> r101, Integer r102, Integer r103, String r104, Integer r105, String r106, String r107) {
                this.uri = r100;
                this.urlList = r101;
                this.width = r102;
                this.height = r103;
                this.urlKey = r104;
                this.dataSize = r105;
                this.fileHash = r106;
                this.fileCs = r107;
            }

            public /* synthetic */ AddrH265(String r110, List r111, Integer r112, Integer r113, String r114, Integer r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
                String r100 = null;
                if ((r118 & 1) == 0) goto L5;
                String r101 = null;
            L7:
                if ((r118 & 2) == 0) goto L9;
                List r102 = null;
            L11:
                if ((r118 & 4) == 0) goto L13;
                Integer r103 = null;
            L15:
                if ((r118 & 8) == 0) goto L17;
                Integer r104 = null;
            L19:
                if ((r118 & 16) == 0) goto L21;
                String r105 = null;
            L23:
                if ((r118 & 32) == 0) goto L25;
                Integer r106 = null;
            L27:
                if ((r118 & 64) == 0) goto L29;
                String r107 = null;
            L31:
                if ((r118 & 128) != 0) goto L34;
                r100 = r117;
            L34:
                this(r101, r102, r103, r104, r105, r106, r107, r100);
                return;
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
                r103 = r112;
                goto L15
            L9:
                r102 = r111;
                goto L11
            L5:
                r101 = r110;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

        public Video() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Video copy$default(Video r100, String r101, String r102, Integer r103, Cover r104, Addr r110, AddrH265 r111, String r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.f170334id;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.itemId;
        L8:
            String r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.seconds;
        L11:
            Integer r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.cover;
        L14:
            Cover r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.addr;
        L17:
            Addr r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.addrH265;
        L20:
            AddrH265 r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.desc;
        L23:
            String r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final String component1() {
            return this.f170334id;
        }

        public final String component2() {
            return this.itemId;
        }

        public final Integer component3() {
            return this.seconds;
        }

        public final Cover component4() {
            return this.cover;
        }

        public final Addr component5() {
            return this.addr;
        }

        public final AddrH265 component6() {
            return this.addrH265;
        }

        public final String component7() {
            return this.desc;
        }

        public final Video copy(String r110, String r111, Integer r112, Cover r113, Addr r114, AddrH265 r115, String r116) {
            return new Video(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Video) == false) goto L20;
            Video r101 = (Video) r100;
            if (Intrinsics.areEqual(this.f170334id, r101.f170334id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.seconds, r101.seconds) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.addr, r101.addr) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.addrH265, r101.addrH265) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            String r100 = this.f170334id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.itemId;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.seconds;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Cover r110 = this.cover;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Addr r113 = this.addr;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            AddrH265 r116 = this.addrH265;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.desc;
            if (r119 == null) goto L30;
            r101 = r119.hashCode();
        L30:
            return r118 + r101;
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
            return "Video(id=" + this.f170334id + ", itemId=" + this.itemId + ", seconds=" + this.seconds + ", cover=" + this.cover + ", addr=" + this.addr + ", addrH265=" + this.addrH265 + ", desc=" + this.desc + ")";
        }

        public final Addr getAddr() {
            return this.addr;
        }

        public final AddrH265 getAddrH265() {
            return this.addrH265;
        }

        public final Cover getCover() {
            return this.cover;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getId() {
            return this.f170334id;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final Integer getSeconds() {
            return this.seconds;
        }

        public Video(String r100, String r101, Integer r102, Cover r103, Addr r104, AddrH265 r105, String r106) {
            this.f170334id = r100;
            this.itemId = r101;
            this.seconds = r102;
            this.cover = r103;
            this.addr = r104;
            this.addrH265 = r105;
            this.desc = r106;
        }

        public /* synthetic */ Video(String r100, String r101, Integer r102, Cover r110, Addr r111, AddrH265 r112, String r113, int r114, DefaultConstructorMarker r115) {
            if ((r114 & 1) == 0) goto L5;
            String r116 = null;
        L7:
            if ((r114 & 2) == 0) goto L9;
            String r103 = null;
        L11:
            if ((r114 & 4) == 0) goto L13;
            Integer r104 = null;
        L15:
            if ((r114 & 8) == 0) goto L17;
            Cover r105 = null;
        L19:
            if ((r114 & 16) == 0) goto L21;
            Addr r106 = null;
        L23:
            if ((r114 & 32) == 0) goto L25;
            AddrH265 r107 = null;
        L27:
            if ((r114 & 64) == 0) goto L29;
            String r117 = null;
        L30:
            this(r116, r103, r104, r105, r106, r107, r117);
            return;
        L29:
            r117 = r113;
            goto L30
        L25:
            r107 = r112;
            goto L27
        L21:
            r106 = r111;
            goto L23
        L17:
            r105 = r110;
            goto L19
        L13:
            r104 = r102;
            goto L15
        L9:
            r103 = r101;
            goto L11
        L5:
            r116 = r100;
            goto L7
        }
    }

    static {
        Companion = new Companion();
    }

    public VideoCardData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
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

    public final CommonData.CoinData getCoinData() {
        return this.coinData;
    }

    public final CommonData.ElementStyle getElementStyle() {
        return this.elementStyle;
    }

    public final CommonData.Extra getExtra() {
        return this.extra;
    }

    public final FavoriteVideoCardABValue getFavoriteVideoCardABValue() {
        return this.favoriteVideoCardABValue;
    }

    public final FavoriteVideoCardABValues getFavoriteVideoCardABValues() {
        return this.favoriteVideoCardABValues;
    }

    public final CommonData.Impression getImpression() {
        return this.impression;
    }

    public final FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final Companion.LiveHeader getLiveHeader() {
        return this.liveHeader;
    }

    public final CommonData.MarketingData getMarketingData() {
        return this.marketingData;
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

    public final Integer getType() {
        return this.type;
    }

    public final CommonData.User getUser() {
        return this.user;
    }

    public final Video getVideo() {
        return this.video;
    }

    public final CommonData.WindVaneEventData getWindVaneData() {
        return this.windVaneData;
    }

    public final Object getWindVaneParams() {
        return this.windVaneParams;
    }

    public VideoCardData(Integer r100, CommonData.Product r101, CommonData.User r102, Video r103, Companion.LiveHeader r104, CommonData.Impression r105, CommonData.CardCommon r106, CommonData.Extra r110, String r111, CommonData.MarketingData r112, CommonData.CoinData r113, FavoriteVideoCardABValue r114, FavoriteVideoCardABValues r115, FavoriteItemStyle r116, Boolean r117, CommonData.WindVaneEventData r118, Object r119, CommonData.ElementStyle r210, String r211, String r212) {
        this.type = r100;
        this.product = r101;
        this.user = r102;
        this.video = r103;
        this.liveHeader = r104;
        this.impression = r105;
        this.cardCommon = r106;
        this.extra = r110;
        this.schema = r111;
        this.marketingData = r112;
        this.coinData = r113;
        this.favoriteVideoCardABValue = r114;
        this.favoriteVideoCardABValues = r115;
        this.itemStyle = r116;
        this.showJustNowUI = r117;
        this.windVaneData = r118;
        this.windVaneParams = r119;
        this.elementStyle = r210;
        this.accessibilityLabel = r211;
        this.btmCD = r212;
    }

    public /* synthetic */ VideoCardData(Integer r210, CommonData.Product r211, CommonData.User r212, Video r213, Companion.LiveHeader r214, CommonData.Impression r215, CommonData.CardCommon r216, CommonData.Extra r217, String r310, CommonData.MarketingData r311, CommonData.CoinData r312, FavoriteVideoCardABValue r313, FavoriteVideoCardABValues r314, FavoriteItemStyle r315, Boolean r316, CommonData.WindVaneEventData r317, Object r318, CommonData.ElementStyle r319, String r410, String r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r412 & 2) == 0) goto L9;
        CommonData.Product r101 = null;
    L11:
        if ((r412 & 4) == 0) goto L13;
        CommonData.User r102 = null;
    L15:
        if ((r412 & 8) == 0) goto L17;
        Video r103 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        Companion.LiveHeader r104 = null;
    L23:
        if ((r412 & 32) == 0) goto L25;
        CommonData.Impression r105 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        CommonData.CardCommon r106 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        CommonData.Extra r107 = null;
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        CommonData.MarketingData r111 = null;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        CommonData.CoinData r112 = null;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        FavoriteVideoCardABValue r113 = null;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        FavoriteVideoCardABValues r114 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        FavoriteItemStyle r115 = null;
    L59:
        if ((r412 & 16384) == 0) goto L61;
        Boolean r108 = null;
    L63:
        if ((r412 & 32768) == 0) goto L65;
        CommonData.WindVaneEventData r116 = null;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        Object r117 = null;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        CommonData.ElementStyle r118 = null;
    L75:
        if ((r412 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r412 & 524288) == 0) goto L81;
        String r109 = null;
    L82:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r109);
        return;
    L81:
        r109 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r118 = r319;
        goto L75
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L59
    L53:
        r114 = r314;
        goto L55
    L49:
        r113 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r111 = r311;
        goto L43
    L37:
        r110 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
