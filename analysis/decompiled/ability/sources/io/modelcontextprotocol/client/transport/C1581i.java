package io.modelcontextprotocol.client.transport;

import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/* renamed from: io.modelcontextprotocol.client.transport.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1581i implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4665a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1581i(Object obj, int i) {
        this.f4665a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4665a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return HttpClientSseClientTransport.lambda$connect$2((FluxSink) obj2, (Throwable) obj);
            default:
                return ((StdioClientTransport) obj2).lambda$startOutboundProcessing$8((Flux) obj);
        }
    }
}
