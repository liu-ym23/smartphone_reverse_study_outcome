package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionSeckillPrice;", "Ljava/io/Serializable;", "()V", "seckillMaxPrice", "", "getSeckillMaxPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "seckillMinPrice", "getSeckillMinPrice", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionSeckillPrice implements Serializable {

    @SerializedName("seckill_max_price")
    private final Long seckillMaxPrice;

    @SerializedName("seckill_min_price")
    private final Long seckillMinPrice;

    public PromotionSeckillPrice() {
    }

    public final Long getSeckillMaxPrice() {
        return this.seckillMaxPrice;
    }

    public final Long getSeckillMinPrice() {
        return this.seckillMinPrice;
    }
}
