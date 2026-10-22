package io.ktor.server.application;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentType;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.config.MapApplicationConfig;
import io.ktor.server.routing.RoutingNode;
import io.ktor.util.AttributeKey;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000R\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a[\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00052\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\f\u0010\u000f\u001aM\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u0012\u0010\u0013\u001a[\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00052\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u0012\u0010\u0014\u001a5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\f\u0010\u0015\u001a5\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0010\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u0012\u0010\u0016\u001a\u008b\u0001\u0010\u001f\u001a\u00020\u001a\"\b\b\u0000\u0010\u0018*\u00020\u0017\"\b\b\u0001\u0010\u0001*\u00020\u0000*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00172\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\t0\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00010\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u008b\u0001\u0010!\u001a\u00020\u001a\"\b\b\u0000\u0010\u0018*\u00020\u0017\"\b\b\u0001\u0010\u0001*\u00020\u0000*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00172\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0004\u0012\u00020\t0\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00010\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\u0005H\u0002¢\u0006\u0004\b!\u0010 \u001aA\u0010$\u001a\u00020\t\"\b\b\u0000\u0010\"*\u00020\u0000\"\u000e\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u00000\b*\u00028\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\u0005H\u0002¢\u0006\u0004\b$\u0010%\u001a9\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010&*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"", "PluginConfigT", "", "name", "configurationPath", "Lkotlin/Function1;", "Lio/ktor/server/config/ApplicationConfig;", "createConfiguration", "Lio/ktor/server/application/PluginBuilder;", "LY8/t;", "body", "Lio/ktor/server/application/ApplicationPlugin;", "createApplicationPlugin", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/l;)Lio/ktor/server/application/ApplicationPlugin;", "Lkotlin/Function0;", "(Ljava/lang/String;Lp9/a;Lp9/l;)Lio/ktor/server/application/ApplicationPlugin;", "Lio/ktor/server/application/RouteScopedPluginBuilder;", "Lio/ktor/server/application/RouteScopedPlugin;", "createRouteScopedPlugin", "(Ljava/lang/String;Lp9/a;Lp9/l;)Lio/ktor/server/application/RouteScopedPlugin;", "(Ljava/lang/String;Ljava/lang/String;Lp9/l;Lp9/l;)Lio/ktor/server/application/RouteScopedPlugin;", "(Ljava/lang/String;Lp9/l;)Lio/ktor/server/application/ApplicationPlugin;", "(Ljava/lang/String;Lp9/l;)Lio/ktor/server/application/RouteScopedPlugin;", "Lio/ktor/server/application/ApplicationCallPipeline;", "PipelineT", "Lio/ktor/server/application/Plugin;", "Lio/ktor/server/application/PluginInstance;", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "pipeline", "configure", "createPluginInstance", "(Lio/ktor/server/application/Plugin;Lio/ktor/server/application/Application;Lio/ktor/server/application/ApplicationCallPipeline;Lp9/l;Lp9/l;Lp9/l;)Lio/ktor/server/application/PluginInstance;", "createRouteScopedPluginInstance", "Configuration", "Builder", "setupPlugin", "(Lio/ktor/server/application/PluginBuilder;Lp9/l;)V", ExifInterface.GPS_DIRECTION_TRUE, "path", "withConfig", "(Lp9/l;Ljava/lang/String;)Lp9/l;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreatePluginUtilsKt {
    public static final <PluginConfigT> ApplicationPlugin<PluginConfigT> createApplicationPlugin(String name, String configurationPath, InterfaceC5074l<? super ApplicationConfig, ? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super PluginBuilder<PluginConfigT>, t> body) {
        p.i(name, "name");
        p.i(configurationPath, "configurationPath");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        return new ApplicationPluginImpl(name, withConfig(createConfiguration, configurationPath), body);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createApplicationPlugin$lambda$0(InterfaceC5063a interfaceC5063a, ApplicationCallPipeline ApplicationPluginImpl) {
        p.i(ApplicationPluginImpl, "$this$ApplicationPluginImpl");
        return interfaceC5063a.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <PipelineT extends ApplicationCallPipeline, PluginConfigT> PluginInstance createPluginInstance(Plugin<? super PipelineT, ? extends PluginConfigT, PluginInstance> plugin, final Application application, final ApplicationCallPipeline applicationCallPipeline, InterfaceC5074l<? super PluginBuilder<PluginConfigT>, t> interfaceC5074l, InterfaceC5074l<? super ApplicationCallPipeline, ? extends PluginConfigT> interfaceC5074l2, InterfaceC5074l<? super PluginConfigT, t> interfaceC5074l3) {
        final PluginConfigT pluginconfigtInvoke = interfaceC5074l2.invoke(applicationCallPipeline);
        interfaceC5074l3.invoke(pluginconfigtInvoke);
        final AttributeKey<PluginInstance> key = plugin.getKey();
        PluginBuilder<PluginConfigT> pluginBuilder = new PluginBuilder<PluginConfigT>(application, applicationCallPipeline, pluginconfigtInvoke, key) { // from class: io.ktor.server.application.CreatePluginUtilsKt$createPluginInstance$pluginBuilder$1
            private final Application application;
            private final ApplicationCallPipeline pipeline;
            private final PluginConfigT pluginConfig;

            {
                super(key);
                this.application = application;
                this.pipeline = applicationCallPipeline;
                this.pluginConfig = pluginconfigtInvoke;
            }

            @Override // io.ktor.server.application.PluginBuilder
            public Application getApplication() {
                return this.application;
            }

            @Override // io.ktor.server.application.PluginBuilder
            /* renamed from: getPipeline$ktor_server_core, reason: from getter */
            public ApplicationCallPipeline getPipeline() {
                return this.pipeline;
            }

            @Override // io.ktor.server.application.PluginBuilder
            public PluginConfigT getPluginConfig() {
                return this.pluginConfig;
            }
        };
        setupPlugin(pluginBuilder, interfaceC5074l);
        return new PluginInstance(pluginBuilder);
    }

    public static final <PluginConfigT> RouteScopedPlugin<PluginConfigT> createRouteScopedPlugin(String name, final InterfaceC5063a<? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super RouteScopedPluginBuilder<PluginConfigT>, t> body) {
        p.i(name, "name");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        return new RouteScopedPluginImpl(name, new InterfaceC5074l() { // from class: io.ktor.server.application.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CreatePluginUtilsKt.createRouteScopedPlugin$lambda$1(createConfiguration, (ApplicationCallPipeline) obj);
            }
        }, body);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createRouteScopedPlugin$lambda$1(InterfaceC5063a interfaceC5063a, ApplicationCallPipeline RouteScopedPluginImpl) {
        p.i(RouteScopedPluginImpl, "$this$RouteScopedPluginImpl");
        return interfaceC5063a.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <PipelineT extends ApplicationCallPipeline, PluginConfigT> PluginInstance createRouteScopedPluginInstance(Plugin<? super PipelineT, ? extends PluginConfigT, PluginInstance> plugin, final Application application, final ApplicationCallPipeline applicationCallPipeline, InterfaceC5074l<? super RouteScopedPluginBuilder<PluginConfigT>, t> interfaceC5074l, InterfaceC5074l<? super ApplicationCallPipeline, ? extends PluginConfigT> interfaceC5074l2, InterfaceC5074l<? super PluginConfigT, t> interfaceC5074l3) {
        final PluginConfigT pluginconfigtInvoke = interfaceC5074l2.invoke(applicationCallPipeline);
        interfaceC5074l3.invoke(pluginconfigtInvoke);
        final AttributeKey<PluginInstance> key = plugin.getKey();
        RouteScopedPluginBuilder<PluginConfigT> routeScopedPluginBuilder = new RouteScopedPluginBuilder<PluginConfigT>(application, applicationCallPipeline, pluginconfigtInvoke, key) { // from class: io.ktor.server.application.CreatePluginUtilsKt$createRouteScopedPluginInstance$pluginBuilder$1
            private final Application application;
            private final ApplicationCallPipeline pipeline;
            private final PluginConfigT pluginConfig;
            private final RoutingNode route;

            {
                super(key);
                this.application = application;
                this.pipeline = applicationCallPipeline;
                this.pluginConfig = pluginconfigtInvoke;
                this.route = applicationCallPipeline instanceof RoutingNode ? (RoutingNode) applicationCallPipeline : null;
            }

            @Override // io.ktor.server.application.PluginBuilder
            public Application getApplication() {
                return this.application;
            }

            @Override // io.ktor.server.application.PluginBuilder
            /* renamed from: getPipeline$ktor_server_core, reason: from getter */
            public ApplicationCallPipeline getPipeline() {
                return this.pipeline;
            }

            @Override // io.ktor.server.application.PluginBuilder
            public PluginConfigT getPluginConfig() {
                return this.pluginConfig;
            }

            @Override // io.ktor.server.application.RouteScopedPluginBuilder
            public RoutingNode getRoute() {
                return this.route;
            }
        };
        setupPlugin(routeScopedPluginBuilder, interfaceC5074l);
        return new PluginInstance(routeScopedPluginBuilder);
    }

    private static final <Configuration, Builder extends PluginBuilder<Configuration>> void setupPlugin(Builder builder, InterfaceC5074l<? super Builder, t> interfaceC5074l) {
        interfaceC5074l.invoke(builder);
        Iterator<T> it = builder.getCallInterceptions$ktor_server_core().iterator();
        while (it.hasNext()) {
            ((Interception) it.next()).getAction().invoke(builder.getPipeline());
        }
        Iterator<T> it2 = builder.getOnReceiveInterceptions$ktor_server_core().iterator();
        while (it2.hasNext()) {
            ((Interception) it2.next()).getAction().invoke(builder.getPipeline().getReceivePipeline());
        }
        Iterator<T> it3 = builder.getOnResponseInterceptions$ktor_server_core().iterator();
        while (it3.hasNext()) {
            ((Interception) it3.next()).getAction().invoke(builder.getPipeline().getSendPipeline());
        }
        Iterator<T> it4 = builder.getAfterResponseInterceptions$ktor_server_core().iterator();
        while (it4.hasNext()) {
            ((Interception) it4.next()).getAction().invoke(builder.getPipeline().getSendPipeline());
        }
        Iterator<T> it5 = builder.getHooks$ktor_server_core().iterator();
        while (it5.hasNext()) {
            ((HookHandler) it5.next()).install(builder.getPipeline());
        }
    }

    private static final <T> InterfaceC5074l<ApplicationCallPipeline, T> withConfig(final InterfaceC5074l<? super ApplicationConfig, ? extends T> interfaceC5074l, final String str) {
        return new InterfaceC5074l() { // from class: io.ktor.server.application.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CreatePluginUtilsKt.withConfig$lambda$9(str, interfaceC5074l, (ApplicationCallPipeline) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object withConfig$lambda$9(String str, InterfaceC5074l interfaceC5074l, ApplicationCallPipeline applicationCallPipeline) {
        ApplicationConfig mapApplicationConfig;
        p.i(applicationCallPipeline, "<this>");
        try {
            mapApplicationConfig = applicationCallPipeline.getEnvironment().getConfig().config(str);
        } catch (Throwable unused) {
            mapApplicationConfig = new MapApplicationConfig();
        }
        return interfaceC5074l.invoke(mapApplicationConfig);
    }

    public static final <PluginConfigT> ApplicationPlugin<PluginConfigT> createApplicationPlugin(String name, final InterfaceC5063a<? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super PluginBuilder<PluginConfigT>, t> body) {
        p.i(name, "name");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        return new ApplicationPluginImpl(name, new InterfaceC5074l() { // from class: io.ktor.server.application.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CreatePluginUtilsKt.createApplicationPlugin$lambda$0(createConfiguration, (ApplicationCallPipeline) obj);
            }
        }, body);
    }

    public static final <PluginConfigT> RouteScopedPlugin<PluginConfigT> createRouteScopedPlugin(String name, String configurationPath, InterfaceC5074l<? super ApplicationConfig, ? extends PluginConfigT> createConfiguration, InterfaceC5074l<? super RouteScopedPluginBuilder<PluginConfigT>, t> body) {
        p.i(name, "name");
        p.i(configurationPath, "configurationPath");
        p.i(createConfiguration, "createConfiguration");
        p.i(body, "body");
        return new RouteScopedPluginImpl(name, withConfig(createConfiguration, configurationPath), body);
    }

    public static final ApplicationPlugin<t> createApplicationPlugin(String name, InterfaceC5074l<? super PluginBuilder<t>, t> body) {
        p.i(name, "name");
        p.i(body, "body");
        return createApplicationPlugin(name, new InterfaceC5063a() { // from class: io.ktor.server.application.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.f7040a;
            }
        }, body);
    }

    public static final RouteScopedPlugin<t> createRouteScopedPlugin(String name, InterfaceC5074l<? super RouteScopedPluginBuilder<t>, t> body) {
        p.i(name, "name");
        p.i(body, "body");
        return createRouteScopedPlugin(name, new InterfaceC5063a() { // from class: io.ktor.server.application.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.f7040a;
            }
        }, body);
    }
}
