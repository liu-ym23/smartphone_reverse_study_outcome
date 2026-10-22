package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayMerchantInfo implements CJPayObject, Serializable {
    public String app_id;
    public int ext_uid_type;
    public String jh_app_id;
    public String jh_merchant_id;
    public String merchant_id;
    public String merchant_name;
    public String merchant_short_name;
    public String merchant_short_to_customer;

    public CJPayMerchantInfo() {
        this.ext_uid_type = 0;
        this.merchant_id = "";
        this.merchant_name = "";
        this.merchant_short_to_customer = "";
        this.app_id = "";
        this.jh_merchant_id = "";
        this.jh_app_id = "";
        this.merchant_short_name = "";
    }
}
