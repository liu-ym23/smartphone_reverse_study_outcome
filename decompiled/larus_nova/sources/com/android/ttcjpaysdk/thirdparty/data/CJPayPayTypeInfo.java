package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPayTypeInfo implements CJPayObject, Serializable {
    public CJPayBalance balance;
    public CJPayCreditPay credit_pay;
    public String default_pay_channel;
    public CJPayCheckoutCounterResponseBean.HomePageGroupInfo home_page_group_info;
    public String home_page_picture_url;
    public OutDisplayInfo out_display_info;
    public PayAgainDisplayInfo pay_again_display_info;
    public String pay_brand;
    public ArrayList<String> pay_channels;
    public CJPayQuickPay quick_pay;
    public int show_channel_num;
    public ArrayList<SubPayTypeGroupInfo> sub_pay_type_group_info_list;
    public FrontSubPayTypeSumInfo sub_pay_type_sum_info;

    public static class FoldStatusShowInfo implements CJPayObject, Serializable {
        public String confirm_btn_text;
        public boolean hide_unfold_btn;

        public FoldStatusShowInfo() {
            this.hide_unfold_btn = false;
            this.confirm_btn_text = "";
        }
    }

    public static class OutDisplayInfo implements CJPayObject, Serializable {
        public String after_pay_success_text;
        public String deduct_method_sub_desc;
        public String pay_and_sign_cashier_style;
        public String pay_type_text;
        public String promotion_desc;
        public String real_trade_amount;
        public String service_desc_name;
        public String service_desc_text;
        public String template_id;

        public boolean isFrontSignAndPay() {
            return !TextUtils.isEmpty(this.pay_and_sign_cashier_style);
        }

        public boolean isFrontSignDeductComplex() {
            return TextUtils.equals(this.pay_and_sign_cashier_style, "front_sign_deduct_complex");
        }

        public boolean isFrontSignDeductStyle() {
            if (TextUtils.equals(this.pay_and_sign_cashier_style, "front_sign_deduct_simple") == false) goto L5;
        L8:
            return true;
        L5:
            if (TextUtils.equals(this.pay_and_sign_cashier_style, "front_sign_deduct_complex") == true) goto L8;
            return false;
        }

        public boolean isNeedShow() {
            if (TextUtils.equals(this.pay_and_sign_cashier_style, "front_sign_pay_complex") == false) goto L5;
        L8:
            return true;
        L5:
            if (TextUtils.equals(this.pay_and_sign_cashier_style, "front_sign_deduct_simple") == true) goto L8;
            return false;
        }

        public OutDisplayInfo() {
            this.pay_and_sign_cashier_style = "";
            this.service_desc_name = "";
            this.service_desc_text = "";
            this.promotion_desc = "";
            this.deduct_method_sub_desc = "";
            this.after_pay_success_text = "";
            this.pay_type_text = "";
            this.template_id = "";
            this.real_trade_amount = "";
        }
    }

    public static class PayAgainDisplayInfo implements CJPayObject, Serializable {
        public String button_tips;
        public int fail_pay_type_index;
        public FoldStatusShowInfo fold_status_show_info;
        public String guide_icon;
        public String guide_title;
        public String header_style;
        public boolean is_combine_pay_again;
        public boolean is_rec_card_header_style;
        public RecommendPopup pay_again_recommend_popup;
        public String pay_card_show_name;
        public String pay_err_desc;
        public String pay_err_detail;
        public String pay_err_detail_toast;
        public String rec_area_guide_title;
        public ArrayList<Integer> rec_pay_type_index_list;
        public String show_combine_style;
        public int single_combine_pay_type_index;
        public String super_link;
        public String top_right_desc;

        public PayAgainDisplayInfo() {
            this.rec_pay_type_index_list = new ArrayList();
            this.guide_title = "";
            this.is_combine_pay_again = false;
            this.guide_icon = "";
            this.pay_card_show_name = "";
            this.pay_err_desc = "";
            this.pay_err_detail = "";
            this.button_tips = "";
            this.rec_area_guide_title = "";
            this.fail_pay_type_index = 0;
            this.top_right_desc = "";
            this.super_link = "";
            this.show_combine_style = "";
            this.single_combine_pay_type_index = -1;
            this.is_rec_card_header_style = false;
            this.fold_status_show_info = new FoldStatusShowInfo();
            this.pay_again_recommend_popup = null;
            this.header_style = null;
            this.pay_err_detail_toast = null;
        }
    }

    public CJPayPayTypeInfo() {
        this.balance = new CJPayBalance();
        this.quick_pay = new CJPayQuickPay();
        this.credit_pay = new CJPayCreditPay();
        this.default_pay_channel = "";
        this.pay_channels = new ArrayList();
        this.show_channel_num = 0;
        this.sub_pay_type_sum_info = new FrontSubPayTypeSumInfo();
        this.pay_brand = "";
        this.home_page_picture_url = "";
        this.sub_pay_type_group_info_list = new ArrayList();
        this.home_page_group_info = new CJPayCheckoutCounterResponseBean.HomePageGroupInfo();
        this.out_display_info = new OutDisplayInfo();
        this.pay_again_display_info = new PayAgainDisplayInfo();
    }

    public JSONObject toJson() {
        return CJPayJsonParser.toJsonObject(this);
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
}
