package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u001f\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermDetailInfo;", "Ljava/io/Serializable;", "()V", "benefitDesc", "", "getBenefitDesc", "()Ljava/lang/String;", "itemId", "getItemId", "reduceAmount", "", "getReduceAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "serviceDiscount", "getServiceDiscount", "serviceFreeFlag", "", "getServiceFreeFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "servicePerAmount", "getServicePerAmount", "termCount", "", "getTermCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "termFlag", "getTermFlag", "termPerAmount", "getTermPerAmount", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTermDetailInfo implements Serializable {

    @SerializedName("benefit_desc")
    private final String benefitDesc;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("reduce_amount")
    private final Long reduceAmount;

    @SerializedName("service_discount")
    private final Long serviceDiscount;

    @SerializedName("service_free_flag")
    private final Boolean serviceFreeFlag;

    @SerializedName("service_per_amount")
    private final Long servicePerAmount;

    @SerializedName("term_count")
    private final Integer termCount;

    @SerializedName("term_flag")
    private final Boolean termFlag;

    @SerializedName("term_per_amount")
    private final Long termPerAmount;

    public SkuTermDetailInfo() {
    }

    public final String getBenefitDesc() {
        return this.benefitDesc;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Long getReduceAmount() {
        return this.reduceAmount;
    }

    public final Long getServiceDiscount() {
        return this.serviceDiscount;
    }

    public final Boolean getServiceFreeFlag() {
        return this.serviceFreeFlag;
    }

    public final Long getServicePerAmount() {
        return this.servicePerAmount;
    }

    public final Integer getTermCount() {
        return this.termCount;
    }

    public final Boolean getTermFlag() {
        return this.termFlag;
    }

    public final Long getTermPerAmount() {
        return this.termPerAmount;
    }
}
