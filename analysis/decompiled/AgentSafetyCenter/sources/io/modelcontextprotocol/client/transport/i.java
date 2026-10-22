package io.modelcontextprotocol.client.transport;

import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6181a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6182b;

    public /* synthetic */ i(int i) {
        this.f6181a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6181a;
        Object obj2 = this.f6182b;
        switch (i) {
            case 0:
                return HttpClientSseClientTransport.lambda$connect$2((FluxSink) obj2, (Throwable) obj);
            default:
                return ((StdioClientTransport) obj2).lambda$startOutboundProcessing$8((Flux) obj);
        }
    }
}
