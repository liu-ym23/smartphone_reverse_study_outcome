package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCardSignResponseBean implements CJPayObject, Serializable {
    public ArrayList<CJPayUserAgreement> agreement;
    public CJPayButtonInfo button_info;
    public CJPayCard card;
    public String code;
    public String msg;
    public CJPayProcessInfo process_info;
    public CJPaySignInfo sign_info;
    public CJPayUserInfo user_info;

    public static class CJPaySignInfo implements CJPayObject, Serializable {
        public String sign;
        public String sign_order_no;
        public String smch_id;

        public JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            r100.put("sign", this.sign);     // Catch: JSONException -> L5
            r100.put("sign_order_no", this.sign_order_no);     // Catch: JSONException -> L5
            r100.put(DyVerifyReqConstants.Key.SMCH_ID, this.smch_id);     // Catch: JSONException -> L5
            return r100;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayCardSignResponseBean#toJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayCardSignResponseBean#toJson", e);
            e.printStackTrace();
            return null;
        }

        public CJPaySignInfo() {
            this.sign = "";
            this.sign_order_no = "";
            this.smch_id = "";
        }
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("code", this.code);     // Catch: JSONException -> L5
        r100.put("msg", this.msg);     // Catch: JSONException -> L5
        r100.put("user_info", this.user_info.toJson());     // Catch: JSONException -> L5
        r100.put("agreement", toJsonArray(this.agreement));     // Catch: JSONException -> L5
        r100.put(BrowserDependency.UrlClickType.CARD, this.card.toJson());     // Catch: JSONException -> L5
        r100.put("button_info", this.button_info.toJson());     // Catch: JSONException -> L5
        r100.put("sign_info", this.sign_info.toJson());     // Catch: JSONException -> L5
        r100.put("process_info", this.process_info.toJson());     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCardSignResponseBean#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCardSignResponseBean#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCardSignResponseBean() {
        this.code = "";
        this.msg = "";
        this.user_info = new CJPayUserInfo();
        this.agreement = new ArrayList();
        this.card = new CJPayCard();
        this.button_info = new CJPayButtonInfo();
        this.sign_info = new CJPaySignInfo();
        this.process_info = new CJPayProcessInfo();
    }

    private JSONArray toJsonArray(ArrayList<CJPayUserAgreement> r100) {
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101.put(((CJPayUserAgreement) ListProtector.get(r100, r102)).toJson());
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }
}
