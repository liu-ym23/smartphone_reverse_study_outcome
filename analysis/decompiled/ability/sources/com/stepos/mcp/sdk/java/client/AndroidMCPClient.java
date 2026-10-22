package com.stepos.mcp.sdk.java.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import com.stepos.mcp.sdk.java.a;
import com.stepos.mcp.sdk.java.transport.AndroidClientTransport;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class AndroidMCPClient {
    private static final int KEEP_ALIVE = 180000;
    private static final String TAG = "MCPClient";
    private McpClientTransport clientTransport;
    private Context context;
    private McpSyncClient mcpClient;
    private String pkgName;
    private final AtomicBoolean connected = new AtomicBoolean(false);
    private final AtomicBoolean isConnecting = new AtomicBoolean(false);
    private final List<IClientDecorator> decorators = new LinkedList();
    private Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable releaseRunnable = new Runnable() { // from class: com.stepos.mcp.sdk.java.client.AndroidMCPClient.1
        @Override // java.lang.Runnable
        public void run() {
            KLog.i(AndroidMCPClient.TAG, "执行自动释放: " + AndroidMCPClient.this.pkgName);
            if (AndroidMCPClient.this.pkgName != null) {
                ToolHelper.getInstance().releaseClient(AndroidMCPClient.this.pkgName);
            }
        }
    };

    public AndroidMCPClient(Context context, String str) {
        Assert.notNull(context, "context can not be null");
        Assert.notNull(str, "package name can not be null");
        this.context = context;
        this.pkgName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void cleanup() {
        KLog.i(TAG, "cleanup: " + this.pkgName);
        try {
            McpSyncClient mcpSyncClient = this.mcpClient;
            if (mcpSyncClient != null) {
                try {
                    mcpSyncClient.close();
                } catch (Exception e) {
                    KLog.w(TAG, "Error closing MCP client" + e);
                }
            }
            McpClientTransport mcpClientTransport = this.clientTransport;
            if (mcpClientTransport != null) {
                try {
                    mcpClientTransport.lambda$closeGracefully$1();
                } catch (Exception e6) {
                    KLog.w(TAG, "Error closing transport " + e6);
                }
            }
            this.decorators.clear();
            removeAutoRelease();
        } catch (Exception e9) {
            KLog.e(TAG, "Error during cleanup" + e9);
        } finally {
            this.mcpClient = null;
            this.clientTransport = null;
            this.handler = null;
            this.connected.set(false);
            this.context = null;
        }
    }

    private void ensureConnected() {
        KLog.i(TAG, "ensureConnected: " + this.pkgName);
        if (this.connected.get()) {
            return;
        }
        if (this.isConnecting.get()) {
            KLog.w(TAG, "Connection already in progress for " + this.pkgName);
            return;
        }
        try {
            try {
                this.isConnecting.set(true);
                AndroidClientTransport androidClientTransport = new AndroidClientTransport(this.context, this.pkgName);
                this.clientTransport = androidClientTransport;
                McpClient.SyncSpec syncSpecJsonSchemaValidator = McpClient.sync(androidClientTransport).jsonSchemaValidator(ZyMcpJson.jsonSchemaValidator);
                this.decorators.forEach(new a(syncSpecJsonSchemaValidator, 1));
                McpSyncClient mcpSyncClientBuild = syncSpecJsonSchemaValidator.build();
                this.mcpClient = mcpSyncClientBuild;
                mcpSyncClientBuild.initialize();
                this.connected.set(true);
                KLog.i(TAG, "Successfully connected to service: " + this.pkgName);
            } catch (Exception e) {
                KLog.e(TAG, "Failed to connect to service: " + e);
                cleanup();
                throw e;
            }
        } finally {
            this.isConnecting.set(false);
        }
    }

    private void removeAutoRelease() {
        if (this.handler != null) {
            KLog.i(TAG, "移除自动释放任务: " + this.pkgName);
            this.handler.removeCallbacks(this.releaseRunnable, this.pkgName);
        }
    }

    private void startAutoRelease() {
        if (this.handler != null) {
            KLog.i(TAG, "设置自动释放任务: " + this.pkgName);
            this.handler.postDelayed(this.releaseRunnable, this.pkgName, 180000L);
        }
    }

    public AndroidMCPClient addDecorator(IClientDecorator iClientDecorator) {
        if (iClientDecorator != null) {
            this.decorators.add(iClientDecorator);
        }
        return this;
    }

    public McpSchema.CallToolResult callTool(McpSchema.CallToolRequest callToolRequest) {
        if (callToolRequest == null) {
            throw new NullPointerException("callToolRequest can not be null.");
        }
        KLog.d(TAG, "Calling tool " + callToolRequest.name() + " on service: " + this.pkgName);
        removeAutoRelease();
        try {
            try {
                ensureConnected();
                McpSchema.CallToolResult callToolResultCallTool = this.mcpClient.callTool(callToolRequest);
                StringBuilder sb = new StringBuilder("Tool call completed: ");
                sb.append(callToolRequest.name());
                sb.append(", isError=");
                int size = 0;
                sb.append(callToolResultCallTool != null && Boolean.TRUE.equals(callToolResultCallTool.isError()));
                sb.append(", blocks=");
                if (callToolResultCallTool != null && callToolResultCallTool.content() != null) {
                    size = callToolResultCallTool.content().size();
                }
                sb.append(size);
                KLog.d(TAG, sb.toString());
                startAutoRelease();
                return callToolResultCallTool;
            } catch (Exception e) {
                if ((e instanceof McpError) || e.getCause() == null || !(e.getCause() instanceof McpError)) {
                    throw e;
                }
                throw ((McpError) e.getCause());
            }
        } catch (Throwable th) {
            startAutoRelease();
            throw th;
        }
    }

    public void disconnect() {
        cleanup();
    }

    public McpSyncClient getSyncClient() {
        return this.mcpClient;
    }
}
