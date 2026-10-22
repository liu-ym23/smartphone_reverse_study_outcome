package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/ECStorePreloadInfoResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "shopInfo", "Lcom/bytedance/android/shopping/store/hybrid/entity/PreLoadShopInfo;", "getShopInfo", "()Lcom/bytedance/android/shopping/store/hybrid/entity/PreLoadShopInfo;", "tabInfo", "Lcom/bytedance/android/shopping/store/hybrid/entity/TabInfoResponse;", "getTabInfo", "()Lcom/bytedance/android/shopping/store/hybrid/entity/TabInfoResponse;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStorePreloadInfoResponse extends CommerceBaseResponse {

    @SerializedName("shop_info")
    private final PreLoadShopInfo shopInfo;

    @SerializedName("tab_info")
    private final TabInfoResponse tabInfo;

    public ECStorePreloadInfoResponse() {
    }

    public final PreLoadShopInfo getShopInfo() {
        return this.shopInfo;
    }

    public final TabInfoResponse getTabInfo() {
        return this.tabInfo;
    }
}
