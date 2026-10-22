package com.stepos.core.ability.speech;

import com.stepos.core.common.telemetry.FailStage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetworkTransport {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ NetworkTransport[] $VALUES;
    public static final NetworkTransport WIFI = new NetworkTransport("WIFI", 0);
    public static final NetworkTransport CELLULAR = new NetworkTransport("CELLULAR", 1);
    public static final NetworkTransport OTHER = new NetworkTransport("OTHER", 2);
    public static final NetworkTransport UNKNOWN = new NetworkTransport(FailStage.UNKNOWN, 3);

    private static final /* synthetic */ NetworkTransport[] $values() {
        return new NetworkTransport[]{WIFI, CELLULAR, OTHER, UNKNOWN};
    }

    static {
        NetworkTransport[] networkTransportArr$values = $values();
        $VALUES = networkTransportArr$values;
        $ENTRIES = kotlin.enums.a.a(networkTransportArr$values);
    }

    private NetworkTransport(String str, int i10) {
    }

    public static sb.a<NetworkTransport> getEntries() {
        return $ENTRIES;
    }

    public static NetworkTransport valueOf(String str) {
        return (NetworkTransport) Enum.valueOf(NetworkTransport.class, str);
    }

    public static NetworkTransport[] values() {
        return (NetworkTransport[]) $VALUES.clone();
    }
}
