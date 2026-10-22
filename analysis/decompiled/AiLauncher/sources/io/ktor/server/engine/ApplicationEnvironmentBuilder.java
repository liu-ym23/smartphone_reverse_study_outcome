package io.ktor.server.engine;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.config.MapApplicationConfig;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;

@KtorDsl
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/server/engine/ApplicationEnvironmentBuilder;", "", "<init>", "()V", "Lio/ktor/server/application/ApplicationEnvironment;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lio/ktor/server/application/ApplicationEnvironment;", "Ljava/lang/ClassLoader;", "classLoader", "Ljava/lang/ClassLoader;", "getClassLoader", "()Ljava/lang/ClassLoader;", "setClassLoader", "(Ljava/lang/ClassLoader;)V", "Lvc/c;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "Lvc/c;", "getLog", "()Lvc/c;", "setLog", "(Lvc/c;)V", "Lio/ktor/server/config/ApplicationConfig;", "config", "Lio/ktor/server/config/ApplicationConfig;", "getConfig", "()Lio/ktor/server/config/ApplicationConfig;", "setConfig", "(Lio/ktor/server/config/ApplicationConfig;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationEnvironmentBuilder {
    private ClassLoader classLoader;
    private ApplicationConfig config;
    private vc.c log;

    public ApplicationEnvironmentBuilder() {
        ClassLoader classLoader = ApplicationEnvironmentBuilder.class.getClassLoader();
        kotlin.jvm.internal.p.h(classLoader, "getClassLoader(...)");
        this.classLoader = classLoader;
        vc.c cVarM = vc.e.m("io.ktor.server.Application");
        kotlin.jvm.internal.p.h(cVarM, "getLogger(...)");
        this.log = cVarM;
        this.config = new MapApplicationConfig();
    }

    public final ApplicationEnvironment build() {
        return new ApplicationEnvironmentImplJvm(this.classLoader, this.log, this.config, null, 8, null);
    }

    public final ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public final ApplicationConfig getConfig() {
        return this.config;
    }

    public final vc.c getLog() {
        return this.log;
    }

    public final void setClassLoader(ClassLoader classLoader) {
        kotlin.jvm.internal.p.i(classLoader, "<set-?>");
        this.classLoader = classLoader;
    }

    public final void setConfig(ApplicationConfig applicationConfig) {
        kotlin.jvm.internal.p.i(applicationConfig, "<set-?>");
        this.config = applicationConfig;
    }

    public final void setLog(vc.c cVar) {
        kotlin.jvm.internal.p.i(cVar, "<set-?>");
        this.log = cVar;
    }
}
