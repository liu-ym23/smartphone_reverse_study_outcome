package com.android.ttcjpaysdk.thirdparty.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.slice.SliceInitService;

/* JADX INFO: loaded from: classes39.dex */
public class FeGuideInfo implements CJPayObject {
    public String guide_data;
    public String guide_type;
    public String url;

    public FeGuideInfo() {
        this.guide_type = "";
        this.url = "";
        this.guide_data = SliceInitService.DEFAULT_SWITCH;
    }
}
