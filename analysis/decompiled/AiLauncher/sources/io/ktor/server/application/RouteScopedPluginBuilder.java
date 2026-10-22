package io.ktor.server.application;

import io.ktor.server.routing.RoutingNode;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lio/ktor/server/application/RouteScopedPluginBuilder;", "", "PluginConfig", "Lio/ktor/server/application/PluginBuilder;", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/application/PluginInstance;", "key", "<init>", "(Lio/ktor/util/AttributeKey;)V", "Lio/ktor/server/routing/RoutingNode;", "getRoute", "()Lio/ktor/server/routing/RoutingNode;", M5.a.CARD_TYPE_ROUTE, "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RouteScopedPluginBuilder<PluginConfig> extends PluginBuilder<PluginConfig> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteScopedPluginBuilder(AttributeKey<PluginInstance> key) {
        super(key);
        p.i(key, "key");
    }

    public abstract RoutingNode getRoute();
}
