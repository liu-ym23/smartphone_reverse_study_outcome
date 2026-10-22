package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.VoucherInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class Card implements CJPayObject {
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_no_tail;
    public String card_type;
    public String card_type_name;
    public String certificate_code_mask;
    public String certificate_num_mask;
    public String certificate_type;
    public String end_color;
    public String front_bank_code;
    public String front_bank_code_name;
    public String icon_url;
    public String identity_verify_way;
    public boolean is_freeze_card;
    public String mark;
    public String mobile_mask;
    public String msg;
    public String need_pwd;
    public String need_repaire;
    public String need_send_sms;
    public String perday_limit;
    public String perpay_limit;
    public String quickpay_mark;
    public boolean route_available;
    public String route_id;
    public String sign_no;
    public String start_color;
    public String status;
    public String true_name_mask;
    public ArrayList<UserAgreement> user_agreement;
    public VoucherInfo voucher_info;

    public boolean isCardInactive() {
        if (this.card_level != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public Card() {
        this.status = "";
        this.msg = "";
        this.mark = "";
        this.card_no = "";
        this.bank_code = "";
        this.card_no_tail = "";
        this.route_id = "";
        this.route_available = false;
        this.bank_name = "";
        this.sign_no = "";
        this.bank_card_id = "";
        this.card_no_mask = "";
        this.card_type = "";
        this.card_type_name = "";
        this.front_bank_code = "";
        this.true_name_mask = "";
        this.front_bank_code_name = "";
        this.mobile_mask = "";
        this.certificate_code_mask = "";
        this.certificate_num_mask = "";
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
        this.identity_verify_way = "";
        this.voucher_info = new VoucherInfo();
    }
}
