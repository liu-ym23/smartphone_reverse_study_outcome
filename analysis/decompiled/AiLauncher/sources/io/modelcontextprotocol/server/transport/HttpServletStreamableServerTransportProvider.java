package io.modelcontextprotocol.server.transport;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.client.utils.CacheControl;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.McpTransportContextExtractor;
import io.modelcontextprotocol.spec.HttpHeaders;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import io.modelcontextprotocol.spec.McpStreamableServerTransport;
import io.modelcontextprotocol.spec.McpStreamableServerTransportProvider;
import io.modelcontextprotocol.spec.ProtocolVersions;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.KeepAliveScheduler;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@WebServlet(asyncSupported = true)
/* loaded from: classes4.dex */
public class HttpServletStreamableServerTransportProvider extends HttpServlet implements McpStreamableServerTransportProvider {
    private static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String ENDPOINT_EVENT_TYPE = "endpoint";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String MESSAGE_EVENT_TYPE = "message";
    public static final String TEXT_EVENT_STREAM = "text/event-stream";
    public static final String UTF_8 = "UTF-8";
    private static final vc.c logger = vc.e.l(HttpServletStreamableServerTransportProvider.class);
    private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
    private final boolean disallowDelete;
    private volatile boolean isClosing;
    private final McpJsonMapper jsonMapper;
    private KeepAliveScheduler keepAliveScheduler;
    private final String mcpEndpoint;
    private McpStreamableServerSession.Factory sessionFactory;
    private final ConcurrentHashMap<String, McpStreamableServerSession> sessions;

    public static class Builder {
        private McpJsonMapper jsonMapper;
        private Duration keepAliveInterval;
        private String mcpEndpoint = "/mcp";
        private boolean disallowDelete = false;
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor = new McpTransportContextExtractor() { // from class: io.modelcontextprotocol.server.transport.B
            @Override // io.modelcontextprotocol.server.McpTransportContextExtractor
            public final McpTransportContext extract(Object obj) {
                return McpTransportContext.EMPTY;
            }
        };

        public HttpServletStreamableServerTransportProvider build() {
            Assert.notNull(this.mcpEndpoint, "MCP endpoint must be set");
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpServletStreamableServerTransportProvider(mcpJsonMapper, this.mcpEndpoint, this.disallowDelete, this.contextExtractor, this.keepAliveInterval);
        }

        public Builder contextExtractor(McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor) {
            Assert.notNull(mcpTransportContextExtractor, "Context extractor must not be null");
            this.contextExtractor = mcpTransportContextExtractor;
            return this;
        }

        public Builder disallowDelete(boolean z10) {
            this.disallowDelete = z10;
            return this;
        }

        public Builder jsonMapper(McpJsonMapper mcpJsonMapper) {
            Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
            this.jsonMapper = mcpJsonMapper;
            return this;
        }

        public Builder keepAliveInterval(Duration duration) {
            this.keepAliveInterval = duration;
            return this;
        }

        public Builder mcpEndpoint(String str) {
            Assert.notNull(str, "MCP endpoint must not be null");
            this.mcpEndpoint = str;
            return this;
        }
    }

    public class HttpServletStreamableMcpSessionTransport implements McpStreamableServerTransport {
        private final AsyncContext asyncContext;
        private volatile boolean closed = false;
        private final ReentrantLock lock = new ReentrantLock();
        private final String sessionId;
        private final PrintWriter writer;

