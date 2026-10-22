package com.bytedance.privacy.pseudoid;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.utils.PrivacyUtils;

/* JADX INFO: loaded from: classes2.dex */
public class RPIDStoreConfig {
    private static final String BOE_SUFFIX = "_boe";
    public static final String DID_SUFFIX = "_did";
    public static final String RPDID_SUFFIX = "_rpdid";
    public static final String RPUID_SUFFIX = "_rpuid";

    public RPIDStoreConfig() {
    }

    private static String buildAlias(String r1, String r2, String r3) {
        String r4 = r1 + "_" + r2 + r3;
        if (NetworkConfig.getInstance().isBoeEnv() == true) goto L5;
        return r4;
    L5:
        return r4 + BOE_SUFFIX;
    }

    public static String buildRPDIDAlias(String r1, String r2) {
        return PrivacyUtils.sha256ToHexString(buildAlias(r1, r2, RPDID_SUFFIX));
    }

    public static String buildDeviceIdAlias(String r1, String r2) {
        return PrivacyUtils.sha256ToHexString(buildAlias(r1, r2, DID_SUFFIX));
    }

    public static String buildRPUIDAlias(String r1, String r2) {
        return PrivacyUtils.sha256ToHexString(buildAlias(r1, r2, RPUID_SUFFIX));
    }
}
