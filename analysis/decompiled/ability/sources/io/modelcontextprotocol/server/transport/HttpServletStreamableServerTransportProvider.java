package io.modelcontextprotocol.server.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import androidx.compose.runtime.ComposerKt;
import com.stepos.ability.mcpserver.model.McpErrorCode;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@WebServlet(asyncSupported = true)
/* loaded from: classes3.dex */
public class HttpServletStreamableServerTransportProvider extends HttpServlet implements McpStreamableServerTransportProvider {
    private static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String ENDPOINT_EVENT_TYPE = "endpoint";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String MESSAGE_EVENT_TYPE = "message";
    public static final String TEXT_EVENT_STREAM = "text/event-stream";
    public static final String UTF_8 = "UTF-8";
    private static final InterfaceC0315b logger = AbstractC0317d.b(HttpServletStreamableServerTransportProvider.class);
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
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor = new l();

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpTransportContext lambda$new$0(HttpServletRequest httpServletRequest) {
            return McpTransportContext.EMPTY;
        }

        public HttpServletStreamableServerTransportProvider build() {
            Assert.notNull(this.mcpEndpoint, "MCP endpoint must be set");
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpServletStreamableServerTransportProvider(mcpJsonMapper, this.mcpEndpoint, this.disallowDelete, this.contextExtractor, this.keepAliveInterval, 0);
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
            HttpServletStreamableServerTransportProvider.logger.j(str, "Streamable session transport {} initialized with SSE writer");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage, String str) {
            if (this.closed) {
                HttpServletStreamableServerTransportProvider.logger.j(this.sessionId, "Attempted to send message to closed session: {}");
                return;
            }
            this.lock.lock();
            try {
                if (this.closed) {
                    HttpServletStreamableServerTransportProvider.logger.j(this.sessionId, "Session {} was closed during message send attempt");
                    return;
                }
                HttpServletStreamableServerTransportProvider.this.sendEvent(this.writer, "message", HttpServletStreamableServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage), str != null ? str : this.sessionId);
                HttpServletStreamableServerTransportProvider.logger.a("Message sent to session {} with ID {}", this.sessionId, str);
            } catch (Exception e) {
                HttpServletStreamableServerTransportProvider.logger.i("Failed to send message to session {}: {}", this.sessionId, e.getMessage());
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
                        HttpServletStreamableServerTransportProvider.logger.j(this.sessionId, "Session transport {} already closed");
                    } else {
                        this.closed = true;
                        this.asyncContext.complete();
                        HttpServletStreamableServerTransportProvider.logger.j(this.sessionId, "Successfully completed async context for session {}");
                    }
                } catch (Exception e) {
                    HttpServletStreamableServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e.getMessage());
                }
            } finally {
                this.lock.unlock();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new g(this, 1));
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
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage, String str) {
            return Mono.fromRunnable(new m(this, jSONRPCMessage, str));
        }
    }

    public /* synthetic */ HttpServletStreamableServerTransportProvider(McpJsonMapper mcpJsonMapper, String str, boolean z10, McpTransportContextExtractor mcpTransportContextExtractor, Duration duration, int i) {
        this(mcpJsonMapper, str, z10, mcpTransportContextExtractor, duration);
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeGracefully$3(McpStreamableServerSession mcpStreamableServerSession) {
        try {
            mcpStreamableServerSession.closeGracefully().block();
        } catch (Exception e) {
            logger.i("Failed to close session {}: {}", mcpStreamableServerSession.getId(), e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$4() {
        this.isClosing = true;
        InterfaceC0315b interfaceC0315b = logger;
        interfaceC0315b.j(Integer.valueOf(this.sessions.size()), "Initiating graceful shutdown with {} active sessions");
        this.sessions.values().parallelStream().forEach(new j(0));
        this.sessions.clear();
        interfaceC0315b.debug("Graceful shutdown completed");
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
    public static /* synthetic */ Context lambda$doDelete$12(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doGet$6(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doGet$7(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doGet$8(HttpServletStreamableMcpSessionTransport httpServletStreamableMcpSessionTransport, McpTransportContext mcpTransportContext, AsyncContext asyncContext, McpSchema.JSONRPCMessage jSONRPCMessage) {
        try {
            httpServletStreamableMcpSessionTransport.sendMessage(jSONRPCMessage).contextWrite(new d(mcpTransportContext, 5)).block();
        } catch (Exception e) {
            logger.e(e.getMessage(), "Failed to replay message: {}");
            asyncContext.complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doPost$10(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doPost$11(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doPost$9(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Flux lambda$new$0() {
        return this.isClosing ? Flux.empty() : Flux.fromIterable(this.sessions.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyClients$1(String str, Object obj, McpStreamableServerSession mcpStreamableServerSession) {
        try {
            mcpStreamableServerSession.sendNotification(str, obj).block();
        } catch (Exception e) {
            logger.i("Failed to send message to session {}: {}", mcpStreamableServerSession.getId(), e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyClients$2(final String str, final Object obj) {
        this.sessions.values().parallelStream().forEach(new Consumer() { // from class: io.modelcontextprotocol.server.transport.k
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                HttpServletStreamableServerTransportProvider.lambda$notifyClients$1(str, obj, (McpStreamableServerSession) obj2);
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
        return Mono.fromRunnable(new g(this, 3)).then().doOnSuccess(new b(this, 2));
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
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
        McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        if (httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID) == null) {
            responseError(httpServletResponse, 400, new McpError("Session ID required in mcp-session-id header"));
            return;
        }
        String header = httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID);
        McpStreamableServerSession mcpStreamableServerSession = this.sessions.get(header);
        if (mcpStreamableServerSession == null) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
            return;
        }
        try {
            mcpStreamableServerSession.delete().contextWrite(new d(mcpTransportContextExtract, 3)).block();
            this.sessions.remove(header);
            httpServletResponse.setStatus(200);
        } catch (Exception e) {
            logger.i("Failed to delete session {}: {}", header, e.getMessage());
            try {
                responseError(httpServletResponse, 500, new McpError(e.getMessage()));
            } catch (IOException e6) {
                logger.e(e6.getMessage(), "Failed to send error response: {}");
                httpServletResponse.sendError(500, "Error deleting session");
            }
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
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
            responseError(httpServletResponse, 400, new McpError(String.join("; ", arrayList)));
            return;
        }
        McpStreamableServerSession mcpStreamableServerSession = this.sessions.get(header2);
        if (mcpStreamableServerSession == null) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
            return;
        }
        logger.j(header2, "Handling GET request for session: {}");
        final McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        try {
            httpServletResponse.setContentType("text/event-stream");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
            httpServletResponse.setHeader("Connection", "keep-alive");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            final AsyncContext asyncContextStartAsync = httpServletRequest.startAsync();
            asyncContextStartAsync.setTimeout(0L);
            final HttpServletStreamableMcpSessionTransport httpServletStreamableMcpSessionTransport = new HttpServletStreamableMcpSessionTransport(header2, asyncContextStartAsync, httpServletResponse.getWriter());
            if (httpServletRequest.getHeader(HttpHeaders.LAST_EVENT_ID) != null) {
                try {
                    mcpStreamableServerSession.replay(httpServletRequest.getHeader(HttpHeaders.LAST_EVENT_ID)).contextWrite(new d(mcpTransportContextExtract, 4)).toIterable().forEach(new Consumer() { // from class: io.modelcontextprotocol.server.transport.i
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            HttpServletStreamableServerTransportProvider.lambda$doGet$8(httpServletStreamableMcpSessionTransport, mcpTransportContextExtract, asyncContextStartAsync, (McpSchema.JSONRPCMessage) obj);
                        }
                    });
                } catch (Exception e) {
                    logger.e(e.getMessage(), "Failed to replay messages: {}");
                    asyncContextStartAsync.complete();
                }
            } else {
                final McpStreamableServerSession.McpStreamableServerSessionStream mcpStreamableServerSessionStreamListeningStream = mcpStreamableServerSession.listeningStream(httpServletStreamableMcpSessionTransport);
                asyncContextStartAsync.addListener(new AsyncListener() { // from class: io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider.1
                    public void onComplete(AsyncEvent asyncEvent) throws IOException {
                        HttpServletStreamableServerTransportProvider.logger.j(header2, "SSE connection completed for session: {}");
                        mcpStreamableServerSessionStreamListeningStream.close();
                    }

                    public void onError(AsyncEvent asyncEvent) throws IOException {
                        HttpServletStreamableServerTransportProvider.logger.j(header2, "SSE connection error for session: {}");
                        mcpStreamableServerSessionStreamListeningStream.close();
                    }

                    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    }

                    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                        HttpServletStreamableServerTransportProvider.logger.j(header2, "SSE connection timed out for session: {}");
                        mcpStreamableServerSessionStreamListeningStream.close();
                    }
                });
            }
        } catch (Exception e6) {
            logger.i("Failed to handle GET request for session {}: {}", header2, e6.getMessage());
            httpServletResponse.sendError(500);
        }
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
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
        McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        try {
            try {
                BufferedReader reader = httpServletRequest.getReader();
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line);
                    }
                }
                McpSchema.JSONRPCMessage jSONRPCMessageDeserializeJsonRpcMessage = McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sb.toString());
                if (jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCRequest) {
                    McpSchema.JSONRPCRequest jSONRPCRequest = (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage;
                    if (jSONRPCRequest.method().equals(McpSchema.METHOD_INITIALIZE)) {
                        if (!arrayList.isEmpty()) {
                            responseError(httpServletResponse, 400, new McpError(String.join("; ", arrayList)));
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
                            String strWriteValueAsString = this.jsonMapper.writeValueAsString(new McpSchema.JSONRPCResponse(McpSchema.JSONRPC_VERSION, jSONRPCRequest.id(), initializeResultBlock, null));
                            PrintWriter writer = httpServletResponse.getWriter();
                            writer.write(strWriteValueAsString);
                            writer.flush();
                            return;
                        } catch (Exception e) {
                            logger.e(e.getMessage(), "Failed to initialize session: {}");
                            responseError(httpServletResponse, 500, new McpError("Failed to initialize session: " + e.getMessage()));
                            return;
                        }
                    }
                }
                String header2 = httpServletRequest.getHeader(HttpHeaders.MCP_SESSION_ID);
                if (header2 == null || header2.isBlank()) {
                    arrayList.add("Session ID required in mcp-session-id header");
                }
                if (!arrayList.isEmpty()) {
                    responseError(httpServletResponse, 400, new McpError(String.join("; ", arrayList)));
                    return;
                }
                McpStreamableServerSession mcpStreamableServerSession = this.sessions.get(header2);
                if (mcpStreamableServerSession == null) {
                    responseError(httpServletResponse, McpErrorCode.TOOL_NOT_FOUND, new McpError("Session not found: " + header2));
                    return;
                }
                if (jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCResponse) {
                    mcpStreamableServerSession.accept((McpSchema.JSONRPCResponse) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new d(mcpTransportContextExtract, 6)).block();
                    httpServletResponse.setStatus(ComposerKt.compositionLocalMapKey);
                    return;
                }
                if (jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCNotification) {
                    mcpStreamableServerSession.accept((McpSchema.JSONRPCNotification) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new d(mcpTransportContextExtract, 7)).block();
                    httpServletResponse.setStatus(ComposerKt.compositionLocalMapKey);
                    return;
                }
                if (!(jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCRequest)) {
                    responseError(httpServletResponse, 500, new McpError("Unknown message type"));
                    return;
                }
                McpSchema.JSONRPCRequest jSONRPCRequest2 = (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage;
                httpServletResponse.setContentType("text/event-stream");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
                httpServletResponse.setHeader("Connection", "keep-alive");
                httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                AsyncContext asyncContextStartAsync = httpServletRequest.startAsync();
                asyncContextStartAsync.setTimeout(0L);
                try {
                    mcpStreamableServerSession.responseStream(jSONRPCRequest2, new HttpServletStreamableMcpSessionTransport(header2, asyncContextStartAsync, httpServletResponse.getWriter())).contextWrite(new d(mcpTransportContextExtract, 8)).block();
                } catch (Exception e6) {
                    logger.e(e6.getMessage(), "Failed to handle request stream: {}");
                    asyncContextStartAsync.complete();
                }
            } catch (IOException | IllegalArgumentException e9) {
                logger.e(e9.getMessage(), "Failed to deserialize message: {}");
                responseError(httpServletResponse, 400, new McpError(B7.a.k("Invalid message format: ", e9.getMessage())));
            }
        } catch (Exception e10) {
            logger.e(e10.getMessage(), "Error handling message: {}");
            try {
                responseError(httpServletResponse, 500, new McpError("Error processing message: " + e10.getMessage()));
            } catch (IOException e11) {
                logger.e(e11.getMessage(), "Failed to send error response: {}");
                httpServletResponse.sendError(500, "Error processing message");
            }
        }
    }

    @Override // io.modelcontextprotocol.spec.McpStreamableServerTransportProvider, io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(String str, Object obj) {
        if (this.sessions.isEmpty()) {
            logger.debug("No active sessions to broadcast message to");
            return Mono.empty();
        }
        logger.j(Integer.valueOf(this.sessions.size()), "Attempting to broadcast message to {} active sessions");
        return Mono.fromRunnable(new m(this, str, obj));
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05, ProtocolVersions.MCP_2025_03_26, "2025-06-18");
    }

    public void responseError(HttpServletResponse httpServletResponse, int i, McpError mcpError) throws IOException {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setStatus(i);
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
            KeepAliveScheduler keepAliveSchedulerBuild = KeepAliveScheduler.builder(new a(this, 1)).initialDelay(duration).interval(duration).build();
            this.keepAliveScheduler = keepAliveSchedulerBuild;
            keepAliveSchedulerBuild.start();
        }
    }
}
