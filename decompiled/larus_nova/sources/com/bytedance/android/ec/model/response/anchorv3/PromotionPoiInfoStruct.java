package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPoiInfoStruct;", "Ljava/io/Serializable;", "()V", "navLink", "", "getNavLink", "()Ljava/lang/String;", "selectPoiInfo", "Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;", "getSelectPoiInfo", "()Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;", "total", "", "getTotal", "()Ljava/lang/Long;", "Ljava/lang/Long;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionPoiInfoStruct implements Serializable {

    @SerializedName("nav_link")
    private final String navLink;

    @SerializedName("selected")
    private final ProductSelectPoiInfo selectPoiInfo;

    @SerializedName("total")
    private final Long total;

    public PromotionPoiInfoStruct() {
    }

    public final String getNavLink() {
        return this.navLink;
    }

    public final ProductSelectPoiInfo getSelectPoiInfo() {
        return this.selectPoiInfo;
    }

    public final Long getTotal() {
        return this.total;
    }
}
