package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportSession;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import reactor.core.publisher.SignalType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6193c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ AtomicReference f6194f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ McpTransportSession f6195g;

    public /* synthetic */ m(int i) {
        this.f6193c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6193c) {
            case 0:
                HttpClientStreamableHttpTransport.lambda$sendMessage$32(this.f6194f, this.f6195g, (SignalType) obj);
                break;
            default:
                HttpClientStreamableHttpTransport.lambda$reconnect$17(this.f6194f, this.f6195g, (SignalType) obj);
                break;
        }
    }
}
