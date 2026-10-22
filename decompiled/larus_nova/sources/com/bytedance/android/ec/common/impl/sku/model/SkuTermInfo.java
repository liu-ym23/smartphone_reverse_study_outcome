package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u001a\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000b¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermInfo;", "Ljava/io/Serializable;", "()V", "anchorId", "", "getAnchorId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "bizType", "", "getBizType", "()Ljava/lang/String;", "creditTip", "getCreditTip", "itemDetails", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermDetailInfo;", "getItemDetails", "()Ljava/util/List;", "itemList", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuTermInfoItem;", "getItemList", "materialNo", "getMaterialNo", "planNo", "getPlanNo", "resourceNo", "getResourceNo", "selectable", "", "getSelectable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "selectionTip", "getSelectionTip", "showFlag", "getShowFlag", "title", "getTitle", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuTermInfo implements Serializable {

    @SerializedName("anchor_id")
    private final Integer anchorId;

    @SerializedName("biz_type")
    private final String bizType;

    @SerializedName("credit_tip")
    private final String creditTip;

    @SerializedName("item_details")
    private final List<SkuTermDetailInfo> itemDetails;

    @SerializedName("item_list")
    private final List<SkuTermInfoItem> itemList;

    @SerializedName("material_no")
    private final String materialNo;

    @SerializedName("plan_no")
    private final String planNo;

    @SerializedName("resource_no")
    private final String resourceNo;

    @SerializedName("selectable")
    private final Boolean selectable;

    @SerializedName("selection_tip")
    private final String selectionTip;

    @SerializedName("show_flag")
    private final Boolean showFlag;

    @SerializedName("title")
    private final String title;

    public SkuTermInfo() {
    }

    public final Integer getAnchorId() {
        return this.anchorId;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getCreditTip() {
        return this.creditTip;
    }

    public final List<SkuTermDetailInfo> getItemDetails() {
        return this.itemDetails;
    }

    public final List<SkuTermInfoItem> getItemList() {
        return this.itemList;
    }

    public final String getMaterialNo() {
        return this.materialNo;
    }

    public final String getPlanNo() {
        return this.planNo;
    }

    public final String getResourceNo() {
        return this.resourceNo;
    }

    public final Boolean getSelectable() {
        return this.selectable;
    }

    public final String getSelectionTip() {
        return this.selectionTip;
    }

    public final Boolean getShowFlag() {
        return this.showFlag;
    }

    public final String getTitle() {
        return this.title;
    }
}
