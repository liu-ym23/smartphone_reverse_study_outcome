package com.android.ttcjpaysdk.bindcard.base.utils;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.ICJPayNewCardCallback;
import com.android.ttcjpaysdk.base.service.ICJPayQuickbindService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.InsuranceConfiguration;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBankInfoBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardParamsBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayCardAddBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayOneKeyCopyWritingInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020\u0004J\b\u0010$\u001a\u00020\u0004H\u0007J\u001b\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040&2\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0019J\b\u0010+\u001a\u0004\u0018\u00010,J\u0006\u0010-\u001a\u00020\u0004J\b\u0010.\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020 J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u0004J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u000207J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000207J\u0006\u0010=\u001a\u00020;J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020\u0019J\u000e\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020\u0004J\u0010\u0010G\u001a\u00020?2\b\u0010H\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010I\u001a\u00020?2\u0006\u0010B\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020 J\u0016\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004J\u0016\u0010O\u001a\u00020?2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/BindCardCommonInfoUtil;", "", "()V", "CJ_PAY_BIND_CARD_COMBINE_PAY_CD005104", "", "CJ_PAY_BIND_CARD_COMBINE_PAY_CD005105", "CJ_PAY_BIND_CARD_COMBINE_PAY_LIMITED", "CJ_PAY_BIND_CARD_PAY_CANCEL", "CJ_PAY_BIND_CARD_PAY_FAILED", "CJ_PAY_BIND_CARD_PAY_KEEP_LOADING", "CJ_PAY_BIND_CARD_PAY_SUCCESS", "cardAddBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayCardAddBean;", "getCardAddBean", "()Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayCardAddBean;", "setCardAddBean", "(Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayCardAddBean;)V", "combineType", "delayFinishMillis", "", "getDelayFinishMillis", "()J", "setDelayFinishMillis", "(J)V", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "insuranceConfiguration", "Lcom/android/ttcjpaysdk/base/settings/bean/InsuranceConfiguration;", "payNewCardCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayNewCardCallback;", "payType", "quickbindContextDepend", "Lcom/android/ttcjpaysdk/base/service/ICJPayQuickbindService$IQuickbindContextDepend;", "safetyIconUrl", "safetyText", "getAppId", "getBackgroundPicUrl", "getBankCardBgColors", "", "backgroundColor", "(Ljava/lang/String;)[Ljava/lang/String;", "getCombineType", "getHostInfo", "getHostInfoJson", "Lorg/json/JSONObject;", "getMerchantId", "getPayNewCardCallback", "getPayType", "getQuickbindContextDepend", "getSafetyIconUrl", "getSafetyText", "getSignOrderNo", "getSmchId", "getUnionPaySignInfo", "isBackgroundShowLogo", "", "isGoSetPwd", "isHasPassword", "isNeedRealNameAuth", "", "isRealName", "isShowPhoneNum", "setAppId", "", "appId", "setCombineType", "p", "setHostInfo", "info", "setMerchantId", "merchantId", "setPayNewCardCallback", "cardCallback", "setPayType", "setQuickbindContextDepend", "contextDepend", "setSafetyIconAndText", "iconUrl", "text", "updateMerchantIdAndAppId", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindCardCommonInfoUtil {
    public static final String CJ_PAY_BIND_CARD_COMBINE_PAY_CD005104 = "CD005104";
    public static final String CJ_PAY_BIND_CARD_COMBINE_PAY_CD005105 = "CD005105";
    public static final String CJ_PAY_BIND_CARD_COMBINE_PAY_LIMITED = "5";
    public static final String CJ_PAY_BIND_CARD_PAY_CANCEL = "-1";
    public static final String CJ_PAY_BIND_CARD_PAY_FAILED = "1";
    public static final String CJ_PAY_BIND_CARD_PAY_KEEP_LOADING = "2";
    public static final String CJ_PAY_BIND_CARD_PAY_SUCCESS = "0";
    public static final BindCardCommonInfoUtil INSTANCE = null;
    private static CJPayCardAddBean cardAddBean;
    private static String combineType;
    private static long delayFinishMillis;
    private static CJPayHostInfo hostInfo;
    private static InsuranceConfiguration insuranceConfiguration;
    private static ICJPayNewCardCallback payNewCardCallback;
    private static String payType;
    private static ICJPayQuickbindService.IQuickbindContextDepend quickbindContextDepend;
    private static String safetyIconUrl;
    private static String safetyText;

    private BindCardCommonInfoUtil() {
    }

    static {
        INSTANCE = new BindCardCommonInfoUtil();
        insuranceConfiguration = CJPaySettingsManager.getInstance().getInsuranceConfig();
        safetyIconUrl = "";
        safetyText = "";
        payType = "";
        combineType = "";
    }

    @JvmStatic
    public static final String getBackgroundPicUrl() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.background_info;
        if (r101 == null) goto L8;
        String r102 = r101.get("background_image_url");
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public final String getAppId() {
        CJPayHostInfo r100 = hostInfo;
        if (r100 == null) goto L6;
        String r101 = r100.appId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final CJPayHostInfo getHostInfo() {
        CJPayHostInfo r100 = hostInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new CJPayHostInfo();
    }

    public final JSONObject getHostInfoJson() {
        return CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, hostInfo, null, 2, null);
    }

    public final String getMerchantId() {
        CJPayHostInfo r100 = hostInfo;
        if (r100 == null) goto L6;
        String r101 = r100.merchantId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final ICJPayQuickbindService.IQuickbindContextDepend getQuickbindContextDepend() {
        ICJPayQuickbindService.IQuickbindContextDepend r100 = quickbindContextDepend;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new AnonymousClass2();
    }

    public final String getSafetyIconUrl() {
        String r100 = safetyIconUrl;
        String r101 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L31;
        CJPayCardAddBean r102 = cardAddBean;
        if (r102 == null) goto L18;
        CJPayBindCardParamsBean r103 = r102.url_params;
        if (r103 == null) goto L18;
        CJPayOneKeyCopyWritingInfo r104 = r103.card_copywriting_info;
        if (r104 == null) goto L18;
        String r105 = r104.display_icon;
        if (r105 == null) goto L18;
        if ((!StringsKt.isBlank(r105)) == false) goto L18;
    L19:
        if (r105 != null) goto L32;
        CJPayCardAddBean r106 = cardAddBean;
        if (r106 == null) goto L27;
        CJPayBindCardParamsBean r107 = r106.url_params;
        if (r107 == null) goto L27;
        CJPayBankInfoBean r108 = r107.one_key_bank_info;
        if (r108 == null) goto L27;
        r101 = r108.display_icon;
    L27:
        if (r101 != null) goto L30;
        return "";
    L30:
        return r101;
    L32:
        return r105;
    L18:
        r105 = null;
        goto L19
    L31:
        return r100;
    }

    public final String getSafetyText() {
        String r100 = safetyText;
        String r101 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L31;
        CJPayCardAddBean r102 = cardAddBean;
        if (r102 == null) goto L18;
        CJPayBindCardParamsBean r103 = r102.url_params;
        if (r103 == null) goto L18;
        CJPayOneKeyCopyWritingInfo r104 = r103.card_copywriting_info;
        if (r104 == null) goto L18;
        String r105 = r104.display_desc;
        if (r105 == null) goto L18;
        if ((!StringsKt.isBlank(r105)) == false) goto L18;
    L19:
        if (r105 != null) goto L32;
        CJPayCardAddBean r106 = cardAddBean;
        if (r106 == null) goto L27;
        CJPayBindCardParamsBean r107 = r106.url_params;
        if (r107 == null) goto L27;
        CJPayBankInfoBean r108 = r107.one_key_bank_info;
        if (r108 == null) goto L27;
        r101 = r108.display_desc;
    L27:
        if (r101 != null) goto L30;
        return "";
    L30:
        return r101;
    L32:
        return r105;
    L18:
        r105 = null;
        goto L19
    L31:
        return r100;
    }

    public final String getSignOrderNo() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L7;
        CJPayBindCardParamsBean r101 = r100.url_params;
        if (r101 == null) goto L7;
        String r102 = r101.sign_order_no;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final String getSmchId() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L7;
        CJPayBindCardParamsBean r101 = r100.url_params;
        if (r101 == null) goto L7;
        String r102 = r101.smch_id;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final String getUnionPaySignInfo() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L5;
        String r101 = r100.union_pay_sign_info;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isBackgroundShowLogo() {
        return !insuranceConfiguration.is_no_show_douyin_logo;
    }

    public final boolean isGoSetPwd() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L10;
        CJPayBindCardParamsBean r101 = r100.url_params;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isSetPwd() == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean isHasPassword() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L7;
        CJPayBindCardParamsBean r101 = r100.url_params;
        if (r101 == null) goto L7;
        return r101.isSetPwd();
    L7:
        return false;
    }

    public final int isNeedRealNameAuth() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.busi_authorize_info.is_need_authorize ? 1 : 0;
    }

    public final boolean isRealName() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 == null) goto L7;
        CJPayBindCardParamsBean r101 = r100.url_params;
        if (r101 == null) goto L7;
        return r101.isAuth();
    L7:
        return false;
    }

    public final int isShowPhoneNum() {
        CJPayCardAddBean r100 = cardAddBean;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (TextUtils.isEmpty(r100.url_params.mobile_mask) == false) goto L10;
        if (TextUtils.isEmpty(r100.url_params.uid_mobile_mask) == false) goto L10;
        return 0;
    L10:
        return 1;
    }

    public final CJPayCardAddBean getCardAddBean() {
        return cardAddBean;
    }

    public final String getCombineType() {
        return combineType;
    }

    public final long getDelayFinishMillis() {
        return delayFinishMillis;
    }

    public final ICJPayNewCardCallback getPayNewCardCallback() {
        return payNewCardCallback;
    }

    public final String getPayType() {
        return payType;
    }

    public final String[] getBankCardBgColors(String r100) {
        Intrinsics.checkNotNullParameter(r100, "backgroundColor");
        String[] r101 = {"#dd4a51", "#e95259"};
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return r101;
    L5:
        if (StringsKt.contains$default(r100, ",", false, 2, null) == false) goto L14;
        String[] r102 = (String[]) new Regex(",").split(r100, 0).toArray(new String[0]);
        if (r102.length != 2) goto L14;
        if (r102[0].length() != 6) goto L14;
        if (r102[1].length() != 6) goto L14;
        r101[0] = "#" + r102[0];
        r101[1] = "#" + r102[1];
        goto L14
    }

    public final void setAppId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        CJPayHostInfo r101 = hostInfo;
        if (r101 == null) goto L7;
        r101.appId = r100;
        return;
    }

    public final void setCardAddBean(CJPayCardAddBean r100) {
        cardAddBean = r100;
    }

    public final void setCombineType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        combineType = r100;
    }

    public final void setDelayFinishMillis(long r100) {
        delayFinishMillis = r100;
    }

    public final void setHostInfo(CJPayHostInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        hostInfo = r100;
    }

    public final void setMerchantId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        CJPayHostInfo r101 = hostInfo;
        if (r101 == null) goto L7;
        r101.merchantId = r100;
        return;
    }

    public final void setPayNewCardCallback(ICJPayNewCardCallback r100) {
        payNewCardCallback = r100;
    }

    public final void setPayType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        payType = r100;
    }

    public final void setQuickbindContextDepend(ICJPayQuickbindService.IQuickbindContextDepend r100) {
        Intrinsics.checkNotNullParameter(r100, "contextDepend");
        quickbindContextDepend = r100;
    }

    public final void setSafetyIconAndText(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "iconUrl");
        Intrinsics.checkNotNullParameter(r101, "text");
        safetyIconUrl = r100;
        safetyText = r101;
    }

    public final void updateMerchantIdAndAppId(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "merchantId");
        Intrinsics.checkNotNullParameter(r101, "appId");
        setMerchantId(r100);
        setAppId(r101);
    }
}
