package io.ktor.server.sse;

import Y8.t;
import io.ktor.server.application.ApplicationPlugin;
import io.ktor.server.application.CreatePluginUtilsKt;
import io.ktor.server.application.PluginBuilder;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0002\u001a\u00060\u0000j\u0002`\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "Lio/ktor/server/application/ApplicationPlugin;", "LY8/t;", "SSE", "Lio/ktor/server/application/ApplicationPlugin;", "getSSE", "()Lio/ktor/server/application/ApplicationPlugin;", "ktor-server-sse"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SSEKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.plugins.sse.SSE");
    private static final ApplicationPlugin<t> SSE = CreatePluginUtilsKt.createApplicationPlugin("SSE", new InterfaceC5074l() { // from class: io.ktor.server.sse.c
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return SSEKt.SSE$lambda$0((PluginBuilder) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final t SSE$lambda$0(PluginBuilder createApplicationPlugin) {
        p.i(createApplicationPlugin, "$this$createApplicationPlugin");
        return t.f7040a;
    }

    public static final vc.c getLOGGER() {
        return LOGGER;
    }

    public static final ApplicationPlugin<t> getSSE() {
        return SSE;
    }
}
