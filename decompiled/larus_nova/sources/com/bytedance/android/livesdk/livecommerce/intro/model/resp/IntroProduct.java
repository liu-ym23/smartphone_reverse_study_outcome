package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "", "", "productId", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "promotionId", RXScreenCaptureService.KEY_INDEX, "", RemoteMessageConst.Notification.CHANNEL_ID, "J", "b", "()J", "channelType", "c", "detailUrl", "d", "shopId", ce.f26395j, "itemType", "f", "bizIdentity", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "productType", "I", "h", "()I", "industryType", "e", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroProduct {

    @SerializedName("biz_identity")
    private final String bizIdentity;

    @SerializedName("channel_id")
    private final long channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final long channelType;

    @SerializedName("detail_url")
    private final String detailUrl;

    @SerializedName("industry_type")
    private final int industryType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final long itemType;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_type")
    private final int productType;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final long shopId;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct$Companion$IntroIndustryType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroIndustryType {
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct$Companion$IntroProductType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroProductType {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IntroProduct) == false) goto L26;
        IntroProduct r101 = (IntroProduct) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (this.channelId == r101.channelId) goto L12;
        return false;
    L12:
        if (this.channelType == r101.channelType) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.detailUrl, r101.detailUrl) == true) goto L16;
        return false;
    L16:
        if (this.shopId == r101.shopId) goto L18;
        return false;
    L18:
        if (this.itemType == r101.itemType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizIdentity, r101.bizIdentity) == true) goto L22;
        return false;
    L22:
        if (this.productType == r101.productType) goto L24;
        return false;
    L24:
        if (this.industryType == r101.industryType) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.channelId;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.channelType;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.detailUrl;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        long r114 = this.shopId;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.itemType;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        String r118 = this.bizIdentity;
        if (r118 == null) goto L18;
        r101 = r118.hashCode();
    L18:
        return ((((r117 + r101) * 31) + this.productType) * 31) + this.industryType;
    L13:
        r112 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroProduct(productId=" + this.productId + ", promotionId=" + this.promotionId + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", detailUrl=" + this.detailUrl + ", shopId=" + this.shopId + ", itemType=" + this.itemType + ", bizIdentity=" + this.bizIdentity + ", productType=" + this.productType + ", industryType=" + this.industryType + ")";
    }

    public IntroProduct() {
        this.productId = null;
        this.promotionId = null;
        this.channelId = 0;
        this.channelType = 0;
        this.detailUrl = null;
        this.shopId = 0;
        this.itemType = 0;
        this.bizIdentity = null;
        this.productType = 0;
        this.industryType = 0;
    }

    public final String a() {
        return this.bizIdentity;
    }

    public final long b() {
        return this.channelId;
    }

    public final long c() {
        return this.channelType;
    }

    public final String d() {
        return this.detailUrl;
    }

    public final int e() {
        return this.industryType;
    }

    public final long f() {
        return this.itemType;
    }

    public final String g() {
        return this.productId;
    }

    public final int h() {
        return this.productType;
    }

    public final String i() {
        return this.promotionId;
    }

    public final long j() {
        return this.shopId;
    }
}
