package com.android.ttcjpaysdk.bindcard.base.applog;

import android.content.Context;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPaySmsSignBean;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ \u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ*\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\n¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/SmsCheckLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "logCaptchaClick", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "buttonName", "", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "logCaptchaError", "logCardAddResult", "logImp", "event", "logInput", "logResult", "loadingTime", "", "smsSignBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPaySmsSignBean;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmsCheckLogger implements MvpLogger {
    public SmsCheckLogger() {
    }

    public final void logCaptchaError(Context r100, CJPayRealNameBean r101) {
        Intrinsics.checkNotNullParameter(r101, "realNameBean");
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L19
        String r103 = r102.getMerchantId();     // Catch: Exception -> L19
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r105 = r102.getAppId();     // Catch: Exception -> L19
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r103, r104);     // Catch: Exception -> L19
        JSONObject r107 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: Exception -> L19
        if (r100 == null) goto L14;
        r107.put("bank_type", r101.getCardTypeStr(r100));     // Catch: Exception -> L19
    L14:
        r107.put("bank_name", r101.bank_name);     // Catch: Exception -> L19
        r107.put("activity_info", new JSONArray(r101.activity_info));     // Catch: Exception -> L19
        if (r101.isUnionPay == false) goto L17;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r107);     // Catch: Exception -> L19
    L17:
        CJPayBindCardLogUtils.doReport("wallet_addbcard_captcha_error_info", new JSONObject[]{r106, r107});     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SmsCheckLogger#logCaptchaError", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SmsCheckLogger#logCaptchaError", e);
    }

    public final void logCardAddResult(Context r100, CJPayRealNameBean r101) {
        Intrinsics.checkNotNullParameter(r101, "realNameBean");
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L19
        String r103 = r102.getMerchantId();     // Catch: Exception -> L19
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r105 = r102.getAppId();     // Catch: Exception -> L19
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r103, r104);     // Catch: Exception -> L19
        JSONObject r107 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: Exception -> L19
        if (r100 == null) goto L14;
        r107.put("bank_type", r101.getCardTypeStr(r100));     // Catch: Exception -> L19
    L14:
        r107.put("bank_name", r101.bank_name);     // Catch: Exception -> L19
        r107.put("activity_info", new JSONArray(r101.activity_info));     // Catch: Exception -> L19
        if (r101.isUnionPay == false) goto L17;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r107);     // Catch: Exception -> L19
    L17:
        CJPayBindCardLogUtils.doReport("wallet_addbcard_page_toast_info", new JSONObject[]{r106, r107});     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SmsCheckLogger#logCardAddResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SmsCheckLogger#logCardAddResult", e);
    }

    public final void logInput(Context r100, CJPayRealNameBean r101) {
        Intrinsics.checkNotNullParameter(r101, "realNameBean");
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L19
        String r103 = r102.getMerchantId();     // Catch: Exception -> L19
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r105 = r102.getAppId();     // Catch: Exception -> L19
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r103, r104);     // Catch: Exception -> L19
        JSONObject r107 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: Exception -> L19
        if (r100 == null) goto L14;
        r107.put("bank_type", r101.getCardTypeStr(r100));     // Catch: Exception -> L19
    L14:
        r107.put("bank_name", r101.bank_name);     // Catch: Exception -> L19
        r107.put("activity_info", new JSONArray(r101.activity_info));     // Catch: Exception -> L19
        if (r101.isUnionPay == false) goto L17;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r107);     // Catch: Exception -> L19
    L17:
        CJPayBindCardLogUtils.doReport("wallet_addbcard_captcha_input", new JSONObject[]{r106, r107});     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SmsCheckLogger#logInput", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SmsCheckLogger#logInput", e);
    }

    public final void logCaptchaClick(Context r100, String r101, CJPayRealNameBean r102) {
        Intrinsics.checkNotNullParameter(r101, "buttonName");
        Intrinsics.checkNotNullParameter(r102, "realNameBean");
        BindCardCommonInfoUtil r103 = BindCardCommonInfoUtil.INSTANCE;     // Catch: JSONException -> L19
        String r104 = r103.getMerchantId();     // Catch: JSONException -> L19
        String r105 = "";
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        String r106 = r103.getAppId();     // Catch: JSONException -> L19
        if (r106 == null) goto L11;
        r105 = r106;
    L11:
        JSONObject r107 = CJPayParamsUtils.getCommonLogParams(r104, r105);     // Catch: JSONException -> L19
        JSONObject r108 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: JSONException -> L19
        if (r100 == null) goto L14;
        r108.put("bank_type", r102.getCardTypeStr(r100));     // Catch: JSONException -> L19
    L14:
        r108.put("bank_name", r102.bank_name);     // Catch: JSONException -> L19
        r108.put("button_name", r101);     // Catch: JSONException -> L19
        r108.put("activity_info", new JSONArray(r102.activity_info));     // Catch: JSONException -> L19
        if (r102.isUnionPay == false) goto L17;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r108);     // Catch: JSONException -> L19
    L17:
        CJPayBindCardLogUtils.doReport("wallet_addbcard_captcha_click", new JSONObject[]{r107, r108});     // Catch: JSONException -> L19
        return;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SmsCheckLogger#logCaptchaClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SmsCheckLogger#logCaptchaClick", e);
    }

    public final void logImp(Context r100, CJPayRealNameBean r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "realNameBean");
        Intrinsics.checkNotNullParameter(r102, "event");
        BindCardCommonInfoUtil r103 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L19
        String r104 = r103.getMerchantId();     // Catch: Exception -> L19
        String r105 = "";
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        String r106 = r103.getAppId();     // Catch: Exception -> L19
        if (r106 == null) goto L11;
        r105 = r106;
    L11:
        JSONObject r107 = CJPayParamsUtils.getCommonLogParams(r104, r105);     // Catch: Exception -> L19
        JSONObject r108 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: Exception -> L19
        if (r100 == null) goto L14;
        r108.put("bank_type", r101.getCardTypeStr(r100));     // Catch: Exception -> L19
    L14:
        r108.put("bank_name", r101.bank_name);     // Catch: Exception -> L19
        r108.put("activity_info", new JSONArray(r101.activity_info));     // Catch: Exception -> L19
        if (r101.isUnionPay == false) goto L17;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r108);     // Catch: Exception -> L19
    L17:
        CJPayBindCardLogUtils.doReport(r102, new JSONObject[]{r107, r108});     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SmsCheckLogger#logImp", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SmsCheckLogger#logImp", e);
    }

    public final void logResult(Context r100, long r101, CJPaySmsSignBean r102, CJPayRealNameBean r103) {
        Intrinsics.checkNotNullParameter(r103, "realNameBean");
        BindCardCommonInfoUtil r104 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L21
        String r105 = r104.getMerchantId();     // Catch: Exception -> L21
        String r106 = "";
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        String r107 = r104.getAppId();     // Catch: Exception -> L21
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        JSONObject r108 = CJPayParamsUtils.getCommonLogParams(r105, r107);     // Catch: Exception -> L21
        JSONObject r109 = CJPayBindCardLogUtils.getBindCardBizLogParams();     // Catch: Exception -> L21
        r109.put("loading_time", r101);     // Catch: Exception -> L21
        if (r102 == null) goto L13;
        r106 = r102.code;     // Catch: Exception -> L21
    L13:
        r109.put("captcha_result", r106);     // Catch: Exception -> L21
        if (r100 == null) goto L16;
        r109.put("bank_type", r103.getCardTypeStr(r100));     // Catch: Exception -> L21
    L16:
        r109.put("bank_name", r103.bank_name);     // Catch: Exception -> L21
        r109.put("activity_info", new JSONArray(r103.activity_info));     // Catch: Exception -> L21
        if (r103.isUnionPay == false) goto L19;
        CJPayBindCardLogUtils.setAddCardTypeForUnionPay(r109);     // Catch: Exception -> L21
    L19:
        CJPayBindCardLogUtils.doReport("wallet_addbcard_captcha_submit_result", new JSONObject[]{r108, r109});     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("SmsCheckLogger#logResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "SmsCheckLogger#logResult", e);
    }
}
