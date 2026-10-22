package io.modelcontextprotocol.client.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.stepos.ability.mcpserver.model.McpErrorCode;
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
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SignalType;
import reactor.util.context.ContextView;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* loaded from: classes2.dex */
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
    private static final InterfaceC0315b logger = AbstractC0317d.b(HttpClientStreamableHttpTransport.class);
    public static int NOT_FOUND = McpErrorCode.TOOL_NOT_FOUND;
    public static int METHOD_NOT_ALLOWED = 405;
    public static int BAD_REQUEST = 400;

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

        public /* synthetic */ Builder(String str, int i) {
            this(str);
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
    }

    public /* synthetic */ HttpClientStreamableHttpTransport(McpJsonMapper mcpJsonMapper, HttpClient httpClient, HttpRequest.Builder builder, String str, String str2, boolean z10, boolean z11, McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer, int i) {
        this(mcpJsonMapper, httpClient, builder, str, str2, z10, z11, mcpAsyncHttpClientRequestCustomizer);
    }

    public static Builder builder(String str) {
        return new Builder(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public McpTransportSession<Disposable> createClosedSession(McpTransportSession<Disposable> mcpTransportSession) {
        return new ClosedMcpTransportSession((String) Optional.ofNullable(mcpTransportSession).filter(new y(0)).flatMap(new C1574b(4)).orElse(null));
    }

    private Z9.c createDelete(String str) {
        return Mono.deferContextual(new r(this, Utils.resolveUri(this.baseUri, this.endpoint), str, 3)).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f4670a.lambda$createDelete$6((HttpRequest.Builder) obj);
            }
        }).then();
    }

    private McpTransportSession<Disposable> createTransportSession() {
        return new DefaultMcpTransportSession(new p(this, 0));
    }

    private void handleException(Throwable th) {
        InterfaceC0315b interfaceC0315b = logger;
        interfaceC0315b.a("Handling exception for session {}", sessionIdOrPlaceholder(this.activeSession.get()), th);
        if (th instanceof McpTransportSessionNotFoundException) {
            McpTransportSession<Disposable> andSet = this.activeSession.getAndSet(createTransportSession());
            interfaceC0315b.h(andSet.sessionId(), "Server does not recognize session {}. Invalidating.");
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
        McpTransportSession<Disposable> andUpdate = this.activeSession.getAndUpdate(new UnaryOperator() { // from class: io.modelcontextprotocol.client.transport.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f4674a.createClosedSession((McpTransportSession) obj);
            }
        });
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
        return Mono.fromFuture(new o(this, builder.build(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$createTransportSession$2(String str) {
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
    public /* synthetic */ void lambda$reconnect$11(HttpRequest.Builder builder, final FluxSink fluxSink) {
        this.httpClient.sendAsync(builder.build(), new C1580h(fluxSink)).whenComplete(new BiConsumer() { // from class: io.modelcontextprotocol.client.transport.v
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HttpClientStreamableHttpTransport.lambda$reconnect$10(fluxSink, (HttpResponse) obj, (Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResponseSubscribers.SseResponseEvent lambda$reconnect$12(ResponseSubscribers.ResponseEvent responseEvent) {
        return (ResponseSubscribers.SseResponseEvent) responseEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$reconnect$13(McpTransportStream mcpTransportStream, McpTransportSession mcpTransportSession, ResponseSubscribers.SseResponseEvent sseResponseEvent) {
        int iStatusCode = sseResponseEvent.responseInfo().statusCode();
        if (iStatusCode < 200 || iStatusCode >= 300) {
            if (iStatusCode == METHOD_NOT_ALLOWED) {
                logger.debug("The server does not support SSE streams, using request-response mode.");
                return Flux.empty();
            }
            if (iStatusCode != NOT_FOUND) {
                return iStatusCode == BAD_REQUEST ? (mcpTransportSession == null || !mcpTransportSession.sessionId().isPresent()) ? Flux.error(new McpTransportException(androidx.constraintlayout.core.dsl.a.c(iStatusCode, "Bad Request. Status code:", ", response-event:", String.valueOf(sseResponseEvent)))) : Flux.error(new McpTransportSessionNotFoundException(B7.a.k("Session not found for session ID: ", sessionIdOrPlaceholder(mcpTransportSession)))) : Flux.error(new McpTransportException(B7.a.k("Received unrecognized SSE event type: ", sseResponseEvent.sseEvent().event())));
            }
            if (mcpTransportSession == null || !mcpTransportSession.sessionId().isPresent()) {
                return Flux.error(new McpTransportException(androidx.constraintlayout.core.dsl.a.c(iStatusCode, "Server Not Found. Status code:", ", response-event:", String.valueOf(sseResponseEvent))));
            }
            logger.j(mcpTransportSession.sessionId().get(), "Session not found for session ID: {}");
            return Flux.error(new McpTransportSessionNotFoundException(B7.a.k("Session not found for session ID: ", sessionIdOrPlaceholder(mcpTransportSession))));
        }
        if (!"message".equals(sseResponseEvent.sseEvent().event())) {
            logger.j(sseResponseEvent.sseEvent(), "Received SSE event with type: {}");
            return Flux.empty();
        }
        try {
            Tuple2 tuple2Of = Tuples.of(Optional.ofNullable(sseResponseEvent.sseEvent().id()), List.of(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseResponseEvent.sseEvent().data())));
            if (mcpTransportStream == null) {
                mcpTransportStream = new DefaultMcpTransportStream(this.resumableStreams, new p(this, 2));
            }
            logger.j(Long.valueOf(mcpTransportStream.streamId()), "Connected stream {}");
            return Flux.from(mcpTransportStream.consumeSseStream(Flux.just(tuple2Of)));
        } catch (IOException e) {
            return Flux.error(new McpTransportException("Error parsing JSON-RPC message: ".concat(String.valueOf(sseResponseEvent)), e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$reconnect$14(McpSchema.JSONRPCMessage jSONRPCMessage) {
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
    public /* synthetic */ Z9.c lambda$reconnect$18(McpTransportStream mcpTransportStream, McpTransportSession mcpTransportSession, AtomicReference atomicReference, HttpRequest.Builder builder) {
        int i = 1;
        return Flux.create(new w(this, builder, i)).map(new C1574b(i)).flatMap(new r(this, mcpTransportStream, mcpTransportSession, i)).flatMap(new p(this, 1)).onErrorMap(CompletionException.class, new C1574b(3)).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.client.transport.x
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f4679a.lambda$reconnect$16((Throwable) obj);
            }
        }).doFinally(new m(atomicReference, mcpTransportSession, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$reconnect$19(final McpTransportStream mcpTransportStream, ContextView contextView) {
        if (mcpTransportStream != null) {
            logger.a("Reconnecting stream {} with lastId {}", Long.valueOf(mcpTransportStream.streamId()), mcpTransportStream.lastId());
        } else {
            logger.debug("Reconnecting with no prior stream");
        }
        final AtomicReference atomicReference = new AtomicReference();
        final McpTransportSession<Disposable> mcpTransportSession = this.activeSession.get();
        Disposable disposableSubscribe = Mono.deferContextual(new A(this, mcpTransportSession, mcpTransportStream, Utils.resolveUri(this.baseUri, this.endpoint), 1)).flatMapMany(new Function() { // from class: io.modelcontextprotocol.client.transport.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f4675a.lambda$reconnect$18(mcpTransportStream, mcpTransportSession, atomicReference, (HttpRequest.Builder) obj);
            }
        }).contextWrite(contextView).subscribe();
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
    public /* synthetic */ void lambda$sendMessage$24(HttpRequest.Builder builder, final FluxSink fluxSink) {
        Mono.fromFuture(this.httpClient.sendAsync(builder.build(), toSendMessageBodySubscriber(fluxSink)).whenComplete(new BiConsumer() { // from class: io.modelcontextprotocol.client.transport.u
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HttpClientStreamableHttpTransport.lambda$sendMessage$22(fluxSink, (HttpResponse) obj, (Throwable) obj2);
            }
        })).onErrorMap(CompletionException.class, new C1574b(2)).onErrorComplete().subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$sendMessage$25(HttpRequest.Builder builder) {
        return Flux.create(new w(this, builder, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$sendMessage$26() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$sendMessage$27(MonoSink monoSink, ResponseSubscribers.ResponseEvent responseEvent, ResponseSubscribers.SseEvent sseEvent) {
        try {
            Tuple2 tuple2Of = Tuples.of(Optional.ofNullable(sseEvent.id()), List.of(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseEvent.data())));
            DefaultMcpTransportStream defaultMcpTransportStream = new DefaultMcpTransportStream(this.resumableStreams, new p(this, 2));
            logger.j(Long.valueOf(defaultMcpTransportStream.streamId()), "Connected stream {}");
            monoSink.success();
            return Flux.from(defaultMcpTransportStream.consumeSseStream(Flux.just(tuple2Of)));
        } catch (IOException e) {
            return Flux.error(new McpTransportException("Error parsing JSON-RPC message: ".concat(String.valueOf(responseEvent)), e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$sendMessage$28(McpTransportSession mcpTransportSession, MonoSink monoSink, McpSchema.JSONRPCMessage jSONRPCMessage, ResponseSubscribers.ResponseEvent responseEvent) {
        if (mcpTransportSession.markInitialized((String) responseEvent.responseInfo().headers().firstValue("mcp-session-id").orElseGet(new q()))) {
            reconnect(null).contextWrite(monoSink.contextView()).subscribe();
        }
        String strSessionIdOrPlaceholder = sessionIdOrPlaceholder(mcpTransportSession);
        int iStatusCode = responseEvent.responseInfo().statusCode();
        if (iStatusCode < 200 || iStatusCode >= 300) {
            if (iStatusCode != NOT_FOUND) {
                return iStatusCode == BAD_REQUEST ? mcpTransportSession.sessionId().isPresent() ? Flux.error(new McpTransportSessionNotFoundException(B7.a.k("Session not found for session ID: ", strSessionIdOrPlaceholder))) : Flux.error(new McpTransportException(androidx.constraintlayout.core.dsl.a.c(iStatusCode, "Bad Request. Status code:", ", response-event:", String.valueOf(responseEvent)))) : Flux.error(new RuntimeException("Failed to send message: ".concat(String.valueOf(responseEvent))));
            }
            if (!mcpTransportSession.sessionId().isPresent()) {
                return Flux.error(new McpTransportException(androidx.constraintlayout.core.dsl.a.c(iStatusCode, "Server Not Found. Status code:", ", response-event:", String.valueOf(responseEvent))));
            }
            logger.j(mcpTransportSession.sessionId().get(), "Session not found for session ID: {}");
            return Flux.error(new McpTransportSessionNotFoundException(B7.a.k("Session not found for session ID: ", strSessionIdOrPlaceholder)));
        }
        String lowerCase = ((String) responseEvent.responseInfo().headers().firstValue(HttpHeaders.CONTENT_TYPE).orElse("")).toLowerCase();
        String str = (String) responseEvent.responseInfo().headers().firstValue(HttpHeaders.CONTENT_LENGTH).orElse(null);
        if (lowerCase.isBlank() || "0".equals(str)) {
            logger.j(strSessionIdOrPlaceholder, "No body returned for POST in session {}");
            monoSink.success();
            return Flux.empty();
        }
        if (lowerCase.contains("text/event-stream")) {
            return Flux.just(((ResponseSubscribers.SseResponseEvent) responseEvent).sseEvent()).flatMap(new r(this, monoSink, responseEvent, 0));
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
            } catch (IOException e) {
                return Mono.error(new McpTransportException("Error deserializing JSON-RPC message: ".concat(String.valueOf(responseEvent)), e));
            }
        }
        InterfaceC0315b interfaceC0315b = logger;
        if (!Utils.hasText(strData)) {
            strData = "[empty]";
        }
        interfaceC0315b.c("Notification: {} received non-compliant response: {}", jSONRPCMessage, strData);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$sendMessage$29(McpSchema.JSONRPCMessage jSONRPCMessage) {
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
        logger.j(signalType, "SendMessage finally: {}");
        Disposable disposable = (Disposable) atomicReference.getAndSet(null);
        if (disposable != null) {
            mcpTransportSession.removeConnection(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$33(McpSchema.JSONRPCMessage jSONRPCMessage, MonoSink monoSink) {
        logger.j(jSONRPCMessage, "Sending message {}");
        AtomicReference atomicReference = new AtomicReference();
        McpTransportSession<Disposable> mcpTransportSession = this.activeSession.get();
        Disposable disposableSubscribe = Mono.deferContextual(new A(this, mcpTransportSession, Utils.resolveUri(this.baseUri, this.endpoint), toString(jSONRPCMessage), 2)).flatMapMany(new Function() { // from class: io.modelcontextprotocol.client.transport.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f4681a.lambda$sendMessage$25((HttpRequest.Builder) obj);
            }
        }).flatMap(new A(this, mcpTransportSession, monoSink, jSONRPCMessage, 0)).flatMap(new p(this, 3)).onErrorMap(CompletionException.class, new C1574b(5)).onErrorComplete(new C1577e(this, monoSink, 1)).doFinally(new m(atomicReference, mcpTransportSession, 0)).contextWrite(monoSink.contextView()).subscribe();
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
        return Mono.deferContextual(new C1575c(this, mcpTransportStream, 5));
    }

    private static String sessionIdOrPlaceholder(McpTransportSession<?> mcpTransportSession) {
        return mcpTransportSession.sessionId().orElse("[missing_session_id]");
    }

    private HttpResponse.BodyHandler<Void> toSendMessageBodySubscriber(FluxSink<ResponseSubscribers.ResponseEvent> fluxSink) {
        return new C1580h(fluxSink);
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        return Mono.defer(new J(this, 2));
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        return Mono.deferContextual(new C1575c(this, function, 4));
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05, ProtocolVersions.MCP_2025_03_26, "2025-06-18");
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.create(new C1573a(this, jSONRPCMessage, 1));
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public void setExceptionHandler(Consumer<Throwable> consumer) {
        logger.debug("Exception handler registered");
        this.exceptionHandler.set(consumer);
    }

    public String toString(McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            return this.jsonMapper.writeValueAsString(jSONRPCMessage);
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize JSON-RPC message", e);
        }
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
        return (T) this.jsonMapper.convertValue(obj, typeRef);
    }

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
}
