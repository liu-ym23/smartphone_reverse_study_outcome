package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveLink;", "Ljava/io/Serializable;", "()V", "liveSchema", "", "getLiveSchema", "()Ljava/lang/String;", "productSchema", "getProductSchema", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemCardLiveLink implements Serializable {

    @SerializedName("live")
    private final String liveSchema;

    @SerializedName("live_with_product")
    private final String productSchema;

    public ItemCardLiveLink() {
    }

    public final String getLiveSchema() {
        return this.liveSchema;
    }

    public final String getProductSchema() {
        return this.productSchema;
    }
}
