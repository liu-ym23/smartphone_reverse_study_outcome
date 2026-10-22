package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "scanCode")
public final class ob extends w20.p5<w20.sd, JSONObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public ob() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.sd r102 = (w20.sd) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        nb r103 = new nb(this, r102, r101);
        IHostAction r104 = (IHostAction) jc1.k.n(IHostAction.class);
        Context r105 = r101.getContext();
        Boolean r106 = r102.a();
        boolean r107 = false;
        if (r106 == null) goto L5;
        boolean r108 = r106.booleanValue();
    L6:
        Boolean r109 = r102.b();
        if (r109 == null) goto L9;
        r107 = r109.booleanValue();
    L9:
        r104.startQrScanCode(r105, r108, r107, r103);
        return;
    L5:
        r108 = false;
        goto L6
    }
}
