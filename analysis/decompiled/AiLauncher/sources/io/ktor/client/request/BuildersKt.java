package io.ktor.client.request;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0007\u0010\u0005\u001a(\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0004\u0010\u000b\u001a(\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0007\u0010\u000b\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0004\u0010\u000e\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0007\u0010\u000e\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0004\u0010\u0011\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0007\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0012\u0010\u0005\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0013\u0010\u0005\u001a\u001c\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0014\u0010\u0005\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0017\u0010\u0005\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0018\u0010\u0005\u001a\u001c\u0010\u0019\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u001c\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001a\u0010\u0005\u001a\u001c\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001b\u0010\u0005\u001a\u001c\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001c\u0010\u0005\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001d\u0010\u0005\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001f\u0010\u0005\u001a(\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0012\u0010\u000b\u001a(\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u000b\u001a(\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0014\u0010\u000b\u001a(\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0015\u0010\u000b\u001a(\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0016\u0010\u000b\u001a(\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0017\u0010\u000b\u001a(\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u000b\u001a(\u0010\u0019\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0019\u0010\u000b\u001a(\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001a\u0010\u000b\u001a(\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001b\u0010\u000b\u001a(\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001c\u0010\u000b\u001a(\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001d\u0010\u000b\u001a(\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001e\u0010\u000b\u001a(\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001f\u0010\u000b\u001a!\u0010\u0004\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0004\u0010 \u001a2\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0012\u0010\u000e\u001a2\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0013\u0010\u000e\u001a2\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0014\u0010\u000e\u001a2\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0015\u0010\u000e\u001a2\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0016\u0010\u000e\u001a2\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0017\u0010\u000e\u001a2\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0018\u0010\u000e\u001a2\u0010\u0019\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u0019\u0010\u000e\u001a2\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001a\u0010\u000e\u001a2\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001b\u0010\u000e\u001a2\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001c\u0010\u000e\u001a2\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001d\u0010\u000e\u001a2\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001e\u0010\u000e\u001a2\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0086H¢\u0006\u0004\b\u001f\u0010\u000e¨\u0006!"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/statement/HttpResponse;", "request", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestBuilder;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareRequest", "Lkotlin/Function1;", "LY8/t;", "block", "(Lio/ktor/client/HttpClient;Lp9/l;Le9/c;)Ljava/lang/Object;", "", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "url", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lp9/l;Le9/c;)Ljava/lang/Object;", "get", "post", "put", ChatTracker.CLICK_DELETE, "options", "patch", "head", "prepareGet", "preparePost", "preparePut", "prepareDelete", "prepareOptions", "preparePatch", "prepareHead", "(Lp9/l;)Lio/ktor/client/request/HttpRequestBuilder;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersKt {
    public static final Object delete(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object delete$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.delete.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object get(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object get$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.get.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object head(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object head$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.head.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object options(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object options$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.options.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object patch(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object patch$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.patch.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object post(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object post$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.post.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareDelete(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.prepareDelete.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareGet(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.prepareGet.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.prepareHead.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.prepareOptions.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.preparePatch.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.preparePost.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.preparePut.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareRequest(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpRequestBuilder = new HttpRequestBuilder();
        }
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object put$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.put.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object request(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object request$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            httpRequestBuilder = new HttpRequestBuilder();
        }
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareRequest(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object request$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object delete(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object delete$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object get(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object get$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object head(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object head$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object options(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object options$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object patch(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object patch$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object post(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object post$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareDelete(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareGet(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.prepareRequest.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object put$$forInline(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.request.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareRequest(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final HttpRequestBuilder request(InterfaceC5074l<? super HttpRequestBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        block.invoke(httpRequestBuilder);
        return httpRequestBuilder;
    }

    private static final Object request$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object request(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static final Object get(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object get$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareGet(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object delete(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object delete$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object head(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object head$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object options(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object options$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object patch(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object patch$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object post(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object post$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareRequest(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.prepareRequest.7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object put$$forInline(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersKt.request.7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Y8.t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object request$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }
}
