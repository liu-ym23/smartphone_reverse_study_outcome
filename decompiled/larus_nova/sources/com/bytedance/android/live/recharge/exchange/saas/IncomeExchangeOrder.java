package com.bytedance.android.live.recharge.exchange.saas;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/saas/IncomeExchangeOrder;", "", "()V", "extra", "", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IncomeExchangeOrder {

    @SerializedName("extra")
    private String extra;

    @SerializedName("order_id")
    private String orderId;

    public IncomeExchangeOrder() {
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setOrderId(String r100) {
        this.orderId = r100;
    }
}
