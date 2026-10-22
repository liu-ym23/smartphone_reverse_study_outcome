package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayOneKeyCopyWritingInfo implements CJPayObject, Serializable {
    public String display_desc;
    public String display_icon;
    public String order_display_desc;
    public String order_display_icon;
    public String sub_title;
    public String title;

    public CJPayOneKeyCopyWritingInfo() {
        this.sub_title = "";
        this.title = "";
        this.display_desc = "";
        this.display_icon = "";
        this.order_display_desc = "";
        this.order_display_icon = "";
    }
}
