package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportSession;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import reactor.core.publisher.SignalType;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4669a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ McpTransportSession c;

    public /* synthetic */ m(AtomicReference atomicReference, McpTransportSession mcpTransportSession, int i) {
        this.f4669a = i;
        this.b = atomicReference;
        this.c = mcpTransportSession;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4669a) {
            case 0:
                HttpClientStreamableHttpTransport.lambda$sendMessage$32(this.b, this.c, (SignalType) obj);
                break;
            default:
                HttpClientStreamableHttpTransport.lambda$reconnect$17(this.b, this.c, (SignalType) obj);
                break;
        }
    }
}
