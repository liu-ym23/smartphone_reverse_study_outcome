package io.ktor.server.application;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/server/application/ApplicationRootConfigBridge;", "", "Lio/ktor/server/application/ServerConfig;", "rootConfig", "Lkotlin/coroutines/d;", "parentCoroutineContext", "<init>", "(Lio/ktor/server/application/ServerConfig;Lkotlin/coroutines/d;)V", "Lkotlin/coroutines/d;", "getParentCoroutineContext", "()Lkotlin/coroutines/d;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationRootConfigBridge {
    private final kotlin.coroutines.d parentCoroutineContext;

    public ApplicationRootConfigBridge(ServerConfig rootConfig, kotlin.coroutines.d parentCoroutineContext) {
        p.i(rootConfig, "rootConfig");
        p.i(parentCoroutineContext, "parentCoroutineContext");
        if (rootConfig.getDevelopmentMode() && !rootConfig.getWatchPaths$ktor_server_core().isEmpty()) {
            parentCoroutineContext = parentCoroutineContext.plus(ClassLoaderAwareContinuationInterceptor.INSTANCE);
        }
        this.parentCoroutineContext = parentCoroutineContext;
    }

    public final kotlin.coroutines.d getParentCoroutineContext() {
        return this.parentCoroutineContext;
    }
}
