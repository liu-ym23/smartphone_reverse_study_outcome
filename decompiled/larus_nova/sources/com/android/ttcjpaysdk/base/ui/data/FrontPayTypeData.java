package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class FrontPayTypeData implements CJPayObject, Serializable {
    public ArrayList<CJPayPayInfo.AmountAreaInfo> amount_area_list;
    public AssetInfoBean asset_info;
    public long balance_amount;
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public CJPayBubbleInfo bubble_info_map;
    public String card_add_ext;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_show_name;
    public String card_type;
    public String card_type_name;
    public String certificate_num_mask;
    public String certificate_type;
    public CombinePayInfo combine_pay_info;
    public ArrayList<CJPayPayInfo.CombineShowInfo> combine_show_info;
    public String credit_activate_url;
    public ArrayList<CJPayCreditPayMethods> credit_pay_methods;
    public String crossed_price;
    public String decision_id;
    public HomePageFoldVoucherInfo fold_voucher_info;
    public long freezed_amount;
    public String icon_url;
    public boolean is_credit_activate;
    public boolean is_foreign_card;
    public String mobile_mask;
    public boolean need_show_voucher_enhance;
    public CJPayOutDisplayInfo out_display_info;
    public String password_page_desc;
    public String password_page_desc_title;
    public ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
    public PayTypeVoucherMsgV2 pay_type_voucher_msg_v2;
    public String perday_limit;
    public String perpay_limit;
    public PromotionShowPriority promotion_show_priority;
    public int recommend_type;
    public String select_page_guide_text;
    public String share_asset_code;
    public String share_asset_id;
    public boolean show_combine_pay;
    public String sign_no;
    public String standard_rec_desc;
    public String standard_retain_voucher_label;
    public String standard_show_amount;
    public String standard_voucher_label;
    public VoucherRetainInfo superimposed_retain_info;
    public TradeAreaVoucher trade_area_voucher;
    public String trade_confirm_voucher_enhance_msg;
    public String true_name_mask;
    public String voucher_desc_text;
    public String voucher_enhance_display_text;
    public CJPayVoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;
    public VoucherRetainInfo voucher_retain_info;
    public HashMap<String, VoucherShowInfo> voucher_show_info;
    public String voucher_type;

    public static class CJPayOutDisplayInfo implements CJPayObject, Serializable {
        public String activity_info_desc;
        public String after_pay_success_text;

        public CJPayOutDisplayInfo() {
            this.after_pay_success_text = "";
            this.activity_info_desc = "";
        }
    }

    public static class CombinePayInfo implements CJPayObject, Serializable {
        public ArrayList<CJPayPayInfo.AmountAreaInfo> amount_area_list;
        public String combine_pay_title;
        public String crossed_price;
        public String expand_standard_rec_desc;
        public String expand_standard_show_amount;
        public HomePageFoldVoucherInfo fold_voucher_info;
        public boolean need_show_voucher_enhance;
        public ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
        public ArrayList<PrimaryCombinePayInfoList> primary_combine_pay_info_list;
        public PromotionShowPriority promotion_show_priority;
        public String right_top_button;
        public PrimaryCombinePayInfoList secondary_combine_pay_info;
        public String select_page_voucher_msg;
        public String standard_rec_desc;
        public String standard_retain_voucher_label;
        public String standard_show_amount;
        public String standard_voucher_label;
        public VoucherRetainInfo superimposed_retain_info;
        public String trade_confirm_voucher_enhance_msg;
        public CJPayVoucherInfo voucher_info;
        public ArrayList<String> voucher_msg_list;
        public VoucherRetainInfo voucher_retain_info;
        public HashMap<String, VoucherShowInfo> voucher_show_info;

        public CombinePayInfo() {
            this.voucher_msg_list = new ArrayList();
            this.voucher_info = new CJPayVoucherInfo();
            this.primary_combine_pay_info_list = new ArrayList();
            this.secondary_combine_pay_info = null;
            this.standard_rec_desc = "";
            this.standard_voucher_label = "";
            this.standard_retain_voucher_label = "";
            this.fold_voucher_info = new HomePageFoldVoucherInfo();
            this.standard_show_amount = "";
            this.expand_standard_rec_desc = "";
            this.expand_standard_show_amount = "";
            this.crossed_price = "";
            this.pay_addi_item_list = new ArrayList();
            this.select_page_voucher_msg = "";
            this.trade_confirm_voucher_enhance_msg = "";
            this.need_show_voucher_enhance = false;
            this.voucher_show_info = new HashMap();
            this.promotion_show_priority = new PromotionShowPriority();
            this.right_top_button = "";
            this.combine_pay_title = "";
        }
    }

    public static class HomePageFoldVoucherInfo implements CJPayObject, Serializable {
        public String button;
        public ArrayList<String> retain_voucher_desc;
        public String title;
        public ArrayList<String> voucher_desc;

        public HomePageFoldVoucherInfo() {
            this.title = "";
            this.button = "";
            this.voucher_desc = new ArrayList();
            this.retain_voucher_desc = new ArrayList();
        }
    }

    public static class PrimaryCombinePayInfoList implements CJPayObject, Serializable {
        public String expand_primary_pay_type_msg;
        public String expand_secondary_pay_type_msg;
        public long primary_amount;
        public String primary_pay_type_msg;
        public long secondary_amount;
        public String secondary_pay_type;
        public int secondary_pay_type_index;
        public String secondary_pay_type_msg;
        public long trade_amount;
        public String trade_confirm_button_label;

        public PrimaryCombinePayInfoList() {
            this.primary_pay_type_msg = "";
            this.secondary_pay_type_msg = "";
            this.expand_primary_pay_type_msg = "";
            this.expand_secondary_pay_type_msg = "";
            this.secondary_pay_type = "";
            this.trade_confirm_button_label = "";
        }
    }

    public static class PromotionShowPriority implements CJPayObject, Serializable {
        public String first_retain_type;
        public String second_retain_type;

        public PromotionShowPriority() {
            this.first_retain_type = "";
            this.second_retain_type = "";
        }
    }

    public static class VoucherMsgInfo implements CJPayObject, Serializable {
        public String left_msg;
        public String right_msg;
        public String tag_show_type;

        public VoucherMsgInfo() {
            this.left_msg = "";
            this.right_msg = "";
            this.tag_show_type = "";
        }
    }

    public static class VoucherShowInfo implements CJPayObject, Serializable {
        public String crossed_price;
        public String standard_show_amount;
        public ArrayList<VoucherMsgInfo> standard_voucher_msg_list;
        public ArrayList<String> sub_pay_type_voucher_tag_list;

        public VoucherShowInfo() {
            this.standard_voucher_msg_list = new ArrayList();
            this.sub_pay_type_voucher_tag_list = new ArrayList();
            this.crossed_price = "";
            this.standard_show_amount = "";
        }
    }

    public boolean isAssetStandard() {
        AssetInfoBean r100 = this.asset_info;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.asset_basic_show_info.index == (-1)) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isCardInactive() {
        if (this.card_level != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNotNewBankCardShare() {
        return !TextUtils.equals(this.share_asset_code, CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_NEW_BANK_CARD);
    }

    public FrontPayTypeData() {
        this.bank_card_id = "";
        this.card_no = "";
        this.card_no_mask = "";
        this.card_type = "";
        this.card_type_name = "";
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
        this.card_add_ext = "";
        this.standard_rec_desc = "";
        this.standard_voucher_label = "";
        this.standard_show_amount = "";
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new CJPayVoucherInfo();
        this.credit_pay_methods = new ArrayList();
        this.is_credit_activate = false;
        this.recommend_type = 0;
        this.combine_show_info = new ArrayList();
        this.combine_pay_info = new CombinePayInfo();
        this.select_page_guide_text = "";
        this.credit_activate_url = "";
        this.decision_id = "";
        this.voucher_desc_text = "";
        this.trade_area_voucher = new TradeAreaVoucher();
        this.pay_type_voucher_msg_v2 = new PayTypeVoucherMsgV2();
        this.crossed_price = "";
        this.out_display_info = new CJPayOutDisplayInfo();
        this.pay_addi_item_list = new ArrayList();
        this.bubble_info_map = new CJPayBubbleInfo();
        this.share_asset_code = "";
        this.share_asset_id = "";
        this.fold_voucher_info = new HomePageFoldVoucherInfo();
        this.voucher_enhance_display_text = "";
        this.need_show_voucher_enhance = false;
        this.standard_retain_voucher_label = "";
        this.trade_confirm_voucher_enhance_msg = "";
        this.password_page_desc_title = "";
        this.password_page_desc = "";
        this.voucher_type = "";
        this.voucher_show_info = new HashMap();
        this.promotion_show_priority = new PromotionShowPriority();
        this.is_foreign_card = false;
    }

    public String getInsufficientId() {
        if (isNotNewBankCardShare() == false) goto L7;
        return this.share_asset_id;
    L7:
        return this.bank_card_id;
    }

    public TradeAreaVoucher getTradeAreaVoucher() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_extension_show_info.trade_area_voucher;
    L7:
        return this.trade_area_voucher;
    }

    public String getVoucherDescText() {
        if (isAssetStandard() == false) goto L7;
        return this.voucher_desc_text;
    L7:
        return this.voucher_desc_text;
    }
}
