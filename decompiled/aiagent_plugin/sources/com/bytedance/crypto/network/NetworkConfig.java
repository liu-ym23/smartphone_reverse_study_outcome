package com.bytedance.crypto.network;

import com.bytedance.crypto.bridge.IEnvBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class NetworkConfig {
    private static final String TAG = "NetworkConfig";
    private static volatile NetworkConfig networkConfig;
    private IEnvBridge mEnvBridge;

    public NetworkConfig() {
    }

    public static NetworkConfig getInstance() {
        if (networkConfig != null) goto L15;
        monitor-enter(NetworkConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (networkConfig != null) goto L9;
        networkConfig = new NetworkConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkConfig.class);     // Catch: Throwable -> L11
    L15:
        return networkConfig;
    }

    public void init(IEnvBridge r3) {
        this.mEnvBridge = (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r3, IEnvBridge.class, "com.obric.aiagent.plugin");
    }

    public boolean isBoeEnv() {
        IEnvBridge r0 = this.mEnvBridge;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onIsBoeEnv();
    }
}
