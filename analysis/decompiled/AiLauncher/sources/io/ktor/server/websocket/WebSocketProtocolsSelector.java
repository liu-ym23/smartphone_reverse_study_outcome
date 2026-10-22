package io.ktor.server.websocket;

import Z8.C1174w;
import e9.InterfaceC4014c;
import io.ktor.http.HeaderValue;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.server.routing.RouteSelector;
import io.ktor.server.routing.RouteSelectorEvaluation;
import io.ktor.server.routing.RoutingResolveContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/server/websocket/WebSocketProtocolsSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "requiredProtocol", "<init>", "(Ljava/lang/String;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getRequiredProtocol", "()Ljava/lang/String;", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class WebSocketProtocolsSelector extends RouteSelector {
    private final String requiredProtocol;

    public WebSocketProtocolsSelector(String requiredProtocol) {
        p.i(requiredProtocol, "requiredProtocol");
        this.requiredProtocol = requiredProtocol;
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        String str = routingResolveContext.getCall().getRequest().getHeaders().get(HttpHeaders.INSTANCE.getSecWebSocketProtocol());
        if (str == null) {
            WebSocketsKt.getLOGGER().trace("Skipping WebSocket plugin because no Sec-WebSocket-Protocol header provided.");
            return RouteSelectorEvaluation.INSTANCE.getFailedParameter();
        }
        List<HeaderValue> headerValue = HttpHeaderValueParserKt.parseHeaderValue(str);
        ArrayList arrayList = new ArrayList(C1174w.x(headerValue, 10));
        Iterator<T> it = headerValue.iterator();
        while (it.hasNext()) {
            arrayList.add(((HeaderValue) it.next()).getValue());
        }
        if (arrayList.contains(this.requiredProtocol)) {
            return RouteSelectorEvaluation.INSTANCE.getConstant();
        }
        WebSocketsKt.getLOGGER().trace("Skipping WebSocket plugin because no Sec-WebSocket-Protocol header " + str + " is not matching " + this.requiredProtocol + '.');
        return RouteSelectorEvaluation.INSTANCE.getFailedParameter();
    }

    public final String getRequiredProtocol() {
        return this.requiredProtocol;
    }
}
