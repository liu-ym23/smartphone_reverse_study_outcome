package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportSessionNotFoundException;
import io.modelcontextprotocol.util.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
class LifecycleInitializer {
    private static final vc.c logger = vc.e.l(LifecycleInitializer.class);
    private final McpSchema.ClientCapabilities clientCapabilities;
    private final McpSchema.Implementation clientInfo;
    private final AtomicReference<DefaultInitialization> initializationRef = new AtomicReference<>();
    private final Duration initializationTimeout;
    private final Function<Initialization, Mono<Void>> postInitializationHook;
    private List<String> protocolVersions;
    private final Function<ContextView, McpClientSession> sessionSupplier;

    public static class DefaultInitialization implements Initialization {
        private final Sinks.One<McpSchema.InitializeResult> initSink;
        private final AtomicReference<McpClientSession> mcpClientSession;
        private final AtomicReference<McpSchema.InitializeResult> result;

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

        private DefaultInitialization() {
            this.initSink = Sinks.one();
            this.result = new AtomicReference<>();
            this.mcpClientSession = new AtomicReference<>();
        }
    }

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

    private Mono<McpSchema.InitializeResult> doInitialize(final DefaultInitialization defaultInitialization, final Function<Initialization, Mono<Void>> function, ContextView contextView) {
        defaultInitialization.setMcpClientSession(this.sessionSupplier.apply(contextView));
        final McpClientSession mcpClientSessionMcpSession = defaultInitialization.mcpSession();
        return mcpClientSessionMcpSession.sendRequest(McpSchema.METHOD_INITIALIZE, new McpSchema.InitializeRequest(this.protocolVersions.get(r0.size() - 1), this.clientCapabilities, this.clientInfo), McpAsyncClient.INITIALIZE_RESULT_TYPE_REF).flatMap(new Function() { // from class: io.modelcontextprotocol.client.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33582a.lambda$doInitialize$4(mcpClientSessionMcpSession, (McpSchema.InitializeResult) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.client.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LifecycleInitializer.f(defaultInitialization, function, (McpSchema.InitializeResult) obj);
            }
        }).doOnNext(new Consumer() { // from class: io.modelcontextprotocol.client.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                defaultInitialization.complete((McpSchema.InitializeResult) obj);
            }
        }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.client.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LifecycleInitializer.g(defaultInitialization, (Throwable) obj);
            }
        });
    }

    public static /* synthetic */ Mono f(DefaultInitialization defaultInitialization, Function function, McpSchema.InitializeResult initializeResult) {
        defaultInitialization.cacheResult(initializeResult);
        return ((Mono) function.apply(defaultInitialization)).thenReturn(initializeResult);
    }

    public static /* synthetic */ Mono g(DefaultInitialization defaultInitialization, Throwable th) {
        defaultInitialization.error(th);
        return Mono.error(th);
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
    public /* synthetic */ DefaultInitialization lambda$withInitialization$1(McpSchema.InitializeResult initializeResult) {
        return this.initializationRef.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$withInitialization$2(DefaultInitialization defaultInitialization, String str, Throwable th) {
        this.initializationRef.compareAndSet(defaultInitialization, null);
        return Mono.error(new RuntimeException("Client failed to initialize " + str, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$withInitialization$3(final String str, Function function, ContextView contextView) {
        final DefaultInitialization defaultInitialization = new DefaultInitialization();
        DefaultInitialization defaultInitializationCompareAndExchange = this.initializationRef.compareAndExchange(null, defaultInitialization);
        boolean z10 = defaultInitializationCompareAndExchange == null;
        logger.debug(z10 ? "Initialization process started" : "Joining previous initialization");
        return (z10 ? doInitialize(defaultInitialization, this.postInitializationHook, contextView) : defaultInitializationCompareAndExchange.await()).map(new Function() { // from class: io.modelcontextprotocol.client.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33592a.lambda$withInitialization$1((McpSchema.InitializeResult) obj);
            }
        }).timeout(this.initializationTimeout).onErrorResume(new Function() { // from class: io.modelcontextprotocol.client.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33594a.lambda$withInitialization$2(defaultInitialization, str, (Throwable) obj);
            }
        }).flatMap(function);
    }

    public void close() {
        DefaultInitialization andSet = this.initializationRef.getAndSet(null);
        if (andSet != null) {
            andSet.close();
        }
    }

    public Mono<?> closeGracefully() {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.client.f
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33591a.lambda$closeGracefully$7();
            }
        });
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
            withInitialization("re-initializing", new Function() { // from class: io.modelcontextprotocol.client.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Mono.empty();
                }
            }).subscribe();
        }
    }

    public boolean isInitialized() {
        return currentInitializationResult() != null;
    }

    public void setProtocolVersions(List<String> list) {
        this.protocolVersions = list;
    }

    public <T> Mono<T> withInitialization(final String str, final Function<Initialization, Mono<T>> function) {
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.client.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33599a.lambda$withInitialization$3(str, function, (ContextView) obj);
            }
        });
    }
}
