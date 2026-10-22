package com.android.ttcjpaysdk.thirdparty.payagain.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayBubbleInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.base.ui.data.PayTypeVoucherMsgV2;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCard;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserAgreement;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class FrontPaymentMethodInfo implements CJPayObject {
    public String account;
    public AssetInfoBean asset_info;
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public CJPayBubbleInfo bubble_info_map;
    public CJPayCard card;
    public String card_add_ext;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_show_name;
    public String card_type;
    public String card_type_name;
    public boolean choose;
    public String credit_pay_installment;
    public ArrayList<CJPayCreditPayMethods> credit_pay_methods;
    public String crossedPrice;
    public String decision_id;
    public String desc_title;
    public String front_bank_code;
    public String front_bank_code_name;
    public String icon_url;
    public String identity_verify_way;
    public int index;
    public boolean isAssetStandard;
    public boolean isChecked;
    public boolean isLoading;
    public boolean isShowLoading;
    public boolean is_credit_activate;
    public boolean is_foreign_card;
    public boolean is_hide_cards;
    public boolean is_hide_merge_guide_section;
    public String mark;
    public MergedTypeDetailSectionStatus mergedTypeDetailSectionStatus;
    public String mobile_mask;
    public String msg;
    public String need_pwd;
    public String need_send_sms;
    public String new_bank_card_fold_desc;
    public FrontPayTypeData pay_type_data;
    public String paymentType;
    public String perpay_limit;
    public String select_page_guide_text;
    public String share_asset_code;
    public String share_asset_id;
    public boolean show_combine_pay;
    public String sign_no;
    public String standardRecDesc;
    public String standardShowAmount;
    public String status;
    public ArrayList<FrontPaymentMethodInfo> subMethodInfo;
    public String sub_title;
    public String sub_title_color;
    public String sub_title_icon;
    public String title;
    public String trade_confirm_button_label;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_sub_title_icon;
    public String tt_title;
    public ArrayList<CJPayUserAgreement> user_agreement;
    public ViewType view_type;
    public PayTypeVoucherMsgV2 voucherMsgV2;
    public CJPayVoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;
    public ArrayList<String> voucher_no_list;

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

    public static final enum ViewType extends Enum<ViewType> {
        private static final /* synthetic */ ViewType[] $VALUES = null;
        public static final ViewType FOLD_AREA = null;
        public static final ViewType NORMAL = null;
        public static final ViewType SPLIT_LINE = null;

        private static /* synthetic */ ViewType[] $values() {
            return new ViewType[]{NORMAL, SPLIT_LINE, FOLD_AREA};
        }

        static {
            NORMAL = new ViewType(EffectConstants.NORMAL, 0);
            SPLIT_LINE = new ViewType("SPLIT_LINE", 1);
            FOLD_AREA = new ViewType("FOLD_AREA", 2);
            $VALUES = $values();
        }

        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }

        public static ViewType valueOf(String r100) {
            return (ViewType) a.a(ViewType.class, r100);
        }

        private ViewType(String r100, int r101) {
            super(r100, r101);
        }
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

    public boolean isEnable() {
        return "1".equals(this.status);
    }

    public boolean isNotNewBankCardShare() {
        if (TextUtils.equals(this.paymentType, "share_pay") == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.share_asset_code, CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_NEW_BANK_CARD) == true) goto L7;
        return true;
    }

    public FrontPaymentMethodInfo() {
        this.index = -1;
        this.icon_url = "";
        this.status = "";
        this.title = "";
        this.sub_title = "";
        this.sub_title_color = "";
        this.sub_title_icon = "";
        this.mark = "";
        this.card_no = "";
        this.bank_card_id = "";
        this.is_foreign_card = false;
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
        this.card = new CJPayCard();
        this.user_agreement = new ArrayList();
        this.account = "";
        this.card_type_name = "";
        this.is_hide_cards = false;
        this.mergedTypeDetailSectionStatus = MergedTypeDetailSectionStatus.INIT_STATUS;
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new CJPayVoucherInfo();
        this.identity_verify_way = "";
        this.subMethodInfo = new ArrayList();
        this.card_add_ext = "";
        this.pay_type_data = new FrontPayTypeData();
        this.credit_pay_installment = "";
        this.decision_id = "";
        this.view_type = ViewType.NORMAL;
        this.new_bank_card_fold_desc = "";
        this.choose = false;
        this.msg = "";
        this.desc_title = "";
        this.bank_code = "";
        this.card_type = "";
        this.card_show_name = "";
        this.perpay_limit = "";
        this.sign_no = "";
        this.standardRecDesc = "";
        this.standardShowAmount = "";
        this.crossedPrice = "";
        this.select_page_guide_text = "";
        this.is_credit_activate = false;
        this.credit_pay_methods = new ArrayList();
        this.voucherMsgV2 = new PayTypeVoucherMsgV2();
        this.trade_confirm_button_label = "";
        this.bubble_info_map = new CJPayBubbleInfo();
        this.share_asset_code = "";
        this.share_asset_id = "";
        this.isAssetStandard = false;
    }

    public String getInsufficientId() {
        if (isNotNewBankCardShare() == false) goto L7;
        return this.share_asset_id;
    L7:
        return this.card_no;
    }
}
