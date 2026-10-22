package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveTryLoadCertPluginResultModel;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "live.tryLoadCertPlugin")
public final class s1 extends w20.o3<JsonObject, LiveTryLoadCertPluginResultModel> {
    public s1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHostOCRApiProxy r102 = (IHostOCRApiProxy) jc1.k.f(IHostOCRApiProxy.class);
        if (r102 != null) goto L5;
    L7:
        IHostOCRApiProxy r103 = (IHostOCRApiProxy) jc1.k.f(IHostOCRApiProxy.class);
        if (r103 == null) goto L12;
        r103.tryLoadCertPlugin(r101.getContext(), new r1(this));
        return;
    L12:
        return;
    L5:
        if (r102.isCertPluginLoaded() != true) goto L7;
        LiveTryLoadCertPluginResultModel r104 = new LiveTryLoadCertPluginResultModel();
        r104.a(LiveTryLoadCertPluginResultModel.Code.Success);
        r104.b("cert plugin loaded");
        Unit r105 = Unit.INSTANCE;
        finishWithResult(r104);
    }
}
