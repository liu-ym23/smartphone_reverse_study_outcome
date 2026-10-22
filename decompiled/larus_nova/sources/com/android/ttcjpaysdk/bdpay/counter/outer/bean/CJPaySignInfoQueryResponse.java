package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayRetainInfoV2NativeBean;
import com.android.ttcjpaysdk.base.ui.data.PrePayDoubleConfirmInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRecommendPopup;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010:\u001a\u00020\u0010J\u0006\u0010;\u001a\u00020\u0010J\u0006\u0010<\u001a\u00020\u0010J\u0006\u0010=\u001a\u00020\u0010J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007` 8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\u0012\u0012\u0004\u0012\u00020$0\u0017j\b\u0012\u0004\u0012\u00020$`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0002098\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "code", "", "confirm_sign_button", "count_num", "", "double_confirm_info", "Lcom/android/ttcjpaysdk/base/ui/data/PrePayDoubleConfirmInfo;", "exts", "Lorg/json/JSONObject;", "is_need_cashdesk", "", "merchant_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "msg", "non_blocking_popup", DyPayConstant.K_PAY_INFO_PAYSCORE_APPLY_TOKEN, "post_payments", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/PostItem;", "Lkotlin/collections/ArrayList;", DyPayConstant.K_PAY_INFO_PARAM_PRE_ENTRUSTWEB_ID, "promotion_voucher_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayPromotionVoucherInfo;", "promotion_voucher_info_raw_string", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "protocol_group_names_raw_string", "protocol_guide_desc", "protocol_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "protocol_info_raw_string", "protocol_show_position", "recommend_popup", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRecommendPopup;", "recommend_user_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayRecommendUserInfo;", "retain_info_v2", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayRetainInfoV2NativeBean;", "retain_info_v2_raw_string", "risk_fund", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayRiskFund;", "risk_verify_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/RiskVerifyInfo;", "sdk_show_info", "sign_information", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInformation;", "sign_page_style", "trace_params", b.B0, "user_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;", CJPayConstant.CJ_PAY_SHARE_PARAMS_KEY_IS_ASSET_STANDARD, "isPreSign", "isResponseOK", "protocolShowOnBody", "saveRawData", "", "dataStr", "dataObj", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySignInfoQueryResponse implements CJPayObject, Serializable {
    public static final String CREDIT_RESPONSE_SUCCEED = "CP000000";
    public static final Companion Companion = null;
    public static final String RESPONSE_NEED_OUTER_PAY = "CP400001";
    public static final String RESPONSE_SUCCEED = "AU000000";
    public CJPayButtonInfo button_info;
    public String code;
    public String confirm_sign_button;
    public int count_num;
    public PrePayDoubleConfirmInfo double_confirm_info;
    public JSONObject exts;
    public boolean is_need_cashdesk;
    public CJPayMerchantInfo merchant_info;
    public String msg;
    public CJPayButtonInfo non_blocking_popup;
    public String payscore_apply_token;
    public ArrayList<PostItem> post_payments;
    public String pre_entrustweb_id;
    public CJPayPromotionVoucherInfo promotion_voucher_info;
    public String promotion_voucher_info_raw_string;
    public HashMap<String, String> protocol_group_names;
    public String protocol_group_names_raw_string;
    public String protocol_guide_desc;
    public ArrayList<CJPayCardProtocolBean> protocol_info;
    public String protocol_info_raw_string;
    public String protocol_show_position;
    public CJPayRecommendPopup recommend_popup;
    public CJPayRecommendUserInfo recommend_user_info;
    public CJPayRetainInfoV2NativeBean retain_info_v2;
    public String retain_info_v2_raw_string;
    public CJPayRiskFund risk_fund;
    public RiskVerifyInfo risk_verify_info;
    public JSONObject sdk_show_info;
    public CJPaySignInformation sign_information;
    public String sign_page_style;
    public JSONObject trace_params;
    public String trade_no;
    public CJPayUserInfo user_info;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse$Companion;", "", "()V", "CREDIT_RESPONSE_SUCCEED", "", "RESPONSE_NEED_OUTER_PAY", "RESPONSE_SUCCEED", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean isAssetStd() {
        JSONObject r100 = this.exts;
        if (r100 == null) goto L5;
        String r101 = r100.optString("is_ap_std");
    L7:
        return Intrinsics.areEqual("Y", r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isPreSign() {
        return Intrinsics.areEqual(this.sign_page_style, "NO_SCREEN");
    }

    public final boolean isResponseOK() {
        if (Intrinsics.areEqual(RESPONSE_SUCCEED, this.code) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(CREDIT_RESPONSE_SUCCEED, this.code) == true) goto L8;
        return false;
    }

    public final boolean protocolShowOnBody() {
        return Intrinsics.areEqual(this.protocol_show_position, "BodyView");
    }

    public CJPaySignInfoQueryResponse() {
        this.code = "";
        this.msg = "";
        this.user_info = new CJPayUserInfo();
        this.merchant_info = new CJPayMerchantInfo();
        this.retain_info_v2_raw_string = "";
        this.promotion_voucher_info = new CJPayPromotionVoucherInfo();
        this.promotion_voucher_info_raw_string = "";
        this.protocol_group_names = new HashMap();
        this.protocol_group_names_raw_string = "";
        this.protocol_info = new ArrayList();
        this.protocol_info_raw_string = "";
        this.protocol_guide_desc = "";
        this.protocol_show_position = "";
        this.count_num = -1;
        this.confirm_sign_button = "";
        this.sign_information = new CJPaySignInformation();
        this.sign_page_style = "";
        this.pre_entrustweb_id = "";
        this.payscore_apply_token = "";
        this.trade_no = "";
        this.post_payments = new ArrayList();
    }

    public final void saveRawData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "dataObj");
        this.retain_info_v2_raw_string = r100.optString("retain_info_v2");
        this.promotion_voucher_info_raw_string = r100.optString("promotion_voucher_info");
        this.protocol_info_raw_string = r100.optString("protocol_info");
        this.protocol_group_names_raw_string = r100.optString("protocol_group_names");
    }

    public final void saveRawData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataStr");
        saveRawData(KtSafeMethodExtensionKt.safeCreate(r100));
    }
}
