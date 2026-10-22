package com.bytedance.android.shopping.sameproduct.model;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\"\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010&R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010,R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010,R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010!R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010!¨\u0006@"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/model/SameProductPageParams;", "Ljava/io/Serializable;", "mainProductId", "", "mainPromotionId", "mainProductIsValid", "", "sameProductStyle", "", "isFromFlowGuessULike", "isFullScreenFlowPage", "authorId", "secAuthorId", "userId", "secUserId", "videoId", "shopId", "enterFrom", "followStatus", "ecomEntranceForm", "metaParams", "entranceInfo", "requestAdditions", "v3EventsAdditions", "isReceptor", "mainCardRequestParam", "Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "mainProductRequestId", "mainProductRecommendInfo", "filterProductIds", "", "(Ljava/lang/String;Ljava/lang/String;ZIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuthorId", "()Ljava/lang/String;", "getEcomEntranceForm", "getEnterFrom", "getEntranceInfo", "setEntranceInfo", "(Ljava/lang/String;)V", "getFilterProductIds", "()Ljava/util/List;", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getMainCardRequestParam", "()Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "setMainCardRequestParam", "(Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;)V", "getMainProductId", "getMainProductIsValid", "getMainProductRecommendInfo", "getMainProductRequestId", "getMainPromotionId", "getMetaParams", "getRequestAdditions", "getSameProductStyle", "()I", "getSecAuthorId", "getSecUserId", "getShopId", "getUserId", "getV3EventsAdditions", "getVideoId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductPageParams implements Serializable {
    private final String authorId;
    private final String ecomEntranceForm;
    private final String enterFrom;
    private String entranceInfo;
    private final List<String> filterProductIds;
    private final Integer followStatus;
    private final boolean isFromFlowGuessULike;
    private final boolean isFullScreenFlowPage;
    private final String isReceptor;
    private AnchorV3PromotionRequestParam mainCardRequestParam;
    private final String mainProductId;
    private final boolean mainProductIsValid;
    private final String mainProductRecommendInfo;
    private final String mainProductRequestId;
    private final String mainPromotionId;
    private final String metaParams;
    private final String requestAdditions;
    private final int sameProductStyle;
    private final String secAuthorId;
    private final String secUserId;
    private final String shopId;
    private final String userId;
    private final String v3EventsAdditions;
    private final String videoId;

    public SameProductPageParams() {
        this(null, null, false, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getEcomEntranceForm() {
        return this.ecomEntranceForm;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final List<String> getFilterProductIds() {
        return this.filterProductIds;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final AnchorV3PromotionRequestParam getMainCardRequestParam() {
        return this.mainCardRequestParam;
    }

    public final String getMainProductId() {
        return this.mainProductId;
    }

    public final boolean getMainProductIsValid() {
        return this.mainProductIsValid;
    }

    public final String getMainProductRecommendInfo() {
        return this.mainProductRecommendInfo;
    }

    public final String getMainProductRequestId() {
        return this.mainProductRequestId;
    }

    public final String getMainPromotionId() {
        return this.mainPromotionId;
    }

    public final String getMetaParams() {
        return this.metaParams;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final int getSameProductStyle() {
        return this.sameProductStyle;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean isFromFlowGuessULike() {
        return this.isFromFlowGuessULike;
    }

    public final boolean isFullScreenFlowPage() {
        return this.isFullScreenFlowPage;
    }

    public final String isReceptor() {
        return this.isReceptor;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setMainCardRequestParam(AnchorV3PromotionRequestParam r100) {
        this.mainCardRequestParam = r100;
    }

    public SameProductPageParams(String r100, String r101, boolean r102, int r103, boolean r104, boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, Integer r118, String r119, String r210, String r211, String r212, String r213, String r214, AnchorV3PromotionRequestParam r215, String r216, String r217, List<String> r218) {
        Intrinsics.checkNotNullParameter(r100, "mainProductId");
        Intrinsics.checkNotNullParameter(r101, "mainPromotionId");
        this.mainProductId = r100;
        this.mainPromotionId = r101;
        this.mainProductIsValid = r102;
        this.sameProductStyle = r103;
        this.isFromFlowGuessULike = r104;
        this.isFullScreenFlowPage = r110;
        this.authorId = r111;
        this.secAuthorId = r112;
        this.userId = r113;
        this.secUserId = r114;
        this.videoId = r115;
        this.shopId = r116;
        this.enterFrom = r117;
        this.followStatus = r118;
        this.ecomEntranceForm = r119;
        this.metaParams = r210;
        this.entranceInfo = r211;
        this.requestAdditions = r212;
        this.v3EventsAdditions = r213;
        this.isReceptor = r214;
        this.mainCardRequestParam = r215;
        this.mainProductRequestId = r216;
        this.mainProductRecommendInfo = r217;
        this.filterProductIds = r218;
    }

    public /* synthetic */ SameProductPageParams(String r210, String r211, boolean r212, int r310, boolean r311, boolean r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, Integer r410, String r411, String r412, String r413, String r414, String r415, String r416, AnchorV3PromotionRequestParam r417, String r418, String r419, List r510, int r511, DefaultConstructorMarker r512) {
        if ((r511 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r511 & 2) == 0) goto L9;
        String r101 = "";
    L10:
        boolean r102 = false;
        if ((r511 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r511 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r511 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r511 & 32) != 0) goto L27;
        r102 = r312;
    L27:
        if ((r511 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r511 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r511 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r511 & 512) == 0) goto L41;
        String r111 = "";
    L43:
        if ((r511 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r511 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r511 & 4096) == 0) goto L53;
        String r114 = "";
    L54:
        List r115 = null;
        if ((r511 & 8192) == 0) goto L57;
        Integer r116 = null;
    L59:
        if ((r511 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r511 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r511 & 65536) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r511 & 131072) == 0) goto L73;
        String r119 = null;
    L75:
        if ((r511 & 262144) == 0) goto L77;
        String r213 = null;
    L79:
        if ((r511 & 524288) == 0) goto L81;
        String r214 = null;
    L83:
        if ((r511 & 1048576) == 0) goto L85;
        AnchorV3PromotionRequestParam r215 = null;
    L87:
        if ((r511 & 2097152) == 0) goto L89;
        String r216 = null;
    L91:
        if ((r511 & 4194304) == 0) goto L93;
        String r217 = null;
    L95:
        if ((r511 & 8388608) != 0) goto L98;
        r115 = r510;
    L98:
        this(r100, r101, r103, r104, r105, r102, r106, r107, r110, r111, r112, r113, r114, r116, r108, r117, r118, r119, r213, r214, r215, r216, r217, r115);
        return;
    L93:
        r217 = r419;
        goto L95
    L89:
        r216 = r418;
        goto L91
    L85:
        r215 = r417;
        goto L87
    L81:
        r214 = r416;
        goto L83
    L77:
        r213 = r415;
        goto L79
    L73:
        r119 = r414;
        goto L75
    L69:
        r118 = r413;
        goto L71
    L65:
        r117 = r412;
        goto L67
    L61:
        r108 = r411;
        goto L63
    L57:
        r116 = r410;
        goto L59
    L53:
        r114 = r319;
        goto L54
    L49:
        r113 = r318;
        goto L51
    L45:
        r112 = r317;
        goto L47
    L41:
        r111 = r316;
        goto L43
    L37:
        r110 = r315;
        goto L39
    L33:
        r107 = r314;
        goto L35
    L29:
        r106 = r313;
        goto L31
    L21:
        r105 = r311;
        goto L23
    L17:
        r104 = r310;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}
