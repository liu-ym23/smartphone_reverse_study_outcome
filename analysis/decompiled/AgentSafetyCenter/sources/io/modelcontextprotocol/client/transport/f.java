package io.modelcontextprotocol.client.transport;

import java.util.function.Consumer;
import reactor.core.publisher.SignalType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6174c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ HttpClientSseClientTransport f6175f;

    public /* synthetic */ f(int i) {
        this.f6174c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6174c;
        HttpClientSseClientTransport httpClientSseClientTransport = this.f6175f;
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
