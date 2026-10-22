package com.android.ttcjpaysdk.thirdparty.fingerprint.jsb;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.utils.CJPayXBridgeUtils;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFingerprintService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.jsb.abs.AbsJsbBioPaymentShowState;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/JSBBioPaymentShowState;", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState$BioPaymentShowStateInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState$BioPaymentShowStateOutput;", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBBioPaymentShowState extends AbsJsbBioPaymentShowState {
    public JSBBioPaymentShowState() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbBioPaymentShowState.BioPaymentShowStateInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return MapsKt.emptyMap();
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbBioPaymentShowState.BioPaymentShowStateInput) r100);
    }

    public void realHandle(Context r110, AbsJsbBioPaymentShowState.BioPaymentShowStateInput r111, final AbsJsbBioPaymentShowState.BioPaymentShowStateOutput r112) {
        Intrinsics.checkNotNullParameter(r111, "input");
        Intrinsics.checkNotNullParameter(r112, BdpAppEventConstant.PARAMS_OUTPUT);
        String r100 = r111.appId;
        String r101 = r111.merchantId;
        String r102 = r111.did;
        String r103 = r111.uid;
        String r104 = r111.aid;
        boolean r105 = r111.onlyReturnDeviceType;
        HashMap<String, String> r106 = CJPayXBridgeUtils.convertJsonToMap(r111.riskInfoParams);
        new HashMap();
        ICJPayFingerprintService r107 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        if (CJPaySettingsManager.getInstance().isForbidSaasBranchMerge() == false) goto L5;
    L11:
        String r113 = "-1";
    L13:
        if (r107 == null) goto L51;
        CJPayHostInfo r114 = new CJPayHostInfo();
        r114.merchantId = r101;
        r114.appId = r100;
        r114.setRiskInfoParams(r106);
        r114.isCaijingSaas = r113;
        HashMap<String, String> r108 = r114.extraHeaderMap;
        if (r108 != null) goto L18;
        r108 = new HashMap();
    L18:
        if (Intrinsics.areEqual(r113, "1") == false) goto L21;
        r108.put(CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER, "saas");
    L23:
        r114.extraHeaderMap = r108;
        if (TextUtils.isEmpty(r103) == true) goto L27;
        CJPayHostInfo.uid = r103;
    L27:
        if (TextUtils.isEmpty(r102) == true) goto L30;
        CJPayHostInfo.did = r102;
    L30:
        if (TextUtils.isEmpty(r104) == true) goto L53;
        CJPayHostInfo.aid = r104;
    L53:
        r112.show = "1";     // Catch: Exception -> L46
        r112.bioType = "2";     // Catch: Exception -> L46
        String r109 = "";
        if (CJPayBasicUtils.isSupportFingerPrint(r110) == true) goto L44;
        if (r110 == null) goto L39;
        Resources r115 = r110.getResources();     // Catch: Exception -> L46
        if (r115 == null) goto L39;
        String r116 = r115.getString(R.string.cj_pay_h5_fingerprint_system_disabled);     // Catch: Exception -> L46
    L40:
        if (r116 == null) goto L43;
        r109 = r116;
    L43:
        r112.msg = r109;     // Catch: Exception -> L46
        r112.style = "2";     // Catch: Exception -> L46
    L48:
        if (r105 == false) goto L50;
        r112.onSuccess();
        return;
    L50:
        r107.queryFingerprintState(r110, r103, new AnonymousClass3(r112), CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, r114, null, 2, null));
        return;
    L39:
        r116 = null;
        goto L40
    L44:
        r112.msg = "";     // Catch: Exception -> L46
    L46:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("JSBBioPaymentShowState#realHandle", e);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBBioPaymentShowState#realHandle", e);
        goto L48
    L21:
        if (Intrinsics.areEqual(r113, "0") == false) goto L23;
        r108.put(CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER, CJPaySaasUtils.CAIJING_NO_SAAS_REQUEST_HEADER_MARK);
        goto L23
    L51:
        IJSBResult.DefaultImpls.onFailed$default(r112, null, null, 3, null);
        return;
    L5:
        if (r111.is_caijing_saas.length() != 0) goto L7;
        boolean r117 = true;
    L8:
        if (r117 == true) goto L11;
        r113 = r111.is_caijing_saas;
        goto L13
    L7:
        r117 = false;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbBioPaymentShowState.BioPaymentShowStateInput) r101, (AbsJsbBioPaymentShowState.BioPaymentShowStateOutput) r102);
    }
}
