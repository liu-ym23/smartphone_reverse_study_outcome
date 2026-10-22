package com.bytedance.crypto.e2eetrans;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CryptoSessionManager {
    public CryptoSessionManager() {
    }

    public static CryptoSession createInitiatorSession(String r2, String r3, IAttestationService r4, long r5) {
        return CryptoSessionImpl.createInitiator(r2, r3, (IAttestationService) ZeusTransformUtils.wrapperContextForParams(r4, IAttestationService.class, "com.obric.aiagent.plugin"), r5);
    }

    public static CryptoSession createResponderSession(String r6, String r7, IAttestationService r8, long r9, byte[] r11) {
        return CryptoSessionImpl.createResponder(r6, r7, (IAttestationService) ZeusTransformUtils.wrapperContextForParams(r8, IAttestationService.class, "com.obric.aiagent.plugin"), r9, r11);
    }
}
