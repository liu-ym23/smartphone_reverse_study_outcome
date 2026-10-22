package com.stepos.mcp.sdk.base;

import android.content.Intent;
import android.os.IBinder;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import kc.e0;
import kc.k1;
import kc.t;
import kc.w;
import nb.c;
import nb.h;
import pc.n;
import rc.e;
import reactor.core.publisher.Mono;
import reactor.util.retry.a;
import xb.p;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class BaseMCPService extends AbsMCPService {
    private t serviceScope;
    private final List<IToolHandler> toolHandlerList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mono addTool$lambda$0(BaseMCPService baseMCPService, q qVar, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        baseMCPService.getClass();
        qVar.getClass();
        return (Mono) w.y(h.f8811c, new BaseMCPService$addTool$1$1(baseMCPService, qVar, mcpAsyncServerExchange, callToolRequest, null));
    }

    public final void addTool(String str, q qVar) {
        str.getClass();
        qVar.getClass();
        a aVar = new a(2);
        aVar.f10922f = this;
        aVar.f10923g = qVar;
        VarHandle.storeStoreFence();
        addTool(str, aVar);
    }

    public final t getScope() {
        return this.serviceScope;
    }

    public final t getServiceScope() {
        return this.serviceScope;
    }

    public abstract void init();

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService
    public void initToolHandlers() {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-initToolHandlers》》》");
        Iterator<T> it = this.toolHandlerList.iterator();
        while (it.hasNext()) {
            ((IToolHandler) it.next()).handlerTools(this);
        }
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public IBinder onBind(Intent intent) {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onBind》》》");
        return super.onBind(intent);
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public void onCreate() throws Exception {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onCreate-start");
        k1 k1VarC = w.c();
        e eVar = e0.f7430a;
        this.serviceScope = w.a(ac.a.N(k1VarC, n.f9978a.i));
        init();
        super.onCreate();
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onCreate-end");
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        release();
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onDestroy》》》");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onStartCommand》》》");
        return super.onStartCommand(intent, i, i3);
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public boolean onUnbind(Intent intent) {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onUnbind》》》");
        return super.onUnbind(intent);
    }

    public final void registerToolHandler(IToolHandler iToolHandler) {
        iToolHandler.getClass();
        if (this.toolHandlerList.contains(iToolHandler)) {
            return;
        }
        this.toolHandlerList.add(iToolHandler);
    }

    public final void release() {
        this.toolHandlerList.clear();
        try {
            t tVar = this.serviceScope;
            if (tVar != null) {
                w.d(tVar, null);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            this.serviceScope = null;
        }
    }

    public final void setServiceScope(t tVar) {
        this.serviceScope = tVar;
    }

    public final void unRegisterToolHandler(IToolHandler iToolHandler) {
        iToolHandler.getClass();
        if (this.toolHandlerList.contains(iToolHandler)) {
            this.toolHandlerList.remove(iToolHandler);
        }
    }

    public final void addTool(String str, final p pVar) {
        str.getClass();
        pVar.getClass();
        addTool(str, new q() { // from class: com.stepos.mcp.sdk.base.BaseMCPService$addTool$wrapper$1
            @Override // xb.q
            public Object invoke(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest, c cVar) {
                return pVar.invoke(callToolRequest, cVar);
            }
        });
    }

    public final void addTool(String str, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
        str.getClass();
        biFunction.getClass();
        AndroidMCPServer androidMCPServer = this.mcpServer;
        if (androidMCPServer != null) {
            androidMCPServer.addToolHandler(str, biFunction);
        }
    }
}
