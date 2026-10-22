package r7;

import android.content.Context;
import com.stepos.mcp.sdk.java.transport.h;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import q7.C5157a;
import q7.C5158b;
import q7.C5159c;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* renamed from: r7.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5224c {

    /* renamed from: a, reason: collision with root package name */
    public Context f38842a;

    /* renamed from: b, reason: collision with root package name */
    public h f38843b;

    /* renamed from: c, reason: collision with root package name */
    public McpAsyncServer f38844c;

    /* renamed from: d, reason: collision with root package name */
    public McpServer.AsyncSpecification f38845d;

    /* renamed from: f, reason: collision with root package name */
    public Scheduler f38847f;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>>> f38846e = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f38848g = new AtomicBoolean(false);

    public C5224c(Context context, h hVar) {
        this.f38843b = hVar;
        this.f38845d = McpServer.async(hVar).jsonMapper(C5159c.f38612a).jsonSchemaValidator(C5159c.f38613b);
        this.f38842a = context.getApplicationContext();
    }

    public void c(String str, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
        Assert.notNull(str, "tools name can not be null");
        Assert.notNull(biFunction, "handler can not be null");
        this.f38846e.put(str, biFunction);
    }

    public final void d() {
        try {
            List<McpSchema.Tool> listC = C5158b.b(this.f38842a).c(this.f38842a.getPackageName());
            if (listC != null && !listC.isEmpty()) {
                listC.forEach(new Consumer() { // from class: r7.b
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f38841a.e((McpSchema.Tool) obj);
                    }
                });
                this.f38844c = this.f38845d.build();
            }
        } catch (Exception e10) {
            C5157a.b("MCPServer", "init tools error: " + e10);
        }
    }

    public final /* synthetic */ void e(McpSchema.Tool tool) {
        BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction = this.f38846e.get(tool.name());
        if (biFunction != null) {
            this.f38845d.tools(McpServerFeatures.AsyncToolSpecification.builder().tool(tool).callHandler(biFunction).build());
        }
    }

    public final /* synthetic */ void f() {
        C5157a.c("MCPServer", "Starting MCPServer...");
        try {
            d();
            this.f38848g.set(true);
            C5157a.c("MCPServer", "MCPServer started successfully");
        } catch (Exception e10) {
            C5157a.b("MCPServer", "Failed to start MCPServer " + e10);
            this.f38848g.set(false);
        }
    }

    public void g() {
        if (this.f38848g.get()) {
            C5157a.d("MCPServer", "MCPServer already started");
            return;
        }
        Scheduler schedulerBoundedElastic = Schedulers.boundedElastic();
        this.f38847f = schedulerBoundedElastic;
        schedulerBoundedElastic.schedule(new Runnable() { // from class: r7.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f38840a.f();
            }
        });
    }

    public void h() throws Exception {
        if (!this.f38848g.get()) {
            C5157a.d("MCPServer", "MCPServer not started");
            return;
        }
        C5157a.c("MCPServer", "Stopping MCPServer...");
        try {
            McpAsyncServer mcpAsyncServer = this.f38844c;
            if (mcpAsyncServer != null) {
                mcpAsyncServer.close();
            }
            Scheduler scheduler = this.f38847f;
            if (scheduler != null) {
                scheduler.dispose();
            }
            this.f38848g.set(false);
            C5157a.c("MCPServer", "MCPServer stopped successfully");
        } catch (Exception e10) {
            C5157a.b("MCPServer", "Error stopping MCPServer " + e10);
            throw e10;
        }
    }
}
