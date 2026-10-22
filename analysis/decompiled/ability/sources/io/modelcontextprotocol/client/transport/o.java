package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import java.net.http.HttpRequest;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class o implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4671a;
    public final /* synthetic */ McpClientTransport b;
    public final /* synthetic */ Object c;

    public /* synthetic */ o(McpClientTransport mcpClientTransport, Object obj, int i) {
        this.f4671a = i;
        this.b = mcpClientTransport;
        this.c = obj;
    }

    private final Object a() {
        return ((HttpClientStreamableHttpTransport) this.b).lambda$createDelete$5((HttpRequest) this.c);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f4671a) {
            case 0:
                return a();
            default:
                return ((HttpClientSseClientTransport) this.b).lambda$serializeMessage$15((McpSchema.JSONRPCMessage) this.c);
        }
    }
}
