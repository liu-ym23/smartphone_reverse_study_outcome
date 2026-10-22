package io.ktor.server.routing;

import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationPluginKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/ktor/server/application/Application;", "Lio/ktor/server/routing/RoutingNode;", "getRoutingRoot", "(Lio/ktor/server/application/Application;)Lio/ktor/server/routing/RoutingNode;", "routingRoot", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingIntrospectionKt {
    public static final RoutingNode getRoutingRoot(Application application) {
        kotlin.jvm.internal.p.i(application, "<this>");
        RoutingRoot routingRoot = (RoutingRoot) ApplicationPluginKt.pluginOrNull(application, RoutingRoot.INSTANCE);
        if (routingRoot != null) {
            return routingRoot;
        }
        throw new IllegalStateException("Routing plugin is not installed");
    }
}
