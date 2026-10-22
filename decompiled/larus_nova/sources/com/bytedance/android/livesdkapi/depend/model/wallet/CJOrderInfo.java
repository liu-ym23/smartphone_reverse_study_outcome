package com.bytedance.android.livesdkapi.depend.model.wallet;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class CJOrderInfo {

    @SerializedName("order_id")
    String orderId;

    @SerializedName("params")
    String params;

    public CJOrderInfo() {
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getParams() {
        return this.params;
    }
}
