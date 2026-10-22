package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.client.b1;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpInitRequestHandler;
import io.modelcontextprotocol.server.McpNotificationHandler;
import io.modelcontextprotocol.server.McpRequestHandler;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
public class McpServerSession implements McpLoggableSession {
    private static final int STATE_INITIALIZED = 2;
    private static final int STATE_INITIALIZING = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private static final vc.c logger = vc.e.l(McpServerSession.class);
    private final String id;
    private final McpInitRequestHandler initRequestHandler;
    private final Map<String, McpNotificationHandler> notificationHandlers;
    private final Map<String, McpRequestHandler<?>> requestHandlers;
    private final Duration requestTimeout;
    private final McpServerTransport transport;
    private final ConcurrentHashMap<Object, MonoSink<McpSchema.JSONRPCResponse>> pendingResponses = new ConcurrentHashMap<>();
    private final AtomicLong requestCounter = new AtomicLong(0);
    private final Sinks.One<McpAsyncServerExchange> exchangeSink = Sinks.one();
    private final AtomicReference<McpSchema.ClientCapabilities> clientCapabilities = new AtomicReference<>();
    private final AtomicReference<McpSchema.Implementation> clientInfo = new AtomicReference<>();
    private final AtomicInteger state = new AtomicInteger(0);
    private volatile McpSchema.LoggingLevel minLoggingLevel = McpSchema.LoggingLevel.INFO;

    @FunctionalInterface
    public interface Factory {
        McpServerSession create(McpServerTransport mcpServerTransport);
    }

    public interface InitNotificationHandler {
        Mono<Void> handle();
    }

    @Deprecated
    public interface InitRequestHandler {
        Mono<McpSchema.InitializeResult> handle(McpSchema.InitializeRequest initializeRequest);
    }

    public static final class MethodNotFoundError extends W8.a {
        private final Object data;
        private final String message;
        private final String method;

