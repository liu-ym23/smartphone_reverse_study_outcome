package io.ktor.server.routing;

import Ua.M;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.server.application.Application;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001eR\u0014\u00100\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lio/ktor/server/routing/RoutingPipelineCall;", "Lio/ktor/server/application/PipelineCall;", "LUa/M;", "engineCall", "Lio/ktor/server/routing/RoutingNode;", M5.a.CARD_TYPE_ROUTE, "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/server/request/ApplicationReceivePipeline;", "receivePipeline", "Lio/ktor/server/response/ApplicationSendPipeline;", "responsePipeline", "Lio/ktor/http/Parameters;", "pathParameters", "<init>", "(Lio/ktor/server/application/PipelineCall;Lio/ktor/server/routing/RoutingNode;Lkotlin/coroutines/d;Lio/ktor/server/request/ApplicationReceivePipeline;Lio/ktor/server/response/ApplicationSendPipeline;Lio/ktor/http/Parameters;)V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/server/application/PipelineCall;", "getEngineCall", "()Lio/ktor/server/application/PipelineCall;", "Lio/ktor/server/routing/RoutingNode;", "getRoute", "()Lio/ktor/server/routing/RoutingNode;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lio/ktor/http/Parameters;", "getPathParameters", "()Lio/ktor/http/Parameters;", "Lio/ktor/server/routing/RoutingPipelineRequest;", "request", "Lio/ktor/server/routing/RoutingPipelineRequest;", "getRequest", "()Lio/ktor/server/routing/RoutingPipelineRequest;", "Lio/ktor/server/routing/RoutingPipelineResponse;", UxipConstants.f30685x, "Lio/ktor/server/routing/RoutingPipelineResponse;", "getResponse", "()Lio/ktor/server/routing/RoutingPipelineResponse;", "parameters$delegate", "LY8/h;", "getParameters", "parameters", "Lio/ktor/server/application/Application;", "getApplication", "()Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "attributes", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: io.ktor.server.routing.RoutingPipelineCall, reason: from toString */
/* loaded from: classes4.dex */
public final class RoutingApplicationCall implements PipelineCall, M {
    private final kotlin.coroutines.d coroutineContext;
    private final PipelineCall engineCall;

    /* renamed from: parameters$delegate, reason: from kotlin metadata */
    private final Y8.h parameters;
    private final Parameters pathParameters;
    private final RoutingPipelineRequest request;
    private final RoutingPipelineResponse response;
    private final RoutingNode route;

    public RoutingApplicationCall(PipelineCall engineCall, RoutingNode route, kotlin.coroutines.d coroutineContext, ApplicationReceivePipeline receivePipeline, ApplicationSendPipeline responsePipeline, Parameters pathParameters) {
        kotlin.jvm.internal.p.i(engineCall, "engineCall");
        kotlin.jvm.internal.p.i(route, "route");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        kotlin.jvm.internal.p.i(receivePipeline, "receivePipeline");
        kotlin.jvm.internal.p.i(responsePipeline, "responsePipeline");
        kotlin.jvm.internal.p.i(pathParameters, "pathParameters");
        this.engineCall = engineCall;
        this.route = route;
        this.coroutineContext = coroutineContext;
        this.pathParameters = pathParameters;
        this.request = new RoutingPipelineRequest(this, receivePipeline, engineCall.getRequest());
        this.response = new RoutingPipelineResponse(this, responsePipeline, engineCall.getResponse());
        this.parameters = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: io.ktor.server.routing.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RoutingApplicationCall.parameters_delegate$lambda$1(this.f33445a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Parameters parameters_delegate$lambda$1(RoutingApplicationCall routingApplicationCall) {
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parametersBuilderParametersBuilder$default.appendAll(routingApplicationCall.engineCall.getParameters());
        parametersBuilderParametersBuilder$default.appendMissing(routingApplicationCall.pathParameters);
        return parametersBuilderParametersBuilder$default.build();
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Application getApplication() {
        return this.engineCall.getApplication();
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Attributes getAttributes() {
        return this.engineCall.getAttributes();
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    public final PipelineCall getEngineCall() {
        return this.engineCall;
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Parameters getParameters() {
        return (Parameters) this.parameters.getValue();
    }

    public final Parameters getPathParameters() {
        return this.pathParameters;
    }

    public final RoutingNode getRoute() {
        return this.route;
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall
    public <T> Object receiveNullable(TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c) {
        return PipelineCall.DefaultImpls.receiveNullable(this, typeInfo, interfaceC4014c);
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall
    public Object respond(Object obj, TypeInfo typeInfo, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return PipelineCall.DefaultImpls.respond(this, obj, typeInfo, interfaceC4014c);
    }

    public String toString() {
        return "RoutingApplicationCall(route=" + this.route + ')';
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall
    public RoutingPipelineRequest getRequest() {
        return this.request;
    }

    @Override // io.ktor.server.application.PipelineCall, io.ktor.server.application.ApplicationCall
    public RoutingPipelineResponse getResponse() {
        return this.response;
    }
}
