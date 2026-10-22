package com.android.ttcjpaysdk.superpay.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class SuperPayAgainHintInfo implements CJPayObject, Serializable {
    public CJPayButtonInfo button_info;
    public String button_text;
    public ArrayList<String> cashierTag;
    public String fail_pay_type_msg;
    public String icon;
    public String icon_url;
    public MerchantInfo merchant_info;
    public String msg;
    public CJPayProcessInfo promotion_process;
    public FrontSubPayTypeInfo rec_pay_type;
    public RetainInfo retain_info;
    public String status_msg;
    public String style;
    public String sub_button_text;
    public String sub_status_msg;
    public String top_right_desc_text;
    public int trade_amount;
    public ArrayList<String> voucher_bank_icons;

    public static class MerchantInfo implements CJPayObject, Serializable {
        public String app_id;
        public String merchant_id;

        public MerchantInfo() {
            this.merchant_id = "";
            this.app_id = "";
        }
    }

    public boolean hasCombinePay() {
        if (this.rec_pay_type.pay_type_data.combine_show_info.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPayAgainRecSimpleExp() {
        return this.cashierTag.contains("pay_again_rec_simple");
    }

    public Boolean isServerControl() {
        return Boolean.valueOf(!TextUtils.isEmpty(this.style));
    }

    public SuperPayAgainHintInfo() {
        this.msg = "";
        this.icon_url = "";
        this.status_msg = "";
        this.rec_pay_type = new FrontSubPayTypeInfo();
        this.voucher_bank_icons = new ArrayList();
        this.button_text = "";
        this.sub_button_text = "";
        this.sub_status_msg = "";
        this.fail_pay_type_msg = "";
        this.retain_info = new RetainInfo();
        this.style = "";
        this.button_info = new CJPayButtonInfo();
        this.top_right_desc_text = "";
        this.trade_amount = 0;
        this.icon = "";
        this.promotion_process = new CJPayProcessInfo();
        this.cashierTag = new ArrayList();
        this.merchant_info = new MerchantInfo();
    }
}
