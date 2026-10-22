package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import java.util.function.Predicate;
import reactor.core.publisher.MonoSink;

/* renamed from: io.modelcontextprotocol.client.transport.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1577e implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4662a;
    public final /* synthetic */ MonoSink b;
    public final /* synthetic */ McpClientTransport c;

    public /* synthetic */ C1577e(McpClientTransport mcpClientTransport, MonoSink monoSink, int i) {
        this.f4662a = i;
        this.c = mcpClientTransport;
        this.b = monoSink;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4662a) {
            case 0:
                return ((HttpClientSseClientTransport) this.c).lambda$connect$7(this.b, (Throwable) obj);
            default:
                return ((HttpClientStreamableHttpTransport) this.c).lambda$sendMessage$31(this.b, (Throwable) obj);
        }
    }
}
