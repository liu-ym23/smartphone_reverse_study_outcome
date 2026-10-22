package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.ClosedMcpTransportSession;
import io.modelcontextprotocol.spec.DefaultMcpTransportSession;
import io.modelcontextprotocol.spec.DefaultMcpTransportStream;
import io.modelcontextprotocol.spec.HttpHeaders;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportException;
import io.modelcontextprotocol.spec.McpTransportSession;
import io.modelcontextprotocol.spec.McpTransportSessionNotFoundException;
import io.modelcontextprotocol.spec.McpTransportStream;
import io.modelcontextprotocol.spec.ProtocolVersions;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SignalType;
import reactor.util.context.ContextView;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class HttpClientStreamableHttpTransport implements McpClientTransport {
    private static final String APPLICATION_JSON = "application/json";
    private static final String DEFAULT_ENDPOINT = "/mcp";
    private static final String MCP_PROTOCOL_VERSION = "2025-06-18";
    private static final String MESSAGE_EVENT_TYPE = "message";
    private static final String TEXT_EVENT_STREAM = "text/event-stream";
    private final AtomicReference<McpTransportSession<Disposable>> activeSession;
    private final URI baseUri;
    private final String endpoint;
    private final AtomicReference<Consumer<Throwable>> exceptionHandler;
    private final AtomicReference<Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>>> handler;
    private final HttpClient httpClient;
    private final McpAsyncHttpClientRequestCustomizer httpRequestCustomizer;
    private final McpJsonMapper jsonMapper;
    private final boolean openConnectionOnStartup;
    private final HttpRequest.Builder requestBuilder;
    private final boolean resumableStreams;
    private static final rd.b logger = rd.d.b(HttpClientStreamableHttpTransport.class);
    public static int NOT_FOUND = 404;
    public static int METHOD_NOT_ALLOWED = 405;
    public static int BAD_REQUEST = 400;

    private HttpClientStreamableHttpTransport(McpJsonMapper mcpJsonMapper, HttpClient httpClient, HttpRequest.Builder builder, String str, String str2, boolean z10, boolean z11, McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer) {
        AtomicReference<McpTransportSession<Disposable>> atomicReference = new AtomicReference<>();
        this.activeSession = atomicReference;
        this.handler = new AtomicReference<>();
        this.exceptionHandler = new AtomicReference<>();
        this.jsonMapper = mcpJsonMapper;
        this.httpClient = httpClient;
        this.requestBuilder = builder;
        this.baseUri = URI.create(str);
        this.endpoint = str2;
        this.resumableStreams = z10;
        this.openConnectionOnStartup = z11;
        atomicReference.set(createTransportSession());
        this.httpRequestCustomizer = mcpAsyncHttpClientRequestCustomizer;
    }

    public static Builder builder(String str) {
        return new Builder(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public McpTransportSession<Disposable> createClosedSession(McpTransportSession<Disposable> mcpTransportSession) {
        return new ClosedMcpTransportSession((String) Optional.ofNullable(mcpTransportSession).filter(new y(0)).flatMap(new b(4)).orElse(null));
    }

    private qd.c createDelete(String str) {
        URI uriResolveUri = Utils.resolveUri(this.baseUri, this.endpoint);
        r rVar = new r(3);
        rVar.f6203b = this;
        rVar.f6204c = uriResolveUri;
        rVar.f6205d = str;
        VarHandle.storeStoreFence();
        Mono monoDeferContextual = Mono.deferContextual(rVar);
        n nVar = new n();
        nVar.f6196a = this;
        VarHandle.storeStoreFence();
        return monoDeferContextual.flatMap(nVar).then();
    }

    private McpTransportSession<Disposable> createTransportSession() {
        p pVar = new p(0);
        pVar.f6201b = this;
        VarHandle.storeStoreFence();
        return new DefaultMcpTransportSession(pVar);
    }

    private void handleException(Throwable th) {
        rd.b bVar = logger;
        bVar.a("Handling exception for session {}", sessionIdOrPlaceholder(this.activeSession.get()), th);
        if (th instanceof McpTransportSessionNotFoundException) {
            McpTransportSession<Disposable> andSet = this.activeSession.getAndSet(createTransportSession());
            bVar.b(andSet.sessionId(), "Server does not recognize session {}. Invalidating.");
            andSet.close();
        }
        Consumer<Throwable> consumer = this.exceptionHandler.get();
        if (consumer != null) {
            consumer.accept(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$7() {
        logger.debug("Graceful close triggered");
        AtomicReference<McpTransportSession<Disposable>> atomicReference = this.activeSession;
        s sVar = new s();
        sVar.f6206a = this;
        VarHandle.storeStoreFence();
        McpTransportSession<Disposable> andUpdate = atomicReference.getAndUpdate(sVar);
        return andUpdate != null ? Mono.from(andUpdate.closeGracefully()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$connect$0(Throwable th) {
        logger.warn("Eager connect failed ", th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$connect$1(Function function, ContextView contextView) {
        this.handler.set(function);
        if (!this.openConnectionOnStartup) {
            return Mono.empty();
        }
        logger.debug("Eagerly opening connection on startup");
        return reconnect(null).onErrorComplete(new y(1)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createClosedSession$3(McpTransportSession mcpTransportSession) {
        return !(mcpTransportSession instanceof ClosedMcpTransportSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$createDelete$4(URI uri, String str, ContextView contextView) {
        return Mono.from(this.httpRequestCustomizer.customize(this.requestBuilder.copy().uri(uri).header(HttpHeaders.CACHE_CONTROL, "no-cache").header(HttpHeaders.MCP_SESSION_ID, str).header(HttpHeaders.PROTOCOL_VERSION, "2025-06-18").DELETE(), "DELETE", uri, null, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture lambda$createDelete$5(HttpRequest httpRequest) {
        return this.httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$createDelete$6(HttpRequest.Builder builder) {
        HttpRequest httpRequestBuild = builder.build();
        o oVar = new o(0);
        oVar.f6198f = this;
        oVar.f6199g = httpRequestBuild;
        VarHandle.storeStoreFence();
        return Mono.fromFuture(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$createTransportSession$2(String str) {
        return str == null ? Mono.empty() : createDelete(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reconnect$10(FluxSink fluxSink, HttpResponse httpResponse, Throwable th) {
        if (th != null) {
            fluxSink.error(th);
        } else {
            logger.debug("SSE connection established successfully");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reconnect$11(HttpRequest.Builder builder, FluxSink fluxSink) {
        HttpClient httpClient = this.httpClient;
        HttpRequest httpRequestBuild = builder.build();
        h hVar = new h();
        hVar.f6179a = fluxSink;
        VarHandle.storeStoreFence();
        CompletableFuture completableFutureSendAsync = httpClient.sendAsync(httpRequestBuild, hVar);
        v vVar = new v();
        vVar.f6212c = fluxSink;
        VarHandle.storeStoreFence();
        completableFutureSendAsync.whenComplete((BiConsumer) vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResponseSubscribers.SseResponseEvent lambda$reconnect$12(ResponseSubscribers.ResponseEvent responseEvent) {
        return (ResponseSubscribers.SseResponseEvent) responseEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$reconnect$13(McpTransportStream mcpTransportStream, McpTransportSession mcpTransportSession, ResponseSubscribers.SseResponseEvent sseResponseEvent) {
        int iStatusCode = sseResponseEvent.responseInfo().statusCode();
        if (iStatusCode >= 200 && iStatusCode < 300) {
            if (!"message".equals(sseResponseEvent.sseEvent().event())) {
                logger.h(sseResponseEvent.sseEvent(), "Received SSE event with type: {}");
                return Flux.empty();
            }
            try {
                Tuple2 tuple2Of = Tuples.of(Optional.ofNullable(sseResponseEvent.sseEvent().id()), List.of(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseResponseEvent.sseEvent().data())));
                if (mcpTransportStream == null) {
                    boolean z10 = this.resumableStreams;
                    p pVar = new p(2);
                    pVar.f6201b = this;
                    VarHandle.storeStoreFence();
                    mcpTransportStream = new DefaultMcpTransportStream(z10, pVar);
                }
                logger.h(Long.valueOf(mcpTransportStream.streamId()), "Connected stream {}");
                return Flux.from(mcpTransportStream.consumeSseStream(Flux.just(tuple2Of)));
            } catch (IOException e10) {
                return Flux.error(new McpTransportException("Error parsing JSON-RPC message: ".concat(String.valueOf(sseResponseEvent)), e10));
            }
        }
        if (iStatusCode == METHOD_NOT_ALLOWED) {
            logger.debug("The server does not support SSE streams, using request-response mode.");
            return Flux.empty();
        }
        if (iStatusCode == NOT_FOUND) {
            if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
                logger.h(mcpTransportSession.sessionId().get(), "Session not found for session ID: {}");
                return Flux.error(new McpTransportSessionNotFoundException(w2.c.b("Session not found for session ID: ", sessionIdOrPlaceholder(mcpTransportSession))));
            }
            return Flux.error(new McpTransportException("Server Not Found. Status code:" + iStatusCode + ", response-event:" + String.valueOf(sseResponseEvent)));
        }
        if (iStatusCode != BAD_REQUEST) {
            return Flux.error(new McpTransportException(w2.c.b("Received unrecognized SSE event type: ", sseResponseEvent.sseEvent().event())));
        }
        if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
            return Flux.error(new McpTransportSessionNotFoundException(w2.c.b("Session not found for session ID: ", sessionIdOrPlaceholder(mcpTransportSession))));
        }
        return Flux.error(new McpTransportException("Bad Request. Status code:" + iStatusCode + ", response-event:" + String.valueOf(sseResponseEvent)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$reconnect$14(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.handler.get().apply(Mono.just(jSONRPCMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$reconnect$16(Throwable th) {
        handleException(th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reconnect$17(AtomicReference atomicReference, McpTransportSession mcpTransportSession, SignalType signalType) {
        Disposable disposable = (Disposable) atomicReference.getAndSet(null);
        if (disposable != null) {
            mcpTransportSession.removeConnection(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$reconnect$18(McpTransportStream mcpTransportStream, McpTransportSession mcpTransportSession, AtomicReference atomicReference, HttpRequest.Builder builder) {
        int i = 1;
        w wVar = new w(i);
        wVar.f6214f = this;
        wVar.f6215g = builder;
        VarHandle.storeStoreFence();
        Flux map = Flux.create(wVar).map(new b(i));
        r rVar = new r(i);
        rVar.f6203b = this;
        rVar.f6204c = mcpTransportStream;
        rVar.f6205d = mcpTransportSession;
        VarHandle.storeStoreFence();
        Flux fluxFlatMap = map.flatMap(rVar);
        p pVar = new p(i);
        pVar.f6201b = this;
        VarHandle.storeStoreFence();
        Flux fluxOnErrorMap = fluxFlatMap.flatMap(pVar).onErrorMap(CompletionException.class, new b(3));
        x xVar = new x();
        xVar.f6216c = this;
        VarHandle.storeStoreFence();
        Flux fluxOnErrorComplete = fluxOnErrorMap.onErrorComplete(xVar);
        m mVar = new m(i);
        mVar.f6194f = atomicReference;
        mVar.f6195g = mcpTransportSession;
        VarHandle.storeStoreFence();
        return fluxOnErrorComplete.doFinally(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$reconnect$19(McpTransportStream mcpTransportStream, ContextView contextView) {
        if (mcpTransportStream != null) {
            logger.a("Reconnecting stream {} with lastId {}", Long.valueOf(mcpTransportStream.streamId()), mcpTransportStream.lastId());
        } else {
            logger.debug("Reconnecting with no prior stream");
        }
        AtomicReference atomicReference = new AtomicReference();
        McpTransportSession<Disposable> mcpTransportSession = this.activeSession.get();
        URI uriResolveUri = Utils.resolveUri(this.baseUri, this.endpoint);
        a0 a0Var = new a0(1);
        a0Var.f6153b = this;
        a0Var.f6154c = mcpTransportSession;
        a0Var.f6155d = mcpTransportStream;
        a0Var.f6156e = uriResolveUri;
        VarHandle.storeStoreFence();
        Mono monoDeferContextual = Mono.deferContextual(a0Var);
        t tVar = new t();
        tVar.f6207a = this;
        tVar.f6208b = mcpTransportStream;
        tVar.f6209c = mcpTransportSession;
        tVar.f6210d = atomicReference;
        VarHandle.storeStoreFence();
        Disposable disposableSubscribe = monoDeferContextual.flatMapMany(tVar).contextWrite(contextView).subscribe();
        atomicReference.set(disposableSubscribe);
        mcpTransportSession.addConnection(disposableSubscribe);
        return Mono.just(disposableSubscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$reconnect$8(McpTransportSession mcpTransportSession, McpTransportStream mcpTransportStream, URI uri, ContextView contextView) {
        HttpRequest.Builder builderCopy = this.requestBuilder.copy();
        if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
            builderCopy = builderCopy.header(HttpHeaders.MCP_SESSION_ID, mcpTransportSession.sessionId().get());
        }
        if (mcpTransportStream != null && mcpTransportStream.lastId().isPresent()) {
            builderCopy = builderCopy.header(HttpHeaders.LAST_EVENT_ID, mcpTransportStream.lastId().get());
        }
        return Mono.from(this.httpRequestCustomizer.customize(builderCopy.uri(uri).header("Accept", "text/event-stream").header(HttpHeaders.CACHE_CONTROL, "no-cache").header(HttpHeaders.PROTOCOL_VERSION, "2025-06-18").GET(), "GET", uri, null, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$21(McpTransportSession mcpTransportSession, URI uri, String str, ContextView contextView) {
        HttpRequest.Builder builderCopy = this.requestBuilder.copy();
        if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
            builderCopy = builderCopy.header(HttpHeaders.MCP_SESSION_ID, mcpTransportSession.sessionId().get());
        }
        return Mono.from(this.httpRequestCustomizer.customize(builderCopy.uri(uri).header("Accept", "application/json, text/event-stream").header(HttpHeaders.CONTENT_TYPE, "application/json").header(HttpHeaders.CACHE_CONTROL, "no-cache").header(HttpHeaders.PROTOCOL_VERSION, "2025-06-18").POST(HttpRequest.BodyPublishers.ofString(str)), "POST", uri, str, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMessage$22(FluxSink fluxSink, HttpResponse httpResponse, Throwable th) {
        if (th != null) {
            fluxSink.error(th);
        } else {
            logger.debug("SSE connection established successfully");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$24(HttpRequest.Builder builder, FluxSink fluxSink) {
        CompletableFuture completableFutureSendAsync = this.httpClient.sendAsync(builder.build(), toSendMessageBodySubscriber(fluxSink));
        u uVar = new u();
        uVar.f6211c = fluxSink;
        VarHandle.storeStoreFence();
        Mono.fromFuture(completableFutureSendAsync.whenComplete((BiConsumer) uVar)).onErrorMap(CompletionException.class, new b(2)).onErrorComplete().subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$sendMessage$25(HttpRequest.Builder builder) {
        w wVar = new w(0);
        wVar.f6214f = this;
        wVar.f6215g = builder;
        VarHandle.storeStoreFence();
        return Flux.create(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$sendMessage$26() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$sendMessage$27(MonoSink monoSink, ResponseSubscribers.ResponseEvent responseEvent, ResponseSubscribers.SseEvent sseEvent) {
        try {
            Tuple2 tuple2Of = Tuples.of(Optional.ofNullable(sseEvent.id()), List.of(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseEvent.data())));
            boolean z10 = this.resumableStreams;
            p pVar = new p(2);
            pVar.f6201b = this;
            VarHandle.storeStoreFence();
            DefaultMcpTransportStream defaultMcpTransportStream = new DefaultMcpTransportStream(z10, pVar);
            logger.h(Long.valueOf(defaultMcpTransportStream.streamId()), "Connected stream {}");
            monoSink.success();
            return Flux.from(defaultMcpTransportStream.consumeSseStream(Flux.just(tuple2Of)));
        } catch (IOException e10) {
            return Flux.error(new McpTransportException("Error parsing JSON-RPC message: ".concat(String.valueOf(responseEvent)), e10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$sendMessage$28(McpTransportSession mcpTransportSession, MonoSink monoSink, McpSchema.JSONRPCMessage jSONRPCMessage, ResponseSubscribers.ResponseEvent responseEvent) {
        if (mcpTransportSession.markInitialized((String) responseEvent.responseInfo().headers().firstValue("mcp-session-id").orElseGet(new q()))) {
            reconnect(null).contextWrite(monoSink.contextView()).subscribe();
        }
        String strSessionIdOrPlaceholder = sessionIdOrPlaceholder(mcpTransportSession);
        int iStatusCode = responseEvent.responseInfo().statusCode();
        if (iStatusCode < 200 || iStatusCode >= 300) {
            if (iStatusCode == NOT_FOUND) {
                if (mcpTransportSession.sessionId().isPresent()) {
                    logger.h(mcpTransportSession.sessionId().get(), "Session not found for session ID: {}");
                    return Flux.error(new McpTransportSessionNotFoundException(w2.c.b("Session not found for session ID: ", strSessionIdOrPlaceholder)));
                }
                return Flux.error(new McpTransportException("Server Not Found. Status code:" + iStatusCode + ", response-event:" + String.valueOf(responseEvent)));
            }
            if (iStatusCode != BAD_REQUEST) {
                return Flux.error(new RuntimeException("Failed to send message: ".concat(String.valueOf(responseEvent))));
            }
            if (mcpTransportSession.sessionId().isPresent()) {
                return Flux.error(new McpTransportSessionNotFoundException(w2.c.b("Session not found for session ID: ", strSessionIdOrPlaceholder)));
            }
            return Flux.error(new McpTransportException("Bad Request. Status code:" + iStatusCode + ", response-event:" + String.valueOf(responseEvent)));
        }
        String lowerCase = ((String) responseEvent.responseInfo().headers().firstValue(HttpHeaders.CONTENT_TYPE).orElse("")).toLowerCase();
        String str = (String) responseEvent.responseInfo().headers().firstValue(HttpHeaders.CONTENT_LENGTH).orElse(null);
        if (lowerCase.isBlank() || "0".equals(str)) {
            logger.h(strSessionIdOrPlaceholder, "No body returned for POST in session {}");
            monoSink.success();
            return Flux.empty();
        }
        if (lowerCase.contains("text/event-stream")) {
            Flux fluxJust = Flux.just(((ResponseSubscribers.SseResponseEvent) responseEvent).sseEvent());
            r rVar = new r(0);
            rVar.f6203b = this;
            rVar.f6204c = monoSink;
            rVar.f6205d = responseEvent;
            VarHandle.storeStoreFence();
            return fluxJust.flatMap(rVar);
        }
        if (!lowerCase.contains("application/json")) {
            logger.c("Unknown media type {} returned for POST in session {}", lowerCase, strSessionIdOrPlaceholder);
            return Flux.error(new RuntimeException("Unknown media type returned: ".concat(lowerCase)));
        }
        monoSink.success();
        String strData = ((ResponseSubscribers.AggregateResponseEvent) responseEvent).data();
        if (!(jSONRPCMessage instanceof McpSchema.JSONRPCNotification)) {
            try {
                return Mono.just(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, strData));
            } catch (IOException e10) {
                return Mono.error(new McpTransportException("Error deserializing JSON-RPC message: ".concat(String.valueOf(responseEvent)), e10));
            }
        }
        rd.b bVar = logger;
        if (!Utils.hasText(strData)) {
            strData = "[empty]";
        }
        bVar.c("Notification: {} received non-compliant response: {}", jSONRPCMessage, strData);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$sendMessage$29(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.handler.get().apply(Mono.just(jSONRPCMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$sendMessage$31(MonoSink monoSink, Throwable th) {
        handleException(th);
        monoSink.error(th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMessage$32(AtomicReference atomicReference, McpTransportSession mcpTransportSession, SignalType signalType) {
        logger.h(signalType, "SendMessage finally: {}");
        Disposable disposable = (Disposable) atomicReference.getAndSet(null);
        if (disposable != null) {
            mcpTransportSession.removeConnection(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$33(McpSchema.JSONRPCMessage jSONRPCMessage, MonoSink monoSink) {
        logger.h(jSONRPCMessage, "Sending message {}");
        AtomicReference atomicReference = new AtomicReference();
        McpTransportSession<Disposable> mcpTransportSession = this.activeSession.get();
        URI uriResolveUri = Utils.resolveUri(this.baseUri, this.endpoint);
        String string = toString(jSONRPCMessage);
        a0 a0Var = new a0(2);
        a0Var.f6153b = this;
        a0Var.f6154c = mcpTransportSession;
        a0Var.f6155d = uriResolveUri;
        a0Var.f6156e = string;
        VarHandle.storeStoreFence();
        Mono monoDeferContextual = Mono.deferContextual(a0Var);
        z zVar = new z();
        zVar.f6218a = this;
        VarHandle.storeStoreFence();
        Flux fluxFlatMapMany = monoDeferContextual.flatMapMany(zVar);
        int i = 0;
        a0 a0Var2 = new a0(i);
        a0Var2.f6153b = this;
        a0Var2.f6154c = mcpTransportSession;
        a0Var2.f6155d = monoSink;
        a0Var2.f6156e = jSONRPCMessage;
        VarHandle.storeStoreFence();
        Flux fluxFlatMap = fluxFlatMapMany.flatMap(a0Var2);
        p pVar = new p(3);
        pVar.f6201b = this;
        VarHandle.storeStoreFence();
        Flux fluxOnErrorMap = fluxFlatMap.flatMap(pVar).onErrorMap(CompletionException.class, new b(5));
        e eVar = new e(1);
        eVar.f6171g = this;
        eVar.f6170f = monoSink;
        VarHandle.storeStoreFence();
        Flux fluxOnErrorComplete = fluxOnErrorMap.onErrorComplete(eVar);
        m mVar = new m(i);
        mVar.f6194f = atomicReference;
        mVar.f6195g = mcpTransportSession;
        VarHandle.storeStoreFence();
        Disposable disposableSubscribe = fluxOnErrorComplete.doFinally(mVar).contextWrite(monoSink.contextView()).subscribe();
        atomicReference.set(disposableSubscribe);
        mcpTransportSession.addConnection(disposableSubscribe);
    }

    private static /* synthetic */ HttpResponse.BodySubscriber lambda$toSendMessageBodySubscriber$20(FluxSink fluxSink, HttpResponse.ResponseInfo responseInfo) {
        String lowerCase = ((String) responseInfo.headers().firstValue(HttpHeaders.CONTENT_TYPE).orElse("")).toLowerCase();
        if (lowerCase.contains("text/event-stream")) {
            logger.debug("Received SSE stream response, using line subscriber");
            return ResponseSubscribers.sseToBodySubscriber(responseInfo, fluxSink);
        }
        if (lowerCase.contains("application/json")) {
            logger.debug("Received response, using string subscriber");
            return ResponseSubscribers.aggregateBodySubscriber(responseInfo, fluxSink);
        }
        logger.debug("Received Bodyless response, using discarding subscriber");
        return ResponseSubscribers.bodilessBodySubscriber(responseInfo, fluxSink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mono<Disposable> reconnect(McpTransportStream<Disposable> mcpTransportStream) {
        c cVar = new c(5);
        cVar.f6162b = this;
        cVar.f6163c = mcpTransportStream;
        VarHandle.storeStoreFence();
        return Mono.deferContextual(cVar);
    }

    private static String sessionIdOrPlaceholder(McpTransportSession<?> mcpTransportSession) {
        return mcpTransportSession.sessionId().orElse("[missing_session_id]");
    }

    private HttpResponse.BodyHandler<Void> toSendMessageBodySubscriber(FluxSink<ResponseSubscribers.ResponseEvent> fluxSink) {
        h hVar = new h();
        hVar.f6179a = fluxSink;
        VarHandle.storeStoreFence();
        return hVar;
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        j0 j0Var = new j0(2);
        j0Var.f6189f = this;
        VarHandle.storeStoreFence();
        return Mono.defer(j0Var);
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        c cVar = new c(4);
        cVar.f6162b = this;
        cVar.f6163c = function;
        VarHandle.storeStoreFence();
        return Mono.deferContextual(cVar);
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05, ProtocolVersions.MCP_2025_03_26, "2025-06-18");
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        a aVar = new a(1);
        aVar.f6150f = this;
        aVar.f6151g = jSONRPCMessage;
        VarHandle.storeStoreFence();
        return Mono.create(aVar);
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public void setExceptionHandler(Consumer<Throwable> consumer) {
        logger.debug("Exception handler registered");
        this.exceptionHandler.set(consumer);
    }

    public String toString(McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            return this.jsonMapper.writeValueAsString(jSONRPCMessage);
        } catch (IOException e10) {
            od.f.g("Failed to serialize JSON-RPC message", e10);
            return null;
        }
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
        return (T) this.jsonMapper.convertValue(obj, typeRef);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private final String baseUri;
        private HttpClient.Builder clientBuilder;
        private Duration connectTimeout;
        private String endpoint;
        private McpAsyncHttpClientRequestCustomizer httpRequestCustomizer;
        private McpJsonMapper jsonMapper;
        private boolean openConnectionOnStartup;
        private HttpRequest.Builder requestBuilder;
        private boolean resumableStreams;

        private Builder(String str) {
            this.clientBuilder = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1);
            this.endpoint = HttpClientStreamableHttpTransport.DEFAULT_ENDPOINT;
            this.resumableStreams = true;
            this.openConnectionOnStartup = false;
            this.requestBuilder = HttpRequest.newBuilder();
            this.httpRequestCustomizer = McpAsyncHttpClientRequestCustomizer.NOOP;
            this.connectTimeout = Duration.ofSeconds(10L);
            Assert.hasText(str, "baseUri must not be empty");
            this.baseUri = str;
        }

        public Builder asyncHttpRequestCustomizer(McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer) {
            this.httpRequestCustomizer = mcpAsyncHttpClientRequestCustomizer;
            return this;
        }

        public HttpClientStreamableHttpTransport build() {
            HttpClient httpClientBuild = this.clientBuilder.connectTimeout(this.connectTimeout).build();
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpClientStreamableHttpTransport(mcpJsonMapper, httpClientBuild, this.requestBuilder, this.baseUri, this.endpoint, this.resumableStreams, this.openConnectionOnStartup, this.httpRequestCustomizer, 0);
        }

        public Builder clientBuilder(HttpClient.Builder builder) {
            Assert.notNull(builder, "clientBuilder must not be null");
            this.clientBuilder = builder;
            return this;
        }

        public Builder connectTimeout(Duration duration) {
            Assert.notNull(duration, "connectTimeout must not be null");
            this.connectTimeout = duration;
            return this;
        }

        public Builder customizeClient(Consumer<HttpClient.Builder> consumer) {
            Assert.notNull(consumer, "clientCustomizer must not be null");
            consumer.accept(this.clientBuilder);
            return this;
        }

        public Builder customizeRequest(Consumer<HttpRequest.Builder> consumer) {
            Assert.notNull(consumer, "requestCustomizer must not be null");
            consumer.accept(this.requestBuilder);
            return this;
        }

        public Builder endpoint(String str) {
            Assert.hasText(str, "endpoint must be a non-empty String");
            this.endpoint = str;
            return this;
        }

        public Builder httpRequestCustomizer(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer) {
            this.httpRequestCustomizer = McpAsyncHttpClientRequestCustomizer.fromSync(mcpSyncHttpClientRequestCustomizer);
            return this;
        }

        public Builder jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "jsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public Builder openConnectionOnStartup(boolean z10) {
            this.openConnectionOnStartup = z10;
            return this;
        }

        public Builder requestBuilder(HttpRequest.Builder builder) {
            Assert.notNull(builder, "requestBuilder must not be null");
            this.requestBuilder = builder;
            return this;
        }

        public Builder resumableStreams(boolean z10) {
            this.resumableStreams = z10;
            return this;
        }

        public /* synthetic */ Builder(String str, int i) {
            this(str);
        }
    }

    public /* synthetic */ HttpClientStreamableHttpTransport(McpJsonMapper mcpJsonMapper, HttpClient httpClient, HttpRequest.Builder builder, String str, String str2, boolean z10, boolean z11, McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer, int i) {
        this(mcpJsonMapper, httpClient, builder, str, str2, z10, z11, mcpAsyncHttpClientRequestCustomizer);
    }
}
