package com.android.ttcjpaysdk.outer.pay.jsb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ContainerWay;
import com.android.ttcjpaysdk.base.OuterSource;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.android.ttcjpaysdk.base.h5.utils.CJPayDYPayHelper;
import com.android.ttcjpaysdk.base.h5.utils.CJPayXBridgeUtils;
import com.android.ttcjpaysdk.base.ktextension.CJStringExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayDyVerifyService;
import com.android.ttcjpaysdk.base.service.IOuterPayService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.outer.pay.jsb.abs.AbsJsbDypay;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/jsb/JSBDyPay;", "Lcom/android/ttcjpaysdk/outer/pay/jsb/abs/AbsJsbDypay;", "()V", "buildClientExtraDataMap", "", "", "sdkInfoJSONObject", "Lorg/json/JSONObject;", "buildTokenParams", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/outer/pay/jsb/abs/AbsJsbDypay$DypayInput;", "getContainerWay", "Lcom/android/ttcjpaysdk/base/ContainerWay;", "scheme", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "tryToLocate", "Companion", "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBDyPay extends AbsJsbDypay {
    public static final Companion Companion = null;
    private static final String TAG = "JSBDyPay";

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/jsb/JSBDyPay$Companion;", "", "()V", "TAG", "", "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbDypay.DypayInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    private final void tryToLocate() {
        b.d(AnonymousClass1.INSTANCE);
    }

    public JSBDyPay() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    private final Map<String, String> buildClientExtraDataMap(JSONObject r100) {
        HashMap r101 = new HashMap();
        String r102 = r100.optString(CJOuterPayBean.KEY_SAAS_SCENE);
        boolean r103 = true;
        if (r102.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        String r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        String r106 = (String) r101.put(CJOuterPayBean.KEY_SAAS_SCENE, r102);
    L12:
        String r107 = r100.optString(CJOuterPayBean.KEY_PREFETCH_DATA);
        if (r107.length() > 0) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r105 = r107;
    L18:
        if (r105 == null) goto L20;
        r101.put(CJOuterPayBean.KEY_PREFETCH_DATA, r105);
    L20:
        return r101;
    L5:
        r104 = false;
        goto L6
    }

    private final JSONObject buildTokenParams(JSONObject r100) {
        r100.remove(CJOuterPayBean.KEY_SAAS_SCENE);
        r100.remove(CJOuterPayBean.KEY_PREFETCH_DATA);
        return r100;
    }

    private final ContainerWay getContainerWay(String r100) {
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L4
    L6:
        if (r101 == null) goto L56;
        String r102 = UriProtector.getQueryParameter(r101, "__scene__");
        boolean r103 = false;
        if (r102 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L17;
        return ContainerWay.NFC;
    L17:
        if (CJStringExtensionKt.isNotNullOrEmpty(UriProtector.getQueryParameter(r101, "__cj_nfc_param__")) == true) goto L19;
        String r105 = UriProtector.getQueryParameter(r101, AppConstants.BUNDLE_REFERER);
        if (r105 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == true) goto L28;
        String r107 = UriProtector.getQueryParameter(r101, "scene");
        if (r107 != null) goto L32;
    L34:
        boolean r108 = false;
    L35:
        if (r108 == true) goto L37;
        String r109 = UriProtector.getQueryParameter(r101, "is_from_scan");
        if (r109 != null) goto L41;
    L43:
        boolean r110 = false;
    L44:
        if (r110 == true) goto L46;
        String r111 = UriProtector.getQueryParameter(r101, "is_cj_web_scan");
        if (r111 != null) goto L50;
    L52:
        if (r103 == false) goto L56;
        return ContainerWay.SCAN;
    L50:
        if (StringsKt.equals(r111, "1", true) != true) goto L52;
        r103 = true;
        goto L52
    L46:
        return ContainerWay.SCAN;
    L41:
        if (StringsKt.equals(r109, "1", true) != true) goto L43;
        r110 = true;
        goto L44
    L37:
        return ContainerWay.SCAN;
    L32:
        if (StringsKt.equals(r107, "qrcode", true) != true) goto L34;
        r108 = true;
        goto L35
    L28:
        return ContainerWay.SCAN;
    L23:
        if (StringsKt.equals(r105, "SCAN", true) != true) goto L25;
        r106 = true;
        goto L26
    L19:
        return ContainerWay.NFC;
    L10:
        if (StringsKt.equals(r102, "nfc", true) != true) goto L12;
        r104 = true;
    L56:
        return ContainerWay.OTHER;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("JSBDyPay#getContainerWay", e);
        CJBasicCommonUtils.logCatch("CJCatch", "JSBDyPay#getContainerWay", e);
        CJReporter r112 = CJReporter.f202294a;
        CJReporter.m(null, "get_scheme_illegal", 2, e);
        r101 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbDypay.DypayInput) r100);
    }

    public void realHandle(Context r310, AbsJsbDypay.DypayInput r311, final NothingOutput r312) {
        Intrinsics.checkNotNullParameter(r311, "input");
        Intrinsics.checkNotNullParameter(r312, BdpAppEventConstant.PARAMS_OUTPUT);
        if (CJPayDYPayHelper.isInvokeValidTiming() == false) goto L120;
        if (r310 != null) goto L118;
        return;
    L118:
        String r100 = r311.sdk_info;     // Catch: Throwable -> L115
        IOuterPayService r101 = (IOuterPayService) CJPayServiceManager.getInstance().getIService(IOuterPayService.class);     // Catch: Throwable -> L115
        boolean r102 = false;
        if (r100 != null) goto L10;
    L13:
        boolean r110 = true;
    L14:
        if (r110 == false) goto L16;
        JSBDyPay r111 = this;
    L17:
        if (r111 == null) goto L22;
        JSONObject r112 = KtSafeMethodExtensionKt.safeCreate(CJPayDYPayHelper.buildDefaultMapResult((String) CJPayDYPayHelper.CJ_PAY_DYPAY_PARAMS_ERROR.first));     // Catch: Throwable -> L115
        if (r112 != null) goto L21;
        r112 = new JSONObject();     // Catch: Throwable -> L115
    L21:
        r312.onSuccess(r112);     // Catch: Throwable -> L115
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L115
    L23:
        if (r113 != null) goto L121;
        if (r101 != null) goto L26;
    L108:
        Unit r103 = null;
    L109:
        if (r103 != null) goto L122;
        JSONObject r104 = KtSafeMethodExtensionKt.safeCreate(CJPayDYPayHelper.buildDefaultMapResult$default(null, 1, null));     // Catch: Throwable -> L115
        if (r104 != null) goto L113;
        r104 = new JSONObject();     // Catch: Throwable -> L115
    L113:
        r312.onSuccess(r104);     // Catch: Throwable -> L115
        return;
    L122:
        return;
    L26:
        if ((r310 instanceof Activity) == true) goto L29;
        r101 = null;
    L29:
        if (r101 == null) goto L108;
        CJPayHostInfo r114 = CJPayDYPayHelper.buildHostInfo(r310, CJPayXBridgeUtils.convertJsonToMap(r311.riskInfoParams), r311.cur_page_url);     // Catch: Throwable -> L115
        String r115 = r311.did;     // Catch: Throwable -> L115
        if (r115 != null) goto L33;
    L36:
        boolean r116 = true;
    L38:
        if ((!r116) == true) goto L41;
        r115 = null;
    L41:
        if (r115 != null) goto L43;
        r115 = null;
    L43:
        CJPayHostInfo.did = r115;     // Catch: Throwable -> L115
        String r105 = r311.aid;     // Catch: Throwable -> L115
        if (r105 != null) goto L46;
    L49:
        boolean r117 = true;
    L51:
        if ((!r117) == true) goto L54;
        r105 = null;
    L54:
        if (r105 != null) goto L56;
        r105 = null;
    L56:
        CJPayHostInfo.aid = r105;     // Catch: Throwable -> L115
        JSONObject r106 = KtSafeMethodExtensionKt.safeCreate(r100);     // Catch: Throwable -> L115
        String r107 = OuterSource.JSAPI.getValue();     // Catch: Throwable -> L115
        if (r106.optString("invoke_type").length() <= 0) goto L59;
        r102 = true;
    L59:
        if (r102 == false) goto L61;
        r107 = r106.optString("invoke_type");     // Catch: Throwable -> L115
    L61:
        Map<String, String> r108 = buildClientExtraDataMap(r106);     // Catch: Throwable -> L115
        JSONObject r109 = buildTokenParams(r106);     // Catch: Throwable -> L115
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L115
        KtSafeMethodExtensionKt.safePut(r118, "token", r109.toString());     // Catch: Throwable -> L115
        KtSafeMethodExtensionKt.safePut(r118, "mchid", r106.optString("merchantId"));     // Catch: Throwable -> L115
        KtSafeMethodExtensionKt.safePut(r118, "invoke_source", "0");     // Catch: Throwable -> L115
        String r119 = r118.toString();     // Catch: Throwable -> L115
        CJOuterPayBean r120 = new CJOuterPayBean(null, null, 0, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, 1048575, null).toOuterPayBean(r106);     // Catch: Throwable -> L115
        if (r120 == null) goto L65;
        r120.pay_scene_source = "JSAPI";     // Catch: Throwable -> L115
    L65:
        if (r120 == null) goto L68;
        r120.pay_source = r107;     // Catch: Throwable -> L115
    L68:
        if (r120 == null) goto L71;
        r120.payInfo = r119;     // Catch: Throwable -> L115
    L71:
        if (r120 == null) goto L74;
        r120.hostInfo = CJPayHostInfo.Companion.copy(r114);     // Catch: Throwable -> L115
    L74:
        if (r120 == null) goto L81;
        md4.b r121 = (md4.b) getDependency(md4.b.class);     // Catch: Throwable -> L115
        if (r121 == null) goto L79;
        String r122 = r121.getSchema();     // Catch: Throwable -> L115
    L80:
        r120.container_way = getContainerWay(r122);     // Catch: Throwable -> L115
        goto L81
    L79:
        r122 = null;
    L81:
        if (r120 == null) goto L87;
        Map<String, String> r123 = r120.dataMap;     // Catch: Throwable -> L115
        if (r123 != null) goto L86;
        r123 = new HashMap();     // Catch: Throwable -> L115
    L86:
        r123.putAll(r108);     // Catch: Throwable -> L115
        r120.dataMap = r123;     // Catch: Throwable -> L115
    L87:
        if (r120 == null) goto L90;
        r120.extTrackParams = new LinkedHashMap();     // Catch: Throwable -> L115
    L90:
        if (r120 != null) goto L92;
    L107:
        tryToLocate();     // Catch: Throwable -> L115
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L115
        goto L109
    L92:
        if ((r310 instanceof Activity) == false) goto L94;
        Activity r124 = (Activity) r310;     // Catch: Throwable -> L115
    L95:
        r101.startOuterProcessInvokeForInner(r124, r120, new JSBDyPay$realHandle$3$2$5(r312));     // Catch: Throwable -> L115
        ICJPayDyVerifyService r125 = (ICJPayDyVerifyService) CJPayServiceManager.getInstance().getIService(ICJPayDyVerifyService.class);     // Catch: Throwable -> L115
        if (r125 == null) goto L107;
        if (r114 == null) goto L99;
        Context r126 = r114.getContext();     // Catch: Throwable -> L115
    L100:
        if (r114 == null) goto L102;
        String r127 = r114.appId;     // Catch: Throwable -> L115
    L103:
        if (r114 == null) goto L105;
        String r128 = r114.merchantId;     // Catch: Throwable -> L115
    L106:
        r125.prefetchForIDaaSAuth(r126, r127, r128, "收银台", 2147483645);     // Catch: Throwable -> L115
        goto L107
    L105:
        r128 = null;
        goto L106
    L102:
        r127 = null;
        goto L103
    L99:
        r126 = null;
        goto L100
    L94:
        r124 = null;
        goto L95
    L46:
        if (StringsKt.isBlank(r105) == true) goto L49;
        r117 = false;
        goto L51
    L33:
        if (StringsKt.isBlank(r115) == true) goto L36;
        r116 = false;
        goto L38
    L121:
        return;
    L22:
        r113 = null;
        goto L23
    L16:
        r111 = null;
        goto L17
    L10:
        if (StringsKt.isBlank(r100) == true) goto L13;
        r110 = false;
    L115:
        th = move-exception;
        CJLogger.c(TAG, "realHandle failed", th);
        CJReporter r129 = CJReporter.f202294a;
        CJReporter.l(null, "JSBDyPay_realHandle", 1, "JSBDyPay realHandle failed", th);
        IJSBResult.DefaultImpls.onFailed$default(r312, null, null, 3, null);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbDypay.DypayInput) r101, (NothingOutput) r102);
    }
}
