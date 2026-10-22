package io.ktor.server.application;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.util.PlatformUtils;
import java.util.List;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012(\u0010\t\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R<\u0010\t\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lio/ktor/server/application/ServerConfig;", "", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "", "Lkotlin/Function2;", "Lio/ktor/server/application/Application;", "Le9/c;", "LY8/t;", "modules", "", "watchPaths", "rootPath", "", "developmentMode", "Lkotlin/coroutines/d;", "parentCoroutineContext", "<init>", "(Lio/ktor/server/application/ApplicationEnvironment;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZLkotlin/coroutines/d;)V", "Lio/ktor/server/application/ApplicationEnvironment;", "getEnvironment", "()Lio/ktor/server/application/ApplicationEnvironment;", "Ljava/util/List;", "getModules$ktor_server_core", "()Ljava/util/List;", "getWatchPaths$ktor_server_core", "Ljava/lang/String;", "getRootPath", "()Ljava/lang/String;", "Z", "getDevelopmentMode", "()Z", "Lio/ktor/server/application/ApplicationRootConfigBridge;", "bridge", "Lio/ktor/server/application/ApplicationRootConfigBridge;", "Lkotlin/coroutines/d;", "getParentCoroutineContext", "()Lkotlin/coroutines/d;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerConfig {
    private final ApplicationRootConfigBridge bridge;
    private final boolean developmentMode;
    private final ApplicationEnvironment environment;
    private final List<p<Application, InterfaceC4014c<? super t>, Object>> modules;
    private final kotlin.coroutines.d parentCoroutineContext;
    private final String rootPath;
    private final List<String> watchPaths;

    /* JADX WARN: Multi-variable type inference failed */
    public ServerConfig(ApplicationEnvironment environment, List<? extends p<? super Application, ? super InterfaceC4014c<? super t>, ? extends Object>> modules, List<String> watchPaths, String rootPath, boolean z10, kotlin.coroutines.d parentCoroutineContext) {
        kotlin.jvm.internal.p.i(environment, "environment");
        kotlin.jvm.internal.p.i(modules, "modules");
        kotlin.jvm.internal.p.i(watchPaths, "watchPaths");
        kotlin.jvm.internal.p.i(rootPath, "rootPath");
        kotlin.jvm.internal.p.i(parentCoroutineContext, "parentCoroutineContext");
        this.environment = environment;
        this.modules = modules;
        this.watchPaths = watchPaths;
        this.rootPath = rootPath;
        this.developmentMode = z10;
        ApplicationRootConfigBridge applicationRootConfigBridge = new ApplicationRootConfigBridge(this, parentCoroutineContext);
        this.bridge = applicationRootConfigBridge;
        this.parentCoroutineContext = applicationRootConfigBridge.getParentCoroutineContext();
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final ApplicationEnvironment getEnvironment() {
        return this.environment;
    }

    public final List<p<Application, InterfaceC4014c<? super t>, Object>> getModules$ktor_server_core() {
        return this.modules;
    }

    public final kotlin.coroutines.d getParentCoroutineContext() {
        return this.parentCoroutineContext;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final List<String> getWatchPaths$ktor_server_core() {
        return this.watchPaths;
    }

    public /* synthetic */ ServerConfig(ApplicationEnvironment applicationEnvironment, List list, List list2, String str, boolean z10, kotlin.coroutines.d dVar, int i10, kotlin.jvm.internal.i iVar) {
        this(applicationEnvironment, list, list2, str, (i10 & 16) != 0 ? PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE() : z10, dVar);
    }
}
