package com.bytedance.android.shopping.store.hybrid.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/PreLoadShopInfo;", "Ljava/io/Serializable;", "()V", "shopType", "", "getShopType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreLoadShopInfo implements Serializable {

    @SerializedName("shop_type")
    private final Integer shopType;

    public PreLoadShopInfo() {
        this.shopType = 0;
    }

    public final Integer getShopType() {
        return this.shopType;
    }
}
