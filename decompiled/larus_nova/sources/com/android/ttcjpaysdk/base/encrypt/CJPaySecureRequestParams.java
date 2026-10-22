package com.android.ttcjpaysdk.base.encrypt;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySecureRequestParams implements Serializable {
    public int check;
    public ArrayList<String> fields;
    public boolean useXinAnEncrypt;

    public CJPaySecureRequestParams() {
        this.check = 0;
        this.fields = new ArrayList();
        this.useXinAnEncrypt = false;
    }

    private JSONArray toJsonArray(ArrayList<String> r100) {
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101.put(ListProtector.get(r100, r102));
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public JSONObject toJson(CJEncryptScene r100) {
        JSONObject r101 = new JSONObject();
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySecureRequestParams#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySecureRequestParams#toJson", e);
        e.printStackTrace();
        return null;
    L4:
        if (this.useXinAnEncrypt == false) goto L6;
        r100 = CJEncryptScene.UNKNOWN;     // Catch: JSONException -> L8
    L6:
        r101.put("version", CJPayEncryptHelper.getEPVersion(r100, true));     // Catch: JSONException -> L8
        r101.put("type1", 2);     // Catch: JSONException -> L8
        r101.put("type2", 1);     // Catch: JSONException -> L8
        r101.put("check", this.check);     // Catch: JSONException -> L8
        r101.put(SlcCommonAction.KEY_PARAMS, toJsonArray(this.fields));     // Catch: JSONException -> L8
        r101.put("support_cert", CJPayEncryptHelper.getSupportCert(r100));     // Catch: JSONException -> L8
        return r101;
    }

    public Map toMap(CJEncryptScene r100, Boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("version", Integer.valueOf(CJPayEncryptHelper.getEPVersion(r100, r101.booleanValue())));
        r102.put("type1", 2);
        r102.put("type2", 1);
        r102.put("check", Integer.valueOf(this.check));
        r102.put(SlcCommonAction.KEY_PARAMS, toJsonArray(this.fields));
        r102.put("support_cert", Integer.valueOf(CJPayEncryptHelper.getSupportCert(r100)));
        return r102;
    }
}
