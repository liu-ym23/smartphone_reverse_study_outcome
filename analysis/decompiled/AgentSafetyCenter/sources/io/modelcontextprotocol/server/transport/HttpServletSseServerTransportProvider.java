package io.modelcontextprotocol.server.transport;

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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@WebServlet(asyncSupported = true)
/* loaded from: classes.dex */
public class HttpServletSseServerTransportProvider extends HttpServlet implements McpServerTransportProvider {
    public static final String APPLICATION_JSON = "application/json";
    public static final String DEFAULT_BASE_URL = "";
    public static final String DEFAULT_SSE_ENDPOINT = "/sse";
    public static final String ENDPOINT_EVENT_TYPE = "endpoint";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String MESSAGE_EVENT_TYPE = "message";
    public static final String UTF_8 = "UTF-8";
    private static final rd.b logger = rd.d.b(HttpServletSseServerTransportProvider.class);
    private final String baseUrl;
    private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
    private final AtomicBoolean isClosing;
    private final McpJsonMapper jsonMapper;
    private KeepAliveScheduler keepAliveScheduler;
    private final String messageEndpoint;
    private McpServerSession.Factory sessionFactory;
    private final Map<String, McpServerSession> sessions;
    private final String sseEndpoint;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
                od.f.e("MessageEndpoint must be set");
                return null;
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class HttpServletMcpSessionTransport implements McpServerTransport {
        private final AsyncContext asyncContext;
        private final String sessionId;
        private final PrintWriter writer;

        public HttpServletMcpSessionTransport(String str, AsyncContext asyncContext, PrintWriter printWriter) {
            this.sessionId = str;
            this.asyncContext = asyncContext;
            this.writer = printWriter;
            HttpServletSseServerTransportProvider.logger.h(str, "Session transport {} initialized with SSE writer");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$closeGracefully$1() {
            HttpServletSseServerTransportProvider.logger.h(this.sessionId, "Closing session transport: {}");
            try {
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
                HttpServletSseServerTransportProvider.logger.h(this.sessionId, "Successfully completed async context for session {}");
            } catch (Exception e10) {
                HttpServletSseServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e10.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage) {
            try {
                HttpServletSseServerTransportProvider.this.sendEvent(this.writer, "message", HttpServletSseServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage));
                HttpServletSseServerTransportProvider.logger.h(this.sessionId, "Message sent to session {}");
            } catch (Exception e10) {
                HttpServletSseServerTransportProvider.logger.e("Failed to send message to session {}: {}", this.sessionId, e10.getMessage());
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
                HttpServletSseServerTransportProvider.logger.h(this.sessionId, "Successfully completed async context for session {}");
            } catch (Exception e10) {
                HttpServletSseServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e10.getMessage());
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            g gVar = new g(0);
            gVar.f6303f = this;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(gVar);
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
            f fVar = new f();
            fVar.f6300c = this;
            fVar.f6301f = jSONRPCMessage;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(fVar);
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) HttpServletSseServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }
    }

    private HttpServletSseServerTransportProvider(McpJsonMapper mcpJsonMapper, String str, String str2, String str3, Duration duration, McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor) {
        this.sessions = new ConcurrentHashMap();
        int i = 0;
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
            a aVar = new a(i);
            aVar.f6293f = this;
            VarHandle.storeStoreFence();
            KeepAliveScheduler keepAliveSchedulerBuild = KeepAliveScheduler.builder(aVar).initialDelay(duration).interval(duration).build();
            this.keepAliveScheduler = keepAliveSchedulerBuild;
            keepAliveSchedulerBuild.start();
        }
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
        logger.e("Failed to send message to session {}: {}", mcpServerSession.getId(), th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$notifyClients$2(String str, Object obj, McpServerSession mcpServerSession) {
        Mono<Void> monoSendNotification = mcpServerSession.sendNotification(str, obj);
        b bVar = new b(1);
        bVar.f6295f = mcpServerSession;
        VarHandle.storeStoreFence();
        return monoSendNotification.doOnError(bVar).onErrorComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(PrintWriter printWriter, String str, String str2) throws IOException {
        printWriter.write("event: " + str + "\n");
        printWriter.write("data: " + str2 + "\n\n");
        printWriter.flush();
        if (printWriter.checkError()) {
            od.f.l("Client disconnected");
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        this.isClosing.set(true);
        logger.h(Integer.valueOf(this.sessions.size()), "Initiating graceful shutdown with {} active sessions");
        Mono<Void> monoThen = Flux.fromIterable(this.sessions.values()).flatMap(new com.stepos.mcp.sdk.java.transport.p(1)).then();
        b bVar = new b(0);
        bVar.f6295f = this;
        VarHandle.storeStoreFence();
        return monoThen.doOnSuccess(bVar);
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        if (!httpServletRequest.getRequestURI().endsWith(this.sseEndpoint)) {
            httpServletResponse.sendError(404);
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

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        if (this.isClosing.get()) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        if (!httpServletRequest.getRequestURI().endsWith(this.messageEndpoint)) {
            httpServletResponse.sendError(404);
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
            httpServletResponse.setStatus(404);
            String strWriteValueAsString2 = this.jsonMapper.writeValueAsString(new McpError("Session not found: ".concat(parameter)));
            PrintWriter writer2 = httpServletResponse.getWriter();
            writer2.write(strWriteValueAsString2);
            writer2.flush();
            return;
        }
        try {
            BufferedReader reader = httpServletRequest.getReader();
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
                    Mono<Void> monoHandle = mcpServerSession.handle(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sb2.toString()));
                    d dVar = new d(0);
                    dVar.f6299b = mcpTransportContextExtract;
                    VarHandle.storeStoreFence();
                    monoHandle.contextWrite(dVar).block();
                    httpServletResponse.setStatus(200);
                    return;
                }
                sb2.append(line);
            }
        } catch (Exception e10) {
            logger.f(e10.getMessage(), "Error processing message: {}");
            try {
                McpError mcpError = new McpError(e10.getMessage());
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setStatus(500);
                String strWriteValueAsString3 = this.jsonMapper.writeValueAsString(mcpError);
                PrintWriter writer3 = httpServletResponse.getWriter();
                writer3.write(strWriteValueAsString3);
                writer3.flush();
            } catch (IOException e11) {
                logger.f(e11.getMessage(), "Failed to send error response: {}");
                httpServletResponse.sendError(500, "Error processing message");
            }
        }
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(String str, Object obj) {
        if (this.sessions.isEmpty()) {
            logger.debug("No active sessions to broadcast message to");
            return Mono.empty();
        }
        logger.h(Integer.valueOf(this.sessions.size()), "Attempting to broadcast message to {} active sessions");
        Flux fluxFromIterable = Flux.fromIterable(this.sessions.values());
        c cVar = new c();
        cVar.f6296a = str;
        cVar.f6297b = obj;
        VarHandle.storeStoreFence();
        return fluxFromIterable.flatMap(cVar).then();
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05);
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProvider
    public void setSessionFactory(McpServerSession.Factory factory) {
        this.sessionFactory = factory;
    }

    public /* synthetic */ HttpServletSseServerTransportProvider(McpJsonMapper mcpJsonMapper, String str, String str2, String str3, Duration duration, McpTransportContextExtractor mcpTransportContextExtractor, int i) {
        this(mcpJsonMapper, str, str2, str3, duration, mcpTransportContextExtractor);
    }
}
