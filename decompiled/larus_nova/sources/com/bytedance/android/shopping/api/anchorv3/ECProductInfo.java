package com.bytedance.android.shopping.api.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b)\u0018\u00002\u00020\u0001B\u0097\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001fR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010*R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b0\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u001a\u00104R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u001e\u00104R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010-\u001a\u0004\b7\u0010,R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010!R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b?\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010!¨\u0006D"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECProductInfo;", "Ljava/io/Serializable;", "currentPromotionId", "", "productId", "rankId", "promotionIds", "", "commodityType", "", "headImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "frameCovImage", "shopId", "promotionSource", "status", "", "title", "salesNum", "price", "frontCategoryId", "frontCategoryName", "firstCategoryId", "firstCategoryName", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "isDirectSubmitOrder", "", "bizCampaignType", "nGroupBuyToken", "isOptCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBizCampaignType", "()Ljava/lang/String;", "getChannelId", "getChannelType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCommodityType", "()J", "getCurrentPromotionId", "setCurrentPromotionId", "(Ljava/lang/String;)V", "getFirstCategoryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFirstCategoryName", "getFrameCovImage", "getFrontCategoryId", "getFrontCategoryName", "getHeadImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNGroupBuyToken", "getPrice", "getProductId", "getPromotionIds", "()Ljava/util/List;", "setPromotionIds", "(Ljava/util/List;)V", "getPromotionSource", "getRankId", "getSalesNum", "getShopId", "getStatus", "()I", "getTitle", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECProductInfo implements Serializable {
    private final String bizCampaignType;
    private final String channelId;
    private final Integer channelType;
    private final long commodityType;
    private String currentPromotionId;
    private final Long firstCategoryId;
    private final String firstCategoryName;
    private final String frameCovImage;
    private final Long frontCategoryId;
    private final String frontCategoryName;
    private final ECUrlModel headImg;
    private final Boolean isDirectSubmitOrder;
    private final Boolean isOptCode;
    private final String nGroupBuyToken;
    private final Long price;
    private final String productId;
    private List<String> promotionIds;
    private final long promotionSource;
    private final String rankId;
    private final Integer salesNum;
    private final String shopId;
    private final int status;
    private final String title;

    public ECProductInfo() {
        this(null, null, null, null, 0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final long getCommodityType() {
        return this.commodityType;
    }

    public final String getCurrentPromotionId() {
        return this.currentPromotionId;
    }

    public final Long getFirstCategoryId() {
        return this.firstCategoryId;
    }

    public final String getFirstCategoryName() {
        return this.firstCategoryName;
    }

    public final String getFrameCovImage() {
        return this.frameCovImage;
    }

    public final Long getFrontCategoryId() {
        return this.frontCategoryId;
    }

    public final String getFrontCategoryName() {
        return this.frontCategoryName;
    }

    public final ECUrlModel getHeadImg() {
        return this.headImg;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<String> getPromotionIds() {
        return this.promotionIds;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final Integer getSalesNum() {
        return this.salesNum;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isDirectSubmitOrder() {
        return this.isDirectSubmitOrder;
    }

    public final Boolean isOptCode() {
        return this.isOptCode;
    }

    public final void setCurrentPromotionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentPromotionId = r100;
    }

    public final void setPromotionIds(List<String> r100) {
        this.promotionIds = r100;
    }

    public ECProductInfo(String r100, String r101, String r102, List<String> r103, long r104, ECUrlModel r110, String r111, String r112, long r113, int r114, String r115, Integer r116, Long r117, Long r118, String r210, Long r211, String r212, String r213, Integer r214, Boolean r215, String r216, String r217, Boolean r218) {
        Intrinsics.checkNotNullParameter(r100, "currentPromotionId");
        this.currentPromotionId = r100;
        this.productId = r101;
        this.rankId = r102;
        this.promotionIds = r103;
        this.commodityType = r104;
        this.headImg = r110;
        this.frameCovImage = r111;
        this.shopId = r112;
        this.promotionSource = r113;
        this.status = r114;
        this.title = r115;
        this.salesNum = r116;
        this.price = r117;
        this.frontCategoryId = r118;
        this.frontCategoryName = r210;
        this.firstCategoryId = r211;
        this.firstCategoryName = r212;
        this.channelId = r213;
        this.channelType = r214;
        this.isDirectSubmitOrder = r215;
        this.bizCampaignType = r216;
        this.nGroupBuyToken = r217;
        this.isOptCode = r218;
    }

    public /* synthetic */ ECProductInfo(String r210, String r211, String r212, List r213, long r310, ECUrlModel r311, String r312, String r313, long r314, int r315, String r316, Integer r317, Long r410, Long r411, String r412, Long r413, String r414, String r415, Integer r416, Boolean r417, String r418, String r419, Boolean r510, int r511, DefaultConstructorMarker r512) {
        if ((r511 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r511 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r511 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r511 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r511 & 16) == 0) goto L21;
        long r104 = 0;
    L23:
        if ((r511 & 32) == 0) goto L25;
        ECUrlModel r105 = null;
    L27:
        if ((r511 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r511 & 128) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r511 & 256) == 0) goto L37;
        long r112 = SourceType.UNKNOWN.getType();
    L39:
        if ((r511 & 512) == 0) goto L41;
        int r113 = 1;
    L43:
        if ((r511 & 1024) == 0) goto L45;
        String r106 = null;
    L47:
        if ((r511 & 2048) == 0) goto L49;
        Integer r107 = 0;
    L51:
        if ((r511 & 4096) == 0) goto L53;
        Long r108 = 0L;
    L54:
        Long r513 = r108;
        if ((r511 & 8192) == 0) goto L57;
        Long r109 = null;
    L58:
        Long r114 = r109;
        if ((r511 & 16384) == 0) goto L61;
        String r115 = null;
    L63:
        if ((r511 & 32768) == 0) goto L65;
        Long r116 = null;
    L67:
        if ((r511 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r511 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r511 & 262144) == 0) goto L77;
        Integer r214 = 0;
    L79:
        if ((r511 & 524288) == 0) goto L81;
        Boolean r215 = Boolean.FALSE;
    L83:
        if ((r511 & 1048576) == 0) goto L85;
        String r216 = null;
    L87:
        if ((r511 & 2097152) == 0) goto L89;
        String r217 = null;
    L91:
        if ((r511 & 4194304) == 0) goto L93;
        Boolean r119 = Boolean.FALSE;
    L94:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r513, r114, r115, r116, r117, r118, r214, r215, r216, r217, r119);
        return;
    L93:
        r119 = r510;
        goto L94
    L89:
        r217 = r419;
        goto L91
    L85:
        r216 = r418;
        goto L87
    L81:
        r215 = r417;
        goto L83
    L77:
        r214 = r416;
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
        r115 = r412;
        goto L63
    L57:
        r109 = r411;
        goto L58
    L53:
        r108 = r410;
        goto L54
    L49:
        r107 = r317;
        goto L51
    L45:
        r106 = r316;
        goto L47
    L41:
        r113 = r315;
        goto L43
    L37:
        r112 = r314;
        goto L39
    L33:
        r111 = r313;
        goto L35
    L29:
        r110 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
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
