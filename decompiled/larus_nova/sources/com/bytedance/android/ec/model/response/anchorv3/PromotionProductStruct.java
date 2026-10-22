package com.bytedance.android.ec.model.response.anchorv3;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\bI\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001Bç\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020,\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010.\u001a\u00020,\u0012\b\b\u0002\u0010/\u001a\u00020,\u0012\b\b\u0002\u00100\u001a\u00020,\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u00102\u001a\u00020,\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0019\u0012\u0016\b\u0002\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u000105¢\u0006\u0002\u00106J\u0013\u0010}\u001a\u00020,2\b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0096\u0002J\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u0007\u0010\u0082\u0001\u001a\u00020,J\u0007\u0010\u0083\u0001\u001a\u00020,J\u0007\u0010\u0084\u0001\u001a\u00020,J\u0007\u0010\u0085\u0001\u001a\u00020,J\n\u0010\u0086\u0001\u001a\u00030\u0081\u0001H\u0016J\u0007\u0010\u0087\u0001\u001a\u00020,J\u0007\u0010\u0088\u0001\u001a\u00020,J\u0007\u0010\u0089\u0001\u001a\u00020,J\u0007\u0010\u008a\u0001\u001a\u00020,J\u0007\u0010\u008b\u0001\u001a\u00020,J\u0007\u0010\u008c\u0001\u001a\u00020,J\u0007\u0010\u008d\u0001\u001a\u00020,J\u0007\u0010\u008e\u0001\u001a\u00020,J\u0007\u0010\u008f\u0001\u001a\u00020,J\u0007\u0010\u0090\u0001\u001a\u00020,R\u001c\u00101\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR&\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001c\u00103\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0018\u0010)\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001a\u0010.\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010]\"\u0004\b^\u0010_R\u001a\u00102\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010]\"\u0004\b`\u0010_R\u001a\u0010/\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010]\"\u0004\ba\u0010_R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010]\"\u0004\bb\u0010_R\u001a\u00100\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010]\"\u0004\bc\u0010_R\u001a\u0010-\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010]\"\u0004\bd\u0010_R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00108\"\u0004\bf\u0010:R\u0018\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0018\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|¨\u0006\u0091\u0001"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "Ljava/io/Serializable;", "baseInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBaseStruct;", "privilegeInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesStruct;", "commentInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentsStruct;", "entryInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAuthorEntriesStruct;", "pageComsConfig", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPageConfigStruct;", "extraInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductExtraStruct;", "hotsoon", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductHotsoonStruct;", "addressInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct;", "productPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;", "productPriceV2", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStructV2;", "innerflowSchema", "Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowSchema;", "link", "", "buyButtonInfos", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;", "customButton", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCustomButtonStruct;", "bizProcess", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBizProcessStruct;", "poiInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPoiInfoStruct;", "videoComponentInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorGoodsVideoComponent;", "smallVideoWindowComponentInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/SmallWindowVideoComponent;", "newbeeChannelInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeChannelComponent;", "homeMallStruct", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionHomeMallStruct;", "isOnlyHeadImg", "", "isUseAnchorInfo", "isForceRefreshExchangeCouponTips", "isForceRefreshHeadCard", "isPreload", "activityLabel", "isForceRefreshGoodPriceStrip", "goodPriceStripData", "goodPriceStripLogExtra", "", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBaseStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentsStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAuthorEntriesStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPageConfigStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductExtraStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductHotsoonStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStructV2;Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowSchema;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCustomButtonStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBizProcessStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPoiInfoStruct;Lcom/bytedance/android/ec/model/response/anchorv3/AuthorGoodsVideoComponent;Lcom/bytedance/android/ec/model/response/anchorv3/SmallWindowVideoComponent;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeChannelComponent;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionHomeMallStruct;ZZZZZLjava/lang/String;ZLjava/lang/String;Ljava/util/Map;)V", "getActivityLabel", "()Ljava/lang/String;", "setActivityLabel", "(Ljava/lang/String;)V", "getAddressInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct;", "getBaseInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBaseStruct;", "setBaseInfo", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBaseStruct;)V", "getBizProcess", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBizProcessStruct;", "setBizProcess", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBizProcessStruct;)V", "getBuyButtonInfos", "()Ljava/util/List;", "setBuyButtonInfos", "(Ljava/util/List;)V", "getCommentInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentsStruct;", "getCustomButton", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCustomButtonStruct;", "getEntryInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAuthorEntriesStruct;", "getExtraInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductExtraStruct;", "getGoodPriceStripData", "setGoodPriceStripData", "getGoodPriceStripLogExtra", "()Ljava/util/Map;", "setGoodPriceStripLogExtra", "(Ljava/util/Map;)V", "getHomeMallStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionHomeMallStruct;", "getHotsoon", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductHotsoonStruct;", "getInnerflowSchema", "()Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowSchema;", "()Z", "setForceRefreshExchangeCouponTips", "(Z)V", "setForceRefreshGoodPriceStrip", "setForceRefreshHeadCard", "setOnlyHeadImg", "setPreload", "setUseAnchorInfo", "getLink", "setLink", "getNewbeeChannelInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeChannelComponent;", "getPageComsConfig", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPageConfigStruct;", "setPageComsConfig", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPageConfigStruct;)V", "getPoiInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPoiInfoStruct;", "getPrivilegeInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrivilegesStruct;", "getProductPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;", "setProductPrice", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStruct;)V", "getProductPriceV2", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStructV2;", "setProductPriceV2", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPriceStructV2;)V", "getSmallVideoWindowComponentInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/SmallWindowVideoComponent;", "getVideoComponentInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorGoodsVideoComponent;", "equals", "other", "", "getCartProductCount", "", "hasCoupon", "hasPlatformActivity", "hasPlatformDiscountCoupon", "hasSecKillActivity", "hashCode", "isApiBack", "isInGroupActivity", "isInGroupOrNGroupActivity", "isInSecKillActivity", "isInited", "isSelfGood", "isShowDiscount", "isShowInstallmentDiscountInfo", "isThirdParty", "isVirtualGood", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class PromotionProductStruct implements Serializable {
    private String activityLabel;

    @SerializedName("address_info")
    private final PromotionProductAddressStruct addressInfo;

    @SerializedName("base_info")
    private PromotionProductBaseStruct baseInfo;

    @SerializedName("biz_process")
    private PromotionBizProcessStruct bizProcess;

    @SerializedName("buy_buttons")
    private List<PromotionProductButtonStruct> buyButtonInfos;

    @SerializedName("comment_info")
    private final PromotionProductCommentsStruct commentInfo;

    @SerializedName("custom_biz_button")
    private final PromotionCustomButtonStruct customButton;

    @SerializedName("entry_info")
    private final PromotionProductAuthorEntriesStruct entryInfo;

    @SerializedName("extra_info")
    private final PromotionProductExtraStruct extraInfo;
    private String goodPriceStripData;
    private Map<String, String> goodPriceStripLogExtra;

    @SerializedName("home_mall")
    private final PromotionHomeMallStruct homeMallStruct;

    @SerializedName("hotsoon")
    private final PromotionProductHotsoonStruct hotsoon;

    @SerializedName("inner_flow_schema")
    private final InnerFlowSchema innerflowSchema;
    private boolean isForceRefreshExchangeCouponTips;
    private boolean isForceRefreshGoodPriceStrip;
    private boolean isForceRefreshHeadCard;
    private boolean isOnlyHeadImg;
    private boolean isPreload;
    private boolean isUseAnchorInfo;

    @SerializedName("link")
    private String link;

    @SerializedName("resource_location")
    private final PromotionNewbeeChannelComponent newbeeChannelInfo;

    @SerializedName("page_coms_config")
    private PromotionProductPageConfigStruct pageComsConfig;

    @SerializedName("poi_info")
    private final PromotionPoiInfoStruct poiInfo;

    @SerializedName("privilege_info")
    private final PromotionProductPrivilegesStruct privilegeInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_PRICE)
    private PromotionProductPriceStruct productPrice;

    @SerializedName("product_price_v2")
    private PromotionProductPriceStructV2 productPriceV2;

    @SerializedName("small_window_video_component")
    private final SmallWindowVideoComponent smallVideoWindowComponentInfo;

    @SerializedName("good_goods_video_component")
    private final AuthorGoodsVideoComponent videoComponentInfo;

    public PromotionProductStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, false, null, false, null, null, 536870911, null);
    }

    public final int getCartProductCount() {
        PromotionProductExtraStruct r100 = this.extraInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCartNum();
    }

    public final boolean hasCoupon() {
        PromotionProductExtraStruct r100 = this.extraInfo;
        if (r100 == null) goto L9;
        PromotionProductButtonStruct r101 = r100.getBuyButton();
        if (r101 == null) goto L9;
        Integer r102 = r101.getCouponAmount();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L11:
        if (r103 > 0) goto L39;
        PromotionProductPrivilegesStruct r104 = this.privilegeInfo;
        List<PromotionDiscountLabel> r105 = null;
        if (r104 == null) goto L17;
        PromotionProductCouponsStruct r106 = r104.getCoupons();
        if (r106 == null) goto L17;
        List<String> r107 = r106.getCouponMetaLabels();
    L18:
        List<String> r108 = r107;
        if (r108 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L39;
        PromotionProductPrivilegesStruct r110 = this.privilegeInfo;
        if (r110 == null) goto L31;
        PromotionProductCouponsStruct r111 = r110.getCoupons();
        if (r111 == null) goto L31;
        r105 = r111.getDiscountLabels();
    L31:
        List<PromotionDiscountLabel> r112 = r105;
        if (r112 != null) goto L34;
    L37:
        boolean r113 = true;
    L38:
        if (r113 == false) goto L39;
        return false;
    L34:
        if (r112.isEmpty() == true) goto L37;
        r113 = false;
        goto L38
    L21:
        if (r108.isEmpty() == true) goto L24;
        r109 = false;
    L17:
        r107 = null;
    L39:
        return true;
    L9:
        r103 = 0;
        goto L11
    }

    public final boolean hasPlatformActivity() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L9;
        PromotionProductActivitiesStruct r101 = r100.getActivities();
        if (r101 == null) goto L9;
        PromotionMarketFloor r102 = r101.getPlatformTextActivity();
        if (r102 == null) goto L9;
        ECUrlModel r103 = r102.getIcon();
    L10:
        if (r103 == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        r103 = null;
        goto L10
    }

    public final boolean hasPlatformDiscountCoupon() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L21;
        PromotionProductCouponsStruct r101 = r100.getCoupons();
        if (r101 == null) goto L21;
        List<PromotionDiscountLabel> r102 = r101.getDiscountLabels();
        if (r102 == null) goto L21;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if (((PromotionDiscountLabel) r104).getType() != 3) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L10;
    L19:
        if (((PromotionDiscountLabel) r104) == null) goto L21;
        return true;
    L14:
        r105 = false;
        goto L15
    L17:
        r104 = null;
    L21:
        return false;
    }

    public final boolean hasSecKillActivity() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L10;
        PromotionProductActivitiesStruct r101 = r100.getActivities();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getSecKillActivity() == null) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public final boolean isApiBack() {
        if (this.isOnlyHeadImg == false) goto L5;
    L7:
        return false;
    L5:
        if (this.isUseAnchorInfo == true) goto L7;
        return true;
    }

    public final boolean isInGroupActivity() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L9;
        PromotionProductActivitiesStruct r101 = r100.getActivities();
        if (r101 == null) goto L9;
        GroupInfo r102 = r101.getGroupInfoActivity();
        if (r102 == null) goto L9;
        return r102.isInGroup();
    L9:
        return false;
    }

    public final boolean isInGroupOrNGroupActivity() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L9;
        PromotionProductActivitiesStruct r101 = r100.getActivities();
        if (r101 == null) goto L9;
        GroupInfo r102 = r101.getGroupInfoActivity();
        if (r102 == null) goto L9;
        boolean r103 = r102.isInGroup();
    L10:
        if (r103 == true) goto L20;
        PromotionProductPrivilegesStruct r104 = this.privilegeInfo;
        if (r104 == null) goto L18;
        PromotionProductActivitiesStruct r105 = r104.getActivities();
        if (r105 == null) goto L18;
        GroupInfo r106 = r105.getNGroupInfoActivity();
        if (r106 == null) goto L18;
        boolean r107 = r106.isInGroup();
    L19:
        if (r107 == true) goto L20;
        return false;
    L18:
        r107 = false;
    L20:
        return true;
    L9:
        r103 = false;
        goto L10
    }

    public final boolean isInSecKillActivity() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L9;
        PromotionProductActivitiesStruct r101 = r100.getActivities();
        if (r101 == null) goto L9;
        SeckillInfo r102 = r101.getSecKillActivity();
        if (r102 == null) goto L9;
        return r102.isInSecKill();
    L9:
        return false;
    }

    public final boolean isInited() {
        if (this.baseInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSelfGood() {
        SourceType.a r100 = SourceType.Companion;
        PromotionProductBaseStruct r101 = this.baseInfo;
        if (r101 == null) goto L7;
        Integer r102 = r101.getPromotionSource();
        if (r102 == null) goto L7;
        long r103 = r102.intValue();
    L8:
        r100.getClass();
        return SourceType.a.c(r103);
    L7:
        r103 = 0;
        goto L8
    }

    public final boolean isShowDiscount() {
        PromotionProductPageConfigStruct r100 = this.pageComsConfig;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getDisplayDiscount();
    }

    public final boolean isShowInstallmentDiscountInfo() {
        PromotionProductPrivilegesStruct r100 = this.privilegeInfo;
        if (r100 == null) goto L9;
        PromotionProductInstallmentStruct r101 = r100.getInstallment();
        if (r101 == null) goto L9;
        PromotionDiscountInfo r102 = r101.getMPromotionDiscountInfo();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getShowFlag();
    L11:
        return Intrinsics.areEqual(r103, Boolean.TRUE);
    L9:
        r103 = null;
        goto L11
    }

    public final boolean isThirdParty() {
        SourceType.a r100 = SourceType.Companion;
        PromotionProductBaseStruct r101 = this.baseInfo;
        if (r101 == null) goto L7;
        Integer r102 = r101.getPromotionSource();
        if (r102 == null) goto L7;
        long r103 = r102.intValue();
    L8:
        r100.getClass();
        return SourceType.a.e(r103);
    L7:
        r103 = 0;
        goto L8
    }

    public final boolean isVirtualGood() {
        PromotionProductExtraStruct r100 = this.extraInfo;
        if (r100 == null) goto L7;
        Boolean r101 = r100.isVirtualProduct();
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final String getActivityLabel() {
        return this.activityLabel;
    }

    public final PromotionProductAddressStruct getAddressInfo() {
        return this.addressInfo;
    }

    public final PromotionProductBaseStruct getBaseInfo() {
        return this.baseInfo;
    }

    public final PromotionBizProcessStruct getBizProcess() {
        return this.bizProcess;
    }

    public final List<PromotionProductButtonStruct> getBuyButtonInfos() {
        return this.buyButtonInfos;
    }

    public final PromotionProductCommentsStruct getCommentInfo() {
        return this.commentInfo;
    }

    public final PromotionCustomButtonStruct getCustomButton() {
        return this.customButton;
    }

    public final PromotionProductAuthorEntriesStruct getEntryInfo() {
        return this.entryInfo;
    }

    public final PromotionProductExtraStruct getExtraInfo() {
        return this.extraInfo;
    }

    public final String getGoodPriceStripData() {
        return this.goodPriceStripData;
    }

    public final Map<String, String> getGoodPriceStripLogExtra() {
        return this.goodPriceStripLogExtra;
    }

    public final PromotionHomeMallStruct getHomeMallStruct() {
        return this.homeMallStruct;
    }

    public final PromotionProductHotsoonStruct getHotsoon() {
        return this.hotsoon;
    }

    public final InnerFlowSchema getInnerflowSchema() {
        return this.innerflowSchema;
    }

    public final String getLink() {
        return this.link;
    }

    public final PromotionNewbeeChannelComponent getNewbeeChannelInfo() {
        return this.newbeeChannelInfo;
    }

    public final PromotionProductPageConfigStruct getPageComsConfig() {
        return this.pageComsConfig;
    }

    public final PromotionPoiInfoStruct getPoiInfo() {
        return this.poiInfo;
    }

    public final PromotionProductPrivilegesStruct getPrivilegeInfo() {
        return this.privilegeInfo;
    }

    public final PromotionProductPriceStruct getProductPrice() {
        return this.productPrice;
    }

    public final PromotionProductPriceStructV2 getProductPriceV2() {
        return this.productPriceV2;
    }

    public final SmallWindowVideoComponent getSmallVideoWindowComponentInfo() {
        return this.smallVideoWindowComponentInfo;
    }

    public final AuthorGoodsVideoComponent getVideoComponentInfo() {
        return this.videoComponentInfo;
    }

    public final boolean isForceRefreshExchangeCouponTips() {
        return this.isForceRefreshExchangeCouponTips;
    }

    public final boolean isForceRefreshGoodPriceStrip() {
        return this.isForceRefreshGoodPriceStrip;
    }

    public final boolean isForceRefreshHeadCard() {
        return this.isForceRefreshHeadCard;
    }

    public final boolean isOnlyHeadImg() {
        return this.isOnlyHeadImg;
    }

    public final boolean isPreload() {
        return this.isPreload;
    }

    public final boolean isUseAnchorInfo() {
        return this.isUseAnchorInfo;
    }

    public boolean equals(Object r100) {
        if (this.isForceRefreshExchangeCouponTips == false) goto L5;
    L8:
        return false;
    L5:
        if (this.isForceRefreshHeadCard == true) goto L8;
        return super.equals(r100);
    }

    public final void setActivityLabel(String r100) {
        this.activityLabel = r100;
    }

    public final void setBaseInfo(PromotionProductBaseStruct r100) {
        this.baseInfo = r100;
    }

    public final void setBizProcess(PromotionBizProcessStruct r100) {
        this.bizProcess = r100;
    }

    public final void setBuyButtonInfos(List<PromotionProductButtonStruct> r100) {
        this.buyButtonInfos = r100;
    }

    public final void setForceRefreshExchangeCouponTips(boolean r100) {
        this.isForceRefreshExchangeCouponTips = r100;
    }

    public final void setForceRefreshGoodPriceStrip(boolean r100) {
        this.isForceRefreshGoodPriceStrip = r100;
    }

    public final void setForceRefreshHeadCard(boolean r100) {
        this.isForceRefreshHeadCard = r100;
    }

    public final void setGoodPriceStripData(String r100) {
        this.goodPriceStripData = r100;
    }

    public final void setGoodPriceStripLogExtra(Map<String, String> r100) {
        this.goodPriceStripLogExtra = r100;
    }

    public final void setLink(String r100) {
        this.link = r100;
    }

    public final void setOnlyHeadImg(boolean r100) {
        this.isOnlyHeadImg = r100;
    }

    public final void setPageComsConfig(PromotionProductPageConfigStruct r100) {
        this.pageComsConfig = r100;
    }

    public final void setPreload(boolean r100) {
        this.isPreload = r100;
    }

    public final void setProductPrice(PromotionProductPriceStruct r100) {
        this.productPrice = r100;
    }

    public final void setProductPriceV2(PromotionProductPriceStructV2 r100) {
        this.productPriceV2 = r100;
    }

    public final void setUseAnchorInfo(boolean r100) {
        this.isUseAnchorInfo = r100;
    }

    public PromotionProductStruct(PromotionProductBaseStruct r100, PromotionProductPrivilegesStruct r101, PromotionProductCommentsStruct r102, PromotionProductAuthorEntriesStruct r103, PromotionProductPageConfigStruct r104, PromotionProductExtraStruct r105, PromotionProductHotsoonStruct r106, PromotionProductAddressStruct r110, PromotionProductPriceStruct r111, PromotionProductPriceStructV2 r112, InnerFlowSchema r113, String r114, List<PromotionProductButtonStruct> r115, PromotionCustomButtonStruct r116, PromotionBizProcessStruct r117, PromotionPoiInfoStruct r118, AuthorGoodsVideoComponent r119, SmallWindowVideoComponent r210, PromotionNewbeeChannelComponent r211, PromotionHomeMallStruct r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, String r218, boolean r219, String r310, Map<String, String> r311) {
        this.baseInfo = r100;
        this.privilegeInfo = r101;
        this.commentInfo = r102;
        this.entryInfo = r103;
        this.pageComsConfig = r104;
        this.extraInfo = r105;
        this.hotsoon = r106;
        this.addressInfo = r110;
        this.productPrice = r111;
        this.productPriceV2 = r112;
        this.innerflowSchema = r113;
        this.link = r114;
        this.buyButtonInfos = r115;
        this.customButton = r116;
        this.bizProcess = r117;
        this.poiInfo = r118;
        this.videoComponentInfo = r119;
        this.smallVideoWindowComponentInfo = r210;
        this.newbeeChannelInfo = r211;
        this.homeMallStruct = r212;
        this.isOnlyHeadImg = r213;
        this.isUseAnchorInfo = r214;
        this.isForceRefreshExchangeCouponTips = r215;
        this.isForceRefreshHeadCard = r216;
        this.isPreload = r217;
        this.activityLabel = r218;
        this.isForceRefreshGoodPriceStrip = r219;
        this.goodPriceStripData = r310;
        this.goodPriceStripLogExtra = r311;
    }

    public /* synthetic */ PromotionProductStruct(PromotionProductBaseStruct r310, PromotionProductPrivilegesStruct r311, PromotionProductCommentsStruct r312, PromotionProductAuthorEntriesStruct r313, PromotionProductPageConfigStruct r314, PromotionProductExtraStruct r315, PromotionProductHotsoonStruct r316, PromotionProductAddressStruct r317, PromotionProductPriceStruct r318, PromotionProductPriceStructV2 r410, InnerFlowSchema r411, String r412, List r413, PromotionCustomButtonStruct r414, PromotionBizProcessStruct r415, PromotionPoiInfoStruct r416, AuthorGoodsVideoComponent r417, SmallWindowVideoComponent r418, PromotionNewbeeChannelComponent r419, PromotionHomeMallStruct r510, boolean r511, boolean r512, boolean r513, boolean r514, boolean r515, String r516, boolean r517, String r518, Map r519, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        PromotionProductBaseStruct r100 = null;
    L7:
        if ((r610 & 2) == 0) goto L9;
        PromotionProductPrivilegesStruct r101 = null;
    L11:
        if ((r610 & 4) == 0) goto L13;
        PromotionProductCommentsStruct r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        PromotionProductAuthorEntriesStruct r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        PromotionProductPageConfigStruct r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        PromotionProductExtraStruct r105 = null;
    L27:
        if ((r610 & 64) == 0) goto L29;
        PromotionProductHotsoonStruct r106 = null;
    L31:
        if ((r610 & 128) == 0) goto L33;
        PromotionProductAddressStruct r107 = null;
    L35:
        if ((r610 & 256) == 0) goto L37;
        PromotionProductPriceStruct r110 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        PromotionProductPriceStructV2 r111 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        InnerFlowSchema r112 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        List r114 = null;
    L55:
        if ((r610 & 8192) == 0) goto L57;
        PromotionCustomButtonStruct r115 = null;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        PromotionBizProcessStruct r108 = null;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        PromotionPoiInfoStruct r116 = null;
    L67:
        if ((r610 & 65536) == 0) goto L69;
        AuthorGoodsVideoComponent r117 = null;
    L71:
        if ((r610 & 131072) == 0) goto L73;
        SmallWindowVideoComponent r118 = null;
    L75:
        if ((r610 & 262144) == 0) goto L77;
        PromotionNewbeeChannelComponent r119 = null;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        PromotionHomeMallStruct r210 = null;
    L82:
        boolean r211 = false;
        if ((r610 & 1048576) == 0) goto L85;
        boolean r212 = false;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        boolean r213 = false;
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        boolean r214 = false;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        boolean r215 = false;
    L99:
        if ((r610 & 16777216) == 0) goto L101;
        boolean r216 = false;
    L103:
        if ((r610 & 33554432) == 0) goto L105;
        String r217 = null;
    L107:
        if ((r610 & 67108864) != 0) goto L111;
        r211 = r517;
    L111:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r218 = null;
    L115:
        if ((r610 & 268435456) == 0) goto L117;
        Map r109 = null;
    L118:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r212, r213, r214, r215, r216, r217, r211, r218, r109);
        return;
    L117:
        r109 = r519;
        goto L118
    L113:
        r218 = r518;
        goto L115
    L105:
        r217 = r516;
        goto L107
    L101:
        r216 = r515;
        goto L103
    L97:
        r215 = r514;
        goto L99
    L93:
        r214 = r513;
        goto L95
    L89:
        r213 = r512;
        goto L91
    L85:
        r212 = r511;
        goto L87
    L81:
        r210 = r510;
        goto L82
    L77:
        r119 = r419;
        goto L79
    L73:
        r118 = r418;
        goto L75
    L69:
        r117 = r417;
        goto L71
    L65:
        r116 = r416;
        goto L67
    L61:
        r108 = r415;
        goto L63
    L57:
        r115 = r414;
        goto L59
    L53:
        r114 = r413;
        goto L55
    L49:
        r113 = r412;
        goto L51
    L45:
        r112 = r411;
        goto L47
    L41:
        r111 = r410;
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
