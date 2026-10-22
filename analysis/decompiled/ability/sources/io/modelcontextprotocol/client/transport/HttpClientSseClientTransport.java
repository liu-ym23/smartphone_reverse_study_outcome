package io.modelcontextprotocol.client.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
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
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SignalType;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* loaded from: classes2.dex */
public class HttpClientSseClientTransport implements McpClientTransport {
    private static final String DEFAULT_SSE_ENDPOINT = "/sse";
    private static final String ENDPOINT_EVENT_TYPE = "endpoint";
    private static final String MCP_PROTOCOL_VERSION = "2024-11-05";
    private static final String MCP_PROTOCOL_VERSION_HEADER_NAME = "MCP-Protocol-Version";
    private static final String MESSAGE_EVENT_TYPE = "message";
    private static final InterfaceC0315b logger = AbstractC0317d.b(HttpClientSseClientTransport.class);
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
        return Mono.from(this.httpRequestCustomizer.customize(this.requestBuilder.copy().uri(uri).header("Accept", "text/event-stream").header(HttpHeaders.CACHE_CONTROL, "no-cache").header("MCP-Protocol-Version", "2024-11-05").GET(), "GET", uri, null, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$connect$10(final Function function, final HttpRequest.Builder builder) {
        return Mono.create(new Consumer() { // from class: io.modelcontextprotocol.client.transport.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f4666a.lambda$connect$9(builder, function, (MonoSink) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletionStage lambda$connect$2(FluxSink fluxSink, Throwable th) {
        fluxSink.error(th);
        return CompletableFuture.failedFuture(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$3(HttpRequest.Builder builder, FluxSink fluxSink) {
        this.httpClient.sendAsync(builder.build(), new C1580h(fluxSink)).exceptionallyCompose((Function) new C1581i(fluxSink, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResponseSubscribers.SseResponseEvent lambda$connect$4(ResponseSubscribers.ResponseEvent responseEvent) {
        return (ResponseSubscribers.SseResponseEvent) responseEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Z9.c lambda$connect$5(MonoSink monoSink, ResponseSubscribers.SseResponseEvent sseResponseEvent) {
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
                    logger.j(sseResponseEvent.sseEvent(), "Received unrecognized SSE event type: {}");
                    monoSink.success();
                }
            } catch (IOException e) {
                monoSink.error(new McpTransportException("Error processing SSE event", e));
            }
        }
        return Flux.error(new RuntimeException("Failed to send message: ".concat(String.valueOf(sseResponseEvent))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$connect$6(Function function, McpSchema.JSONRPCMessage jSONRPCMessage) {
        return (Z9.c) function.apply(Mono.just(jSONRPCMessage));
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
    public /* synthetic */ void lambda$connect$9(HttpRequest.Builder builder, Function function, MonoSink monoSink) {
        int i = 0;
        int i6 = 0;
        this.sseSubscription.set(Flux.create(new C1573a(this, builder, i)).map(new C1574b(i)).flatMap(new C1575c(this, monoSink, i)).flatMap(new C1576d(i, function)).onErrorComplete(new C1577e(this, monoSink, i6)).doFinally(new C1578f(this, i6)).contextWrite(monoSink.contextView()).subscribe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendHttpPost$16(URI uri, String str, ContextView contextView) {
        return Mono.from(this.httpRequestCustomizer.customize(this.requestBuilder.copy().uri(uri).header(HttpHeaders.CONTENT_TYPE, "application/json").header("MCP-Protocol-Version", "2024-11-05").POST(HttpRequest.BodyPublishers.ofString(str)), "POST", uri, str, (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendHttpPost$17(HttpRequest.Builder builder) {
        return Mono.fromFuture(this.httpClient.sendAsync(builder.build(), HttpResponse.BodyHandlers.ofString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMessage$11(HttpResponse httpResponse, SynchronousSink synchronousSink) {
        if (httpResponse.statusCode() != 200 && httpResponse.statusCode() != 201 && httpResponse.statusCode() != 202 && httpResponse.statusCode() != 206) {
            synchronousSink.error(new RuntimeException(androidx.constraintlayout.core.dsl.a.c(httpResponse.statusCode(), "Sending message failed with a non-OK HTTP code: ", " - ", (String) httpResponse.body())));
        } else {
            synchronousSink.next(httpResponse);
            synchronousSink.complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$12(String str, String str2) {
        return sendHttpPost(str, str2).handle(new C1579g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$13(Throwable th) {
        if (this.isClosing) {
            return;
        }
        logger.e(th.getMessage(), "Error sending message: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$14(McpSchema.JSONRPCMessage jSONRPCMessage, String str) {
        return this.isClosing ? Mono.empty() : serializeMessage(jSONRPCMessage).flatMap(new C1575c(this, str, 2)).doOnError(new C1578f(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$serializeMessage$15(McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            return Mono.just(this.jsonMapper.writeValueAsString(jSONRPCMessage));
        } catch (IOException e) {
            return Mono.error(new McpTransportException("Failed to serialize message", e));
        }
    }

    private Mono<HttpResponse<String>> sendHttpPost(String str, String str2) {
        return Mono.deferContextual(new r(this, Utils.resolveUri(this.baseUri, str), str2, 2)).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f4667a.lambda$sendHttpPost$17((HttpRequest.Builder) obj);
            }
        });
    }

    private Mono<String> serializeMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.defer(new o(this, jSONRPCMessage, 1));
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        return Mono.fromRunnable(new E(this, 5));
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(final Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        return Mono.deferContextual(new C1575c(this, Utils.resolveUri(this.baseUri, this.sseEndpoint), 3)).flatMap(new Function() { // from class: io.modelcontextprotocol.client.transport.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f4668a.lambda$connect$10(function, (HttpRequest.Builder) obj);
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public List<String> protocolVersions() {
        return List.of("2024-11-05");
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.messageEndpointSink.asMono().flatMap(new C1575c(this, jSONRPCMessage, 1)).then();
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
