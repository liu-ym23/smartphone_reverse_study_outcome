package io.ktor.client.engine.cio;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/client/engine/cio/CIOEngineConfig;", "Lkotlin/Function1;", "Lio/ktor/client/engine/cio/EndpointConfig;", "LY8/t;", "block", "endpoint", "(Lio/ktor/client/engine/cio/CIOEngineConfig;Lp9/l;)Lio/ktor/client/engine/cio/EndpointConfig;", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOEngineConfigKt {
    public static final EndpointConfig endpoint(CIOEngineConfig cIOEngineConfig, InterfaceC5074l<? super EndpointConfig, t> block) {
        p.i(cIOEngineConfig, "<this>");
        p.i(block, "block");
        EndpointConfig endpoint = cIOEngineConfig.getEndpoint();
        block.invoke(endpoint);
        return endpoint;
    }
}
