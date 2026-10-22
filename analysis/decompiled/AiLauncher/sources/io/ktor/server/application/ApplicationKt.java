package io.ktor.server.application;

import Y8.t;
import io.ktor.server.engine.ApplicationEnvironmentBuilder;
import io.ktor.server.engine.ApplicationEnvironmentBuilderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0019\u0010\u000e\u001a\u00060\nj\u0002`\u000b*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lkotlin/Function1;", "Lio/ktor/server/application/ServerConfigBuilder;", "LY8/t;", "block", "Lio/ktor/server/application/ServerConfig;", "serverConfig", "(Lio/ktor/server/application/ApplicationEnvironment;Lp9/l;)Lio/ktor/server/application/ServerConfig;", "Lio/ktor/server/application/Application;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "getLog", "(Lio/ktor/server/application/Application;)Lvc/c;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationKt {
    public static final vc.c getLog(Application application) {
        p.i(application, "<this>");
        return application.getEnvironment().getLog();
    }

    public static final ServerConfig serverConfig(ApplicationEnvironment environment, InterfaceC5074l<? super ServerConfigBuilder, t> block) {
        p.i(environment, "environment");
        p.i(block, "block");
        ServerConfigBuilder serverConfigBuilder = new ServerConfigBuilder(environment);
        block.invoke(serverConfigBuilder);
        return serverConfigBuilder.build$ktor_server_core();
    }

    public static /* synthetic */ ServerConfig serverConfig$default(ApplicationEnvironment applicationEnvironment, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            applicationEnvironment = ApplicationEnvironmentBuilderKt.applicationEnvironment(new InterfaceC5074l() { // from class: io.ktor.server.application.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationKt.serverConfig$lambda$0((ApplicationEnvironmentBuilder) obj2);
                }
            });
        }
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.application.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationKt.serverConfig$lambda$1((ServerConfigBuilder) obj2);
                }
            };
        }
        return serverConfig(applicationEnvironment, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t serverConfig$lambda$0(ApplicationEnvironmentBuilder applicationEnvironment) {
        p.i(applicationEnvironment, "$this$applicationEnvironment");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t serverConfig$lambda$1(ServerConfigBuilder serverConfigBuilder) {
        p.i(serverConfigBuilder, "<this>");
        return t.f7040a;
    }
}
