package com.bytedance.privacy.network;

import com.bytedance.privacy.bridge.IEnvBridge;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkConfig {
    private static final String TAG = "NetworkConfig";
    private static volatile NetworkConfig networkConfig;
    private IEnvBridge mEnvBridge;

    static {
    }

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

    public void init(IEnvBridge r1) throws NullPointerException {
        if (r1 == null) goto L6;
        this.mEnvBridge = r1;
        return;
    L6:
        throw new NullPointerException("IEnvBridge envBridge cannot be null");
    }

    public boolean isBoeEnv() {
        IEnvBridge r0 = this.mEnvBridge;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onIsBoeEnv();
    }
}
