package com.stepos.mcp.sdk.java.server;

import a4.t;
import android.content.Context;
import b8.g0;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.MCPHelper;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
                g0 g0Var = new g0(10);
                g0Var.f1963f = this;
                VarHandle.storeStoreFence();
                servicesByPkgName.forEach(g0Var);
                this.asyncServer = this.asyncSpecification.build();
            }
        } catch (Exception e10) {
            KLog.e(TAG, "init tools error: " + e10);
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
        } catch (Exception e10) {
            KLog.e(TAG, "Failed to start MCPServer " + e10);
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
        t tVar = new t(28);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        schedulerBoundedElastic.schedule(tVar);
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
        } catch (Exception e10) {
            KLog.e(TAG, "Error stopping MCPServer " + e10);
            throw e10;
        }
    }
}
