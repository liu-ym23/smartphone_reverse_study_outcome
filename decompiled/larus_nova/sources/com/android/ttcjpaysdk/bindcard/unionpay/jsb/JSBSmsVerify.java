package com.android.ttcjpaysdk.bindcard.unionpay.jsb;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.IUnionPayBindCardService;
import com.android.ttcjpaysdk.bindcard.unionpay.jsb.abs.AbsJsbSmsVerify;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/JSBSmsVerify;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify$SmsVerifyInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify$SmsVerifyOutput;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBSmsVerify extends AbsJsbSmsVerify {
    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbSmsVerify.SmsVerifyInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBSmsVerify() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbSmsVerify.SmsVerifyInput) r100);
    }

    public void realHandle(Context r100, AbsJsbSmsVerify.SmsVerifyInput r101, final AbsJsbSmsVerify.SmsVerifyOutput r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_OUTPUT);
        JSONObject r103 = r101.card_info;
        Activity r104 = null;
        if (r103 == null) goto L5;
        CJPayHostInfo.Companion r105 = CJPayHostInfo.Companion;
        CJPayHostInfo r106 = new CJPayHostInfo();
        r106.merchantId = r101.merchant_id;
        r106.appId = r101.app_id;
        Unit r107 = Unit.INSTANCE;
        r103.put("hostInfo", CJPayHostInfo.Companion.toJson$default(r105, r106, null, 2, null));
        r103.put("is_skip_set_pwd", r101.is_skip_set_pwd);
    L6:
        IUnionPayBindCardService r108 = (IUnionPayBindCardService) CJPayServiceManager.getInstance().getIService(IUnionPayBindCardService.class);
        EventManager.INSTANCE.register(new AnonymousClass1(r102));
        if ((r100 instanceof Activity) == false) goto L9;
        r104 = (Activity) r100;
    L9:
        r108.startUnionPaySmsBindCard(r104, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbSmsVerify.SmsVerifyInput) r101, (AbsJsbSmsVerify.SmsVerifyOutput) r102);
    }
}
