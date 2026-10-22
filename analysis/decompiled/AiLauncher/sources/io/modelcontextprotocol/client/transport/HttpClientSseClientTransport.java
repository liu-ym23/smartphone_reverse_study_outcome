package io.modelcontextprotocol.client.transport;

import io.ktor.client.utils.CacheControl;
import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.HttpHeaders;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportException;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SignalType;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
public class HttpClientSseClientTransport implements McpClientTransport {
    private static final String DEFAULT_SSE_ENDPOINT = "/sse";
    private static final String ENDPOINT_EVENT_TYPE = "endpoint";
    private static final String MCP_PROTOCOL_VERSION = "2024-11-05";
    private static final String MCP_PROTOCOL_VERSION_HEADER_NAME = "MCP-Protocol-Version";
    private static final String MESSAGE_EVENT_TYPE = "message";
    private static final vc.c logger = vc.e.l(HttpClientSseClientTransport.class);
    private final URI baseUri;
    private final HttpClient httpClient;
    private final McpAsyncHttpClientRequestCustomizer httpRequestCustomizer;
    protected McpJsonMapper jsonMapper;
    private final HttpRequest.Builder requestBuilder;
    private final String sseEndpoint;
    private volatile boolean isClosing = false;
    private final AtomicReference<Disposable> sseSubscription = new AtomicReference<>();
    protected final Sinks.One<String> messageEndpointSink = Sinks.one();

    public HttpClientSseClientTransport(HttpClient httpClient, HttpRequest.Builder builder, String str, String str2, McpJsonMapper mcpJsonMapper, McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer) {
        Assert.notNull(mcpJsonMapper, "jsonMapper must not be null");
        Assert.hasText(str, "baseUri must not be empty");
        Assert.hasText(str2, "sseEndpoint must not be empty");
        Assert.notNull(httpClient, "httpClient must not be null");
        Assert.notNull(builder, "requestBuilder must not be null");
        Assert.notNull(mcpAsyncHttpClientRequestCustomizer, "httpRequestCustomizer must not be null");
        this.baseUri = URI.create(str);
        this.sseEndpoint = str2;
        this.jsonMapper = mcpJsonMapper;
        this.httpClient = httpClient;
        this.requestBuilder = builder;
        this.httpRequestCustomizer = mcpAsyncHttpClientRequestCustomizer;
    }

    public static Builder builder(String str) {
        return new Builder().baseUri(str);
    }

    public static /* synthetic */ CompletionStage f(FluxSink fluxSink, Throwable th) {
        fluxSink.error(th);
        return CompletableFuture.failedFuture(th);
    }

    public static /* synthetic */ ResponseSubscribers.SseResponseEvent j(ResponseSubscribers.ResponseEvent responseEvent) {
        return (ResponseSubscribers.SseResponseEvent) responseEvent;
    }

