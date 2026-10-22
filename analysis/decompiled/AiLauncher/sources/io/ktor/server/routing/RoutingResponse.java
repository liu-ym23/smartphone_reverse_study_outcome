package io.ktor.server.routing;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.response.ApplicationResponse;
import io.ktor.server.response.PipelineResponse;
import io.ktor.server.response.ResponseCookies;
import io.ktor.server.response.ResponseHeaders;
import io.ktor.server.response.ResponsePushBuilder;
import io.ktor.server.response.UseHttp2Push;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lio/ktor/server/routing/RoutingResponse;", "Lio/ktor/server/response/ApplicationResponse;", "Lio/ktor/server/routing/RoutingCall;", "call", "Lio/ktor/server/response/PipelineResponse;", "applicationResponse", "<init>", "(Lio/ktor/server/routing/RoutingCall;Lio/ktor/server/response/PipelineResponse;)V", "Lio/ktor/http/HttpStatusCode;", "status", "()Lio/ktor/http/HttpStatusCode;", UxipConstants.f30680s, "LY8/t;", "(Lio/ktor/http/HttpStatusCode;)V", "Lio/ktor/server/response/ResponsePushBuilder;", "builder", "push", "(Lio/ktor/server/response/ResponsePushBuilder;)V", "Lio/ktor/server/routing/RoutingCall;", "getCall", "()Lio/ktor/server/routing/RoutingCall;", "Lio/ktor/server/response/PipelineResponse;", "getApplicationResponse$ktor_server_core", "()Lio/ktor/server/response/PipelineResponse;", "Lio/ktor/server/response/ResponseHeaders;", "headers", "Lio/ktor/server/response/ResponseHeaders;", "getHeaders", "()Lio/ktor/server/response/ResponseHeaders;", "Lio/ktor/server/response/ResponseCookies;", "cookies", "Lio/ktor/server/response/ResponseCookies;", "getCookies", "()Lio/ktor/server/response/ResponseCookies;", "", "isCommitted", "()Z", "isSent", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingResponse implements ApplicationResponse {
    private final PipelineResponse applicationResponse;
    private final RoutingCall call;
    private final ResponseCookies cookies;
    private final ResponseHeaders headers;

    public RoutingResponse(RoutingCall call, PipelineResponse applicationResponse) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(applicationResponse, "applicationResponse");
        this.call = call;
        this.applicationResponse = applicationResponse;
        this.headers = applicationResponse.getHeaders();
        this.cookies = applicationResponse.getCookies();
    }

    /* renamed from: getApplicationResponse$ktor_server_core, reason: from getter */
    public final PipelineResponse getApplicationResponse() {
        return this.applicationResponse;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public ResponseCookies getCookies() {
        return this.cookies;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public ResponseHeaders getHeaders() {
        return this.headers;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    /* renamed from: isCommitted */
    public boolean getResponded() {
        return this.applicationResponse.getResponded();
    }

    @Override // io.ktor.server.response.ApplicationResponse
    /* renamed from: isSent */
    public boolean getIsSent() {
        return this.applicationResponse.getIsSent();
    }

    @Override // io.ktor.server.response.ApplicationResponse
    @UseHttp2Push
    public void push(ResponsePushBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        this.applicationResponse.push(builder);
    }

    @Override // io.ktor.server.response.ApplicationResponse
    /* renamed from: status */
    public HttpStatusCode getStatus() {
        return this.applicationResponse.getStatus();
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public RoutingCall getCall() {
        return this.call;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public void status(HttpStatusCode value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.applicationResponse.status(value);
    }
}
