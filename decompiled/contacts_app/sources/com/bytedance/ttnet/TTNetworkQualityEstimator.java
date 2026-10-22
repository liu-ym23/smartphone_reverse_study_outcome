package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetworkQualityEstimator {
    public TTNetworkQualityEstimator() {
    }

    public static int getNetworkQualityLevel() {
        SsCronetHttpClient r1 = getCronetHttpClient();     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.getNetworkQualityLevel();
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getEffectiveHttpRttMs() {
        SsCronetHttpClient r1 = getCronetHttpClient();     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.getEffectiveHttpRttMs();
    L12:
        return -1;
    L7:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static int getEffectiveTransportRttMs() {
        SsCronetHttpClient r1 = getCronetHttpClient();     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.getEffectiveTransportRttMs();
    L12:
        return -1;
    L7:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static int getEffectiveRxThroughputKbps() {
        SsCronetHttpClient r1 = getCronetHttpClient();     // Catch: Exception -> L7
        if (r1 == null) goto L12;
        return r1.getEffectiveRxThroughputKbps();
    L12:
        return -1;
    L7:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable() == false) goto L7;
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }
}
