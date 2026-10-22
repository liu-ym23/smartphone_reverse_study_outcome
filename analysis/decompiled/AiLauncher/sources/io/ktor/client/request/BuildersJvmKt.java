package io.ktor.client.request;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsJvmKt;
import java.net.URISyntaxException;
import java.net.URL;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\n\u0010\t\u001a2\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000b\u0010\t\u001a2\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\f\u0010\t\u001a2\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\r\u0010\t\u001a2\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000e\u0010\t\u001a2\u0010\u000f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000f\u0010\t\u001a2\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0010\u0010\t\u001a2\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0012\u0010\t\u001a2\u0010\u0013\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0013\u0010\t\u001a2\u0010\u0014\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0014\u0010\t\u001a2\u0010\u0015\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0015\u0010\t\u001a2\u0010\u0016\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0016\u0010\t\u001a2\u0010\u0017\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0017\u0010\t\u001a2\u0010\u0018\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0018\u0010\t\u001a2\u0010\u0019\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lio/ktor/client/HttpClient;", "Ljava/net/URL;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "block", "Lio/ktor/client/statement/HttpResponse;", "request", "(Lio/ktor/client/HttpClient;Ljava/net/URL;Lp9/l;Le9/c;)Ljava/lang/Object;", "get", "post", "put", "patch", "options", "head", ChatTracker.CLICK_DELETE, "Lio/ktor/client/statement/HttpStatement;", "prepareRequest", "prepareGet", "preparePost", "preparePut", "preparePatch", "prepareOptions", "prepareHead", "prepareDelete", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersJvmKt {
    public static final Object delete(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.delete$lambda$14((HttpRequestBuilder) obj2);
                }
            };
        }
        return delete(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t delete$lambda$14(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object get(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.get$lambda$2((HttpRequestBuilder) obj2);
                }
            };
        }
        return get(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t get$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object head(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.k
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.head$lambda$12((HttpRequestBuilder) obj2);
                }
            };
        }
        return head(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t head$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object options(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.options$lambda$10((HttpRequestBuilder) obj2);
                }
            };
        }
        return options(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t options$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object patch(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.patch$lambda$8((HttpRequestBuilder) obj2);
                }
            };
        }
        return patch(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t patch$lambda$8(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object post(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.post$lambda$4((HttpRequestBuilder) obj2);
                }
            };
        }
        return post(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t post$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object prepareDelete(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.prepareDelete$lambda$30((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareDelete(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t prepareDelete$lambda$30(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object prepareGet(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.prepareGet$lambda$18((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareGet(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t prepareGet$lambda$18(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object prepareHead(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.n
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.prepareHead$lambda$28((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareHead(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t prepareHead$lambda$28(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object prepareOptions(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.prepareOptions$lambda$26((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareOptions(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t prepareOptions$lambda$26(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object preparePatch(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.preparePatch$lambda$24((HttpRequestBuilder) obj2);
                }
            };
        }
        return preparePatch(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t preparePatch$lambda$24(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object preparePost(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.preparePost$lambda$20((HttpRequestBuilder) obj2);
                }
            };
        }
        return preparePost(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t preparePost$lambda$20(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object preparePut(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.preparePut$lambda$22((HttpRequestBuilder) obj2);
                }
            };
        }
        return preparePut(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t preparePut$lambda$22(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object prepareRequest(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.prepareRequest$lambda$16((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareRequest(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t prepareRequest$lambda$16(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object put(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.put$lambda$6((HttpRequestBuilder) obj2);
                }
            };
        }
        return put(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t put$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final Object request(HttpClient httpClient, URL url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) throws URISyntaxException {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, URL url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersJvmKt.request$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return request(httpClient, url, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t request$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }
}
