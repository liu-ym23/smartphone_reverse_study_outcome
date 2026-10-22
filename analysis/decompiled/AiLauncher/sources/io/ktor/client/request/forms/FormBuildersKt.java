package io.ktor.client.request.forms;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.content.PartData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\n\u0010\u000b\u001aF\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\n\u0010\u000e\u001a8\u0010\u0012\u001a\u00020\t*\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0012\u0010\u0013\u001a@\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0012\u0010\u0014\u001a>\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0016\u0010\u000b\u001aF\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\u0016\u0010\u000e\u001a8\u0010\u0017\u001a\u00020\u0015*\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0006\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0017\u0010\u0013\u001a@\u0010\u0017\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0006\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086H¢\u0006\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/http/Parameters;", "formParameters", "", "encodeInQuery", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "block", "Lio/ktor/client/statement/HttpResponse;", "submitForm", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Parameters;ZLp9/l;Le9/c;)Ljava/lang/Object;", "", "url", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lio/ktor/http/Parameters;ZLp9/l;Le9/c;)Ljava/lang/Object;", "", "Lio/ktor/http/content/PartData;", "formData", "submitFormWithBinaryData", "(Lio/ktor/client/HttpClient;Ljava/util/List;Lp9/l;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/List;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareForm", "prepareFormWithBinaryData", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FormBuildersKt {
    public static final Object prepareForm(HttpClient httpClient, Parameters parameters, boolean z10, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z10, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        interfaceC5074l.invoke(httpRequestBuilder);
        t tVar = t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, Parameters parameters, boolean z10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, t>() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareForm.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t prepareForm$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        interfaceC5074l.invoke(httpRequestBuilder);
        t tVar = t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, List list, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, t>() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareFormWithBinaryData.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitForm(HttpClient httpClient, Parameters parameters, boolean z10, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object submitForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z10, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        interfaceC5074l.invoke(httpRequestBuilder);
        t tVar = t.f7040a;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, Parameters parameters, boolean z10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, t>() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitForm.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        n.c(1);
        return objExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t submitForm$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        p.i(httpRequestBuilder, "<this>");
        return t.f7040a;
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        interfaceC5074l.invoke(httpRequestBuilder);
        t tVar = t.f7040a;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient httpClient, List list, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, t>() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitFormWithBinaryData.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        n.c(1);
        return objExecute;
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        t tVar = t.f7040a;
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, String str, List list, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, t>() { // from class: io.ktor.client.request.forms.FormBuildersKt.prepareFormWithBinaryData.5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        t tVar = t.f7040a;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        n.c(1);
        return objExecute;
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient httpClient, String str, List list, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l<HttpRequestBuilder, t>() { // from class: io.ktor.client.request.forms.FormBuildersKt.submitFormWithBinaryData.5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    p.i(httpRequestBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return t.f7040a;
                }
            };
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
        httpRequestBuilder.setBody(new MultiPartFormDataContent(list, null, null, 6, null));
        httpRequestBuilder.setBodyType(null);
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        n.c(0);
        Object objExecute = httpStatement.execute(interfaceC4014c);
        n.c(1);
        return objExecute;
    }

    public static final Object prepareForm(HttpClient httpClient, String str, Parameters parameters, boolean z10, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpStatement> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitForm(HttpClient httpClient, String str, Parameters parameters, boolean z10, InterfaceC5074l<? super HttpRequestBuilder, t> interfaceC5074l, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z10) {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
            httpRequestBuilder.setBody(new FormDataContent(parameters));
            httpRequestBuilder.setBodyType(null);
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        interfaceC5074l.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(interfaceC4014c);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.forms.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return FormBuildersKt.prepareForm$lambda$6((HttpRequestBuilder) obj2);
                }
            };
        }
        return prepareForm(httpClient, str, parameters2, z11, interfaceC5074l, interfaceC4014c);
    }

    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            parameters = Parameters.INSTANCE.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.forms.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return FormBuildersKt.submitForm$lambda$1((HttpRequestBuilder) obj2);
                }
            };
        }
        return submitForm(httpClient, str, parameters2, z11, interfaceC5074l, interfaceC4014c);
    }
}
