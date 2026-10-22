package com.bytedance.android.btm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.getBTMEventParams")
public final class g extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f42096b;

    public g() {
        this.f42095a = "btm.getBTMEventParams";
        this.f42096b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f42096b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f42095a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.String] */
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r110) {
        int r111 = f.f42094a;
        ALogger.c(ALogger.f41996d, "FE_getBtmEventParams", new GetBtmParamsHelper$handle$1(r100));
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        BtmSDK r102 = BtmSDK.INSTANCE;
        String r103 = r102.getService().getLastPageBtm();
        String r104 = "";
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        ?? r105 = s.f(r100, "btm", r103);
        r112.element = r105;
        if (r105.length() != 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L16;
        String r107 = r102.getService().getLastPageBtm();
        T r108 = r104;
        if (r107 == null) goto L14;
        r108 = r107;
    L14:
        r112.element = r108;
        com.bytedance.android.btm.api.inner.g.a.a(r102.getService().getMonitor(), 1019, null, null, new GetBtmParamsHelper$handle$2(r112, this), 30);
    L16:
        if (getContextProviderFactory() == null) goto L21;
        Lazy r109 = HybridContainerContextManager.f42079a;
        g66.c r113 = getContextProviderFactory();
        if (r113 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        View r114 = HybridContainerContextManager.c(r113);
    L22:
        LinkedHashMap r115 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r116 = r102.createFullyReportParams((String) r112.element, PageFinder.via(r114)).entrySet().iterator();
    L24:
        if (r116.hasNext() == false) goto L28;
        Map.Entry<String, Object> r117 = r116.next();
        Object r118 = r117.getValue();
        if (r118 == null) goto L24;
        r115.put(r117.getKey(), r118);
        goto L24
    L28:
        j.b(this, r101, r115);
        return;
    L21:
        r114 = null;
        goto L22
    L9:
        r106 = false;
        goto L10
    }
}
