package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySdkNetworkGate;", "", "<init>", "()V", "", "enable", "LY8/t;", "setBlockNetworkBeforeAgree", "(Z)V", "isBlockNetworkBeforeAgree", "()Z", "", "status", "updateAgreeStatusCache", "(I)V", "shouldBlock", "Ljava/io/IOException;", "blockedIOException", "()Ljava/io/IOException;", "", "BLOCKED_MESSAGE", "Ljava/lang/String;", "blockBeforeAgree", "Z", "cachedAgreeStatus", "Ljava/lang/Integer;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public static final void setBlockNetworkBeforeAgree(boolean enable) {
        blockBeforeAgree = enable;
        PolicySdkLogUtils.INSTANCE.d("NetworkGate", "setBlockNetworkBeforeAgree=" + enable);
    }

    public static final boolean shouldBlock() {
        if (!blockBeforeAgree) {
            return false;
        }
        Integer num = cachedAgreeStatus;
        boolean z10 = (num != null ? num.intValue() : 0) != 1;
        if (z10) {
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("block SDK network: agreeStatus=");
            Object obj = cachedAgreeStatus;
            if (obj == null) {
                obj = "unset";
            }
            sb2.append(obj);
            companion.d("NetworkGate", sb2.toString());
        }
        return z10;
    }

    public static final void updateAgreeStatusCache(int status) {
        cachedAgreeStatus = Integer.valueOf(status);
        PolicySdkLogUtils.INSTANCE.d("NetworkGate", "agreeStatusCache=" + status);
    }
}
