package com.stepos.mcp.sdk.java.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b8.g0;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.ZyMcpJson;
import com.stepos.mcp.sdk.java.transport.AndroidClientTransport;
import g5.f;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
                } catch (Exception e10) {
                    KLog.w(TAG, "Error closing MCP client" + e10);
                }
            }
            McpClientTransport mcpClientTransport = this.clientTransport;
            if (mcpClientTransport != null) {
                try {
                    mcpClientTransport.lambda$closeGracefully$1();
                } catch (Exception e11) {
                    KLog.w(TAG, "Error closing transport " + e11);
                }
            }
            this.decorators.clear();
            removeAutoRelease();
        } catch (Exception e12) {
            KLog.e(TAG, "Error during cleanup" + e12);
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
                List<IClientDecorator> list = this.decorators;
                g0 g0Var = new g0(2);
                g0Var.f1963f = syncSpecJsonSchemaValidator;
                VarHandle.storeStoreFence();
                list.forEach(g0Var);
                McpSyncClient mcpSyncClientBuild = syncSpecJsonSchemaValidator.build();
                this.mcpClient = mcpSyncClientBuild;
                mcpSyncClientBuild.initialize();
                this.connected.set(true);
                KLog.i(TAG, "Successfully connected to service: " + this.pkgName);
            } catch (Exception e10) {
                KLog.e(TAG, "Failed to connect to service: " + e10);
                cleanup();
                throw e10;
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
            f.g("callToolRequest can not be null.");
            return null;
        }
        KLog.d(TAG, "Calling tool " + callToolRequest.name() + " on service: " + this.pkgName);
        removeAutoRelease();
        try {
            try {
                ensureConnected();
                McpSchema.CallToolResult callToolResultCallTool = this.mcpClient.callTool(callToolRequest);
                KLog.d(TAG, "Tool call completed : " + callToolResultCallTool);
                return callToolResultCallTool;
            } catch (Exception e10) {
                if ((e10 instanceof McpError) || e10.getCause() == null || !(e10.getCause() instanceof McpError)) {
                    throw e10;
                }
                throw ((McpError) e10.getCause());
            }
        } finally {
            startAutoRelease();
        }
    }

    public void disconnect() {
        cleanup();
    }

    public McpSyncClient getSyncClient() {
        return this.mcpClient;
    }
}
