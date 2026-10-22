package com.alibaba.fastjson.support.jaxrs;

import javax.annotation.Priority;
import javax.ws.rs.core.FeatureContext;
import org.glassfish.jersey.internal.spi.AutoDiscoverable;

/* JADX INFO: loaded from: classes28.dex */
@Priority(1999)
public class FastJsonAutoDiscoverable implements AutoDiscoverable {
    public static final String FASTJSON_AUTO_DISCOVERABLE = "fastjson.auto.discoverable";
    public static volatile boolean autoDiscover = true;

    public FastJsonAutoDiscoverable() {
    }

    static {
        autoDiscover = Boolean.parseBoolean(System.getProperty(FASTJSON_AUTO_DISCOVERABLE, String.valueOf(autoDiscover)));     // Catch: Throwable -> L4
        return;
    }

    public void configure(FeatureContext r100) {
        if (r100.getConfiguration().isRegistered(FastJsonFeature.class) == false) goto L5;
        return;
    L5:
        if (autoDiscover == false) goto L9;
        r100.register(FastJsonFeature.class);
        return;
    }
}
