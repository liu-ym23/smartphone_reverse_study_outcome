package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportSessionNotFoundException;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class LifecycleInitializer {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6106a = 0;
    private static final rd.b logger = rd.d.b(LifecycleInitializer.class);
    private final McpSchema.ClientCapabilities clientCapabilities;
    private final McpSchema.Implementation clientInfo;
    private final AtomicReference<DefaultInitialization> initializationRef = new AtomicReference<>();
    private final Duration initializationTimeout;
    private final Function<Initialization, Mono<Void>> postInitializationHook;
    private List<String> protocolVersions;
    private final Function<ContextView, McpClientSession> sessionSupplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Initialization {
        McpSchema.InitializeResult initializeResult();

        McpClientSession mcpSession();
    }

    public LifecycleInitializer(McpSchema.ClientCapabilities clientCapabilities, McpSchema.Implementation implementation, List<String> list, Duration duration, Function<ContextView, McpClientSession> function, Function<Initialization, Mono<Void>> function2) {
        Assert.notNull(function, "Session supplier must not be null");
        Assert.notNull(clientCapabilities, "Client capabilities must not be null");
        Assert.notNull(implementation, "Client info must not be null");
        Assert.notEmpty(list, "Protocol versions must not be empty");
        Assert.notNull(duration, "Initialization timeout must not be null");
        Assert.notNull(function2, "Post-initialization hook must not be null");
        this.sessionSupplier = function;
        this.clientCapabilities = clientCapabilities;
        this.clientInfo = implementation;
        this.protocolVersions = Collections.unmodifiableList(new ArrayList(list));
        this.initializationTimeout = duration;
        this.postInitializationHook = function2;
    }

    private Mono<McpSchema.InitializeResult> doInitialize(DefaultInitialization defaultInitialization, Function<Initialization, Mono<Void>> function, ContextView contextView) {
        defaultInitialization.setMcpClientSession(this.sessionSupplier.apply(contextView));
        McpClientSession mcpClientSessionMcpSession = defaultInitialization.mcpSession();
        List<String> list = this.protocolVersions;
        Mono monoSendRequest = mcpClientSessionMcpSession.sendRequest(McpSchema.METHOD_INITIALIZE, new McpSchema.InitializeRequest(list.get(list.size() - 1), this.clientCapabilities, this.clientInfo), McpAsyncClient.INITIALIZE_RESULT_TYPE_REF);
        int i = 0;
        a aVar = new a(i);
        aVar.f6108b = this;
        aVar.f6109c = mcpClientSessionMcpSession;
        VarHandle.storeStoreFence();
        Mono monoFlatMap = monoSendRequest.flatMap(aVar);
        a aVar2 = new a(1);
        aVar2.f6108b = defaultInitialization;
        aVar2.f6109c = function;
        VarHandle.storeStoreFence();
        Mono monoFlatMap2 = monoFlatMap.flatMap(aVar2);
        b bVar = new b(i);
        bVar.f6111f = defaultInitialization;
        VarHandle.storeStoreFence();
        Mono monoDoOnNext = monoFlatMap2.doOnNext(bVar);
        c cVar = new c(i);
        cVar.f6113b = defaultInitialization;
        VarHandle.storeStoreFence();
        return monoDoOnNext.onErrorResume(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$7() {
        DefaultInitialization andSet = this.initializationRef.getAndSet(null);
        return andSet != null ? andSet.closeGracefully() : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$doInitialize$4(McpClientSession mcpClientSession, McpSchema.InitializeResult initializeResult) {
        logger.info("Server response with Protocol: {}, Capabilities: {}, Info: {} and Instructions {}", initializeResult.protocolVersion(), initializeResult.capabilities(), initializeResult.serverInfo(), initializeResult.instructions());
        if (this.protocolVersions.contains(initializeResult.protocolVersion())) {
            return mcpClientSession.sendNotification(McpSchema.METHOD_NOTIFICATION_INITIALIZED, null).thenReturn(initializeResult);
        }
        return Mono.error(McpError.builder(McpSchema.ErrorCodes.INVALID_PARAMS).message("Unsupported protocol version").data("Unsupported protocol version from the server: " + initializeResult.protocolVersion()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$doInitialize$5(DefaultInitialization defaultInitialization, Function function, McpSchema.InitializeResult initializeResult) {
        defaultInitialization.cacheResult(initializeResult);
        return ((Mono) function.apply(defaultInitialization)).thenReturn(initializeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$doInitialize$6(DefaultInitialization defaultInitialization, Throwable th) {
        defaultInitialization.error(th);
        return Mono.error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$handleException$0(Initialization initialization) {
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ DefaultInitialization lambda$withInitialization$1(McpSchema.InitializeResult initializeResult) {
        return this.initializationRef.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$withInitialization$2(DefaultInitialization defaultInitialization, String str, Throwable th) {
        this.initializationRef.compareAndSet(defaultInitialization, null);
        return Mono.error(new RuntimeException(w2.c.b("Client failed to initialize ", str), th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$withInitialization$3(String str, Function function, ContextView contextView) {
        int i = 0;
        DefaultInitialization defaultInitialization = new DefaultInitialization(i);
        DefaultInitialization defaultInitializationCompareAndExchange = this.initializationRef.compareAndExchange(null, defaultInitialization);
        int i3 = 1;
        boolean z10 = defaultInitializationCompareAndExchange == null;
        logger.debug(z10 ? "Initialization process started" : "Joining previous initialization");
        Mono<McpSchema.InitializeResult> monoDoInitialize = z10 ? doInitialize(defaultInitialization, this.postInitializationHook, contextView) : defaultInitializationCompareAndExchange.await();
        c cVar = new c(i3);
        cVar.f6113b = this;
        VarHandle.storeStoreFence();
        Mono monoTimeout = monoDoInitialize.map(cVar).timeout(this.initializationTimeout);
        f fVar = new f(i);
        fVar.f6118b = this;
        fVar.f6120d = defaultInitialization;
        fVar.f6119c = str;
        VarHandle.storeStoreFence();
        return monoTimeout.onErrorResume(fVar).flatMap(function);
    }

    public void close() {
        DefaultInitialization andSet = this.initializationRef.getAndSet(null);
        if (andSet != null) {
            andSet.close();
        }
    }

    public Mono<?> closeGracefully() {
        e eVar = new e(0);
        eVar.f6116f = this;
        VarHandle.storeStoreFence();
        return Mono.defer(eVar);
    }

    public McpSchema.InitializeResult currentInitializationResult() {
        DefaultInitialization defaultInitialization = this.initializationRef.get();
        if (defaultInitialization != null) {
            return (McpSchema.InitializeResult) defaultInitialization.result.get();
        }
        return null;
    }

    public void handleException(Throwable th) {
        logger.warn("Handling exception", th);
        if (th instanceof McpTransportSessionNotFoundException) {
            DefaultInitialization andSet = this.initializationRef.getAndSet(null);
            if (andSet != null) {
                andSet.close();
            }
            withInitialization("re-initializing", new d(0)).subscribe();
        }
    }

    public boolean isInitialized() {
        return currentInitializationResult() != null;
    }

    public void setProtocolVersions(List<String> list) {
        this.protocolVersions = list;
    }

    public <T> Mono<T> withInitialization(String str, Function<Initialization, Mono<T>> function) {
        f fVar = new f(1);
        fVar.f6118b = this;
        fVar.f6119c = str;
        fVar.f6120d = function;
        VarHandle.storeStoreFence();
        return Mono.deferContextual(fVar);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class DefaultInitialization implements Initialization {
        private final Sinks.One<McpSchema.InitializeResult> initSink;
        private final AtomicReference<McpClientSession> mcpClientSession;
        private final AtomicReference<McpSchema.InitializeResult> result;

        private DefaultInitialization() {
            this.initSink = Sinks.one();
            this.result = new AtomicReference<>();
            this.mcpClientSession = new AtomicReference<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Mono<McpSchema.InitializeResult> await() {
            return this.initSink.asMono();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cacheResult(McpSchema.InitializeResult initializeResult) {
            this.result.set(initializeResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close() {
            mcpSession().close();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Mono<Void> closeGracefully() {
            return mcpSession().closeGracefully();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void complete(McpSchema.InitializeResult initializeResult) {
            this.initSink.emitValue(initializeResult, Sinks.EmitFailureHandler.FAIL_FAST);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void error(Throwable th) {
            this.initSink.emitError(th, Sinks.EmitFailureHandler.FAIL_FAST);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMcpClientSession(McpClientSession mcpClientSession) {
            this.mcpClientSession.set(mcpClientSession);
        }

        @Override // io.modelcontextprotocol.client.LifecycleInitializer.Initialization
        public McpSchema.InitializeResult initializeResult() {
            return this.result.get();
        }

        @Override // io.modelcontextprotocol.client.LifecycleInitializer.Initialization
        public McpClientSession mcpSession() {
            return this.mcpClientSession.get();
        }

        public /* synthetic */ DefaultInitialization(int i) {
            this();
        }
    }
}
