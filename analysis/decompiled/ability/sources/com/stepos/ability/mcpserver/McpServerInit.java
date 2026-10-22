package com.stepos.ability.mcpserver;

import A6.i;
import a.AbstractC0291a;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.mcpserver.model.McpServerState;
import com.stepos.ability.mcpserver.search.b;
import e4.C1422a;
import f4.C1434a;
import g4.C1458e;
import g4.C1459f;
import i4.C1554b;
import javax.inject.Inject;
import javax.inject.Singleton;
import k4.h;
import k4.s;
import k4.w;
import k4.z;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Singleton
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 82\u00020\u0001:\u00019Bi\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010&R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010*R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010,R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010-R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/stepos/ability/mcpserver/McpServerInit;", "Lcom/stepos/ability/api/init/IInit;", "Lcom/stepos/ability/mcpserver/model/McpServerConfig;", "config", "Lcom/stepos/ability/mcpserver/search/b;", "searchEngine", "Lcom/stepos/ability/mcpserver/describe/a;", "describeEngine", "Lcom/stepos/ability/mcpserver/executor/b;", "toolBridge", "Lf4/a;", "dagScheduler", "Lcom/stepos/ability/mcpserver/executor/a;", "batchExecutor", "Lcom/stepos/ability/mcpserver/endpoint/b;", "sessionManager", "Li4/b;", "monitor", "Lk4/z;", "serverNonce", "Lk4/h;", "authenticator", "Lk4/w;", "rateLimiter", "Lk4/s;", "packageChangeReceiver", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/mcpserver/model/McpServerConfig;Lcom/stepos/ability/mcpserver/search/b;Lcom/stepos/ability/mcpserver/describe/a;Lcom/stepos/ability/mcpserver/executor/b;Lf4/a;Lcom/stepos/ability/mcpserver/executor/a;Lcom/stepos/ability/mcpserver/endpoint/b;Li4/b;Lk4/z;Lk4/h;Lk4/w;Lk4/s;)V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "stop", "()V", "Lcom/stepos/ability/mcpserver/model/McpServerConfig;", "Lcom/stepos/ability/mcpserver/search/b;", "Lcom/stepos/ability/mcpserver/describe/a;", "Lcom/stepos/ability/mcpserver/executor/b;", "Lf4/a;", "Lcom/stepos/ability/mcpserver/executor/a;", "Lcom/stepos/ability/mcpserver/endpoint/b;", "Li4/b;", "Lk4/z;", "Lk4/h;", "Lk4/w;", "Lk4/s;", "Lg4/f;", "supervisor", "Lg4/f;", "appContext", "Landroid/content/Context;", "Lcom/stepos/ability/mcpserver/model/McpServerState;", "getState", "()Lcom/stepos/ability/mcpserver/model/McpServerState;", "state", "Companion", "e4/a", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class McpServerInit implements IInit {
    public static final C1422a Companion = new C1422a();
    private static final String TAG = "McpServerInit";
    private Context appContext;
    private final h authenticator;
    private final com.stepos.ability.mcpserver.executor.a batchExecutor;
    private final McpServerConfig config;
    private final C1434a dagScheduler;
    private final com.stepos.ability.mcpserver.describe.a describeEngine;
    private final C1554b monitor;
    private final s packageChangeReceiver;
    private final w rateLimiter;
    private final b searchEngine;
    private final z serverNonce;
    private final com.stepos.ability.mcpserver.endpoint.b sessionManager;
    private C1459f supervisor;
    private final com.stepos.ability.mcpserver.executor.b toolBridge;

    @Inject
    public McpServerInit(McpServerConfig config, b searchEngine, com.stepos.ability.mcpserver.describe.a describeEngine, com.stepos.ability.mcpserver.executor.b toolBridge, C1434a dagScheduler, com.stepos.ability.mcpserver.executor.a batchExecutor, com.stepos.ability.mcpserver.endpoint.b sessionManager, C1554b monitor, z serverNonce, h authenticator, w rateLimiter, s packageChangeReceiver) {
        k.f(config, "config");
        k.f(searchEngine, "searchEngine");
        k.f(describeEngine, "describeEngine");
        k.f(toolBridge, "toolBridge");
        k.f(dagScheduler, "dagScheduler");
        k.f(batchExecutor, "batchExecutor");
        k.f(sessionManager, "sessionManager");
        k.f(monitor, "monitor");
        k.f(serverNonce, "serverNonce");
        k.f(authenticator, "authenticator");
        k.f(rateLimiter, "rateLimiter");
        k.f(packageChangeReceiver, "packageChangeReceiver");
        this.config = config;
        this.searchEngine = searchEngine;
        this.describeEngine = describeEngine;
        this.toolBridge = toolBridge;
        this.dagScheduler = dagScheduler;
        this.batchExecutor = batchExecutor;
        this.sessionManager = sessionManager;
        this.monitor = monitor;
        this.serverNonce = serverNonce;
        this.authenticator = authenticator;
        this.rateLimiter = rateLimiter;
        this.packageChangeReceiver = packageChangeReceiver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1458e init$lambda$0(McpServerInit mcpServerInit, com.stepos.ability.mcpserver.endpoint.a aVar) {
        McpServerConfig mcpServerConfig = mcpServerInit.config;
        return new C1458e(mcpServerConfig, mcpServerConfig.getPort(), aVar, mcpServerInit.serverNonce, mcpServerInit.authenticator, mcpServerInit.rateLimiter, mcpServerInit.monitor);
    }

    public final McpServerState getState() {
        return this.monitor.b;
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        Log.i(TAG, androidx.constraintlayout.core.dsl.a.d(this.config.getPort(), "Starting MCP Server on ", this.config.getBindHost(), ":", " (fixed port, retry on bind failure)"));
        this.searchEngine.b();
        this.appContext = context.getApplicationContext();
        s sVar = this.packageChangeReceiver;
        sVar.getClass();
        if (!sVar.b) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
            intentFilter.addDataScheme("package");
            ContextCompat.registerReceiver(context, sVar, intentFilter, 4);
            sVar.b = true;
            Log.i("McpPackageChange", "watching package replace/remove to drop stale identity bindings");
        }
        C1459f c1459f = new C1459f(new i(15, this, new com.stepos.ability.mcpserver.endpoint.a(this.searchEngine, this.describeEngine, this.toolBridge, this.dagScheduler, this.batchExecutor, this.sessionManager, this.monitor, this.rateLimiter)), this.monitor);
        synchronized (c1459f) {
            c1459f.c = false;
            if (!c1459f.a()) {
                c1459f.e = AbstractC0291a.H("mcp-endpoint-retry", new D6.i(c1459f, 29));
            }
        }
        this.supervisor = c1459f;
    }

    public final void stop() {
        Log.i(TAG, "Stopping MCP Server");
        Context context = this.appContext;
        if (context != null) {
            s sVar = this.packageChangeReceiver;
            sVar.getClass();
            if (sVar.b) {
                sVar.b = false;
                try {
                    context.unregisterReceiver(sVar);
                } catch (IllegalArgumentException e) {
                    androidx.constraintlayout.core.dsl.a.w("receiver was not registered: ", e.getMessage(), "McpPackageChange");
                }
            }
        }
        this.appContext = null;
        b bVar = this.searchEngine;
        bVar.f3198a.removeOnDataChangedListener(bVar.d);
        C1459f c1459f = this.supervisor;
        if (c1459f != null) {
            synchronized (c1459f) {
                try {
                    c1459f.c = true;
                    G7.a aVar = c1459f.e;
                    if (aVar != null) {
                        aVar.interrupt();
                    }
                    c1459f.e = null;
                    C1458e c1458e = c1459f.d;
                    if (c1458e != null) {
                        c1458e.g();
                    }
                    c1459f.d = null;
                    c1459f.b.c(McpServerState.NotStarted.INSTANCE);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.supervisor = null;
    }
}
