package com.stepos.core.common.cloud;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudTransport {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ CloudTransport[] $VALUES;
    public static final CloudTransport HTTP_SSE = new CloudTransport("HTTP_SSE", 0);
    public static final CloudTransport WEBSOCKET = new CloudTransport("WEBSOCKET", 1);
    public static final CloudTransport HTTP_ASYNC = new CloudTransport("HTTP_ASYNC", 2);

    private static final /* synthetic */ CloudTransport[] $values() {
        return new CloudTransport[]{HTTP_SSE, WEBSOCKET, HTTP_ASYNC};
    }

    static {
        CloudTransport[] cloudTransportArr$values = $values();
        $VALUES = cloudTransportArr$values;
        $ENTRIES = kotlin.enums.a.a(cloudTransportArr$values);
    }

    private CloudTransport(String str, int i10) {
    }

    public static sb.a<CloudTransport> getEntries() {
        return $ENTRIES;
    }

    public static CloudTransport valueOf(String str) {
        return (CloudTransport) Enum.valueOf(CloudTransport.class, str);
    }

    public static CloudTransport[] values() {
        return (CloudTransport[]) $VALUES.clone();
    }
}
