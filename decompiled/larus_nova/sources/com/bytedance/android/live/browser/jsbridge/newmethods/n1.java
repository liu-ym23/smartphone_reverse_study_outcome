package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CanIUseResultModel;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n1 extends w20.k<w20.s7, CanIUseResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IJsBridgeManager f63563a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public n1(IJsBridgeManager r100) {
        this.f63563a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.s7 r102 = (w20.s7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        CanIUseResultModel r104 = new CanIUseResultModel();
        IJsBridgeManager r105 = this.f63563a;
        if (r105 == null) goto L9;
        List<String> r106 = r105.getMethodNameList();
        if (r106 == null) goto L9;
        if (CollectionsKt.contains(r106, r103) != true) goto L9;
        int r107 = 1;
    L10:
        r104.a(r107);
        r104.b(CanIUseResultModel.Code.Success);
        finishWithResult(r104);
        return;
    L9:
        r107 = 0;
        goto L10
    }
}
