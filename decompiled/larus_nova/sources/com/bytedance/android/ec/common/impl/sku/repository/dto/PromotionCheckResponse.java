package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/PromotionCheckResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "orderUrl", "", "halfCloseSku", "", "limitType", "(Ljava/lang/String;ILjava/lang/String;)V", "getHalfCloseSku", "()I", "getLimitType", "()Ljava/lang/String;", "getOrderUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCheckResponse extends CommerceBaseResponse {

    @SerializedName("half_close_sku")
    private final int halfCloseSku;

    @SerializedName("limit_type")
    private final String limitType;

    @SerializedName("order_url")
    private final String orderUrl;

    public PromotionCheckResponse() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ PromotionCheckResponse copy$default(PromotionCheckResponse r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.orderUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.halfCloseSku;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.limitType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.orderUrl;
    }

    public final int component2() {
        return this.halfCloseSku;
    }

    public final String component3() {
        return this.limitType;
    }

    public final PromotionCheckResponse copy(String r100, int r101, String r102) {
        return new PromotionCheckResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionCheckResponse) == false) goto L12;
        PromotionCheckResponse r101 = (PromotionCheckResponse) r100;
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L8;
        return false;
    L8:
        if (this.halfCloseSku == r101.halfCloseSku) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.limitType, r101.limitType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.orderUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.halfCloseSku) * 31;
        String r104 = this.limitType;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionCheckResponse(orderUrl=" + this.orderUrl + ", halfCloseSku=" + this.halfCloseSku + ", limitType=" + this.limitType + ")";
    }

    public final int getHalfCloseSku() {
        return this.halfCloseSku;
    }

    public final String getLimitType() {
        return this.limitType;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public PromotionCheckResponse(String r100, int r101, String r102) {
        this.orderUrl = r100;
        this.halfCloseSku = r101;
        this.limitType = r102;
    }

    public /* synthetic */ PromotionCheckResponse(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