        public HttpServletStreamableMcpSessionTransport(String str, AsyncContext asyncContext, PrintWriter printWriter) {
            this.sessionId = str;
            this.asyncContext = asyncContext;
            this.writer = printWriter;
            HttpServletStreamableServerTransportProvider.logger.t("Streamable session transport {} initialized with SSE writer", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage, String str) {
            if (this.closed) {
                HttpServletStreamableServerTransportProvider.logger.t("Attempted to send message to closed session: {}", this.sessionId);
                return;
            }
            this.lock.lock();
            try {
                if (this.closed) {
                    HttpServletStreamableServerTransportProvider.logger.t("Session {} was closed during message send attempt", this.sessionId);
                    return;
                }
                HttpServletStreamableServerTransportProvider.this.sendEvent(this.writer, "message", HttpServletStreamableServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage), str != null ? str : this.sessionId);
                HttpServletStreamableServerTransportProvider.logger.a("Message sent to session {} with ID {}", this.sessionId, str);
            } catch (Exception e10) {
                HttpServletStreamableServerTransportProvider.logger.q("Failed to send message to session {}: {}", this.sessionId, e10.getMessage());
                HttpServletStreamableServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
            } finally {
                this.lock.unlock();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        /* renamed from: close, reason: merged with bridge method [inline-methods] */
        public void lambda$closeGracefully$1() {
            this.lock.lock();
            try {
                try {
                    if (this.closed) {
                        HttpServletStreamableServerTransportProvider.logger.t("Session transport {} already closed", this.sessionId);
                    } else {
                        this.closed = true;
                        this.asyncContext.complete();
                        HttpServletStreamableServerTransportProvider.logger.t("Successfully completed async context for session {}", this.sessionId);
                    }
                } catch (Exception e10) {
                    HttpServletStreamableServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e10.getMessage());
                }
            } finally {
                this.lock.unlock();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.D
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34024a.lambda$closeGracefully$1();
                }
            });
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return sendMessage(jSONRPCMessage, null);
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) HttpServletStreamableServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }

        @Override // io.modelcontextprotocol.spec.McpStreamableServerTransport
        public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage, final String str) {
            return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.C
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34021a.lambda$sendMessage$0(jSONRPCMessage, str);
                }
            });
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static /* synthetic */ void g(McpStreamableServerSession mcpStreamableServerSession) {
        try {
            mcpStreamableServerSession.closeGracefully().block();
        } catch (Exception e10) {
            logger.q("Failed to close session {}: {}", mcpStreamableServerSession.getId(), e10.getMessage());
        }
    }

    public static /* synthetic */ void h(String str, Object obj, McpStreamableServerSession mcpStreamableServerSession) {
        try {
            mcpStreamableServerSession.sendNotification(str, obj).block();
        } catch (Exception e10) {
            logger.q("Failed to send message to session {}: {}", mcpStreamableServerSession.getId(), e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$4() {
        this.isClosing = true;
        vc.c cVar = logger;
        cVar.t("Initiating graceful shutdown with {} active sessions", Integer.valueOf(this.sessions.size()));
        this.sessions.values().parallelStream().forEach(new Consumer() { // from class: io.modelcontextprotocol.server.transport.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HttpServletStreamableServerTransportProvider.g((McpStreamableServerSession) obj);
            }
        });
        this.sessions.clear();
        cVar.debug("Graceful shutdown completed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$5(Void r22) {
        this.sessions.clear();
        logger.debug("Graceful shutdown completed");
        KeepAliveScheduler keepAliveScheduler = this.keepAliveScheduler;
        if (keepAliveScheduler != null) {
            keepAliveScheduler.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doGet$8(HttpServletStreamableMcpSessionTransport httpServletStreamableMcpSessionTransport, final McpTransportContext mcpTransportContext, AsyncContext asyncContext, McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            httpServletStreamableMcpSessionTransport.sendMessage(jSONRPCMessage).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContext);
                }
            }).block();
        } catch (Exception e10) {
            logger.u("Failed to replay message: {}", e10.getMessage());
            asyncContext.complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Flux lambda$new$0() {
        return this.isClosing ? Flux.empty() : Flux.fromIterable(this.sessions.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyClients$2(final String str, final Object obj) {
        this.sessions.values().parallelStream().forEach(new Consumer() { // from class: io.modelcontextprotocol.server.transport.A
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                HttpServletStreamableServerTransportProvider.h(str, obj, (McpStreamableServerSession) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(PrintWriter printWriter, String str, String str2, String str3) throws IOException {
        if (str3 != null) {
            printWriter.write("id: " + str3 + "\n");
        }
        printWriter.write("event: " + str + "\n");
        printWriter.write("data: " + str2 + "\n\n");
        printWriter.flush();
        if (printWriter.checkError()) {
            throw new IOException("Client disconnected");
        }
    }

    @Override // io.modelcontextprotocol.spec.McpStreamableServerTransportProvider, io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f34050a.lambda$closeGracefully$4();
            }
        }).then().doOnSuccess(new Consumer() { // from class: io.modelcontextprotocol.server.transport.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34051a.lambda$closeGracefully$5((Void) obj);
            }
        });
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(404);
            return;
        }
        if (this.isClosing) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        if (this.disallowDelete) {
            httpServletResponse.sendError(405);
            return;
        }
        final McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        if (httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID) == null) {
            responseError(httpServletResponse, Const.I_TILE_TINY, new McpError("Session ID required in mcp-session-id header"));
            return;
        }
        String header = httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID);
        McpStreamableServerSession mcpStreamableServerSession = this.sessions.get(header);
        if (mcpStreamableServerSession == null) {
            httpServletResponse.sendError(404);
            return;
        }
        try {
            mcpStreamableServerSession.delete().contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.o
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                }
            }).block();
            this.sessions.remove(header);
            httpServletResponse.setStatus(200);
        } catch (Exception e10) {
            logger.q("Failed to delete session {}: {}", header, e10.getMessage());
            try {
                responseError(httpServletResponse, 500, new McpError(e10.getMessage()));
            } catch (IOException e11) {
                logger.u("Failed to send error response: {}", e11.getMessage());
                httpServletResponse.sendError(500, "Error deleting session");
            }
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(404);
            return;
        }
        if (this.isClosing) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        ArrayList arrayList = new ArrayList();
        String header = httpServletRequest.getHeader("Accept");
        if (header == null || !header.contains("text/event-stream")) {
            arrayList.add("text/event-stream required in Accept header");
        }
        final String header2 = httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID);
        if (header2 == null || header2.isBlank()) {
            arrayList.add("Session ID required in mcp-session-id header");
        }
        if (!arrayList.isEmpty()) {
            responseError(httpServletResponse, Const.I_TILE_TINY, new McpError(String.join("; ", arrayList)));
            return;
        }
        McpStreamableServerSession mcpStreamableServerSession = this.sessions.get(header2);
        if (mcpStreamableServerSession == null) {
            httpServletResponse.sendError(404);
            return;
        }
        logger.t("Handling GET request for session: {}", header2);
        final McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        try {
            httpServletResponse.setContentType("text/event-stream");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE);
            httpServletResponse.setHeader(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, "keep-alive");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            final AsyncContext asyncContextStartAsync = httpServletRequest.startAsync();
            asyncContextStartAsync.setTimeout(0L);
            final HttpServletStreamableMcpSessionTransport httpServletStreamableMcpSessionTransport = new HttpServletStreamableMcpSessionTransport(header2, asyncContextStartAsync, httpServletResponse.getWriter());
            if (httpServletRequest.getHeader(HttpHeaders.LAST_EVENT_ID) != null) {
                try {
                    mcpStreamableServerSession.replay(httpServletRequest.getHeader(HttpHeaders.LAST_EVENT_ID)).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.s
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                        }
                    }).toIterable().forEach(new Consumer() { // from class: io.modelcontextprotocol.server.transport.t
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            HttpServletStreamableServerTransportProvider.lambda$doGet$8(httpServletStreamableMcpSessionTransport, mcpTransportContextExtract, asyncContextStartAsync, (McpSchema.JSONRPCMessage) obj);
                        }
                    });
                } catch (Exception e10) {
                    logger.u("Failed to replay messages: {}", e10.getMessage());
                    asyncContextStartAsync.complete();
                }
            } else {
                final McpStreamableServerSession.McpStreamableServerSessionStream mcpStreamableServerSessionStreamListeningStream = mcpStreamableServerSession.listeningStream(httpServletStreamableMcpSessionTransport);
                asyncContextStartAsync.addListener(new AsyncListener() { // from class: io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider.1
                    public void onComplete(AsyncEvent asyncEvent) throws IOException {
                        HttpServletStreamableServerTransportProvider.logger.t("SSE connection completed for session: {}", header2);
                        mcpStreamableServerSessionStreamListeningStream.close();
                    }

                    public void onError(AsyncEvent asyncEvent) throws IOException {
                        HttpServletStreamableServerTransportProvider.logger.t("SSE connection error for session: {}", header2);
                        mcpStreamableServerSessionStreamListeningStream.close();
                    }

                    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    }

                    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                        HttpServletStreamableServerTransportProvider.logger.t("SSE connection timed out for session: {}", header2);
                        mcpStreamableServerSessionStreamListeningStream.close();
                    }
                });
            }
        } catch (Exception e11) {
            logger.q("Failed to handle GET request for session {}: {}", header2, e11.getMessage());
            httpServletResponse.sendError(500);
        }
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(404);
            return;
        }
        if (this.isClosing) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        ArrayList arrayList = new ArrayList();
        String header = httpServletRequest.getHeader("Accept");
        if (header == null || !header.contains("text/event-stream")) {
            arrayList.add("text/event-stream required in Accept header");
        }
        if (header == null || !header.contains("application/json")) {
            arrayList.add("application/json required in Accept header");
        }
        final McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        try {
            try {
                BufferedReader reader = httpServletRequest.getReader();
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb2.append(line);
                    }
                }
                McpSchema.JSONRPCMessage jSONRPCMessageDeserializeJsonRpcMessage = McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sb2.toString());
                if (jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCRequest) {
                    McpSchema.JSONRPCRequest jSONRPCRequest = (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage;
                    if (jSONRPCRequest.method().equals(McpSchema.METHOD_INITIALIZE)) {
                        if (!arrayList.isEmpty()) {
                            responseError(httpServletResponse, Const.I_TILE_TINY, new McpError(String.join("; ", arrayList)));
                            return;
                        }
                        McpStreamableServerSession.McpStreamableServerSessionInit mcpStreamableServerSessionInitStartSession = this.sessionFactory.startSession((McpSchema.InitializeRequest) this.jsonMapper.convertValue(jSONRPCRequest.params(), new TypeRef<McpSchema.InitializeRequest>() { // from class: io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider.2
                        }));
                        this.sessions.put(mcpStreamableServerSessionInitStartSession.session().getId(), mcpStreamableServerSessionInitStartSession.session());
                        try {
                            McpSchema.InitializeResult initializeResultBlock = mcpStreamableServerSessionInitStartSession.initResult().block();
                            httpServletResponse.setContentType("application/json");
                            httpServletResponse.setCharacterEncoding("UTF-8");
                            httpServletResponse.setHeader(HttpHeaders.MCP_SESSION_ID, mcpStreamableServerSessionInitStartSession.session().getId());
                            httpServletResponse.setStatus(200);
                            String strWriteValueAsString = this.jsonMapper.writeValueAsString(new McpSchema.JSONRPCResponse("2.0", jSONRPCRequest.id(), initializeResultBlock, null));
                            PrintWriter writer = httpServletResponse.getWriter();
                            writer.write(strWriteValueAsString);
                            writer.flush();
                            return;
                        } catch (Exception e10) {
                            logger.u("Failed to initialize session: {}", e10.getMessage());
                            responseError(httpServletResponse, 500, new McpError("Failed to initialize session: " + e10.getMessage()));
                            return;
                        }
                    }
                }
                String header2 = httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID);
                if (header2 == null || header2.isBlank()) {
                    arrayList.add("Session ID required in mcp-session-id header");
                }
                if (!arrayList.isEmpty()) {
                    responseError(httpServletResponse, Const.I_TILE_TINY, new McpError(String.join("; ", arrayList)));
                    return;
                }
                McpStreamableServerSession mcpStreamableServerSession = this.sessions.get(header2);
                if (mcpStreamableServerSession == null) {
                    responseError(httpServletResponse, 404, new McpError("Session not found: " + header2));
                    return;
                }
                if (jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCResponse) {
                    mcpStreamableServerSession.accept((McpSchema.JSONRPCResponse) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.x
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                        }
                    }).block();
                    httpServletResponse.setStatus(202);
                    return;
                }
                if (jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCNotification) {
                    mcpStreamableServerSession.accept((McpSchema.JSONRPCNotification) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.y
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                        }
                    }).block();
                    httpServletResponse.setStatus(202);
                    return;
                }
                if (!(jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCRequest)) {
                    responseError(httpServletResponse, 500, new McpError("Unknown message type"));
                    return;
                }
                McpSchema.JSONRPCRequest jSONRPCRequest2 = (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage;
                httpServletResponse.setContentType("text/event-stream");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE);
                httpServletResponse.setHeader(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, "keep-alive");
                httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                AsyncContext asyncContextStartAsync = httpServletRequest.startAsync();
                asyncContextStartAsync.setTimeout(0L);
                try {
                    mcpStreamableServerSession.responseStream(jSONRPCRequest2, new HttpServletStreamableMcpSessionTransport(header2, asyncContextStartAsync, httpServletResponse.getWriter())).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.z
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                        }
                    }).block();
                } catch (Exception e11) {
                    logger.u("Failed to handle request stream: {}", e11.getMessage());
                    asyncContextStartAsync.complete();
                }
            } catch (IOException | IllegalArgumentException e12) {
                logger.u("Failed to deserialize message: {}", e12.getMessage());
                responseError(httpServletResponse, Const.I_TILE_TINY, new McpError("Invalid message format: " + e12.getMessage()));
            }
        } catch (Exception e13) {
            logger.u("Error handling message: {}", e13.getMessage());
            try {
                responseError(httpServletResponse, 500, new McpError("Error processing message: " + e13.getMessage()));
            } catch (IOException e14) {
                logger.u("Failed to send error response: {}", e14.getMessage());
                httpServletResponse.sendError(500, "Error processing message");
            }
        }
    }

    @Override // io.modelcontextprotocol.spec.McpStreamableServerTransportProvider, io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(final String str, final Object obj) {
        if (this.sessions.isEmpty()) {
            logger.debug("No active sessions to broadcast message to");
            return Mono.empty();
        }
        logger.t("Attempting to broadcast message to {} active sessions", Integer.valueOf(this.sessions.size()));
        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f34057a.lambda$notifyClients$2(str, obj);
            }
        });
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of("2024-11-05", ProtocolVersions.MCP_2025_03_26, "2025-06-18");
    }

    public void responseError(HttpServletResponse httpServletResponse, int i10, McpError mcpError) throws IOException {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setStatus(i10);
        String strWriteValueAsString = this.jsonMapper.writeValueAsString(mcpError);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(strWriteValueAsString);
        writer.flush();
    }

    @Override // io.modelcontextprotocol.spec.McpStreamableServerTransportProvider
    public void setSessionFactory(McpStreamableServerSession.Factory factory) {
        this.sessionFactory = factory;
    }

    private HttpServletStreamableServerTransportProvider(McpJsonMapper mcpJsonMapper, String str, boolean z10, McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor, Duration duration) {
        this.sessions = new ConcurrentHashMap<>();
        this.isClosing = false;
        Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
        Assert.notNull(str, "MCP endpoint must not be null");
        Assert.notNull(mcpTransportContextExtractor, "Context extractor must not be null");
        this.jsonMapper = mcpJsonMapper;
        this.mcpEndpoint = str;
        this.disallowDelete = z10;
        this.contextExtractor = mcpTransportContextExtractor;
        if (duration != null) {
            KeepAliveScheduler keepAliveSchedulerBuild = KeepAliveScheduler.builder(new Supplier() { // from class: io.modelcontextprotocol.server.transport.p
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f34049a.lambda$new$0();
                }
            }).initialDelay(duration).interval(duration).build();
            this.keepAliveScheduler = keepAliveSchedulerBuild;
            keepAliveSchedulerBuild.start();
        }
    }
}
