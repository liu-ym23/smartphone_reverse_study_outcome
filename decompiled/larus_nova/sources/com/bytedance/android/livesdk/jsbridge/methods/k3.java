package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.bytedance.android.live.browser.jsbridge.base.RechargeScreenShieldResultModel;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.config.er0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import w20.cd;

/* JADX INFO: loaded from: classes9.dex */
public final class k3 extends w20.b5<cd, RechargeScreenShieldResultModel> {

    public static final class a {
    }

    static {
    }

    public k3(WeakReference<Context> r100) {
        Intrinsics.checkNotNullParameter(r100, "contextRef");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        cd r102 = (cd) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102.a();
        if (er0.f120149a.getValue().booleanValue() == false) goto L18;
        Activity r103 = ContextUtil.contextToActivity(r101.getContext());
        Integer r104 = r102.a();
        if (r104 != null) goto L8;
    L13:
        if (r103 == null) goto L17;
        Window r105 = r103.getWindow();
        if (r105 == null) goto L17;
        r105.clearFlags(8192);
    L17:
        finishWithSuccess();
        return;
    L8:
        if (r104.intValue() != 1) goto L13;
        if (r103 == null) goto L17;
        Window r106 = r103.getWindow();
        if (r106 == null) goto L17;
        r106.setFlags(8192, 8192);
        goto L17
    L18:
        finishWithSuccess();
    }
}
