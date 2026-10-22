package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.service.ICJPayCombineService;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayBubbleInfo;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import com.android.ttcjpaysdk.base.ui.data.VoucherInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class PaymentMethodInfo implements CJPayObject {
    public String account;
    public int adapterItemStyle;
    public int adapterPosition;
    public AssetInfoBean assetInfoBean;
    public String bank_card_id;
    public String bank_name;
    public CJPayBubbleInfo bubble_info_map;
    public ArrayList<BytepayVoucherMsg> bytepay_voucher_msg_list;
    public Card card;
    public String card_add_ext;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_style_short_name;
    public String card_type_name;
    public boolean choose;
    public ICJPayCombineService.CombineType combineType;
    public String credit_pay_installment;
    public String currency;
    public String currency_setting_url;
    public String decision_id;
    public ArrayList<DynamicSubTitleInfo> dynamic_sub_title;
    public String extParams;
    public String fold_desc;
    public String front_bank_code;
    public String front_bank_code_name;
    public boolean hasValidAssetInfo;
    public IconTips icon_tips;
    public String icon_url;
    public String identity_verify_way;
    public int index;
    public boolean isChecked;
    public Boolean isCollapse;
    public boolean isLoading;
    public boolean isShowLoading;
    public Boolean is_default_fold;
    public boolean is_foreign_card;
    public boolean is_hide_cards;
    public boolean is_hide_merge_guide_section;
    public boolean is_sign_withholding;
    public String lynxExtParams;
    public String mark;
    public ArrayList<String> mark_array;
    public MergedTypeDetailSectionStatus mergedTypeDetailSectionStatus;
    public String mobile_mask;
    public String need_pwd;
    public String need_send_sms;
    public String payMethodStatusStr;
    public PayTypeData pay_type_data;
    public String paymentType;
    public String ptcode;
    public RetainInfo retainInfo;
    public JSONObject retainInfoV2;
    public String select_page_guide_text;
    public String share_asset_code;
    public String share_asset_id;
    public boolean show_combine_pay;
    public String split_Line_text;
    public String standardRecDesc;
    public String standardShowAmount;
    public String status;
    public int stdCombineLimitAssetInfoIndex;
    public ArrayList<PaymentMethodInfo> subMethodInfo;
    public SubPayTypeInfo subPayTypeInfo;
    public String sub_ext;
    public ArrayList<String> sub_pay_voucher_msg_list;
    public String sub_title;
    public String sub_title_color;
    public String sub_title_icon;
    public boolean support_one_key_sign;
    public String tips_msg;
    public ArrayList<String> tips_msg_info;
    public String title;
    public String trackInfoStr;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_sub_title_icon;
    public String tt_title;
    public ArrayList<UserAgreement> user_agreement;
    public AssetInfoBean.VoucherMsgBean.VoucherEventType voucherEventType;
    public PayTypeData.PayTypeVoucherMsgV2 voucherMsgV2;
    public VoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;
    public ArrayList<String> voucher_no_list;

    public static final enum IdentityVerifyType extends Enum<IdentityVerifyType> {
        private static final /* synthetic */ IdentityVerifyType[] $VALUES = null;
        public static final IdentityVerifyType NoPwd = null;
        public String desc;
        public String value;

        private static /* synthetic */ IdentityVerifyType[] $values() {
            return new IdentityVerifyType[]{NoPwd};
        }

        static {
            NoPwd = new IdentityVerifyType("NoPwd", 0, "3", "免密支付");
            $VALUES = $values();
        }

        public static IdentityVerifyType[] values() {
            return (IdentityVerifyType[]) $VALUES.clone();
        }

        public static IdentityVerifyType valueOf(String r100) {
            return (IdentityVerifyType) a.a(IdentityVerifyType.class, r100);
        }

        private IdentityVerifyType(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.value = r102;
            this.desc = r103;
        }
    }

    public static final enum MergedTypeDetailSectionStatus extends Enum<MergedTypeDetailSectionStatus> {
        private static final /* synthetic */ MergedTypeDetailSectionStatus[] $VALUES = null;
        public static final MergedTypeDetailSectionStatus COLLAPSE_STATUS = null;
        public static final MergedTypeDetailSectionStatus EXPAND_STATUS = null;
        public static final MergedTypeDetailSectionStatus INIT_STATUS = null;

        private static /* synthetic */ MergedTypeDetailSectionStatus[] $values() {
            return new MergedTypeDetailSectionStatus[]{INIT_STATUS, COLLAPSE_STATUS, EXPAND_STATUS};
        }

        static {
            INIT_STATUS = new MergedTypeDetailSectionStatus("INIT_STATUS", 0);
            COLLAPSE_STATUS = new MergedTypeDetailSectionStatus("COLLAPSE_STATUS", 1);
            EXPAND_STATUS = new MergedTypeDetailSectionStatus("EXPAND_STATUS", 2);
            $VALUES = $values();
        }

        public static MergedTypeDetailSectionStatus[] values() {
            return (MergedTypeDetailSectionStatus[]) $VALUES.clone();
        }

        public static MergedTypeDetailSectionStatus valueOf(String r100) {
            return (MergedTypeDetailSectionStatus) a.a(MergedTypeDetailSectionStatus.class, r100);
        }

        private MergedTypeDetailSectionStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AssetInfoBean.AssetMetaInfoBean getStdCombineAssetMetaInfoBean() {
        AssetInfoBean.AssetMetaInfoBean r100 = new AssetInfoBean.AssetMetaInfoBean();
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r101 = this.assetInfoBean.asset_combine_pay_info.asset_to_combine_asset_info_list;
        if (r101 == null) goto L11;
        int r102 = 0;
    L6:
        if (r102 >= r101.size()) goto L15;
        if (this.stdCombineLimitAssetInfoIndex == ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(r101, r102)).to_combine_asset_index) goto L14;
        r102 = r102 + 1;
        goto L6
    L14:
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(r101, r102)).asset_meta_info;
    L15:
        return r100;
    L11:
        return r100;
    }

    public AssetInfoBean.AssetMetaInfoBean getStdCurrentAssetMetaInfoBean() {
        return this.assetInfoBean.asset_meta_info;
    }

    public ArrayList<String> getVoucherList() {
        ArrayList<String> r100 = this.voucher_msg_list;
        if (r100.size() != 0) goto L5;
    L6:
        ArrayList<String> r101 = new ArrayList();
        r101.add(this.voucher_info.vouchers_label);
        return r101;
    L5:
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(this.voucher_msg_list, 0)) == true) goto L6;
        return r100;
    }

    public boolean isCardAvailable() {
        return "1".equals(this.status);
    }

    public boolean isCardInactive() {
        if (this.card_level != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNotNewBankCardShare() {
        if (TextUtils.equals(this.paymentType, "share_pay") == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.share_asset_code, CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_NEW_BANK_CARD) == true) goto L7;
        return true;
    }

    public boolean isStdCombinePay() {
        if (this.assetInfoBean.isNeedCombine() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.stdCombineLimitAssetInfoIndex != (-1)) goto L8;
        return false;
    }

    public boolean isUnionPay() {
        return TextUtils.equals("UPYSFBANK", this.card_type_name);
    }

    public PaymentMethodInfo() {
        this.ptcode = "";
        this.index = -1;
        this.icon_url = "";
        this.status = "";
        this.title = "";
        this.sub_title = "";
        this.sub_title_color = "";
        this.sub_title_icon = "";
        this.dynamic_sub_title = new ArrayList();
        this.mark = "";
        this.mark_array = new ArrayList();
        this.tips_msg = "";
        this.tips_msg_info = new ArrayList();
        this.card_no = "";
        this.bank_card_id = "";
        this.bank_name = "";
        this.front_bank_code = "";
        this.front_bank_code_name = "";
        this.card_no_mask = "";
        this.isChecked = false;
        this.isLoading = false;
        this.paymentType = "";
        this.need_pwd = "";
        this.need_send_sms = "";
        this.mobile_mask = "";
        this.card_level = -1;
        this.tt_mark = "";
        this.tt_title = "";
        this.tt_sub_title = "";
        this.tt_sub_title_icon = "";
        this.tt_icon_url = "";
        this.is_hide_merge_guide_section = false;
        this.card = new Card();
        this.user_agreement = new ArrayList();
        this.account = "";
        this.card_type_name = "";
        this.is_hide_cards = false;
        this.mergedTypeDetailSectionStatus = MergedTypeDetailSectionStatus.INIT_STATUS;
        this.voucher_info = new VoucherInfo();
        this.voucher_msg_list = new ArrayList();
        this.bytepay_voucher_msg_list = new ArrayList();
        this.sub_pay_voucher_msg_list = new ArrayList();
        this.identity_verify_way = "";
        this.subMethodInfo = new ArrayList();
        this.card_add_ext = "";
        this.pay_type_data = new PayTypeData();
        this.split_Line_text = "";
        this.standardRecDesc = "";
        this.standardShowAmount = "";
        this.credit_pay_installment = "";
        this.decision_id = "";
        this.card_style_short_name = "";
        this.select_page_guide_text = "";
        this.combineType = null;
        this.lynxExtParams = "";
        this.extParams = "";
        this.trackInfoStr = "";
        this.voucherMsgV2 = new PayTypeData.PayTypeVoucherMsgV2();
        this.adapterPosition = -1;
        this.payMethodStatusStr = "1";
        this.sub_ext = "";
        this.subPayTypeInfo = new SubPayTypeInfo();
        this.is_foreign_card = false;
        this.share_asset_code = "";
        this.share_asset_id = "";
        Boolean r100 = Boolean.FALSE;
        this.isCollapse = r100;
        this.is_default_fold = r100;
        this.fold_desc = "";
        this.currency = "";
        this.currency_setting_url = "";
        this.assetInfoBean = new AssetInfoBean();
        this.adapterItemStyle = 0;
        this.stdCombineLimitAssetInfoIndex = -1;
        this.hasValidAssetInfo = false;
        this.voucherEventType = AssetInfoBean.VoucherMsgBean.VoucherEventType.DEFAULT;
    }

    public String getInsufficientId() {
        if (isNotNewBankCardShare() == false) goto L7;
        return this.share_asset_id;
    L7:
        return this.card_no;
    }

    public void disableUnionPayBindCard(String r100) {
        this.status = "0";
        this.sub_title = r100;
        this.voucher_msg_list.clear();
        this.voucher_info.vouchers_label = "";
    }
}
