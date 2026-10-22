package io.modelcontextprotocol.client.transport;

import java.net.http.HttpRequest;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpClientSseClientTransport f6185c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ HttpRequest.Builder f6186f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Function f6187g;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f6185c.lambda$connect$9(this.f6186f, this.f6187g, (MonoSink) obj);
    }
}
