package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import java.net.http.HttpRequest;
import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.MonoSink;

/* renamed from: io.modelcontextprotocol.client.transport.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1573a implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4658a;
    public final /* synthetic */ McpClientTransport b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1573a(McpClientTransport mcpClientTransport, Object obj, int i) {
        this.f4658a = i;
        this.b = mcpClientTransport;
        this.c = obj;
    }

    private final void a(Object obj) {
        ((HttpClientSseClientTransport) this.b).lambda$connect$3((HttpRequest.Builder) this.c, (FluxSink) obj);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4658a) {
            case 0:
                a(obj);
                break;
            default:
                ((HttpClientStreamableHttpTransport) this.b).lambda$sendMessage$33((McpSchema.JSONRPCMessage) this.c, (MonoSink) obj);
                break;
        }
    }
}
