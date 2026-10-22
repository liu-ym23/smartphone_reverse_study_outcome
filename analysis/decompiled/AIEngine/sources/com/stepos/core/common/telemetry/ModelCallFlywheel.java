package com.stepos.core.common.telemetry;

import android.content.Context;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelCallFlywheel {
    public static final ModelCallFlywheel INSTANCE = new ModelCallFlywheel();
    private static volatile boolean initialized;

    private ModelCallFlywheel() {
    }

    public final void init(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
            kotlin.jvm.internal.g.c(applicationContext);
            AgentCacheSdk.init$default(agentCacheSdk, applicationContext, null, null, 6, null);
            ModelCallUpload.INSTANCE.install(AgentCacheModelCallUploader.INSTANCE);
            initialized = true;
            n nVar = n.f10413a;
        }
    }
}
