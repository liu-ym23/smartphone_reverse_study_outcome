package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkNetworkGate {
    public static final String BLOCKED_MESSAGE = "blocked before agree privacy policy";
    public static final PolicySdkNetworkGate INSTANCE = new PolicySdkNetworkGate();
    private static volatile boolean blockBeforeAgree = true;
    private static volatile Integer cachedAgreeStatus;

    private PolicySdkNetworkGate() {
    }

    public static final IOException blockedIOException() {
        return new IOException(BLOCKED_MESSAGE);
    }

    public static final boolean isBlockNetworkBeforeAgree() {
        return blockBeforeAgree;
    }

    public static final void setBlockNetworkBeforeAgree(boolean z) {
        blockBeforeAgree = z;
        PolicySdkLogUtils.Companion.d("NetworkGate", "setBlockNetworkBeforeAgree=" + z);
    }

    public static final boolean shouldBlock() {
        if (!blockBeforeAgree) {
            return false;
        }
        Integer num = cachedAgreeStatus;
        boolean z = (num != null ? num.intValue() : 0) != 1;
        if (z) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb2 = new StringBuilder("block SDK network: agreeStatus=");
            Object obj = cachedAgreeStatus;
            if (obj == null) {
                obj = "unset";
            }
            sb2.append(obj);
            companion.d("NetworkGate", sb2.toString());
        }
        return z;
    }

    public static final void updateAgreeStatusCache(int i10) {
        cachedAgreeStatus = Integer.valueOf(i10);
        PolicySdkLogUtils.Companion.d("NetworkGate", "agreeStatusCache=" + i10);
    }
}
