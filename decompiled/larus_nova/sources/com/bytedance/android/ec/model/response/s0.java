package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentStatStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentTagStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u001c\u0010 \u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/model/response/s0;", "", "", "statusCode", "I", "getStatusCode", "()I", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentStatStruct;", "stats", "Ljava/util/List;", "getStats", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentTagStruct;", PromotionProductPrivilegesStruct.TAGS, "getTags", "Lcom/bytedance/android/ec/model/response/f;", "extra", "Lcom/bytedance/android/ec/model/response/f;", "getExtra", "()Lcom/bytedance/android/ec/model/response/f;", "Lcom/bytedance/android/ec/model/response/c0;", "extendTags", "getExtendTags", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductSkuStruct;", "skuInfo", "getSkuInfo", "productName", "getProductName", "", "logMap", "Ljava/util/Map;", "getLogMap", "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("extend_tags")
    private final List<c0> extendTags;

    @SerializedName("extra")
    private final f extra;

    @SerializedName("log_map")
    private final Map<String, String> logMap;

    @SerializedName("product_name")
    private final String productName;

    @SerializedName("sku_info")
    private final List<PromotionProductSkuStruct> skuInfo;

    @SerializedName("stats")
    private final List<PromotionProductCommentStatStruct> stats;

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<PromotionProductCommentTagStruct> tags;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L24;
        s0 r101 = (s0) r100;
        if (this.statusCode == r101.statusCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.stats, r101.stats) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.extendTags, r101.extendTags) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.skuInfo, r101.skuInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productName, r101.productName) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.logMap, r101.logMap) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = this.statusCode * 31;
        String r101 = this.statusMsg;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<PromotionProductCommentStatStruct> r105 = this.stats;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        List<PromotionProductCommentTagStruct> r108 = this.tags;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        f r111 = this.extra;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        List<c0> r114 = this.extendTags;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        List<PromotionProductSkuStruct> r117 = this.skuInfo;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.productName;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        Map<String, String> r123 = this.logMap;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        return r122 + r102;
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionCommentTagsDTO(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", stats=" + this.stats + ", tags=" + this.tags + ", extra=" + this.extra + ", extendTags=" + this.extendTags + ", skuInfo=" + this.skuInfo + ", productName=" + this.productName + ", logMap=" + this.logMap + ")";
    }
}
