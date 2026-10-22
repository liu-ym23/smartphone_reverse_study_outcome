package io.modelcontextprotocol.spec;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import io.modelcontextprotocol.client.r;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.C1586d;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* loaded from: classes3.dex */
public class McpClientSession implements McpSession {
    private static final InterfaceC0315b logger = AbstractC0317d.b(McpClientSession.class);
    private final ConcurrentHashMap<String, NotificationHandler> notificationHandlers;
    private final ConcurrentHashMap<Object, MonoSink<McpSchema.JSONRPCResponse>> pendingResponses;
    private final AtomicLong requestCounter;
    private final ConcurrentHashMap<String, RequestHandler<?>> requestHandlers;
    private final Duration requestTimeout;
    private final String sessionPrefix;
    private final McpClientTransport transport;

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

    @FunctionalInterface
    public interface NotificationHandler {
        Mono<Void> handle(Object obj);
    }

    @FunctionalInterface
    public interface RequestHandler<T> {
        Mono<T> handle(Object obj);
    }

    @Deprecated
    public McpClientSession(Duration duration, McpClientTransport mcpClientTransport, Map<String, RequestHandler<?>> map, Map<String, NotificationHandler> map2) {
        this(duration, mcpClientTransport, map, map2, Function.identity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissPendingResponses() {
        this.pendingResponses.forEach(new A3.b(10));
        this.pendingResponses.clear();
    }

    private String generateRequestId() {
        return this.sessionPrefix + "-" + this.requestCounter.getAndIncrement();
    }

    private MethodNotFoundError getMethodNotFoundError(String str) {
        str.getClass();
        return !str.equals(McpSchema.METHOD_ROOTS_LIST) ? new MethodNotFoundError(str, "Method not found: ".concat(str), null) : new MethodNotFoundError(str, "Roots not supported", Map.of("reason", "Client does not have roots capability"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handle(McpSchema.JSONRPCMessage jSONRPCMessage) {
        if (jSONRPCMessage instanceof McpSchema.JSONRPCResponse) {
            McpSchema.JSONRPCResponse jSONRPCResponse = (McpSchema.JSONRPCResponse) jSONRPCMessage;
            InterfaceC0315b interfaceC0315b = logger;
            interfaceC0315b.j(jSONRPCResponse, "Received response: {}");
            if (jSONRPCResponse.id() == null) {
                interfaceC0315b.error("Discarded MCP request response without session id. This is an indication of a bug in the request sender code that can lead to memory leaks as pending requests will never be completed.");
                return;
            }
            MonoSink<McpSchema.JSONRPCResponse> monoSinkRemove = this.pendingResponses.remove(jSONRPCResponse.id());
            if (monoSinkRemove == null) {
                interfaceC0315b.h(jSONRPCResponse.id(), "Unexpected response for unknown id {}");
                return;
            } else {
                monoSinkRemove.success(jSONRPCResponse);
                return;
            }
        }
        if (jSONRPCMessage instanceof McpSchema.JSONRPCRequest) {
            McpSchema.JSONRPCRequest jSONRPCRequest = (McpSchema.JSONRPCRequest) jSONRPCMessage;
            logger.j(jSONRPCRequest, "Received request: {}");
            Mono<McpSchema.JSONRPCResponse> monoOnErrorResume = handleIncomingRequest(jSONRPCRequest).onErrorResume(new d(jSONRPCRequest, 1));
            McpClientTransport mcpClientTransport = this.transport;
            Objects.requireNonNull(mcpClientTransport);
            monoOnErrorResume.flatMap(new Ba.g(mcpClientTransport, 1)).onErrorComplete(new S6.c(4)).subscribe();
            return;
        }
        if (!(jSONRPCMessage instanceof McpSchema.JSONRPCNotification)) {
            logger.h(jSONRPCMessage, "Received unknown message type: {}");
            return;
        }
        McpSchema.JSONRPCNotification jSONRPCNotification = (McpSchema.JSONRPCNotification) jSONRPCMessage;
        logger.j(jSONRPCNotification, "Received notification: {}");
        handleIncomingNotification(jSONRPCNotification).onErrorComplete(new S6.c(5)).subscribe();
    }

    private Mono<Void> handleIncomingNotification(McpSchema.JSONRPCNotification jSONRPCNotification) {
        return Mono.defer(new C1586d(11, this, jSONRPCNotification));
    }

    private Mono<McpSchema.JSONRPCResponse> handleIncomingRequest(McpSchema.JSONRPCRequest jSONRPCRequest) {
        return Mono.defer(new C1586d(12, this, jSONRPCRequest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dismissPendingResponses$1(Object obj, MonoSink monoSink) {
        logger.h(obj, "Abruptly terminating exchange for request {}");
        monoSink.error(new RuntimeException("MCP session with server terminated"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ reactor.core.publisher.Mono lambda$handle$2(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r3, java.lang.Throwable r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.spec.McpClientSession.lambda$handle$2(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$handle$3(Throwable th) {
        logger.warn("Issue sending response to the client, ", th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$handle$4(Throwable th) {
        logger.e(th.getMessage(), "Error handling notification: {}");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingNotification$7(McpSchema.JSONRPCNotification jSONRPCNotification) {
        NotificationHandler notificationHandler = this.notificationHandlers.get(jSONRPCNotification.method());
        if (notificationHandler != null) {
            return notificationHandler.handle(jSONRPCNotification.params());
        }
        logger.h(jSONRPCNotification, "No handler registered for notification method: {}");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.JSONRPCResponse lambda$handleIncomingRequest$5(McpSchema.JSONRPCRequest jSONRPCRequest, Object obj) {
        return new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingRequest$6(McpSchema.JSONRPCRequest jSONRPCRequest) {
        RequestHandler<?> requestHandler = this.requestHandlers.get(jSONRPCRequest.method());
        if (requestHandler != null) {
            return requestHandler.handle(jSONRPCRequest.params()).map(new d(jSONRPCRequest, 0));
        }
        MethodNotFoundError methodNotFoundError = getMethodNotFoundError(jSONRPCRequest.method());
        return Mono.just(new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), null, new McpSchema.JSONRPCResponse.JSONRPCError(-32601, methodNotFoundError.message(), methodNotFoundError.data())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$new$0(Mono mono) {
        return mono.doOnNext(new com.stepos.mcp.sdk.java.a(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$10(String str, String str2, Object obj, ContextView contextView, MonoSink monoSink) {
        logger.j(str, "Sending message for method {}");
        this.pendingResponses.put(str2, monoSink);
        this.transport.sendMessage(new McpSchema.JSONRPCRequest(McpSchema.JSONRPC_VERSION, str, str2, obj)).contextWrite(contextView).subscribe(new b(0), new M3.e(this, str2, monoSink, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendRequest$11(final String str, final String str2, final Object obj, final ContextView contextView) {
        return Mono.create(new Consumer() { // from class: io.modelcontextprotocol.spec.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                this.f4743a.lambda$sendRequest$10(str, str2, obj, contextView, (MonoSink) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$12(TypeRef typeRef, McpSchema.JSONRPCResponse jSONRPCResponse, SynchronousSink synchronousSink) {
        if (jSONRPCResponse.error() != null) {
            logger.e(jSONRPCResponse.error(), "Error handling request: {}");
            synchronousSink.error(new McpError(jSONRPCResponse.error()));
        } else if (typeRef.getType().equals(Void.class)) {
            synchronousSink.complete();
        } else {
            synchronousSink.next(this.transport.unmarshalFrom(jSONRPCResponse.result(), typeRef));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendRequest$8(Void r02) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$9(String str, MonoSink monoSink, Throwable th) {
        this.pendingResponses.remove(str);
        monoSink.error(th);
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public void close() {
        dismissPendingResponses();
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> closeGracefully() {
        return Mono.fromRunnable(new c(this, 0));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> sendNotification(String str, Object obj) {
        return this.transport.sendMessage(new McpSchema.JSONRPCNotification(McpSchema.JSONRPC_VERSION, str, obj));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef) {
        return (Mono<T>) Mono.deferContextual(new r(this, str, generateRequestId(), obj, 1)).timeout(this.requestTimeout).handle(new f(0, this, typeRef));
    }

    public McpClientSession(Duration duration, McpClientTransport mcpClientTransport, Map<String, RequestHandler<?>> map, Map<String, NotificationHandler> map2, Function<? super Mono<Void>, ? extends Z9.c> function) {
        this.pendingResponses = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, RequestHandler<?>> concurrentHashMap = new ConcurrentHashMap<>();
        this.requestHandlers = concurrentHashMap;
        ConcurrentHashMap<String, NotificationHandler> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.notificationHandlers = concurrentHashMap2;
        this.sessionPrefix = UUID.randomUUID().toString().substring(0, 8);
        this.requestCounter = new AtomicLong(0L);
        Assert.notNull(duration, "The requestTimeout can not be null");
        Assert.notNull(mcpClientTransport, "The transport can not be null");
        Assert.notNull(map, "The requestHandlers can not be null");
        Assert.notNull(map2, "The notificationHandlers can not be null");
        this.requestTimeout = duration;
        this.transport = mcpClientTransport;
        concurrentHashMap.putAll(map);
        concurrentHashMap2.putAll(map2);
        mcpClientTransport.connect(new Ba.g(this, 2)).transform(function).subscribe();
    }
}
