package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBindCardBaseBean implements CJPayObject, Serializable {
    public String code;
    public String msg;
    public String status;

    public boolean isResponseOK() {
        if (TextUtils.equals("MP000000", this.code) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals("CD000000", this.code) == true) goto L8;
        return false;
    }

    public CJPayBindCardBaseBean() {
        this.status = "";
        this.code = "";
        this.msg = "";
    }
}
