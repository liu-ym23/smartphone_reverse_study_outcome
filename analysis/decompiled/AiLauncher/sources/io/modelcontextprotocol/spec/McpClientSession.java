package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.client.b1;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
public class McpClientSession implements McpSession {
    private static final vc.c logger = vc.e.l(McpClientSession.class);
    private final ConcurrentHashMap<String, NotificationHandler> notificationHandlers;
    private final ConcurrentHashMap<Object, MonoSink<McpSchema.JSONRPCResponse>> pendingResponses;
    private final AtomicLong requestCounter;
    private final ConcurrentHashMap<String, RequestHandler<?>> requestHandlers;
    private final Duration requestTimeout;
    private final String sessionPrefix;
    private final McpClientTransport transport;

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

    public static /* synthetic */ McpSchema.JSONRPCResponse d(McpSchema.JSONRPCRequest jSONRPCRequest, Object obj) {
        return new McpSchema.JSONRPCResponse("2.0", jSONRPCRequest.id(), obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissPendingResponses() {
        this.pendingResponses.forEach(new BiConsumer() { // from class: io.modelcontextprotocol.spec.i
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                McpClientSession.e(obj, (MonoSink) obj2);
            }
        });
        this.pendingResponses.clear();
    }

    public static /* synthetic */ void e(Object obj, MonoSink monoSink) {
        logger.j("Abruptly terminating exchange for request {}", obj);
        monoSink.error(new RuntimeException("MCP session with server terminated"));
    }

    public static /* synthetic */ void g(Void r02) {
    }

    private String generateRequestId() {
        return this.sessionPrefix + O6.l.DATE_SEPARATOR + this.requestCounter.getAndIncrement();
    }

    private MethodNotFoundError getMethodNotFoundError(String str) {
        str.getClass();
        if (str.equals(McpSchema.METHOD_ROOTS_LIST)) {
            return new MethodNotFoundError(str, "Roots not supported", Map.of("reason", "Client does not have roots capability"));
        }
        return new MethodNotFoundError(str, "Method not found: " + str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handle(McpSchema.JSONRPCMessage jSONRPCMessage) {
        if (jSONRPCMessage instanceof McpSchema.JSONRPCResponse) {
            McpSchema.JSONRPCResponse jSONRPCResponse = (McpSchema.JSONRPCResponse) jSONRPCMessage;
            vc.c cVar = logger;
            cVar.t("Received response: {}", jSONRPCResponse);
            if (jSONRPCResponse.id() == null) {
                cVar.error("Discarded MCP request response without session id. This is an indication of a bug in the request sender code that can lead to memory leaks as pending requests will never be completed.");
                return;
            }
            MonoSink<McpSchema.JSONRPCResponse> monoSinkRemove = this.pendingResponses.remove(jSONRPCResponse.id());
            if (monoSinkRemove == null) {
                cVar.j("Unexpected response for unknown id {}", jSONRPCResponse.id());
                return;
            } else {
                monoSinkRemove.success(jSONRPCResponse);
                return;
            }
        }
        if (jSONRPCMessage instanceof McpSchema.JSONRPCRequest) {
            final McpSchema.JSONRPCRequest jSONRPCRequest = (McpSchema.JSONRPCRequest) jSONRPCMessage;
            logger.t("Received request: {}", jSONRPCRequest);
            Mono<McpSchema.JSONRPCResponse> monoOnErrorResume = handleIncomingRequest(jSONRPCRequest).onErrorResume(new Function() { // from class: io.modelcontextprotocol.spec.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return McpClientSession.i(jSONRPCRequest, (Throwable) obj);
                }
            });
            final McpClientTransport mcpClientTransport = this.transport;
            Objects.requireNonNull(mcpClientTransport);
            monoOnErrorResume.flatMap(new Function() { // from class: io.modelcontextprotocol.spec.r
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return mcpClientTransport.sendMessage((McpSchema.JSONRPCResponse) obj);
                }
            }).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.spec.s
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return McpClientSession.l((Throwable) obj);
                }
            }).subscribe();
            return;
        }
        if (!(jSONRPCMessage instanceof McpSchema.JSONRPCNotification)) {
            logger.j("Received unknown message type: {}", jSONRPCMessage);
            return;
        }
        McpSchema.JSONRPCNotification jSONRPCNotification = (McpSchema.JSONRPCNotification) jSONRPCMessage;
        logger.t("Received notification: {}", jSONRPCNotification);
        handleIncomingNotification(jSONRPCNotification).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.spec.t
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return McpClientSession.k((Throwable) obj);
            }
        }).subscribe();
    }

    private Mono<Void> handleIncomingNotification(final McpSchema.JSONRPCNotification jSONRPCNotification) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.spec.l
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f34173a.lambda$handleIncomingNotification$7(jSONRPCNotification);
            }
        });
    }

    private Mono<McpSchema.JSONRPCResponse> handleIncomingRequest(final McpSchema.JSONRPCRequest jSONRPCRequest) {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.spec.u
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f34192a.lambda$handleIncomingRequest$6(jSONRPCRequest);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ reactor.core.publisher.Mono i(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r3, java.lang.Throwable r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.spec.McpClientSession.i(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    public static /* synthetic */ boolean k(Throwable th) {
        logger.u("Error handling notification: {}", th.getMessage());
        return true;
    }

    public static /* synthetic */ boolean l(Throwable th) {
        logger.warn("Issue sending response to the client, ", th);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingNotification$7(McpSchema.JSONRPCNotification jSONRPCNotification) {
        NotificationHandler notificationHandler = this.notificationHandlers.get(jSONRPCNotification.method());
        if (notificationHandler != null) {
            return notificationHandler.handle(jSONRPCNotification.params());
        }
        logger.j("No handler registered for notification method: {}", jSONRPCNotification);
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$handleIncomingRequest$6(final McpSchema.JSONRPCRequest jSONRPCRequest) {
        RequestHandler<?> requestHandler = this.requestHandlers.get(jSONRPCRequest.method());
        if (requestHandler != null) {
            return requestHandler.handle(jSONRPCRequest.params()).map(new Function() { // from class: io.modelcontextprotocol.spec.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return McpClientSession.d(jSONRPCRequest, obj);
                }
            });
        }
        MethodNotFoundError methodNotFoundError = getMethodNotFoundError(jSONRPCRequest.method());
        return Mono.just(new McpSchema.JSONRPCResponse("2.0", jSONRPCRequest.id(), null, new McpSchema.JSONRPCResponse.JSONRPCError(Integer.valueOf(McpSchema.ErrorCodes.METHOD_NOT_FOUND), methodNotFoundError.message(), methodNotFoundError.data())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$new$0(Mono mono) {
        return mono.doOnNext(new Consumer() { // from class: io.modelcontextprotocol.spec.k
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34171a.handle((McpSchema.JSONRPCMessage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$10(String str, final String str2, Object obj, ContextView contextView, final MonoSink monoSink) {
        logger.t("Sending message for method {}", str);
        this.pendingResponses.put(str2, monoSink);
        this.transport.sendMessage(new McpSchema.JSONRPCRequest("2.0", str, str2, obj)).contextWrite(contextView).subscribe(new Consumer() { // from class: io.modelcontextprotocol.spec.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                McpClientSession.g((Void) obj2);
            }
        }, new Consumer() { // from class: io.modelcontextprotocol.spec.n
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                this.f34181a.lambda$sendRequest$9(str2, monoSink, (Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendRequest$11(final String str, final String str2, final Object obj, final ContextView contextView) {
        return Mono.create(new Consumer() { // from class: io.modelcontextprotocol.spec.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                this.f34175a.lambda$sendRequest$10(str, str2, obj, contextView, (MonoSink) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$12(TypeRef typeRef, McpSchema.JSONRPCResponse jSONRPCResponse, SynchronousSink synchronousSink) {
        if (jSONRPCResponse.error() != null) {
            logger.u("Error handling request: {}", jSONRPCResponse.error());
            synchronousSink.error(new McpError(jSONRPCResponse.error()));
        } else if (typeRef.getType().equals(Void.class)) {
            synchronousSink.complete();
        } else {
            synchronousSink.next(this.transport.unmarshalFrom(jSONRPCResponse.result(), typeRef));
        }
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
        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.spec.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f34164a.dismissPendingResponses();
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> sendNotification(String str, Object obj) {
        return this.transport.sendMessage(new McpSchema.JSONRPCNotification("2.0", str, obj));
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(final String str, final Object obj, final TypeRef<T> typeRef) {
        final String strGenerateRequestId = generateRequestId();
        return (Mono<T>) Mono.deferContextual(new Function() { // from class: io.modelcontextprotocol.spec.o
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return this.f34184a.lambda$sendRequest$11(str, strGenerateRequestId, obj, (ContextView) obj2);
            }
        }).timeout(this.requestTimeout).handle(new BiConsumer() { // from class: io.modelcontextprotocol.spec.p
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj2, Object obj3) {
                this.f34188a.lambda$sendRequest$12(typeRef, (McpSchema.JSONRPCResponse) obj2, (SynchronousSink) obj3);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public McpClientSession(Duration duration, McpClientTransport mcpClientTransport, Map<String, RequestHandler<?>> map, Map<String, NotificationHandler> map2, Function<? super Mono<Void>, ? extends qc.b<Void>> function) {
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
        mcpClientTransport.connect(new Function() { // from class: io.modelcontextprotocol.spec.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f34194a.lambda$new$0((Mono) obj);
            }
        }).transform(function).subscribe();
    }
}
