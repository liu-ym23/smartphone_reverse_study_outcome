package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayBubbleInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.base.ui.data.VoucherInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class PayTypeData implements CJPayObject {
    public long balance_amount;
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public CJPayBubbleInfo bubble_info_map;
    public ArrayList<BytepayVoucherMsg> bytepay_voucher_msg_list;
    public String card_add_ext;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_show_name;
    public String card_style_short_name;
    public String card_type;
    public String card_type_name;
    public String certificate_num_mask;
    public String certificate_type;
    public CombinePayInfo combine_pay_info;
    public ArrayList<CJPayCreditPayMethods> credit_pay_methods;
    public long freezed_amount;
    public String front_bank_code;
    public IconTips icon_tips;
    public String icon_url;
    public int income_amount;
    public boolean is_foreign_card;
    public String mobile_mask;
    public PayTypeVoucherMsgV2 pay_type_voucher_msg_v2;
    public String perday_limit;
    public String perpay_limit;
    public String select_page_guide_text;
    public String share_asset_code;
    public String share_asset_id;
    public boolean show_combine_pay;
    public String sign_no;
    public String standard_rec_desc;
    public String standard_show_amount;
    public String sub_ext;
    public ArrayList<String> sub_pay_voucher_msg_list;
    public boolean support_one_key_sign;
    public String true_name_mask;
    public VoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;

    public static class CombinePayInfo implements CJPayObject, Serializable {
        public ArrayList<PrimaryCombinePayInfo> primary_combine_pay_info_list;
        public SecondaryCombinePayInfo secondary_combine_pay_info;
        public String standard_rec_desc;
        public String standard_show_amount;
        public String trade_confirm_button_label;
        public ArrayList<String> voucher_msg_list;

        public CombinePayInfo() {
            this.voucher_msg_list = new ArrayList();
            this.standard_rec_desc = "";
            this.standard_show_amount = "";
            this.primary_combine_pay_info_list = null;
            this.secondary_combine_pay_info = null;
            this.trade_confirm_button_label = "";
        }
    }

    public static class PayTypeVoucherMsgV2 implements CJPayObject, Serializable {
        public ArrayList<PayTypeVoucherMsgV2Tag> tag12;
        public ArrayList<PayTypeVoucherMsgV2Tag> tag34;
        public ArrayList<PayTypeVoucherMsgV2Tag> tag56;

        public static class PayTypeVoucherMsgV2Tag implements CJPayObject, Serializable {
            public String event_type;
            public ArrayList<VoucherDetailLabel> label;
            public String voucher_msg_sub_type;
            public String voucher_msg_type;
            public String voucher_pos;

            public static class VoucherDetailLabel implements CJPayObject, Serializable {
                public String icon_url;
                public String text;
                public String type;

                public VoucherDetailLabel() {
                    this.text = "";
                    this.type = "";
                    this.icon_url = "";
                }
            }

            public boolean isCombineType() {
                return TextUtils.equals(this.event_type, "combine_pay");
            }

            public boolean isDefaultType() {
                return TextUtils.equals(this.event_type, "default");
            }

            public PayTypeVoucherMsgV2Tag() {
                this.event_type = "";
                this.label = new ArrayList();
                this.voucher_msg_type = "";
                this.voucher_msg_sub_type = "";
                this.voucher_pos = "";
            }
        }

        public PayTypeVoucherMsgV2() {
            this.tag12 = new ArrayList();
            this.tag34 = new ArrayList();
            this.tag56 = new ArrayList();
        }
    }

    public static class PrimaryCombinePayInfo implements CJPayObject, Serializable {
        public int primary_amount;
        public String primary_pay_type_msg;
        public int secondary_amount;
        public String secondary_pay_type;
        public int secondary_pay_type_index;
        public String secondary_pay_type_msg;
        public String trade_confirm_button_label;

        public PrimaryCombinePayInfo() {
            this.secondary_pay_type_index = -1;
            this.primary_amount = -1;
            this.secondary_amount = -1;
            this.secondary_pay_type_msg = "";
            this.primary_pay_type_msg = "";
            this.secondary_pay_type = "";
            this.trade_confirm_button_label = "";
        }
    }

    public static class SecondaryCombinePayInfo implements CJPayObject, Serializable {
        public String banner_text;
        public boolean btn_is_checked;
        public boolean default_show;
        public int primary_amount;
        public int secondary_amount;
        public String switch_btn_text;
        public int trade_amount;

        public SecondaryCombinePayInfo() {
            this.banner_text = "";
            this.btn_is_checked = false;
            this.default_show = false;
            this.primary_amount = -1;
            this.secondary_amount = -1;
            this.switch_btn_text = "";
            this.trade_amount = -1;
        }
    }

    public PayTypeData() {
        this.bank_card_id = "";
        this.card_no = "";
        this.card_no_mask = "";
        this.card_type = "";
        this.card_type_name = "";
        this.is_foreign_card = false;
        this.true_name_mask = "";
        this.certificate_num_mask = "";
        this.certificate_type = "";
        this.mobile_mask = "";
        this.icon_url = "";
        this.card_level = -1;
        this.perday_limit = "";
        this.perpay_limit = "";
        this.bank_code = "";
        this.sign_no = "";
        this.bank_name = "";
        this.card_show_name = "";
        this.front_bank_code = "";
        this.card_style_short_name = "";
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new VoucherInfo();
        this.bytepay_voucher_msg_list = new ArrayList();
        this.sub_pay_voucher_msg_list = new ArrayList();
        this.card_add_ext = "";
        this.icon_tips = new IconTips();
        this.credit_pay_methods = new ArrayList();
        this.standard_show_amount = "";
        this.standard_rec_desc = "";
        this.select_page_guide_text = "";
        this.pay_type_voucher_msg_v2 = new PayTypeVoucherMsgV2();
        this.combine_pay_info = new CombinePayInfo();
        this.sub_ext = "";
        this.share_asset_code = "";
        this.share_asset_id = "";
    }
}
