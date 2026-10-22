package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class CounterTradeErrorBean implements CJPayObject {
    public String inner_msg;
    public String msg;
    public String type;
    public String type_cnt;

    public CounterTradeErrorBean() {
        this.inner_msg = "";
        this.msg = "";
        this.type = "";
        this.type_cnt = "";
    }
}
