package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class TypeItems implements CJPayObject {
    public String icon_url;
    public String mark;
    public String ptcode;
    public int sign_status;
    public int status;
    public String sub_title;
    public String sub_title_color;
    public String title;
    public String tt_icon_url;
    public String tt_title;

    public TypeItems() {
        this.ptcode = "";
        this.status = 0;
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.sub_title_color = "";
        this.mark = "";
        this.tt_title = "";
        this.tt_icon_url = "";
        this.sign_status = 0;
    }
}
