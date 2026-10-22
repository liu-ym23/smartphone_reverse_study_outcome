package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/InnerFlowSchema;", "Ljava/io/Serializable;", "()V", "orderSchema", "Lcom/bytedance/android/ec/model/response/anchorv3/ShortVideoSchema;", "getOrderSchema", "()Lcom/bytedance/android/ec/model/response/anchorv3/ShortVideoSchema;", "skuSchema", "getSkuSchema", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class InnerFlowSchema implements Serializable {

    @SerializedName("order_schema")
    private final ShortVideoSchema orderSchema;

    @SerializedName("sku_schema")
    private final ShortVideoSchema skuSchema;

    public InnerFlowSchema() {
    }

    public final ShortVideoSchema getOrderSchema() {
        return this.orderSchema;
    }

    public final ShortVideoSchema getSkuSchema() {
        return this.skuSchema;
    }
}
