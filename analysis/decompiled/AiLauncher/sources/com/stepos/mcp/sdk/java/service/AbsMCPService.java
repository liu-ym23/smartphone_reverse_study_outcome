package com.stepos.mcp.sdk.java.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.IMCPBinderService;
import com.stepos.mcp.sdk.java.transport.h;
import java.lang.ref.WeakReference;
import q7.C5157a;
import r7.C5224c;

/* loaded from: classes.dex */
public abstract class AbsMCPService extends Service {
    public static final String MCP_SERVICE_ACTION = "com.stepos.mcp.sdk.TOOLS_SERVICE";
    public static final String METADATA_TOOLS = "mcp.tools";
    public static final String METADATA_TOOL_EXT = "tools.ext";
    private static final String TAG = "MCPService";
    private IBinder binder;
    protected C5224c mcpServer;
    private final h transportProvider = new h();

    public static class MCPServiceBinder extends IMCPBinderService.Stub {
        private WeakReference<AbsMCPService> weakReference;

        public MCPServiceBinder(AbsMCPService absMCPService) {
            this.weakReference = new WeakReference<>(absMCPService);
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void register(String str, IMCPBinderCallback iMCPBinderCallback) throws RemoteException {
            if (this.weakReference.get() != null) {
                this.weakReference.get().b().n(str, iMCPBinderCallback);
            }
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void request(String str, String str2) {
            if (this.weakReference.get() != null) {
                this.weakReference.get().b().o(str, str2);
            }
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderService
        public void unregister(String str) {
            if (this.weakReference.get() != null) {
                this.weakReference.get().b().r(str);
            }
        }
    }

    public final void a() {
        try {
            try {
                C5224c c5224c = this.mcpServer;
                if (c5224c != null) {
                    try {
                        c5224c.h();
                    } catch (Exception e10) {
                        C5157a.b(TAG, "Error stopping MCPServer " + e10);
                    }
                }
                d();
            } catch (Exception e11) {
                C5157a.b(TAG, "Error during service cleanup " + e11);
            }
        } finally {
            this.mcpServer = null;
        }
    }

    public h b() {
        return this.transportProvider;
    }

    public abstract void c();

    public void d() {
    }

    public void e() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C5157a.a(TAG, "MCPService onBind called");
        if (intent.getAction() == null || !intent.getAction().equals(MCP_SERVICE_ACTION)) {
            C5157a.d(TAG, "Unexpected intent action: ${intent?.action}");
            return null;
        }
        if (this.binder == null) {
            this.binder = new MCPServiceBinder(this);
        }
        C5157a.a(TAG, "Service binding requested - deferring security validation to actual calls");
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() throws Exception {
        super.onCreate();
        C5157a.c(TAG, "MCPService onCreate: ".concat(getClass().getSimpleName()));
        try {
            e();
            this.mcpServer = new C5224c(this, this.transportProvider);
            c();
            this.mcpServer.g();
            C5157a.c(TAG, "MCPService created successfully");
        } catch (Exception e10) {
            C5157a.b(TAG, "Failed to create MCPService " + e10);
            a();
            throw e10;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        C5157a.c(TAG, "MCPService onDestroy: ".concat(getClass().getSimpleName()));
        a();
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C5157a.a(TAG, "MCPService onUnbind called");
        return super.onUnbind(intent);
    }
}
