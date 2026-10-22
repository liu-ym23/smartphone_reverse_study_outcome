package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CombineLimitInfo implements CJPayObject, Serializable {
    public String button_desc;
    public String high_light_desc;
    public String page_desc;
    public String page_title;

    public CombineLimitInfo() {
        this.page_title = "";
        this.page_desc = "";
        this.button_desc = "";
        this.high_light_desc = "";
    }
}
