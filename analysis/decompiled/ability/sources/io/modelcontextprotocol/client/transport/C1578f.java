package io.modelcontextprotocol.client.transport;

import java.util.function.Consumer;
import reactor.core.publisher.SignalType;

/* renamed from: io.modelcontextprotocol.client.transport.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1578f implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4663a;
    public final /* synthetic */ HttpClientSseClientTransport b;

    public /* synthetic */ C1578f(HttpClientSseClientTransport httpClientSseClientTransport, int i) {
        this.f4663a = i;
        this.b = httpClientSseClientTransport;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4663a;
        HttpClientSseClientTransport httpClientSseClientTransport = this.b;
        switch (i) {
            case 0:
                httpClientSseClientTransport.lambda$connect$8((SignalType) obj);
                break;
            default:
                httpClientSseClientTransport.lambda$sendMessage$13((Throwable) obj);
                break;
        }
    }
}
