package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class ForgetPwdInfo implements CJPayObject, Serializable {
    public String action;
    public String desc;
    public String show_style;
    public int times;

    public boolean isNewStyle() {
        if ("next_to_tips".equals(this.show_style) == false) goto L5;
    L8:
        return true;
    L5:
        if ("top_right".equals(this.show_style) == true) goto L8;
        return false;
    }

    public ForgetPwdInfo() {
        this.action = "";
        this.desc = "";
        this.times = -1;
        this.show_style = "";
    }
}
