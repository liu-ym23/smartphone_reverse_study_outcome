package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class CounterTradeConfirmResponseBean implements CJPayObject {
    public String code;
    public ChannelResult data;
    public CounterTradeErrorBean error;
    public String process;
    public String typecnt;

    public boolean isResponseOk() {
        if (TextUtils.isEmpty(this.code) == false) goto L5;
    L7:
        return false;
    L5:
        if ("CA0000".equals(this.code) == false) goto L7;
        return true;
    }

    public CounterTradeConfirmResponseBean() {
        this.code = "";
        this.error = new CounterTradeErrorBean();
        this.typecnt = "";
        this.process = "";
        this.data = new ChannelResult();
    }
}
