package io.ktor.server.response;

import Y8.t;
import Z8.C1173v;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.content.Version;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.util.URLBuilderKt;
import io.ktor.utils.io.InternalAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@InternalAPI
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u000b\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR2\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u001dj\b\u0012\u0004\u0012\u00020\t`\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lio/ktor/server/response/DefaultResponsePushBuilder;", "Lio/ktor/server/response/ResponsePushBuilder;", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/URLBuilder;", "url", "Lio/ktor/http/HeadersBuilder;", "headers", "", "Lio/ktor/http/content/Version;", "versions", "<init>", "(Lio/ktor/http/HttpMethod;Lio/ktor/http/URLBuilder;Lio/ktor/http/HeadersBuilder;Ljava/util/List;)V", "Lio/ktor/http/Headers;", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/Headers;)V", "Lio/ktor/server/application/ApplicationCall;", "call", "(Lio/ktor/server/application/ApplicationCall;)V", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "setMethod", "(Lio/ktor/http/HttpMethod;)V", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getVersions", "()Ljava/util/ArrayList;", "setVersions", "(Ljava/util/ArrayList;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseHttp2Push
/* loaded from: classes4.dex */
public final class DefaultResponsePushBuilder implements ResponsePushBuilder {
    private final HeadersBuilder headers;
    private HttpMethod method;
    private final URLBuilder url;
    private ArrayList<Version> versions;

    public DefaultResponsePushBuilder() {
        this(null, null, null, null, 15, null);
    }

    @Override // io.ktor.server.response.ResponsePushBuilder
    public HeadersBuilder getHeaders() {
        return this.headers;
    }

    @Override // io.ktor.server.response.ResponsePushBuilder
    public HttpMethod getMethod() {
        return this.method;
    }

    @Override // io.ktor.server.response.ResponsePushBuilder
    public URLBuilder getUrl() {
        return this.url;
    }

    @Override // io.ktor.server.response.ResponsePushBuilder
    public void setMethod(HttpMethod httpMethod) {
        p.i(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public void setVersions(ArrayList<Version> arrayList) {
        p.i(arrayList, "<set-?>");
        this.versions = arrayList;
    }

    public DefaultResponsePushBuilder(HttpMethod method, URLBuilder url, HeadersBuilder headers, List<? extends Version> versions) {
        p.i(method, "method");
        p.i(url, "url");
        p.i(headers, "headers");
        p.i(versions, "versions");
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.versions = versions.isEmpty() ? new ArrayList<>() : new ArrayList<>(versions);
    }

    @Override // io.ktor.server.response.ResponsePushBuilder
    public ArrayList<Version> getVersions() {
        return this.versions;
    }

    public /* synthetic */ DefaultResponsePushBuilder(HttpMethod httpMethod, URLBuilder uRLBuilder, HeadersBuilder headersBuilder, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? HttpMethod.INSTANCE.getGet() : httpMethod, (i10 & 2) != 0 ? new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null) : uRLBuilder, (i10 & 4) != 0 ? new HeadersBuilder(0, 1, null) : headersBuilder, (i10 & 8) != 0 ? C1173v.m() : list);
    }

    public DefaultResponsePushBuilder(URLBuilder url, Headers headers) {
        p.i(url, "url");
        p.i(headers, "headers");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(headers);
        t tVar = t.f7040a;
        this(null, url, headersBuilder, null, 9, null);
    }

    public DefaultResponsePushBuilder(ApplicationCall call) {
        p.i(call, "call");
        URLBuilder.Companion companion = URLBuilder.INSTANCE;
        URLBuilder uRLBuilderCreateFromCall = URLBuilderKt.createFromCall(companion, call);
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(call.getRequest().getHeaders());
        String referrer = HttpHeaders.INSTANCE.getReferrer();
        URLBuilder uRLBuilderCreateFromCall2 = URLBuilderKt.createFromCall(companion, call);
        t tVar = t.f7040a;
        headersBuilder.set(referrer, uRLBuilderCreateFromCall2.buildString());
        this(null, uRLBuilderCreateFromCall, headersBuilder, null, 9, null);
    }
}
