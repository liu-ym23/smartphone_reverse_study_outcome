package io.modelcontextprotocol.spec;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import io.modelcontextprotocol.client.r;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.C1588f;
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
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* loaded from: classes3.dex */
public class McpServerSession implements McpLoggableSession {
    private static final int STATE_INITIALIZED = 2;
    private static final int STATE_INITIALIZING = 1;
    private static final int STATE_UNINITIALIZED = 0;
    private static final InterfaceC0315b logger = AbstractC0317d.b(McpServerSession.class);
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

    public static final class MethodNotFoundError extends B7.a {
        private final Object data;
        private final String message;
        private final String method;

        public MethodNotFoundError(String str, String str2, Object obj) {
            this.method = str;
            this.message = str2;
            this.data = obj;
        }

        public Object data() {
            return this.data;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof MethodNotFoundError)) {
                return false;
            }
            MethodNotFoundError methodNotFoundError = (MethodNotFoundError) obj;
            return Objects.equals(this.method, methodNotFoundError.method) && Objects.equals(this.message, methodNotFoundError.message) && Objects.equals(this.data, methodNotFoundError.data);
        }

        public final int hashCode() {
            String str = this.method;
            String str2 = this.message;
            Object obj = this.data;
            return Objects.hashCode(obj) + com.stepos.statsrpk.service.c.a(Objects.hashCode(str) * 31, 31, str2);
        }

        public String message() {
            return this.message;
        }

        public String method() {
            return this.method;
        }

        public final String toString() {
            Object[] objArr = {this.method, this.message, this.data};
            String[] strArrSplit = "method;message;data".length() == 0 ? new String[0] : "method;message;data".split(";");
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, MethodNotFoundError.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
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

    private McpAsyncServerExchange copyExchange(McpAsyncServerExchange mcpAsyncServerExchange, McpTransportContext mcpTransportContext) {
        return new McpAsyncServerExchange(mcpAsyncServerExchange.sessionId(), this, mcpAsyncServerExchange.getClientCapabilities(), mcpAsyncServerExchange.getClientInfo(), mcpTransportContext);
    }

    private String generateRequestId() {
        return this.id + "-" + this.requestCounter.getAndIncrement();
    }

    private MethodNotFoundError getMethodNotFoundError(String str) {
        return new MethodNotFoundError(str, B7.a.k("Method not found: ", str), null);
    }

    private Mono<Void> handleIncomingNotification(McpSchema.JSONRPCNotification jSONRPCNotification, McpTransportContext mcpTransportContext) {
        return Mono.defer(new com.stepos.mcp.sdk.java.transport.e(this, jSONRPCNotification, mcpTransportContext, 1));
    }

    private Mono<McpSchema.JSONRPCResponse> handleIncomingRequest(McpSchema.JSONRPCRequest jSONRPCRequest, McpTransportContext mcpTransportContext) {
        return Mono.defer(new com.stepos.mcp.sdk.java.transport.e(this, jSONRPCRequest, mcpTransportContext, 2));
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
    public static /* synthetic */ void lambda$handle$5(Throwable th) {
        logger.e(th.getMessage(), "Error handling notification: {}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handle$6(McpSchema.JSONRPCMessage jSONRPCMessage, ContextView contextView) {
        McpTransportContext mcpTransportContext = (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY);
        if (jSONRPCMessage instanceof McpSchema.JSONRPCResponse) {
            McpSchema.JSONRPCResponse jSONRPCResponse = (McpSchema.JSONRPCResponse) jSONRPCMessage;
            InterfaceC0315b interfaceC0315b = logger;
            interfaceC0315b.j(jSONRPCResponse, "Received response: {}");
            if (jSONRPCResponse.id() != null) {
                MonoSink<McpSchema.JSONRPCResponse> monoSinkRemove = this.pendingResponses.remove(jSONRPCResponse.id());
                if (monoSinkRemove == null) {
                    interfaceC0315b.h(jSONRPCResponse.id(), "Unexpected response for unknown id {}");
                } else {
                    monoSinkRemove.success(jSONRPCResponse);
                }
            } else {
                interfaceC0315b.error("Discarded MCP request response without session id. This is an indication of a bug in the request sender code that can lead to memory leaks as pending requests will never be completed.");
            }
            return Mono.empty();
        }
        if (jSONRPCMessage instanceof McpSchema.JSONRPCRequest) {
            McpSchema.JSONRPCRequest jSONRPCRequest = (McpSchema.JSONRPCRequest) jSONRPCMessage;
            logger.j(jSONRPCRequest, "Received request: {}");
            Mono<McpSchema.JSONRPCResponse> monoOnErrorResume = handleIncomingRequest(jSONRPCRequest, mcpTransportContext).onErrorResume(new C1588f(4, this, jSONRPCRequest));
            McpServerTransport mcpServerTransport = this.transport;
            Objects.requireNonNull(mcpServerTransport);
            return monoOnErrorResume.flatMap(new Ba.g(mcpServerTransport, 3));
        }
        if (!(jSONRPCMessage instanceof McpSchema.JSONRPCNotification)) {
            logger.h(jSONRPCMessage, "Received unknown message type: {}");
            return Mono.empty();
        }
        McpSchema.JSONRPCNotification jSONRPCNotification = (McpSchema.JSONRPCNotification) jSONRPCMessage;
        logger.j(jSONRPCNotification, "Received notification: {}");
        return handleIncomingNotification(jSONRPCNotification, mcpTransportContext).doOnError(new b(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingNotification$11(McpNotificationHandler mcpNotificationHandler, McpTransportContext mcpTransportContext, McpSchema.JSONRPCNotification jSONRPCNotification, McpAsyncServerExchange mcpAsyncServerExchange) {
        return mcpNotificationHandler.handle(copyExchange(mcpAsyncServerExchange, mcpTransportContext), jSONRPCNotification.params());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingNotification$12(McpSchema.JSONRPCNotification jSONRPCNotification, McpTransportContext mcpTransportContext) {
        McpServerSession mcpServerSession;
        McpTransportContext mcpTransportContext2;
        if (McpSchema.METHOD_NOTIFICATION_INITIALIZED.equals(jSONRPCNotification.method())) {
            this.state.lazySet(2);
            mcpServerSession = this;
            mcpTransportContext2 = mcpTransportContext;
            this.exchangeSink.tryEmitValue(new McpAsyncServerExchange(this.id, mcpServerSession, this.clientCapabilities.get(), this.clientInfo.get(), mcpTransportContext2));
        } else {
            mcpServerSession = this;
            mcpTransportContext2 = mcpTransportContext;
        }
        McpNotificationHandler mcpNotificationHandler = mcpServerSession.notificationHandlers.get(jSONRPCNotification.method());
        if (mcpNotificationHandler == null) {
            logger.h(jSONRPCNotification, "No handler registered for notification method: {}");
            return Mono.empty();
        }
        return mcpServerSession.exchangeSink.asMono().flatMap(new r(mcpServerSession, mcpNotificationHandler, mcpTransportContext2, jSONRPCNotification, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingRequest$10(McpSchema.JSONRPCRequest jSONRPCRequest, McpTransportContext mcpTransportContext) {
        McpSchema.JSONRPCRequest jSONRPCRequest2;
        Mono monoFlatMap;
        if (McpSchema.METHOD_INITIALIZE.equals(jSONRPCRequest.method())) {
            McpSchema.InitializeRequest initializeRequest = (McpSchema.InitializeRequest) this.transport.unmarshalFrom(jSONRPCRequest.params(), new TypeRef<McpSchema.InitializeRequest>() { // from class: io.modelcontextprotocol.spec.McpServerSession.1
            });
            this.state.lazySet(1);
            init(initializeRequest.capabilities(), initializeRequest.clientInfo());
            monoFlatMap = this.initRequestHandler.handle(initializeRequest);
            jSONRPCRequest2 = jSONRPCRequest;
        } else {
            McpRequestHandler<?> mcpRequestHandler = this.requestHandlers.get(jSONRPCRequest.method());
            if (mcpRequestHandler == null) {
                MethodNotFoundError methodNotFoundError = getMethodNotFoundError(jSONRPCRequest.method());
                return Mono.just(new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), null, new McpSchema.JSONRPCResponse.JSONRPCError(-32601, methodNotFoundError.message(), methodNotFoundError.data())));
            }
            jSONRPCRequest2 = jSONRPCRequest;
            monoFlatMap = this.exchangeSink.asMono().flatMap(new r(this, mcpRequestHandler, mcpTransportContext, jSONRPCRequest2, 3));
        }
        return monoFlatMap.map(new d(jSONRPCRequest2, 2)).onErrorResume(new d(jSONRPCRequest2, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingRequest$7(McpRequestHandler mcpRequestHandler, McpTransportContext mcpTransportContext, McpSchema.JSONRPCRequest jSONRPCRequest, McpAsyncServerExchange mcpAsyncServerExchange) {
        return mcpRequestHandler.handle(copyExchange(mcpAsyncServerExchange, mcpTransportContext), jSONRPCRequest.params());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.JSONRPCResponse lambda$handleIncomingRequest$8(McpSchema.JSONRPCRequest jSONRPCRequest, Object obj) {
        return new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ reactor.core.publisher.Mono lambda$handleIncomingRequest$9(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r3, java.lang.Throwable r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.spec.McpServerSession.lambda$handleIncomingRequest$9(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendRequest$0(Void r02) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$1(String str, MonoSink monoSink, Throwable th) {
        this.pendingResponses.remove(str);
        monoSink.error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$2(String str, String str2, Object obj, MonoSink monoSink) {
        this.pendingResponses.put(str, monoSink);
        this.transport.sendMessage(new McpSchema.JSONRPCRequest(McpSchema.JSONRPC_VERSION, str2, str, obj)).subscribe(new b(1), new M3.e(this, str, monoSink, 2));
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
        this.transport.lambda$closeGracefully$1();
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> closeGracefully() {
        return this.transport.closeGracefully();
    }

    public String getId() {
        return this.id;
    }

    public Mono<Void> handle(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.deferContextual(new C1588f(3, this, jSONRPCMessage));
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
        return this.transport.sendMessage(new McpSchema.JSONRPCNotification(McpSchema.JSONRPC_VERSION, str, obj));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef) {
        return (Mono<T>) Mono.create(new h(this, generateRequestId(), str, obj, 0)).timeout(this.requestTimeout).handle(new f(1, this, typeRef));
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
