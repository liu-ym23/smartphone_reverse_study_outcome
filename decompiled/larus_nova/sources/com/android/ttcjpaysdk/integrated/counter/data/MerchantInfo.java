package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class MerchantInfo implements CJPayObject {
    public String app_id;
    public int ext_uid_type;
    public String jh_app_id;
    public String jh_merchant_id;
    public String merchant_id;
    public String merchant_name;
    public String merchant_short_to_customer;

    public MerchantInfo() {
        this.ext_uid_type = 0;
        this.merchant_id = "";
        this.merchant_name = "";
        this.merchant_short_to_customer = "";
        this.app_id = "";
        this.jh_merchant_id = "";
        this.jh_app_id = "";
    }
}
