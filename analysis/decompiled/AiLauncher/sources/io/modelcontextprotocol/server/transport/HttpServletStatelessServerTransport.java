package io.modelcontextprotocol.server.transport;

import com.autonavi.aps.amapapi.config.Const;
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
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@WebServlet(asyncSupported = true)
/* loaded from: classes4.dex */
public class HttpServletStatelessServerTransport extends HttpServlet implements McpStatelessServerTransport {
    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";
    public static final String FAILED_TO_SEND_ERROR_RESPONSE = "Failed to send error response: {}";
    public static final String TEXT_EVENT_STREAM = "text/event-stream";
    public static final String UTF_8 = "UTF-8";
    private static final vc.c logger = vc.e.l(HttpServletStatelessServerTransport.class);
    private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
    private volatile boolean isClosing;
    private final McpJsonMapper jsonMapper;
    private final String mcpEndpoint;
    private McpStatelessServerHandler mcpHandler;

    public static class Builder {
        private McpTransportContextExtractor<HttpServletRequest> contextExtractor;
        private McpJsonMapper jsonMapper;
        private String mcpEndpoint;

        public HttpServletStatelessServerTransport build() {
            Assert.notNull(this.mcpEndpoint, "Message endpoint must be set");
            McpJsonMapper mcpJsonMapper = this.jsonMapper;
            if (mcpJsonMapper == null) {
                mcpJsonMapper = McpJsonMapper.getDefault();
            }
            return new HttpServletStatelessServerTransport(mcpJsonMapper, this.mcpEndpoint, this.contextExtractor);
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
            this.contextExtractor = new McpTransportContextExtractor() { // from class: io.modelcontextprotocol.server.transport.m
                @Override // io.modelcontextprotocol.server.McpTransportContextExtractor
                public final McpTransportContext extract(Object obj) {
                    return McpTransportContext.EMPTY;
                }
            };
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$0() {
        this.isClosing = true;
    }

    private void responseError(HttpServletResponse httpServletResponse, int i10, McpError mcpError) throws IOException {
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setStatus(i10);
        String strWriteValueAsString = this.jsonMapper.writeValueAsString(mcpError);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(strWriteValueAsString);
        writer.flush();
    }

    @Override // io.modelcontextprotocol.spec.McpStatelessServerTransport
    public Mono<Void> closeGracefully() {
        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.transport.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f34047a.lambda$closeGracefully$0();
            }
        });
    }

    public void destroy() {
        closeGracefully().block();
        super.destroy();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (httpServletRequest.getRequestURI().endsWith(this.mcpEndpoint)) {
            httpServletResponse.sendError(405);
        } else {
            httpServletResponse.sendError(404);
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
        final McpTransportContext mcpTransportContextExtract = this.contextExtractor.extract(httpServletRequest);
        String header = httpServletRequest.getHeader("Accept");
        if (header == null || !header.contains("application/json") || !header.contains("text/event-stream")) {
            responseError(httpServletResponse, Const.I_TILE_TINY, new McpError("Both application/json and text/event-stream required in Accept header"));
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
                        responseError(httpServletResponse, Const.I_TILE_TINY, new McpError("The server accepts either requests or notifications"));
                        return;
                    }
                    try {
                        this.mcpHandler.handleNotification(mcpTransportContextExtract, (McpSchema.JSONRPCNotification) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.k
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                            }
                        }).block();
                        httpServletResponse.setStatus(202);
                        return;
                    } catch (Exception e10) {
                        logger.u("Failed to handle notification: {}", e10.getMessage());
                        responseError(httpServletResponse, 500, new McpError("Failed to handle notification: " + e10.getMessage()));
                        return;
                    }
                }
                try {
                    McpSchema.JSONRPCResponse jSONRPCResponseBlock = this.mcpHandler.handleRequest(mcpTransportContextExtract, (McpSchema.JSONRPCRequest) jSONRPCMessageDeserializeJsonRpcMessage).contextWrite(new Function() { // from class: io.modelcontextprotocol.server.transport.j
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((Context) obj).put(McpTransportContext.KEY, mcpTransportContextExtract);
                        }
                    }).block();
                    httpServletResponse.setContentType("application/json");
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.setStatus(200);
                    String strWriteValueAsString = this.jsonMapper.writeValueAsString(jSONRPCResponseBlock);
                    PrintWriter writer = httpServletResponse.getWriter();
                    writer.write(strWriteValueAsString);
                    writer.flush();
                } catch (Exception e11) {
                    logger.u("Failed to handle request: {}", e11.getMessage());
                    responseError(httpServletResponse, 500, new McpError("Failed to handle request: " + e11.getMessage()));
                }
            } catch (IOException | IllegalArgumentException e12) {
                logger.u("Failed to deserialize message: {}", e12.getMessage());
                responseError(httpServletResponse, Const.I_TILE_TINY, new McpError("Invalid message format"));
            }
        } catch (Exception e13) {
            logger.u("Unexpected error handling message: {}", e13.getMessage());
            responseError(httpServletResponse, 500, new McpError("Unexpected error: " + e13.getMessage()));
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
