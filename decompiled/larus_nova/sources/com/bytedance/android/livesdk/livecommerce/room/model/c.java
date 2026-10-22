package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u00105¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "", "", "eventItemType", "Ljava/lang/String;", "getEventItemType", "()Ljava/lang/String;", "productId", "getProductId", "promotionId", "getPromotionId", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "getStandardEventTrack", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "channelType", "getChannelType", "scheme", "getScheme", "shopId", "getShopId", "leafCategory", "getLeafCategory", "Lcom/bytedance/android/ec/model/ECUrlModel;", "detailCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDetailCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "getCover", "title", "getTitle", "", "singleSku", "Z", "getSingleSku", "()Z", "bizIdentity", "getBizIdentity", "setBizIdentity", "(Ljava/lang/String;)V", "checkCallback", "getCheckCallback", "setCheckCallback", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("biz_identity")
    private String bizIdentity;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final Integer channelType;

    @SerializedName("check_callback")
    private String checkCallback;

    @SerializedName("cover")
    private final String cover;

    @SerializedName("detail_cover")
    private final ECUrlModel detailCover;

    @SerializedName("event_item_type")
    private final String eventItemType;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("leaf_category")
    private final String leafCategory;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("scheme")
    private final String scheme;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("single_sku")
    private final boolean singleSku;

    @SerializedName("standard_event_track")
    private final StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L40;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.eventItemType, r101.eventItemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.standardEventTrack, r101.standardEventTrack) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.scheme, r101.scheme) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.leafCategory, r101.leafCategory) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.detailCover, r101.detailCover) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L34;
        return false;
    L34:
        if (this.singleSku == r101.singleSku) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bizIdentity, r101.bizIdentity) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.checkCallback, r101.checkCallback) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v60 */
    public final int hashCode() {
        String r100 = this.eventItemType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.promotionId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.status;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.eventParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        StandardEventTrack r116 = this.standardEventTrack;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.channelId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.channelType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.scheme;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.shopId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.leafCategory;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        ECUrlModel r134 = this.detailCover;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.cover;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.title;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        boolean r143 = this.singleSku;
        ?? r144 = r143;
        if (r143 == false) goto L61;
        r144 = 1;
    L61:
        int r145 = (r142 + r144) * 31;
        String r146 = this.bizIdentity;
        if (r146 == null) goto L64;
        int r147 = r146.hashCode();
    L65:
        int r148 = (r145 + r147) * 31;
        String r149 = this.checkCallback;
        if (r149 == null) goto L69;
        r101 = r149.hashCode();
    L69:
        return r148 + r101;
    L64:
        r147 = 0;
        goto L65
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

    public final String toString() {
        return "ECLiveHybridPromotion(eventItemType=" + this.eventItemType + ", productId=" + this.productId + ", promotionId=" + this.promotionId + ", status=" + this.status + ", eventParams=" + this.eventParams + ", standardEventTrack=" + this.standardEventTrack + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", scheme=" + this.scheme + ", shopId=" + this.shopId + ", leafCategory=" + this.leafCategory + ", detailCover=" + this.detailCover + ", cover=" + this.cover + ", title=" + this.title + ", singleSku=" + this.singleSku + ", bizIdentity=" + this.bizIdentity + ", checkCallback=" + this.checkCallback + ")";
    }

    public c() {
        this.eventItemType = null;
        this.productId = null;
        this.promotionId = null;
        this.status = null;
        this.eventParams = null;
        this.standardEventTrack = null;
        this.channelId = null;
        this.channelType = null;
        this.scheme = null;
        this.shopId = null;
        this.leafCategory = null;
        this.detailCover = null;
        this.cover = null;
        this.title = null;
        this.singleSku = false;
        this.bizIdentity = null;
        this.checkCallback = null;
    }

    public final ql.a a(ql.a r100) {
        if (r100 != null) goto L4;
        r100 = new a(this.cover, this.title);
    L4:
        r100.setEventItemType(this.eventItemType);
        String r101 = this.productId;
        String r102 = "";
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.setProductId(r101);
        String r103 = this.promotionId;
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r100.setPromotionId(r103);
        Integer r104 = this.status;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        r100.setStatus(r105);
        r100.setEventParams(this.eventParams);
        r100.setStandardEventTrack(this.standardEventTrack);
        r100.setChannelId(this.channelId);
        r100.setChannelType(this.channelType);
        r100.setScheme(this.scheme);
        String r106 = this.shopId;
        if (r106 == null) goto L18;
        r102 = r106;
    L18:
        r100.setShopId(r102);
        r100.setLeafCategory(this.leafCategory);
        r100.setDetailCover(this.detailCover);
        r100.setSingleSku(this.singleSku);
        r100.setBizIdentity(this.bizIdentity);
        r100.setCheckCallback(this.checkCallback);
        return r100;
    L13:
        r105 = 0;
        goto L14
    }
}
