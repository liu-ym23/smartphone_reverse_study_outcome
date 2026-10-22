package io.modelcontextprotocol.client.transport;

import java.net.http.HttpRequest;
import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6213c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ HttpClientStreamableHttpTransport f6214f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ HttpRequest.Builder f6215g;

    public /* synthetic */ w(int i) {
        this.f6213c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6213c) {
            case 0:
                this.f6214f.lambda$sendMessage$24(this.f6215g, (FluxSink) obj);
                break;
            default:
                this.f6214f.lambda$reconnect$11(this.f6215g, (FluxSink) obj);
                break;
        }
    }
}
