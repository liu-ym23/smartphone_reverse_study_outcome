package com.stepos.mcp.sdk.java.server;

import android.content.Context;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.MCPHelper;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import com.stepos.mcp.sdk.java.a;
import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.c;
import io.modelcontextprotocol.util.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes3.dex */
public class AndroidMCPServer {
    private static final String TAG = "MCPServer";
    private McpAsyncServer asyncServer;
    private McpServer.AsyncSpecification asyncSpecification;
    private Context context;
    private HashMap<String, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>>> handlers = new HashMap<>();
    private final AtomicBoolean isStarted = new AtomicBoolean(false);
    private Scheduler scheduler;
    private AIDLServerTransportProvider transportProvider;

    public AndroidMCPServer(Context context, AIDLServerTransportProvider aIDLServerTransportProvider) {
        this.transportProvider = aIDLServerTransportProvider;
        this.asyncSpecification = McpServer.async(aIDLServerTransportProvider).jsonMapper(ZyMcpJson.jsonMapper).jsonSchemaValidator(ZyMcpJson.jsonSchemaValidator);
        this.context = context.getApplicationContext();
    }

    private void initTools() {
        try {
            List<McpSchema.Tool> servicesByPkgName = MCPHelper.getInstance(this.context).getServicesByPkgName(this.context.getPackageName());
            if (servicesByPkgName != null && !servicesByPkgName.isEmpty()) {
                servicesByPkgName.forEach(new a(this, 7));
                this.asyncServer = this.asyncSpecification.build();
            }
        } catch (Exception e) {
            KLog.e(TAG, "init tools error: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTools$1(McpSchema.Tool tool) {
        BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction = this.handlers.get(tool.name());
        if (biFunction != null) {
            this.asyncSpecification.tools(McpServerFeatures.AsyncToolSpecification.builder().tool(tool).callHandler(biFunction).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        KLog.i(TAG, "Starting MCPServer...");
        try {
            initTools();
            this.isStarted.set(true);
            KLog.i(TAG, "MCPServer started successfully");
        } catch (Exception e) {
            KLog.e(TAG, "Failed to start MCPServer " + e);
            this.isStarted.set(false);
        }
    }

    public void addToolHandler(String str, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
        Assert.notNull(str, "tools name can not be null");
        Assert.notNull(biFunction, "handler can not be null");
        this.handlers.put(str, biFunction);
    }

    public McpAsyncServer getUnderlyingServer() {
        return this.asyncServer;
    }

    public void start() {
        if (this.isStarted.get()) {
            KLog.w(TAG, "MCPServer already started");
            return;
        }
        Scheduler schedulerBoundedElastic = Schedulers.boundedElastic();
        this.scheduler = schedulerBoundedElastic;
        schedulerBoundedElastic.schedule(new c(this, 2));
    }

    public void stop() throws Exception {
        if (!this.isStarted.get()) {
            KLog.w(TAG, "MCPServer not started");
            return;
        }
        KLog.i(TAG, "Stopping MCPServer...");
        try {
            McpAsyncServer mcpAsyncServer = this.asyncServer;
            if (mcpAsyncServer != null) {
                mcpAsyncServer.close();
            }
            Scheduler scheduler = this.scheduler;
            if (scheduler != null) {
                scheduler.dispose();
            }
            this.isStarted.set(false);
            KLog.i(TAG, "MCPServer stopped successfully");
        } catch (Exception e) {
            KLog.e(TAG, "Error stopping MCPServer " + e);
            throw e;
        }
    }
}
