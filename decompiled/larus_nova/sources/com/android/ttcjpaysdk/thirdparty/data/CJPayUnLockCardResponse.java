package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayUnLockCardResponse implements CJPayObject {
    public String code;
    public String msg;
    public String status;

    public boolean isResponseOK() {
        return TextUtils.equals("MP000000", this.code);
    }

    public CJPayUnLockCardResponse() {
        this.status = "";
        this.code = "";
        this.msg = "";
    }
}
