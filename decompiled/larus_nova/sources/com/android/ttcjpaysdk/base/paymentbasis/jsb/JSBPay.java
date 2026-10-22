package com.android.ttcjpaysdk.base.paymentbasis.jsb;

import android.content.Context;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.android.ttcjpaysdk.base.paymentbasis.jsb.abs.AbsJsbPay;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayService;
import com.android.ttcjpaysdk.base.service.ICJPayThirdPartyPaymentService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/jsb/JSBPay;", "Lcom/android/ttcjpaysdk/base/paymentbasis/jsb/abs/AbsJsbPay;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/base/paymentbasis/jsb/abs/AbsJsbPay$PayInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBPay extends AbsJsbPay {
    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbPay.PayInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBPay() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbPay.PayInput) r100);
    }

    public void realHandle(Context r110, AbsJsbPay.PayInput r111, final NothingOutput r112) {
        Intrinsics.checkNotNullParameter(r111, "input");
        Intrinsics.checkNotNullParameter(r112, BdpAppEventConstant.PARAMS_OUTPUT);
        JSONObject r100 = new JSONObject(r111.data);     // Catch: JSONException -> L8
        String r101 = r100.optJSONObject("sdk_info").optString("appid");     // Catch: JSONException -> L8
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L8
        r102.put("data", r100);     // Catch: JSONException -> L8
        if (CJPayServiceManager.getInstance().getIService(ICJPayThirdPartyPaymentService.class) == null) goto L6;
        ICJPayService r113 = CJPayServiceManager.getInstance().getIService(ICJPayThirdPartyPaymentService.class);     // Catch: JSONException -> L8
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.android.ttcjpaysdk.base.service.ICJPayThirdPartyPaymentService");     // Catch: JSONException -> L8
        ((ICJPayThirdPartyPaymentService) r113).executePay(r110, r101, r102, new AnonymousClass1(), new AnonymousClass2(r112));     // Catch: JSONException -> L8
    L11:
        return;
    L6:
        IJSBResult.DefaultImpls.onFailed$default(r112, "ICJPayThirdPartyPaymentService not found", null, 2, null);     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("JSBPay#onDisplayCMBEnterToast", e);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBPay#onDisplayCMBEnterToast", e);
        IJSBResult.DefaultImpls.onFailed$default(r112, e.toString(), null, 2, null);
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbPay.PayInput) r101, (NothingOutput) r102);
    }
}
