package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class Balance implements CJPayObject {
    public long balance_amount;
    public String balance_quota;
    public long freezed_amount;
    public String icon_url;
    public String identity_verify_way;
    public String mark;
    public String mobile_mask;
    public String msg;
    public String need_pwd;
    public String status;
    public String sub_title;
    public String title;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_title;

    public Balance() {
        this.balance_amount = 0;
        this.balance_quota = "";
        this.freezed_amount = 0;
        this.mark = "";
        this.msg = "";
        this.status = "";
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.need_pwd = "";
        this.mobile_mask = "";
        this.tt_mark = "";
        this.tt_title = "";
        this.tt_sub_title = "";
        this.tt_icon_url = "";
        this.identity_verify_way = "";
    }
}
