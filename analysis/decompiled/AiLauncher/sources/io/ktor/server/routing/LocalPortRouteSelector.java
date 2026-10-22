package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.http.ParametersKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\r¨\u0006\u001c"}, d2 = {"Lio/ktor/server/routing/LocalPortRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "port", "<init>", "(I)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "component1", "()I", ChatTracker.CLICK_COPY, "(I)Lio/ktor/server/routing/LocalPortRouteSelector;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPort", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LocalPortRouteSelector extends RouteSelector {
    public static final String LocalPortParameter = "$LocalPort";
    private final int port;

    public LocalPortRouteSelector(int i10) {
        this.port = i10;
    }

    public static /* synthetic */ LocalPortRouteSelector copy$default(LocalPortRouteSelector localPortRouteSelector, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = localPortRouteSelector.port;
        }
        return localPortRouteSelector.copy(i10);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final LocalPortRouteSelector copy(int port) {
        return new LocalPortRouteSelector(port);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LocalPortRouteSelector) && this.port == ((LocalPortRouteSelector) other).port;
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        int localPort = routingResolveContext.getCall().getRequest().getLocal().getLocalPort();
        int i11 = this.port;
        return localPort == i11 ? new RouteSelectorEvaluation.Success(1.0d, ParametersKt.parametersOf(LocalPortParameter, String.valueOf(i11)), 0, 4, null) : RouteSelectorEvaluation.INSTANCE.getFailed();
    }

    public final int getPort() {
        return this.port;
    }

    public int hashCode() {
        return Integer.hashCode(this.port);
    }

    public String toString() {
        return "LocalPortRouteSelector(port=" + this.port + ')';
    }
}
