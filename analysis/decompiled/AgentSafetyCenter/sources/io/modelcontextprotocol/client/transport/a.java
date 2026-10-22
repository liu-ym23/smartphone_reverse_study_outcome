package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import java.net.http.HttpRequest;
import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.MonoSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6149c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6150f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6151g;

    public /* synthetic */ a(int i) {
        this.f6149c = i;
    }

    private final void a(Object obj) {
        ((HttpClientSseClientTransport) this.f6150f).lambda$connect$3((HttpRequest.Builder) this.f6151g, (FluxSink) obj);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6149c) {
            case 0:
                a(obj);
                break;
            default:
                ((HttpClientStreamableHttpTransport) this.f6150f).lambda$sendMessage$33((McpSchema.JSONRPCMessage) this.f6151g, (MonoSink) obj);
                break;
        }
    }
}
