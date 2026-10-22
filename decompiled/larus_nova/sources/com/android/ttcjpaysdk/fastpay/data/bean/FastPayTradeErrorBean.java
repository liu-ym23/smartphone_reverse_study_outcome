package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class FastPayTradeErrorBean implements CJPayObject {
    public String data;
    public String inner_msg;
    public String msg;
    public String type;
    public String type_cnt;

    public FastPayTradeErrorBean() {
        this.inner_msg = "";
        this.msg = "";
        this.type = "";
        this.type_cnt = "";
        this.data = "";
    }
}
