package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPreTradeResponseBean implements CJPayObject {
    public CashDeskShowConf cashdesk_show_conf;
    public String code;
    public CJPayDiscountInfo discount_info;
    public CJPayMerchantInfo merchant_info;
    public String msg;
    public CJPayPayTypeInfo paytype_info;
    public CJPayProcessInfo process_info;
    public CJPayResultPageShowConf result_page_show_conf;
    public CJPayNoPwdPayInfo secondary_confirm_info;
    public SmallChangeBindCardPromotion small_change_bind_card_promotion;
    public boolean small_change_using_new_verify_flag;
    public CJPayTradeInfo trade_info;
    public CJPayUserInfo user_info;

    public static class CashDeskShowConf implements CJPayObject {
        public String confirm_btn_desc;
        public long left_time;
        public CJPayNoticeInfo notice_info;
        public int show_style;
        public Theme theme;
        public CJPayUserAgreement user_agreement;
        public boolean whether_show_left_time;
        public String withdraw_arrival_time;

        public CashDeskShowConf() {
            this.confirm_btn_desc = "";
            this.user_agreement = new CJPayUserAgreement();
            this.theme = new Theme();
            this.whether_show_left_time = false;
            this.left_time = 0;
            this.show_style = 0;
            this.withdraw_arrival_time = "";
            this.notice_info = new CJPayNoticeInfo();
        }
    }

    public static class SmallChangeBindCardPromotion implements CJPayObject, Serializable {
        public String bind_card_info;
        public String biz_type;
        public boolean has_bind_card_lottery;
        public String material_no;
        public String plan_no;
        public String promotion_description;
        public String resource_no;

        public SmallChangeBindCardPromotion() {
            this.promotion_description = "";
            this.has_bind_card_lottery = false;
            this.bind_card_info = "";
            this.resource_no = "";
            this.plan_no = "";
            this.material_no = "";
            this.biz_type = "";
        }
    }

    public static class Theme implements CJPayObject {
        public String amount_color;
        public String button_color;
        public String button_shape;
        public String font_color;
        public String pay_type_mark_color;
        public String pay_type_mark_shape;
        public String pay_type_mark_style;
        public String pay_type_msg_color;
        public String trade_name_color;

        public JSONObject parseThemeToJson() {
            JSONObject r100 = new JSONObject();
            r100.put("button_color", this.button_color);     // Catch: JSONException -> L5
            r100.put("font_color", this.font_color);     // Catch: JSONException -> L5
            r100.put("button_shape", this.button_shape);     // Catch: JSONException -> L5
            r100.put("amount_color", this.amount_color);     // Catch: JSONException -> L5
            r100.put("pay_type_msg_color", this.pay_type_msg_color);     // Catch: JSONException -> L5
            r100.put("pay_type_mark_style", this.pay_type_mark_style);     // Catch: JSONException -> L5
            r100.put("pay_type_mark_color", this.pay_type_mark_color);     // Catch: JSONException -> L5
            r100.put("pay_type_mark_shape", this.pay_type_mark_shape);     // Catch: JSONException -> L5
            r100.put("trade_name_color", this.trade_name_color);     // Catch: JSONException -> L5
        L7:
            return r100;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayPreTradeResponseBean#parseThemeToJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreTradeResponseBean#parseThemeToJson", e);
            e.printStackTrace();
            goto L7
        }

        public Theme() {
            this.button_color = "";
            this.font_color = "";
            this.button_shape = "";
            this.amount_color = "";
            this.pay_type_msg_color = "";
            this.pay_type_mark_style = "";
            this.pay_type_mark_color = "";
            this.pay_type_mark_shape = "";
            this.trade_name_color = "";
        }
    }

    public boolean isAuth() {
        return TextUtils.equals("1", this.user_info.auth_status);
    }

    public CJPayPreTradeResponseBean() {
        this.code = "";
        this.msg = "";
        this.cashdesk_show_conf = new CashDeskShowConf();
        this.discount_info = new CJPayDiscountInfo();
        this.merchant_info = new CJPayMerchantInfo();
        this.paytype_info = new CJPayPayTypeInfo();
        this.process_info = new CJPayProcessInfo();
        this.user_info = new CJPayUserInfo();
        this.result_page_show_conf = new CJPayResultPageShowConf();
        this.trade_info = new CJPayTradeInfo();
        this.small_change_bind_card_promotion = new SmallChangeBindCardPromotion();
        this.secondary_confirm_info = null;
        this.small_change_using_new_verify_flag = false;
    }
}
