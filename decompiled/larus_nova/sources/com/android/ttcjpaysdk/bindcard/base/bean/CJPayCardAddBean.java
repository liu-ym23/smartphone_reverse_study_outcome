package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.service.ICJPayNormalBindCardService;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUnionPassParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCardAddBean extends CJPayBindCardBaseBean {
    public boolean authorizeClicked;
    public Map<String, String> background_info;
    public CJPayBusiAuthorizeInfo busi_authorize_info;
    public String busi_authorize_info_str;
    public boolean cardBinAutoFocus;
    public String end_page_url;
    public boolean goSetPwd;
    public boolean isNeedCardInfo;
    public CJPayUnionPassParams pass_params;
    public String processInfo;
    public CJPayKeepDialogBean retention_msg;
    public ICJPayNormalBindCardService.SourceType sourceType;
    public String union_pay_sign_info;
    public CJPayBindCardParamsBean url_params;
    public CJPayUserInfo user_info;
    public VerifyPwdTxtInfo verify_pwd_copywriting_info;

    public static class VerifyPwdTxtInfo implements CJPayObject, Serializable {
        public String display_desc;
        public String sub_title;
        public String title;

        public VerifyPwdTxtInfo() {
            this.title = "";
            this.sub_title = "";
            this.display_desc = "";
        }
    }

    public String getProductPrice() {
        CJPayBindCardParamsBean r100 = this.url_params;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.order_amount;
    }

    public Boolean hasOrderIconAndText() {
        CJPayBindCardParamsBean r100 = this.url_params;
        if (r100 == null) goto L11;
        CJPayOneKeyCopyWritingInfo r101 = r100.card_copywriting_info;
        if (r101 == null) goto L11;
        if (TextUtils.isEmpty(r101.order_display_icon) == true) goto L11;
        if (TextUtils.isEmpty(this.url_params.card_copywriting_info.order_display_desc) == true) goto L11;
        boolean r102 = true;
    L13:
        return Boolean.valueOf(r102);
    L11:
        r102 = false;
        goto L13
    }

    public boolean hasTitleText() {
        CJPayBindCardParamsBean r100 = this.url_params;
        if (r100 == null) goto L9;
        CJPayOneKeyCopyWritingInfo r101 = r100.card_copywriting_info;
        if (r101 == null) goto L9;
        if (TextUtils.isEmpty(r101.title) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isBindCardThenPay() {
        return !this.isNeedCardInfo;
    }

    public boolean isSelectBankInCounter() {
        CJPayBindCardParamsBean r100 = this.url_params;
        if (r100 == null) goto L9;
        CJPayBankInfoBean r101 = r100.one_key_bank_info;
        if (r101 == null) goto L9;
        if (TextUtils.isEmpty(r101.bank_name) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public CJPayCardAddBean() {
        this.url_params = new CJPayBindCardParamsBean();
        this.user_info = new CJPayUserInfo();
        this.verify_pwd_copywriting_info = new VerifyPwdTxtInfo();
        this.pass_params = new CJPayUnionPassParams();
        this.goSetPwd = false;
        this.isNeedCardInfo = false;
        this.processInfo = "";
        this.busi_authorize_info_str = "";
        this.background_info = new HashMap();
        this.busi_authorize_info = new CJPayBusiAuthorizeInfo();
        this.authorizeClicked = false;
        this.union_pay_sign_info = "";
        this.sourceType = ICJPayNormalBindCardService.SourceType.Null;
        this.cardBinAutoFocus = false;
        this.end_page_url = "";
    }
}
