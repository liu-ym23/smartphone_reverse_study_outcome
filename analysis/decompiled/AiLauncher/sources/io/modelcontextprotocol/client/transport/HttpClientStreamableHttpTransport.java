package io.modelcontextprotocol.client.transport;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.client.utils.CacheControl;
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
import java.util.function.Supplier;
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

/* loaded from: classes4.dex */
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
    private static final vc.c logger = vc.e.l(HttpClientStreamableHttpTransport.class);
    public static int NOT_FOUND = 404;
    public static int METHOD_NOT_ALLOWED = 405;
    public static int BAD_REQUEST = Const.I_TILE_TINY;

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
            return new HttpClientStreamableHttpTransport(mcpJsonMapper, httpClientBuild, this.requestBuilder, this.baseUri, this.endpoint, this.resumableStreams, this.openConnectionOnStartup, this.httpRequestCustomizer);
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

    public static /* synthetic */ void F(AtomicReference atomicReference, McpTransportSession mcpTransportSession, SignalType signalType) {
        Disposable disposable = (Disposable) atomicReference.getAndSet(null);
        if (disposable != null) {
            mcpTransportSession.removeConnection(disposable);
        }
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public static /* synthetic */ boolean c(McpTransportSession mcpTransportSession) {
        return !(mcpTransportSession instanceof ClosedMcpTransportSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public McpTransportSession<Disposable> createClosedSession(McpTransportSession<Disposable> mcpTransportSession) {
        return new ClosedMcpTransportSession((String) Optional.ofNullable(mcpTransportSession).filter(new Predicate() { // from class: io.modelcontextprotocol.client.transport.P
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return HttpClientStreamableHttpTransport.c((McpTransportSession) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.W
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((McpTransportSession) obj).sessionId();
            }
        }).orElse(null));
    }

    private qc.b<Void> createDelete(final String str) {
        final URI uriResolveUri = Utils.resolveUri(this.baseUri, this.endpoint);
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33713a.lambda$createDelete$4(uriResolveUri, str, (ContextView) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33717a.lambda$createDelete$6((HttpRequest.Builder) obj);
            }
        }).then();
    }

    private McpTransportSession<Disposable> createTransportSession() {
        return new DefaultMcpTransportSession(new Function() { // from class: io.modelcontextprotocol.client.transport.A
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33622a.lambda$createTransportSession$2((String) obj);
            }
        });
    }

    public static /* synthetic */ ResponseSubscribers.SseResponseEvent d(ResponseSubscribers.ResponseEvent responseEvent) {
        return (ResponseSubscribers.SseResponseEvent) responseEvent;
    }

    public static /* synthetic */ void g(FluxSink fluxSink, HttpResponse httpResponse, Throwable th) {
        if (th != null) {
            fluxSink.error(th);
        } else {
            logger.debug("SSE connection established successfully");
        }
    }

    private void handleException(Throwable th) {
        vc.c cVar = logger;
        cVar.a("Handling exception for session {}", sessionIdOrPlaceholder(this.activeSession.get()), th);
        if (th instanceof McpTransportSessionNotFoundException) {
            McpTransportSession<Disposable> andSet = this.activeSession.getAndSet(createTransportSession());
            cVar.j("Server does not recognize session {}. Invalidating.", andSet.sessionId());
            andSet.close();
        }
        Consumer<Throwable> consumer = this.exceptionHandler.get();
        if (consumer != null) {
            consumer.accept(th);
        }
    }

    public static /* synthetic */ void j(FluxSink fluxSink, HttpResponse httpResponse, Throwable th) {
        if (th != null) {
            fluxSink.error(th);
        } else {
            logger.debug("SSE connection established successfully");
        }
    }

    public static /* synthetic */ boolean k(Throwable th) {
        logger.warn("Eager connect failed ", th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$7() {
        logger.debug("Graceful close triggered");
        McpTransportSession<Disposable> andUpdate = this.activeSession.getAndUpdate(new UnaryOperator() { // from class: io.modelcontextprotocol.client.transport.D
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33630a.createClosedSession((McpTransportSession) obj);
            }
        });
        return andUpdate != null ? Mono.from(andUpdate.closeGracefully()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$connect$1(Function function, ContextView contextView) {
        this.handler.set(function);
        if (!this.openConnectionOnStartup) {
            return Mono.empty();
        }
        logger.debug("Eagerly opening connection on startup");
        return reconnect(null).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.client.transport.U
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return HttpClientStreamableHttpTransport.k((Throwable) obj);
            }
        }).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$createDelete$4(URI uri, String str, ContextView contextView) {
        return Mono.from(this.httpRequestCustomizer.customize(this.requestBuilder.copy().uri(uri).header(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE).header(HttpHeaders.MCP_SESSION_ID, str).header(HttpHeaders.PROTOCOL_VERSION, "2025-06-18").DELETE(), "DELETE", uri, null, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture lambda$createDelete$5(HttpRequest httpRequest) {
        return this.httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$createDelete$6(HttpRequest.Builder builder) {
        final HttpRequest httpRequestBuild = builder.build();
        return Mono.fromFuture(new Supplier() { // from class: io.modelcontextprotocol.client.transport.z
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33724a.lambda$createDelete$5(httpRequestBuild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$createTransportSession$2(String str) {
        return str == null ? Mono.empty() : createDelete(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reconnect$11(HttpRequest.Builder builder, final FluxSink fluxSink) {
        this.httpClient.sendAsync(builder.build(), new C4520h(fluxSink)).whenComplete(new BiConsumer() { // from class: io.modelcontextprotocol.client.transport.H
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HttpClientStreamableHttpTransport.g(fluxSink, (HttpResponse) obj, (Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$reconnect$13(McpTransportStream mcpTransportStream, McpTransportSession mcpTransportSession, ResponseSubscribers.SseResponseEvent sseResponseEvent) {
        int iStatusCode = sseResponseEvent.responseInfo().statusCode();
        if (iStatusCode >= 200 && iStatusCode < 300) {
            if (!"message".equals(sseResponseEvent.sseEvent().event())) {
                logger.t("Received SSE event with type: {}", sseResponseEvent.sseEvent());
                return Flux.empty();
            }
            try {
                Tuple2 tuple2Of = Tuples.of(Optional.ofNullable(sseResponseEvent.sseEvent().id()), List.of(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseResponseEvent.sseEvent().data())));
                if (mcpTransportStream == null) {
                    mcpTransportStream = new DefaultMcpTransportStream(this.resumableStreams, new V(this));
                }
                logger.t("Connected stream {}", Long.valueOf(mcpTransportStream.streamId()));
                return Flux.from(mcpTransportStream.consumeSseStream(Flux.just(tuple2Of)));
            } catch (IOException e10) {
                return Flux.error(new McpTransportException("Error parsing JSON-RPC message: " + String.valueOf(sseResponseEvent), e10));
            }
        }
        if (iStatusCode == METHOD_NOT_ALLOWED) {
            logger.debug("The server does not support SSE streams, using request-response mode.");
            return Flux.empty();
        }
        if (iStatusCode == NOT_FOUND) {
            if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
                logger.t("Session not found for session ID: {}", mcpTransportSession.sessionId().get());
                return Flux.error(new McpTransportSessionNotFoundException("Session not found for session ID: " + sessionIdOrPlaceholder(mcpTransportSession)));
            }
            return Flux.error(new McpTransportException("Server Not Found. Status code:" + iStatusCode + ", response-event:" + String.valueOf(sseResponseEvent)));
        }
        if (iStatusCode != BAD_REQUEST) {
            return Flux.error(new McpTransportException("Received unrecognized SSE event type: " + sseResponseEvent.sseEvent().event()));
        }
        if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
            return Flux.error(new McpTransportSessionNotFoundException("Session not found for session ID: " + sessionIdOrPlaceholder(mcpTransportSession)));
        }
        return Flux.error(new McpTransportException("Bad Request. Status code:" + iStatusCode + ", response-event:" + String.valueOf(sseResponseEvent)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$reconnect$14(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.handler.get().apply(Mono.just(jSONRPCMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$reconnect$16(Throwable th) {
        handleException(th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$reconnect$18(final McpTransportStream mcpTransportStream, final McpTransportSession mcpTransportSession, final AtomicReference atomicReference, final HttpRequest.Builder builder) {
        return Flux.create(new Consumer() { // from class: io.modelcontextprotocol.client.transport.J
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33644a.lambda$reconnect$11(builder, (FluxSink) obj);
            }
        }).map(new Function() { // from class: io.modelcontextprotocol.client.transport.K
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpClientStreamableHttpTransport.d((ResponseSubscribers.ResponseEvent) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.L
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33646a.lambda$reconnect$13(mcpTransportStream, mcpTransportSession, (ResponseSubscribers.SseResponseEvent) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.M
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33649a.lambda$reconnect$14((McpSchema.JSONRPCMessage) obj);
            }
        }).onErrorMap(CompletionException.class, new Function() { // from class: io.modelcontextprotocol.client.transport.N
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CompletionException) obj).getCause();
            }
        }).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.client.transport.O
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33650a.lambda$reconnect$16((Throwable) obj);
            }
        }).doFinally(new Consumer() { // from class: io.modelcontextprotocol.client.transport.Q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HttpClientStreamableHttpTransport.F(atomicReference, mcpTransportSession, (SignalType) obj);
            }
        });
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
        final URI uriResolveUri = Utils.resolveUri(this.baseUri, this.endpoint);
        Disposable disposableSubscribe = Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33706a.lambda$reconnect$8(mcpTransportSession, mcpTransportStream, uriResolveUri, (ContextView) obj);
            }
        }).flatMapMany(new Function() { // from class: io.modelcontextprotocol.client.transport.E
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33632a.lambda$reconnect$18(mcpTransportStream, mcpTransportSession, atomicReference, (HttpRequest.Builder) obj);
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
        return Mono.from(this.httpRequestCustomizer.customize(builderCopy.uri(uri).header("Accept", "text/event-stream").header(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE).header(HttpHeaders.PROTOCOL_VERSION, "2025-06-18").GET(), "GET", uri, null, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$21(McpTransportSession mcpTransportSession, URI uri, String str, ContextView contextView) {
        HttpRequest.Builder builderCopy = this.requestBuilder.copy();
        if (mcpTransportSession != null && mcpTransportSession.sessionId().isPresent()) {
            builderCopy = builderCopy.header(HttpHeaders.MCP_SESSION_ID, mcpTransportSession.sessionId().get());
        }
        return Mono.from(this.httpRequestCustomizer.customize(builderCopy.uri(uri).header("Accept", "application/json, text/event-stream").header("Content-Type", "application/json").header(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE).header(HttpHeaders.PROTOCOL_VERSION, "2025-06-18").POST(HttpRequest.BodyPublishers.ofString(str)), "POST", uri, str, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$24(HttpRequest.Builder builder, final FluxSink fluxSink) {
        Mono.fromFuture(this.httpClient.sendAsync(builder.build(), toSendMessageBodySubscriber(fluxSink)).whenComplete(new BiConsumer() { // from class: io.modelcontextprotocol.client.transport.F
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HttpClientStreamableHttpTransport.j(fluxSink, (HttpResponse) obj, (Throwable) obj2);
            }
        })).onErrorMap(CompletionException.class, new Function() { // from class: io.modelcontextprotocol.client.transport.G
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CompletionException) obj).getCause();
            }
        }).onErrorComplete().subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$sendMessage$25(final HttpRequest.Builder builder) {
        return Flux.create(new Consumer() { // from class: io.modelcontextprotocol.client.transport.I
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33641a.lambda$sendMessage$24(builder, (FluxSink) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$sendMessage$27(MonoSink monoSink, ResponseSubscribers.ResponseEvent responseEvent, ResponseSubscribers.SseEvent sseEvent) {
        try {
            Tuple2 tuple2Of = Tuples.of(Optional.ofNullable(sseEvent.id()), List.of(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseEvent.data())));
            DefaultMcpTransportStream defaultMcpTransportStream = new DefaultMcpTransportStream(this.resumableStreams, new V(this));
            logger.t("Connected stream {}", Long.valueOf(defaultMcpTransportStream.streamId()));
            monoSink.success();
            return Flux.from(defaultMcpTransportStream.consumeSseStream(Flux.just(tuple2Of)));
        } catch (IOException e10) {
            return Flux.error(new McpTransportException("Error parsing JSON-RPC message: " + String.valueOf(responseEvent), e10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$sendMessage$28(McpTransportSession mcpTransportSession, final MonoSink monoSink, McpSchema.JSONRPCMessage jSONRPCMessage, final ResponseSubscribers.ResponseEvent responseEvent) {
        if (mcpTransportSession.markInitialized((String) responseEvent.responseInfo().headers().firstValue("mcp-session-id").orElseGet(new Supplier() { // from class: io.modelcontextprotocol.client.transport.B
            @Override // java.util.function.Supplier
            public final Object get() {
                return HttpClientStreamableHttpTransport.u();
            }
        }))) {
            reconnect(null).contextWrite(monoSink.contextView()).subscribe();
        }
        String strSessionIdOrPlaceholder = sessionIdOrPlaceholder(mcpTransportSession);
        int iStatusCode = responseEvent.responseInfo().statusCode();
        if (iStatusCode >= 200 && iStatusCode < 300) {
            String lowerCase = ((String) responseEvent.responseInfo().headers().firstValue("Content-Type").orElse("")).toLowerCase();
            String str = (String) responseEvent.responseInfo().headers().firstValue("Content-Length").orElse(null);
            if (lowerCase.isBlank() || "0".equals(str)) {
                logger.t("No body returned for POST in session {}", strSessionIdOrPlaceholder);
                monoSink.success();
                return Flux.empty();
            }
            if (lowerCase.contains("text/event-stream")) {
                return Flux.just(((ResponseSubscribers.SseResponseEvent) responseEvent).sseEvent()).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.C
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.f33626a.lambda$sendMessage$27(monoSink, responseEvent, (ResponseSubscribers.SseEvent) obj);
                    }
                });
            }
            if (!lowerCase.contains("application/json")) {
                logger.c("Unknown media type {} returned for POST in session {}", lowerCase, strSessionIdOrPlaceholder);
                return Flux.error(new RuntimeException("Unknown media type returned: " + lowerCase));
            }
            monoSink.success();
            String strData = ((ResponseSubscribers.AggregateResponseEvent) responseEvent).data();
            if (jSONRPCMessage instanceof McpSchema.JSONRPCNotification) {
                vc.c cVar = logger;
                if (!Utils.hasText(strData)) {
                    strData = "[empty]";
                }
                cVar.c("Notification: {} received non-compliant response: {}", jSONRPCMessage, strData);
                return Mono.empty();
            }
            try {
                return Mono.just(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, strData));
            } catch (IOException e10) {
                return Mono.error(new McpTransportException("Error deserializing JSON-RPC message: " + String.valueOf(responseEvent), e10));
            }
        }
        if (iStatusCode == NOT_FOUND) {
            if (mcpTransportSession.sessionId().isPresent()) {
                logger.t("Session not found for session ID: {}", mcpTransportSession.sessionId().get());
                return Flux.error(new McpTransportSessionNotFoundException("Session not found for session ID: " + strSessionIdOrPlaceholder));
            }
            return Flux.error(new McpTransportException("Server Not Found. Status code:" + iStatusCode + ", response-event:" + String.valueOf(responseEvent)));
        }
        if (iStatusCode != BAD_REQUEST) {
            return Flux.error(new RuntimeException("Failed to send message: " + String.valueOf(responseEvent)));
        }
        if (mcpTransportSession.sessionId().isPresent()) {
            return Flux.error(new McpTransportSessionNotFoundException("Session not found for session ID: " + strSessionIdOrPlaceholder));
        }
        return Flux.error(new McpTransportException("Bad Request. Status code:" + iStatusCode + ", response-event:" + String.valueOf(responseEvent)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$sendMessage$29(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.handler.get().apply(Mono.just(jSONRPCMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$sendMessage$31(MonoSink monoSink, Throwable th) {
        handleException(th);
        monoSink.error(th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$33(final McpSchema.JSONRPCMessage jSONRPCMessage, final MonoSink monoSink) {
        logger.t("Sending message {}", jSONRPCMessage);
        final AtomicReference atomicReference = new AtomicReference();
        final McpTransportSession<Disposable> mcpTransportSession = this.activeSession.get();
        final URI uriResolveUri = Utils.resolveUri(this.baseUri, this.endpoint);
        final String string = toString(jSONRPCMessage);
        Disposable disposableSubscribe = Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.X
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33657a.lambda$sendMessage$21(mcpTransportSession, uriResolveUri, string, (ContextView) obj);
            }
        }).flatMapMany(new Function() { // from class: io.modelcontextprotocol.client.transport.Y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33661a.lambda$sendMessage$25((HttpRequest.Builder) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.Z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33662a.lambda$sendMessage$28(mcpTransportSession, monoSink, jSONRPCMessage, (ResponseSubscribers.ResponseEvent) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.a0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33669a.lambda$sendMessage$29((McpSchema.JSONRPCMessage) obj);
            }
        }).onErrorMap(CompletionException.class, new Function() { // from class: io.modelcontextprotocol.client.transport.b0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CompletionException) obj).getCause();
            }
        }).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.client.transport.c0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33672a.lambda$sendMessage$31(monoSink, (Throwable) obj);
            }
        }).doFinally(new Consumer() { // from class: io.modelcontextprotocol.client.transport.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HttpClientStreamableHttpTransport.r(atomicReference, mcpTransportSession, (SignalType) obj);
            }
        }).contextWrite(monoSink.contextView()).subscribe();
        atomicReference.set(disposableSubscribe);
        mcpTransportSession.addConnection(disposableSubscribe);
    }

    private static /* synthetic */ HttpResponse.BodySubscriber lambda$toSendMessageBodySubscriber$20(FluxSink fluxSink, HttpResponse.ResponseInfo responseInfo) {
        String lowerCase = ((String) responseInfo.headers().firstValue("Content-Type").orElse("")).toLowerCase();
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

    public static /* synthetic */ void r(AtomicReference atomicReference, McpTransportSession mcpTransportSession, SignalType signalType) {
        logger.t("SendMessage finally: {}", signalType);
        Disposable disposable = (Disposable) atomicReference.getAndSet(null);
        if (disposable != null) {
            mcpTransportSession.removeConnection(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mono<Disposable> reconnect(final McpTransportStream<Disposable> mcpTransportStream) {
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.S
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33653a.lambda$reconnect$19(mcpTransportStream, (ContextView) obj);
            }
        });
    }

    private static String sessionIdOrPlaceholder(McpTransportSession<?> mcpTransportSession) {
        return mcpTransportSession.sessionId().orElse("[missing_session_id]");
    }

    private HttpResponse.BodyHandler<Void> toSendMessageBodySubscriber(FluxSink<ResponseSubscribers.ResponseEvent> fluxSink) {
        return new C4520h(fluxSink);
    }

    public static /* synthetic */ String u() {
        return null;
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.client.transport.T
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33655a.lambda$closeGracefully$7();
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(final Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33721a.lambda$connect$1(function, (ContextView) obj);
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public List<String> protocolVersions() {
        return List.of("2024-11-05", ProtocolVersions.MCP_2025_03_26, "2025-06-18");
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.create(new Consumer() { // from class: io.modelcontextprotocol.client.transport.x
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33719a.lambda$sendMessage$33(jSONRPCMessage, (MonoSink) obj);
            }
        });
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
            throw new RuntimeException("Failed to serialize JSON-RPC message", e10);
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
