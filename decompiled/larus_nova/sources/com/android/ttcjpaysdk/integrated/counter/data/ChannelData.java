package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.Utils.AssetLogUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayForgetPwdBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayTopRightBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.PayNewCardReconfirmInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class ChannelData implements CJPayObject {
    public String app_id;
    public CJPayButtonInfo button_info;
    public CashDeskShowConf cashdesk_show_conf;
    public String finger_page_style;
    public CJPayForgetPwdBtnInfo forget_pwd_btn_info;
    public HashMap<String, String> grey_func_map;
    public LynxShowInfo lynx_show_info;
    public String merchant_id;
    public MerchantInfo merchant_info;
    public String mweb_url;
    public boolean need_resign_card;
    public String next_page;
    public String nonce_str;
    public CJPayProtocolGroupContentsBean nopwd_guide_info;
    public String order_info;
    public String partner_id;
    public CJPayPayInfo pay_info;
    public PayNewCardReconfirmInfo pay_new_card_reconfirm_info;
    public PayTypeInfo paytype_info;
    public String prepay_id;
    public ProcessInfo process_info;
    public int pwd_check_way;
    public CJPayResultPageShowConf result_page_show_conf;
    public JSONObject sdk_show_info;
    public CJPayNoPwdPayInfo secondary_confirm_info;
    public int show_no_pwd_button;
    public int show_no_pwd_confirm_page;
    public String sign;
    public String sign_type;
    public String timestamp;
    public CJPayTopRightBtnInfo top_right_btn_info;
    public JSONObject trade_confirm_response;
    public TradeInfo trade_info;
    public AssetInfoBean used_asset_info;
    public UsePayTypeInfo used_paytype_info;
    public UserInfo user_info;

    public static class CJPayResultPageShowConf implements CJPayObject {
        public int query_result_times;
        public int remain_time;
        public int show_style;
        public String success_btn_desc;
        public String success_desc;
        public String success_url;
        public int third_remain_time;

        public CJPayResultPageShowConf() {
            this.remain_time = 0;
            this.third_remain_time = 0;
            this.success_desc = "";
            this.success_url = "";
            this.success_btn_desc = "";
            this.query_result_times = 0;
            this.show_style = 0;
        }
    }

    public static class CashDeskShowConf implements CJPayObject {
        public BioOpenGuide bio_open_guide;
        public String confirm_btn_desc;
        public long left_time;
        public int show_style;
        public UserAgreement user_agreement;
        public boolean whether_show_left_time;

        public CashDeskShowConf() {
            this.confirm_btn_desc = "";
            this.user_agreement = new UserAgreement();
            this.whether_show_left_time = false;
            this.left_time = 0;
            this.show_style = 0;
            this.bio_open_guide = new BioOpenGuide();
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
        public String mobile_mask;

        public UsePayTypeInfo() {
            this.bank_card_id = "";
            this.card_no_mask = "";
            this.mobile_mask = "";
            this.bank_name = "";
        }
    }

    public Boolean fingerPrintIsHalfWindowStyle() {
        return Boolean.valueOf(TextUtils.equals(this.finger_page_style, CJPayConstant.CJ_PAY_FINGER_PAGE_STYLE_HALF));
    }

    public boolean isAssetStandard() {
        HashMap<String, String> r100 = this.grey_func_map;
        if (r100 != null) goto L7;
        return false;
    L7:
        return "1".equals(r100.get(AssetLogUtils.CJ_PAY_ASSET_STD));
    }

    public boolean userPayTypeInfoV2() {
        if (this.used_paytype_info == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ChannelData() {
        this.pwd_check_way = 0;
        this.need_resign_card = false;
        this.merchant_id = "";
        this.app_id = "";
        this.partner_id = "";
        this.prepay_id = "";
        this.nonce_str = "";
        this.timestamp = "";
        this.order_info = "";
        this.sign = "";
        this.sign_type = "";
        this.mweb_url = "";
        this.cashdesk_show_conf = new CashDeskShowConf();
        this.result_page_show_conf = new CJPayResultPageShowConf();
        this.merchant_info = new MerchantInfo();
        this.secondary_confirm_info = new CJPayNoPwdPayInfo();
        this.pay_new_card_reconfirm_info = new PayNewCardReconfirmInfo();
        this.next_page = null;
        this.paytype_info = new PayTypeInfo();
        this.process_info = new ProcessInfo();
        this.trade_info = new TradeInfo();
        this.user_info = new UserInfo();
        this.pay_info = new CJPayPayInfo();
        this.nopwd_guide_info = new CJPayProtocolGroupContentsBean();
        this.show_no_pwd_button = 0;
        this.show_no_pwd_confirm_page = 0;
        this.top_right_btn_info = new CJPayTopRightBtnInfo();
        this.forget_pwd_btn_info = new CJPayForgetPwdBtnInfo();
        this.trade_confirm_response = null;
        this.sdk_show_info = new JSONObject();
        this.button_info = null;
        this.used_asset_info = new AssetInfoBean();
        this.grey_func_map = new HashMap();
        this.finger_page_style = "";
        this.lynx_show_info = new LynxShowInfo();
    }
}
