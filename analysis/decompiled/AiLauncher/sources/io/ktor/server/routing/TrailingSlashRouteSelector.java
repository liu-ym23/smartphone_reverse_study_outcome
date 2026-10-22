package io.ktor.server.routing;

import Z8.C1173v;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/server/routing/TrailingSlashRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "<init>", "()V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TrailingSlashRouteSelector extends RouteSelector {
    public static final TrailingSlashRouteSelector INSTANCE = new TrailingSlashRouteSelector();

    private TrailingSlashRouteSelector() {
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        return IgnoreTrailingSlashKt.getIgnoreTrailingSlash(routingResolveContext.getCall()) ? RouteSelectorEvaluation.INSTANCE.getTransparent() : routingResolveContext.getSegments().isEmpty() ? RouteSelectorEvaluation.INSTANCE.getConstant() : i10 < C1173v.o(routingResolveContext.getSegments()) ? RouteSelectorEvaluation.INSTANCE.getTransparent() : i10 > C1173v.o(routingResolveContext.getSegments()) ? RouteSelectorEvaluation.INSTANCE.getFailedPath() : routingResolveContext.getSegments().get(i10).length() > 0 ? RouteSelectorEvaluation.INSTANCE.getTransparent() : routingResolveContext.getHasTrailingSlash() ? RouteSelectorEvaluation.INSTANCE.getConstantPath() : RouteSelectorEvaluation.INSTANCE.getFailedPath();
    }

    public String toString() {
        return "<slash>";
    }
}
