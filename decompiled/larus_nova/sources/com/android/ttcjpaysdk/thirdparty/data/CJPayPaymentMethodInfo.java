package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.base.ui.data.VoucherRetainInfo;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPaymentMethodInfo implements Serializable {
    public String account;
    public ArrayList<CJPayPayInfo.AmountAreaInfo> amount_area_list;
    public AssetInfoBean asset_info;
    public String bank_card_id;
    public String bank_name;
    public String bubbleVoucherInfo;
    public CJPayCampaign campaign;
    public CJPayCard card;
    public String card_add_ext;
    public int card_level;
    public String card_no;
    public String card_no_mask;
    public String card_show_name;
    public String card_type_name;
    public String combine_pay_title;
    public String combine_right_top_button;
    public String credit_pay_installment;
    public String crossed_price;
    public String decision_id;
    public String default_expand_confirm_btn_label;
    public FrontPayTypeData.HomePageFoldVoucherInfo fold_voucher_info;
    public String front_bank_code;
    public String front_bank_code_name;
    public IconTips icon_tips;
    public String icon_url;
    public String identity_verify_way;
    public int index;
    public boolean isAssetStandard;
    public boolean isChecked;
    public boolean isShowLoading;
    public boolean is_combine_new_card;
    public boolean is_foreign_card;
    public boolean is_hide_merge_guide_section;
    public boolean localEnable;
    public String mark;
    public String mobile_mask;
    public String need_pwd;
    public String need_send_sms;
    public boolean need_show_voucher_enhance;
    public FrontPayTypeData.CJPayOutDisplayInfo out_display_info;
    public ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
    public FrontPayTypeData pay_type_data;
    public String paymentType;
    public FrontPayTypeData.PromotionShowPriority promotion_show_priority;
    public int selectedCombineCardIndex;
    public int selectedInstallmentIndex;
    public JSONObject server_params;
    public String share_asset_code;
    public String share_asset_id;
    public boolean show_combine_pay;
    public String standardRecDesc;
    public String standardShowAmount;
    public String standard_retain_voucher_label;
    public String standard_voucher_label;
    public String status;
    public String sub_title;
    public String sub_title_icon;
    public VoucherRetainInfo superimposed_retain_info;
    public String title;
    public String trade_confirm_button_label;
    public String trade_confirm_voucher_enhance_msg;
    public CJPayCampaign tt_campaign;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_sub_title_icon;
    public String tt_title;
    public ArrayList<CJPayUserAgreement> user_agreement;
    public CJPayVoucherInfo voucher_info;
    public ArrayList<String> voucher_msg_list;
    public ArrayList<String> voucher_no_list;
    public VoucherRetainInfo voucher_retain_info;
    public HashMap<String, FrontPayTypeData.VoucherShowInfo> voucher_show_info;
    public String voucher_show_info_type;

    public int getCombineAssetIndex() {
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() > 0) goto L5;
        return -1;
    L5:
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).to_combine_asset_index;
    }

    public String getPromotionScene() {
        if (this.asset_info != null) goto L5;
        return null;
    L5:
        if (isAssetStandard() == true) goto L7;
        return null;
    L7:
        return this.asset_info.asset_extension_show_info.promotion_scene;
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
        if (this.isAssetStandard == false) goto L7;
        return this.asset_info.asset_extension_show_info.need_resign;
    L7:
        if (this.card_level != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isEnable() {
        return "1".equals(this.status);
    }

    public boolean isForeignCard() {
        if (this.isAssetStandard == true) goto L5;
        return false;
    L5:
        AssetInfoBean r100 = this.asset_info;
        if (r100 != null) goto L9;
        return false;
    L9:
        return "1".equals(r100.ext_info.is_foreign_card);
    }

    public boolean isNeedResign() {
        AssetInfoBean r100 = this.asset_info;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.asset_extension_show_info.need_resign;
    }

    public CJPayPaymentMethodInfo() {
        this.index = -1;
        this.icon_url = "";
        this.status = "";
        this.localEnable = true;
        this.title = "";
        this.sub_title = "";
        this.sub_title_icon = "";
        this.mark = "";
        this.bank_card_id = "";
        this.is_foreign_card = false;
        this.bank_name = "";
        this.card_no_mask = "";
        this.isChecked = false;
        this.paymentType = "";
        this.need_pwd = "";
        this.need_send_sms = "";
        this.mobile_mask = "";
        this.tt_mark = "";
        this.tt_title = "";
        this.tt_sub_title = "";
        this.tt_sub_title_icon = "";
        this.tt_icon_url = "";
        this.is_hide_merge_guide_section = false;
        this.user_agreement = new ArrayList();
        this.account = "";
        this.card_type_name = "";
        this.credit_pay_installment = "";
        this.decision_id = "";
        this.isShowLoading = false;
        this.card_no = "";
        this.front_bank_code = "";
        this.front_bank_code_name = "";
        this.voucher_info = new CJPayVoucherInfo();
        this.voucher_msg_list = new ArrayList();
        this.identity_verify_way = "";
        this.pay_type_data = new FrontPayTypeData();
        this.selectedInstallmentIndex = 0;
        this.standardRecDesc = "";
        this.standard_voucher_label = "";
        this.standard_retain_voucher_label = "";
        this.fold_voucher_info = new FrontPayTypeData.HomePageFoldVoucherInfo();
        this.standardShowAmount = "";
        this.card_add_ext = "";
        this.show_combine_pay = false;
        this.trade_confirm_button_label = "";
        this.default_expand_confirm_btn_label = "";
        this.card_show_name = "";
        this.selectedCombineCardIndex = -1;
        this.is_combine_new_card = false;
        this.share_asset_code = "";
        this.share_asset_id = "";
        this.out_display_info = new FrontPayTypeData.CJPayOutDisplayInfo();
        this.crossed_price = "";
        this.need_show_voucher_enhance = false;
        this.trade_confirm_voucher_enhance_msg = "";
        this.voucher_show_info = new HashMap();
        this.promotion_show_priority = new FrontPayTypeData.PromotionShowPriority();
        this.combine_right_top_button = "";
        this.combine_pay_title = "";
        this.isAssetStandard = false;
        this.voucher_show_info_type = "";
    }

    public String getFundBillIndex() {
        if (isAssetStandard() == true) goto L5;
        return "";
    L5:
        if (isCombine() == false) goto L9;
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).asset_meta_info.fund_bill_index;
    L9:
        if (hasSubAsset() == false) goto L15;
        AssetInfoBean r100 = getSubChooseAssetInfo();
        if (r100 == null) goto L15;
        return r100.asset_meta_info.fund_bill_index;
    L15:
        return this.asset_info.asset_meta_info.fund_bill_index;
    }

    public AssetInfoBean getSubChooseAssetInfo() {
        if (hasSubAsset() == false) goto L10;
        Iterator<AssetInfoBean> r100 = this.asset_info.sub_asset_info_list.iterator();
    L6:
        if (r100.hasNext() == false) goto L15;
        AssetInfoBean r101 = r100.next();
        if (r101.asset_basic_show_info.choose != true) goto L6;
        return r101;
    L15:
        return null;
    L10:
        return null;
    }

    public String getUniqueSymbol() {
        if (isAssetStandard() == true) goto L5;
        return "";
    L5:
        if (isCombine() == false) goto L9;
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).asset_meta_info.getUniqueSymbol();
    L9:
        if (hasSubAsset() == false) goto L15;
        AssetInfoBean r100 = getSubChooseAssetInfo();
        if (r100 == null) goto L15;
        return r100.asset_meta_info.getUniqueSymbol();
    L15:
        return this.asset_info.asset_meta_info.getUniqueSymbol();
    }

    public Boolean hasOptionVouchers() {
        if (isAssetStandard() == false) goto L27;
        boolean r100 = false;
        if (isCombine() == false) goto L9;
        return Boolean.valueOf(((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).isShowPaymentSelectionMaterial());
    L9:
        if (hasSubAsset() == false) goto L20;
        AssetInfoBean r101 = getSubChooseAssetInfo();
        if (r101 == null) goto L20;
        if (r101.isShowPaymentSelectionMaterial() == false) goto L15;
    L16:
        r100 = true;
    L18:
        return Boolean.valueOf(r100);
    L15:
        if (r101.isShowFunctionGuide() == false) goto L18;
    L20:
        if (this.asset_info.isShowPaymentSelectionMaterial() == false) goto L22;
    L23:
        r100 = true;
    L25:
        return Boolean.valueOf(r100);
    L22:
        if (this.asset_info.isShowFunctionGuide() == false) goto L25;
    L27:
        return Boolean.FALSE;
    }

    public boolean hasSubAsset() {
        if (isAssetStandard() == true) goto L5;
        return false;
    L5:
        if (this.asset_info.sub_asset_info_list.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isCardAvailable() {
        if (isAssetStandard() == false) goto L7;
        return "1".equals(this.asset_info.asset_basic_show_info.status);
    L7:
        return "1".equals(this.status);
    }

    public boolean isCombine() {
        if (isAssetStandard() == true) goto L5;
        return false;
    L5:
        if (VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT.equals(this.asset_info.asset_combine_pay_info.combine_fund_type) == true) goto L7;
        return false;
    L7:
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public void updatePromotionScene(String r100) {
        if (this.asset_info != null) goto L5;
        return;
    L5:
        if (isAssetStandard() == false) goto L9;
        this.asset_info.asset_extension_show_info.promotion_scene = r100;
        return;
    }
}
