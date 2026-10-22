package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySendSmsResponseBean implements CJPayObject {
    public CJPayButtonInfo button_info;
    public String code;
    public String desc;
    public String mobile;
    public String msg;

    public CJPaySendSmsResponseBean() {
        this.code = "";
        this.msg = "";
        this.desc = "";
        this.mobile = "";
        this.button_info = new CJPayButtonInfo();
    }
}
