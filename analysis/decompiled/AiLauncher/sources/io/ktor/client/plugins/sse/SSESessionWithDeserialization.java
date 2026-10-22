package io.ktor.client.plugins.sse;

import Ua.M;
import io.ktor.sse.TypedServerSentEvent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR(\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/sse/SSESessionWithDeserialization;", "LUa/M;", "", "bodyBuffer", "()[B", "LXa/b;", "Lio/ktor/sse/TypedServerSentEvent;", "", "getIncoming", "()LXa/b;", "incoming", "Lkotlin/Function2;", "Lio/ktor/util/reflect/TypeInfo;", "", "getDeserializer", "()Lp9/p;", "deserializer", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SSESessionWithDeserialization extends M {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @InternalAPI
        @Deprecated
        public static byte[] bodyBuffer(SSESessionWithDeserialization sSESessionWithDeserialization) {
            return SSESessionWithDeserialization.super.bodyBuffer();
        }
    }

    @InternalAPI
    default byte[] bodyBuffer() {
        return SSEBufferPolicyKt.getEMPTY();
    }

    @Override // Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    p9.p<TypeInfo, String, Object> getDeserializer();

    Xa.b<TypedServerSentEvent<String>> getIncoming();
}
