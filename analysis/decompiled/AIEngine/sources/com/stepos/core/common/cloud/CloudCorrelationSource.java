package com.stepos.core.common.cloud;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudCorrelationSource {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ CloudCorrelationSource[] $VALUES;
    public static final CloudCorrelationSource RESPONSE_HEADER_X_TRACE_ID = new CloudCorrelationSource("RESPONSE_HEADER_X_TRACE_ID", 0);
    public static final CloudCorrelationSource TTS_WS_CONNECTION_SESSION_ID = new CloudCorrelationSource("TTS_WS_CONNECTION_SESSION_ID", 1);
    public static final CloudCorrelationSource ASR_WS_SESSION_CREATED_ID = new CloudCorrelationSource("ASR_WS_SESSION_CREATED_ID", 2);
    public static final CloudCorrelationSource SSE_META_SESSION_ID = new CloudCorrelationSource("SSE_META_SESSION_ID", 3);
    public static final CloudCorrelationSource ASYNC_TASK_ID = new CloudCorrelationSource("ASYNC_TASK_ID", 4);

    private static final /* synthetic */ CloudCorrelationSource[] $values() {
        return new CloudCorrelationSource[]{RESPONSE_HEADER_X_TRACE_ID, TTS_WS_CONNECTION_SESSION_ID, ASR_WS_SESSION_CREATED_ID, SSE_META_SESSION_ID, ASYNC_TASK_ID};
    }

    static {
        CloudCorrelationSource[] cloudCorrelationSourceArr$values = $values();
        $VALUES = cloudCorrelationSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(cloudCorrelationSourceArr$values);
    }

    private CloudCorrelationSource(String str, int i10) {
    }

    public static sb.a<CloudCorrelationSource> getEntries() {
        return $ENTRIES;
    }

    public static CloudCorrelationSource valueOf(String str) {
        return (CloudCorrelationSource) Enum.valueOf(CloudCorrelationSource.class, str);
    }

    public static CloudCorrelationSource[] values() {
        return (CloudCorrelationSource[]) $VALUES.clone();
    }
}
