package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayTradeConfirmBizContentParams extends CJPayTradeConfirmBizContentBasicParams {
    public CJPayRiskInfo risk_info;

    public static class DoubleCheckReq implements CJPayObject {
        private static final String TAG = "DoubleCheckReq";
        public String verifyId;
        public String verifyToken;

        public JSONObject toJson() {
            JSONObject r100 = new JSONObject();
        L10:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJson", e);
            CJLogger.b(TAG, e.getMessage());
            return null;
        L4:
            if (TextUtils.isEmpty(this.verifyId) == true) goto L7;
            r100.put("verifyId", this.verifyId);     // Catch: JSONException -> L10
        L7:
            if (TextUtils.isEmpty(this.verifyToken) == true) goto L9;
            r100.put("verifyToken", this.verifyToken);     // Catch: JSONException -> L10
        L9:
            return r100;
        }

        public DoubleCheckReq() {
            this.verifyId = "";
            this.verifyToken = "";
        }
    }

    public static class ForeignCardPayExt implements CJPayObject {
        public String client_reference_information_code;
        public String device_information;
        public String finger_print_session_id;
        public String reference_id;
        public String return_url;

        public ForeignCardPayExt() {
        }
    }

    public static class PreParams implements CJPayObject {
        public String currency;
        public String sign_no;
        public String token;
        public long total_amount;

        public PreParams() {
        }

        public JSONObject toJson() {
            JSONObject r100 = new JSONObject();
            r100.put("total_amount", this.total_amount);     // Catch: JSONException -> L5
            r100.put("currency", this.currency);     // Catch: JSONException -> L5
            r100.put("sign_no", this.sign_no);     // Catch: JSONException -> L5
            r100.put("token", this.token);     // Catch: JSONException -> L5
            return r100;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#toJson", e);
            e.printStackTrace();
            return null;
        }
    }

    public static class PreQueryWithdrawInfo implements CJPayObject {
        public long arrival_amount;
        public long withdrawal_fee;
        public long withdrawal_free_quota;

        public PreQueryWithdrawInfo() {
        }
    }

    public CJPayTradeConfirmBizContentParams() {
    }

    private JSONObject mapToJSONObj(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L12
    L8:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, String> r103 = r102.next();     // Catch: JSONException -> L12
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L12
        goto L8
    L11:
        return r101;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#mapToJSONObj", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#mapToJSONObj", e);
        e.printStackTrace();
        return null;
    }

    public String toJsonString(CJEncryptScene r110) {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L201
        String r101 = this.trade_no;     // Catch: JSONException -> L201
        if (r101 == null) goto L7;
        r100.put(b.B0, r101);     // Catch: JSONException -> L201
    L7:
        if (TextUtils.isEmpty(this.sign_no) == true) goto L9;
        r100.put("sign_no", this.sign_no);     // Catch: JSONException -> L201
    L9:
        long r102 = this.trade_amount;     // Catch: JSONException -> L201
        if (r102 <= 0) goto L12;
        r100.put("trade_amount", r102);     // Catch: JSONException -> L201
    L12:
        long r103 = this.pay_amount;     // Catch: JSONException -> L201
        if (r103 <= 0) goto L15;
        r100.put("pay_amount", r103);     // Catch: JSONException -> L201
    L15:
        String r104 = this.merchant_id;     // Catch: JSONException -> L201
        if (r104 == null) goto L18;
        r100.put("merchant_id", r104);     // Catch: JSONException -> L201
    L18:
        String r105 = this.pay_type;     // Catch: JSONException -> L201
        if (r105 == null) goto L21;
        r100.put("pay_type", r105);     // Catch: JSONException -> L201
    L21:
        String r106 = this.channel_pay_type;     // Catch: JSONException -> L201
        if (r106 == null) goto L24;
        r100.put("channel_pay_type", r106);     // Catch: JSONException -> L201
    L24:
        CJPayProcessInfo r107 = this.process_info;     // Catch: JSONException -> L201
        if (r107 == null) goto L27;
        r100.put("process_info", r107.toJson());     // Catch: JSONException -> L201
    L27:
        CJPayAccountInfo r108 = this.account_info;     // Catch: JSONException -> L201
        if (r108 == null) goto L30;
        r100.put("account_info", r108.toJson());     // Catch: JSONException -> L201
    L30:
        CJPayRiskInfo r109 = this.risk_info;     // Catch: JSONException -> L201
        if (r109 == null) goto L33;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r109.toJson());     // Catch: JSONException -> L201
    L33:
        String r111 = this.pwd;     // Catch: JSONException -> L201
        if (r111 == null) goto L36;
        r100.put("pwd", r111);     // Catch: JSONException -> L201
    L36:
        String r112 = this.verify_id;     // Catch: JSONException -> L201
        if (r112 == null) goto L39;
        r100.put("verify_id", r112);     // Catch: JSONException -> L201
    L39:
        String r113 = this.pwd_type;     // Catch: JSONException -> L201
        if (r113 == null) goto L42;
        r100.put("pwd_type", r113);     // Catch: JSONException -> L201
    L42:
        CJPayCardItem r114 = this.card_item;     // Catch: JSONException -> L201
        if (r114 == null) goto L45;
        r100.put("card_item", r114.toJson());     // Catch: JSONException -> L201
    L45:
        CJPayCreditItem r115 = this.credit_item;     // Catch: JSONException -> L201
        if (r115 == null) goto L48;
        r100.put("credit_item", r115.toJson());     // Catch: JSONException -> L201
    L48:
        String r116 = this.sms;     // Catch: JSONException -> L201
        if (r116 == null) goto L51;
        r100.put("sms", r116);     // Catch: JSONException -> L201
    L51:
        String r117 = this.req_type;     // Catch: JSONException -> L201
        if (r117 == null) goto L54;
        r100.put("req_type", r117);     // Catch: JSONException -> L201
    L54:
        CJPaySecureRequestParams r118 = this.secure_request_params;     // Catch: JSONException -> L201
        if (r118 == null) goto L59;
        if (r110 != null) goto L58;
        r110 = CJEncryptScene.UNKNOWN;     // Catch: JSONException -> L201
    L58:
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r118.toJson(r110));     // Catch: JSONException -> L201
    L59:
        PreParams r119 = this.pre_params;     // Catch: JSONException -> L201
        if (r119 == null) goto L63;
        r100.put("pre_params", r119.toJson());     // Catch: JSONException -> L201
    L63:
        if (TextUtils.isEmpty(this.token) == true) goto L65;
        r100.put("token", this.token);     // Catch: JSONException -> L201
    L65:
        String r120 = this.cvv;     // Catch: JSONException -> L201
        if (r120 == null) goto L68;
        r100.put("cvv", r120);     // Catch: JSONException -> L201
    L68:
        Map<String, String> r121 = this.params;     // Catch: JSONException -> L201
        if (r121 == null) goto L73;
        JSONObject r122 = mapToJSONObj(r121);     // Catch: JSONException -> L201
        if (r122 == null) goto L73;
        r100.put("params", r122);     // Catch: JSONException -> L201
    L73:
        String r123 = this.cert_code;     // Catch: JSONException -> L201
        if (r123 == null) goto L76;
        r100.put(EventConstant.Key.CERT_CODE, r123);     // Catch: JSONException -> L201
    L76:
        String r124 = this.cert_type;     // Catch: JSONException -> L201
        if (r124 == null) goto L79;
        r100.put("cert_type", r124);     // Catch: JSONException -> L201
    L79:
        CJPayOneTimePwd r125 = this.one_time_pwd;     // Catch: JSONException -> L201
        if (r125 == null) goto L82;
        r100.put("one_time_pwd", r125.toJson());     // Catch: JSONException -> L201
    L82:
        String r126 = this.combine_type;     // Catch: JSONException -> L201
        if (r126 == null) goto L85;
        r100.put("combine_type", r126);     // Catch: JSONException -> L201
    L85:
        r100.put("nonblock_anti_laundering_canceled", this.nonblock_anti_laundering_canceled);     // Catch: JSONException -> L201
        r100.put("selected_open_nopwd", this.selected_open_nopwd);     // Catch: JSONException -> L201
        r100.put("no_pwd_confirm_hide_period", this.no_pwd_confirm_hide_period);     // Catch: JSONException -> L201
        CJPayFaceVerifyParam r127 = this.face_verify_params;     // Catch: JSONException -> L201
        if (r127 == null) goto L88;
        r100.put("face_verify_params", r127.toJson());     // Catch: JSONException -> L201
    L88:
        ArrayList<String> r128 = this.voucher_no_list;     // Catch: JSONException -> L201
        if (r128 != null) goto L91;
    L101:
        ArrayList<String> r129 = this.pay_addi_type_list;     // Catch: JSONException -> L201
        if (r129 == null) goto L115;
        if (r129.isEmpty() == true) goto L115;
        JSONArray r130 = new JSONArray();     // Catch: JSONException -> L201
        Iterator<String> r131 = this.pay_addi_type_list.iterator();     // Catch: JSONException -> L201
    L107:
        if (r131.hasNext() == false) goto L113;
        r130.put(r131.next());     // Catch: Exception -> L111
    L111:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#JSONArray", e);     // Catch: JSONException -> L201
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#JSONArray", e);     // Catch: JSONException -> L201
        goto L107
    L113:
        r100.put("pay_addi_type_list", r130);     // Catch: JSONException -> L201
    L115:
        if (this.expanded == false) goto L118;
        r100.put("expanded", true);     // Catch: JSONException -> L201
    L118:
        if (TextUtils.isEmpty(this.promotion_scene) == true) goto L120;
        r100.put("promotion_scene", this.promotion_scene);     // Catch: JSONException -> L201
    L120:
        JSONObject r132 = this.exts;     // Catch: JSONException -> L201
        if (r132 == null) goto L125;
        r100.put("exts", r132);     // Catch: JSONException -> L201
    L125:
        if (this.user_retain_info == null) goto L132;
        if (r100.has("exts") == false) goto L130;
        r100.optJSONObject("exts").put("user_retain_info", this.user_retain_info.toJson());     // Catch: JSONException -> L201
        goto L132
    L130:
        r100.put("exts", new JSONObject().put("user_retain_info", this.user_retain_info.toJson()));     // Catch: JSONException -> L201
    L132:
        if (this.verify_info != null) goto L135;
    L138:
        ForeignCardPayExt r133 = this.foreign_card_pay_ext;     // Catch: JSONException -> L201
        if (r133 == null) goto L143;
        r100.put("foreign_card_pay_ext", CJPayJsonParser.toJsonObject(r133));     // Catch: JSONException -> L201
    L143:
        if (r100.has("exts") == false) goto L145;
        r100.optJSONObject("exts").put("is_click_open_bio_guide", this.is_click_open_bio_guide);     // Catch: JSONException -> L201
    L147:
        if (TextUtils.isEmpty(this.extension) == false) goto L211;
    L157:
        String r134 = this.face_pay_scene;     // Catch: JSONException -> L201
        if (r134 == null) goto L161;
        r100.put("face_pay_scene", r134);     // Catch: JSONException -> L201
    L161:
        if (TextUtils.isEmpty(this.deduct_params) == true) goto L163;
        r100.put("deduct_params", this.deduct_params);     // Catch: JSONException -> L201
    L163:
        PreQueryWithdrawInfo r135 = this.pre_query_withdraw_info;     // Catch: JSONException -> L201
        if (r135 == null) goto L167;
        r100.put("pre_query_withdraw_info", CJPayJsonParser.toJsonObject(r135));     // Catch: JSONException -> L201
    L167:
        if (TextUtils.isEmpty(this.share_asset_id) == true) goto L170;
        r100.put("share_asset_id", this.share_asset_id);     // Catch: JSONException -> L201
    L170:
        if (TextUtils.isEmpty(this.fund_bill_index) == true) goto L172;
        r100.put("fund_bill_index", this.fund_bill_index);     // Catch: JSONException -> L201
    L172:
        TextUtils.isEmpty(this.uniqueSymbol);     // Catch: JSONException -> L201
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r136 = this.asset_meta_info_list;     // Catch: JSONException -> L201
        if (r136 != null) goto L175;
    L185:
        DoubleCheckReq r137 = this.double_check_req;     // Catch: JSONException -> L201
        if (r137 == null) goto L188;
        r100.put("double_check_req", r137.toJson());     // Catch: JSONException -> L201
    L188:
        JSONObject r138 = this.o_server_params;     // Catch: JSONException -> L201
        if (r138 == null) goto L199;
        Iterator<String> r139 = r138.keys();     // Catch: JSONException -> L201
    L204:
    L197:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        CJReporter r140 = CJReporter.f202294a;     // Catch: JSONException -> L201
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "json_parser_exception", 2, e);     // Catch: JSONException -> L201
        goto L199
    L192:
        if (r139.hasNext() == false) goto L199;
        String r141 = r139.next();     // Catch: Exception -> L197
        if (r100.has(r141) == true) goto L204;
        r100.put(r141, this.o_server_params.get(r141));     // Catch: Exception -> L197
    L199:
        return r100.toString();
    L175:
        if (r136.isEmpty() == true) goto L185;
        JSONArray r142 = new JSONArray();     // Catch: JSONException -> L201
        Iterator<AssetInfoBean.AssetMetaInfoBean> r143 = this.asset_meta_info_list.iterator();     // Catch: JSONException -> L201
    L178:
        if (r143.hasNext() == false) goto L184;
        r142.put(CJPayJsonParser.toJsonObject(r143.next()));     // Catch: Exception -> L182
    L182:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        goto L178
    L184:
        r100.put("asset_meta_info_list", r142);     // Catch: JSONException -> L201
        goto L185
    L211:
        String r144 = new JSONObject(this.extension).optString("X-BytePay-SampleHit", "");     // Catch: JSONException -> L155
        if (TextUtils.isEmpty(r144) == false) goto L151;
    L210:
    L151:
        if (r100.has("exts") == false) goto L153;
        r100.optJSONObject("exts").put("X-BytePay-SampleHit", r144);     // Catch: JSONException -> L155
        goto L210
    L153:
        r100.put("exts", new JSONObject().put("X-BytePay-SampleHit", r144));     // Catch: JSONException -> L155
    L155:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        goto L157
    L145:
        r100.put("exts", new JSONObject().put("is_click_open_bio_guide", this.is_click_open_bio_guide));     // Catch: JSONException -> L201
        goto L147
    L135:
        if (r100.has("exts") == false) goto L137;
        r100.optJSONObject("exts").put("verify_info", CJPayJsonParser.toJsonObject(this.verify_info));     // Catch: JSONException -> L201
        goto L138
    L137:
        r100.put("exts", new JSONObject().put("verify_info", CJPayJsonParser.toJsonObject(this.verify_info)));     // Catch: JSONException -> L201
        goto L138
    L91:
        if (r128.isEmpty() == true) goto L101;
        JSONArray r145 = new JSONArray();     // Catch: JSONException -> L201
        Iterator<String> r146 = this.voucher_no_list.iterator();     // Catch: JSONException -> L201
    L94:
        if (r146.hasNext() == false) goto L100;
        r145.put(r146.next());     // Catch: Exception -> L98
    L98:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#toJsonString", e);     // Catch: JSONException -> L201
        goto L94
    L100:
        r100.put("voucher_no_list", r145);     // Catch: JSONException -> L201
    L201:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeConfirmBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeConfirmBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }
}
