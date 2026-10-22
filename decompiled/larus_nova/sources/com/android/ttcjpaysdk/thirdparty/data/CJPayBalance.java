package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayBalance implements CJPayObject, Serializable {
    public long balance_amount;
    public String balance_quota;
    public long freezed_amount;
    public String icon_url;
    public String mark;
    public String mobile_mask;
    public String msg;
    public String need_pwd;
    public String primary_combine_pay_amount;
    public boolean show_combine_pay;
    public String status;
    public String title;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_title;

    public CJPayBalance() {
        this.balance_amount = 0;
        this.balance_quota = "";
        this.freezed_amount = 0;
        this.mark = "";
        this.msg = "";
        this.status = "";
        this.icon_url = "";
        this.title = "";
        this.need_pwd = "";
        this.mobile_mask = "";
        this.tt_mark = "";
        this.tt_title = "";
        this.tt_sub_title = "";
        this.tt_icon_url = "";
        this.show_combine_pay = false;
        this.primary_combine_pay_amount = "";
    }
}
