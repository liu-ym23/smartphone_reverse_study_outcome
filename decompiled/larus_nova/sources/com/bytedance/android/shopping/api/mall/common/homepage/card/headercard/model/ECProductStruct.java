package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l93.b;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001:\u0003XYZBå\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jî\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010T\u001a\u0004\u0018\u00010\u0003J\t\u0010U\u001a\u00020\bHÖ\u0001J\u0006\u0010V\u001a\u00020RJ\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b8\u00100\"\u0004\b9\u0010:R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010=¨\u0006["}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "", "productId", "", "cover", "coverWhiteBg", "title", SalesInfoStruct.SALES, "", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "brandName", "campaignInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;", "shopId", "link", "shop", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "recommendInfo", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/TagInfo;", "type", "wysiwygParam", "extraInfo", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "getBrandName", "()Ljava/lang/String;", "getCampaignInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;", "getCover", "()Ljava/lang/Object;", "getCoverWhiteBg", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "getLink", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "getProductId", "getRecommendInfo", "getSales", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShop", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;", "getShopId", "getTags", "()Ljava/util/List;", "getTitle", "getType", "setType", "(Ljava/lang/Integer;)V", "getWysiwygParam", "setWysiwygParam", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "equals", "", "other", "getCoverUrl", "hashCode", "productIsActivity", "toString", "Extra", "ProductExtraActivityType", "SecKillProductCampaignType", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECProductStruct {

    @SerializedName("brand_name")
    private final String brandName;

    @SerializedName("campaign_info")
    private final CampaignInfo campaignInfo;

    @SerializedName("cover")
    private final Object cover;

    @SerializedName("cover_white_bg")
    private final Object coverWhiteBg;

    @SerializedName("extra")
    private final Extra extra;
    private Map<String, String> extraInfo;

    @SerializedName("link")
    private final String link;

    @SerializedName("price")
    private final PriceStruct price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName(SalesInfoStruct.SALES)
    private final Integer sales;

    @SerializedName("shop")
    private final Shop shop;

    @SerializedName(a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<TagInfo> tags;

    @SerializedName("title")
    private final String title;
    private Integer type;
    private String wysiwygParam;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "", "useNewChannel", "", "resourceId", "", "mallCategoryChannelFirstVertical", "mallCategoryChannelThirdVertical", "productActivityType", "nYuanMPiece", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getMallCategoryChannelFirstVertical", "()Ljava/lang/String;", "getMallCategoryChannelThirdVertical", "getNYuanMPiece", "getProductActivityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResourceId", "getUseNewChannel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName("mall_category_channel_first_vertical")
        private final String mallCategoryChannelFirstVertical;

        @SerializedName("mall_category_channel_third_vertical")
        private final String mallCategoryChannelThirdVertical;

        @SerializedName("n_yuan_m_piece")
        private final String nYuanMPiece;

        @SerializedName(a.KEY_PRODUCT_ACTIVITY_TYPE)
        private final Integer productActivityType;

        @SerializedName("resource_id")
        private final String resourceId;

        @SerializedName("use_new_channel")
        private final Integer useNewChannel;

        public Extra() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Extra copy$default(Extra r100, Integer r101, String r102, String r103, String r104, Integer r105, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.useNewChannel;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.resourceId;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.mallCategoryChannelFirstVertical;
        L11:
            String r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.mallCategoryChannelThirdVertical;
        L14:
            String r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.productActivityType;
        L17:
            Integer r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.nYuanMPiece;
        L20:
            Integer r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final Integer component1() {
            return this.useNewChannel;
        }

        public final String component2() {
            return this.resourceId;
        }

        public final String component3() {
            return this.mallCategoryChannelFirstVertical;
        }

        public final String component4() {
            return this.mallCategoryChannelThirdVertical;
        }

        public final Integer component5() {
            return this.productActivityType;
        }

        public final String component6() {
            return this.nYuanMPiece;
        }

        public final Extra copy(Integer r100, String r110, String r111, String r112, Integer r113, String r114) {
            return new Extra(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Extra) == false) goto L18;
            Extra r101 = (Extra) r100;
            if (Intrinsics.areEqual(this.useNewChannel, r101.useNewChannel) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.mallCategoryChannelFirstVertical, r101.mallCategoryChannelFirstVertical) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.mallCategoryChannelThirdVertical, r101.mallCategoryChannelThirdVertical) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.productActivityType, r101.productActivityType) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.nYuanMPiece, r101.nYuanMPiece) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.useNewChannel;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.resourceId;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.mallCategoryChannelFirstVertical;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.mallCategoryChannelThirdVertical;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.productActivityType;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.nYuanMPiece;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
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
            return "Extra(useNewChannel=" + this.useNewChannel + ", resourceId=" + this.resourceId + ", mallCategoryChannelFirstVertical=" + this.mallCategoryChannelFirstVertical + ", mallCategoryChannelThirdVertical=" + this.mallCategoryChannelThirdVertical + ", productActivityType=" + this.productActivityType + ", nYuanMPiece=" + this.nYuanMPiece + ")";
        }

        public final String getMallCategoryChannelFirstVertical() {
            return this.mallCategoryChannelFirstVertical;
        }

        public final String getMallCategoryChannelThirdVertical() {
            return this.mallCategoryChannelThirdVertical;
        }

        public final String getNYuanMPiece() {
            return this.nYuanMPiece;
        }

        public final Integer getProductActivityType() {
            return this.productActivityType;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Integer getUseNewChannel() {
            return this.useNewChannel;
        }

        public Extra(Integer r100, String r101, String r102, String r103, Integer r104, String r105) {
            this.useNewChannel = r100;
            this.resourceId = r101;
            this.mallCategoryChannelFirstVertical = r102;
            this.mallCategoryChannelThirdVertical = r103;
            this.productActivityType = r104;
            this.nYuanMPiece = r105;
        }

        public /* synthetic */ Extra(Integer r100, String r101, String r102, String r103, Integer r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            Integer r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            String r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            String r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            Integer r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            String r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$ProductExtraActivityType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL_PRODUCT", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ProductExtraActivityType extends Enum<ProductExtraActivityType> {
        private static final /* synthetic */ ProductExtraActivityType[] $VALUES = null;
        public static final ProductExtraActivityType NORMAL_PRODUCT = null;
        private final int value;

        static {
            ProductExtraActivityType r100 = new ProductExtraActivityType("NORMAL_PRODUCT", 0, 0);
            NORMAL_PRODUCT = r100;
            $VALUES = new ProductExtraActivityType[]{r100};
        }

        public static ProductExtraActivityType valueOf(String r100) {
            return (ProductExtraActivityType) r27.a.a(ProductExtraActivityType.class, r100);
        }

        public static ProductExtraActivityType[] values() {
            return (ProductExtraActivityType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private ProductExtraActivityType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$SecKillProductCampaignType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SECKILL", "PREORDER", "DRAW", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SecKillProductCampaignType extends Enum<SecKillProductCampaignType> {
        private static final /* synthetic */ SecKillProductCampaignType[] $VALUES = null;
        public static final SecKillProductCampaignType DRAW = null;
        public static final SecKillProductCampaignType PREORDER = null;
        public static final SecKillProductCampaignType SECKILL = null;
        private final int value;

        static {
            SecKillProductCampaignType r100 = new SecKillProductCampaignType("SECKILL", 0, 1);
            SECKILL = r100;
            SecKillProductCampaignType r101 = new SecKillProductCampaignType("PREORDER", 1, 2);
            PREORDER = r101;
            SecKillProductCampaignType r102 = new SecKillProductCampaignType("DRAW", 2, 3);
            DRAW = r102;
            $VALUES = new SecKillProductCampaignType[]{r100, r101, r102};
        }

        public static SecKillProductCampaignType valueOf(String r100) {
            return (SecKillProductCampaignType) r27.a.a(SecKillProductCampaignType.class, r100);
        }

        public static SecKillProductCampaignType[] values() {
            return (SecKillProductCampaignType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private SecKillProductCampaignType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ECProductStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECProductStruct copy$default(ECProductStruct r110, String r111, Object r112, Object r210, String r211, Integer r212, PriceStruct r213, String r214, CampaignInfo r215, String r216, String r217, Shop r218, Extra r219, String r310, List r311, Integer r312, String r313, Map r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.productId;
    L7:
        if ((r315 & 2) == 0) goto L9;
        Object r101 = r110.cover;
    L11:
        if ((r315 & 4) == 0) goto L13;
        Object r102 = r110.coverWhiteBg;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.title;
    L19:
        if ((r315 & 16) == 0) goto L21;
        Integer r104 = r110.sales;
    L23:
        if ((r315 & 32) == 0) goto L25;
        PriceStruct r105 = r110.price;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.brandName;
    L31:
        if ((r315 & 128) == 0) goto L33;
        CampaignInfo r107 = r110.campaignInfo;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.shopId;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.link;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Shop r115 = r110.shop;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Extra r116 = r110.extra;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.recommendInfo;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        List r118 = r110.tags;
    L58:
        List r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        Integer r119 = r110.type;
    L62:
        Integer r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.wysiwygParam;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        Map r108 = r110.extraInfo;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
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
        return this.productId;
    }

    public final String component10() {
        return this.link;
    }

    public final Shop component11() {
        return this.shop;
    }

    public final Extra component12() {
        return this.extra;
    }

    public final String component13() {
        return this.recommendInfo;
    }

    public final List<TagInfo> component14() {
        return this.tags;
    }

    public final Integer component15() {
        return this.type;
    }

    public final String component16() {
        return this.wysiwygParam;
    }

    public final Map<String, String> component17() {
        return this.extraInfo;
    }

    public final Object component2() {
        return this.cover;
    }

    public final Object component3() {
        return this.coverWhiteBg;
    }

    public final String component4() {
        return this.title;
    }

    public final Integer component5() {
        return this.sales;
    }

    public final PriceStruct component6() {
        return this.price;
    }

    public final String component7() {
        return this.brandName;
    }

    public final CampaignInfo component8() {
        return this.campaignInfo;
    }

    public final String component9() {
        return this.shopId;
    }

    public final ECProductStruct copy(String r210, Object r211, Object r212, String r213, Integer r214, PriceStruct r215, String r216, CampaignInfo r217, String r218, String r219, Shop r310, Extra r311, String r312, List<TagInfo> r313, Integer r314, String r315, Map<String, String> r316) {
        return new ECProductStruct(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECProductStruct) == false) goto L40;
        ECProductStruct r101 = (ECProductStruct) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverWhiteBg, r101.coverWhiteBg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sales, r101.sales) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.brandName, r101.brandName) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.campaignInfo, r101.campaignInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shop, r101.shop) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.wysiwygParam, r101.wysiwygParam) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Object r104 = this.cover;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.coverWhiteBg;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.sales;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        PriceStruct r116 = this.price;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.brandName;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        CampaignInfo r122 = this.campaignInfo;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.shopId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.link;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Shop r131 = this.shop;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Extra r134 = this.extra;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.recommendInfo;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        List<TagInfo> r140 = this.tags;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.type;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.wysiwygParam;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Map<String, String> r149 = this.extraInfo;
        if (r149 == null) goto L70;
        r101 = r149.hashCode();
    L70:
        return r148 + r101;
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
        return "ECProductStruct(productId=" + this.productId + ", cover=" + this.cover + ", coverWhiteBg=" + this.coverWhiteBg + ", title=" + this.title + ", sales=" + this.sales + ", price=" + this.price + ", brandName=" + this.brandName + ", campaignInfo=" + this.campaignInfo + ", shopId=" + this.shopId + ", link=" + this.link + ", shop=" + this.shop + ", extra=" + this.extra + ", recommendInfo=" + this.recommendInfo + ", tags=" + this.tags + ", type=" + this.type + ", wysiwygParam=" + this.wysiwygParam + ", extraInfo=" + this.extraInfo + ")";
    }

    public final String getCoverUrl() {
        String r100 = b.a(this.coverWhiteBg);
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return r100;
    L11:
        String r103 = b.a(this.cover);
        if (r103 != null) goto L14;
    L15:
        r101 = true;
    L16:
        if (r101 == true) goto L18;
        return r103;
    L18:
        return null;
    L14:
        if (r103.length() != 0) goto L16;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean productIsActivity() {
        Extra r100 = this.extra;
        if (r100 == null) goto L5;
        Integer r101 = r100.getProductActivityType();
    L6:
        if (r101 == null) goto L13;
        Integer r102 = this.extra.getProductActivityType();
        int r103 = ProductExtraActivityType.NORMAL_PRODUCT.getValue();
        if (r102 != null) goto L11;
    L12:
        return true;
    L11:
        if (r102.intValue() != r103) goto L12;
    L13:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final CampaignInfo getCampaignInfo() {
        return this.campaignInfo;
    }

    public final Object getCover() {
        return this.cover;
    }

    public final Object getCoverWhiteBg() {
        return this.coverWhiteBg;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final String getLink() {
        return this.link;
    }

    public final PriceStruct getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final Integer getSales() {
        return this.sales;
    }

    public final Shop getShop() {
        return this.shop;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final List<TagInfo> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getWysiwygParam() {
        return this.wysiwygParam;
    }

    public final void setExtraInfo(Map<String, String> r100) {
        this.extraInfo = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void setWysiwygParam(String r100) {
        this.wysiwygParam = r100;
    }

    public ECProductStruct(String r100, Object r101, Object r102, String r103, Integer r104, PriceStruct r105, String r106, CampaignInfo r110, String r111, String r112, Shop r113, Extra r114, String r115, List<TagInfo> r116, Integer r117, String r118, Map<String, String> r119) {
        this.productId = r100;
        this.cover = r101;
        this.coverWhiteBg = r102;
        this.title = r103;
        this.sales = r104;
        this.price = r105;
        this.brandName = r106;
        this.campaignInfo = r110;
        this.shopId = r111;
        this.link = r112;
        this.shop = r113;
        this.extra = r114;
        this.recommendInfo = r115;
        this.tags = r116;
        this.type = r117;
        this.wysiwygParam = r118;
        this.extraInfo = r119;
    }

    public /* synthetic */ ECProductStruct(String r110, Object r210, Object r211, String r212, Integer r213, PriceStruct r214, String r215, CampaignInfo r216, String r217, String r218, Shop r219, Extra r310, String r311, List r312, Integer r313, String r314, Map r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        PriceStruct r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        CampaignInfo r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Shop r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Extra r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        List r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        Map r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
