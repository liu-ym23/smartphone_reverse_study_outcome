package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayOneTimePwd implements Serializable, CJPayObject {
    public boolean is_bio_verify_with_open;
    public String key;
    public String pwd_type;
    public String serial_num;
    public String token_code;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("pwd_type", this.pwd_type);     // Catch: JSONException -> L5
        r100.put("token_code", this.token_code);     // Catch: JSONException -> L5
        r100.put(CJPayFingerprintSharedPrefUtils.KEY_SERIAL_NUM, this.serial_num);     // Catch: JSONException -> L5
        r100.put("key", this.key);     // Catch: JSONException -> L5
        r100.put("is_bio_verify_with_open", this.is_bio_verify_with_open);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayOneTimePwd#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayOneTimePwd#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayOneTimePwd() {
        this.is_bio_verify_with_open = false;
    }
}
