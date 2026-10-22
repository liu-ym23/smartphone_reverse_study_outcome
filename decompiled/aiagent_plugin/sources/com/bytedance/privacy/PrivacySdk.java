package com.bytedance.privacy;

import android.content.Context;
import com.bytedance.privacy.attestation.IdAttestationManager;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.bridge.IEventBridge;
import com.bytedance.privacy.bridge.ILogBridge;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.PccManager;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.utils.EventUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PrivacySdk {
    private static volatile boolean initialized = false;

    static {
    }

    public PrivacySdk() {
    }

    public static void init(IAccountBridge r2, IEnvBridge r3) {
        IAccountBridge r4 = (IAccountBridge) ZeusTransformUtils.wrapperContextForParams(r2, IAccountBridge.class, "com.obric.aiagent.plugin");
        IEnvBridge r5 = (IEnvBridge) ZeusTransformUtils.wrapperContextForParams(r3, IEnvBridge.class, "com.obric.aiagent.plugin");
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(PrivacySdk.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (initialized == true) goto L15;
        if (r4 == null) goto L14;
        if (r5 == null) goto L12;
        AccountApi.init(r4);     // Catch: Throwable -> L17
        NetworkConfig.getInstance().init(r5);     // Catch: Throwable -> L17
        initialized = true;     // Catch: Throwable -> L17
        goto L15
    L12:
        throw new BdPrivacyException("IEnvBridge cannot be null");     // Catch: Throwable -> L17
    L14:
        throw new BdPrivacyException("IAccountBridge cannot be null");     // Catch: Throwable -> L17
    L15:
        monitor-exit(PrivacySdk.class);     // Catch: Throwable -> L17
    }

    public static void initLogger(ILogBridge r2) {
        LogUtils.init((ILogBridge) ZeusTransformUtils.wrapperContextForParams(r2, ILogBridge.class, "com.obric.aiagent.plugin"));
    }

    public static void initEventReporter(IEventBridge r2) {
        EventUtils.init((IEventBridge) ZeusTransformUtils.wrapperContextForParams(r2, IEventBridge.class, "com.obric.aiagent.plugin"));
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

    public static PccManager getPccManager(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        checkInitialized();
        return PccManager.getInstance(r3);
    }
}
