package io.ktor.client.plugins;

import Ua.C1086v0;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1089x;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LUa/x;", "requestJob", "Lkotlinx/coroutines/g;", "clientEngineJob", "LY8/t;", "attachToClientEngineJob", "(LUa/x;Lkotlinx/coroutines/g;)V", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestLifecycle", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestLifecycle", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRequestLifecycleKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestLifecycle");
    private static final ClientPlugin<Y8.t> HttpRequestLifecycle = CreatePluginUtilsKt.createClientPlugin("RequestLifecycle", new InterfaceC5074l() { // from class: io.ktor.client.plugins.r
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return HttpRequestLifecycleKt.HttpRequestLifecycle$lambda$0((ClientPluginBuilder) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpRequestLifecycle$lambda$0(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(SetupRequestContext.INSTANCE, new HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(createClientPlugin, null));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachToClientEngineJob(final InterfaceC1089x interfaceC1089x, kotlinx.coroutines.g gVar) {
        final InterfaceC1045a0 interfaceC1045a0J = gVar.J(new InterfaceC5074l() { // from class: io.ktor.client.plugins.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpRequestLifecycleKt.attachToClientEngineJob$lambda$1(interfaceC1089x, (Throwable) obj);
            }
        });
        interfaceC1089x.J(new InterfaceC5074l() { // from class: io.ktor.client.plugins.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpRequestLifecycleKt.attachToClientEngineJob$lambda$2(interfaceC1045a0J, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t attachToClientEngineJob$lambda$1(InterfaceC1089x interfaceC1089x, Throwable th) {
        if (th != null) {
            LOGGER.trace("Cancelling request because engine Job failed with error: " + th);
            C1086v0.d(interfaceC1089x, "Engine failed", th);
        } else {
            LOGGER.trace("Cancelling request because engine Job completed");
            interfaceC1089x.complete();
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t attachToClientEngineJob$lambda$2(InterfaceC1045a0 interfaceC1045a0, Throwable th) {
        interfaceC1045a0.dispose();
        return Y8.t.f7040a;
    }

    public static final ClientPlugin<Y8.t> getHttpRequestLifecycle() {
        return HttpRequestLifecycle;
    }
}
