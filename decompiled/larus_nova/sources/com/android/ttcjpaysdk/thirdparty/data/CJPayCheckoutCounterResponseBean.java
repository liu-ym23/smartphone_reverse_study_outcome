package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.asset.bean.CashierPageInfoBean;
import com.android.ttcjpaysdk.asset.utils.AssetInfoUtil;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.Utils.AssetLogUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJCommonRecommendInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCheckoutCounterButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayDoubleConfirmPageInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayDoubleConfirmPopInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayForgetPwdBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayTopRightBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.base.ui.data.PayNewCardReconfirmInfo;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.CheckoutCounterUnifyCashierInfo;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.dypay.activity.DyPayCoreActivity;
import com.bytedance.caijing.sdk.infra.base.api.localtest.CJPayDebugSwitchOverrideService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import ve4.a;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCheckoutCounterResponseBean implements CJPayObject {
    public CJPayTopRightBtnInfo back_top_right_btn_info;
    public String bindcard_exts;
    public CJPayBioOpenAndPayInfo bio_open_and_pay_info;
    public CJPayCheckoutCounterButtonInfo button_info;
    public CheckoutCounterCashDeskShowConf cashdesk_show_conf;
    public CashierPageInfoBean cashier_page_info;
    public String code;
    public JSONObject collected_asset_ext_map;
    public CJCommonRecommendInfo common_recommend_info;
    public ArrayList<UIComponent> countdown_area;
    public CJPayDoubleConfirmPageInfo double_confirm_page_info;
    public CJPayDoubleConfirmPopInfo double_confirm_pop_info;
    public Map<String, String> exts;
    public String finger_page_style;
    public CJPayForgetPwdBtnInfo forget_pwd_btn_info;
    public HashMap<String, String> grey_func_map;
    public boolean isNeedUnLockCard;
    public Boolean isStdFromCreditPayActiveOrUnlock;
    public LynxShowInfo lynx_show_info;
    public CJPayMerchantInfo merchant_info;
    public String msg;
    public boolean need_resign_card;
    public String next_page;
    public CJPayProtocolGroupContentsBean nopwd_guide_info;
    public String nopwd_pre_show;
    public CJPayUnionPassParams pass_params;
    public CJPayPayAndXShowParams pay_and_x_show_info;
    public CJPayPayInfo pay_info;
    public PayNewCardReconfirmInfo pay_new_card_reconfirm_info;
    public CJPayPayTypeInfo paytype_info;
    public ArrayList<AssetInfoBean> peer_asset_info_list;
    public CJPayPreBioGuideInfo pre_bio_guide_info;
    public CJPayProcessInfo process_info;
    public String rawString;
    public CJPayRecommendPopup recommend_popup;
    public CJPayResultPageShowConf result_page_show_conf;
    public RetainInfo retain_info;
    public JSONObject retain_info_v2;
    public LoadingStyleInfo sdk_show_info;
    public CJPayNoPwdPayInfo secondary_confirm_info;
    public ShowConfirmBioGuideInfo show_confirm_bio_guide_info;
    public String show_double_confirm_page;
    public int show_no_pwd_button;
    public int show_no_pwd_confirm_page;
    public SignPageInfo sign_page_info;
    public boolean skip_bio_confirm_page;
    public Map<String, String> smart_info;
    public UnifyCashierRenderInfo.StandardVerifyInfo standard_verify_info;
    public CJPayTopRightBtnInfo top_right_btn_info;
    public String track_mode;
    public long track_parse_end_timestamp;
    public String track_path;
    public String track_req_chain;
    public JSONObject trade_confirm_response;
    public CJPayTradeInfo trade_info;
    public UnifyCashierRenderInfo unify_page_info;
    public CheckoutCounterUnifyCashierInfo unify_page_info_pb;
    public AssetInfoBean used_asset_info;
    public UsePayTypeInfo used_paytype_info;
    public CJPayUserInfo user_info;

    public static class CJPayExts implements CJPayObject {
        public String balance_status;
        public String bank_card_status;
        public String credit_status;

        public CJPayExts() {
            this.balance_status = "";
            this.bank_card_status = "";
            this.credit_status = "";
        }
    }

    public static class HomePageGroupInfo implements CJPayObject, Serializable {
        public String fold_describe;
        public ArrayList<SubPayTypeGroupInfo> sub_pay_type_group_info_list;

        public boolean isNotEmpty() {
            if (this.fold_describe.isEmpty() == false) goto L10;
            ArrayList<SubPayTypeGroupInfo> r100 = this.sub_pay_type_group_info_list;
            if (r100 != null) goto L7;
        L9:
            return false;
        L7:
            if (r100.isEmpty() == true) goto L9;
        L10:
            return true;
        }

        public HomePageGroupInfo() {
            this.sub_pay_type_group_info_list = new ArrayList();
            this.fold_describe = "";
        }
    }

    public static class LynxShowInfo implements CJPayObject {
        public Map<String, Object> exts;
        public boolean need_jump;
        public String type;
        public String url;

        public LynxShowInfo() {
            this.url = "";
            this.need_jump = false;
            this.exts = new HashMap();
        }
    }

    public static class UsePayTypeInfo implements CJPayObject {
        public String bank_card_id;
        public String bank_name;
        public String card_no_mask;
        public CJPayExts exts;
        public String mobile_mask;
        public String trade_confirm_button_label;

        public UsePayTypeInfo() {
            this.bank_card_id = "";
            this.card_no_mask = "";
            this.mobile_mask = "";
            this.bank_name = "";
            this.trade_confirm_button_label = "";
            this.exts = new CJPayExts();
        }
    }

    public void afterProtoDecode() {
        CheckoutCounterUnifyCashierInfo r100 = this.unify_page_info_pb;
        if (r100 == null) goto L6;
        this.unify_page_info = r100.toUnifyCashierRenderInfo();
        this.unify_page_info_pb = null;
        return;
    }

    public Boolean fingerPrintIsHalfWindowStyle() {
        return Boolean.valueOf(TextUtils.equals(this.finger_page_style, CJPayConstant.CJ_PAY_FINGER_PAGE_STYLE_HALF));
    }

    public String getRecipientDesc() {
        String r100 = this.pay_info.recipient_desc;
        if (r100.isEmpty() == true) goto L5;
        return r100;
    L5:
        return this.merchant_info.merchant_short_to_customer;
    }

    public String getStdMethodForTea() {
        return AssetLogUtils.INSTANCE.parseDefaultAssetType(this.used_asset_info);
    }

    public String getUnionPassUrl() {
        CJPayUnionPassParams r100 = this.pass_params;
        if (r100 == null) goto L11;
        CJPayUnionPassParams.CJPayPassParamsExt r101 = r100.ext;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r101.redirectUrl) == false) goto L10;
        return null;
    L10:
        return this.pass_params.ext.redirectUrl;
    L11:
        return null;
    }

    public boolean isAssetStandard() {
        HashMap<String, String> r100 = this.grey_func_map;
        if (r100 != null) goto L7;
        return false;
    L7:
        return "1".equals(r100.get(AssetLogUtils.CJ_PAY_ASSET_STD));
    }

    public boolean isAuth() {
        return TextUtils.equals("1", this.user_info.auth_status);
    }

    public boolean isDirectDoVerify() {
        return TextUtils.equals("1", this.cashdesk_show_conf.skip_confirm_show_verify_page);
    }

    public boolean isNoPwdPreSow() {
        if ("3".equals(this.user_info.pwd_check_way) == true) goto L5;
    L7:
        return false;
    L5:
        if ("1".equals(this.nopwd_pre_show) == false) goto L7;
        return true;
    }

    public boolean isResponseOk() {
        return "CD000000".equals(this.code);
    }

    public boolean isShowPreLoading() {
        AssetInfoBean r100 = this.used_asset_info;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.asset_extension_show_info.show_pay_verify_pre_loading;
    }

    public boolean isUnifyCashierMerge() {
        HashMap<String, String> r100 = this.grey_func_map;
        if (r100 != null) goto L7;
        return false;
    L7:
        return "1".equals(r100.get("unify_cashier_merge"));
    }

    public boolean needDoubleCheckPage() {
        if (TextUtils.equals(this.show_double_confirm_page, "1") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.double_confirm_page_info == null) goto L7;
        return true;
    }

    public boolean userPayTypeInfoV2() {
        if (this.used_paytype_info == null) goto L5;
        return true;
    L5:
        return false;
    }

    public CJPayCheckoutCounterResponseBean() {
        this.code = "";
        this.msg = "";
        this.cashdesk_show_conf = new CheckoutCounterCashDeskShowConf();
        this.countdown_area = new ArrayList();
        this.merchant_info = new CJPayMerchantInfo();
        this.paytype_info = new CJPayPayTypeInfo();
        this.process_info = new CJPayProcessInfo();
        this.retain_info = new RetainInfo();
        this.retain_info_v2 = null;
        this.secondary_confirm_info = new CJPayNoPwdPayInfo();
        this.pay_new_card_reconfirm_info = new PayNewCardReconfirmInfo();
        this.next_page = null;
        this.double_confirm_page_info = new CJPayDoubleConfirmPageInfo();
        this.double_confirm_pop_info = new CJPayDoubleConfirmPopInfo();
        this.show_double_confirm_page = "0";
        this.trade_info = new CJPayTradeInfo();
        this.user_info = new CJPayUserInfo();
        this.result_page_show_conf = new CJPayResultPageShowConf();
        this.pass_params = new CJPayUnionPassParams();
        this.pay_info = new CJPayPayInfo();
        this.need_resign_card = false;
        this.nopwd_guide_info = new CJPayProtocolGroupContentsBean();
        this.show_no_pwd_button = 0;
        this.show_no_pwd_confirm_page = 0;
        this.pre_bio_guide_info = new CJPayPreBioGuideInfo();
        this.top_right_btn_info = new CJPayTopRightBtnInfo();
        this.back_top_right_btn_info = new CJPayTopRightBtnInfo();
        this.skip_bio_confirm_page = false;
        this.sdk_show_info = new LoadingStyleInfo();
        this.forget_pwd_btn_info = new CJPayForgetPwdBtnInfo();
        this.show_confirm_bio_guide_info = new ShowConfirmBioGuideInfo();
        this.sign_page_info = null;
        this.trade_confirm_response = null;
        this.nopwd_pre_show = "";
        this.isNeedUnLockCard = false;
        this.lynx_show_info = new LynxShowInfo();
        this.finger_page_style = "";
        this.bindcard_exts = "";
        this.rawString = "";
        this.cashier_page_info = new CashierPageInfoBean();
        this.grey_func_map = new HashMap();
        this.isStdFromCreditPayActiveOrUnlock = Boolean.FALSE;
        this.collected_asset_ext_map = new JSONObject();
        this.bio_open_and_pay_info = new CJPayBioOpenAndPayInfo();
        this.button_info = new CJPayCheckoutCounterButtonInfo();
        this.unify_page_info = new UnifyCashierRenderInfo();
        this.common_recommend_info = new CJCommonRecommendInfo();
        this.smart_info = new HashMap();
        this.exts = new HashMap();
        this.track_path = "";
        this.track_mode = "";
        this.track_parse_end_timestamp = 0;
        this.track_req_chain = "";
    }

    public FrontSubPayTypeInfo findBindCardFrontPayTypeData() {
        FrontSubPayTypeInfo r100 = null;
        if (isAssetStandard() == false) goto L10;
        Iterator<AssetInfoBean> r101 = this.cashier_page_info.asset_info.sub_asset_info_list.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        AssetInfoBean r102 = r101.next();
        if (AssetInfoUtil.INSTANCE.isBindCardPay(r102) == false) goto L6;
        r100 = new FrontSubPayTypeInfo();
        r100.pay_type_data.asset_info = r102;
        r100.asset_info = r102;
    L16:
        return r100;
    L10:
        Iterator<FrontSubPayTypeInfo> r103 = this.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        FrontSubPayTypeInfo r104 = r103.next();
        if ("new_bank_card".equals(r104.sub_pay_type) == false) goto L12;
        r100 = r104;
        goto L12
    }

    public FrontPayTypeData findChooseFrontPayTypeData() {
        FrontPayTypeData r100 = null;
        if (isAssetStandard() == false) goto L10;
        Iterator<AssetInfoBean> r101 = this.cashier_page_info.asset_info.sub_asset_info_list.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        AssetInfoBean r102 = r101.next();
        if (r102.asset_basic_show_info.choose == false) goto L6;
        r100 = new FrontPayTypeData();
        r100.asset_info = r102;
    L16:
        return r100;
    L10:
        Iterator<FrontSubPayTypeInfo> r103 = this.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        FrontSubPayTypeInfo r104 = r103.next();
        if (r104.choose == false) goto L12;
        r100 = r104.pay_type_data;
        goto L12
    }

    public AssetInfoBean getDefautBindCardAssetInfo() {
        if (isAssetStandard() == false) goto L10;
        Iterator<AssetInfoBean> r100 = this.cashier_page_info.asset_info.sub_asset_info_list.iterator();
    L6:
        if (r100.hasNext() == false) goto L15;
        AssetInfoBean r101 = r100.next();
        if (AssetInfoUtil.INSTANCE.isBindCardPay(r101) == false) goto L6;
        return r101;
    L15:
        return null;
    L10:
        return null;
    }

    public AssetInfoBean getDefautCombineAssetInfo() {
        if (isAssetStandard() == true) goto L5;
        return null;
    L5:
        if (this.used_asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list.size() <= 0) goto L7;
        int r100 = ((AssetInfoBean.AssetToCombineAssetInfoBean) ListProtector.get(this.used_asset_info.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).to_combine_asset_index;
    L8:
        Iterator<AssetInfoBean> r101 = this.cashier_page_info.asset_info.sub_asset_info_list.iterator();
    L10:
        if (r101.hasNext() == false) goto L19;
        AssetInfoBean r102 = r101.next();
        if (r102.asset_basic_show_info.index != r100) goto L10;
        return r102;
    L19:
        return null;
    L7:
        r100 = -1;
        goto L8
    }

    public boolean getHasSuggestCard() {
        if (isAssetStandard() == false) goto L7;
        return "freq_suggest".equals(this.cashier_page_info.asset_info.asset_primary_show_info.home_page_show_style);
    L7:
        return this.paytype_info.sub_pay_type_sum_info.freq_suggest_style_info.has_suggest_card;
    }

    public String getHomePagePictureUrl() {
        if (isAssetStandard() == false) goto L7;
        return this.cashier_page_info.asset_info.asset_primary_show_info.home_page_picture_url;
    L7:
        return this.paytype_info.home_page_picture_url;
    }

    public String getHomePageShowStyle() {
        if (isAssetStandard() == false) goto L7;
        return this.cashier_page_info.asset_info.asset_primary_show_info.home_page_show_style;
    L7:
        return this.paytype_info.sub_pay_type_sum_info.home_page_show_style;
    }

    public CJPayPayTypeInfo.OutDisplayInfo getOutDisplayInfo() {
        if (isAssetStandard() == false) goto L7;
        return this.cashier_page_info.out_display_info;
    L7:
        return this.paytype_info.out_display_info;
    }

    public String getTitleButtonLabel() {
        if (isAssetStandard() == false) goto L7;
        return this.cashier_page_info.asset_info.asset_primary_show_info.home_page_guide_info.home_page_guide_text;
    L7:
        return this.paytype_info.sub_pay_type_sum_info.freq_suggest_style_info.title_button_label;
    }

    public String getTradeConfirmButtonLabel() {
        if (isAssetStandard() == false) goto L7;
        return this.cashier_page_info.asset_info.asset_extension_show_info.trade_confirm_button_label;
    L7:
        return this.paytype_info.sub_pay_type_sum_info.freq_suggest_style_info.trade_confirm_button_label;
    }

    public boolean isHitSdkCashierCoreMerge() {
        if (CJEnv.n() == false) goto L11;
        a.f554342a.getClass();
        CJPayDebugSwitchOverrideService r100 = (CJPayDebugSwitchOverrideService) a.a(CJPayDebugSwitchOverrideService.class);
        if (r100 == null) goto L11;
        int r101 = r100.getHitSdkCashierCoreMergeOverrideState();
        if (r101 != 1) goto L9;
        return true;
    L9:
        if (r101 != 0) goto L11;
        return false;
    L11:
        HashMap<String, String> r102 = this.grey_func_map;
        if (r102 != null) goto L15;
        return false;
    L15:
        return "1".equals(r102.get(DyPayCoreActivity.EXTRA_HIT_SDK_CASHIER_CORE_MERGE));
    }

    public void initNewCustomerCardList(ArrayList<FreqSuggestCardInfo> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (isAssetStandard() == false) goto L10;
        Iterator<AssetInfoBean> r101 = this.cashier_page_info.asset_info.sub_asset_info_list.iterator();
    L8:
        if (r101.hasNext() == false) goto L20;
        AssetInfoBean r102 = r101.next();
        FreqSuggestCardInfo r103 = new FreqSuggestCardInfo();
        r103.title_button_label = getTitleButtonLabel();
        r103.trade_confirm_button_label = getTradeConfirmButtonLabel();
        r103.has_suggest_card = getHasSuggestCard();
        FrontSubPayTypeInfo r104 = new FrontSubPayTypeInfo();
        r104.asset_info = this.cashier_page_info.asset_info;
        r103.sub_pay_type_info = r104;
        r100.add(r103);
        goto L8
    L20:
        return;
    L10:
        Iterator<Integer> r105 = this.paytype_info.sub_pay_type_sum_info.freq_suggest_style_info.freq_suggest_style_index_list.iterator();
    L12:
        if (r105.hasNext() == false) goto L28;
        Integer r106 = r105.next();
        FreqSuggestCardInfo r107 = new FreqSuggestCardInfo();
        r107.title_button_label = getTitleButtonLabel();
        r107.trade_confirm_button_label = getTradeConfirmButtonLabel();
        r107.has_suggest_card = getHasSuggestCard();
        Iterator<FrontSubPayTypeInfo> r108 = this.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.iterator();
    L15:
        if (r108.hasNext() == false) goto L19;
        FrontSubPayTypeInfo r109 = r108.next();
        if (r109.index != r106.intValue()) goto L15;
        r107.sub_pay_type_info = r109;
        goto L15
    L19:
        r100.add(r107);
        goto L12
    }
}
