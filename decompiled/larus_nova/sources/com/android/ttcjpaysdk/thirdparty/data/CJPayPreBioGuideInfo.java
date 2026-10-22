package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.FingerInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPreBioGuideInfo implements CJPayObject, Serializable {
    public String apple_verify_type;
    public String bio_type;
    public String btn_desc;
    public boolean choose;
    public boolean default_hidden;
    public FingerInfo finger_info;
    public boolean guide_show_style;
    public boolean is_show_button;
    public boolean is_visible;
    public String style;
    public String title;

    public CJPayPreBioGuideInfo() {
        this.apple_verify_type = "";
        this.title = "";
        this.bio_type = "";
        this.btn_desc = "";
        this.style = "";
        this.is_show_button = false;
        this.default_hidden = false;
        this.guide_show_style = false;
        this.finger_info = new FingerInfo();
        this.is_visible = true;
    }
}
