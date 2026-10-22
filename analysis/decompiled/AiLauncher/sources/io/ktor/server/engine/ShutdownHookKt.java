package io.ktor.server.engine;

import io.ktor.server.application.Application;
import io.ktor.server.application.DefaultApplicationEventsKt;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/server/engine/EmbeddedServer;", "Lkotlin/Function0;", "LY8/t;", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, "addShutdownHook", "(Lio/ktor/server/engine/EmbeddedServer;Lp9/a;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShutdownHookKt {
    public static final void addShutdownHook(final EmbeddedServer<?, ?> embeddedServer, final InterfaceC5063a<Y8.t> stop) {
        kotlin.jvm.internal.p.i(embeddedServer, "<this>");
        kotlin.jvm.internal.p.i(stop, "stop");
        if (ShutdownHookJvmKt.getSHUTDOWN_HOOK_ENABLED()) {
            embeddedServer.getMonitor().subscribe(DefaultApplicationEventsKt.getApplicationStarting(), new InterfaceC5074l() { // from class: io.ktor.server.engine.F
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ShutdownHookKt.addShutdownHook$lambda$0(embeddedServer, stop, (Application) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t addShutdownHook$lambda$0(EmbeddedServer embeddedServer, InterfaceC5063a interfaceC5063a, Application it) {
        kotlin.jvm.internal.p.i(it, "it");
        ShutdownHookJvmKt.platformAddShutdownHook(embeddedServer, interfaceC5063a);
        return Y8.t.f7040a;
    }
}
