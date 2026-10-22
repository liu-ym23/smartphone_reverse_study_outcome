package com.android.ttcjpaysdk.bdpay.bindcard.lynx.jsb;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bdpay.bindcard.lynx.CJPayLynxMyBankCardProvider;
import com.android.ttcjpaysdk.bdpay.bindcard.lynx.jsb.abs.AbsJsbGoMyBankCard;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qd4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/bindcard/lynx/jsb/JSBGoMyBankCard;", "Lcom/android/ttcjpaysdk/bdpay/bindcard/lynx/jsb/abs/AbsJsbGoMyBankCard;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/bdpay/bindcard/lynx/jsb/abs/AbsJsbGoMyBankCard$GoMyBankCardInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "bdpay-bindcard-lynx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBGoMyBankCard extends AbsJsbGoMyBankCard {
    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbGoMyBankCard.GoMyBankCardInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBGoMyBankCard() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbGoMyBankCard.GoMyBankCardInput) r100);
    }

    public void realHandle(Context r100, AbsJsbGoMyBankCard.GoMyBankCardInput r101, NothingOutput r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_OUTPUT);
        String r103 = r101.params;
        if (TextUtils.isEmpty(r103) == false) goto L30;
        return;
    L30:
        HashMap r104 = new HashMap();     // Catch: Exception -> L27
        JSONObject r105 = new JSONObject(r103);     // Catch: Exception -> L27
        Iterator<String> r106 = r105.keys();     // Catch: Exception -> L27
    L7:
        if (r106.hasNext() == false) goto L9;
        String r107 = r106.next();     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L27
        String r108 = r107;     // Catch: Exception -> L27
        r104.put(r108, r105.optString(r108));     // Catch: Exception -> L27
        goto L7
    L9:
        CJPayHostInfo.Companion r109 = CJPayHostInfo.Companion;     // Catch: Exception -> L27
        a r110 = (a) getDependency(a.class);     // Catch: Exception -> L27
        if (r110 == null) goto L12;
        Object r111 = r110.getHostInfo();     // Catch: Exception -> L27
    L14:
        if ((r111 instanceof CJPayHostInfo) == false) goto L16;
        CJPayHostInfo r112 = (CJPayHostInfo) r111;     // Catch: Exception -> L27
    L17:
        CJPayHostInfo r113 = r109.copy(r112);     // Catch: Exception -> L27
        r113.setRequestParams(r104);     // Catch: Exception -> L27
        if (r100 != null) goto L20;
    L25:
        CJPayCallBackCenter.getInstance().setResultCode(112).notifyPayResult();     // Catch: Exception -> L27
        IJSBResult.DefaultImpls.onFailed$default(r102, null, null, 3, null);     // Catch: Exception -> L27
        return;
    L20:
        if (r113.getRequestParams() == null) goto L25;
        if (r113.getRiskInfoParams() == null) goto L25;
        new CJPayLynxMyBankCardProvider().startFrontMyBankCard(r100, CJPayHostInfo.Companion.toJson$default(r109, r113, null, 2, null));     // Catch: Exception -> L27
        r102.onSuccess();     // Catch: Exception -> L27
        return;
    L16:
        r112 = null;
        goto L17
    L12:
        r111 = null;
    L27:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("JSBGoMyBankCard#realHandle", e);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBGoMyBankCard#realHandle", e);
        IJSBResult.DefaultImpls.onFailed$default(r102, null, null, 3, null);
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbGoMyBankCard.GoMyBankCardInput) r101, (NothingOutput) r102);
    }
}
