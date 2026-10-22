package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.inner.ALogger;
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
import lc.d;
import lc.e;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.setScopedBcmUnitParams")
public final class SetScopedBcmUnitParamsMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f41776b;

    public SetScopedBcmUnitParamsMethod() {
        this.f41775a = "btm.setScopedBcmUnitParams";
        this.f41776b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f41776b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f41775a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        ALogger.c(ALogger.f41996d, "FE_setScopedBcmUnitParams", new AnonymousClass1(r100));
        c r103 = getContextProviderFactory();
        Object r104 = null;
        if (r103 == null) goto L5;
        View r105 = HybridContainerContextManager.c(r103);
    L6:
        Map<String, Object> r106 = r100.toMap();
        Object r107 = r106.get("scope");
        Object r108 = r106.get("content");
        if ((r108 instanceof Map) == false) goto L10;
        r104 = r108;
    L10:
        Map<String, ? extends Object> r109 = (Map) r104;
        if (r107 != null) goto L13;
    L31:
        j.a(this, r101, "scope must not be empty");
        return;
    L13:
        if ((r107 instanceof String) == false) goto L31;
        if (((CharSequence) r107).length() != 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == true) goto L31;
        if (r109 != null) goto L22;
    L29:
        j.a(this, r101, "scoped bcm unit params content not be empty");
        return;
    L22:
        if (r109.isEmpty() == true) goto L29;
        d r111 = e.f508392a;
        if (e.f508392a.getScope((String) r107).b(PageFinder.via(r105), r109) == false) goto L27;
        int r112 = j.f42100a;
        j.b(this, r101, new LinkedHashMap());
        return;
    L27:
        j.a(this, r101, "failed to set scoped bcm unit params");
        return;
    L17:
        r110 = false;
        goto L18
    L5:
        r105 = null;
        goto L6
    }
}
