package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCardItem implements Serializable, CJPayObject {
    public String bank_card_id;
    public String certificate_num;
    public String certificate_type;
    public boolean is_foreign_card;
    public String true_name;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("bank_card_id", this.bank_card_id);     // Catch: JSONException -> L5
        r100.put("true_name", this.true_name);     // Catch: JSONException -> L5
        r100.put("certificate_num", this.certificate_num);     // Catch: JSONException -> L5
        r100.put("certificate_type", this.certificate_type);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCardItem#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCardItem#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCardItem() {
        this.bank_card_id = "";
        this.true_name = "";
        this.certificate_num = "";
        this.certificate_type = "";
        this.is_foreign_card = false;
    }
}
