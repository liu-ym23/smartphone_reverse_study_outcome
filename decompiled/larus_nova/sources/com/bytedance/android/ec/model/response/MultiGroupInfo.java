package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/model/response/MultiGroupInfo;", "Ljava/io/Serializable;", "()V", "skuIsGroupBuying", "", "getSkuIsGroupBuying", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MultiGroupInfo implements Serializable {

    @SerializedName("sku_is_group_buy")
    private final Boolean skuIsGroupBuying;

    public MultiGroupInfo() {
        this.skuIsGroupBuying = Boolean.FALSE;
    }

    public final Boolean getSkuIsGroupBuying() {
        return this.skuIsGroupBuying;
    }
}
