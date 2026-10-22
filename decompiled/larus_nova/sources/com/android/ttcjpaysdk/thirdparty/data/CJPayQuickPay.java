package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayQuickPay implements CJPayObject, Serializable {
    public ArrayList<CJPayCard> cards;
    public ArrayList<CJPayCard> discount_banks;
    public String discount_bind_card_msg;
    public String enable_bind_card;
    public String enable_bind_card_msg;
    public String mark;
    public String msg;
    public String status;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_title;
    public boolean withdrawal_charge;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("cards", toJsonArray(this.cards));     // Catch: JSONException -> L5
        r100.put("discount_banks", toJsonArray(this.discount_banks));     // Catch: JSONException -> L5
        r100.put("msg", this.msg);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put("mark", this.mark);     // Catch: JSONException -> L5
        r100.put("enable_bind_card", this.enable_bind_card);     // Catch: JSONException -> L5
        r100.put("enable_bind_card_msg", this.enable_bind_card_msg);     // Catch: JSONException -> L5
        r100.put("discount_bind_card_msg", this.discount_bind_card_msg);     // Catch: JSONException -> L5
        r100.put("tt_mark", this.tt_mark);     // Catch: JSONException -> L5
        r100.put("tt_title", this.tt_title);     // Catch: JSONException -> L5
        r100.put("tt_sub_title", this.tt_sub_title);     // Catch: JSONException -> L5
        r100.put("tt_icon_url", this.tt_icon_url);     // Catch: JSONException -> L5
        r100.put("withdrawal_charge", this.withdrawal_charge);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayQuickPay#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayQuickPay#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayQuickPay() {
        this.cards = new ArrayList();
        this.discount_banks = new ArrayList();
        this.msg = "";
        this.status = "";
        this.mark = "";
        this.enable_bind_card = "";
        this.enable_bind_card_msg = "";
        this.discount_bind_card_msg = "";
        this.tt_mark = "";
        this.tt_title = "";
        this.tt_sub_title = "";
        this.tt_icon_url = "";
        this.withdrawal_charge = false;
    }

    private JSONArray toJsonArray(ArrayList<CJPayCard> r100) {
        JSONArray r101 = new JSONArray();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101.put(((CJPayCard) ListProtector.get(r100, r102)).toJson());
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public String getDiscountBankInfo(String r100) {
        Iterator<CJPayCard> r101 = this.discount_banks.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        CJPayCard r102 = r101.next();
        if (TextUtils.equals(r100, r102.bank_code) == false) goto L4;
        return r102.bank_name.concat(r102.card_type_name);
    L9:
        return "";
    }
}
