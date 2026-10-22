package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPaySubGuideDesc;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayBioOpenGuide implements CJPayObject {
    public String after_open_desc;
    public String bio_type;
    public String cancel_btn_desc;
    public String confirm_btn_desc;
    public String guide_desc;
    public boolean show_guide;
    public ArrayList<CJPaySubGuideDesc> sub_guide_desc;

    public CJPayBioOpenGuide() {
        this.show_guide = false;
        this.confirm_btn_desc = "";
        this.cancel_btn_desc = "";
        this.guide_desc = "";
        this.after_open_desc = "";
        this.bio_type = "";
        this.sub_guide_desc = new ArrayList();
    }
}
