package com.stepos.policy.sdk.config;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkErrorCode {
    public static final int FAILED = -1;
    public static final PolicySdkErrorCode INSTANCE = new PolicySdkErrorCode();
    public static final int NETWORK_ERROR = -10004;
    public static final int NOT_NETWORK = -10003;
    public static final int PARAMETER_ERROR = -10001;
    public static final int PARAMETER_LOCAL_FILE_NAME_ERROR = -10002;
    public static final int SUCCESS = 0;

    private PolicySdkErrorCode() {
    }
}
