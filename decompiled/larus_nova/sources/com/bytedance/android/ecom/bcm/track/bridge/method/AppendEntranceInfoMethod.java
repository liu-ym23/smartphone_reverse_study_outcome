package com.bytedance.android.ecom.bcm.track.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(name = "appendEntranceInfo")
public final class AppendEntranceInfoMethod extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f51067b;

    public AppendEntranceInfoMethod() {
        this.f51066a = "appendEntranceInfo";
        this.f51067b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f51067b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f51066a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        ALogger r103 = ALogger.f41996d;
        ALogger.c(r103, "FE_appendEntranceInfo", new AnonymousClass1(r100));
        String r104 = r100.getString(a.KEY_ENTRANCE_INFO);
        c r105 = getContextProviderFactory();
        if (r105 == null) goto L5;
        View r106 = HybridContainerContextManager.c(r105);
    L6:
        if (r106 != null) goto L17;
        ALogger.c(r103, "FE_appendEntranceInfo", AnonymousClass3.INSTANCE);
        int r107 = j.f42100a;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put(a.KEY_ENTRANCE_INFO, r104);
        j.b(this, r101, r108);
        return;
    L17:
        JSONObject r109 = new JSONObject(r104);     // Catch: Exception -> L11
    L12:
        JSONObject r110 = EcomBcmTracker.c(PageFinder.via(r106), r109);     // Catch: Exception -> L14
        int r111 = j.f42100a;     // Catch: Exception -> L14
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Exception -> L14
        r112.put(a.KEY_ENTRANCE_INFO, String.valueOf(r110));     // Catch: Exception -> L14
        j.b(this, r101, r112);     // Catch: Exception -> L14
        return;
    L11:
        r109 = new JSONObject();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ALogger.c(ALogger.f41996d, "FE_appendEntranceInfo", new AnonymousClass6(e));
        int r113 = j.f42100a;
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put(a.KEY_ENTRANCE_INFO, r104);
        j.b(this, r101, r114);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
