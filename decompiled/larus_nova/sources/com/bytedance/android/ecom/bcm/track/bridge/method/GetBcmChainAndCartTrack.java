package com.bytedance.android.ecom.bcm.track.bridge.method;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(name = "getBcmChainAndCartTrack")
public final class GetBcmChainAndCartTrack extends XCoreBridgeMethod implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f51069b;

    public GetBcmChainAndCartTrack() {
        this.f51068a = "getBcmChainAndCartTrack";
        this.f51069b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f51069b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f51068a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        ALogger r103 = ALogger.f41996d;
        ALogger.c(r103, "FE_getBcmChainAndCartTrack", new AnonymousClass1(r100));
        String r104 = r100.getString("cart_track");
        String r105 = r100.getString("btm");
        XReadableMap r106 = r100.getMap("bcm");
        View r107 = null;
        if (r106 == null) goto L5;
        Map<String, Object> r108 = s.h(r106);
    L6:
        c r109 = getContextProviderFactory();
        if (r109 == null) goto L9;
        r107 = HybridContainerContextManager.c(r109);
    L9:
        if (r107 != null) goto L12;
        ALogger.c(r103, "FE_getBcmChainAndCartTrack", AnonymousClass3.INSTANCE);
        int r110 = j.f42100a;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("cart_track", r104);
        j.b(this, r101, r111);
        return;
    L12:
        d r112 = new d();
        r112.f42022a = r105;
        BcmParams.Companion.getClass();
        r112.f42024c = BcmParams.a.c(r108);
        r112.f42023b = PageFinder.via(r107);
        JSONObject r113 = new JSONObject(r104);     // Catch: Exception -> L15
    L16:
        Object r114 = EcomBcmTracker.e(r112, r113);     // Catch: Exception -> L18
    L20:
        String r115 = EcomBcmTracker.g(r112);
        int r116 = j.f42100a;
        LinkedHashMap r117 = new LinkedHashMap();
        r117.put("cart_track", String.valueOf(r114));
        if (r115 != null) goto L24;
        r115 = "";
    L24:
        r117.put("bcm_chain", r115);
        j.b(this, r101, r117);
        return;
    L18:
        e = move-exception;
        ALogger.c(ALogger.f41996d, "FE_getBcmChainAndCartTrack", new GetBcmChainAndCartTrack$handle$newCartTrack$1(e));
        r114 = r104;
    L15:
        r113 = new JSONObject();     // Catch: Exception -> L18
        goto L16
    L5:
        r108 = null;
        goto L6
    }
}
