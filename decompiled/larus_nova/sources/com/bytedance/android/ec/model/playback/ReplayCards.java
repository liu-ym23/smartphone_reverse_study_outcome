package com.bytedance.android.ec.model.playback;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ReplayCards;", "Ljava/io/Serializable;", "()V", "productReplayCards", "", "Lcom/bytedance/android/ec/model/playback/ReplayCard;", "getProductReplayCards", "()Ljava/util/List;", "productReplayCnt", "", "getProductReplayCnt", "()I", "productsWithIndex", "Lcom/bytedance/android/ec/model/playback/ProductIndex;", "getProductsWithIndex", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ReplayCards implements Serializable {

    @SerializedName("product_replay_cards")
    private final List<ReplayCard> productReplayCards;

    @SerializedName("product_replay_cnt")
    private final int productReplayCnt;

    @SerializedName("products")
    private final List<ProductIndex> productsWithIndex;

    public ReplayCards() {
    }

    public final List<ReplayCard> getProductReplayCards() {
        return this.productReplayCards;
    }

    public final int getProductReplayCnt() {
        return this.productReplayCnt;
    }

    public final List<ProductIndex> getProductsWithIndex() {
        return this.productsWithIndex;
    }
}
