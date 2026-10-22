package io.modelcontextprotocol.client.transport;

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
import java.lang.invoke.VarHandle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class HttpClientSseClientTransport implements McpClientTransport {
    private static final String DEFAULT_SSE_ENDPOINT = "/sse";
    private static final String ENDPOINT_EVENT_TYPE = "endpoint";
    private static final String MCP_PROTOCOL_VERSION = "2024-11-05";
    private static final String MCP_PROTOCOL_VERSION_HEADER_NAME = "MCP-Protocol-Version";
    private static final String MESSAGE_EVENT_TYPE = "message";
    private static final rd.b logger = rd.d.b(HttpClientSseClientTransport.class);
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
    public /* synthetic */ Mono lambda$connect$10(Function function, HttpRequest.Builder builder) {
        j jVar = new j();
        jVar.f6185c = this;
        jVar.f6186f = builder;
        jVar.f6187g = function;
        VarHandle.storeStoreFence();
        return Mono.create(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CompletionStage lambda$connect$2(FluxSink fluxSink, Throwable th) {
        fluxSink.error(th);
        return CompletableFuture.failedFuture(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$3(HttpRequest.Builder builder, FluxSink fluxSink) {
        HttpClient httpClient = this.httpClient;
        HttpRequest httpRequestBuild = builder.build();
        h hVar = new h();
        hVar.f6179a = fluxSink;
        VarHandle.storeStoreFence();
        CompletableFuture completableFutureSendAsync = httpClient.sendAsync(httpRequestBuild, hVar);
        i iVar = new i(0);
        iVar.f6182b = fluxSink;
        VarHandle.storeStoreFence();
        completableFutureSendAsync.exceptionallyCompose((Function) iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ResponseSubscribers.SseResponseEvent lambda$connect$4(ResponseSubscribers.ResponseEvent responseEvent) {
        return (ResponseSubscribers.SseResponseEvent) responseEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qd.c lambda$connect$5(MonoSink monoSink, ResponseSubscribers.SseResponseEvent sseResponseEvent) {
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
                    logger.h(sseResponseEvent.sseEvent(), "Received unrecognized SSE event type: {}");
                    monoSink.success();
                }
            } catch (IOException e10) {
                monoSink.error(new McpTransportException("Error processing SSE event", e10));
            }
        }
        return Flux.error(new RuntimeException("Failed to send message: ".concat(String.valueOf(sseResponseEvent))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$connect$6(Function function, McpSchema.JSONRPCMessage jSONRPCMessage) {
        return (qd.c) function.apply(Mono.just(jSONRPCMessage));
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
        a aVar = new a(i);
        aVar.f6150f = this;
        aVar.f6151g = builder;
        VarHandle.storeStoreFence();
        Flux map = Flux.create(aVar).map(new b(i));
        c cVar = new c(i);
        cVar.f6162b = this;
        cVar.f6163c = monoSink;
        VarHandle.storeStoreFence();
        Flux fluxFlatMap = map.flatMap(cVar);
        d dVar = new d(i);
        dVar.f6167b = function;
        VarHandle.storeStoreFence();
        Flux fluxFlatMap2 = fluxFlatMap.flatMap(dVar);
        e eVar = new e(i);
        eVar.f6171g = this;
        eVar.f6170f = monoSink;
        VarHandle.storeStoreFence();
        Flux fluxOnErrorComplete = fluxFlatMap2.onErrorComplete(eVar);
        f fVar = new f(i);
        fVar.f6175f = this;
        VarHandle.storeStoreFence();
        this.sseSubscription.set(fluxOnErrorComplete.doFinally(fVar).contextWrite(monoSink.contextView()).subscribe());
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
        if (httpResponse.statusCode() == 200 || httpResponse.statusCode() == 201 || httpResponse.statusCode() == 202 || httpResponse.statusCode() == 206) {
            synchronousSink.next(httpResponse);
            synchronousSink.complete();
            return;
        }
        synchronousSink.error(new RuntimeException("Sending message failed with a non-OK HTTP code: " + httpResponse.statusCode() + " - " + ((String) httpResponse.body())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$12(String str, String str2) {
        return sendHttpPost(str, str2).handle(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$13(Throwable th) {
        if (this.isClosing) {
            return;
        }
        logger.f(th.getMessage(), "Error sending message: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendMessage$14(McpSchema.JSONRPCMessage jSONRPCMessage, String str) {
        if (this.isClosing) {
            return Mono.empty();
        }
        Mono<String> monoSerializeMessage = serializeMessage(jSONRPCMessage);
        c cVar = new c(2);
        cVar.f6162b = this;
        cVar.f6163c = str;
        VarHandle.storeStoreFence();
        Mono<R> monoFlatMap = monoSerializeMessage.flatMap(cVar);
        f fVar = new f(1);
        fVar.f6175f = this;
        VarHandle.storeStoreFence();
        return monoFlatMap.doOnError(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$serializeMessage$15(McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            return Mono.just(this.jsonMapper.writeValueAsString(jSONRPCMessage));
        } catch (IOException e10) {
            return Mono.error(new McpTransportException("Failed to serialize message", e10));
        }
    }

    private Mono<HttpResponse<String>> sendHttpPost(String str, String str2) {
        URI uriResolveUri = Utils.resolveUri(this.baseUri, str);
        r rVar = new r(2);
        rVar.f6203b = this;
        rVar.f6204c = uriResolveUri;
        rVar.f6205d = str2;
        VarHandle.storeStoreFence();
        Mono monoDeferContextual = Mono.deferContextual(rVar);
        k kVar = new k();
        kVar.f6190a = this;
        VarHandle.storeStoreFence();
        return monoDeferContextual.flatMap(kVar);
    }

    private Mono<String> serializeMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        o oVar = new o(1);
        oVar.f6198f = this;
        oVar.f6199g = jSONRPCMessage;
        VarHandle.storeStoreFence();
        return Mono.defer(oVar);
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        e0 e0Var = new e0(5);
        e0Var.f6173f = this;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(e0Var);
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        URI uriResolveUri = Utils.resolveUri(this.baseUri, this.sseEndpoint);
        c cVar = new c(3);
        cVar.f6162b = this;
        cVar.f6163c = uriResolveUri;
        VarHandle.storeStoreFence();
        Mono monoDeferContextual = Mono.deferContextual(cVar);
        l lVar = new l();
        lVar.f6191a = this;
        lVar.f6192b = function;
        VarHandle.storeStoreFence();
        return monoDeferContextual.flatMap(lVar);
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public List<String> protocolVersions() {
        return List.of("2024-11-05");
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        Mono<String> monoAsMono = this.messageEndpointSink.asMono();
        c cVar = new c(1);
        cVar.f6162b = this;
        cVar.f6163c = jSONRPCMessage;
        VarHandle.storeStoreFence();
        return monoAsMono.flatMap(cVar).then();
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
        return (T) this.jsonMapper.convertValue(obj, typeRef);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private String baseUri;
        private McpJsonMapper jsonMapper;
        private String sseEndpoint = "/sse";
        private HttpClient.Builder clientBuilder = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1);
        private HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
        private McpAsyncHttpClientRequestCustomizer httpRequestCustomizer = McpAsyncHttpClientRequestCustomizer.NOOP;
        private Duration connectTimeout = Duration.ofSeconds(10);

        @Deprecated(forRemoval = true)
        public Builder(String str) {
            Assert.hasText(str, "baseUri must not be empty");
            this.baseUri = str;
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

        public Builder() {
        }
    }
}
