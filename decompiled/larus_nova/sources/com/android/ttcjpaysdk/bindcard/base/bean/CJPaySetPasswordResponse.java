package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySetPasswordResponse implements CJPayObject {
    public com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo button_info;
    public CJPayFrontBindCardInfo card_info;
    public String code;
    public String msg;
    public String status;
    public String token;

    public boolean isResponseOK() {
        return TextUtils.equals("MP000000", this.code);
    }

    public CJPaySetPasswordResponse() {
        this.status = "";
        this.code = "";
        this.msg = "";
        this.token = "";
        this.button_info = new com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo();
        this.card_info = new CJPayFrontBindCardInfo();
    }
}
