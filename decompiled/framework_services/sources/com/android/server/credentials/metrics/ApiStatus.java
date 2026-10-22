package com.android.server.credentials.metrics;

/* JADX INFO: loaded from: classes.dex */
public final enum ApiStatus extends Enum<ApiStatus> {
    private static final /* synthetic */ ApiStatus[] $VALUES = null;
    public static final ApiStatus BINDER_DIED = null;
    public static final ApiStatus CLIENT_CANCELED = null;
    public static final ApiStatus FAILURE = null;
    public static final ApiStatus SUCCESS = null;
    public static final ApiStatus USER_CANCELED = null;
    private final int mInnerMetricCode;

    private static /* synthetic */ ApiStatus[] $values() {
        return new ApiStatus[]{SUCCESS, FAILURE, CLIENT_CANCELED, USER_CANCELED, BINDER_DIED};
    }

    public static ApiStatus valueOf(String name) {
        return (ApiStatus) Enum.valueOf(ApiStatus.class, name);
    }

    public static ApiStatus[] values() {
        return (ApiStatus[]) $VALUES.clone();
    }

    static {
        SUCCESS = new ApiStatus("SUCCESS", 0, 1);
        FAILURE = new ApiStatus("FAILURE", 1, 2);
        CLIENT_CANCELED = new ApiStatus("CLIENT_CANCELED", 2, 4);
        USER_CANCELED = new ApiStatus("USER_CANCELED", 3, 3);
        BINDER_DIED = new ApiStatus("BINDER_DIED", 4, 5);
        $VALUES = $values();
    }

    private ApiStatus(String r1, int r2, int innerMetricCode) {
        super(r1, r2);
        this.mInnerMetricCode = innerMetricCode;
    }

    public int getMetricCode() {
        return this.mInnerMetricCode;
    }
}
