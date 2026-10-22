package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportStream;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class V implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HttpClientStreamableHttpTransport f33656a;

    public /* synthetic */ V(HttpClientStreamableHttpTransport httpClientStreamableHttpTransport) {
        this.f33656a = httpClientStreamableHttpTransport;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f33656a.reconnect((McpTransportStream) obj);
    }
}
