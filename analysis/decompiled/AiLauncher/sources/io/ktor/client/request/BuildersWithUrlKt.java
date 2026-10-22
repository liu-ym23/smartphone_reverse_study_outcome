package io.ktor.client.request;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a2\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u000b\u0010\t\u001a2\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\f\u0010\t\u001a2\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\r\u0010\t\u001a2\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u000e\u0010\t\u001a2\u0010\u000f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u000f\u0010\t\u001a2\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0010\u0010\t\u001a2\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0011\u0010\t\u001a2\u0010\u0012\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0012\u0010\t\u001a2\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0013\u0010\t\u001a2\u0010\u0014\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0014\u0010\t\u001a2\u0010\u0015\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0015\u0010\t\u001a2\u0010\u0016\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0016\u0010\t\u001a2\u0010\u0017\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086H¢\u0006\u0004\b\u0017\u0010\t\u001a\u0019\u0010\u0002\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Url;", "url", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "block", "Lio/ktor/client/statement/HttpResponse;", "get", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareGet", "post", "preparePost", "put", "preparePut", "patch", "preparePatch", "options", "prepareOptions", "head", "prepareHead", ChatTracker.CLICK_DELETE, "prepareDelete", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/Url;)V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersWithUrlKt {
    public static final Object delete(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object delete$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.delete.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object get(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object get$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.get.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object head(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object head$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.head.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object options(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object options$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.options.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object patch(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object patch$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.patch.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object post(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object post$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.post.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final Object prepareDelete(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getDelete());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareDelete.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareGet(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareGet.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getHead());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareHead.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getOptions());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.prepareOptions.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPatch());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePatch.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePost.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.preparePut.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object put(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object put$$forInline(HttpClient httpClient, Url url, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        httpRequestBuilder.setMethod(companion.getPut());
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        httpRequestBuilder.setMethod(companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, Url url, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, Y8.t>() { // from class: io.ktor.client.request.BuildersWithUrlKt.put.2
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
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
        interfaceC5074l.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objExecute;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Url url) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(url, "url");
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), url);
    }
}
