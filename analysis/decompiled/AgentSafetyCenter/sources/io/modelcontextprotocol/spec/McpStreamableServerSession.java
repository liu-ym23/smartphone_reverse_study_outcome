package io.modelcontextprotocol.spec;

import b8.f0;
import b8.g0;
import b8.n0;
import b8.o;
import b8.q0;
import e3.j;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpNotificationHandler;
import io.modelcontextprotocol.server.McpRequestHandler;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.SynchronousSink;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class McpStreamableServerSession implements McpLoggableSession {
    private static final rd.b logger = rd.d.b(McpStreamableServerSession.class);
    private final AtomicReference<McpSchema.ClientCapabilities> clientCapabilities;
    private final AtomicReference<McpSchema.Implementation> clientInfo;

    /* renamed from: id, reason: collision with root package name */
    private final String f6344id;
    private final AtomicReference<McpLoggableSession> listeningStreamRef;
    private volatile McpSchema.LoggingLevel minLoggingLevel;
    private final MissingMcpTransportSession missingMcpTransportSession;
    private final Map<String, McpNotificationHandler> notificationHandlers;
    private final Map<String, McpRequestHandler<?>> requestHandlers;
    private final Duration requestTimeout;
    private final ConcurrentHashMap<Object, McpStreamableServerSessionStream> requestIdToStream = new ConcurrentHashMap<>();
    private final AtomicLong requestCounter = new AtomicLong(0);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface Factory {
        McpStreamableServerSessionInit startSession(McpSchema.InitializeRequest initializeRequest);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public interface InitRequestHandler {
        Mono<McpSchema.InitializeResult> handle(McpSchema.InitializeRequest initializeRequest);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class McpStreamableServerSessionInit extends androidx.activity.b {
        private final Mono<McpSchema.InitializeResult> initResult;
        private final McpStreamableServerSession session;

        public McpStreamableServerSessionInit(McpStreamableServerSession mcpStreamableServerSession, Mono<McpSchema.InitializeResult> mono) {
            this.session = mcpStreamableServerSession;
            this.initResult = mono;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof McpStreamableServerSessionInit)) {
                return false;
            }
            McpStreamableServerSessionInit mcpStreamableServerSessionInit = (McpStreamableServerSessionInit) obj;
            return Objects.equals(this.session, mcpStreamableServerSessionInit.session) && Objects.equals(this.initResult, mcpStreamableServerSessionInit.initResult);
        }

        public final int hashCode() {
            McpStreamableServerSession mcpStreamableServerSession = this.session;
            Mono<McpSchema.InitializeResult> mono = this.initResult;
            return Objects.hashCode(mono) + (Objects.hashCode(mcpStreamableServerSession) * 31);
        }

        public Mono<McpSchema.InitializeResult> initResult() {
            return this.initResult;
        }

        public McpStreamableServerSession session() {
            return this.session;
        }

        public final String toString() {
            Object[] objArr = {this.session, this.initResult};
            String[] strArrSplit = "session;initResult".length() == 0 ? new String[0] : "session;initResult".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, McpStreamableServerSessionInit.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MethodNotFoundError extends androidx.activity.b {
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
            return Objects.hashCode(obj) + androidx.activity.b.w(Objects.hashCode(str) * 31, 31, str2);
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
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, MethodNotFoundError.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public McpStreamableServerSession(String str, McpSchema.ClientCapabilities clientCapabilities, McpSchema.Implementation implementation, Duration duration, Map<String, McpRequestHandler<?>> map, Map<String, McpNotificationHandler> map2) {
        AtomicReference<McpSchema.ClientCapabilities> atomicReference = new AtomicReference<>();
        this.clientCapabilities = atomicReference;
        AtomicReference<McpSchema.Implementation> atomicReference2 = new AtomicReference<>();
        this.clientInfo = atomicReference2;
        this.minLoggingLevel = McpSchema.LoggingLevel.INFO;
        this.f6344id = str;
        MissingMcpTransportSession missingMcpTransportSession = new MissingMcpTransportSession(str);
        this.missingMcpTransportSession = missingMcpTransportSession;
        this.listeningStreamRef = new AtomicReference<>(missingMcpTransportSession);
        atomicReference.lazySet(clientCapabilities);
        atomicReference2.lazySet(implementation);
        this.requestTimeout = duration;
        this.requestHandlers = map;
        this.notificationHandlers = map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateRequestId() {
        return this.f6344id + "-" + this.requestCounter.getAndIncrement();
    }

    private MethodNotFoundError getMethodNotFoundError(String str) {
        return new MethodNotFoundError(str, w2.c.b("Method not found: ", str), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$accept$6(McpSchema.JSONRPCNotification jSONRPCNotification, ContextView contextView) {
        McpTransportContext mcpTransportContext = (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY);
        McpNotificationHandler mcpNotificationHandler = this.notificationHandlers.get(jSONRPCNotification.method());
        if (mcpNotificationHandler == null) {
            logger.b(jSONRPCNotification, "No handler registered for notification method: {}");
            return Mono.empty();
        }
        return mcpNotificationHandler.handle(new McpAsyncServerExchange(this.f6344id, this.listeningStreamRef.get(), this.clientCapabilities.get(), this.clientInfo.get(), mcpTransportContext), jSONRPCNotification.params());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$accept$7(McpSchema.JSONRPCResponse jSONRPCResponse) {
        rd.b bVar = logger;
        bVar.h(jSONRPCResponse, "Received response: {}");
        if (jSONRPCResponse.id() != null) {
            McpStreamableServerSessionStream mcpStreamableServerSessionStream = this.requestIdToStream.get(jSONRPCResponse.id());
            if (mcpStreamableServerSessionStream == null) {
                return Mono.error(McpError.builder(McpSchema.ErrorCodes.INTERNAL_ERROR).message("Unexpected response for unknown id ".concat(String.valueOf(jSONRPCResponse.id()))).build());
            }
            MonoSink monoSink = (MonoSink) mcpStreamableServerSessionStream.pendingResponses.remove(jSONRPCResponse.id());
            if (monoSink == null) {
                return Mono.error(McpError.builder(McpSchema.ErrorCodes.INTERNAL_ERROR).message("Unexpected response for unknown id ".concat(String.valueOf(jSONRPCResponse.id()))).build());
            }
            monoSink.success(jSONRPCResponse);
        } else {
            bVar.error("Discarded MCP request response without session id. This is an indication of a bug in the request sender code that can lead to memory leaks as pending requests will never be completed.");
        }
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$8() {
        return this.listeningStreamRef.getAndSet(this.missingMcpTransportSession).closeGracefully();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ McpSchema.JSONRPCResponse lambda$responseStream$3(McpSchema.JSONRPCRequest jSONRPCRequest, Object obj) {
        return new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ reactor.core.publisher.Mono lambda$responseStream$4(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r3, java.lang.Throwable r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.spec.McpStreamableServerSession.lambda$responseStream$4(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$responseStream$5(McpStreamableServerTransport mcpStreamableServerTransport, McpSchema.JSONRPCRequest jSONRPCRequest, ContextView contextView) {
        McpTransportContext mcpTransportContext = (McpTransportContext) contextView.getOrDefault(McpTransportContext.KEY, McpTransportContext.EMPTY);
        McpStreamableServerSessionStream mcpStreamableServerSessionStream = new McpStreamableServerSessionStream(mcpStreamableServerTransport);
        McpRequestHandler<?> mcpRequestHandler = this.requestHandlers.get(jSONRPCRequest.method());
        if (mcpRequestHandler == null) {
            MethodNotFoundError methodNotFoundError = getMethodNotFoundError(jSONRPCRequest.method());
            return mcpStreamableServerTransport.sendMessage(new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), null, new McpSchema.JSONRPCResponse.JSONRPCError(Integer.valueOf(McpSchema.ErrorCodes.METHOD_NOT_FOUND), methodNotFoundError.message(), methodNotFoundError.data())));
        }
        Mono<?> monoHandle = mcpRequestHandler.handle(new McpAsyncServerExchange(this.f6344id, mcpStreamableServerSessionStream, this.clientCapabilities.get(), this.clientInfo.get(), mcpTransportContext), jSONRPCRequest.params());
        b bVar = new b(4);
        bVar.f6348b = jSONRPCRequest;
        VarHandle.storeStoreFence();
        Mono<R> map = monoHandle.map(bVar);
        int i = 5;
        b bVar2 = new b(i);
        bVar2.f6348b = jSONRPCRequest;
        VarHandle.storeStoreFence();
        Mono monoOnErrorResume = map.onErrorResume(bVar2);
        Objects.requireNonNull(mcpStreamableServerTransport);
        a8.c cVar = new a8.c(i);
        cVar.f234b = mcpStreamableServerTransport;
        VarHandle.storeStoreFence();
        return monoOnErrorResume.flatMap(cVar).then(mcpStreamableServerTransport.closeGracefully());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendNotification$1(String str, Object obj) {
        return this.listeningStreamRef.get().sendNotification(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$sendRequest$0(String str, Object obj, TypeRef typeRef) {
        return this.listeningStreamRef.get().sendRequest(str, obj, typeRef);
    }

    public Mono<Void> accept(McpSchema.JSONRPCResponse jSONRPCResponse) {
        n0 n0Var = new n0(14);
        n0Var.f1991f = this;
        n0Var.f1992g = jSONRPCResponse;
        VarHandle.storeStoreFence();
        return Mono.defer(n0Var);
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public void close() {
        McpLoggableSession andSet = this.listeningStreamRef.getAndSet(this.missingMcpTransportSession);
        if (andSet != null) {
            andSet.close();
        }
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> closeGracefully() {
        q0 q0Var = new q0(3);
        q0Var.f2013f = this;
        VarHandle.storeStoreFence();
        return Mono.defer(q0Var);
    }

    public Mono<Void> delete() {
        return closeGracefully().then(Mono.fromRunnable(new j(1)));
    }

    public String getId() {
        return this.f6344id;
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public boolean isNotificationForLevelAllowed(McpSchema.LoggingLevel loggingLevel) {
        return loggingLevel.level() >= this.minLoggingLevel.level();
    }

    public McpStreamableServerSessionStream listeningStream(McpStreamableServerTransport mcpStreamableServerTransport) {
        McpStreamableServerSessionStream mcpStreamableServerSessionStream = new McpStreamableServerSessionStream(mcpStreamableServerTransport);
        this.listeningStreamRef.set(mcpStreamableServerSessionStream);
        return mcpStreamableServerSessionStream;
    }

    public Flux<McpSchema.JSONRPCMessage> replay(Object obj) {
        return Flux.empty();
    }

    public Mono<Void> responseStream(McpSchema.JSONRPCRequest jSONRPCRequest, McpStreamableServerTransport mcpStreamableServerTransport) {
        f0 f0Var = new f0(1);
        f0Var.f1958b = this;
        f0Var.f1959c = mcpStreamableServerTransport;
        f0Var.f1960d = jSONRPCRequest;
        VarHandle.storeStoreFence();
        return Mono.deferContextual(f0Var);
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public Mono<Void> sendNotification(String str, Object obj) {
        com.stepos.mcp.sdk.java.transport.e eVar = new com.stepos.mcp.sdk.java.transport.e(3);
        eVar.f2741f = this;
        eVar.f2742g = str;
        eVar.f2743h = obj;
        VarHandle.storeStoreFence();
        return Mono.defer(eVar);
    }

    @Override // io.modelcontextprotocol.spec.McpSession
    public <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef) {
        o oVar = new o(4);
        oVar.f1994f = this;
        oVar.f1995g = str;
        oVar.f1996h = obj;
        oVar.i = typeRef;
        VarHandle.storeStoreFence();
        return Mono.defer(oVar);
    }

    @Override // io.modelcontextprotocol.spec.McpLoggableSession
    public void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
        Assert.notNull(loggingLevel, "minLoggingLevel must not be null");
        this.minLoggingLevel = loggingLevel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$delete$2() {
    }

    public Mono<Void> accept(McpSchema.JSONRPCNotification jSONRPCNotification) {
        io.modelcontextprotocol.server.e eVar = new io.modelcontextprotocol.server.e(5);
        eVar.f6261b = this;
        eVar.f6262c = jSONRPCNotification;
        VarHandle.storeStoreFence();
        return Mono.deferContextual(eVar);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public final class McpStreamableServerSessionStream implements McpLoggableSession {
        private final McpStreamableServerTransport transport;
        private final Supplier<String> uuidGenerator;
        private final ConcurrentHashMap<Object, MonoSink<McpSchema.JSONRPCResponse>> pendingResponses = new ConcurrentHashMap<>();
        private final String transportId = UUID.randomUUID().toString();

        public McpStreamableServerSessionStream(McpStreamableServerTransport mcpStreamableServerTransport) {
            this.transport = mcpStreamableServerTransport;
            g gVar = new g(0);
            gVar.f6365f = this;
            VarHandle.storeStoreFence();
            this.uuidGenerator = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$close$7(MonoSink monoSink) {
            monoSink.error(new RuntimeException("Stream closed"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$closeGracefully$5(MonoSink monoSink) {
            monoSink.error(new RuntimeException("Stream closed"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Mono lambda$closeGracefully$6() {
            this.pendingResponses.values().forEach(new b8.h(5));
            this.pendingResponses.clear();
            McpStreamableServerSession.this.listeningStreamRef.compareAndExchange(this, McpStreamableServerSession.this.missingMcpTransportSession);
            Collection collectionValues = McpStreamableServerSession.this.requestIdToStream.values();
            h hVar = new h(0);
            hVar.f6367f = this;
            VarHandle.storeStoreFence();
            collectionValues.removeIf(hVar);
            return this.transport.closeGracefully();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$new$0() {
            return k0.a.o(this.transportId, "_", String.valueOf(UUID.randomUUID()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendRequest$2(String str, String str2, Object obj, MonoSink monoSink) {
            this.pendingResponses.put(str, monoSink);
            Mono<Void> monoSendMessage = this.transport.sendMessage(new McpSchema.JSONRPCRequest(McpSchema.JSONRPC_VERSION, str2, str, obj), this.uuidGenerator.get());
            b8.h hVar = new b8.h(4);
            Objects.requireNonNull(monoSink);
            g0 g0Var = new g0(7);
            g0Var.f1963f = monoSink;
            VarHandle.storeStoreFence();
            monoSendMessage.subscribe(hVar, g0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendRequest$3(String str, Throwable th) {
            this.pendingResponses.remove(str);
            McpStreamableServerSession.this.requestIdToStream.remove(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendRequest$4(TypeRef typeRef, McpSchema.JSONRPCResponse jSONRPCResponse, SynchronousSink synchronousSink) {
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
            this.pendingResponses.values().forEach(new b8.h(6));
            this.pendingResponses.clear();
            McpStreamableServerSession.this.listeningStreamRef.compareAndExchange(this, McpStreamableServerSession.this.missingMcpTransportSession);
            Collection collectionValues = McpStreamableServerSession.this.requestIdToStream.values();
            h hVar = new h(0);
            hVar.f6367f = this;
            VarHandle.storeStoreFence();
            collectionValues.removeIf(hVar);
            this.transport.lambda$closeGracefully$1();
        }

        @Override // io.modelcontextprotocol.spec.McpSession
        public Mono<Void> closeGracefully() {
            g gVar = new g(1);
            gVar.f6365f = this;
            VarHandle.storeStoreFence();
            return Mono.defer(gVar);
        }

        @Override // io.modelcontextprotocol.spec.McpLoggableSession
        public boolean isNotificationForLevelAllowed(McpSchema.LoggingLevel loggingLevel) {
            return McpStreamableServerSession.this.isNotificationForLevelAllowed(loggingLevel);
        }

        @Override // io.modelcontextprotocol.spec.McpSession
        public Mono<Void> sendNotification(String str, Object obj) {
            return this.transport.sendMessage(new McpSchema.JSONRPCNotification(McpSchema.JSONRPC_VERSION, str, obj), this.uuidGenerator.get());
        }

        @Override // io.modelcontextprotocol.spec.McpSession
        public <T> Mono<T> sendRequest(String str, Object obj, TypeRef<T> typeRef) {
            String strGenerateRequestId = McpStreamableServerSession.this.generateRequestId();
            McpStreamableServerSession.this.requestIdToStream.put(strGenerateRequestId, this);
            f fVar = new f(1);
            fVar.i = this;
            fVar.f6361f = strGenerateRequestId;
            fVar.f6362g = str;
            fVar.f6363h = obj;
            VarHandle.storeStoreFence();
            Mono monoTimeout = Mono.create(fVar).timeout(McpStreamableServerSession.this.requestTimeout);
            int i = 2;
            g8.g gVar = new g8.g(i);
            gVar.f4383f = this;
            gVar.f4384g = strGenerateRequestId;
            VarHandle.storeStoreFence();
            Mono<T> monoDoOnError = monoTimeout.doOnError(gVar);
            e eVar = new e(i);
            eVar.f6359g = this;
            eVar.f6358f = typeRef;
            VarHandle.storeStoreFence();
            return monoDoOnError.handle(eVar);
        }

        @Override // io.modelcontextprotocol.spec.McpLoggableSession
        public void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel) {
            Assert.notNull(loggingLevel, "minLoggingLevel must not be null");
            McpStreamableServerSession.this.setMinLoggingLevel(loggingLevel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$sendRequest$1(Void r02) {
        }
    }
}
