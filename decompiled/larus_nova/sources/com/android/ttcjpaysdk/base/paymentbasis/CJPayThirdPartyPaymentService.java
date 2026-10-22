package com.android.ttcjpaysdk.base.paymentbasis;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayAliPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayCMBPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayCloudUnionPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayThirdPartyPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayWXPaymentService;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\b\u0010\u000f\u001a\u00020\bH\u0016JB\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\nH\u0017J\b\u0010\u0014\u001a\u00020\u0004H\u0016¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayThirdPartyPaymentService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayThirdPartyPaymentService;", "()V", "executePay", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "wxAppId", "", "params", "Lorg/json/JSONObject;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;", "getPackageName", "pay", "data", "wxPayType", "hostInfo", "releasePaySession", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayThirdPartyPaymentService implements ICJPayThirdPartyPaymentService {
    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService
    public void releasePaySession() {
    }

    public CJPayThirdPartyPaymentService() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService
    @CJPayModuleEntryReport
    public void executePay(Context r100, String r101, JSONObject r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        int r102 = CJPayRequest.parse(String.valueOf(r110)).type;
        if (r102 != 1) goto L5;
        ((ICJPayWXPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayWXPaymentService.class)).executePay(r100, r101, r110, r111, r112);
        return;
    L5:
        if (r102 != 2) goto L7;
        ((ICJPayAliPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayAliPaymentService.class)).executePay(r100, r101, r110, r111, r112);
        return;
    L7:
        if (r102 != 3) goto L9;
        ((ICJPayCMBPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayCMBPaymentService.class)).executePay(r100, r101, r110, r111, r112);
        return;
    L9:
        if (r102 != 4) goto L19;
        ((ICJPayCloudUnionPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayCloudUnionPaymentService.class)).executePay(r100, r101, r110, r111, r112);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService
    @CJPayModuleEntryReport
    public void pay(Context r100, String r110, String r111, ICJPayBasisPaymentService.OnPayResultCallback r112, ICJPayBasisPaymentService.OnResultCallback r113, JSONObject r114) {
        Intrinsics.checkNotNullParameter(r114, "hostInfo");
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L30;
        CJPayRequest r115 = CJPayRequest.parse(r110);
        String r101 = new JSONObject(r110).optJSONObject("data").optString("sdk_info");     // Catch: Exception -> L19
        int r116 = r115.type;     // Catch: Exception -> L19
        if (r116 != 1) goto L11;
        ((ICJPayWXPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayWXPaymentService.class)).pay(r100, r101, "APP", r112, r113, r114);     // Catch: Exception -> L19
    L24:
        return;
    L11:
        if (r116 != 2) goto L13;
        ((ICJPayAliPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayAliPaymentService.class)).pay(r100, r101, "", r112, r113, r114);     // Catch: Exception -> L19
        goto L24
    L13:
        if (r116 != 3) goto L24;
        ((ICJPayCMBPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayCMBPaymentService.class)).pay(r100, r101, "", r112, r113, r114);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayThirdPartyPaymentService#pay", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayThirdPartyPaymentService#pay", e);
        if (r112 == null) goto L29;
        r112.onShowErrorInfo(r100, r100.getResources().getString(R.string.cj_pay_params_error));
        return;
    L29:
        return;
    }
}
