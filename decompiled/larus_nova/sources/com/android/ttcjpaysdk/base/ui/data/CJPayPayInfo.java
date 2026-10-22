package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.ui.Utils.AssetProcessUtils;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayPayInfo implements CJPayObject {
    private static final String TAG = "CJPayPayInfo";
    public ArrayList<AmountAreaInfo> amount_area_list;
    public AssetInfoBean asset_info;
    public String bank_card_id;
    public String bubbleVoucherInfo;
    public String business_scene;
    public ArrayList<String> cashier_tag;
    public CJPayCircularCarouselRegionConfig circular_carousel_region;
    public ArrayList<CombineShowInfo> combine_show_info;
    public String combine_type;
    public String credit_activate_url;
    public String credit_pay_installment;
    public String currency;
    public String decision_id;
    public String ext_image;
    public boolean forbid_retain_default;
    public String guide_voucher_label;
    public boolean has_random_discount;
    public boolean is_credit_activate;
    public boolean is_foreign_card;
    public boolean is_need_jump_target_url;
    public String jump_lynx_url;
    public String local_verify_downgrade_desc;
    public CJMemberVerifyInfo member_verify_info;
    public String origin_fee_per_installment;
    public String origin_trade_amount;
    public String pay_amount_per_installment;
    public String pay_icon;
    public String pay_name;
    public String price_zone_show_style;
    public String primary_pay_type;
    public String real_fee_per_installment;
    public String real_trade_amount;
    public int real_trade_amount_raw;
    public String recipient_desc;
    public RegionShowConfig region_show_config;
    public RetainInfo retain_info;
    public JSONObject retain_info_batch;
    public JSONObject retain_info_v2;
    public boolean retain_new_road_switch;
    public String share_asset_code;
    public String share_asset_id;
    public String show_amount_view;
    public String show_change_paytype;
    public String show_combine_style;
    public String sign_no;
    public String sms_verify_mobile_mask;
    public String standard_rec_desc;
    public String standard_show_amount;
    public ArrayList<SubPayTypeDisplayInfo> sub_pay_type_display_info_list;
    public SubPayTypeRecommend sub_pay_type_recommend;
    public boolean switch_finger_verify_type;
    public String target_url;
    public ToastInfo toast_info;
    public String trade_desc;
    public String verify_desc;
    public String verify_desc_icon;
    public VerifyDescRegionInfo verify_desc_region_info;
    public int verify_desc_type;
    public String verify_downgrade_reason;
    public String verify_type;
    public String voucher_msg;
    public ArrayList<String> voucher_no_list;
    public String voucher_type;

    public static class AmountAreaInfo implements CJPayObject, Serializable {
        public String area_name;
        public IconTips icon_tips;
        public String text;
        public boolean text_high_light;

        public AmountAreaInfo() {
            this.area_name = "";
            this.text = "";
            this.text_high_light = false;
        }
    }

    public static class CJAtomicComponent implements CJPayObject, Serializable {
        public String color;
        public int font_size;
        public int height;
        public String text;
        public String type;
        public String url;
        public int width;

        public CJAtomicComponent() {
            this.type = "";
            this.url = "";
            this.width = 0;
            this.height = 0;
            this.text = "";
            this.color = "";
            this.font_size = 0;
        }
    }

    public static class CJCircularCarouselComponent implements CJPayObject, Serializable {
        public ArrayList<CJAtomicComponent> atomic_component_list;
        public String component_type;

        public CJCircularCarouselComponent() {
            this.component_type = "";
            this.atomic_component_list = new ArrayList();
        }
    }

    public static class CJMemberVerifyInfo implements CJPayObject, Serializable {
        public String schema;
        public String verify_id;
        public String verify_token;

        public CJMemberVerifyInfo() {
            this.schema = "";
            this.verify_id = "";
            this.verify_token = "";
        }
    }

    public static class CombineShowInfo implements CJPayObject, Serializable {
        public String combine_msg;
        public String combine_type;
        public String expand_combine_msg;

        public CombineShowInfo() {
            this.combine_type = "";
            this.combine_msg = "";
            this.expand_combine_msg = "";
        }
    }

    public static class RegionShowConfig implements CJPayObject, Serializable {
        public String bound_card_bubble_display_duration;
        public String bound_card_bubble_title;
        public String show_forget_pwd_button;
        public String show_peer_asset_list_region;
        public String sub_pay_type_change_region;
        public String sub_pay_type_desc_region;
        public String verify_desc_region;
        public String verify_page_new_header_style;

        public RegionShowConfig() {
            this.sub_pay_type_change_region = "1";
            this.sub_pay_type_desc_region = "1";
            this.verify_desc_region = "";
            this.verify_page_new_header_style = "";
            this.bound_card_bubble_title = "";
            this.bound_card_bubble_display_duration = "";
            this.show_forget_pwd_button = "";
            this.show_peer_asset_list_region = "";
        }
    }

    public static class SubPayTypeRecommend implements CJPayObject, Serializable {
        public AssetInfoBean.AssetMetaInfoBean asset_meta_info;
        public String button_action;
        public String button_label;
        public String icon_url;
        public JumpInfoBean jump_info;
        public String jump_url;
        public String recommend_msg;
        public String sub_pay_type_code;
        public String sub_pay_type_key;
        public UIComponent voucher_msg_info;

        public SubPayTypeRecommend() {
            this.sub_pay_type_code = "";
            this.sub_pay_type_key = "";
            this.icon_url = "";
            this.recommend_msg = "";
            this.button_label = "";
            this.button_action = "";
            this.jump_url = "";
            this.asset_meta_info = new AssetInfoBean.AssetMetaInfoBean();
            this.jump_info = new JumpInfoBean();
        }
    }

    public static class ToastInfo implements CJPayObject, Serializable {
        public String toast_msg;
        public String toast_type;

        public ToastInfo() {
            this.toast_type = "";
            this.toast_msg = "";
        }
    }

    public static class VerifyDescRegionInfo implements CJPayObject, Serializable {
        public String icon_url;
        public String msg;
        public String position;
        public VerifyMsgInfo reset_pwd_verify_msg;

        public VerifyDescRegionInfo() {
            this.icon_url = "";
            this.msg = "";
            this.position = "";
            this.reset_pwd_verify_msg = new VerifyMsgInfo();
        }
    }

    public static class VerifyMsgInfo implements CJPayObject, Serializable {
        public String icon_url;
        public String msg;
        public String position;

        public VerifyMsgInfo() {
            this.icon_url = "";
            this.msg = "";
            this.position = "";
        }
    }

    public String getStandardRecDescIgnoreLimit() {
        AssetProcessUtils r100 = AssetProcessUtils.INSTANCE;
        if (r100.isSingleCombineStyle(this.show_combine_style) == false) goto L17;
        if (CJPaySettingsManager.getInstance().isDegradeSmsCombine() == true) goto L17;
        AssetInfoBean r101 = this.asset_info;
        if (r101 == null) goto L13;
        AssetInfoBean.AssetToCombineAssetInfoBean r102 = r101.findDefaultCombineInfo();
        if (r102 != null) goto L11;
        CJLogger.b(TAG, this.show_combine_style + " AssetToCombineAssetInfoBean is null");
        return "";
    L11:
        return r100.parseDesc(r102);
    L13:
        CJLogger.b(TAG, this.show_combine_style + " init asset info is null");
        return "";
    L17:
        return getStandardRecDesc();
    }

    public String getStandardShowAmountIgnoreLimit() {
        AssetProcessUtils r100 = AssetProcessUtils.INSTANCE;
        if (r100.isSingleCombineStyle(this.show_combine_style) == false) goto L17;
        if (CJPaySettingsManager.getInstance().isDegradeSmsCombine() == true) goto L17;
        AssetInfoBean r101 = this.asset_info;
        if (r101 == null) goto L13;
        AssetInfoBean.AssetToCombineAssetInfoBean r102 = r101.findDefaultCombineInfo();
        if (r102 != null) goto L11;
        CJLogger.b(TAG, this.show_combine_style + " AssetToCombineAssetInfoBean is null");
        return "";
    L11:
        return r100.parseAmount(r102);
    L13:
        CJLogger.b(TAG, this.show_combine_style + " init asset info is null");
        return "";
    L17:
        return getStandardShowAmount();
    }

    public boolean hideAmount() {
        return TextUtils.equals(this.show_amount_view, "0");
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

    public boolean isDynamicPwd() {
        if (this.cashier_tag.contains("fe_tag_static_forget_pwd_style") == false) goto L5;
    L8:
        return true;
    L5:
        if (this.cashier_tag.contains("fe_tag_guide_mid_style") == true) goto L8;
        return false;
    }

    public boolean isLocalFingerUnableExp() {
        ArrayList<String> r100 = this.cashier_tag;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.contains("local_unable_opt");
    }

    public boolean isNewBankCardShare() {
        return TextUtils.equals(this.share_asset_code, CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_NEW_BANK_CARD);
    }

    public boolean isOrderShare() {
        return TextUtils.equals(this.share_asset_code, CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_ORDER_SHARE);
    }

    public boolean isShowSecurityView() {
        if (this.verify_desc_type == 1) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.verify_desc) == true) goto L7;
        return true;
    }

    public boolean pwdPageShowChangeCombineInfo() {
        ArrayList<String> r100 = this.cashier_tag;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.contains("verify_page_support_combine_pay");
    }

    public void removeAmountData() {
        this.price_zone_show_style = "";
        this.standard_rec_desc = "";
        this.standard_show_amount = "";
    }

    public boolean useHalfBindCardLoading() {
        ArrayList<String> r100 = this.cashier_tag;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.contains("use_half_bindcard_loading");
    }

    public CJPayPayInfo() {
        this.business_scene = "";
        this.ext_image = "";
        this.sign_no = "";
        this.bank_card_id = "";
        this.is_foreign_card = false;
        this.credit_pay_installment = "";
        this.pay_amount_per_installment = "";
        this.origin_fee_per_installment = "";
        this.real_fee_per_installment = "";
        this.voucher_no_list = new ArrayList();
        this.decision_id = "";
        this.real_trade_amount = "";
        this.real_trade_amount_raw = 0;
        this.origin_trade_amount = "";
        this.voucher_msg = "";
        this.credit_activate_url = "";
        this.is_need_jump_target_url = false;
        this.target_url = "";
        this.voucher_type = "";
        this.pay_name = "";
        this.verify_type = "";
        this.verify_desc = "";
        this.verify_desc_icon = "";
        this.sms_verify_mobile_mask = "";
        this.verify_desc_type = 0;
        this.local_verify_downgrade_desc = "";
        this.verify_downgrade_reason = "";
        this.trade_desc = "";
        this.currency = "";
        this.pay_icon = "";
        this.has_random_discount = false;
        this.combine_show_info = new ArrayList();
        this.cashier_tag = new ArrayList();
        this.guide_voucher_label = "";
        this.sub_pay_type_display_info_list = new ArrayList();
        this.show_change_paytype = "";
        this.price_zone_show_style = "";
        this.standard_rec_desc = "";
        this.standard_show_amount = "";
        this.show_amount_view = "";
        this.switch_finger_verify_type = false;
        this.bubbleVoucherInfo = "";
        this.share_asset_code = "";
        this.share_asset_id = "";
        this.recipient_desc = "";
        this.member_verify_info = new CJMemberVerifyInfo();
        this.jump_lynx_url = "";
        this.show_combine_style = "";
        this.circular_carousel_region = new CJPayCircularCarouselRegionConfig();
        this.forbid_retain_default = false;
        this.retain_new_road_switch = false;
    }

    public ArrayList<AmountAreaInfo> getAmountAreaList() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.asset_extension_show_info.amount_area_list;
    L7:
        return this.amount_area_list;
    }

    public AssetInfoBean.AssetToCombineAssetInfoBean getCombineAssetInfo() {
        if (isAssetStandard() == true) goto L5;
        return null;
    L5:
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.isEmpty() == false) goto L7;
        return null;
    L7:
        return (AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0);
    }

    public String getCombinePayAmountDesc1() {
        if (isAssetStandard() == false) goto L8;
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() > 0) goto L12;
    L10:
        return "";
    L12:
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).origin_asset_amount_desc;
    L8:
        if (this.sub_pay_type_display_info_list.size() <= 0) goto L10;
        return ((SubPayTypeDisplayInfo) ListProtector.get(this.sub_pay_type_display_info_list, 0)).payment_info;
    }

    public String getCombinePayAmountDesc2() {
        if (isAssetStandard() == false) goto L8;
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() > 0) goto L12;
    L10:
        return "";
    L12:
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).to_combine_asset_amount_desc;
    L8:
        if (this.sub_pay_type_display_info_list.size() <= 1) goto L10;
        return ((SubPayTypeDisplayInfo) ListProtector.get(this.sub_pay_type_display_info_list, 1)).payment_info;
    }

    public String getCombinePayTitle1() {
        if (isAssetStandard() == false) goto L8;
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() > 0) goto L12;
    L10:
        return "";
    L12:
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).origin_asset_desc;
    L8:
        if (this.sub_pay_type_display_info_list.size() <= 0) goto L10;
        return ((SubPayTypeDisplayInfo) ListProtector.get(this.sub_pay_type_display_info_list, 0)).title;
    }

    public String getCombinePayTitle2() {
        if (isAssetStandard() == false) goto L8;
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() > 0) goto L12;
    L10:
        return "";
    L12:
        return ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).to_combine_asset_desc;
    L8:
        if (this.sub_pay_type_display_info_list.size() <= 1) goto L10;
        return ((SubPayTypeDisplayInfo) ListProtector.get(this.sub_pay_type_display_info_list, 1)).title;
    }

    public String getStandardRecDesc() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.parseStandardRecDesc();
    L7:
        return this.standard_rec_desc;
    }

    public String getStandardShowAmount() {
        if (isAssetStandard() == false) goto L7;
        return this.asset_info.parseStandardRecAmount();
    L7:
        return this.standard_show_amount;
    }

    public AssetInfoBean getSubChooseAssetInfo() {
        if (isAssetStandard() == false) goto L10;
        Iterator<AssetInfoBean> r100 = this.asset_info.sub_asset_info_list.iterator();
    L6:
        if (r100.hasNext() == false) goto L15;
        AssetInfoBean r101 = r100.next();
        if (r101.asset_basic_show_info.choose == false) goto L6;
        return r101;
    L15:
        return null;
    L10:
        return null;
    }

    public Boolean hasSubPayTypeDisplaList() {
        if (isAssetStandard() == false) goto L7;
        return Boolean.TRUE;
    L7:
        if (this.sub_pay_type_display_info_list.size() <= 0) goto L9;
        boolean r100 = true;
    L11:
        return Boolean.valueOf(r100);
    L9:
        r100 = false;
        goto L11
    }

    public Boolean isBandCard() {
        if (isAssetStandard() == false) goto L7;
        return Boolean.valueOf(this.asset_info.isBindCardPay());
    L7:
        return Boolean.valueOf("Pre_Pay_NewCard".equals(this.business_scene));
    }

    public boolean isCombinePay() {
        if (isAssetStandard() == false) goto L11;
        if (VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT.equals(this.asset_info.asset_combine_pay_info.combine_fund_type) == true) goto L7;
        return false;
    L7:
        if (this.asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() <= 0) goto L15;
        return true;
    L15:
        return false;
    L11:
        if (this.sub_pay_type_display_info_list.size() <= 1) goto L16;
        return true;
    L16:
        return false;
    }
}
