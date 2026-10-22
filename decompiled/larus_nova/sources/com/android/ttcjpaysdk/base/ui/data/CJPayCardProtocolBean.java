package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCardProtocolBean implements CJPayObject, Serializable {
    public boolean default_choose;
    public String group;
    public String name;
    public String protocol_no;
    public String template_url;

    public CJPayCardProtocolBean() {
        this.name = "";
        this.template_url = "";
        this.protocol_no = "";
        this.group = "";
        this.default_choose = false;
    }
}
