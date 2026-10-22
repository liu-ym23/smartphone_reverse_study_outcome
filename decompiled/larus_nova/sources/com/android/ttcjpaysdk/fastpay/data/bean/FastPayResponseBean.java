package com.android.ttcjpaysdk.fastpay.data.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class FastPayResponseBean implements CJPayObject {
    public String code;
    public FastPayData data;
    public FastPayTradeErrorBean error;
    public String process;

    public boolean isResponseOk() {
        if (TextUtils.isEmpty(this.code) == false) goto L5;
    L7:
        return false;
    L5:
        if ("CA0000".equals(this.code) == false) goto L7;
        return true;
    }

    public FastPayResponseBean() {
        this.code = "";
        this.error = new FastPayTradeErrorBean();
        this.data = new FastPayData();
        this.process = "";
    }
}
