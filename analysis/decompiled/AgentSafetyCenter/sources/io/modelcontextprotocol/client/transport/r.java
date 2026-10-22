package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpTransportSession;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.URI;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6202a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6203b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6204c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f6205d;

    public /* synthetic */ r(int i) {
        this.f6202a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6202a) {
            case 0:
                return ((HttpClientStreamableHttpTransport) this.f6203b).lambda$sendMessage$27((MonoSink) this.f6204c, (ResponseSubscribers.ResponseEvent) this.f6205d, (ResponseSubscribers.SseEvent) obj);
            case 1:
                return ((HttpClientStreamableHttpTransport) this.f6203b).lambda$reconnect$13((McpTransportStream) this.f6204c, (McpTransportSession) this.f6205d, (ResponseSubscribers.SseResponseEvent) obj);
            case 2:
                return ((HttpClientSseClientTransport) this.f6203b).lambda$sendHttpPost$16((URI) this.f6204c, (String) this.f6205d, (ContextView) obj);
            default:
                return ((HttpClientStreamableHttpTransport) this.f6203b).lambda$createDelete$4((URI) this.f6204c, (String) this.f6205d, (ContextView) obj);
        }
    }
}
