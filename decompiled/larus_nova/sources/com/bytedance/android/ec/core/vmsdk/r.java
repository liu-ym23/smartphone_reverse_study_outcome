package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class r extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.xbridge.n f45824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f45825b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f45824a.a().release();
    }

    public r(com.bytedance.ies.xbridge.n r100, String r101) {
        this.f45824a = r100;
        this.f45825b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        if ((this.f45824a.a() instanceof XCoreBridgeMethod) == false) goto L7;
        g66.c r103 = ((XCoreBridgeMethod) this.f45824a.a()).getContextProviderFactory();
        if (r103 == null) goto L7;
        r103.f(CallContext.class, r101);
    L7:
        r102.put("func", this.f45825b);
        this.f45824a.a().handle(new ReadableMapImpl(r102), new q(this), XBridgePlatformType.LYNX);
    }
}
