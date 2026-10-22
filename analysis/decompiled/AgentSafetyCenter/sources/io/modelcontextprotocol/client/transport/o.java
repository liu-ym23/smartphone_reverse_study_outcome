package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import java.net.http.HttpRequest;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6197c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6198f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6199g;

    public /* synthetic */ o(int i) {
        this.f6197c = i;
    }

    private final Object a() {
        return ((HttpClientStreamableHttpTransport) this.f6198f).lambda$createDelete$5((HttpRequest) this.f6199g);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6197c) {
            case 0:
                return a();
            default:
                return ((HttpClientSseClientTransport) this.f6198f).lambda$serializeMessage$15((McpSchema.JSONRPCMessage) this.f6199g);
        }
    }
}
