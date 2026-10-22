package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class QuickBindCardAdapterBean implements CJPayObject, Serializable {
    public boolean authorizeClicked;
    public String backgroundColor;
    public String bankCode;
    public String bankIconUrl;
    public String bankInitials;
    public String bankName;
    public boolean bankPopularFlag;
    public int bankSortNumber;
    public String bank_rank;
    public String cardBinVoucher;
    public String cardType;
    public CJPayOneKeyCopyWritingInfo card_copywriting_info;
    public String card_type_chosen;
    public String creditCardBinVoucher;
    public String creditHomePageVoucher;
    public String creditVoucher;
    public String debitCardBinVoucher;
    public String debitHomePageVoucher;
    public String debitVoucher;
    public String descLable;
    public String displayDesc;
    public String displayIcon;
    public String homePageVoucher;
    public String iconBackground;
    public boolean isIndex;
    public Boolean isJumpOneKeySign;
    public boolean isLoading;
    public boolean isNeedCardInfo;
    public boolean isNeedShowAuth;
    public boolean is_support_one_key;
    public String jumpBindCardType;
    public String mobileMask;
    public boolean needAuthGuide;
    public String rank_type;
    public boolean showCreditVoucher;
    public boolean showDebitVoucher;
    public String smchId;
    public String unionPayVoucher;
    public HashMap<String, CJPayVoucherInfo> voucher_info_map;

    public boolean hasVoucher() {
        if (TextUtils.isEmpty(this.debitVoucher) == true) goto L5;
    L14:
        return true;
    L5:
        if (TextUtils.isEmpty(this.creditVoucher) == false) goto L14;
        if (TextUtils.isEmpty(this.unionPayVoucher) == false) goto L14;
        if (TextUtils.isEmpty(this.homePageVoucher) == false) goto L14;
        if (TextUtils.isEmpty(this.cardBinVoucher) == false) goto L14;
        return false;
    }

    public boolean isBindCardThenPay() {
        return !this.isNeedCardInfo;
    }

    public boolean isUnionPay() {
        return TextUtils.equals("UPYSFBANK", this.bankCode);
    }

    public QuickBindCardAdapterBean() {
        this.backgroundColor = "";
        this.isIndex = false;
        this.bankInitials = "";
        this.bankIconUrl = "";
        this.bankName = "";
        this.bankCode = "";
        this.cardType = "";
        this.iconBackground = "";
        this.descLable = "";
        this.smchId = "";
        this.mobileMask = "";
        this.isLoading = false;
        this.isNeedCardInfo = false;
        this.isNeedShowAuth = true;
        this.needAuthGuide = false;
        this.authorizeClicked = false;
        this.debitVoucher = "";
        this.showDebitVoucher = false;
        this.creditVoucher = "";
        this.showCreditVoucher = false;
        this.unionPayVoucher = "";
        this.homePageVoucher = "";
        this.debitHomePageVoucher = "";
        this.creditHomePageVoucher = "";
        this.cardBinVoucher = "";
        this.debitCardBinVoucher = "";
        this.creditCardBinVoucher = "";
        this.displayIcon = "";
        this.displayDesc = "";
        this.bankPopularFlag = false;
        this.bankSortNumber = -1;
        this.voucher_info_map = new HashMap();
        this.card_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.card_type_chosen = "";
        this.bank_rank = "";
        this.rank_type = "";
        this.isJumpOneKeySign = Boolean.FALSE;
        this.is_support_one_key = false;
        this.jumpBindCardType = "";
    }

    public boolean isBindCardNotPay() {
        return this.isNeedCardInfo;
    }

    public QuickBindCardAdapterBean(CJPayCardAddBean r100) {
        this.backgroundColor = "";
        this.isIndex = false;
        this.bankInitials = "";
        this.bankIconUrl = "";
        this.bankName = "";
        this.bankCode = "";
        this.cardType = "";
        this.iconBackground = "";
        this.descLable = "";
        this.smchId = "";
        this.mobileMask = "";
        this.isLoading = false;
        this.isNeedCardInfo = false;
        this.isNeedShowAuth = true;
        this.needAuthGuide = false;
        this.authorizeClicked = false;
        this.debitVoucher = "";
        this.showDebitVoucher = false;
        this.creditVoucher = "";
        this.showCreditVoucher = false;
        this.unionPayVoucher = "";
        this.homePageVoucher = "";
        this.debitHomePageVoucher = "";
        this.creditHomePageVoucher = "";
        this.cardBinVoucher = "";
        this.debitCardBinVoucher = "";
        this.creditCardBinVoucher = "";
        this.displayIcon = "";
        this.displayDesc = "";
        this.bankPopularFlag = false;
        this.bankSortNumber = -1;
        this.voucher_info_map = new HashMap();
        this.card_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.card_type_chosen = "";
        this.bank_rank = "";
        this.rank_type = "";
        this.isJumpOneKeySign = Boolean.FALSE;
        this.is_support_one_key = false;
        this.jumpBindCardType = "";
        CJPayBankInfoBean r101 = r100.url_params.one_key_bank_info;
        this.backgroundColor = r101.background_color;
        this.bankName = r101.bank_name;
        this.bankCode = r101.bank_code;
        this.bankIconUrl = r101.icon_url;
        this.iconBackground = r101.icon_background;
        this.cardType = r101.card_type;
        this.debitVoucher = r101.getDebitVoucher();
        this.creditVoucher = r100.url_params.one_key_bank_info.getCreditVoucher();
        this.homePageVoucher = r100.url_params.one_key_bank_info.getHomePageVoucher();
        this.debitHomePageVoucher = r100.url_params.one_key_bank_info.getDebitHomePageVoucher();
        this.creditHomePageVoucher = r100.url_params.one_key_bank_info.getCreditHomePageVoucher();
        this.cardBinVoucher = r100.url_params.one_key_bank_info.getCardBinVoucher();
        this.debitCardBinVoucher = r100.url_params.one_key_bank_info.getDebitCardBinVoucher();
        this.creditCardBinVoucher = r100.url_params.one_key_bank_info.getCreditCardBinVoucher();
        this.voucher_info_map = r100.url_params.one_key_bank_info.getVoucherInfoMap();
        CJPayBindCardParamsBean r102 = r100.url_params;
        this.smchId = r102.smch_id;
        this.isNeedCardInfo = r100.isNeedCardInfo;
        this.card_type_chosen = r102.one_key_bank_info.card_type_chosen;
        this.isJumpOneKeySign = Boolean.valueOf(r102.jump_one_key_sign.equals("1"));
        CJPayBindCardParamsBean r103 = r100.url_params;
        CJPayBankInfoBean r104 = r103.one_key_bank_info;
        this.displayIcon = r104.display_icon;
        this.displayDesc = r104.display_desc;
        this.card_copywriting_info = r103.card_copywriting_info;
        this.jumpBindCardType = r104.jump_bind_card_type;
    }

    public QuickBindCardAdapterBean(QuickBindCardAdapterBean r100) {
        this.backgroundColor = "";
        this.isIndex = false;
        this.bankInitials = "";
        this.bankIconUrl = "";
        this.bankName = "";
        this.bankCode = "";
        this.cardType = "";
        this.iconBackground = "";
        this.descLable = "";
        this.smchId = "";
        this.mobileMask = "";
        this.isLoading = false;
        this.isNeedCardInfo = false;
        this.isNeedShowAuth = true;
        this.needAuthGuide = false;
        this.authorizeClicked = false;
        this.debitVoucher = "";
        this.showDebitVoucher = false;
        this.creditVoucher = "";
        this.showCreditVoucher = false;
        this.unionPayVoucher = "";
        this.homePageVoucher = "";
        this.debitHomePageVoucher = "";
        this.creditHomePageVoucher = "";
        this.cardBinVoucher = "";
        this.debitCardBinVoucher = "";
        this.creditCardBinVoucher = "";
        this.displayIcon = "";
        this.displayDesc = "";
        this.bankPopularFlag = false;
        this.bankSortNumber = -1;
        this.voucher_info_map = new HashMap();
        this.card_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.card_type_chosen = "";
        this.bank_rank = "";
        this.rank_type = "";
        this.isJumpOneKeySign = Boolean.FALSE;
        this.is_support_one_key = false;
        this.jumpBindCardType = "";
        this.backgroundColor = r100.backgroundColor;
        this.isIndex = r100.isIndex;
        this.bankInitials = r100.bankInitials;
        this.bankName = r100.bankName;
        this.bankCode = r100.bankCode;
        this.bankIconUrl = r100.bankIconUrl;
        this.iconBackground = r100.iconBackground;
        this.cardType = r100.cardType;
        this.debitVoucher = r100.debitVoucher;
        this.creditVoucher = r100.creditVoucher;
        this.homePageVoucher = r100.homePageVoucher;
        this.debitHomePageVoucher = r100.debitHomePageVoucher;
        this.creditHomePageVoucher = r100.creditHomePageVoucher;
        this.cardBinVoucher = r100.cardBinVoucher;
        this.debitCardBinVoucher = r100.debitCardBinVoucher;
        this.creditCardBinVoucher = r100.creditCardBinVoucher;
        this.voucher_info_map = r100.voucher_info_map;
        this.smchId = r100.smchId;
        this.isNeedCardInfo = r100.isNeedCardInfo;
        this.card_type_chosen = r100.card_type_chosen;
        this.isJumpOneKeySign = r100.isJumpOneKeySign;
        this.displayIcon = r100.displayIcon;
        this.displayDesc = r100.displayDesc;
        this.card_copywriting_info = r100.card_copywriting_info;
        this.jumpBindCardType = r100.jumpBindCardType;
        this.bankPopularFlag = r100.bankPopularFlag;
        this.bankSortNumber = r100.bankSortNumber;
        this.is_support_one_key = r100.is_support_one_key;
        this.unionPayVoucher = r100.unionPayVoucher;
        this.authorizeClicked = r100.authorizeClicked;
        this.needAuthGuide = r100.needAuthGuide;
        this.isNeedShowAuth = r100.isNeedShowAuth;
        this.mobileMask = r100.mobileMask;
        this.descLable = r100.descLable;
    }
}
