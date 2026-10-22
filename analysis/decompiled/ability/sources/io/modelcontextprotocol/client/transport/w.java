package io.modelcontextprotocol.client.transport;

import java.net.http.HttpRequest;
import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;

/* loaded from: classes2.dex */
public final /* synthetic */ class w implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4678a;
    public final /* synthetic */ HttpClientStreamableHttpTransport b;
    public final /* synthetic */ HttpRequest.Builder c;

    public /* synthetic */ w(HttpClientStreamableHttpTransport httpClientStreamableHttpTransport, HttpRequest.Builder builder, int i) {
        this.f4678a = i;
        this.b = httpClientStreamableHttpTransport;
        this.c = builder;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4678a) {
            case 0:
                this.b.lambda$sendMessage$24(this.c, (FluxSink) obj);
                break;
            default:
                this.b.lambda$reconnect$11(this.c, (FluxSink) obj);
                break;
        }
    }
}
