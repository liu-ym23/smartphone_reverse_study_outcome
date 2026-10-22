package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class RecommendVerifyInfo implements CJPayObject, Serializable {
    public String button_desc;
    public String cancel_desc;
    public String icon_url;
    public String recommend_desc;
    public String verify_type;

    public RecommendVerifyInfo() {
        this.verify_type = "";
        this.icon_url = "";
        this.recommend_desc = "";
        this.button_desc = "";
        this.cancel_desc = "";
    }
}
