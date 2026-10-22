package io.ktor.server.application;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.server.routing.RoutingNode;
import io.ktor.server.routing.RoutingRoot;
import io.ktor.server.routing.RoutingRootKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.q;
import s.C5423E;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aE\u0010\u0006\u001a\u00028\u0001\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00028\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001aG\u0010\b\u001a\u0004\u0018\u00018\u0001\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00028\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\b\u0010\u0007\u001ai\u0010\u000e\u001a\u00028\u0002\"\u0012\b\u0000\u0010\t*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\n*\u00020\u0003\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001aQ\u0010\u0012\u001a\u00028\u0001\"\b\b\u0000\u0010\n*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001am\u0010\u0018\u001a\u00020\f\"\b\b\u0000\u0010\n*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\u0004\b\u0002\u0010\u0014\"\u0004\b\u0003\u0010\u0015\"\u0014\b\u0004\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000*\u00028\u00042\u0006\u0010\u0016\u001a\u00028\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0017\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001aa\u0010\u000e\u001a\u00028\u0002\"\b\b\u0000\u0010\t*\u00020\u0010\"\b\b\u0001\u0010\n*\u00020\u0003\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001a2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\f\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000*\u00028\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aU\u0010\u001e\u001a\u00020\f\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\n*\u00020\u0003\"\b\b\u0002\u0010\u0004*\u00020\u0003*\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a?\u0010\"\u001a\u00020\f\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00028\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0007¢\u0006\u0004\b\"\u0010#\" \u0010%\u001a\b\u0012\u0004\u0012\u00020$0 8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\")\u0010+\u001a\u00020$\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010\u0000*\u00028\u00008F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lio/ktor/util/pipeline/Pipeline;", "Lio/ktor/server/application/PipelineCall;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "F", "Lio/ktor/server/application/Plugin;", "plugin", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/server/application/Plugin;)Ljava/lang/Object;", "pluginOrNull", "P", "B", "Lkotlin/Function1;", "LY8/t;", "configure", W4.b.STEP_INSTALL, "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/server/application/Plugin;Lp9/l;)Ljava/lang/Object;", "Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/server/application/BaseRouteScopedPlugin;", "installIntoRoute", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/server/application/BaseRouteScopedPlugin;Lp9/l;)Ljava/lang/Object;", "TSubject", "TContext", "fakePipeline", "pluginInstance", "addAllInterceptors", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/Pipeline;Lio/ktor/server/application/BaseRouteScopedPlugin;Ljava/lang/Object;)V", "Lio/ktor/server/application/BaseApplicationPlugin;", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/server/application/BaseApplicationPlugin;Lp9/l;)Ljava/lang/Object;", "uninstallAllPlugins", "(Lio/ktor/util/pipeline/Pipeline;)V", "uninstall", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/server/application/Plugin;)V", "Lio/ktor/util/AttributeKey;", "key", "uninstallPlugin", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/AttributeKey;)V", "Lio/ktor/util/Attributes;", "pluginRegistryKey", "Lio/ktor/util/AttributeKey;", "getPluginRegistryKey", "()Lio/ktor/util/AttributeKey;", "getPluginRegistry", "(Lio/ktor/util/pipeline/Pipeline;)Lio/ktor/util/Attributes;", "pluginRegistry", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationPluginKt {
    private static final AttributeKey<Attributes> pluginRegistryKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = t.b(Attributes.class);
        try {
            interfaceC5755nM = t.m(Attributes.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        pluginRegistryKey = new AttributeKey<>("ApplicationPluginRegistry", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Attributes _get_pluginRegistry_$lambda$0() {
        return AttributesJvmKt.Attributes(true);
    }

    private static final <B, F, TSubject, TContext, P extends Pipeline<TSubject, TContext>> void addAllInterceptors(P p10, P p11, BaseRouteScopedPlugin<B, F> baseRouteScopedPlugin, F f10) {
        for (Phase phase : p10.getItems()) {
            Iterator<T> it = p11.interceptorsForPhase(phase).iterator();
            while (it.hasNext()) {
                p10.intercept(phase, new ApplicationPluginKt$addAllInterceptors$1$1$1(baseRouteScopedPlugin, f10, (q) it.next(), null));
            }
        }
    }

    public static final <A extends Pipeline<?, PipelineCall>> Attributes getPluginRegistry(A a10) {
        p.i(a10, "<this>");
        return (Attributes) a10.getAttributes().computeIfAbsent(pluginRegistryKey, new InterfaceC5063a() { // from class: io.ktor.server.application.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ApplicationPluginKt._get_pluginRegistry_$lambda$0();
            }
        });
    }

    public static final AttributeKey<Attributes> getPluginRegistryKey() {
        return pluginRegistryKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <P extends Pipeline<?, PipelineCall>, B, F> F install(P p10, Plugin<? super P, ? extends B, F> plugin, InterfaceC5074l<? super B, Y8.t> configure) {
        p.i(p10, "<this>");
        p.i(plugin, "plugin");
        p.i(configure, "configure");
        if ((p10 instanceof RoutingNode) && (plugin instanceof BaseRouteScopedPlugin)) {
            return (F) installIntoRoute((RoutingNode) p10, (BaseRouteScopedPlugin) plugin, configure);
        }
        Attributes pluginRegistry = getPluginRegistry(p10);
        F f10 = (F) pluginRegistry.getOrNull(plugin.getKey());
        if (f10 == null) {
            F fInstall = plugin.install(p10, configure);
            pluginRegistry.put(plugin.getKey(), fInstall);
            return fInstall;
        }
        if (p.d(f10, plugin)) {
            return f10;
        }
        throw new DuplicatePluginException("Please make sure that you use unique name for the plugin and don't install it twice. Conflicting application plugin is already installed with the same key as `" + plugin.getKey().getName() + '`');
    }

    public static /* synthetic */ Object install$default(Pipeline pipeline, Plugin plugin, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.application.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationPluginKt.install$lambda$1(obj2);
                }
            };
        }
        return install(pipeline, (Plugin<? super Pipeline, ? extends B, F>) plugin, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t install$lambda$1(Object obj) {
        p.i(obj, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t install$lambda$5(Object obj) {
        p.i(obj, "<this>");
        return Y8.t.f7040a;
    }

    private static final <B, F> F installIntoRoute(RoutingNode routingNode, BaseRouteScopedPlugin<B, F> baseRouteScopedPlugin, InterfaceC5074l<? super B, Y8.t> interfaceC5074l) throws DuplicatePluginException {
        if (getPluginRegistry(routingNode).getOrNull(baseRouteScopedPlugin.getKey()) != null) {
            throw new DuplicatePluginException("Please make sure that you use unique name for the plugin and don't install it twice. Plugin `" + baseRouteScopedPlugin.getKey().getName() + "` is already installed to the pipeline " + routingNode);
        }
        if (getPluginRegistry(RoutingRootKt.getApplication(routingNode)).getOrNull(baseRouteScopedPlugin.getKey()) != null) {
            throw new DuplicatePluginException("Installing RouteScopedPlugin to application and route is not supported. Consider moving application level install to routing root.");
        }
        ApplicationCallPipeline routingRoot = routingNode instanceof RoutingRoot ? new RoutingRoot(((RoutingRoot) routingNode).getApplication()) : new RoutingNode(routingNode.getParent(), routingNode.getSelector(), routingNode.getDevelopmentMode(), routingNode.getEnvironment());
        F fInstall = baseRouteScopedPlugin.install(routingRoot, interfaceC5074l);
        getPluginRegistry(routingNode).put(baseRouteScopedPlugin.getKey(), fInstall);
        routingNode.mergePhases(routingRoot);
        routingNode.getReceivePipeline().mergePhases(routingRoot.getReceivePipeline());
        routingNode.getSendPipeline().mergePhases(routingRoot.getSendPipeline());
        addAllInterceptors(routingNode, routingRoot, baseRouteScopedPlugin, fInstall);
        addAllInterceptors(routingNode.getReceivePipeline(), routingRoot.getReceivePipeline(), baseRouteScopedPlugin, fInstall);
        addAllInterceptors(routingNode.getSendPipeline(), routingRoot.getSendPipeline(), baseRouteScopedPlugin, fInstall);
        return fInstall;
    }

    public static /* synthetic */ Object installIntoRoute$default(RoutingNode routingNode, BaseRouteScopedPlugin baseRouteScopedPlugin, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.application.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationPluginKt.installIntoRoute$lambda$2(obj2);
                }
            };
        }
        return installIntoRoute(routingNode, baseRouteScopedPlugin, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t installIntoRoute$lambda$2(Object obj) {
        p.i(obj, "<this>");
        return Y8.t.f7040a;
    }

    public static final <A extends Pipeline<?, PipelineCall>, F> F plugin(A a10, Plugin<?, ?, F> plugin) {
        p.i(a10, "<this>");
        p.i(plugin, "plugin");
        F f10 = a10 instanceof RoutingNode ? (F) RouteScopedPluginKt.findPluginInRoute((RoutingNode) a10, plugin) : (F) pluginOrNull(a10, plugin);
        if (f10 != null) {
            return f10;
        }
        throw new MissingApplicationPluginException(plugin.getKey());
    }

    public static final <A extends Pipeline<?, PipelineCall>, F> F pluginOrNull(A a10, Plugin<?, ?, F> plugin) {
        p.i(a10, "<this>");
        p.i(plugin, "plugin");
        return (F) getPluginRegistry(a10).getOrNull(plugin.getKey());
    }

    public static final <A extends Pipeline<?, PipelineCall>, B, F> void uninstall(A a10, Plugin<? super A, ? extends B, F> plugin) throws Exception {
        p.i(a10, "<this>");
        p.i(plugin, "plugin");
        uninstallPlugin(a10, plugin.getKey());
    }

    public static final <A extends Pipeline<?, PipelineCall>> void uninstallAllPlugins(A a10) {
        p.i(a10, "<this>");
        Iterator<T> it = getPluginRegistry(a10).getAllKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            p.g(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            uninstallPlugin(a10, attributeKey);
        }
    }

    public static final <A extends Pipeline<?, PipelineCall>, F> void uninstallPlugin(A a10, AttributeKey<F> key) throws Exception {
        Object orNull;
        p.i(a10, "<this>");
        p.i(key, "key");
        Attributes attributes = (Attributes) a10.getAttributes().getOrNull(pluginRegistryKey);
        if (attributes == null || (orNull = attributes.getOrNull(key)) == null) {
            return;
        }
        if (orNull instanceof AutoCloseable) {
            C5423E.a((AutoCloseable) orNull);
        }
        attributes.remove(key);
    }

    public static /* synthetic */ Object install$default(RoutingNode routingNode, BaseApplicationPlugin baseApplicationPlugin, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.application.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationPluginKt.install$lambda$5(obj2);
                }
            };
        }
        return install(routingNode, (BaseApplicationPlugin<? super RoutingNode, ? extends B, F>) baseApplicationPlugin, interfaceC5074l);
    }

    public static final <P extends RoutingNode, B, F> F install(P p10, BaseApplicationPlugin<? super P, ? extends B, F> plugin, InterfaceC5074l<? super B, Y8.t> configure) {
        p.i(p10, "<this>");
        p.i(plugin, "plugin");
        p.i(configure, "configure");
        return (F) install(p10, (Plugin<? super P, ? extends B, F>) plugin, (InterfaceC5074l) configure);
    }
}
