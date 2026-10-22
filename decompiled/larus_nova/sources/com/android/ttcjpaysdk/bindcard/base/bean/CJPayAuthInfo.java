package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayAuthInfo implements CJPayObject, Serializable {
    public String id_code_mask;
    public String id_name_mask;
    public String id_type;

    public CJPayAuthInfo() {
        this.id_type = "";
        this.id_code_mask = "";
        this.id_name_mask = "";
    }
}
