package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountInfo;", "Ljava/io/Serializable;", "()V", "activityType", "", "getActivityType", "()Ljava/lang/String;", "descText", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountDescText;", "getDescText", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuDiscountDescText;", "discountDesc", "getDiscountDesc", "showFlag", "", "getShowFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuDiscountInfo implements Serializable {

    @SerializedName(a.KEY_ACTIVITY_TYPE)
    private final String activityType;

    @SerializedName("desc_text")
    private final SkuDiscountDescText descText;

    @SerializedName("discount_desc")
    private final String discountDesc;

    @SerializedName("show_flag")
    private final Boolean showFlag;

    public SkuDiscountInfo() {
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final SkuDiscountDescText getDescText() {
        return this.descText;
    }

    public final String getDiscountDesc() {
        return this.discountDesc;
    }

    public final Boolean getShowFlag() {
        return this.showFlag;
    }
}
