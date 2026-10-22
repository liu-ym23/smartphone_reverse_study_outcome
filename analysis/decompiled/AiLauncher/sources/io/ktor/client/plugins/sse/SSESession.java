package io.ktor.client.plugins.sse;

import Ua.M;
import io.ktor.sse.ServerSentEvent;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/sse/SSESession;", "LUa/M;", "", "bodyBuffer", "()[B", "LXa/b;", "Lio/ktor/sse/ServerSentEvent;", "getIncoming", "()LXa/b;", "incoming", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SSESession extends M {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @InternalAPI
        @Deprecated
        public static byte[] bodyBuffer(SSESession sSESession) {
            return SSESession.super.bodyBuffer();
        }
    }

    @InternalAPI
    default byte[] bodyBuffer() {
        return SSEBufferPolicyKt.getEMPTY();
    }

    @Override // Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    Xa.b<ServerSentEvent> getIncoming();
}
