package io.ktor.client.engine.cio;

import Y8.t;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.network.tls.TLSConfigBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/client/engine/cio/CIOEngineConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/network/tls/TLSConfigBuilder;", "LY8/t;", "block", "https", "(Lp9/l;)Lio/ktor/network/tls/TLSConfigBuilder;", "Lio/ktor/client/engine/cio/EndpointConfig;", "endpoint", "Lio/ktor/client/engine/cio/EndpointConfig;", "getEndpoint", "()Lio/ktor/client/engine/cio/EndpointConfig;", "Lio/ktor/network/tls/TLSConfigBuilder;", "getHttps", "()Lio/ktor/network/tls/TLSConfigBuilder;", "", "maxConnectionsCount", "I", "getMaxConnectionsCount", "()I", "setMaxConnectionsCount", "(I)V", "", "requestTimeout", "J", "getRequestTimeout", "()J", "setRequestTimeout", "(J)V", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOEngineConfig extends HttpClientEngineConfig {
    private final EndpointConfig endpoint = new EndpointConfig();
    private final TLSConfigBuilder https = new TLSConfigBuilder();
    private int maxConnectionsCount = 1000;
    private long requestTimeout = 15000;

    public final EndpointConfig getEndpoint() {
        return this.endpoint;
    }

    public final TLSConfigBuilder getHttps() {
        return this.https;
    }

    public final int getMaxConnectionsCount() {
        return this.maxConnectionsCount;
    }

    public final long getRequestTimeout() {
        return this.requestTimeout;
    }

    public final TLSConfigBuilder https(InterfaceC5074l<? super TLSConfigBuilder, t> block) {
        p.i(block, "block");
        TLSConfigBuilder tLSConfigBuilder = this.https;
        block.invoke(tLSConfigBuilder);
        return tLSConfigBuilder;
    }

    public final void setMaxConnectionsCount(int i10) {
        this.maxConnectionsCount = i10;
    }

    public final void setRequestTimeout(long j10) {
        this.requestTimeout = j10;
    }
}
