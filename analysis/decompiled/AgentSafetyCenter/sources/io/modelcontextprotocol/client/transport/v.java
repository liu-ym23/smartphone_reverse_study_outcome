package io.modelcontextprotocol.client.transport;

import java.net.http.HttpResponse;
import java.util.function.BiConsumer;
import reactor.core.publisher.FluxSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ FluxSink f6212c;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        HttpClientStreamableHttpTransport.lambda$reconnect$10(this.f6212c, (HttpResponse) obj, (Throwable) obj2);
    }
}
