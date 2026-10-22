package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ss.ttvideoengine.DataLoaderHelper;
import g66.c;
import java.util.LinkedHashMap;
import lc.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.getScopedBcmChain")
public final class GetScopedBcmChainMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41768b;

    public GetScopedBcmChainMethod() {
        this.f41767a = "btm.getScopedBcmChain";
        this.f41768b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41768b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41767a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r110, XBridgePlatformType r111) {
        ALogger.c(ALogger.f41996d, "FE_getScopedBcmChain", new AnonymousClass1(r100));
        int r112 = r100.getInt("chain_length");
        String r101 = r100.getString("scope");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        j.a(this, r110, "scope is empty");
        return;
    L9:
        c r103 = getContextProviderFactory();
        JSONObject r104 = null;
        if (r103 == null) goto L12;
        View r105 = HybridContainerContextManager.c(r103);
    L13:
        if (r105 != null) goto L15;
        g.a.a(BtmSDK.INSTANCE.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, null, null, new AnonymousClass4(this), 30);
    L18:
        if (r104 != null) goto L20;
        j.a(this, r110, "chain is null");
        return;
    L20:
        int r106 = j.f42100a;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("content", r104);
        j.b(this, r110, r107);
        return;
    L15:
        kc.a r108 = e.f508392a.getScope(r101).a(PageFinder.via(r105), r112);
        if (r108 == null) goto L18;
        r104 = r108.a();
        goto L18
    L12:
        r105 = null;
        goto L13
    L5:
        r102 = false;
        goto L6
    }
}
