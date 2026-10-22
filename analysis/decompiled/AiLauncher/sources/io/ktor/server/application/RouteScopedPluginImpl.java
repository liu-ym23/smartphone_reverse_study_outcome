package io.ktor.server.application;

import Y8.t;
import io.ktor.server.routing.Route;
import io.ktor.server.routing.RoutingNode;
import io.ktor.server.routing.RoutingRootKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B=\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R&\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/server/application/RouteScopedPluginImpl;", "", "PluginConfigT", "Lio/ktor/server/application/RouteScopedPlugin;", "", "name", "Lkotlin/Function1;", "Lio/ktor/server/application/ApplicationCallPipeline;", "createConfiguration", "Lio/ktor/server/application/RouteScopedPluginBuilder;", "LY8/t;", "body", "<init>", "(Ljava/lang/String;Lp9/l;Lp9/l;)V", "pipeline", "configure", "Lio/ktor/server/application/PluginInstance;", W4.b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Lp9/l;)Lio/ktor/server/application/PluginInstance;", "Lp9/l;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class RouteScopedPluginImpl<PluginConfigT> implements RouteScopedPlugin<PluginConfigT> {
    private final InterfaceC5074l<RouteScopedPluginBuilder<PluginConfigT>, t> body;
    private final InterfaceC5074l<ApplicationCallPipeline, PluginConfigT> createConfiguration;
    private final AttributeKey<PluginInstance> key;

    /* JADX WARN: Multi-variable type inference failed */
    public RouteScopedPluginImpl(String name, InterfaceC5074l<? super ApplicationCallPipeline, ? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super RouteScopedPluginBuilder<PluginConfigT>, t> body) {
        InterfaceC5755n interfaceC5755nM;
        p.i(name, "name");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        this.createConfiguration = createConfiguration;
        this.body = body;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(PluginInstance.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(PluginInstance.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        this.key = new AttributeKey<>(name, new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    @Override // io.ktor.server.application.Plugin
    public AttributeKey<PluginInstance> getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.server.application.Plugin
    public PluginInstance install(ApplicationCallPipeline pipeline, InterfaceC5074l<? super PluginConfigT, t> configure) {
        Application application;
        p.i(pipeline, "pipeline");
        p.i(configure, "configure");
        if (pipeline instanceof RoutingNode) {
            application = RoutingRootKt.getApplication((Route) pipeline);
        } else {
            if (!(pipeline instanceof Application)) {
                throw new IllegalStateException(("Unsupported pipeline type: " + kotlin.jvm.internal.t.b(pipeline.getClass())).toString());
            }
            application = (Application) pipeline;
        }
        return CreatePluginUtilsKt.createRouteScopedPluginInstance(this, application, pipeline, this.body, this.createConfiguration, configure);
    }
}
