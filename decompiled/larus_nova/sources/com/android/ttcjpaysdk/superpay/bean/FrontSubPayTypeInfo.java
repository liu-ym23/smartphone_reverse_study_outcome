package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class FrontSubPayTypeInfo implements CJPayObject, Serializable {
    public boolean choose;
    public boolean home_page_show;
    public String icon_url;
    public String identity_verify_way;
    public int index;
    public String mark;
    public String msg;
    public FrontPayTypeData pay_type_data;
    public String status;
    public String sub_pay_type;
    public String sub_pay_type_num;
    public String sub_title;
    public String title;
    public String trade_confirm_button_label;

    public boolean isEnable() {
        return this.status.equals("1");
    }

    public FrontSubPayTypeInfo() {
        this.sub_pay_type = "";
        this.sub_pay_type_num = "";
        this.status = "";
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.msg = "";
        this.mark = "";
        this.identity_verify_way = "";
        this.pay_type_data = new FrontPayTypeData();
        this.trade_confirm_button_label = "";
    }
}
