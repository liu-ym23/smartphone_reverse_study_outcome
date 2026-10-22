package io.ktor.client.engine.cio;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.C1086v0;
import Ua.CoroutineName;
import Y8.t;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u0018\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/coroutines/d;", "callContext", "Lio/ktor/client/request/HttpRequestData;", "request", "", "timeout", "LY8/t;", "setupTimeout", "(Lkotlin/coroutines/d;Lio/ktor/client/request/HttpRequestData;J)V", "Lio/ktor/client/engine/cio/CIOEngineConfig;", "engineConfig", "getRequestTimeout", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/client/engine/cio/CIOEngineConfig;)J", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EndpointKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.engine.cio.Endpoint");

    public static final long getRequestTimeout(HttpRequestData request, CIOEngineConfig engineConfig) {
        p.i(request, "request");
        p.i(engineConfig, "engineConfig");
        boolean zIsWebsocket = URLProtocolKt.isWebsocket(request.getUrl().getProtocol());
        if (request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE) != null || zIsWebsocket || HttpRequestKt.isUpgradeRequest(request) || HttpRequestKt.isSseRequest(request)) {
            return Long.MAX_VALUE;
        }
        return engineConfig.getRequestTimeout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTimeout(kotlin.coroutines.d dVar, HttpRequestData httpRequestData, long j10) {
        if (j10 == Long.MAX_VALUE || j10 == 0) {
            return;
        }
        final kotlinx.coroutines.g gVarD = C1060i.d(C1073o0.f6391a, new CoroutineName("cio-request-timeout"), null, new EndpointKt$setupTimeout$timeoutJob$1(j10, dVar, httpRequestData, null), 2, null);
        C1086v0.o(dVar).J(new InterfaceC5074l() { // from class: io.ktor.client.engine.cio.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return EndpointKt.setupTimeout$lambda$0(gVarD, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t setupTimeout$lambda$0(kotlinx.coroutines.g gVar, Throwable th) {
        kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        return t.f7040a;
    }
}
