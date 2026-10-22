package io.modelcontextprotocol.client.transport;

import java.net.http.HttpResponse;
import java.util.function.BiConsumer;
import reactor.core.publisher.SynchronousSink;

/* renamed from: io.modelcontextprotocol.client.transport.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1579g implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        HttpClientSseClientTransport.lambda$sendMessage$11((HttpResponse) obj, (SynchronousSink) obj2);
    }
}
