package io.ktor.client.call;

import La.w;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/call/NoTransformationFoundException;", "Ljava/lang/UnsupportedOperationException;", "Lkotlin/UnsupportedOperationException;", "Lio/ktor/client/statement/HttpResponse;", UxipConstants.f30685x, "Lw9/d;", "from", "to", "<init>", "(Lio/ktor/client/statement/HttpResponse;Lw9/d;Lw9/d;)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NoTransformationFoundException extends UnsupportedOperationException {
    private final String message;

    public NoTransformationFoundException(HttpResponse response, InterfaceC5745d<?> from, InterfaceC5745d<?> to) {
        p.i(response, "response");
        p.i(from, "from");
        p.i(to, "to");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n        Expected response body of the type '");
        sb2.append(to);
        sb2.append("' but was '");
        sb2.append(from);
        sb2.append("'\n        In response from `");
        sb2.append(HttpResponseKt.getRequest(response).getUrl());
        sb2.append("`\n        Response status `");
        sb2.append(response.getStatus());
        sb2.append("`\n        Response header `ContentType: ");
        Headers headers = response.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        sb2.append(headers.get(httpHeaders.getContentType()));
        sb2.append("` \n        Request header `Accept: ");
        sb2.append(HttpResponseKt.getRequest(response).getHeaders().get(httpHeaders.getAccept()));
        sb2.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.message = w.n(sb2.toString());
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
