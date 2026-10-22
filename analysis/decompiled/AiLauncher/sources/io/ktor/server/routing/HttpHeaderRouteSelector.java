package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.HeaderValue;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000f¨\u0006\u001e"}, d2 = {"Lio/ktor/server/routing/HttpHeaderRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "name", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "component1", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/server/routing/HttpHeaderRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getValue", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HttpHeaderRouteSelector extends RouteSelector {
    private final String name;
    private final String value;

    public HttpHeaderRouteSelector(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        this.name = name;
        this.value = value;
    }

    public static /* synthetic */ HttpHeaderRouteSelector copy$default(HttpHeaderRouteSelector httpHeaderRouteSelector, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = httpHeaderRouteSelector.name;
        }
        if ((i10 & 2) != 0) {
            str2 = httpHeaderRouteSelector.value;
        }
        return httpHeaderRouteSelector.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final HttpHeaderRouteSelector copy(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        return new HttpHeaderRouteSelector(name, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpHeaderRouteSelector)) {
            return false;
        }
        HttpHeaderRouteSelector httpHeaderRouteSelector = (HttpHeaderRouteSelector) other;
        return kotlin.jvm.internal.p.d(this.name, httpHeaderRouteSelector.name) && kotlin.jvm.internal.p.d(this.value, httpHeaderRouteSelector.value);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        Object next;
        Iterator<T> it = HttpHeaderValueParserKt.parseAndSortHeader(routingResolveContext.getCall().getRequest().getHeaders().get(this.name)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (La.D.L(((HeaderValue) next).getValue(), this.value, true)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) next;
        return headerValue == null ? RouteSelectorEvaluation.INSTANCE.getFailedParameter() : new RouteSelectorEvaluation.Success(headerValue.getQuality(), null, 0, 6, null);
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "(header:" + this.name + " = " + this.value + ')';
    }
}
