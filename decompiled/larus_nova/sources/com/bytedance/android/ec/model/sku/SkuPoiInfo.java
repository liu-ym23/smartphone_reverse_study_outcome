package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "Ljava/io/Serializable;", "()V", "navLink", "", "getNavLink", "()Ljava/lang/String;", "setNavLink", "(Ljava/lang/String;)V", "selectedPoiInfo", "Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;", "getSelectedPoiInfo", "()Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;", "setSelectedPoiInfo", "(Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;)V", "total", "", "getTotal", "()Ljava/lang/Long;", "setTotal", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuPoiInfo implements Serializable {

    @SerializedName("nav_link")
    private String navLink;

    @SerializedName("selected")
    private ProductSelectPoiInfo selectedPoiInfo;

    @SerializedName("total")
    private Long total;

    public SkuPoiInfo() {
    }

    public final String getNavLink() {
        return this.navLink;
    }

    public final ProductSelectPoiInfo getSelectedPoiInfo() {
        return this.selectedPoiInfo;
    }

    public final Long getTotal() {
        return this.total;
    }

    public final void setNavLink(String r100) {
        this.navLink = r100;
    }

    public final void setSelectedPoiInfo(ProductSelectPoiInfo r100) {
        this.selectedPoiInfo = r100;
    }

    public final void setTotal(Long r100) {
        this.total = r100;
    }
}
