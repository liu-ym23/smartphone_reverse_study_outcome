package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuUserInfo;", "Ljava/io/Serializable;", "()V", "itemDetails", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermDetailInfo;", "getItemDetails", "()Ljava/util/List;", "showFlag", "", "getShowFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "title", "", "getTitle", "()Ljava/lang/String;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuUserInfo implements Serializable {

    @SerializedName("item_details")
    private final List<SkuTermDetailInfo> itemDetails;

    @SerializedName("show_flag")
    private final Boolean showFlag;

    @SerializedName("title")
    private final String title;

    public SkuUserInfo() {
    }

    public final List<SkuTermDetailInfo> getItemDetails() {
        return this.itemDetails;
    }

    public final Boolean getShowFlag() {
        return this.showFlag;
    }

    public final String getTitle() {
        return this.title;
    }
}
