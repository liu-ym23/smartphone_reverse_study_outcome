package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class ChannelResult implements CJPayObject {
    public String channel_pay_type;
    public ChannelInfo pay_params;

    public ChannelResult() {
        this.pay_params = new ChannelInfo();
        this.channel_pay_type = "";
    }
}
