package com.android.server.credentials.metrics;

/* JADX INFO: loaded from: classes.dex */
public final enum ProviderStatusForMetrics extends Enum<ProviderStatusForMetrics> {
    private static final /* synthetic */ ProviderStatusForMetrics[] $VALUES = null;
    public static final ProviderStatusForMetrics FINAL_FAILURE = null;
    public static final ProviderStatusForMetrics FINAL_SUCCESS = null;
    public static final ProviderStatusForMetrics QUERY_FAILURE = null;
    public static final ProviderStatusForMetrics QUERY_SUCCESS = null;
    public static final ProviderStatusForMetrics UNKNOWN = null;
    private final int mInnerMetricCode;

    private static /* synthetic */ ProviderStatusForMetrics[] $values() {
        return new ProviderStatusForMetrics[]{UNKNOWN, FINAL_FAILURE, QUERY_FAILURE, FINAL_SUCCESS, QUERY_SUCCESS};
    }

    public static ProviderStatusForMetrics valueOf(String name) {
        return (ProviderStatusForMetrics) Enum.valueOf(ProviderStatusForMetrics.class, name);
    }

    public static ProviderStatusForMetrics[] values() {
        return (ProviderStatusForMetrics[]) $VALUES.clone();
    }

    static {
        UNKNOWN = new ProviderStatusForMetrics("UNKNOWN", 0, 0);
        FINAL_FAILURE = new ProviderStatusForMetrics("FINAL_FAILURE", 1, 4);
        QUERY_FAILURE = new ProviderStatusForMetrics("QUERY_FAILURE", 2, 3);
        FINAL_SUCCESS = new ProviderStatusForMetrics("FINAL_SUCCESS", 3, 2);
        QUERY_SUCCESS = new ProviderStatusForMetrics("QUERY_SUCCESS", 4, 1);
        $VALUES = $values();
    }

    private ProviderStatusForMetrics(String r1, int r2, int innerMetricCode) {
        super(r1, r2);
        this.mInnerMetricCode = innerMetricCode;
    }

    public int getMetricCode() {
        return this.mInnerMetricCode;
    }
}
