package io.ktor.server.routing;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.http.ContentType;
import io.ktor.http.Parameters;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCall;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b.\u0010,R\u0017\u0010/\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u00109\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lio/ktor/server/routing/RoutingCall;", "Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/server/routing/RoutingPipelineCall;", "pipelineCall", "<init>", "(Lio/ktor/server/routing/RoutingPipelineCall;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "receiveNullable", "(Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "", "message", "LY8/t;", "respond", "(Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/routing/RoutingPipelineCall;", "getPipelineCall", "()Lio/ktor/server/routing/RoutingPipelineCall;", "Lio/ktor/server/routing/RoutingRequest;", "request$delegate", "LY8/h;", "getRequest", "()Lio/ktor/server/routing/RoutingRequest;", "request", "Lio/ktor/server/routing/RoutingResponse;", "response$delegate", "getResponse", "()Lio/ktor/server/routing/RoutingResponse;", UxipConstants.f30685x, "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lio/ktor/server/application/Application;", "getApplication", "()Lio/ktor/server/application/Application;", "Lio/ktor/http/Parameters;", "parameters", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "pathParameters", "getPathParameters", "queryParameters", "getQueryParameters", "Lio/ktor/server/routing/RoutingNode;", M5.a.CARD_TYPE_ROUTE, "Lio/ktor/server/routing/RoutingNode;", "getRoute", "()Lio/ktor/server/routing/RoutingNode;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingCall implements ApplicationCall {
    private final Application application;
    private final Attributes attributes;
    private final Parameters parameters;
    private final Parameters pathParameters;
    private final RoutingApplicationCall pipelineCall;
    private final Parameters queryParameters;

    /* renamed from: request$delegate, reason: from kotlin metadata */
    private final Y8.h request;

    /* renamed from: response$delegate, reason: from kotlin metadata */
    private final Y8.h response;
    private final RoutingNode route;

    public RoutingCall(RoutingApplicationCall pipelineCall) {
        kotlin.jvm.internal.p.i(pipelineCall, "pipelineCall");
        this.pipelineCall = pipelineCall;
        this.request = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.routing.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RoutingCall.request_delegate$lambda$0(this.f33467a);
            }
        });
        this.response = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.routing.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RoutingCall.response_delegate$lambda$1(this.f33468a);
            }
        });
        this.attributes = pipelineCall.getAttributes();
        this.application = pipelineCall.getApplication();
        this.parameters = pipelineCall.getParameters();
        this.pathParameters = pipelineCall.getPathParameters();
        this.queryParameters = pipelineCall.getEngineCall().getParameters();
        this.route = pipelineCall.getRoute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoutingRequest request_delegate$lambda$0(RoutingCall routingCall) {
        return new RoutingRequest(routingCall.pipelineCall.getPathParameters(), routingCall.pipelineCall.getRequest(), routingCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoutingResponse response_delegate$lambda$1(RoutingCall routingCall) {
        return new RoutingResponse(routingCall, routingCall.pipelineCall.getResponse());
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Application getApplication() {
        return this.application;
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.ktor.server.application.ApplicationCall, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.pipelineCall.getCoroutineContext();
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Parameters getParameters() {
        return this.parameters;
    }

    public final Parameters getPathParameters() {
        return this.pathParameters;
    }

    public final RoutingApplicationCall getPipelineCall() {
        return this.pipelineCall;
    }

    public final Parameters getQueryParameters() {
        return this.queryParameters;
    }

    public final RoutingNode getRoute() {
        return this.route;
    }

    @Override // io.ktor.server.application.ApplicationCall
    public <T> Object receiveNullable(TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c) {
        return this.pipelineCall.receiveNullable(typeInfo, interfaceC4014c);
    }

    @Override // io.ktor.server.application.ApplicationCall
    public Object respond(Object obj, TypeInfo typeInfo, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objRespond = this.pipelineCall.respond(obj, typeInfo, interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : Y8.t.f7040a;
    }

    @Override // io.ktor.server.application.ApplicationCall
    public RoutingRequest getRequest() {
        return (RoutingRequest) this.request.getValue();
    }

    @Override // io.ktor.server.application.ApplicationCall
    public RoutingResponse getResponse() {
        return (RoutingResponse) this.response.getValue();
    }
}
