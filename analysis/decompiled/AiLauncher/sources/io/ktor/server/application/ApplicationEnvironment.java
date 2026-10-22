package io.ktor.server.application;

import io.ktor.events.Events;
import io.ktor.server.config.ApplicationConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/ktor/server/application/ApplicationEnvironment;", "", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "classLoader", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "getLog", "()Lvc/c;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "Lio/ktor/server/config/ApplicationConfig;", "getConfig", "()Lio/ktor/server/config/ApplicationConfig;", "config", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "getMonitor$annotations", "()V", "monitor", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ApplicationEnvironment {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getMonitor$annotations() {
        }
    }

    ClassLoader getClassLoader();

    ApplicationConfig getConfig();

    vc.c getLog();

    Events getMonitor();
}
