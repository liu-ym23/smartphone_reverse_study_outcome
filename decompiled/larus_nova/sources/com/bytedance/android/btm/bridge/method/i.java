package com.bytedance.android.btm.bridge.method;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "btm.getBTMSdkInfo")
public final class i extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access f42099b;

    public i() {
        this.f42098a = "btm.getBTMSdkInfo";
        this.f42099b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.f42099b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f42098a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(final XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        int r103 = h.f42097a;
        ALogger.c(ALogger.f41996d, "FE_getBtmSdkInfo", new GetSdkInfoHelper$handle$1(r100));
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("btm_sdk_version", "2.0.4.i18n-rc.176");
        r104.put("btm_sdk_version_int", 2000418226);
        r104.put("debug", Boolean.FALSE);
        r104.put(EffectConfiguration.KEY_REGION, "cn");
        r104.put("os", "Android");
        j.b(this, r101, r104);
    }
}
