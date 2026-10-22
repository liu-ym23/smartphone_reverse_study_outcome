package io.ktor.server.engine;

import io.ktor.events.Events;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.config.ApplicationConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\u00020\b8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/server/engine/ApplicationEnvironmentImplJvm;", "Lio/ktor/server/application/ApplicationEnvironment;", "Ljava/lang/ClassLoader;", "classLoader", "Lvc/c;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "Lio/ktor/server/config/ApplicationConfig;", "config", "Lio/ktor/events/Events;", "monitor", "<init>", "(Ljava/lang/ClassLoader;Lvc/c;Lio/ktor/server/config/ApplicationConfig;Lio/ktor/events/Events;)V", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "Lvc/c;", "getLog", "()Lvc/c;", "Lio/ktor/server/config/ApplicationConfig;", "getConfig", "()Lio/ktor/server/config/ApplicationConfig;", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "getMonitor$annotations", "()V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationEnvironmentImplJvm implements ApplicationEnvironment {
    private final ClassLoader classLoader;
    private final ApplicationConfig config;
    private final vc.c log;
    private final Events monitor;

    public ApplicationEnvironmentImplJvm(ClassLoader classLoader, vc.c log, ApplicationConfig config, Events monitor) {
        kotlin.jvm.internal.p.i(classLoader, "classLoader");
        kotlin.jvm.internal.p.i(log, "log");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(monitor, "monitor");
        this.classLoader = classLoader;
        this.log = log;
        this.config = config;
        this.monitor = monitor;
    }

    public static /* synthetic */ void getMonitor$annotations() {
    }

    @Override // io.ktor.server.application.ApplicationEnvironment
    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    @Override // io.ktor.server.application.ApplicationEnvironment
    public ApplicationConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.server.application.ApplicationEnvironment
    public vc.c getLog() {
        return this.log;
    }

    @Override // io.ktor.server.application.ApplicationEnvironment
    public Events getMonitor() {
        return this.monitor;
    }

    public /* synthetic */ ApplicationEnvironmentImplJvm(ClassLoader classLoader, vc.c cVar, ApplicationConfig applicationConfig, Events events, int i10, kotlin.jvm.internal.i iVar) {
        this(classLoader, cVar, applicationConfig, (i10 & 8) != 0 ? new Events() : events);
    }
}
