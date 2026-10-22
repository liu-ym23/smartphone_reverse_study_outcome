package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayVerifyPasswordResponse implements CJPayObject {
    public CJPayButtonInfo button_info;
    public String code;
    public String msg;
    public String remain_lock_desc;
    public int remain_lock_time;
    public int remain_retry_count;
    public String status;

    public boolean isResponseOK() {
        return TextUtils.equals("MP000000", this.code);
    }

    public CJPayVerifyPasswordResponse() {
        this.status = "";
        this.code = "";
        this.msg = "";
        this.remain_retry_count = 0;
        this.remain_lock_time = 0;
        this.remain_lock_desc = "";
        this.button_info = new CJPayButtonInfo();
    }
}
