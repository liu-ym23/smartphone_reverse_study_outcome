package io.ktor.client.call;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/call/DelegatedCall;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "originCall", "Lkotlin/Function1;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/utils/io/ByteReadChannel;", "responseContent", "Lio/ktor/http/Headers;", "responseHeaders", "<init>", "(Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lp9/l;Lio/ktor/http/Headers;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DelegatedCall extends HttpClientCall {
    public /* synthetic */ DelegatedCall(HttpClient httpClient, HttpClientCall httpClientCall, InterfaceC5074l interfaceC5074l, Headers headers, int i10, i iVar) {
        this(httpClient, httpClientCall, interfaceC5074l, (i10 & 8) != 0 ? httpClientCall.getResponse().getHeaders() : headers);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegatedCall(HttpClient client, HttpClientCall originCall, InterfaceC5074l<? super HttpResponse, ? extends ByteReadChannel> responseContent, Headers responseHeaders) {
        super(client);
        p.i(client, "client");
        p.i(originCall, "originCall");
        p.i(responseContent, "responseContent");
        p.i(responseHeaders, "responseHeaders");
        setRequest(new DelegatedRequest(this, originCall.getRequest()));
        setResponse(new DelegatedResponse(this, originCall.getResponse(), responseContent, responseHeaders));
    }
}
