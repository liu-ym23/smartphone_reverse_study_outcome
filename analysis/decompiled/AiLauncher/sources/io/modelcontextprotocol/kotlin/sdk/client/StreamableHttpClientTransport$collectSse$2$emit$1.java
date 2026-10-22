package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.sse.ServerSentEvent;
import io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport$collectSse$2", f = "StreamableHttpClientTransport.kt", l = {271, 273}, m = "emit")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamableHttpClientTransport$collectSse$2$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamableHttpClientTransport.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StreamableHttpClientTransport$collectSse$2$emit$1(StreamableHttpClientTransport.AnonymousClass2<? super T> anonymousClass2, InterfaceC4014c<? super StreamableHttpClientTransport$collectSse$2$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ServerSentEvent) null, (InterfaceC4014c<? super Y8.t>) this);
    }
}
