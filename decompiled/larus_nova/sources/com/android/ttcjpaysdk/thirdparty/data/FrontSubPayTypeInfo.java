package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.asset.utils.AssetInfoUtil;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class FrontSubPayTypeInfo implements CJPayObject, Serializable {
    public static final String SUB_PAY_TYPE_BALANCE = "balance";
    public static final String SUB_PAY_TYPE_CREDIT_PAY = "credit_pay";
    public int asset_combine_index;
    public AssetInfoBean asset_info;
    public boolean choose;
    public String desc_title;
    public String ext_title;
    public boolean home_page_show;
    public String icon;
    public String icon_url;
    public String identity_verify_way;
    public int index;
    public boolean isSingleStyleCombine;
    public String mark;
    public String msg;
    public FrontPayTypeData pay_type_data;
    public String status;
    public String sub_pay_type;
    public String sub_pay_type_num;
    public String sub_title;
    public int tagBgColor;
    public String title;
    public String toCombineAssetUniqueId;
    public String trade_confirm_button_label;

    public AssetInfoBean.AssetToCombineAssetInfoBean findCombineAssetInfo() {
        return AssetInfoUtil.INSTANCE.findCombineAssetInfo(this.asset_info, Integer.valueOf(this.asset_combine_index));
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

    public FrontSubPayTypeInfo() {
        this.sub_pay_type = "";
        this.sub_pay_type_num = "";
        this.status = "";
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.desc_title = "";
        this.msg = "";
        this.mark = "";
        this.identity_verify_way = "";
        this.pay_type_data = new FrontPayTypeData();
        this.trade_confirm_button_label = "";
        this.asset_combine_index = -1;
        this.isSingleStyleCombine = false;
        this.toCombineAssetUniqueId = "";
        this.tagBgColor = -1;
    }

    public FrontSubPayTypeInfo cp() {
        if (isAssetStandard() == false) goto L6;
        FrontSubPayTypeInfo r100 = new FrontSubPayTypeInfo();
        r100.asset_info = this.asset_info.cp();
        r100.asset_combine_index = this.asset_combine_index;
        return r100;
    L6:
        return this;
    }

    public ArrayList<CJPayPayInfo.AmountAreaInfo> getAmountAreaList() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_extension_show_info.amount_area_list;
    L7:
        return this.pay_type_data.amount_area_list;
    }

    public ArrayList<CJPayPayInfo.AmountAreaInfo> getCombineAmountAreaList() {
        if (isAssetStandard() == false) goto L10;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = findCombineAssetInfo();
        if (r100 != null) goto L11;
        return null;
    L11:
        return r100.amount_area_list;
    L10:
        return this.pay_type_data.combine_pay_info.amount_area_list;
    }

    public String getCombinePayAmountDesc1() {
        if (isAssetStandard() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = findCombineAssetInfo();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.origin_asset_amount_desc;
    L8:
        return "";
    }

    public String getCombinePayAmountDesc2() {
        if (isAssetStandard() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = findCombineAssetInfo();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.to_combine_asset_amount_desc;
    L8:
        return "";
    }

    public String getCombinePayTitle1() {
        if (isAssetStandard() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = findCombineAssetInfo();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.origin_asset_desc;
    L8:
        return "";
    }

    public String getCombinePayTitle2() {
        if (isAssetStandard() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = findCombineAssetInfo();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.to_combine_asset_desc;
    L8:
        return "";
    }

    public String getFundBillIndex() {
        if (isAssetStandard() == true) goto L5;
        return "";
    L5:
        if (this.asset_combine_index == (-1)) goto L7;
        Iterator<AssetInfoBean.AssetToCombineAssetInfoBean> r100 = this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();
    L16:
        if (r100.hasNext() == false) goto L26;
        AssetInfoBean.AssetToCombineAssetInfoBean r101 = r100.next();
        if (r101.to_combine_asset_index != this.asset_combine_index) goto L16;
        return r101.asset_meta_info.fund_bill_index;
    L26:
        return "";
    L7:
        if (hasSubAsset() == false) goto L13;
        AssetInfoBean r102 = getSubChooseAssetInfo();
        if (r102 == null) goto L13;
        return r102.asset_meta_info.fund_bill_index;
    L13:
        return this.asset_info.asset_meta_info.fund_bill_index;
    }

    public String getIconUrl() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_basic_show_info.icon_url;
    L7:
        return this.icon_url;
    }

    public boolean getIsChoose() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_basic_show_info.choose;
    L7:
        return this.choose;
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

    public String getSubTitle() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_basic_show_info.sub_title;
    L7:
        return this.sub_title;
    }

    public String getTitle() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_basic_show_info.title;
    L7:
        return this.title;
    }

    public String getTradeConfirmButtonLabel() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_extension_show_info.trade_confirm_button_label;
    L7:
        return this.trade_confirm_button_label;
    }

    public String getUniqueSymbol() {
        if (isAssetStandard() == true) goto L5;
        return "";
    L5:
        if (this.asset_combine_index == (-1)) goto L7;
        Iterator<AssetInfoBean.AssetToCombineAssetInfoBean> r100 = this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();
    L16:
        if (r100.hasNext() == false) goto L26;
        AssetInfoBean.AssetToCombineAssetInfoBean r101 = r100.next();
        if (r101.to_combine_asset_index != this.asset_combine_index) goto L16;
        return r101.asset_meta_info.getUniqueSymbol();
    L26:
        return "";
    L7:
        if (hasSubAsset() == false) goto L13;
        AssetInfoBean r102 = getSubChooseAssetInfo();
        if (r102 == null) goto L13;
        return r102.asset_meta_info.getUniqueSymbol();
    L13:
        return this.asset_info.asset_meta_info.getUniqueSymbol();
    }

    public CJPayVoucherInfo getVoucherInfo() {
        if (isAssetStandard() == false) goto L7;
        return null;
    L7:
        return this.pay_type_data.voucher_info;
    }

    public ArrayList<String> getVoucherMsgList() {
        if (isAssetStandard() == false) goto L13;
        ArrayList<String> r100 = new ArrayList();
        Iterator<AssetInfoBean.VoucherTagBean> r101 = this.asset_info.asset_extension_show_info.voucher_msg_map.tag56.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        Iterator<AssetInfoBean.VoucherLabel> r102 = r101.next().label.iterator();
    L9:
        if (r102.hasNext() == false) goto L6;
        r100.add(r102.next().text);
        goto L9
    L11:
        return r100;
    L13:
        return this.pay_type_data.voucher_msg_list;
    }

    public Boolean hasOptionVoucher() {
        if (isAssetStandard() == false) goto L32;
        if (this.asset_combine_index != (-1)) goto L24;
        boolean r100 = false;
        if (hasSubAsset() == false) goto L18;
        AssetInfoBean r101 = getSubChooseAssetInfo();
        if (r101 == null) goto L18;
        if (r101.isShowPaymentSelectionMaterial() == false) goto L13;
    L14:
        r100 = true;
    L16:
        return Boolean.valueOf(r100);
    L13:
        if (r101.isShowFunctionGuide() == false) goto L16;
    L18:
        if (this.asset_info.isShowPaymentSelectionMaterial() == false) goto L20;
    L21:
        r100 = true;
    L23:
        return Boolean.valueOf(r100);
    L20:
        if (this.asset_info.isShowFunctionGuide() == false) goto L23;
    L24:
        Iterator<AssetInfoBean.AssetToCombineAssetInfoBean> r102 = this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();
    L26:
        if (r102.hasNext() == false) goto L32;
        AssetInfoBean.AssetToCombineAssetInfoBean r103 = r102.next();
        if (r103.to_combine_asset_index != this.asset_combine_index) goto L26;
        return Boolean.valueOf(r103.isShowPaymentSelectionMaterial());
    L32:
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

    public boolean isBindCard() {
        if (isAssetStandard() == false) goto L7;
        return AssetInfoUtil.INSTANCE.isBindCardPay(this.asset_info);
    L7:
        return "new_bank_card".equals(this.sub_pay_type);
    }

    public boolean isCombine() {
        if (isAssetStandard() == false) goto L10;
        if (this.asset_combine_index == (-1)) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.pay_type_data.show_combine_pay;
    }

    public boolean isEnable() {
        if (isAssetStandard() == false) goto L7;
        return "1".equals(this.asset_info.asset_basic_show_info.status);
    L7:
        return "1".equals(this.status);
    }

    public FrontSubPayTypeInfo(AssetInfoBean r100) {
        this.sub_pay_type = "";
        this.sub_pay_type_num = "";
        this.status = "";
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.desc_title = "";
        this.msg = "";
        this.mark = "";
        this.identity_verify_way = "";
        this.pay_type_data = new FrontPayTypeData();
        this.trade_confirm_button_label = "";
        this.asset_combine_index = -1;
        this.isSingleStyleCombine = false;
        this.toCombineAssetUniqueId = "";
        this.tagBgColor = -1;
        this.asset_info = r100;
    }

    public String getCombineStandardRecDesc(boolean r100) {
        if (isAssetStandard() == false) goto L7;
        return AssetInfoUtil.INSTANCE.parseCombineStandardRecDesc(findCombineAssetInfo(), r100);
    L7:
        return this.pay_type_data.combine_pay_info.standard_rec_desc;
    }

    public String getCombineStandardShowAmount(boolean r100) {
        if (isAssetStandard() == false) goto L7;
        return AssetInfoUtil.INSTANCE.parseCombineStandardShowAmount(findCombineAssetInfo(), r100);
    L7:
        return this.pay_type_data.combine_pay_info.standard_show_amount;
    }

    public String getStandardRecDesc(boolean r100) {
        if (isAssetStandard() == false) goto L7;
        return AssetInfoUtil.INSTANCE.parseStandardRecDesc(this.asset_info.asset_extension_show_info, r100);
    L7:
        return this.pay_type_data.standard_rec_desc;
    }

    public String getStandardShowAmount(boolean r100) {
        if (isAssetStandard() == false) goto L7;
        return AssetInfoUtil.INSTANCE.parseStandardShowAmount(this.asset_info.asset_extension_show_info, r100);
    L7:
        return this.pay_type_data.standard_show_amount;
    }

    public void setChoose(boolean r100) {
        if (isAssetStandard() == false) goto L5;
        this.asset_info.asset_basic_show_info.choose = r100;
        return;
    L5:
        this.choose = r100;
    }
}
