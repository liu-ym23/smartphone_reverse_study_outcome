package io.ktor.server.routing;

import io.ktor.http.Headers;
import io.ktor.http.Parameters;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.server.request.ApplicationRequest;
import io.ktor.server.request.PipelineRequest;
import io.ktor.server.request.RequestCookies;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lio/ktor/server/routing/RoutingRequest;", "Lio/ktor/server/request/ApplicationRequest;", "Lio/ktor/http/Parameters;", "pathVariables", "Lio/ktor/server/request/PipelineRequest;", "request", "Lio/ktor/server/routing/RoutingCall;", "call", "<init>", "(Lio/ktor/http/Parameters;Lio/ktor/server/request/PipelineRequest;Lio/ktor/server/routing/RoutingCall;)V", "Lio/ktor/utils/io/ByteReadChannel;", "receiveChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/Parameters;", "getPathVariables", "()Lio/ktor/http/Parameters;", "Lio/ktor/server/request/PipelineRequest;", "getRequest$ktor_server_core", "()Lio/ktor/server/request/PipelineRequest;", "Lio/ktor/server/routing/RoutingCall;", "getCall", "()Lio/ktor/server/routing/RoutingCall;", "queryParameters", "getQueryParameters", "rawQueryParameters", "getRawQueryParameters", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lio/ktor/http/RequestConnectionPoint;", "local", "Lio/ktor/http/RequestConnectionPoint;", "getLocal", "()Lio/ktor/http/RequestConnectionPoint;", "Lio/ktor/server/request/RequestCookies;", "cookies", "Lio/ktor/server/request/RequestCookies;", "getCookies", "()Lio/ktor/server/request/RequestCookies;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingRequest implements ApplicationRequest {
    private final RoutingCall call;
    private final RequestCookies cookies;
    private final Headers headers;
    private final RequestConnectionPoint local;
    private final Parameters pathVariables;
    private final Parameters queryParameters;
    private final Parameters rawQueryParameters;
    private final PipelineRequest request;

    public RoutingRequest(Parameters pathVariables, PipelineRequest request, RoutingCall call) {
        kotlin.jvm.internal.p.i(pathVariables, "pathVariables");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(call, "call");
        this.pathVariables = pathVariables;
        this.request = request;
        this.call = call;
        this.queryParameters = request.getQueryParameters();
        this.rawQueryParameters = request.getRawQueryParameters();
        this.headers = request.getHeaders();
        this.local = request.getLocal();
        this.cookies = request.getCookies();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RequestCookies getCookies() {
        return this.cookies;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Headers getHeaders() {
        return this.headers;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RequestConnectionPoint getLocal() {
        return this.local;
    }

    public final Parameters getPathVariables() {
        return this.pathVariables;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Parameters getQueryParameters() {
        return this.queryParameters;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Parameters getRawQueryParameters() {
        return this.rawQueryParameters;
    }

    /* renamed from: getRequest$ktor_server_core, reason: from getter */
    public final PipelineRequest getRequest() {
        return this.request;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public ByteReadChannel receiveChannel() {
        return this.request.receiveChannel();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RoutingCall getCall() {
        return this.call;
    }
}
