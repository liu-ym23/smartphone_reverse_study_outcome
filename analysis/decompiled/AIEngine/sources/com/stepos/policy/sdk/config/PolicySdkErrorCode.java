package com.stepos.policy.sdk.config;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
