package io.ktor.server.engine;

import io.ktor.events.Events;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.ApplicationEngine.Configuration;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005J#\u0010\t\u001a\u00028\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ=\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/server/engine/ApplicationEngineFactory;", "Lio/ktor/server/engine/ApplicationEngine;", "TEngine", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "TConfiguration", "", "Lkotlin/Function1;", "LY8/t;", "configure", "configuration", "(Lp9/l;)Lio/ktor/server/engine/ApplicationEngine$Configuration;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/events/Events;", "monitor", "", "developmentMode", "Lkotlin/Function0;", "Lio/ktor/server/application/Application;", "applicationProvider", "create", "(Lio/ktor/server/application/ApplicationEnvironment;Lio/ktor/events/Events;ZLio/ktor/server/engine/ApplicationEngine$Configuration;Lp9/a;)Lio/ktor/server/engine/ApplicationEngine;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ApplicationEngineFactory<TEngine extends ApplicationEngine, TConfiguration extends ApplicationEngine.Configuration> {
    TConfiguration configuration(InterfaceC5074l<? super TConfiguration, Y8.t> configure);

    TEngine create(ApplicationEnvironment environment, Events monitor, boolean developmentMode, TConfiguration configuration, InterfaceC5063a<Application> applicationProvider);
}
