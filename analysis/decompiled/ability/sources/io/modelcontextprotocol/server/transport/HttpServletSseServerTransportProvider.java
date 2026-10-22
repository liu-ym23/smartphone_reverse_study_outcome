package io.modelcontextprotocol.server.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.McpTransportContextExtractor;
import io.modelcontextprotocol.spec.HttpHeaders;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import io.modelcontextprotocol.spec.ProtocolVersions;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.KeepAliveScheduler;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@WebServlet(asyncSupported = true)
/* loaded from: classes3.dex */
public class HttpServletSseServerTransportProvider extends HttpServlet implements McpServerTransportProvider {
    public static final String APPLICATION_JSON = "application/json";
    public static final String DEFAULT_BASE_URL = "";
    public static final String DEFAULT_SSE_ENDPOINT = "/sse";
    public static final String ENDPOINT_EVENT_TYPE = "endpoint";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String MESSAGE_EVENT_TYPE = "message";
    public static final String UTF_8 = "UTF-8";
    private static final InterfaceC0315b logger = AbstractC0317d.b(HttpServletSseServerTransportProvider.class);
    private final String baseUrl;
    private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
    private final AtomicBoolean isClosing;
    private final McpJsonMapper jsonMapper;
    private KeepAliveScheduler keepAliveScheduler;
    private final String messageEndpoint;
    private McpServerSession.Factory sessionFactory;
    private final Map<String, McpServerSession> sessions;
    private final String sseEndpoint;

    public static class Builder {
        private McpJsonMapper jsonMapper;
        private Duration keepAliveInterval;
        private String messageEndpoint;
        private String baseUrl = "";
        private String sseEndpoint = HttpServletSseServerTransportProvider.DEFAULT_SSE_ENDPOINT;
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor = new e();

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpTransportContext lambda$new$0(HttpServletRequest httpServletRequest) {
            return McpTransportContext.EMPTY;
        }

        public Builder baseUrl(String str) {
            Assert.notNull(str, "Base URL must not be null");
            this.baseUrl = str;
            return this;
        }

        public HttpServletSseServerTransportProvider build() {
            if (this.messageEndpoint == null) {
                throw new IllegalStateException("MessageEndpoint must be set");
            }
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpServletSseServerTransportProvider(mcpJsonMapper, this.baseUrl, this.messageEndpoint, this.sseEndpoint, this.keepAliveInterval, this.contextExtractor, 0);
        }

        public Builder contextExtractor(McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor) {
            Assert.notNull(mcpTransportContextExtractor, "Context extractor must not be null");
            this.contextExtractor = mcpTransportContextExtractor;
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

        public Builder messageEndpoint(String str) {
            Assert.hasText(str, "Message endpoint must not be empty");
            this.messageEndpoint = str;
            return this;
        }

        public Builder sseEndpoint(String str) {
            Assert.hasText(str, "SSE endpoint must not be empty");
            this.sseEndpoint = str;
            return this;
        }
    }

    public class HttpServletMcpSessionTransport implements McpServerTransport {
        private final AsyncContext asyncContext;
        private final String sessionId;
        private final PrintWriter writer;

