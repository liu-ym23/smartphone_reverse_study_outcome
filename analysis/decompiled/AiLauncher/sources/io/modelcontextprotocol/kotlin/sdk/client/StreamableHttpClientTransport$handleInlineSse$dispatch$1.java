package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport", f = "StreamableHttpClientTransport.kt", l = {310, 312}, m = "handleInlineSse$dispatch")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamableHttpClientTransport$handleInlineSse$dispatch$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;

    public StreamableHttpClientTransport$handleInlineSse$dispatch$1(InterfaceC4014c<? super StreamableHttpClientTransport$handleInlineSse$dispatch$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StreamableHttpClientTransport.handleInlineSse$dispatch(null, null, null, null, null, null, null, this);
    }
}
