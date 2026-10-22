package io.ktor.server.cio;

import Y8.t;
import io.ktor.events.Events;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.cio.CIOApplicationEngine;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.ApplicationEngineFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ=\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/server/cio/CIO;", "Lio/ktor/server/engine/ApplicationEngineFactory;", "Lio/ktor/server/cio/CIOApplicationEngine;", "Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "<init>", "()V", "Lkotlin/Function1;", "LY8/t;", "configure", "configuration", "(Lp9/l;)Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/events/Events;", "monitor", "", "developmentMode", "Lkotlin/Function0;", "Lio/ktor/server/application/Application;", "applicationProvider", "create", "(Lio/ktor/server/application/ApplicationEnvironment;Lio/ktor/events/Events;ZLio/ktor/server/cio/CIOApplicationEngine$Configuration;Lp9/a;)Lio/ktor/server/cio/CIOApplicationEngine;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIO implements ApplicationEngineFactory<CIOApplicationEngine, CIOApplicationEngine.Configuration> {
    public static final CIO INSTANCE = new CIO();

    private CIO() {
    }

    @Override // io.ktor.server.engine.ApplicationEngineFactory
    public /* bridge */ /* synthetic */ ApplicationEngine.Configuration configuration(InterfaceC5074l interfaceC5074l) {
        return configuration((InterfaceC5074l<? super CIOApplicationEngine.Configuration, t>) interfaceC5074l);
    }

    @Override // io.ktor.server.engine.ApplicationEngineFactory
    public /* bridge */ /* synthetic */ ApplicationEngine create(ApplicationEnvironment applicationEnvironment, Events events, boolean z10, ApplicationEngine.Configuration configuration, InterfaceC5063a interfaceC5063a) {
        return create(applicationEnvironment, events, z10, (CIOApplicationEngine.Configuration) configuration, (InterfaceC5063a<Application>) interfaceC5063a);
    }

    @Override // io.ktor.server.engine.ApplicationEngineFactory
    public CIOApplicationEngine.Configuration configuration(InterfaceC5074l<? super CIOApplicationEngine.Configuration, t> configure) {
        p.i(configure, "configure");
        CIOApplicationEngine.Configuration configuration = new CIOApplicationEngine.Configuration();
        configure.invoke(configuration);
        return configuration;
    }

    public CIOApplicationEngine create(ApplicationEnvironment environment, Events monitor, boolean developmentMode, CIOApplicationEngine.Configuration configuration, InterfaceC5063a<Application> applicationProvider) {
        p.i(environment, "environment");
        p.i(monitor, "monitor");
        p.i(configuration, "configuration");
        p.i(applicationProvider, "applicationProvider");
        return new CIOApplicationEngine(environment, monitor, developmentMode, configuration, applicationProvider);
    }
}
