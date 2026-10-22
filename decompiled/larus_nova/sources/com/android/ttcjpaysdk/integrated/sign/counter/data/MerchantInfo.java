package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/MerchantInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "app_id", "", "merchant_id", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MerchantInfo implements CJPayObject {
    public String app_id;
    public String merchant_id;

    public MerchantInfo() {
        this.merchant_id = "";
        this.app_id = "";
    }
}
