package com.stepos.mcp.sdk.base;

import H7.c;
import S7.n;
import S7.o;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.mcp.sdk.java.KLog;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import reactor.core.publisher.Mono;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J)\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J<\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJB\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152(\u0010\u001c\u001a$\b\u0001\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001fø\u0001\u0000¢\u0006\u0004\b\u001d\u0010!J5\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0#0\"¢\u0006\u0004\b\u001d\u0010$J\u0011\u0010&\u001a\u0004\u0018\u00010%H\u0004¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020(¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u0004H\u0014¢\u0006\u0004\b,\u0010\u0003J\r\u0010-\u001a\u00020\u0004¢\u0006\u0004\b-\u0010\u0003R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020(0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010'\"\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/stepos/mcp/sdk/base/BaseMCPService;", "Lcom/stepos/mcp/sdk/java/service/AbsMCPService;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "init", AppAgent.ON_CREATE, "Landroid/content/Intent;", "intent", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onUnbind", "(Landroid/content/Intent;)Z", "onDestroy", "", "toolName", "Lkotlin/Function2;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolRequest;", "LH7/c;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "", "handler", "addTool", "(Ljava/lang/String;LS7/n;)V", "Lkotlin/Function3;", "Lio/modelcontextprotocol/server/McpAsyncServerExchange;", "(Ljava/lang/String;LS7/o;)V", "Ljava/util/function/BiFunction;", "Lreactor/core/publisher/Mono;", "(Ljava/lang/String;Ljava/util/function/BiFunction;)V", "Lm9/z;", "getScope", "()Lm9/z;", "Lcom/stepos/mcp/sdk/base/IToolHandler;", "registerToolHandler", "(Lcom/stepos/mcp/sdk/base/IToolHandler;)V", "unRegisterToolHandler", "initToolHandlers", "release", "", "toolHandlerList", "Ljava/util/List;", "serviceScope", "Lm9/z;", "getServiceScope", "setServiceScope", "(Lm9/z;)V", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseMCPService extends AbsMCPService {
    private InterfaceC1733z serviceScope;
    private final List<IToolHandler> toolHandlerList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mono addTool$lambda$0(BaseMCPService this$0, o handler, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        k.f(this$0, "this$0");
        k.f(handler, "$handler");
        return (Mono) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new BaseMCPService$addTool$1$1(this$0, handler, mcpAsyncServerExchange, callToolRequest, null));
    }

    public final void addTool(String toolName, final n handler) {
        k.f(toolName, "toolName");
        k.f(handler, "handler");
        addTool(toolName, new o() { // from class: com.stepos.mcp.sdk.base.BaseMCPService$addTool$wrapper$1
            @Override // S7.o
            public Object invoke(McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest, c<? super McpSchema.CallToolResult> cVar) {
                return handler.invoke(callToolRequest, cVar);
            }
        });
    }

    /* renamed from: getScope, reason: from getter */
    public final InterfaceC1733z getServiceScope() {
        return this.serviceScope;
    }

    public final InterfaceC1733z getServiceScope() {
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
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.serviceScope = AbstractC1683A.b(l.H(r0VarC, s9.k.f6003a.d));
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
    public int onStartCommand(Intent intent, int flags, int startId) {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onStartCommand》》》");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public boolean onUnbind(Intent intent) {
        KLog.d(BaseMCPServiceKt.TAG, "GalleryMCPService-onUnbind》》》");
        return super.onUnbind(intent);
    }

    public final void registerToolHandler(IToolHandler handler) {
        k.f(handler, "handler");
        if (this.toolHandlerList.contains(handler)) {
            return;
        }
        this.toolHandlerList.add(handler);
    }

    public final void release() {
        this.toolHandlerList.clear();
        try {
            InterfaceC1733z interfaceC1733z = this.serviceScope;
            if (interfaceC1733z != null) {
                AbstractC1683A.e(interfaceC1733z, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.serviceScope = null;
        }
    }

    public final void setServiceScope(InterfaceC1733z interfaceC1733z) {
        this.serviceScope = interfaceC1733z;
    }

    public final void unRegisterToolHandler(IToolHandler handler) {
        k.f(handler, "handler");
        if (this.toolHandlerList.contains(handler)) {
            this.toolHandlerList.remove(handler);
        }
    }

    public final void addTool(String toolName, o handler) {
        k.f(toolName, "toolName");
        k.f(handler, "handler");
        addTool(toolName, new Z5.d(this, handler, 1));
    }

    public final void addTool(String toolName, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> handler) {
        k.f(toolName, "toolName");
        k.f(handler, "handler");
        AndroidMCPServer androidMCPServer = this.mcpServer;
        if (androidMCPServer != null) {
            androidMCPServer.addToolHandler(toolName, handler);
        }
    }
}
