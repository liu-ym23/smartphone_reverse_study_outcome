package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.setBTMPageShowEventParams")
public final class SetPageEventParamsMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41772b;

    public SetPageEventParamsMethod() {
        this.f41771a = "btm.setBTMPageShowEventParams";
        this.f41772b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41772b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41771a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        ALogger.c(ALogger.f41996d, "FE_setBTMPageShowEventParams", new AnonymousClass1(r100));
        c r103 = getContextProviderFactory();
        if (r103 == null) goto L5;
        View r104 = HybridContainerContextManager.c(r103);
    L13:
        XReadableMap r105 = s.e(r100, "params");     // Catch: Throwable -> L11
        if (r105 == null) goto L9;
        b.f41761a.setPageEventParams(PageFinder.via(r104), r105.toMap());     // Catch: Throwable -> L11
    L9:
        int r106 = j.f42100a;     // Catch: Throwable -> L11
        j.b(this, r101, new LinkedHashMap());     // Catch: Throwable -> L11
        return;
    L11:
        j.a(this, r101, "failed");
        return;
    L5:
        r104 = null;
        goto L13
    }
}
