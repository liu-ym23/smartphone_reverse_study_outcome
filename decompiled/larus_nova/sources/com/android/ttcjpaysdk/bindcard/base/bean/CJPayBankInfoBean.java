package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.bindcard.base.constants.CJPayBindCardType;
import com.android.ttcjpaysdk.bindcard.base.utils.DataConvertUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBankInfoBean implements CJPayObject, Serializable {
    public String background_color;
    public String bankCardNum;
    public String bank_code;
    public String bank_initials;
    public String bank_name;
    public boolean bank_popular_flag;
    public String bank_rank;
    public int bank_sort_number;
    public String card_type;
    public String card_type_chosen;
    public CJPayCardVoucherListBean card_voucher_list;
    public String display_desc;
    public String display_icon;
    public String icon_background;
    public String icon_url;
    public boolean is_support_one_key;
    public String jump_bind_card_type;
    public String perday_limit;
    public String perpay_limit;
    public String rank_type;
    public String uid;
    public HashMap<String, CJPayVoucherInfo> voucherInfoMap;
    public String voucher_bank;
    public transient JSONObject voucher_info_map;

    public String getCardBinInfo() {
        return this.bank_name.concat(getCardTypeStr());
    }

    public String getCardTypeStr() {
        return CJPayBindCardType.Companion.getCardDesc(this.card_type);
    }

    public String getChosenCardTypeStr() {
        return CJPayBindCardType.Companion.getCardDesc(this.card_type_chosen);
    }

    public String getCreditVoucher() {
        return getVoucher(CJPayBindCardType.CREDIT.mType);
    }

    public String getDebitVoucher() {
        return getVoucher(CJPayBindCardType.DEBIT.mType);
    }

    public String getUnionPayVoucher() {
        return getVoucher(CJPayBindCardType.UPYSFBANK.mType);
    }

    public String getVoucher() {
        return getVoucher(this.card_type);
    }

    public boolean isUnionPay() {
        return TextUtils.equals(CJPayBindCardType.UPYSFBANK.mType, this.bank_code);
    }

    public void setVoucherInfoMap() {
        if (this.voucherInfoMap.isEmpty() == false) goto L10;
        JSONObject r100 = this.voucher_info_map;
        if (r100 == null) goto L12;
        Iterator<String> r101 = r100.keys();
    L8:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        JSONObject r103 = this.voucher_info_map.optJSONObject(r102);
        this.voucherInfoMap.put(r102, (CJPayVoucherInfo) CJPayJsonParser.fromJson(r103, CJPayVoucherInfo.class));
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public QuickBindCardAdapterBean toQuickBindCardAdapterBean() {
        return DataConvertUtil.INSTANCE.cjPayBankInfoBean2QuickBindCardAdapterBean(this);
    }

    public CJPayBankInfoBean() {
        this.background_color = "";
        this.bank_name = "";
        this.voucher_bank = "";
        this.bank_code = "";
        this.bank_initials = "";
        this.card_type = CJPayBindCardType.DEBIT.mType;
        this.icon_url = "";
        this.icon_background = "";
        this.perpay_limit = "";
        this.perday_limit = "";
        this.display_icon = "";
        this.display_desc = "";
        this.card_type_chosen = "";
        this.bank_rank = "";
        this.rank_type = "";
        this.bank_sort_number = -1;
        this.bank_popular_flag = false;
        this.card_voucher_list = new CJPayCardVoucherListBean();
        this.jump_bind_card_type = "";
        this.bankCardNum = "";
        this.uid = "";
        this.is_support_one_key = false;
        this.voucherInfoMap = new HashMap();
        this.voucher_info_map = new JSONObject();
    }

    public String getCardBinVoucher() {
        setVoucherInfoMap();
        CJPayBindCardType r100 = CJPayBindCardType.CREDIT;
        if (TextUtils.isEmpty(getCardBinVoucher(r100.mType)) == false) goto L5;
        CJPayBindCardType r101 = CJPayBindCardType.DEBIT;
        if (TextUtils.isEmpty(getCardBinVoucher(r101.mType)) == false) goto L9;
        return "";
    L9:
        return getCardBinVoucher(r101.mType);
    L5:
        return getCardBinVoucher(r100.mType);
    }

    public String getCreditCardBinVoucher() {
        setVoucherInfoMap();
        return getCardBinVoucher(CJPayBindCardType.CREDIT.mType);
    }

    public String getCreditHomePageVoucher() {
        setVoucherInfoMap();
        return getHomePageVoucher(CJPayBindCardType.CREDIT.mType);
    }

    public String getDebitCardBinVoucher() {
        setVoucherInfoMap();
        return getCardBinVoucher(CJPayBindCardType.DEBIT.mType);
    }

    public String getDebitHomePageVoucher() {
        setVoucherInfoMap();
        return getHomePageVoucher(CJPayBindCardType.DEBIT.mType);
    }

    public String getHomePageVoucher() {
        setVoucherInfoMap();
        CJPayBindCardType r100 = CJPayBindCardType.CREDIT;
        if (TextUtils.isEmpty(getHomePageVoucher(r100.mType)) == false) goto L5;
        CJPayBindCardType r101 = CJPayBindCardType.DEBIT;
        if (TextUtils.isEmpty(getHomePageVoucher(r101.mType)) == false) goto L9;
        return "";
    L9:
        return getHomePageVoucher(r101.mType);
    L5:
        return getHomePageVoucher(r100.mType);
    }

    public HashMap<String, CJPayVoucherInfo> getVoucherInfoMap() {
        setVoucherInfoMap();
        return this.voucherInfoMap;
    }

    public boolean showCreditVoucher() {
        setVoucherInfoMap();
        HashMap<String, CJPayVoucherInfo> r100 = this.voucherInfoMap;
        CJPayBindCardType r101 = CJPayBindCardType.CREDIT;
        if (r100.get(r101.mType) != null) goto L5;
        return true;
    L5:
        if (1 != this.voucherInfoMap.get(r101.mType).is_not_show_promotion) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean showDebitVoucher() {
        setVoucherInfoMap();
        HashMap<String, CJPayVoucherInfo> r100 = this.voucherInfoMap;
        CJPayBindCardType r101 = CJPayBindCardType.DEBIT;
        if (r100.get(r101.mType) != null) goto L5;
        return true;
    L5:
        if (1 != this.voucherInfoMap.get(r101.mType).is_not_show_promotion) goto L10;
        return false;
    L10:
        return true;
    }

    private String getCardBinVoucher(String r100) {
        if (this.voucherInfoMap.get(r100) != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(this.voucherInfoMap.get(r100).bin_voucher_msg) == false) goto L7;
        return "";
    L7:
        return this.voucherInfoMap.get(r100).bin_voucher_msg;
    }

    private String getHomePageVoucher(String r100) {
        if (this.voucherInfoMap.get(r100) != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(this.voucherInfoMap.get(r100).home_page_voucher_msg) == false) goto L7;
        return "";
    L7:
        return this.voucherInfoMap.get(r100).home_page_voucher_msg;
    }

    private String getVoucher(String r100) {
        setVoucherInfoMap();
        if (this.voucherInfoMap.get(r100) != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(this.voucherInfoMap.get(r100).voucher_msg) == false) goto L7;
        return "";
    L7:
        return this.voucherInfoMap.get(r100).voucher_msg;
    }
}
