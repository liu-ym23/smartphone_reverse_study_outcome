package io.ktor.server.engine;

import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.ServerConfig;
import io.ktor.server.engine.BaseApplicationEngine;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/server/engine/CommandLineConfig;", "", "Lio/ktor/server/application/ServerConfig;", "rootConfig", "Lio/ktor/server/engine/BaseApplicationEngine$Configuration;", "engineConfig", "<init>", "(Lio/ktor/server/application/ServerConfig;Lio/ktor/server/engine/BaseApplicationEngine$Configuration;)V", "Lio/ktor/server/application/ServerConfig;", "getRootConfig", "()Lio/ktor/server/application/ServerConfig;", "Lio/ktor/server/engine/BaseApplicationEngine$Configuration;", "getEngineConfig", "()Lio/ktor/server/engine/BaseApplicationEngine$Configuration;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommandLineConfig {
    private final BaseApplicationEngine.Configuration engineConfig;
    private final ApplicationEnvironment environment;
    private final ServerConfig rootConfig;

    public CommandLineConfig(ServerConfig rootConfig, BaseApplicationEngine.Configuration engineConfig) {
        kotlin.jvm.internal.p.i(rootConfig, "rootConfig");
        kotlin.jvm.internal.p.i(engineConfig, "engineConfig");
        this.rootConfig = rootConfig;
        this.engineConfig = engineConfig;
        this.environment = rootConfig.getEnvironment();
    }

    public final BaseApplicationEngine.Configuration getEngineConfig() {
        return this.engineConfig;
    }

    public final ApplicationEnvironment getEnvironment() {
        return this.environment;
    }

    public final ServerConfig getRootConfig() {
        return this.rootConfig;
    }
}
