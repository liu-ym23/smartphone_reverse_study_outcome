package com.bytedance.android.ec.model.playback;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ProductIndex;", "Ljava/io/Serializable;", "()V", "index", "", "getIndex", "()I", "promotionId", "", "getPromotionId", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductIndex implements Serializable {

    @SerializedName("index")
    private final int index;

    @SerializedName("promotion_id")
    private final String promotionId;

    public ProductIndex() {
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }
}
