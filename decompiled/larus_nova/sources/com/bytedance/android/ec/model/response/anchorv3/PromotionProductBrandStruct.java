package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBrandStruct;", "Ljava/io/Serializable;", "()V", "brandIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBrandIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "isBrandStore", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductBrandStruct implements Serializable {

    @SerializedName("icon")
    private final ECUrlModel brandIcon;

    @SerializedName("is_brand_store")
    private final Boolean isBrandStore;

    public PromotionProductBrandStruct() {
    }

    public final ECUrlModel getBrandIcon() {
        return this.brandIcon;
    }

    public final Boolean isBrandStore() {
        return this.isBrandStore;
    }
}
