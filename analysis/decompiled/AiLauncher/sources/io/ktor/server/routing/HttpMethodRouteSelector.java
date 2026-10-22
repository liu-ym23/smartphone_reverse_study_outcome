package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.http.HttpMethod;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001d"}, d2 = {"Lio/ktor/server/routing/HttpMethodRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "Lio/ktor/http/HttpMethod;", "method", "<init>", "(Lio/ktor/http/HttpMethod;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "component1", "()Lio/ktor/http/HttpMethod;", ChatTracker.CLICK_COPY, "(Lio/ktor/http/HttpMethod;)Lio/ktor/server/routing/HttpMethodRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/http/HttpMethod;", "getMethod", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HttpMethodRouteSelector extends RouteSelector {
    private final HttpMethod method;

    public HttpMethodRouteSelector(HttpMethod method) {
        kotlin.jvm.internal.p.i(method, "method");
        this.method = method;
    }

    public static /* synthetic */ HttpMethodRouteSelector copy$default(HttpMethodRouteSelector httpMethodRouteSelector, HttpMethod httpMethod, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpMethod = httpMethodRouteSelector.method;
        }
        return httpMethodRouteSelector.copy(httpMethod);
    }

    /* renamed from: component1, reason: from getter */
    public final HttpMethod getMethod() {
        return this.method;
    }

    public final HttpMethodRouteSelector copy(HttpMethod method) {
        kotlin.jvm.internal.p.i(method, "method");
        return new HttpMethodRouteSelector(method);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HttpMethodRouteSelector) && kotlin.jvm.internal.p.d(this.method, ((HttpMethodRouteSelector) other).method);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        return kotlin.jvm.internal.p.d(ApplicationRequestPropertiesKt.getHttpMethod(routingResolveContext.getCall().getRequest()), this.method) ? RouteSelectorEvaluation.INSTANCE.getConstant() : RouteSelectorEvaluation.INSTANCE.getFailedMethod();
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public String toString() {
        return "(method:" + this.method.getValue() + ')';
    }
}
