package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayVerifyLiveDetectBean extends CJPayBindCardBaseBean {
    public String face_content;
    public String face_recognition_type;
    public String name_mask;
    public String ret_status;

    public boolean isNeedRetry() {
        return "MP060005".equals(this.code);
    }

    public boolean isVerifySuccess() {
        return "MP000000".equals(this.code);
    }

    public JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("face_content", this.face_content);     // Catch: JSONException -> L5
        r100.put("face_recognition_type", this.face_recognition_type);     // Catch: JSONException -> L5
        r100.put("name_mask", this.name_mask);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put("code", this.code);     // Catch: JSONException -> L5
        r100.put("msg", this.msg);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayVerifyLiveDetectBean#toJSON", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayVerifyLiveDetectBean#toJSON", e);
        goto L7
    }

    public CJPayVerifyLiveDetectBean() {
        this.ret_status = "";
        this.face_content = "";
        this.face_recognition_type = "";
        this.name_mask = "";
    }
}
