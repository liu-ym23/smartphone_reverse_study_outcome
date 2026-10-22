package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySmsSignBean extends CJPayBindCardBaseBean {
    public String activity_info;
    public String bank_card_id;
    public String bind_card_ext;
    public CJPayButtonInfo button_info;
    public CJPayFrontBindCardInfo card_info;
    public CJPayBindCardCommonBean commonBean;
    public String cvv;
    public CJPayTradeConfirmBizContentParams.ForeignCardPayExt foreign_card_pay_ext;
    public boolean isNeedCardInfo;
    public boolean isUnionPay;
    public String payUid;
    public String pwd_token;
    public String sign_no;

    public JSONObject getPayParams() {
        JSONObject r100 = new JSONObject();
        r100.put("sign_no", this.sign_no);     // Catch: JSONException -> L5
        r100.put("bank_card_id", this.bank_card_id);     // Catch: JSONException -> L5
        r100.put("pwd_token", this.pwd_token);     // Catch: JSONException -> L5
        r100.put("cvv", this.cvv);     // Catch: JSONException -> L5
        r100.put("bind_card_ext", this.bind_card_ext);     // Catch: JSONException -> L5
        r100.put("process_info", this.commonBean.processInfo);     // Catch: JSONException -> L5
        r100.put("member_biz_order_no", this.commonBean.signOrderNo);     // Catch: JSONException -> L5
        r100.put("foreign_card_pay_ext", CJPayJsonParser.toJsonObject(this.foreign_card_pay_ext));     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySmsSignBean#getPayParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySmsSignBean#getPayParams", e);
        goto L7
    }

    public String toString() {
        return "CJPaySmsSignResponse{, code='" + this.code + "', msg='" + this.msg + "', sign_no='" + this.sign_no + "', bank_card_id='" + this.bank_card_id + "', pwd_token='" + this.pwd_token + "'}";
    }

    public CJPaySmsSignBean() {
        this.sign_no = "";
        this.bank_card_id = "";
        this.pwd_token = "";
        this.cvv = "";
        this.button_info = new CJPayButtonInfo();
        this.card_info = new CJPayFrontBindCardInfo();
        this.payUid = "";
        this.commonBean = new CJPayBindCardCommonBean();
        this.isNeedCardInfo = false;
        this.activity_info = "[]";
        this.isUnionPay = false;
        this.bind_card_ext = "";
    }
}
