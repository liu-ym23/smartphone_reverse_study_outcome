package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6188c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6189f;

    public /* synthetic */ j0(int i) {
        this.f6188c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f6188c;
        McpClientTransport mcpClientTransport = this.f6189f;
        switch (i) {
            case 0:
                return ((StdioClientTransport) mcpClientTransport).lambda$closeGracefully$12();
            case 1:
                return ((StdioClientTransport) mcpClientTransport).lambda$closeGracefully$13();
            default:
                return ((HttpClientStreamableHttpTransport) mcpClientTransport).lambda$closeGracefully$7();
        }
    }
}
