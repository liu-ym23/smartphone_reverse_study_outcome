package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.SkuBaseInfoComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.PriceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b2\b\u0086\b\u0018\u0000 o2\u00020\u0001:\u0001pB\u0095\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u0013\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00103\u001a\u00020\u0013\u0012\b\b\u0002\u00104\u001a\u00020\u0013\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0013\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010;\u001a\u00020\"¢\u0006\u0004\bm\u0010nJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0013HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0013HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0013HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\t\u0010#\u001a\u00020\"HÆ\u0003J\u0097\u0002\u0010<\u001a\u00020\u00002\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010/\u001a\u00020\u00132\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00132\b\b\u0002\u00104\u001a\u00020\u00132\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00108\u001a\u00020\u00132\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010;\u001a\u00020\"HÆ\u0001J\t\u0010=\u001a\u00020\u0002HÖ\u0001J\t\u0010>\u001a\u00020\u0004HÖ\u0001J\u0013\u0010A\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010?HÖ\u0003R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010&\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010'\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010(\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010)\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010N\u001a\u0004\bQ\u0010PR\u001c\u0010*\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010H\u001a\u0004\bR\u0010JR\u001c\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010S\u001a\u0004\bV\u0010UR\u001c\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010S\u001a\u0004\bW\u0010UR\u001c\u0010.\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010H\u001a\u0004\bX\u0010JR\u001a\u0010/\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010Y\u001a\u0004\bZ\u0010[R\u001a\u00100\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010E\u001a\u0004\b\\\u0010GR\u001a\u00101\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010E\u001a\u0004\b]\u0010GR\u001a\u00102\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010E\u001a\u0004\b^\u0010GR\u001a\u00103\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010Y\u001a\u0004\b_\u0010[R\u001a\u00104\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010Y\u001a\u0004\b`\u0010[R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010B\u001a\u0004\ba\u0010DR\u001c\u00106\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010S\u001a\u0004\bb\u0010UR\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010B\u001a\u0004\bc\u0010DR\u001a\u00108\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010Y\u001a\u0004\bd\u0010[R\u001c\u00109\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010e\u001a\u0004\bf\u0010gR\u001c\u0010:\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010h\u001a\u0004\bi\u0010jR\u001a\u0010;\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010k\u001a\u0004\b;\u0010l¨\u0006q"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "Ljava/io/Serializable;", "", "component1", "", "component2", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "component3", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "component4", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "component5", "component6", "component7", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "component8", "component9", "component10", "component11", "", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "component22", "Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "component23", "", "component24", "activityId", "activityType", "priceDesc", "activityTime", "activityBgUrl", "activityIconImage", "activityHintText", "price", "marketPrice", "discountPrice", SalesInfoStruct.SALES, "groupId", "joined", "groupSize", "percent", "skuMinPrice", "skuMaxPrice", "rulePageUrl", "depositPrice", "auctionId", "auctionStatus", "subsidy", "skuInfo", "isGroupBuying", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getActivityId", "()Ljava/lang/String;", "I", "getActivityType", "()I", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPriceDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "getActivityTime", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getActivityBgUrl", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getActivityIconImage", "getActivityHintText", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getPrice", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;", "getMarketPrice", "getDiscountPrice", "getSales", "J", "getGroupId", "()J", "getJoined", "getGroupSize", "getPercent", "getSkuMinPrice", "getSkuMaxPrice", "getRulePageUrl", "getDepositPrice", "getAuctionId", "getAuctionStatus", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "getSubsidy", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;", "Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "getSkuInfo", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;", "Z", "()Z", "<init>", "(Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityTime;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;JIIIJJLjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/elements/PriceElement;Ljava/lang/String;JLcom/bytedance/android/ec/model/response/anchorv3/PromotionSubsidizedActivity;Lcom/bytedance/android/shopping/anchorv4/dto/components/SkuBaseInfoComponent;Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityVO implements Serializable {
    public static final a Companion = null;
    public static final long STATUS_BOUGHT_IN = 4;
    public static final long STATUS_DEAL = 3;
    public static final long STATUS_ON_AUCTION = 2;
    public static final long STATUS_OTHER_DEAL = 7;
    public static final long STATUS_PREVIEW = 1;

    @SerializedName("activity_bg_url")
    private final ImageModel activityBgUrl;

    @SerializedName("activity_hint_text")
    private final TextElement activityHintText;

    @SerializedName("activity_icon_image")
    private final ImageModel activityIconImage;

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("activity_time")
    private final ActivityTime activityTime;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE)
    private final int activityType;

    @SerializedName("auction_id")
    private final String auctionId;

    @SerializedName("auction_status")
    private final long auctionStatus;

    @SerializedName("deposit_price")
    private final PriceElement depositPrice;

    @SerializedName("discount_price")
    private final PriceElement discountPrice;

    @SerializedName("group_id")
    private final long groupId;

    @SerializedName("group_size")
    private final int groupSize;

    @SerializedName("is_group_buying")
    private final boolean isGroupBuying;

    @SerializedName("joined")
    private final int joined;

    @SerializedName("market_price")
    private final PriceElement marketPrice;

    @SerializedName("percent")
    private final int percent;

    @SerializedName("price")
    private final PriceElement price;

    @SerializedName("price_desc")
    private final TextElement priceDesc;

    @SerializedName("rule_page_url")
    private final String rulePageUrl;

    @SerializedName(SalesInfoStruct.SALES)
    private final TextElement sales;

    @SerializedName("sku_info")
    private final SkuBaseInfoComponent skuInfo;

    @SerializedName("sku_max_price")
    private final long skuMaxPrice;

    @SerializedName("sku_min_price")
    private final long skuMinPrice;

    @SerializedName("subsidy")
    private final PromotionSubsidizedActivity subsidy;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ActivityVO() {
        this(null, 0, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, null, 0, null, null, false, 16777215, null);
    }

    public static /* synthetic */ ActivityVO copy$default(ActivityVO r110, String r111, int r112, TextElement r210, ActivityTime r211, ImageModel r212, ImageModel r213, TextElement r214, PriceElement r215, PriceElement r216, PriceElement r217, TextElement r218, long r219, int r310, int r311, int r312, long r313, long r314, String r315, PriceElement r316, String r410, long r411, PromotionSubsidizedActivity r412, SkuBaseInfoComponent r413, boolean r414, int r415, Object r416) {
        if ((r415 & 1) == 0) goto L5;
        String r100 = r110.activityId;
    L7:
        if ((r415 & 2) == 0) goto L9;
        int r101 = r110.activityType;
    L11:
        if ((r415 & 4) == 0) goto L13;
        TextElement r102 = r110.priceDesc;
    L15:
        if ((r415 & 8) == 0) goto L17;
        ActivityTime r103 = r110.activityTime;
    L19:
        if ((r415 & 16) == 0) goto L21;
        ImageModel r104 = r110.activityBgUrl;
    L23:
        if ((r415 & 32) == 0) goto L25;
        ImageModel r105 = r110.activityIconImage;
    L27:
        if ((r415 & 64) == 0) goto L29;
        TextElement r106 = r110.activityHintText;
    L31:
        if ((r415 & 128) == 0) goto L33;
        PriceElement r107 = r110.price;
    L35:
        if ((r415 & 256) == 0) goto L37;
        PriceElement r113 = r110.marketPrice;
    L39:
        if ((r415 & 512) == 0) goto L41;
        PriceElement r114 = r110.discountPrice;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        TextElement r115 = r110.sales;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        long r116 = r110.groupId;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        int r117 = r110.joined;
    L54:
        int r317 = r117;
        if ((r415 & 8192) == 0) goto L57;
        int r118 = r110.groupSize;
    L58:
        int r318 = r118;
        if ((r415 & 16384) == 0) goto L61;
        int r119 = r110.percent;
    L62:
        long r220 = r116;
        if ((r415 & 32768) == 0) goto L65;
        long r120 = r110.skuMinPrice;
    L66:
        long r319 = r120;
        if ((r415 & 65536) == 0) goto L69;
        long r121 = r110.skuMaxPrice;
    L70:
        long r320 = r121;
        if ((r415 & 131072) == 0) goto L73;
        String r122 = r110.rulePageUrl;
    L75:
        if ((262144 & r415) == 0) goto L77;
        PriceElement r123 = r110.depositPrice;
    L78:
        PriceElement r321 = r123;
        if ((r415 & 524288) == 0) goto L81;
        String r124 = r110.auctionId;
    L82:
        String r322 = r122;
        String r417 = r124;
        if ((r415 & 1048576) == 0) goto L85;
        long r125 = r110.auctionStatus;
    L86:
        long r418 = r125;
        if ((r415 & 2097152) == 0) goto L89;
        PromotionSubsidizedActivity r126 = r110.subsidy;
    L91:
        if ((4194304 & r415) == 0) goto L93;
        SkuBaseInfoComponent r127 = r110.skuInfo;
    L95:
        if ((r415 & 8388608) == 0) goto L97;
        boolean r108 = r110.isGroupBuying;
    L99:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r220, r317, r318, r119, r319, r320, r322, r321, r417, r418, r126, r127, r108);
    L97:
        r108 = r414;
        goto L99
    L93:
        r127 = r413;
        goto L95
    L89:
        r126 = r412;
        goto L91
    L85:
        r125 = r411;
        goto L86
    L81:
        r124 = r410;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L75
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
        goto L54
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
        return this.activityId;
    }

    public final PriceElement component10() {
        return this.discountPrice;
    }

    public final TextElement component11() {
        return this.sales;
    }

    public final long component12() {
        return this.groupId;
    }

    public final int component13() {
        return this.joined;
    }

    public final int component14() {
        return this.groupSize;
    }

    public final int component15() {
        return this.percent;
    }

    public final long component16() {
        return this.skuMinPrice;
    }

    public final long component17() {
        return this.skuMaxPrice;
    }

    public final String component18() {
        return this.rulePageUrl;
    }

    public final PriceElement component19() {
        return this.depositPrice;
    }

    public final int component2() {
        return this.activityType;
    }

    public final String component20() {
        return this.auctionId;
    }

    public final long component21() {
        return this.auctionStatus;
    }

    public final PromotionSubsidizedActivity component22() {
        return this.subsidy;
    }

    public final SkuBaseInfoComponent component23() {
        return this.skuInfo;
    }

    public final boolean component24() {
        return this.isGroupBuying;
    }

    public final TextElement component3() {
        return this.priceDesc;
    }

    public final ActivityTime component4() {
        return this.activityTime;
    }

    public final ImageModel component5() {
        return this.activityBgUrl;
    }

    public final ImageModel component6() {
        return this.activityIconImage;
    }

    public final TextElement component7() {
        return this.activityHintText;
    }

    public final PriceElement component8() {
        return this.price;
    }

    public final PriceElement component9() {
        return this.marketPrice;
    }

    public final ActivityVO copy(String r310, int r311, TextElement r312, ActivityTime r313, ImageModel r314, ImageModel r315, TextElement r316, PriceElement r317, PriceElement r318, PriceElement r410, TextElement r411, long r412, int r413, int r414, int r415, long r416, long r417, String r510, PriceElement r511, String r512, long r513, PromotionSubsidizedActivity r514, SkuBaseInfoComponent r515, boolean r516) {
        return new ActivityVO(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ActivityVO) == false) goto L54;
        ActivityVO r101 = (ActivityVO) r100;
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L8;
        return false;
    L8:
        if (this.activityType == r101.activityType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceDesc, r101.priceDesc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.activityTime, r101.activityTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activityBgUrl, r101.activityBgUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.activityIconImage, r101.activityIconImage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.activityHintText, r101.activityHintText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sales, r101.sales) == true) goto L28;
        return false;
    L28:
        if (this.groupId == r101.groupId) goto L30;
        return false;
    L30:
        if (this.joined == r101.joined) goto L32;
        return false;
    L32:
        if (this.groupSize == r101.groupSize) goto L34;
        return false;
    L34:
        if (this.percent == r101.percent) goto L36;
        return false;
    L36:
        if (this.skuMinPrice == r101.skuMinPrice) goto L38;
        return false;
    L38:
        if (this.skuMaxPrice == r101.skuMaxPrice) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.rulePageUrl, r101.rulePageUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.depositPrice, r101.depositPrice) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.auctionId, r101.auctionId) == true) goto L46;
        return false;
    L46:
        if (this.auctionStatus == r101.auctionStatus) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.subsidy, r101.subsidy) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.skuInfo, r101.skuInfo) == true) goto L52;
        return false;
    L52:
        if (this.isGroupBuying == r101.isGroupBuying) goto L82;
        return false;
    L82:
        return true;
    L54:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.activityId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.activityType) * 31;
        TextElement r104 = this.priceDesc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ActivityTime r107 = this.activityTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImageModel r110 = this.activityBgUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ImageModel r113 = this.activityIconImage;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        TextElement r116 = this.activityHintText;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        PriceElement r119 = this.price;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        PriceElement r122 = this.marketPrice;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        PriceElement r125 = this.discountPrice;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        TextElement r128 = this.sales;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        long r131 = this.groupId;
        int r132 = (((((((r130 + ((int) (r131 ^ (r131 >>> 32)))) * 31) + this.joined) * 31) + this.groupSize) * 31) + this.percent) * 31;
        long r133 = this.skuMinPrice;
        int r134 = (r132 + ((int) (r133 ^ (r133 >>> 32)))) * 31;
        long r135 = this.skuMaxPrice;
        int r136 = (r134 + ((int) (r135 ^ (r135 >>> 32)))) * 31;
        String r137 = this.rulePageUrl;
        if (r137 == null) goto L45;
        int r138 = r137.hashCode();
    L46:
        int r139 = (r136 + r138) * 31;
        PriceElement r140 = this.depositPrice;
        if (r140 == null) goto L49;
        int r141 = r140.hashCode();
    L50:
        int r142 = (r139 + r141) * 31;
        String r143 = this.auctionId;
        if (r143 == null) goto L53;
        int r144 = r143.hashCode();
    L54:
        int r145 = (r142 + r144) * 31;
        long r146 = this.auctionStatus;
        int r147 = (r145 + ((int) (r146 ^ (r146 >>> 32)))) * 31;
        PromotionSubsidizedActivity r148 = this.subsidy;
        if (r148 == null) goto L57;
        int r149 = r148.hashCode();
    L58:
        int r150 = (r147 + r149) * 31;
        SkuBaseInfoComponent r151 = this.skuInfo;
        if (r151 == null) goto L61;
        r101 = r151.hashCode();
    L61:
        int r152 = (r150 + r101) * 31;
        boolean r153 = this.isGroupBuying;
        ?? r154 = r153;
        if (r153 == false) goto L65;
        r154 = 1;
    L65:
        return r152 + r154;
    L57:
        r149 = 0;
        goto L58
    L53:
        r144 = 0;
        goto L54
    L49:
        r141 = 0;
        goto L50
    L45:
        r138 = 0;
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
        return "ActivityVO(activityId=" + this.activityId + ", activityType=" + this.activityType + ", priceDesc=" + this.priceDesc + ", activityTime=" + this.activityTime + ", activityBgUrl=" + this.activityBgUrl + ", activityIconImage=" + this.activityIconImage + ", activityHintText=" + this.activityHintText + ", price=" + this.price + ", marketPrice=" + this.marketPrice + ", discountPrice=" + this.discountPrice + ", sales=" + this.sales + ", groupId=" + this.groupId + ", joined=" + this.joined + ", groupSize=" + this.groupSize + ", percent=" + this.percent + ", skuMinPrice=" + this.skuMinPrice + ", skuMaxPrice=" + this.skuMaxPrice + ", rulePageUrl=" + this.rulePageUrl + ", depositPrice=" + this.depositPrice + ", auctionId=" + this.auctionId + ", auctionStatus=" + this.auctionStatus + ", subsidy=" + this.subsidy + ", skuInfo=" + this.skuInfo + ", isGroupBuying=" + this.isGroupBuying + ")";
    }

    public final ImageModel getActivityBgUrl() {
        return this.activityBgUrl;
    }

    public final TextElement getActivityHintText() {
        return this.activityHintText;
    }

    public final ImageModel getActivityIconImage() {
        return this.activityIconImage;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final ActivityTime getActivityTime() {
        return this.activityTime;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public final String getAuctionId() {
        return this.auctionId;
    }

    public final long getAuctionStatus() {
        return this.auctionStatus;
    }

    public final PriceElement getDepositPrice() {
        return this.depositPrice;
    }

    public final PriceElement getDiscountPrice() {
        return this.discountPrice;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final int getGroupSize() {
        return this.groupSize;
    }

    public final int getJoined() {
        return this.joined;
    }

    public final PriceElement getMarketPrice() {
        return this.marketPrice;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final PriceElement getPrice() {
        return this.price;
    }

    public final TextElement getPriceDesc() {
        return this.priceDesc;
    }

    public final String getRulePageUrl() {
        return this.rulePageUrl;
    }

    public final TextElement getSales() {
        return this.sales;
    }

    public final SkuBaseInfoComponent getSkuInfo() {
        return this.skuInfo;
    }

    public final long getSkuMaxPrice() {
        return this.skuMaxPrice;
    }

    public final long getSkuMinPrice() {
        return this.skuMinPrice;
    }

    public final PromotionSubsidizedActivity getSubsidy() {
        return this.subsidy;
    }

    public final boolean isGroupBuying() {
        return this.isGroupBuying;
    }

    public ActivityVO(String r100, int r101, TextElement r102, ActivityTime r103, ImageModel r104, ImageModel r105, TextElement r110, PriceElement r111, PriceElement r112, PriceElement r113, TextElement r114, long r115, int r116, int r117, int r118, long r210, long r211, String r212, PriceElement r213, String r214, long r215, PromotionSubsidizedActivity r216, SkuBaseInfoComponent r310, boolean r311) {
        this.activityId = r100;
        this.activityType = r101;
        this.priceDesc = r102;
        this.activityTime = r103;
        this.activityBgUrl = r104;
        this.activityIconImage = r105;
        this.activityHintText = r110;
        this.price = r111;
        this.marketPrice = r112;
        this.discountPrice = r113;
        this.sales = r114;
        this.groupId = r115;
        this.joined = r116;
        this.groupSize = r117;
        this.percent = r118;
        this.skuMinPrice = r210;
        this.skuMaxPrice = r211;
        this.rulePageUrl = r212;
        this.depositPrice = r213;
        this.auctionId = r214;
        this.auctionStatus = r215;
        this.subsidy = r216;
        this.skuInfo = r310;
        this.isGroupBuying = r311;
    }

    public /* synthetic */ ActivityVO(String r310, int r311, TextElement r312, ActivityTime r313, ImageModel r314, ImageModel r315, TextElement r316, PriceElement r317, PriceElement r318, PriceElement r319, TextElement r410, long r411, int r412, int r413, int r414, long r415, long r416, String r510, PriceElement r511, String r512, long r513, PromotionSubsidizedActivity r514, SkuBaseInfoComponent r515, boolean r516, int r517, DefaultConstructorMarker r518) {
        if ((r517 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r517 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r517 & 4) == 0) goto L13;
        TextElement r102 = null;
    L15:
        if ((r517 & 8) == 0) goto L17;
        ActivityTime r103 = null;
    L19:
        if ((r517 & 16) == 0) goto L21;
        ImageModel r104 = null;
    L23:
        if ((r517 & 32) == 0) goto L25;
        ImageModel r105 = null;
    L27:
        if ((r517 & 64) == 0) goto L29;
        TextElement r106 = null;
    L31:
        if ((r517 & 128) == 0) goto L33;
        PriceElement r110 = null;
    L35:
        if ((r517 & 256) == 0) goto L37;
        PriceElement r111 = null;
    L39:
        if ((r517 & 512) == 0) goto L41;
        PriceElement r112 = null;
    L43:
        if ((r517 & 1024) == 0) goto L45;
        TextElement r113 = null;
    L46:
        long r114 = 0;
        if ((r517 & 2048) == 0) goto L49;
        long r115 = 0;
    L51:
        if ((r517 & 4096) == 0) goto L53;
        int r116 = 0;
    L55:
        if ((r517 & 8192) == 0) goto L57;
        int r107 = 0;
    L59:
        if ((r517 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r517 & 32768) == 0) goto L65;
        long r117 = 0;
    L67:
        if ((r517 & 65536) == 0) goto L69;
        long r210 = 0;
    L71:
        if ((r517 & 131072) == 0) goto L73;
        String r211 = null;
    L75:
        if ((r517 & 262144) == 0) goto L77;
        PriceElement r212 = null;
    L79:
        if ((r517 & 524288) == 0) goto L81;
        String r213 = null;
    L83:
        if ((r517 & 1048576) != 0) goto L87;
        r114 = r513;
    L87:
        if ((r517 & 2097152) == 0) goto L89;
        PromotionSubsidizedActivity r214 = null;
    L91:
        if ((r517 & 4194304) == 0) goto L93;
        SkuBaseInfoComponent r215 = null;
    L95:
        if ((r517 & 8388608) == 0) goto L97;
        boolean r109 = false;
    L98:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r115, r116, r107, r108, r117, r210, r211, r212, r213, r114, r214, r215, r109);
        return;
    L97:
        r109 = r516;
        goto L98
    L93:
        r215 = r515;
        goto L95
    L89:
        r214 = r514;
        goto L91
    L81:
        r213 = r512;
        goto L83
    L77:
        r212 = r511;
        goto L79
    L73:
        r211 = r510;
        goto L75
    L69:
        r210 = r416;
        goto L71
    L65:
        r117 = r415;
        goto L67
    L61:
        r108 = r414;
        goto L63
    L57:
        r107 = r413;
        goto L59
    L53:
        r116 = r412;
        goto L55
    L49:
        r115 = r411;
        goto L51
    L45:
        r113 = r410;
        goto L46
    L41:
        r112 = r319;
        goto L43
    L37:
        r111 = r318;
        goto L39
    L33:
        r110 = r317;
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
