package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;
import java.util.function.Predicate;
import reactor.core.publisher.MonoSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6169c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ MonoSink f6170f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6171g;

    public /* synthetic */ e(int i) {
        this.f6169c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6169c) {
            case 0:
                return ((HttpClientSseClientTransport) this.f6171g).lambda$connect$7(this.f6170f, (Throwable) obj);
            default:
                return ((HttpClientStreamableHttpTransport) this.f6171g).lambda$sendMessage$31(this.f6170f, (Throwable) obj);
        }
    }
}
