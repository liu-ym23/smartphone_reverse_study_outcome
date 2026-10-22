package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayUserInfo implements Serializable, CJPayObject {
    public static final String PWD_CHECK_CARRIER = "13";
    public static final String PWD_CHECK_CVV = "7";
    public static final String PWD_CHECK_FACE = "11";
    public static final String PWD_CHECK_FINGERPRINT = "1";
    public static final String PWD_CHECK_NOTHING = "5";
    public static final String PWD_CHECK_PWD = "0";
    public static final String PWD_CHECK_SMS_CODE = "8";
    public static final String PWD_CHECK_TOKEN = "6";
    public static final String PWD_CHECK_VOICE_PRINT = "12";
    public static final String PWD_NOT_CHECK_PWD = "3";
    public String account_mobile_mask;
    public String add_pwd_url;
    public CJPayAppUserInfo app_user_info;
    public String auth_status;
    public String auth_url;
    public long balance_amount;
    public String bind_url;
    public String certificate_num;
    public String certificate_type;
    public String charge_withdraw_style;
    public String complete_hint_title;
    public String complete_left_text;
    public String complete_lynx_url;
    public int complete_order_times;
    public String complete_right_text;
    public String complete_type;
    public String complete_url;
    public String declive_url;
    public ExtInfo ext_info;
    public HashMap<String, String> ext_info_pb;
    public String find_pwd_url;
    public boolean has_signed_cards;
    public String invoke_wild_card_pwd_check_way;
    public boolean is_new_user;
    public String jruid;
    public String lynx_auth_url;
    public String m_name;
    public int member_pay_id_state;
    public String mid;
    public String mobile;
    public boolean need_auth_guide;
    public boolean need_complete_user_info;
    public boolean need_set_pwd_after_pay;
    public boolean need_show_user_info;
    public List<String> opened_check_ways;
    public boolean pay_after_use_active;
    public String pay_uid;
    public String pwd_check_way;
    public String pwd_status;
    public String real_check_type;
    public String real_check_type_supplementary;
    public String real_name_auth_url;
    public String uid;

    public static class ExtInfo implements Serializable, CJPayObject {
        public String pwd_first_input_tips;
        public String pwd_first_page_title;
        public String pwd_mode;
        public String pwd_second_input_tips;
        public String pwd_second_page_title;
        public String pwd_type;

        public ExtInfo() {
            this.pwd_type = "";
            this.pwd_mode = "";
            this.pwd_first_page_title = "";
            this.pwd_first_input_tips = "";
            this.pwd_second_page_title = "";
            this.pwd_second_input_tips = "";
        }
    }

    public void afterProtoDecode() {
        HashMap<String, String> r100 = this.ext_info_pb;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get("pwd_type") == null) goto L8;
        ExtInfo r101 = this.ext_info;
        r101.pwd_type = this.ext_info_pb.get("pwd_type");
    L8:
        if (this.ext_info_pb.get("pwd_mode") == null) goto L11;
        ExtInfo r102 = this.ext_info;
        r102.pwd_mode = this.ext_info_pb.get("pwd_mode");
    L11:
        if (this.ext_info_pb.get("pwd_first_page_title") == null) goto L14;
        ExtInfo r103 = this.ext_info;
        r103.pwd_first_page_title = this.ext_info_pb.get("pwd_first_page_title");
    L14:
        if (this.ext_info_pb.get("pwd_first_input_tips") == null) goto L17;
        ExtInfo r104 = this.ext_info;
        r104.pwd_first_input_tips = this.ext_info_pb.get("pwd_first_input_tips");
    L17:
        if (this.ext_info_pb.get("pwd_second_page_title") == null) goto L20;
        ExtInfo r105 = this.ext_info;
        r105.pwd_second_page_title = this.ext_info_pb.get("pwd_second_page_title");
    L20:
        if (this.ext_info_pb.get("pwd_second_input_tips") == null) goto L22;
        ExtInfo r106 = this.ext_info;
        r106.pwd_second_input_tips = this.ext_info_pb.get("pwd_second_input_tips");
    L22:
        this.ext_info_pb = null;
    }

    public boolean hasPass() {
        return !TextUtils.equals(this.pwd_status, "0");
    }

    public boolean isNeedAddPwd() {
        if (TextUtils.equals(this.auth_status, "1") == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(this.pwd_status, "0") == false) goto L9;
        if (TextUtils.isEmpty(this.add_pwd_url) == true) goto L9;
        return true;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("auth_url", this.auth_url);     // Catch: JSONException -> L5
        r100.put("certificate_num", this.certificate_num);     // Catch: JSONException -> L5
        r100.put("certificate_type", this.certificate_type);     // Catch: JSONException -> L5
        r100.put("m_name", this.m_name);     // Catch: JSONException -> L5
        r100.put("mobile", this.mobile);     // Catch: JSONException -> L5
        r100.put("mid", this.mid);     // Catch: JSONException -> L5
        r100.put("uid", this.uid);     // Catch: JSONException -> L5
        r100.put("find_pwd_url", this.find_pwd_url);     // Catch: JSONException -> L5
        r100.put("declive_url", this.declive_url);     // Catch: JSONException -> L5
        r100.put("pwd_check_way", this.pwd_check_way);     // Catch: JSONException -> L5
        r100.put("balance_amount", this.balance_amount);     // Catch: JSONException -> L5
        r100.put("pay_uid", this.pay_uid);     // Catch: JSONException -> L5
        r100.put("pay_after_use_active", this.pay_after_use_active);     // Catch: JSONException -> L5
        r100.put("has_signed_cards", this.has_signed_cards);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayUserInfo#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayUserInfo#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayUserInfo() {
        this.auth_url = "";
        this.lynx_auth_url = "";
        this.certificate_num = "";
        this.certificate_type = "";
        this.m_name = "";
        this.mobile = "";
        this.account_mobile_mask = "";
        this.mid = "";
        this.uid = "";
        this.find_pwd_url = "";
        this.add_pwd_url = "";
        this.pwd_status = "";
        this.declive_url = "";
        this.bind_url = "";
        this.pwd_check_way = "";
        this.ext_info = new ExtInfo();
        this.ext_info_pb = null;
        this.invoke_wild_card_pwd_check_way = "";
        this.balance_amount = 0;
        this.pay_uid = "";
        this.need_complete_user_info = false;
        this.complete_hint_title = "";
        this.complete_right_text = "";
        this.complete_left_text = "";
        this.complete_url = "";
        this.complete_lynx_url = "";
        this.complete_type = "";
        this.complete_order_times = 1;
        this.jruid = "";
        this.app_user_info = null;
        this.charge_withdraw_style = "v1";
        this.real_check_type = "";
        this.real_check_type_supplementary = "";
        this.real_name_auth_url = "";
        this.need_auth_guide = false;
        this.need_set_pwd_after_pay = false;
        this.need_show_user_info = false;
    }

    public boolean isHitExperimentGroup() {
        if ("v2".equals(this.charge_withdraw_style) == false) goto L5;
    L10:
        return true;
    L5:
        if ("v3".equals(this.charge_withdraw_style) == true) goto L10;
        if (DevicePlans.DEVICE_PLAN_VIVO4.equals(this.charge_withdraw_style) == true) goto L10;
        return false;
    }

    public boolean isShowVoucherInvolveExperiment() {
        return DevicePlans.DEVICE_PLAN_VIVO4.equals(this.charge_withdraw_style);
    }

    public String toJsonString() {
        JSONObject r100 = toJson();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.toString();
    }
}
