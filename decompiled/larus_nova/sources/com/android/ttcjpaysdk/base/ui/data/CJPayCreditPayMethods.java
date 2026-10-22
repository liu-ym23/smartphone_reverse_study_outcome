package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCreditPayMethods implements CJPayObject, Serializable {
    public boolean choose;
    public String crossed_price;
    public int fee;
    public String fee_desc;
    public String first_page_voucher_msg;
    public FrontPayTypeData.HomePageFoldVoucherInfo fold_voucher_info;
    public String icon_url;
    public int index;
    public String installment;
    public String msg;
    public boolean need_show_voucher_enhance;
    public String password_page_desc;
    public String password_page_desc_title;
    public ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
    public int pay_amount_per_installment;
    public String pay_type_desc;
    public FrontPayTypeData.PromotionShowPriority promotion_show_priority;
    public String standard_rec_desc;
    public String standard_retain_voucher_label;
    public String standard_show_amount;
    public String standard_voucher_label;
    public String status;
    public VoucherRetainInfo superimposed_retain_info;
    public int total_amount_per_installment;
    public String trade_confirm_voucher_enhance_msg;
    public VoucherInfo voucher_info;
    public ArrayList<String> voucher_msg;
    public VoucherRetainInfo voucher_retain_info;
    public HashMap<String, FrontPayTypeData.VoucherShowInfo> voucher_show_info;

    public boolean isEnable() {
        return "1".equals(this.status);
    }

    public CJPayCreditPayMethods() {
        this.index = -1;
        this.choose = false;
        this.status = "";
        this.msg = "";
        this.installment = "";
        this.fee = 0;
        this.pay_amount_per_installment = 0;
        this.total_amount_per_installment = 0;
        this.voucher_msg = new ArrayList();
        this.first_page_voucher_msg = "";
        this.pay_type_desc = "";
        this.fee_desc = "";
        this.icon_url = "";
        this.voucher_info = new VoucherInfo();
        this.crossed_price = "";
        this.standard_show_amount = "";
        this.standard_rec_desc = "";
        this.standard_voucher_label = "";
        this.standard_retain_voucher_label = "";
        this.fold_voucher_info = new FrontPayTypeData.HomePageFoldVoucherInfo();
        this.need_show_voucher_enhance = false;
        this.trade_confirm_voucher_enhance_msg = "";
        this.voucher_retain_info = null;
        this.superimposed_retain_info = null;
        this.pay_addi_item_list = new ArrayList();
        this.password_page_desc = "";
        this.password_page_desc_title = "";
        this.voucher_show_info = new HashMap();
        this.promotion_show_priority = new FrontPayTypeData.PromotionShowPriority();
    }
}
