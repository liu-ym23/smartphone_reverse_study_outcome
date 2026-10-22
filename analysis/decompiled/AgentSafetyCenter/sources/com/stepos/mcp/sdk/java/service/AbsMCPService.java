package com.stepos.mcp.sdk.java.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.IMCPBinderService;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class AbsMCPService extends Service {
    public static final String MCP_SERVICE_ACTION = "com.stepos.mcp.sdk.TOOLS_SERVICE";
    public static final String METADATA_TOOLS = "mcp.tools";
    public static final String METADATA_TOOL_EXT = "tools.ext";
    public static final String PERMISSION_ACCESS_MCP_SERVICES = "com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES";
    private static final String TAG = "MCPService";
    private IBinder binder;
    protected AndroidMCPServer mcpServer;
    private final AIDLServerTransportProvider transportProvider = new AIDLServerTransportProvider();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class MCPServiceBinder extends IMCPBinderService.Stub {
        private final WeakReference<AbsMCPService> weakReference;

        public MCPServiceBinder(AbsMCPService absMCPService) {
            this.weakReference = new WeakReference<>(absMCPService);
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void register(String str, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
            AbsMCPService absMCPService = this.weakReference.get();
            if (absMCPService == null) {
                return;
            }
            absMCPService.enforceCallerHasPermission();
            absMCPService.getTransportProvider().newSession(str, iMCPBinderCallback);
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void request(String str, String str2) {
            AbsMCPService absMCPService = this.weakReference.get();
            if (absMCPService == null) {
                return;
            }
            absMCPService.enforceCallerHasPermission();
            absMCPService.getTransportProvider().onRequest(str, str2);
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void unregister(String str) {
            AbsMCPService absMCPService = this.weakReference.get();
            if (absMCPService == null) {
                return;
            }
            absMCPService.enforceCallerHasPermission();
            absMCPService.getTransportProvider().removeSession(str);
        }
    }

    private void cleanup() {
        try {
            try {
                AndroidMCPServer androidMCPServer = this.mcpServer;
                if (androidMCPServer != null) {
                    try {
                        androidMCPServer.stop();
                    } catch (Exception e10) {
                        KLog.e(TAG, "Error stopping MCPServer " + e10);
                    }
                }
                onServiceCleanup();
            } catch (Exception e11) {
                KLog.e(TAG, "Error during service cleanup " + e11);
            }
        } finally {
            this.mcpServer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enforceCallerHasPermission() {
        if (checkCallingPermission(PERMISSION_ACCESS_MCP_SERVICES) == 0) {
            return;
        }
        KLog.w(TAG, "Caller missing permission com.stepos.mcp.sdk.permission.ACCESS_MCP_SERVICES, uid=" + Binder.getCallingUid());
        throw new SecurityException("Caller is not authorized to access MCP services");
    }

    public AIDLServerTransportProvider getTransportProvider() {
        return this.transportProvider;
    }

    public abstract void initToolHandlers();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        KLog.d(TAG, "MCPService onBind called");
        if (intent == null || !MCP_SERVICE_ACTION.equals(intent.getAction())) {
            StringBuilder sb2 = new StringBuilder("Unexpected intent action: ");
            sb2.append(intent != null ? intent.getAction() : "null intent");
            KLog.w(TAG, sb2.toString());
            return null;
        }
        if (this.binder == null) {
            this.binder = new MCPServiceBinder(this);
        }
        KLog.d(TAG, "Service binding accepted");
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() throws Exception {
        super.onCreate();
        KLog.i(TAG, "MCPService onCreate: ".concat(getClass().getSimpleName()));
        try {
            onServiceSetup();
            this.mcpServer = new AndroidMCPServer(this, this.transportProvider);
            initToolHandlers();
            this.mcpServer.start();
            KLog.i(TAG, "MCPService created successfully");
        } catch (Exception e10) {
            KLog.e(TAG, "Failed to create MCPService " + e10);
            cleanup();
            throw e10;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        KLog.i(TAG, "MCPService onDestroy: ".concat(getClass().getSimpleName()));
        cleanup();
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        KLog.d(TAG, "MCPService onUnbind called");
        return super.onUnbind(intent);
    }

    public void onServiceCleanup() {
    }

    public void onServiceSetup() {
    }
}
