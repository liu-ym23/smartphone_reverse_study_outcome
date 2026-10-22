package com.stepos.core.common.cloud;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConfigBootstrap {
    public static final CloudConfigBootstrap INSTANCE = new CloudConfigBootstrap();
    private static volatile CloudTransportConfig config = new CloudTransportConfig(null, null, null, null, 15, null);

    private CloudConfigBootstrap() {
    }

    public final CloudTransportConfig get() {
        return config;
    }

    public final void setup(CloudTransportConfig cfg) {
        kotlin.jvm.internal.g.f(cfg, "cfg");
        config = cfg;
    }
}
