package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayWithoutPwdResponse implements CJPayObject {
    public static final String SUCCESS_CODE = "CD000000";
    public static final String SUCCESS_STATUS = "SUCCESS";
    public String code;
    public String msg;
    public String nopwd_button_text;
    public String nopwd_modify_result;
    public String nopwd_open_result;

    public CJPayWithoutPwdResponse() {
        this.code = "";
        this.msg = "";
        this.nopwd_open_result = "";
        this.nopwd_button_text = "";
        this.nopwd_modify_result = "";
    }
}
