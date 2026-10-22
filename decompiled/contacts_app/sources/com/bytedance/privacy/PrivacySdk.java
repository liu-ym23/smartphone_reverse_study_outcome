package com.bytedance.privacy;

import com.bytedance.privacy.attestation.IdAttestationManager;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacySdk {
    private static volatile boolean initialized = false;

    static {
    }

    public PrivacySdk() {
    }

    public static void init(IAccountBridge r2, IEnvBridge r3) throws BdPrivacyException {
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(PrivacySdk.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (initialized == true) goto L15;
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        AccountApi.init(r2);     // Catch: Throwable -> L17
        NetworkConfig.getInstance().init(r3);     // Catch: Throwable -> L17
        initialized = true;     // Catch: Throwable -> L17
        goto L15
    L12:
        throw new BdPrivacyException("IEnvBridge cannot be null");     // Catch: Throwable -> L17
    L14:
        throw new BdPrivacyException("IAccountBridge cannot be null");     // Catch: Throwable -> L17
    L15:
        monitor-exit(PrivacySdk.class);     // Catch: Throwable -> L17
    }

    public static boolean isInitialized() {
        return initialized;
    }

    private static void checkInitialized() {
        if (initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Privacy SDK not initialized. Please call PrivacySdk.init(...) during app startup.");
    }

    public static PseudoManager getPseudoManager() {
        checkInitialized();
        return PseudoManager.getInstance();
    }

    public static IdAttestationManager getIdAttestationManager() {
        checkInitialized();
        return IdAttestationManager.getInstance();
    }
}