        public MethodNotFoundError(String str, String str2, Object obj) {
            this.method = str;
            this.message = str2;
            this.data = obj;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof MethodNotFoundError)) {
                return false;
            }
            MethodNotFoundError methodNotFoundError = (MethodNotFoundError) obj;
            return Objects.equals(this.method, methodNotFoundError.method) && Objects.equals(this.message, methodNotFoundError.message) && Objects.equals(this.data, methodNotFoundError.data);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.method, this.message, this.data};
        }

        public Object data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return io.modelcontextprotocol.client.transport.k0.a(this.method, this.message, this.data);
        }

        public String message() {
            return this.message;
        }

        public String method() {
            return this.method;
        }

        public final String toString() {
            return b1.a(b(), MethodNotFoundError.class, "method;message;data");
        }
    }

    @Deprecated
    public interface NotificationHandler {
        Mono<Void> handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj);
    }

    @Deprecated
    public interface RequestHandler<T> {
        Mono<T> handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj);
    }

    public McpServerSession(String str, Duration duration, McpServerTransport mcpServerTransport, McpInitRequestHandler mcpInitRequestHandler, Map<String, McpRequestHandler<?>> map, Map<String, McpNotificationHandler> map2) {
        this.id = str;
        this.requestTimeout = duration;
        this.transport = mcpServerTransport;
        this.initRequestHandler = mcpInitRequestHandler;
        this.requestHandlers = map;
        this.notificationHandlers = map2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ reactor.core.publisher.Mono a(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r3, java.lang.Throwable r4) {
        /*
            boolean r0 = r4 instanceof io.modelcontextprotocol.spec.McpError
            if (r0 == 0) goto L12
            r0 = r4
            io.modelcontextprotocol.spec.McpError r0 = (io.modelcontextprotocol.spec.McpError) r0
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r1 = r0.getJsonRpcError()
            if (r1 == 0) goto L12
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r4 = r0.getJsonRpcError()
            goto L26
        L12:
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r0 = new io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError
            r1 = -32603(0xffffffffffff80a5, float:NaN)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = r4.getMessage()
            java.lang.String r4 = io.modelcontextprotocol.spec.McpError.aggregateExceptionMessages(r4)
            r0.<init>(r1, r2, r4)
            r4 = r0
        L26:
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse r0 = new io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse
            java.lang.Object r3 = r3.id()
            r1 = 0
            java.lang.String r2 = "2.0"
            r0.<init>(r2, r3, r1, r4)
            reactor.core.publisher.Mono r3 = reactor.core.publisher.Mono.just(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.spec.McpServerSession.a(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    private McpAsyncServerExchange copyExchange(McpAsyncServerExchange mcpAsyncServerExchange, McpTransportContext mcpTransportContext) {
        return new McpAsyncServerExchange(mcpAsyncServerExchange.sessionId(), this, mcpAsyncServerExchange.getClientCapabilities(), mcpAsyncServerExchange.getClientInfo(), mcpTransportContext);
    }

    public static /* synthetic */ McpSchema.JSONRPCResponse d(McpSchema.JSONRPCRequest jSONRPCRequest, Object obj) {
        return new McpSchema.JSONRPCResponse("2.0", jSONRPCRequest.id(), obj, null);
    }

    private String generateRequestId() {
        return this.id + O6.l.DATE_SEPARATOR + this.requestCounter.getAndIncrement();
    }

    private MethodNotFoundError getMethodNotFoundError(String str) {
        return new MethodNotFoundError(str, "Method not found: " + str, null);
    }

    private Mono<Void> handleIncomingNotification(final McpSchema.JSONRPCNotification jSONRPCNotification, final McpTransportContext mcpTransportContext) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.spec.F
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f34104a.lambda$handleIncomingNotification$12(jSONRPCNotification, mcpTransportContext);
            }
        });
    }

    private Mono<McpSchema.JSONRPCResponse> handleIncomingRequest(final McpSchema.JSONRPCRequest jSONRPCRequest, final McpTransportContext mcpTransportContext) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.spec.M
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f34122a.lambda$handleIncomingRequest$10(jSONRPCRequest, mcpTransportContext);
            }
        });
    }

    public static /* synthetic */ void j(Void r02) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ reactor.core.publisher.Mono lambda$handle$4(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r4, java.lang.Throwable r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof io.modelcontextprotocol.spec.McpError
            if (r0 == 0) goto L12
            r0 = r5
            io.modelcontextprotocol.spec.McpError r0 = (io.modelcontextprotocol.spec.McpError) r0
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r1 = r0.getJsonRpcError()
            if (r1 == 0) goto L12
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r5 = r0.getJsonRpcError()
            goto L26
        L12:
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r0 = new io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError
            r1 = -32603(0xffffffffffff80a5, float:NaN)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = r5.getMessage()
            java.lang.String r5 = io.modelcontextprotocol.spec.McpError.aggregateExceptionMessages(r5)
            r0.<init>(r1, r2, r5)
            r5 = r0
        L26:
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse r0 = new io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse
            java.lang.Object r4 = r4.id()
            r1 = 0
            java.lang.String r2 = "2.0"
            r0.<init>(r2, r4, r1, r5)
            io.modelcontextprotocol.spec.McpServerTransport r3 = r3.transport
            reactor.core.publisher.Mono r3 = r3.sendMessage(r0)
            reactor.core.publisher.Mono r4 = reactor.core.publisher.Mono.empty()
            reactor.core.publisher.Mono r3 = r3.then(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.spec.McpServerSession.lambda$handle$4(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handle$6(McpSchema.JSONRPCMessage jSONRPCMessage, ContextView contextView) {
        McpTransportContext mcpTransportContext = (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY);
        if (jSONRPCMessage instanceof McpSchema.JSONRPCResponse) {
            McpSchema.JSONRPCResponse jSONRPCResponse = (McpSchema.JSONRPCResponse) jSONRPCMessage;
            vc.c cVar = logger;
            cVar.t("Received response: {}", jSONRPCResponse);
            if (jSONRPCResponse.id() != null) {
                MonoSink<McpSchema.JSONRPCResponse> monoSinkRemove = this.pendingResponses.remove(jSONRPCResponse.id());
                if (monoSinkRemove == null) {
                    cVar.j("Unexpected response for unknown id {}", jSONRPCResponse.id());
                } else {
                    monoSinkRemove.success(jSONRPCResponse);
                }
            } else {
                cVar.error("Discarded MCP request response without session id. This is an indication of a bug in the request sender code that can lead to memory leaks as pending requests will never be completed.");
            }
            return Mono.empty();
        }
        if (jSONRPCMessage instanceof McpSchema.JSONRPCRequest) {
            final McpSchema.JSONRPCRequest jSONRPCRequest = (McpSchema.JSONRPCRequest) jSONRPCMessage;
            logger.t("Received request: {}", jSONRPCRequest);
            Mono<McpSchema.JSONRPCResponse> monoOnErrorResume = handleIncomingRequest(jSONRPCRequest, mcpTransportContext).onErrorResume(new Function() { // from class: io.modelcontextprotocol.spec.N
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f34125a.lambda$handle$4(jSONRPCRequest, (Throwable) obj);
                }
            });
            final McpServerTransport mcpServerTransport = this.transport;
            Objects.requireNonNull(mcpServerTransport);
            return monoOnErrorResume.flatMap(new Function() { // from class: io.modelcontextprotocol.spec.O
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return mcpServerTransport.sendMessage((McpSchema.JSONRPCResponse) obj);
                }
            });
        }
        if (!(jSONRPCMessage instanceof McpSchema.JSONRPCNotification)) {
            logger.j("Received unknown message type: {}", jSONRPCMessage);
            return Mono.empty();
        }
        McpSchema.JSONRPCNotification jSONRPCNotification = (McpSchema.JSONRPCNotification) jSONRPCMessage;
        logger.t("Received notification: {}", jSONRPCNotification);
        return handleIncomingNotification(jSONRPCNotification, mcpTransportContext).doOnError(new Consumer() { // from class: io.modelcontextprotocol.spec.P
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                McpServerSession.logger.u("Error handling notification: {}", ((Throwable) obj).getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingNotification$11(McpNotificationHandler mcpNotificationHandler, McpTransportContext mcpTransportContext, McpSchema.JSONRPCNotification jSONRPCNotification, McpAsyncServerExchange mcpAsyncServerExchange) {
        return mcpNotificationHandler.handle(copyExchange(mcpAsyncServerExchange, mcpTransportContext), jSONRPCNotification.params());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingNotification$12(final McpSchema.JSONRPCNotification jSONRPCNotification, McpTransportContext mcpTransportContext) {
        final McpServerSession mcpServerSession;
        final McpTransportContext mcpTransportContext2;
        if (McpSchema.METHOD_NOTIFICATION_INITIALIZED.equals(jSONRPCNotification.method())) {
            this.state.lazySet(2);
            mcpServerSession = this;
            mcpTransportContext2 = mcpTransportContext;
            this.exchangeSink.tryEmitValue(new McpAsyncServerExchange(this.id, mcpServerSession, this.clientCapabilities.get(), this.clientInfo.get(), mcpTransportContext2));
        } else {
            mcpServerSession = this;
            mcpTransportContext2 = mcpTransportContext;
        }
        final McpNotificationHandler mcpNotificationHandler = mcpServerSession.notificationHandlers.get(jSONRPCNotification.method());
        if (mcpNotificationHandler != null) {
            return mcpServerSession.exchangeSink.asMono().flatMap(new Function() { // from class: io.modelcontextprotocol.spec.G
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f34107a.lambda$handleIncomingNotification$11(mcpNotificationHandler, mcpTransportContext2, jSONRPCNotification, (McpAsyncServerExchange) obj);
                }
            });
        }
        logger.j("No handler registered for notification method: {}", jSONRPCNotification);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingRequest$10(final McpSchema.JSONRPCRequest jSONRPCRequest, final McpTransportContext mcpTransportContext) {
        Mono monoFlatMap;
        if (McpSchema.METHOD_INITIALIZE.equals(jSONRPCRequest.method())) {
            McpSchema.InitializeRequest initializeRequest = (McpSchema.InitializeRequest) this.transport.unmarshalFrom(jSONRPCRequest.params(), new TypeRef<McpSchema.InitializeRequest>() { // from class: io.modelcontextprotocol.spec.McpServerSession.1
            });
            this.state.lazySet(1);
            init(initializeRequest.capabilities(), initializeRequest.clientInfo());
            monoFlatMap = this.initRequestHandler.handle(initializeRequest);
        } else {
            final McpRequestHandler<?> mcpRequestHandler = this.requestHandlers.get(jSONRPCRequest.method());
            if (mcpRequestHandler == null) {
                MethodNotFoundError methodNotFoundError = getMethodNotFoundError(jSONRPCRequest.method());
                return Mono.just(new McpSchema.JSONRPCResponse("2.0", jSONRPCRequest.id(), null, new McpSchema.JSONRPCResponse.JSONRPCError(Integer.valueOf(McpSchema.ErrorCodes.METHOD_NOT_FOUND), methodNotFoundError.message(), methodNotFoundError.data())));
            }
            monoFlatMap = this.exchangeSink.asMono().flatMap(new Function() { // from class: io.modelcontextprotocol.spec.Q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f34128a.lambda$handleIncomingRequest$7(mcpRequestHandler, mcpTransportContext, jSONRPCRequest, (McpAsyncServerExchange) obj);
                }
            });
        }
        return monoFlatMap.map(new Function() { // from class: io.modelcontextprotocol.spec.S
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpServerSession.d(jSONRPCRequest, obj);
            }
        }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.spec.T
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpServerSession.a(jSONRPCRequest, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingRequest$7(McpRequestHandler mcpRequestHandler, McpTransportContext mcpTransportContext, McpSchema.JSONRPCRequest jSONRPCRequest, McpAsyncServerExchange mcpAsyncServerExchange) {
        return mcpRequestHandler.handle(copyExchange(mcpAsyncServerExchange, mcpTransportContext), jSONRPCRequest.params());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$1(String str, MonoSink monoSink, Throwable th) {
        this.pendingResponses.remove(str);
        monoSink.error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$2(final String str, String str2, Object obj, final MonoSink monoSink) {
        this.pendingResponses.put(str, monoSink);
        this.transport.sendMessage(new McpSchema.JSONRPCRequest("2.0", str2, str, obj)).subscribe(new Consumer() { // from class: io.modelcontextprotocol.spec.H
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                McpServerSession.j((Void) obj2);
            }
        }, new Consumer() { // from class: io.modelcontextprotocol.spec.I
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                this.f34111a.lambda$sendRequest$1(str, monoSink, (Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$3(TypeRef typeRef, McpSchema.JSONRPCResponse jSONRPCResponse, SynchronousSink synchronousSink) {
        if (jSONRPCResponse.error() != null) {
            synchronousSink.error(new McpError(jSONRPCResponse.error()));
        } else if (typeRef.getType().equals(Void.class)) {
            synchronousSink.complete();
        } else {
            synchronousSink.next(this.transport.unmarshalFrom(jSONRPCResponse.result(), typeRef));
        }
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public void close() {
        this.transport.close();
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> closeGracefully() {
        return this.transport.closeGracefully();
    }

    public String getId() {
        return this.id;
    }

    public Mono<Void> handle(final McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.spec.J
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f34114a.lambda$handle$6(jSONRPCMessage, (ContextView) obj);
            }
        });
    }

    public void init(McpSchema.ClientCapabilities clientCapabilities, McpSchema.Implementation implementation) {
        this.clientCapabilities.lazySet(clientCapabilities);
        this.clientInfo.lazySet(implementation);
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public boolean isNotificationForLevelAllowed(McpSchema.LoggingLevel loggingLevel) {
        return loggingLevel.level() >= this.minLoggingLevel.level();
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> sendNotification(String str, Object obj) {
        return this.transport.sendMessage(new McpSchema.JSONRPCNotification("2.0", str, obj));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(final String str, final Object obj, final TypeRef<T> typeRef) {
        final String strGenerateRequestId = generateRequestId();
        return (Mono<T>) Mono.create(new Consumer() { // from class: io.modelcontextprotocol.spec.K
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                this.f34116a.lambda$sendRequest$2(strGenerateRequestId, str, obj, (MonoSink) obj2);
            }
        }).timeout(this.requestTimeout).handle(new BiConsumer() { // from class: io.modelcontextprotocol.spec.L
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj2, Object obj3) {
                this.f34120a.lambda$sendRequest$3(typeRef, (McpSchema.JSONRPCResponse) obj2, (SynchronousSink) obj3);
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        Assert.notNull(loggingLevel, "minLoggingLevel must not be null");
        this.minLoggingLevel = loggingLevel;
    }

    @Deprecated
    public McpServerSession(String str, Duration duration, McpServerTransport mcpServerTransport, McpInitRequestHandler mcpInitRequestHandler, InitNotificationHandler initNotificationHandler, Map<String, McpRequestHandler<?>> map, Map<String, McpNotificationHandler> map2) {
        this.id = str;
        this.requestTimeout = duration;
        this.transport = mcpServerTransport;
        this.initRequestHandler = mcpInitRequestHandler;
        this.requestHandlers = map;
        this.notificationHandlers = map2;
    }
}
