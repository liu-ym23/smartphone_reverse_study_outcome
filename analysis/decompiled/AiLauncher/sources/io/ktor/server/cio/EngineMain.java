package io.ktor.server.cio;

import Y8.t;
import io.ktor.server.cio.CIOApplicationEngine;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.server.engine.CommandLineConfig;
import io.ktor.server.engine.CommandLineKt;
import io.ktor.server.engine.EmbeddedServer;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u0007*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/server/cio/EngineMain;", "", "<init>", "()V", "", "", "args", "LY8/t;", "main", "([Ljava/lang/String;)V", "Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "Lio/ktor/server/config/ApplicationConfig;", "config", "loadConfiguration", "(Lio/ktor/server/cio/CIOApplicationEngine$Configuration;Lio/ktor/server/config/ApplicationConfig;)V", "Lio/ktor/server/engine/EmbeddedServer;", "Lio/ktor/server/cio/CIOApplicationEngine;", "createServer", "([Ljava/lang/String;)Lio/ktor/server/engine/EmbeddedServer;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EngineMain {
    public static final EngineMain INSTANCE = new EngineMain();

    private EngineMain() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t createServer$lambda$0(CommandLineConfig commandLineConfig, CIOApplicationEngine.Configuration EmbeddedServer) {
        p.i(EmbeddedServer, "$this$EmbeddedServer");
        EmbeddedServer.takeFrom(commandLineConfig.getEngineConfig());
        INSTANCE.loadConfiguration(EmbeddedServer, commandLineConfig.getRootConfig().getEnvironment().getConfig());
        return t.f7040a;
    }

    private final void loadConfiguration(CIOApplicationEngine.Configuration configuration, ApplicationConfig applicationConfig) {
        String string;
        ApplicationConfig applicationConfigConfig = applicationConfig.config("ktor.deployment");
        CommandLineKt.loadCommonConfiguration(configuration, applicationConfigConfig);
        ApplicationConfigValue applicationConfigValuePropertyOrNull = applicationConfigConfig.propertyOrNull("connectionIdleTimeoutSeconds");
        if (applicationConfigValuePropertyOrNull == null || (string = applicationConfigValuePropertyOrNull.getString()) == null) {
            return;
        }
        configuration.setConnectionIdleTimeoutSeconds(Integer.parseInt(string));
    }

    public static final void main(String[] args) {
        p.i(args, "args");
        INSTANCE.createServer(args).start(true);
    }

    public final EmbeddedServer<CIOApplicationEngine, CIOApplicationEngine.Configuration> createServer(String[] args) {
        p.i(args, "args");
        final CommandLineConfig CommandLineConfig = CommandLineKt.CommandLineConfig(args);
        return new EmbeddedServer<>(CommandLineConfig.getRootConfig(), CIO.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.server.cio.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EngineMain.createServer$lambda$0(CommandLineConfig, (CIOApplicationEngine.Configuration) obj);
            }
        });
    }
}
