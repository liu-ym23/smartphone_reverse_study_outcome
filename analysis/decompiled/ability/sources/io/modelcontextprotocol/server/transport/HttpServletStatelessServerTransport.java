package io.modelcontextprotocol.server.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import androidx.compose.runtime.ComposerKt;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.server.McpStatelessServerHandler;
import io.modelcontextprotocol.server.McpTransportContextExtractor;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStatelessServerTransport;
import io.modelcontextprotocol.util.Assert;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@WebServlet(asyncSupported = true)
/* loaded from: classes3.dex */
public class HttpServletStatelessServerTransport extends HttpServlet implements McpStatelessServerTransport {
    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String TEXT_EVENT_STREAM = "text/event-stream";
    public static final String UTF_8 = "UTF-8";
    private static final InterfaceC0315b logger = AbstractC0317d.b(HttpServletStatelessServerTransport.class);
    private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
    private volatile boolean isClosing;
    private final McpJsonMapper jsonMapper;
    private final String mcpEndpoint;
    private McpStatelessServerHandler mcpHandler;

    public static class Builder {
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
        private McpJsonMapper jsonMapper;
        private String mcpEndpoint;

        public /* synthetic */ Builder(int i) {
            this();
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

        private Builder() {
            this.mcpEndpoint = "/mcp";
            this.contextExtractor = new h();
        }
    }

    public /* synthetic */ HttpServletStatelessServerTransport(McpJsonMapper mcpJsonMapper, String str, McpTransportContextExtractor mcpTransportContextExtractor, int i) {
        this(mcpJsonMapper, str, mcpTransportContextExtractor);
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

    private void responseError(HttpServletResponse httpServletResponse, int i, McpError mcpError) throws IOException {
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
        return Mono.fromRunnable(new g(this, 2));
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(405);
        } else {
            httpServletResponse.sendError(McpErrorCode.TOOL_NOT_FOUND);
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
        McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        String header = httpServletRequest.getHeader("Accept");
        if (header == null || !header.contains("application/json") || !header.contains("text/event-stream")) {
            responseError(httpServletResponse, 400, new McpError("Both application/json and text/event-stream required in Accept header"));
            return;
        }
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
                if (!(jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCRequest)) {
                    if (!(jSONRPCMessageDeserializeJsonRpcMessage instanceof McpSchema.JSONRPCNotification)) {
                        responseError(httpServletResponse, 400, new McpError("The server accepts either requests or notifications"));
                        return;
                    }
                    try {
                        this.mcpHandler.handleNotification(mcpTransportContextExtract, (McpSchema.JSONRPCNotification) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new d(mcpTransportContextExtract, 2)).block();
                        httpServletResponse.setStatus(ComposerKt.compositionLocalMapKey);
                        return;
                    } catch (Exception e) {
                        logger.e(e.getMessage(), "Failed to handle notification: {}");
                        responseError(httpServletResponse, 500, new McpError("Failed to handle notification: " + e.getMessage()));
                        return;
                    }
                }
                try {
                    McpSchema.JSONRPCResponse jSONRPCResponseBlock = this.mcpHandler.handleRequest(mcpTransportContextExtract, (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new d(mcpTransportContextExtract, 1)).block();
                    httpServletResponse.setContentType("application/json");
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.setStatus(200);
                    String strWriteValueAsString = this.jsonMapper.writeValueAsString(jSONRPCResponseBlock);
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write(strWriteValueAsString);
                    writer.flush();
                } catch (Exception e6) {
                    logger.e(e6.getMessage(), "Failed to handle request: {}");
                    responseError(httpServletResponse, 500, new McpError("Failed to handle request: " + e6.getMessage()));
                }
            } catch (IOException | IllegalArgumentException e9) {
                logger.e(e9.getMessage(), "Failed to deserialize message: {}");
                responseError(httpServletResponse, 400, new McpError("Invalid message format"));
            }
        } catch (Exception e10) {
            logger.e(e10.getMessage(), "Unexpected error handling message: {}");
            responseError(httpServletResponse, 500, new McpError(B7.a.k("Unexpected error: ", e10.getMessage())));
        }
    }

    @Override // io.modelcontextprotocol.spec.McpStatelessServerTransport
    public void setMcpHandler(McpStatelessServerHandler mcpStatelessServerHandler) {
        this.mcpHandler = mcpStatelessServerHandler;
    }

    private HttpServletStatelessServerTransport(McpJsonMapper mcpJsonMapper, String str, McpTransportContextExtractor<HttpServletRequest> mcpTransportContextExtractor) {
        this.isClosing = false;
        Assert.notNull(mcpJsonMapper, "jsonMapper must not be null");
        Assert.notNull(str, "mcpEndpoint must not be null");
        Assert.notNull(mcpTransportContextExtractor, "contextExtractor must not be null");
        this.jsonMapper = mcpJsonMapper;
        this.mcpEndpoint = str;
        this.contextExtractor = mcpTransportContextExtractor;
    }
}
