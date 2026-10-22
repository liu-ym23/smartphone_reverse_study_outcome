package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;
import java.util.Map;
import jc.b;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "setBcmParams")
public final class a extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41778b;

    public a() {
        this.f41777a = "setBcmParams";
        this.f41778b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41778b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41777a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        c r103 = getContextProviderFactory();
        if (r103 == null) goto L5;
        View r104 = HybridContainerContextManager.c(r103);
    L6:
        b r105 = com.bytedance.android.bcm.api.b.f41761a;
        PageFinder r106 = PageFinder.via(r104);
        Map<String, ? extends Object> r107 = r100.toMap();
        if (com.bytedance.android.bcm.api.b.f41761a.setBcmParams(r106, r107) == false) goto L9;
        int r108 = j.f42100a;
        j.b(this, r101, new LinkedHashMap());
        return;
    L9:
        j.a(this, r101, "failed");
        return;
    L5:
        r104 = null;
        goto L6
    }
}
