package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.io.IOException;

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

    public static final void setBlockNetworkBeforeAgree(boolean z5) {
        blockBeforeAgree = z5;
        PolicySdkLogUtils.Companion.d("NetworkGate", "setBlockNetworkBeforeAgree=" + z5);
    }

    public static final boolean shouldBlock() {
        if (!blockBeforeAgree) {
            return false;
        }
        Integer num = cachedAgreeStatus;
        boolean z5 = (num != null ? num.intValue() : 0) != 1;
        if (z5) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("block SDK network: agreeStatus=");
            Object obj = cachedAgreeStatus;
            if (obj == null) {
                obj = "unset";
            }
            sb.append(obj);
            companion.d("NetworkGate", sb.toString());
        }
        return z5;
    }

    public static final void updateAgreeStatusCache(int i5) {
        cachedAgreeStatus = Integer.valueOf(i5);
        PolicySdkLogUtils.Companion.d("NetworkGate", "agreeStatusCache=" + i5);
    }
}
