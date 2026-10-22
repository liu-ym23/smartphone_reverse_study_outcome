package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAccountInfo implements Serializable, CJPayObject {
    public String account;
    public String account_name;
    public String account_type;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("account_type", this.account_type);     // Catch: JSONException -> L5
        r100.put("account", this.account);     // Catch: JSONException -> L5
        r100.put("account_name", this.account_name);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayAccountInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayAccountInfo#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayAccountInfo() {
        this.account_type = "";
        this.account = "";
        this.account_name = "";
    }
}
