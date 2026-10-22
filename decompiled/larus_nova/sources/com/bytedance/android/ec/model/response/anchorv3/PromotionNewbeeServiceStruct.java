package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeServiceStruct;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", PromotionProductPrivilegesStruct.SERVICES, "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductServiceStruct;", "getServices", "()Ljava/util/List;", "url", "", "getUrl", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionNewbeeServiceStruct implements Serializable {

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName(PromotionProductPrivilegesStruct.SERVICES)
    private final List<PromotionProductServiceStruct> services;

    @SerializedName("url")
    private final String url;

    public PromotionNewbeeServiceStruct() {
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final List<PromotionProductServiceStruct> getServices() {
        return this.services;
    }

    public final String getUrl() {
        return this.url;
    }
}
