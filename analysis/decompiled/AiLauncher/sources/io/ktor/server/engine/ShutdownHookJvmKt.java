package io.ktor.server.engine;

import io.ktor.server.application.Application;
import io.ktor.server.application.DefaultApplicationEventsKt;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a)\u0010\u0004\u001a\u00020\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/server/engine/EmbeddedServer;", "Lkotlin/Function0;", "LY8/t;", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, "platformAddShutdownHook", "(Lio/ktor/server/engine/EmbeddedServer;Lp9/a;)V", "", "SHUTDOWN_HOOK_ENABLED", "Z", "getSHUTDOWN_HOOK_ENABLED", "()Z", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShutdownHookJvmKt {
    private static final boolean SHUTDOWN_HOOK_ENABLED = kotlin.jvm.internal.p.d(System.getProperty("io.ktor.server.engine.ShutdownHook", "true"), "true");

    public static final boolean getSHUTDOWN_HOOK_ENABLED() {
        return SHUTDOWN_HOOK_ENABLED;
    }

    public static final void platformAddShutdownHook(EmbeddedServer<?, ?> embeddedServer, InterfaceC5063a<Y8.t> stop) {
        kotlin.jvm.internal.p.i(embeddedServer, "<this>");
        kotlin.jvm.internal.p.i(stop, "stop");
        final ShutdownHook shutdownHook = new ShutdownHook(stop);
        embeddedServer.getMonitor().subscribe(DefaultApplicationEventsKt.getApplicationStopping(), new InterfaceC5074l() { // from class: io.ktor.server.engine.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ShutdownHookJvmKt.platformAddShutdownHook$lambda$0(shutdownHook, (Application) obj);
            }
        });
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t platformAddShutdownHook$lambda$0(ShutdownHook shutdownHook, Application it) {
        kotlin.jvm.internal.p.i(it, "it");
        try {
            Runtime.getRuntime().removeShutdownHook(shutdownHook);
        } catch (IllegalStateException unused) {
        }
        return Y8.t.f7040a;
    }
}
