package com.android.ttcjpaysdk.base.h5.cjjsb.h5jsb;

import android.content.Context;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbSetTitle;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import md4.b;
import md4.c;
import qd4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/h5jsb/JSBSetTitle;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbSetTitle;", "()V", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbSetTitle$SetTitleInput;", "realHandle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbSetTitle$SetTitleOutput;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBSetTitle extends AbsJsbSetTitle {
    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbSetTitle.SetTitleInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return null;
    }

    public JSBSetTitle() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbSetTitle.SetTitleInput) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.android.ttcjpaysdk.base.h5.cjjsb.h5jsb.JSBSetTitle$realHandle$2$1] */
    public void realHandle(Context r100, AbsJsbSetTitle.SetTitleInput r101, AbsJsbSetTitle.SetTitleOutput r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_OUTPUT);
        final String r103 = r101.title;
        String r104 = r101.subTitle;
        c r105 = (c) getDependency(c.class);
        String r106 = "";
        String r107 = null;
        if (r105 == 0) goto L24;
        b r108 = (b) getDependency(b.class);
        if (r108 == null) goto L9;
        ContainerName r109 = r108.a();
        if (r109 == null) goto L9;
        Boolean r110 = Boolean.valueOf(r109.isNotCJH5());
    L10:
        boolean r111 = false;
        if (r110 == null) goto L13;
        boolean r112 = r110.booleanValue();
    L14:
        if (r112 == true) goto L16;
    L18:
        if (r111 == true) goto L21;
        r105 = 0;
    L21:
        if (r105 == 0) goto L24;
        r105.a(new JSBSetTitle$realHandle$2$1(r103));
        r102.code = "0";
        r102.message = "";
        r102.onSuccess();
        return;
    L16:
        if (CJPaySettingsManager.getInstance().getNewContainerConfig().isOpenH52AnnieJSBAdapt() == false) goto L18;
        r111 = true;
        goto L18
    L13:
        r112 = false;
    L9:
        r110 = null;
    L24:
        a r113 = (a) getDependency(a.class);
        if (r113 == null) goto L27;
        Map<String, String> r114 = r113.updateWebviewTitle(r103, r104);
    L28:
        if (r114 == null) goto L30;
        String r115 = r114.get("code");
    L31:
        if (r115 != null) goto L33;
        r115 = "";
    L33:
        r102.code = r115;
        if (r114 == null) goto L36;
        r107 = r114.get("message");
    L36:
        if (r107 == null) goto L39;
        r106 = r107;
    L39:
        r102.message = r106;
        r102.onSuccess();
        return;
    L30:
        r115 = null;
        goto L31
    L27:
        r114 = null;
        goto L28
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbSetTitle.SetTitleInput) r101, (AbsJsbSetTitle.SetTitleOutput) r102);
    }
}
