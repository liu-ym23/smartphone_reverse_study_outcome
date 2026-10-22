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
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@WebServlet(asyncSupported = true)
/* loaded from: classes4.dex */
public class HttpServletSseServerTransportProvider extends HttpServlet implements McpServerTransportProvider {
    public static final String APPLICATION_JSON = "application/json";
    public static final String DEFAULT_BASE_URL = "";
    public static final String DEFAULT_SSE_ENDPOINT = "/sse";
    public static final String ENDPOINT_EVENT_TYPE = "endpoint";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String MESSAGE_EVENT_TYPE = "message";
    public static final String UTF_8 = "UTF-8";
    private static final vc.c logger = vc.e.l(HttpServletSseServerTransportProvider.class);
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
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor = new McpTransportContextExtractor() { // from class: io.modelcontextprotocol.server.transport.f
            @Override // io.modelcontextprotocol.server.McpTransportContextExtractor
            public final McpTransportContext extract(Object obj) {
                return McpTransportContext.EMPTY;
            }
        };

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
            return new HttpServletSseServerTransportProvider(mcpJsonMapper, this.baseUrl, this.messageEndpoint, this.sseEndpoint, this.keepAliveInterval, this.contextExtractor);
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
            HttpServletSseServerTransportProvider.logger.t("Session transport {} initialized with SSE writer", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$closeGracefully$1() {
            HttpServletSseServerTransportProvider.logger.t("Closing session transport: {}", this.sessionId);
            try {
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
                HttpServletSseServerTransportProvider.logger.t("Successfully completed async context for session {}", this.sessionId);
            } catch (Exception e10) {
                HttpServletSseServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e10.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage) {
            try {
                HttpServletSseServerTransportProvider.this.sendEvent(this.writer, "message", HttpServletSseServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage));
                HttpServletSseServerTransportProvider.logger.t("Message sent to session {}", this.sessionId);
            } catch (Exception e10) {
                HttpServletSseServerTransportProvider.logger.q("Failed to send message to session {}: {}", this.sessionId, e10.getMessage());
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public void close() {
            try {
                HttpServletSseServerTransportProvider.this.sessions.remove(this.sessionId);
                this.asyncContext.complete();
                HttpServletSseServerTransportProvider.logger.t("Successfully completed async context for session {}", this.sessionId);
            } catch (Exception e10) {
                HttpServletSseServerTransportProvider.logger.c("Failed to complete async context for session {}: {}", this.sessionId, e10.getMessage());
            }
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34044a.lambda$closeGracefully$1();
                }
            });
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
            return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f34042a.lambda$sendMessage$0(jSONRPCMessage);
                }
            });
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) HttpServletSseServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
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
    public /* synthetic */ Flux lambda$new$0() {
        return this.isClosing.get() ? Flux.empty() : Flux.fromIterable(this.sessions.values());
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
        logger.t("Initiating graceful shutdown with {} active sessions", Integer.valueOf(this.sessions.size()));
        return Flux.fromIterable(this.sessions.values()).flatMap(new com.stepos.mcp.sdk.java.transport.d()).then().doOnSuccess(new Consumer() { // from class: io.modelcontextprotocol.server.transport.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34037a.lambda$closeGracefully$4((Void) obj);
            }
        });
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
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
        httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, CacheControl.NO_CACHE);
        httpServletResponse.setHeader(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, "keep-alive");
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
            httpServletResponse.sendError(404);
            return;
        }
        String parameter = httpServletRequest.getParameter("sessionId");
        if (parameter == null) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setStatus(Const.I_TILE_TINY);
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
            String strWriteValueAsString2 = this.jsonMapper.writeValueAsString(new McpError("Session not found: " + parameter));
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
                    final McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
                    mcpServerSession.handle(McpSchema.deserializeJsonRpcMessage(this.jsonMapper, sb2.toString())).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.d
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                        }
                    }).block();
                    httpServletResponse.setStatus(200);
                    return;
                }
                sb2.append(line);
            }
        } catch (Exception e10) {
            logger.u("Error processing message: {}", e10.getMessage());
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
                logger.u("Failed to send error response: {}", e11.getMessage());
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
        logger.t("Attempting to broadcast message to {} active sessions", Integer.valueOf(this.sessions.size()));
        return Flux.fromIterable(this.sessions.values()).flatMap(new Function() { // from class: io.modelcontextprotocol.server.transport.c
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                McpServerSession mcpServerSession = (McpServerSession) obj2;
                return mcpServerSession.sendNotification(str, obj).doOnError(new Consumer() { // from class: io.modelcontextprotocol.server.transport.e
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj3) {
                        HttpServletSseServerTransportProvider.logger.q("Failed to send message to session {}: {}", mcpServerSession.getId(), ((Throwable) obj3).getMessage());
                    }
                }).onErrorComplete();
            }
        }).then();
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of("2024-11-05");
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
            KeepAliveScheduler keepAliveSchedulerBuild = KeepAliveScheduler.builder(new Supplier() { // from class: io.modelcontextprotocol.server.transport.a
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f34036a.lambda$new$0();
                }
            }).initialDelay(duration).interval(duration).build();
            this.keepAliveScheduler = keepAliveSchedulerBuild;
            keepAliveSchedulerBuild.start();
        }
    }
}
