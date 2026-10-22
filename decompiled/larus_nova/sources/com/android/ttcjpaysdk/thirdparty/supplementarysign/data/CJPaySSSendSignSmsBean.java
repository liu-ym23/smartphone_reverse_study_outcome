package com.android.ttcjpaysdk.thirdparty.supplementarysign.data;

import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySSSendSignSmsBean extends CJPaySSBaseBean {
    public CJPayButtonInfo button_info;
    public String sms_token;

    public CJPaySSSendSignSmsBean() {
        this.sms_token = "";
        this.button_info = new CJPayButtonInfo();
    }
}
