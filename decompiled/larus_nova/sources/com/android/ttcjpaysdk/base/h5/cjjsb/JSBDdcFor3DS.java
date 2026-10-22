package com.android.ttcjpaysdk.base.h5.cjjsb;

import android.content.Context;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbDdcFor3DS;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBResult;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayCybsService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/JSBDdcFor3DS;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS;", "()V", "webview", "Landroid/webkit/WebView;", "getWebview", "()Landroid/webkit/WebView;", "setWebview", "(Landroid/webkit/WebView;)V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS$DdcFor3DSInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbDdcFor3DS$DdcFor3DSOutput;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBDdcFor3DS extends AbsJsbDdcFor3DS {
    private WebView webview;

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbDdcFor3DS.DdcFor3DSInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBDdcFor3DS() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    public final WebView getWebview() {
        return this.webview;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbDdcFor3DS.DdcFor3DSInput) r100);
    }

    public final void setWebview(WebView r100) {
        this.webview = r100;
    }

    public void realHandle(Context r100, AbsJsbDdcFor3DS.DdcFor3DSInput r101, final AbsJsbDdcFor3DS.DdcFor3DSOutput r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_OUTPUT);
        if (r100 != null) goto L6;
        IJSBResult.DefaultImpls.onFailed$default(r102, "context is null", null, 2, null);
        Unit r103 = Unit.INSTANCE;
        return;
    L6:
        String r104 = r101.accessToken;
        String r105 = r101.ddcURL;
        ICJPayCybsService r106 = (ICJPayCybsService) CJPayServiceManager.getInstance().getIService(ICJPayCybsService.class);
        if (r106 == null) goto L10;
        WebView r107 = new WebView(r100);
        r106.startDDCIFrame(r107, r105, r104, new JSBDdcFor3DS$realHandle$2$1$1());
        r106.getBrowserDeviceFinger(r100, new JSBDdcFor3DS$realHandle$2$1$2(r102));
        this.webview = r107;
        return;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbDdcFor3DS.DdcFor3DSInput) r101, (AbsJsbDdcFor3DS.DdcFor3DSOutput) r102);
    }
}
