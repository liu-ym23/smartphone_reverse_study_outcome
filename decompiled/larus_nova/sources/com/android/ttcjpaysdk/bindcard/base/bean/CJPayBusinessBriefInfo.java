package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBusinessBriefInfo implements CJPayObject, Serializable {
    public String brief_title;
    public String display_desc;
    public String display_url;
    public String input_display_desc;
    public String input_display_icon;

    public CJPayBusinessBriefInfo() {
        this.display_desc = "";
        this.display_url = "";
        this.brief_title = "";
        this.input_display_desc = "";
        this.input_display_icon = "";
    }
}
