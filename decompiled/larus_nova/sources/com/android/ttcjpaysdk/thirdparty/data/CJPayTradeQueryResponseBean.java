package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayTradeQueryResponseBean implements CJPayObject, Serializable {
    public CJPayButtonInfo button_info;
    public String code;
    public CJPayMerchantInfo merchant_info;
    public String msg;
    public ArrayList<PayInfo> pay_info;
    public CJPayResultPageShowConf result_page_show_conf;
    public CJPayUserInfo user_info;
    public ArrayList<Voucher> voucher_details;

    public static class AccountInfo implements CJPayObject, Serializable {
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
            CJBasicCommonUtils.reportCatchException("CJPayTradeQueryResponseBean#toJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeQueryResponseBean#toJson", e);
            e.printStackTrace();
            return null;
        }

        public AccountInfo() {
            this.account_type = "";
            this.account = "";
            this.account_name = "";
        }
    }

    public static class PayInfo implements CJPayObject, Serializable {
        public AccountInfo account_info;
        public int amount;
        public String color_type;
        public String desc;
        public String half_screen_desc;
        public String icon;
        public String name;
        public String paytype;
        public String type_mark;

        public String toJsonString() {
            JSONObject r100 = new JSONObject();
            int r101 = this.amount;     // Catch: JSONException -> L29
            if (r101 <= 0) goto L7;
            r100.put("amount", r101);     // Catch: JSONException -> L29
        L7:
            if (TextUtils.isEmpty(this.paytype) == true) goto L9;
            r100.put("paytype", this.paytype);     // Catch: JSONException -> L29
        L9:
            AccountInfo r102 = this.account_info;     // Catch: JSONException -> L29
            if (r102 == null) goto L13;
            r100.put("process_info", r102.toJson());     // Catch: JSONException -> L29
        L13:
            if (TextUtils.isEmpty(this.name) == true) goto L16;
            r100.put("name", this.name);     // Catch: JSONException -> L29
        L16:
            if (TextUtils.isEmpty(this.desc) == true) goto L19;
            r100.put(SocialConstants.PARAM_APP_DESC, this.desc);     // Catch: JSONException -> L29
        L19:
            if (TextUtils.isEmpty(this.color_type) == true) goto L22;
            r100.put("color_type", this.color_type);     // Catch: JSONException -> L29
        L22:
            if (TextUtils.isEmpty(this.type_mark) == true) goto L25;
            r100.put("type_mark", this.type_mark);     // Catch: JSONException -> L29
        L25:
            if (TextUtils.isEmpty(this.icon) == true) goto L27;
            r100.put("icon", this.icon);     // Catch: JSONException -> L29
        L27:
            return r100.toString();
        L29:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayTradeQueryResponseBean#toJsonString", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeQueryResponseBean#toJsonString", e);
            e.printStackTrace();
            return "";
        }

        public PayInfo() {
            this.amount = 0;
            this.paytype = "";
            this.account_info = new AccountInfo();
            this.name = "";
            this.desc = "";
            this.color_type = "";
            this.type_mark = "";
            this.half_screen_desc = "";
        }
    }

    public static class Voucher implements CJPayObject, Serializable {
        public String credit_pay_installment;
        public String exts;
        public String front_bank_code;
        public String label;
        public int used_amount;
        public String voucher_name;
        public String voucher_no;
        public String voucher_type;

        public Voucher() {
            this.voucher_no = "";
            this.voucher_type = "";
            this.front_bank_code = "";
            this.label = "";
            this.voucher_name = "";
            this.credit_pay_installment = "";
            this.exts = "";
        }
    }

    public CJPayTradeQueryResponseBean() {
        this.code = "";
        this.msg = "";
        this.pay_info = new ArrayList();
        this.merchant_info = new CJPayMerchantInfo();
        this.user_info = new CJPayUserInfo();
        this.result_page_show_conf = new CJPayResultPageShowConf();
        this.button_info = new CJPayButtonInfo();
        this.voucher_details = new ArrayList();
    }
}
