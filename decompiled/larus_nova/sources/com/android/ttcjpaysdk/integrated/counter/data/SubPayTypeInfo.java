package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class SubPayTypeInfo implements CJPayObject {
    public PayTypeItemInfo.CashierPageInfo cashier_page_info;
    public boolean choose;
    public boolean home_page_show;
    public String icon_url;
    public String identity_verify_way;
    public int index;
    public String mark;
    public String msg;
    public PayTypeData pay_type_data;
    public PromotionProcessInfo promotion_process;
    public String status;
    public String sub_pay_type;
    public String sub_pay_type_num;
    public String sub_title;
    public String title;
    public String trade_confirm_button_label;
    public int way;

    public String getSafeSubTitle() {
        String r100 = this.sub_title;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        return this.msg;
    }

    public SubPayTypeInfo() {
        this.sub_pay_type = "";
        this.sub_pay_type_num = "";
        this.status = "";
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.msg = "";
        this.mark = "";
        this.identity_verify_way = "";
        this.pay_type_data = new PayTypeData();
        this.trade_confirm_button_label = "";
        this.cashier_page_info = new PayTypeItemInfo.CashierPageInfo();
        this.promotion_process = new PromotionProcessInfo();
    }
}
