package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class FrontPayTypeData implements CJPayObject, Serializable {
    public long balance_amount;
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public String card_add_ext;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_show_name;
    public String card_type;
    public String card_type_name;
    public String certificate_num_mask;
    public String certificate_type;
    public ArrayList<CJPayPayInfo.CombineShowInfo> combine_show_info;
    public String credit_activate_url;
    public ArrayList<CJPayCreditPayMethods> credit_pay_methods;
    public String credit_sign_url;
    public String decision_id;
    public long freezed_amount;
    public String icon_url;
    public boolean is_credit_activate;
    public String mobile_mask;
    public String perday_limit;
    public String perpay_limit;
    public int recommend_type;
    public String select_page_guide_text;
    public boolean show_combine_pay;
    public String sign_no;
    public String standard_rec_desc;
    public String standard_show_amount;
    public String true_name_mask;
    public CJPayVoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;

    public boolean isCardInactive() {
        if (this.card_level != 2) goto L5;
        return true;
    L5:
        return false;
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
        this.standard_show_amount = "";
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new CJPayVoucherInfo();
        this.credit_pay_methods = new ArrayList();
        this.is_credit_activate = false;
        this.recommend_type = 0;
        this.combine_show_info = new ArrayList();
        this.select_page_guide_text = "";
        this.credit_activate_url = "";
        this.credit_sign_url = "";
        this.decision_id = "";
    }
}
