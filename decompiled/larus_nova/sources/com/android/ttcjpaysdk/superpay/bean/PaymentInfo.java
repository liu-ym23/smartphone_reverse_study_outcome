package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/superpay/bean/PaymentInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "card_mask_code", "", OpenFeedConstantKt.KEY_CHANNEL_NAME, "deduct_amount", "", "deduct_type", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentInfo implements CJPayObject {
    public String card_mask_code;
    public String channel_name;
    public long deduct_amount;
    public String deduct_type;

    public PaymentInfo() {
        this.deduct_type = "";
        this.channel_name = "";
        this.card_mask_code = "";
    }
}
