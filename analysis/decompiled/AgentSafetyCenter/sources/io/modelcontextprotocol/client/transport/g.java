package io.modelcontextprotocol.client.transport;

import java.net.http.HttpResponse;
import java.util.function.BiConsumer;
import reactor.core.publisher.SynchronousSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        HttpClientSseClientTransport.lambda$sendMessage$11((HttpResponse) obj, (SynchronousSink) obj2);
    }
}
