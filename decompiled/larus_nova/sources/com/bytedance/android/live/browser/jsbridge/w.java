package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class w extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f64109a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        ((com.bytedance.ies.xbridge.n) this.f64109a.f64143b.getValue()).a().release();
    }

    public w(x r100) {
        this.f64109a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Logger.d("XbridgeManager", "xbridge start,fun name:" + this.f64109a.f64142a);
        if ((((com.bytedance.ies.xbridge.n) this.f64109a.f64143b.getValue()).a() instanceof XCoreBridgeMethod) == false) goto L11;
        XBridgeMethod r103 = ((com.bytedance.ies.xbridge.n) this.f64109a.f64143b.getValue()).a();
        if (r103 == null) goto L10;
        g66.c r104 = ((XCoreBridgeMethod) r103).getContextProviderFactory();
        if (r104 == null) goto L11;
        r104.f(CallContext.class, r101);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod");
    L11:
        r102.put("func", this.f64109a.f64142a);
        XBridgeMethod r105 = ((com.bytedance.ies.xbridge.n) this.f64109a.f64143b.getValue()).a();
        m30.g r106 = new m30.g(r102);
        v r107 = new v(this);
        IHybridComponent r108 = this.f64109a.f64144c.c();
        if (r108 == null) goto L14;
        IHybridComponent.HybridType r109 = r108.hybridType();
    L16:
        if (r109 != IHybridComponent.HybridType.LYNX) goto L18;
        XBridgePlatformType r110 = XBridgePlatformType.LYNX;
    L19:
        r105.handle(r106, r107, r110);
        return;
    L18:
        r110 = XBridgePlatformType.WEB;
        goto L19
    L14:
        r109 = null;
        goto L16
    }
}
