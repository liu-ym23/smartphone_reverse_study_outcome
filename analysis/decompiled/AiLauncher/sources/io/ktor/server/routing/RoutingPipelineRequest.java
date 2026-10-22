package io.ktor.server.routing;

import io.ktor.http.Headers;
import io.ktor.http.Parameters;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.request.PipelineRequest;
import io.ktor.server.request.RequestCookies;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0097\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0097\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u00100\u001a\u00020-8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lio/ktor/server/routing/RoutingPipelineRequest;", "Lio/ktor/server/request/PipelineRequest;", "Lio/ktor/server/routing/RoutingPipelineCall;", "call", "Lio/ktor/server/request/ApplicationReceivePipeline;", "pipeline", "engineRequest", "<init>", "(Lio/ktor/server/routing/RoutingPipelineCall;Lio/ktor/server/request/ApplicationReceivePipeline;Lio/ktor/server/request/PipelineRequest;)V", "", "name", "", "values", "LY8/t;", "setHeader", "(Ljava/lang/String;Ljava/util/List;)V", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "setReceiveChannel", "(Lio/ktor/utils/io/ByteReadChannel;)V", "receiveChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/server/routing/RoutingPipelineCall;", "getCall", "()Lio/ktor/server/routing/RoutingPipelineCall;", "Lio/ktor/server/request/ApplicationReceivePipeline;", "getPipeline", "()Lio/ktor/server/request/ApplicationReceivePipeline;", "Lio/ktor/server/request/PipelineRequest;", "getEngineRequest", "()Lio/ktor/server/request/PipelineRequest;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/RequestConnectionPoint;", "getLocal", "()Lio/ktor/http/RequestConnectionPoint;", "local", "Lio/ktor/http/Parameters;", "getQueryParameters", "()Lio/ktor/http/Parameters;", "queryParameters", "getRawQueryParameters", "rawQueryParameters", "Lio/ktor/server/request/RequestCookies;", "getCookies", "()Lio/ktor/server/request/RequestCookies;", "cookies", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingPipelineRequest implements PipelineRequest {
    private final RoutingApplicationCall call;
    private final PipelineRequest engineRequest;
    private final ApplicationReceivePipeline pipeline;

    public RoutingPipelineRequest(RoutingApplicationCall call, ApplicationReceivePipeline pipeline, PipelineRequest engineRequest) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(pipeline, "pipeline");
        kotlin.jvm.internal.p.i(engineRequest, "engineRequest");
        this.call = call;
        this.pipeline = pipeline;
        this.engineRequest = engineRequest;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RequestCookies getCookies() {
        return this.engineRequest.getCookies();
    }

    public final PipelineRequest getEngineRequest() {
        return this.engineRequest;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Headers getHeaders() {
        return this.engineRequest.getHeaders();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public RequestConnectionPoint getLocal() {
        return this.engineRequest.getLocal();
    }

    @Override // io.ktor.server.request.PipelineRequest
    public ApplicationReceivePipeline getPipeline() {
        return this.pipeline;
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Parameters getQueryParameters() {
        return this.engineRequest.getQueryParameters();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public Parameters getRawQueryParameters() {
        return this.engineRequest.getRawQueryParameters();
    }

    @Override // io.ktor.server.request.ApplicationRequest
    public ByteReadChannel receiveChannel() {
        return this.engineRequest.receiveChannel();
    }

    @Override // io.ktor.server.request.PipelineRequest
    @InternalAPI
    public void setHeader(String name, List<String> values) {
        kotlin.jvm.internal.p.i(name, "name");
        this.engineRequest.setHeader(name, values);
    }

    @Override // io.ktor.server.request.PipelineRequest
    @InternalAPI
    public void setReceiveChannel(ByteReadChannel channel) {
        kotlin.jvm.internal.p.i(channel, "channel");
        this.engineRequest.setReceiveChannel(channel);
    }

    @Override // io.ktor.server.request.PipelineRequest, io.ktor.server.request.ApplicationRequest
    public RoutingApplicationCall getCall() {
        return this.call;
    }
}