        public HttpServletMcpSessionTransport(String str, AsyncContext asyncContext, PrintWriter printWriter) {
            this.sessionId = str;
            this.asyncContext = asyncContext;
            this.writer = printWriter;
            HttpServletSseServerTransportProvider.logger.j(str, "Session transport {} initialized with SSE writer");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$closeGracefully$1() {
            HttpServletSseServerTransportProvider.logger.j(this.sessionId, "Closing session transport: {}");
            try {
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
                HttpServletSseServerTransportProvider.logger.j(this.sessionId, "Successfully completed async context for session {}");
            } catch (Exception e) {
                HttpServletSseServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage) {
            try {
                HttpServletSseServerTransportProvider.this.sendEvent(this.writer, "message", HttpServletSseServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage));
                HttpServletSseServerTransportProvider.logger.j(this.sessionId, "Message sent to session {}");
            } catch (Exception e) {
                HttpServletSseServerTransportProvider.logger.i("Failed to send message to session {}: {}", this.sessionId, e.getMessage());
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        /* renamed from: close */
        public void lambda$closeGracefully$1() {
            try {
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
                HttpServletSseServerTransportProvider.logger.j(this.sessionId, "Successfully completed async context for session {}");
            } catch (Exception e) {
                HttpServletSseServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e.getMessage());
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new g(this, 0));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
            return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4723a.lambda$sendMessage$0(jSONRPCMessage);
                }
            });
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) HttpServletSseServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }
    }

    public /* synthetic */ HttpServletSseServerTransportProvider(McpJsonMapper mcpJsonMapper, String str, String str2, String str3, Duration duration, McpTransportContextExtractor mcpTransportContextExtractor, int i) {
        this(mcpJsonMapper, str, str2, str3, duration, mcpTransportContextExtractor);
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$4(Void r22) {
        this.sessions.clear();
        logger.debug("Graceful shutdown completed");
        KeepAliveScheduler keepAliveScheduler = this.keepAliveScheduler;
        if (keepAliveScheduler != null) {
            keepAliveScheduler.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doPost$3(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Flux lambda$new$0() {
        return this.isClosing.get() ? Flux.empty() : Flux.fromIterable(this.sessions.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyClients$1(McpServerSession mcpServerSession, Throwable th) {
        logger.i("Failed to send message to session {}: {}", mcpServerSession.getId(), th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Z9.c lambda$notifyClients$2(String str, Object obj, McpServerSession mcpServerSession) {
        return mcpServerSession.sendNotification(str, obj).doOnError(new b(mcpServerSession, 1)).onErrorComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(PrintWriter printWriter, String str, String str2) throws IOException {
        printWriter.write("event: " + str + "\n");
        printWriter.write("data: " + str2 + "\n\n");
        printWriter.flush();
        if (printWriter.checkError()) {
            throw new IOException("Client disconnected");
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        this.isClosing.set(true);
        logger.j(Integer.valueOf(this.sessions.size()), "Initiating graceful shutdown with {} active sessions");
        return Flux.fromIterable(this.sessions.values()).flatMap(new com.stepos.mcp.sdk.java.transport.o(1)).then().doOnSuccess(new b(this, 0));
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (!httpServletRequest.getRequestURI().endsWith(this.sseEndpoint)) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
            return;
        }
        if (this.isClosing.get()) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        httpServletResponse.setContentType("text/event-stream");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        httpServletResponse.setHeader("Connection", "keep-alive");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        String string = UUID.randomUUID().toString();
        AsyncContext asyncContextStartAsync = httpServletRequest.startAsync();
        asyncContextStartAsync.setTimeout(0L);
        PrintWriter writer = httpServletResponse.getWriter();
        this.sessions.put(string, this.sessionFactory.create(new HttpServletMcpSessionTransport(string, asyncContextStartAsync, writer)));
        sendEvent(writer, "endpoint", this.baseUrl + this.messageEndpoint + "?sessionId=" + string);
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (this.isClosing.get()) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        if (!httpServletRequest.getRequestURI().endsWith(this.messageEndpoint)) {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
            return;
        }
        String parameter = httpServletRequest.getParameter("sessionId");
        if (parameter == null) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setStatus(400);
            String strWriteValueAsString = this.jsonMapper.writeValueAsString(new McpError("Session ID missing in message endpoint"));
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(strWriteValueAsString);
            writer.flush();
            return;
        }
        McpServerSession mcpServerSession = this.sessions.get(parameter);
        if (mcpServerSession == null) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setStatus(McpErrorCode.TOOL_NOT_FOUND);
            String strWriteValueAsString2 = this.jsonMapper.writeValueAsString(new McpError("Session not found: ".concat(parameter)));
            PrintWriter writer2 = httpServletResponse.getWriter();
            writer2.write(strWriteValueAsString2);
            writer2.flush();
            return;
        }
        try {
            BufferedReader reader = httpServletRequest.getReader();
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    mcpServerSession.handle(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sb.toString())).contextWrite(new d(this.contextExtractor.extract(httpServletRequest), 0)).block();
                    httpServletResponse.setStatus(200);
                    return;
                }
                sb.append(line);
            }
        } catch (Exception e) {
            logger.e(e.getMessage(), "Error processing message: {}");
            try {
                McpError mcpError = new McpError(e.getMessage());
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setStatus(500);
                String strWriteValueAsString3 = this.jsonMapper.writeValueAsString(mcpError);
                PrintWriter writer3 = httpServletResponse.getWriter();
                writer3.write(strWriteValueAsString3);
                writer3.flush();
            } catch (IOException e6) {
                logger.e(e6.getMessage(), "Failed to send error response: {}");
                httpServletResponse.sendError(500, "Error processing message");
            }
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(final String str, final Object obj) {
        if (this.sessions.isEmpty()) {
            logger.debug("No active sessions to broadcast message to");
            return Mono.empty();
        }
        logger.j(Integer.valueOf(this.sessions.size()), "Attempting to broadcast message to {} active sessions");
        return Flux.fromIterable(this.sessions.values()).flatMap(new Function() { // from class: io.modelcontextprotocol.server.transport.c
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return HttpServletSseServerTransportProvider.lambda$notifyClients$2(str, obj, (McpServerSession) obj2);
            }
        }).then();
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05);
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProvider
    public void setSessionFactory(McpServerSession.Factory factory) {
        this.sessionFactory = factory;
    }

    private HttpServletSseServerTransportProvider(McpJsonMapper mcpJsonMapper, String str, String str2, String str3, Duration duration, McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor) {
        this.sessions = new ConcurrentHashMap();
        this.isClosing = new AtomicBoolean(false);
        Assert.notNull(mcpJsonMapper, "JsonMapper must not be null");
        Assert.notNull(str2, "messageEndpoint must not be null");
        Assert.notNull(str3, "sseEndpoint must not be null");
        Assert.notNull(mcpTransportContextExtractor, "Context extractor must not be null");
        this.jsonMapper = mcpJsonMapper;
        this.baseUrl = str;
        this.messageEndpoint = str2;
        this.sseEndpoint = str3;
        this.contextExtractor = mcpTransportContextExtractor;
        if (duration != null) {
            KeepAliveScheduler keepAliveSchedulerBuild = KeepAliveScheduler.builder(new a(this, 0)).initialDelay(duration).interval(duration).build();
            this.keepAliveScheduler = keepAliveSchedulerBuild;
            keepAliveSchedulerBuild.start();
        }
    }
}
