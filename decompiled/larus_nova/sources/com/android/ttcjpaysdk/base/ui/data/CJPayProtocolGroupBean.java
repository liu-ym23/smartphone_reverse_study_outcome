package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayProtocolGroupBean implements CJPayObject, Serializable {
    public String groupDesc;
    public String groupName;

    public CJPayProtocolGroupBean() {
        this.groupName = "";
        this.groupDesc = "";
    }
}
