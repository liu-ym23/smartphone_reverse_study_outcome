package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.server.McpStatelessServerHandler;
import io.modelcontextprotocol.server.McpTransportContextExtractor;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStatelessServerTransport;
import io.modelcontextprotocol.util.Assert;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.VarHandle;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@WebServlet(asyncSupported = true)
/* loaded from: classes.dex */
public class HttpServletStatelessServerTransport extends HttpServlet implements McpStatelessServerTransport {
    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String TEXT_EVENT_STREAM = "text/event-stream";
    public static final String UTF_8 = "UTF-8";
    private static final rd.b logger = rd.d.b(HttpServletStatelessServerTransport.class);
    private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
    private volatile boolean isClosing;
    private final McpJsonMapper jsonMapper;
    private final String mcpEndpoint;
    private McpStatelessServerHandler mcpHandler;

    private HttpServletStatelessServerTransport(McpJsonMapper mcpJsonMapper, String str, McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor) {
        this.isClosing = false;
        Assert.notNull(mcpJsonMapper, "jsonMapper must not be null");
        Assert.notNull(str, "mcpEndpoint must not be null");
        Assert.notNull(mcpTransportContextExtractor, "contextExtractor must not be null");
        this.jsonMapper = mcpJsonMapper;
        this.mcpEndpoint = str;
        this.contextExtractor = mcpTransportContextExtractor;
    }

    public static Builder builder() {
        return new Builder(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$0() {
        this.isClosing = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doPost$1(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$doPost$2(McpTransportContext mcpTransportContext, Context context) {
        return context.put(McpTransportContext.KEY, mcpTransportContext);
    }

    private void responseError(HttpServletResponse httpServletResponse, int i, McpError mcpError) {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setStatus(i);
        String strWriteValueAsString = this.jsonMapper.writeValueAsString(mcpError);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(strWriteValueAsString);
        writer.flush();
    }

    @Override // io.modelcontextprotocol.spec.McpStatelessServerTransport
    public Mono<Void> closeGracefully() {
        g gVar = new g(2);
        gVar.f6303f = this;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(gVar);
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(405);
        } else {
            httpServletResponse.sendError(404);
        }
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        if (!httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(404);
            return;
        }
        if (this.isClosing) {
            httpServletResponse.sendError(503, "Server is shutting down");
            return;
        }
        McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        String header = httpServletRequest.getHeader("Accept");
        if (header == null || !header.contains("application/json") || !header.contains("text/event-stream")) {
            responseError(httpServletResponse, 400, new McpError("Both application/json and text/event-stream required in Accept header"));
            return;
        }
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
                if (!(jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCRequest)) {
                    if (!(jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCNotification)) {
                        responseError(httpServletResponse, 400, new McpError("The server accepts either requests or notifications"));
                        return;
                    }
                    try {
                        Mono<Void> monoHandleNotification = this.mcpHandler.handleNotification(mcpTransportContextExtract, (McpSchema.JSONRPCNotification) jSONRPCMessageDeserializeJsonRpcMessage);
                        d dVar = new d(2);
                        dVar.f6299b = mcpTransportContextExtract;
                        VarHandle.storeStoreFence();
                        monoHandleNotification.contextWrite(dVar).block();
                        httpServletResponse.setStatus(202);
                        return;
                    } catch (Exception e10) {
                        logger.f(e10.getMessage(), "Failed to handle notification: {}");
                        responseError(httpServletResponse, 500, new McpError("Failed to handle notification: " + e10.getMessage()));
                        return;
                    }
                }
                try {
                    Mono<McpSchema.JSONRPCResponse> monoHandleRequest = this.mcpHandler.handleRequest(mcpTransportContextExtract, (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage);
                    d dVar2 = new d(1);
                    dVar2.f6299b = mcpTransportContextExtract;
                    VarHandle.storeStoreFence();
                    McpSchema.JSONRPCResponse jSONRPCResponseBlock = monoHandleRequest.contextWrite(dVar2).block();
                    httpServletResponse.setContentType("application/json");
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.setStatus(200);
                    String strWriteValueAsString = this.jsonMapper.writeValueAsString(jSONRPCResponseBlock);
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write(strWriteValueAsString);
                    writer.flush();
                } catch (Exception e11) {
                    logger.f(e11.getMessage(), "Failed to handle request: {}");
                    responseError(httpServletResponse, 500, new McpError("Failed to handle request: " + e11.getMessage()));
                }
            } catch (IOException | IllegalArgumentException e12) {
                logger.f(e12.getMessage(), "Failed to deserialize message: {}");
                responseError(httpServletResponse, 400, new McpError("Invalid message format"));
            }
        } catch (Exception e13) {
            logger.f(e13.getMessage(), "Unexpected error handling message: {}");
            responseError(httpServletResponse, 500, new McpError(w2.c.b("Unexpected error: ", e13.getMessage())));
        }
    }

    @Override // io.modelcontextprotocol.spec.McpStatelessServerTransport
    public void setMcpHandler(McpStatelessServerHandler mcpStatelessServerHandler) {
        this.mcpHandler = mcpStatelessServerHandler;
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
        private McpJsonMapper jsonMapper;
        private String mcpEndpoint;

        private Builder() {
            this.mcpEndpoint = "/mcp";
            this.contextExtractor = new h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpTransportContext lambda$new$0(HttpServletRequest httpServletRequest) {
            return McpTransportContext.EMPTY;
        }

        public HttpServletStatelessServerTransport build() {
            Assert.notNull(this.mcpEndpoint, "Message endpoint must be set");
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpServletStatelessServerTransport(mcpJsonMapper, this.mcpEndpoint, this.contextExtractor, 0);
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

        public Builder messageEndpoint(String str) {
            Assert.notNull(str, "Message endpoint must not be null");
            this.mcpEndpoint = str;
            return this;
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public /* synthetic */ HttpServletStatelessServerTransport(McpJsonMapper mcpJsonMapper, String str, McpTransportContextExtractor mcpTransportContextExtractor, int i) {
        this(mcpJsonMapper, str, mcpTransportContextExtractor);
    }
}
