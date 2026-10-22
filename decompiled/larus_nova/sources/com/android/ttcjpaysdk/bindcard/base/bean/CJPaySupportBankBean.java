package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySupportBankBean extends CJPayBindCardBaseBean {
    public CJPayOneKeyCopyWritingInfo card_bind_copywriting_info;
    public CJPayOneKeyCopyWritingInfo card_no_input_copywriting_info;
    public SupportBankExts exts;
    public ArrayList<CJPayBankInfoBean> one_key_banks;
    public int one_key_banks_lenth;
    public CJPayOneKeyCopyWritingInfo one_key_copywriting_info;
    public ArrayList<CJPayBankInfoBean> recommend_banks;
    public CJPayKeepDialogBean retention_msg;
    public String voucher_bank;
    public CJPayBankInfoBean voucher_bank_info;
    public CJPayVoucherListBean voucher_list;
    public String voucher_msg;

    public static class SupportBankExts implements CJPayObject, Serializable {
        public String search_card_no;

        public SupportBankExts() {
            this.search_card_no = "";
        }
    }

    public boolean hasVoucherBank() {
        CJPayBankInfoBean r100 = this.voucher_bank_info;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.voucher_bank) == true) goto L9;
        if (TextUtils.isEmpty(this.voucher_bank_info.icon_url) == true) goto L9;
        return true;
    }

    public boolean hasVoucherList() {
        CJPayVoucherListBean r100 = this.voucher_list;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.mixVoucherEmpty() == true) goto L7;
    L8:
        return true;
    L7:
        if (this.voucher_list.basicVoucherEmpty() == true) goto L9;
        goto L8
    }

    public CJPaySupportBankBean() {
        this.one_key_banks = new ArrayList();
        this.one_key_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.card_bind_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.voucher_list = new CJPayVoucherListBean();
        this.voucher_msg = "";
        this.voucher_bank = "";
        this.one_key_banks_lenth = 6;
        this.recommend_banks = new ArrayList();
        this.voucher_bank_info = new CJPayBankInfoBean();
        this.card_no_input_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.exts = new SupportBankExts();
    }
}
