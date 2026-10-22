package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class PromotionProcessInfo implements CJPayObject {
    public long create_time;
    public String process_id;
    public String process_info;

    public PromotionProcessInfo() {
        this.process_id = "";
        this.process_info = "";
    }
}
