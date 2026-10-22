package io.ktor.client.plugins.websocket;

import Y8.t;
import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketSession;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponseContainer;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2", f = "WebSockets.kt", l = {239}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class WebSockets$Plugin$install$2 extends SuspendLambda implements p9.q<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$2(WebSockets webSockets, boolean z10, InterfaceC4014c<? super WebSockets$Plugin$install$2> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$plugin = webSockets;
        this.$extensionsSupported = z10;
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, InterfaceC4014c<? super t> interfaceC4014c) {
        WebSockets$Plugin$install$2 webSockets$Plugin$install$2 = new WebSockets$Plugin$install$2(this.$plugin, this.$extensionsSupported, interfaceC4014c);
        webSockets$Plugin$install$2.L$0 = pipelineContext;
        webSockets$Plugin$install$2.L$1 = httpResponseContainer;
        return webSockets$Plugin$install$2.invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v7, types: [io.ktor.client.plugins.websocket.DefaultClientWebSocketSession] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DelegatingClientWebSocketSession delegatingClientWebSocketSession;
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            TypeInfo expectedType = httpResponseContainer.getExpectedType();
            Object response = httpResponseContainer.getResponse();
            HttpResponse response2 = ((HttpClientCall) pipelineContext.getContext()).getResponse();
            HttpStatusCode status = response2.getStatus();
            OutgoingContent content = HttpResponseKt.getRequest(response2).getContent();
            if (!(content instanceof WebSocketContent)) {
                vc.c logger = WebSocketsKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    logger.trace("Skipping non-websocket response from " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + ": " + content);
                }
                return t.f7040a;
            }
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (!kotlin.jvm.internal.p.d(status, companion.getSwitchingProtocols())) {
                throw new WebSocketException("Handshake exception, expected status code " + companion.getSwitchingProtocols().getValue() + " but was " + status.getValue());
            }
            if (!(response instanceof WebSocketSession)) {
                throw new WebSocketException("Handshake exception, expected `WebSocketSession` content but was " + kotlin.jvm.internal.t.b(response.getClass()));
            }
            vc.c logger2 = WebSocketsKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("Receive websocket session from " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + ": " + response);
            }
            if (this.$plugin.getMaxFrameSize() != 2147483647L) {
                ((WebSocketSession) response).setMaxFrameSize(this.$plugin.getMaxFrameSize());
            }
            if (kotlin.jvm.internal.p.d(expectedType.getType(), kotlin.jvm.internal.t.b(DefaultClientWebSocketSession.class))) {
                ?? defaultClientWebSocketSession = new DefaultClientWebSocketSession((HttpClientCall) pipelineContext.getContext(), this.$plugin.convertSessionToDefault$ktor_client_core((WebSocketSession) response));
                defaultClientWebSocketSession.start(this.$extensionsSupported ? this.$plugin.completeNegotiation((HttpClientCall) pipelineContext.getContext()) : C1173v.m());
                delegatingClientWebSocketSession = defaultClientWebSocketSession;
            } else {
                delegatingClientWebSocketSession = new DelegatingClientWebSocketSession((HttpClientCall) pipelineContext.getContext(), (WebSocketSession) response);
            }
            HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(expectedType, delegatingClientWebSocketSession);
            this.L$0 = g9.h.a(pipelineContext);
            this.L$1 = g9.h.a(httpResponseContainer);
            this.L$2 = g9.h.a(expectedType);
            this.L$3 = g9.h.a(response);
            this.L$4 = g9.h.a(response2);
            this.L$5 = g9.h.a(status);
            this.L$6 = g9.h.a(content);
            this.L$7 = g9.h.a(delegatingClientWebSocketSession);
            this.label = 1;
            if (pipelineContext.proceedWith(httpResponseContainer2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
