package com.android.ttcjpaysdk.base.h5.anniexbiz.wx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.h5.CJPayH5Activity;
import com.android.ttcjpaysdk.base.h5.cjjsb.h5jsb.JSBRequestWXH5Payment;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJSchemaExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.router.CJRouteOutMonitorUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.bytedance.caijing.sdk.infra.base.api.container.interfaceWrapper.JSBResult;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ld4.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0016\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/anniexbiz/wx/WxPayWebViewClient;", "Landroid/webkit/WebViewClient;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "containerContext", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "(Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;)V", "getContainerContext", "()Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "isCallWXH5PaySucceed", "", "CJTag", "", "handleContextNotActivity", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "shouldOverrideUrlLoading", "view", "Landroid/webkit/WebView;", "url", "startWxActivity", "cjPayHostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "updateScreenOrientation", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WxPayWebViewClient extends WebViewClient implements ICJTag {
    private final ContainerContext containerContext;
    private final boolean isCallWXH5PaySucceed;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "WxPayWebViewClient";
    }

    private final void updateScreenOrientation() {
        Activity r100 = this.containerContext.getActivity();
        if (r100 == null) goto L7;
        r100.setRequestedOrientation(3);
        return;
    }

    public final ContainerContext getContainerContext() {
        return this.containerContext;
    }

    public WxPayWebViewClient(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.containerContext = r100;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    private final void handleContextNotActivity(Context r100, Intent r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Activity) == true) goto L8;
        r101.setFlags(268435456);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(final WebView r110, final String r111) {
        i("[shouldOverrideUrlLoading] url is " + r111);
        i("[shouldOverrideUrlLoading] schema is " + this.containerContext.f202232a);
        i("[shouldOverrideUrlLoading] ttpay_annie_query is " + CJSchemaExtensionKt.getQueryParameter(this.containerContext.f202232a, "ttpay_annie_query"));
        final CJPayHostInfo r100 = CJPayHostInfo.Companion.toBean(KtSafeMethodExtensionKt.safeCreate(KtSafeMethodExtensionKt.ifNullOrBlank(this.containerContext.a("cjpay_host_info"), WxPayWebViewClient$shouldOverrideUrlLoading$hostInfo$1.INSTANCE)));
        Activity r101 = this.containerContext.getActivity();
        Context r102 = null;
        a r103 = null;
        if (r101 != null) goto L10;
        if (r110 == null) goto L8;
        Context r104 = r110.getContext();
        if (r104 == null) goto L8;
        r101 = CJPayBasicExtensionKt.toActivity(r104);
    L8:
        r101 = null;
    L10:
        if (r101 != null) goto L13;
        ICJTag.DefaultImpls.e$default(this, "[shouldOverrideUrlLoading] activity is null", null, 2, null);
    L13:
        if (r111 == null) goto L15;
        Boolean r105 = Boolean.valueOf(StringsKt.startsWith$default(r111, "weixin://", false, 2, null));
    L16:
        if (r105 == null) goto L18;
        boolean r106 = r105.booleanValue();
    L19:
        String r107 = "";
        if (r106 == true) goto L75;
        String r108 = this.containerContext.a("wx_pay_referer");
        if (TextUtils.isEmpty(r108) == true) goto L74;
        if (r111 == null) goto L53;
        Boolean r109 = Boolean.valueOf(StringsKt.contains$default(r111, r108 + CJPayH5Activity.CJ_PAY_REFERER_SUFFIX_FOR_JSB, false, 2, null));
    L54:
        if (r109 == null) goto L56;
        boolean r112 = r109.booleanValue();
    L57:
        if (r112 == false) goto L74;
        String r113 = this.containerContext.a("wx_pay_jsb_callback_id");
        if (r113 == null) goto L61;
        r103 = JSBRequestWXH5Payment.Companion.getWxPayCallBackContext(r113);
    L61:
        if (r103 == null) goto L69;
        JSONObject r114 = new JSONObject();
        r114.put("code", 1);     // Catch: JSONException -> L67
        int r115 = JSBResult.f202211e;     // Catch: JSONException -> L67
        r103.callback(JSBResult.a.b(r114, ""));     // Catch: JSONException -> L67
        com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a r116 = this.containerContext.f202238g;     // Catch: JSONException -> L67
        if (r116 == null) goto L72;
        r116.close();     // Catch: JSONException -> L67
    L72:
        return true;
    L67:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("WxPayWebViewClient#shouldOverrideUrlLoading", e);
        CJBasicCommonUtils.logCatch("CJCatch", "WxPayWebViewClient#shouldOverrideUrlLoading", e);
        e("WxPayCallback error: ", e);
        goto L72
    L69:
        updateScreenOrientation();
        CJPayCallBackCenter.getInstance().setResultCode(0);
        com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a r117 = this.containerContext.f202238g;
        if (r117 == null) goto L72;
        r117.close();
        goto L72
    L56:
        r112 = false;
        goto L57
    L53:
        r109 = null;
    L74:
        return super.shouldOverrideUrlLoading(r110, r111);
    L75:
        String r118 = r100.merchantId;     // Catch: Exception -> L30
        if (r118 != null) goto L24;
        r118 = "";
    L24:
        String r119 = r100.appId;     // Catch: Exception -> L30
        if (r119 == null) goto L28;
        r107 = r119;
    L28:
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_wx_h5pay_open_wx", new JSONObject[]{CJPayParamsUtils.getCommonLogParams(r118, r107)});     // Catch: Exception -> L30
    L32:
        ICJPayBPEAService r120 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);     // Catch: Exception -> L37
        if (r120 == null) goto L35;
        r120.wrapStartActivityByBpea("bpea-bpea-cjpay_android_weixin", null, new AnonymousClass1(r111, r100, this, r110));     // Catch: Exception -> L37
    L48:
        return true;
    L35:
        Intent r121 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r111));     // Catch: Exception -> L37
        CJRouteOutMonitorUtils r122 = CJRouteOutMonitorUtils.INSTANCE;     // Catch: Exception -> L37
        r122.notifyRouteOutCertId(CJRouteOutMonitorUtils.CERT_ID_WXPAY, null, this.containerContext.getActivity());     // Catch: Exception -> L37
        startWxActivity(r110, r121, r100);     // Catch: Exception -> L37
        r122.removeNotifiedRouteOutCertId(CJRouteOutMonitorUtils.CERT_ID_WXPAY);     // Catch: Exception -> L37
        goto L48
    L30:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("WxPayWebViewClient#shouldOverrideUrlLoading", e);     // Catch: Exception -> L37
        CJBasicCommonUtils.logCatch("CJCatch", "WxPayWebViewClient#shouldOverrideUrlLoading", e);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("WxPayWebViewClient#shouldOverrideUrlLoading", e);
        CJBasicCommonUtils.logCatch("CJCatch", "WxPayWebViewClient#shouldOverrideUrlLoading", e);
        Context r123 = this.containerContext.getActivity();
        if (r123 != null) goto L46;
        if (r110 == null) goto L43;
        r102 = r110.getContext();
    L43:
        if (r102 != null) goto L45;
        r123 = CJEnv.a();
        goto L46
    L45:
        r123 = r102;
    L46:
        if (r123 == null) goto L48;
        CJPayBasicUtils.displayToast(r123, r123.getResources().getString(R.string.cj_pay_wx_un_install));
        goto L48
    L18:
        r106 = false;
        goto L19
    L15:
        r105 = null;
        goto L16
    }

    private final void startWxActivity(WebView r100, Intent r101, CJPayHostInfo r110) {
        Context r102 = this.containerContext.getActivity();
        if (r102 == null) goto L5;
        String r103 = "containerContext_activity";
    L15:
        handleContextNotActivity(r102, r101);
        r102.startActivity(r101);
        i("[startWxActivity] contextType is ".concat(r103));
        CJReporter r104 = CJReporter.f202294a;
        Set<String> r105 = CJContext.f202254w;
        String r106 = r110.appId;
        String r107 = "";
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        String r111 = r110.merchantId;
        if (r111 == null) goto L22;
        r107 = r111;
    L22:
        CJContext r108 = CJContext.c.b("anniex_wxh5_pay", r106, r107);
        Map r109 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("contextSource", r103)});
        Map r112 = (Map) this.containerContext.f202237f.getValue();
        if (r112 == null) goto L25;
        r109.putAll(r112);
    L25:
        Unit r113 = Unit.INSTANCE;
        CJReporter.h(r104, r108, "wallet_rd_h5_open_wx", r109, null, 56);
        return;
    L5:
        r102 = this.containerContext.getContext();
        if (r102 == null) goto L8;
        r103 = "containerContext_context";
        goto L15
    L8:
        if (r100 == null) goto L12;
        Context r114 = r100.getContext();
        if (r114 == null) goto L12;
        r102 = r114;
        r103 = "view_context";
    L13:
        if (r102 != null) goto L15;
        r102 = CJEnv.a();
        r103 = "application";
    L12:
        r103 = "unknown";
        r102 = null;
        goto L13
    }

    public static final /* synthetic */ void access$startWxActivity(WxPayWebViewClient r100, WebView r101, Intent r102, CJPayHostInfo r103) {
        r100.startWxActivity(r101, r102, r103);
    }
}