    public static /* synthetic */ qc.b k(Function function, McpSchema.JSONRPCMessage jSONRPCMessage) {
        return (qc.b) function.apply(Mono.just(jSONRPCMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$18() {
        this.isClosing = true;
        Disposable disposable = this.sseSubscription.get();
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$connect$0(URI uri, ContextView contextView) {
        return Mono.from(this.httpRequestCustomizer.customize(this.requestBuilder.copy().uri(uri).header("Accept", "text/event-stream").header(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE).header("MCP-Protocol-Version", "2024-11-05").GET(), "GET", uri, null, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$connect$10(final Function function, final HttpRequest.Builder builder) {
        return Mono.create(new Consumer() { // from class: io.modelcontextprotocol.client.transport.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33686a.lambda$connect$9(builder, function, (MonoSink) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$3(HttpRequest.Builder builder, final FluxSink fluxSink) {
        this.httpClient.sendAsync(builder.build(), new C4520h(fluxSink)).exceptionallyCompose(new Function() { // from class: io.modelcontextprotocol.client.transport.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpClientSseClientTransport.f(fluxSink, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$connect$5(MonoSink monoSink, ResponseSubscribers.SseResponseEvent sseResponseEvent) {
        if (this.isClosing) {
            return Mono.empty();
        }
        int iStatusCode = sseResponseEvent.responseInfo().statusCode();
        if (iStatusCode >= 200 && iStatusCode < 300) {
            try {
                if ("endpoint".equals(sseResponseEvent.sseEvent().event())) {
                    if (this.messageEndpointSink.tryEmitValue(sseResponseEvent.sseEvent().data()).isSuccess()) {
                        monoSink.success();
                        return Flux.empty();
                    }
                    monoSink.error(new RuntimeException("Failed to handle SSE endpoint event"));
                } else {
                    if ("message".equals(sseResponseEvent.sseEvent().event())) {
                        McpSchema.JSONRPCMessage jSONRPCMessageDeserializeJsonRpcMessage = McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sseResponseEvent.sseEvent().data());
                        monoSink.success();
                        return Flux.just(jSONRPCMessageDeserializeJsonRpcMessage);
                    }
                    logger.t("Received unrecognized SSE event type: {}", sseResponseEvent.sseEvent());
                    monoSink.success();
                }
            } catch (IOException e10) {
                monoSink.error(new McpTransportException("Error processing SSE event", e10));
            }
        }
        return Flux.error(new RuntimeException("Failed to send message: " + String.valueOf(sseResponseEvent)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$connect$7(MonoSink monoSink, Throwable th) {
        if (this.isClosing) {
            return true;
        }
        logger.warn("SSE stream observed an error", th);
        monoSink.error(th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$8(SignalType signalType) {
        Disposable andSet = this.sseSubscription.getAndSet(null);
        if (andSet == null || andSet.isDisposed()) {
            return;
        }
        andSet.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$9(final HttpRequest.Builder builder, final Function function, final MonoSink monoSink) {
        this.sseSubscription.set(Flux.create(new Consumer() { // from class: io.modelcontextprotocol.client.transport.s
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33704a.lambda$connect$3(builder, (FluxSink) obj);
            }
        }).map(new Function() { // from class: io.modelcontextprotocol.client.transport.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpClientSseClientTransport.j((ResponseSubscribers.ResponseEvent) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33670a.lambda$connect$5(monoSink, (ResponseSubscribers.SseResponseEvent) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpClientSseClientTransport.k(function, (McpSchema.JSONRPCMessage) obj);
            }
        }).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.client.transport.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f33675a.lambda$connect$7(monoSink, (Throwable) obj);
            }
        }).doFinally(new Consumer() { // from class: io.modelcontextprotocol.client.transport.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33677a.lambda$connect$8((SignalType) obj);
            }
        }).contextWrite(monoSink.contextView()).subscribe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendHttpPost$16(URI uri, String str, ContextView contextView) {
        return Mono.from(this.httpRequestCustomizer.customize(this.requestBuilder.copy().uri(uri).header("Content-Type", "application/json").header("MCP-Protocol-Version", "2024-11-05").POST(HttpRequest.BodyPublishers.ofString(str)), "POST", uri, str, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendHttpPost$17(HttpRequest.Builder builder) {
        return Mono.fromFuture(this.httpClient.sendAsync(builder.build(), HttpResponse.BodyHandlers.ofString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMessage$11(HttpResponse httpResponse, SynchronousSink synchronousSink) {
        if (httpResponse.statusCode() == 200 || httpResponse.statusCode() == 201 || httpResponse.statusCode() == 202 || httpResponse.statusCode() == 206) {
            synchronousSink.next(httpResponse);
            synchronousSink.complete();
            return;
        }
        synchronousSink.error(new RuntimeException("Sending message failed with a non-OK HTTP code: " + httpResponse.statusCode() + " - " + ((String) httpResponse.body())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$12(String str, String str2) {
        return sendHttpPost(str, str2).handle(new BiConsumer() { // from class: io.modelcontextprotocol.client.transport.g
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HttpClientSseClientTransport.lambda$sendMessage$11((HttpResponse) obj, (SynchronousSink) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$13(Throwable th) {
        if (this.isClosing) {
            return;
        }
        logger.u("Error sending message: {}", th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$14(McpSchema.JSONRPCMessage jSONRPCMessage, final String str) {
        return this.isClosing ? Mono.empty() : serializeMessage(jSONRPCMessage).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33693a.lambda$sendMessage$12(str, (String) obj);
            }
        }).doOnError(new Consumer() { // from class: io.modelcontextprotocol.client.transport.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33696a.lambda$sendMessage$13((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$serializeMessage$15(McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            return Mono.just(this.jsonMapper.writeValueAsString(jSONRPCMessage));
        } catch (IOException e10) {
            return Mono.error(new McpTransportException("Failed to serialize message", e10));
        }
    }

    private Mono<HttpResponse<String>> sendHttpPost(String str, final String str2) {
        final URI uriResolveUri = Utils.resolveUri(this.baseUri, str);
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33666a.lambda$sendHttpPost$16(uriResolveUri, str2, (ContextView) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33689a.lambda$sendHttpPost$17((HttpRequest.Builder) obj);
            }
        });
    }

    private Mono<String> serializeMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.client.transport.q
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33701a.lambda$serializeMessage$15(jSONRPCMessage);
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.transport.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f33703a.lambda$closeGracefully$18();
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(final Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        final URI uriResolveUri = Utils.resolveUri(this.baseUri, this.sseEndpoint);
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.transport.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33697a.lambda$connect$0(uriResolveUri, (ContextView) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33699a.lambda$connect$10(function, (HttpRequest.Builder) obj);
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public List<String> protocolVersions() {
        return List.of("2024-11-05");
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.messageEndpointSink.asMono().flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33690a.lambda$sendMessage$14(jSONRPCMessage, (String) obj);
            }
        }).then();
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
        return (T) this.jsonMapper.convertValue(obj, typeRef);
    }

    public static class Builder {
        private String baseUri;
        private McpJsonMapper jsonMapper;
        private String sseEndpoint = "/sse";
        private HttpClient.Builder clientBuilder = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1);
        private HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
        private McpAsyncHttpClientRequestCustomizer httpRequestCustomizer = McpAsyncHttpClientRequestCustomizer.NOOP;
        private Duration connectTimeout = Duration.ofSeconds(10);

        public Builder() {
        }

        public Builder asyncHttpRequestCustomizer(McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer) {
            this.httpRequestCustomizer = mcpAsyncHttpClientRequestCustomizer;
            return this;
        }

        public Builder baseUri(String str) {
            Assert.hasText(str, "baseUri must not be empty");
            this.baseUri = str;
            return this;
        }

        public HttpClientSseClientTransport build() {
            HttpClient httpClientBuild = this.clientBuilder.connectTimeout(this.connectTimeout).build();
            HttpRequest.Builder builder = this.requestBuilder;
            String str = this.baseUri;
            String str2 = this.sseEndpoint;
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpClientSseClientTransport(httpClientBuild, builder, str, str2, mcpJsonMapper, this.httpRequestCustomizer);
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

        public Builder httpRequestCustomizer(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer) {
            this.httpRequestCustomizer = McpAsyncHttpClientRequestCustomizer.fromSync(mcpSyncHttpClientRequestCustomizer);
            return this;
        }

        public Builder jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "jsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public Builder requestBuilder(HttpRequest.Builder builder) {
            Assert.notNull(builder, "requestBuilder must not be null");
            this.requestBuilder = builder;
            return this;
        }

        public Builder sseEndpoint(String str) {
            Assert.hasText(str, "sseEndpoint must not be empty");
            this.sseEndpoint = str;
            return this;
        }

        @Deprecated(forRemoval = true)
        public Builder(String str) {
            Assert.hasText(str, "baseUri must not be empty");
            this.baseUri = str;
        }
    }
}
