package io.ktor.client.call;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HttpMessagePropertiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0014X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/call/SavedHttpCall;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequest;", "request", "Lio/ktor/client/statement/HttpResponse;", UxipConstants.f30685x, "", "responseBody", "<init>", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;[B)V", "[B", "", "allowDoubleReceive", "Z", "getAllowDoubleReceive", "()Z", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavedHttpCall extends HttpClientCall {
    private final boolean allowDoubleReceive;
    private final byte[] responseBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient client, HttpRequest request, HttpResponse response, byte[] responseBody) {
        super(client);
        p.i(client, "client");
        p.i(request, "request");
        p.i(response, "response");
        p.i(responseBody, "responseBody");
        this.responseBody = responseBody;
        setRequest(new SavedHttpRequest(this, request));
        setResponse(new SavedHttpResponse(this, responseBody, response));
        UtilsKt.checkContentLength(HttpMessagePropertiesKt.contentLength(response), responseBody.length, request.getMethod());
        this.allowDoubleReceive = true;
    }

    @Override // io.ktor.client.call.HttpClientCall
    public boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }
}
