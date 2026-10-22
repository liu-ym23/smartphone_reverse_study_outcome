package com.android.ttcjpaysdk.bindcard.base.applog;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFaceCheckService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J.\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ6\u0010\u001d\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J8\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u0006J\u001a\u0010)\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006J$\u0010*\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/PayNewCardLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "log3DSCancelDialogBtnClick", "", "button_name", "", "status", "log3DSCancelDialogShow", "logButtoInfoButtonClicked", "buttonType", "buttonName", "title", "pageDesc", "trackExts", "logButtonInfoShow", "logFaceCheckResult", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "type", "jsonObject", "Lorg/json/JSONObject;", "logPayNewCard", "code", "msg", "time", "", "isSuccess", "", "walletCashierPayAfterUseOpenResult", "message", "result", "", "activityId", "activityLabel", "walletRiskRestrictionTrigger", ControlRule.KEY_RULE_ID, "triggerStatus", "urlValue", "verifyId", "verifyToken", "walletRiskRestrictionTriggerURLCallback", "walletRiskValidateTriggerSDKCallback", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayNewCardLogger implements MvpLogger {
    public PayNewCardLogger() {
    }

    public final void log3DSCancelDialogBtnClick(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "button_name");
        Intrinsics.checkNotNullParameter(r101, "status");
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L5
        JSONObject r103 = CJPayParamsUtils.getCommonLogParams(r102.getMerchantId(), r102.getAppId());     // Catch: Exception -> L5
        r103.put("button_name", r100);     // Catch: Exception -> L5
        r103.put("status", r101);     // Catch: Exception -> L5
        CJPayBindCardLogUtils.doReport(DyVerifyEventConstants.EventName.VERIFICATION_SDK_3DS_VERIFY_POP_CLICK, new JSONObject[]{r103});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#log3DSCancelDialogBtnClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#log3DSCancelDialogBtnClick", e);
    }

    public final void log3DSCancelDialogShow(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "button_name");
        Intrinsics.checkNotNullParameter(r101, "status");
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L5
        JSONObject r103 = CJPayParamsUtils.getCommonLogParams(r102.getMerchantId(), r102.getAppId());     // Catch: Exception -> L5
        r103.put("button_name", r100);     // Catch: Exception -> L5
        r103.put("status", r101);     // Catch: Exception -> L5
        CJPayBindCardLogUtils.doReport(DyVerifyEventConstants.EventName.VERIFICATION_SDK_3DS_VERIFY_POP_IMP, new JSONObject[]{r103});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#log3DSCancelDialogShow", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#log3DSCancelDialogShow", e);
    }

    public final void walletRiskRestrictionTriggerURLCallback(String r100, String r101) {
        BindCardCommonInfoUtil r102 = BindCardCommonInfoUtil.INSTANCE;
        JSONObject r103 = CJPayParamsUtils.getCommonLogParams(r102.getMerchantId(), r102.getAppId());
        r103.put("url_value", r100);     // Catch: Exception -> L5
        r103.put("trigger_status", r101);     // Catch: Exception -> L5
    L7:
        CJPayBindCardLogUtils.doReport("wallet_risk_restriction_trigger_url_callback", new JSONObject[]{r103});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#walletRiskRestrictionTriggerURLCallback", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#walletRiskRestrictionTriggerURLCallback", e);
        goto L7
    }

    public final void logFaceCheckResult(Context r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        ICJPayFaceCheckService r103 = (ICJPayFaceCheckService) CJPayServiceManager.getInstance().getIService(ICJPayFaceCheckService.class);
        if (r103 == null) goto L6;
        r103.logFaceResultEvent(r100, r101, r102);
        return;
    }

    public final void walletRiskValidateTriggerSDKCallback(String r100, String r101, String r102) {
        BindCardCommonInfoUtil r103 = BindCardCommonInfoUtil.INSTANCE;
        JSONObject r104 = CJPayParamsUtils.getCommonLogParams(r103.getMerchantId(), r103.getAppId());
        r104.put("verify_id", r100);     // Catch: Exception -> L5
        r104.put("verify_token", r101);     // Catch: Exception -> L5
        r104.put("trigger_status", r102);     // Catch: Exception -> L5
    L7:
        CJPayBindCardLogUtils.doReport("wallet_risk_validate_trigger_sdk_callback", new JSONObject[]{r104});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#walletRiskValidateTriggerSDKCallback", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#walletRiskValidateTriggerSDKCallback", e);
        goto L7
    }

    public final void logButtonInfoShow(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "buttonType");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "pageDesc");
        Intrinsics.checkNotNullParameter(r103, "trackExts");
        BindCardCommonInfoUtil r104 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L15
        JSONObject r105 = CJPayParamsUtils.getCommonLogParams(r104.getMerchantId(), r104.getAppId());     // Catch: Exception -> L15
        r105.put(a.KEY_BUTTON_TYPE, r100);     // Catch: Exception -> L15
        if ((!StringsKt.isBlank(r101)) == false) goto L6;
        r105.put("title", r101);     // Catch: Exception -> L15
    L8:
        if (TextUtils.isEmpty(r103) == true) goto L13;
        JSONObject r106 = new JSONObject(r103);     // Catch: Exception -> L15
        Iterator<String> r107 = r106.keys();     // Catch: Exception -> L15
    L11:
        if (r107.hasNext() == false) goto L13;
        String r108 = r107.next();     // Catch: Exception -> L15
        r105.put(r108, r106.opt(r108));     // Catch: Exception -> L15
    L13:
        CJPayBindCardLogUtils.doReport("wallet_alert_pop_imp", new JSONObject[]{r105});     // Catch: Exception -> L15
        return;
    L6:
        r105.put("title", r102);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#logButtonInfoShow", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#logButtonInfoShow", e);
    }

    public final void logPayNewCard(String r100, String r101, long r102, boolean r110) {
        BindCardCommonInfoUtil r103 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L16
        JSONObject r104 = CJPayParamsUtils.getCommonLogParams(r103.getMerchantId(), r103.getAppId());     // Catch: Exception -> L16
        if (Intrinsics.areEqual("MP000000", r100) == false) goto L6;
    L9:
        int r105 = 1;
    L10:
        r104.put("result", r105);     // Catch: Exception -> L16
        r104.put("code", r100);     // Catch: Exception -> L16
        r104.put("msg", r101);     // Catch: Exception -> L16
        if (r110 == false) goto L13;
        String r106 = "0";
    L14:
        r104.put("is_success", r106);     // Catch: Exception -> L16
        r104.put("time", r102);     // Catch: Exception -> L16
        CJPayBindCardLogUtils.doReport("wallet_rd_pay_new_card_time", new JSONObject[]{r104});     // Catch: Exception -> L16
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_pay_new_card_time", r104);     // Catch: Exception -> L16
        return;
    L13:
        r106 = "1";
        goto L14
    L6:
        if (Intrinsics.areEqual("CD000000", r100) == true) goto L9;
        r105 = 0;
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#logPayNewCard", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#logPayNewCard", e);
    }

    public final void logButtoInfoButtonClicked(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "buttonType");
        Intrinsics.checkNotNullParameter(r101, "buttonName");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "pageDesc");
        Intrinsics.checkNotNullParameter(r104, "trackExts");
        BindCardCommonInfoUtil r105 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Exception -> L15
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r105.getMerchantId(), r105.getAppId());     // Catch: Exception -> L15
        r106.put(a.KEY_BUTTON_TYPE, r100);     // Catch: Exception -> L15
        r106.put("button_name", r101);     // Catch: Exception -> L15
        if ((!StringsKt.isBlank(r102)) == false) goto L6;
        r106.put("title", r102);     // Catch: Exception -> L15
    L8:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        JSONObject r107 = new JSONObject(r104);     // Catch: Exception -> L15
        Iterator<String> r108 = r107.keys();     // Catch: Exception -> L15
    L11:
        if (r108.hasNext() == false) goto L13;
        String r109 = r108.next();     // Catch: Exception -> L15
        r106.put(r109, r107.opt(r109));     // Catch: Exception -> L15
    L13:
        CJPayBindCardLogUtils.doReport("wallet_alert_pop_click", new JSONObject[]{r106});     // Catch: Exception -> L15
        return;
    L6:
        r106.put("title", r103);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#logButtoInfoButtonClicked", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#logButtoInfoButtonClicked", e);
    }

    public final void walletCashierPayAfterUseOpenResult(String r100, String r101, int r102, String r103, String r104) {
        BindCardCommonInfoUtil r105 = BindCardCommonInfoUtil.INSTANCE;     // Catch: Throwable -> L4
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r105.getMerchantId(), r105.getAppId());     // Catch: Throwable -> L4
        r106.put("error_code", r100);     // Catch: Throwable -> L4
        r106.put("error_message", r101);     // Catch: Throwable -> L4
        r106.put("result", r102);     // Catch: Throwable -> L4
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_OPEN_SOURCE, "支付中");     // Catch: Throwable -> L4
        r106.put("activity_id", r103);     // Catch: Throwable -> L4
        r106.put(a.KEY_ACTIVITY_LABEL, r104);     // Catch: Throwable -> L4
        r106.put("is_bankcard", "0");     // Catch: Throwable -> L4
        CJPayBindCardLogUtils.doReport("wallet_cashier_payafteruse_open_result", new JSONObject[]{r106});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#walletCashierPayAfterUseOpenResult", th);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#walletCashierPayAfterUseOpenResult", th);
    }

    public final void walletRiskRestrictionTrigger(String r100, String r101, String r102, String r103, String r104) {
        BindCardCommonInfoUtil r105 = BindCardCommonInfoUtil.INSTANCE;
        JSONObject r106 = CJPayParamsUtils.getCommonLogParams(r105.getMerchantId(), r105.getAppId());
        r106.put("rule_id", r100);     // Catch: Exception -> L5
        r106.put("verify_id", r103);     // Catch: Exception -> L5
        r106.put("url_value", r102);     // Catch: Exception -> L5
        r106.put("trigger_status", r101);     // Catch: Exception -> L5
        r106.put("verify_token", r104);     // Catch: Exception -> L5
    L7:
        CJPayBindCardLogUtils.doReport("wallet_risk_restriction_trigger", new JSONObject[]{r106});
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PayNewCardLogger#walletRiskRestrictionTrigger", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PayNewCardLogger#walletRiskRestrictionTrigger", e);
        goto L7
    }
}
