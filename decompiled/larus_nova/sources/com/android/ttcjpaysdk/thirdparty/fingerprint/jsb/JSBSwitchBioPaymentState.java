package com.android.ttcjpaysdk.thirdparty.fingerprint.jsb;

import android.content.Context;
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
import com.android.ttcjpaysdk.base.service.ICJPayFingerprintSwitchCallback;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.thirdparty.fingerprint.jsb.abs.AbsJsbSwitchBioPaymentState;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/JSBSwitchBioPaymentState;", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState$SwitchBioPaymentStateInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState$SwitchBioPaymentStateOutput;", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBSwitchBioPaymentState extends AbsJsbSwitchBioPaymentState {
    public JSBSwitchBioPaymentState() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbSwitchBioPaymentState.SwitchBioPaymentStateInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return MapsKt.emptyMap();
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbSwitchBioPaymentState.SwitchBioPaymentStateInput) r100);
    }

    public void realHandle(final Context r210, AbsJsbSwitchBioPaymentState.SwitchBioPaymentStateInput r211, final AbsJsbSwitchBioPaymentState.SwitchBioPaymentStateOutput r212) {
        Intrinsics.checkNotNullParameter(r211, "input");
        Intrinsics.checkNotNullParameter(r212, BdpAppEventConstant.PARAMS_OUTPUT);
        if (r210 != null) goto L5;
        return;
    L5:
        String r100 = r211.appId;
        String r101 = r211.merchantId;
        String r102 = r211.did;
        String r103 = r211.uid;
        String r104 = r211.open;
        String r105 = r211.member_biz_order_no;
        String r106 = r211.verify_type;
        JSONObject r110 = r211.verify_info;
        HashMap<String, String> r111 = CJPayXBridgeUtils.convertJsonToMap(r211.riskInfoParams);
        String r112 = r211.source;
        new HashMap();
        String r113 = r211.trade_no;
        JSONObject r114 = r211.process_info;
        boolean r115 = r211.is_from_guide;
        ICJPayFingerprintService r107 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        if (CJPaySettingsManager.getInstance().isForbidSaasBranchMerge() == false) goto L8;
    L14:
        String r108 = "-1";
    L15:
        if (r107 == null) goto L40;
        CJPayHostInfo r116 = new CJPayHostInfo();
        r116.merchantId = r101;
        r116.appId = r100;
        r116.isCaijingSaas = r108;
        r116.enableBioSource = r112;
        HashMap<String, String> r109 = r116.extraHeaderMap;
        if (r109 != null) goto L20;
        r109 = new HashMap();
    L20:
        if (Intrinsics.areEqual(r108, "1") == false) goto L22;
        r109.put(CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER, "saas");
        String r117 = r112;
    L25:
        r116.extraHeaderMap = r109;
        r116.setRiskInfoParams(r111);
        if (TextUtils.isEmpty(r103) == true) goto L29;
        CJPayHostInfo.uid = r103;
    L29:
        if (TextUtils.isEmpty(r102) == true) goto L31;
        CJPayHostInfo.did = r102;
    L31:
        ICJPayFingerprintSwitchCallback r118 = new JSBSwitchBioPaymentState$realHandle$fingerprintSwitchCallback$1(r212, r210);
        if (Intrinsics.areEqual("1", r104) == false) goto L39;
        if (r115 == true) goto L35;
    L38:
        r107.openFingerprint(r210, r103, r118, CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, r116, null, 2, null), r105, r106, r110, r117);
        return;
    L35:
        if (TextUtils.isEmpty(r113) == true) goto L38;
        if (r114 == null) goto L38;
        r107.openFingerprint(r210, r103, r118, CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, r116, null, 2, null), r117, r113, r114, r115);
        return;
    L39:
        r107.closeFingerprint(r210, r103, CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, r116, null, 2, null), r118);
        return;
    L22:
        r117 = r112;
        if (Intrinsics.areEqual(r108, "0") == false) goto L25;
        r109.put(CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER, CJPaySaasUtils.CAIJING_NO_SAAS_REQUEST_HEADER_MARK);
        goto L25
    L40:
        IJSBResult.DefaultImpls.onFailed$default(r212, null, null, 3, null);
        return;
    L8:
        if (r211.is_caijing_saas.length() != 0) goto L10;
        boolean r119 = true;
    L11:
        if (r119 == true) goto L14;
        r108 = r211.is_caijing_saas;
        goto L15
    L10:
        r119 = false;
        goto L11
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbSwitchBioPaymentState.SwitchBioPaymentStateInput) r101, (AbsJsbSwitchBioPaymentState.SwitchBioPaymentStateOutput) r102);
    }
}
