package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayButtonInfo implements CJPayObject, Serializable {
    public int action;
    public String button_desc;
    public String button_status;
    public String button_type;
    public String error_code;
    public String find_pwd_url;
    public int left_button_action;
    public String left_button_desc;
    public String main_title;
    public String page_desc;
    public int right_button_action;
    public String right_button_desc;

    public boolean isGoCustomerServiceDialog() {
        return hasAction(13);
    }

    public boolean isShow() {
        return TextUtils.equals("1", this.button_status);
    }

    public com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo toStandardCJPayButtonInfo() {
        com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo r100 = new com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo();
        r100.page_desc = this.page_desc;
        r100.button_desc = this.button_desc;
        r100.button_type = this.button_type;
        r100.action = this.action;
        r100.left_button_action = this.left_button_action;
        r100.left_button_desc = this.left_button_desc;
        r100.right_button_action = this.right_button_action;
        r100.right_button_desc = this.right_button_desc;
        r100.button_status = this.button_status;
        r100.error_code = this.error_code;
        r100.find_pwd_url = this.find_pwd_url;
        r100.main_title = this.main_title;
        return r100;
    }

    public CJPayButtonInfo() {
        this.page_desc = "";
        this.button_desc = "";
        this.button_type = "";
        this.action = 0;
        this.left_button_desc = "";
        this.left_button_action = 0;
        this.right_button_desc = "";
        this.right_button_action = 0;
        this.button_status = "";
        this.find_pwd_url = "";
        this.error_code = "";
        this.main_title = "";
    }

    private boolean hasAction(int r100) {
        if (this.action != r100) goto L5;
    L10:
        return true;
    L5:
        if (this.left_button_action == r100) goto L10;
        if (this.right_button_action == r100) goto L10;
        return false;
    }
}
