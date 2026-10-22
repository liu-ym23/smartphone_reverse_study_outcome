package com.bytedance.android.btm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.bridge.BtmBridgeProvider;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "createBtmId")
public final class e extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f42093b;

    public e() {
        this.f42092a = "createBtmId";
        this.f42093b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f42093b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f42092a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        int r103 = d.f42091a;
        ALogger.c(ALogger.f41996d, "FE_createBtmId", new CreateBtmIdHelper$handle$1(r100));
        BtmBridgeProvider r104 = BtmBridgeProvider.f42078c;
        g66.c r105 = getContextProviderFactory();
        r104.getClass();
        String r106 = null;
        if (r105 == null) goto L5;
        View r107 = HybridContainerContextManager.c(r105);
    L6:
        BtmItemBuilder r108 = BtmBridgeProvider.a(cd.a.c(r100.toMap()), r107, null);
        if (r108 == null) goto L9;
        r106 = BtmSDK.INSTANCE.createBtmId(r108.build());
    L9:
        if (r106 != null) goto L11;
    L14:
        boolean r109 = true;
    L15:
        if (r109 == false) goto L17;
        com.bytedance.android.btm.api.inner.g.a.b(BtmSDK.INSTANCE.getService().getMonitor(), 1113, null, null, false, 30);
    L17:
        LinkedHashMap r110 = new LinkedHashMap();
        if (r106 == null) goto L20;
        r110.put("btm_id", r106);
    L20:
        j.b(this, r101, r110);
        return;
    L11:
        if (r106.length() == 0) goto L14;
        r109 = false;
        goto L15
    L5:
        r107 = null;
        goto L6
    }
}
