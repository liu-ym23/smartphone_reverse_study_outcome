package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifySmsVM;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCard implements CJPayObject, Serializable {
    public String background_color;
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public int card_level;
    public String card_no_mask;
    public String card_show_name;
    public String card_type;
    public String card_type_name;
    public String certificate_code_mask;
    public String certificate_type;
    public String channel_icon_url;
    public String end_color;
    public String icon_url;
    public String identity_code_mask;
    public String identity_type;
    public boolean is_freeze_card;
    public String mark;
    public String mobile_mask;
    public String msg;
    public String name_mask;
    public String need_pwd;
    public String need_repaire;
    public boolean need_resign;
    public String need_send_sms;
    public String paymentType;
    public String perday_limit;
    public String perpay_limit;
    public String quickpay_mark;
    public String route_id;
    public String sign_no;
    public String start_color;
    public String status;
    public String true_name_mask;
    public ArrayList<CJPayUserAgreement> user_agreement;
    public CJPayVoucherInfo voucher_info;
    public String withdraw_msg;

    public boolean isCardAvailable() {
        return "1".equals(this.status);
    }

    public boolean isCardInactive() {
        if (this.card_level != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFreezeCard() {
        return "freeze".equals(this.status);
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("status", this.status);     // Catch: JSONException -> L8
        r100.put("msg", this.msg);     // Catch: JSONException -> L8
        r100.put("mark", this.mark);     // Catch: JSONException -> L8
        r100.put("bank_card_id", this.bank_card_id);     // Catch: JSONException -> L8
        r100.put("card_no_mask", this.card_no_mask);     // Catch: JSONException -> L8
        r100.put(a.KEY_CARD_TYPE, this.card_type);     // Catch: JSONException -> L8
        r100.put("card_type_name", this.card_type_name);     // Catch: JSONException -> L8
        r100.put("bank_code", this.bank_code);     // Catch: JSONException -> L8
        r100.put("true_name_mask", this.true_name_mask);     // Catch: JSONException -> L8
        r100.put("bank_name", this.bank_name);     // Catch: JSONException -> L8
        r100.put(UnifyPreVerifySmsVM.KEY_MOBILE_MASK, this.mobile_mask);     // Catch: JSONException -> L8
        r100.put("certificate_code_mask", this.certificate_code_mask);     // Catch: JSONException -> L8
        r100.put("certificate_type", this.certificate_type);     // Catch: JSONException -> L8
        r100.put("need_pwd", this.need_pwd);     // Catch: JSONException -> L8
        r100.put("need_send_sms", this.need_send_sms);     // Catch: JSONException -> L8
        r100.put("need_repaire", this.need_repaire);     // Catch: JSONException -> L8
        r100.put("icon_url", this.icon_url);     // Catch: JSONException -> L8
        r100.put("card_level", this.card_level);     // Catch: JSONException -> L8
        if (this.user_agreement.size() <= 0) goto L6;
        r100.put("user_agreement", toJsonArray(this.user_agreement));     // Catch: JSONException -> L8
    L6:
        r100.put("is_freeze_card", this.is_freeze_card);     // Catch: JSONException -> L8
        r100.put("perday_limit", this.perday_limit);     // Catch: JSONException -> L8
        r100.put("perpay_limit", this.perpay_limit);     // Catch: JSONException -> L8
        r100.put("start_color", this.start_color);     // Catch: JSONException -> L8
        r100.put("end_color", this.end_color);     // Catch: JSONException -> L8
        r100.put("quickpay_mark", this.quickpay_mark);     // Catch: JSONException -> L8
        r100.put("route_id", this.route_id);     // Catch: JSONException -> L8
        r100.put("withdraw_msg", this.withdraw_msg);     // Catch: JSONException -> L8
        r100.put("sign_no", this.sign_no);     // Catch: JSONException -> L8
        r100.put("channel_icon_url", this.channel_icon_url);     // Catch: JSONException -> L8
        r100.put("need_resign", this.need_resign);     // Catch: JSONException -> L8
        return r100;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCard#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCard#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCard() {
        this.status = "";
        this.msg = "";
        this.mark = "";
        this.bank_card_id = "";
        this.card_no_mask = "";
        this.card_type = "";
        this.card_type_name = "";
        this.bank_code = "";
        this.background_color = "";
        this.true_name_mask = "";
        this.bank_name = "";
        this.mobile_mask = "";
        this.certificate_code_mask = "";
        this.certificate_type = "";
        this.need_pwd = "";
        this.need_send_sms = "";
        this.need_repaire = "";
        this.icon_url = "";
        this.card_level = -1;
        this.user_agreement = new ArrayList();
        this.is_freeze_card = false;
        this.perday_limit = "";
        this.perpay_limit = "";
        this.start_color = "";
        this.end_color = "";
        this.quickpay_mark = "";
        this.route_id = "";
        this.withdraw_msg = "";
        this.identity_code_mask = "";
        this.identity_type = "";
        this.name_mask = "";
        this.sign_no = "";
        this.paymentType = "";
        this.card_show_name = "";
        this.voucher_info = new CJPayVoucherInfo();
        this.channel_icon_url = "";
        this.need_resign = false;
    }

    public String toJsonString() {
        JSONObject r100 = toJson();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.toString();
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
