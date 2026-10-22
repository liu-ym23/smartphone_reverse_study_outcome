package io.ktor.server.engine;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import e9.InterfaceC4014c;
import io.ktor.events.Events;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.DefaultApplicationEventsKt;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.BaseApplicationResponse;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.pipeline.InvalidPhaseException;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00198\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lio/ktor/server/engine/BaseApplicationEngine;", "Lio/ktor/server/engine/ApplicationEngine;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/events/Events;", "monitor", "", "developmentMode", "Lio/ktor/server/engine/EnginePipeline;", "pipeline", "<init>", "(Lio/ktor/server/application/ApplicationEnvironment;Lio/ktor/events/Events;ZLio/ktor/server/engine/EnginePipeline;)V", "", "Lio/ktor/server/engine/EngineConnectorConfig;", "resolvedConnectors", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "Lio/ktor/server/engine/EnginePipeline;", "getPipeline", "()Lio/ktor/server/engine/EnginePipeline;", "LUa/u;", "resolvedConnectorsDeferred", "LUa/u;", "getResolvedConnectorsDeferred", "()LUa/u;", "Configuration", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseApplicationEngine implements ApplicationEngine {
    private final ApplicationEnvironment environment;
    private final Events monitor;
    private final EnginePipeline pipeline;
    private final InterfaceC1083u<List<EngineConnectorConfig>> resolvedConnectorsDeferred;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/server/engine/BaseApplicationEngine$Configuration;", "Lio/ktor/server/engine/ApplicationEngine$Configuration;", "<init>", "()V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Configuration extends ApplicationEngine.Configuration {
    }

    public BaseApplicationEngine(final ApplicationEnvironment environment, Events monitor, boolean z10, final EnginePipeline pipeline) {
        kotlin.jvm.internal.p.i(environment, "environment");
        kotlin.jvm.internal.p.i(monitor, "monitor");
        kotlin.jvm.internal.p.i(pipeline, "pipeline");
        this.environment = environment;
        this.monitor = monitor;
        this.pipeline = pipeline;
        this.resolvedConnectorsDeferred = C1087w.c(null, 1, null);
        final StartupInfo startupInfo = new StartupInfo();
        BaseApplicationResponse.Companion companion = BaseApplicationResponse.INSTANCE;
        companion.setupSendPipeline(pipeline.getSendPipeline());
        companion.setupFallbackResponse$ktor_server_core(pipeline, environment.getLog());
        monitor.subscribe(DefaultApplicationEventsKt.getApplicationStarting(), new InterfaceC5074l() { // from class: io.ktor.server.engine.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BaseApplicationEngine._init_$lambda$0(startupInfo, pipeline, (Application) obj);
            }
        });
        monitor.subscribe(DefaultApplicationEventsKt.getApplicationStarted(), new InterfaceC5074l() { // from class: io.ktor.server.engine.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BaseApplicationEngine._init_$lambda$1(startupInfo, environment, (Application) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$0(StartupInfo startupInfo, EnginePipeline enginePipeline, Application it) throws InvalidPhaseException {
        kotlin.jvm.internal.p.i(it, "it");
        if (!startupInfo.getIsFirstLoading()) {
            startupInfo.setInitializedStartAt(DateJvmKt.getTimeMillis());
        }
        it.getReceivePipeline().merge(enginePipeline.getReceivePipeline());
        it.getSendPipeline().merge(enginePipeline.getSendPipeline());
        DefaultTransformKt.installDefaultTransformations(it.getReceivePipeline());
        DefaultTransformKt.installDefaultTransformations(it.getSendPipeline());
        BaseApplicationEngineKt.installDefaultInterceptors(it);
        BaseApplicationEngineKt.installDefaultTransformationChecker(it);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$1(StartupInfo startupInfo, ApplicationEnvironment applicationEnvironment, Application it) {
        kotlin.jvm.internal.p.i(it, "it");
        double timeMillis = (DateJvmKt.getTimeMillis() - startupInfo.getInitializedStartAt()) / 1000.0d;
        if (startupInfo.getIsFirstLoading()) {
            applicationEnvironment.getLog().info("Application started in " + timeMillis + " seconds.");
            startupInfo.setFirstLoading(false);
        } else {
            applicationEnvironment.getLog().info("Application auto-reloaded in " + timeMillis + " seconds.");
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ Object resolvedConnectors$suspendImpl(BaseApplicationEngine baseApplicationEngine, InterfaceC4014c<? super List<? extends EngineConnectorConfig>> interfaceC4014c) {
        return baseApplicationEngine.resolvedConnectorsDeferred.a1(interfaceC4014c);
    }

    @Override // io.ktor.server.engine.ApplicationEngine
    public final ApplicationEnvironment getEnvironment() {
        return this.environment;
    }

    public final Events getMonitor() {
        return this.monitor;
    }

    public final EnginePipeline getPipeline() {
        return this.pipeline;
    }

    public final InterfaceC1083u<List<EngineConnectorConfig>> getResolvedConnectorsDeferred() {
        return this.resolvedConnectorsDeferred;
    }

    @Override // io.ktor.server.engine.ApplicationEngine
    public Object resolvedConnectors(InterfaceC4014c<? super List<? extends EngineConnectorConfig>> interfaceC4014c) {
        return resolvedConnectors$suspendImpl(this, interfaceC4014c);
    }

    @Override // io.ktor.server.engine.ApplicationEngine
    public Object startSuspend(boolean z10, InterfaceC4014c<? super ApplicationEngine> interfaceC4014c) {
        return ApplicationEngine.DefaultImpls.startSuspend(this, z10, interfaceC4014c);
    }

    @Override // io.ktor.server.engine.ApplicationEngine
    public Object stopSuspend(long j10, long j11, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ApplicationEngine.DefaultImpls.stopSuspend(this, j10, j11, interfaceC4014c);
    }

    public /* synthetic */ BaseApplicationEngine(ApplicationEnvironment applicationEnvironment, Events events, boolean z10, EnginePipeline enginePipeline, int i10, kotlin.jvm.internal.i iVar) {
        this(applicationEnvironment, events, z10, (i10 & 8) != 0 ? DefaultEnginePipelineKt.defaultEnginePipeline(applicationEnvironment.getConfig(), z10) : enginePipeline);
    }
}
