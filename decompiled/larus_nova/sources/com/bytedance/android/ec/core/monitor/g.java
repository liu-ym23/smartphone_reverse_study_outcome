package com.bytedance.android.ec.core.monitor;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements SDKMonitor.IGetExtendParams {
    public g() {
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final Map<String, String> getCommonParams() {
        Pair[] r100 = new Pair[1];
        String r101 = ECAppInfoService.f48114e.getAppId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[0] = new Pair("host_aid", r101);
        return MapsKt.mutableMapOf(r100);
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final String getSessionId() {
        return null;
    }
}
