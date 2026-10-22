package io.ktor.client.engine.cio;

import Ua.InterfaceC1083u;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lio/ktor/client/engine/cio/RequestTask;", "", "Lio/ktor/client/request/HttpRequestData;", "request", "LUa/u;", "Lio/ktor/client/request/HttpResponseData;", UxipConstants.f30685x, "Lkotlin/coroutines/d;", "context", "<init>", "(Lio/ktor/client/request/HttpRequestData;LUa/u;Lkotlin/coroutines/d;)V", "component1", "()Lio/ktor/client/request/HttpRequestData;", "component2", "()LUa/u;", "component3", "()Lkotlin/coroutines/d;", ChatTracker.CLICK_COPY, "(Lio/ktor/client/request/HttpRequestData;LUa/u;Lkotlin/coroutines/d;)Lio/ktor/client/engine/cio/RequestTask;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/client/request/HttpRequestData;", "getRequest", "LUa/u;", "getResponse", "Lkotlin/coroutines/d;", "getContext", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RequestTask {
    private final kotlin.coroutines.d context;
    private final HttpRequestData request;
    private final InterfaceC1083u<HttpResponseData> response;

    public RequestTask(HttpRequestData request, InterfaceC1083u<HttpResponseData> response, kotlin.coroutines.d context) {
        p.i(request, "request");
        p.i(response, "response");
        p.i(context, "context");
        this.request = request;
        this.response = response;
        this.context = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestTask copy$default(RequestTask requestTask, HttpRequestData httpRequestData, InterfaceC1083u interfaceC1083u, kotlin.coroutines.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpRequestData = requestTask.request;
        }
        if ((i10 & 2) != 0) {
            interfaceC1083u = requestTask.response;
        }
        if ((i10 & 4) != 0) {
            dVar = requestTask.context;
        }
        return requestTask.copy(httpRequestData, interfaceC1083u, dVar);
    }

    /* renamed from: component1, reason: from getter */
    public final HttpRequestData getRequest() {
        return this.request;
    }

    public final InterfaceC1083u<HttpResponseData> component2() {
        return this.response;
    }

    /* renamed from: component3, reason: from getter */
    public final kotlin.coroutines.d getContext() {
        return this.context;
    }

    public final RequestTask copy(HttpRequestData request, InterfaceC1083u<HttpResponseData> response, kotlin.coroutines.d context) {
        p.i(request, "request");
        p.i(response, "response");
        p.i(context, "context");
        return new RequestTask(request, response, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestTask)) {
            return false;
        }
        RequestTask requestTask = (RequestTask) other;
        return p.d(this.request, requestTask.request) && p.d(this.response, requestTask.response) && p.d(this.context, requestTask.context);
    }

    public final kotlin.coroutines.d getContext() {
        return this.context;
    }

    public final HttpRequestData getRequest() {
        return this.request;
    }

    public final InterfaceC1083u<HttpResponseData> getResponse() {
        return this.response;
    }

    public int hashCode() {
        return (((this.request.hashCode() * 31) + this.response.hashCode()) * 31) + this.context.hashCode();
    }

    public String toString() {
        return "RequestTask(request=" + this.request + ", response=" + this.response + ", context=" + this.context + ')';
    }
}
