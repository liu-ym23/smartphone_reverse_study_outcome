package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class J implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4657a;
    public final /* synthetic */ McpClientTransport b;

    public /* synthetic */ J(McpClientTransport mcpClientTransport, int i) {
        this.f4657a = i;
        this.b = mcpClientTransport;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f4657a;
        McpClientTransport mcpClientTransport = this.b;
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
