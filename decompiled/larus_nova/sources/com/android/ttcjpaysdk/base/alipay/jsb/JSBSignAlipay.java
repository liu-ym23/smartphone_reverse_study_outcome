package com.android.ttcjpaysdk.base.alipay.jsb;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.alipay.jsb.abs.AbsJsbSignAlipay;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayAliPaymentService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/alipay/jsb/JSBSignAlipay;", "Lcom/android/ttcjpaysdk/base/alipay/jsb/abs/AbsJsbSignAlipay;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/base/alipay/jsb/abs/AbsJsbSignAlipay$SignAlipayInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/alipay/jsb/abs/AbsJsbSignAlipay$SignAlipayOutput;", "base-pay-alipay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBSignAlipay extends AbsJsbSignAlipay {
    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbSignAlipay.SignAlipayInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBSignAlipay() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbSignAlipay.SignAlipayInput) r100);
    }

    public void realHandle(Context r100, AbsJsbSignAlipay.SignAlipayInput r101, final AbsJsbSignAlipay.SignAlipayOutput r110) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_OUTPUT);
        ICJPayAliPaymentService r102 = (ICJPayAliPaymentService) CJPayServiceManager.getInstance().getIService(ICJPayAliPaymentService.class);
        String r103 = r101.appId;
        String r104 = r101.merchantId;
        String r105 = r101.sign_params;
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r106 = (Activity) r100;
    L6:
        Activity r107 = r106;
        if (r102 == null) goto L10;
        r102.independentSign(r107, r105, r103, r104, new AnonymousClass1(r110));
        return;
    L10:
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbSignAlipay.SignAlipayInput) r101, (AbsJsbSignAlipay.SignAlipayOutput) r102);
    }
}
