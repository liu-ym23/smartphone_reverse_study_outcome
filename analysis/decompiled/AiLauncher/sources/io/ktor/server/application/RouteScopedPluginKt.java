package io.ktor.server.application;

import io.ktor.server.routing.RoutingNode;
import io.ktor.server.routing.RoutingRoot;
import io.ktor.server.routing.RoutingRootKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0014\u0010\u0004\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "F", "Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/server/application/Plugin;", "plugin", "findPluginInRoute", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/server/application/Plugin;)Ljava/lang/Object;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RouteScopedPluginKt {
    public static final <F> F findPluginInRoute(RoutingNode routingNode, Plugin<?, ?, F> plugin) {
        p.i(routingNode, "<this>");
        p.i(plugin, "plugin");
        RoutingNode parent = routingNode;
        while (true) {
            F f10 = (F) ApplicationPluginKt.pluginOrNull(parent, plugin);
            if (f10 != null) {
                return f10;
            }
            if (parent.getParent() == null) {
                if (parent instanceof RoutingRoot) {
                    return (F) ApplicationPluginKt.pluginOrNull(RoutingRootKt.getApplication(routingNode), plugin);
                }
                return null;
            }
            parent = parent.getParent();
            p.f(parent);
        }
    }
}
