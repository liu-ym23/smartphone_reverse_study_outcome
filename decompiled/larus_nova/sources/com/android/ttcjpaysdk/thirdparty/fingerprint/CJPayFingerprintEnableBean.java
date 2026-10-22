package com.android.ttcjpaysdk.thirdparty.fingerprint;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayFingerprintEnableBean implements CJPayObject, Serializable {
    public CJPayButtonInfo button_info;
    public String code;
    public String msg;
    public String token_file_str;

    public CJPayFingerprintEnableBean() {
        this.code = "";
        this.msg = "";
        this.token_file_str = "";
        this.button_info = new CJPayButtonInfo();
    }
}
